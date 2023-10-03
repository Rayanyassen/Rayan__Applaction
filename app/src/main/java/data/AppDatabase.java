package data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import data.SubjectTable.MySubject;
import data.SubjectTable.MySubjectQuery;
import data.myTasksTable.MyTasks;
import data.myTasksTable.MyTasksQuery;
import data.usersTable.myUsersQuery;
import data.usersTable.myusers;

@Database(entities = {myusers.class, MySubject.class, MyTasks.class},version = 5)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase db;

    public abstract myUsersQuery getMyUserQuery();

    public abstract MySubjectQuery getMySubjectQuery();

    public abstract MyTasksQuery getMyTaskQuery();

    public static AppDatabase getDB(Context context) {
        if (db == null) {
            db = Room.databaseBuilder(context,
                            AppDatabase.class , "database-name")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return db;

    }
}
