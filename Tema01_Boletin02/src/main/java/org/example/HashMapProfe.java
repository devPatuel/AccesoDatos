package org.example;

import java.util.ArrayList;
import java.util.List;

public class HashMapProfe<K, V> {
    private int size;
    private  Node<K, V>[][] data;

    public HashMapProfe(int capacity) {
        data = new Node[capacity][capacity];
        size = 0;
    }

    private int hash(K key, Node<K, V>[][] matrix) {
        int hash = key.hashCode();
        hash = hash * 31;
        hash = hash & 0x7FFFFFFF;
        return hash = hash % matrix.length;
    }

    private int hash(K key) {
        return hash(key, data);
    }

    public V put(K key, V value) {
        return put(key, value, data);
    }

    private V put(K key, V value, Node<K, V>[][] matrix) {
        int column = hash(key, matrix);
        int row;
        for (row = 0; row < matrix.length; row++) {
            Node<K, V> node = matrix[row][column];
            if (node == null || node.getKey().equals(key)) {
                break;
            }
        }
        if (row == matrix.length) {
            resize();
        }
        Node<K, V> oldValue = matrix[row][column];
        matrix[row][column] = new Node<>(key, value);
        size++;
        return oldValue == null? null:oldValue.getValue();
    }

    public V get(K key) {
        int column = hash(key);
        for (int row = 0; row < data.length; row++) {
            Node<K, V> node = data[row][column];
            if (node == null) {
                return null;
            }
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
        }
        return null;
    }

    public V remove(K key) {
        int column = hash(key);
        int row;
        for (row = 0; row < data.length; row++) {
            Node<K, V> node = data[row][column];
            if (node == null) {
                return null;
            }
            if (node.getKey().equals(key)) {
                for (int i = row; i < data[row].length; i++) {
                    data[i][column] = data[i][column];
                }
                size--;
                return node.getValue();
            }
        }
        return null;
    }

    public List<V> values(){
        List<V> values = new ArrayList<>();
        for (int column = 0; column < data[0].length; column++) {
            for (int row = 0; row < data.length; row++) {
                Node<K,V> node = data[row][column];
                if(node == null){
                    break;
                }
                values.add(node.getValue());
            }
        }
        return  values;
    }
    public List<K> keys(){
        List<K> keys = new ArrayList<>();
        for (int column = 0; column < data[0].length; column++) {
            for (int row = 0; row < data.length; row++) {
                Node<K,V> node = data[row][column];
                if(node == null){
                    break;
                }
                keys.add(node.getKey());
            }
        }
        return  keys;
    }

    private void resize() {
        Node<K, V>[][] resizedData = new Node[data.length * 2][data.length * 2];
        size = 0;
        for (int row = 0; row < data.length; row++) {
            for (int column = 0; column < data.length; column++) {
            Node<K,V> node = data[row][column];
            put(node.key, node.value, resizedData);
            }
        }
        data = resizedData;
    }


    static class Node<K, V> {
        private K key;
        private V value;


        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
