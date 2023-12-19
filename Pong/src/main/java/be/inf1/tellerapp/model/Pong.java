/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.inf1.tellerapp.model;

//is kijken of die nest hier werkt
/**
 *
 * @author LenovoTest
 */

public class Pong {

public double xCoordinaatBal;
public double yCoordinaatBal;
public double xCoordinaat2;
public double xmovement;
public double ymovement;

private Botsingen botsing;
private Botsingen plaatsVanBotsing;

public Pong() {
    this.xmovement = Math.random()*5+3;
    this.ymovement = Math.random()*3+2;
}

public void checkBotsing(double x1,double y1,double x2,double y2) {
    if (Math.abs(x2 - x1) < 50 && y1-y2 < 111 && y1-y2 > -5) {
    this.xmovement = -xmovement;
}
}
public void restart() {
    this.xmovement = Math.random()*5+3;
    this.ymovement = Math.random()*3+2;
}
public void checkCoordinaat(double x1,double y1) {
    if (x1 <= 0) {
        this.xmovement = 0;
        this.ymovement = 0;
        System.out.println("ben je dom ofzo");
    }
    if (x1 >= 500) {
        this.xmovement = -xmovement;
    }
    if (y1 <= 100) {
        this.ymovement = -ymovement;
    }
    if (y1 >= 400) {
        this.ymovement = -ymovement;
    }
    else {
        this.xmovement = xmovement;
        this.ymovement = ymovement;
    }
}
public void richtingNaBotsing() {
    
    this.xmovement = -xmovement;
    this.ymovement = ymovement;   
}
public void bovenRand() {
    this.xmovement = xmovement;
    this.ymovement = -ymovement;
}
public double getXmovement() {
    return this.xmovement;
}
public double getYmovement() {
    return this.ymovement;
}





}
