package com.facebook.pages.common.reaction.ui;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.text.BetterTextView;

/* compiled from: section_information */
public class PageAddressNavigationComponentView extends CustomLinearLayout {
    private final int f2140a;
    private final int f2141b;
    public final BetterTextView f2142c = ((BetterTextView) a(2131565343));
    public final BetterTextView f2143d = ((BetterTextView) a(2131565344));

    public PageAddressNavigationComponentView(Context context) {
        super(context);
        setOrientation(0);
        Resources resources = getResources();
        this.f2140a = resources.getDimensionPixelSize(2131429798);
        this.f2141b = resources.getDimensionPixelSize(2131429797);
        setContentView(2130905960);
        CustomViewUtils.b(this, resources.getDrawable(2130842474));
        setPadding(this.f2141b, this.f2140a, this.f2141b, this.f2140a);
    }
}
