package com.chat.fetchdatafromapi_volley;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class DeatailActivity extends AppCompatActivity {
    CircleImageView imageView;
    TextView titles,rating,detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemdetail);
        imageView=findViewById(R.id.dtestimg);
       titles=findViewById(R.id.dtitle_tv);
      rating=findViewById(R.id.drating);
        detail=findViewById(R.id.doverview);

        Bundle bundle=getIntent().getExtras();
        String title=bundle.getString("title");
        String pic=bundle.getString("poster");
        String desc=bundle.getString("overview");
       Double ratings=bundle.getDouble("rating");
        Glide.with(this).load(pic).into(imageView);
        titles.setText(title);
       rating.setText(ratings.toString());
       detail.setText(desc);

    }
}