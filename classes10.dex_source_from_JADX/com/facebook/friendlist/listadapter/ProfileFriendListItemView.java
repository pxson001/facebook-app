package com.facebook.friendlist.listadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.friends.ui.SmartButtonLite;

/* compiled from: account_type */
public class ProfileFriendListItemView extends ContentView {
    public View f20405h = LayoutInflater.from(getContext()).inflate(2130906435, this, false);
    public SmartButtonLite f20406i;
    public ImageView f20407j;

    public ProfileFriendListItemView(Context context) {
        super(context);
        addView(this.f20405h);
        this.f20406i = (SmartButtonLite) getView(2131566350);
        this.f20407j = (ImageView) getView(2131566351);
        setPadding(getPaddingLeft(), getPaddingTop(), 0, getPaddingBottom());
        setMetaTextAppearance(2131626595);
    }

    public void setActionButtonText(CharSequence charSequence) {
        m20670a(charSequence, null);
    }

    public final void m20670a(CharSequence charSequence, CharSequence charSequence2) {
        this.f20406i.a(charSequence, charSequence2);
    }

    public void setShowButtonContainer(boolean z) {
        this.f20405h.setVisibility(z ? 0 : 8);
    }

    public void setActionButtonStyle(int i) {
        this.f20406i.setStyle(i);
    }

    public void setActionButtonContentDescription(CharSequence charSequence) {
        this.f20406i.setContentDescription(charSequence);
    }
}
