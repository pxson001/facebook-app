package com.facebook.feed.util.composer.sprout;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.Paint.Style;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: TRIPLE_ITEMS_FIRST_PORTRAIT */
public class SproutListItemBinder {
    private final Resources f22450a;
    private final GlyphColorizer f22451b;

    public static SproutListItemBinder m25054b(InjectorLike injectorLike) {
        return new SproutListItemBinder(ResourcesMethodAutoProvider.a(injectorLike), GlyphColorizer.a(injectorLike));
    }

    @Inject
    public SproutListItemBinder(Resources resources, GlyphColorizer glyphColorizer) {
        this.f22450a = resources;
        this.f22451b = glyphColorizer;
    }

    public final void m25055a(SproutIconDrawable sproutIconDrawable, SproutSpec sproutSpec) {
        Style style;
        ColorFilter a;
        sproutIconDrawable.f22432c.setColor(this.f22450a.getColor(sproutSpec.f22463a));
        sproutIconDrawable.invalidateSelf();
        sproutIconDrawable.m25031b(sproutSpec.f22464b);
        if (sproutSpec.f22469g == SproutSpec.Style.FILL) {
            style = Style.FILL;
        } else {
            style = Style.STROKE;
        }
        sproutIconDrawable.f22432c.setStyle(style);
        sproutIconDrawable.invalidateSelf();
        if (sproutSpec.f22470h != null) {
            a = this.f22451b.a(this.f22450a.getColor(sproutSpec.f22470h.intValue()));
        } else {
            a = null;
        }
        sproutIconDrawable.f22434e = a;
        if (sproutIconDrawable.f22435f != null) {
            sproutIconDrawable.f22435f.setColorFilter(a);
        }
        sproutIconDrawable.invalidateSelf();
    }

    public static SproutListItemBinder m25053a(InjectorLike injectorLike) {
        return m25054b(injectorLike);
    }

    public final void m25056a(SproutSpec sproutSpec, SproutListItem sproutListItem) {
        sproutListItem.setTitle(sproutSpec.f22465c);
        sproutListItem.setSubtitle(sproutSpec.f22466d);
        sproutListItem.setNuxProvider(sproutSpec.f22472j);
        m25055a(sproutListItem.f22444l, sproutSpec);
    }
}
