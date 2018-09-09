import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class Person {

        private String name;
        private int age;
        private String city;
        private String state;
        private int zipCode;
        private String industry;
        //private boolean searching;                     //add in boolean


    public Person(String name, int age, String city, String state, int zipCode, String industry){
        this.name = name;
        this.age = age;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.industry = industry;
    }  // removed ,boolean searching


    //getters
    public String getName(){return this.name;}
    public int getAge(){return age;}
    public String getCity(){return city;}
    public String getState(){return state;}
    public int getZipCode(){return zipCode;}
    public String getIndustry(){return industry;}
    //public String getSearching(){return searching;}



    public static void main(String[] args) {
        String secondCSV = ("Name,Age,City,State,Zip,Industry,Job Searching?\n" +
                "John,23,Austin,TX,78730,Software,Yes\n" +
                "Karen,22,Austin,TX,78730,Finance,No\n" +
                "Bob,35,San Francsico,CA,94501,Finance,Yes\n" +
                "Thomas,43,Austin,TX,78730,Software, \n" +
                "Jennifer,34,San Francsico,CA,94501,Finance,No\n" +
                "Lucy,55,Austin,TX,78730,Software,No\n" +
                "Rob,23,San Francsico,CA,94501, ,No\n" +
                "Margaret,27,Austin,TX,78730,Finance,\n" +
                "John,66,Dallas,TX,75001, , \n" +
                "Mary,27,San Francsico,CA,94501,Accounting, \n" +
                "Mary,29,San Francsico,CA,94501,Software,No\n" +
                "George,36,Austin,TX,78746,Software, \n" +
                "Michael,37,Austin,TX,78746,HR,Yes\n" +
                "Larry,34,Austin,TX,78746,Finance,Yes\n" +
                "Brian,31,Austin,TX,78746, , \n" +
                "Elon,31,Austin,TX,78746, , \n" +
                "Robert,31,Austin,TX,78746,Finance,Yes\n" +
                "Bill,31,Austin,TX,78746,Finance, \n" +
                "Emma,31,Austin,TX,78746,Finance,Yes\n" +
                "Liz,31,Austin,TX,78746, ,No\n" +
                "Ronald,43,Dallas,TX,75001,HR,No\n" +
                "Rebecca,35,Houston,TX,77473,Finance, ");

        String[] separateArray = secondCSV.split("\n");             //separate string by line
        ArrayList<Person> objectArray = new ArrayList<>();                //new arraylist of Person objects

        for(int i = 1; i < separateArray.length; i++) {
            String[] rowArrays = separateArray[i].split(",");       //splits each row at comma (adjust for nulls)
            objectArray.add(new Person(                                    //creates new person in my Person arraylist
                    rowArrays[0],                                          //names
                    Integer.parseInt(rowArrays[1]),                        //ages
                    rowArrays[2],                                          //cities
                    rowArrays[3],                                          //states
                    Integer.parseInt(rowArrays[4]),                        //zips
                    rowArrays[5]));                                        //industry
        }

        HashMap<String, Integer> stateCountMap = new HashMap<String, Integer>(); //new hashmap for state counts
        ArrayList<String> states = new ArrayList<>();                            //new arraylist of states
        for(int i = 0; i < separateArray.length - 1; i++) {
            states.add(objectArray.get(i).getState());                           //adds states from objects
            if (!stateCountMap.containsKey(states.get(i))) {                     //check for 1st instance
                stateCountMap.put(states.get(i), 1);                             //add to map with value 1
            } else {
                stateCountMap.put(states.get(i), stateCountMap.get(states.get(i)) + 1); //add one to count
            }
        }

        int maxValueStates = Collections.max(stateCountMap.values());       //determines the highest value in statecounts map
        ArrayList<String> maxStates = new ArrayList<>();                    //a list in case there are multiple maxes
        for (Entry<String, Integer> entry : stateCountMap.entrySet()) {
            if (entry.getValue()==maxValueStates) {          // compares each value against max value
                maxStates.add(entry.getKey());               // add most populous state(s) to maxStates ArrayList
            }
        }

        ArrayList<String> maxStatePop = new ArrayList<>();              //max state population list
        for (int i = 0; i < separateArray.length - 1; i++) {
            if(maxStates.contains(objectArray.get(i).getState())) {     //looks for states in maxStates array
                maxStatePop.add(objectArray.get(i).getName());          //adds the name for each from that state
            }
        }

        System.out.println("The counts for each state are: " + stateCountMap);
        System.out.println("The most populous state(s): " + maxStates);
        System.out.println("The following people reside in " + maxStates + ": " + maxStatePop);



        HashMap<Integer, Integer> zipCountMap = new HashMap<Integer, Integer>();        //same as above for zips
        ArrayList<Integer> zips = new ArrayList<>();                                    //create method?
        for(int i = 0; i < separateArray.length - 1; i++) {
            zips.add(objectArray.get(i).getZipCode());
            if (!zipCountMap.containsKey(zips.get(i))) {
                zipCountMap.put(zips.get(i), 1);
            } else {
                zipCountMap.put(zips.get(i), zipCountMap.get(zips.get(i)) + 1);
            }
        }

        System.out.println("Zip codes by frequency: " + zipCountMap);

        HashMap<String, Integer> cityCountMap = new HashMap<String, Integer>();         // same but for cities
        ArrayList<String> cities = new ArrayList<>();                                   // make a method
        for(int i = 0; i < separateArray.length - 1; i++) {
            cities.add(objectArray.get(i).getCity());
            if (!cityCountMap.containsKey(cities.get(i))) {
                cityCountMap.put(cities.get(i), 1);
            } else {
                cityCountMap.put(cities.get(i), cityCountMap.get(cities.get(i)) + 1);
            }
        }

        System.out.println("The following cities are represented: " + cityCountMap.keySet());


       ArrayList<Integer> ageArray = new ArrayList<>();
        for(int i = 1; i < separateArray.length - 1; i++){
            ageArray.add(objectArray.get(i-1).getAge());
        }
       int ageMax = Collections.max(ageArray);
       int ageMaxIndex = ageArray.indexOf(ageMax);
       int ageMin = Collections.min(ageArray);
       int ageMinIndex = ageArray.indexOf(ageMin);

System.out.println("The oldest person is: " + separateArray[ageMaxIndex + 1]);
System.out.println("The youngest person is: " + separateArray[ageMinIndex + 1]);

        }
    }

