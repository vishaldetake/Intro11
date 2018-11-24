package syscryption.intro11;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Nilima on 05-10-2018.
 */

public class ProductsAdapterOct extends RecyclerView.Adapter<ProductsAdapterOct.ProductViewHolder>
{ private Context mCtx;
    private List<Product> productList;

    public ProductsAdapterOct(Context mCtx, List<Product> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductsAdapterOct.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.oct_product_list, null);
        return new ProductsAdapterOct.ProductViewHolder(view);
    }


    public void onBindViewHolder(ProductsAdapterOct.ProductViewHolder holder, int position) {
        Product product = productList.get(position);

        //loading the image
        Glide.with(mCtx).load(product.getCol_1()).into(holder.imageView);
        Glide.with(mCtx).load(product.getCol_2()).into(holder.imageView2);
        Glide.with(mCtx).load(product.getCol_3()).into(holder.imageView3);
        Glide.with(mCtx).load(product.getCol_4()).into(holder.imageView4);
        Glide.with(mCtx).load(product.getCol_5()).into(holder.imageView5);
        Glide.with(mCtx).load(product.getCol_6()).into(holder.imageView6);
        Glide.with(mCtx).load(product.getCol_7()).into(holder.imageView7);
        Glide.with(mCtx).load(product.getCol_8()).into(holder.imageView8);
        Glide.with(mCtx).load(product.getCol_9()).into(holder.imageView9);
        Glide.with(mCtx).load(product.getCol_10()).into(holder.imageView10);
        Glide.with(mCtx).load(product.getCol_11()).into(holder.imageView11);
        Glide.with(mCtx).load(product.getCol_12()).into(holder.imageView12);
        Glide.with(mCtx).load(product.getCol_13()).into(holder.imageView13);
        Glide.with(mCtx).load(product.getCol_14()).into(holder.imageView14);
        Glide.with(mCtx).load(product.getCol_15()).into(holder.imageView15);
        Glide.with(mCtx).load(product.getCol_16()).into(holder.imageView16);
        Glide.with(mCtx).load(product.getCol_17()).into(holder.imageView17);
        Glide.with(mCtx).load(product.getCol_18()).into(holder.imageView18);
        Glide.with(mCtx).load(product.getCol_19()).into(holder.imageView19);
        Glide.with(mCtx).load(product.getCol_20()).into(holder.imageView20);
        Glide.with(mCtx).load(product.getCol_21()).into(holder.imageView21);
        Glide.with(mCtx).load(product.getCol_22()).into(holder.imageView22);
        Glide.with(mCtx).load(product.getCol_23()).into(holder.imageView23);
        Glide.with(mCtx).load(product.getCol_24()).into(holder.imageView24);
        Glide.with(mCtx).load(product.getCol_25()).into(holder.imageView25);
        Glide.with(mCtx).load(product.getCol_26()).into(holder.imageView26);
        Glide.with(mCtx).load(product.getCol_27()).into(holder.imageView27);
        Glide.with(mCtx).load(product.getCol_28()).into(holder.imageView28);
        Glide.with(mCtx).load(product.getCol_29()).into(holder.imageView29);
        Glide.with(mCtx).load(product.getCol_30()).into(holder.imageView30);
        Glide.with(mCtx).load(product.getCol_31()).into(holder.imageView31);
        Glide.with(mCtx).load(product.getCol_32()).into(holder.imageView32);
        Glide.with(mCtx).load(product.getCol_33()).into(holder.imageView33);
        Glide.with(mCtx).load(product.getCol_34()).into(holder.imageView34);
        Glide.with(mCtx).load(product.getCol_35()).into(holder.imageView35);
        Glide.with(mCtx).load(product.getCol_header()).into(holder.imageView36);
       /* Glide.with(mCtx).load(product.getCol_footer()).into(holder.imageView37);*/


    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10,imageView11,imageView12,imageView13,imageView14,imageView15,imageView16
                ,imageView17,imageView18,imageView19,imageView20,imageView21,imageView22,imageView23,imageView24,imageView25,imageView26,
                imageView27,imageView28,imageView29,imageView30,imageView31,imageView32,imageView33,imageView34,imageView35,imageView36,imageView37;

        public ProductViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.oct_genericblock1);
            imageView2 = itemView.findViewById(R.id.oct_genericblock2);
            imageView3 = itemView.findViewById(R.id.oct_genericblock3);
            imageView4 = itemView.findViewById(R.id.oct_genericblock4);
            imageView5 = itemView.findViewById(R.id.oct_genericblock5);
            imageView6 = itemView.findViewById(R.id.oct_genericblock6);
            imageView7 = itemView.findViewById(R.id.oct_genericblock7);
            imageView8 = itemView.findViewById(R.id.oct_genericblock8);
            imageView9 = itemView.findViewById(R.id.oct_genericblock9);
            imageView10 = itemView.findViewById(R.id.oct_genericblock10);
            imageView11= itemView.findViewById(R.id.oct_genericblock11);
            imageView12= itemView.findViewById(R.id.oct_genericblock12);
            imageView13= itemView.findViewById(R.id.oct_genericblock13);
            imageView14= itemView.findViewById(R.id.oct_genericblock14);
            imageView15= itemView.findViewById(R.id.oct_genericblock15);
            imageView16= itemView.findViewById(R.id.oct_genericblock16);
            imageView17= itemView.findViewById(R.id.oct_genericblock17);
            imageView18= itemView.findViewById(R.id.oct_genericblock18);
            imageView19= itemView.findViewById(R.id.oct_genericblock19);
            imageView20= itemView.findViewById(R.id.oct_genericblock20);
            imageView21 = itemView.findViewById(R.id.oct_genericblock21);
            imageView22 = itemView.findViewById(R.id.oct_genericblock22);
            imageView23= itemView.findViewById(R.id.oct_genericblock23);
            imageView24= itemView.findViewById(R.id.oct_genericblock24);
            imageView25= itemView.findViewById(R.id.oct_genericblock25);
            imageView26= itemView.findViewById(R.id.oct_genericblock26);
            imageView27= itemView.findViewById(R.id.oct_genericblock27);
            imageView28= itemView.findViewById(R.id.oct_genericblock28);
            imageView29= itemView.findViewById(R.id.oct_genericblock29);
            imageView30= itemView.findViewById(R.id.oct_genericblock30);
            imageView31 = itemView.findViewById(R.id.oct_genericblock31);
            imageView32 = itemView.findViewById(R.id.oct_genericblock32);
            imageView33= itemView.findViewById(R.id.oct_genericblock33);
            imageView34 = itemView.findViewById(R.id.oct_genericblock34);
            imageView35= itemView.findViewById(R.id.oct_genericblock35);
            imageView36= itemView.findViewById(R.id.oct_img_header);
            imageView37= itemView.findViewById(R.id.oct_img_footer);

        }
    }
}