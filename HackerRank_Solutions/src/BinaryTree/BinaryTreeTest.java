package BinaryTree;

public class BinaryTreeTest {

    public static void main(String[] args){
        BinaryTree2 bt = new BinaryTree2();
        bt.add(50);
        bt.add(10);
        bt.add(100);
        bt.add(60);
        bt.add(33);
        bt.add(23);
        bt.add(11);
        bt.add(83);
        bt.add(1);

        /*bt.add(50);
        bt.add(25);
        bt.add(75);
        bt.add(10);
        bt.add(30);
        bt.add(60);
        bt.add(65);
        bt.add(80);
        bt.add(76);
        bt.add(77);
        bt.add(85);
        bt.add(1);
        bt.add(100);*/

        System.out.println("Done");

//        bt.delete(50);
        bt.traverse();



    }
}
