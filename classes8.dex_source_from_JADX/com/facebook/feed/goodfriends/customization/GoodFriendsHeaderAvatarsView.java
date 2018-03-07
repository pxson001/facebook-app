package com.facebook.feed.goodfriends.customization;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.DraweeView;
import com.facebook.goodfriends.data.FriendData;
import com.google.common.collect.ImmutableList;

/* compiled from: group_mall_side_conversation */
public class GoodFriendsHeaderAvatarsView extends FrameLayout {
    private static final CallerContext f11914a = CallerContext.a(GoodFriendsHeaderAvatarsView.class);
    private final FbDraweeView[] f11915b;
    private OverflowAvatarView f11916c;

    public GoodFriendsHeaderAvatarsView(Context context) {
        this(context, null, 0);
    }

    public GoodFriendsHeaderAvatarsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GoodFriendsHeaderAvatarsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11915b = new FbDraweeView[4];
        m14004a(context);
    }

    private void m14004a(Context context) {
        LayoutInflater.from(context).inflate(2130904601, this, true);
        this.f11915b[0] = (FbDraweeView) findViewById(2131562564);
        this.f11915b[1] = (FbDraweeView) findViewById(2131562562);
        this.f11915b[2] = (FbDraweeView) findViewById(2131562563);
        this.f11915b[3] = (FbDraweeView) findViewById(2131562560);
        m14003a();
        this.f11916c = (OverflowAvatarView) findViewById(2131562561);
    }

    private void m14003a() {
        for (DraweeView hierarchy : this.f11915b) {
            GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) hierarchy.getHierarchy();
            genericDraweeHierarchy.a(RoundingParams.e());
            genericDraweeHierarchy.b(2130842676);
        }
    }

    public final void m14005a(ImmutableList<FriendData> immutableList, int i) {
        int size = immutableList.size();
        for (int i2 = 0; i2 < this.f11915b.length; i2++) {
            FbDraweeView fbDraweeView = this.f11915b[i2];
            if (i2 < size) {
                fbDraweeView.a(((FriendData) immutableList.get(i2)).c, f11914a);
            } else {
                fbDraweeView.a(null, f11914a);
            }
        }
        this.f11916c.m14007a(i >= 5 ? (FriendData) immutableList.get(4) : null, (i - 5) + 1);
    }
}
