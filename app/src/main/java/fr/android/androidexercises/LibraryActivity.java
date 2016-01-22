package fr.android.androidexercises;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

public class LibraryActivity extends AppCompatActivity implements Step0Fragment.OnNextStep0Listener, Step1Fragment.OnNextStep1Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        // TODO replace Step0Fragment in containerFrameLayout
        boolean landscape = getResources().getBoolean(R.bool.landscape);
        View fragment1 = findViewById(R.id.fragment2);
        if(landscape){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment1, new Step0Fragment())
                    .commit();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment2, new Step1Fragment())
                    .commit();
            fragment1.setVisibility(View.VISIBLE);
        } else{
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment1, new Step0Fragment())
                    .commit();
            fragment1.setVisibility(View.GONE);
        }

    }

    public void onNext() {
        // TODO replace Step1Fragment in containerFrameLayout
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment1, new Step1Fragment())
                .addToBackStack(Step1Fragment.class.getSimpleName())
                .commit();
    }

    public void onNextStep1() {
        // TODO replace Step1Fragment in containerFrameLayout
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment1, new Step2Fragment(), Step2Fragment.class.getSimpleName())
                .addToBackStack(Step2Fragment.class.getSimpleName())
                .commit();
    }

}
