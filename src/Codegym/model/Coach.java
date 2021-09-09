    package Codegym.model;

    public class Coach {
        private String id;
        private String name;
        private String nationality ;
        private String birthday;
        private int experience;
        private double wage;
        private Coach coach;

        public Coach(String id, String name, String nationality, String birthday, int experience, double wage) {
            this.id = id;
            this.name = name;
            this.nationality = nationality;
            this.birthday = birthday;
            this.experience = experience;
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

        public int getExperience() {
            return experience;
        }

        public void setExperience(int experience) {
            this.experience = experience;
        }

        public double getWage() {
            return wage;
        }

        public void setWage(double wage) {
            this.wage = wage;
        }

        public Coach getCoach() {
            return coach;
        }

        public void setCoach(Coach coach) {
            this.coach = coach;
        }

        @Override
        public String toString() {
            return "Coach{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", nationality='" + nationality + '\'' +
                    ", birthday='" + birthday + '\'' +
                    ", experience=" + experience +
                    ", wage=" + wage +
                    '}';
        }
    }
