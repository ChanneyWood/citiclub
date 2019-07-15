package com.example.a12579.citiclub.main;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.a12579.citiclub.R;
import com.example.a12579.citiclub.home.HomeFragment;
import com.example.a12579.citiclub.my.MyFragment;
import com.example.a12579.citiclub.workdisplay.WorkDisplayFragment;
import com.example.a12579.citiclub.workspace.WorkspaceFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    private BottomNavigationBar bottomNavigationBar;
    int lastSelectedPosition = 0;
    private HomeFragment homeFragment;
    private WorkspaceFragment workspaceFragment;
    private WorkDisplayFragment workDisplayFragment;
    private MyFragment myFragment;
    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        bottomNavigationBar = findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_CLASSIC);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.home_u340,"首页").setActiveColor(R.color.colorBlack))
                .addItem(new BottomNavigationItem(R.drawable.workspace_u335,"工作台").setActiveColor(R.color.colorBlack))
                .addItem(new BottomNavigationItem(R.drawable.display_u330,"作品展示").setActiveColor(R.color.colorBlack))
                .addItem(new BottomNavigationItem(R.drawable.personal_u325,"个人中心").setActiveColor(R.color.colorBlack))
                .setFirstSelectedPosition(lastSelectedPosition)
                .initialise();
        bottomNavigationBar.setTabSelectedListener(this);
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        homeFragment = HomeFragment.newInstance();
        transaction.replace(R.id.replace_layout, homeFragment);
        transaction.commit();
    }

    @Override
    public void onTabSelected(int position) {
        FragmentManager fm = this.getSupportFragmentManager();
        //开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (position){
            case 0:
                if (homeFragment == null){
                    homeFragment = HomeFragment.newInstance();
                }
                transaction.replace(R.id.replace_layout,homeFragment);
                break;
            case 1:
                if (workspaceFragment == null){
                    workspaceFragment = WorkspaceFragment.newInstance();
                }
                transaction.replace(R.id.replace_layout,workspaceFragment);
                break;
            case 2:
                if (workDisplayFragment == null){
                    workDisplayFragment = WorkDisplayFragment.newInstance();
                }
                transaction.replace(R.id.replace_layout,workDisplayFragment);
                break;
            case 3:
                if (myFragment == null){
                    myFragment = MyFragment.newInstance();
                }
                transaction.replace(R.id.replace_layout,myFragment);
                break;
        }
        transaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-exitTime) > 2000){
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
