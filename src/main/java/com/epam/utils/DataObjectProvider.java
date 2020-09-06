package com.epam.utils;

public class DataObjectProvider implements Constants {
    public static Object[][] getUsers() {
        int usersAmount = USERS.size();
        Object[][] users = new Object[usersAmount][];
        for (int i = 0; i < usersAmount; i++) {
            users[i] = new Object[]{USERS.get(i).getEmail(), USERS.get(i).getPassword()};
        }
        return users;
    }
}
