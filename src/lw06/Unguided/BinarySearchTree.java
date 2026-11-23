package lw06.Unguided;

class BinarySearchTree  {
  Node root;

    public void insert(int data){
        root = insertHelper(root, data);
    }

    private Node insertHelper(Node root, int data){
        if(root==null){
            root = new Node(data);
        }else if(data < root.data){
            root.left = insertHelper(root.left, data);
        }else if(data > root.data){
            root.right = insertHelper(root.right, data);
        }
        return root;
    }

    public boolean search(int target){
        return searchHelper(root, target);
    }

    private boolean searchHelper(Node root, int target){
        if(root==null){
            return false;
        }

        if(root.data==target){
            return true;
        }else if(target < root.data){
            return searchHelper(root.left, target);
        }else{
            return searchHelper(root.right, target);
        }
    }

    public int findMin(){
        return findMinHelper(root);
    }

    public int findMax(){
        return findMaxHelper(root);
    }

    public int findMinHelper(Node root){
        if(root.left==null){
            return root.data;
        }
        return findMinHelper(root.left);
    }

    public int findMaxHelper(Node root){
        if(root.right==null){
            return root.data;
        }
        return findMaxHelper(root.right);
    }

    public void inOrder(){
        inOrderHelper(root);
        System.out.println();
    }

    public void postOrder(){
        postOrderHelper(root);
        System.out.println();
    }

    public void preOrder(){
        preOrderHelper(root);
        System.out.println();
    }

    public void inOrderHelper(Node root){
        if(root==null){
            return;
        }
        inOrderHelper(root.left);
        System.out.print(root.data + " ");
        inOrderHelper(root.right);
    }

    public void postOrderHelper(Node root){
        if(root==null){
            return;
        }
        postOrderHelper(root.left);
        postOrderHelper(root.right);
        System.out.print(root.data + " ");
    }

    public void preOrderHelper(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data + " ");
        preOrderHelper(root.left);
        preOrderHelper(root.right);
    }
}
