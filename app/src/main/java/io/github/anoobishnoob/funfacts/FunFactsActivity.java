package io.github.anoobishnoob.funfacts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class FunFactsActivity extends AppCompatActivity {
    public static final String TAG = FunFactsActivity.class.getSimpleName(); // this is a better method using string for refactoring purposes
    private static final String KEY_FACT = "KEY_FACT";
    private static final String KEY_COLOR = "Key_Color";
    private FactBook factBook = new FactBook();
    private ColorWheel colorwheel = new ColorWheel();

    //declare our view variables
    private TextView factTextView;
    private Button showFactButton;
    private RelativeLayout relativeLayout;
    private String mFact;
    private int mColor;


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(KEY_FACT, mFact);
        outState.putInt(KEY_COLOR, mColor);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        mFact = savedInstanceState.getString(KEY_FACT, mFact);
        mColor = savedInstanceState.getInt(KEY_COLOR, mColor);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        // Assign the views from the layout file to the corresponding variables
        factTextView = (TextView) findViewById(R.id.factTextView);
        showFactButton = (Button) findViewById(R.id.showFactButton);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFact = factBook.getFact();
                // update the screen with our new fact
                factTextView.setText(mFact);

                mColor = colorwheel.getColor();
                relativeLayout.setBackgroundColor(mColor);

                showFactButton.setTextColor(mColor);
            }
        };
        showFactButton.setOnClickListener(listener);


        //Toast.makeText(this, "this is a little toast message", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "we are logging from the onCreate() method!");

    }
}