package com.zxh.simple;


import java.util.Date;

import com.zxh.utils.StringUtil;

import java.text.DecimalFormat;
/**
 * block
 */
public class Block {
    /**
     * Block height
     */
    public GetIndex index;

    /**
     * A SHA-256 hash value taken from the content of current block
     */
    public String hash;

    /**
     * A SHA-256 hash value taken from the content of previous block
     */
    public String previousHash;

    /**
     * Any data that is included in the block
     */
    private String data;

    /**
     * UnixTimeEpoch()
     */
    private long timeStamp;

    public Block(String hash, String previousHash, String data) {
        this.hash = hash;
        this.previousHash = previousHash;
        this.data = data;
    }

    public Block(String data, String previousHash) {
        this.index = new GetIndex();
        this.previousHash = previousHash;
        this.data = data;
        this.timeStamp = new Date().getTime() / 1000;;
        this.hash = calculateHash();
    }

    public static class GetIndex {
        private static int totalCount = 0;
        private int index;

        public GetIndex() {

            ++totalCount;
            index = totalCount -1;
        }


        public String GetIndexID() {
            DecimalFormat decimalFormat = new DecimalFormat("0");
            return decimalFormat.format(index);
        }
    }


    public String calculateHash() {
        String calculatedhash = StringUtil.applySha256(
                previousHash +
                        Long.toString(timeStamp) +
                        index +
                        data);
        return calculatedhash;
    }

}
