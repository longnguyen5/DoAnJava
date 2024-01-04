package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cover;

public class CoverDAO extends DBContext{
	public List<Cover> getAllCover(){
		List<Cover> list = new ArrayList<>();
		String sql = "Select * from `covers`";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int coverId = rs.getInt("coverId"); 
				String coverName = rs.getString("coverName");
				String description = rs.getString("description");
				String link = rs.getString("link");
				int status = rs.getInt("status");
				Cover c = new Cover(coverId, coverName, description, link, status);
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public Cover getCoverById(int id) {
		String sql = "Select * from `covers` where `coverId` = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String coverName = rs.getString("coverName");
				String description = rs.getString("description");
				String link = rs.getString("link");
				int status = rs.getInt("status");
				Cover c = new Cover(id, coverName, description, link, status);
				return c;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Cover getCoverbyStatus() {
		String sql = "SELECT *\r\n"
				+ "FROM covers\r\n"
				+ "WHERE status = 1\r\n"
				+ "LIMIT 1;";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int coverId = rs.getInt("coverId");
				String coverName = rs.getString("coverName");
				String description = rs.getString("description");
				String link = rs.getString("link");
				int status = rs.getInt("status");
				Cover c = new Cover(coverId, coverName, description, link, status);
				return c;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void insert(Cover c) {
		String sql = "insert into `covers` values (?,?,?,?,?) ";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, c.getCoverId());
			ps.setString(2, c.getCoverName());
			ps.setString(3, c.getDescription());
			ps.setString(4, c.getLink());
			ps.setInt(5, c.getStatus());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(Cover c) {
		String sql = "UPDATE `covers` SET\r\n"
				+ "`coverName` = ?,\r\n"
				+ "`description` = ?,\r\n"
				+ "`link` = ?,\r\n"
				+ "`status` = ?\r\n"
				+ "WHERE `coverId` = ?;";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, c.getCoverName());
			ps.setString(2, c.getDescription());
			ps.setString(3, c.getLink());
			ps.setInt(4, c.getStatus());
			ps.setInt(5, c.getCoverId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		String sql = "DELETE FROM `covers`\r\n"
				+ "WHERE `coverId` = ?;";
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








