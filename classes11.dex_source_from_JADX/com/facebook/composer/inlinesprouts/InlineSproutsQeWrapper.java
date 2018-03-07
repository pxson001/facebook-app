package com.facebook.composer.inlinesprouts;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.feed.util.composer.abtest.ExperimentsForFeedUtilComposerAbtestModule;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.RegularImmutableSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fundraiser_page_tapped_donate */
public class InlineSproutsQeWrapper {
    private static final ImmutableSet<TargetType> f6595a = RegularImmutableSet.a;
    public static final ImmutableList<String> f6596b = ImmutableList.of("composer_media_inline_sprout", "composer_facecast_inline_sprout", "composer_place_tagging_inline_sprout", "location_lightweight_picker_sprout", "composer_activity_tagging_inline_sprout", "composer_user_tagging_inline_sprout");
    private static InlineSproutsQeWrapper f6597g;
    private static final Object f6598h = new Object();
    public final Resources f6599c;
    public final QeAccessor f6600d;
    private ImmutableSet<TargetType> f6601e = RegularImmutableSet.a;
    public boolean f6602f;

    private static InlineSproutsQeWrapper m8045b(InjectorLike injectorLike) {
        return new InlineSproutsQeWrapper(ResourcesMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public InlineSproutsQeWrapper(Resources resources, QeAccessor qeAccessor, Boolean bool) {
        this.f6599c = resources;
        this.f6600d = qeAccessor;
        this.f6602f = bool.booleanValue();
    }

    public static InlineSproutsQeWrapper m8044a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InlineSproutsQeWrapper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6598h) {
                InlineSproutsQeWrapper inlineSproutsQeWrapper;
                if (a2 != null) {
                    inlineSproutsQeWrapper = (InlineSproutsQeWrapper) a2.a(f6598h);
                } else {
                    inlineSproutsQeWrapper = f6597g;
                }
                if (inlineSproutsQeWrapper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8045b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6598h, b3);
                        } else {
                            f6597g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = inlineSproutsQeWrapper;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m8046q() {
        return this.f6600d.a(ExperimentsForFeedUtilComposerAbtestModule.A, false);
    }

    public final ImmutableSet<TargetType> m8047u() {
        if (!this.f6601e.isEmpty()) {
            return this.f6601e;
        }
        String a = this.f6600d.a(ExperimentsForFeedUtilComposerAbtestModule.D, null);
        if (Strings.isNullOrEmpty(a)) {
            this.f6601e = f6595a;
        } else {
            Builder builder = ImmutableSet.builder();
            String[] split = a.split(",");
            for (String trim : split) {
                try {
                    builder.c(TargetType.fromString(trim.trim()));
                } catch (Exception e) {
                }
            }
            this.f6601e = builder.b();
        }
        return this.f6601e;
    }
}
