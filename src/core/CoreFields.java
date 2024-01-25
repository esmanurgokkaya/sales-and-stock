package core;

public class CoreFields {
    private String userName = "kullanici_adi";
    private String password =  "kullanici_sifre";
    private String url = "jdbc:postgresql://localhost:5432/SatisveStok"; // link ekle

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }


}
