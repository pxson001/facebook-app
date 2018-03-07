package com.facebook.feed.inlinecomposer.multirow;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.composer.ui.drawables.GlyphpileDrawable;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.feed.util.composer.abtest.InlineComposerExperiment$ComposerGlyphType;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.widget.FbImageView;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: mr_IN */
public class InlineComposerGlyphsPartDefinition extends BaseSinglePartDefinition<InlineComposerExperiment$ComposerGlyphType, Drawable, AnyEnvironment, FbImageView> {
    private static InlineComposerGlyphsPartDefinition f13235d;
    private static final Object f13236e = new Object();
    public final Resources f13237a;
    public final GlyphColorizer f13238b;
    private final AbstractFbErrorReporter f13239c;

    private static InlineComposerGlyphsPartDefinition m19491b(InjectorLike injectorLike) {
        return new InlineComposerGlyphsPartDefinition(ResourcesMethodAutoProvider.m6510a(injectorLike), GlyphColorizer.m11486a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        InlineComposerExperiment$ComposerGlyphType inlineComposerExperiment$ComposerGlyphType = (InlineComposerExperiment$ComposerGlyphType) obj;
        if (inlineComposerExperiment$ComposerGlyphType == null || inlineComposerExperiment$ComposerGlyphType == InlineComposerExperiment$ComposerGlyphType.NONE) {
            this.f13239c.m2350b("inline_composer_glyphs_incorrect_type", "Called with incorrect glyph type: " + inlineComposerExperiment$ComposerGlyphType);
            return null;
        }
        switch (1.a[inlineComposerExperiment$ComposerGlyphType.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return m19490b();
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return m19492c();
            default:
                GlyphpileDrawable glyphpileDrawable = new GlyphpileDrawable(ImmutableList.of(this.f13237a.getDrawable(2130838228), this.f13237a.getDrawable(2130838227), this.f13237a.getDrawable(2130838229)), 0);
                glyphpileDrawable.setColorFilter(this.f13238b.m11488a(this.f13237a.getColor(2131361936)));
                return glyphpileDrawable;
        }
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 970009190);
        Drawable drawable = (Drawable) obj2;
        FbImageView fbImageView = (FbImageView) view;
        if (drawable == null) {
            fbImageView.setVisibility(8);
        } else {
            fbImageView.setVisibility(0);
            fbImageView.setImageDrawable(drawable);
        }
        Logger.a(8, EntryType.MARK_POP, 1502179634, a);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((FbImageView) view).setVisibility(8);
    }

    @Inject
    public InlineComposerGlyphsPartDefinition(Resources resources, GlyphColorizer glyphColorizer, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f13237a = resources;
        this.f13238b = glyphColorizer;
        this.f13239c = abstractFbErrorReporter;
    }

    public static InlineComposerGlyphsPartDefinition m19489a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InlineComposerGlyphsPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f13236e) {
                InlineComposerGlyphsPartDefinition inlineComposerGlyphsPartDefinition;
                if (a2 != null) {
                    inlineComposerGlyphsPartDefinition = (InlineComposerGlyphsPartDefinition) a2.mo818a(f13236e);
                } else {
                    inlineComposerGlyphsPartDefinition = f13235d;
                }
                if (inlineComposerGlyphsPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m19491b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f13236e, b3);
                        } else {
                            f13235d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = inlineComposerGlyphsPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    private Drawable m19490b() {
        return new GlyphpileDrawable(ImmutableList.of(this.f13238b.m11489a(2130838228, this.f13237a.getColor(2131362971)), this.f13238b.m11489a(2130838227, this.f13237a.getColor(2131362972)), this.f13238b.m11489a(2130838229, this.f13237a.getColor(2131362974))), 0);
    }

    private Drawable m19492c() {
        return new GlyphpileDrawable(ImmutableList.of(this.f13237a.getDrawable(2130838224), this.f13237a.getDrawable(2130838222), this.f13237a.getDrawable(2130838238)), this.f13237a.getDimensionPixelSize(2131430475));
    }
}
