package data.myTasksTable;
//هذا تمثل المهمه

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class MyTasks {
    public long keyid;//رقم المهمه
    String tasks;//المهمات
    int importance;//جه الاهمية
    long subjid;
    long userid;
    long time;//وقت انتاج المهمه

    public long getKeyid() {
        return keyid;
    }

    public void setKeyid(long keyid) {
        this.keyid = keyid;
    }

    public String getTasks() {
        return tasks;
    }

    public void setTasks(String tasks) {
        this.tasks = tasks;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public long getSubjid() {
        return subjid;
    }

    public void setSubjid(long subjid) {
        this.subjid = subjid;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "MyTasks{" +
                "keyid=" + keyid +
                ", tasks='" + tasks + '\'' +
                ", importance=" + importance +
                ", subjid=" + subjid +
                ", userid=" + userid +
                ", time=" + time +
                '}';
    }
}
