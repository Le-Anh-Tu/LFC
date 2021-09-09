    package Codegym.management;

    import Codegym.model.Coach;

    import java.util.ArrayList;
    import java.util.List;

    public class CoachManagement implements IGeneralManagement<Coach> {
        private List<Coach> coachList = new ArrayList<>();

        public List<Coach> getCoachList() {
            return coachList;
        }

        public void setCoachList(List<Coach> coachList) {
            this.coachList = coachList;
        }

        @Override
        public void showAll() {
            for (Coach coach : coachList) {
                System.out.println(coach);
            }
        }

        @Override
        public void addNew(Coach coach) {
            coachList.add(coach);
        }

        @Override
        public void addNew(int index, Coach coach) {
            coachList.add(index, coach);
        }

        @Override
        public void updateById(String id, Coach coach) {
            int index = findById(id);
            //            if (index != -1){
            coachList.set(index, coach);
            //            }else {
            //                System.out.println("Không tồn tại");
            //            }
        }

        @Override
        public void removeById(String id) {
            int index = findById(id);
            if (index != -1) {
                coachList.remove(index);
            }
        }

        @Override
        public int findById(String id) {
            int index = -1;
            for (int i = 0; i < coachList.size(); i++) {
                if (coachList.get(i).getId().equals(id)) {
                    index = i;
                    break;
                }
            }
            return index;
        }

        public Coach findByName(int index) {
            return coachList.get(index);

        }

        public int finnByCoachExperience() {
            int index = -1;
            if (coachList.isEmpty()) {
                return index;
            }
            double max = coachList.get(0).getExperience();
            for (int i = 0; i < coachList.size(); i++) {
                if (coachList.get(i).getExperience() > max) {
                    max = coachList.get(i).getExperience();
                    index = i;
                }
            }
            return index;
        }
    }
