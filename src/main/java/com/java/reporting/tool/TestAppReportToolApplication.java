package com.java.reporting.tool;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class TestAppReportToolApplication {

	public static ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

	public static void main(String[] args) {
		SpringApplication.run(TestAppReportToolApplication.class, args);

		Util utilities = new Util();
		Map<String, Instruction> instBeans = (Map<String, Instruction>) context.getBeansOfType(Instruction.class);
		BigDecimal inAmount = new BigDecimal(0);
		BigDecimal outAmount = new BigDecimal(0);
		Map<String, BigDecimal> inMap = new HashMap<String, BigDecimal>();
		Map<String, BigDecimal> outMap = new HashMap<String, BigDecimal>();

		for (String instruction : instBeans.keySet()) {

			/* 1) get and set proper working day */

			String oldSettlementDate = instBeans.get(instruction).getSettleDate();
			String newSettlementDate = utilities.getSettlementDate(instBeans.get(instruction).getCurrency(),
					oldSettlementDate);
			if (!newSettlementDate.equals(oldSettlementDate)) {
				instBeans.get(instruction).setSettleDate(newSettlementDate);
			}

			/* 2) calculate USD = Price per unit * Units * Agreed Fx */

			BigDecimal amount = (instBeans.get(instruction).getPpu().multiply(instBeans.get(instruction).getAgreedFx())
					.multiply(new BigDecimal(instBeans.get(instruction).getUnits())));

			/*
			 * 3) print amount in USD settled incoming everyday 4) print amount in USD
			 * settled outgoing everyday
			 */

			if (instBeans.get(instruction).getBuysell().equalsIgnoreCase("B")) {
				BigDecimal resultOut = outAmount.add(amount);
				outMap.put(instBeans.get(instruction).getEntity(), resultOut);
				System.out.println("Outgoing amount in USD on Settlement Date:"
						+ instBeans.get(instruction).getSettleDate() + " is " + resultOut);
			} else {
				BigDecimal resultIn = inAmount.add(amount);
				inMap.put(instBeans.get(instruction).getEntity(), resultIn);
				System.out.println("Incoming amount in USD on Settlement Date:"
						+ instBeans.get(instruction).getSettleDate() + " is " + resultIn);
			}

		}
		/*
		 * 5) Ranking of entities based on incoming and outgoing amount. eg: if entity
		 * foo instructs the highest amount for a buy instruction, then foo is rank 1
		 * for outgoing.
		 */

		System.out.println("***Printing Outgoing instructions in decreasing order***");
		utilities.printRanking(outMap);
		System.out.println("***Printing Incoming instructions in decreasing order***");
		utilities.printRanking(inMap);

	}

	

}
