import java.util.*;
import java.util.function.Predicate;

public class Person {

    private String name;
    private int age;
    private String city;
    private String state;
    private int zipCode;
    private String industry;
    private boolean searching;


    //setters
    public void setName(String name) {
        if (name.length() == 0) {
            this.name = "unknown";
        } else if (name == null) {
            this.name = "unknown";
        } else {
            this.name = name;
        }
    }

    public void setAge(String age) {
        if (age.length() == 0) {
            this.age = 0;
        } else if (age == null) {
            this.age = 0;
        } else {
            this.age = Integer.parseInt(age);
        }
    }

    public void setCity(String city) {
        if (city.length() == 0) {
            this.city = "unknown";
        } else if (city == null) {
            this.city = "unknown";
        } else {
            this.city = city;
        }
    }

    public void setState(String state) {
        if (state.length() == 0) {
            this.state = "unknown";
        } else if (state == null) {
            this.state = "unknown";
        } else {
            this.state = state;
        }
    }

    public void setZipCode(String zipCode) {
        if (zipCode.length() == 0) {
            this.zipCode = 0;
        } else if (zipCode == null) {
            this.zipCode = 0;
        } else {
            this.zipCode = Integer.parseInt(zipCode);
        }
    }

    public void setIndustry(String industry) {
        if (industry.length() == 0) {
            this.industry = "unknown";
        } else if (industry == null) {
            this.industry = "unknown";
        } else {
            this.industry = industry;
        }
    }

    public void setSearching(String searching) {
        if (searching.length() == 0) {
            this.searching = false;
        } else if (searching == null) {
            this.searching = false;
        } else if (searching.equalsIgnoreCase("Yes")) {
            this.searching = true;
        } else {
            this.searching = false;
        }
    }

    //getters
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getIndustry() {
        return industry;
    }

    public Boolean getSearching() {
        return searching;
    }

    public String toString() {                                           //replaces the hashcode object output with my own. not scalable to new fields
        return "[" + name + "," + age + "," + city + "," + state + "," + zipCode + "," + industry + "," + searching + "]";
    }
    /*
        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", city='" + city + '\'' +
                    ", state='" + state + '\'' +
                    ", zipCode=" + zipCode +
                    ", industry='" + industry + '\'' +
                    ", searching=" + searching +
                    '}';
        }
    */

