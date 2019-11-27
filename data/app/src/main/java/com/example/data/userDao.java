package com.example.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface userDao {
    @Query("SELECT * from user")
    List<User> getAll();

    @Insert
    void insert(User user);
}
