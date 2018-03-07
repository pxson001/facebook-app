package com.facebook.pages.common.reaction.ui;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.text.BetterTextView;

/* compiled from: search_results_error */
public class PageInlineComposerComponentView extends ImageBlockLayout {
    private final int f2169h;
    private final int f2170i;
    public BetterTextView f2171j = ((BetterTextView) getView(2131565608));

    public PageInlineComposerComponentView(Context context) {
        super(context);
        Resources resources = getResources();
        this.f2170i = resources.getDimensionPixelSize(2131427450);
        this.f2169h = resources.getDimensionPixelSize(2131427450);
        CustomViewUtils.b(this, resources.getDrawable(2130842474));
        setContentView(2130906061);
        setPadding(this.f2169h, this.f2170i, this.f2169h, this.f2170i);
        setGravity(19);
    }
}
