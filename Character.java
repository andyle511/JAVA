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
public class Character 
{
    private String name;
    private String race;
    private int hitpoints;
    private Equipment equip;
    
    public Character(String name, String race, int hitpoints, Equipment equip)
    {
        this.name = name;
        this.race = race;
        this.hitpoints = hitpoints;
        this.equip = equip;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getRace()
    {
        return race;
    }
    public void setRace(String race)
    {
        this.race = race;
    }
    public int getHitpoints()
    {
        return hitpoints;
    }
    public void setHitpoints(int hp)
    {
        this.hitpoints = hp;
    }
    public Equipment getEquip()
    {
        return equip;
    }
    public void setEquip(Equipment equip)
    {
        this.equip = equip;
    }
    @Override
    public String toString()
    {
        return String.format("%s|%s|HP:%d%n%s%n", getName(), getRace(), getHitpoints(), getEquip());
    }
}