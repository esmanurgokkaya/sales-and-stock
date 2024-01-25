package dal;

import Contract.AccountsContract;
import core.ObjectHelper;
import interfaces.DALInterfaces;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountsDAL extends ObjectHelper implements DALInterfaces<AccountsContract> {
    @Override
    public void Insert(AccountsContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Accounts (YetkiId,PersonelId, Sifre ) VALUES ("+entity.getYetkiId()+","+entity.getPersonelId()+", "+entity.getSifre()+" )");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public AccountsContract GetPersonelIdVeSifre(int personelId, String sifre){
        AccountsContract contract = new AccountsContract();
        List<AccountsContract> list = new ArrayList<AccountsContract>();
        Connection connection = getConnection();
        try {
            Statement sorgu = connection.createStatement();
            ResultSet rs = sorgu.executeQuery("Select * from accounts  " +
                    "WHERE PersonelId = "+personelId+" AND Sifre = '"+sifre.trim()+"'");

            while (rs.next()){
                contract.setId(rs.getInt("Id"));
                contract.setPersonelId(rs.getInt("PersonelId"));
                contract.setSifre(rs.getString("Sifre"));
                contract.setYetkiId(rs.getInt("YetkiId"));
            }
        }
        catch (SQLException e){
        System.out.println(e);
        }
        return contract;
    }
    @Override
    public List<AccountsContract> GetAll() {
        return null;
    }

    @Override
    public AccountsContract Delete(AccountsContract entity) {
        return null;
    }

    @Override
    public void Update(AccountsContract entity) {

    }

    @Override
    public List<AccountsContract> GetById(int id) {
        return null;
    }
}
