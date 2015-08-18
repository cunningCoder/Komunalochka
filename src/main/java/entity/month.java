package entity;

public class month {
    int id;
    String monthName;
    float rentSum;

    public month(int id, String name, float rentSum) {

    }

    public float getRentSum() {
        return rentSum;
    }

    public void setRentSum(float rentSum) {
        this.rentSum = rentSum;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

