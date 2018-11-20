public class FunctioningCode {

    public static void main(String[] args) {
        
        CsvParse.parse();                                  //parses the csv so we can use the personList

        System.out.println("The counts for each state are: " +
                PersonCalc.getCount(CsvParse.personList, PersonCalc.Attribute.STATE));
        String maxState = PersonCalc.getMinMaxFreq(CsvParse.personList, PersonCalc.Attribute.STATE, "max");
        System.out.println("The most populous state(s): " + maxState);
        System.out.println("The following people reside in " + maxState);
        PersonCalc.transform(PersonCalc.filter(CsvParse.personList, PersonCalc.Attribute.STATE, maxState), PersonCalc.Attribute.NAME);
                    //filters the arraylist to only those people in the max state, then transforms that list into just names.

        System.out.println("Zip codes by frequency: " +
                PersonCalc.getCount(CsvParse.personList, PersonCalc.Attribute.ZIPCODE));

        System.out.println("The following cities are represented: " +
                PersonCalc.getCount(CsvParse.personList, PersonCalc.Attribute.CITY).keySet());                //creates count hashmap, displays only keys

        Person youngestPerson = PersonCalc.getMinOrMaxAge(CsvParse.personList, "max");
        System.out.println("The oldest person is: " + youngestPerson);

        Person oldestPerson = PersonCalc.getMinOrMaxAge(CsvParse.personList, "min");
        System.out.println("The youngest person is: " + oldestPerson);

        System.out.println("The number of people in each industry: " +
                PersonCalc.getCount(CsvParse.personList, PersonCalc.Attribute.INDUSTRY));

        System.out.println("The number of people in each state: " +
                PersonCalc.getCount(CsvParse.personList, PersonCalc.Attribute.STATE));

        System.out.println("The state with the least people represented is: " +
                PersonCalc.getMinMaxFreq(CsvParse.personList, PersonCalc.Attribute.STATE, "min"));

        PersonCalc.getPopulation(CsvParse.personList);

    }
}
