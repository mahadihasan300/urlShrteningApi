package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.ClickedInformation;

/**
 * @author : Md. Mahadi Hasan Rabbi
 * @since : 30/03/2021
 */

@Repository
public interface ClickedInformationRepository extends JpaRepository<ClickedInformation, String>{

}
