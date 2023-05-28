package by.http.parser.service;

import by.http.parser.entity.Money;
import by.http.parser.repository.MoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoneyServiceImpl implements MoneyService{

    @Autowired
    MoneyRepository moneyRepository;

    @Override
    public void save(Money money) {
        moneyRepository.save(money);
    }

    @Override
    public boolean isExist(String moneyName) {
        List<Money> allMoney = moneyRepository.findAll();
        for (Money m: allMoney) {
            if (m.getMoneyName().equals(moneyName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Money> getAllMoney() {
        return moneyRepository.findAll();
    }

    public Money get(Integer id)
    {
       return moneyRepository.findById(id).get();
    }

    public void delete(Integer id)
    {
        moneyRepository.deleteById(id);
    }
}

