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
    private String[] com1 = new String[9];
    private String[] com2 = new String[9];
    private String[] com3 = new String[9];

    DatabaseReference mData = FirebaseDatabase.getInstance().getReference().child("user");

    public UserData(String eMail) {

        eMail = eMail.replace(".", "!");
        DatabaseReference mUser = mData.child(eMail);
        mUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                name = dataSnapshot.child("name").getValue().toString();
                email = dataSnapshot.child("email").getValue().toString();
                picLink = dataSnapshot.child("picLink").getValue().toString();

//                System.out.println("TTEST========"+dataSnapshot.child("cList").getChildrenCount());
//                System.out.println("TTEST========"+dataSnapshot.getKey());

                com1[0] = dataSnapshot.child("cList").child("com1").child("name").getValue().toString();
                com1[1] = dataSnapshot.child("cList").child("com1").child("goal0").getValue().toString();
                com1[2] = dataSnapshot.child("cList").child("com1").child("goal1").getValue().toString();
                com1[3] = dataSnapshot.child("cList").child("com1").child("goal2").getValue().toString();
                com1[4] = dataSnapshot.child("cList").child("com1").child("goal3").getValue().toString();
                com1[5] = dataSnapshot.child("cList").child("com1").child("goal4").getValue().toString();
                com1[6] = dataSnapshot.child("cList").child("com1").child("goalD").getValue().toString();
                com1[7] = dataSnapshot.child("cList").child("com1").child("goalW").getValue().toString();
                com1[8] = dataSnapshot.child("cList").child("com1").child("goalM").getValue().toString();

                com2[0] = dataSnapshot.child("cList").child("com2").child("name").getValue().toString();
                com2[1] = dataSnapshot.child("cList").child("com2").child("goal0").getValue().toString();
                com2[2] = dataSnapshot.child("cList").child("com2").child("goal1").getValue().toString();
                com2[3] = dataSnapshot.child("cList").child("com2").child("goal2").getValue().toString();
                com2[4] = dataSnapshot.child("cList").child("com2").child("goal3").getValue().toString();
                com2[5] = dataSnapshot.child("cList").child("com2").child("goal4").getValue().toString();
                com2[6] = dataSnapshot.child("cList").child("com2").child("goalD").getValue().toString();
                com2[7] = dataSnapshot.child("cList").child("com2").child("goalW").getValue().toString();
                com2[8] = dataSnapshot.child("cList").child("com2").child("goalM").getValue().toString();

                com3[0] = dataSnapshot.child("cList").child("com3").child("name").getValue().toString();
                com3[1] = dataSnapshot.child("cList").child("com3").child("goal0").getValue().toString();
                com3[2] = dataSnapshot.child("cList").child("com3").child("goal1").getValue().toString();
                com3[3] = dataSnapshot.child("cList").child("com3").child("goal2").getValue().toString();
                com3[4] = dataSnapshot.child("cList").child("com3").child("goal3").getValue().toString();
                com3[5] = dataSnapshot.child("cList").child("com3").child("goal4").getValue().toString();
                com3[6] = dataSnapshot.child("cList").child("com3").child("goalD").getValue().toString();
                com3[7] = dataSnapshot.child("cList").child("com3").child("goalW").getValue().toString();
                com3[8] = dataSnapshot.child("cList").child("com3").child("goalM").getValue().toString();

//                System.out.println("SSICBAL!!!---"+name);
//                System.out.println("SSICBAL!!!---"+email);
//                System.out.println("SSICBAL!!!---"+picLink);
//                System.out.println("SSICBAL!!!---"+com2[2]);

                statUpdate();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void DataUpdate() {
        DatabaseReference uData = mData.child(email.replace(".","!"));
        uData.child("name").setValue(name);
        uData.child("email").setValue(email);
        uData.child("picLink").setValue(picLink);

        uData.child("cList").child("com1").child("name").setValue(com1[0]);
        uData.child("cList").child("com1").child("goal0").setValue(com1[1]);
        uData.child("cList").child("com1").child("goal1").setValue(com1[2]);
        uData.child("cList").child("com1").child("goal2").setValue(com1[3]);
        uData.child("cList").child("com1").child("goal3").setValue(com1[4]);
        uData.child("cList").child("com1").child("goal4").setValue(com1[5]);
        uData.child("cList").child("com1").child("goalD").setValue(com1[6]);
        uData.child("cList").child("com1").child("goalW").setValue(com1[7]);
        uData.child("cList").child("com1").child("goalM").setValue(com1[8]);

        uData.child("cList").child("com2").child("name").setValue(com2[0]);
        uData.child("cList").child("com2").child("goal0").setValue(com2[1]);
        uData.child("cList").child("com2").child("goal1").setValue(com2[2]);
        uData.child("cList").child("com2").child("goal2").setValue(com2[3]);
        uData.child("cList").child("com2").child("goal3").setValue(com2[4]);
        uData.child("cList").child("com2").child("goal4").setValue(com2[5]);
        uData.child("cList").child("com2").child("goalD").setValue(com1[6]);
        uData.child("cList").child("com2").child("goalW").setValue(com1[7]);
        uData.child("cList").child("com2").child("goalM").setValue(com1[8]);

        uData.child("cList").child("com3").child("name").setValue(com3[0]);
        uData.child("cList").child("com3").child("goal0").setValue(com3[1]);
        uData.child("cList").child("com3").child("goal1").setValue(com3[2]);
        uData.child("cList").child("com3").child("goal2").setValue(com3[3]);
        uData.child("cList").child("com3").child("goal3").setValue(com3[4]);
        uData.child("cList").child("com3").child("goal4").setValue(com3[5]);
        uData.child("cList").child("com3").child("goalD").setValue(com1[6]);
        uData.child("cList").child("com3").child("goalW").setValue(com1[7]);
        uData.child("cList").child("com3").child("goalM").setValue(com1[8]);
    }

    public void setUserName(String namae) {
        name = namae;
    }
    public void setUserPic(String link) {
        picLink = link;
    }
    public void setUserMail(String mail) {
        email = mail;
    }
    public void setUserCom1(String[] arr) {
        for(int i = 0; i < 9; i++) {
            com1[i] = arr[i];
        }
    }
    public void setUserCom2(String[] arr) {
        for(int i = 0; i < 9; i++) {
            com2[i] = arr[i];
        }
    }
    public void setUserCom3(String[] arr) {
        for(int i = 0; i < 9; i++) {
            com3[i] = arr[i];
        }
    }
    public String getUserName() {
        return name;
    }
    public String getUserPic() {
        return picLink;
    }
    public String getUserMail() {
        return email;
    }
    public String[] getUserCom1() {return com1;}
    public String[] getUserCom2() {return com2;}
    public String[] getUserCom3() {return com3;}

    private void statUpdate() {
//        System.out.println("SSICBAL@@@!!!---"+name);
//        System.out.println("SSICBAL@@@!!!---"+email);
//        System.out.println("SSICBAL@@@!!!---"+picLink);
//        System.out.println("SSICBAL@@@!!!---"+com2[2]);
        for(int i = 0; i < 9; i++) {
            GetUserData.com1[i] = com1[i];
            GetUserData.com2[i] = com2[i];
            GetUserData.com3[i] = com3[i];
        }
        GetUserData.name = name;
        GetUserData.email = email;
        GetUserData.picLink = picLink;
    }

    boolean checkStatus() {
        if(com1[0].isEmpty() || com2[0].isEmpty() || com3[0].isEmpty()) {
            return false;
        } else if(GetUserData.com1[0].isEmpty() || GetUserData.com2[0].isEmpty() || GetUserData.com3[0].isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    void easyComSet(String[] arr) {
        if(com1[0].equals("1")) {
            setUserCom1(arr);
        } else if(com2[0].equals("1")) {
            setUserCom2(arr);
        } else {
            setUserCom3(arr);
        }
        DataUpdate();
    }
}
