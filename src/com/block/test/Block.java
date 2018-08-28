package com.block.test;

import java.util.Date;

public class Block {

	public String hash; //�������ǩ��
    public String preHash; //ǰ����ǩ��
    private String data;
    private long timeStamp;

    public Block(String data, String preHash) {
        this.data = data;
        this.preHash = preHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    public String calculateHash() {
        String calculatedhash = StringUtil.applySha256(preHash + Long.toString(timeStamp) + data);
        return calculatedhash;
    }
}
