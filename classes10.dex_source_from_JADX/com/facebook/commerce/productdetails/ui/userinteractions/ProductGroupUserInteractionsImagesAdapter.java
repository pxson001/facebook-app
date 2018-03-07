package com.facebook.commerce.productdetails.ui.userinteractions;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.inject.Assisted;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: dbl_settings_passcode_change */
public class ProductGroupUserInteractionsImagesAdapter extends PagerAdapter {
    private final Context f15319a;
    public ImmutableList<String> f15320b;
    public OnClickListener f15321c;

    @Inject
    public ProductGroupUserInteractionsImagesAdapter(@Assisted Context context) {
        this.f15319a = context;
    }

    public final int m15935b() {
        return (this.f15320b == null || this.f15320b.isEmpty()) ? 0 : this.f15320b.size();
    }

    public final Object m15932a(ViewGroup viewGroup, int i) {
        ProductGroupUserInteractionsImageItemView productGroupUserInteractionsImageItemView = new ProductGroupUserInteractionsImageItemView(this.f15319a);
        productGroupUserInteractionsImageItemView.f15317c.a(Uri.parse((String) this.f15320b.get(i)), ProductGroupUserInteractionsImageItemView.f15315b);
        OnClickListener onClickListener = this.f15321c;
        productGroupUserInteractionsImageItemView.f15318d.setOnClickListener(onClickListener);
        productGroupUserInteractionsImageItemView.f15318d.setVisibility(onClickListener == null ? 8 : 0);
        viewGroup.addView(productGroupUserInteractionsImageItemView);
        return productGroupUserInteractionsImageItemView;
    }

    public final boolean m15934a(View view, Object obj) {
        return view == obj;
    }

    public final int m15931a(Object obj) {
        return -2;
    }

    public final void m15933a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }
}
