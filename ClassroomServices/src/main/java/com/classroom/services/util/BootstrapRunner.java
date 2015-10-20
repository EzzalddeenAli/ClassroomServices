/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.classroom.services.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.classroom.services.domain.repositories.IBankTransactionRepository;
//import com.classroom.services.facade.interfaces.IBillService;


@Component
@Service
@Transactional
@Repository
public class BootstrapRunner {
    private final Logger log = LoggerFactory.getLogger(BootstrapRunner.class);

    /**
     * The main method.
     * 
     * @param args
     *            the args
     */
//    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext(
//                "META-INF/config.xml");
//        BootstrapRunner runner = context.getBean(BootstrapRunner.class);
//        runner.start(args);
//    }

    /**
     * Start.
     * 
     * @param args
     *            the args
     */
//    public void start(String args[]) {
//        try {
//            p2pReceiveMoneyService.processP2PTransactions();
//            billService.processBills();
//            transactionRepository.alignTransactionsWithAccounts();
//        } catch (Exception e) {
//            log.error(BankingConstants.ERROR_MSG, e);
//        }
//    }
//
//    @Autowired
//    private IP2PReceiveMoneyService p2pReceiveMoneyService;
//    @Autowired
//    private IBillService billService;
//    @Autowired
//    private IBankTransactionRepository transactionRepository;

}
