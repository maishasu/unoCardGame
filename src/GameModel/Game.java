package GameModel;

import java.awt.Color;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

import CardModel.*;
import Interfaces.GameConstants;
import View.UNOCard;

public class Game implements GameConstants {

 private ThePlayer[] players;
 private boolean isOver;
 private int GAMEMODE;
 
 private PC pc;
 private TheDealer dealer;
 private Stack<UNOCard> cardStack;
 
 
 public Game(int mode){
  
  GAMEMODE = mode;
  
  //Create players
  String name = (GAMEMODE==MANUAL) ? JOptionPane.showInputDialog("Player 1") : "PC"; 
  String name2 = JOptionPane.showInputDialog("Player 2");
  
  if(GAMEMODE==vsPC)
   pc = new PC();
  
  ThePlayer player1 = (GAMEMODE==vsPC) ? pc : new ThePlayer(name);
  ThePlayer player2 = new ThePlayer(name2);  
  player2.toggleTurn();    //Initially, player2's turn  
   
  players = new ThePlayer[]{player1, player2};   
  
  //Create Dealer
  dealer = new TheDealer();
  cardStack = dealer.shuffle();
  dealer.spreadOut(players);
  
  isOver = false;
 }

 public ThePlayer[] getPlayers() {
  return players;
 }

 public UNOCard getCard() {
  return dealer.getCard();
 }
 
 public void removePlayedCard(UNOCard playedCard) {

  for (ThePlayer p : players) {
   if (p.hasCard(playedCard)){
    p.removeCard(playedCard);
    
    if (p.getTotalCards() == 1 && !p.getSaidUNO()) {
     infoPanel.setError(p.getName() + " Forgot to say UNO");
     p.obtainCard(getCard());
     p.obtainCard(getCard());
    }else if(p.getTotalCards()>2){
     p.setSaidUNOFalse();
    }
   }   
  }
 }
 
 //give player a card
 public void drawCard(UNOCard topCard) {

  boolean canPlay = false;

  for (ThePlayer p : players) {
   if (p.isMyTurn()) {
    UNOCard newCard = getCard();
    p.obtainCard(newCard);
    canPlay = canPlay(topCard, newCard);
    break;
   }
  }

  if (!canPlay)
   switchTurn();
 }

 public void switchTurn() {
  for (ThePlayer p : players) {
   p.toggleTurn();
  }
  whoseTurn();
 }
 
 //Draw cards x times
 public void drawPlus(int times) {
  for (ThePlayer p : players) {
   if (!p.isMyTurn()) {
    for (int i = 1; i <= times; i++)
     p.obtainCard(getCard());
   }
  }
 }
 
 //response whose turn it is
 public void whoseTurn() {

  for (ThePlayer p : players) {
   if (p.isMyTurn()){
    infoPanel.updateText(p.getName() + "'s Turn");
    System.out.println(p.getName() + "'s Turn");
   }
  }
  infoPanel.setDetail(playedCardsSize(), remainingCards());
  infoPanel.repaint();
 }
 
 //return if the game is over
 public boolean isOver() {
  
  if(cardStack.isEmpty()){
   isOver= true;
   return isOver;
  }
  
  for (ThePlayer p : players) {
   if (!p.hasCards()) {
    isOver = true;
    break;
   }
  }
  
  return isOver;
 }

 public int remainingCards() {
  return cardStack.size();
 }

 public int[] playedCardsSize() {
  int[] nr = new int[2];
  int i = 0;
  for (ThePlayer p : players) {
   nr[i] = p.totalPlayedCards();
   i++;
  }
  return nr;
 }

 //Check if this card can be played
 private boolean canPlay(UNOCard topCard, UNOCard newCard) {

  // Color or value matches
  if (topCard.getColor().equals(newCard.getColor())
    || topCard.getValue().equals(newCard.getValue()))
   return true;
  // if chosen wild card color matches
  else if (topCard.getType() == WILD)
   return ((WildCard) topCard).getWildColor().equals(newCard.getColor());

  // suppose the new card is a wild card
  else if (newCard.getType() == WILD)
   return true;

  // else
  return false;
 }

 //Check whether the player said or forgot to say UNO
 public void checkUNO() {
  for (ThePlayer p : players) {
   if (p.isMyTurn()) {
    if (p.getTotalCards() == 1 && !p.getSaidUNO()) {
     infoPanel.setError(p.getName() + " Forgot to say UNO");
     p.obtainCard(getCard());
     p.obtainCard(getCard());
    }
   }
  }  
 }

 public void setSaidUNO() {
  for (ThePlayer p : players) {
   if (p.isMyTurn()) {
    if (p.getTotalCards() == 2) {
     p.saysUNO();
     infoPanel.setError(p.getName() + " said UNO");
    }
   }
  }
 }
 
 public boolean isPCsTurn(){
  if(pc.isMyTurn()){
   return true;
  }
  return false;
 }

 //if it's PC's turn, play it for pc
 public void playPC(UNOCard topCard) {  
  
  if (pc.isMyTurn()) {
   boolean done = pc.play(topCard);
   
   if(!done)
    drawCard(topCard);
  }
 }
}