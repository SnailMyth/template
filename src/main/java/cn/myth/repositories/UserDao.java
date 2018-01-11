package cn.myth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cn.myth.data.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

	@Query("select b from User b where b.id=:id")
	public User getUserById(@Param("id") int id);

	@Query("select b from User b where b.username=:name")
	public User getUserByName(@Param("name") String name);

}
