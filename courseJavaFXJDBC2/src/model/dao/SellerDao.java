package model.dao;

import java.util.List;

import model.entities.Department;
import model.entities.Seller;

public interface SellerDao {

	void insert(Seller vendor);
	void update(Seller vendor);
	void deleteById (Integer id);
	Seller findById(Integer id);
	List<Seller> findByDepartment(Department depto);
	List<Seller> findAll();
}
