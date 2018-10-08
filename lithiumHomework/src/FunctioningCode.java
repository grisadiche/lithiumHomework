import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FunctioningCode {

    public static void main(String[] args) {

        String[] separateArray = CSVdataset.csvDataset.split("\n");             //separate string by line
        ArrayList<Person> objectArray = new ArrayList<>();                //new arraylist of Person objects
        String[] fixedLengthRowArray = new String[7];                    //fixed length array to handle missing data

        for (int i = 1; i < separateArray.length; i++) {                   //loop through each row
            String[] rowArrays = separateArray[i].split(",");       //splits each row at commas

            for (int j = 0; j < rowArrays.length; j++) {                     //loop through length of row
                fixedLengthRowArray[j] = rowArrays[j];                      //adds data to fixed length array
            }
            objectArray.add(new Person());                                    //creates new person in my Person arraylist
            objectArray.get(i - 1).setName(fixedLengthRowArray[0]);                                          //names
            objectArray.get(i - 1).setAge(fixedLengthRowArray[1]);                                           //ages
            objectArray.get(i - 1).setCity(fixedLengthRowArray[2]);                                          //cities
            objectArray.get(i - 1).setState(fixedLengthRowArray[3]);                                          //states
            objectArray.get(i - 1).setZipCode(fixedLengthRowArray[4]);                                       //zips
            objectArray.get(i - 1).setIndustry(fixedLengthRowArray[5]);                                       //industry
            objectArray.get(i - 1).setSearching(fixedLengthRowArray[6]);                                    //searching?
        }

        Person.createDatabase(objectArray);

        HashMap<String, Integer> stateCountMap = new HashMap<String, Integer>(); //new hashmap for state counts
        ArrayList<String> states = new ArrayList<>();                            //new arraylist of states
        for(int i = 0; i < objectArray.size(); i++) {
            states.add(objectArray.get(i).getState());                           //adds states from objects
            if (!stateCountMap.containsKey(states.get(i))) {                     //check for 1st instance
                stateCountMap.put(states.get(i), 1);                             //add to map with value 1
            } else {
                stateCountMap.put(states.get(i), stateCountMap.get(states.get(i)) + 1); //add one to count
            }
        }

        int maxValueStates = Collections.max(stateCountMap.values());       //determines the highest value in statecounts map
        ArrayList<String> maxStates = new ArrayList<>();                    //a list in case there are multiple maxes
        for (Map.Entry<String, Integer> entry : stateCountMap.entrySet()) {
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
        for(int i = 0; i < objectArray.size(); i++) {
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
        for(int i = 0; i < objectArray.size(); i++) {
            cities.add(objectArray.get(i).getCity());
            if (!cityCountMap.containsKey(cities.get(i))) {
                cityCountMap.put(cities.get(i), 1);
            } else {
                cityCountMap.put(cities.get(i), cityCountMap.get(cities.get(i)) + 1);
            }
        }

        System.out.println("The following cities are represented: " + cityCountMap.keySet());


        ArrayList<Integer> ageArray = new ArrayList<>();
        for(int i = 0; i < objectArray.size(); i++){
            ageArray.add(objectArray.get(i).getAge());
        }
        int ageMax = Collections.max(ageArray);
        int ageMaxIndex = ageArray.indexOf(ageMax);
        int ageMin = Collections.min(ageArray);
        int ageMinIndex = ageArray.indexOf(ageMin);

        System.out.println("The oldest person is: " + objectArray.get(ageMaxIndex));
        System.out.println("The youngest person is: " + objectArray.get(ageMinIndex));
        //Person.getCount(objectArray,"industry");
        Person.getPopulation(objectArray);


    }
}
