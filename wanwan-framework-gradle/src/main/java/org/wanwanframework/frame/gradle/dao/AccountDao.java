package org.wanwanframework.frame.gradle.dao;

import org.springframework.stereotype.Component;
import org.wanwanframework.frame.gradle.vo.AccountVo;

/**
 * ��������
 * 
 * @author coco
 *
 */
@Component
public interface AccountDao {
	String call(AccountVo vo);
}
