import java.util.*;

public class csvHomework {
    csvHomework(){}
    public int getMax (ArrayList <Integer> array){
        int max = 0;
        if (array.size() < 1){
            System.out.println("error, the array is empty");
            return 0;
        } else {
            max = Collections.max(array);
            return max;
        }
    }
    public int getMin (ArrayList <Integer> array){
        int min = 0;
        if (array.size() < 1){
            System.out.println("error, the array is empty");
            return 0;
        } else {
            min = Collections.min(array);
            return min;
        }
    }

    public int getChar (char charToLookFor, String string){
        int charCount = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == charToLookFor) {
                charCount++;
            }
        }
        return charCount;
    }

    // testing creating an arraylist of arraylists - need a specific output to make it useful

    public ArrayList<ArrayList<String>> parseString (String string) {
        ArrayList<ArrayList<String>> categories = new ArrayList<ArrayList<String>>();
        String [] lineArray = string.split("\n");
        String [] headerArray = lineArray[0].split(",");
        for (int i = 0; i < headerArray.length; i++){
            ArrayList<String> category = new ArrayList<String>();
            category.add(headerArray[i]);
            categories.add(category);
       //     for (int j = 0; j < lineArray.length; j++) {
       //         String[] rowArray = lineArray[j].split(",");
       //         category.add(rowArray[j]);
       //         }
            }
        return categories;
    }

    //public HashMap<String, Integer> freqCalc (ArrayList<String> array) {
    //    for(int i = 0; i < array.size(); i++) {
    //        String keyWord = array.get(i);
    //        int counter = 1;

          //  boolean stringExists = false;
          //  if(stringExists) {
          //      counter += 1;
          //  }

    //}

  public static void main(String[] args) {

      csvHomework csvAnalyzer = new csvHomework();

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

    System.out.println(csvAnalyzer.parseString(myCSV)); //tests the arraylist creator

    int char1Count = csvAnalyzer.getChar('\n', myCSV); //uses method to count characters
    int char2Count = csvAnalyzer.getChar(',', myCSV);

//    System.out.println(char1Count + " " + char2Count);  // quick test - prints counts of the two characters

    String[] separatedArray = myCSV.split("\n"); // separates myCSV at each instance of "\n"

    ArrayList<String> firstNames = new ArrayList<>();
    ArrayList<String> age = new ArrayList<>();
    ArrayList<Integer> ageInt = new ArrayList<>();
    ArrayList<String> city = new ArrayList<>();
    ArrayList<String> state = new ArrayList<>();
    ArrayList<String> zipCode = new ArrayList<>();
    ArrayList<Integer> zipCodeInt = new ArrayList<>();

    //fill out the above arrays
        for (int i = 1; i < char1Count + 1; i++) { //1 because I don't need the info in the header row
            String [] rowArray = separatedArray[i].split(","); //splits each array by row
            firstNames.add (rowArray[0]);
            age.add (rowArray[1]);
            city.add (rowArray[2]);
            state.add (rowArray[3]);
            zipCode.add (rowArray[4]);
        }

        for (int i = 0; i < char1Count; i++) {
            ageInt.add (Integer.parseInt(age.get(i)));
            zipCodeInt.add (Integer.parseInt(zipCode.get(i)));
        }



        System.out.println("The oldest person is " + firstNames.get(ageInt.indexOf(csvAnalyzer.getMax(ageInt))) + ", at " + csvAnalyzer.getMax(ageInt) + " years old.");
        System.out.println("The youngest person is " + firstNames.get(ageInt.indexOf(csvAnalyzer.getMin(ageInt))) + ", at " + csvAnalyzer.getMin(ageInt) + " years old.");


        // Most Common Name

        HashMap<String, Integer> freqTest = new HashMap<String, Integer>();
        HashMap<Integer, String> testFreq = new HashMap<Integer, String>();

      for(int i = 0; i < char1Count; i++) {
                String keyWord = firstNames.get(i);
                int counter = 1;
                if (freqTest.containsKey(firstNames.get(i))) {
                    counter++;
                }
                freqTest.put(keyWord, counter);
                testFreq.put(counter, keyWord);
            }

        //System.out.println(freqTest); checks the hashmap
        //System.out.println(testFreq); not reliable at all, but works for a unique max
        System.out.println(testFreq.get(Collections.max(freqTest.values())) + " is the most common name at " + Collections.max(freqTest.values()) + " times.");



        /* First Round of idea-ing

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


      int min;
      int max;
      int minIndex;
      int maxIndex;
      min = Collections.min(ageInt);
      max = Collections.max(ageInt);
      minIndex = ageInt.indexOf(min);
      maxIndex = ageInt.indexOf(max);

      System.out.println("The oldest person, " + firstNames.get(maxIndex) + ", is " + max + " years old.");
      System.out.println("The youngest person, " + firstNames.get(minIndex) + ", is " + min + " years old.");
*/
  }
}

