package dal;

import Contract.KategoriContract;
import core.ObjectHelper;
import interfaces.DALInterfaces;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KategoriDAL extends ObjectHelper implements DALInterfaces<KategoriContract> {


    @Override
    public void Insert(KategoriContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Kategori (Adi, ParentId) VALUES ('"+entity.getAdi()+"',"+entity.getParentId()+" )");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<KategoriContract> GetAll() {
        List<KategoriContract> datacontract = new ArrayList<KategoriContract>();

        Connection connection = getConnection();
        KategoriContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Kategori");
            while (resultSet.next()){
                contract = new KategoriContract();
                contract.setId(resultSet.getInt("Id"));
                contract.setAdi(resultSet.getString("Adi"));
                contract.setParentId(resultSet.getInt("ParentId"));

                datacontract.add(contract);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  datacontract;
    }
    public List<KategoriContract> GetAllParentId(){
        List<KategoriContract> datacontract = new ArrayList<KategoriContract>();

        Connection connection = getConnection();
        KategoriContract contract;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Kategori WHERE parentId = 0 ");
            while (resultSet.next()){
                contract = new KategoriContract();
                contract.setId(resultSet.getInt("Id"));
                contract.setAdi(resultSet.getString("Adi"));
                contract.setParentId(resultSet.getInt("ParentId"));

                datacontract.add(contract);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  datacontract;
    }

    @Override
    public KategoriContract Delete(KategoriContract entity) {
        return null;
    }

    @Override
    public void Update(KategoriContract entity) {

    }

    @Override
    public List<KategoriContract> GetById(int id) {
        return null;
    }
}
