package com.facebook.permalink.rows;

import android.content.Context;
import com.facebook.resources.ui.FbTextView;

/* compiled from: store_locator */
public class SeenByView extends FbTextView {
    public SeenByView(Context context) {
        super(context);
        setTextSize(2, getResources().getDimension(2131427400) / getResources().getDisplayMetrics().scaledDensity);
        setTypeface(null, 1);
        setIncludeFontPadding(false);
        setGravity(16);
        setHighlightColor(getResources().getColor(2131362049));
    }
}
