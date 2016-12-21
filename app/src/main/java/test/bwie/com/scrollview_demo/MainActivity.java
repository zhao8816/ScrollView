package test.bwie.com.scrollview_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    private ScrollView scrollView;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化界面
        initView();
    }

    //初始化界面
    private void initView() {
        //连接到控件
        Button bt_0 = (Button) findViewById(R.id.bt_0);
        Button bt_1 = (Button) findViewById(R.id.bt_1);
        Button bt_2 = (Button) findViewById(R.id.bt_2);
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        tv = (TextView) findViewById(R.id.tv);

        //按钮设置点击事件
        bt_0.setOnClickListener(this);
        bt_1.setOnClickListener(this);
        bt_2.setOnClickListener(this);

        //ScrollView设置触摸监听
        scrollView.setOnTouchListener(this);
    }

    //点击事件的方法
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_0:
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_1://ScrollView向上滚动
                int y_up=-30;
                scrollView.scrollBy(0, y_up);//向上滚动30dp，（y轴坐标减少30）
                break;
            case R.id.bt_2://ScrollView向下滚动
                int y_down=30;
                scrollView.scrollBy(0, y_down);//向下滚动30dp，（y轴坐标增加30）
                break;
        }
    }

    //触摸事件的方法
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN://手指按下，无动作
                break;
            case MotionEvent.ACTION_UP://手指抬起，无动作
                break;
            case MotionEvent.ACTION_MOVE://手指滑动，ScrollView滑动
                if (scrollView.getScrollY() <= 0) {
                    Log.d(">>>>>>>>>", "onTouch: 滑到顶部");
                    Toast.makeText(MainActivity.this, "滑到顶部", Toast.LENGTH_SHORT).show();
                }
                //TextView的总高度<=屏幕的高度+滚动条的滚动距离的时候，吐司“滑到底部”,并追加
                else if (scrollView.getChildAt(0).getMeasuredHeight() <= scrollView.getHeight() + scrollView.getScrollY()) {
                    Log.d(">>>>>>>>>", "onTouch: 滑到底部");
                    Toast.makeText(MainActivity.this, "滑到底部", Toast.LENGTH_SHORT).show();
                    tv.append("追加.....");
                }
                break;
        }
        return false;
    }
}
