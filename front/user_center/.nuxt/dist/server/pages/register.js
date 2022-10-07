exports.ids = [10];
exports.modules = {

/***/ 73:
/***/ (function(module, exports, __webpack_require__) {

// style-loader: Adds some css to the DOM by adding a <style> tag

// load the styles
var content = __webpack_require__(74);
if(content.__esModule) content = content.default;
if(typeof content === 'string') content = [[module.i, content, '']];
if(content.locals) module.exports = content.locals;
__webpack_require__(2).default("34d6e5d0", content, true)

/***/ }),

/***/ 74:
/***/ (function(module, exports, __webpack_require__) {

// Imports
var ___CSS_LOADER_API_IMPORT___ = __webpack_require__(1);
var ___CSS_LOADER_EXPORT___ = ___CSS_LOADER_API_IMPORT___(false);
// Module
___CSS_LOADER_EXPORT___.push([module.i, "body{\r\n    background-color: #F1F1F1;\r\n}\r\n\r\n*, :after, :before {\r\n    box-sizing: border-box;\r\n}\r\n\r\n/*选择器*/\r\n.sign-up-msg{\r\n    text-align: center;\r\n    font-size: 12px;\r\n    line-height: 20px;\r\n    color: #969696;\r\n}\r\n\r\n/*标签选择器*/\r\na{\r\n    text-decoration: none;\r\n}\r\n\r\n/*后代选择器*/\r\n.sign-up-msg a{\r\n    color: #3194d0;\r\n}\r\n\r\n.sign-up-msg a:hover{\r\n    text-decoration: underline;\r\n}\r\n\r\n.sign {\r\n    height: 100%;\r\n    min-height: 750px;\r\n    text-align: center;\r\n    font-size: 14px;\r\n    background-color: #f1f1f1;\r\n}\r\n\r\n/*表单样式*/\r\n.sign .main{\r\n    background-color: #FFFFFF;\r\n    width: 400px;\r\n    padding: 50px;\r\n    margin: 60px auto 0 auto;\r\n    box-shadow: 0 0 8px rgba(0,0,0,0.1);\r\n    border-radius: 5px;\r\n}\r\n\r\n.sign .logo{\r\n    position: absolute;\r\n    top: 56px;\r\n    left: 50px;\r\n}\r\n\r\n\r\n/*登录注册文字*/\r\n.sign .title{\r\n    margin: 0 auto 50px;\r\n    padding: 10px;\r\n    text-align: center;\r\n}\r\n\r\n.sign .title a{\r\n    padding: 10px;\r\n    color: #969696;\r\n    font-size: 18px;\r\n}\r\n\r\n.sign .title a:hover{\r\n    border-bottom: 2px solid #3BB149;\r\n}\r\n\r\n.sign .title .active{\r\n    font-weight: 700;\r\n    color: #3BB149;\r\n    border-bottom: 2px solid #3BB149;\r\n}\r\n\r\n.sign .title span{\r\n    padding: 10px;\r\n    color: #969696;\r\n    font-weight: 700;\r\n}\r\n\r\n/*表单文本框\r\n.sign form .input input{\r\n    width: 100%;\r\n    height: 50px;\r\n    padding: 4px 12px 4px 35px;\r\n    border: 1px solid #c8c8c8;\r\n    background-color: #F8F8F8;\r\n    box-sizing: border-box;\r\n}*/\r\n\r\n.sign form .restyle {\r\n    margin-bottom: 0;\r\n}\r\n.sign form .input-prepend {\r\n    position: relative;\r\n    width: 100%;\r\n}\r\n.sign form .input-prepend input {\r\n    width: 100%;\r\n    height: 50px;\r\n    margin-bottom: 0;\r\n    padding: 4px 12px 4px 35px;\r\n    border: 1px solid #c8c8c8;\r\n    border-radius: 0 0 4px 4px;\r\n    background-color: hsla(0,0%,71%,.1);\r\n    vertical-align: middle;\r\n}\r\n.sign form .restyle input {\r\n    border-bottom: none;\r\n    border-radius: 4px 4px 0 0;\r\n}\r\n.sign form .no-radius input {\r\n    border-radius: 0;\r\n}\r\n.sign form .input-prepend i {\r\n    position: absolute;\r\n    top: 14px;\r\n    left: 10px;\r\n    font-size: 18px;\r\n    color: #969696;\r\n}\r\n.sign .sign-up-button{\r\n    margin-top: 20px;\r\n    width: 100%;\r\n    padding: 9px 18px;\r\n    font-size: 18px;\r\n    border: none;\r\n    border-radius: 25px;\r\n    color: #FFFFFF;\r\n    background-color: #42c02c;\r\n    cursor: pointer;\r\n}\r\n.sign .sign-up-button:hover{\r\n    background-color: #3db922;\r\n}\r\n\r\n.sign .sign-in-button{\r\n    margin-top: 20px;\r\n    width: 100%;\r\n    padding: 9px 18px;\r\n    font-size: 18px;\r\n    border: none;\r\n    border-radius: 25px;\r\n    color: #FFFFFF;\r\n    background-color: #3194d0;\r\n    cursor: pointer;\r\n}\r\n.sign .sign-in-button:hover{\r\n    background-color: #187cb7;\r\n}\r\n/* 新增 */\r\n.sign .back-home-button{\r\n    margin-top: 20px;\r\n    width: 100%;\r\n    padding: 9px 18px;\r\n    font-size: 18px;\r\n    border: none;\r\n    border-radius: 25px;\r\n    color: #FFFFFF;\r\n    background-color: #94cbee;\r\n    cursor: pointer;\r\n}\r\n.sign .back-home-button:hover{\r\n    background-color: #94cbee;\r\n}\r\n\r\n.sign .more-sign {\r\n    margin-top: 50px;\r\n}\r\n\r\n.sign .more-sign h6 {\r\n    position: relative;\r\n    margin: 0 0 10px;\r\n    font-size: 12px;\r\n    color: #b5b5b5;\r\n}\r\n\r\n.sign .more-sign h6:after, .sign .more-sign h6:before {\r\n    content: \"\";\r\n    border-top: 1px solid #b5b5b5;\r\n    display: block;\r\n    position: absolute;\r\n    width: 60px;\r\n    top: 5px;\r\n}\r\n.sign .more-sign h6:before {\r\n    left: 30px;\r\n}\r\n\r\n.sign .more-sign h6:after {\r\n    right: 30px;\r\n}\r\n.sign .more-sign h6:after, .sign .more-sign h6:before {\r\n    content: \"\";\r\n    border-top: 1px solid #b5b5b5;\r\n    display: block;\r\n    position: absolute;\r\n    width: 60px;\r\n    top: 5px;\r\n}\r\n\r\n.sign .more-sign ul {\r\n    margin-bottom: 10px;\r\n    list-style: none;\r\n\tpadding-left: 0;\r\n}\r\n\r\n.sign .more-sign ul li {\r\n    margin: 0 5px;\r\n    display: inline-block;\r\n}\r\n\r\n.sign .more-sign ul a {\r\n    width: 50px;\r\n    height: 50px;\r\n    line-height: 50px;\r\n    display: block;\r\n}\r\n.sign .more-sign .icon-weixin {\r\n    color: #00bb29;\r\n}\r\n.sign .more-sign .icon-qq {\r\n    color: #498ad5;\r\n}\r\n.sign .more-sign ul i {\r\n    font-size: 28px;\r\n}\r\n.ic-wechat:before {\r\n    content: \"\\E604\";\r\n}\r\n.ic-qq_connect:before {\r\n    content: \"\\E603\";\r\n}\r\n\r\n\r\n", ""]);
// Exports
module.exports = ___CSS_LOADER_EXPORT___;


/***/ }),

/***/ 75:
/***/ (function(module, exports, __webpack_require__) {

// style-loader: Adds some css to the DOM by adding a <style> tag

// load the styles
var content = __webpack_require__(76);
if(content.__esModule) content = content.default;
if(typeof content === 'string') content = [[module.i, content, '']];
if(content.locals) module.exports = content.locals;
__webpack_require__(2).default("7631f024", content, true)

/***/ }),

/***/ 76:
/***/ (function(module, exports, __webpack_require__) {

// Imports
var ___CSS_LOADER_API_IMPORT___ = __webpack_require__(1);
var ___CSS_LOADER_GET_URL_IMPORT___ = __webpack_require__(8);
var ___CSS_LOADER_URL_IMPORT_0___ = __webpack_require__(77);
var ___CSS_LOADER_URL_IMPORT_1___ = __webpack_require__(78);
var ___CSS_LOADER_URL_IMPORT_2___ = __webpack_require__(79);
var ___CSS_LOADER_URL_IMPORT_3___ = __webpack_require__(80);
var ___CSS_LOADER_EXPORT___ = ___CSS_LOADER_API_IMPORT___(false);
var ___CSS_LOADER_URL_REPLACEMENT_0___ = ___CSS_LOADER_GET_URL_IMPORT___(___CSS_LOADER_URL_IMPORT_0___);
var ___CSS_LOADER_URL_REPLACEMENT_1___ = ___CSS_LOADER_GET_URL_IMPORT___(___CSS_LOADER_URL_IMPORT_0___, { hash: "#iefix" });
var ___CSS_LOADER_URL_REPLACEMENT_2___ = ___CSS_LOADER_GET_URL_IMPORT___(___CSS_LOADER_URL_IMPORT_1___);
var ___CSS_LOADER_URL_REPLACEMENT_3___ = ___CSS_LOADER_GET_URL_IMPORT___(___CSS_LOADER_URL_IMPORT_2___);
var ___CSS_LOADER_URL_REPLACEMENT_4___ = ___CSS_LOADER_GET_URL_IMPORT___(___CSS_LOADER_URL_IMPORT_3___, { hash: "#iconfont" });
// Module
___CSS_LOADER_EXPORT___.push([module.i, "@font-face {font-family: \"iconfont\";\n  src: url(" + ___CSS_LOADER_URL_REPLACEMENT_0___ + "); /* IE9 */\n  src: url(" + ___CSS_LOADER_URL_REPLACEMENT_1___ + ") format('embedded-opentype'), \n  url('data:application/x-font-woff2;charset=utf-8;base64,d09GMgABAAAAAAUQAAsAAAAACdQAAATDAAEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHEIGVgCDQAqGWIVgATYCJAMYCw4ABCAFhG0HTxuFCCMRdnNwkpL9M8HE00eBQ7iUQugtV0jUF8GXW5Wj09JnIoj2+83ek29OE0vwIx1voqGYJyiBBLFRKiF5CRzlVdXBSuYBnLwOL8ANiArs3e/b1omXNCFhkdehn/WVv+DDCvY/h0ubtsHmt9oucw/qRXEcUEDj9sTW8wO+AwnI7wGe4cIEvk+gbooKtGm3fYxBTrgsEPeJVycYXBZ5DDlU9WXIvbl4A1I1vWA3ALzqfx9/oBUMJEVG+NB+3NY5i2fwLBSv+A9C8EqoKM+F20NkGAM58RTqeQTczIzh6p8UYR3ge4qqJH2iZ8afrs9C///nE0DRI09dU8yQK8r5x0tESdA0EbudLfgEmUnOJ5KEaY3RJEOtK5oEakNxQAJlief0QdSJaxBwY6lQSrSFrDd4+RkZOZmYzBEnwcxGIC4ujnR0nfKnaH4PHvg+fOgIWpsPJ42W3yxL8yJ8Xurr4797kbmZfwxRlF/zYsVC01Llss+cInYYMpO0zV+W9/W7TUVFqZnfBmbz6MEbD2R7j9VHzyrOnIDRh76XKWHmwYe2FCVeeUpu+bz46iH/PE1riybXj8aUUCVfeVvuAVgQ4Z15oIGK+65IFPRs2rL2Xpem79+yQxHM8HLr7a3oaeqr7OdHhXNLwtrt84uCPQs8CPmzkKxEMROaLsElCUxtVvm3bdcBY6eaTohUrMpCxWLzMkLz69HYxAMbtks0KXyasme/+ND8hG64QyU4k4XGU40bS6gGyUJw9jWH686yPWzCoyokobZl2JHhQkJpV1sa0AB2YwWvBienQht16ZQyc7ojSa4P0wpY4cqkWQxvgWK+0neR63mQx3fFH0r113yTwtM3u0uxamylG0sHoSo0nzuROBelKxRUYJvYl8TmK+LLxpsrkrvFCgjbbdSK1EK43jpdtMuzUY+q0he/vfm4QzVs4UOA/BrPWqD8U1twfpebz/v3i9Iqj9FnLnTR65ZaFgEkPSlCcJWSVUOLdTgLWcg/o5SLECFZArQsLAE4tsssL+oAdxI3u/Z7zRnLVB43HTCSapFp0Y4YZBtkb2RrzAD66S5wsgr/KjOD2LTugK8tb0/R9aBxTzRbWdm4PIKModOvl1L+F6H2ttlihEL1m6j9dAwsWy0Dv5VgEKevhC9nkKCV1jZgE7KwIkQxhLlCCQD+h7NYp56AbI4afg4PoMNN8UoRys7C01ia2DoOZzf5WmXOwccapxuF/xGQXnIqaX2k55w05UT+lQvWMn+Pl3sESrs7KpVQF2c41wJ9j8vSjVLXEqpGNiQVk5CpWkDm2DEUGpahVLUCdUvsH24YyAJc5DUsqgUIXeuQtL1DpusmMsc+gsKEt1DqBg519/gF9zOZyUXzsnYQAZrkTo3i0Uj28DLq36jmXjinXKf84XwTpzRKvPkSI1wZN/ilykIwZBwPVMDH0PdMk+MWKkR1CFMexybsQJHi4fBizQEhAI1IO9JQ2Mio84OX7/ffoDLrCS5m7EfwDxyvWZ6kIkkKZKkZU41ty3pvUckEgeGLDIcNSIEu6MUMI1P4WS1QgkidIzXJxTTNpNVE9euGpbwAABNhz3SBIRwRiER0iB6IZw93y0ezNeMp014zah7xyBDer+z04QAA') format('woff2'),\n  url(" + ___CSS_LOADER_URL_REPLACEMENT_2___ + ") format('woff'),\n  url(" + ___CSS_LOADER_URL_REPLACEMENT_3___ + ") format('truetype'), \n  url(" + ___CSS_LOADER_URL_REPLACEMENT_4___ + ") format('svg'); /* iOS 4.1- */\n}\n\n.iconfont {\n  font-family: \"iconfont\" !important;\n  font-size: 16px;\n  font-style: normal;\n  -webkit-font-smoothing: antialiased;\n  -moz-osx-font-smoothing: grayscale;\n}\n\n.icon-user:before {\n  content: \"\\e64d\";\n}\n\n.icon-weixin:before {\n  content: \"\\e65d\";\n}\n\n.icon-qq:before {\n  content: \"\\e63b\";\n}\n\n.icon-phone:before {\n  content: \"\\e600\";\n}\n\n.icon-password:before {\n  content: \"\\e601\";\n}\n\n", ""]);
// Exports
module.exports = ___CSS_LOADER_EXPORT___;


/***/ }),

/***/ 77:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__.p + "fonts/iconfont.0b8ca0e.eot";

/***/ }),

