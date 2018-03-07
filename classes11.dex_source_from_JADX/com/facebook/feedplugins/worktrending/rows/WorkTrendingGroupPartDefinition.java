package com.facebook.feedplugins.worktrending.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLWorkCommunityTrendingFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: android.bluetooth.adapter.action.DISCOVERY_STARTED */
public class WorkTrendingGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLWorkCommunityTrendingFeedUnit>, Void, FeedEnvironment> {
    private static WorkTrendingGroupPartDefinition f10013d;
    private static final Object f10014e = new Object();
    private final WorkTrendingHeaderPartDefinition f10015a;
    private final WorkTrendingHScrollViewPartDefinition f10016b;
    private final WorkTrendingExpandableListPartDefinition f10017c;

    private static WorkTrendingGroupPartDefinition m10366b(InjectorLike injectorLike) {
        return new WorkTrendingGroupPartDefinition(WorkTrendingHeaderPartDefinition.m10376a(injectorLike), WorkTrendingHScrollViewPartDefinition.m10371a(injectorLike), WorkTrendingExpandableListPartDefinition.m10354a(injectorLike));
    }

    public final Object m10367a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f10015a, feedProps);
        baseMultiRowSubParts.a(this.f10017c, feedProps);
        return null;
    }

    @Inject
    public WorkTrendingGroupPartDefinition(WorkTrendingHeaderPartDefinition workTrendingHeaderPartDefinition, WorkTrendingHScrollViewPartDefinition workTrendingHScrollViewPartDefinition, WorkTrendingExpandableListPartDefinition workTrendingExpandableListPartDefinition) {
        this.f10015a = workTrendingHeaderPartDefinition;
        this.f10016b = workTrendingHScrollViewPartDefinition;
        this.f10017c = workTrendingExpandableListPartDefinition;
    }

    public final boolean m10368a(Object obj) {
        return true;
    }

    public static WorkTrendingGroupPartDefinition m10365a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            WorkTrendingGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10014e) {
                WorkTrendingGroupPartDefinition workTrendingGroupPartDefinition;
                if (a2 != null) {
                    workTrendingGroupPartDefinition = (WorkTrendingGroupPartDefinition) a2.a(f10014e);
                } else {
                    workTrendingGroupPartDefinition = f10013d;
                }
                if (workTrendingGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10366b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10014e, b3);
                        } else {
                            f10013d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = workTrendingGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
