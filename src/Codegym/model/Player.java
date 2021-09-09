    package Codegym.model;

    public class Player  {
        private String id;
        private String name;
        private String weight;
        private String height;
        private String nationality ;
        private String birthday;
        private String location;
        private int goal;
        private int assist;
        private int battle;
        private double wage;

        public Player() {

        }

        public Player(String id, String name, String weight, String height, String nationality, String birthday, String location, int goal, int assist, int battle, double wage) {
            this.id = id;
            this.name = name;
            this.weight = weight;
            this.height = height;
            this.nationality = nationality;
            this.birthday = birthday;
            this.location = location;
            this.goal = goal;
            this.assist = assist;
            this.battle = battle;
            this.wage = wage;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getNationality() {
            return nationality;
        }

        public void setNationality(String nationality) {
            this.nationality = nationality;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public int getGoal() {
            return goal;
        }

        public void setGoal(int goal) {
            this.goal = goal;
        }

        public int getAssist() {
            return assist;
        }

        public void setAssist(int assist) {
            this.assist = assist;
        }

        public int getBattle() {
            return battle;
        }

        public void setBattle(int battle) {
            this.battle = battle;
        }

        public double getWage() {
            return wage;
        }

        public void setWage(double wage) {
            this.wage = wage;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", weight='" + weight + '\'' +
                    ", height='" + height + '\'' +
                    ", nationality='" + nationality + '\'' +
                    ", birthday='" + birthday + '\'' +
                    ", location='" + location + '\'' +
                    ", goal=" + goal +
                    ", assist=" + assist +
                    ", battle=" + battle +
                    ", wage=" + wage +
                    '}';
        }
    }
