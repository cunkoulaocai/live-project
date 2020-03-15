package maskAppointment.dao;

import maskAppointment.pojo.Mask;

/**
 * 
 * @author 221701120_hxy
 *
 * 访问口罩的抽象接口
 */

public interface MaskDAO {
	Mask getMask();
	boolean setMask(Mask mask);
	
}
