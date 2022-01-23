package br.com.archtype.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import org.springframework.jdbc.core.RowMapper;

import br.com.archtype.model.entity.Domain;
import br.com.archtype.model.entity.User;

public class UserMapper implements RowMapper<Optional<User>> {

	public static final String COLUMN_ID = "id_user";
	public static final String COLUMN_FULL_NAME = "user_full_name";
	public static final String COLUMN_EMAIL = "email";
	public static final String COLUMN_CPF = "cpf";
	public static final String COLUMN_SUR_NAME = "user_surname";
	public static final String COLUMN_STATUS = "status";
	public static final String COLUMN_REGISTRE_DATE = "register_date";

	public static final String GET_USER_FIND_EMAIL_AND_ACTIVE = "SELECT id_user, user_full_name, user_surname, register_date, status, email, cpf "
			+ "FROM \"mStockUser\".user " 
			+ "WHERE status = true " 
			+ "ORDER BY :sorting "
			+ "OFFSET :skip " 
			+ "LIMIT :limit ";
	
	public static final String GET_USER_BY_ID_IS_ACTIVE = "SELECT id_user, user_full_name, user_surname, register_date, status, email, cpf "
					+ "FROM \"mStockUser\".user " 
					+ "WHERE id_user =:id "
					+ "AND status = true ";
	
	public static final String CREATE_USER = "INSERT INTO \"mStockUser\".user (user_full_name, user_surname, register_date, status, email, password, cpf) "
			+ "VALUES(:fullName, :surName, :resgistreDate, :active, :email, :password, :cpf)";
	
	public static final String UDPATE_STATUS_USER = "UPDATE \"mStockUser\".user SET status =:active WHERE id_user =:id ";
	
	public static final String GET_USER_BY_EMAIL_IS_ACTIVE = "SELECT id_user, user_full_name, user_surname, register_date, status, email, cpf "
			+ "FROM \"mStockUser\".user " 
			+ "WHERE email =:email "
			+ "AND status = true ";
	

	@Override
	public Optional<User> mapRow(ResultSet rs, int rowNum) throws SQLException {

		Date dateBase = rs.getTimestamp(COLUMN_REGISTRE_DATE);
		LocalDateTime date = dateBase.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

		User user = User.builder().cpf(rs.getString(COLUMN_CPF))
				.domain(Domain.builder()
						.id(rs.getInt(COLUMN_ID))
						.build())
				.email(rs.getString(COLUMN_EMAIL))
				.fullName(rs.getString(COLUMN_FULL_NAME))
				.registreDate(date)
				.surName(rs.getString(COLUMN_SUR_NAME))
				.active(rs.getBoolean(COLUMN_STATUS))
				.build();

		return Optional.of(user);
	}

}
