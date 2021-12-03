
/**
 * Enumeration class ItemTypes - write a description of the enum class here
 *
 * @author Derek
 * @version 2020
 */
public enum ItemTypes
{
    NONE("none"),
    KEY("keys"),
    BOTTLE("bottle"),
    WATER("water"),
    FOOD("food"),
    TREASURE("treasure");

    private String itemString;

    ItemTypes(String itemString)
    {
        this.itemString = itemString;
    }

    public String toString()
    {
        return itemString;
    }
}
