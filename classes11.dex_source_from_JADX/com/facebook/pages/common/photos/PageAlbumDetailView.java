package com.facebook.pages.common.photos;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.widget.ImageView;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

/* compiled from: sgny_profile */
public class PageAlbumDetailView extends CustomRelativeLayout {
    @Inject
    public GlyphColorizer f1671a;
    @Inject
    public DefaultTimeFormatUtil f1672b;
    public ImageView f1673c;
    public BetterTextView f1674d;
    public BetterTextView f1675e = ((BetterTextView) a(2131565363));

    public static void m2486a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PageAlbumDetailView pageAlbumDetailView = (PageAlbumDetailView) obj;
        GlyphColorizer a = GlyphColorizer.a(fbInjector);
        DefaultTimeFormatUtil a2 = DefaultTimeFormatUtil.a(fbInjector);
        pageAlbumDetailView.f1671a = a;
        pageAlbumDetailView.f1672b = a2;
    }

    public PageAlbumDetailView(Context context) {
        super(context);
        Class cls = PageAlbumDetailView.class;
        m2486a((Object) this, getContext());
        setContentView(2130905965);
        CustomViewUtils.b(this, new ColorDrawable(getResources().getColor(2131361920)));
        BetterTextView betterTextView = (BetterTextView) a(2131565361);
        if (betterTextView.g) {
            m2485a(betterTextView);
            this.f1675e.setGravity(5);
        }
        this.f1673c = (ImageView) a(2131565362);
        this.f1674d = (BetterTextView) a(2131565364);
        this.f1673c.setImageDrawable(this.f1671a.a(2130839779, getResources().getColor(2131363259), true));
    }

    public static String m2484a(int i, Context context) {
        if (i == 0) {
            return context.getResources().getString(2131234347);
        }
        if (i > 0) {
            return context.getResources().getQuantityString(2131689584, i, new Object[]{Integer.valueOf(i)});
        }
        throw new IllegalArgumentException("Invalid album size " + i);
    }

    public static void m2485a(BetterTextView betterTextView) {
        Drawable[] compoundDrawables = betterTextView.getCompoundDrawables();
        if (compoundDrawables[0] == null && compoundDrawables[1] == null && compoundDrawables[2] != null && compoundDrawables[3] == null) {
            Drawable drawable = compoundDrawables[2];
            DrawableCompat.a(drawable, true);
            betterTextView.setCompoundDrawables(drawable, null, null, null);
            return;
        }
        throw new IllegalArgumentException("Album detail title prefix layout mismatch");
    }
}
