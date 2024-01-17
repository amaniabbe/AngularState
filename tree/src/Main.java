import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        Tree BSTtree= new Tree();

        List<Integer> list = Arrays.asList(5,9,7,8);
        list.forEach(ele -> BSTtree.addNode(new Node(ele)));

        BSTtree.print();
        System.out.println("size is: " + BSTtree.size());
        System.out.println();
        BSTtree.remove(5);
        BSTtree.print();
        System.out.println("size is: " + BSTtree.size());
        System.out.println();
        BSTtree.addNode(new Node(30));

        BSTtree.print();
        System.out.println("size is: " + BSTtree.size());
        System.out.println();


    }
}