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
    private String grade;
    private String name;
        
    public Equipment(String grade, String name)
    {
        this.grade = grade;
        this.name = name;
    }
    public String getGrade()
    {
        return grade;
    }
    public void setGrade(String grade)
    {
        this.grade = grade;
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
        return name + " of " + grade;
    }
}