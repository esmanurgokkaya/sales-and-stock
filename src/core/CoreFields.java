package core;

public class CoreFields {
    private String userName = "postgres";
    private String password =  "12345";
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
