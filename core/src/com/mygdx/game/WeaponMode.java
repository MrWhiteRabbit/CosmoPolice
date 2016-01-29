package com.mygdx.game;

/**
 * Created by Toshiba on 29.01.2016.
 */
public class WeaponMode {

    int rankMath;
    int speedShoot;
    String rank;

    public int getSpeedShoot(){
        return this.speedShoot;
    }
    public String getRank(){ return this.rank; }

    //Подсчет звания
    public String setrank(){
        if (rankMath < 5) {
            speedShoot = 100;
            rank = "Soldier";
        }
        if (rankMath >= 5 && rankMath < 10) {
            speedShoot = 200;
            rank = "Sergeant";
        }
        if (rankMath >= 10 && rankMath < 20) {
            speedShoot = 300;
            rank = "Lieutenant";
        }
        if (rankMath >= 20 && rankMath < 30) {
            speedShoot = 400;
            rank = "Captain";
        }
        if (rankMath >= 30 && rankMath < 40) {
            speedShoot = 500;
            rank = "Col.";
        }
        if (rankMath >= 40 && rankMath < 50) {
            speedShoot = 600;
            rank = "General";
        }
        if (rankMath >= 50) {
            speedShoot = 700;
            rank = "Admiral";
        }
        return rank;
    }

    //Посдчет скорости полета снаряда
    public int setspeedShoot() {

        if (rankMath < 5) {
            speedShoot = 100;

        }
        if (rankMath >= 5 && rankMath < 10) {
            speedShoot = 200;

        }
        if (rankMath >= 10 && rankMath < 20) {
            speedShoot = 300;

        }
        if (rankMath >= 20 && rankMath < 30) {
            speedShoot = 400;

        }
        if (rankMath >= 30 && rankMath < 40) {
            speedShoot = 500;

        }
        if (rankMath >= 40 && rankMath < 50) {
            speedShoot = 600;

        }
        if (rankMath >= 50) {
            speedShoot = 700;

        }
        return speedShoot;
    }

/*
        rankMath = bahAgressor - nobahAgressor;
        if (rankMath < 5) {
            speedShoot = 100;
            rank = "Soldier";
        }
        if (rankMath >= 5 && rankMath < 10) {
            speedShoot = 200;
            rank = "Sergeant";
        }
        if (rankMath >= 10 && rankMath < 20) {
            speedShoot = 300;
            rank = "Lieutenant";
        }
        if (rankMath >= 20 && rankMath < 30) {
            speedShoot = 400;
            rank = "Captain";
        }
        if (rankMath >= 30 && rankMath < 40) {
            speedShoot = 500;
            rank = "Col.";
        }
        if (rankMath >= 40 && rankMath < 50) {
            speedShoot = 600;
            rank = "General";
        }
        if (rankMath >= 50) {
            speedShoot = 700;
            rank = "Admiral";
        }*/
}


    /*private void Gun() {
    }*/

