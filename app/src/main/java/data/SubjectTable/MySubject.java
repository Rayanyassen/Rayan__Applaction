package data.SubjectTable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class MySubject {
    @PrimaryKey(autoGenerate = true)
    public long keyid;//رقم المهمه
    public String Title;/// عنوان الموضوع


    public void setKeyid(long keyid) {
        this.keyid = keyid;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    @Override
    public String toString() {
        return "MySubject{" +
                "keyid=" + keyid +
                ", Title='" + Title + '\'' +
                '}';
    }
}

