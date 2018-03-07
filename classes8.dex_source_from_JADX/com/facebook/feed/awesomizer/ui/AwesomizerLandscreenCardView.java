package com.facebook.feed.awesomizer.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.R;
import com.facebook.common.util.FindViewUtil;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbTextView;
import javax.inject.Inject;

/* compiled from: hasInvalidate */
public class AwesomizerLandscreenCardView extends ImageBlockLayout {
    @Inject
    public GlyphColorizer f11759h;
    private FbTextView f11760i;
    private GlyphView f11761j;
    private GlyphView f11762k;

    private static <T extends View> void m13855a(Class<T> cls, T t) {
        m13856a((Object) t, t.getContext());
    }

    private static void m13856a(Object obj, Context context) {
        ((AwesomizerLandscreenCardView) obj).f11759h = GlyphColorizer.a(FbInjector.get(context));
    }

    private void m13854a(GlyphColorizer glyphColorizer) {
        this.f11759h = glyphColorizer;
    }

    public AwesomizerLandscreenCardView(Context context) {
        this(context, null);
    }

    public AwesomizerLandscreenCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m13855a(AwesomizerLandscreenCardView.class, (View) this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AwesomizerLandscreenCardView);
        m13853a(context, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    private void m13853a(Context context, TypedArray typedArray) {
        LayoutInflater.from(context).inflate(2130904997, this);
        this.f11760i = (FbTextView) FindViewUtil.b(this, 2131563341);
        this.f11761j = (GlyphView) FindViewUtil.b(this, 2131563342);
        this.f11762k = (GlyphView) FindViewUtil.b(this, 2131563343);
        this.f11760i.setText(typedArray.getText(0));
        this.f11762k.setGlyphColor(typedArray.getColor(4, 0));
        this.f11761j.setImageDrawable(context.getResources().getDrawable(typedArray.getResourceId(6, 0)));
        this.f11761j.setBackgroundDrawable(this.f11759h.a(2130841018, typedArray.getColor(4, 0), false));
    }

    public void setCardCheckVisibility(int i) {
        this.f11762k.setVisibility(i);
    }
}
