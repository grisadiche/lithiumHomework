public class CSVobjects {

        private String name;
        private int age;
        private String city;
        private String state;
        private int zipCode;

        public CSVobjects(){
            name = "Andrew";
            age = 31;
            city = "Austin";
            state = "TX";
            zipCode = 78748;
        }

        //Constructor accepts and initializes the object with data in the main method (default)
        public CSVobjects(String n, int a, String c, String s, int z){
            name = n;
            age = a;
            city = c;
            state = s;
            zipCode = z;
        }

        // Accessors (getters)
        public String getName(){return name;}
        public int getAge(){return age;}
        public String getCity(){return city;}
        public String getState(){return state;}
        public int getZipCode(){return zipCode;}

        //setters (mutators)
        public void setName(String y){
            name = y;
        }
        public void setAge(int x){
            age = x;
        }
        public void setCity(String v){
            city = v;
        }
        public void setState(String b){
            state = b;
        }
        public void setZipCode(int p){
            zipCode = p;
        }

    public static void main(String[] args) {
        CSVobjects Andrew = new CSVobjects();
        Andrew.setName("Andrew");
        Andrew.getName();
        System.out.println(Andrew.name);


















    }

}

