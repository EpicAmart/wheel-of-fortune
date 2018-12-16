/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author darsh
 */
public class Player implements Comparable {
    private String name;
    private int money;
    
    public Player(String name){
        this.name = name;
        money = 0;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getMoney(){
        return money;
    }
    
    public void setMoney(int value, int num){
        if(value > 0){
            money += value*num;
        }else if(value == 0){
            money = 0;
        }else if(value == -1){
            money -= 250;
        }
    }

    @Override
    public int compareTo(Object p) {
        Player other = (Player) p;
        return this.money - other.getMoney();
    }
    
}


