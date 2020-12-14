/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CardModel;
import java.awt.Color;

import View.UNOCard;

public class ActionCard extends UNOCard{
 
 private int Function = 0;
 
 //Constructor
 public ActionCard(){
 }
 
 public ActionCard(Color cardColor, String cardValue){
  super(cardColor,ACTION, cardValue);  
 } 
}
