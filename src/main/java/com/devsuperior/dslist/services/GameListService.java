package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired//faz a injeção de depend.
	private GameListRepository gameListRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() throws Exception{
		List<GameList> result = null;
		try {
			result = gameListRepository.findAll();
			List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
			return dto;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
