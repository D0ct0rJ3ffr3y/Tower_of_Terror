/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication10;

/**
 * Class of methods for project
 * @author Jeffrey Contreras
 */
import javax.swing.*;
public class HauntedHouse {
    private String backpack;
    private String answer;
    private String player;

    private final ImageIcon bedroom1 = new ImageIcon("bedroom1.jpg");
    private final ImageIcon bedroom2 = new ImageIcon("bedroom2.jpg");
    private final ImageIcon bathroom1 = new ImageIcon("bathroom1.jpg");
    private final ImageIcon bathroom2 = new ImageIcon("bathroom2.jpg");
    private final ImageIcon diningRoom = new ImageIcon("dining room.jpg");
    private final ImageIcon livingRoom = new ImageIcon("living room.jpg");
    private final ImageIcon masterBedroom = new ImageIcon("master bedroom.jpg");
    private final ImageIcon masterBathroom = new ImageIcon("master bathroom.jpg");
    private final ImageIcon pantry = new ImageIcon("pantry.jpg");
    private final ImageIcon kitchen = new ImageIcon("kitchen.jpg");
    private final ImageIcon frontDoor = new ImageIcon("front door.png");
    private final ImageIcon boilerRoom = new ImageIcon("boiler room.jpg");
    private final ImageIcon storageRoom = new ImageIcon("storage room.jpg");
    private final ImageIcon attic = new ImageIcon("attic.png");
    private final ImageIcon elevator = new ImageIcon("elevator.jpg");
    private final ImageIcon basement = new ImageIcon("basement.jpg");

    private final ImageIcon[] pics ={null,elevator, basement, boilerRoom, storageRoom, frontDoor, diningRoom, kitchen, pantry, livingRoom, bathroom1, bedroom1, bedroom2, bathroom2, masterBedroom, masterBathroom, attic, null}; //   ADD MISSING PICTURES ACCORDINGLY
    private final String floor[] = {"Basement", "First Floor", "Dining Room", "Kitchen", "Pantry", "Living room", "Bathroom 1", "Bedroom 1", "Bedroom 2", "Bathroom 2", "Master Bedroom", "Master Bathroom" , "Attic"};
    private final Elevator[] rooms = new Elevator[]{new Elevator(){public void moveto(){ basement();}},new Elevator(){public void moveto(){ floor1();}},new Elevator(){public void moveto(){ diningRoom();}},
            new Elevator(){public void moveto(){ kitchen();}},new Elevator(){public void moveto(){ pantry();}},new Elevator(){public void moveto(){ livingRoom();}},
            new Elevator(){public void moveto(){ bathroom(1);}},new Elevator(){public void moveto(){ bedroom1();}},new Elevator(){public void moveto(){ bedroom2();}},
            new Elevator(){public void moveto(){ bathroom(2);}}, new Elevator(){public void moveto(){ masterBedroom();}}, new Elevator(){public void moveto(){ masterBathroom();}},
            new Elevator(){public void moveto(){ attic();}}};

    
    HauntedHouse (){
        backpack="";
        answer="";
    }

    interface Elevator{
        void moveto();
    }
    /**
     *This method controls the interactions involving the elevator
     */
    public void elevator(){
        JOptionPane.showMessageDialog(null,"You are back at the elevator","Display Image",JOptionPane.INFORMATION_MESSAGE,elevator);
        answer =(String) JOptionPane.showInputDialog(null,"Choose the floor you would like to go to","Haunted Tower",JOptionPane.QUESTION_MESSAGE,null,floor,floor[0]);
        for(int i = 0; i<floor.length;i++){
            if(answer.equals(floor[i])){
                rooms[i].moveto();
            }
        }
    }


/**
 *This is the start method. It acquires the Player's name, and their first choice.
 * According to what the Player chooses, we call the method for the room they choose.
 */
    public void start(){  //FIX JOPTION OUTPUT
        while(true) {
            player = JOptionPane.showInputDialog("Welcome to the Haunted House, what is your name?");
            JOptionPane.showMessageDialog(null, "Hello " + player + ", you are now going to enter the Haunted House, Have Fun.");
            JOptionPane.showMessageDialog(null, "You are now inside of the house standing at the front door", "Display Image", JOptionPane.INFORMATION_MESSAGE, frontDoor);
            JOptionPane.showMessageDialog(null, "You go inside the house and see an elevator");
            elevator();
        }
    }
    
