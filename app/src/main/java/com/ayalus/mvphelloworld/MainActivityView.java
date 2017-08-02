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

//important for MVP
public class MainActivityView extends AppCompatActivity implements MainActivityInterface.View{

    private static final String TAG = "MainActivityView";
    //Binding activities with Butter knife (really simple to implement)
    @BindView(R.id.edit_text_one)
    EditText editTextOne;

    @BindView(R.id.background)
    RelativeLayout relativeLayout;

    MainActivityInterface.Presenter mPresenter; //important for MVP

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG, "onCreate called.....");
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this); //for buttons.
        mPresenter = new MainActivityPresenter(this);  //important for MVP
    }

    //---------------------------------Buttons-----------------------------------------------------------------------------

    //This logs & toasts what is inputted into the edit text field.
    @OnClick(R.id.button_one)
    public void buttonOnePressed() {
        Log.v(TAG, "button to toast pressed.");
        try {
            mPresenter.logString(editTextOne.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //Change background color.
    @OnClick(R.id.button_two)
    public void buttonTwoPressed() {
        Log.v(TAG, "button to change color pressed.");
        mPresenter.changeBackgroundColor(relativeLayout,-1);
    }


    @Override
    public void showToast(String stringToast) {
        Toast.makeText(this, stringToast+editTextOne.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}
