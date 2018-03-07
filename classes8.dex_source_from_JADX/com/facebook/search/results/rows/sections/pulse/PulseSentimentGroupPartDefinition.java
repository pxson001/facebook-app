package com.facebook.search.results.rows.sections.pulse;

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
import com.facebook.search.results.model.unit.SearchResultsPulseSentimentUnit;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PRE_SELECT_MEMBERS */
public class PulseSentimentGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<SearchResultsPulseSentimentUnit>, Void, SearchResultsFeedEnvironment> {
    private static PulseSentimentGroupPartDefinition f24917c;
    private static final Object f24918d = new Object();
    private final PulseSentimentEmotionalHScrollPartDefinition f24919a;
    private final PulseSentimentEmotionalVerticalPartDefinition f24920b;

    private static PulseSentimentGroupPartDefinition m28279b(InjectorLike injectorLike) {
        return new PulseSentimentGroupPartDefinition(PulseSentimentEmotionalHScrollPartDefinition.m28253a(injectorLike), PulseSentimentEmotionalVerticalPartDefinition.m28274a(injectorLike));
    }

    public final Object m28280a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        if (PulseSentimentEmotionalHScrollPartDefinition.m28254a(feedProps)) {
            baseMultiRowSubParts.a(this.f24919a, feedProps);
        } else {
            baseMultiRowSubParts.a(this.f24920b, feedProps.a);
        }
        return null;
    }

    @Inject
    public PulseSentimentGroupPartDefinition(PulseSentimentEmotionalHScrollPartDefinition pulseSentimentEmotionalHScrollPartDefinition, PulseSentimentEmotionalVerticalPartDefinition pulseSentimentEmotionalVerticalPartDefinition) {
        this.f24919a = pulseSentimentEmotionalHScrollPartDefinition;
        this.f24920b = pulseSentimentEmotionalVerticalPartDefinition;
    }

    public final boolean m28281a(Object obj) {
        return true;
    }

    public static PulseSentimentGroupPartDefinition m28278a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PulseSentimentGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24918d) {
                PulseSentimentGroupPartDefinition pulseSentimentGroupPartDefinition;
                if (a2 != null) {
                    pulseSentimentGroupPartDefinition = (PulseSentimentGroupPartDefinition) a2.a(f24918d);
                } else {
                    pulseSentimentGroupPartDefinition = f24917c;
                }
                if (pulseSentimentGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28279b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24918d, b3);
                        } else {
                            f24917c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pulseSentimentGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
