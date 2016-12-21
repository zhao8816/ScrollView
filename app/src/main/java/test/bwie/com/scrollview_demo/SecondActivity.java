package test.bwie.com.scrollview_demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;

/**
 * Author：ZhaoTieJin
 * date :  2016/12/21
 */

public class SecondActivity extends Activity implements View.OnClickListener {

    private HorizontalScrollView horizontalScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //初始化界面
        initView();
    }

    //初始化界面
    private void initView() {
        Button bt_11 = (Button) findViewById(R.id.bt_11);
        Button bt_22 = (Button) findViewById(R.id.bt_22);
        horizontalScrollView = (HorizontalScrollView) findViewById(R.id.horizontalScrollView);
        bt_11.setOnClickListener(this);
        bt_22.setOnClickListener(this);
    }

    //点击事件的方法
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_11:
                int x_left = -30;
                horizontalScrollView.scrollBy(x_left, 0);
                break;
            case R.id.bt_22:
                int x_right = 30;
                horizontalScrollView.scrollBy(x_right, 0);
                break;
        }
    }
}
