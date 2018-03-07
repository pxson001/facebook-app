package com.facebook.facecast.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbToggleButton;
import com.facebook.resources.utils.TextViewUtils;
import com.facebook.widget.text.CustomFontHelper;
import com.facebook.widget.text.CustomFontHelper.FontFamily;
import com.facebook.widget.text.CustomFontHelper.FontWeight;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: borderTopRightRadius */
public class FacecastHdUploadButton extends FbToggleButton {
    @Inject
    public GlyphColorizer f18827a;
    public OnInterceptClickListener f18828b;

    /* compiled from: borderTopRightRadius */
    public interface OnInterceptClickListener {
        boolean mo1418a();
    }

    private static <T extends View> void m22426a(Class<T> cls, T t) {
        m22427a((Object) t, t.getContext());
    }

    private static void m22427a(Object obj, Context context) {
        ((FacecastHdUploadButton) obj).f18827a = GlyphColorizer.a(FbInjector.get(context));
    }

    public FacecastHdUploadButton(Context context) {
        this(context, null);
    }

    public FacecastHdUploadButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FacecastHdUploadButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m22424a();
    }

    private void m22424a() {
        m22426a(FacecastHdUploadButton.class, (View) this);
        TextViewUtils.a(this, this.f18827a.a(2130840147, getResources().getColor(17170443)), null, null, null);
        setClickable(true);
        CustomFontHelper.a(this, FontFamily.ROBOTO, FontWeight.MEDIUM, getTypeface());
    }

    public void setOnInterceptClickListener(OnInterceptClickListener onInterceptClickListener) {
        this.f18828b = onInterceptClickListener;
    }

    public boolean performClick() {
        if (this.f18828b == null || !this.f18828b.mo1418a()) {
            return super.performClick();
        }
        return true;
    }

    private void m22425a(GlyphColorizer glyphColorizer) {
        this.f18827a = glyphColorizer;
    }
}
