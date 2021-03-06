package com.block.test;

import java.util.Date;

public class Block {

	    public String hash; //��ϣ��
	    public String preHash; // ǰ�ù�ϣ��
	    private String data;     // ������
	    private long timeStamp;  // ʱ���
	    private int nonce;  // �ڿ����

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
