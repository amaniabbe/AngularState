public class Tree {

    private Node root;
    private int count = 0;

    public int size()
    {
        return count;
    }
    public void addNode(Node node)
    {
        if(root == null)
        {
            root =  node;
            count = 1;
            return;
        }

        add(node, root);
        count++;
    };

    private void add(Node node, Node current)
    {
        // if less that or equal to me check my left
        //if greater than me check my right
        if(node.data <= current.data)
        {
            if(current.left != null)
                add(node,current.left);
            else
                current.left = node;
        }
        else
        {
            if(current.right != null)
                add(node, current.right);
            else current.right = node;
        }
    }

    public void remove(int val)
    {
        boolean removed = false;

        if(root != null )
        {
            if(root.data == val)
            {
               removed = remove(val, root, true);
            }
            else
            {
                removed = remove(val,root, false);
            }
        }

        if(removed)
            count--;
    }

    private boolean remove(int val,  Node parent, boolean isRoot)
    {
        Node current;
        boolean isRemoved = true;

        if(isRoot)
            current = parent;
        else if(val < parent.data)
            current = parent.left;
        else
            current = parent.right;

        if(current != null && current.data == val)
        {
            if(current.right != null)
            {
                if(current.right.left != null)
                {
                    Node nextValParent = getNextValueParentNode(current.right);
                    swapRemove(current,nextValParent );
                }
                else
                {
                    current.data = current.right.data;
                    current.right = current.right.right;
                }

            }
            else
            {
                if(isRoot)
                {
                    root = current.left;
                }
                else if(val < parent.data)
                    parent.left = current.left;
                else
                    parent.right = current.left;
            }
        }
        else if(current != null)
            remove(val,current, false);
        else
        {
            isRemoved = false;
            System.out.println("Element not found");
        }

        return isRemoved;
    }

    private Node getNextValueParentNode(Node parent)
    {
        if(parent.left != null && parent.left.left != null)
            return getNextValueParentNode(parent.left);
         else
             return parent;
    }

    private void swapRemove(Node current , Node nextValueParent)
    {
        current.data = nextValueParent.left.data;
        nextValueParent.left = nextValueParent.left.right;
    }

    public void print()
    {   System.out.println("root is: " + root.data );
        print(root);
        System.out.println();
    }
    private void print(Node current)
    {
        if(current.left != null)
            print(current.left);

        System.out.print(current.data + " ");

        if(current.right != null)
            print(current.right);
    }


}
