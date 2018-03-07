package com.facebook.friends.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;

/* compiled from: mSubscribeStatus */
public class FriendingButton extends ImageView {
    private FriendingButtonModel f10848a;

    public FriendingButton(Context context) {
        super(context);
        m17419a(context, null);
    }

    public FriendingButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m17419a(context, attributeSet);
    }

    public FriendingButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m17419a(context, attributeSet);
    }

    public final void m17420a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
        this.f10848a.m17424a(graphQLFriendshipStatus);
        if (this.f10848a.m17427c()) {
            Resources resources = getResources();
            Drawable drawable = resources.getDrawable(this.f10848a.m17425b());
            CharSequence string = resources.getString(this.f10848a.m17421a());
            setImageDrawable(drawable);
            setContentDescription(string);
            setVisibility(0);
            return;
        }
        setVisibility(4);
    }

    public void setActiveSource(int i) {
        this.f10848a.f10852d = i;
    }

    public void setInactiveSource(int i) {
        this.f10848a.f10853e = i;
    }

    private void m17419a(Context context, AttributeSet attributeSet) {
        this.f10848a = new FriendingButtonModel();
        this.f10848a.m17423a(context, attributeSet);
    }
}
