package org.example;

import java.io.IOException;
import java.util.Scanner;

public class UserInterfaceView {

    Controller controller = new Controller();

    public void runInterface() throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Введите название города: ");
            String city = scanner.nextLine();

            System.out.println("Выберите, из какого источника получить погоду: 1. Accuweather; " +
                    "2. Weatherapi; Для выхода введите 0: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Введите 1 для получения погоды на сегодня; " +
                            "Введите 5 для прогноза на 5 дней; Для выхода нажмите 0: ");

                    String command1 = scanner.nextLine();

                    if (command1.equals("0")) break;

                    try {
                        controller.getWeather(choice, command1, city);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "2":
                    System.out.println("Введите 1 для получения погоды на сегодня; Для выхода нажмите 0: ");

                    String command2 = scanner.nextLine();

                    if (command2.equals("0")) break;

                    try {
                        controller.getWeather(choice, command2, city);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
            }
            break;
        }
    }

    public static void main(String[] args) throws IOException {
        UserInterfaceView userInterfaceView = new UserInterfaceView();
        userInterfaceView.runInterface();

    }

}

