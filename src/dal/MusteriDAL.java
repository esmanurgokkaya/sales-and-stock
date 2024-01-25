package dal;

import Contract.KategoriContract;
import Contract.MusteriContract;
import core.ObjectHelper;
import interfaces.DALInterfaces;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MusteriDAL  extends ObjectHelper implements DALInterfaces<MusteriContract> {
    @Override
    public void Insert(MusteriContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Musteri (AdiSoyadi, Telefon, Adres, SehirId) VALUES ('"+entity.getAdiSoyadi()+"','"+entity.getTelefon()+"', '"+entity.getAdres()+"', "+entity.getSehirId()+" )");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public List<MusteriContract> GetAll() {
        List<MusteriContract> datacontract = new ArrayList<MusteriContract>();

        Connection connection = getConnection();
        MusteriContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Musteri");
            while (resultSet.next()){
                contract = new MusteriContract();
                contract.setId(resultSet.getInt("Id"));
                contract.setAdiSoyadi(resultSet.getString("Adi"));
                contract.setTelefon(resultSet.getString("Telefon"));
                contract.setAdres(resultSet.getString("Adres"));
                contract.setSehirId(resultSet.getInt("SehirId"));
                datacontract.add(contract);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  datacontract;
    }

    @Override
    public MusteriContract Delete(MusteriContract entity) {
        return null;
    }

    @Override
    public void Update(MusteriContract entity) {

    }

    @Override
    public List<MusteriContract> GetById(int id) {
        return null;
    }
}
