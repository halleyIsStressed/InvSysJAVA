package Database;

import lombok.Getter;
import lombok.experimental.Delegate;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Database {
    @Getter private static final Database instance = new Database();

    @Delegate(types=SqlSessionFactory.class)
    private final SqlSessionFactory sqlSessionFactory;

    private Database() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            System.out.println("Database instantiation error: " + e);
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
}
