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
public class Equipment 
{
    private String type;
    private String name;
        
    public Equipment()
    {
        this("","");
    }
    public Equipment(String type, String name)
    {
        this.type = type;
        this.name = name;
    }
    public String getType()
    {
        return type;
    }
    public void setType(String type)
    {
        this.type = type;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    
    @Override
    public String toString()
    {
        return name + " of " + type;
    }
}