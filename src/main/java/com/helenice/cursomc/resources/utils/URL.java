package com.helenice.cursomc.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class URL {
	public static String decodeParam (String s) {
		try {
			return URLDecoder.decode(s, "UTF-8");
		}catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static List<Integer> decodeIntLis(String s){
//		String[] vetor = s.split(",");
//		List<Integer> lista = new ArrayList<>();
//		for(int i=0; i < vetor.length; i++) {
//			lista.add(Integer.parseInt(vetor[i]));
//		}
		//return lista;
		return Arrays.asList(s.split(",")).stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
	}

}
