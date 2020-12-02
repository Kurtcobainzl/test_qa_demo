package learn.bean;

public class User {

    private String id;
    private String employeeId;
    private int age;
    private String address;
    private CustomeInfo customeInfo;

    public CustomeInfo getCustomeInfo() {
        return customeInfo;
    }

    public void setCustomeInfo(CustomeInfo customeInfo) {
        this.customeInfo = customeInfo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getEmployeeId() {
        return employeeId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", customeInfo=" + customeInfo +
                '}';
    }

  public   class CustomeInfo{
        public String  customerId;

        @Override
        public String toString() {
            return "CustomeInfo{" +
                    "customerId='" + customerId + '\'' +
                    '}';
        }
    }

}