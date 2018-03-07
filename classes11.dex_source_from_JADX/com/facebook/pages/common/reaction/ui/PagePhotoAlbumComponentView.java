package com.facebook.pages.common.reaction.ui;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.pages.common.ui.widgets.AlbumWithOffsetShadow;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;

/* compiled from: search_distance */
public class PagePhotoAlbumComponentView extends CustomLinearLayout {
    public static final CallerContext f2214a = CallerContext.a(PagePhotoAlbumComponentView.class, "pages_public_view");
    public final AlbumWithOffsetShadow f2215b = ((AlbumWithOffsetShadow) a(2131565634));
    public final BetterTextView f2216c;
    public final BetterTextView f2217d;

    public PagePhotoAlbumComponentView(Context context) {
        super(context);
        setOrientation(1);
        setContentView(2130906072);
        this.f2215b.m3650a(ContextCompat.a(getContext(), 2130837625), 2);
        this.f2216c = (BetterTextView) a(2131565635);
        this.f2217d = (BetterTextView) a(2131565636);
    }
}
