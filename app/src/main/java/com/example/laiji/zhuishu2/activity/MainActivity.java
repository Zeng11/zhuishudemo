package com.example.laiji.zhuishu2.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.laiji.zhuishu2.R;
import com.example.laiji.zhuishu2.fragment.AreaFragment;
import com.example.laiji.zhuishu2.fragment.MyBookFragment;
import com.example.laiji.zhuishu2.fragment.SearchFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG_Area="area";
    public static final String TAG_MYBOOK="mybook";
    public static final String TAG_SEARCH="search";
    private TextView mBook;
    private TextView mSearch;
    private TextView mArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBook = (TextView) findViewById(R.id.book);
        mSearch = (TextView) findViewById(R.id.search);
        mArea = (TextView) findViewById(R.id.area);

        mBook.setOnClickListener(this);
        mSearch.setOnClickListener(this);
        mArea.setOnClickListener(this);


        switchMyBook();
    }

    private void switchMyBook() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        MyBookFragment myBookFragment = (MyBookFragment) getSupportFragmentManager().findFragmentByTag(TAG_MYBOOK);
        AreaFragment areaFragment= (AreaFragment) getSupportFragmentManager().findFragmentByTag(TAG_Area);
        SearchFragment searchFragment= (SearchFragment) getSupportFragmentManager().findFragmentByTag(TAG_SEARCH);
       if(areaFragment!=null){
           transaction.hide(areaFragment);
       }
       if(searchFragment!=null){
           transaction.hide(searchFragment);
       }
       if(myBookFragment==null){
           transaction.add(R.id.fl_flag,new MyBookFragment(),TAG_MYBOOK);
       }else {
           transaction.show(myBookFragment);
       }
        transaction.commitAllowingStateLoss();
    }
    private void switchArea() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        MyBookFragment myBookFragment = (MyBookFragment) getSupportFragmentManager().findFragmentByTag(TAG_MYBOOK);
        AreaFragment areaFragment= (AreaFragment) getSupportFragmentManager().findFragmentByTag(TAG_Area);
        SearchFragment searchFragment= (SearchFragment) getSupportFragmentManager().findFragmentByTag(TAG_SEARCH);
        if(myBookFragment!=null){
            transaction.hide(myBookFragment);
        }
        if(searchFragment!=null){
            transaction.hide(searchFragment);
        }
        if(areaFragment==null){
            transaction.add(R.id.fl_flag,new AreaFragment(),TAG_Area);
        }else {
            transaction.show(areaFragment);
        }
        transaction.commitAllowingStateLoss();
    }
    private void switchSearch() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        MyBookFragment myBookFragment = (MyBookFragment) getSupportFragmentManager().findFragmentByTag(TAG_MYBOOK);
        AreaFragment areaFragment= (AreaFragment) getSupportFragmentManager().findFragmentByTag(TAG_Area);
        SearchFragment searchFragment= (SearchFragment) getSupportFragmentManager().findFragmentByTag(TAG_SEARCH);
        if(areaFragment!=null){
            transaction.hide(areaFragment);
        }
        if(myBookFragment!=null){
            transaction.hide(myBookFragment);
        }
        if(searchFragment==null){
            transaction.add(R.id.fl_flag,new SearchFragment(),TAG_SEARCH);
        }else {
            transaction.show(searchFragment);
        }
        transaction.commitAllowingStateLoss();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.book:
                switchMyBook();
                break;
            case R.id.search:
                switchSearch();
                break;
            case R.id.area:
                switchArea();
                break;
        }
    }
}
