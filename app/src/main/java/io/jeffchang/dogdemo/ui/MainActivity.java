package io.jeffchang.dogdemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import dagger.android.DaggerActivity;
import io.jeffchang.dogdemo.R;

/**
 * Hosts our two main fragments.
 */

public class MainActivity extends DaggerActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
