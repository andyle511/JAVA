/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Scanner;
import java.util.Random;

public class Game 
{
    Scanner input = new Scanner(System.in);
    Scanner enter = new Scanner(System.in);
    Random rng = new Random();

    Character player = new Character();
    int playerHP = 100;
    Character monster1 = new Character("Cerberus", "Hell Hound", 100, new Equipment("Steel", "Claws"));
    Character monster2 = new Character("Minotaur", "Bipedal Bull", 200, new Equipment("Stone", "Horns"));
    int monsterHP = monster2.getHitpoints();
    Character boss = new Character("Monty Rabbit", "Killer Bunny", 9000, new Equipment("Fluff", "Teeth"));
    Equipment testsword = new Equipment("Wood", "Sword");
    Equipment ultsword = new Equipment("Adamantium", "Legendary Sword");
    Equipment weapon = new Equipment();
    String key = "";    
    
    public static void main(String[] args)
    {
        Game RPG = new Game();
        RPG.CharCreation();
        RPG.start();
    }
    
    public void CharCreation()
    {
        System.out.println("Welcome to the greatest RPG ever made!");
        System.out.println("Enter your name: ");
        player.setName(input.nextLine());
        System.out.println("Enter your desired starting equipment: ");
        //display array of available starting equipments
        System.out.println("I want to start with a wooden sword");
        player.setEquip(testsword);
        player.setRace("Human");
        player.setHitpoints(playerHP);
        System.out.printf("So you are %s", player);
        System.out.println("Great! Now you are well-equipped to start your adventure into the Abyss Dungeon.");        
    }
    
    public void start()
    {
        System.out.println("\n--------------------------------------------------");
        System.out.println("You're standing in front of the Abyss Dungeon.");        
        System.out.println("What do you want to do?");
        System.out.printf("\t1. Enter the dungeon\n");
        System.out.printf("\t2. Turn tail and run home\n");
        System.out.printf("\t3. Take a nap first\n");
        System.out.println("--------------------------------------------------");
        
        int choice = input.nextInt();        
        switch(choice)
        {
            case 1:
                enter();
                break;
            case 2:
                flee();
                break;
            case 3:
                nap();
                break;
            default:
                System.out.println("Only 1, 2 or 3");
                break;
        }
    }
    
    public void flee()
    {
        System.out.println("\n--------------------------------------------------");
        System.out.println("In your cowardly haste, you tripped over a rock and died!");
        System.out.println("Want to try again? 1 for yes or 2 for no..");
        int choice = input.nextInt();
        if(choice==1)
            start();
        else if(choice==2)
            GameOver();
    }
    
    public void nap()
    {
        System.out.println("\n--------------------------------------------------");
        System.out.println("You take a well-deserved rest and wake up fully refreshed!");
        System.out.println("Suddenly you hear a voice echoing from within the dungeon..");
        System.out.printf("\"Come in, weary adventurer! There is cake!\" the voice says.\n");
        System.out.println("Waking up from an empty stomach, you find the cake irresistable so you approach the dungeon again.\n");
        start();
    }
    
    public void enter()
    {
        System.out.println("\n--------------------------------------------------");
        System.out.println("Upon entering the caves, your nostrils start flaring up uncontrollably from the permeating smell of cake.");
        System.out.println("After gathering your senses, you can see the path split into 3.");
        System.out.printf("\t1. Left\n");
        System.out.printf("\t2. Right\n");
        System.out.printf("\t3. Forward\n");
        System.out.println();
        System.out.println("Where do you think the voice is hiding the cake?");
        
        int choice = input.nextInt();
        switch(choice)
        {
            case 1:
                Left();
                break;
            case 2:
                Right();
                break;
            case 3:
                Forward();
                break;
            default:
                enter();
                break;
        }
    }
    
    public void Left()
    {
        System.out.println("After wandering down this path for a while, you end up in a pitch dark room.");
        System.out.println("While trying to light a torch, you feel a sudden pain in your left leg.");
        System.out.println("So you take a good look and realize you've been bit by some creature.");
        System.out.println("(You received 10 damage)");
        playerHP -= 10;
        enter.nextLine();
        System.out.printf("The torch is lit. You can see the creature is actually a %s.\n", monster1.getName());
        System.out.println("--------------------------------------------------");
        System.out.println();
        System.out.println("What do you want to do?");
        System.out.printf("\t1. Fight it\n");
        System.out.printf("\t2. Run away\n");
        System.out.printf("\t3. Attempt to play fetch with the beast using the torch\n");
        
        int choice = input.nextInt();
        switch(choice)
        {
            case 1:        
                if(player.getEquip().equals(ultsword))
                {
                    displayStats();
                    System.out.printf("Feeling confident wielding the %s, you lunge at the beast.\n", ultsword);
                    System.out.println("But your injured leg makes you lose balance and you fall face first to the ground.");
                    System.out.printf("The %s is confused for 3 seconds, then proceeds to claw you to death.\n", monster1.getName());
                    GameOver();
                }
                else
                {
                    displayStats();
                    System.out.printf("Yelling at the top of your lungs, you charge forward with your %s.\n", testsword);
                    System.out.printf("But the %s is simply too strong and it claws you to death.\n", monster1.getName());
                    GameOver();
                }                    
                break;
            case 2:            
                System.out.println("You try to run as fast you can but the injured leg isn't helping.");
                System.out.printf("The %s catches up to you in 3 seconds and claws you to death.\n", monster1.getName());
                GameOver();
                break;
            case 3:
                System.out.println("You throw the torch behind the beast.");
                System.out.printf("Being a canine, the %s simply cannot resist running to fetch the torch.\n", monster1.getName());
                System.out.printf("When the beast is occupied with the torch, you take out your %s and knock it out cold.\n", player.getEquip());
                enter.nextLine();
                System.out.printf("After confirming that the %s is unconscious, you discover a door behind it.\n", monster1.getName());
                System.out.println("You open the door and see a pool of green water.");
                System.out.println("Soaking yourself in the water, you can feel your wounded leg healing.");
                playerHP += 5;
                System.out.println("You also found a stone key at the bottom of the pool.");
                key = "Stone Key";
                System.out.println();
                System.out.printf("\t1. Go back to the entrance\n");
                System.out.println("--------------------------------------------------");

                int choice1 = input.nextInt();
                if(choice1==1)
                    enter();
                else
                    Left();
                break;
            default:
                Left();
                break;
        }        
    }
    
