package maskAppointment.pojo;

public class Citizen {
    private String idNumber;
    private String name;
    private String phone;
    private int orderNum;
    private int lastRound;

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public int getLastRound() {
        return lastRound;
    }

    public void setLastRound(int lastRound) {
        this.lastRound = lastRound;
    }
}
