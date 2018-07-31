package com.java.reporting.tool;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Test;
import org.mockito.Mock;

public class InstructionTest {
	
	@Mock
    private Instruction instruction;
	
	@Test
	public void initializeValuesConstructor() {
		BigDecimal fx = new BigDecimal(0.22);
		BigDecimal ppu = new BigDecimal(145);
		
		Instruction instruction = new Instruction ("bar", "S" , fx, "INR", "31 Jul 2018", "01 Aug 2018", 100, ppu );
		assertEquals(new BigDecimal(0.22), instruction.getAgreedFx());
		assertNotNull(ppu);
		assertEquals("31 Jul 2018",instruction.getInstDate());
		assertNotEquals("AED",instruction.getCurrency());
		assertEquals("01 Aug 2018",instruction.getSettleDate());
		assertNotEquals("B",instruction.getBuysell());
		assertEquals("bar",instruction.getEntity());
		
	}
	
	@Test
	public void initializeValuesManually() {
		BigDecimal fx = new BigDecimal(0.13);
		BigDecimal ppu = new BigDecimal(127.9);
		
		Instruction instruction = new Instruction();
		instruction.setAgreedFx(fx);
		instruction.setPpu(ppu);
		instruction.setBuysell("B");
		instruction.setCurrency("AED");
		instruction.setEntity("foo");
		instruction.setInstDate("31 Jul 2018");
		instruction.setSettleDate("01 Aug 2018");
		
		assertEquals(new BigDecimal(0.13), instruction.getAgreedFx());
		assertNotNull(ppu);
		assertEquals("31 Jul 2018",instruction.getInstDate());
		assertEquals("AED",instruction.getCurrency());
		assertEquals("01 Aug 2018",instruction.getSettleDate());
		assertEquals("B",instruction.getBuysell());
		assertEquals("foo",instruction.getEntity());
		
		
	}

}
