package com.mygdx.game;

public class WeaponMode {

    int rankMath;
    int speedShoot;
 //   int bahAgressor;
 //   int nobahAgressor;
    String rank;

    public int getSpeedShoot(){
        setspeedShoot();
        return this.speedShoot;
    }

    public String getRank(){
        setrank();
        return this.rank;
    }


    //Подсчет звания
    public String setrank(){

    //rankMath = bahAgressor - nobahAgressor;
        if (rankMath < 5) {
           rank = "Soldier";
        }
        if (rankMath >= 5 && rankMath < 10) {

            rank = "Sergeant";
        }
        if (rankMath >= 10 && rankMath < 20) {

            rank = "Lieutenant";
        }
        if (rankMath >= 20 && rankMath < 30) {

            rank = "Captain";
        }
        if (rankMath >= 30 && rankMath < 40) {

            rank = "Col.";
        }
        if (rankMath >= 40 && rankMath < 50) {

            rank = "General";
        }
        if (rankMath >= 50) {

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

