package lanchong.iloveu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import lanchong.iloveu.datastructure.R;


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
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
