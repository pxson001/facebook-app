package com.facebook.feed.goodfriends.nux;

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

/* compiled from: TYPE_BOOL */
public class GoodFriendsAvatarsView extends FrameLayout {
    private static final CallerContext f24484a = CallerContext.a(GoodFriendsAvatarsView.class);
    private final FbDraweeView[] f24485b;

    public GoodFriendsAvatarsView(Context context) {
        this(context, null, 0);
    }

    public GoodFriendsAvatarsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GoodFriendsAvatarsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f24485b = new FbDraweeView[5];
        m26385a(context);
    }

    private void m26385a(Context context) {
        int i = 0;
        LayoutInflater.from(context).inflate(2130904598, this, true);
        this.f24485b[0] = (FbDraweeView) findViewById(2131562554);
        this.f24485b[1] = (FbDraweeView) findViewById(2131562552);
        this.f24485b[2] = (FbDraweeView) findViewById(2131562553);
        this.f24485b[3] = (FbDraweeView) findViewById(2131562550);
        this.f24485b[4] = (FbDraweeView) findViewById(2131562551);
        FbDraweeView[] fbDraweeViewArr = this.f24485b;
        int length = fbDraweeViewArr.length;
        while (i < length) {
            DraweeView draweeView = fbDraweeViewArr[i];
            GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) draweeView.getHierarchy();
            genericDraweeHierarchy.a(RoundingParams.e());
            genericDraweeHierarchy.b(2130842676);
            i++;
        }
    }

    public void setFriendsData(ImmutableList<FriendData> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < 5; i++) {
            FbDraweeView fbDraweeView = this.f24485b[i];
            if (i < size) {
                fbDraweeView.a(((FriendData) immutableList.get(i)).c, f24484a);
            } else {
                fbDraweeView.a(null, f24484a);
            }
        }
    }
}
