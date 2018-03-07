package com.facebook.groups.memberlist;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.common.util.StringUtil;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: extra_query_display_style */
public class GroupMemberStickyHeaderView extends CustomLinearLayout {
    private final FbTextView f14292a;

    public GroupMemberStickyHeaderView(Context context) {
        this(context, null);
    }

    private GroupMemberStickyHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130904677);
        this.f14292a = (FbTextView) findViewById(2131562703);
    }

    public final void m15905a(String str) {
        if (StringUtil.c(str)) {
            setViewVisibility(false);
            return;
        }
        this.f14292a.setText(str);
        setViewVisibility(true);
    }

    public final void m15904a() {
        setViewVisibility(false);
    }

    private void setViewVisibility(boolean z) {
        int i = z ? 0 : 8;
        this.f14292a.setVisibility(i);
        setVisibility(i);
    }
}
