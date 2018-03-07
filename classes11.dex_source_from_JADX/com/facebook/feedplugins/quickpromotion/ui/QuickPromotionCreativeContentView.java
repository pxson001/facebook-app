package com.facebook.feedplugins.quickpromotion.ui;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.user.tiles.UserTileView;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;

/* compiled from: card_index */
public class QuickPromotionCreativeContentView extends ImageBlockLayout {
    public TextWithEntitiesView f9008h = ((TextWithEntitiesView) getView(2131566487));
    public TextWithEntitiesView f9009i = ((TextWithEntitiesView) getView(2131566501));
    public FbDraweeView f9010j = ((FbDraweeView) getView(2131566484));
    public UserTileView f9011k = ((UserTileView) getView(2131566500));

    public QuickPromotionCreativeContentView(Context context) {
        super(context);
        Resources resources = getResources();
        setContentView(2130906542);
        setGravity(51);
        setThumbnailPadding(resources.getDimensionPixelSize(2131434631));
    }

    public final void m9712a() {
        this.f9010j.setVisibility(0);
        this.f9011k.setVisibility(8);
        setGravity(51);
        setThumbnailGravity(0);
    }
}
