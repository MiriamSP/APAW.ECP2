package voting.rest.data.models.daos;

public abstract class DaoFactory {
    
    public static DaoFactory factory = null;

    public static void setFactory(DaoFactory factory) {
        DaoFactory.factory = factory;
    }

    public static DaoFactory getFactory() {
        assert factory != null;
        return factory;
    }

    public abstract Entity1Dao getEntity1Dao();

    public abstract Entity2Dao getEntity2Dao();

}
