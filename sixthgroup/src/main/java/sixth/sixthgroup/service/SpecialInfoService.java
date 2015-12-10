package sixth.sixthgroup.service;

import java.util.List;

import sixth.sixthgroup.model.SpecialInfo;

public interface SpecialInfoService {
	 public List<SpecialInfo> selectByInfoType(Integer spinClassno);
	 
	 public int insertOneInfo(SpecialInfo record);
}
