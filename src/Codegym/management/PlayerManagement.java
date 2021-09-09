    package Codegym.management;

    import Codegym.model.Player;

    import java.util.ArrayList;
    import java.util.List;

    import static sun.audio.AudioPlayer.player;

    public class PlayerManagement implements IGeneralManagement<Player> {
        private List<Player> players = new ArrayList<>();

        public List<Player> getPlayers() {
            return players;
        }

        public void setPlayers(List<Player> players) {
            this.players = players;
        }

        @Override
        public void showAll() {
            for (Player player : players) {
                System.out.println(player);
            }
        }

        @Override
        public void addNew(Player player) {
            players.add(player);
        }

        @Override
        public void addNew(int index, Player player) {

        }

        @Override
        public void updateById(String id, Player player) {
            int index = findById(id);
            if (index != -1) {
                players.set(index, player);
            } else {
                System.out.println("Không tìm thấy cầu thủ!");
            }
        }

        @Override
        public void removeById(String id) {
            int index = findById(id);
            if (index != -1) {
                players.remove(index);
            } else {
                System.out.println("Không tìm thấy cầu thủ!");
            }
        }

        @Override
        public int findById(String id) {
            int index = -1;
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).getId().equals(id)) {
                    index = i;
                    break;
                }
            }
            return index;
        }
        public int finByPlayerToGoals(){
            int index = -1;
            if (players.isEmpty()){
                return  index;
            }
            double max = players.get(0).getGoal();
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).getGoal() > max) {
                    max = players.get(i).getGoal();
                    index = i;
                }
            }
            return index;
        }
        public int finByPlayerToAssist(){
            int index = -1;
            if (players.isEmpty()){
                return  index;
            }
            double max = players.get(0).getAssist();
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).getAssist() > max) {
                    max = players.get(i).getAssist();
                    index = i;
                }
            }
            return index;
        }

        }
