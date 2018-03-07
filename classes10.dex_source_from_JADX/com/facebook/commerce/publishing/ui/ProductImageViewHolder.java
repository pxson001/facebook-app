package com.facebook.commerce.publishing.ui;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.glyph.GlyphView;

/* compiled from: current_app_locale */
public class ProductImageViewHolder extends ViewHolder {
    public ImageView f15636l;
    private ImageView f15637m;
    public FbDraweeView f15638n;
    public CallerContext f15639o;

    public ProductImageViewHolder(View view, CallerContext callerContext) {
        super(view);
        this.f15636l = (ImageView) view.findViewById(2131560472);
        this.f15637m = (GlyphView) view.findViewById(2131566325);
        this.f15638n = (FbDraweeView) view.findViewById(2131566324);
        this.f15639o = callerContext;
    }

    public final void m16109b(OnClickListener onClickListener) {
        this.f15637m.setOnClickListener(onClickListener);
        this.f15637m.setVisibility(onClickListener != null ? 0 : 8);
    }
}
