package Menu;

import Codegym.management.UserManagement;
import Codegym.model.User;

import java.util.Scanner;

import static Codegym.main.Main.scanner;
import static Codegym.main.Main.scanner;

public class LoginMenu {
    public static UserManagement userManagement = new UserManagement();
    private void menuAdmin(){
        System.out.println("******* MENU LIVERPOOL FC *******");
        System.out.println("******* You'll never walk alone *******");
        System.out.println("1. Quản lý HLV");
        System.out.println("2. Quản lý cầu thủ");
        System.out.println("0. Thoát");
        System.out.println("=======================================");
    }
    public void run() {
        int choice;
        do {
            menu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    doLogin();
                    break;
                }
                case 2: {
                    doRegister();
                    break;
                }
            }
        } while (choice != 0);

    }
    private void doRegister() {
        System.out.println("Tạo tài khoản mới");
        System.out.println("Nhập id:");
        String id = scanner.nextLine();
        System.out.println("Nhập username:");
        String username = scanner.nextLine();
        System.out.println("Nhập password:");
        String password = scanner.nextLine();
        String role = "";
        do {
            System.out.println("Nhập role(admin/user):");
            role = scanner.nextLine();
        } while (!role.equals("admin") && !role.equals("user"));
        User user = new User(id, username, password, role);
        userManagement.addNew(user);
    }

    private void doLogin() {
        System.out.println("Đăng nhập....");
        System.out.println("Nhập username:");
        String username = scanner.nextLine();
        System.out.println("Nhập password:");
        String password = scanner.nextLine();
        User userLogin = new User(username, password);
        if (userManagement.isLogin(userLogin) != null) {
            User user = userManagement.isLogin(userLogin);
            if (user.getRole().equals("admin")) {
                showAdminMenu();
            }else {
                showUserMenu();
            }
        } else {
            System.err.println("Sai tài khoản hoặc mật khẩu");
        }
    }

    private void showUserMenu() {
        System.out.println("User Menu");
    }

    private void showAdminMenu() {
        int choice;
        CoachMenu coachMenu = new CoachMenu();
        PlayerMenu playerMenu = new PlayerMenu();
        do {
            menuAdmin();
            System.out.println("Nhập lựa chọn:");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    coachMenu.run();
                    break;
                }
                case 2: {
                    playerMenu.run();
                    break;
                }
            }
        } while (choice != 0);
    }

    private void menu() {
        System.out.println("MENU");
        System.out.println("1. Đăng nhập");
        System.out.println("2. Đăng ký");
        System.out.println("0. Thoát");
    }
}
