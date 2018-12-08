package na.mo.ri.levelup;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

class UserData {
    private String name;
    private String email;
    private String picLink;
    //private int level;
    private String[] com1 = new String[6];
    private String[] com2 = new String[6];
    private String[] com3 = new String[6];

    DatabaseReference mData = FirebaseDatabase.getInstance().getReference().child("user");

    public UserData(String eMail) {
        eMail = eMail.replaceAll(".", "!");
        DatabaseReference mUser = mData.child(eMail);

        mUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //dataSnapshot.child("name").toString();
                DataRead(dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void DataRead(DataSnapshot ds) {
        this.name = ds.child("name").getValue().toString();
        this.email = ds.child("email").getValue().toString();
        this.picLink = ds.child("picLink").getValue().toString();
        //this.level = (Integer) ds.child("level").getValue();

        this.com1[0] = ds.child("cList").child("com1").child("name").getValue().toString();
        this.com1[1] = ds.child("cList").child("com1").child("goal0").getValue().toString();
        this.com1[2] = ds.child("cList").child("com1").child("goal1").getValue().toString();
        this.com1[3] = ds.child("cList").child("com1").child("goal2").getValue().toString();
        this.com1[4] = ds.child("cList").child("com1").child("goal3").getValue().toString();
        this.com1[5] = ds.child("cList").child("com1").child("goal4").getValue().toString();

        this.com2[0] = ds.child("cList").child("com2").child("name").getValue().toString();
        this.com2[1] = ds.child("cList").child("com2").child("goal0").getValue().toString();
        this.com2[2] = ds.child("cList").child("com2").child("goal1").getValue().toString();
        this.com2[3] = ds.child("cList").child("com2").child("goal2").getValue().toString();
        this.com2[4] = ds.child("cList").child("com2").child("goal3").getValue().toString();
        this.com2[5] = ds.child("cList").child("com2").child("goal4").getValue().toString();

        this.com3[0] = ds.child("cList").child("com3").child("name").getValue().toString();
        this.com3[1] = ds.child("cList").child("com3").child("goal0").getValue().toString();
        this.com3[2] = ds.child("cList").child("com3").child("goal1").getValue().toString();
        this.com3[3] = ds.child("cList").child("com3").child("goal2").getValue().toString();
        this.com3[4] = ds.child("cList").child("com3").child("goal3").getValue().toString();
        this.com3[5] = ds.child("cList").child("com3").child("goal4").getValue().toString();
    }

    public void DataUpdate() {
        DatabaseReference uData = mData.child(this.email.replaceAll(".","!"));
        uData.child("name").setValue(this.name);
        uData.child("email").setValue(this.email);
        uData.child("picLink").setValue(this.picLink);

        uData.child("cList").child("com1").child("name").setValue(this.com1[0]);
        uData.child("cList").child("com1").child("goal0").setValue(this.com1[1]);
        uData.child("cList").child("com1").child("goal1").setValue(this.com1[2]);
        uData.child("cList").child("com1").child("goal2").setValue(this.com1[3]);
        uData.child("cList").child("com1").child("goal3").setValue(this.com1[4]);
        uData.child("cList").child("com1").child("goal4").setValue(this.com1[5]);

        uData.child("cList").child("com2").child("name").setValue(this.com2[0]);
        uData.child("cList").child("com2").child("goal0").setValue(this.com2[1]);
        uData.child("cList").child("com2").child("goal1").setValue(this.com2[2]);
        uData.child("cList").child("com2").child("goal2").setValue(this.com2[3]);
        uData.child("cList").child("com2").child("goal3").setValue(this.com2[4]);
        uData.child("cList").child("com2").child("goal4").setValue(this.com2[5]);

        uData.child("cList").child("com3").child("name").setValue(this.com3[0]);
        uData.child("cList").child("com3").child("goal0").setValue(this.com3[1]);
        uData.child("cList").child("com3").child("goal1").setValue(this.com3[2]);
        uData.child("cList").child("com3").child("goal2").setValue(this.com3[3]);
        uData.child("cList").child("com3").child("goal3").setValue(this.com3[4]);
        uData.child("cList").child("com3").child("goal4").setValue(this.com3[5]);
    }

    public void setUserName(String namae) {
        this.name = namae;
    }
    public void setUserPic(String link) {
        this.picLink = link;
    }
    public void setUserMail(String mail) {
        this.email = mail;
    }
    public void setUserCom1(String[] arr) {
        this.com1 = arr;
    }
    public void setUserCom2(String[] arr) {
        this.com2 = arr;
    }
    public void setUserCom3(String[] arr) {
        this.com3 = arr;
    }
    public String getUserName() {
        return this.name;
    }
    public String getUserPic() {
        return this.picLink;
    }
    public String getUserMail() {
        return this.email;
    }
    public String[] getUserCom1() {return this.com1;}
    public String[] getUserCom2() {return this.com2;}
    public String[] getUserCom3() {return this.com3;}
}
