package com.facebook.feed.ufi;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.feed.ufi.UFIFooterButtonStyleDefinition.FooterLayoutType;
import com.facebook.feed.widget.DownstateType;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: Trying to resolve view with tag  */
public class FullscreenVideoFeedbackActionButtonBarHelper {
    private static final DownstateType[] f21728a = new DownstateType[]{DownstateType.NEWSFEED_SHADOW, DownstateType.SUBSTORY_SHADOW};
    private final GlyphColorizer f21729b;
    private final Drawable f21730c;
    private final Drawable f21731d = m24310b(2130843790);
    private final Drawable f21732e = m24310b(2130843788);
    private final Drawable f21733f = m24310b(2130843792);
    private final int f21734g;
    private final int f21735h;

    /* compiled from: Trying to resolve view with tag  */
    public enum FeedbackActionButton {
        LIKE,
        COMMENT,
        SHARE
    }

    private static FullscreenVideoFeedbackActionButtonBarHelper m24311b(InjectorLike injectorLike) {
        return new FullscreenVideoFeedbackActionButtonBarHelper((Context) injectorLike.getInstance(Context.class), GlyphColorizer.a(injectorLike));
    }

    @Inject
    public FullscreenVideoFeedbackActionButtonBarHelper(Context context, GlyphColorizer glyphColorizer) {
        this.f21729b = glyphColorizer;
        Resources resources = context.getResources();
        this.f21734g = resources.getColor(2131361917);
        this.f21735h = resources.getColor(2131361937);
        this.f21730c = resources.getDrawable(2130843791);
    }

    public static FullscreenVideoFeedbackActionButtonBarHelper m24307a(InjectorLike injectorLike) {
        return m24311b(injectorLike);
    }

    public final int m24312a(boolean z) {
        return z ? this.f21734g : this.f21735h;
    }

    public final Drawable m24314b(boolean z) {
        return z ? this.f21730c : this.f21731d;
    }

    public static FooterLayoutType m24308a() {
        return FooterLayoutType.INLINE;
    }

    public static int m24306a(FeedbackActionButton feedbackActionButton) {
        switch (feedbackActionButton) {
            case LIKE:
                return 2131233267;
            case COMMENT:
                return 2131233269;
            case SHARE:
                return 2131233280;
            default:
                throw new IllegalArgumentException("Unknown FeedbackActionButton");
        }
    }

    public final Drawable m24313b(FeedbackActionButton feedbackActionButton) {
        switch (feedbackActionButton) {
            case LIKE:
                return this.f21731d;
            case COMMENT:
                return this.f21732e;
            case SHARE:
                return this.f21733f;
            default:
                throw new IllegalArgumentException("Unknown FeedbackActionButton");
        }
    }

    public static DownstateType m24309a(int i) {
        return f21728a[i];
    }

    private Drawable m24310b(int i) {
        return this.f21729b.a(i, -7235677);
    }
}
