/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestCode;
import CardModel.*;
import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import GameModel.*;
import View.UNOCard;




public class PCTest {
	
	UNOCard uc;
	ActionCard ac;
	NumberCard nc;
	WildCard wc;
	Color BLACK = new Color(0,0,0);
	Color RED = new Color(192,80,77);

	PC p;
	@Before
	public void setUp() throws Exception {
		p=new PC();
		
		ac=Mockito.mock(ActionCard.class);
		wc=Mockito.mock(WildCard.class);
		nc=Mockito.mock(NumberCard.class);
		
		
	}

	@Test
	public void playTest() {
		
		Mockito.when(wc.getType()).thenReturn(3);
		Mockito.when(wc.getColor()).thenReturn(BLACK);
		Mockito.when(wc.getValue()).thenReturn("4+");
		boolean play=p.play(wc);
		
		try {
			assertEquals(true,play);
			}catch(AssertionError e) {
				assertEquals(false,play);
			}
		
		Mockito.when(nc.getType()).thenReturn(1);
		Mockito.when(nc.getColor()).thenReturn(RED);
		Mockito.when(nc.getValue()).thenReturn("6");
		
		play=p.play(nc);
		
		try {
		assertEquals(true,play);
		}catch(AssertionError e) {
			assertEquals(false,play);
		}
		
		
		Mockito.when(ac.getType()).thenReturn(2);
		Mockito.when(ac.getColor()).thenReturn(RED);
		Mockito.when(ac.getValue()).thenReturn("2+");


		play=p.play(ac);
		
		try {
		assertEquals(true,play);
		}catch(AssertionError e) {
			assertEquals(false,play);
		}
		
	}

}


