package com.facebook.api.feedcache.memory;

import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLReadOnlyVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: log_http_queue_events */
public class FeedUnitTagHelper {

    /* compiled from: log_http_queue_events */
    class FeedUnitIdFindingVisitor extends GraphQLReadOnlyVisitor {
        final Set<String> f16267a = new HashSet();

        public final boolean mo2927a(GraphQLVisitableModel graphQLVisitableModel) {
            if (graphQLVisitableModel instanceof GraphQLPersistableNode) {
                m23088a(((GraphQLPersistableNode) graphQLVisitableModel).mo2834a());
            }
            if (graphQLVisitableModel instanceof FeedUnit) {
                m23088a(((FeedUnit) graphQLVisitableModel).mo2507g());
            }
            if (graphQLVisitableModel instanceof GraphQLStory) {
                m23088a(((GraphQLStory) graphQLVisitableModel).ai());
            }
            return true;
        }

        private void m23088a(String str) {
            if (!Strings.isNullOrEmpty(str)) {
                this.f16267a.add(str);
            }
        }
    }

    private FeedUnitTagHelper() {
    }

    public static ImmutableSet<String> m23086a(@Nullable FeedUnit feedUnit, boolean z) {
        if (!z) {
            return ImmutableSet.copyOf(m23087a(feedUnit));
        }
        if (feedUnit == null) {
            return RegularImmutableSet.f688a;
        }
        ImmutableSet<String> g = PropertyHelper.m21305g(feedUnit);
        if (g != null) {
            return g;
        }
        ImmutableSet copyOf = ImmutableSet.copyOf(m23087a(feedUnit));
        PropertyHelper.m21267a(feedUnit, copyOf);
        return copyOf;
    }

    private static Set<String> m23087a(@Nullable FeedUnit feedUnit) {
        Set<String> set;
        TracerDetour.a("FeedUnitTagHelper.findTags", -1801545672);
        if (feedUnit != null) {
            try {
                GraphQLReadOnlyVisitor feedUnitIdFindingVisitor = new FeedUnitIdFindingVisitor();
                feedUnitIdFindingVisitor.mo2928b(feedUnit);
                set = feedUnitIdFindingVisitor.f16267a;
            } finally {
                TracerDetour.a(692543171);
            }
        } else {
            set = ImmutableSet.of();
            TracerDetour.a(-682861489);
        }
        return set;
    }
}
