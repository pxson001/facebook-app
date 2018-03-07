package com.facebook.goodwill.feed.rows;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.multirow.api.ViewType;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomRelativeLayout;

/* compiled from: fb4a_draft_notification_clicked */
public class ThrowbackFriendversaryHeaderView extends CustomRelativeLayout {
    public static final ViewType f13727a = new C14581();
    public static final CallerContext f13728b = CallerContext.a(ThrowbackFriendversaryHeaderView.class);
    public FbDraweeView f13729c = ((FbDraweeView) findViewById(2131560864));
    public FbTextView f13730d = ((FbTextView) findViewById(2131560281));
    public FbTextView f13731e = ((FbTextView) findViewById(2131562884));

    /* compiled from: fb4a_draft_notification_clicked */
    final class C14581 extends ViewType {
        C14581() {
        }

        public final View m15412a(Context context) {
            return new ThrowbackFriendversaryHeaderView(context);
        }
    }

    public ThrowbackFriendversaryHeaderView(Context context) {
        super(context);
        setContentView(2130907410);
        this.f13730d.setMovementMethod(LinkMovementMethod.getInstance());
        this.f13731e.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
