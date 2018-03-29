package net.itspartner.test.n1;

public class Main {

    /**
     * Description: Application contains custom linked list implementation
     * and loops through the list to print each element
     * Task: Implement 'reverse' method for this linked list that modify the list in following way:
     * original: 1->2->3
     * expected: 3->2->1
     * <p>
     * Do not change 'Node' class
     */
    public static void main(String[] args) {

        Node<Integer> linkedListHead = new Node<>(1);
        linkedListHead
            .setNextNode(new Node<>(2))
            .setNextNode(new Node<>(3))
            .setNextNode(new Node<>(4));

        print(linkedListHead);

        linkedListHead = reverse(linkedListHead);

        System.out.println("");
        print(linkedListHead);
    }

    private static void print(Node<Integer> head) {

        Node<Integer> curNode = head;
        while (curNode != null) {

            System.out.print(curNode.value);

            curNode = curNode.getNextNode();
            if (curNode != null) System.out.print("->");
        }
    }

    private static Node<Integer> reverse(Node<Integer> head) {
        Node<Integer> prevNode;
        Node<Integer> curNode = head;
        Node<Integer> nextNode = null;

        while (curNode != null) {
            prevNode = curNode.getNextNode();
            curNode.setNextNode(nextNode);
            nextNode = curNode;
            curNode = prevNode;
        }

        return nextNode;
    }
}
