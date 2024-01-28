package com.vikram.service;

import java.util.List;

import com.vikram.models.Reels;
import com.vikram.models.User;

public interface ReelsService {
	
	public Reels createReel(Reels reels, User user);
	
	public List<Reels> findAllReels();
	
	public List<Reels> findUsersReel(Integer userId) throws Exception;

}
