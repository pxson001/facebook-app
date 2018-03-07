package com.facebook.pages.common.reaction.ui;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.text.BetterTextView;

/* compiled from: secondary_pin_tapped */
public class PageImageBlockComponentView extends ImageBlockLayout {
    public BetterTextView f2154h = ((BetterTextView) getView(2131565549));
    private BetterTextView f2155i = ((BetterTextView) getView(2131565550));
    private BetterTextView f2156j = ((BetterTextView) getView(2131565551));

    public PageImageBlockComponentView(Context context) {
        super(context);
        Resources resources = getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(2131429798);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(2131429797);
        setContentView(2130906042);
        CustomViewUtils.b(this, ContextCompat.a(context, 2130842474));
        setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        setGravity(19);
    }

    public final void m3167a(CharSequence charSequence, String str, String str2) {
        this.f2154h.setText(charSequence);
        if (StringUtil.a(str)) {
            this.f2155i.setVisibility(8);
        } else {
            this.f2155i.setText(str);
            this.f2155i.setVisibility(0);
        }
        setThumbnailUri(str2);
    }
}
