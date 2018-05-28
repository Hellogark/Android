package com.example.supdude.appcomidita;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import static android.os.Build.VERSION_CODES.LOLLIPOP;

public class adaptadorLayoutMapa extends RelativeLayout implements  View.OnClickListener {

    public adaptadorLayoutMapa(Context context) {
        super(context);
    }

    public adaptadorLayoutMapa(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public adaptadorLayoutMapa(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void onClick(View v) {

    }
}
