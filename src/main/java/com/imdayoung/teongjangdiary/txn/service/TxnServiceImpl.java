package com.imdayoung.teongjangdiary.txn.service;

import com.imdayoung.teongjangdiary.txn.dto.TotalSummaryVO;
import com.imdayoung.teongjangdiary.txn.dto.TxnListDTO;
import com.imdayoung.teongjangdiary.txn.dto.TxnVO;
import com.imdayoung.teongjangdiary.txn.mapper.TxnMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TxnServiceImpl implements TxnService {

    private final TxnMapper txnMapper;

    @Override
    public List<TxnListDTO> selectTxnList(TxnVO txnVO) {

        List<TxnVO> txnList = txnMapper.selectTxnList(txnVO);

        Map<Integer, TxnListDTO> dailyMap = new LinkedHashMap<>();

        for (TxnVO txn : txnList) {
            int month = Integer.parseInt(txn.getTxnDt().substring(5, 7));
            int date = Integer.parseInt(txn.getTxnDt().substring(8, 10));

            if (!dailyMap.containsKey(date)) {
                dailyMap.put(date, TxnListDTO.builder()
                                .month(month)
                                .date(date)
                                .weekday(txn.getWeekday())
                                .income(0)
                                .expense(0)
                                .transactions(new ArrayList<>())
                                .build());
            }

            TxnListDTO dayData = dailyMap.get(date);

            TxnVO txnItem = TxnVO.builder()
                    .categoryNm(txn.getCategoryNm())
                    .content(txn.getContent())
                    .assetNm(txn.getAssetNm())
                    .amount(txn.getAmount())
                    .txnTypeNm(txn.getTxnTypeNm())
                    .build();

            dayData.getTransactions().add(txnItem);

            if ("수입".equals(txn.getTxnTypeNm())) {
                dayData.setIncome(dayData.getIncome() + txn.getAmount());
            } else if ("지출".equals(txn.getTxnTypeNm())) {
                dayData.setExpense(dayData.getExpense() + txn.getAmount());
            }
        }

        return new ArrayList<>(dailyMap.values());
    }

    @Override
    public TotalSummaryVO selectTotalSummary(TxnVO txnVO) {
        return txnMapper.selectTotalSummary(txnVO);
    }
}
