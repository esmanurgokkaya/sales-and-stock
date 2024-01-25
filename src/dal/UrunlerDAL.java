package dal;

import Contract.UrunlerContract;
import core.ObjectHelper;
import interfaces.DALInterfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UrunlerDAL extends ObjectHelper implements DALInterfaces<UrunlerContract>  {
    @Override
    public void Insert(UrunlerContract entity) {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Urunler(Adi, KategoriId, Tarih, Fiyat) " +
                    "values ('"+entity.getAdi()+"', "+entity.getKategoriId()+",'"+entity.getTarih()+"',"+entity.getFiyat()+")");
            statement.close();
            connection.close();
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UrunlerContract> GetAll() {
        return null;
    }

    @Override
    public UrunlerContract Delete(UrunlerContract entity) {
        return null;
    }

    @Override
    public void Update(UrunlerContract entity) {

    }

    @Override
    public List<UrunlerContract> GetById(int id) {
        return null;
    }
}
