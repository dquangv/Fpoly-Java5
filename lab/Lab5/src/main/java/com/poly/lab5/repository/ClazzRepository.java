package com.poly.lab5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.lab5.entity.Clazz;

public interface ClazzRepository extends JpaRepository<Clazz, Long>{
	@Query(value="SELECT c from Clazz c where c.name like ?1")
	List<Clazz> findClazzByName(String name);
	
	@Query(value = "SELECT c FROM Clazz c WHERE c.numberOfStudents BETWEEN ?1 AND ?2")
    List<Clazz> findClazzByNumberOfStudentsBetween(int minStudents, int maxStudents);
	
	@Query(value = "SELECT * FROM clazz WHERE semester = :semester", nativeQuery = true)
    List<Clazz> findClazzBySemester(@Param("semester") String semester);
	
	@Query(name="findByNameAndSemester")
	List<Clazz> findClazzByNameAndSemester(@Param("name") String name, @Param("semester") String semester);
}
