package com.block.test;

import java.security.MessageDigest;
import java.util.List;

public class StringUtil {

	public static String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	
	public static Boolean isChainValid(List blockchain) {
        Block currentBlock;
        Block previousBlock;

        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = (Block) blockchain.get(i);
            previousBlock =  (Block)blockchain.get(i - 1);

            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                System.out.println("Current Hashes not equal!");
                return false;
            }

            if (!previousBlock.hash.equals(currentBlock.preHash)) {
                System.out.println("Previous Hashes not equal!");
                return false;
            }
        }
        return true;
    }
}
