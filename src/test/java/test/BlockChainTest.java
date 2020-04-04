package test;

import com.zxh.simple.Block;

public class BlockChainTest {

    public static void main(String[] args) {
        //first
        Block firstBlock = new Block("first", "0");
        
        System.out.println("Hash for block 1: " + firstBlock.hash);

        //second
        Block secondBlock = new Block("second", firstBlock.hash);
        System.out.println("Hash for block 2: " + secondBlock.hash);

        //third
        Block thirdBlock = new Block("third", secondBlock.hash);
        System.out.println("Hash for block 3: " + thirdBlock.hash);
    }
}
