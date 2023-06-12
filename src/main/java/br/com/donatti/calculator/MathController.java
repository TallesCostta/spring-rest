package br.com.donatti.calculator;

import java.io.Serializable;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.donatti.exceptions.ResourcesNotFoundException;

@RestController
public class MathController implements Serializable{

	private static final long serialVersionUID = -7140350689888845906L;
	
	private String number; 

	/**
	 * @author Donatti [tallescosttapaiva@gmail.com] 10/06/2023 - 15:32:10
	 * @param numberOne
	 * @param numberTwo
	 * @return
	 * @throws Exception
	 * 
	 * Soma de dois numeros
	 * 
	 */
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new ResourcesNotFoundException("Parametro invalido! por favor digite um valor numerico!");
		}
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}
	
	/**
	 * @author Donatti [tallescosttapaiva@gmail.com] 10/06/2023 - 15:40:25
	 * @param numberOne
	 * @param numberTwo
	 * @return
	 * @throws Exception
	 * 
	 * Subtracao de dois numeros
	 * 
	 */
	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sub(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new ResourcesNotFoundException("Parametro invalido! por favor digite um valor numerico!");
		}
		return convertToDouble(numberOne) - convertToDouble(numberTwo);
	}
	
	/**
	 * @author Donatti [tallescosttapaiva@gmail.com] 10/06/2023 - 15:42:28
	 * @param numberOne
	 * @param numberTwo
	 * @return
	 * @throws Exception
	 * 
	 * Multiplicacao de dois numeros
	 * 
	 */
	@RequestMapping(value = "/multi/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multi(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new ResourcesNotFoundException("Parametro invalido! por favor digite um valor numerico!");
		}
		return convertToDouble(numberOne) * convertToDouble(numberTwo);
	}
	
	/**
	 * @author Donatti [tallescosttapaiva@gmail.com] 10/06/2023 - 15:44:45
	 * @param numberOne
	 * @param numberTwo
	 * @return
	 * @throws Exception
	 * 
	 * Divisao de dois numeros
	 * 
	 */
	@RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double div(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new ResourcesNotFoundException("Parametro invalido! por favor digite um valor numerico!");
		}
		return convertToDouble(numberOne) / convertToDouble(numberTwo);
	
	}
	
	/**
	 * @author Donatti [tallescosttapaiva@gmail.com] 10/06/2023 - 15:47:30
	 * @param numberOne
	 * @param numberTwo
	 * @return
	 * @throws Exception
	 * 
	 * Media de dois numeros
	 * 
	 */
	@RequestMapping(value = "/avg/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double avg(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new ResourcesNotFoundException("Parametro invalido! por favor digite um valor numerico!");
		}
		return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
	
	}
	
	/**
	 * @author Donatti [tallescosttapaiva@gmail.com] 10/06/2023 - 15:51:13
	 * @param numberOne
	 * @param numberTwo
	 * @return
	 * @throws Exception
	 * 
	 * Raiz quadrada de dois numeros distintos
	 * 
	 */
	@RequestMapping(value = "/sqrt/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public RaizQuadrada sqrt(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new ResourcesNotFoundException("Parametro invalido! por favor digite um valor numerico!");
		}
		
		Integer numOne = converterToInt(numberOne);
		Integer numTwo = converterToInt(numberTwo);
		
		return new RaizQuadrada(Math.sqrt(numOne), Math.sqrt(numTwo)) ;
	
	}
	
	private Integer converterToInt(String strNumber) {
		if (strNumber == null)
			return 0;
		
		number = converterSeparator(strNumber);

		if (isNumeric(number))
			return Integer.parseInt(number);
		return 0;
	}

	private Double convertToDouble(String strNumber) {

		if (strNumber == null)
			return 0D;
		number = converterSeparator(strNumber);

		if (isNumeric(number))
			return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if (strNumber == null)
			return false;
		number = converterSeparator(strNumber);
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

	private String converterSeparator(String strNumber) {
		number = strNumber.replaceAll(",", ".");
		return number;
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
