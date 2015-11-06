package com.liutaw.navaigationbardemo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.liutaw.navigationbarlib.NaviBarBuilder;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.navi_container_1)
    FrameLayout navi_container_1;
    @Bind(R.id.navi_container_2)
    FrameLayout navi_container_2;
    @Bind(R.id.navi_container_3)
    FrameLayout navi_container_3;
    @Bind(R.id.navi_container_4)
    FrameLayout navi_container_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        ButterKnife.bind(this);

        //三个都是文字的导航栏
        NaviBarBuilder naviBarBuilder1 = new NaviBarBuilder(getApplicationContext());
        naviBarBuilder1.buildLeftView().buildSideText("左文字").buildCenterView().buildTitleText("标题文字测试").buildRightView().buildSideText("右文字");//按照buildXXXView().buildXXX()的形式构建
        setTestClickListener(naviBarBuilder1);//设置点击的监听事件
        navi_container_1.addView(naviBarBuilder1.build());//获取最终组合的View


        //两边图标,中间文字的导航栏
        NaviBarBuilder naviBarBuilder2 = new NaviBarBuilder(getApplicationContext());
        naviBarBuilder2.buildLeftView().buildImg(com.liutaw.navigationbarlib.R.drawable.navi_back).buildCenterView().buildTitleText("添加一项日程").buildRightView().buildImg(com.liutaw.navigationbarlib.R.drawable.navi_add);
        setTestClickListener(naviBarBuilder2);//设置点击的监听事件
        navi_container_2.addView(naviBarBuilder2.build());

        //左边无内容,其余都是文字的导航栏
        NaviBarBuilder naviBarBuilder3 = new NaviBarBuilder(getApplicationContext());
        naviBarBuilder3.buildCenterView().buildTitleText("社区").buildRightView().buildSideText("发帖");
        setTestClickListener(naviBarBuilder3);//设置点击的监听事件
        navi_container_3.addView(naviBarBuilder3.build());

        //左边为图标,右边为图标,中间为自定义view的情况
        NaviBarBuilder naviBarBuilder4 = new NaviBarBuilder(getApplicationContext(),true);
        final View searchView = LayoutInflater.from(this).inflate(R.layout.layout_search_store,null);
        naviBarBuilder4.buildLeftView().buildImg(com.liutaw.navigationbarlib.R.drawable.navi_phone).buildCenterView().buildCustomView(searchView).buildRightView().buildImg(com.liutaw.navigationbarlib.R.drawable.navi_shopcar);
        setTestClickListener(naviBarBuilder4);//设置点击的监听事件
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击中间布局之后,直接让搜索框获取焦点
                EditText editText = (EditText) searchView.findViewById(R.id.edit_search_store);
                editText.requestFocus();
            }
        });
        navi_container_4.addView(naviBarBuilder4.build());
    }

    private void setTestClickListener(NaviBarBuilder naviBarBuilder) {
        naviBarBuilder.setOnLeftViewOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"你点击的左边",Toast.LENGTH_LONG).show();
            }
        });

        naviBarBuilder.setOnCenterViewOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"你点击了标题",Toast.LENGTH_LONG).show();
            }
        });

        naviBarBuilder.setOnRightViewOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"你点击了右边",Toast.LENGTH_LONG).show();
            }
        });
    }


}
