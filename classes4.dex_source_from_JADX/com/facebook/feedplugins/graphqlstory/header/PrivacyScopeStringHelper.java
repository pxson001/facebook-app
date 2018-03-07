package com.facebook.feedplugins.graphqlstory.header;

import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.view.View;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.goodfriends.abtest.ExperimentsForGoodFriendsAbtestModule;
import com.facebook.goodfriends.abtest.FeedPrivacyRenderingQEStore;
import com.facebook.goodfriends.abtest.GoodFriendsFeedPrivacyRenderingQEStore;
import com.facebook.inject.Lazy;
import com.facebook.widget.text.PrivacyImageSpan;
import com.facebook.widget.text.RoundedBackgroundSpan;
import com.facebook.widget.text.TextSpan;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: near_saved_place */
public class PrivacyScopeStringHelper {
    private final FeedPrivacyRenderingQEStore f7259a;
    private final GoodFriendsFeedPrivacyRenderingQEStore f7260b;
    private final Resources f7261c;
    private TextPaint f7262d;

    /* compiled from: near_saved_place */
    class QEParameters {
        public final boolean f7263a;
        public final boolean f7264b;
        public final boolean f7265c;
        public final boolean f7266d;
        public final int f7267e;
        public final int f7268f;
        public final boolean f7269g;
        final /* synthetic */ PrivacyScopeStringHelper f7270h;

        private QEParameters(PrivacyScopeStringHelper privacyScopeStringHelper, boolean z, boolean z2, boolean z3, boolean z4, int i, int i2, boolean z5) {
            this.f7270h = privacyScopeStringHelper;
            this.f7263a = z;
            this.f7264b = z2;
            this.f7265c = z3;
            this.f7266d = z4;
            this.f7267e = i;
            this.f7268f = i2;
            this.f7269g = z5;
        }
    }

    @Inject
    public PrivacyScopeStringHelper(FeedPrivacyRenderingQEStore feedPrivacyRenderingQEStore, GoodFriendsFeedPrivacyRenderingQEStore goodFriendsFeedPrivacyRenderingQEStore, Resources resources) {
        this.f7259a = feedPrivacyRenderingQEStore;
        this.f7260b = goodFriendsFeedPrivacyRenderingQEStore;
        this.f7261c = resources;
    }

    public final SpannableStringBuilder m7597a(String str, BulletedHeaderSubtitleFormatter bulletedHeaderSubtitleFormatter, PrivacyImageSpan privacyImageSpan, PrivacyString privacyString, SpannableStringBuilder spannableStringBuilder, TextPaint textPaint, Lazy<Float> lazy, Lazy<Float> lazy2, boolean z) {
        QEParameters a = m7590a(privacyString.b(), z);
        CharSequence spannableStringBuilder2 = new SpannableStringBuilder();
        if (a.f7269g) {
            m7592a(a, spannableStringBuilder2, privacyImageSpan);
            if (a.f7265c) {
                m7594a(str, a, spannableStringBuilder, spannableStringBuilder2, privacyString, textPaint, lazy, lazy2);
            }
            bulletedHeaderSubtitleFormatter.a(spannableStringBuilder2);
            return spannableStringBuilder2.append(spannableStringBuilder);
        }
        bulletedHeaderSubtitleFormatter.a(spannableStringBuilder2);
        m7592a(a, spannableStringBuilder2, privacyImageSpan);
        if (a.f7265c) {
            m7594a(str, a, spannableStringBuilder, spannableStringBuilder2, privacyString, textPaint, lazy, lazy2);
        }
        spannableStringBuilder.append(spannableStringBuilder2);
        return spannableStringBuilder;
    }

    private static void m7592a(QEParameters qEParameters, SpannableStringBuilder spannableStringBuilder, PrivacyImageSpan privacyImageSpan) {
        int length = spannableStringBuilder.length();
        if (qEParameters.f7264b) {
            privacyImageSpan.a.setColorFilter(qEParameters.f7267e, Mode.SRC_IN);
            spannableStringBuilder.append('a');
            spannableStringBuilder.setSpan(privacyImageSpan, length, length + 1, 17);
            spannableStringBuilder.append(' ');
        }
    }

    private void m7594a(String str, QEParameters qEParameters, SpannableStringBuilder spannableStringBuilder, SpannableStringBuilder spannableStringBuilder2, PrivacyString privacyString, TextPaint textPaint, Lazy<Float> lazy, Lazy<Float> lazy2) {
        int length = spannableStringBuilder2.length();
        spannableStringBuilder2.append(privacyString.a());
        int length2 = spannableStringBuilder2.length();
        if (this.f7262d == null) {
            this.f7262d = new TextPaint(textPaint);
        }
        this.f7262d.setColor(qEParameters.f7267e);
        if (m7595a(privacyString.b())) {
            Object 1;
            if (qEParameters.f7269g) {
                1 = new 1(this, privacyString, textPaint, str);
            } else {
                1 = new 2(this, privacyString, textPaint, spannableStringBuilder, str);
            }
            spannableStringBuilder2.setSpan(1, length - 1, length2, 17);
        }
        if (qEParameters.f7266d) {
            m7593a(qEParameters, lazy, lazy2, spannableStringBuilder2, length, length2);
        } else {
            m7591a(qEParameters, spannableStringBuilder2, length, length2);
        }
    }

    public static Tooltip m7589a(PrivacyScopeStringHelper privacyScopeStringHelper, View view, int i, String str) {
        CharSequence string;
        PopoverWindow tooltip = new Tooltip(view.getContext());
        if (Strings.isNullOrEmpty(str)) {
            string = privacyScopeStringHelper.f7261c.getString(2131235601);
        } else {
            string = privacyScopeStringHelper.f7261c.getString(2131235602, new Object[]{str});
        }
        tooltip.m6259b(string);
        tooltip.f5777t = -1;
        tooltip.m6279a(view, i, 0, 0, 0);
        return tooltip;
    }

    public static int m7596b(int i, float f, String str, TextPaint textPaint) {
        return (int) ((f - ((float) ((int) (((float) (i / 2)) + f)))) + (Layout.getDesiredWidth(str, textPaint) / 2.0f));
    }

    private void m7591a(QEParameters qEParameters, SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        spannableStringBuilder.setSpan(new TextSpan(this.f7262d, qEParameters.f7267e), i, i2, 17);
    }

    private static void m7593a(QEParameters qEParameters, Lazy<Float> lazy, Lazy<Float> lazy2, SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        spannableStringBuilder.setSpan(new RoundedBackgroundSpan(((Float) lazy.get()).floatValue(), ((Float) lazy2.get()).floatValue(), qEParameters.f7268f, Integer.valueOf(qEParameters.f7267e)), i, i2, 17);
    }

    private QEParameters m7590a(String str, boolean z) {
        boolean z2;
        if (z) {
            z2 = false;
        } else {
            z2 = this.f7259a.c();
        }
        if (m7595a(str)) {
            return new QEParameters(this.f7260b.a(), this.f7260b.a.a(ExperimentsForGoodFriendsAbtestModule.b, false), this.f7260b.c(), this.f7260b.d(), this.f7260b.e(), this.f7260b.f(), z2);
        }
        return new QEParameters(this.f7259a.a(), this.f7259a.b(), true, this.f7259a.d(), this.f7259a.e(), this.f7259a.f(), z2);
    }

    private boolean m7595a(String str) {
        return "good_friends".equals(str) && this.f7260b.a();
    }
}
