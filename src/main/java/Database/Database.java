package Database;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

public class Database {
    private static final Database instance = new Database();

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

    public static Database getInstance() {
        return Database.instance;
    }

    public SqlSession openSession() {
        return this.sqlSessionFactory.openSession();
    }

    public SqlSession openSession(boolean b) {
        return this.sqlSessionFactory.openSession(b);
    }

    public SqlSession openSession(Connection connection) {
        return this.sqlSessionFactory.openSession(connection);
    }

    public SqlSession openSession(TransactionIsolationLevel transactionIsolationLevel) {
        return this.sqlSessionFactory.openSession(transactionIsolationLevel);
    }

    public SqlSession openSession(ExecutorType executorType) {
        return this.sqlSessionFactory.openSession(executorType);
    }

    public SqlSession openSession(ExecutorType executorType, boolean b) {
        return this.sqlSessionFactory.openSession(executorType, b);
    }

    public SqlSession openSession(ExecutorType executorType, TransactionIsolationLevel transactionIsolationLevel) {
        return this.sqlSessionFactory.openSession(executorType, transactionIsolationLevel);
    }

    public SqlSession openSession(ExecutorType executorType, Connection connection) {
        return this.sqlSessionFactory.openSession(executorType, connection);
    }

    public Configuration getConfiguration() {
        return this.sqlSessionFactory.getConfiguration();
    }
}
