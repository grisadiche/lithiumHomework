import java.util.ArrayList;

public class csvHomework {

   public static <string> void main(String[] args) {

    String myCSV = new String("Name,Age,City,State,Zip\n" +
            "John,23,Austin,TX,78730\n" +
            "Karen,22,Austin,TX,78730\n" +
            "Bob,35,San Francsico,CA,94501\n" +
            "Thomas,43,Austin,TX,78730\n" +
            "Jennifer,34,San Francsico,CA,94501\n" +
            "Lucy,55,Austin,TX,78730\n" +
            "Rob,23,San Francsico,CA,94501\n" +
            "Margaret,27,Austin,TX,78730\n" +
            "Mary,27,San Francsico,CA,94501\n" +
            "Mary,29,San Francsico,CA,94501\n" +
            "George,36,Austin,TX,78746\n" +
            "Michael,37,Austin,TX,78746\n" +
            "Larry,34,Austin,TX,78746\n" +
            "Brian,31,Austin,TX,78746\n" +
            "Elon,31,Austin,TX,78746\n" +
            "Robert,31,Austin,TX,78746\n" +
            "Bill,31,Austin,TX,78746\n" +
            "Emma,31,Austin,TX,78746\n" +
            "Liz,31,Austin,TX,78746");

         // counts the number of characters of certain types, to determine # of rows and columns
         char someChar1 = '\n';
         char someChar2 = ',';
         int char1Count = 0;
         int char2Count = 0;

         for (int i = 0; i < myCSV.length(); i++) {
             if (myCSV.charAt(i) == someChar1) {
                 char1Count++;
             } else if (myCSV.charAt(i) == someChar2) {
                 char2Count++;
             }
         }
//        System.out.println(char1Count + " " + char2Count);  // quick test - prints counts of the two characters

    String[] separatedArray = myCSV.split("\n"); // separates myCSV at each instance of "\n"
    String[] objectHeader = separatedArray[0].split(","); // captures the header row, need to create the below arrays with for loop

    ArrayList<String> firstNames = new ArrayList<>();
    ArrayList<String> age = new ArrayList<>();
    ArrayList<String> city = new ArrayList<>();
    ArrayList<String> state = new ArrayList<>();
    ArrayList<String> zipCode = new ArrayList<>();

    for (int i = 1; i < char1Count + 1; i++) {
        String [] superSeparateArray = separatedArray[i].split(","); //splits each array by row
        firstNames.add (superSeparateArray[0]);
        age.add (superSeparateArray[1]); // needs conversion to int array
        city.add (superSeparateArray[2]);
        state.add (superSeparateArray[3]);
        zipCode.add (superSeparateArray[4]); // needs conversion to int array

                }


       System.out.println(firstNames); //create method to determine most common
        System.out.println(age);       //same but for name of oldest and youngest person
                                       // use indexOf to match up ages and names?
             }
         }

//try to do all of this as single method that creates each person as their own object, regardless of input

