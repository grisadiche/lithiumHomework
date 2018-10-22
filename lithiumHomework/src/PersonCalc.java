import java.util.*;
import java.util.function.Predicate;

public class PersonCalc {

    public enum Attribute {
        NAME ("Name"),
        AGE ("Age"),
        CITY ("City"),
        STATE ("State"),
        ZIPCODE ("ZipCode"),
        INDUSTRY ("Industry"),
        SEARCHING ("Searching"),
        ALL ("All");

        private String attribute;

        Attribute(String attString) {
            this.attribute = attString;
        }

        public String getAttString() {
            return attribute;
        }
    }

    public static String attName = Attribute.NAME.getAttString();
    public static String attAge = Attribute.AGE.getAttString();
    public static String attCity = Attribute.CITY.getAttString();
    public static String attState = Attribute.STATE.getAttString();
    public static String attZipCode = Attribute.ZIPCODE.getAttString();
    public static String attIndustry = Attribute.INDUSTRY.getAttString();
    public static String attSearching = Attribute.SEARCHING.getAttString();
    public static String attAll = Attribute.ALL.getAttString();


    public static ArrayList<Person> personList = new ArrayList<>();

    public static void csvParse() {

        String[] csvLineArray = CSVdataset.csvDataset.split("\n");             //separate string by line

        for (int i = 1; i < csvLineArray.length; i++) {                   //loop through each row
            String[] rowArrays = csvLineArray[i].split(",");       //splits each row at commas

            Person person = new Person();

            person.setName(rowArrays[0]);                                          //names
            person.setAge(rowArrays[1]);                                           //ages
            person.setCity(rowArrays[2]);                                          //cities
            person.setState(rowArrays[3]);                                          //states
            person.setZipCode(rowArrays[4]);                                       //zips
            if (rowArrays.length > 5) {
                person.setIndustry(rowArrays[5]);                                   //industry
                if (rowArrays.length > 6) {
                    person.setSearching(rowArrays[6]);                              //searching?
                }
            }
            personList.add(person);                                    //creates new person in my Person arraylist
        }
    }

    public static String getMinMaxFreq(ArrayList<Person> personArray, String searchString, String minOrMax) {
        String returnValue = new String();
        HashMap<String, Integer> maxMap = getCount(personArray, searchString);

        if (minOrMax.equalsIgnoreCase("max")) {
            int maxValueHash = Collections.max(maxMap.values());       //determines the highest value in statecounts map
            for (Map.Entry<String, Integer> entry : maxMap.entrySet()) {
                if (entry.getValue() == maxValueHash) {          // compares each value against max value
                    returnValue = entry.getKey();               // add most populous state(s) to maxStates ArrayList
                }
            }
        } else if (minOrMax.equalsIgnoreCase("min")) {
            int minValueHash = Collections.min(maxMap.values());       //determines the highest value in statecounts map
            for (Map.Entry<String, Integer> entry : maxMap.entrySet()) {
                if (entry.getValue() == minValueHash) {          // compares each value against max value
                    returnValue = entry.getKey();               // add most populous state(s) to maxStates ArrayList
                }
            }
        }
        if (searchString.equalsIgnoreCase("age")) {
            System.out.println("***use minOrMaxAge method for oldest and youngest***");
        }
        return returnValue;
    }

    public static Person getMinOrMaxAge(ArrayList<Person> personArray, String maxOrMin) {
        int maxMinIndex = -1;
        ArrayList<Integer> ageArray = new ArrayList<>();
        for (int i = 0; i < personArray.size(); i++) {
            ageArray.add(personArray.get(i).getAge());
        }
        if (maxOrMin.equalsIgnoreCase("max")) {
            int ageMax = Collections.max(ageArray);
            maxMinIndex = ageArray.indexOf(ageMax);
        } else if (maxOrMin.equalsIgnoreCase("min")) {
            int ageMin = Collections.min(ageArray);
            maxMinIndex = ageArray.indexOf(ageMin);
        }
        return personArray.get(maxMinIndex);
    }

