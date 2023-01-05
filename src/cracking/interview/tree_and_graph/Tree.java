package cracking.interview.tree_and_graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class Tree {

    static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node root;

    public Tree(int size) {
        this.root = makeBinarySearchTree(0, size - 1);
    }

    public int countPathsWithSum(int targetSum) {
        return countPathsWithSum(root, targetSum);
    }

    private int countPathsWithSum(Node root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int pathsFromRoot = countPathsWithSumFromNode(root, targetSum, 0);
        int pathsOnLeft = countPathsWithSum(root.left, targetSum);
        int pathsOnRight = countPathsWithSum(root.right, targetSum);

        return pathsFromRoot + pathsOnLeft + pathsOnRight;
    }

    private int countPathsWithSumFromNode(Node node, int targetSum, int currSum) {
        if (node == null) {
            return 0;
        }

        currSum += node.data;
        int totalPaths = 0;
        if (targetSum == currSum) {
            totalPaths++;
        }
        totalPaths += countPathsWithSumFromNode(node.left, targetSum, currSum);
        totalPaths += countPathsWithSumFromNode(node.right, targetSum, currSum);
        return totalPaths;
    }

    public Tree(int[] sortedArr) {
        this.root = makeBinarySearchTree(sortedArr);
    }

    public ArrayList<LinkedList<Node>> bstToList() {
        ArrayList<LinkedList<Node>> results = new ArrayList<>();
        LinkedList<Node> current = new LinkedList<>();
        if (root != null) {
            current.add(root);
        }

        while (!current.isEmpty()) {
            results.add(current);
            LinkedList<Node> parents = current;
            current = new LinkedList<>();
            for (Node parent : parents) {
                if (parent.left != null) {
                    current.add(parent.left);
                }
                if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }
        return results;
    }

    public void printList(ArrayList<LinkedList<Node>> lists) {
        for (LinkedList<Node> list : lists) {
            for (Node node : list) {
                System.out.print(node.data + " ");
            }
            System.out.println();
        }
    }

    // private //
    private Node makeBinarySearchTree(int[] sortedArray) {
        if (sortedArray == null || sortedArray.length == 0) {
            return null;
        }
        return makeBinarySearchTree(sortedArray, 0, sortedArray.length - 1);
    }

    private Node makeBinarySearchTree(int[] sortedArray, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node node = new Node(sortedArray[mid]);
        node.left = makeBinarySearchTree(sortedArray, start, mid - 1);
        node.right = makeBinarySearchTree(sortedArray, mid + 1, end);
        return node;
    }

    private Node makeBinarySearchTree(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node node = new Node(mid);
        node.left = makeBinarySearchTree(start, mid - 1);
        node.right = makeBinarySearchTree(mid + 1, end);
        return node;
    }
}
