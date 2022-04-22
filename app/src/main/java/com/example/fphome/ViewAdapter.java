package com.example.fphome;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;


public class ViewAdapter extends FirebaseRecyclerAdapter<Notifications,ViewAdapter.MyViewHolder>
{

    public ViewAdapter(@NonNull FirebaseRecyclerOptions<Notifications> options) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull Notifications Notifications)
    {
        holder.date.setText(Notifications.getDate());
        holder.title.setText(Notifications.getTitle());
        holder.label.setText(Notifications.getLabel());
        if (position == 0) {
            holder.pdfImg.setVisibility(View.VISIBLE);
            holder.pdfText.setText(Notifications.getPdfName());
            Glide.with(holder.pdfImg.getContext()).load(Notifications.getPdfimg()).into(holder.pdfImg);
        } else {
            holder.pdfImg.setVisibility(View.GONE);
        }
        holder.pdfImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(holder.pdfImg.getContext(),ViewPdf.class);
                intent.putExtra("pdfname",Notifications.getPdfName());
                intent.putExtra("pdfurl",Notifications.getPdfurl());
                Glide.with(holder.pdfImg.getContext()).load(Notifications.getPdfimg()).into(holder.pdfImg);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.pdfImg.getContext().startActivity(intent);

            }
        });
        //Glide.with(holder.pdf.getContext()).load(Notifications.getPdf()).into(holder.pdf);
    }





    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,parent,false);
        return new MyViewHolder(view);
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView pdfImg;
        public  TextView date, title, label, pdfText;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            date=(TextView)itemView.findViewById(R.id.date_text);
            title=(TextView)itemView.findViewById(R.id.title_text);
            label=(TextView)itemView.findViewById(R.id.label_text);
            pdfImg=itemView.findViewById(R.id.pdf_img);
            //pdfImg.setVisibility(View.GONE);
            pdfText=itemView.findViewById(R.id.pdf_text);

            //pdf=(ImageView)itemView.findViewById(R.id.pdf_file);

        }
    }

}