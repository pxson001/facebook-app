package com.facebook.privacy.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.R;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.FbInjector;
import com.facebook.privacy.model.PrivacyOptionHelper;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyIconFields;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFieldsWithExplanation;
import com.facebook.privacy.ui.PrivacyIcons.Size;
import com.facebook.resources.ui.FbTextView;
import javax.inject.Inject;

/* compiled from: family_tagged_mediaset */
public class PrivacyOptionView extends FbTextView {
    private PrivacyIcons f15333a;
    private GlyphColorizer f15334b;
    public boolean f15335c;

    private static <T extends View> void m22964a(Class<T> cls, T t) {
        m22965a((Object) t, t.getContext());
    }

    private static void m22965a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PrivacyOptionView) obj).m22963a(PrivacyIcons.m22956a(fbInjector), GlyphColorizer.a(fbInjector));
    }

    public PrivacyOptionView(Context context) {
        super(context);
        m22962a(context, null);
    }

    public PrivacyOptionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m22962a(context, attributeSet);
    }

    public PrivacyOptionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m22962a(context, attributeSet);
    }

    @Inject
    private void m22963a(PrivacyIcons privacyIcons, GlyphColorizer glyphColorizer) {
        this.f15333a = privacyIcons;
        this.f15334b = glyphColorizer;
    }

    private void m22962a(Context context, AttributeSet attributeSet) {
        m22964a(PrivacyOptionView.class, (View) this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PrivacyOptionView);
            this.f15335c = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
            return;
        }
        this.f15335c = false;
    }

    public void setPrivacyOption(PrivacyOptionFieldsWithExplanation privacyOptionFieldsWithExplanation) {
        if (privacyOptionFieldsWithExplanation == null) {
            setText("");
            setViewDrawables(-1);
            return;
        }
        setText(privacyOptionFieldsWithExplanation.d());
        setViewDrawables(this.f15333a.m22957a(PrivacyOptionHelper.a(privacyOptionFieldsWithExplanation), Size.TOKEN));
    }

    public final void m22967a(String str, PrivacyIconFields privacyIconFields) {
        setText(str);
        if (privacyIconFields != null) {
            setViewDrawables(this.f15333a.m22959a(privacyIconFields, Size.TOKEN));
        } else {
            setViewDrawables(-1);
        }
    }

    public final void m22966a(String str, int i) {
        setText(str);
        setViewDrawables(i);
    }

    private void setViewDrawables(int i) {
        Drawable a;
        Drawable a2;
        if (i > 0) {
            a = m22961a(i, 2131429373);
        } else {
            a = null;
        }
        if (this.f15335c) {
            a2 = m22961a(2130840139, 2131429374);
        } else {
            a2 = null;
        }
        setCompoundDrawables(a, null, a2, null);
    }

    private Drawable m22961a(int i, int i2) {
        Drawable a = this.f15334b.a(i, getCurrentTextColor());
        int dimensionPixelSize = getResources().getDimensionPixelSize(i2);
        a.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        return a;
    }

    public void setShowChevron(boolean z) {
        this.f15335c = z;
    }
}
