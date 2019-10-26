import lombok.var;
import org.hibernate.SQLQuery;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.hibernate.transform.Transformers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Map;

public class test {
    public static void main(String [] args){
//        Map<String, Object> properties = new HashMap<String, Object>();
//        properties.put(AvailableSettings.DRIVER, org.postgresql.Driver.class);
//        properties.put(AvailableSettings.URL, "jdbc:postgresql://127.0.0.1:5432/testaa");
//        properties.put(AvailableSettings.USER, "testaa");
//        properties.put(AvailableSettings.PASS, "password");
//        properties.put(AvailableSettings.DEFAULT_CATALOG, "testaa");
//        properties.put(AvailableSettings.DIALECT, org.hibernate.dialect.PostgreSQL95Dialect.class);
//

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("aa");
        EntityManager em = entityManagerFactory.createEntityManager();
        var query =em.createNativeQuery("select * from figdxmzd2019 ");
        NativeQueryImpl nativeQuery=query.unwrap(NativeQueryImpl.class);
        nativeQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        var ret = query.getResultList();



       // NativeQueryImpl nativeQuery = (NativeQueryImpl) query;

        List<Map<String,Object>> result = query.getResultList();
        Map<String, Object> row = result.get(0);

        System.out.println("hehe");

    }

}
