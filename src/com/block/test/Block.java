package com.block.test;

import java.util.Date;

public class Block {

	    public String hash; //哈希码
	    public String preHash; // 前置哈希码
	    private String data;     // 块数据
	    private long timeStamp;  // 时间戳
	    private int nonce;  // 挖矿次数

	    public Block(String data, String preHash) {
	        this.data = data;
	        this.preHash = preHash;
	        this.timeStamp = new Date().getTime();
	        this.hash = calculateHash();
	    }

	    public String calculateHash() {
	        String calculatedhash = StringUtil.applySha256(preHash + Long.toString(timeStamp) 
	        + Integer.toString(nonce) +
	                data);
	        return calculatedhash;
	    }

	    public void mineBlock(int difficulty) {
	        String target = new String(new char[difficulty]).replace('\0', '0');
	        while (!hash.substring(0, difficulty).equals(target)) {
	            nonce++;
	            hash = calculateHash();
	        }
	        System.out.println("Block Mined!!!" + hash);
	    }
}
