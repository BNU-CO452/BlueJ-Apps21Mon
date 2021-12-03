
/**
 * Write a description of class Map here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Caves
{
    private Location building;
    private Location start;
    private Location eastForest;
    private Location westForest;
    private Location valley;
    private Location slit;
    private Location grate;
    private Location smallChamber;
    private Location cobbles;
    private Location largeChamber;
    private Location kingsHall;

    private String description;

    /**
     * Constructor for objects of class Map
     */
    public Caves()
    {
        createStart();
        createBuilding();
        createEastForest();
        createWestForest();
        createValley();
        createSlit();
        createGrate();
        createSmallChamber();
        createCobbles();
        createLargeChamber();
        createKingsHall();
    }

    public Location getStartLocation()
    {
        return start;
    }

    /**
     * This is the Location the player starts in
     */
    private void createStart()
    {
        start = new Location(0, " outside Brick Building");

        description =
                " standing at the end of a road before a brick \n" +
                        " building. Around you is a forest. A small stream\n" +
                        " flows out of the building and down a gully.";

        start.setDescription(description);

        Item bottle = new Item(ItemTypes.BOTTLE, "\n There is an empty bottle on the ground");
        start.setItem(bottle);
    }

    /**
     * The building is North of the Start and contains
     * important items that need to be picked up
     */
    private void createBuilding()
    {
        building = new Location(2, "inside Brick Building");

        description =  " in a well house for a large spring. ";

        building.setDescription(description);

        building.setItem(
                new Item(ItemTypes.KEY,
                        "\n There are some keys on the ground here."));

        connectLocations(start, "north", building);
    }

    private void createEastForest()
    {
        eastForest = new Location(3, "lost in thick Forest");

        description =  " up a hill, still in the forest.  \n The road";
        description += " slopes back down the other side of the hill.";
        description += " \n There is a building in the distance";

        eastForest.setDescription(description);

        //eastForest.setExit("west", start);
        //start.setExit("east", eastForest);
        connectLocations(start, "east", eastForest);
    }

    private void createWestForest()
    {
        westForest = new Location(4, "lost in open Forest");

        description =  " in open forest, with a deep valley to one side";
        westForest.setDescription(description);

        connectLocations(start, "west", westForest);
    }

    /**
     *
     */
    private void createValley()
    {
        valley = new Location(5, "in a valley");

        description = " in a valley in the forest beside a stream";
        description += "\n tumbling along a rocky bed.";
        valley.setDescription(description);

        valley.setItem(new Item(ItemTypes.FOOD,
                "\n There are a couple of apple trees with fruit"));

        connectLocations(start, "south", valley);

        Location forest = cloneLocation(6, eastForest);
        connectLocations(valley, "east", forest);

        forest = cloneLocation(7, westForest);
        connectLocations(valley, "west", forest);
    }

    private void createSlit()
    {
        slit = new Location(8, "at slit in streambed");

        description = "standing, at your feet all the water of the stream";
        description += " \n splashes into a 2-inch slit in the rock.  ";
        description += " \n Downstream the streambed is bare rock";

        slit.setDescription(description);

        Item water = new Item(ItemTypes.WATER,"a small trickle of water");
        slit.setItem(water);

        connectLocations(slit, "north", valley);
    }

    private void createGrate()
    {
        grate = new Location(9, "beside a grate");

        description = " You are in a 20-foot depression floored ";
        description += " \n with bare dirt.  Set into the dirt ";
        description += " \n is a strong steel grate. The grate is locked";

        grate.setDescription(description);
        connectLocations(grate, "north", slit);
    }

    private void createSmallChamber()
    {
        smallChamber = new Location(10, "in a chamber");

        description = "You are in a small chamber beneath a 3x3 steel";
        description.join("\ngrate to the surface.",
                "\nA low crawl over cobbles leads inward to the west.");

        smallChamber.setDescription(description);
        connectLocations(smallChamber, "up", grate);
    }

    private void createCobbles()
    {
        cobbles = new Location(10, "crawling over cobbles");

        description = "crawling over cobbles in a low passage.";
        description.join("\nThere is a dim light at the east end of the passage.");

        cobbles.setDescription(description);
        connectLocations(cobbles, "west", smallChamber);
    }

    private void createLargeChamber()
    {
        largeChamber = new Location(10, "in a large chamber");

        description = "in a splendid chamber thirty feet high.";
        description.join("\nThe walls are frozen rivers of orange stone. ",
                "There are passages off in all directions.");

        largeChamber.setDescription(description);
        connectLocations(largeChamber, "west", cobbles);

        Location pit = new Location(11, "in a small pit");
        description = "in a small pit breathing traces of white mist. ";
        description.join("A east passage ends here except for a small crack leading on");
        pit.setDescription(description);

        connectLocations(pit, "west", largeChamber);

        Location  jumble = new Location(12, "in a jumble of rocks");
        description = "in a jumble of rocks, with cracks everywhere.";
        jumble.setDescription(description);

        connectLocations(jumble, "north", largeChamber);

        // Location  rocks = new Location(13, "in a large Location");
        // description = "You are in a large Location full of dusty rocks. ";
        // description.join("There are cracks everywhere.");
        // rocks.setDescription(description);

        // connectLocations(rocks, "south", largeChamber);        
    }

    private void createKingsHall()
    {
        kingsHall = new Location(14, "in the King's Hall");

        description = "You are in the Hall of the Mountain King";
        description.join("\nThe hall is filled with wisps of white mist ",
                "swaying to and fro as if alive.");

        Item treasure = new Item(ItemTypes.TREASURE,
                "\n There is an old chest filled with treasure");

        kingsHall.setItem(treasure);

        kingsHall.setDescription(description);
        connectLocations(kingsHall, "south", largeChamber);
    }

    private void connectLocations(Location Location, String direction, Location otherLocation)
    {
        Location.setExit(direction, otherLocation);

        if(direction.equals("east"))
        {
            otherLocation.setExit("west", Location);
        }
        else if(direction.equals("west"))
        {
            otherLocation.setExit("east", Location);
        }
        else if(direction.equals("north"))
        {
            otherLocation.setExit("south", Location);
        }
        else if(direction.equals("south"))
        {
            otherLocation.setExit("north", Location);
        }
        else if(direction.equals("down"))
        {
            otherLocation.setExit("up", Location);
        }
        else if(direction.equals("up"))
        {
            otherLocation.setExit("down", Location);
        }
    }

    private Location cloneLocation(int id, Location toClone)
    {
        Location Location = new Location(id, toClone.getDescription());
        Location.setDescription(toClone.getShortDescription());

        return Location;
    }

    /**
     * Create all the Locations and link their exits together.
     * and return the current Location for the player to start
     */
    public Location createTestLocations()
    {
        Location outside, theater, pub, lab, office;

        // create the Locations
        outside = new Location(1, " outside the main entrance of the university");
        theater = new Location(2, " in a lecture theater");
        pub = new Location(3, " in the campus pub");
        lab = new Location(4, " in a computing lab");
        office = new Location(5, " in the computing admin office");

        // initialise Location exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        return outside;  // start game outside
    }
}
