package com.facebook.feed.awesomizer.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.common.util.FindViewUtil;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.resources.ui.FbTextView;

/* compiled from: gysj_see_all_click */
public class AwesomizerTopicHeaderView extends SegmentedLinearLayout {
    private FbTextView f11790a;

    public AwesomizerTopicHeaderView(Context context) {
        super(context);
        m13878a();
    }

    public AwesomizerTopicHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m13878a();
    }

    private void m13878a() {
        setContentView(2130903338);
        this.f11790a = (FbTextView) FindViewUtil.b(this, 2131559795);
    }

    public void setTopicHeaderTitle(String str) {
        this.f11790a.setText(str.toUpperCase());
    }
}
