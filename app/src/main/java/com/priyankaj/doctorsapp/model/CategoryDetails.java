package com.priyankaj.doctorsapp.model;


import java.util.ArrayList;
public class CategoryDetails {


    public ArrayList<Category> getCategory() {
        return Category;
    }

    public void setCategory(ArrayList<Category> category) {
        this.Category = category;
    }
    private ArrayList<Category> Category;


    public class Category{
        private String category_id;
        private String category_name;
        private String status;

        public int getDoctorCount() {
            return doctorCount;
        }

        public void setDoctorCount(int doctorCount) {
            this.doctorCount = doctorCount;
        }

        int doctorCount;

        public String getCategory_id() {
            return category_id;
        }

        public void setCategory_id(String category_id) {
            this.category_id = category_id;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCreate_date() {
            return create_date;
        }

        public void setCreate_date(String create_date) {
            this.create_date = create_date;
        }

        private String create_date;
    }


}