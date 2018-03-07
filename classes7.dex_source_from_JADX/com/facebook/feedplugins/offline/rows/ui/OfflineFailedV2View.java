package com.facebook.feedplugins.offline.rows.ui;

import android.content.Context;
import android.text.Html;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomRelativeLayout;

/* compiled from: STARS_BACKGROUND */
public class OfflineFailedV2View extends CustomRelativeLayout {
    private final ImageView f23707a = ((ImageView) a(2131564387));
    private final FbTextView f23708b = ((FbTextView) a(2131564386));

    public OfflineFailedV2View(Context context) {
        super(context);
        setContentView(2130905538);
        ((FbTextView) a(2131564386)).setText(Html.fromHtml(context.getString(2131239197)));
    }

    public void setCancelButtonListeners(OnClickListener onClickListener) {
        this.f23707a.setOnClickListener(onClickListener);
    }

    public void setTextOnClickListener(OnClickListener onClickListener) {
        this.f23708b.setOnClickListener(onClickListener);
    }
}
