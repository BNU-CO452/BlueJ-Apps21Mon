
/**
 * This class represents a course module and contains
 * information on the module title and code.
 *
 * @author Derek Peacock
 * @version 1.0 11/10/2021
 */
public class Module
{
    // instance variables - replace the example below with your own
    
    private String code;
    
    private String title;
    
    private int credit;
    
    /**
     * Constructor for objects of class Module
     */
    public Module(String code, String title)
    {
        // initialise instance variables
        credit = 15;
        this.code = code;
        this.title = title;
    }

    public String getCode()
    {
        return code;
    }
    
    public String getTitle()
    {
        return title;
    } 
    
    public void setCredit(int credit)
    {
        this.credit = credit;
    }
    
    /**
     * Print the details of the course, the list
     * of students enrolled and the module
     */
    public void print()
    {
        System.out.println(" Module Code: " + code + ": " 
                            + title + " Credit " + credit);
        System.out.println();
    }
    
}
