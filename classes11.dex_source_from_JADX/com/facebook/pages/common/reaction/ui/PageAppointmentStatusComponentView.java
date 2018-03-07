package com.facebook.pages.common.reaction.ui;

import android.content.Context;
import android.text.style.TextAppearanceSpan;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: section_data */
public class PageAppointmentStatusComponentView extends CustomLinearLayout {
    public ContentView f2144a = ((ContentView) a(2131565372));
    public FbTextView f2145b = ((FbTextView) a(2131565371));
    public TextAppearanceSpan f2146c;
    public TextAppearanceSpan f2147d;

    public PageAppointmentStatusComponentView(Context context) {
        super(context);
        setContentView(2130905968);
        setLayoutParams(new LayoutParams(-1, getResources().getDimensionPixelSize(2131434061)));
        setOrientation(0);
        setGravity(16);
        setBackgroundResource(2131361920);
        this.f2146c = new TextAppearanceSpan(context, 2131626539);
        this.f2147d = new TextAppearanceSpan(context, 2131626540);
    }
}
