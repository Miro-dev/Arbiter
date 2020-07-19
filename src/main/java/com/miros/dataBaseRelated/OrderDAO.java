package com.miros.dataBaseRelated;

public class OrderDAO {
//
//	private StaticHelpers staticHelpers;
//
//	@Autowired
//	public OrderDAO(StaticHelpers staticHelpers) {
//		this.staticHelpers = staticHelpers;
//		System.out.println("OrderDAO created!");
//	}
//
//	public Order getOrder(int initNum) throws Exception {
//		return null;
//		// return Order
//	}
//
//	public void constructOrder(Order order) throws Exception {
//
//		// Check the values
//
//		// 1_id, 2_origin, 3_timestamp, 4_procedures, 5_dueDate, 6_materials,
//		// 7_timeOfCompletion, 8_price, 9_status, 10_importance // num=10
//		String query = "insert into Orders values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//		System.out.println("Connection on OrderDAO");
//		PreparedStatement pst = staticHelpers.getCon().prepareStatement(query);
//
//		order.getProcedures().toString();
//
////		(String name, String origin, ShipStyle shipStyle, List<Procedure> procedures, Timestamp timeStamp,
////				Timestamp dueDate)
//
//		pst.setInt(1, 0);
//		pst.setString(2, order.getOrigin());
//		pst.setTimestamp(3, order.getTimeStamp());
//		pst.setTimestamp(4, order.getTimeStamp());
//		pst.setString(5, order.getProcedures().toString());
//		pst.setTimestamp(6, order.getDueDate());
//		pst.setTimestamp(7, order.getTimeStamp());
//		pst.setInt(8, order.getPrice());
//		pst.setString(9, "DDD");
//		pst.setString(10, "GGG");
//		pst.setString(11, "AAA");
//		pst.setString(12, "SSS");
//		pst.setString(13, "KKK");
//
//		pst.executeUpdate();
//		pst.close();
//	}
//
//	public void deleteOrder(int OrderID) throws Exception {
//		String query = "delete from Orders where ID_Orders=?";
//		PreparedStatement pst = staticHelpers.getCon().prepareStatement(query);
//
//		pst.setInt(1, OrderID);
//
//		pst.executeUpdate();
//		pst.close();
//	}
}
