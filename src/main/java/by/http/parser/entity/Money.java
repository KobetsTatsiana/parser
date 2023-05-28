package by.http.parser.entity;

import javax.persistence.*;

@Entity
@Table(name = "money")
public class Money {

    @Id
    @Column(name = "money_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    @Column(name = "moneyCount")
    public String moneyCount;
    @Column(name = "moneyName")
    public String moneyName;
    @Column(name = "moneyInfo")
    public String moneyInfo;
    @Column(name = "price")
    public String price;

    public Money(){}

    public Money(Integer id, String moneyCount, String moneyName, String moneyInfo, String price) {
        this.id = id;
        this.moneyCount = moneyCount;
        this.moneyName = moneyName;
        this.moneyInfo = moneyInfo;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMoneyCount() {
        return moneyCount;
    }

    public void setMoneyCount(String moneyCount) {
        this.moneyCount = moneyCount;
    }

    public String getMoneyName() {
        return moneyName;
    }

    public void setMoneyName(String moneyName) {
        this.moneyName = moneyName;
    }

    public String getMoneyInfo() {
        return moneyInfo;
    }

    public void setMoneyInfo(String moneyInfo) {
        this.moneyInfo = moneyInfo;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

