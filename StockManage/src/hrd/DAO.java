package hrd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	 private static Connection getCon() throws Exception{
	        Class.forName("oracle.jdbc.OracleDriver");
	        Connection con = DriverManager.getConnection
	                          ("jdbc:oracle:thin:@//localhost:1521/xe", "loginboard", "hkit2019");
	        System.out.println("DB연결");
	        return con;
	    }
	    
	    private static void close(Connection con, PreparedStatement ps, ResultSet rs) {
	    	if(rs != null) {
	    		try {	rs.close();} catch (SQLException e) {
					e.printStackTrace();
				}
	    	}
	    	
	    	if(ps != null) {
	    		try { ps.close(); } catch (SQLException e) {
					e.printStackTrace();
				}
	    	}
	    	
	    	if(con != null) {
	    		try { con.close(); } catch (SQLException e) {
					e.printStackTrace();
				}
	    	}
	    }
	    
	    //판매 상품 리스트
	    public static List<ProductVo> selectProductList() {
	    	List<ProductVo> list = new ArrayList();
	    	Connection con = null;
	    	PreparedStatement ps = null;
	    	ResultSet rs = null;
	    	
	    	String sql = " select * from t_product "; 
	    	try {
				con = getCon();
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) {
					int p_no = rs.getInt("p_no");
					String p_name = rs.getString("p_name");
					int p_cnt_sum = rs.getInt("p_cnt_sum"); 
					int p_cnt_rem = rs.getInt("p_cnt_rem");					
					int p_price = rs.getInt("p_price");
					
					ProductVo vo = new ProductVo();
					vo.setP_no(p_no);
					vo.setP_name(p_name);
					vo.setP_cnt_sum(p_cnt_sum);
					vo.setP_cnt_rem(p_cnt_rem);
					vo.setP_price(p_price);
					
					list.add(vo);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(con, ps, rs);
			}
	    	
	    	return list;
	    }
	    
	    //상품 정보 (1개)
	    public static ProductVo getProduct(int p_no) {
	    	ProductVo vo = new ProductVo();
	    	Connection con = null;
	    	PreparedStatement ps = null;
	    	ResultSet rs = null;
	    	
	    	String sql = " select * from t_product where p_no = ? ";
	    	
	    	try {
				con = getCon();
				ps = con.prepareStatement(sql);
				ps.setInt(1, p_no);
				rs = ps.executeQuery();
				while(rs.next()) {					
					String p_name = rs.getString("p_name");
					int p_cnt_sum = rs.getInt("p_cnt_sum"); 
					int p_cnt_rem = rs.getInt("p_cnt_rem");					
					int p_price = rs.getInt("p_price");
					
					vo.setP_no(p_no);
					vo.setP_name(p_name);
					vo.setP_cnt_sum(p_cnt_sum);
					vo.setP_cnt_rem(p_cnt_rem);
					vo.setP_price(p_price);
				}
			} catch (Exception e) {				
				e.printStackTrace();
			} finally {
				close(con, ps, rs);
			}
	    	
	    	return vo;
	    }
	    
	    
	    //상품  등록
	    public static void insertProduct(ProductVo vo) {
	    	Connection con = null;
	    	PreparedStatement ps = null;	    	
	    	
	    	String sql = " insert into t_product (p_no, p_name, p_price)"
	    			+ " select nvl(max(p_no), 0) + 1, ?, ? from t_product ";
	    		    	
	    	try {
				con = getCon();
				ps = con.prepareStatement(sql);
				ps.setString(1, vo.getP_name());
				ps.setInt(2, vo.getP_price());
				ps.execute();
				
			} catch (Exception e) {				
				e.printStackTrace();
			} finally {
				close(con, ps, null);
			}
	    	
	    }
	    
	    //상품  수정
	    public static void updateProduct(ProductVo vo) {
	    	Connection con = null;
	    	PreparedStatement ps = null;	    	
	    	
	    	String sql = " update t_product set p_name = ?"
	    			+ " , p_price = ?"
	    			+ " where p_no = ? ";
	    		    	
	    	try {
				con = getCon();
				ps = con.prepareStatement(sql);
				ps.setString(1, vo.getP_name());
				ps.setInt(2, vo.getP_price());
				ps.setInt(3, vo.getP_no());
				ps.execute();
				
			} catch (Exception e) {				
				e.printStackTrace();
			} finally {
				close(con, ps, null);
			}
	    	
	    }
	    
	    public static int regProductIm(int p_no, int i_cnt) {
	    	int result = 0;
	    	Connection con = null;
	    	PreparedStatement ps = null;	 
	    	
	    	String sql = " insert into t_import (i_no, p_no, i_cnt)"
	    			+ " select nvl(max(i_no), 0) + 1, ?, ? FROM t_import ";
	    	
	    	try {
				con = getCon();
				ps = con.prepareStatement(sql);
				ps.setInt(1, p_no);
				ps.setInt(2,  i_cnt);
				result = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(con, ps, null);
			}
			
	    	return result;
	    }
	    
	    public static void updateProductStock(int p_no, int i_cnt) {
	    	Connection con = null;
	    	PreparedStatement ps = null;	 
	    	
	    	String sql = " update t_product"
	    			+ " set p_cnt_sum = p_cnt_sum + ? "
	    			+ " , p_cnt_rem = p_cnt_rem + ? "
	    			+ " where p_no = ? ";
	    	
	    	try {
				con = getCon();
				ps = con.prepareStatement(sql);
				ps.setInt(1,  i_cnt);
				ps.setInt(2,  i_cnt);
				ps.setInt(3,  p_no);
				ps.execute();
				
			} catch (Exception e) {				
				e.printStackTrace();
			} finally {
				close(con, ps, null);
			}
	    }
	    
	    public static void productDel(int p_no) {
	    	Connection con = null;
	    	PreparedStatement ps = null;	 
	    	
	    	String sql = " delete from t_product where p_no = ? ";
	    	
	    	try {
				con = getCon();
				ps = con.prepareStatement(sql);
				ps.setInt(1, p_no);
				ps.execute();				
			} catch (Exception e) {			
				e.printStackTrace();
			} finally {
				close(con, ps, null);
			}
	    }
}














