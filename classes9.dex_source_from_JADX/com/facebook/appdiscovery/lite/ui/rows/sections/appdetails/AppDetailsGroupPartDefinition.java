package com.facebook.appdiscovery.lite.ui.rows.sections.appdetails;

import android.content.Context;
import com.facebook.appdiscovery.lite.model.unit.AppDetailsFeedUnit;
import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLModels$SocialContextSentenceFragmentModel.RangesModel;
import com.facebook.appdiscovery.lite.ui.rows.sections.actor.ActorHeaderPartDefinition;
import com.facebook.appdiscovery.lite.ui.rows.sections.actor.MessagePartDefinition;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: selected_tab */
public class AppDetailsGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<AppDetailsFeedUnit>, Void, AnyEnvironment> {
    private static AppDetailsGroupPartDefinition f4156h;
    private static final Object f4157i = new Object();
    private final ActorHeaderPartDefinition f4158a;
    private final MessagePartDefinition f4159b;
    private final CoverImagePartDefinition f4160c;
    private final AppInfoPartDefinition f4161d;
    private final UserFacepilePartDefinition f4162e;
    private final SocialContextPartDefinition f4163f;
    private final CallToActionPartDefinition f4164g;

    private static AppDetailsGroupPartDefinition m4212b(InjectorLike injectorLike) {
        return new AppDetailsGroupPartDefinition(ActorHeaderPartDefinition.a(injectorLike), MessagePartDefinition.a(injectorLike), CoverImagePartDefinition.a(injectorLike), AppInfoPartDefinition.a(injectorLike), UserFacepilePartDefinition.a(injectorLike), SocialContextPartDefinition.a(injectorLike), CallToActionPartDefinition.a(injectorLike));
    }

    public final Object m4213a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        AppDetailsFeedUnit appDetailsFeedUnit = (AppDetailsFeedUnit) ((FeedProps) obj).a;
        baseMultiRowSubParts.a(this.f4158a, appDetailsFeedUnit);
        baseMultiRowSubParts.a(this.f4159b, appDetailsFeedUnit.e);
        baseMultiRowSubParts.a(this.f4160c, appDetailsFeedUnit);
        baseMultiRowSubParts.a(this.f4161d, appDetailsFeedUnit);
        UserFacepilePartDefinition userFacepilePartDefinition = this.f4162e;
        Builder builder = ImmutableList.builder();
        if (!(appDetailsFeedUnit.c == null || appDetailsFeedUnit.c.g() == null || appDetailsFeedUnit.c.g().m3983a() == null)) {
            ImmutableList a = appDetailsFeedUnit.c.g().m3983a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                RangesModel rangesModel = (RangesModel) a.get(i);
                if (rangesModel.m3977a() != null) {
                    builder.c(rangesModel.m3977a());
                }
            }
        }
        baseMultiRowSubParts.a(userFacepilePartDefinition, builder.b());
        baseMultiRowSubParts.a(this.f4163f, appDetailsFeedUnit);
        baseMultiRowSubParts.a(this.f4164g, appDetailsFeedUnit);
        return null;
    }

    public final boolean m4214a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        return (((AppDetailsFeedUnit) feedProps.a).f() == null || ((AppDetailsFeedUnit) feedProps.a).k() == null) ? false : true;
    }

    @Inject
    public AppDetailsGroupPartDefinition(ActorHeaderPartDefinition actorHeaderPartDefinition, MessagePartDefinition messagePartDefinition, CoverImagePartDefinition coverImagePartDefinition, AppInfoPartDefinition appInfoPartDefinition, UserFacepilePartDefinition userFacepilePartDefinition, SocialContextPartDefinition socialContextPartDefinition, CallToActionPartDefinition callToActionPartDefinition) {
        this.f4158a = actorHeaderPartDefinition;
        this.f4159b = messagePartDefinition;
        this.f4160c = coverImagePartDefinition;
        this.f4161d = appInfoPartDefinition;
        this.f4162e = userFacepilePartDefinition;
        this.f4163f = socialContextPartDefinition;
        this.f4164g = callToActionPartDefinition;
    }

    public static AppDetailsGroupPartDefinition m4211a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AppDetailsGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4157i) {
                AppDetailsGroupPartDefinition appDetailsGroupPartDefinition;
                if (a2 != null) {
                    appDetailsGroupPartDefinition = (AppDetailsGroupPartDefinition) a2.a(f4157i);
                } else {
                    appDetailsGroupPartDefinition = f4156h;
                }
                if (appDetailsGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m4212b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4157i, b3);
                        } else {
                            f4156h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = appDetailsGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
