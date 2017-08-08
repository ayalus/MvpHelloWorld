package com.ayalus.mvphelloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ayalus.mvphelloworld.AccuWeatherFiveDayForecast.AccuWeatherForecastResponseObj;

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

    @BindView(R.id.weather_forecast_text_view_one)
    TextView weatherForecastTextViewOne;

    @BindView(R.id.weather_forecast_text_view_two)
    TextView weatherForecastTextViewTwo;

    @BindView(R.id.weather_forecast_text_view_three)
    TextView weatherForecastTextViewThree;

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
    public void buttonThreeParseJson() {
        Log.v(TAG, "button to parse the String Json.");
        mPresenter.logStringJson();
    }

    @OnClick(R.id.button_four)
    public void buttonFourGetAccuWeather() {
        Log.v(TAG, "API CALL TO GET AccuWeather 5 day forecast.");
        mPresenter.getAccuWeather();
    }

    @Override
    public void showToast(String stringToast) {
        Toast.makeText(this, stringToast+editTextOne.getText().toString(), Toast.LENGTH_SHORT).show();
    }


    public void showWeatherInfo(AccuWeatherForecastResponseObj weatherObject){
        Log.v(TAG, "SHOWING INFO FROM ACCUWEATHER");
        weatherForecastTextViewOne.setText(weatherObject.getHeadline().getText());
        weatherForecastTextViewTwo.setText("TODAYS HIGH: "+weatherObject.getDailyForecasts().get(0).getTemperature().getMaximum().getValue());
        weatherForecastTextViewThree.setText("TODAYS LOW: "+weatherObject.getDailyForecasts().get(0).getTemperature().getMinimum().getValue());
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
