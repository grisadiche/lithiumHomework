import java.util.ArrayList;

public class CsvParse {

    public static ArrayList<Person> personList = new ArrayList<>();

    public static void parse() {

        String[] csvRows = CSVdataset.csvDataset.split("\n");             //separate string by line

        for (int i = 1; i < csvRows.length; i++) {                   //loop through each row

            String[] parsedRow = csvRows[i].split(",");       //splits each row at commas
            Person person = new Person();

            person.setName(parsedRow[0]);                                          //names
            person.setAge(parsedRow[1]);                                           //ages
            person.setCity(parsedRow[2]);                                          //cities
            person.setState(parsedRow[3]);                                          //states
            person.setZipCode(parsedRow[4]);                                       //zips
            if (parsedRow.length > 5) {
                person.setIndustry(parsedRow[5]);                                   //industry
                if (parsedRow.length > 6) {
                    person.setSearching(parsedRow[6]);                              //searching?
                }
            }
            personList.add(person);                                    //creates new person in my Person arraylist
        }
    }
}
