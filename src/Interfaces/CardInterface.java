package Interfaces;
import java.awt.*;

public interface CardInterface{
 
 int WIDTH = 30;
 int HEIGHT = 60;
 Dimension SMALL = new Dimension(WIDTH,HEIGHT);
 Dimension MEDIUM = new Dimension(WIDTH*2,HEIGHT*2);
 Dimension BIG = new Dimension(WIDTH*3,HEIGHT*3); 
 
 //Default card size
 Dimension CARDSIZE = MEDIUM;
 
 //Default offset
 int OFFSET = 71;
 
 void setColor(Color newColor);
 Color getColor();
 
 void setValue(String newValue);
 String getValue();
 
 void setType(int newType);
 int getType();
}