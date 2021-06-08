import ecs100.*;

/**
 * DOing the gui
 *
 * @author Jakob L.
 * @version 8/06/21
 */
public class GUI
{    
    /**
     * Menu to display options to the user and call appropriate methods
     */
    public static void main(String[] args)
    {
        Contacts c = new Contacts();
        
        UI.setMouseListener(c::doMouse);
        
        UI.addButton("Add Contact", c::addContact);
        UI.addButton("Display All", c::printAll);
        UI.addButton("Clear", UI::clearGraphics);
        UI.addTextField("Find Contact", c::find);
        UI.addButton("Quit", UI::quit);
    }
}
