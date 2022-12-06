public class Node
{
    public int value;
    public int level;
    public Node left;
    public Node right;
    public Node(int value)
    {
        this.value = value;
        left = null;
        right = null;
        level = 0;
    }

}


