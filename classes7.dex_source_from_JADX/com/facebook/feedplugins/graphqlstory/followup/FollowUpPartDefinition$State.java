package com.facebook.feedplugins.graphqlstory.followup;

import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.view.View.OnClickListener;
import com.facebook.feed.thirdparty.instagram.InstagramEntryPoint;

/* compiled from: StandardCoverPhotoView.bindModel */
public class FollowUpPartDefinition$State {
    public final OnClickListener f23168a;
    public final OnClickListener f23169b;
    public final OnClickListener f23170c;
    public final SimpleOnPageChangeListener f23171d;
    public final FollowUpPersistentState f23172e;
    public final InstagramEntryPoint f23173f;

    public FollowUpPartDefinition$State(OnClickListener onClickListener, OnClickListener onClickListener2, OnClickListener onClickListener3, SimpleOnPageChangeListener simpleOnPageChangeListener, FollowUpPersistentState followUpPersistentState, InstagramEntryPoint instagramEntryPoint) {
        this.f23168a = onClickListener;
        this.f23169b = onClickListener2;
        this.f23170c = onClickListener3;
        this.f23171d = simpleOnPageChangeListener;
        this.f23172e = followUpPersistentState;
        this.f23173f = instagramEntryPoint;
    }
}
