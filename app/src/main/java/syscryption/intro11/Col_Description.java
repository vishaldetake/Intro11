package syscryption.intro11;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Col_Description extends AppCompatActivity {
    ImageView imageView;
    private Context mCtx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_col__description);
        imageView = (ImageView)findViewById(R.id.image_desc);

        Intent intent=getIntent();
        String Title=intent.getStringExtra("Title");
        String Desc=intent.getStringExtra("Desc");
        String Long_desc=intent.getStringExtra("Long_desc");
        String date=intent.getStringExtra("date");
        String img=intent.getStringExtra("img");

        ((TextView) findViewById(R.id.texttitle)).setText(Title);
        ((TextView) findViewById(R.id.text_date)).setText(Long_desc);
      ((TextView) findViewById(R.id.text_address)).setText(date);
       /* ((ImageView) findViewById(R.id.imageView)).setImageBitmap(img);*/
      Glide.with(this).load(img).into(imageView);

    }
}
