package syscryption.intro11;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class June_Col extends AppCompatActivity {
    List<Details> productList;
    private Context context;
    RecyclerView recyclerView;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_june__col);

        builder= new AlertDialog.Builder(June_Col.this);

        Bundle bundle = getIntent().getExtras();
        String stuff = bundle.getString("COL");


        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recylcerView_june_col);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        productList = new ArrayList<>();

        /*builder.setTitle("PARAM Value");
        builder.setMessage("Col:-"+stuff);
        AlertDialog alertDialog=builder.create();
        alertDialog.show();*/

        //this method will fetch and parse json
        //to display it in recyclerview
        if(stuff.equals("COL_1"))
        {
            loadProducts();
        }else if(stuff.equals("COL_2"))
        {
            loadProducts_Col2();
        }else if(stuff.equals("COL_3"))
        {
            loadProducts_Col3();
        }else if(stuff.equals("COL_4"))
        {
            loadProducts_Col4();
        }else if(stuff.equals("COL_5"))
        {
            loadProducts_Col5();
        }else if(stuff.equals("COL_6"))
        {
            loadProducts_Col6();
        }else if(stuff.equals("COL_7"))
        {
            loadProducts_Col7();
        }else if(stuff.equals("COL_8"))
        {
            loadProducts_Col8();
        }else if(stuff.equals("COL_9"))
        {
            loadProducts_Col9();
        }else if(stuff.equals("COL_10"))
        {
            loadProducts_Col10();
        }else if(stuff.equals("COL_11"))
        {
            loadProducts_Col11();
        }else if(stuff.equals("COL_12"))
        {
            loadProducts_Col12();
        }else if(stuff.equals("COL_13"))
        {
            loadProducts_Col13();
        }else if(stuff.equals("COL_14"))
        {
            loadProducts_Col14();
        }else if(stuff.equals("COL_15"))
        {
            loadProducts_Col15();
        }else if(stuff.equals("COL_16"))
        {
            loadProducts_Col16();
        }else if(stuff.equals("COL_17"))
        {
            loadProducts_Col17();
        }else if(stuff.equals("COL_18"))
        {
            loadProducts_Col18();
        }else if(stuff.equals("COL_19"))
        {
            loadProducts_Col19();
        }else if(stuff.equals("COL_20"))
        {
            loadProducts_Col20();
        }else if(stuff.equals("COL_21"))
        {
            loadProducts_Col21();
        }else if(stuff.equals("COL_22"))
        {
            loadProducts_Col22();
        }else if(stuff.equals("COL_23"))
        {
            loadProducts_Col23();
        }else if(stuff.equals("COL_24"))
        {
            loadProducts_Col24();
        }else if(stuff.equals("COL_25"))
        {
            loadProducts_Col25();
        }else if(stuff.equals("COL_26"))
        {
            loadProducts_Col26();
        }else if(stuff.equals("COL_27"))
        {
            loadProducts_Col27();
        }else if(stuff.equals("COL_28"))
        {
            loadProducts_Col28();
        }else if(stuff.equals("COL_29"))
        {
            loadProducts_Col29();
        }else if(stuff.equals("COL_30"))
        {
            loadProducts_Col30();
        }else if(stuff.equals("COL_31"))
        {
            loadProducts_Col31();
        }else if(stuff.equals("COL_32"))
        {
            loadProducts_Col32();
        }else if(stuff.equals("COL_33"))
        {
            loadProducts_Col33();
        }else if(stuff.equals("COL_34"))
        {
            loadProducts_Col34();
        }else if(stuff.equals("COL_35"))
        {
            loadProducts_Col35();
        }

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(context, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // TODO Handle item click
                        Details d = productList.get(position);
                        Intent intent = new Intent(June_Col.this, Col_Description.class);
                        intent.putExtra("Title", d.getTitle());
                        intent.putExtra("Desc", d.getDesc());
                        intent.putExtra("Long_desc", d.getLong_desc());
                        intent.putExtra("date",d.getDate());
                        intent.putExtra("img", d.getImage());
                        startActivity(intent);

                    }
                })
        );

    }

    private void loadProducts() {

        String cc="1";
        StringRequest stringRequest = new StringRequest(Request.Method.GET,"http://192.168.42.122/get_cal_text_june.php?col='1'",
                new Response.Listener<String>() {
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
                                productList.add(new Details(
                                        product.getString("title"),
                                        product.getString("description"),
                                        product.getString("img"),product.getString("date"),product.getString("long_desc")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Details_Jan_Col1_Adapter adapter = new Details_Jan_Col1_Adapter(June_Col.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }


    private void loadProducts_Col2() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://192.168.42.122/get_cal_text_june.php?col='2'",
                new Response.Listener<String>() {
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
                                productList.add(new Details(
                                        product.getString("title"),
                                        product.getString("description"),
                                        product.getString("img"),product.getString("date"),product.getString("long_desc")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Details_Jan_Col1_Adapter adapter = new Details_Jan_Col1_Adapter(June_Col .this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }
    private void loadProducts_Col3() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://192.168.42.122/get_cal_text_june.php?col='3'",
                new Response.Listener<String>() {
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
                                productList.add(new Details(
                                        product.getString("title"),
                                        product.getString("description"),
                                        product.getString("img"),product.getString("date"),product.getString("long_desc")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Details_Jan_Col1_Adapter adapter = new Details_Jan_Col1_Adapter(June_Col.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }

    private void loadProducts_Col4() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,"http://192.168.42.122/get_cal_text_june.php?col='4'",
                new Response.Listener<String>() {
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
                                productList.add(new Details(
                                        product.getString("title"),
                                        product.getString("description"),
                                        product.getString("img"),product.getString("date"),product.getString("long_desc")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Details_Jan_Col1_Adapter adapter = new Details_Jan_Col1_Adapter(June_Col.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }


    private void loadProducts_Col5() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://192.168.42.122/get_cal_text_june.php?col='5'",
                new Response.Listener<String>() {
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
                                productList.add(new Details(
                                        product.getString("title"),
                                        product.getString("description"),
                                        product.getString("img"),product.getString("date"),product.getString("long_desc")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Details_Jan_Col1_Adapter adapter = new Details_Jan_Col1_Adapter(June_Col.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }


    private void loadProducts_Col6() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://192.168.42.122/get_cal_text_june.php?col='6'",
                new Response.Listener<String>() {
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
                                productList.add(new Details(
                                        product.getString("title"),
                                        product.getString("description"),
                                        product.getString("img"),product.getString("date"),product.getString("long_desc")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Details_Jan_Col1_Adapter adapter = new Details_Jan_Col1_Adapter(June_Col.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }


    private void loadProducts_Col7() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,"http://192.168.42.122/get_cal_text_june.php?col='7'",
                new Response.Listener<String>() {
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
                                productList.add(new Details(
                                        product.getString("title"),
                                        product.getString("description"),
                                        product.getString("img"),product.getString("date"),product.getString("long_desc")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Details_Jan_Col1_Adapter adapter = new Details_Jan_Col1_Adapter(June_Col.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }


    private void loadProducts_Col8() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://192.168.42.122/get_cal_text_june.php?col='8'",
                new Response.Listener<String>() {
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
                                productList.add(new Details(
                                        product.getString("title"),
                                        product.getString("description"),
                                        product.getString("img"),product.getString("date"),product.getString("long_desc")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Details_Jan_Col1_Adapter adapter = new Details_Jan_Col1_Adapter(June_Col.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }


    private void loadProducts_Col9() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,"http://192.168.42.122/get_cal_text_june.php?col='9'",
                new Response.Listener<String>() {
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
                                productList.add(new Details(
                                        product.getString("title"),
                                        product.getString("description"),
                                        product.getString("img"),product.getString("date"),product.getString("long_desc")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Details_Jan_Col1_Adapter adapter = new Details_Jan_Col1_Adapter(June_Col.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }


    private void loadProducts_Col10() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,"http://192.168.42.122/get_cal_text_june.php?col='10'",
                new Response.Listener<String>() {
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
                                productList.add(new Details(
                                        product.getString("title"),
                                        product.getString("description"),
                                        product.getString("img"),product.getString("date"),product.getString("long_desc")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Details_Jan_Col1_Adapter adapter = new Details_Jan_Col1_Adapter(June_Col.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }


    private void loadProducts_Col11() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,"http://192.168.42.122/get_cal_text_june.php?col='11'",
                new Response.Listener<String>() {
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
                                productList.add(new Details(
                                        product.getString("title"),
                                        product.getString("description"),
                                        product.getString("img"),product.getString("date"),product.getString("long_desc")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Details_Jan_Col1_Adapter adapter = new Details_Jan_Col1_Adapter(June_Col.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }


    private void loadProducts_Col12() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,"http://192.168.42.122/get_cal_text_june.php?col='12'",
                new Response.Listener<String>() {
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
                                productList.add(new Details(
                                        product.getString("title"),
                                        product.getString("description"),
                                        product.getString("img"),product.getString("date"),product.getString("long_desc")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Details_Jan_Col1_Adapter adapter = new Details_Jan_Col1_Adapter(June_Col.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }


    private void loadProducts_Col13() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,"http://192.168.42.122/get_cal_text_june.php?col='13'",
                new Response.Listener<String>() {
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
                                productList.add(new Details(
                                        product.getString("title"),
                                        product.getString("description"),
                                        product.getString("img"),product.getString("date"),product.getString("long_desc")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Details_Jan_Col1_Adapter adapter = new Details_Jan_Col1_Adapter(June_Col.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }


    private void loadProducts_Col14() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,"http://192.168.42.122/get_cal_text_june.php?col='14'",
                new Response.Listener<String>() {
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
                                productList.add(new Details(
                                        product.getString("title"),
                                        product.getString("description"),
                                        product.getString("img"),product.getString("date"),product.getString("long_desc")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Details_Jan_Col1_Adapter adapter = new Details_Jan_Col1_Adapter(June_Col.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }

    private void loadProducts_Col15() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,"http://192.168.42.122/get_cal_text_june.php?col='15'",
                new Response.Listener<String>() {
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
                                productList.add(new Details(
                                        product.getString("title"),
                                        product.getString("description"),
                                        product.getString("img"),product.getString("date"),product.getString("long_desc")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Details_Jan_Col1_Adapter adapter = new Details_Jan_Col1_Adapter(June_Col.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }


    private void loadProducts_Col16() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,"http://192.168.42.122/get_cal_text_june.php?col='16'",
                new Response.Listener<String>() {
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
                                productList.add(new Details(
                                        product.getString("title"),
                                        product.getString("description"),
                                        product.getString("img"),product.getString("date"),product.getString("long_desc")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Details_Jan_Col1_Adapter adapter = new Details_Jan_Col1_Adapter(June_Col.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }


    private void loadProducts_Col17() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,"http://192.168.42.122/get_cal_text_june.php?col='17'",
                new Response.Listener<String>() {
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
                                productList.add(new Details(
                                        product.getString("title"),
                                        product.getString("description"),
                                        product.getString("img"),product.getString("date"),product.getString("long_desc")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Details_Jan_Col1_Adapter adapter = new Details_Jan_Col1_Adapter(June_Col.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }


    private void loadProducts_Col18() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,"http://192.168.42.122/get_cal_text_june.php?col='18'",
                new Response.Listener<String>() {
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
                                productList.add(new Details(
                                        product.getString("title"),
                                        product.getString("description"),
                                        product.getString("img"),product.getString("date"),product.getString("long_desc")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Details_Jan_Col1_Adapter adapter = new Details_Jan_Col1_Adapter(June_Col.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }


    private void loadProducts_Col19() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,"http://192.168.42.122/get_cal_text_june.php?col='19'",
                new Response.Listener<String>() {
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
                                productList.add(new Details(
                                        product.getString("title"),
                                        product.getString("description"),
                                        product.getString("img"),product.getString("date"),product.getString("long_desc")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Details_Jan_Col1_Adapter adapter = new Details_Jan_Col1_Adapter(June_Col.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }


    private void loadProducts_Col20() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,"http://192.168.42.122/get_cal_text_june.php?col='20'",
                new Response.Listener<String>() {
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
                                productList.add(new Details(
                                        product.getString("title"),
                                        product.getString("description"),
                                        product.getString("img"),product.getString("date"),product.getString("long_desc")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Details_Jan_Col1_Adapter adapter = new Details_Jan_Col1_Adapter(June_Col.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }


    private void loadProducts_Col21() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,"http://192.168.42.122/get_cal_text_june.php?col='21'",
                new Response.Listener<String>() {
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
                                productList.add(new Details(
                                        product.getString("title"),
                                        product.getString("description"),
                                        product.getString("img"),product.getString("date"),product.getString("long_desc")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Details_Jan_Col1_Adapter adapter = new Details_Jan_Col1_Adapter(June_Col.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }


    private void loadProducts_Col22() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,"http://192.168.42.122/get_cal_text_june.php?col='22'",
                new Response.Listener<String>() {
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
                                productList.add(new Details(
                                        product.getString("title"),
                                        product.getString("description"),
                                        product.getString("img"),product.getString("date"),product.getString("long_desc")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Details_Jan_Col1_Adapter adapter = new Details_Jan_Col1_Adapter(June_Col.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }


    private void loadProducts_Col23() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,"http://192.168.42.122/get_cal_text_june.php?col='23'",
                new Response.Listener<String>() {
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
                                productList.add(new Details(
                                        product.getString("title"),
                                        product.getString("description"),
                                        product.getString("img"),product.getString("date"),product.getString("long_desc")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Details_Jan_Col1_Adapter adapter = new Details_Jan_Col1_Adapter(June_Col.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }



    private void loadProducts_Col24() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,"http://192.168.42.122/get_cal_text_june.php?col='24'",
                new Response.Listener<String>() {
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
                                productList.add(new Details(
                                        product.getString("title"),
                                        product.getString("description"),
                                        product.getString("img"),product.getString("date"),product.getString("long_desc")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Details_Jan_Col1_Adapter adapter = new Details_Jan_Col1_Adapter(June_Col.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }


    private void loadProducts_Col25() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,"http://192.168.42.122/get_cal_text_june.php?col='25'",
                new Response.Listener<String>() {
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
                                productList.add(new Details(
                                        product.getString("title"),
                                        product.getString("description"),
                                        product.getString("img"),product.getString("date"),product.getString("long_desc")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Details_Jan_Col1_Adapter adapter = new Details_Jan_Col1_Adapter(June_Col.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }



    private void loadProducts_Col26() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,"http://192.168.42.122/get_cal_text_june.php?col='26'",
                new Response.Listener<String>() {
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
                                productList.add(new Details(
                                        product.getString("title"),
                                        product.getString("description"),
                                        product.getString("img"),product.getString("date"),product.getString("long_desc")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Details_Jan_Col1_Adapter adapter = new Details_Jan_Col1_Adapter(June_Col.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }


    private void loadProducts_Col27() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,"http://192.168.42.122/get_cal_text_june.php?col='27'",
                new Response.Listener<String>() {
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
                                productList.add(new Details(
                                        product.getString("title"),
                                        product.getString("description"),
                                        product.getString("img"),product.getString("date"),product.getString("long_desc")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Details_Jan_Col1_Adapter adapter = new Details_Jan_Col1_Adapter(June_Col.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }


    private void loadProducts_Col28() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,"http://192.168.42.122/get_cal_text_june.php?col='28'",
                new Response.Listener<String>() {
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
                                productList.add(new Details(
                                        product.getString("title"),
                                        product.getString("description"),
                                        product.getString("img"),product.getString("date"),product.getString("long_desc")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Details_Jan_Col1_Adapter adapter = new Details_Jan_Col1_Adapter(June_Col.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }


    private void loadProducts_Col29() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,"http://192.168.42.122/get_cal_text_june.php?col='29'",
                new Response.Listener<String>() {
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
                                productList.add(new Details(
                                        product.getString("title"),
                                        product.getString("description"),
                                        product.getString("img"),product.getString("date"),product.getString("long_desc")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Details_Jan_Col1_Adapter adapter = new Details_Jan_Col1_Adapter(June_Col.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }


    private void loadProducts_Col30() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,"http://192.168.42.122/get_cal_text_june.php?col='30'",
                new Response.Listener<String>() {
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
                                productList.add(new Details(
                                        product.getString("title"),
                                        product.getString("description"),
                                        product.getString("img"),product.getString("date"),product.getString("long_desc")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Details_Jan_Col1_Adapter adapter = new Details_Jan_Col1_Adapter(June_Col.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }


    private void loadProducts_Col31() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,"http://192.168.42.122/get_cal_text_june.php?col='31'",
                new Response.Listener<String>() {
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
                                productList.add(new Details(
                                        product.getString("title"),
                                        product.getString("description"),
                                        product.getString("img"),product.getString("date"),product.getString("long_desc")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Details_Jan_Col1_Adapter adapter = new Details_Jan_Col1_Adapter(June_Col.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }

    private void loadProducts_Col32() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,"http://192.168.42.122/get_cal_text_june.php?col='32'",
                new Response.Listener<String>() {
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
                                productList.add(new Details(
                                        product.getString("title"),
                                        product.getString("description"),
                                        product.getString("img"),product.getString("date"),product.getString("long_desc")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Details_Jan_Col1_Adapter adapter = new Details_Jan_Col1_Adapter(June_Col.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }


    private void loadProducts_Col33() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,"http://192.168.42.122/get_cal_text_june.php?col='33'",
                new Response.Listener<String>() {
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
                                productList.add(new Details(
                                        product.getString("title"),
                                        product.getString("description"),
                                        product.getString("img"),product.getString("date"),product.getString("long_desc")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Details_Jan_Col1_Adapter adapter = new Details_Jan_Col1_Adapter(June_Col.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }
    private void loadProducts_Col34() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://192.168.42.122/get_cal_text_june.php?col='34'",
                new Response.Listener<String>() {
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
                                productList.add(new Details(
                                        product.getString("title"),
                                        product.getString("description"),
                                        product.getString("img"),product.getString("date"),product.getString("long_desc")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Details_Jan_Col1_Adapter adapter = new Details_Jan_Col1_Adapter(June_Col.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }

    private void loadProducts_Col35() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,"http://192.168.42.122/get_cal_text_june.php?col='35'",
                new Response.Listener<String>() {
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
                                productList.add(new Details(
                                        product.getString("title"),
                                        product.getString("description"),
                                        product.getString("img"),product.getString("date"),product.getString("long_desc")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Details_Jan_Col1_Adapter adapter = new Details_Jan_Col1_Adapter(June_Col.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }

}
