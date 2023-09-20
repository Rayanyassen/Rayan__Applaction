package data.myTasksTable;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao //واجهه استعلامات على جدول معطيات
public interface MyTasksQuery {
    @Query("SELECT * FROM mytasks")
    List<MyTasks> getallTasks();
    @Insert
    void insertTask(MyTasks...t); // ثلاثة نقاط تعني ادخال مجموعه
}
