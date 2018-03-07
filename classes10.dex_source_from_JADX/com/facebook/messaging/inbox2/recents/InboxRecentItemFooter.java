package com.facebook.messaging.inbox2.recents;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: sendJoinGroupRequest */
public class InboxRecentItemFooter extends CustomLinearLayout {
    private static final CallerContext f2862a = CallerContext.a(InboxRecentItemFooter.class);
    private FbDraweeView f2863b;
    private TextView f2864c;
    private TextView f2865d;
    @Nullable
    private InboxRecentItem f2866e;

    public InboxRecentItemFooter(Context context) {
        super(context);
        m2831a();
    }

    public InboxRecentItemFooter(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m2831a();
    }

    public InboxRecentItemFooter(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2831a();
    }

    private void m2831a() {
        setOrientation(1);
        setContentView(2130904877);
        this.f2863b = (FbDraweeView) a(2131563106);
        this.f2864c = (TextView) a(2131563107);
        this.f2865d = (TextView) a(2131563108);
    }

    public void setItem(@Nullable InboxRecentItem inboxRecentItem) {
        Uri uri = null;
        if (this.f2866e != inboxRecentItem) {
            this.f2866e = inboxRecentItem;
            this.f2864c.setText(inboxRecentItem == null ? null : inboxRecentItem.lZ_());
            this.f2865d.setText(inboxRecentItem == null ? null : inboxRecentItem.ma_());
            FbDraweeView fbDraweeView = this.f2863b;
            if (inboxRecentItem != null) {
                uri = inboxRecentItem.mo99m();
            }
            fbDraweeView.a(uri, f2862a);
            FbDraweeView fbDraweeView2 = this.f2863b;
            int i = (inboxRecentItem == null || inboxRecentItem.mo99m() == null) ? 8 : 0;
            fbDraweeView2.setVisibility(i);
        }
    }
}
