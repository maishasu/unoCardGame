/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestCode;

import GameModel.TheDealer;
import GameModel.ThePlayer;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import View.UNOCard;

import org.mockito.BDDMockito.Then;
import org.mockito.Mockito;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Stack;

public class DealerTest {
	TheDealer d;
	

	@Before
	public void setUp() throws Exception {
	
		d=new TheDealer();

	}

	@Test
	public void suffleTest() {
		
		assertEquals(108,d.shuffle().size());
	}
	
	@Test
	public void spreadOutTest() {
		UNOCard c=Mockito.mock(UNOCard.class);
		ThePlayer p1=Mockito.mock(ThePlayer.class);
		ThePlayer p2=Mockito.mock(ThePlayer.class);
		Mockito.doNothing().when(p1).obtainCard(c);
		Mockito.doNothing().when(p1).obtainCard(c);
		ThePlayer[] p= {p1,p2};
		d.shuffle();
		d.spreadOut(p);
	}
	
	@Test
	public void getCardTest() {
	
		d.shuffle();
		UNOCard c=d.getCard();
		
		assertNotNull(c);
	}
	

}