    /**
     *This method allows the player to attempt to escape the Haunted Tower
     */
    public void floor1(){       //FIX ALL JOPTION OUTPUT AND ADD JAVADOC
        if(backpack.contains("key 2")){
            JOptionPane.showMessageDialog(null, "You have the key to exit the Haunted Tower");
            while(true){
                answer = JOptionPane.showInputDialog("Do you want to exit or keep exploring? Type \"exit\" or \"explore\"" );
                if(answer.equalsIgnoreCase("exit")){
                    JOptionPane.showMessageDialog(null, "You decide to leave the Tower of Yonder and you walk out of the front door");
                    gameOver(floor[1]);
                    System.exit(0);
                }
                else if(answer.equalsIgnoreCase("explore")){
                    JOptionPane.showMessageDialog(null, "You decide to continue exploring and walk back into the elevator");
                    elevator();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Your input was not accepted, try again.");
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "You try to leave the Tower of Yonder but you find that the door is locked, so you go back in the elevator");
            elevator();
        }
    }
/**
 *This method allows the player to choose whether to examine the chest, or go back to the elevator.
 */
    public void livingRoom(){ //FIX JOPTION OUTPUT add javadoc
        JOptionPane.showMessageDialog(null,"You are now inside the Living Room","Display Image",JOptionPane.INFORMATION_MESSAGE,livingRoom);
        while(true){
            answer = JOptionPane.showInputDialog("Do you open the Chest or go back to the elevator? type \"chest\" or \"elevator\"");
            if(answer.equalsIgnoreCase("chest")){
                JOptionPane.showMessageDialog(null,"A ghost escapes and scares you to death");
                JOptionPane.showMessageDialog(null,"You put the chest in your backpack as you float out of the tower in shock.");
                backpack += "chest, ";
                elevator();
            }
            else if(answer.equalsIgnoreCase("elevator")){
                elevator();
            }
            else{
                JOptionPane.showMessageDialog(null,"Your input was invalid, try again.");
            }
        }
    }
    /**
     *This method allows the player to choose whether to examine the candelabra, or go back to the elevator
     */
    public void diningRoom(){ //FIX IF STATEMENTS AND JOPTION OUTPUT
        JOptionPane.showMessageDialog(null,"You are now inside the Dining Room","Display Image",JOptionPane.INFORMATION_MESSAGE,diningRoom);
        while(true){
            answer = JOptionPane.showInputDialog("Do you observe the Candelabra or back to the elevator? type \"candelabra\" or \"elevator\"");
            if(answer.equalsIgnoreCase("candelabra")){
                JOptionPane.showMessageDialog(null,"The lights turn on by themselves and you see a deathly shadow");
                JOptionPane.showMessageDialog(null,"You put the Candelabra in your backpack as you float out of the tower in shock.");
                backpack += "candelabra, ";
                elevator();
            }
            else if (answer.equalsIgnoreCase("elevator")){
                elevator();
            }
            else{
                JOptionPane.showMessageDialog(null,"Your input was invalid, try again.");
            }
        }
    }
    /**
     *This method allows the player to choose whether to examine the mirror or the shower.
     * @param floor checks the floor where the player is at
     */
    public void bathroom(int floor){ //FIX JOPTION OUTPUT *edit, Fixed? - Finest
        if(floor == 1){
            JOptionPane.showMessageDialog(null,"You are now inside Bathroom 1.","Display Image",JOptionPane.INFORMATION_MESSAGE,bathroom1);
            while(true){
                answer = JOptionPane.showInputDialog("Do you observe the Mirror, the Shower or head back to the elevator? Type \"mirror\" or \"shower\" or \"elevator\"");
                if(answer.equalsIgnoreCase("mirror")){
                    JOptionPane.showMessageDialog(null,"You see a bloody face looking back at you");
                    JOptionPane.showMessageDialog(null,"You place the Mirror in your backpack");
                    backpack += "mirror, ";
                    elevator();
                }
                else if(answer.equalsIgnoreCase("shower")){
                    JOptionPane.showMessageDialog(null,"The room suddenly steams up and you feel fingers touching the back of your neck");
                    JOptionPane.showMessageDialog(null,"You place the Shower in your backpack");
                    backpack += "shower, ";
                    elevator();
                }
                else if(answer.equalsIgnoreCase("elevator"))
                {
                    elevator();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Your input was invalid, try again.");
                }
            }
        }
        else if(floor == 2){
            JOptionPane.showMessageDialog(null,"You are now inside the Bathroom 2.","Display Image",JOptionPane.INFORMATION_MESSAGE,bathroom2);
            while(true){
                answer = JOptionPane.showInputDialog("Do you observe the Mirror, the Shower or head back to the elevator? Type \"mirror\" or \"shower\" or \"elevator\"");
                if(answer.equalsIgnoreCase("mirror")){
                    JOptionPane.showMessageDialog(null,"You see a bloody face looking back at you");
                    JOptionPane.showMessageDialog(null,"You place the Mirror in your backpack");
                    backpack += "mirror, ";
                    elevator();
                }
                else if(answer.equalsIgnoreCase("shower")){
                    JOptionPane.showMessageDialog(null,"The room suddenly steams up and you feel fingers touching the back of your neck");
                    JOptionPane.showMessageDialog(null,"You place the Shower in your backpack");
                    backpack += "shower, ";
                    elevator();
                }
                else if(answer.equalsIgnoreCase("elevator"))
                {
                    elevator();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Your input was invalid, try again.");
                }
            }
        }
    }
    /**
     *This method allows the player to choose whether to examine the refrigerator, cabinet, or proceed to the pantry.
     */
    public void kitchen(){ //FIX IF STATEMENTS AND JOPTION OUTPUT
        JOptionPane.showMessageDialog(null,"You are now inside the Kitchen,","Display Image",JOptionPane.INFORMATION_MESSAGE,kitchen);
        while(true){
            answer = JOptionPane.showInputDialog("Do you open the Refrigerator do you open the Cabinet or do you head back to the elevator? Type \"refrigerator\" or \"cabinet\" or \"elevator\"");
            if(answer.equalsIgnoreCase("refrigerator")){
                JOptionPane.showMessageDialog(null,"You open it and find some delicious soul food");
                JOptionPane.showMessageDialog(null,"You place the Refrigerator in your backpack");
                backpack += "refrigerator, ";
                elevator();
            }
            else if(answer.equalsIgnoreCase("cabinet")){
                JOptionPane.showMessageDialog(null,"The dishes and glasses start flying at you as soon as you open the door. You get hit in the head and feel yourself start moving towards a light");
                backpack += "cabinet, ";
                elevator();
            }
            else if(answer.equalsIgnoreCase("elevator")){
                elevator();
            }
            else{
                JOptionPane.showMessageDialog(null,"Your input was invalid, try again.");
            }
        }
    }
    /**
     *This method allows the player to choose whether to examine the broom or dusty recipe box.
     */
    public void pantry(){ //FIX JOPTION OUTPUT
        JOptionPane.showMessageDialog(null,"You are in the Pantry","Display Image",JOptionPane.INFORMATION_MESSAGE,pantry);
        while(true){
            answer = JOptionPane.showInputDialog("Do you observe the Broom or open the Dusty recipe box or head back to the elevator? Type \"broom\" or \"dusty recipe box\" or \"elevator\"");
            if(answer.equalsIgnoreCase("broom")){
                JOptionPane.showMessageDialog(null,"It flies up in the air as soon as you touch it");
                JOptionPane.showMessageDialog(null,"You place the broom in your backpack");
                backpack += "broom, ";
                elevator();
            }
            else if(answer.equalsIgnoreCase("dusty recipe box")){
                JOptionPane.showMessageDialog(null,"You open it up and a recipe for chocolate devils food cake appears our of no where");
                JOptionPane.showMessageDialog(null,"You place the Dusty recipe box in your backpack and continue exploring");
                backpack += "dusty recipe box, ";
                elevator();
            }
            else if(answer.equalsIgnoreCase("elevator"))
            {
                elevator();
            }
            else{
                JOptionPane.showMessageDialog(null,"Your input was invalid, try again.");
            }
        }
    }


    /**
     *This method allows the player to choose whether to examine the window, rocking chair, or proceed to the bathroom.
     */
    public void bedroom1(){ //FIX IF STATEMENTS AND JOPTION OUTPUT
        JOptionPane.showMessageDialog(null,"You are now inside Bedroom 1","Display Image",JOptionPane.INFORMATION_MESSAGE,bedroom1);
        while(true){
            answer = JOptionPane.showInputDialog("Do you observe the Window, observe the Rocking chair, or go back to the elevator? Type \"window\", \"rocking chair\", or \"elevator\"");

            if(answer.equalsIgnoreCase("window")){
                JOptionPane.showMessageDialog(null,"You see a child outside on a swing who suddenly disappears");
                JOptionPane.showMessageDialog(null,"You place the window in your backpack");
                backpack += "window, ";
                elevator();
            }
            else if(answer.equalsIgnoreCase("rocking chair")){
                JOptionPane.showMessageDialog(null,"The chair starts rocking by itself with no one in it");
                JOptionPane.showMessageDialog(null,"You place the rocking chair in your backpack");
                backpack += "rocking chair, ";
                elevator();
            }
            else if(answer.equalsIgnoreCase("elevator")){
                elevator();
            }
            else{
                JOptionPane.showMessageDialog(null,"Your input was invalid, try again.");
            }
        }
    }
    /**
     *This method allows the player to choose whether to examine the doll house, dresser, or call the bathroom2 method.
     */
    public void bedroom2(){ //FIX JOPTION OUTPUT
        JOptionPane.showMessageDialog(null,"You are now inside Bedroom 2","Display Image",JOptionPane.INFORMATION_MESSAGE,bedroom2);
        while(true){
            answer = JOptionPane.showInputDialog("Do you observe the Doll house, open the Dresser, or go back to the elevator? Type \"doll house\", \"dresser\", or \"elevator\"");

            if(answer.equalsIgnoreCase("doll house")){
                JOptionPane.showMessageDialog(null,"The dolls start dancing on their own");
                JOptionPane.showMessageDialog(null,"You place the doll house in your backpack");
                backpack += "doll house, ";
                elevator();

            }
            else if(answer.equalsIgnoreCase("dresser")){
                JOptionPane.showMessageDialog(null,"A ghost flies out of the dresser as soon as you open it and goes right though your body");
                JOptionPane.showMessageDialog(null,"You place the dresser in your backpack");
                backpack += "dresser, ";
                elevator();
            }
            else if(answer.equalsIgnoreCase("elevator")){
                elevator();
            }
            else{
                JOptionPane.showMessageDialog(null,"Your input was invalid, try again.");
            }
        }
    }
    /**
     *This method allows the player to choose whether to examine the jewelry box or proceed to the master bathroom.
     */
    public void masterBedroom(){ //FIX JOPTION OUTPUT
        JOptionPane.showMessageDialog(null,"You are now inside the Master Bedroom","Display Image",JOptionPane.INFORMATION_MESSAGE,masterBedroom);
        while(true){
            answer = JOptionPane.showInputDialog("Do you open the Jewelry box or go back to the elevator? Type \"jewelry box\" or \"elevator\"");

            if(answer.equalsIgnoreCase("jewelry box")){
                JOptionPane.showMessageDialog(null,"You find the cursed Hope Diamond and feel your doom");
                JOptionPane.showMessageDialog(null,"You place the jewelry box in your backpack");
                backpack += "jewelry box, ";
                elevator();
            }
            else if(answer.equalsIgnoreCase("elevator")){
                elevator();
            }
            else{
                JOptionPane.showMessageDialog(null,"Your input was invalid, try again.");
            }
        }
    }
    /**
     *This method allows the player to choose whether to examine the intricate oil lamp or the shower.
     */
    public void masterBathroom(){ //FIX JOPTION OUTPUT
        JOptionPane.showMessageDialog(null,"You are now inside the Master Bathroom","Display Image",JOptionPane.INFORMATION_MESSAGE,masterBathroom);
        while(true){
            answer = JOptionPane.showInputDialog("Do you rub the Intricate oil lamp or observe the Shower or head back to the elevator? Type \"intricate oil lamp\" or \"shower\" or \"elevator\"");
            if(answer.equalsIgnoreCase("intricate oil lamp")){
                JOptionPane.showMessageDialog(null,"You rub the lamp and a genie pops out who says he’ll grant you 3 wishes");
                JOptionPane.showMessageDialog(null,"You place the intricate oil lamp in your backpack");
                backpack += "intricate oil lamp, ";
                elevator();
            }
            else if(answer.equalsIgnoreCase("shower")){
                JOptionPane.showMessageDialog(null,"The room suddenly steams up and you feel fingers touching the back of your neck");
                JOptionPane.showMessageDialog(null,"You place the shower in your backpack");
                backpack += "shower, ";
                elevator();
            }
             else if(answer.equalsIgnoreCase("elevator")){
                elevator();
            }
            else{
                JOptionPane.showMessageDialog(null,"Your input was invalid, try again.");
            }
        }
    }

    /**
     *This method controls the interactions of the attic
     */
    public void attic(){ //FIX ALL JOPTION OUTPUT AND ADD JAVADOC
        if (backpack.contains("key 1")) {
            JOptionPane.showMessageDialog(null,"You are now inside the Attic","Display Image",JOptionPane.INFORMATION_MESSAGE,attic);
            while(true){
                answer = JOptionPane.showInputDialog("Do you open the Chest? Type \"yes\" or \"no\"");
                if (answer.equalsIgnoreCase("yes")) {
                    backpack += "key 2, ";
                    JOptionPane.showMessageDialog(null, "You find a key and place it in your backpack. Now you head back to the elevator to see what this key opens");
                    elevator();
                }
                else if(answer.equalsIgnoreCase("no")){
                    JOptionPane.showMessageDialog(null, "You you ignore the chest and head back to the elevator to keep exploring");
                    elevator();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Your input was not accepted, try again.");
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null,"The door to enter the room in the Attic is locked. You head back to the elevator.");
            elevator();
        }

    }
    
    /**
     *This method controls the interactions of the basement
     */
    public void basement(){//FIX ALL JOPTION OUTPUT AND ADD JAVADOC
        JOptionPane.showMessageDialog(null, "You now see a creepy basement", "Display Image", JOptionPane.INFORMATION_MESSAGE, basement);
        while(true){
            answer = JOptionPane.showInputDialog("You are now standing in the center of the basement, do you go to the elevator, the storage, or the boiler room? Type \"elevator\", \"storage room\", or \"boiler room\"");
            if(answer.equalsIgnoreCase("elevator")){
                elevator();
            }
            else if(answer.equalsIgnoreCase("storage room")){
                storageRoom();
            }
            else if(answer.equalsIgnoreCase("boiler room")){
                boilerRoom();
            }
            else{
                JOptionPane.showMessageDialog(null,"Your input was not accepted, try again.");
            }
        }
    }
    /**
     *This method controls the interactions of the boiler room
     */
    public void boilerRoom(){ //FIX ALL JOPTION OUTPUT AND ADD JAVADOC
        JOptionPane.showMessageDialog(null,"You enter the Boiler Room, but you find nothing of interest. You head back to the basement", "Display Image", JOptionPane.INFORMATION_MESSAGE,boilerRoom);
        basement();
    }
    /**
     *This method controls the interactions of the storage room
     */
    public void storageRoom(){ //FIX ALL JOPTION OUTPUT AND ADD JAVADOC
        answer = JOptionPane.showInputDialog("You enter the Storage Room, do you go to the basement or observer the chest? Type \"basement\" or \"chest\"");
        if(answer.equalsIgnoreCase("chest")){
            JOptionPane.showMessageDialog(null,"You open up the chest to find a dusty key. you put the key in your back pack as you head back to the basement", "Display Image", JOptionPane.INFORMATION_MESSAGE,storageRoom);
            backpack += "key 1, ";
            basement();
        }
        else if(answer.equalsIgnoreCase("basement")){
            basement();
        }
    }
    
    /**
     * This method ends the game
     * @param room checks the room where the player is at
     */
    public void gameOver(String room){ //EXPLAIN DO WHILE LOOP!!!! MAKE JAVADOC AND FIX JOPTION
        int i = 0;
        ImageIcon finalRoom = new ImageIcon();
        if(room.equalsIgnoreCase(floor[1])){
            JOptionPane.showMessageDialog(null, "GAME OVER, you conquered the frightful Tower of Yonder and are free to do whatever you please with the items you found. have fun and come back again.");
            JOptionPane.showMessageDialog(null,"These are the items in your backpack " + backpack.substring(0,backpack.length()-2) + ".");
        }
        else{
            do{
                if(room.equalsIgnoreCase(floor[i])){
                    finalRoom = pics[i];
                }
                i++;
            }while(i<floor.length);
            JOptionPane.showMessageDialog(null,"GAME OVER, you died in the " + room + ", I hope you enjoyed your visit to the Tower of Yonder, have fun being a ghost","Display Image",JOptionPane.INFORMATION_MESSAGE,finalRoom);
            JOptionPane.showMessageDialog(null,"These are the items in your backpack " + backpack.substring(0,backpack.length()-2) + ".");
        }
    }
   }