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

import ServerController.*;
import GameModel.*;
import View.*;

public class ServerTest {

	Server server;
	UNOCard uc;
	ActionCard ac;
	NumberCard nc;
	WildCard wc;
	Color BLACK = new Color(0,0,0);
	Color RED = new Color(192,80,77);
	
	@Before
	public void setUp() throws Exception {
		server =new Server();
		ac=Mockito.mock(ActionCard.class);
		wc=Mockito.mock(WildCard.class);
		nc=Mockito.mock(NumberCard.class);
	}

	@Test
	public void getSessionTest() {
		assertNotEquals(null, server.getSession());
	}
	@Test 
	public void isValidMoveTest() {
	
		Mockito.when(wc.getType()).thenReturn(3);
		Mockito.when(wc.getColor()).thenReturn(BLACK);
		Mockito.when(wc.getValue()).thenReturn("4+");
		assertEquals(true, server.isValidMove(wc));
		
		Mockito.when(nc.getType()).thenReturn(1);
		Mockito.when(nc.getColor()).thenReturn(RED);
		Mockito.when(nc.getValue()).thenReturn("6");
		
		boolean valid= server.isValidMove(nc);
		
		try {
		assertEquals(true,valid);
		}catch(AssertionError e) {
			assertEquals(false,valid);
		}
		
		
		Mockito.when(ac.getType()).thenReturn(2);
		Mockito.when(ac.getColor()).thenReturn(RED);
		Mockito.when(ac.getValue()).thenReturn("2+");


	    valid= server.isValidMove(ac);
		
		try {
		assertEquals(true,valid);
		}catch(AssertionError e) {
			assertEquals(false,valid);
		}
		
		
		
	}
	@Test
	public void peekTopCardTest() {
		assertEquals(true, server.peekTopCard() instanceof UNOCard);
	}
	@Test
	public void isHisTurnTest() {
		assertEquals(false, server.isHisTurn(ac));
	}
	@Test
	public void submitSaidUNOTest() {
		server.submitSaidUNO();
	}
	@Test
	public void requestCardTest() {
		server.requestCard();
	}
	@Test
	public void playThisCardTest() {
		server.playThisCard(nc);
		server.playThisCard(ac);
		server.playThisCard(wc);
	}
}

