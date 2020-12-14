/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CardModel;
import java.awt.Color;

import View.UNOCard;

public class NumberCard extends UNOCard {

 public NumberCard(){
 }
 
 public NumberCard(Color cardColor, String cardValue){
  super(cardColor, NUMBERS, cardValue);  
 }

}
