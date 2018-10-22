import javax.naming.Name;

public class FunctioningCode {



    public static void main(String[] args) {



        PersonCalc.csvParse();                                  //parses the csv so we can use the personList

        System.out.println("The counts for each state are: " +
                PersonCalc.getCount(PersonCalc.personList, PersonCalc.Attribute.STATE));

        System.out.println("The most populous state(s): " +
                PersonCalc.getMinMaxFreq(PersonCalc.personList, PersonCalc.Attribute.STATE, "max"));

        System.out.println("The following people reside in " + PersonCalc.getMinMaxFreq(PersonCalc.personList, PersonCalc.Attribute.STATE, "max") + ": ");
        PersonCalc.transform(PersonCalc.filter(PersonCalc.personList, PersonCalc.Attribute.STATE, PersonCalc.getMinMaxFreq(PersonCalc.personList, PersonCalc.Attribute.STATE, "max")), PersonCalc.Attribute.NAME);
                    //filters the arraylist to only those people in the max state, then transforms that list into just names.

        System.out.println("Zip codes by frequency: " +
                PersonCalc.getCount(PersonCalc.personList, PersonCalc.Attribute.ZIPCODE));

        System.out.println("The following cities are represented: " +
                PersonCalc.getCount(PersonCalc.personList, PersonCalc.Attribute.CITY).keySet());                //creates count hashmap, displays only keys

        System.out.println("The oldest person is: " + PersonCalc.getMinOrMaxAge(PersonCalc.personList, "max"));

        System.out.println("The youngest person is: " + PersonCalc.getMinOrMaxAge(PersonCalc.personList, "min"));

        System.out.println("The number of people in each industry: " +
                PersonCalc.getCount(PersonCalc.personList, PersonCalc.Attribute.INDUSTRY));

        System.out.println("The number of people in each state: " +
                PersonCalc.getCount(PersonCalc.personList, PersonCalc.Attribute.STATE));

        System.out.println("The state with the least people represented is: " +
                PersonCalc.getMinMaxFreq(PersonCalc.personList, PersonCalc.Attribute.STATE, "min"));

        PersonCalc.getPopulation(PersonCalc.personList);

    }
}
