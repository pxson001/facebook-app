package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.R;
import com.google.android.gms.common.api.Scope;

public final class zzac extends Button {
    public zzac(Context context) {
        this(context, null);
    }

    private zzac(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842824);
    }

    private static int m12270a(int i, int i2, int i3) {
        switch (i) {
            case 0:
            case 1:
                return i3;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                return i2;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
    }

    private static int m12271a(int i, int i2, int i3, int i4) {
        switch (i) {
            case 0:
                return i2;
            case 1:
                return i3;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                return i4;
            default:
                throw new IllegalStateException("Unknown color scheme: " + i);
        }
    }

    private void m12272a(Resources resources) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        float f = resources.getDisplayMetrics().density;
        setMinHeight((int) ((f * 48.0f) + 0.5f));
        setMinWidth((int) ((f * 48.0f) + 0.5f));
    }

    private void m12273a(Resources resources, int i, int i2, boolean z) {
        setBackgroundDrawable(resources.getDrawable(z ? m12270a(i, m12271a(i2, R.drawable.common_plus_signin_btn_icon_dark, R.drawable.common_plus_signin_btn_icon_light, R.drawable.common_plus_signin_btn_icon_dark), m12271a(i2, R.drawable.common_plus_signin_btn_text_dark, R.drawable.common_plus_signin_btn_text_light, R.drawable.common_plus_signin_btn_text_dark)) : m12270a(i, m12271a(i2, R.drawable.common_google_signin_btn_icon_dark, R.drawable.common_google_signin_btn_icon_light, R.drawable.common_google_signin_btn_icon_light), m12271a(i2, R.drawable.common_google_signin_btn_text_dark, R.drawable.common_google_signin_btn_text_light, R.drawable.common_google_signin_btn_text_light))));
    }

    private void m12274b(Resources resources, int i, int i2, boolean z) {
        setTextColor((ColorStateList) zzx.a(resources.getColorStateList(z ? m12271a(i2, R.color.common_plus_signin_btn_text_dark, R.color.common_plus_signin_btn_text_light, R.color.common_plus_signin_btn_text_dark) : m12271a(i2, R.color.common_google_signin_btn_text_dark, R.color.common_google_signin_btn_text_light, R.color.common_google_signin_btn_text_light))));
        switch (i) {
            case 0:
                setText(resources.getString(R.string.common_signin_button_text));
                break;
            case 1:
                setText(resources.getString(R.string.common_signin_button_text_long));
                break;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                setText(null);
                break;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
        setTransformationMethod(null);
    }

    public final void m12275a(Resources resources, int i, int i2, Scope[] scopeArr) {
        boolean z = false;
        if (scopeArr != null) {
            int length = scopeArr.length;
            int i3 = 0;
            while (i3 < length) {
                String str = scopeArr[i3].b;
                if (str.contains("/plus.") && !str.equals("https://www.googleapis.com/auth/plus.me")) {
                    z = true;
                    break;
                } else if (str.equals("https://www.googleapis.com/auth/games")) {
                    z = true;
                    break;
                } else {
                    i3++;
                }
            }
        }
        boolean z2 = z;
        m12272a(resources);
        m12273a(resources, i, i2, z2);
        m12274b(resources, i, i2, z2);
    }
}
