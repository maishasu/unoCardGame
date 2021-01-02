/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
  package TestCode;
import CardModel.ActionCard;
import CardModel.NumberCard;
import CardModel.WildCard;
import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.*;
import java.util.regex.Pattern;

import GameModel.*;
import View.*;

public class GameTest {

	Game game;
	
	UNOCard uc;
	ActionCard ac;
	NumberCard nc;
	WildCard wc;
	
	Color RED = new Color(192,80,77);
	Color BLUE = new Color(31,73,125);
	Color GREEN = new Color(0,153,0);
	Color YELLOW = new Color(255,204,0);
	Color BLACK = new Color(0,0,0);
	
	
	@Before
	public void setUp() throws Exception {
		game=new Game(1);
		
		ac=Mockito.mock(ActionCard.class);
		wc=Mockito.mock(WildCard.class);
		nc=Mockito.mock(NumberCard.class);
	}

	@Test
	public void getPlayersTest() {
		ThePlayer[] p=game.getPlayers();
		assertEquals("PC",p[0].getName());
		assertEquals(true,Pattern.matches(".*", p[1].getName()));
	}
	@Test
	public void getCardTest() {
		UNOCard uc=game.getCard();
		int type=uc.getType();
		try {
			assertEquals(1,type);
		}catch(AssertionError e) {
			try{
				assertEquals(2,type);
			}catch(AssertionError ee) {
				assertEquals(3,type);
			}
		}
	}
	
	@Test
	public void isOverTest() {
		assertEquals(false, game.isOver());
		
	}
	
	@Test
	public void remainingCardsTest() {
		assertEquals(92, game.remainingCards());
	}
	@Test
	public void isPCsTurnTest() {
		assertEquals(false,game.isPCsTurn());
}
	@Test
	public void playedCardSizeTest() {
		int[] nr=game.playedCardsSize();
		int[] m= {0,0};
		assertArrayEquals(m, nr);
	}
	
	
		
	@Test
	public void drawCardTest() {
		Mockito.when(ac.getColor()).thenReturn(YELLOW);
		Mockito.when(ac.getValue()).thenReturn((((char) 8634)+""));
		Mockito.when(ac.getType()).thenReturn(2);
		
		Mockito.when(wc.getColor()).thenReturn(BLACK);
		Mockito.when(wc.getValue()).thenReturn("4+");
		Mockito.when(wc.getType()).thenReturn(3);
		Mockito.when(wc.getWildColor()).thenReturn(RED);
		
		Mockito.when(nc.getColor()).thenReturn(YELLOW);
		Mockito.when(nc.getValue()).thenReturn("5");
		Mockito.when(nc.getType()).thenReturn(1);
		
		game.drawCard(ac);
		game.drawCard(wc);
		game.drawCard(nc);
	
	}
	
	@Test
	public void removePlayedCardTest() {
		game.removePlayedCard(ac);
		game.removePlayedCard(nc);
		game.removePlayedCard(wc);
	}
	
	@Test
	public void playPCTest() {
		game.playPC(ac);
		game.playPC(nc);
		game.playPC(wc);
	}
	@Test
	public void switchTurnTest() {
		game.switchTurn();
	}
	@Test
	public void drawPlusTest() {
		game.drawPlus(2);
	}
	@Test
	public void whoseTurnTest() {
		game.whoseTurn();
	}
	@Test
	public void checkUNOTest() {
		game.checkUNO();
		
	}
	@Test
	public void setSaidUNOTest() {
		game.setSaidUNO();
		
	}

}

