package lanchong.iloveu.diy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import lanchong.iloveu.datastructure.R;

public class DiyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diy);
        Log.e("zjzjzj", "onCreate");



    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("zjzjzj", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("zjzjzj", "onResume");
    }
}
