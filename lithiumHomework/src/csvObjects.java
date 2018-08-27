public class csvObjects {
            // create these categories in for loop?
        private String name;
        private int age; // create string and convert to int (use if statement to do automatically)
        private String city;
        private String state;
        private int zipCode; //same as age

        public csvObjects(){}

        //Constructor accepts and initializes the object with data in the main method (default)
        //create objects in for loop?
        public csvObjects(String n, int a, String c, String s, int z){
            name = n;
            age = a;
            city = c;
            state = s;
            zipCode = z;
        }

        //setters
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

        //getters
        public String getName(){return name;}
        public int getAge(){return age;}
        public String getCity(){return city;}
        public String getState(){return state;}
        public int getZipCode(){return zipCode;}


    public static void main(String[] args) {
        csvObjects Andrew = new csvObjects();
        Andrew.setName("Andrew");
        Andrew.getName();
        System.out.println(Andrew.name);
        System.out.println("update test 10:16");
    }

}

