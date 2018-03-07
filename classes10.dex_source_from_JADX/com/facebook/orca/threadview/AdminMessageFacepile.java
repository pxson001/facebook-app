package com.facebook.orca.threadview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.photos.tiles.UserTileViewParamsFactory;
import com.facebook.messaging.util.CircleOverflowDrawable;
import com.facebook.messaging.util.CircleOverflowRenderer.Builder;
import com.facebook.user.tiles.UserTileView;
import com.facebook.user.tiles.UserTileViewParams;
import com.google.common.collect.ImmutableList;

/* compiled from: multiway_call_search */
public class AdminMessageFacepile extends LinearLayout {
    public AdminMessageFacepile(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdminMessageFacepile(Context context) {
        super(context);
    }

    public final void m6471a(ImmutableList<ParticipantInfo> immutableList, UserTileViewParamsFactory userTileViewParamsFactory) {
        int i;
        int i2 = 0;
        removeAllViews();
        int min = Math.min(immutableList.size(), 3);
        int i3 = immutableList.size() > min ? 1 : 0;
        if (i3 != 0) {
            i = min - 1;
        } else {
            i = min;
        }
        int i4 = i > 1 ? 2130905563 : 2130905564;
        LayoutInflater from = LayoutInflater.from(getContext());
        while (i2 < i) {
            m6468a(userTileViewParamsFactory, i4, from, (ParticipantInfo) immutableList.get(i2));
            i2++;
        }
        if (i3 != 0) {
            m6466a(immutableList.size() - i, from);
        }
    }

    public final void m6470a(ImmutableList<ParticipantInfo> immutableList) {
        int i;
        int i2 = 0;
        removeAllViews();
        int min = Math.min(immutableList.size(), 3);
        int i3 = immutableList.size() > min ? 1 : 0;
        if (i3 != 0) {
            i = min - 1;
        } else {
            i = min;
        }
        int i4 = i > 1 ? 2130905561 : 2130905564;
        LayoutInflater from = LayoutInflater.from(getContext());
        while (i2 < i) {
            m6467a(i4, from, (ParticipantInfo) immutableList.get(i2), i2);
            i2++;
        }
        if (i3 != 0) {
            m6466a(immutableList.size() - i, from);
        }
    }

    public final void m6469a() {
        removeAllViews();
    }

    private void m6468a(UserTileViewParamsFactory userTileViewParamsFactory, int i, LayoutInflater layoutInflater, ParticipantInfo participantInfo) {
        UserTileView userTileView = (UserTileView) layoutInflater.inflate(i, this, false);
        userTileView.setParams(userTileViewParamsFactory.a(participantInfo.b));
        userTileView.setVisibility(0);
        addView(userTileView);
    }

    private void m6467a(int i, LayoutInflater layoutInflater, ParticipantInfo participantInfo, int i2) {
        UserTileView userTileView = (UserTileView) layoutInflater.inflate(i, this, false);
        if (i2 != 0) {
            LayoutParams layoutParams = (LayoutParams) userTileView.getLayoutParams();
            layoutParams.setMargins(getResources().getDimensionPixelSize(2131428676), 0, 0, 0);
            userTileView.setLayoutParams(layoutParams);
        }
        userTileView.setParams(UserTileViewParams.a(participantInfo.b));
        userTileView.setVisibility(0);
        addView(userTileView);
    }

    private void m6466a(int i, LayoutInflater layoutInflater) {
        Builder builder = new Builder(getResources());
        builder.b = 2131428625;
        builder = builder;
        builder.c = getResources().getColor(2131362392);
        builder = builder;
        builder.d = getResources().getColor(2131362391);
        builder = builder;
        builder.e = 2131428626;
        builder = builder;
        builder.f = Typeface.create("sans-serif", 0);
        CircleOverflowDrawable circleOverflowDrawable = new CircleOverflowDrawable(builder.a());
        circleOverflowDrawable.a(i);
        ImageView imageView = (ImageView) layoutInflater.inflate(2130905562, this, false);
        imageView.setImageDrawable(circleOverflowDrawable);
        addView(imageView);
    }
}
