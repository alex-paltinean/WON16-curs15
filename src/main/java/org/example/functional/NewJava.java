package org.example.functional;

import java.util.function.Supplier;

public class NewJava {

    public static void main(String[] args) {
        placeTile(() -> "Five taps");
        placeTile(() -> "Spin");
    }

    public static void placeTile(Supplier<String> customExecution) {
        System.out.println("1000 lines code");
        System.out.println(customExecution.get());
        System.out.println("1000 lines code");
    }
}
