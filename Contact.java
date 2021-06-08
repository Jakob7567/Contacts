import ecs100.*;

/**
 * Support class to help create and organise variables and objects
 * Contains the id, name, number and photo of the contact
 *
 * @author Jakob L.
 * @version 31/05/21
 */
public class Contact
{
    // fields
    private String name;
    private String photo;
    private int number;
    static final String DEFAULT_PIC = "blank.png";
    
    /**
     * Constructor to make the Contact object
     */
    public Contact(String nm, String pic, int num)
    {
        this.name = nm;
        this.photo = pic;
        this.number = num;
    }
    
    /**
     * Constructor overloading in case they choose not to have a picture
     */
    public Contact(String nm, int num)
    {
        this(nm, DEFAULT_PIC, num);
    }
    
    /**
     * Getter for name
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * Getter for number
     */
    public int getNumber()
    {
        return this.number;
    }
    
    /**
     * Getter for photo
     */
    public String getPhoto()
    {
        return this.photo;
    }
    
    /**
     * Draws the picture of the contact
     */
    public void drawImage(double x, double y, String name)
    {
        final double WIDTH = 10;
        final double HEIGHT = 10;
        
        UI.drawImage(name, x, y, WIDTH, HEIGHT);
    }
}
