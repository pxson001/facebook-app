package com.facebook.pages.common.services;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.pages.common.surface.calltoaction.PageCallToActionButton;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomViewGroup;
import javax.annotation.Nullable;

/* compiled from: rootca_reporter */
public class PagesServiceItemLarge extends CustomViewGroup {
    private static final CallerContext f2340a = CallerContext.a(PagesServiceItemLarge.class);
    private FbDraweeView f2341b;
    private PagesServiceItem f2342c;
    private FbTextView f2343d;
    private PageCallToActionButton f2344e;

    public PagesServiceItemLarge(Context context) {
        super(context);
        m3303a();
    }

    public PagesServiceItemLarge(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3303a();
    }

    public PagesServiceItemLarge(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3303a();
    }

    private void m3303a() {
        setContentView(2130906121);
        this.f2341b = (FbDraweeView) getView(2131565733);
        this.f2342c = (PagesServiceItem) getView(2131565734);
        this.f2343d = (FbTextView) getView(2131565736);
        this.f2344e = (PageCallToActionButton) getView(2131565735);
    }

    public final void m3304a(@Nullable Uri uri, String str, @Nullable String str2, @Nullable String str3, boolean z, @Nullable PageHeaderData pageHeaderData) {
        if (uri != null) {
            this.f2341b.a(uri, f2340a);
            this.f2341b.setVisibility(0);
        } else {
            this.f2341b.setVisibility(8);
        }
        this.f2342c.m3301a(null, str, str2, null);
        if (StringUtil.a(str3)) {
            this.f2343d.setVisibility(8);
        } else {
            this.f2343d.setText(str3);
            this.f2343d.setVisibility(0);
        }
        if (pageHeaderData == null || !z) {
            this.f2344e.setVisibility(8);
            return;
        }
        this.f2344e.a(pageHeaderData);
        this.f2344e.setVisibility(0);
    }
}
