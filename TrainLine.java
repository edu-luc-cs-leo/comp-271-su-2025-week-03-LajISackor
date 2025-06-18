public class TrainLine {

    private static final String DEFAULT_NAME = "Hogwarts Express";

    /** The name of the train line */
    private String name;
    /** The head station of the train line */
    private Station head;
    /** Current number of stations in the line */
    private int numberOfStations;
    /** The tail station of the train line */
    private Station tail; 

    /** Basic constructor */
    public TrainLine(String name) {
        this.name = name;
        this.head = null;
        this.tail = null;
        this.numberOfStations = 0;
    } // basic constructor

    /** Default constructor */
    public TrainLine() {
        this(DEFAULT_NAME);
    } // default constructor

    /** Accessor for the number of stations */
    public int getNumberOfStations() {
        return this.numberOfStations;
    }

    /**
     * Adds a new station after the last station of a trainline.
     * Uses a tail pointer to avoid full traversal of the line 
     * 
     * @param name String with name of new station to create and add
     */
    public void add(String name) {
        Station newStation = new Station(name);
        if (this.head == null) {
            // No stations exist in this line. Make this new station
            // the head station of the line
            this.head = newStation;
            this.tail = newStation; 
        } else {
            this.tail.setNext(newStation); 
            this.tail = newStation; 
        }
        this.numberOfStations++; 
        // or this.numberOfStations++;
        // or this.numberOfStatiosn += 1;
    } // method add

    /** 
     * Returns the position of a station in the train line. 
     * 0 for the head, 1 for the second station, etc.
     * Returns -1 if the station is not found 
     */
    public int indexOf(String stationName) {
        int index = 0; 
        Station cursor = this.head; 
        while (cursor != null) {
            if (cursor.getName().equals(stationName)) {
                return index; 
            }
            index++; 
            cursor = cursor.getNext(); 
        }
        return -1; 
    }

    /**
     * Checks whether the train line contains a station with the given name
     * 
     * @param stationName the name to search for 
     * @return true if the station is found; false otherwise 
     */
    public boolean contains(String stationName) { 
        Station cursor = this.head; 
        while (cursor != null) { 
            if (cursor.getName().equals(stationName)) { 
                return true;
            }
            cursor = cursor.getNext(); 
        }
        return false; 
    }

    /**
     * Finds how many stations are in a train line
     * 
     * METHOD MADE OBSOLETE BY INTRODUCTING TrainLine.numberOfStations
     */
    public int stationCounter() {
        int counter = 0;
        if (this.head != null) {
            // Train line not empty
            Station cursor = this.head;
            while (cursor != null) {
                counter = counter + 1;
                cursor = cursor.getNext();
            }
        }
        return counter;
    } // method countStations

    

    /**
     * String representation of the object
     */
    private static final String EMPTY_TRAIN_LINE = "The train line is empty";
    private static final String TRAIN_LINE_HEADER = "\"%s\" has the following stations: %s";
    private static final String NEXT_ARROW = " --> ";

    public String toString() {
        if (this.head == null) {
            return EMPTY_TRAIN_LINE;
        } else {
            String stations = String.format(TRAIN_LINE_HEADER, this.name, this.head.getName());
            Station cursor = this.head.getNext();
            while (cursor != null) {
                stations = stations + NEXT_ARROW + cursor.getName();
                cursor = cursor.getNext();
            }
            return stations;
        }
    } // method toString
} // class TrainLine
