import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Users extends Names {
    private String firstName;
    private String lastNane;
    private String city;
    private Integer age;
    private Integer height;
    private boolean gender; // True is male. False is female
    private ArrayList<String> interests;
    
        public Users(String firstName, String lastName, String city, Integer age, Integer height, boolean gender,ArrayList<String> interest) {
            this.firstName = firstName;
            this.lastNane = lastName;
            this.city = city;
            this.age = age;
            this.height = height;
            this.gender = gender;
            this.interests = interest;
        }
    
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
    
        public String getFirstName() {
            return this.firstName;
        }
    
        public void setLastName(String lastNane) {
            this.lastNane = lastNane;
        }
    
        public String getLastName() {
            return this.lastNane;
        }
    
        public void setCity(String city) {
            this.city = city;
        }
    
        public String getCity() {
            return this.city;
        }
    
        public void setAge(Integer age) {
            this.age = age;
        }
    
        public int getAge() {
            return this.age;
        }
    
        public void setHeight(Integer height) {
            this.height = height;
        }
    
        public int getHeight() {
            return this.height;
        }
    
        public void setGender(boolean gender) {
            this.gender = gender;
        }
    
        public boolean getGender(){
            return this.gender;
        }
    
        public ArrayList<String> addInterest(String userInterest){ // needs work
            List<String> list = Arrays.asList(Names.getInterests());
            if (list.contains(userInterest)) {
                this.interests.add(userInterest);  
                System.out.println("Interest "+ userInterest + " added sucessfully" );
                return interests;
            }
            System.out.println("Interest cannot be added.");
            return interests;
        }
    
        public ArrayList<String> removeInterest(String interest) {
            this.interests.removeIf(i -> i.equals(interest));
            return interests;
        }
    
        public ArrayList<String> getInterestsArrayList() {
            return this.interests;
    }

    public String toString() {
    return "FirstName : " + firstName + " " + "\n" + "LastName: " + lastNane + ""
    + "\n" +
    "From : " + city + " " + "\n"+ "Age: " + age + " " + "\n" + "Height: " +
    height + " " + "\n" + "Gender: " + gender + "\n" + "Interests: " + interests.toString() ;
    }

    
    public String printFullName() {
        return firstName + " " + lastNane;
    }

    public static void main(String[] args) {

    }
}
