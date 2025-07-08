package com.imdayoung.teongjangdiary.asset.mapper;

import com.imdayoung.teongjangdiary.asset.dto.AssetVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AssetMapper {

    List<AssetVO> selectAssetList(AssetVO txnVO);
}
