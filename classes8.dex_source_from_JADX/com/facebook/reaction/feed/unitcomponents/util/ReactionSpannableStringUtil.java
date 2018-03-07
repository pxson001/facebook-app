package com.facebook.reaction.feed.unitcomponents.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.TypefaceSpan;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultTimeRangeFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.pages.hours.PageHours;
import com.facebook.pages.hours.PageHours.Status;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.PlaceInfoBlurbFieldsModel;
import com.facebook.text.CustomTypefaceSpan;
import com.facebook.widget.text.CustomFontHelper;
import com.facebook.widget.text.CustomFontHelper.FontFamily;
import com.facebook.widget.text.CustomFontHelper.FontWeight;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.TimeZone;
import javax.annotation.Nullable;

/* compiled from: You are pretending to be at %s */
public class ReactionSpannableStringUtil {

    /* compiled from: You are pretending to be at %s */
    class StarSpan extends ImageSpan {
        private int f20712a;

        public StarSpan(Drawable drawable, int i) {
            super(drawable);
            this.f20712a = i;
        }

        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            Drawable drawable = getDrawable();
            canvas.save();
            FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            canvas.translate(f, (float) (((fontMetricsInt.bottom - fontMetricsInt.top) - this.f20712a) / 2));
            drawable.draw(canvas);
            canvas.restore();
        }
    }

    /* compiled from: You are pretending to be at %s */
    public class TokenReplacerProps {
        public final String f20713a;
        public final String f20714b;
        @Nullable
        public final CharacterStyle f20715c;

        public TokenReplacerProps(String str, String str2, @Nullable CharacterStyle characterStyle) {
            this.f20713a = str;
            this.f20714b = str2;
            this.f20715c = characterStyle;
        }
    }

    public static SpannableStringBuilder m24372a(SystemClock systemClock, Locale locale, ImmutableList<? extends DefaultTimeRangeFields> immutableList, @Nullable String str, double d, double d2, @Nullable String str2, Resources resources) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        NumberFormat instance = NumberFormat.getInstance(locale);
        instance.setMaximumFractionDigits(1);
        instance.setMinimumFractionDigits(1);
        instance.setMaximumIntegerDigits(1);
        instance.setMinimumIntegerDigits(1);
        if (d > 0.0d) {
            m24376a(spannableStringBuilder, instance.format(d), new ForegroundColorSpan(resources.getColor(2131361917)));
            m24375a(resources.getDimensionPixelSize(2131427397), spannableStringBuilder, resources);
            spannableStringBuilder.append(" · ");
        }
        if (d2 > 0.0d) {
            spannableStringBuilder.append(resources.getQuantityString(2131689684, (int) d2, new Object[]{Integer.valueOf((int) d2)}));
            spannableStringBuilder.append(" · ");
        }
        if (!TextUtils.isEmpty(str)) {
            spannableStringBuilder.append(str);
            spannableStringBuilder.append(" · ");
        }
        Status a = m24374a((ImmutableList) immutableList, str2, (Clock) systemClock);
        if (a != null) {
            String string;
            int color;
            if (a == Status.OPEN) {
                string = resources.getString(2131236703);
            } else {
                string = resources.getString(2131236704);
            }
            if (a == Status.OPEN) {
                color = resources.getColor(2131361919);
            } else {
                color = resources.getColor(2131361918);
            }
            m24376a(spannableStringBuilder, string, new ForegroundColorSpan(color));
            spannableStringBuilder.append(" · ");
        }
        if (TextUtils.isEmpty(spannableStringBuilder)) {
            return spannableStringBuilder;
        }
        return spannableStringBuilder.delete(spannableStringBuilder.length() - 3, spannableStringBuilder.length());
    }

    public static SpannableStringBuilder m24371a(Clock clock, Context context, @Nullable String str, String str2, PlaceInfoBlurbFieldsModel placeInfoBlurbFieldsModel) {
        Status status;
        Resources resources = context.getResources();
        int color = resources.getColor(2131361974);
        int color2 = resources.getColor(2131361917);
        int dimensionPixelSize = resources.getDimensionPixelSize(2131427397);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!Strings.isNullOrEmpty(str)) {
            m24377a(spannableStringBuilder, str, new ForegroundColorSpan(color), m24373a(context));
            spannableStringBuilder.append(" · ");
        }
        if (placeInfoBlurbFieldsModel.g() != null) {
            m24377a(spannableStringBuilder, new DecimalFormat("0.#").format(placeInfoBlurbFieldsModel.g().a()), new ForegroundColorSpan(color2), m24373a(context));
            m24375a(dimensionPixelSize, spannableStringBuilder, resources);
            spannableStringBuilder.append(" · ");
        }
        if (placeInfoBlurbFieldsModel.d() == null) {
            status = null;
        } else {
            status = m24374a(placeInfoBlurbFieldsModel.b(), placeInfoBlurbFieldsModel.d().a(), clock);
        }
        Status status2 = status;
        if (status2 != null) {
            m24377a(spannableStringBuilder, status2 == Status.OPEN ? resources.getString(2131236703) : resources.getString(2131236704), new ForegroundColorSpan(status2 == Status.OPEN ? resources.getColor(2131361919) : resources.getColor(2131361918)), m24373a(context));
            spannableStringBuilder.append(" · ");
        }
        if (!Strings.isNullOrEmpty(placeInfoBlurbFieldsModel.eE_())) {
            m24377a(spannableStringBuilder, placeInfoBlurbFieldsModel.eE_(), new ForegroundColorSpan(color), m24373a(context));
            spannableStringBuilder.append(" · ");
        }
        m24376a(spannableStringBuilder, str2.replaceAll("\n", " "), new ForegroundColorSpan(color));
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder m24369a(Resources resources, SpannableStringBuilder spannableStringBuilder, boolean z, @Nullable DefaultTextWithEntitiesFields defaultTextWithEntitiesFields, int i, int i2, int i3) {
        return m24370a(resources, spannableStringBuilder, z, defaultTextWithEntitiesFields == null ? null : defaultTextWithEntitiesFields.a(), i, i2, i3);
    }

    public static SpannableStringBuilder m24370a(Resources resources, SpannableStringBuilder spannableStringBuilder, boolean z, @Nullable String str, int i, int i2, int i3) {
        CharSequence charSequence;
        int color = resources.getColor(2131361916);
        int dimensionPixelSize = (resources.getDisplayMetrics().widthPixels - (resources.getDimensionPixelSize(2131431413) * 4)) * i3;
        CharSequence spannableStringBuilder2 = new SpannableStringBuilder(" … ");
        if (!TextUtils.isEmpty(str)) {
            int length = spannableStringBuilder2.length();
            spannableStringBuilder2.append(str);
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(color), length, spannableStringBuilder2.length(), 33);
        }
        TextPaint textPaint = new TextPaint(1);
        textPaint.setColor(i);
        textPaint.setTextSize((float) i2);
        float measureText = textPaint.measureText(spannableStringBuilder, 0, spannableStringBuilder.length());
        float measureText2 = textPaint.measureText(spannableStringBuilder2, 0, spannableStringBuilder2.length());
        if (measureText > ((float) dimensionPixelSize) + measureText2) {
            color = (int) Math.ceil((double) (((measureText2 + (measureText - ((float) dimensionPixelSize))) / measureText) * ((float) spannableStringBuilder.length())));
            charSequence = (Spanned) TextUtils.concat(new CharSequence[]{spannableStringBuilder.subSequence(0, spannableStringBuilder.length() - color), spannableStringBuilder2});
        } else if (z) {
            Spanned spanned = (Spanned) TextUtils.concat(new CharSequence[]{spannableStringBuilder, spannableStringBuilder2});
        } else {
            Object obj = spannableStringBuilder;
        }
        return new SpannableStringBuilder(charSequence);
    }

    public static void m24376a(SpannableStringBuilder spannableStringBuilder, String str, @Nullable CharacterStyle characterStyle) {
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append(str);
        if (characterStyle != null) {
            spannableStringBuilder.setSpan(characterStyle, length, str.length() + length, 33);
        }
    }

    private static void m24377a(SpannableStringBuilder spannableStringBuilder, String str, CharacterStyle characterStyle, CharacterStyle characterStyle2) {
        int length = spannableStringBuilder.length();
        m24376a(spannableStringBuilder, str, characterStyle);
        spannableStringBuilder.setSpan(characterStyle2, length, str.length() + length, 33);
    }

    private static TypefaceSpan m24373a(Context context) {
        return new CustomTypefaceSpan("roboto", CustomFontHelper.a(context, FontFamily.ROBOTO, FontWeight.MEDIUM, null));
    }

    public static SpannableString m24368a(String str, Resources resources, TokenReplacerProps... tokenReplacerPropsArr) {
        StyledStringBuilder a = new StyledStringBuilder(resources).a(str);
        for (TokenReplacerProps tokenReplacerProps : tokenReplacerPropsArr) {
            if (tokenReplacerProps.f20715c == null) {
                a.a(tokenReplacerProps.f20713a, tokenReplacerProps.f20714b);
            } else {
                a.a(tokenReplacerProps.f20713a, tokenReplacerProps.f20714b, tokenReplacerProps.f20715c, 33);
            }
        }
        return a.b();
    }

    @Nullable
    public static Status m24374a(ImmutableList<? extends DefaultTimeRangeFields> immutableList, @Nullable String str, Clock clock) {
        if (immutableList.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return new PageHours(immutableList, TimeZone.getTimeZone(str), clock).m1913a();
    }

    private static void m24375a(int i, SpannableStringBuilder spannableStringBuilder, Resources resources) {
        spannableStringBuilder.append(" ");
        Drawable drawable = resources.getDrawable(2130843449);
        drawable.setBounds(0, 0, i, i);
        m24376a(spannableStringBuilder, " ", new StarSpan(drawable, i));
    }
}
