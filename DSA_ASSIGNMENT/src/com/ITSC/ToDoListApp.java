package com.ITSC;
//Task class
class Task {
    private String title;
    private String description;
    private boolean completed;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isCompleted() {
        return this.completed;
    }

    public void markCompleted() {
        this.completed = true;
    }
}
//Node class
class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}
//ToDoList class
class ToDoList {
    private Node head;

    public ToDoList() {
        this.head = null;
    }

    public void addToDo(Task task) {
        Node newNode = new Node(task);

        if (this.head == null) {
            this.head = newNode;
            return;
        }

        Node current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void markToDoAsCompleted(String title) {
        if (this.head == null) {
            return;
        }

        Node current = this.head;
        while (current != null) {
            if (current.task.getTitle().equals(title)) {
                current.task.markCompleted();
                return;
            }
            current = current.next;
        }
    }

    public void viewToDoList() {
        Node current = this.head;
        while (current != null) {
            System.out.println("Title: " + current.task.getTitle());
            System.out.println("Description: " + current.task.getDescription());
            System.out.println("Completed: " + (current.task.isCompleted() ? "Yes" : "No"));
            System.out.println();
            current = current.next;
        }
    }
}
//Main Method for testing
public class ToDoListApp {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();

        Task task1 = new Task("Finish assignment", "Complete to-do list project");
        Task task2 = new Task("Go for a walk", "Take a 30-minute walk outside");
        Task task3 = new Task("Attending class", "Presenting the project");
        Task task4 = new Task("Study for final", "Study one subject for two hours");
     // Add tasks to the to-do list
        toDoList.addToDo(task1);
        toDoList.addToDo(task2);
        toDoList.addToDo(task3);
        toDoList.addToDo(task4);
        // Mark tasks as completed
        toDoList.markToDoAsCompleted("Go for a walk");
        toDoList.markToDoAsCompleted("Finish assignment");

        toDoList.viewToDoList();
    }
}