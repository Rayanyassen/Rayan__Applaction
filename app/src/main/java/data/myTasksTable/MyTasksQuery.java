package data.myTasksTable;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * واجهه استعلامات على جدول المعطيات
 */
@Dao
public interface MyTasksQuery {
    /**
     *اعاده جميع معطيات جدول المهمات
     * @return *اعاده قائمه من المهمات
     */
    @Query("SELECT * FROM mytasks")
    List<MyTasks> getallTasks();

    /**
     * قائمه من المهمات حسب رقم المستخدم بترتيب او حسب اقامه انتاج المهمه
     * @param userId_pp رقم الهويه الprimaryKey
     * @return * اعادة  قائمه من المهمات حسب رقم المستخدم بترتيب او حسب اقامه انتاج المهمه
     */

@Query( "SELECT * FROM MyTasks WHERE userid=:userId_pp " + "ORDER BY time DESC")
List<MyTasks> getallTasksOrderBYuserid(long userId_pp);

    /**
     * قائمه من المهمات الغير مكتمله بترتيب او حسب الاهمية
     * @param userid_p رقم الهويه ال primarykey
     * @param iscompleted_p المهمات غي      ر مكتمله
     * @return
     */
    @Query("SELECT * FROM Mytasks WHERE userid=:userid_p AND iscompleted=:iscompleted_p  " + "ORDER BY importance DESC" )
    List<MyTasks> getalltasksnotcompleted(long userid_p, boolean iscompleted_p);


    /**
     *  ادخال مهمات
     * @param t  مجموعه مهمات
     */
    @Insert
    void insertTask(MyTasks...t); // ثلاثة نقاط تعني ادخال مجموعه

    /**
     * تعديل المهمات
     * @param tasks مجموعه لتعديل المهمات (التعديل حسب المفتاح الرئيسي)
     */
    @Update
    void UpdateTask(MyTasks... tasks);

    /**
     * حذف  المهمات او مهمات
     * @param tasks حذف المهمات (حسب المفتاح الرئيسي)
     */

    @Delete
    void deletTask(MyTasks... tasks);

    @Query("DELETE FROM  Mytasks WHERE keyid=:kid  ")
    void deletTask(long  kid);





}

