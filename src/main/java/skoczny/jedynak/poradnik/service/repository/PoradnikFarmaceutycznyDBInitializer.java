package skoczny.jedynak.poradnik.service.repository;

public class PoradnikFarmaceutycznyDBInitializer {

    public static void main(String[] args) {
        DBLoader loader = new DBLoader();
        loader.initMySQLDB();
        loader.initMSSQLDB();
        loader.initMongoDB();
    }
}
