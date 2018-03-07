package com.facebook.events.permalink.summary;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.widget.TextView;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.InjectorLike;
import com.facebook.resources.utils.TextViewUtils;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: background_location_notification_nux_inviter_short_name_fetch_fail */
public class EventSummaryRowBuilder {
    private Context f18925a;
    private GlyphColorizer f18926b;
    public final int f18927c = this.f18928d.getDimensionPixelSize(2131431164);
    private final Resources f18928d;

    public static EventSummaryRowBuilder m19164b(InjectorLike injectorLike) {
        return new EventSummaryRowBuilder((Context) injectorLike.getInstance(Context.class), GlyphColorizer.a(injectorLike));
    }

    @Inject
    public EventSummaryRowBuilder(Context context, GlyphColorizer glyphColorizer) {
        this.f18925a = context;
        this.f18926b = glyphColorizer;
        this.f18928d = context.getResources();
    }

    public final void m19165a(TextView textView, int i, boolean z) {
        Drawable a = this.f18926b.a(i, -9801344);
        if (!z) {
            int intrinsicWidth = (this.f18927c - a.getIntrinsicWidth()) / 2;
            textView.setCompoundDrawablePadding(intrinsicWidth);
            TextViewUtils.a(textView, a, null, null, null);
            ViewCompat.b(textView, intrinsicWidth, 0, 0, 0);
        }
    }

    public final void m19166a(TextView textView, @Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, boolean z) {
        Object textAppearanceSpan = new TextAppearanceSpan(this.f18925a, z ? 2131625752 : 2131625750);
        Object textAppearanceSpan2 = new TextAppearanceSpan(this.f18925a, z ? 2131625753 : 2131625751);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!StringUtil.a(charSequence)) {
            m19163a(spannableStringBuilder, charSequence, textAppearanceSpan, 17);
        }
        if (!StringUtil.a(charSequence2)) {
            if (spannableStringBuilder.length() > 0) {
                spannableStringBuilder.append("\n");
            }
            m19163a(spannableStringBuilder, charSequence2, textAppearanceSpan2, 17);
        }
        textView.setText(spannableStringBuilder);
    }

    private static SpannableStringBuilder m19163a(SpannableStringBuilder spannableStringBuilder, CharSequence charSequence, Object obj, int i) {
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append(charSequence);
        spannableStringBuilder.setSpan(obj, length, spannableStringBuilder.length(), i);
        return spannableStringBuilder;
    }
}
