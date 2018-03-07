package com.facebook.messaging.composershortcuts;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.base.Objects;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: messenger_bots_you_may_message */
public class ComposerButtonColorUtil {
    public static final int f9962a = Color.argb(77, 0, 0, 0);
    public static final int f9963b = Color.argb(97, 0, 0, 0);
    public static final int f9964c = Color.argb(255, 0, 132, 255);
    public static final int f9965d = Color.argb(255, 0, 132, 255);
    public static final int f9966e = Color.argb(51, 0, 0, 0);
    private static ComposerButtonColorUtil f9967i;
    private static final Object f9968j = new Object();
    private final GlyphColorizer f9969f;
    private final Provider<Boolean> f9970g;
    private final Resources f9971h;

    private static ComposerButtonColorUtil m10510b(InjectorLike injectorLike) {
        return new ComposerButtonColorUtil(GlyphColorizer.a(injectorLike), IdBasedProvider.a(injectorLike, 4073), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ComposerButtonColorUtil(GlyphColorizer glyphColorizer, Provider<Boolean> provider, Resources resources) {
        this.f9969f = glyphColorizer;
        this.f9970g = provider;
        this.f9971h = resources;
    }

    public static ComposerButtonColorUtil m10509a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ComposerButtonColorUtil b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9968j) {
                ComposerButtonColorUtil composerButtonColorUtil;
                if (a2 != null) {
                    composerButtonColorUtil = (ComposerButtonColorUtil) a2.a(f9968j);
                } else {
                    composerButtonColorUtil = f9967i;
                }
                if (composerButtonColorUtil == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10510b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9968j, b3);
                        } else {
                            f9967i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = composerButtonColorUtil;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final Drawable m10515a(ComposerShortcutItem composerShortcutItem) {
        if (!composerShortcutItem.f9981j) {
            return null;
        }
        if (composerShortcutItem.f9977f != null) {
            return composerShortcutItem.f9977f;
        }
        return this.f9971h.getDrawable(composerShortcutItem.f9975d);
    }

    public final ColorFilter m10514a(@Nullable String str) {
        int color;
        if (Objects.equal(str, "send") || Objects.equal(str, "like")) {
            color = this.f9971h.getColor(2131362241);
        } else {
            color = m10511c();
        }
        return this.f9969f.a(color);
    }

    public final ColorFilter m10513a() {
        return this.f9969f.a(m10512d());
    }

    private int m10511c() {
        return ((Boolean) this.f9970g.get()).booleanValue() ? f9963b : f9962a;
    }

    private int m10512d() {
        return ((Boolean) this.f9970g.get()).booleanValue() ? f9965d : f9964c;
    }

    public final ColorFilter m10516b() {
        return this.f9969f.a(f9966e);
    }
}
