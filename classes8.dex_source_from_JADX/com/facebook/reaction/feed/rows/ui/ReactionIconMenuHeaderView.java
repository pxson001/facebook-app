package com.facebook.reaction.feed.rows.ui;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import javax.annotation.Nullable;

/* compiled from: android_native_article_perf */
public class ReactionIconMenuHeaderView extends AbstractReactionHeaderView {
    private static final CallerContext f19457a = CallerContext.a(ReactionIconMenuHeaderView.class, "reaction_dialog");
    public ImageView f19458b = ((ImageView) a(2131566656));
    private FbDraweeView f19459c = ((FbDraweeView) a(2131566655));

    public ReactionIconMenuHeaderView(Context context) {
        super(context);
    }

    public void setIconUri(@Nullable Uri uri) {
        if (uri != null) {
            this.f19459c.a(uri, f19457a);
        }
        this.f19459c.setVisibility(uri == null ? 8 : 0);
    }

    protected int getContentViewId() {
        return 2130906630;
    }
}
