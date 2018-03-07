package com.facebook.pages.common.reaction.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.pages.common.ui.widgets.ExpandableTextView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.text.BetterTextView;
import com.facebook.widget.text.CustomFontHelper;
import com.facebook.widget.text.CustomFontHelper.FontFamily;
import com.facebook.widget.text.CustomFontHelper.FontWeight;

/* compiled from: seconds_back */
public class PageContactInfoStackComponentView extends CustomLinearLayout {
    private final int f2148a;
    private final int f2149b;
    private ExpandableTextView f2150c = ((ExpandableTextView) a(2131565409));
    public BetterTextView f2151d = ((BetterTextView) a(2131565410));
    public BetterTextView f2152e = ((BetterTextView) a(2131565411));
    public BetterTextView f2153f = ((BetterTextView) a(2131565412));

    public PageContactInfoStackComponentView(Context context) {
        super(context);
        Resources resources = getResources();
        setContentView(2130905997);
        setOrientation(1);
        this.f2148a = resources.getDimensionPixelSize(2131429797);
        this.f2149b = resources.getDimensionPixelSize(2131429798);
        CustomViewUtils.b(this, resources.getDrawable(2130842474));
        setPadding(this.f2148a, this.f2149b / 2, this.f2148a, this.f2149b / 2);
        ExpandableTextView expandableTextView = this.f2150c;
        CustomFontHelper.a(expandableTextView, FontFamily.ROBOTO, FontWeight.REGULAR, expandableTextView.getTypeface());
    }

    public final void m3166a(String str, String str2, OnClickListener onClickListener, String str3, OnClickListener onClickListener2, String str4, OnClickListener onClickListener3) {
        getResources();
        m3165a(this.f2150c, str, null);
        m3165a(this.f2151d, str2, onClickListener);
        m3165a(this.f2152e, str4, onClickListener3);
        m3165a(this.f2153f, str3, onClickListener2);
    }

    private void m3165a(TextView textView, String str, OnClickListener onClickListener) {
        int i = 0;
        int i2 = str != null ? 1 : 0;
        if (i2 != 0) {
            textView.setText(str);
            textView.setOnClickListener(onClickListener);
            textView.setPadding(0, this.f2149b / 2, 0, this.f2149b / 2);
        }
        if (i2 == 0) {
            i = 8;
        }
        textView.setVisibility(i);
    }
}
