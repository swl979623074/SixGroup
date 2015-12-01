package sixth.sixthgroup.dao;

import sixth.sixthgroup.model.Diary;

public interface DiaryMapper {
    int deleteByPrimaryKey(Integer diarId);

    int insert(Diary record);

    int insertSelective(Diary record);

    Diary selectByPrimaryKey(Integer diarId);

    int updateByPrimaryKeySelective(Diary record);

    int updateByPrimaryKey(Diary record);
}