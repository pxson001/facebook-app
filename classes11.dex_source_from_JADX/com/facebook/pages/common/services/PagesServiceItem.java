package com.facebook.pages.common.services;

import android.content.Context;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.facebook.common.util.StringUtil;
import com.facebook.fig.listitem.FigListItem;
import javax.annotation.Nullable;

/* compiled from: rootca_sample */
public class PagesServiceItem extends FigListItem {
    public PagesServiceItem(Context context) {
        super(context);
    }

    public PagesServiceItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PagesServiceItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void m3301a(@Nullable Uri uri, String str, @Nullable String str2, OnClickListener onClickListener) {
        if (uri != null) {
            setThumbnailUri(uri);
            setShowThumbnail(true);
        } else {
            setShowThumbnail(false);
        }
        setTitleTextAppearenceType(0);
        setTitleText(str);
        setMetaTextAppearenceType(0);
        if (StringUtil.a(str2)) {
            setMetaText(2131235473);
        } else {
            setMetaText(str2);
        }
        setBackgroundResource(2130842466);
        setOnClickListener(onClickListener);
    }

    public final void m3302f() {
        setOnClickListener(null);
    }

    public final void m3300a(int i) {
        setBackgroundResource(2130842467);
        ((TransitionDrawable) getBackground()).startTransition(i);
    }
}
