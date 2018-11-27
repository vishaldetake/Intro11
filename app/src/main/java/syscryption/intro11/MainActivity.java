package syscryption.intro11;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.WindowCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.AdapterViewFlipper;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.RecyclerView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;


import java.util.Observable;

public class MainActivity extends AppCompatActivity {

    private static final String URL_PRODUCTS = "http://calendar.syscryption.org/webservice/get_cal_images.php";
    private static final String URL_PRODUCTS_FEB="http://calendar.syscryption.org/webservice/get_cal_images_feb.php";
    private static final String URL_PRODUCTS_MARCH="http://calendar.syscryption.org/webservice/get_cal_images_march.php";
    private static final String URL_PRODUCTS_APRIL="http://calendar.syscryption.org/webservice/get_cal_images_april.php";
    private static final String URL_PRODUCTS_MAY="http://calendar.syscryption.org/webservice/get_cal_images_may.php";
    private static final String URL_PRODUCTS_JUNE="http://calendar.syscryption.org/webservice/get_cal_images_june.php";
    private static final String URL_PRODUCTS_JULY="http://calendar.syscryption.org/webservice/get_cal_images_july.php";
    private static final String URL_PRODUCTS_AUGUST="http://calendar.syscryption.org/webservice/get_cal_images_august.php";
    private static final String URL_PRODUCTS_SEP="http://calendar.syscryption.org/webservice/get_cal_images_sep.php";
    private static final String URL_PRODUCTS_OCT="http://calendar.syscryption.org/webservice/get_cal_images_octo.php";
    private static final String URL_PRODUCTS_NOV="http://calendar.syscryption.org/webservice/get_cal_images_nov.php";
    private static final String URL_PRODUCTS_DEC="http://calendar.syscryption.org/webservice/get_cal_images_dec.php";

    public static final String BASE_URL = "http://calendar.syscryption.org/Web-Services/get_slider_images.php";
    private ViewPager viewPager;
    private Intromanager intromanager;

    private int[] layouts;

    //a list to store all the products
    List<Product> productList;

    private AdapterViewFlipper adapterViewFlipper;
    List<Hero> flipList;
    //the recyclerview
    RecyclerView recyclerView,recyclerView_feb,recyclerView_march,recyclerView_april,recyclerView_may,recyclerView_june,recyclerView_july,recyclerView_august,recyclerView_sep,recyclerView_oct,recyclerView_nov,recyclerView_dec;
    RecyclerView recyclerView_jan_col1;

 /*   Button next,skip;*/
    private ViewPagerAdapter viewPagerAdapter;
    private ImageView i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13,i14,i15,i16,i17,i18,i19,i20,i21,i22,i23,i24,i25,i26,i27,i28,i29,i30,i31,i32,i33,i34,i35,i36,i37;
    private ImageView f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16,f17,f18,f19,f20,f21,f22,f23,f24,f25,f26,f27,f28,f29,f30,f31,f32,f33,f34,f35;
    private ImageView m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,m13,m14,m15,m16,m17,m18,m19,m20,m21,m22,m23,m24,m25,m26,m27,m28,m29,m30,m31,m32,m33,m34,m35;
    private ImageView a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,a18,a19,a20,a21,a22,a23,a24,a25,a26,a27,a28,a29,a30,a31,a32,a33,a34,a35;
    private ImageView may1,may2,may3,may4,may5,may6,may7,may8,may9,may10,may11,may12,may13,may14,may15,may16,may17,may18,may19,may20,may21,may22,may23,may24,may25,may26,may27,may28,may29,may30,may31,may32,may33,may34,may35;
    private ImageView ju1,ju2,ju3,ju4,ju5,ju6,ju7,ju8,ju9,ju10,ju11,ju12,ju13,ju14,ju15,ju16,ju17,ju18,ju19,ju20,ju21,ju22,ju23,ju24,ju25,ju26,ju27,ju28,ju29,ju30,ju31,ju32,ju33,ju34,ju35;
    private ImageView jn1,jn2,jn3,jn4,jn5,jn6,jn7,jn8,jn9,jn10,jn11,jn12,jn13,jn14,jn15,jn16,jn17,jn18,jn19,jn20,jn21,jn22,jn23,jn24,jn25,jn26,jn27,jn28,jn29,jn30,jn31,jn32,jn33,jn34,jn35;
    private ImageView au1,au2,au3,au4,au5,au6,au7,au8,au9,au10,au11,au12,au13,au14,au15,au16,au17,au18,au19,au20,au21,au22,au23,au24,au25,au26,au27,au28,au29,au30,au31,au32,au33,au34,au35;
    private ImageView s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20,s21,s22,s23,s24,s25,s26,s27,s28,s29,s30,s31,s32,s33,s34,s35;
    private ImageView o1,o2,o3,o4,o5,o6,o7,o8,o9,o10,o11,o12,o13,o14,o15,o16,o17,o18,o19,o20,o21,o22,o23,o24,o25,o26,o27,o28,o29,o30,o31,o32,o33,o34,o35;
    private ImageView n1,n2,n3,n4,n5,n6,n7,n8,n9,n10,n11,n12,n13,n14,n15,n16,n17,n18,n19,n20,n21,n22,n23,n24,n25,n26,n27,n28,n29,n30,n31,n32,n33,n34,n35;
    private ImageView d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12,d13,d14,d15,d16,d17,d18,d19,d20,d21,d22,d23,d24,d25,d26,d27,d28,d29,d30,d31,d32,d33,d34,d35;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        builder= new AlertDialog.Builder(MainActivity.this);

        intromanager=new Intromanager(this);

        ActionBar actionbar=getSupportActionBar();
        actionbar.hide();
        adapterViewFlipper = (AdapterViewFlipper)findViewById(R.id.adapterViewFlipper);
        flipList = new ArrayList<>();




    if(!intromanager.Check())
        {
            intromanager.setFirst(false);
            Intent i=new Intent(MainActivity.this,Main2.class);
            startActivity(i);
            finish();
        }

