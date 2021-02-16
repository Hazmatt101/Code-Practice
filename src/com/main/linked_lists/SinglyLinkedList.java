package com.main.linked_lists;

import org.jetbrains.annotations.NotNull;

//TODO The insertAt function is incomplete
public class SinglyLinkedList<T> {
    Node<T> head;
    Node<T>[] nodes;

    public static void main(String[] args) {
        SinglyLinkedList<Integer> integerSinglyLinkedList =
                new SinglyLinkedList<>(new Node[]{new Node<>(1), new Node<>(2), new Node<>(3)});
    }

    //Constructors
    public SinglyLinkedList(){}

    public SinglyLinkedList(@NotNull Node<T>[] nodes) {
        this.head = new Node<>();
        this.nodes = new Node[nodes.length + 1];
        this.nodes[0] = this.head;
        for (int i = 0; i < nodes.length; i++) {
            this.nodes[i + 1] = nodes[i];
        }
    }

    //Operations
    public void insertAt(Node<T> node, int position) {
        int size = size();
        if (position >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        Node<T>[] subArr = this.nodes;
        this.nodes[position] = node;
    }

    public int size() {
        return this.nodes.length;
    }

    public static class Node<T> {
        T value;
        Node<T> next;

        public Node() {}
        public Node(T value) {
            this.value = value;
        }
        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
