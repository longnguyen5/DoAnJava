package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Manufacturer;

public class ManufacturerDAO extends DBContext {
    public List<Manufacturer> getAllManufacturer() {
        List<Manufacturer> list = new ArrayList<>();
        try {
            String sSql = "select * from `manufacturer`";
            PreparedStatement ps = connection.prepareStatement(sSql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int manufacturerId = rs.getInt("manufacturerId");
                String manufacturerName = rs.getString("manufacturerName");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phoneNumber");
                Manufacturer m = new Manufacturer(manufacturerId, manufacturerName, address, phoneNumber);
                list.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Manufacturer getManufacturerById(int id) {
        try {
            String sSql = "select * from `manufacturer` where `id` = ?";
            PreparedStatement ps = connection.prepareStatement(sSql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String manufacturerName = rs.getString("manufacturerName");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phoneNumber");
                return new Manufacturer(id, manufacturerName, address, phoneNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}