package br.com.donatti;

/**
 * 
 * @author Donatti [tallescosttapaiva@gmail.com] 06/06/2023 - 02:45:23
 *
 */
public class Greeting {
	private final Long id;
	private final String content;
	
	public Greeting(Long id, String content) {
		this.id = id;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
	
}
