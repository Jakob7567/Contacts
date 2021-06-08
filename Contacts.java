import java.util.HashMap;
import ecs100.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Color;

/**
 * Holds a collection of contacts in a hashmap
 * Allows user to add, remove, edit, find and print all contacts from a menu
 * prevent the user from adding duplicate contacts
 *
 * @author Jakob L.
 * @version 31/05/21
 */
public class Contacts
{
    // variables
    private HashMap<Integer, Contact> contactList;  // Creating the HashMap of contacts
    private int curId;                              // Stores the id of the current contact in use
    private ArrayList<Integer> numbers;              // Stores a list of numbers, so no duplicates can be made
    private ArrayList<String> names;                // Stores a list of names to allow the user to search for a contact
    
    /**
     * Constructor for objects of class Contacts
     */
    public Contacts()
    {
        // Initialise variables
        contactList = new HashMap<Integer, Contact>();
        numbers = new ArrayList<Integer>();
        names = new ArrayList<String>();
        
        // Creating preset contacts
        Contact c1 = new Contact("John F", 0000000000);
        Contact c2 = new Contact("Max S", 1111111111);
        Contact c3 = new Contact("Sam W", 222222222);
        
        contactList.put(1, c1);
        contactList.put(2, c2);
        contactList.put(3, c3);
        numbers.add(00000000000);
        numbers.add(1111111111);
        numbers.add(222222222);
        names.add("John F");
        names.add("Max S");
        names.add("Sam W");
        
        curId = 4;
    }
    
    /**
     * adding a contact to the list
     */
    public void addContact()
    {
        // maximum amount of contacts the list can store
        int MAX_CONTACTS = 99;
        int number;
        
        // checking if the list of contacts is too big
        if (contactList.size() >= MAX_CONTACTS)
        {
            UI.println("Too many contacts");
        }
        else
        {
            // getting the number and checking if it is already in the list
            number = UI.askInt("Number: ");
            while (numbers.contains(number) && number > 999999999)
            {
                UI.println("You must enter a 10-digit number that is not already entered.");
                number = UI.askInt("Number: ");
            }
            
            // adding number to seperate list to avoid duplicates
            numbers.add(number);
            
            // asking for the name and picture of the contact
            String name = UI.askString("Name: ");
            String imgFile = UIFileChooser.open("Select Contact Image");
            names.add(name);
            
            // inputting variables to the HashMap
            contactList.put(curId, new Contact(name, imgFile, number));
            
            // incrementing the current id
            curId++;
        }
    }

    /**
     * find a contact
     */
    public void find(String name)
    {
        // Checking if the contact exists
        if (names.contains(name))
        {
            UI.clearGraphics();     // clearing the graphics pane
            
            // printing out the details of the contact
            double left = 20;   // variable for the distance of the text and image from left
            double top = 70;    // variable for the distance of the text and image from top
            
            UI.drawImage(contactList.get(name).getPhoto(), left, top, 70, 70);
            top += 80;
            UI.drawString(contactList.get(name) + " Details:", left, top);
            top += 12;
            UI.drawString(contactList.get(name).getName(), left, top);
            top += 12;
            UI.drawString(String.valueOf(contactList.get(name).getNumber()), left, top);
            
            // Code for String.valueOf() taken from:
            // https://www.educative.io/edpresso/how-to-convert-an-integer-to-a-string-in-java
        }
        else
        {
            // Error message if the contact is not in the list
            UI.println("That contact does not exist");
        }
    }
    
    /**
     * Loops through the list and prints all contacts and their details
     */
    public void printAll()
    {
        double left = 50;   // variable for the distance of the text and image from left
        
        for (int contactId : contactList.keySet())
        {
            double top = 50;    // variable for the distance of the text and image from top
            
            UI.drawImage(contactList.get(contactId).getPhoto(), left, top, 70, 70);
            top += 80;
            UI.drawString(contactId + " Details:", left, top);
            top += 12;
            UI.drawString(contactList.get(contactId).getName(), left, top);
            top += 12;
            UI.drawString(String.valueOf(contactList.get(contactId).getNumber()), left, top);
            left += 90;
        }
    }
    
    /**
     * Hides the current contact
     */
    public void hideContact(double x, double y)
    {
        UI.setColor(Color.white);
        UI.fillRect(x, y, 70, 110);
        UI.setColor(Color.black);
    }
    
    /**
     * Listens for a mouse click on the image of the contact
     */
    public void doMouse(String action, double x, double y)
    {
        if (action == "pressed")
        {
            // checking if the mouse is located on one of the images (only the starting three)
            if (x > 50 && x < 120 && y > 50 && y < 120)
            {
                hideContact(50, 50);
            }
            else if (x > 140 && x < 210 && y > 50 && y < 120)
            {
                hideContact(140, 50);
            }
            else if (x > 230 && x < 300 && y > 50 && y < 120)
            {
                hideContact(230, 50);
            }
        }
    }
}
