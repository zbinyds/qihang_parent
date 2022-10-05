package com.zbinyds.eduOrder.client;

import com.zbinyds.orderVo.CourseOrder;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author zbinyds
 * @time 2022/09/29 20:32
 *
 * 远程调用service-edu服务中的接口
 */

@FeignClient(value = "service-edu",fallback = EduClientHystrix.class)
public interface EduClient {

    @ApiOperation("通过课程id获取课程信息-order服务调用")
    @PostMapping("/eduService/courseFront/getCourseOrder/{courseId}")
    CourseOrder getCourseOrder(@PathVariable("courseId") String courseId);
}
