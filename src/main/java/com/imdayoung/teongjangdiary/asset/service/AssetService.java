package com.imdayoung.teongjangdiary.asset.service;

import com.imdayoung.teongjangdiary.asset.dto.AssetGroupDTO;

import java.util.List;

public interface AssetService {

    List<AssetGroupDTO> selectAssetList(String userId);
}
