package com.facebook.feedplugins.offline.rows.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomRelativeLayout;

/* compiled from: STAR */
public class OfflineFailedView extends CustomRelativeLayout implements HasOfflineHeaderView {
    private final ImageView f23709a = ((ImageView) a(2131564383));
    private final ImageView f23710b = ((ImageView) a(2131560414));
    private final FbTextView f23711c = ((FbTextView) a(2131560676));
    private final View f23712d = a(2131564382);

    public OfflineFailedView(Context context) {
        super(context);
        setContentView(2130905537);
    }

    public final void m25893a(OnTouchListener onTouchListener, OnClickListener onClickListener) {
        this.f23710b.setOnTouchListener(onTouchListener);
        this.f23710b.setOnClickListener(onClickListener);
    }

    public void setErrorListener(OnClickListener onClickListener) {
        this.f23709a.setOnClickListener(onClickListener);
        this.f23711c.setOnClickListener(onClickListener);
    }

    public View getOfflineHeaderView() {
        return this.f23712d;
    }
}
