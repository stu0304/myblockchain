package com.binarytree;

public class TestBinTree {

    public static void main(String[] args) {
    	BinTree binTree=new BinTree();
		Object[] objs={0,1,2,3,4,5,6,7};
		binTree.createTree(objs);
//		binTree.preorder(binTree.getRoot()); �������
//		binTree.inorder(binTree.getRoot()); �������
		binTree.afterorder(binTree.getRoot()); //�������
	} 
}
