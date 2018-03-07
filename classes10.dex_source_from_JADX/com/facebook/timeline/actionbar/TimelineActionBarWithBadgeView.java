package com.facebook.timeline.actionbar;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View.OnClickListener;
import com.facebook.fbui.widget.inlineactionbar.InlineActionButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomRelativeLayout;

/* compiled from: groups/addtogroups/{%s}?profile_name={%s} */
public class TimelineActionBarWithBadgeView extends CustomRelativeLayout {
    private InlineActionButton f10301a;
    private FbTextView f10302b;

    public TimelineActionBarWithBadgeView(Context context) {
        super(context);
        m10438a();
    }

    private void m10438a() {
        setContentView(2130907430);
        this.f10301a = (InlineActionButton) a(2131567905);
        this.f10302b = (FbTextView) a(2131567906);
        this.f10301a.setText(2131234882);
        this.f10301a.setImageDrawable(ContextCompat.a(getContext(), 2130839880));
        this.f10301a.setTextAppearance(getContext(), 2131625422);
        this.f10301a.setGlyphColor(ContextCompat.b(getContext(), 2131361936));
    }

    public void setClickListener(OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
        this.f10301a.setOnClickListener(onClickListener);
    }

    public void setCount(int i) {
        this.f10302b.setText(String.valueOf(i));
    }
}
