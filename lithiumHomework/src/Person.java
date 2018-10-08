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
    public static ArrayList<String> nameArray = new ArrayList<>();
    public static ArrayList<String> ageArray = new ArrayList<>();
    public static ArrayList<String> cityArray = new ArrayList<>();
    public static ArrayList<String> stateArray = new ArrayList<>();
    public static ArrayList<String> zipCodeArray = new ArrayList<>();
    public static ArrayList<String> industryArray = new ArrayList<>();
    public static ArrayList<String> searchingArray = new ArrayList<>();

    public static void createDatabase(ArrayList<Person> personArray) {
        for (int i = 0; i < personArray.size(); i++) {
            nameArray.add(personArray.get(i).getName());
            ageArray.add(Integer.toString(personArray.get(i).getAge()));
            cityArray.add(personArray.get(i).getCity());
            stateArray.add(personArray.get(i).getState());
            zipCodeArray.add(Integer.toString(personArray.get(i).getZipCode()));
            industryArray.add(personArray.get(i).getIndustry());
            searchingArray.add(String.valueOf(personArray.get(i).getSearching()));
        }
    }

    public static String getMax (String maxKey) {
        String maxValue = new String();
        switch (maxKey) {
            case "name": maxValue = Collections.max(nameArray);
                break;
            case "age": maxValue = Collections.max(ageArray);
                break;
            case "city": maxValue = Collections.max(cityArray);
                break;
            case "state": maxValue = Collections.max(stateArray);
                break;
            case "zipcode": maxValue = Collections.max(zipCodeArray);
                break;
            case "industry": maxValue = Collections.max(industryArray);
                break;
            case "searching": maxValue = Collections.max(searchingArray);
                break;
        }
        return maxValue;
    }

    public static HashMap<String, Integer> getCount(ArrayList<Person> personArray, String searchString) {
        HashMap<String, Integer> mapCount = new HashMap<String, Integer>();

        for (int i = 0; i < personArray.size(); i++) {
            if (searchString.equalsIgnoreCase("name")) {
                if (!mapCount.containsKey(personArray.get(i).getName())) {
                    mapCount.put(personArray.get(i).getName(), 1);
                } else {
                    mapCount.put(personArray.get(i).getName(), mapCount.get(personArray.get(i).getName()) + 1);
                }
            } else if (searchString.equalsIgnoreCase("age")) {
                if (!mapCount.containsKey(Integer.toString(personArray.get(i).getAge()))) {
                    mapCount.put(Integer.toString(personArray.get(i).getAge()), 1);
                } else {
                    mapCount.put(Integer.toString(personArray.get(i).getAge()), mapCount.get(Integer.toString(personArray.get(i).getAge())) + 1);
                }
            } else if (searchString.equalsIgnoreCase("city")) {
                if (!mapCount.containsKey(personArray.get(i).getCity())) {
                    mapCount.put(personArray.get(i).getCity(), 1);
                } else {
                    mapCount.put(personArray.get(i).getCity(), mapCount.get(personArray.get(i).getCity()) + 1);
                }

            } else if (searchString.equalsIgnoreCase("state")) {
                if (!mapCount.containsKey(personArray.get(i).getState())) {
                    mapCount.put(personArray.get(i).getState(), 1);
                } else {
                    mapCount.put(personArray.get(i).getState(), mapCount.get(personArray.get(i).getState()) + 1);
                }
            } else if (searchString.equalsIgnoreCase("zipcode")) {
                if (!mapCount.containsKey(Integer.toString(personArray.get(i).getZipCode()))) {
                    mapCount.put(Integer.toString(personArray.get(i).getZipCode()), 1);
                } else {
                    mapCount.put(Integer.toString(personArray.get(i).getZipCode()), mapCount.get(Integer.toString(personArray.get(i).getZipCode())) + 1);
                }
            } else if (searchString.equalsIgnoreCase("industry")) {
                if (!mapCount.containsKey(personArray.get(i).getIndustry())) {
                    mapCount.put(personArray.get(i).getIndustry(), 1);
                } else {
                    mapCount.put(personArray.get(i).getIndustry(), mapCount.get(personArray.get(i).getIndustry()) + 1);
                }

            } else if (searchString.equalsIgnoreCase("searching")) {
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

    public static ArrayList<Person> filter(ArrayList<Person> personArray, String filterKey, String filterValue) { //method to create filtered arraylist
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
            case "zipcode":
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

    public static void transform (ArrayList<Person> personArray, String transformKey) { //transforms an arraylist of people into just their values
        ArrayList<String> returnArray = new ArrayList<String>();
        for(int i = 0; i < personArray.size(); i++) {
            switch (transformKey) {
                case "name": returnArray.add(personArray.get(i).getName());
                    break;
                case "age": returnArray.add(Integer.toString(personArray.get(i).getAge()));
                    break;
                case "city": returnArray.add(personArray.get(i).getCity());
                    break;
                case "state": returnArray.add(personArray.get(i).getState());
                    break;
                case "zipcode": returnArray.add(Integer.toString(personArray.get(i).getZipCode()));
                    break;
                case "industry": returnArray.add(personArray.get(i).getName());
                    break;
                case "searching": returnArray.add(String.valueOf(personArray.get(i).getName()));
                    break;
                case "all":
                    break;
                default: System.out.println("Please enter a valid attribute to list by, or choose all.");
                    break;

            }
        }
        if(returnArray.size() != 0) {
            System.out.println(returnArray);
        }
        if(transformKey.equalsIgnoreCase("all")) {
            System.out.println(personArray);
        }
    }

    public static void getPopulation(ArrayList<Person> personArray) {


        Scanner reader = new Scanner(System.in);
        System.out.println("Which value type would you like a list of? (name, age, city, state, zipcode, industry, searching)");
        String listValue = reader.nextLine();
        System.out.println(getCount(personArray, listValue));
        System.out.println("Which value would you like to sort by? Choose a specific value from the list above");
        String categoryValue = reader.nextLine();
        System.out.println("Choose what attributes to list. (name, age, etc... or all");
        String displayList = reader.nextLine();
        reader.close();

        transform(filter(personArray, listValue, categoryValue), displayList);            //uses transrom and filter methods
    }
}


