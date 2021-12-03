/**
 * This class stores one of the ItemTypes together
 * with a description.
 * e.g. water: a small running stream
 */
public class Item
{
    private final ItemTypes itemType;
    private final String description;

    public Item(ItemTypes type, String description)
    {
        this.itemType = type;
        this.description = description;
    }

    public ItemTypes getItemType()
    {
        return itemType;
    }

    public String getDescription()
    {
        return description;
    }
}
