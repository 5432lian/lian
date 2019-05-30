package com.example.xlian_1;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.xlian_1.Adapter.MainAdapter;
import com.example.xlian_1.Fragment.HomeFragment;
import com.example.xlian_1.Fragment.QinFragment;

import java.util.ArrayList;

/**
 * @author 李玉莲
 * @date 2019-5-27 19:11:45
 **/
public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private TabLayout tabla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        tabla = (TabLayout) findViewById(R.id.tabla);
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new QinFragment());

        MainAdapter adapter = new MainAdapter(getSupportFragmentManager(), list);
        vp.setAdapter(adapter);
        tabla.setupWithViewPager(vp);
        tabla.getTabAt(0).setText("最新").setIcon(R.drawable.story_icon_new);
        tabla.getTabAt(1).setText("最早").setIcon(R.drawable.story_icon_morning);

    }
}
