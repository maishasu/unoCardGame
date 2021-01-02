/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestCode;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import CardModel.CardDeck;

public class CardDeckTest {

	CardDeck c;

	@Before
	public void setUp() throws Exception {
		c=new CardDeck();
	}

	@Test
	public void getCardTest() {
		assertEquals(108, c.getCards().size());
	}

}
