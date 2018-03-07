package com.facebook.feed.awesomizer.ui;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.FindViewUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.facepile.FacepileView;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbTextView;
import java.util.List;
import javax.inject.Inject;

/* compiled from: has_backed_out_of_place_picker */
public class AwesomizerGridItemView extends LinearLayout {
    @Inject
    public GlyphColorizer f11748a;
    private FbDraweeView f11749b;
    private FacepileView f11750c;
    private FbTextView f11751d;
    private FbTextView f11752e;
    private boolean f11753f = false;
    public boolean f11754g = false;
    private int f11755h;
    private int f11756i;
    private Drawable f11757j;
    private Drawable f11758k;

    private static <T extends View> void m13848a(Class<T> cls, T t) {
        m13849a((Object) t, t.getContext());
    }

    private static void m13849a(Object obj, Context context) {
        ((AwesomizerGridItemView) obj).f11748a = GlyphColorizer.a(FbInjector.get(context));
    }

    private void m13847a(GlyphColorizer glyphColorizer) {
        this.f11748a = glyphColorizer;
    }

    public AwesomizerGridItemView(Context context) {
        super(context);
        m13846a(context);
    }

    public AwesomizerGridItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m13846a(context);
    }

    private void m13846a(Context context) {
        m13848a(AwesomizerGridItemView.class, (View) this);
        LayoutInflater.from(context).inflate(2130903337, this);
        this.f11749b = (FbDraweeView) FindViewUtil.b(this, 2131559791);
        this.f11750c = (FacepileView) FindViewUtil.b(this, 2131559792);
        this.f11751d = (FbTextView) FindViewUtil.b(this, 2131559793);
        this.f11752e = (FbTextView) FindViewUtil.b(this, 2131559794);
        Theme theme = getContext().getTheme();
        TypedValue typedValue = new TypedValue();
        TypedValue typedValue2 = new TypedValue();
        theme.resolveAttribute(2130773489, typedValue, true);
        theme.resolveAttribute(2130773490, typedValue2, true);
        this.f11756i = typedValue.data;
        this.f11755h = typedValue2.data;
        this.f11757j = getResources().getDrawable(2130843312);
        this.f11758k = this.f11748a.a(2130837749, getResources().getColor(2131361920));
    }

    public final void m13850a(Uri uri, CallerContext callerContext) {
        this.f11749b.a(uri, callerContext);
    }

    public void setAvatarImageViewDrawable(int i) {
        this.f11749b.setImageResource(i);
    }

    public void setAvatarImageViewBorder(Drawable drawable) {
        this.f11749b.setBackgroundDrawable(drawable);
    }

    public final void m13851a(List<String> list, int i) {
        if (i >= 102) {
            i = 99;
        }
        this.f11750c.setFaceCountForOverflow(i);
        this.f11750c.setFaceStrings(list);
        this.f11750c.setVisibility(0);
    }

    public void setAvatarContextViewText(String str) {
        this.f11752e.setText(str);
    }

    public void setAvatarContextViewTextColor(int i) {
        this.f11752e.setTextColor(i);
    }

    public void setAvatarContextViewVisibility(int i) {
        this.f11752e.setVisibility(i);
    }

    public void setAvatarNameViewText(String str) {
        this.f11751d.setText(str);
    }

    public void setShowStar(boolean z) {
        this.f11754g = z;
    }

    public final void m13852a(boolean z) {
        int i;
        int i2;
        this.f11753f = z;
        int i3;
        if (z) {
            i3 = this.f11755h;
            i = this.f11756i;
            i2 = i3;
        } else {
            i3 = getResources().getColor(2131361920);
            i = getResources().getColor(2131361937);
            i2 = i3;
        }
        LayerDrawable layerDrawable = (LayerDrawable) getResources().getDrawable(2130837741);
        ((GradientDrawable) layerDrawable.findDrawableByLayerId(2131568578)).setStroke((int) getResources().getDimension(2131430782), i2);
        setAvatarContextViewTextColor(i);
        setAvatarImageViewBorder(layerDrawable);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f11753f && this.f11754g) {
            this.f11757j.setBounds(this.f11749b.getRight() - this.f11757j.getIntrinsicWidth(), 0, this.f11749b.getRight(), this.f11757j.getIntrinsicHeight());
            this.f11757j.draw(canvas);
            this.f11758k.setBounds(this.f11749b.getRight() - this.f11758k.getIntrinsicWidth(), 0, this.f11749b.getRight(), this.f11758k.getIntrinsicHeight());
            this.f11758k.draw(canvas);
        }
    }
}
