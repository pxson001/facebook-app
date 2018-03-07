package com.facebook.facecastdisplay;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.facebook.common.util.StyledStringBuilder;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* compiled from: submitResearchPollResponseParamsKey */
public class FacecastUiUtil {
    public static String m3100a(long j) {
        long j2 = j / 3600000;
        long j3 = (j / 60000) % 60;
        long j4 = (j / 1000) % 60;
        StringBuilder stringBuilder = new StringBuilder();
        if (j2 > 0) {
            stringBuilder.append(j2 + ":" + (j3 < 10 ? "0" : ""));
        }
        stringBuilder.append(j3 + ":" + (j4 < 10 ? "0" : "") + j4);
        return stringBuilder.toString();
    }

    public static void m3103a(int i, String str, List list, StyledStringBuilder styledStringBuilder) {
        CharSequence spannableString = new SpannableString(str);
        for (Object span : list) {
            spannableString.setSpan(span, 0, str.length(), 33);
        }
        styledStringBuilder.a("%" + i + "$s", spannableString);
    }

    public static List m3101a(Resources resources) {
        return m3102a(resources, 2131361973);
    }

    public static List m3102a(Resources resources, int i) {
        return ImmutableList.of(new StyleSpan(1), new ForegroundColorSpan(resources.getColor(i)));
    }

    public static ObjectAnimator m3098a(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{1.0f, 0.7f});
        ofFloat.setDuration(700);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        return ofFloat;
    }

    public static CharSequence m3099a(boolean z, Resources resources) {
        CharSequence spannableString = new SpannableString("·");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(resources.getColor(z ? 2131362612 : 2131362613));
        StyleSpan styleSpan = new StyleSpan(1);
        spannableString.setSpan(foregroundColorSpan, 0, spannableString.length(), 33);
        spannableString.setSpan(styleSpan, 0, spannableString.length(), 33);
        return spannableString;
    }

    public static int m3097a() {
        return 2131624719;
    }

    public static int m3104b() {
        return 2131624720;
    }
}
