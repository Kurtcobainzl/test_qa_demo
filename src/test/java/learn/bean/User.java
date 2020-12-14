package learn.bean;

public class User {

    private String id;
    private String filedName;
    private String requiredStatusName;
    private String agreementId;
    private String address;
    private CustomeInfo customeInfo;

    public CustomeInfo getCustomeInfo() {
        return customeInfo;
    }

    public void setCustomeInfo(CustomeInfo customeInfo) {
        this.customeInfo = customeInfo;
    }

    public String getrequiredStatusName() {
        return requiredStatusName;
    }

    public void setrequiredStatusName(String activeStatusName) {
        this.requiredStatusName = activeStatusName;
    }

    public String getFiledName() {
        return filedName;
    }

    public void setFiledName(String filedName) {
        this.filedName = filedName;
    }

    public String getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
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
        return filedName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", filedName='" + filedName + '\'' +
                ", activeStatusName=" + requiredStatusName +
                ", agreementId=" + agreementId +
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