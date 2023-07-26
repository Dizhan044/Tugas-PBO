package TES;

import java.util.List;
public class Customer {
	private String name;
    private String adress;
    private String phoneNumber;
    private List<String> orders;

    public Customer(String name, String adress, String phoneNumber, List<String> orders) {
        this.name = name;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void addOrder(String order, int price){
        orders.add(order);
    }

    public List<String> getOrders(){
        return orders;
    }
}
