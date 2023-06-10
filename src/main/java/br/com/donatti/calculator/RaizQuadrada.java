package br.com.donatti.calculator;

import java.io.Serializable;

/**
 * 
 * @author Donatti [tallescosttapaiva@gmail.com] 10/06/2023 - 15:49:52
 *
 */
public class RaizQuadrada implements Serializable{

	private static final long serialVersionUID = 8676737481130019264L;
	
	private final Double numberOne;
	private final Double numberTwo;
	
	public RaizQuadrada(Double numberOne, Double numberTwo) {
		this.numberOne = numberOne;
		this.numberTwo = numberTwo;
	}

	public Double getNumberOne() {
		return numberOne;
	}

	public Double getNumberTwo() {
		return numberTwo;
	}
}
