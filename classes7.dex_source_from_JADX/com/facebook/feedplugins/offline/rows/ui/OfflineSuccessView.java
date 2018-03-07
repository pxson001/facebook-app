package com.facebook.feedplugins.offline.rows.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomRelativeLayout;

/* compiled from: SPONSORED */
public class OfflineSuccessView extends CustomRelativeLayout {
    public final FbTextView f23725a = ((FbTextView) a(2131564386));
    private View f23726b = a(2131564396);

    public OfflineSuccessView(Context context) {
        super(context);
        setContentView(2130905544);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f23726b.setOnClickListener(onClickListener);
    }
}
