/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.facade.dto.assembler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.classroom.services.domain.model.Account;
import com.classroom.services.facade.dto.entities.AccountDTO;
import com.classroom.services.util.BankingConstants;
import com.classroom.services.util.BankingProcessorUtilities;

public class AccountAssembler {
    private static final Logger LOG = LoggerFactory
    .getLogger(AccountAssembler.class);
    
    private AccountAssembler() {
    }
    
    /**
     * Object domain2 dto.
     * 
     * @param obj
     *            the obj
     * @param dto
     *            the dto
     */
    public static void objectDomain2DTO(Account obj, AccountDTO dto) {
        dto.setAccountCategory(obj.getAccountCategory());
        dto.setAvailableBalance(obj.getAvailableBalance());
        dto.setAvailableCredit(obj.getAvailableCredit());
        dto.setCreditCardType(obj.getCreditCardType());
        dto.setCurrentBalance(obj.getCurrentBalance());
        dto.setDisplayTransactions(obj.getDisplayTransactions());
        dto.setDueDate(obj.getDueDate());
        try {
            dto.setId(BankingProcessorUtilities.encrypt(obj.getId()));
            dto.setMaskedNumber(BankingProcessorUtilities
                    .getMaskedAccountNumber(obj.getId(), "X",
                            BankingConstants.NO_MASK_ACCTNO_CHARS,
                            BankingConstants.NO_UNMASK_ACCTNO_CHARS));
        } catch (Exception e) {
            LOG.error(BankingConstants.ERROR_MSG, e);
        }
        dto.setInterestRate(obj.getInterestRate());
        dto.setMinimumDue(obj.getMinimumDue());
        dto.setNickName(obj.getNickName());
        dto.setStatus(obj.getStatus());
        dto.setSupportBillPay(obj.getSupportBillPay());
        dto.setSupportTransferFrom(obj.getSupportTransferFrom());
        dto.setSupportTransferTo(obj.getSupportTransferTo());
        dto.setType(obj.getType());
        dto.setUserId(obj.getUser().getCustomerId());
    }

}
