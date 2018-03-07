package com.facebook.timeline.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.i18n.StringLengthHelper;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.fbui.tooltip.Tooltip;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: ui_state */
public class TimelineViewHelper {

    /* compiled from: ui_state */
    final class C01131 extends ClickableSpan {
        final /* synthetic */ Integer f1162a;

        C01131(Integer num) {
            this.f1162a = num;
        }

        public final void onClick(View view) {
            TextView textView = (TextView) view;
            Tooltip tooltip = new Tooltip(textView.getContext(), 2);
            tooltip.t = -1;
            tooltip.a(2131239320);
            tooltip.b(this.f1162a.intValue());
            tooltip.b(0.4f);
            tooltip.d(true);
            tooltip.f(textView);
        }

        public final void updateDrawState(TextPaint textPaint) {
        }
    }

    public static void m1217a(TextView textView, CharSequence charSequence, int i, int i2, int i3) {
        if (StringUtil.a(charSequence)) {
            textView.setText("");
            return;
        }
        textView.setText(charSequence);
        if (charSequence.length() > i) {
            textView.setTextSize(0, (float) i3);
        } else {
            textView.setTextSize(0, (float) i2);
        }
    }

    public static SpannableStringBuilder m1212a(TextView textView, String str, @Nullable String str2, int i, Context context) {
        if (StringUtil.a(str) || textView == null) {
            return null;
        }
        Typeface typeface;
        int style;
        if (textView.getTypeface() != null) {
            typeface = textView.getTypeface();
            style = typeface.getStyle();
        } else {
            typeface = null;
            style = 0;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (StringUtil.a(str2) || str2.equals(str)) {
            textView.setTypeface(typeface);
        } else {
            textView.setTypeface(typeface, 0);
            spannableStringBuilder.setSpan(new StyleSpan(style), 0, str.length(), 33);
            spannableStringBuilder.append(" (" + str2 + ")");
            if (i != 0) {
                spannableStringBuilder.setSpan(new TextAppearanceSpan(context, i), str.length() + 1, spannableStringBuilder.length(), 33);
            }
        }
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder m1214a(String str, @Nullable String str2, int i, int i2, Context context) {
        if (StringUtil.a(str)) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new TextAppearanceSpan(context, i), 0, StringLengthHelper.a(str), 33);
        if (StringUtil.a(str2) || str2.equals(str)) {
            return spannableStringBuilder;
        }
        spannableStringBuilder.append(" (" + str2 + ")");
        if (i2 == 0) {
            return spannableStringBuilder;
        }
        spannableStringBuilder.setSpan(new TextAppearanceSpan(context, i2), StringLengthHelper.a(str) + 1, spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder m1213a(CharSequence charSequence, int i, Context context) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        spannableStringBuilder.setSpan(new TextAppearanceSpan(context, i), 0, charSequence.length(), 33);
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder m1215a(boolean z, boolean z2, SpannableStringBuilder spannableStringBuilder, int i, int i2, Context context, int i3, int i4, Provider<TriState> provider) {
        Object obj;
        Object obj2 = null;
        if (z) {
            obj = 1;
        } else {
            obj = null;
        }
        if (z2 && TriState.YES.equals(provider.get())) {
            obj2 = 1;
        }
        if (!(StringUtil.a(spannableStringBuilder) || (obj == null && r0 == null))) {
            spannableStringBuilder.append("⁠");
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append("[badge]");
            Resources resources = context.getResources();
            if (obj != null) {
                i2 = i;
            }
            Drawable drawable = resources.getDrawable(i2);
            Drawable insetDrawable = new InsetDrawable(drawable, 0, -i4, 0, i4);
            insetDrawable.setBounds(i3, 0, drawable.getIntrinsicWidth() + i3, drawable.getIntrinsicHeight());
            spannableStringBuilder.setSpan(new ImageSpan(insetDrawable, 1), length, spannableStringBuilder.length(), 33);
            if (obj != null) {
                Integer a = m1216a(i);
                if (a != null) {
                    spannableStringBuilder.setSpan(new C01131(a), length, spannableStringBuilder.length(), 33);
                }
            }
        }
        return spannableStringBuilder;
    }

    private static Integer m1216a(int i) {
        if (i == 2130842498) {
            return Integer.valueOf(2131239321);
        }
        if (i == 2130842497) {
            return Integer.valueOf(2131239322);
        }
        return null;
    }
}
