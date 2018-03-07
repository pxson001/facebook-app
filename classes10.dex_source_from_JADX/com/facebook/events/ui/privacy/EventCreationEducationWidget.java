package com.facebook.events.ui.privacy;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.util.AttributeSet;
import com.facebook.common.util.StringUtil;
import com.facebook.events.model.PrivacyType;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.OnDrawListenerSet;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: appfeed */
public class EventCreationEducationWidget extends FbTextView {
    private TextAppearanceSpan f19481a;
    private TextAppearanceSpan f19482b;
    private final OnDrawListenerSet f19483c = new OnDrawListenerSet();

    /* compiled from: appfeed */
    /* synthetic */ class C27721 {
        static final /* synthetic */ int[] f19480a = new int[PrivacyType.values().length];

        static {
            try {
                f19480a[PrivacyType.INVITE_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f19480a[PrivacyType.USER_PUBLIC.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f19480a[PrivacyType.GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f19480a[PrivacyType.COMMUNITY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public EventCreationEducationWidget(Context context) {
        super(context);
        m19665a();
    }

    public EventCreationEducationWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m19665a();
    }

    public EventCreationEducationWidget(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19665a();
    }

    private void m19665a() {
        this.f19482b = new TextAppearanceSpan(getContext(), 2131625791);
        this.f19481a = new TextAppearanceSpan(getContext(), 2131625792);
    }

    public final CharSequence m19667a(PrivacyType privacyType, boolean z) {
        CharSequence charSequence = null;
        if (privacyType != null) {
            CharSequence a = m19664a(privacyType);
            CharSequence b = m19666b(privacyType, z);
            if (!Strings.isNullOrEmpty(a)) {
                if (VERSION.SDK_INT >= 17) {
                    setCompoundDrawablesRelativeWithIntrinsicBounds(2130840788, 0, 0, 0);
                } else {
                    setCompoundDrawablesWithIntrinsicBounds(2130840788, 0, 0, 0);
                }
                charSequence = new SpannableStringBuilder();
                if (!StringUtil.a(a)) {
                    m19663a(charSequence, a, this.f19482b, 17);
                }
                if (!StringUtil.a(b)) {
                    if (charSequence.length() > 0) {
                        charSequence.append("\n");
                    }
                    m19663a(charSequence, b, this.f19481a, 17);
                }
            }
        }
        return charSequence;
    }

    public final void m19668a(CharSequence charSequence) {
        setText(charSequence);
        setVisibility(charSequence == null ? 8 : 0);
    }

    public void setOnDrawListenerTo(OnDrawListener onDrawListener) {
        this.f19483c.b(onDrawListener);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f19483c.a();
    }

    private String m19664a(PrivacyType privacyType) {
        switch (C27721.f19480a[privacyType.ordinal()]) {
            case 1:
                return getResources().getString(2131236905);
            case 2:
                return getResources().getString(2131241657);
            case 3:
                return getResources().getString(2131241659);
            case 4:
                return getResources().getString(2131241661);
            default:
                return null;
        }
    }

    private String m19666b(PrivacyType privacyType, boolean z) {
        switch (C27721.f19480a[privacyType.ordinal()]) {
            case 1:
                if (z) {
                    return getResources().getString(2131241655);
                }
                return getResources().getString(2131241656);
            case 2:
                return getResources().getString(2131241658);
            case 3:
                return getResources().getString(2131241660);
            case 4:
                return getResources().getString(2131241662);
            default:
                return null;
        }
    }

    private static SpannableStringBuilder m19663a(SpannableStringBuilder spannableStringBuilder, CharSequence charSequence, Object obj, int i) {
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append(charSequence);
        spannableStringBuilder.setSpan(obj, length, spannableStringBuilder.length(), i);
        return spannableStringBuilder;
    }
}
