package com.example.demo.RecyclerAdapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.Data.MyDbHandler;
import com.example.demo.Fruit;
import com.example.demo.R;

import java.util.List;

public class AdminRecycleAdapter extends RecyclerView.Adapter<AdminRecycleAdapter.AdminViewAdapter> {
    Context context;
    List<Fruit> fruits;

    public AdminRecycleAdapter(Context context, List<Fruit> fruits) {
        this.context = context;
        this.fruits = fruits;
    }

    @NonNull
    @Override
    public AdminViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.edit_cart_card, parent, false);
        return new AdminViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdminViewAdapter holder, int position) {
        Fruit fruit = fruits.get(position);
        String name=fruit.getName().toLowerCase();
        if(name.contains("pineapple")){
            holder.imageView.setImageDrawable(context.getDrawable(R.drawable.pineapple));
        }
        else if(name.contains("apple")){
            holder.imageView.setImageDrawable(context.getDrawable(R.drawable.apple));
        }
        else if(name.contains("banana")){
            holder.imageView.setImageDrawable(context.getDrawable(R.drawable.banana));
        }
        else if(name.contains("grapes")){
            holder.imageView.setImageDrawable(context.getDrawable(R.drawable.grapes));
        }
        else if(name.contains("cherry")){
            holder.imageView.setImageDrawable(context.getDrawable(R.drawable.cherry));
        }
        else if(name.contains("guava")){
            holder.imageView.setImageDrawable(context.getDrawable(R.drawable.guava));
        }
        else if(name.contains("mango")){
            holder.imageView.setImageDrawable(context.getDrawable(R.drawable.mango));
        }
        else if(name.contains("orange")){
            holder.imageView.setImageDrawable(context.getDrawable(R.drawable.orange));
        }
        else if(name.contains("papaya")){
            holder.imageView.setImageDrawable(context.getDrawable(R.drawable.papaya));
        }
        else if(name.contains("pear")){
            holder.imageView.setImageDrawable(context.getDrawable(R.drawable.pear));
        }
        else if(name.contains("watermelon")){
            holder.imageView.setImageDrawable(context.getDrawable(R.drawable.watermelon));
        }
        else{
            holder.imageView.setImageDrawable(context.getDrawable(R.drawable.fruitbasket));
        }
        holder.textView.setText(fruit.getName());
        holder.textView1.setText(String.valueOf(fruit.getCount()));
    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }

    public class AdminViewAdapter extends RecyclerView.ViewHolder {
        TextView textView,textView1;
        ImageView imageView;
        ImageButton imageButton, imageButton1;
        public AdminViewAdapter(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView4);
            textView1=itemView.findViewById(R.id.textView12);
            imageView=itemView.findViewById(R.id.imageView);
            imageButton=itemView.findViewById(R.id.imageButton);
            imageButton1=itemView.findViewById(R.id.imageButton2);
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fruit fruit = fruits.get(getAdapterPosition());
                    MyDbHandler db = new MyDbHandler(context);
                    fruit.setCount(fruit.getCount()+1);
                    db.updateFruits(fruit);
                    notifyDataSetChanged();
                }
            });
            imageButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fruit fruit = fruits.get(getAdapterPosition());
                    if(fruit.getCount()==0)
                    {
                        Toast.makeText(context, "Alresdy Empty", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    MyDbHandler db = new MyDbHandler(context);
                    fruit.setCount(fruit.getCount()-1);
                    db.updateFruits(fruit);
                    notifyDataSetChanged();
                }
            });
        }
    }
}
