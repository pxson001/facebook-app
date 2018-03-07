package com.facebook.appinvites.ui;

import android.content.Context;
import android.text.Html;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import com.facebook.widget.CustomViewGroup;

/* compiled from: dropbox */
public class AppInviteBlockListEntryView extends CustomViewGroup {
    public ContentViewWithButton f14684a = ((ContentViewWithButton) getView(2131559653));

    public AppInviteBlockListEntryView(Context context) {
        super(context);
        setContentView(2130903276);
    }

    public void setBlocked(boolean z) {
        if (z) {
            this.f14684a.setShowActionButton(true);
            this.f14684a.setSubtitleText("");
            return;
        }
        this.f14684a.setShowActionButton(false);
        this.f14684a.setSubtitleText(Html.fromHtml(getContext().getString(2131241832)));
    }
}