        if(Build.VERSION.SDK_INT>=21)
        {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_FULLSCREEN);
        }



        viewPager=(ViewPager)findViewById(R.id.view_pager);

        layouts =new int[]{R.layout.screen_jan,R.layout.screen_feb,R.layout.screen_march,R.layout.screen_april,R.layout.screen_may,R.layout.screen_june,R.layout.scrren_july,R.layout.screen_agust,R.layout.screen_sep,R.layout.screen_oct,R.layout.screen_nov,R.layout.screen_dec};

        changeStatusBarColor();
        viewPagerAdapter =new ViewPagerAdapter();
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(viewListener);


            StringRequest stringRequest=new StringRequest(Request.Method.GET, BASE_URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        //converting the string to json array object

                        JSONArray array = new JSONArray(response);
                 /*  builder.setTitle("Response");
                    builder.setMessage("Response is:-"+response);
                    AlertDialog alertDialog=builder.create();
                    alertDialog.show();*/
                        //traversing through all the object
                        for (int i = 0; i < array.length(); i++) {

                            //getting product object from json array
                            JSONObject product = array.getJSONObject(i);
                            //adding the product to product list
                            flipList.add(new Hero(

                                    product.getString("image_url")

                            ));

                        }

                        //creating adapter object and setting it to recyclerview
                        //creating adapter object
                        FlipperAdapter adapter = new FlipperAdapter(MainActivity.this, (ArrayList<Hero>) flipList);

                        //adding it to adapterview flipper
                        adapterViewFlipper.setAdapter(adapter);
                        adapterViewFlipper.setFlipInterval(2000);
                        adapterViewFlipper.startFlipping();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });

            //adding our stringrequest to queue
            Volley.newRequestQueue(this).add(stringRequest);

    }



    private int getItem(int i)
    {
        return  viewPager.getCurrentItem() + 1;
    }

    ViewPager.OnPageChangeListener viewListener=new ViewPager.OnPageChangeListener()
    {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

          /*  if(position == layouts.length-1)
            {
                next.setText("PROCEED");
                skip.setVisibility(View.GONE);
            }
            else
            {
                next.setText("NEXT");
                skip.setVisibility(View.VISIBLE);
            }*/
         if(position == 0)
            {
                Toast.makeText(MainActivity.this,"Jan......"+position,Toast.LENGTH_SHORT).show();
                Jan();

            }else if(position == 1)
            {
                Toast.makeText(MainActivity.this,"Feb......"+position,Toast.LENGTH_SHORT).show();
                Feb();

            }else if(position == 2)
            {
                Toast.makeText(MainActivity.this,"March......"+position,Toast.LENGTH_SHORT).show();
              March();
            }else if(position == 3)
            {
               April();
            }else if(position == 4)
            {
                May();
            }else if(position == 5)
            {
                June();
            }else if(position == 6)
            {
                Jully();
            }else if(position == 7)
            {
                August();
            }else if(position == 8)
            {
                Sep();
            }else if(position == 9)
            {
                October();
            }else if(position == 10)
            {
                Nov();
            }else if(position == 11)
            {
               Dec();
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private void changeStatusBarColor()
    {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP)
        {
            Window window=getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    public class ViewPagerAdapter extends PagerAdapter
    {
        private LayoutInflater layoutInflater;

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v=layoutInflater.inflate(layouts[position],container,false);
            container.addView(v);
            return (v);


        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View v=(View)object;
            container.removeView(v);
        }
    }




    public void Jan()
    {
        i1 = (ImageView)findViewById(R.id.jan_genericblock1);
        i2 = (ImageView)findViewById(R.id.jan_genericblock2);
        i3 = (ImageView)findViewById(R.id.jan_genericblock3);
        i4 = (ImageView)findViewById(R.id.jan_genericblock4);
        i5 = (ImageView)findViewById(R.id.jan_genericblock5);
        i6 = (ImageView)findViewById(R.id.jan_genericblock6);
        i7 = (ImageView)findViewById(R.id.jan_genericblock7);
        i8 = (ImageView)findViewById(R.id.jan_genericblock8);
        i9 = (ImageView)findViewById(R.id.jan_genericblock9);
        i10 = (ImageView)findViewById(R.id.jan_genericblock10);
        i11 = (ImageView)findViewById(R.id.jan_genericblock11);
        i12 = (ImageView)findViewById(R.id.jan_genericblock12);
        i13 = (ImageView)findViewById(R.id.jan_genericblock13);
        i14 = (ImageView)findViewById(R.id.jan_genericblock14);
        i15 = (ImageView)findViewById(R.id.jan_genericblock15);
        i16 = (ImageView)findViewById(R.id.jan_genericblock16);
        i17 = (ImageView)findViewById(R.id.jan_genericblock17);
        i18 = (ImageView)findViewById(R.id.jan_genericblock18);
        i19 = (ImageView)findViewById(R.id.jan_genericblock19);
        i20 = (ImageView)findViewById(R.id.jan_genericblock20);
        i21 = (ImageView)findViewById(R.id.jan_genericblock21);
        i22 = (ImageView)findViewById(R.id.jan_genericblock22);
        i23 = (ImageView)findViewById(R.id.jan_genericblock23);
        i24 = (ImageView)findViewById(R.id.jan_genericblock24);
        i25 = (ImageView)findViewById(R.id.jan_genericblock25);
        i26 = (ImageView)findViewById(R.id.jan_genericblock26);
        i27 = (ImageView)findViewById(R.id.jan_genericblock27);
        i28 = (ImageView)findViewById(R.id.jan_genericblock28);
        i29 = (ImageView)findViewById(R.id.jan_genericblock29);
        i30 = (ImageView)findViewById(R.id.jan_genericblock30);
        i31 = (ImageView)findViewById(R.id.jan_genericblock31);
        i32 = (ImageView)findViewById(R.id.jan_genericblock32);
        i33 = (ImageView)findViewById(R.id.jan_genericblock33);
        i34 = (ImageView)findViewById(R.id.jan_genericblock34);
        i35 = (ImageView)findViewById(R.id.jan_genericblock35);
        i36 = (ImageView)findViewById(R.id.jan_img_header);
        i37 = (ImageView)findViewById(R.id.jan_img_footer);
        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recylcerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        productList = new ArrayList<>();

        //this method will fetch and parse json
        //to display it in recyclerview
        loadProducts();


        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Jan_Col1.class);
                String s="COL_1";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

            //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }

        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Jan_Col1.class);
                String s="COL_2";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
              /*  Intent i=new Intent(MainActivity.this,Jan_Col2.class);
                startActivity(i);*/
            }
        });

        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Jan_Col1.class);
                String s="COL_3";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Jan_Col1.class);
                String s="COL_4";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Jan_Col1.class);
                String s="COL_5";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        i6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Jan_Col1.class);
                String s="COL_6";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        i7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Jan_Col1.class);
                String s="COL_7";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        i8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Jan_Col1.class);
                String s="COL_8";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        i9.setOnClickListener(new View.OnClickListener() {
            @Override
              public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Jan_Col1.class);
                String s="COL_9";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });
        i10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Jan_Col1.class);
                String s="COL_10";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        i11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Jan_Col1.class);
                String s="COL_11";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        i12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Jan_Col1.class);
                String s="COL_12";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        i13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Jan_Col1.class);
                String s="COL_13";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        i14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Jan_Col1.class);
                String s="COL_14";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        i15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Jan_Col1.class);
                String s="COL_15";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        i16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Jan_Col1.class);
                String s="COL_16";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        i17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Jan_Col1.class);
                String s="COL_17";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        i18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Jan_Col1.class);
                String s="COL_18";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        i19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Jan_Col1.class);
                String s="COL_19";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        i20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Jan_Col1.class);
                String s="COL_20";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        i21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Jan_Col1.class);
                String s="COL_21";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        i22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Jan_Col1.class);
                String s="COL_22";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        i23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Jan_Col1.class);
                String s="COL_23";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        i24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Jan_Col1.class);
                String s="COL_24";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        i25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Jan_Col1.class);
                String s="COL_25";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        i26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Jan_Col1.class);
                String s="COL_26";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        i27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Jan_Col1.class);
                String s="COL_27";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        i28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Jan_Col1.class);
                String s="COL_28";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        i29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Jan_Col1.class);
                String s="COL_29";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        i30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Jan_Col1.class);
                String s="COL_30";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });
        i31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Jan_Col1.class);
                String s="COL_31";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });
        i32.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent i = new Intent(MainActivity.this, Jan_Col1.class);
            String s="COL_32";
            Bundle bundle = new Bundle();
            //Add your data to bundle
            bundle.putString("COL", s);

            //Add the bundle to the intent
            i.putExtras(bundle);

            startActivity(i);
        }
    });
        i33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Jan_Col1.class);
                String s="COL_33";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        i34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Jan_Col1.class);
                String s="COL_34";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        i35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Jan_Col1.class);
                String s="COL_35";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

    }


    public void March()
    {
        m1 = (ImageView)findViewById(R.id.march_genericblock1);
        m2 = (ImageView)findViewById(R.id.march_genericblock2);
        m3 = (ImageView)findViewById(R.id.march_genericblock3);
        m4 = (ImageView)findViewById(R.id.march_genericblock4);
        m5 = (ImageView)findViewById(R.id.march_genericblock5);
        m6 = (ImageView)findViewById(R.id.march_genericblock6);
        m7 = (ImageView)findViewById(R.id.march_genericblock7);
        m8 = (ImageView)findViewById(R.id.march_genericblock8);
        m9 = (ImageView)findViewById(R.id.march_genericblock9);
        m10 = (ImageView)findViewById(R.id.march_genericblock10);
        m11 = (ImageView)findViewById(R.id.march_genericblock11);
        m12 = (ImageView)findViewById(R.id.march_genericblock12);
        m13 = (ImageView)findViewById(R.id.march_genericblock13);
        m14 = (ImageView)findViewById(R.id.march_genericblock14);
        m15 = (ImageView)findViewById(R.id.march_genericblock15);
        m16 = (ImageView)findViewById(R.id.march_genericblock16);
        m17 = (ImageView)findViewById(R.id.march_genericblock17);
        m18 = (ImageView)findViewById(R.id.march_genericblock18);
        m19 = (ImageView)findViewById(R.id.march_genericblock19);
        m20 = (ImageView)findViewById(R.id.march_genericblock20);
        m21 = (ImageView)findViewById(R.id.march_genericblock21);
        m22 = (ImageView)findViewById(R.id.march_genericblock22);
        m23 = (ImageView)findViewById(R.id.march_genericblock23);
        m24 = (ImageView)findViewById(R.id.march_genericblock24);
        m25 = (ImageView)findViewById(R.id.march_genericblock25);
        m26 = (ImageView)findViewById(R.id.march_genericblock26);
        m27 = (ImageView)findViewById(R.id.march_genericblock27);
        m28 = (ImageView)findViewById(R.id.march_genericblock28);
        m29 = (ImageView)findViewById(R.id.march_genericblock29);
        m30 = (ImageView)findViewById(R.id.march_genericblock30);
        m31 = (ImageView)findViewById(R.id.march_genericblock31);
        m32 = (ImageView)findViewById(R.id.march_genericblock32);
        m33 = (ImageView)findViewById(R.id.march_genericblock33);
        m34 = (ImageView)findViewById(R.id.march_genericblock34);
        m35 = (ImageView)findViewById(R.id.march_genericblock35);

        recyclerView_march = (RecyclerView) findViewById(R.id.recylcerView_march);
        recyclerView_march.setHasFixedSize(true);
        recyclerView_march.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        productList = new ArrayList<>();

        //this method will fetch and parse json
        //to display it in recyclerview
        loadProducts_March();


        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, March_Col.class);
                String s="COL_1";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, March_Col.class);
                String s="COL_2";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, March_Col.class);
                String s="COL_3";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, March_Col.class);
                String s="COL_4";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        m5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, March_Col.class);
                String s="COL_5";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        m6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, March_Col.class);
                String s="COL_6";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        m7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, March_Col.class);
                String s="COL_7";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);

            }
        });

        m8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, March_Col.class);
                String s="COL_8";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        m9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, March_Col.class);
                String s="COL_9";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        m10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, March_Col.class);
                String s="COL_10";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        m11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, March_Col.class);
                String s="COL_11";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        m12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, March_Col.class);
                String s="COL_12";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        m13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, March_Col.class);
                String s="COL_13";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        m14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, March_Col.class);
                String s="COL_14";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        m15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, March_Col.class);
                String s="COL_15";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        m16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, March_Col.class);
                String s="COL_16";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        m17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, March_Col.class);
                String s="COL_17";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        m18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, March_Col.class);
                String s="COL_18";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        m19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, March_Col.class);
                String s="COL_19";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        m20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, March_Col.class);
                String s="COL_20";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        m21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, March_Col.class);
                String s="COL_21";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        m22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, March_Col.class);
                String s="COL_22";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        m23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, March_Col.class);
                String s="COL_23";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        m24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, March_Col.class);
                String s="COL_24";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        m25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, March_Col.class);
                String s="COL_25";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        m26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, March_Col.class);
                String s="COL_26";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        m27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, March_Col.class);
                String s="COL_27";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        m28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, March_Col.class);
                String s="COL_28";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        m29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, March_Col.class);
                String s="COL_29";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        m30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, March_Col.class);
                String s="COL_30";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        m31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, March_Col.class);
                String s="COL_31";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        m32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, March_Col.class);
                String s="COL_32";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });


        m33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, March_Col.class);
                String s="COL_33";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        m34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, March_Col.class);
                String s="COL_34";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        m35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, March_Col.class);
                String s="COL_35";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }

    public void April()
    {
        a1 = (ImageView)findViewById(R.id.april_genericblock1);
        a2 = (ImageView)findViewById(R.id.april_genericblock2);
        a3 = (ImageView)findViewById(R.id.april_genericblock3);
        a4 = (ImageView)findViewById(R.id.april_genericblock4);
        a5 = (ImageView)findViewById(R.id.april_genericblock5);
        a6 = (ImageView)findViewById(R.id.april_genericblock6);
        a7 = (ImageView)findViewById(R.id.april_genericblock7);
        a8 = (ImageView)findViewById(R.id.april_genericblock8);
        a9 = (ImageView)findViewById(R.id.april_genericblock9);
        a10 = (ImageView)findViewById(R.id.april_genericblock10);
        a11 = (ImageView)findViewById(R.id.april_genericblock11);
        a12 = (ImageView)findViewById(R.id.april_genericblock12);
        a13 = (ImageView)findViewById(R.id.april_genericblock13);
        a14 = (ImageView)findViewById(R.id.april_genericblock14);
        a15 = (ImageView)findViewById(R.id.april_genericblock15);
        a16 = (ImageView)findViewById(R.id.april_genericblock16);
        a17 = (ImageView)findViewById(R.id.april_genericblock17);
        a18 = (ImageView)findViewById(R.id.april_genericblock18);
        a19 = (ImageView)findViewById(R.id.april_genericblock19);
        a20 = (ImageView)findViewById(R.id.april_genericblock20);
        a21 = (ImageView)findViewById(R.id.april_genericblock21);
        a22 = (ImageView)findViewById(R.id.april_genericblock22);
        a23 = (ImageView)findViewById(R.id.april_genericblock23);
        a24 = (ImageView)findViewById(R.id.april_genericblock24);
        a25 = (ImageView)findViewById(R.id.april_genericblock25);
        a26 = (ImageView)findViewById(R.id.april_genericblock26);
        a27 = (ImageView)findViewById(R.id.april_genericblock27);
        a28 = (ImageView)findViewById(R.id.april_genericblock28);
        a29 = (ImageView)findViewById(R.id.april_genericblock29);
        a30 = (ImageView)findViewById(R.id.april_genericblock30);
        a31 = (ImageView)findViewById(R.id.april_genericblock31);
        a32 = (ImageView)findViewById(R.id.april_genericblock32);
        a33 = (ImageView)findViewById(R.id.april_genericblock33);
        a34 = (ImageView)findViewById(R.id.april_genericblock34);
        a35 = (ImageView)findViewById(R.id.april_genericblock35);

        recyclerView_april = (RecyclerView) findViewById(R.id.recylcerView_april);
        recyclerView_april.setHasFixedSize(true);
        recyclerView_april.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        productList = new ArrayList<>();

        //this method will fetch and parse json
        //to display it in recyclerview
        loadProducts_April();
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, April_Col.class);
                String s="COL_1";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, April_Col.class);
                String s="COL_2";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, April_Col.class);
                String s="COL_3";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, April_Col.class);
                String s="COL_4";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        a5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, April_Col.class);
                String s="COL_5";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        a6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, April_Col.class);
                String s="COL_6";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        a7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, April_Col.class);
                String s="COL_7";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);

            }
        });

        a8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, April_Col.class);
                String s="COL_8";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        a9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, April_Col.class);
                String s="COL_9";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        a10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, April_Col.class);
                String s="COL_10";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        a11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, April_Col.class);
                String s="COL_11";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        a12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, April_Col.class);
                String s="COL_12";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        a13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, April_Col.class);
                String s="COL_13";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        a14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, April_Col.class);
                String s="COL_14";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        a15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, April_Col.class);
                String s="COL_15";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        a16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, April_Col.class);
                String s="COL_16";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        a17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, April_Col.class);
                String s="COL_17";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        a18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, April_Col.class);
                String s="COL_18";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        a19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, April_Col.class);
                String s="COL_19";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        a20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, April_Col.class);
                String s="COL_20";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        a21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, April_Col.class);
                String s="COL_21";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        a22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, April_Col.class);
                String s="COL_22";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        a23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, April_Col.class);
                String s="COL_23";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        a24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, April_Col.class);
                String s="COL_24";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        a25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, April_Col.class);
                String s="COL_25";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        a26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, April_Col.class);
                String s="COL_26";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        a27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, April_Col.class);
                String s="COL_27";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        a28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, April_Col.class);
                String s="COL_28";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        a29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, April_Col.class);
                String s="COL_29";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        a30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, April_Col.class);
                String s="COL_30";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        a31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, April_Col.class);
                String s="COL_31";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        a32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, April_Col.class);
                String s="COL_32";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });


        a33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, April_Col.class);
                String s="COL_33";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        a34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, April_Col.class);
                String s="COL_34";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        a35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, April_Col.class);
                String s="COL_35";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }

    public void May()
    {
        may1 = (ImageView)findViewById(R.id.may_genericblock1);
        may2 = (ImageView)findViewById(R.id.may_genericblock2);
        may3 = (ImageView)findViewById(R.id.may_genericblock3);
        may4 = (ImageView)findViewById(R.id.may_genericblock4);
        may5 = (ImageView)findViewById(R.id.may_genericblock5);
        may6 = (ImageView)findViewById(R.id.may_genericblock6);
        may7 = (ImageView)findViewById(R.id.may_genericblock7);
        may8 = (ImageView)findViewById(R.id.may_genericblock8);
        may9 = (ImageView)findViewById(R.id.may_genericblock9);
        may10 = (ImageView)findViewById(R.id.may_genericblock10);
        may11 = (ImageView)findViewById(R.id.may_genericblock11);
        may12 = (ImageView)findViewById(R.id.may_genericblock12);
        may13 = (ImageView)findViewById(R.id.may_genericblock13);
        may14 = (ImageView)findViewById(R.id.may_genericblock14);
        may15 = (ImageView)findViewById(R.id.may_genericblock15);
        may16 = (ImageView)findViewById(R.id.may_genericblock16);
        may17 = (ImageView)findViewById(R.id.may_genericblock17);
        may18 = (ImageView)findViewById(R.id.may_genericblock18);
        may19 = (ImageView)findViewById(R.id.may_genericblock19);
        may20 = (ImageView)findViewById(R.id.may_genericblock20);
        may21 = (ImageView)findViewById(R.id.may_genericblock21);
        may22 = (ImageView)findViewById(R.id.may_genericblock22);
        may23 = (ImageView)findViewById(R.id.may_genericblock23);
        may24 = (ImageView)findViewById(R.id.may_genericblock24);
        may25 = (ImageView)findViewById(R.id.may_genericblock25);
        may26 = (ImageView)findViewById(R.id.may_genericblock26);
        may27 = (ImageView)findViewById(R.id.may_genericblock27);
        may28 = (ImageView)findViewById(R.id.may_genericblock28);
        may29 = (ImageView)findViewById(R.id.may_genericblock29);
        may30 = (ImageView)findViewById(R.id.may_genericblock30);
        may31 = (ImageView)findViewById(R.id.may_genericblock31);
        may32 = (ImageView)findViewById(R.id.may_genericblock32);
        may33 = (ImageView)findViewById(R.id.may_genericblock33);
        may34 = (ImageView)findViewById(R.id.may_genericblock34);
        may35 = (ImageView)findViewById(R.id.may_genericblock35);


        //getting the recyclerview from xml
        recyclerView_may = (RecyclerView) findViewById(R.id.recylcerView_may);
        recyclerView_may.setHasFixedSize(true);
        recyclerView_may.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        productList = new ArrayList<>();

        //this method will fetch and parse json
        //to display it in recyclerview
        loadProducts_May();

        may1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, May_Col.class);
                String s="COL_1";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        may2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, May_Col.class);
                String s="COL_2";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        may3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, May_Col.class);
                String s="COL_3";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        may4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, May_Col.class);
                String s="COL_4";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        may5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, May_Col.class);
                String s="COL_5";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        may6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, May_Col.class);
                String s="COL_6";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        may7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, May_Col.class);
                String s="COL_7";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);

            }
        });

        may8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, May_Col.class);
                String s="COL_8";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        may9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, May_Col.class);
                String s="COL_9";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        may10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, May_Col.class);
                String s="COL_10";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        may11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, May_Col.class);
                String s="COL_11";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        may12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, May_Col.class);
                String s="COL_12";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        may13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, May_Col.class);
                String s="COL_13";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        may14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, May_Col.class);
                String s="COL_14";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        may15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, May_Col.class);
                String s="COL_15";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        may16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, May_Col.class);
                String s="COL_16";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        may17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, May_Col.class);
                String s="COL_17";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        may18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, May_Col.class);
                String s="COL_18";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        may19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, May_Col.class);
                String s="COL_19";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        may20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, May_Col.class);
                String s="COL_20";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        may21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, May_Col.class);
                String s="COL_21";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        may22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, May_Col.class);
                String s="COL_22";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        may23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, May_Col.class);
                String s="COL_23";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        may24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, May_Col.class);
                String s="COL_24";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        may25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, May_Col.class);
                String s="COL_25";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        may26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, May_Col.class);
                String s="COL_26";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        may27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, May_Col.class);
                String s="COL_27";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        may28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, May_Col.class);
                String s="COL_28";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        may29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, May_Col.class);
                String s="COL_29";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        may30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, May_Col.class);
                String s="COL_30";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        may31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, May_Col.class);
                String s="COL_31";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        may32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, May_Col.class);
                String s="COL_32";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });


        may33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, May_Col.class);
                String s="COL_33";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        may34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, May_Col.class);
                String s="COL_34";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        may35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, May_Col.class);
                String s="COL_35";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }


    public void June()
    {
        jn1 = (ImageView)findViewById(R.id.june_genericblock1);
        jn2 = (ImageView)findViewById(R.id.june_genericblock2);
        jn3 = (ImageView)findViewById(R.id.june_genericblock3);
        jn4 = (ImageView)findViewById(R.id.june_genericblock4);
        jn5 = (ImageView)findViewById(R.id.june_genericblock5);
        jn6 = (ImageView)findViewById(R.id.june_genericblock6);
        jn7 = (ImageView)findViewById(R.id.june_genericblock7);
        jn8 = (ImageView)findViewById(R.id.june_genericblock8);
        jn9 = (ImageView)findViewById(R.id.june_genericblock9);
        jn10 = (ImageView)findViewById(R.id.june_genericblock10);
        jn11 = (ImageView)findViewById(R.id.june_genericblock11);
        jn12 = (ImageView)findViewById(R.id.june_genericblock12);
        jn13 = (ImageView)findViewById(R.id.june_genericblock13);
        jn14 = (ImageView)findViewById(R.id.june_genericblock14);
        jn15 = (ImageView)findViewById(R.id.june_genericblock15);
        jn16 = (ImageView)findViewById(R.id.june_genericblock16);
        jn17 = (ImageView)findViewById(R.id.june_genericblock17);
        jn18 = (ImageView)findViewById(R.id.june_genericblock18);
        jn19 = (ImageView)findViewById(R.id.june_genericblock19);
        jn20 = (ImageView)findViewById(R.id.june_genericblock20);
        jn21 = (ImageView)findViewById(R.id.june_genericblock21);
        jn22 = (ImageView)findViewById(R.id.june_genericblock22);
        jn23 = (ImageView)findViewById(R.id.june_genericblock23);
        jn24 = (ImageView)findViewById(R.id.june_genericblock24);
        jn25 = (ImageView)findViewById(R.id.june_genericblock25);
        jn26 = (ImageView)findViewById(R.id.june_genericblock26);
        jn27 = (ImageView)findViewById(R.id.june_genericblock27);
        jn28 = (ImageView)findViewById(R.id.june_genericblock28);
        jn29 = (ImageView)findViewById(R.id.june_genericblock29);
        jn30 = (ImageView)findViewById(R.id.june_genericblock30);
        jn31 = (ImageView)findViewById(R.id.june_genericblock31);
        jn32 = (ImageView)findViewById(R.id.june_genericblock32);
        jn33 = (ImageView)findViewById(R.id.june_genericblock33);
        jn34 = (ImageView)findViewById(R.id.june_genericblock34);
        jn35 = (ImageView)findViewById(R.id.june_genericblock35);

        //getting the recyclerview from xml
        recyclerView_june = (RecyclerView) findViewById(R.id.recylcerView_june);
        recyclerView_june.setHasFixedSize(true);
        recyclerView_june.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        productList = new ArrayList<>();

        //this method will fetch and parse json
        //to display it in recyclerview
        loadProducts_June();
        jn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, June_Col.class);
                String s="COL_1";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        jn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, June_Col.class);
                String s="COL_2";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        jn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, June_Col.class);
                String s="COL_3";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        jn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, June_Col.class);
                String s="COL_4";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        jn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, June_Col.class);
                String s="COL_5";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        jn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, June_Col.class);
                String s="COL_6";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        jn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, June_Col.class);
                String s="COL_7";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);

            }
        });

        jn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, June_Col.class);
                String s="COL_8";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        jn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, June_Col.class);
                String s="COL_9";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        jn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, June_Col.class);
                String s="COL_10";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        jn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, June_Col.class);
                String s="COL_11";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        jn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, June_Col.class);
                String s="COL_12";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        jn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, June_Col.class);
                String s="COL_13";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        jn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, June_Col.class);
                String s="COL_14";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        jn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, June_Col.class);
                String s="COL_15";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        jn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, June_Col.class);
                String s="COL_16";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        jn17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, June_Col.class);
                String s="COL_17";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        jn18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, June_Col.class);
                String s="COL_18";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        jn19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, June_Col.class);
                String s="COL_19";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        jn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, June_Col.class);
                String s="COL_20";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        jn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, June_Col.class);
                String s="COL_21";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        jn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, June_Col.class);
                String s="COL_22";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        jn23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, June_Col.class);
                String s="COL_23";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        jn24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, June_Col.class);
                String s="COL_24";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        jn25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, June_Col.class);
                String s="COL_25";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        jn26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, June_Col.class);
                String s="COL_26";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        jn27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, June_Col.class);
                String s="COL_27";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        jn28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, June_Col.class);
                String s="COL_28";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        jn29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, June_Col.class);
                String s="COL_29";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        jn30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, June_Col.class);
                String s="COL_30";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        jn31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, June_Col.class);
                String s="COL_31";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        jn32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, June_Col.class);
                String s="COL_32";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });


        jn33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, June_Col.class);
                String s="COL_33";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        jn34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, June_Col.class);
                String s="COL_34";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        jn35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, June_Col.class);
                String s="COL_35";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }


    public void Jully()
    {
        ju1 = (ImageView)findViewById(R.id.july_genericblock1);
        ju2 = (ImageView)findViewById(R.id.july_genericblock2);
        ju3 = (ImageView)findViewById(R.id.july_genericblock3);
        ju4 = (ImageView)findViewById(R.id.july_genericblock4);
        ju5 = (ImageView)findViewById(R.id.july_genericblock5);
        ju6 = (ImageView)findViewById(R.id.july_genericblock6);
        ju7 = (ImageView)findViewById(R.id.july_genericblock7);
        ju8 = (ImageView)findViewById(R.id.july_genericblock8);
        ju9 = (ImageView)findViewById(R.id.july_genericblock9);
        ju10 = (ImageView)findViewById(R.id.july_genericblock10);
        ju11 = (ImageView)findViewById(R.id.july_genericblock11);
        ju12 = (ImageView)findViewById(R.id.july_genericblock12);
        ju13 = (ImageView)findViewById(R.id.july_genericblock13);
        ju14 = (ImageView)findViewById(R.id.july_genericblock14);
        ju15 = (ImageView)findViewById(R.id.july_genericblock15);
        ju16 = (ImageView)findViewById(R.id.july_genericblock16);
        ju17 = (ImageView)findViewById(R.id.july_genericblock17);
        ju18 = (ImageView)findViewById(R.id.july_genericblock18);
        ju19 = (ImageView)findViewById(R.id.july_genericblock19);
        ju20 = (ImageView)findViewById(R.id.july_genericblock20);
        ju21 = (ImageView)findViewById(R.id.july_genericblock21);
        ju22 = (ImageView)findViewById(R.id.july_genericblock22);
        ju23 = (ImageView)findViewById(R.id.july_genericblock23);
        ju24 = (ImageView)findViewById(R.id.july_genericblock24);
        ju25 = (ImageView)findViewById(R.id.july_genericblock25);
        ju26 = (ImageView)findViewById(R.id.july_genericblock26);
        ju27 = (ImageView)findViewById(R.id.july_genericblock27);
        ju28 = (ImageView)findViewById(R.id.july_genericblock28);
        ju29 = (ImageView)findViewById(R.id.july_genericblock29);
        ju30 = (ImageView)findViewById(R.id.july_genericblock30);
        ju31 = (ImageView)findViewById(R.id.july_genericblock31);
        ju32 = (ImageView)findViewById(R.id.july_genericblock32);
        ju33 = (ImageView)findViewById(R.id.july_genericblock33);
        ju34 = (ImageView)findViewById(R.id.july_genericblock34);
        ju35 = (ImageView)findViewById(R.id.july_genericblock35);
        //getting the recyclerview from xml
        recyclerView_july = (RecyclerView) findViewById(R.id.recylcerView_july);
        recyclerView_july.setHasFixedSize(true);
        recyclerView_july.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        productList = new ArrayList<>();

        //this method will fetch and parse json
        //to display it in recyclerview
        loadProducts_July();

        ju1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, July_Col.class);
                String s="COL_1";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        ju2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, July_Col.class);
                String s="COL_2";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        ju3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, July_Col.class);
                String s="COL_3";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        ju4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, July_Col.class);
                String s="COL_4";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        ju5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, July_Col.class);
                String s="COL_5";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        ju6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, July_Col.class);
                String s="COL_6";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        ju7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, July_Col.class);
                String s="COL_7";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);

            }
        });

        ju8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, July_Col.class);
                String s="COL_8";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        ju9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, July_Col.class);
                String s="COL_9";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        ju10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, July_Col.class);
                String s="COL_10";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        ju11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, July_Col.class);
                String s="COL_11";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        ju12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, July_Col.class);
                String s="COL_12";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        ju13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, July_Col.class);
                String s="COL_13";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        ju14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, July_Col.class);
                String s="COL_14";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        ju15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, July_Col.class);
                String s="COL_15";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        ju16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, July_Col.class);
                String s="COL_16";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        ju17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, July_Col.class);
                String s="COL_17";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        ju18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, July_Col.class);
                String s="COL_18";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        ju19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, July_Col.class);
                String s="COL_19";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        ju20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, July_Col.class);
                String s="COL_20";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        ju21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, July_Col.class);
                String s="COL_21";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        ju22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, July_Col.class);
                String s="COL_22";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        ju23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, July_Col.class);
                String s="COL_23";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        ju24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, July_Col.class);
                String s="COL_24";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        ju25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, July_Col.class);
                String s="COL_25";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        ju26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, July_Col.class);
                String s="COL_26";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        ju27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, July_Col.class);
                String s="COL_27";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        ju28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, July_Col.class);
                String s="COL_28";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        ju29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, July_Col.class);
                String s="COL_29";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        ju30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, July_Col.class);
                String s="COL_30";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        ju31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, July_Col.class);
                String s="COL_31";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        ju32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, July_Col.class);
                String s="COL_32";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });


        ju33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, July_Col.class);
                String s="COL_33";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        ju34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, July_Col.class);
                String s="COL_34";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        ju35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, July_Col.class);
                String s="COL_35";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }
    public void August()
    {
        au1 = (ImageView)findViewById(R.id.au_genericblock1);
        au2 = (ImageView)findViewById(R.id.au_genericblock2);
        au3 = (ImageView)findViewById(R.id.au_genericblock3);
        au4 = (ImageView)findViewById(R.id.au_genericblock4);
        au5 = (ImageView)findViewById(R.id.au_genericblock5);
        au6 = (ImageView)findViewById(R.id.au_genericblock6);
        au7 = (ImageView)findViewById(R.id.au_genericblock7);
        au8 = (ImageView)findViewById(R.id.au_genericblock8);
        au9 = (ImageView)findViewById(R.id.au_genericblock9);
        au10 = (ImageView)findViewById(R.id.au_genericblock10);
        au11 = (ImageView)findViewById(R.id.au_genericblock11);
        au12 = (ImageView)findViewById(R.id.au_genericblock12);
        au13 = (ImageView)findViewById(R.id.au_genericblock13);
        au14 = (ImageView)findViewById(R.id.au_genericblock14);
        au15 = (ImageView)findViewById(R.id.au_genericblock15);
        au16 = (ImageView)findViewById(R.id.au_genericblock16);
        au17 = (ImageView)findViewById(R.id.au_genericblock17);
        au18 = (ImageView)findViewById(R.id.au_genericblock18);
        au19 = (ImageView)findViewById(R.id.au_genericblock19);
        au20 = (ImageView)findViewById(R.id.au_genericblock20);
        au21 = (ImageView)findViewById(R.id.au_genericblock21);
        au22 = (ImageView)findViewById(R.id.au_genericblock22);
        au23 = (ImageView)findViewById(R.id.au_genericblock23);
        au24 = (ImageView)findViewById(R.id.au_genericblock24);
        au25 = (ImageView)findViewById(R.id.au_genericblock25);
        au26 = (ImageView)findViewById(R.id.au_genericblock26);
        au27 = (ImageView)findViewById(R.id.au_genericblock27);
        au28 = (ImageView)findViewById(R.id.au_genericblock28);
        au29 = (ImageView)findViewById(R.id.au_genericblock29);
        au30 = (ImageView)findViewById(R.id.au_genericblock30);
        au31 = (ImageView)findViewById(R.id.au_genericblock31);
        au32 = (ImageView)findViewById(R.id.au_genericblock32);
        au33 = (ImageView)findViewById(R.id.au_genericblock33);
        au34 = (ImageView)findViewById(R.id.au_genericblock34);
        au35 = (ImageView)findViewById(R.id.au_genericblock35);

        recyclerView_august = (RecyclerView) findViewById(R.id.recylcerView_august);
        recyclerView_august.setHasFixedSize(true);
        recyclerView_august.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        productList = new ArrayList<>();

        //this method will fetch and parse json
        //to display it in recyclerview
        loadProducts_August();

        au1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, August_Col.class);
                String s="COL_1";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        au2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, August_Col.class);
                String s="COL_2";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        au3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, August_Col.class);
                String s="COL_3";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        au4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, August_Col.class);
                String s="COL_4";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        au5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, August_Col.class);
                String s="COL_5";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        au6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, August_Col.class);
                String s="COL_6";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        au7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, August_Col.class);
                String s="COL_7";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);

            }
        });

        au8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, August_Col.class);
                String s="COL_8";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        au9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, August_Col.class);
                String s="COL_9";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        au10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, August_Col.class);
                String s="COL_10";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        au11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, August_Col.class);
                String s="COL_11";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        au12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, August_Col.class);
                String s="COL_12";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        au13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, August_Col.class);
                String s="COL_13";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        au14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, August_Col.class);
                String s="COL_14";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        au15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, August_Col.class);
                String s="COL_15";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        au16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, August_Col.class);
                String s="COL_16";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        au17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, August_Col.class);
                String s="COL_17";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        au18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, August_Col.class);
                String s="COL_18";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        au19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, August_Col.class);
                String s="COL_19";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        au20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, August_Col.class);
                String s="COL_20";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        au21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, August_Col.class);
                String s="COL_21";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        au22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, August_Col.class);
                String s="COL_22";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        au23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, August_Col.class);
                String s="COL_23";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        au24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, August_Col.class);
                String s="COL_24";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        au25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, August_Col.class);
                String s="COL_25";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        au26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, August_Col.class);
                String s="COL_26";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        au27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, August_Col.class);
                String s="COL_27";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        au28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, August_Col.class);
                String s="COL_28";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        au29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, August_Col.class);
                String s="COL_29";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        au30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, August_Col.class);
                String s="COL_30";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        au31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, August_Col.class);
                String s="COL_31";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        au32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, August_Col.class);
                String s="COL_32";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });


        au33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, August_Col.class);
                String s="COL_33";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        au34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, August_Col.class);
                String s="COL_34";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        au35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, August_Col.class);
                String s="COL_35";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }

    public void Sep() {
        s1 = (ImageView) findViewById(R.id.sep_genericblock1);
        s2 = (ImageView) findViewById(R.id.sep_genericblock2);
        s3 = (ImageView) findViewById(R.id.sep_genericblock3);
        s4 = (ImageView) findViewById(R.id.sep_genericblock4);
        s5 = (ImageView) findViewById(R.id.sep_genericblock5);
        s6 = (ImageView) findViewById(R.id.sep_genericblock6);
        s7 = (ImageView) findViewById(R.id.sep_genericblock7);
        s8 = (ImageView) findViewById(R.id.sep_genericblock8);
        s9 = (ImageView) findViewById(R.id.sep_genericblock9);
        s10 = (ImageView) findViewById(R.id.sep_genericblock10);
        s11 = (ImageView) findViewById(R.id.sep_genericblock11);
        s12 = (ImageView) findViewById(R.id.sep_genericblock12);
        s13 = (ImageView) findViewById(R.id.sep_genericblock13);
        s14 = (ImageView) findViewById(R.id.sep_genericblock14);
        s15 = (ImageView) findViewById(R.id.sep_genericblock15);
        s16 = (ImageView) findViewById(R.id.sep_genericblock16);
        s17 = (ImageView) findViewById(R.id.sep_genericblock17);
        s18 = (ImageView) findViewById(R.id.sep_genericblock18);
        s19 = (ImageView) findViewById(R.id.sep_genericblock19);
        s20 = (ImageView) findViewById(R.id.sep_genericblock20);
        s21 = (ImageView) findViewById(R.id.sep_genericblock21);
        s22 = (ImageView) findViewById(R.id.sep_genericblock22);
        s23 = (ImageView) findViewById(R.id.sep_genericblock23);
        s24 = (ImageView) findViewById(R.id.sep_genericblock24);
        s25 = (ImageView) findViewById(R.id.sep_genericblock25);
        s26 = (ImageView) findViewById(R.id.sep_genericblock26);
        s27 = (ImageView) findViewById(R.id.sep_genericblock27);
        s28 = (ImageView) findViewById(R.id.sep_genericblock28);
        s29 = (ImageView) findViewById(R.id.sep_genericblock29);
        s30 = (ImageView) findViewById(R.id.sep_genericblock30);
        s31 = (ImageView) findViewById(R.id.sep_genericblock31);
        s32 = (ImageView) findViewById(R.id.sep_genericblock32);
        s33 = (ImageView) findViewById(R.id.sep_genericblock33);
        s34 = (ImageView) findViewById(R.id.sep_genericblock34);
        s35 = (ImageView) findViewById(R.id.sep_genericblock35);

        recyclerView_sep = (RecyclerView) findViewById(R.id.recylcerView_sep);
        recyclerView_sep.setHasFixedSize(true);
        recyclerView_sep.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        productList = new ArrayList<>();

        //this method will fetch and parse json
        //to display it in recyclerview
        loadProducts_Sep();

        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Sep_Col.class);
                String s="COL_1";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Sep_Col.class);
                String s="COL_2";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Sep_Col.class);
                String s="COL_3";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Sep_Col.class);
                String s="COL_4";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        s5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Sep_Col.class);
                String s="COL_5";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        s6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Sep_Col.class);
                String s="COL_6";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        s7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Sep_Col.class);
                String s="COL_7";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);

            }
        });

        s8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Sep_Col.class);
                String s="COL_8";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        s9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Sep_Col.class);
                String s="COL_9";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        s10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Sep_Col.class);
                String s="COL_10";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        s11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Sep_Col.class);
                String s="COL_11";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        s12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Sep_Col.class);
                String s="COL_12";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        s13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Sep_Col.class);
                String s="COL_13";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        s14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Sep_Col.class);
                String s="COL_14";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        s15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Sep_Col.class);
                String s="COL_15";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        s16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Sep_Col.class);
                String s="COL_16";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        s17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Sep_Col.class);
                String s="COL_17";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        s18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Sep_Col.class);
                String s="COL_18";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        s19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Sep_Col.class);
                String s="COL_19";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        s20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Sep_Col.class);
                String s="COL_20";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        s21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Sep_Col.class);
                String s="COL_21";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        s22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Sep_Col.class);
                String s="COL_22";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        s23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Sep_Col.class);
                String s="COL_23";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        s24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Sep_Col.class);
                String s="COL_24";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        s25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Sep_Col.class);
                String s="COL_25";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        s26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Sep_Col.class);
                String s="COL_26";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        s27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Sep_Col.class);
                String s="COL_27";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        s28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Sep_Col.class);
                String s="COL_28";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        s29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Sep_Col.class);
                String s="COL_29";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        s30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Sep_Col.class);
                String s="COL_30";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        s31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Sep_Col.class);
                String s="COL_31";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        s32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Sep_Col.class);
                String s="COL_32";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });


        s33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Sep_Col.class);
                String s="COL_33";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        s34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Sep_Col.class);
                String s="COL_34";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        s35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Sep_Col.class);
                String s="COL_35";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

    }


    public void October() {
        o1 = (ImageView) findViewById(R.id.oct_genericblock1);
        o2 = (ImageView) findViewById(R.id.oct_genericblock2);
        o3 = (ImageView) findViewById(R.id.oct_genericblock3);
        o4 = (ImageView) findViewById(R.id.oct_genericblock4);
        o5 = (ImageView) findViewById(R.id.oct_genericblock5);
        o6 = (ImageView) findViewById(R.id.oct_genericblock6);
        o7 = (ImageView) findViewById(R.id.oct_genericblock7);
        o8 = (ImageView) findViewById(R.id.oct_genericblock8);
        o9 = (ImageView) findViewById(R.id.oct_genericblock9);
        o10 = (ImageView) findViewById(R.id.oct_genericblock10);
        o11 = (ImageView) findViewById(R.id.oct_genericblock11);
        o12 = (ImageView) findViewById(R.id.oct_genericblock12);
        o13 = (ImageView) findViewById(R.id.oct_genericblock13);
        o14 = (ImageView) findViewById(R.id.oct_genericblock14);
        o15 = (ImageView) findViewById(R.id.oct_genericblock15);
        o16 = (ImageView) findViewById(R.id.oct_genericblock16);
        o17 = (ImageView) findViewById(R.id.oct_genericblock17);
        o18 = (ImageView) findViewById(R.id.oct_genericblock18);
        o19 = (ImageView) findViewById(R.id.oct_genericblock19);
        o20 = (ImageView) findViewById(R.id.oct_genericblock20);
        o21 = (ImageView) findViewById(R.id.oct_genericblock21);
        o22 = (ImageView) findViewById(R.id.oct_genericblock22);
        o23 = (ImageView) findViewById(R.id.oct_genericblock23);
        o24 = (ImageView) findViewById(R.id.oct_genericblock24);
        o25 = (ImageView) findViewById(R.id.oct_genericblock25);
        o26 = (ImageView) findViewById(R.id.oct_genericblock26);
        o27 = (ImageView) findViewById(R.id.oct_genericblock27);
        o28 = (ImageView) findViewById(R.id.oct_genericblock28);
        o29 = (ImageView) findViewById(R.id.oct_genericblock29);
        o30 = (ImageView) findViewById(R.id.oct_genericblock30);
        o31 = (ImageView) findViewById(R.id.oct_genericblock31);
        o32 = (ImageView) findViewById(R.id.oct_genericblock32);
        o33 = (ImageView) findViewById(R.id.oct_genericblock33);
        o34 = (ImageView) findViewById(R.id.oct_genericblock34);
        o35 = (ImageView) findViewById(R.id.oct_genericblock35);

        recyclerView_oct = (RecyclerView) findViewById(R.id.recylcerView_oct);
        recyclerView_oct.setHasFixedSize(true);
        recyclerView_oct.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        productList = new ArrayList<>();

        //this method will fetch and parse json
        //to display it in recyclerview
        loadProducts_Oct();

        o1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Oct_Col.class);
                String s="COL_1";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        o2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Oct_Col.class);
                String s="COL_2";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        o3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Oct_Col.class);
                String s="COL_3";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        o4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Oct_Col.class);
                String s="COL_4";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        o5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Oct_Col.class);
                String s="COL_5";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        o6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Oct_Col.class);
                String s="COL_6";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        o7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Oct_Col.class);
                String s="COL_7";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);

            }
        });

        o8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Oct_Col.class);
                String s="COL_8";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        o9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Oct_Col.class);
                String s="COL_9";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        o10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Oct_Col.class);
                String s="COL_10";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        o11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Oct_Col.class);
                String s="COL_11";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        o12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Oct_Col.class);
                String s="COL_12";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        o13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Oct_Col.class);
                String s="COL_13";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        o14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Oct_Col.class);
                String s="COL_14";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        o15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Oct_Col.class);
                String s="COL_15";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        o16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Oct_Col.class);
                String s="COL_16";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        o17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Oct_Col.class);
                String s="COL_17";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        o18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Oct_Col.class);
                String s="COL_18";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        o19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Oct_Col.class);
                String s="COL_19";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        o20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Oct_Col.class);
                String s="COL_20";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        o21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Oct_Col.class);
                String s="COL_21";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        o22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Oct_Col.class);
                String s="COL_22";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        o23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Oct_Col.class);
                String s="COL_23";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        o24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Oct_Col.class);
                String s="COL_24";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        o25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Oct_Col.class);
                String s="COL_25";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        o26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Oct_Col.class);
                String s="COL_26";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        o27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Oct_Col.class);
                String s="COL_27";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        o28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Oct_Col.class);
                String s="COL_28";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        o29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Oct_Col.class);
                String s="COL_29";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        o30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Oct_Col.class);
                String s="COL_30";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        o31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Oct_Col.class);
                String s="COL_31";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        o32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Oct_Col.class);
                String s="COL_32";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });


        o33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Oct_Col.class);
                String s="COL_33";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        o34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Oct_Col.class);
                String s="COL_34";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        o35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Oct_Col.class);
                String s="COL_35";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });


    }

    public void Nov() {
        n1 = (ImageView) findViewById(R.id.nov_genericblock1);
        n2 = (ImageView) findViewById(R.id.nov_genericblock2);
        n3 = (ImageView) findViewById(R.id.nov_genericblock3);
        n4 = (ImageView) findViewById(R.id.nov_genericblock4);
        n5 = (ImageView) findViewById(R.id.nov_genericblock5);
        n6 = (ImageView) findViewById(R.id.nov_genericblock6);
        n7 = (ImageView) findViewById(R.id.nov_genericblock7);
        n8 = (ImageView) findViewById(R.id.nov_genericblock8);
        n9 = (ImageView) findViewById(R.id.nov_genericblock9);
        n10 = (ImageView) findViewById(R.id.nov_genericblock10);
        n11 = (ImageView) findViewById(R.id.nov_genericblock11);
        n12 = (ImageView) findViewById(R.id.nov_genericblock12);
        n13 = (ImageView) findViewById(R.id.nov_genericblock13);
        n14 = (ImageView) findViewById(R.id.nov_genericblock14);
        n15 = (ImageView) findViewById(R.id.nov_genericblock15);
        n16 = (ImageView) findViewById(R.id.nov_genericblock16);
        n17 = (ImageView) findViewById(R.id.nov_genericblock17);
        n18 = (ImageView) findViewById(R.id.nov_genericblock18);
        n19 = (ImageView) findViewById(R.id.nov_genericblock19);
        n20 = (ImageView) findViewById(R.id.nov_genericblock20);
        n21 = (ImageView) findViewById(R.id.nov_genericblock21);
        n22 = (ImageView) findViewById(R.id.nov_genericblock22);
        n23 = (ImageView) findViewById(R.id.nov_genericblock23);
        n24 = (ImageView) findViewById(R.id.nov_genericblock24);
        n25 = (ImageView) findViewById(R.id.nov_genericblock25);
        n26 = (ImageView) findViewById(R.id.nov_genericblock26);
        n27 = (ImageView) findViewById(R.id.nov_genericblock27);
        n28 = (ImageView) findViewById(R.id.nov_genericblock28);
        n29 = (ImageView) findViewById(R.id.nov_genericblock29);
        n30 = (ImageView) findViewById(R.id.nov_genericblock30);
        n31 = (ImageView) findViewById(R.id.nov_genericblock31);
        n32 = (ImageView) findViewById(R.id.nov_genericblock32);
        n33 = (ImageView) findViewById(R.id.nov_genericblock33);
        n34 = (ImageView) findViewById(R.id.nov_genericblock34);
        n35 = (ImageView) findViewById(R.id.nov_genericblock35);

        recyclerView_nov = (RecyclerView) findViewById(R.id.recylcerView_nov);
        recyclerView_nov.setHasFixedSize(true);
        recyclerView_nov.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        productList = new ArrayList<>();

        //this method will fetch and parse json
        //to display it in recyclerview
        loadProducts_Nov();

        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_1";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_2";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_3";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        n4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_4";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        n5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_5";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        n6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_6";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        n7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_7";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);

            }
        });

        n8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_8";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        n9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_9";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        n10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_10";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        n11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_11";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        n12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_12";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        n13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_13";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        n14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_14";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        n15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_15";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        n16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_16";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        n17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_17";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        n18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_18";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        n19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_19";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        n20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_20";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        n21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_21";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        n22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_22";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        n23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_23";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        n24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_24";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        n25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_25";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        n26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_26";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        n27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_27";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        n28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_28";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        n29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_29";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        n30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_30";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        n31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_31";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        n32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_32";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });


        n33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_33";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        n34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_34";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        n35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_35";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

    }

    public void Dec() {
        d1 = (ImageView) findViewById(R.id.dec_genericblock1);
        d2 = (ImageView) findViewById(R.id.dec_genericblock2);
        d3 = (ImageView) findViewById(R.id.dec_genericblock3);
        d4 = (ImageView) findViewById(R.id.dec_genericblock4);
        d5 = (ImageView) findViewById(R.id.dec_genericblock5);
        d6 = (ImageView) findViewById(R.id.dec_genericblock6);
        d7 = (ImageView) findViewById(R.id.dec_genericblock7);
        d8 = (ImageView) findViewById(R.id.dec_genericblock8);
        d9 = (ImageView) findViewById(R.id.dec_genericblock9);
        d10 = (ImageView) findViewById(R.id.dec_genericblock10);
        d11 = (ImageView) findViewById(R.id.dec_genericblock11);
        d12 = (ImageView) findViewById(R.id.dec_genericblock12);
        d13 = (ImageView) findViewById(R.id.dec_genericblock13);
        d14 = (ImageView) findViewById(R.id.dec_genericblock14);
        d15 = (ImageView) findViewById(R.id.dec_genericblock15);
        d16 = (ImageView) findViewById(R.id.dec_genericblock16);
        d17 = (ImageView) findViewById(R.id.dec_genericblock17);
        d18 = (ImageView) findViewById(R.id.dec_genericblock18);
        d19 = (ImageView) findViewById(R.id.dec_genericblock19);
        d20 = (ImageView) findViewById(R.id.dec_genericblock20);
        d21 = (ImageView) findViewById(R.id.dec_genericblock21);
        d22 = (ImageView) findViewById(R.id.dec_genericblock22);
        d23 = (ImageView) findViewById(R.id.dec_genericblock23);
        d24 = (ImageView) findViewById(R.id.dec_genericblock24);
        d25 = (ImageView) findViewById(R.id.dec_genericblock25);
        d26 = (ImageView) findViewById(R.id.dec_genericblock26);
        d27 = (ImageView) findViewById(R.id.dec_genericblock27);
        d28 = (ImageView) findViewById(R.id.dec_genericblock28);
        d29 = (ImageView) findViewById(R.id.dec_genericblock29);
        d30 = (ImageView) findViewById(R.id.dec_genericblock30);
        d31 = (ImageView) findViewById(R.id.dec_genericblock31);
        d32 = (ImageView) findViewById(R.id.dec_genericblock32);
        d33 = (ImageView) findViewById(R.id.dec_genericblock33);
        d34 = (ImageView) findViewById(R.id.dec_genericblock34);
        d35 = (ImageView) findViewById(R.id.dec_genericblock35);

        recyclerView_dec = (RecyclerView) findViewById(R.id.recylcerView_dec);
        recyclerView_dec.setHasFixedSize(true);
        recyclerView_dec.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        productList = new ArrayList<>();

        //this method will fetch and parse json
        //to display it in recyclerview
        loadProducts_Dec();

        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_1";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_2";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        d3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_3";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        d4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_4";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        d5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_5";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        d6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_6";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        d7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_7";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);

            }
        });

        d8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_8";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        d9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_9";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        d10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_10";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        d11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_11";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        d12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_12";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        d13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_13";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        d14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_14";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        d15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_15";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        d16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_16";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        d17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_17";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        d18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_18";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        d19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_19";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        d20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_20";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        d21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_21";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        d22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_22";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        d23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_23";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        d24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_24";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        d25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_25";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        d26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_26";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        d27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_27";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        d28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_28";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        d29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_29";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        d30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_30";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        d31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_31";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        d32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_32";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });


        d33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_33";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        d34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_34";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        d35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Nov_Col.class);
                String s="COL_35";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

    }

    private void loadProducts() {

        /*
        * Creating a String Request
        * The request type is GET defined by first parameter
        * The URL is defined in the second parameter
        * Then we have a Response Listener and a Error Listener
        * In response listener we will get the JSON response as a String
        * */

        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL_PRODUCTS, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                   /* builder.setTitle("Response");
                    builder.setMessage("Response is:-"+response);
                    AlertDialog alertDialog=builder.create();
                    alertDialog.show();*/
                    //converting the string to json array object

                    JSONArray array = new JSONArray(response);

                    //traversing through all the object
                    for (int i = 0; i < array.length(); i++) {

                        //getting product object from json array
                        JSONObject product = array.getJSONObject(i);
                        //adding the product to product list
                        productList.add(new Product(

                                product.getString("col_1"), product.getString("col_2"), product.getString("col_3"),
                                product.getString("col_4"), product.getString("col_5"), product.getString("col_6"),
                                product.getString("col_7"), product.getString("col_8"), product.getString("col_9"),
                                product.getString("col_10"),product.getString("col_11"),product.getString("col_12"),
                                product.getString("col_13"),product.getString("col_14"),product.getString("col_15"),
                                product.getString("col_16"),product.getString("col_17"),product.getString("col_18"),
                                product.getString("col_19"),product.getString("col_20"),product.getString("col_21"),
                                product.getString("col_22"),product.getString("col_23"),product.getString("col_24"),
                                product.getString("col_25"),product.getString("col_26"),product.getString("col_27")
                                ,product.getString("col_28"),product.getString("col_29"),product.getString("col_30"),
                                product.getString("col_31"),product.getString("col_32"),product.getString("col_33"),
                                product.getString("col_34"),product.getString("col_35"),product.getString("col_header"),product.getString("col_footer")

                        ));
                    }

                    //creating adapter object and setting it to recyclerview
                    ProductsAdapter adapter = new ProductsAdapter(MainActivity.this, productList);
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT);
            }
        });
 
        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }
    private void loadProducts_feb() {

        /*
        * Creating a String Request
        * The request type is GET defined by first parameter
        * The URL is defined in the second parameter
        * Then we have a Response Listener and a Error Listener
        * In response listener we will get the JSON response as a String
        * */

        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL_PRODUCTS_FEB, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    //converting the string to json array object

                    JSONArray array = new JSONArray(response);

                    //traversing through all the object
                    for (int i = 0; i < array.length(); i++) {

                        //getting product object from json array
                        JSONObject product = array.getJSONObject(i);
                        //adding the product to product list
                        productList.add(new Product(

                                product.getString("col_1"), product.getString("col_2"), product.getString("col_3"),
                                product.getString("col_4"), product.getString("col_5"), product.getString("col_6"),
                                product.getString("col_7"), product.getString("col_8"), product.getString("col_9"),
                                product.getString("col_10"),product.getString("col_11"),product.getString("col_12"),
                                product.getString("col_13"),product.getString("col_14"),product.getString("col_15"),
                                product.getString("col_16"),product.getString("col_17"),product.getString("col_18"),
                                product.getString("col_19"),product.getString("col_20"),product.getString("col_21"),
                                product.getString("col_22"),product.getString("col_23"),product.getString("col_24"),
                                product.getString("col_25"),product.getString("col_26"),product.getString("col_27")
                                ,product.getString("col_28"),product.getString("col_29"),product.getString("col_30"),
                                product.getString("col_31"),product.getString("col_32"),product.getString("col_33"),
                                product.getString("col_34"),product.getString("col_35"),product.getString("col_header"),product.getString("col_footer")

                        ));
                    }

                    //creating adapter object and setting it to recyclerview
                    ProductsAdapterFeb adapter = new ProductsAdapterFeb(MainActivity.this, productList);
                    recyclerView_feb.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),
                        "Error",
                        Toast.LENGTH_SHORT);
            }
        });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }
    private void loadProducts_March() {


        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL_PRODUCTS_MARCH, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    //converting the string to json array object

                    JSONArray array = new JSONArray(response);

                    //traversing through all the object
                    for (int i = 0; i < array.length(); i++) {

                        //getting product object from json array
                        JSONObject product = array.getJSONObject(i);
                        //adding the product to product list
                        productList.add(new Product(

                                product.getString("col_1"), product.getString("col_2"), product.getString("col_3"),
                                product.getString("col_4"), product.getString("col_5"), product.getString("col_6"),
                                product.getString("col_7"), product.getString("col_8"), product.getString("col_9"),
                                product.getString("col_10"),product.getString("col_11"),product.getString("col_12"),
                                product.getString("col_13"),product.getString("col_14"),product.getString("col_15"),
                                product.getString("col_16"),product.getString("col_17"),product.getString("col_18"),
                                product.getString("col_19"),product.getString("col_20"),product.getString("col_21"),
                                product.getString("col_22"),product.getString("col_23"),product.getString("col_24"),
                                product.getString("col_25"),product.getString("col_26"),product.getString("col_27")
                                ,product.getString("col_28"),product.getString("col_29"),product.getString("col_30"),
                                product.getString("col_31"),product.getString("col_32"),product.getString("col_33"),
                                product.getString("col_34"),product.getString("col_35"),product.getString("col_header"),product.getString("col_footer")

                        ));
                    }

                    //creating adapter object and setting it to recyclerview
                    ProductsAdapterMarch adapter = new ProductsAdapterMarch(MainActivity.this, productList);
                    recyclerView_march.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),
                        "Error",
                        Toast.LENGTH_SHORT);
            }
        });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }
    private void loadProducts_April()
    {
        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL_PRODUCTS_APRIL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    //converting the string to json array object

                    JSONArray array = new JSONArray(response);

                    //traversing through all the object
                    for (int i = 0; i < array.length(); i++) {

                        //getting product object from json array
                        JSONObject product = array.getJSONObject(i);
                        //adding the product to product list
                        productList.add(new Product(

                                product.getString("col_1"), product.getString("col_2"), product.getString("col_3"),
                                product.getString("col_4"), product.getString("col_5"), product.getString("col_6"),
                                product.getString("col_7"), product.getString("col_8"), product.getString("col_9"),
                                product.getString("col_10"),product.getString("col_11"),product.getString("col_12"),
                                product.getString("col_13"),product.getString("col_14"),product.getString("col_15"),
                                product.getString("col_16"),product.getString("col_17"),product.getString("col_18"),
                                product.getString("col_19"),product.getString("col_20"),product.getString("col_21"),
                                product.getString("col_22"),product.getString("col_23"),product.getString("col_24"),
                                product.getString("col_25"),product.getString("col_26"),product.getString("col_27")
                                ,product.getString("col_28"),product.getString("col_29"),product.getString("col_30"),
                                product.getString("col_31"),product.getString("col_32"),product.getString("col_33"),
                                product.getString("col_34"),product.getString("col_35"),product.getString("col_header"),product.getString("col_footer")

                        ));
                    }

                    //creating adapter object and setting it to recyclerview
                    ProductsAdapterApril adapter = new ProductsAdapterApril(MainActivity.this, productList);
                    recyclerView_april.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),
                        "Error",
                        Toast.LENGTH_SHORT);
            }
        });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }

    private void loadProducts_May()
    {
        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL_PRODUCTS_MAY, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    //converting the string to json array object

                    JSONArray array = new JSONArray(response);

                    //traversing through all the object
                    for (int i = 0; i < array.length(); i++) {

                        //getting product object from json array
                        JSONObject product = array.getJSONObject(i);
                        //adding the product to product list
                        productList.add(new Product(

                                product.getString("col_1"), product.getString("col_2"), product.getString("col_3"),
                                product.getString("col_4"), product.getString("col_5"), product.getString("col_6"),
                                product.getString("col_7"), product.getString("col_8"), product.getString("col_9"),
                                product.getString("col_10"),product.getString("col_11"),product.getString("col_12"),
                                product.getString("col_13"),product.getString("col_14"),product.getString("col_15"),
                                product.getString("col_16"),product.getString("col_17"),product.getString("col_18"),
                                product.getString("col_19"),product.getString("col_20"),product.getString("col_21"),
                                product.getString("col_22"),product.getString("col_23"),product.getString("col_24"),
                                product.getString("col_25"),product.getString("col_26"),product.getString("col_27")
                                ,product.getString("col_28"),product.getString("col_29"),product.getString("col_30"),
                                product.getString("col_31"),product.getString("col_32"),product.getString("col_33"),
                                product.getString("col_34"),product.getString("col_35"),product.getString("col_header"),product.getString("col_footer")

                        ));
                    }

                    //creating adapter object and setting it to recyclerview
                    ProductsAdapterMay adapter = new ProductsAdapterMay(MainActivity.this, productList);
                    recyclerView_may.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),
                        "Error",
                        Toast.LENGTH_SHORT);
            }
        });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }

    private void loadProducts_June()
    {
        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL_PRODUCTS_JUNE, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    //converting the string to json array object

                    JSONArray array = new JSONArray(response);

                    //traversing through all the object
                    for (int i = 0; i < array.length(); i++) {

                        //getting product object from json array
                        JSONObject product = array.getJSONObject(i);
                        //adding the product to product list
                        productList.add(new Product(
                                product.getString("col_1"), product.getString("col_2"), product.getString("col_3"),
                                product.getString("col_4"), product.getString("col_5"), product.getString("col_6"),
                                product.getString("col_7"), product.getString("col_8"), product.getString("col_9"),
                                product.getString("col_10"),product.getString("col_11"),product.getString("col_12"),
                                product.getString("col_13"),product.getString("col_14"),product.getString("col_15"),
                                product.getString("col_16"),product.getString("col_17"),product.getString("col_18"),
                                product.getString("col_19"),product.getString("col_20"),product.getString("col_21"),
                                product.getString("col_22"),product.getString("col_23"),product.getString("col_24"),
                                product.getString("col_25"),product.getString("col_26"),product.getString("col_27")
                                ,product.getString("col_28"),product.getString("col_29"),product.getString("col_30"),
                                product.getString("col_31"),product.getString("col_32"),product.getString("col_33"),
                                product.getString("col_34"),product.getString("col_35"),product.getString("col_header"),product.getString("col_footer")

                        ));
                    }

                    //creating adapter object and setting it to recyclerview
                    ProductsAdapterJune adapter = new ProductsAdapterJune(MainActivity.this, productList);
                    recyclerView_june.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),
                        "Error",
                        Toast.LENGTH_SHORT);
            }
        });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }

    private void loadProducts_July()
    {
        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL_PRODUCTS_JULY, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    //converting the string to json array object

                    JSONArray array = new JSONArray(response);

                    //traversing through all the object
                    for (int i = 0; i < array.length(); i++) {

                        //getting product object from json array
                        JSONObject product = array.getJSONObject(i);
                        //adding the product to product list
                        productList.add(new Product(

                                product.getString("col_1"), product.getString("col_2"), product.getString("col_3"),
                                product.getString("col_4"), product.getString("col_5"), product.getString("col_6"),
                                product.getString("col_7"), product.getString("col_8"), product.getString("col_9"),
                                product.getString("col_10"),product.getString("col_11"),product.getString("col_12"),
                                product.getString("col_13"),product.getString("col_14"),product.getString("col_15"),
                                product.getString("col_16"),product.getString("col_17"),product.getString("col_18"),
                                product.getString("col_19"),product.getString("col_20"),product.getString("col_21"),
                                product.getString("col_22"),product.getString("col_23"),product.getString("col_24"),
                                product.getString("col_25"),product.getString("col_26"),product.getString("col_27")
                                ,product.getString("col_28"),product.getString("col_29"),product.getString("col_30"),
                                product.getString("col_31"),product.getString("col_32"),product.getString("col_33"),
                                product.getString("col_34"),product.getString("col_35"),product.getString("col_header"),product.getString("col_footer")
                        ));
                    }

                    //creating adapter object and setting it to recyclerview
                    ProductsAdapterJuly adapter = new ProductsAdapterJuly(MainActivity.this, productList);
                    recyclerView_july.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),
                        "Error",
                        Toast.LENGTH_SHORT);
            }
        });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }

    private void loadProducts_August()
    {
        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL_PRODUCTS_AUGUST, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    //converting the string to json array object

                    JSONArray array = new JSONArray(response);

                    //traversing through all the object
                    for (int i = 0; i < array.length(); i++) {

                        //getting product object from json array
                        JSONObject product = array.getJSONObject(i);
                        //adding the product to product list
                        productList.add(new Product(

                                product.getString("col_1"), product.getString("col_2"), product.getString("col_3"),
                                product.getString("col_4"), product.getString("col_5"), product.getString("col_6"),
                                product.getString("col_7"), product.getString("col_8"), product.getString("col_9"),
                                product.getString("col_10"),product.getString("col_11"),product.getString("col_12"),
                                product.getString("col_13"),product.getString("col_14"),product.getString("col_15"),
                                product.getString("col_16"),product.getString("col_17"),product.getString("col_18"),
                                product.getString("col_19"),product.getString("col_20"),product.getString("col_21"),
                                product.getString("col_22"),product.getString("col_23"),product.getString("col_24"),
                                product.getString("col_25"),product.getString("col_26"),product.getString("col_27")
                                ,product.getString("col_28"),product.getString("col_29"),product.getString("col_30"),
                                product.getString("col_31"),product.getString("col_32"),product.getString("col_33"),
                                product.getString("col_34"),product.getString("col_35"),product.getString("col_header"),product.getString("col_footer")

                        ));
                    }

                    //creating adapter object and setting it to recyclerview
                    ProductsAdapterAugust adapter = new ProductsAdapterAugust(MainActivity.this, productList);
                    recyclerView_august.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),
                        "Error",
                        Toast.LENGTH_SHORT);
            }
        });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }

    private void loadProducts_Sep()
    {
        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL_PRODUCTS_SEP, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    //converting the string to json array object

                    JSONArray array = new JSONArray(response);

                    //traversing through all the object
                    for (int i = 0; i < array.length(); i++) {

                        //getting product object from json array
                        JSONObject product = array.getJSONObject(i);
                        //adding the product to product list
                        productList.add(new Product(

                                product.getString("col_1"), product.getString("col_2"), product.getString("col_3"),
                                product.getString("col_4"), product.getString("col_5"), product.getString("col_6"),
                                product.getString("col_7"), product.getString("col_8"), product.getString("col_9"),
                                product.getString("col_10"),product.getString("col_11"),product.getString("col_12"),
                                product.getString("col_13"),product.getString("col_14"),product.getString("col_15"),
                                product.getString("col_16"),product.getString("col_17"),product.getString("col_18"),
                                product.getString("col_19"),product.getString("col_20"),product.getString("col_21"),
                                product.getString("col_22"),product.getString("col_23"),product.getString("col_24"),
                                product.getString("col_25"),product.getString("col_26"),product.getString("col_27")
                                ,product.getString("col_28"),product.getString("col_29"),product.getString("col_30"),
                                product.getString("col_31"),product.getString("col_32"),product.getString("col_33"),
                                product.getString("col_34"),product.getString("col_35"),product.getString("col_header"),product.getString("col_footer")

                        ));
                    }

                    //creating adapter object and setting it to recyclerview
                    ProductsAdapterSep adapter = new ProductsAdapterSep(MainActivity.this, productList);
                    recyclerView_sep.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),
                        "Error",
                        Toast.LENGTH_SHORT);
            }
        });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }

    private void loadProducts_Oct()
    {
        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL_PRODUCTS_OCT, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    //converting the string to json array object

                    JSONArray array = new JSONArray(response);

                    //traversing through all the object
                    for (int i = 0; i < array.length(); i++) {

                        //getting product object from json array
                        JSONObject product = array.getJSONObject(i);
                        //adding the product to product list
                        productList.add(new Product(

                                product.getString("col_1"), product.getString("col_2"), product.getString("col_3"),
                                product.getString("col_4"), product.getString("col_5"), product.getString("col_6"),
                                product.getString("col_7"), product.getString("col_8"), product.getString("col_9"),
                                product.getString("col_10"),product.getString("col_11"),product.getString("col_12"),
                                product.getString("col_13"),product.getString("col_14"),product.getString("col_15"),
                                product.getString("col_16"),product.getString("col_17"),product.getString("col_18"),
                                product.getString("col_19"),product.getString("col_20"),product.getString("col_21"),
                                product.getString("col_22"),product.getString("col_23"),product.getString("col_24"),
                                product.getString("col_25"),product.getString("col_26"),product.getString("col_27")
                                ,product.getString("col_28"),product.getString("col_29"),product.getString("col_30"),
                                product.getString("col_31"),product.getString("col_32"),product.getString("col_33"),
                                product.getString("col_34"),product.getString("col_35"),product.getString("col_header"),product.getString("col_footer")

                        ));
                    }

                    //creating adapter object and setting it to recyclerview
                    ProductsAdapterOct adapter = new ProductsAdapterOct(MainActivity.this, productList);
                    recyclerView_oct.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),
                        "Error",
                        Toast.LENGTH_SHORT);
            }
        });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }

    public void Feb()
    {
        f1 = (ImageView)findViewById(R.id.feb_genericblock1);
        f2 = (ImageView)findViewById(R.id.feb_genericblock2);
        f3 = (ImageView)findViewById(R.id.feb_genericblock3);
        f4 = (ImageView)findViewById(R.id.feb_genericblock4);
        f5 = (ImageView)findViewById(R.id.feb_genericblock5);
        f6 = (ImageView)findViewById(R.id.feb_genericblock6);
        f7 = (ImageView)findViewById(R.id.feb_genericblock7);
        f8 = (ImageView)findViewById(R.id.feb_genericblock8);
        f9 = (ImageView)findViewById(R.id.feb_genericblock9);
        f10 = (ImageView)findViewById(R.id.feb_genericblock10);
        f11 = (ImageView)findViewById(R.id.feb_genericblock11);
        f12 = (ImageView)findViewById(R.id.feb_genericblock12);
        f13 = (ImageView)findViewById(R.id.feb_genericblock13);
        f14 = (ImageView)findViewById(R.id.feb_genericblock14);
        f15 = (ImageView)findViewById(R.id.feb_genericblock15);
        f16 = (ImageView)findViewById(R.id.feb_genericblock16);
        f17 = (ImageView)findViewById(R.id.feb_genericblock17);
        f18 = (ImageView)findViewById(R.id.feb_genericblock18);
        f19 = (ImageView)findViewById(R.id.feb_genericblock19);
        f20 = (ImageView)findViewById(R.id.feb_genericblock20);
        f21 = (ImageView)findViewById(R.id.feb_genericblock21);
        f22 = (ImageView)findViewById(R.id.feb_genericblock22);
        f23 = (ImageView)findViewById(R.id.feb_genericblock23);
        f24 = (ImageView)findViewById(R.id.feb_genericblock24);
        f25 = (ImageView)findViewById(R.id.feb_genericblock25);
        f26 = (ImageView)findViewById(R.id.feb_genericblock26);
        f27 = (ImageView)findViewById(R.id.feb_genericblock27);
        f28 = (ImageView)findViewById(R.id.feb_genericblock28);
        f29 = (ImageView)findViewById(R.id.feb_genericblock29);
        f30 = (ImageView)findViewById(R.id.feb_genericblock30);
        f31 = (ImageView)findViewById(R.id.feb_genericblock31);
        f32 = (ImageView)findViewById(R.id.feb_genericblock32);
        f33 = (ImageView)findViewById(R.id.feb_genericblock33);
        f34 = (ImageView)findViewById(R.id.feb_genericblock34);
        f35 = (ImageView)findViewById(R.id.feb_genericblock35);

        //getting the recyclerview from xml
        recyclerView_feb = (RecyclerView) findViewById(R.id.recylcerView_feb);
        recyclerView_feb.setHasFixedSize(true);
        recyclerView_feb.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        productList = new ArrayList<>();

        //this method will fetch and parse json
        //to display it in recyclerview
        loadProducts_feb();

        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Feb_Col.class);
                String s="COL_1";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Feb_Col.class);
                String s="COL_2";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        f3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Feb_Col.class);
                String s="COL_3";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        f4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Feb_Col.class);
                String s="COL_4";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        f5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Feb_Col.class);
                String s="COL_5";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        f6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Feb_Col.class);
                String s="COL_6";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        f7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Feb_Col.class);
                String s="COL_7";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);

            }
        });

        f8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Feb_Col.class);
                String s="COL_8";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        f9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Feb_Col.class);
                String s="COL_9";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });
        f10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Feb_Col.class);
                String s="COL_10";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        f11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Feb_Col.class);
                String s="COL_11";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        f12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Feb_Col.class);
                String s="COL_12";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        f13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Feb_Col.class);
                String s="COL_13";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        f14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Feb_Col.class);
                String s="COL_14";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        f15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Feb_Col.class);
                String s="COL_15";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        f16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Feb_Col.class);
                String s="COL_16";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        f17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Feb_Col.class);
                String s="COL_17";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        f18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Feb_Col.class);
                String s="COL_18";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        f19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Feb_Col.class);
                String s="COL_19";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        f20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Feb_Col.class);
                String s="COL_20";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        f21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Feb_Col.class);
                String s="COL_21";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        f22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Feb_Col.class);
                String s="COL_22";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        f23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Feb_Col.class);
                String s="COL_23";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        f24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Feb_Col.class);
                String s="COL_24";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        f25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Feb_Col.class);
                String s="COL_25";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        f26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Feb_Col.class);
                String s="COL_26";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        f27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Feb_Col.class);
                String s="COL_27";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        f28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Feb_Col.class);
                String s="COL_28";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        f29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Feb_Col.class);
                String s="COL_29";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        f30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Feb_Col.class);
                String s="COL_30";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });
        f31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Feb_Col.class);
                String s="COL_31";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        f32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Feb_Col.class);
                String s="COL_32";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });


        f33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Feb_Col.class);
                String s="COL_33";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        f34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Feb_Col.class);
                String s="COL_34";
                Bundle bundle = new Bundle();
                //Add your data to bundle
                bundle.putString("COL", s);

                //Add the bundle to the intent
                i.putExtras(bundle);

                startActivity(i);
            }
        });

        f35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Feb_Col.class);
                String s="COL_35";
                Bundle bundle = new Bundle();
                bundle.putString("COL", s);
                i.putExtras(bundle);
                startActivity(i);
            }
        });



    }

    private void loadProducts_Nov()
    {
        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL_PRODUCTS_NOV, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    //converting the string to json array object

                    JSONArray array = new JSONArray(response);

                    //traversing through all the object
                    for (int i = 0; i < array.length(); i++) {

                        //getting product object from json array
                        JSONObject product = array.getJSONObject(i);
                        //adding the product to product list
                        productList.add(new Product(

                                product.getString("col_1"), product.getString("col_2"), product.getString("col_3"),
                                product.getString("col_4"), product.getString("col_5"), product.getString("col_6"),
                                product.getString("col_7"), product.getString("col_8"), product.getString("col_9"),
                                product.getString("col_10"),product.getString("col_11"),product.getString("col_12"),
                                product.getString("col_13"),product.getString("col_14"),product.getString("col_15"),
                                product.getString("col_16"),product.getString("col_17"),product.getString("col_18"),
                                product.getString("col_19"),product.getString("col_20"),product.getString("col_21"),
                                product.getString("col_22"),product.getString("col_23"),product.getString("col_24"),
                                product.getString("col_25"),product.getString("col_26"),product.getString("col_27")
                                ,product.getString("col_28"),product.getString("col_29"),product.getString("col_30"),
                                product.getString("col_31"),product.getString("col_32"),product.getString("col_33"),
                                product.getString("col_34"),product.getString("col_35"),product.getString("col_header"),product.getString("col_footer")

                        ));
                    }

                    //creating adapter object and setting it to recyclerview
                    ProductsAdapterNov adapter = new ProductsAdapterNov(MainActivity.this, productList);
                    recyclerView_nov.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),
                        "Error",
                        Toast.LENGTH_SHORT);
            }
        });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }

    private void loadProducts_Dec()
    {
        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL_PRODUCTS_DEC, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    //converting the string to json array object

                    JSONArray array = new JSONArray(response);

                    //traversing through all the object
                    for (int i = 0; i < array.length(); i++) {

                        //getting product object from json array
                        JSONObject product = array.getJSONObject(i);
                        //adding the product to product list
                        productList.add(new Product(

                                product.getString("col_1"), product.getString("col_2"), product.getString("col_3"),
                                product.getString("col_4"), product.getString("col_5"), product.getString("col_6"),
                                product.getString("col_7"), product.getString("col_8"), product.getString("col_9"),
                                product.getString("col_10"),product.getString("col_11"),product.getString("col_12"),
                                product.getString("col_13"),product.getString("col_14"),product.getString("col_15"),
                                product.getString("col_16"),product.getString("col_17"),product.getString("col_18"),
                                product.getString("col_19"),product.getString("col_20"),product.getString("col_21"),
                                product.getString("col_22"),product.getString("col_23"),product.getString("col_24"),
                                product.getString("col_25"),product.getString("col_26"),product.getString("col_27")
                                ,product.getString("col_28"),product.getString("col_29"),product.getString("col_30"),
                                product.getString("col_31"),product.getString("col_32"),product.getString("col_33"),
                                product.getString("col_34"),product.getString("col_35"),product.getString("col_header"),product.getString("col_footer")

                        ));
                    }

                    //creating adapter object and setting it to recyclerview
                    ProductsAdapterDec adapter = new ProductsAdapterDec(MainActivity.this, productList);
                    recyclerView_dec.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),
                        "Error",
                        Toast.LENGTH_SHORT);
            }
        });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }




}
