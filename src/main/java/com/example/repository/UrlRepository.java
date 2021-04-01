package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Url;

/**
 * @author : Md. Mahadi Hasan Rabbi
 * @since : 30/03/2021
 */


@Repository
public interface UrlRepository extends JpaRepository<Url, Long>{
	
	public Url findByShortLink(String shortLink);
	
	@Query(value = "SELECT COUNT(*) FROM Url")
	String findTotalShortUrl();

}
