package na.mo.ri.levelup;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SsibalTestActivity extends AppCompatActivity {

    DatabaseReference jotkka = FirebaseDatabase.getInstance()
            .getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ssibal_test);

        Button ssib = findViewById(R.id.button4);

        ssib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //jotkka.setValue("ssoia");
                //jotkka.child("ssoia").setValue("emi");
                jotkka.child("user").push().child("name").setValue("nimo");
                String[] ss = {"ss", "ssdd", "as"};
                jotkka.child("user").child("mailmail").child("cList").child("com1").child("name").setValue("금연");

                jotkka.child("user").child("mailmail").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        System.out.println(dataSnapshot.child("community").getValue().toString());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                //jotkka.child("user").child("mailmail").child("name").push().setValue("Namori1");
                //jotkka.child("user").child("mailmail").child("name").push().setValue("Namori2");

            }
        });
    }
}
