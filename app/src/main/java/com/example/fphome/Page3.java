package com.example.fphome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;


import java.util.ArrayList;
import java.util.List;

public class Page3 extends AppCompatActivity {
     Button phon;
    private ViewPager2 viewPager2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        phon = (Button) findViewById(R.id.phon);

        phon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:052342459"));
                startActivity(intent);
            }
        });


        viewPager2 = findViewById(R.id.viewPagerImageSlider);



        List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.image1));
        sliderItems.add(new SliderItem(R.drawable.image2));
        sliderItems.add(new SliderItem(R.drawable.image6));
        sliderItems.add(new SliderItem(R.drawable.image4));
        sliderItems.add(new SliderItem(R.drawable.image5));

        viewPager2.setAdapter(new SliderAdapter(sliderItems, viewPager2));

        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f+r*0.15f);
            }
        });
        viewPager2.setPageTransformer(compositePageTransformer);



    }
    public void openWeb(View view) {
        String web = "http://www.fpbm.ma/new/";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(web));
        startActivity(intent);
    }
    public void openLocation(View view) {
        String loc = "https://www.google.com/maps/place/Sultan+Moulay+slimane+Multidisciplinary+faculty/@32.3684141,-6.3121795,15.19z/data=!4m5!3m4!1s0xda385fee999f689:0x4e7fbccedbb34938!8m2!3d32.3753585!4d-6.318748";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(loc));
        startActivity(intent);
    }
}