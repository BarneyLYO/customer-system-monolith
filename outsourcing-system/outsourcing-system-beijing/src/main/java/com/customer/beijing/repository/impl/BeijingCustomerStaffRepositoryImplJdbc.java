package com.customer.beijing.repository.impl;

import com.customer.beijing.entity.BeijingCustomerStaff;
import com.customer.beijing.repository.BeijingCustomerStaffRepository;
import com.customer.beijing.utils.JdbcUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BeijingCustomerStaffRepositoryImplJdbc implements BeijingCustomerStaffRepository {

    private final DataSource dataSource;

    @Autowired
    public BeijingCustomerStaffRepositoryImplJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<BeijingCustomerStaff> findCustomerStaff() {
        List<BeijingCustomerStaff> staffs = new ArrayList<>();
        try {
            JdbcUtil.executeJdbcSql(
                    dataSource,
                    "select * from `beijing_customer_staff`",
                    preparedStatement -> {
                        ResultSet resultSet = preparedStatement.executeQuery();
                        return resultSet;
                    },
                    resultSet -> {
                        while (resultSet.next()) {
                            staffs.add(convertStaff(resultSet));
                        }
                    }
            );
        } catch (RuntimeException | SQLException re) {
            return staffs;
        }
        return staffs;
    }

    @Override
    public List<BeijingCustomerStaff> findCustomerStaffByUpdatedTime(Long updatedTime) {
        List<BeijingCustomerStaff> staffs = new ArrayList<>();
        try {
            JdbcUtil.executeJdbcSql(
                    dataSource,
                    "select * from `beijing_customer_staff` where updated_at > ?",
                    preparedStatement -> {
                        preparedStatement.setTimestamp(1, new Timestamp(updatedTime));
                        return preparedStatement.executeQuery();
                    },
                    resultSet -> {
                        if(resultSet.next()) {
                            staffs.add(convertStaff(resultSet));
                        }
                    }
            );
        } catch (RuntimeException | SQLException re) {
            return staffs;
        }
        return staffs;
    }

    @Override
    public Long createCustomerStaff(BeijingCustomerStaff customerStaff) {
        final Long[] rtn = {null};
        try{
            JdbcUtil.executeJdbcSql(
                    dataSource,
                    "INSERT INTO `beijing_customer_staff` (`nickname`,`gender`) VALUES (?,?)",
                    preparedStatement -> {
                        preparedStatement.setString(1, customerStaff.getNickname());
                        preparedStatement.setString(2, customerStaff.getGender());
                        return preparedStatement.getGeneratedKeys();
                    },
                    resultSet -> {
                        if(resultSet.next()) {
                            rtn[0] = Long.valueOf(resultSet.getInt(1));
                        }
                    }
            );
            return rtn[0];
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public Boolean updateCustomerStaff(BeijingCustomerStaff customerStaff) {
        return null;
    }

    @Override
    public Boolean deleteCustomerStaffById(Long id) {
        return null;
    }

    private BeijingCustomerStaff convertStaff(ResultSet resultSet) throws SQLException {
        BeijingCustomerStaff staff = new BeijingCustomerStaff();
        staff.setId(resultSet.getLong("id"));
        staff.setNickname(resultSet.getString("nickname"));
        staff.setGender(resultSet.getString("gender"));
        staff.setPhone(resultSet.getString("phone"));
        staff.setAvatar(resultSet.getString("avatar"));
        staff.setGoodAt(resultSet.getString("good_at"));
        staff.setRemark(resultSet.getString("remark"));
        return staff;

    }

}
