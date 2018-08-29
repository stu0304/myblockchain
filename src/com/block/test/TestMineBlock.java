package com.block.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TestMineBlock {

	@Test
	public void test1() {
		
		   ArrayList<Block> blockchain = new ArrayList<Block>();
		      int difficulty = 5;

	        long beginTime1 = new Date().getTime();
	        blockchain.add(new Block("Hi i am the first block", "0"));
	        System.out.println("Trying to  mine block 1...");
	        blockchain.get(0).mineBlock(difficulty);
	        long endTime1 = new Date().getTime();
	        System.out.println("Mining block 1 cost " + (endTime1 - beginTime1));


	        long beginTime2 = new Date().getTime();
	        blockchain.add(new Block("Hi i am the second block", blockchain.get(blockchain.size() - 1).hash));
	        System.out.println("Trying to  mine block 2...");
	        blockchain.get(1).mineBlock(difficulty);
	        long endTime2 = new Date().getTime();
	        System.out.println("Mining block 1 cost " + (endTime2 - beginTime2));

	        long beginTime3 = new Date().getTime();
	        blockchain.add(new Block("Hi i am the third block", blockchain.get(blockchain.size() - 1).hash));
	        System.out.println("Trying to  mine block 3...");
	        blockchain.get(2).mineBlock(difficulty);
	        long endTime3 = new Date().getTime();
	        System.out.println("Mining block 1 cost " + (endTime3 - beginTime3));

	        System.out.println("\nBlockchain is Valid: " + StringUtil.isChainValid(blockchain));

	        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
	        System.out.println(blockchainJson);
	    
		    

	}
}
