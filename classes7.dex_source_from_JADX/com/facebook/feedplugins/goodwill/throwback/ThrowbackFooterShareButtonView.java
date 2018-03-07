package com.facebook.feedplugins.goodwill.throwback;

import android.content.Context;
import android.view.View;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.inject.FbInjector;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

/* compiled from: StickerToPostOptimisticComment */
public class ThrowbackFooterShareButtonView extends CustomLinearLayout {
    public static final ViewType f23141a = new C20031();
    @Inject
    public GlyphColorizer f23142b;
    public View f23143c = a(2131567898);
    public ImageWithTextView f23144d = ((ImageWithTextView) a(2131567897));

    /* compiled from: StickerToPostOptimisticComment */
    final class C20031 extends ViewType {
        C20031() {
        }

        public final View m25568a(Context context) {
            return new ThrowbackFooterShareButtonView(context);
        }
    }

    public static void m25569a(Object obj, Context context) {
        ((ThrowbackFooterShareButtonView) obj).f23142b = GlyphColorizer.a(FbInjector.get(context));
    }

    public ThrowbackFooterShareButtonView(Context context) {
        super(context);
        Class cls = ThrowbackFooterShareButtonView.class;
        m25569a(this, getContext());
        setContentView(2130907422);
        setOrientation(1);
        this.f23144d.setImageDrawable(this.f23142b.a(2130843792, -7235677));
    }
}
