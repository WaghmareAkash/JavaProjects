
public class Customer {

    private String name;
    private String cusId;
    private String contactNum;
    private String address;

    public Customer(String cusId, String name, String contactNum, String address) {
        this.cusId = cusId;
        this.name = name;
        this.contactNum= contactNum;
        this.address=address;
    }

    public String getName(){
        return name;

    }
    public String getCusId(){
        return cusId;
    }
    public String getContactNum(){
        return contactNum;
    }
    public String getAddress(){
        return address;
    }

    
}
