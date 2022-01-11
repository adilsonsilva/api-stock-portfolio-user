package br.com.archtype.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import br.com.archtype.dao.UserDAO;
import br.com.archtype.dao.mapper.UserMapper;
import br.com.archtype.enumerated.OrderQueryEnum;
import br.com.archtype.model.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {

	private NamedParameterJdbcTemplate namedJdbcTemplate;

	@Autowired
	@Qualifier(value = "dataSource")
	private DataSource dataSource;

	@PostConstruct
	void setDataSource() {
		namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<Optional<User>> getAll(Integer sorting, Integer skip, Integer limit) {

		final SqlParameterSource namedParameters = new MapSqlParameterSource()
				.addValue("sorting", UserMapper.COLUMN_FULL_NAME.concat(" ").concat(OrderQueryEnum.getOrder(sorting)))
				.addValue("skip", skip).addValue("limit", limit);

		return namedJdbcTemplate.query(UserMapper.GET_USER_FIND_EMAIL_AND_ACTIVE, namedParameters, new UserMapper());
	}

	@Override
	public Optional<User> getUserId(Integer id) {

		final SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);

		return namedJdbcTemplate.queryForObject(UserMapper.GET_USER_BY_ID_IS_ACTIVE, namedParameters, new UserMapper());
	}

	@Override
	public Integer createUser(User user) {

		KeyHolder holder = new GeneratedKeyHolder();

		final SqlParameterSource namedParameters = new MapSqlParameterSource()
				.addValue("active", user.getActive())
				.addValue("cpf", user.getCpf())
				.addValue("email", user.getEmail())
				.addValue("fullName", user.getFullName())
				.addValue("password", user.getPassword())
				.addValue("resgistreDate", user.getRegistreDate())
				.addValue("surName", user.getSurName());

		namedJdbcTemplate.update(UserMapper.CREATE_USER, namedParameters, holder);

		return holder.getKeys().get(UserMapper.COLUMN_ID).hashCode();

	}

	@Override
	public void deleteUser(Integer id) {
	
		final SqlParameterSource namedParameters = new MapSqlParameterSource()
				.addValue("id", id)
				.addValue("active", Boolean.FALSE);
		
		namedJdbcTemplate.update(UserMapper.UDPATE_STATUS_USER, namedParameters);
		
	}
}
