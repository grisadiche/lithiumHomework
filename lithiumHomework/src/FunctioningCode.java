import java.util.ArrayList;

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

        System.out.println("The counts for each state are: ");
        System.out.println(Person.getCount(objectArray, "state"));
        System.out.println("The most populous state(s): ");
        System.out.println(Person.getMinMax(objectArray, "state", "max"));
        System.out.println("The following people reside in " + Person.getMinMax(objectArray, "state", "max") + ": ");
        Person.transform(Person.filter(objectArray, "state", Person.getMinMax(objectArray, "state", "max")), "name");
        //filters the arraylist to only those people in the max state, then transforms that list into just names.
        System.out.println("Zip codes by frequency: ");
        System.out.println(Person.getCount(objectArray, "zipcode"));
        System.out.println("The following cities are represented: ");
        System.out.println(Person.getCount(objectArray, "city").keySet()); //creates count hashmap, displays only keys

        System.out.println("The oldest person is: " + Person.getMinOrMaxAge(objectArray, "max"));
        System.out.println("The youngest person is: " + Person.getMinOrMaxAge(objectArray, "min"));
        System.out.println(Person.getCount(objectArray, "industry"));
        System.out.println(Person.getCount(objectArray, "state"));
        System.out.println(Person.getMinMax(objectArray, "state", "min"));
        Person.getPopulation(objectArray);

    }
}
