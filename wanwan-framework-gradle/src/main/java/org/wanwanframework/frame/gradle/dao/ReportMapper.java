package org.wanwanframework.frame.gradle.dao;

import org.springframework.stereotype.Component;
import org.wanwanframework.frame.gradle.vo.UpdateEcCustIdVo;

@Component
public interface ReportMapper {
	
    String updateMonthReportEcCustId(UpdateEcCustIdVo vo);
}
