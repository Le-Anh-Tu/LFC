package Menu;

import Codegym.management.PlayerManagement;
import Codegym.model.Coach;
import Codegym.model.Player;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static Codegym.main.Main.scanner;
import static Codegym.main.Main.scanner;

public class PlayerMenu {
    public static PlayerManagement playerManagement = new PlayerManagement();

    static {
        playerManagement.addNew(new Player("001", "J.Henderson", "75Kg", "1m85", "England", "17-06-1990", "CDM", 50, 100, 150, 200));
        playerManagement.addNew(new Player("002", "V.Van Dijk", "80Kg", "1m95", "Netherlands", "08-07-1991", "CB", 100, 200, 150, 220));
        playerManagement.addNew(new Player("003", "M.Salah", "70Kg", "1m80", "Egypt", "15-06-1992", "RW", 999, 200, 150, 210));
        playerManagement.addNew(new Player("004", "Thiago", "68Kg", "1m69", "Spain", "11-04-1991", "CAM", 100, 500, 150, 180));
        playerManagement.addNew(new Player("005", "Alison", "78Kg", "1m90", "Brazil", "02-10-1992", "GK", 1, 0, 150, 200));
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            menu();
            System.out.println("Nhập lựa chọn của bạn:");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    showAllPlayer();
                    break;
                }
                case 2: {
                    addNewPlayer();
                    break;
                }
                case 3: {
                    updatePlayerInfo();
                    break;
                }
                case 4: {
                    removePlayer();
                    break;
                }
                case 5: {
                    playerToTotal();
                    break;
                }
                case 6: {

                }
                case 7: {
                    playerToGoals();
                    break;
                }
                case 8: {
                    playerToAssist();
                    break;
                }
                case 9: {
                    readDataToFile();
                    break;
                }
                case 10: {
                    writeDataToFile();
                    break;
                }
            }

        } while (choice != 0);
    }

    private void writeDataToFile() {
        List<Player> players = playerManagement.getPlayers();
        try {
            System.out.print("Bạn muốn ghi vào file nào: ");
            String filePath = scanner.nextLine();
            File file = new File(filePath);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for (Player player : players) {
                bw.write(String.valueOf(player));
                bw.newLine();
            }
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void readDataToFile() {
        try {
            System.out.print("Nhập vào file cần đọc: ");
            String filePath = scanner.nextLine();
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(Arrays.toString(line.split(",")));
            }
            br.close();
        } catch (IOException ie) {
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }

    }

    private void playerToAssist() {
        int index = playerManagement.finByPlayerToAssist();
        System.out.println("Cầu thủ kiến tạo nhiều nhất:");
        System.out.println(playerManagement.getPlayers().get(index));
    }

    private void playerToGoals() {
        int index = playerManagement.finByPlayerToGoals();
        System.out.println("Cầu thủ ghi bàn nhiều nhất:");
        System.out.println(playerManagement.getPlayers().get(index));
    }

    private void playerToTotal() {
        System.out.println("Tổng số cầu thủ trong đội hình là: " + playerManagement.getPlayers().size());
    }

    private void removePlayer() {
        System.out.println("Nhập mã HLV cần xóa");
        String id = scanner.nextLine();
        playerManagement.removeById(id);
    }

    private void updatePlayerInfo() {
        System.out.println("Nhập mã HLV cần sửa");
        String id = scanner.nextLine();
        int index = playerManagement.findById(id);
        if (index != -1) {
            Player player = inputPlayerFromKeyboard();
            playerManagement.updateById(id, player);
        } else {
            System.out.println("Nhập mã cầu thủ cần sửa");
        }
    }

    private void addNewPlayer() {
        Player player = inputPlayerFromKeyboard();
        playerManagement.addNew(player);
    }


    private Player inputPlayerFromKeyboard() {
        System.out.println("Nhập mã cầu thủ:");
        String id = scanner.nextLine();
        System.out.println("Nhập tên cầu thủ:");
        String name = scanner.nextLine();
        System.out.println("Nhập cân nặng của cầu thủ:");
        String weight = scanner.nextLine();
        System.out.println("Nhập chiều cao:");
        String height = scanner.nextLine();
        System.out.println("Nhập quốc tịch:");
        String nationality = scanner.nextLine();
        System.out.println("Nhập ngày sinh:");
        String birthday = scanner.nextLine();
        System.out.println("Số năm chơi bóng:");
        String location = scanner.nextLine();
        System.out.println("Số bàn thắng ghi được");
        int goal = scanner.nextInt();
        System.out.println("Số kiến tạo có được:");
        int assist = scanner.nextInt();
        System.out.println("Số trận đã đá cho LFC:");
        int battle = scanner.nextInt();
        System.out.println("Lương");
        double wage = scanner.nextDouble();
        return new Player(id, name, weight, height, nationality, birthday, location, goal, assist, battle, wage);
    }

    private void showAllPlayer() {
        playerManagement.showAll();
    }

    private void menu() {
        System.out.println("Quản Lý Cầu Thủ Liverpool");
        System.out.println("1. Hiển thị danh sách");
        System.out.println("2. Thêm mới cầu thủ");
        System.out.println("3.Sửa danh sách cầu thủ");
        System.out.println("4.Xóa cầu thủ");
        System.out.println("5. Tổng số cầu thủ trong đội");
        System.out.println("6. Thay mới cầu thủ");
        System.out.println("7. Cầu thủ ghi nhiều bàn thắng nhất");
        System.out.println("8. Cầu thủ kiến tạo nhiều nhất");
        System.out.println("9. Đọc từ file");
        System.out.println("10. Ghi từ file");
        System.out.println("0. Thoát");
        System.out.println("Mời bạn chọn chức năng");
    }
}


