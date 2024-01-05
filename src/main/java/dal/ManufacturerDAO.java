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
            String sSql = "select * from `manufacturers`";
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
            String sSql = "select * from `manufacturers` where `manufacturerId` = ?";
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

	public void insert(Manufacturer c) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO `store2023`.`manufacturers`\r\n"
				+ "(`manufacturerId`,\r\n"
				+ "`manufacturerName`,\r\n"
				+ "`address`,\r\n"
				+ "`phoneNumber`)\r\n"
				+ "VALUES\r\n"
				+ "(?,?,?,?);";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setInt(1, c.getManufacturerId());
			ps.setString(2, c.getManufacturerName());
			ps.setString(3, c.getAddress());
			ps.setString(4, c.getPhoneNumber());

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(Manufacturer c ) {
		String sql = "UPDATE `store2023`.`manufacturers`\r\n"
				+ "SET\r\n"
				+ "`manufacturerName` = ?,\r\n"
				+ "`address` = ?,\r\n"
				+ "`phoneNumber` = ?\r\n"
				+ "WHERE `manufacturerId` = ?;";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, c.getManufacturerName());
			ps.setString(2, c.getAddress());
			ps.setString(3, c.getPhoneNumber());
			ps.setInt(4, c.getManufacturerId());

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		String sql = "DELETE FROM `store2023`.`manufacturers`\r\n"
				+ "WHERE `manufacturerId` =?;";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}