package com.facebook.fbui.widget.text.staticlayouthelper;

import android.support.v4.text.TextDirectionHeuristicCompat;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import com.facebook.staticlayoutproxy.StaticLayoutProxy;
import java.lang.reflect.Field;

/* compiled from: gravity_android_menu */
public class StaticLayoutHelper {
    private static StaticLayout m29635b(CharSequence charSequence, int i, int i2, TextPaint textPaint, int i3, Alignment alignment, float f, float f2, boolean z, TruncateAt truncateAt, int i4, int i5, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        try {
            return StaticLayoutProxy.m29636a(charSequence, i, i2, textPaint, i3, alignment, f, f2, z, truncateAt, i4, i5, textDirectionHeuristicCompat);
        } catch (LinkageError e) {
            return m29631a(charSequence, i, i2, textPaint, i3, alignment, f, f2, z, truncateAt, i4);
        }
    }

    private static StaticLayout m29631a(CharSequence charSequence, int i, int i2, TextPaint textPaint, int i3, Alignment alignment, float f, float f2, boolean z, TruncateAt truncateAt, int i4) {
        return new StaticLayout(charSequence, i, i2, textPaint, i3, alignment, f, f2, z, truncateAt, i4);
    }

    public static StaticLayout m29632a(CharSequence charSequence, int i, int i2, TextPaint textPaint, int i3, Alignment alignment, float f, float f2, boolean z, TruncateAt truncateAt, int i4, int i5, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        StaticLayout b = m29635b(charSequence, i, i2, textPaint, i3, alignment, f, f2, z, truncateAt, i4, i5, textDirectionHeuristicCompat);
        if (i5 > 0) {
            while (b.getLineCount() > i5) {
                int lineStart = b.getLineStart(i5);
                if (lineStart >= i2) {
                    break;
                }
                while (lineStart > i) {
                    if (!Character.isSpace(charSequence.charAt(lineStart - 1))) {
                        break;
                    }
                    lineStart--;
                }
                b = m29635b(charSequence, i, lineStart, textPaint, i3, alignment, f, f2, z, truncateAt, i4, i5, textDirectionHeuristicCompat);
                if (b.getLineCount() >= i5 && b.getEllipsisCount(i5 - 1) == 0) {
                    CharSequence charSequence2 = charSequence.subSequence(i, lineStart) + " …";
                    b = m29635b(charSequence2, 0, charSequence2.length(), textPaint, i3, alignment, f, f2, z, truncateAt, i4, i5, textDirectionHeuristicCompat);
                }
                i2 = lineStart;
            }
        }
        do {
        } while (!m29634a(b));
        return b;
    }

    private static boolean m29634a(StaticLayout staticLayout) {
        int lineStart = staticLayout.getLineStart(0);
        int lineCount = staticLayout.getLineCount();
        int i = 0;
        while (i < lineCount) {
            int lineEnd = staticLayout.getLineEnd(i);
            if (lineEnd < lineStart) {
                try {
                    Field declaredField = StaticLayout.class.getDeclaredField("mLines");
                    declaredField.setAccessible(true);
                    Field declaredField2 = StaticLayout.class.getDeclaredField("mColumns");
                    declaredField2.setAccessible(true);
                    int[] iArr = (int[]) declaredField.get(staticLayout);
                    lineCount = declaredField2.getInt(staticLayout);
                    for (lineEnd = 0; lineEnd < lineCount; lineEnd++) {
                        m29633a(iArr, (lineCount * i) + lineEnd, ((lineCount * i) + lineEnd) + lineCount);
                    }
                    return false;
                } catch (Exception e) {
                }
            } else {
                i++;
                lineStart = lineEnd;
            }
        }
        return true;
    }

    private static void m29633a(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
    }
}
