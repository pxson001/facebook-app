package com.facebook.reaction.feed.rows.ui;

import android.content.Context;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;

/* compiled from: android_native_article_report_bad_ad_network_request */
public class ReactionCenterAlignedHeaderView extends CustomLinearLayout {
    public TextWithEntitiesView f19455a;
    public TextWithEntitiesView f19456b = ((TextWithEntitiesView) a(2131566648));

    public ReactionCenterAlignedHeaderView(Context context) {
        super(context);
        setContentView(2130906625);
        ((ImageBlockLayout) a(2131566649)).setShowThumbnail(false);
        this.f19456b.setGravity(17);
        this.f19455a = (TextWithEntitiesView) a(2131566653);
        this.f19455a.setGravity(17);
    }
}
