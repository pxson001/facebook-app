package com.facebook.feed.rows.sections.header.ui;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.Layout;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.friends.ui.FriendingButton;
import com.facebook.inject.FbInjector;
import com.facebook.widget.text.TextViewWithFallback;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Unexpected Content-Range [ */
public class FriendableHeaderView extends ImageBlockLayout implements CanShowDefaultHeaderData {
    @Inject
    public GlyphColorizer f21398h;
    private final FbDraweeView f21399i = ((FbDraweeView) getView(2131562764));
    private final View f21400j;
    private final View f21401k;
    private final FriendingButton f21402l;

    public static void m24116a(Object obj, Context context) {
        ((FriendableHeaderView) obj).f21398h = GlyphColorizer.a(FbInjector.get(context));
    }

    public FriendableHeaderView(Context context) {
        super(context);
        Class cls = FriendableHeaderView.class;
        m24116a(this, getContext());
        setContentView(2130904505);
        setClipChildren(false);
        setClipToPadding(false);
        if (VERSION.SDK_INT >= 16) {
            this.f21399i.setImportantForAccessibility(2);
        }
        this.f21400j = getView(2131562765);
        this.f21401k = getView(2131562766);
        this.f21402l = (FriendingButton) getView(2131562871);
    }

    public void setSubtitleWithLayout(Layout layout) {
        throw new UnsupportedOperationException("Not a text layout header t6009510");
    }

    public void setSubtitleIcon(int i) {
        ((TextViewWithFallback) this.f21401k).setCompoundDrawablesWithIntrinsicBounds(null, null, this.f21398h.a(i, -7235677), null);
    }

    public void setProfileImageOnClickListener(@Nullable OnClickListener onClickListener) {
        this.f21399i.setOnClickListener(onClickListener);
    }

    public void setFriendingButtonListener(@Nullable OnClickListener onClickListener) {
        this.f21402l.setOnClickListener(onClickListener);
    }

    public void setFriendingButtonEnabled(boolean z) {
        this.f21402l.setEnabled(z);
    }
}