    public void Right()
    {
        System.out.println("\n--------------------------------------------------");
        System.out.println("You walk down a brightly lit pathway leading to a golden door.");
        System.out.println("Inside there's only a golden chest on top of a rock.");
        System.out.println("Sensing that something isn't quite right, you pick up a rock and throw it at the chest.");
        enter.nextLine();
        System.out.println("Alas, nothing happened. You simply opened the chest and discovered a shiny weapon.");
        System.out.printf("You've obtained %s.\n", ultsword);
        player.setEquip(ultsword);
        System.out.println();
        System.out.printf("\t1. Go back to the entrance\n");
        System.out.println("--------------------------------------------------");
        
        int choice = input.nextInt();
        if(choice==1)
            enter();
        else
            Right();
    }
    
    public void Forward()
    {
        System.out.println("--------------------------------------------------");
        System.out.println("Going straight ahead, you come to a gigantic stone door with a hole.");
        
        if(key.equals("Stone Key"))
            {
                System.out.println("You thrust the stone key into the hole and turn it clockwise.");
                System.out.println("There are loud rumbling sounds and the door slowly lifts.");
                System.out.println("Somewhere in the misty distance, you see a big silhouette.");
                enter.nextLine();
                System.out.println("It suddenly jumps up high in the air and lands in front of you.");
                System.out.printf("You now realize it's a huge %s.\n", monster2.getName());
                System.out.println(monster2);
                fight();
                BossRoom();
            }
        else
        {
            System.out.println("You try to lift the stone door but it's simply too heavy.");
            enter.nextLine();
            System.out.println("You try to use your " + testsword + " but it doesn't fit the hole.");
            System.out.println("There seems to be another way to lift this stone door.");
            System.out.println();
            System.out.printf("\t1. Go back to the entrance\n");
            System.out.println("--------------------------------------------------");

            int choice = input.nextInt();
            if(choice==1)
                enter();
            else
                Forward();
        }
    }
    
    public void BossRoom()
    {
        
    }
    
    public void displayStats()
    {
        System.out.printf("\tYou: %s", player);
        System.out.printf("\t\t\t\tV.S.\n");
        System.out.printf("\tMonster: %s", monster1);
        enter.nextLine();
    }
    
    public void GameOver()
    {
        System.out.println("--------------------------------------------------");
        System.out.println("GAME OVER!");
        System.out.println("--------------------------------------------------");
    }
        
    public void fight()
    {
        System.out.println("---------------------------------------------------------\n");
        System.out.println("Your HP: " + playerHP);
        System.out.println("Monster HP: " + monsterHP);
        System.out.println("\n\t1. Battle");
        System.out.println("\t2. Run away");
        System.out.println("\n-----------------------------------------------------\n");

        int choice = input.nextInt();                                           
        switch(choice)
        {
            case 1:
                battle();
                break;
            case 2:
                enter();
                break;
            default:
                fight();
                break;
        }
    }
    
    public void battle()
    {
        int playerDmg = 0;
        int monsterDmg = 0;    
                        
        if(player.getEquip().equals(testsword))
            playerDmg = rng.nextInt(10);
        else if(player.getEquip().equals(ultsword))
            playerDmg = 40 + rng.nextInt(10);
        
        System.out.println("You inflicted " + playerDmg + " damage to the monster");
        monsterHP -= playerDmg;
        System.out.println("Monster HP: " + monsterHP);
        
        if(monsterHP>0)
        {
            monsterDmg = 10 + rng.nextInt(10);
            System.out.println("The monster inflicted " + monsterDmg + " damage to you.");
            playerHP -= monsterDmg;
            System.out.println("Your HP: " + playerHP);
            if(playerHP<1)
                GameOver();
            else if(playerHP>0)
                fight();
        }    
        else
        {
            System.out.println("Good job! You defeated the " + monster2.getName() + ".");
            BossRoom();
        }
    }
}