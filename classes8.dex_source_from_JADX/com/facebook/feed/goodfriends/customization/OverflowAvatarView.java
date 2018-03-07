package com.facebook.feed.goodfriends.customization;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.goodfriends.data.FriendData;
import com.facebook.resources.ui.FbTextView;

/* compiled from: group_mall_membership_tabs */
public class OverflowAvatarView extends FrameLayout {
    private static final CallerContext f11917a = CallerContext.a(OverflowAvatarView.class);
    private FbDraweeView f11918b;
    private FbTextView f11919c;

    public OverflowAvatarView(Context context) {
        this(context, null, 0);
    }

    public OverflowAvatarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OverflowAvatarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14006a(context);
    }

    private void m14006a(Context context) {
        LayoutInflater.from(context).inflate(2130904602, this, true);
        this.f11918b = (FbDraweeView) findViewById(2131562565);
        GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) this.f11918b.getHierarchy();
        genericDraweeHierarchy.a(RoundingParams.e());
        genericDraweeHierarchy.b(2130842676);
        this.f11919c = (FbTextView) findViewById(2131562566);
    }

    public final void m14007a(FriendData friendData, int i) {
        Uri uri;
        FbDraweeView fbDraweeView = this.f11918b;
        if (friendData == null) {
            uri = null;
        } else {
            uri = friendData.c;
        }
        fbDraweeView.a(uri, f11917a);
        if (i > 1) {
            this.f11919c.setText("+".concat(String.valueOf(i)));
            this.f11919c.setBackgroundResource(2130843720);
            this.f11919c.setVisibility(0);
            return;
        }
        this.f11919c.setVisibility(8);
    }
}
