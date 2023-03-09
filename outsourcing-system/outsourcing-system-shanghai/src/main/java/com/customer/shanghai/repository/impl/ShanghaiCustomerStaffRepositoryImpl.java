package com.customer.shanghai.repository.impl;

import com.customer.shanghai.entity.ShanghaiCustomerStaff;
import com.customer.shanghai.repository.ShanghaiCustomerStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class ShanghaiCustomerStaffRepositoryImpl implements ShanghaiCustomerStaffRepository {
    public static ShanghaiCustomerStaff mapRowToStaff(ResultSet resultSet, int _rowNum) throws SQLException {
        ShanghaiCustomerStaff staff = new ShanghaiCustomerStaff();
        staff.setId(resultSet.getLong("id"));
        staff.setNickname(resultSet.getString("nickname"));
        staff.setGender(resultSet.getString("gender"));
        staff.setPhone(resultSet.getString("phone"));
        staff.setAvatar(resultSet.getString("avatar"));
        staff.setGoodAt(resultSet.getString("good_at"));
        staff.setRemark(resultSet.getString("remark"));
        return staff;
    }

    private final JdbcTemplate jdbcTemplate;

    private final SimpleJdbcInsert staffInserter;

    @Autowired
    public ShanghaiCustomerStaffRepositoryImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
        this.staffInserter =
                new SimpleJdbcInsert(jdbcTemplate)
                        .withTableName("shanghai_customer_staff")
                        .usingGeneratedKeyColumns("id");

    }


    @Override
    public List<ShanghaiCustomerStaff> findCustomerStaff() {
        return jdbcTemplate
                .query(
                        "SELECT * FROM `shanghai_customer_staff`",
                        ShanghaiCustomerStaffRepositoryImpl::mapRowToStaff
                );
    }

    @Override
    public List<ShanghaiCustomerStaff> findCustomerStaffByUpdatedTime(Long updatedTime) {
        return jdbcTemplate
                .query(
                        "SELECT * FROM `shanghai_customer_staff` WHERE `updated_at` > ?",
                        ShanghaiCustomerStaffRepositoryImpl::mapRowToStaff,
                        new java.sql.Timestamp(updatedTime)
                );
    }

    @Override
    public Long createCustomerStaff(ShanghaiCustomerStaff customerStaff) {
        return staffInserter
                .executeAndReturnKey(
                        Map.of(
                            "nickname", customerStaff.getNickname(),
                            "gender", customerStaff.getGender(),
                            "is_deleted", 0,
                            "created_at", new Date(),
                            "updated_at", new Date()
                        )
                ).longValue();
    }

    @Override
    public Boolean updateCustomerStaff(ShanghaiCustomerStaff customerStaff) {
        return null;
    }

    @Override
    public Boolean deleteCustomerStaffById(Long id) {
        return null;
    }
}
