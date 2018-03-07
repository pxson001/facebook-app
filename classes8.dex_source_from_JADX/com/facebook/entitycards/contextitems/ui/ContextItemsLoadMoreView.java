package com.facebook.entitycards.contextitems.ui;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: impression_report_url */
public class ContextItemsLoadMoreView extends CustomFrameLayout {
    private final ImageView f10939a = ((ImageView) c(2131560777));
    private final ProgressBar f10940b = ((ProgressBar) c(2131560778));

    public ContextItemsLoadMoreView(Context context) {
        super(context);
        setContentView(2130903795);
        setLayoutParams(new LayoutParams(-1, getResources().getDimensionPixelSize(2131429778)));
        setBackgroundResource(2130839946);
    }

    public final void m12876a(boolean z) {
        if (z) {
            this.f10939a.setVisibility(8);
            this.f10940b.setVisibility(0);
            setOnClickListener(null);
            setBackgroundColor(getResources().getColor(2131361864));
            return;
        }
        this.f10939a.setVisibility(0);
        this.f10940b.setVisibility(8);
    }
}
