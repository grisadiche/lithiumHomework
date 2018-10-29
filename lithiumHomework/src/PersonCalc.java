import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    }
    public static List<String> attributeList = Stream.of(Attribute.values())
            .map(Attribute::name)
            .collect(Collectors.toList());

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

    public static String getMinMaxFreq(ArrayList<Person> personArray, Attribute searchString, String minOrMax) {
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
        } else if (!minOrMax.equalsIgnoreCase("min") || !minOrMax.equalsIgnoreCase("max")) {
            System.out.println("***Min or Max not chosen, check getMinMaxFreq method.***");
        }
        if (searchString.equals(Attribute.AGE)) {
            System.out.println("***use minOrMaxAge method for oldest and youngest***");
        }
        return returnValue;
    }

    public static void getMinOrMaxAge(ArrayList<Person> personArray, String maxOrMin) {
        if (personArray.size() > 0) {
            ArrayList<Integer> ageArray = new ArrayList<>();
            for (int i = 0; i < personArray.size(); i++) {
                ageArray.add(personArray.get(i).getAge());
            }

            switch (maxOrMin.toUpperCase()) {
                case "MAX":
                    int ageMax = Collections.max(ageArray);
                    int maxIndex = 0;
                    maxIndex = ageArray.indexOf(ageMax);
                    System.out.println(personArray.get(maxIndex));
                    break;
                case "MIN":
                    int ageMin = Collections.min(ageArray);
                    int minIndex = 0;
                    minIndex = ageArray.indexOf(ageMin);
                    System.out.println(personArray.get(minIndex));
                    break;
                default:
                    System.out.println("***Min or Max not chosen, check getMinMaxAge method.***");
                    break;
            }
        } else {
            System.out.println("***The arraylist of persons is empty, check that csvParse is run***");
        }
    }

    public static HashMap<String, Integer> getCount(ArrayList<Person> personArray, Attribute countAttribute) {
        HashMap<String, Integer> mapCount = new HashMap<String, Integer>();

        for (int i = 0; i < personArray.size(); i++) {
            switch (countAttribute) {
                case NAME:
                    if (!mapCount.containsKey(personArray.get(i).getName())) {
                        mapCount.put(personArray.get(i).getName(), 1);
                    } else {
                        mapCount.put(personArray.get(i).getName(), mapCount.get(personArray.get(i).getName()) + 1);
                    }
                    break;
                case AGE:
                    if (!mapCount.containsKey(Integer.toString(personArray.get(i).getAge()))) {
                        mapCount.put(Integer.toString(personArray.get(i).getAge()), 1);
                    } else {
                        mapCount.put(Integer.toString(personArray.get(i).getAge()), mapCount.get(Integer.toString(personArray.get(i).getAge())) + 1);
                    }
                    break;
                case CITY:
                    if (!mapCount.containsKey(personArray.get(i).getCity())) {
                        mapCount.put(personArray.get(i).getCity(), 1);
                    } else {
                        mapCount.put(personArray.get(i).getCity(), mapCount.get(personArray.get(i).getCity()) + 1);
                    }
                    break;
                case STATE:
                    if (!mapCount.containsKey(personArray.get(i).getState())) {
                        mapCount.put(personArray.get(i).getState(), 1);
                    } else {
                        mapCount.put(personArray.get(i).getState(), mapCount.get(personArray.get(i).getState()) + 1);
                    }
                    break;
                case ZIPCODE:
                    if (!mapCount.containsKey(Integer.toString(personArray.get(i).getZipCode()))) {
                        mapCount.put(Integer.toString(personArray.get(i).getZipCode()), 1);
                    } else {
                        mapCount.put(Integer.toString(personArray.get(i).getZipCode()), mapCount.get(Integer.toString(personArray.get(i).getZipCode())) + 1);
                    }
                    break;
                case INDUSTRY:
                    if (!mapCount.containsKey(personArray.get(i).getIndustry())) {
                        mapCount.put(personArray.get(i).getIndustry(), 1);
                    } else {
                        mapCount.put(personArray.get(i).getIndustry(), mapCount.get(personArray.get(i).getIndustry()) + 1);
                    }
                    break;
                case SEARCHING:
                    if (!mapCount.containsKey(String.valueOf(personArray.get(i).getSearching()))) {
                        mapCount.put(String.valueOf(personArray.get(i).getSearching()), 1);
                    } else {
                        mapCount.put(String.valueOf(personArray.get(i).getSearching()), mapCount.get(String.valueOf(personArray.get(i).getSearching())) + 1);
                    }
                    break;
                default:
                    System.out.println("attribute not chosen for getCount method.");
                    break;
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
        if(!attributeList.contains(listValue.toUpperCase())) {
            System.out.println("\n\n***Please enter an attribute to sort by \n\n");
            getPopulation(personArray);
            return;
        }
        Attribute listAttribute = Attribute.valueOf(listValue.toUpperCase());

        System.out.println(getCount(personArray, listAttribute));
        System.out.println("Which value would you like to sort by? Choose a specific value from the list above");
        String categoryValue = reader.nextLine();
        if(categoryValue.length() == 0 || !getCount(personArray, listAttribute).keySet().toString().toUpperCase().contains(categoryValue.toUpperCase())) {
            System.out.println("\n\n***Please enter a value to sort by\n\n");
            getPopulation(personArray);
            return;
        }

        System.out.println("Choose what attributes to list. (name, age, etc... or all)");
        String displayList = reader.nextLine();
        if(!attributeList.contains(displayList.toUpperCase())) {
            System.out.println("\n\n***Please enter an attribute to list \n\n");
            getPopulation(personArray);
            return;
        }
        Attribute displayAttribute = Attribute.valueOf(displayList.toUpperCase());

        transform(filter(personArray, listAttribute, categoryValue), displayAttribute);            //uses transform and filter methods

        System.out.println("\n\nWould you like to search again? (Yes or No?)");
        String wantRestart = reader.nextLine();
        if(wantRestart.equalsIgnoreCase("yes")) {
            getPopulation(personArray);
        }

        reader.close();

    }
}
