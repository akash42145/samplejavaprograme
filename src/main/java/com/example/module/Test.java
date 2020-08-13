package com.example.module;

class Player {
    String name;
    int age;
 
    Player(String name, int age) {
        this.name = name;
        this.age = age;
    }
 
    public String toString() {
        return name + ", " + age;
    }
 
   
    public boolean equals(Player player) {
        if(player != null && this.name.equals(player.name)
                && this.age == player.age) {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean equals(Object play) {
    	Player player = (Player) play;
        if(player != null && this.name.equals(player.name)
                && this.age == player.age) {
            return true;
        }
        return false;
    }
}
 
public class Test {
    public static void main(String[] args) {
        Object p1 = new Player("Sachin", 44);
        Object p2 = new Player("Sachin", 44);
        System.out.println(p1.equals(p2));
    }
}