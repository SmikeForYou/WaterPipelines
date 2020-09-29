package com.github.waterpipelines.storage;

import com.github.waterpipelines.models.PipeModel;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    private Statement statement;
    private Connection conn;

    //     (idX int NOT NULL, idY int NOT NULL, distance int NOT NULL, CONSTRAINT UC_Points (idX, idY))
    public DBManager(Connection conn) throws SQLException {
        this.conn = conn;
        this.statement = conn.createStatement();

    }

    public void Init() throws SQLException {
        this.statement.execute("CREATE TABLE IF NOT EXISTS WaterPipelines (idX varchar(255) NOT NULL, idY varchar(255) NOT NULL, distance int NOT NULL)");
    }

    public void Clean() throws SQLException {
        this.statement.execute("DELETE FROM WaterPipelines WHERE *");
    }

    public void Insert(PipeModel model) throws SQLException {
        String q = "insert into WaterPipelines values(?, ?, ?)";
        PreparedStatement st = conn.prepareStatement(q);
        st.setString(1, model.getIdX());
        st.setString(2, model.getIdY());
        st.setString(3, String.valueOf(model.getDistance()));
        st.execute();
    }

    public ArrayList<PipeModel> GetPipelines() throws SQLException {
        ArrayList<PipeModel> res = new ArrayList<>(0);
        ResultSet cursor;
        cursor = this.statement.executeQuery("SELECT * FROM WaterPipelines");
        while (cursor.next()) {
            PipeModel model = new PipeModel();
            model.setIdX(cursor.getString("idX"));
            model.setIdY(cursor.getString("idY"));
            model.setDistance(cursor.getInt("distance"));
            res.add(model);
        }
        return res;
    }


    public void Drop() throws SQLException {
        this.statement.execute("DROP TABLE IF EXISTS WaterPipelines");
    }
}
