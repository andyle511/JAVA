/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author REVELUV
 */
public class Test1 
{
    public static void main(String[] args)
    {
        Character player = new Character("Andy", "Human", 100, new Equipment("Wood", "Club"));
        Character monster1 = new Character("Cerberus", "Hell Hound", 1000, new Equipment("Obsidian", "Claws"));
        
        System.out.printf("%s%n", monster1);        
        System.out.printf("%s%n", player);
    }
}