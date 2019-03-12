package org.cyclaps.cyclaps;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;


public class GuideActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    private ViewPager vp;
    private int []imageIdArray;
    private List<View> viewList;
    private ViewGroup vg;


    private ImageView iv_point;
    private ImageView []ivPointArray;


    private Button ib_start;
    private LinearLayout.LayoutParams layoutParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_guide);

        ib_start = (Button) findViewById(R.id.guide_ib_start);
        ib_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuideActivity.this,homeScreen.class));
                finish();
            }
        });


        initViewPager();

        initPoint();
    }


    private void initPoint() {
        vg = (ViewGroup) findViewById(R.id.guide_ll_point);

        ivPointArray = new ImageView[viewList.size()];

        int size = viewList.size();
        for (int i = 0;i<size;i++){
            iv_point = new ImageView(this);
            layoutParams = new LinearLayout.LayoutParams(15,15);


            if (i == 0){
                iv_point.setBackgroundResource(R.drawable.shape_bg_point_enable);
            }else{
                layoutParams.leftMargin=20;
                iv_point.setBackgroundResource(R.drawable.shape_bg_point_disable);
            }
            iv_point.setLayoutParams(layoutParams);
            iv_point.setPadding(30,0,30,0);//left,top,right,bottom
            ivPointArray[i] = iv_point;


            vg.addView(ivPointArray[i]);
        }
    }


    private void initViewPager() {
        vp = (ViewPager) findViewById(R.id.guide_vp);

        imageIdArray = new int[]{R.drawable.guide1,R.drawable.guide2,R.drawable.guide3};
        viewList = new ArrayList<>();

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);


        int len = imageIdArray.length;
        for (int i = 0;i<len;i++){

            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(params);
            imageView.setBackgroundResource(imageIdArray[i]);


            viewList.add(imageView);
        }


        vp.setAdapter(new GuidePageAdapter(viewList));

        vp.setOnPageChangeListener(this);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }


    @Override
    public void onPageSelected(int position) {

        int length = imageIdArray.length;
        for (int i = 0;i<length;i++){
            ivPointArray[position].setBackgroundResource(R.drawable.shape_bg_point_enable);
            if (position != i){
                ivPointArray[i].setBackgroundResource(R.drawable.shape_bg_point_disable);
            }
        }


        if (position == imageIdArray.length-1 ){
            ib_start.setVisibility(View.VISIBLE);
        }else {
            ib_start.setVisibility(View.GONE);
        }
    }
    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

