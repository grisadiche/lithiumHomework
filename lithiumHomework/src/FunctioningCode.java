public class FunctioningCode {

    public static void main(String[] args) {


        PersonCalc.csvParse();                                  //parses the csv so we can use the personList

        System.out.println("The counts for each state are: " +
                PersonCalc.getCount(PersonCalc.personList, "state"));

        System.out.println("The most populous state(s): " +
                PersonCalc.getMinMaxFreq(PersonCalc.personList, "state", "max"));

        System.out.println("The following people reside in " + PersonCalc.getMinMaxFreq(PersonCalc.personList, "state", "max") + ": ");
        PersonCalc.transform(PersonCalc.filter(PersonCalc.personList, "state", PersonCalc.getMinMaxFreq(PersonCalc.personList, "state", "max")), "name");
                    //filters the arraylist to only those people in the max state, then transforms that list into just names.

        System.out.println("Zip codes by frequency: " +
                PersonCalc.getCount(PersonCalc.personList, "zipcode"));

        System.out.println("The following cities are represented: " +
                PersonCalc.getCount(PersonCalc.personList, "city").keySet());                //creates count hashmap, displays only keys

        System.out.println("The oldest person is: " + PersonCalc.getMinOrMaxAge(PersonCalc.personList, "max"));

        System.out.println("The youngest person is: " + PersonCalc.getMinOrMaxAge(PersonCalc.personList, "min"));

        System.out.println(PersonCalc.getCount(PersonCalc.personList, "industry"));

        System.out.println(PersonCalc.getCount(PersonCalc.personList, "state"));

        System.out.println(PersonCalc.getMinMaxFreq(PersonCalc.personList, "state", "min"));

        PersonCalc.getPopulation(PersonCalc.personList);

    }
}