/***/ 78:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__.p + "fonts/iconfont.d947185.woff";

/***/ }),

/***/ 79:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__.p + "fonts/iconfont.d8f2760.ttf";

/***/ }),

/***/ 80:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__.p + "img/iconfont.1802644.svg";

/***/ }),

/***/ 95:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
// ESM COMPAT FLAG
__webpack_require__.r(__webpack_exports__);

// CONCATENATED MODULE: ./node_modules/babel-loader/lib??ref--2-0!./node_modules/vue-loader/lib/loaders/templateLoader.js??ref--6!./node_modules/vue-loader/lib??vue-loader-options!./pages/register.vue?vue&type=template&id=56b74046&
var render = function render() {
  var _vm = this,
      _c = _vm._self._c;

  return _c('div', {
    staticClass: "main"
  }, [_vm._ssrNode("<div class=\"title\"><a href=\"/login\">登录</a> <span>·</span> <a href=\"/register\" class=\"active\">注册</a></div> "), _vm._ssrNode("<div class=\"sign-up-container\">", "</div>", [_c('el-form', {
    ref: "userForm",
    attrs: {
      "model": _vm.params
    }
  }, [_c('el-form-item', {
    staticClass: "input-prepend restyle",
    attrs: {
      "rules": [{
        required: true,
        message: '请输入你的昵称',
        trigger: 'blur'
      }],
      "prop": "nickname"
    }
  }, [_c('div', [_c('el-input', {
    attrs: {
      "type": "text",
      "placeholder": "你的昵称"
    },
    model: {
      value: _vm.params.nickname,
      callback: function ($$v) {
        _vm.$set(_vm.params, "nickname", $$v);
      },
      expression: "params.nickname"
    }
  }), _vm._v(" "), _c('i', {
    staticClass: "iconfont icon-user"
  })], 1)]), _vm._v(" "), _c('el-form-item', {
    staticClass: "input-prepend restyle no-radius",
    attrs: {
      "rules": [{
        required: true,
        message: '请输入手机号码',
        trigger: 'blur'
      }, {
        validator: _vm.checkPhone,
        trigger: 'blur'
      }],
      "prop": "mobile"
    }
  }, [_c('div', [_c('el-input', {
    attrs: {
      "type": "text",
      "placeholder": "手机号"
    },
    model: {
      value: _vm.params.mobile,
      callback: function ($$v) {
        _vm.$set(_vm.params, "mobile", $$v);
      },
      expression: "params.mobile"
    }
  }), _vm._v(" "), _c('i', {
    staticClass: "iconfont icon-phone"
  })], 1)]), _vm._v(" "), _c('el-form-item', {
    staticClass: "input-prepend restyle no-radius",
    attrs: {
      "rules": [{
        required: true,
        message: '请输入验证码',
        trigger: 'blur'
      }],
      "prop": "code"
    }
  }, [_c('div', {
    staticStyle: {
      "width": "100%",
      "display": "block",
      "float": "left",
      "position": "relative"
    }
  }, [_c('el-input', {
    attrs: {
      "type": "text",
      "placeholder": "验证码"
    },
    model: {
      value: _vm.params.code,
      callback: function ($$v) {
        _vm.$set(_vm.params, "code", $$v);
      },
      expression: "params.code"
    }
  }), _vm._v(" "), _c('i', {
    staticClass: "iconfont icon-phone"
  })], 1), _vm._v(" "), _c('div', {
    staticClass: "btn",
    staticStyle: {
      "position": "absolute",
      "right": "0",
      "top": "6px",
      "width": "40%"
    }
  }, [_c('a', {
    staticStyle: {
      "border": "none",
      "background-color": "none"
    },
    attrs: {
      "value": _vm.codeTest,
      "href": "javascript:",
      "type": "button"
    },
    on: {
      "click": function ($event) {
        return _vm.sendCode();
      }
    }
  }, [_vm._v(_vm._s(_vm.codeTest))])])]), _vm._v(" "), _c('el-form-item', {
    staticClass: "input-prepend",
    attrs: {
      "rules": [{
        required: true,
        message: '请输入密码',
        trigger: 'blur'
      }, {
        validator: _vm.checkPass,
        trigger: 'blur'
      }],
      "prop": "password"
    }
  }, [_c('div', [_c('el-input', {
    attrs: {
      "type": "password",
      "placeholder": "设置密码"
    },
    model: {
      value: _vm.params.password,
      callback: function ($$v) {
        _vm.$set(_vm.params, "password", $$v);
      },
      expression: "params.password"
    }
  }), _vm._v(" "), _c('i', {
    staticClass: "iconfont icon-password"
  })], 1)]), _vm._v(" "), _c('div', {
    staticClass: "btn"
  }, [_c('input', {
    staticClass: "sign-up-button",
    attrs: {
      "type": "button",
      "value": "注册"
    },
    on: {
      "click": function ($event) {
        return _vm.submitRegister();
      }
    }
  })]), _vm._v(" "), _c('p', {
    staticClass: "sign-up-msg"
  }, [_vm._v("\n        点击 “注册” 即表示您同意并愿意遵守简书\n        "), _c('br'), _vm._v(" "), _c('a', {
    attrs: {
      "target": "_blank",
      "href": "http://www.jianshu.com/p/c44d171298ce"
    }
  }, [_vm._v("用户协议")]), _vm._v("\n        和\n        "), _c('a', {
    attrs: {
      "target": "_blank",
      "href": "http://www.jianshu.com/p/2ov8x3"
    }
  }, [_vm._v("隐私政策")]), _vm._v("\n        。\n      ")])], 1), _vm._ssrNode(" <div class=\"more-sign\"><h6>社交帐号直接注册</h6> <ul><li><a id=\"weixin\" target=\"_blank\" href=\"http://huaan.free.idcfengye.com/api/ucenter/wx/login\" class=\"weixin\"><i class=\"iconfont icon-weixin\"></i></a></li> <li><a id=\"qq\" target=\"_blank\" href=\"#\" class=\"qq\"><i class=\"iconfont icon-qq\"></i></a></li></ul></div>")], 2)], 2);
};

