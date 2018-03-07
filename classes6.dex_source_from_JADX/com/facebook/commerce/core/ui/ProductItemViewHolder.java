package com.facebook.commerce.core.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.widget.LazyView;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: prefilled_share_id */
public class ProductItemViewHolder extends ViewHolder {
    public final FrameLayout f7528l;
    private final FbDraweeView f7529m;
    public final BetterTextView f7530n;
    public final BetterTextView f7531o;
    private final GlyphView f7532p;
    public final LazyView f7533q;
    private final Context f7534r;

    public ProductItemViewHolder(View view) {
        super(view);
        this.f7528l = (FrameLayout) view.findViewById(2131566323);
        this.f7529m = (FbDraweeView) view.findViewById(2131566324);
        this.f7530n = (BetterTextView) view.findViewById(2131566326);
        this.f7531o = (BetterTextView) view.findViewById(2131566327);
        this.f7532p = (GlyphView) view.findViewById(2131566328);
        this.f7533q = new LazyView((ViewStub) view.findViewById(2131566329));
        this.f7534r = view.getContext();
    }

    public final void m10659a(Uri uri, CallerContext callerContext) {
        this.f7529m.a(uri, callerContext);
    }

    public final void m10662w() {
        this.f7532p.setVisibility(0);
        this.f7532p.setImageResource(2130840562);
        this.f7532p.setBackgroundResource(2130839480);
        m10657a(this.f7534r.getString(2131234796), this.f7534r.getResources().getColor(2131361918));
        m10656a(this.f7534r.getResources().getDrawable(2130842767));
    }

    public final void m10661c(boolean z) {
        m10658d(z);
        m10657a(this.f7534r.getResources().getString(2131234795), this.f7534r.getResources().getColor(2131361917));
        m10656a(null);
    }

    public final void m10660a(boolean z, String str) {
        m10658d(z);
        m10657a(str, this.f7534r.getResources().getColor(2131361974));
        m10656a(null);
    }

    private void m10658d(boolean z) {
        if (z) {
            this.f7532p.setVisibility(0);
            this.f7532p.setImageResource(2130840567);
            this.f7532p.setBackgroundResource(2130840156);
            return;
        }
        this.f7532p.setVisibility(8);
    }

    private void m10657a(String str, int i) {
        this.f7531o.setText(str);
        this.f7531o.setTextColor(i);
    }

    private void m10656a(@Nullable Drawable drawable) {
        this.f7528l.setForeground(drawable);
    }
}
