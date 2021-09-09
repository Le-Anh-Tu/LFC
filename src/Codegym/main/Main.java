    package Codegym.main;

    import Menu.CoachMenu;
    import Menu.LoginMenu;
    import Menu.PlayerMenu;

    import java.util.Scanner;

    public class Main {
        public static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
//            int choice;
//            CoachMenu coachMenu = new CoachMenu();
//            PlayerMenu playerMenu = new PlayerMenu();
//            do {
//                menu();
//                System.out.println("Nhập lựa chọn");
//                choice = scanner.nextInt();
//                scanner.nextLine();
//                switch (choice){
//                    case 1: {
//                        coachMenu.run();
//                        break;
//                    }
//                    case 2: {
//                        playerMenu.run();
//                        break;
//                    }
//                }
//            } while (choice != 0);
//
//        }
//        public static void menu() {
//            System.out.println("******* MENU LIVERPOOL FC *******");
//            System.out.println("******* You'll never walk alone *******");
//            System.out.println("1. Quản lý HLV");
//            System.out.println("2. Quản lý cầu thủ");
//            System.out.println("0. Thoát");
//            System.out.println("=======================================");
//        }

                LoginMenu loginMenu = new LoginMenu();
                loginMenu.run();
        }
    }
