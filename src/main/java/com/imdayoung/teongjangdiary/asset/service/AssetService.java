package com.imdayoung.teongjangdiary.asset.service;

import com.imdayoung.teongjangdiary.asset.dto.AssetVO;

import java.util.List;

public interface AssetService {

    List<AssetVO> selectAssetList(AssetVO vo);
}
