package com.facebook.appdiscovery.lite.ui.rows.sections.relatedapps;

import android.content.Context;
import com.facebook.appdiscovery.lite.model.unit.LiteRelatedAppsFeedUnit;
import com.facebook.appdiscovery.lite.protocol.FetchLiteResultsGraphQLInterfaces.AppStoryQueryFragment;
import com.facebook.appdiscovery.lite.ui.rows.sections.hscroll.HScrollPartDefinition;
import com.facebook.appdiscovery.lite.ui.rows.sections.seemore.HeaderSeeMorePartDefinition;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: selected_mode */
public class RelatedAppsGroupPartDefinition<E extends HasPersistentState & HasPositionInformation> extends BaseMultiRowGroupPartDefinition<FeedProps<LiteRelatedAppsFeedUnit>, Void, E> {
    private static RelatedAppsGroupPartDefinition f4178e;
    private static final Object f4179f = new Object();
    private final HeaderSeeMorePartDefinition f4180a;
    private final HScrollPartDefinition<AppStoryQueryFragment, E> f4181b;
    public final RelatedAppPageItemPartDefinition f4182c;
    public final Context f4183d;

    private static RelatedAppsGroupPartDefinition m4233b(InjectorLike injectorLike) {
        return new RelatedAppsGroupPartDefinition(HeaderSeeMorePartDefinition.a(injectorLike), HScrollPartDefinition.m4225a(injectorLike), RelatedAppPageItemPartDefinition.a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    public final Object m4234a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        final LiteRelatedAppsFeedUnit liteRelatedAppsFeedUnit = (LiteRelatedAppsFeedUnit) ((FeedProps) obj).a;
        baseMultiRowSubParts.a(this.f4180a, liteRelatedAppsFeedUnit);
        baseMultiRowSubParts.a(this.f4181b, new Object(this) {
            public final /* synthetic */ RelatedAppsGroupPartDefinition f4177b;

            public final ImmutableList<AppStoryQueryFragment> m4231a() {
                return liteRelatedAppsFeedUnit.a;
            }
        });
        return null;
    }

    public final boolean m4235a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        return ((LiteRelatedAppsFeedUnit) feedProps.a).a != null && ((LiteRelatedAppsFeedUnit) feedProps.a).a.size() > 0;
    }

    @Inject
    public RelatedAppsGroupPartDefinition(HeaderSeeMorePartDefinition headerSeeMorePartDefinition, HScrollPartDefinition hScrollPartDefinition, RelatedAppPageItemPartDefinition relatedAppPageItemPartDefinition, Context context) {
        this.f4180a = headerSeeMorePartDefinition;
        this.f4181b = hScrollPartDefinition;
        this.f4182c = relatedAppPageItemPartDefinition;
        this.f4183d = context;
    }

    public static RelatedAppsGroupPartDefinition m4232a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RelatedAppsGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4179f) {
                RelatedAppsGroupPartDefinition relatedAppsGroupPartDefinition;
                if (a2 != null) {
                    relatedAppsGroupPartDefinition = (RelatedAppsGroupPartDefinition) a2.a(f4179f);
                } else {
                    relatedAppsGroupPartDefinition = f4178e;
                }
                if (relatedAppsGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m4233b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4179f, b3);
                        } else {
                            f4178e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = relatedAppsGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
