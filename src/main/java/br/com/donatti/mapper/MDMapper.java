package br.com.donatti.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

public class MDMapper {

	private static ModelMapper mapper = new ModelMapper();

	public static <O, D> D parseObject(O origem, Class<D> destino) {
		return mapper.map(origem, destino);
	}

	public static <O, D> List<D> parseListObjects(List<O> origem, Class<D> destino) {
		List<D> destinoObjects = new ArrayList<D>();
		for (O o : origem) {
			destinoObjects.add(mapper.map(o, destino));
		}
		return destinoObjects;
	}
}
