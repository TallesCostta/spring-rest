package br.com.donatti;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Donatti [tallescosttapaiva@gmail.com] 06/06/2023 - 02:47:18
 *
 */
@RestController
public class GreetingController {

	private final static String template = "Hello, %s!";
	private final AtomicLong geradorId = new AtomicLong();

	@RequestMapping("/greeting")
	public Greeting greeting(
			@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(geradorId.incrementAndGet(), String.format(template, name));
	}
}
