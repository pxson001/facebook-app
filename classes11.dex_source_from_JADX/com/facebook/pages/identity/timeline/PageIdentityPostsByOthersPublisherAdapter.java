package com.facebook.pages.identity.timeline;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.config.application.Product;
import com.facebook.pages.identity.ui.PageIdentityPublisher;
import com.facebook.widget.listview.FbBaseAdapter;
import com.google.common.base.Preconditions;

/* compiled from: page_identity_unsave_fail */
public class PageIdentityPostsByOthersPublisherAdapter extends FbBaseAdapter {
    private final LayoutInflater f4197a;
    private final String f4198b;
    private final long f4199c;
    private final String f4200d;
    public final Product f4201e;
    public String f4202f;
    public boolean f4203g;
    public boolean f4204h;
    public boolean f4205i;

    /* compiled from: page_identity_unsave_fail */
    public enum ViewTypes {
        PUBLISHER_BAR,
        UNKNOWN
    }

    public PageIdentityPostsByOthersPublisherAdapter(LayoutInflater layoutInflater, String str, long j, String str2, Product product, String str3, boolean z, boolean z2, boolean z3) {
        this.f4197a = layoutInflater;
        this.f4198b = str;
        this.f4199c = j;
        this.f4200d = str2;
        this.f4201e = product;
        this.f4202f = str3;
        this.f4203g = z;
        this.f4204h = z2;
        this.f4205i = z3;
    }

    public final View m5187a(int i, ViewGroup viewGroup) {
        if (i == ViewTypes.PUBLISHER_BAR.ordinal()) {
            return this.f4197a.inflate(2130906038, null);
        }
        return null;
    }

    public final void m5188a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        if (i2 == ViewTypes.PUBLISHER_BAR.ordinal()) {
            ((PageIdentityPublisher) view.findViewById(2131565539)).m5229a(this.f4199c, this.f4200d, this.f4202f, this.f4204h, this.f4198b);
        }
    }

    public Object getItem(int i) {
        Preconditions.checkArgument(i == 0);
        return null;
    }

    public long getItemId(int i) {
        Preconditions.checkArgument(i == 0);
        return (long) i;
    }

    public int getViewTypeCount() {
        return ViewTypes.values().length;
    }

    public int getItemViewType(int i) {
        if (i == 0) {
            return ViewTypes.PUBLISHER_BAR.ordinal();
        }
        return ViewTypes.UNKNOWN.ordinal();
    }

    public int getCount() {
        Object obj = (this.f4201e == Product.PAA || this.f4205i || !this.f4203g) ? null : 1;
        return obj != null ? 1 : 0;
    }
}
