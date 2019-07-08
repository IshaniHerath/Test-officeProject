package com.my.springboot.dao;

import java.sql.SQLException;
//Do the DB operations
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.my.springboot.model.Icecream;

@Repository
public class IcecreamDao {

	@Autowired // Spring will automatically assign the fields with the passed values
	private JdbcTemplate jdbcTemplate; // object of jdbc
	private static final String SQL1 = "select * from orders"; // set the query
	//private static final String SQL2 = "INSERT INTO orders(cname, name, price, qty, total) VALUES (:cname,:name,:price, :qty, :total)"; 
	//private static final String SQL2 = "INSERT INTO orders (id, name, price, qty, total, cname) VALUES (5, 'ice cream' ,400 , 2, 800, 'ishQuinn');" 
	private static final String SQL2 = "INSERT INTO orders (id, name, price, qty, total, cname) VALUES (:id, :name ,:price, :qty, :total, :cname)"; 

			
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	// To create new record
	public Icecream saveIcecream(Icecream icecream)  {
		
		KeyHolder holder = new GeneratedKeyHolder();
		
		SqlParameterSource parameters = new MapSqlParameterSource()
				.addValue("id", icecream.getid())
				.addValue("cname", icecream.getCName())
				.addValue("name", icecream.getName())
				.addValue("price", icecream.getPrice())
				.addValue("qty" , icecream.getQty())
				.addValue("total", icecream.getTotal());
				
				namedParameterJdbcTemplate.update(SQL2, parameters, holder);
				icecream.setid(holder.getKey().intValue());
				return icecream;
				
				
		//PreparedStatement pstmt = con.prepareStatement(SQL2);
		
		//pstmt.setInt(1, icecream.getid());
//		pstmt.setString(2, icecream.getCName());
//		pstmt.setString(3, icecream.getName());
//		pstmt.setInt(5, icecream.getPrice());
//		pstmt.setInt(6, icecream.getQty());
//		pstmt.setInt(7, icecream.getTotal());
//		
//		pstmt.executeUpdate();

	}
	
	
	
	// To view data
		public List<Icecream> getData() {

			List<Icecream> icecreams = new ArrayList<Icecream>();
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL1); // Set the query to a map

			// retrieve all the data in the DB from the customer table row by row
			for (Map<String, Object> row : rows) {
				Icecream icecream = new Icecream();
				icecream.setid((int) row.get("id"));
				icecream.setCName((String) row.get("cname"));
				icecream.setName((String) row.get("name"));
				icecream.setPrice((int) row.get("price"));
				icecream.setQty((int) row.get("qty"));
				icecream.setTotal((int) row.get("total"));

				icecreams.add(icecream);
			}
			return icecreams;
		}
	
}
