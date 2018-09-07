import java.util.ArrayList;

public class Person {
            // create these categories in for loop?
        private String name;
        private int age; // create string and convert to int (use if statement to do automatically)
        private String city;
        private String state;
        private int zipCode; //same as age
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
    public String getName(){return name;}
    public int getAge(){return age;}
    public String getCity(){return city;}
    public String getState(){return state;}
    public int getZipCode(){return zipCode;}
    public String getIndustry(){return industry;}
    //public String getSearching(){return searching;}

    //setters
    public void setName(String n){name = n;}
    public void setAge(int a){age = a;}
    public void setCity(String c){city = c;}
    public void setState(String s){state = s;}
    public void setZipCode(int z){zipCode = z;}
    public void setIndustry(String i){industry = i;}
    //public void setSearching(String q){searching = q;}


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
        ArrayList<Object> objectArray = new ArrayList<>();

/*
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<String> city = new ArrayList<>();
        ArrayList<String> state = new ArrayList<>();
        ArrayList<Integer> zip = new ArrayList<>();
        ArrayList<String> industry = new ArrayList<>();
        //ArrayList<String> searching = new ArrayList<>();


        for(int i = 1; i < separateArray.length - 1; i++){
            String[] rowArrays = separateArray[i].split(",");
            names.add(rowArrays[0]);
            age.add(Integer.parseInt(rowArrays[1]));
            city.add(rowArrays[2]);
            state.add(rowArrays[3]);
            zip.add(Integer.parseInt(rowArrays[4]));
            industry.add(rowArrays[5]);
            //searching.add(rowArrays[6]);
        }
*/
        for(int i = 1; i < separateArray.length - 1; i++){
            String[] rowArrays = separateArray[i].split(",");
            objectArray.add(new Person(
                    rowArrays[0],
                    Integer.parseInt(rowArrays[1]),
                    rowArrays[2],
                    rowArrays[3],
                    Integer.parseInt(rowArrays[4]),
                    rowArrays[5]));
            }


        System.out.println(objectArray.get(0));
        //Person Andrew = new Person();
        //Andrew.setName("Andrew");
        System.out.println("update test 10:16");
    }
}

