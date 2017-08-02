package com.ayalus.mvphelloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.json.JSONException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivityView extends AppCompatActivity implements MainActivityInterface.View{

    private static final String TAG = "MainActivityView";
    @BindView(R.id.edit_text_one)
    EditText editTextOne;

    @BindView(R.id.background)
    RelativeLayout relativeLayout;

    MainActivityInterface.Presenter mPresenter;

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mPresenter = new MainActivityPresenter(this);
        Log.v(TAG, "onCreate called.....");
    }

    @OnClick(R.id.button_one)
    public void buttonPressed() {
        Log.v(TAG, "button to toast pressed.");
        try {
            mPresenter.logString(editTextOne.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.button_two)
    public void buttonTwoPressed() {
        Log.v(TAG, "button to change color pressed.");
        mPresenter.changeBackgroundColor(relativeLayout,-1);
    }

    @OnClick(R.id.button_three)
    public void buttonTwoParseJson() {
        Log.v(TAG, "button to parse the String Json.");
        mPresenter.logStringJson();
    }

    @Override
    public void showToast(String stringToast) {
//        Log.v(TAG, "showToast called");
        Toast.makeText(this, stringToast+editTextOne.getText().toString(), Toast.LENGTH_SHORT).show();
    }

//---------------------------------override methods-----------------------------------------------------------------------------


    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "onStart called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "onDestroy called");

    }
}
