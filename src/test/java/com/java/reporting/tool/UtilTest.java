package com.java.reporting.tool;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UtilTest {
	
	@Mock
    private Instruction instruction;
	
	@Mock
    private Util util;
	
	@Test
	public void testInstruction1() {
		Util util1 = new Util();
		Instruction instruction1 = new Instruction();
		
		instruction1.setSettleDate("02 Aug 2018");
		instruction1.setCurrency("SGP");

	
		assertEquals("02 Aug 2018",util1.getSettlementDate(instruction1.getCurrency(), instruction1.getSettleDate()));
	}
	
	@Test
	public void testInstruction2() {
		Util util2 =  new Util();
		Instruction instruction2 = new Instruction();
		
		instruction2.setSettleDate("29 Jul 2018");
		instruction2.setCurrency("INR");
		
	
		assertNotEquals("29 Jul 2018",util2.getSettlementDate(instruction2.getCurrency(), instruction2.getSettleDate()));
	}
	
	@Test
	public void testInstruction3() {
		Util util3 =  new Util();
		Instruction instruction3 = new Instruction();
		
		instruction3.setSettleDate("23 Aug 2018");
		instruction3.setCurrency("AED");
		
	
		assertEquals("23 Aug 2018",util3.getSettlementDate(instruction3.getCurrency(), instruction3.getSettleDate()));
	}
	
	@Test
	public void testInstruction4() {
		Util util4 =  new Util();
		Instruction instruction4 = new Instruction();
		
		instruction4.setSettleDate("17 Aug 2018");
		instruction4.setCurrency("SAR");
		
	
		assertNotEquals("17 Aug 2018",util4.getSettlementDate(instruction4.getCurrency(), instruction4.getSettleDate()));
	}
	
	@Test
	public void testInstruction5() {
		Util util5 =  new Util();
		Instruction instruction5 = new Instruction();
		
		instruction5.setSettleDate("01 Sep 2018");
		instruction5.setCurrency("SAR");
		
	
		assertEquals("02 Sep 2018",util5.getSettlementDate(instruction5.getCurrency(), instruction5.getSettleDate()));
	}
	
	@Test
	public void testInstruction6() {
		Util util4 =  new Util();
		Instruction instruction4 = new Instruction();
		
		instruction4.setSettleDate("01 Sep 2018");
		instruction4.setCurrency("INR");
		
	
		assertEquals("03 Sep 2018",util4.getSettlementDate(instruction4.getCurrency(), instruction4.getSettleDate()));
	}
	
	
}
