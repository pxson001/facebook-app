package com.facebook.search.results.rows.sections.sports;

import android.content.Context;
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
import com.facebook.search.results.environment.SearchResultsFeedEnvironment;
import com.facebook.search.results.model.unit.SearchResultsSportsUnit;
import javax.inject.Inject;

@ContextScoped
/* compiled from: POST_COMPOSE_TOOLTIP_SEEN */
public class SportsGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<SearchResultsSportsUnit>, Void, SearchResultsFeedEnvironment> {
    private static SportsGroupPartDefinition f25048c;
    private static final Object f25049d = new Object();
    private final SportsPhotoPartDefinition f25050a;
    private final SportsDetailPartDefinition f25051b;

    private static SportsGroupPartDefinition m28373b(InjectorLike injectorLike) {
        return new SportsGroupPartDefinition(SportsPhotoPartDefinition.m28379a(injectorLike), SportsDetailPartDefinition.m28362a(injectorLike));
    }

    public final Object m28374a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f25050a, (SearchResultsSportsUnit) feedProps.a);
        baseMultiRowSubParts.a(this.f25051b, feedProps);
        return null;
    }

    @Inject
    public SportsGroupPartDefinition(SportsPhotoPartDefinition sportsPhotoPartDefinition, SportsDetailPartDefinition sportsDetailPartDefinition) {
        this.f25050a = sportsPhotoPartDefinition;
        this.f25051b = sportsDetailPartDefinition;
    }

    public final boolean m28375a(Object obj) {
        return true;
    }

    public static SportsGroupPartDefinition m28372a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SportsGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25049d) {
                SportsGroupPartDefinition sportsGroupPartDefinition;
                if (a2 != null) {
                    sportsGroupPartDefinition = (SportsGroupPartDefinition) a2.a(f25049d);
                } else {
                    sportsGroupPartDefinition = f25048c;
                }
                if (sportsGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28373b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25049d, b3);
                        } else {
                            f25048c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = sportsGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
