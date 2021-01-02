/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestCode;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import CardModel.*;

public class WildCardTest {

	WildCard c;
	Color RED=new Color(192,80,77);
	Color YELLOW = new Color(255,204,0);
	

	@Before
	public void setUp() throws Exception {
		c=new WildCard();
	}

	@Test
	public void getWildColorTest() {
		assertEquals(null, c.getWildColor());
		c.useWildColor(RED);
		assertEquals(RED, c.getWildColor());
		assertNotEquals(YELLOW, c.getWildColor());
	
		
	}
}

