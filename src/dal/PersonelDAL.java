package dal;

import Contract.KategoriContract;
import Contract.PersonelContract;
import core.ObjectHelper;
import interfaces.DALInterfaces;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonelDAL extends ObjectHelper implements DALInterfaces<PersonelContract> {
    @Override
    public void Insert(PersonelContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Personel (AdiSoyadi, Email) VALUES ('"+entity.getAdiSoyadi()+"','"+entity.getEmail()+"' )");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<PersonelContract> GetAll() {
        List<PersonelContract> datacontract = new ArrayList<PersonelContract>();

        Connection connection = getConnection();
        PersonelContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Personel");
            while (resultSet.next()){
                contract = new PersonelContract();
                contract.setId(resultSet.getInt("Id"));
                contract.setAdiSoyadi(resultSet.getString("AdiSoyadi"));
                contract.setEmail(resultSet.getString("Email"));

                datacontract.add(contract);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return datacontract;
    }

    @Override
    public PersonelContract Delete(PersonelContract entity) {
        return null;
    }

    @Override
    public void Update(PersonelContract entity) {

    }

    @Override
    public List<PersonelContract> GetById(int id) {
        return null;
    }
}
