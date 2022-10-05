package com.zbinyds.eduOrder.client;

import com.zbinyds.R;
import com.zbinyds.orderVo.CourseOrder;
import org.springframework.stereotype.Component;

/**
 * @author zbinyds
 * @time 2022/09/29 20:34
 */

@Component
public class EduClientHystrix implements EduClient {
    @Override
    public CourseOrder getCourseOrder(String courseId) {
        return null;
    }
}
