package br.com.java.springproject.converters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

import br.com.java.springproject.models.Professor;



public class ArrayStringToListProfessor implements Converter<String[], List<Professor>>  {

	
	@Override
	public List<Professor> convert(String[] source) {
		List<Professor> professores = new ArrayList<Professor>();
		Professor professor;
		for(int i=0;i < source.length;i++){
			professor =  new Professor();
			professor.setId(Integer.parseInt(source[i]));
			professores.add(professor);
		}
		return professores;
	}




	

	
	
	
}
