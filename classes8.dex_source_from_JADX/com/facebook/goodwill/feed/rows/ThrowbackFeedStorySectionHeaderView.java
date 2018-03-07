package com.facebook.goodwill.feed.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.multirow.api.ViewType;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomRelativeLayout;

/* compiled from: feed_unit_header_styled */
public class ThrowbackFeedStorySectionHeaderView extends CustomRelativeLayout {
    public static final ViewType f13569a = new C14381();
    public static final CallerContext f13570b = CallerContext.a(ThrowbackFeedStorySectionHeaderView.class);
    public FbDraweeView f13571c = ((FbDraweeView) findViewById(2131560864));
    public FbTextView f13572d = ((FbTextView) findViewById(2131560281));
    public FbTextView f13573e = ((FbTextView) findViewById(2131562884));
    public SegmentedLinearLayout f13574f = ((SegmentedLinearLayout) findViewById(2131567869));

    /* compiled from: feed_unit_header_styled */
    final class C14381 extends ViewType {
        C14381() {
        }

        public final View m15329a(Context context) {
            return new ThrowbackFeedStorySectionHeaderView(context);
        }
    }

    public ThrowbackFeedStorySectionHeaderView(Context context) {
        super(context);
        setContentView(2130907404);
    }
}
