package by.http.parser.service;

import by.http.parser.entity.Money;

import java.util.List;

public interface MoneyService {
    public void save(Money money);
    public boolean isExist(String moneyName);
    public List<Money> getAllMoney();

    public  Money get(Integer id);

    public void delete(Integer id);
}
