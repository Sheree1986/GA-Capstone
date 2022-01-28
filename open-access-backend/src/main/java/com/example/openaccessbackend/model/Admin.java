package com.example.openaccessbackend.model;

public class Admin {


    public class Admin extends User {

        public Admin() {
            super();
            this.setRole(Role.ADMIN);
        }

        public Admin(String username, String password) {
            super(username, password);
            this.setRole(Role.ADMIN);
        }

    }}
