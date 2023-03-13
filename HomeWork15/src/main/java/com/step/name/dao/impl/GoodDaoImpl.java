package com.step.name.dao.impl;

import com.step.name.config.Connector;
import com.step.name.dao.GoodDao;
import com.step.name.model.Good;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GoodDaoImpl implements GoodDao {
    private static final Logger LOGGER = LogManager.getLogger(GoodDaoImpl.class);


    @Override
    public Optional<Good> getByTittle(String tittle) {
        Optional<Good> good = Optional.empty();
        try (Connection connection = Connector.createConnection()) {
            try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM GOODS WHERE TITTLE ='" + tittle + "'")) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    good = Optional.of(new Good(rs.getLong("ID"),
                            rs.getNString("TITTLE"),
                            rs.getBigDecimal("PRICE")));
                }
            }
        } catch (SQLException throwables) {
            LOGGER.error("SQLException in method getByTittle" + throwables);
        }
        return good;
    }

    @Override
    public Optional<Good> getById(long id) {
        Optional<Good> good = Optional.empty();
        try (Connection connection = Connector.createConnection()) {
            try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM GOODS WHERE ID =" + id)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    good = Optional.of(new Good(rs.getLong("ID"),
                            rs.getNString("TITTLE"),
                            rs.getBigDecimal("PRICE")));
                }
            }
        } catch (SQLException tes) {
            LOGGER.error("SQLException in method getID" + tes);
        }
        return good;
    }

    @Override
    public List<Good> getAll() {
        Good good = null;
        List<Good> goodList = new ArrayList<>();
        try (Connection connection = Connector.createConnection()) {
            try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM GOODS ")) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    good = new Good(rs.getLong("ID"),
                            rs.getNString("TITTLE"),
                            rs.getBigDecimal("PRICE"));
                    goodList.add(good);
                }
            }
        } catch (SQLException throwables) {
            LOGGER.error("SQLException in method getAll" + throwables);
        }
        return goodList;
    }
}
