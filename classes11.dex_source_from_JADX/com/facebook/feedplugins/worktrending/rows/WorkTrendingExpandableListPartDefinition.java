package com.facebook.feedplugins.worktrending.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.worktrending.rows.WorkTrendingRowPartDefinition.Props;
import com.facebook.graphql.model.GraphQLWorkCommunityTrendingFeedUnit;
import com.facebook.graphql.model.GraphQLWorkCommunityTrendingFeedUnitItem;
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
/* compiled from: android.hardware.bluetooth */
public class WorkTrendingExpandableListPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<? extends GraphQLWorkCommunityTrendingFeedUnit>, WorkTrendingExpandableListPersistentKey, FeedEnvironment> {
    private static WorkTrendingExpandableListPartDefinition f9997d;
    private static final Object f9998e = new Object();
    private final WorkTrendingRowPartDefinition f9999a;
    private final WorkTrendingFooterPartDefinition f10000b;
    public boolean f10001c = false;

    /* compiled from: android.hardware.bluetooth */
    public class WorkTrendingExpandableListPersistentKey implements ContextStateKey<String, Boolean> {
        GraphQLWorkCommunityTrendingFeedUnit f9996a;

        public WorkTrendingExpandableListPersistentKey(GraphQLWorkCommunityTrendingFeedUnit graphQLWorkCommunityTrendingFeedUnit) {
            this.f9996a = graphQLWorkCommunityTrendingFeedUnit;
        }

        public final Object m10352a() {
            return Boolean.valueOf(false);
        }

        public final Object m10353b() {
            return this.f9996a.k();
        }
    }

    private static WorkTrendingExpandableListPartDefinition m10355b(InjectorLike injectorLike) {
        return new WorkTrendingExpandableListPartDefinition(WorkTrendingRowPartDefinition.m10389a(injectorLike), WorkTrendingFooterPartDefinition.m10359a(injectorLike));
    }

    public final Object m10356a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        int i;
        final FeedProps feedProps = (FeedProps) obj;
        final FeedEnvironment feedEnvironment = (FeedEnvironment) anyEnvironment;
        final GraphQLWorkCommunityTrendingFeedUnit graphQLWorkCommunityTrendingFeedUnit = (GraphQLWorkCommunityTrendingFeedUnit) feedProps.a;
        ImmutableList o = graphQLWorkCommunityTrendingFeedUnit.o();
        WorkTrendingExpandableListPersistentKey workTrendingExpandableListPersistentKey = new WorkTrendingExpandableListPersistentKey(graphQLWorkCommunityTrendingFeedUnit);
        if (((Boolean) feedEnvironment.a(workTrendingExpandableListPersistentKey, graphQLWorkCommunityTrendingFeedUnit)).booleanValue()) {
            i = 5;
        } else {
            i = 3;
        }
        int size = o.size() > i ? i : o.size();
        for (int i2 = 0; i2 < size; i2++) {
            baseMultiRowSubParts.a(this.f9999a, new Props((GraphQLWorkCommunityTrendingFeedUnitItem) o.get(i2)));
        }
        WorkTrendingFooterPartDefinition.Props props = new WorkTrendingFooterPartDefinition.Props(this.f10001c, new Object(this) {
            public final /* synthetic */ WorkTrendingExpandableListPartDefinition f9995d;
        });
        if (o.size() > 3) {
            baseMultiRowSubParts.a(this.f10000b, props);
        }
        return workTrendingExpandableListPersistentKey;
    }

    @Inject
    public WorkTrendingExpandableListPartDefinition(WorkTrendingRowPartDefinition workTrendingRowPartDefinition, WorkTrendingFooterPartDefinition workTrendingFooterPartDefinition) {
        this.f9999a = workTrendingRowPartDefinition;
        this.f10000b = workTrendingFooterPartDefinition;
    }

    public final boolean m10357a(Object obj) {
        return true;
    }

    public static WorkTrendingExpandableListPartDefinition m10354a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            WorkTrendingExpandableListPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9998e) {
                WorkTrendingExpandableListPartDefinition workTrendingExpandableListPartDefinition;
                if (a2 != null) {
                    workTrendingExpandableListPartDefinition = (WorkTrendingExpandableListPartDefinition) a2.a(f9998e);
                } else {
                    workTrendingExpandableListPartDefinition = f9997d;
                }
                if (workTrendingExpandableListPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10355b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9998e, b3);
                        } else {
                            f9997d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = workTrendingExpandableListPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
