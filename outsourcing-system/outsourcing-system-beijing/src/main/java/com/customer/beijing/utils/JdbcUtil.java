package com.customer.beijing.utils;

import javax.sql.DataSource;
import java.sql.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class JdbcUtil {
    @FunctionalInterface
    public static interface RuntimeExeceptionFunction<In, Out> extends Function<In, Out> {
        @Override
        default Out apply(In in) {
            try {
                return handle(in);
            } catch (Throwable t) {
                throw new RuntimeException(t);
            }
        }

        Out handle(In in) throws SQLException;
    }

    @FunctionalInterface
    public static interface RuntimeExceptionConsumer<In> extends Consumer<In> {
        @Override
        default void accept(In in) {
            try {
                handle(in);
            } catch (Throwable t) {
                throw new RuntimeException(t);
            }
        }

        void handle(In in) throws SQLException;
    }

    public static void executeJdbcSql(
            DataSource dataSource,
            String sql,
            RuntimeExeceptionFunction<PreparedStatement, ResultSet> createResultSet,
            RuntimeExceptionConsumer<ResultSet> onResult
    ) throws SQLException {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = createResultSet.apply(statement)
        ) {
            onResult.accept(resultSet);
        }
    }


}