    public static HashMap<String, Integer> getCount(ArrayList<Person> personArray, String countString) {
        HashMap<String, Integer> mapCount = new HashMap<String, Integer>();

        for (int i = 0; i < personArray.size(); i++) {
            if (countString.equalsIgnoreCase("name")) {
                if (!mapCount.containsKey(personArray.get(i).getName())) {
                    mapCount.put(personArray.get(i).getName(), 1);
                } else {
                    mapCount.put(personArray.get(i).getName(), mapCount.get(personArray.get(i).getName()) + 1);
                }
            } else if (countString.equalsIgnoreCase("age")) {
                if (!mapCount.containsKey(Integer.toString(personArray.get(i).getAge()))) {
                    mapCount.put(Integer.toString(personArray.get(i).getAge()), 1);
                } else {
                    mapCount.put(Integer.toString(personArray.get(i).getAge()), mapCount.get(Integer.toString(personArray.get(i).getAge())) + 1);
                }
            } else if (countString.equalsIgnoreCase("city")) {
                if (!mapCount.containsKey(personArray.get(i).getCity())) {
                    mapCount.put(personArray.get(i).getCity(), 1);
                } else {
                    mapCount.put(personArray.get(i).getCity(), mapCount.get(personArray.get(i).getCity()) + 1);
                }
            } else if (countString.equalsIgnoreCase("state")) {
                if (!mapCount.containsKey(personArray.get(i).getState())) {
                    mapCount.put(personArray.get(i).getState(), 1);
                } else {
                    mapCount.put(personArray.get(i).getState(), mapCount.get(personArray.get(i).getState()) + 1);
                }
            } else if (countString.equalsIgnoreCase("zipcode")) {
                if (!mapCount.containsKey(Integer.toString(personArray.get(i).getZipCode()))) {
                    mapCount.put(Integer.toString(personArray.get(i).getZipCode()), 1);
                } else {
                    mapCount.put(Integer.toString(personArray.get(i).getZipCode()), mapCount.get(Integer.toString(personArray.get(i).getZipCode())) + 1);
                }
            } else if (countString.equalsIgnoreCase("industry")) {
                if (!mapCount.containsKey(personArray.get(i).getIndustry())) {
                    mapCount.put(personArray.get(i).getIndustry(), 1);
                } else {
                    mapCount.put(personArray.get(i).getIndustry(), mapCount.get(personArray.get(i).getIndustry()) + 1);
                }
            } else if (countString.equalsIgnoreCase("searching")) {
                if (!mapCount.containsKey(String.valueOf(personArray.get(i).getSearching()))) {
                    mapCount.put(String.valueOf(personArray.get(i).getSearching()), 1);
                } else {
                    mapCount.put(String.valueOf(personArray.get(i).getSearching()), mapCount.get(String.valueOf(personArray.get(i).getSearching())) + 1);
                }
            } else {
                System.out.println("error");
            }
        }
        return mapCount;
    }

    public static ArrayList<Person> filter(ArrayList<Person> personArray, Attribute filterKey, String searchString) { //method to create filtered arraylist
        ArrayList<Person> returnArray = new ArrayList<>(personArray);
        Predicate<Person> valueFilter = new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return false;
            }
        };
        switch (filterKey) {
            case NAME:
                valueFilter = person -> !person.getName().equalsIgnoreCase(searchString);
                break;
            case AGE:
                valueFilter = person -> !Integer.toString(person.getAge()).equalsIgnoreCase(searchString);
                break;
            case CITY:
                valueFilter = person -> !person.getCity().equalsIgnoreCase(searchString);
                break;
            case STATE:
                valueFilter = person -> !person.getState().equalsIgnoreCase(searchString);
                break;
            case ZIPCODE:
                valueFilter = person -> !Integer.toString(person.getZipCode()).equalsIgnoreCase(searchString);
                break;
            case INDUSTRY:
                valueFilter = person -> !person.getIndustry().equalsIgnoreCase(searchString);
                break;
            case SEARCHING:
                valueFilter = person -> !String.valueOf(person.getSearching()).equalsIgnoreCase(searchString);
                break;
            default:
                System.out.println("Please choose one of the categories: name, age, city, state, zipcode, industry, or searching");
                break;

        }

        returnArray.removeIf(valueFilter);
        return returnArray;
    }

    public static void transform(ArrayList<Person> personArray, Attribute transformKey) { //transforms an arraylist of people into just their values
        ArrayList<String> returnArray = new ArrayList<String>();
        for (int i = 0; i < personArray.size(); i++) {
            switch (transformKey) {
                case NAME:
                    returnArray.add(personArray.get(i).getName());
                    break;
                case AGE:
                    returnArray.add(Integer.toString(personArray.get(i).getAge()));
                    break;
                case CITY:
                    returnArray.add(personArray.get(i).getCity());
                    break;
                case STATE:
                    returnArray.add(personArray.get(i).getState());
                    break;
                case ZIPCODE:
                    returnArray.add(Integer.toString(personArray.get(i).getZipCode()));
                    break;
                case INDUSTRY:
                    returnArray.add(personArray.get(i).getName());
                    break;
                case SEARCHING:
                    returnArray.add(String.valueOf(personArray.get(i).getName()));
                    break;
                case ALL:
                    break;
                default:
                    System.out.println("Please enter a valid attribute to list by, or choose all.");
                    break;

            }
        }
        if (returnArray.size() != 0) {
            System.out.println(returnArray);
        }
        if (transformKey.equals(Attribute.ALL)) {
            System.out.println(personArray);
        }
    }

    public static void getPopulation(ArrayList<Person> personArray) {


        Scanner reader = new Scanner(System.in);
        System.out.println("Which attribute would you like to sort by? (name, age, city, state, zipcode, industry, searching)");
        String listValue = reader.nextLine();
        Attribute listAttribute = Attribute.valueOf(listValue.toUpperCase());
        System.out.println(getCount(personArray, listValue));
        System.out.println("Which value would you like to sort by? Choose a specific value from the list above");
        String categoryValue = reader.nextLine();
        System.out.println("Choose what attributes to list. (name, age, etc... or all)");
        String displayList = reader.nextLine();
        Attribute displayAttribute = Attribute.valueOf(displayList.toUpperCase());
        reader.close();

        transform(filter(personArray, listAttribute, categoryValue), displayAttribute);            //uses transform and filter methods
    }
}
