import java.util.ArrayList;
import java.util.Collections;

public class Person {
            // create these categories in for loop?
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

        String[] separateArray = secondCSV.split("\n");
        ArrayList<Person> objectArray = new ArrayList<>();

/*
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> ages = new ArrayList<>();
        ArrayList<String> cities = new ArrayList<>();
        ArrayList<String> states = new ArrayList<>();
        ArrayList<Integer> zips = new ArrayList<>();
        ArrayList<String> industries = new ArrayList<>();
        //ArrayList<String> searching = new ArrayList<>();


        for(int i = 1; i < separateArray.length - 1; i++){
            String[] rowArrays = separateArray[i].split(",");
            names.add(rowArrays[0]);
            ages.add(Integer.parseInt(rowArrays[1]));
            cities.add(rowArrays[2]);
            states.add(rowArrays[3]);
            zips.add(Integer.parseInt(rowArrays[4]));
            industries.add(rowArrays[5]);
            //searching.add(rowArrays[6]);
        }
*/
        for(int i = 1; i < separateArray.length - 1; i++) {
            String[] rowArrays = separateArray[i].split(",");
            objectArray.add(new Person(
                    rowArrays[0],
                    Integer.parseInt(rowArrays[1]),
                    rowArrays[2],
                    rowArrays[3],
                    Integer.parseInt(rowArrays[4]),
                    rowArrays[5]));
        }


       ArrayList<Integer> ageArray = new ArrayList<>();
        for(int i = 1; i < separateArray.length - 1; i++){
            ageArray.add(objectArray.get(i-1).getAge());
        }
       int ageMax = Collections.max(ageArray);
       int ageMin = Collections.min(ageArray);

System.out.println(ageMax + ageMin);
System.out.println(separateArray.length);
System.out.println(objectArray.get(1).getState()); //use a for loop to tally total numbers of each instance


        }
    }

