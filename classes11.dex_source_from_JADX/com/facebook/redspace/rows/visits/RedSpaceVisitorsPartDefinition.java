package com.facebook.redspace.rows.visits;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.FacepilePartDefinition;
import com.facebook.multirow.parts.FacepilePartDefinition.Props;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.redspace.abtest.ExperimentsForRedSpaceExperimentsModule;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceVisitFragmentModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceVisitsQueryModel.RedspaceModel.VisitsModel;
import com.facebook.redspace.rows.RedSpaceEnvironment;
import com.facebook.ultralight.Inject;
import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

@ContextScoped
/* compiled from: PROFILE_FIELD_SECTION_HEADER */
public class RedSpaceVisitorsPartDefinition extends MultiRowSinglePartDefinition<Object, Void, RedSpaceEnvironment, ContentView> {
    public static final ViewType<ContentView> f12277a = ViewType.a(2130906762);
    private static final Function<RedSpaceVisitFragmentModel, Uri> f12278b = new C14501();
    private static final PaddingStyle f12279c = Builder.b().a(0).b(1).i();
    private static RedSpaceVisitorsPartDefinition f12280g;
    private static final Object f12281h = new Object();
    private final QeAccessor f12282d;
    private final FacepilePartDefinition f12283e;
    private final BackgroundPartDefinition f12284f;

    /* compiled from: PROFILE_FIELD_SECTION_HEADER */
    final class C14501 implements Function<RedSpaceVisitFragmentModel, Uri> {
        C14501() {
        }

        @Nullable
        public final Object apply(@Nullable Object obj) {
            RedSpaceVisitFragmentModel redSpaceVisitFragmentModel = (RedSpaceVisitFragmentModel) obj;
            if (redSpaceVisitFragmentModel == null || redSpaceVisitFragmentModel.j() == null || redSpaceVisitFragmentModel.j().j() == null) {
                return null;
            }
            return Uri.parse(redSpaceVisitFragmentModel.j().j().b());
        }
    }

    private static RedSpaceVisitorsPartDefinition m12721b(InjectorLike injectorLike) {
        return new RedSpaceVisitorsPartDefinition((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), FacepilePartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m12723a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        VisitsModel visitsModel = (VisitsModel) obj;
        ImmutableList copyOf = ImmutableList.copyOf(Collections2.a(visitsModel.k(), f12278b));
        FacepilePartDefinition facepilePartDefinition = this.f12283e;
        int j = visitsModel.j();
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.b = true;
        subParts.a(2131566853, facepilePartDefinition, new Props(copyOf, null, j, roundingParams));
        subParts.a(this.f12284f, new StylingData(f12279c));
        return null;
    }

    public static RedSpaceVisitorsPartDefinition m12720a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RedSpaceVisitorsPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12281h) {
                RedSpaceVisitorsPartDefinition redSpaceVisitorsPartDefinition;
                if (a2 != null) {
                    redSpaceVisitorsPartDefinition = (RedSpaceVisitorsPartDefinition) a2.a(f12281h);
                } else {
                    redSpaceVisitorsPartDefinition = f12280g;
                }
                if (redSpaceVisitorsPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12721b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12281h, b3);
                        } else {
                            f12280g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = redSpaceVisitorsPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    private RedSpaceVisitorsPartDefinition(QeAccessor qeAccessor, FacepilePartDefinition facepilePartDefinition, BackgroundPartDefinition backgroundPartDefinition) {
        this.f12282d = qeAccessor;
        this.f12283e = facepilePartDefinition;
        this.f12284f = backgroundPartDefinition;
    }

    public final ViewType<ContentView> m12722a() {
        return f12277a;
    }

    public final boolean m12724a(Object obj) {
        return (obj instanceof VisitsModel) && ((VisitsModel) obj).j() > 0 && this.f12282d.a(ExperimentsForRedSpaceExperimentsModule.l, false);
    }
}
