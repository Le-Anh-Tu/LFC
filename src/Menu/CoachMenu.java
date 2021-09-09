    package Menu;

    import Codegym.management.CoachManagement;
    import Codegym.management.PlayerManagement;
    import Codegym.model.Coach;
    import Codegym.model.Player;

    import java.io.*;
    import java.util.Arrays;
    import java.util.List;
    import java.util.Scanner;

    import static Codegym.main.Main.scanner;

    public class CoachMenu {
        public static CoachManagement coachManagement = new CoachManagement();
        static {
            coachManagement.addNew(new Coach("001", "J.Klopp", "Germany", "16-06-1967", 10, 500.000));
            coachManagement.addNew(new Coach("002", "Zeljko Buvac", "Netherlands", "08-07-1975", 5, 200.000));
            coachManagement.addNew(new Coach("003", "Peter Krawietz", "Spain", "15-06-1972", 6, 200.000));

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
                        showAllCoach();
                        break;
                    }
                    case 2: {
                        addNewCoach();
                        break;
                    }
                    case 3: {
                        updateCoachInfo();
                        break;
                    }
                    case 4: {
                        removeCoach();
                        break;
                    }
                    case 5: {
                        coachToTotal();
                        break;
                    }
                    case 6: {

                        break;
                    }
                    case 7: {
                        coachToExperience();
                        break;
                    }
                    case 8: {
                        readDataToFile();
                        break;
                    }
                    case 9: {
                        writeDataToFile();
                        break;
                    }

                }
            } while (choice != 0);
        }

        private void writeDataToFile() {
            List<Coach> coachList = coachManagement.getCoachList();
            try {
                System.out.println("Bạn muốn ghi vào file nào: ");
                String filePath = scanner.nextLine();
                File file = new File(filePath);
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fileWriter);
                for (Coach coach : coachList) {
                    bw.write(String.valueOf(coachList));
                    bw.newLine();
                }
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        private void readDataToFile() {
            try {
                System.out.println("Nhập vào file cần đọc: ");
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
                System.err.println("Fie không tồn tại hoặc nội dung có lỗi!");
            }
        }

        private void coachToExperience() {
            int index = coachManagement.finnByCoachExperience();
            System.out.println("Huấn luyện viên có kinh nghiệm nhất");
            System.out.println(coachManagement.getCoachList().get(index));
        }

        private void addCoachToCoachList(int index, Coach coach) {
            Coach coach1 = coachManagement.getCoachList().get(index);
            coach.setCoach(coach1);
            coachManagement.getCoachList().set(index, coach1);
        }

        private void coachToTotal() {
            System.out.println("Tổng số HLV: " + coachManagement.getCoachList().size());

        }

        private void removeCoach() {
            System.out.println("Nhập mã HLV cần xóa");
            String id = scanner.nextLine();
            coachManagement.removeById(id);
        }

        private void updateCoachInfo() {
            System.out.println("Nhập mã HLV cần sửa");
            String id = scanner.nextLine();
            int index = coachManagement.findById(id);
            if (index != -1) {
                Coach coach = inputCoachFromKeyboard();
                coachManagement.updateById(id, coach);
            } else {
                System.out.println("Không tìm thấy");
            }

        }

        private void addNewCoach() {
            Coach coach = inputCoachFromKeyboard();
            coachManagement.addNew(coach);
        }

        //    private void addNewCoach(int index, Coach coach) {
    //        int index = coachManagement.findById(id);
    //        Coach newCoach = inputCoachFromKeyboard();
    //        coachManagement.addNew(coach);
    //    }
        private Coach inputCoachFromKeyboard() {
            System.out.println("Nhập mã HLV");
            String id = scanner.nextLine();
            System.out.println("Nhập tên hvl");
            String name = scanner.nextLine();
            System.out.println("Nhập quốc gia");
            String nationality = scanner.nextLine();
            System.out.println("Nhập ngày sinh");
            String birthday = scanner.nextLine();
            System.out.println("Số năm chơi bóng");
            int experience = scanner.nextInt();
            System.out.println("Lương");
            int wage = scanner.nextInt();
            return new Coach(id, name, nationality, birthday, experience, wage);
        }

        private void showAllCoach() {
            coachManagement.showAll();
        }

        private void menu() {
            System.out.println("Quản Lý HLV Liverpool");
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm mới HLV");
            System.out.println("3.Sửa danh sách HLV");
            System.out.println("4.Xóa HLV");
            System.out.println("5. Tổng số HLV");
            System.out.println("6. Thay mới HLV");
            System.out.println("7. Lương HLV có thâm niên lâu nhất");
            System.out.println("8. Đọc từ file");
            System.out.println("9. Ghi từ file");
            System.out.println("0. Thoát");
        }
    }
