package com.facebook.appinvites.ui;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.widget.CustomViewGroup;

/* compiled from: dropoff[latitude] */
public class AppInviteAppDetailsView extends CustomViewGroup {
    private ImageBlockLayout f14679a;
    private View f14680b;
    private TextView f14681c;
    private TextView f14682d;
    private Button f14683e;

    public AppInviteAppDetailsView(Context context) {
        super(context);
        m15088a();
    }

    public AppInviteAppDetailsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m15088a();
    }

    private void m15088a() {
        setContentView(2130903279);
        this.f14681c = (TextView) getView(2131559622);
        this.f14679a = (ImageBlockLayout) getView(2131559667);
        this.f14680b = getView(2131559668);
        this.f14682d = (TextView) getView(2131559669);
        this.f14683e = (Button) getView(2131559643);
    }

    public void setAppName(String str) {
        this.f14681c.setText(str);
    }

    public void setAppPictureURI(Uri uri) {
        this.f14679a.setThumbnailUri(uri);
    }

    public void setAppRating(float f) {
        if (f > 0.0f) {
            this.f14680b.setVisibility(0);
        } else {
            this.f14680b.setVisibility(8);
        }
        this.f14682d.setText(StringFormatUtil.formatStrLocaleSafe("%.1f", Float.valueOf(f)));
    }

    public void setInstallOnClickListener(OnClickListener onClickListener) {
        this.f14683e.setOnClickListener(onClickListener);
    }

    public void setInstallLabel(int i) {
        this.f14683e.setText(i);
    }
}
