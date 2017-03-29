package org.wanwanframework.frame.gradle.dao;

import org.springframework.stereotype.Component;
import org.wanwanframework.frame.gradle.vo.AccountVo;

@Component
public interface ReportDao {
	
    String updateMonthReportEcCustId(AccountVo vo);
}
