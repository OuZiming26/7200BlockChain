package test;

import com.zxh.simple.Block;
import com.zxh.utils.JsonUtil;

import java.util.ArrayList;


public class BlockChainListTest {

    public static ArrayList<Block> blockChain = new ArrayList();

    public static void main(String[] args) {
        blockChain.add(new Block("first", "0"));
        blockChain.add(new Block("second", blockChain.get(blockChain.size() - 1).hash));
        blockChain.add(new Block("third", blockChain.get(blockChain.size() - 1).hash));

        System.out.println("\nBlockchain is Valid: " + isValidNewBlock());
        System.out.println(JsonUtil.toJson(blockChain));
    }

    public static Boolean isValidNewBlock (){

        Block currentBlock;
        Block previousBlock;
        boolean flag = true;

        //Loop through the list
        for(int i=1;i<blockChain.size();i++){
            currentBlock = blockChain.get(i);
            previousBlock = blockChain.get(i-1);
            if(!currentBlock.hash.equals(currentBlock.calculateHash())){
                System.out.println("The current hash is not equal");
                flag=false;
            }
            //Compare the current previous hash to the previous hash
            if(!previousBlock.hash.equals(currentBlock.previousHash)){
                System.out.println("The previous hash is not equal");
                flag=false;
            }

        }

        return flag;
    }
}

