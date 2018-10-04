import java.util.*;
import java.util.Map.Entry;
import java.util.function.Predicate;

public class Person {

    private String name;
    private int age;
    private String city;
    private String state;
    private int zipCode;
    private String industry;
    private boolean searching;                     //add in boolean


    /*public Person(String name, int age, String city, String state, int zipCode, String industry, Boolean searching){
        this.name = name;
        this.age = age;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.industry = industry;
        this.searching = searching;
    }
*/
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
        } else if (searching == "Yes") {
            this.searching = true;
        } else {
            this.searching = false;
        }
    }

    public static ArrayList<String> nameArray = new ArrayList<>();
    public static ArrayList<String> ageArray = new ArrayList<>();
    public static ArrayList<String> cityArray = new ArrayList<>();
    public static ArrayList<String> stateArray = new ArrayList<>();
    public static ArrayList<String> zipCodeArray = new ArrayList<>();
    public static ArrayList<String> industryArray = new ArrayList<>();
    public static ArrayList<String> searchingArray = new ArrayList<>();

    public static void createDatabase(ArrayList<Person> masterArray) {
        for (int i = 0; i < masterArray.size(); i++) {
            nameArray.add(masterArray.get(i).getName());
            ageArray.add(Integer.toString(masterArray.get(i).getAge()));
            cityArray.add(masterArray.get(i).getCity());
            stateArray.add(masterArray.get(i).getState());
            zipCodeArray.add(Integer.toString(masterArray.get(i).getZipCode()));
            industryArray.add(masterArray.get(i).getIndustry());
            searchingArray.add(String.valueOf(masterArray.get(i).getSearching()));
        }
    }

    private static ArrayList<Person> filter(ArrayList<Person> personArray, String filterKey, String filterValue) {
        ArrayList<Person> returnArray = new ArrayList<>(personArray);
        Predicate<Person> valueFilter = new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return false;
            }
        };
        switch (filterKey) {
            case "name":
                valueFilter = person -> !person.getName().equalsIgnoreCase(filterValue);
                break;
            case "age":
                valueFilter = person -> !Integer.toString(person.getAge()).equalsIgnoreCase(filterValue);
                break;
            case "city":
                valueFilter = person -> !person.getCity().equalsIgnoreCase(filterValue);
                break;
            case "state":
                valueFilter = person -> !person.getState().equalsIgnoreCase(filterValue);
                break;
            case "zipCode":
                valueFilter = person -> !Integer.toString(person.getZipCode()).equalsIgnoreCase(filterValue);
                break;
            case "industry":
                valueFilter = person -> !person.getIndustry().equalsIgnoreCase(filterValue);
                break;
            case "searching":
                valueFilter = person -> !String.valueOf(person.getSearching()).equalsIgnoreCase(filterValue);
                break;
            default:
                System.out.println("Please choose one of the categories: name, age, city, state, zipcode, industry, or searching");
                break;

        }

        returnArray.removeIf(valueFilter);
        return returnArray;
    }

    public static void getPopulation(ArrayList<Person> personArray) {


        Scanner reader = new Scanner(System.in);
        System.out.println("Which value type would you like a list of? (name, age, city, state, zipcode, industry, searching)");
        String listValue = reader.nextLine();
        getCount(personArray, listValue);
        System.out.println("Which value would you like to sort by? Choose a specific value from the list above");
        String categoryValue = reader.nextLine();
        reader.close();

        System.out.println(filter(personArray, listValue, categoryValue));
    }

    public static void getCount(ArrayList<Person> personArray, String searchString) {
        HashMap<String, Integer> mapCount = new HashMap<String, Integer>();

        for (int i = 0; i < personArray.size(); i++) {
            if (searchString.equalsIgnoreCase("name")) {
                if (!mapCount.containsKey(nameArray.get(i))) {
                    mapCount.put(nameArray.get(i), 1);
                } else {
                    mapCount.put(nameArray.get(i), mapCount.get(nameArray.get(i)) + 1);
                }
            } else if (searchString.equalsIgnoreCase("age")) {
                if (!mapCount.containsKey(ageArray.get(i))) {
                    mapCount.put(ageArray.get(i), 1);
                } else {
                    mapCount.put(ageArray.get(i), mapCount.get(ageArray.get(i)) + 1);
                }
            } else if (searchString.equalsIgnoreCase("city")) {
                if (!mapCount.containsKey(cityArray.get(i))) {
                    mapCount.put(cityArray.get(i), 1);
                } else {
                    mapCount.put(cityArray.get(i), mapCount.get(cityArray.get(i)) + 1);
                }

            } else if (searchString.equalsIgnoreCase("state")) {
                if (!mapCount.containsKey(stateArray.get(i))) {
                    mapCount.put(stateArray.get(i), 1);
                } else {
                    mapCount.put(stateArray.get(i), mapCount.get(stateArray.get(i)) + 1);
                }
            } else if (searchString.equalsIgnoreCase("zipcode")) {
                if (!mapCount.containsKey(zipCodeArray.get(i))) {
                    mapCount.put(zipCodeArray.get(i), 1);
                } else {
                    mapCount.put(zipCodeArray.get(i), mapCount.get(zipCodeArray.get(i)) + 1);
                }
            } else if (searchString.equalsIgnoreCase("industry")) {
                if (!mapCount.containsKey(industryArray.get(i))) {
                    mapCount.put(industryArray.get(i), 1);
                } else {
                    mapCount.put(industryArray.get(i), mapCount.get(industryArray.get(i)) + 1);
                }

            } else if (searchString.equalsIgnoreCase("searching")) {
                if (!mapCount.containsKey(searchingArray.get(i))) {
                    mapCount.put(searchingArray.get(i), 1);
                } else {
                    mapCount.put(searchingArray.get(i), mapCount.get(searchingArray.get(i)) + 1);
                }
            } else {
                System.out.println("error");
            }
        }
        System.out.println(mapCount);
    }
/*
        for(int i = 0; i < objectArray.size(); i++) {
            states.add(objectArray.get(i).getState());                           //adds states from objects
            if (!stateCountMap.containsKey(states.get(i))) {                     //check for 1st instance
                stateCountMap.put(states.get(i), 1);                             //add to map with value 1
            } else {
                stateCountMap.put(states.get(i), stateCountMap.get(states.get(i)) + 1); //add one to count
            }
        }

    public void getList()
    //public void getCount(ArrayList){

    //}
*/

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
}


