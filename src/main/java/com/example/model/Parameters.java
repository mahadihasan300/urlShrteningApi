package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author : Md. Mahadi Hasan Rabbi
 * @since : 30/03/2021
 */

@Entity
public class Parameters {

	@Id
    @GeneratedValue
    private long id;
    private String parameter1;
    private String paremeter2;

    public Parameters() {
    }

    public Parameters(long id, String parameter1, String paremeter2) {
		this.id = id;
		this.parameter1 = parameter1;
		this.paremeter2 = paremeter2;
	}

    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getParameter1() {
        return parameter1;
    }

    public void setParameter1(String parameter1) {
        this.parameter1 = parameter1;
    }

    public String getParemeter2() {
        return paremeter2;
    }

    public void setParemeter2(String paremeter2) {
        this.paremeter2 = paremeter2;
    }

    @Override
    public String toString() {
        return "Parameters{" +
                "parameter1='" + parameter1 + '\'' +
                ", paremeter2='" + paremeter2 + '\'' +
                '}';
    }
}
