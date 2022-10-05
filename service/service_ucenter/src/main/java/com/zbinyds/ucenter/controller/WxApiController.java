package com.zbinyds.ucenter.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.zbinyds.JwtUtils;
import com.zbinyds.servicebase.exceptionHandler.QiHangException;
import com.zbinyds.ucenter.pojo.Member;
import com.zbinyds.ucenter.service.MemberService;
import com.zbinyds.ucenter.utils.HttpClientUtils;
import com.zbinyds.ucenter.utils.WxPropertiesUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Objects;

/**
 * @author zbinyds
 * @time 2022/09/27 11:35
 * <p>
 * 微信登录Api-控制器
 * 官方文档：https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1419316505&token=&lang=zh_CN
 */

@Api(tags = "微信登录Api管理")
@Controller
@RequestMapping("/api/ucenter/wx")
//@CrossOrigin
@Slf4j
public class WxApiController {

    @Autowired
    private MemberService memberService;

    @ApiOperation("生成微信登录二维码")
    @GetMapping("/login")
    public String getWxCode() {
        // 生成微信二维码的固定写法
        String baseUrl = "https://open.weixin.qq.com/connect/qrconnect" +
                "?appid=%s" +
                "&redirect_uri=%s" +
                "&response_type=code" +
                "&scope=snsapi_login" +
                "&state=zbinyds" +
                "#wechat_redirect";
        String redirectUrl = WxPropertiesUtils.REDIRECT_URL;
        try {
            // 对url进行编码
            redirectUrl = URLEncoder.encode(redirectUrl, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new QiHangException("20001", "url编码异常");
        }
        String url = String.format(baseUrl, WxPropertiesUtils.APP_ID, redirectUrl);
        return "redirect:" + url;
    }

    /**
     * 扫码成功的回调函数-获取扫描二维码微信用户信息并将该用户注册（如果已注册则直接登录）
     *
     * @param code：扫描登录后返回的临时票据。
     * @param state：请求状态（可选），官方建议加上。
     * @return：携带token信息并跳转到首页面
     */
    @ApiOperation("获取微信用户信息并实现微信注册登录")
    @GetMapping("/callback")
    public String getUserInfo(@ApiParam("临时票据") String code, @ApiParam("请求状态") String state) {
        // 用户是否成功扫描二维码校验
        if (StringUtils.isEmpty(code)) throw new QiHangException("20001", "请重新扫描二维码！");

        // 获取扫描二维码的微信用户信息
        try {
            /**
             * 第一步：根据code响应码，请求官方提供的指定接口，得到access_token(接口调用凭证)。
             */
            // 拼接好指定接口的参数信息
            String AccessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token" +
                    "?appid=%s" +
                    "&secret=%s" +
                    "&code=%s" +
                    "&grant_type=authorization_code";
            AccessTokenUrl = String.format(
                    AccessTokenUrl,
                    WxPropertiesUtils.APP_ID,
                    WxPropertiesUtils.APP_SECRET,
                    code
            );
            // 发送请求，获取到accessTokenInfo，里面包含了我们需要的字段access_token和openid。
            String accessTokenInfo = HttpClientUtils.get(AccessTokenUrl); // 此时类型为String
            log.info("accessTokenInfo：" + accessTokenInfo);
            // 进行类型转换，从String转换成Map类型。
            Gson gson = new Gson();
            HashMap accessTokenMap = gson.fromJson(accessTokenInfo, HashMap.class);
            String accessToken = (String) accessTokenMap.get("access_token");
            String openId = (String) accessTokenMap.get("openid"); // 用户唯一标识

            // 查询该用户是否已注册
            Member member = memberService.getOpenIdMember(openId);
            // 未注册进行注册
            if (Objects.isNull(member)) {
                /**
                 * 第二步：根据access_token，请求官方提供的指定接口，得到微信登录用户的基本信息。
                 */
                // 拼接获取用户基本信息的url
                String userInfoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=" + accessToken + "&openid=" + openId;
                String userInfo = HttpClientUtils.get(userInfoUrl);
                log.info("当前登录微信用户的基本信息(用户昵称、头像)：" + userInfo);
                // 进行类型转换，从String转换成Map类型。
                HashMap userInfoMap = gson.fromJson(userInfo, HashMap.class);

                // 将微信登录用户进行注册
                String headImgUrl = (String) userInfoMap.get("headimgurl"); // 用户头像
                String nickName = (String) userInfoMap.get("nickname"); // 用户昵称
                member = new Member();
                member.setNickname(nickName);
                member.setAvatar(headImgUrl);
                member.setOpenid(openId);
                memberService.save(member);
            }
            // 根据member对象，生成token字符串。
            String token = JwtUtils.getJwtToken(member.getId(), member.getNickname());

            // 登录成功，携带token并跳转到首页面。
            return "redirect:http://localhost:3000?token=" + token;
        } catch (Exception e) {
            e.printStackTrace();
            throw new QiHangException("20001", "请求失败！");
        }
    }
}