    public static String getMinMax(ArrayList<Person> personArray, String searchString, String minOrMax) {
        String returnValue = new String();
        Hashtable<String, Integer> maxMap = new Hashtable<>();

        for (int i = 0; i < personArray.size(); i++) {
            if (searchString.equalsIgnoreCase("name")) {
                if (!maxMap.containsKey(personArray.get(i).getName())) {
                    maxMap.put(personArray.get(i).getName(), 1);
                } else {
                    maxMap.put(personArray.get(i).getName(), maxMap.get(personArray.get(i).getName()) + 1);
                }
            } else if (searchString.equalsIgnoreCase("age")) {
                if (!maxMap.containsKey(Integer.toString(personArray.get(i).getAge()))) {
                    maxMap.put(Integer.toString(personArray.get(i).getAge()), 1);
                } else {
                    maxMap.put(Integer.toString(personArray.get(i).getAge()), maxMap.get(Integer.toString(personArray.get(i).getAge())) + 1);
                }
            } else if (searchString.equalsIgnoreCase("city")) {
                if (!maxMap.containsKey(personArray.get(i).getCity())) {
                    maxMap.put(personArray.get(i).getCity(), 1);
                } else {
                    maxMap.put(personArray.get(i).getCity(), maxMap.get(personArray.get(i).getCity()) + 1);
                }

            } else if (searchString.equalsIgnoreCase("state")) {
                if (!maxMap.containsKey(personArray.get(i).getState())) {
                    maxMap.put(personArray.get(i).getState(), 1);
                } else {
                    maxMap.put(personArray.get(i).getState(), maxMap.get(personArray.get(i).getState()) + 1);
                }
            } else if (searchString.equalsIgnoreCase("zipcode")) {
                if (!maxMap.containsKey(Integer.toString(personArray.get(i).getZipCode()))) {
                    maxMap.put(Integer.toString(personArray.get(i).getZipCode()), 1);
                } else {
                    maxMap.put(Integer.toString(personArray.get(i).getZipCode()), maxMap.get(Integer.toString(personArray.get(i).getZipCode())) + 1);
                }
            } else if (searchString.equalsIgnoreCase("industry")) {
                if (!maxMap.containsKey(personArray.get(i).getIndustry())) {
                    maxMap.put(personArray.get(i).getIndustry(), 1);
                } else {
                    maxMap.put(personArray.get(i).getIndustry(), maxMap.get(personArray.get(i).getIndustry()) + 1);
                }

            } else if (searchString.equalsIgnoreCase("searching")) {
                if (!maxMap.containsKey(String.valueOf(personArray.get(i).getSearching()))) {
                    maxMap.put(String.valueOf(personArray.get(i).getSearching()), 1);
                } else {
                    maxMap.put(String.valueOf(personArray.get(i).getSearching()), maxMap.get(String.valueOf(personArray.get(i).getSearching())) + 1);
                }
            } else {
                System.out.println("error");
            }
        }
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

    public static ArrayList<Person> filter(ArrayList<Person> personArray, String filterKey, String searchString) { //method to create filtered arraylist
        ArrayList<Person> returnArray = new ArrayList<>(personArray);
        Predicate<Person> valueFilter = new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return false;
            }
        };
        switch (filterKey) {
            case "name":
                valueFilter = person -> !person.getName().equalsIgnoreCase(searchString);
                break;
            case "age":
                valueFilter = person -> !Integer.toString(person.getAge()).equalsIgnoreCase(searchString);
                break;
            case "city":
                valueFilter = person -> !person.getCity().equalsIgnoreCase(searchString);
                break;
            case "state":
                valueFilter = person -> !person.getState().equalsIgnoreCase(searchString);
                break;
            case "zipcode":
                valueFilter = person -> !Integer.toString(person.getZipCode()).equalsIgnoreCase(searchString);
                break;
            case "industry":
                valueFilter = person -> !person.getIndustry().equalsIgnoreCase(searchString);
                break;
            case "searching":
                valueFilter = person -> !String.valueOf(person.getSearching()).equalsIgnoreCase(searchString);
                break;
            default:
                System.out.println("Please choose one of the categories: name, age, city, state, zipcode, industry, or searching");
                break;

        }

        returnArray.removeIf(valueFilter);
        return returnArray;
    }

    public static void transform(ArrayList<Person> personArray, String transformKey) { //transforms an arraylist of people into just their values
        ArrayList<String> returnArray = new ArrayList<String>();
        for (int i = 0; i < personArray.size(); i++) {
            switch (transformKey) {
                case "name":
                    returnArray.add(personArray.get(i).getName());
                    break;
                case "age":
                    returnArray.add(Integer.toString(personArray.get(i).getAge()));
                    break;
                case "city":
                    returnArray.add(personArray.get(i).getCity());
                    break;
                case "state":
                    returnArray.add(personArray.get(i).getState());
                    break;
                case "zipcode":
                    returnArray.add(Integer.toString(personArray.get(i).getZipCode()));
                    break;
                case "industry":
                    returnArray.add(personArray.get(i).getName());
                    break;
                case "searching":
                    returnArray.add(String.valueOf(personArray.get(i).getName()));
                    break;
                case "all":
                    break;
                default:
                    System.out.println("Please enter a valid attribute to list by, or choose all.");
                    break;

            }
        }
        if (returnArray.size() != 0) {
            System.out.println(returnArray);
        }
        if (transformKey.equalsIgnoreCase("all")) {
            System.out.println(personArray);
        }
    }

    public static void getPopulation(ArrayList<Person> personArray) {


        Scanner reader = new Scanner(System.in);
        System.out.println("Which attribute would you like to sort by? (name, age, city, state, zipcode, industry, searching)");
        String listValue = reader.nextLine();
        System.out.println(getCount(personArray, listValue));
        System.out.println("Which value would you like to sort by? Choose a specific value from the list above");
        String categoryValue = reader.nextLine();
        System.out.println("Choose what attributes to list. (name, age, etc... or all)");
        String displayList = reader.nextLine();
        reader.close();

        transform(filter(personArray, listValue, categoryValue), displayList);            //uses transrom and filter methods
    }
}


