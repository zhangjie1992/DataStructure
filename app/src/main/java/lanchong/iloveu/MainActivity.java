package lanchong.iloveu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import lanchong.iloveu.datastructure.R;
import lanchong.iloveu.diy.DiyActivity;


//小米面试题
//点击
//A dispatchTouchEvent ACTION_DOWN
//A onInterceptTouchEvent ACTION_DOWN
//B dispatchTouchEvent ACTION_DOWN
//B onInterceptTouchEvent ACTION_DOWN
//C dispatchTouchEvent ACTION_DOWN
//C onTouchEvent ACTION_DOWN

//move
//A dispatchTouchEvent ACTION_MOVE
//A onInterceptTouchEvent ACTION_MOVE
//B dispatchTouchEvent ACTION_MOVE
//B onInterceptTouchEvent ACTION_MOVE //如果target不是b自己，就要onInterceptTouchEvent
//C dispatchTouchEvent ACTION_CANCEL
//C onTouchEvent ACTION_CANCEL

//A dispatchTouchEvent ACTION_MOVE
//A onInterceptTouchEvent ACTION_MOVE
//B dispatchTouchEvent ACTION_MOVE
//B onTouchEvent ACTION_MOVE
//如果target是b自己，就不会走dispatchTouchEvent,第一次不走自己的onTouchEvent

//up
//A dispatchTouchEvent ACTION_UP
//A onInterceptTouchEvent ACTION_UP
//B dispatchTouchEvent ACTION_UP
//B onInterceptTouchEvent ACTION_UP
public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);

//只要不点击就不会anr
//        try {
//            Thread.sleep(10000000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }


    @Override
    public void onClick(View v) {6
        switch (v.getId()) {
            case R.id.btn2:
                Intent intent = new Intent(MainActivity.this, DiyActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.e("zjzjzj", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("zjzjzj", "onStop");

    }
}
