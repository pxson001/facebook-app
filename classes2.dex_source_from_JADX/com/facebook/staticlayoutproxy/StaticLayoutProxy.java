package com.facebook.staticlayoutproxy;

import android.support.v4.text.TextDirectionHeuristicCompat;
import android.support.v4.text.TextDirectionHeuristicsCompat;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;

/* compiled from: gravity_android_employee_debug */
public class StaticLayoutProxy {
    public static StaticLayout m29636a(CharSequence charSequence, int i, int i2, TextPaint textPaint, int i3, Alignment alignment, float f, float f2, boolean z, TruncateAt truncateAt, int i4, int i5, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return new StaticLayout(charSequence, i, i2, textPaint, i3, alignment, m29637a(textDirectionHeuristicCompat), f, f2, z, truncateAt, i4, i5);
    }

    private static TextDirectionHeuristic m29637a(TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        if (textDirectionHeuristicCompat == TextDirectionHeuristicsCompat.f7476a) {
            return TextDirectionHeuristics.LTR;
        }
        if (textDirectionHeuristicCompat == TextDirectionHeuristicsCompat.f7477b) {
            return TextDirectionHeuristics.RTL;
        }
        if (textDirectionHeuristicCompat == TextDirectionHeuristicsCompat.f7478c) {
            return TextDirectionHeuristics.FIRSTSTRONG_LTR;
        }
        if (textDirectionHeuristicCompat == TextDirectionHeuristicsCompat.f7479d) {
            return TextDirectionHeuristics.FIRSTSTRONG_RTL;
        }
        if (textDirectionHeuristicCompat == TextDirectionHeuristicsCompat.f7480e) {
            return TextDirectionHeuristics.ANYRTL_LTR;
        }
        if (textDirectionHeuristicCompat == TextDirectionHeuristicsCompat.f7481f) {
            return TextDirectionHeuristics.LOCALE;
        }
        return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    }
}