var staticRenderFns = [];

// CONCATENATED MODULE: ./pages/register.vue?vue&type=template&id=56b74046&

// EXTERNAL MODULE: ./assets/css/sign.css
var sign = __webpack_require__(73);

// EXTERNAL MODULE: ./assets/css/iconfont.css
var iconfont = __webpack_require__(75);

// EXTERNAL MODULE: ./utils/request.js
var request = __webpack_require__(7);

// CONCATENATED MODULE: ./api/register.js

/* harmony default export */ var register = ({
  // 根据手机号发送验证码
  sendCode(phone) {
    return Object(request["a" /* default */])({
      url: `/edusms/sms/send/${phone}`,
      method: 'post'
    });
  },

  // 用户注册
  register(registerVo) {
    return Object(request["a" /* default */])({
      url: `/ucenter/member/register`,
      method: 'post',
      data: registerVo
    });
  }

});
// CONCATENATED MODULE: ./node_modules/babel-loader/lib??ref--2-0!./node_modules/vue-loader/lib??vue-loader-options!./pages/register.vue?vue&type=script&lang=js&



/* harmony default export */ var registervue_type_script_lang_js_ = ({
  layout: 'sign',

  data() {
    return {
      // 接收表单注册数据
      params: {
        mobile: '',
        // 手机号
        code: '',
        // 验证码
        nickname: '',
        // 用户昵称
        password: '' // 密码

      },
      sending: true,
      // 是否发送验证码
      second: 60,
      // 倒计时
      codeTest: '获取验证码'
    };
  },

  methods: {
    // 验证码倒计时
    timeDown() {
      const result = setInterval(() => {
        --this.second;
        this.codeTest = this.second;

        if (this.second < 1) {
          clearInterval(result);
          this.sending = true; // this.disabled = false;

          this.second = 60;
          this.codeTest = '获取验证码';
        }
      }, 1000);
    },

    // 发送验证码
    sendCode() {
      register.sendCode(this.params.mobile).then(res => {
        this.sending = false; // 获取验证码按钮禁用

        this.timeDown(); // 点击发送验证码，倒计时开始。
      });
    },

    // 注册
    submitRegister() {
      register.register(this.params).then(res => {
        if (res.data.code === '20000') {
          // 成功提示信息
          this.$message.success(res.data.message); // 跳转到登录页面

          this.$router.push({
            path: '/login'
          });
        } else {
          // 失败提示信息
          this.$message.error(res.data.message);
        }
      });
    },

    // 手机号码格式校验. value:输入框的值; rule:输入框规则; callback:回调方法
    checkPhone(rule, value, callback) {
      // debugger
      if (!/^1[34578]\d{9}$/.test(value)) {
        return callback(new Error('手机号码格式不正确'));
      }

      return callback();
    },

    // 密码格式校验(必须为6位+数字+字母)
    checkPass(rule, value, callback) {
      if (!/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$/.test(value)) {
        return callback(new Error('密码格式为6-12位+数字/字母组合'));
      }

      return callback();
    }

  }
});
// CONCATENATED MODULE: ./pages/register.vue?vue&type=script&lang=js&
 /* harmony default export */ var pages_registervue_type_script_lang_js_ = (registervue_type_script_lang_js_); 
// EXTERNAL MODULE: ./node_modules/vue-loader/lib/runtime/componentNormalizer.js
var componentNormalizer = __webpack_require__(4);

// CONCATENATED MODULE: ./pages/register.vue





/* normalize component */

var component = Object(componentNormalizer["a" /* default */])(
  pages_registervue_type_script_lang_js_,
  render,
  staticRenderFns,
  false,
  null,
  null,
  "00805447"
  
)

/* harmony default export */ var pages_register = __webpack_exports__["default"] = (component.exports);

/***/ })

};;
//# sourceMappingURL=register.js.map