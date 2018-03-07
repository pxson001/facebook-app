package com.facebook.feedplugins.goodwill;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.privacy.ui.DefaultPrivacyScopeResourceResolver;
import javax.inject.Inject;

@LayoutSpec
@ContextScoped
/* compiled from: goodwillVideosPost */
public class ThrowbackPrivacyLabelComponentSpec {
    private static ThrowbackPrivacyLabelComponentSpec f12479c;
    private static final Object f12480d = new Object();
    public final DefaultPrivacyScopeResourceResolver f12481a;
    public final GlyphColorizer f12482b;

    private static ThrowbackPrivacyLabelComponentSpec m14369b(InjectorLike injectorLike) {
        return new ThrowbackPrivacyLabelComponentSpec(DefaultPrivacyScopeResourceResolver.a(injectorLike), GlyphColorizer.a(injectorLike));
    }

    @Inject
    public ThrowbackPrivacyLabelComponentSpec(DefaultPrivacyScopeResourceResolver defaultPrivacyScopeResourceResolver, GlyphColorizer glyphColorizer) {
        this.f12481a = defaultPrivacyScopeResourceResolver;
        this.f12482b = glyphColorizer;
    }

    public static ThrowbackPrivacyLabelComponentSpec m14368a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackPrivacyLabelComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12480d) {
                ThrowbackPrivacyLabelComponentSpec throwbackPrivacyLabelComponentSpec;
                if (a2 != null) {
                    throwbackPrivacyLabelComponentSpec = (ThrowbackPrivacyLabelComponentSpec) a2.a(f12480d);
                } else {
                    throwbackPrivacyLabelComponentSpec = f12479c;
                }
                if (throwbackPrivacyLabelComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14369b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12480d, b3);
                        } else {
                            f12479c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackPrivacyLabelComponentSpec;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
