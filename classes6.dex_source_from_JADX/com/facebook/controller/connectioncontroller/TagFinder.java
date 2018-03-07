package com.facebook.controller.connectioncontroller;

import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLReadOnlyVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;
import java.util.HashSet;
import java.util.Set;

/* compiled from: original_file_size */
public class TagFinder {

    /* compiled from: original_file_size */
    class TagVisitor extends GraphQLReadOnlyVisitor {
        final Set<String> f8584a = new HashSet();

        public final boolean m12387a(GraphQLVisitableModel graphQLVisitableModel) {
            if (graphQLVisitableModel instanceof GraphQLPersistableNode) {
                m12386a(((GraphQLPersistableNode) graphQLVisitableModel).a());
            }
            if (graphQLVisitableModel instanceof FeedUnit) {
                m12386a(((FeedUnit) graphQLVisitableModel).g());
            }
            if (graphQLVisitableModel instanceof GraphQLStory) {
                m12386a(((GraphQLStory) graphQLVisitableModel).ai());
            }
            return true;
        }

        private void m12386a(String str) {
            if (!Strings.isNullOrEmpty(str)) {
                this.f8584a.add(str);
            }
        }
    }

    private TagFinder() {
    }

    public static ImmutableSet<String> m12388a(GraphQLVisitableModel graphQLVisitableModel) {
        FeedUnit feedUnit = null;
        if (graphQLVisitableModel instanceof FeedUnit) {
            feedUnit = (FeedUnit) graphQLVisitableModel;
        } else if (graphQLVisitableModel instanceof GraphQLFeedUnitEdge) {
            FeedUnit c = ((GraphQLFeedUnitEdge) graphQLVisitableModel).c();
            if (c == null) {
                return null;
            }
            feedUnit = c;
        }
        if (feedUnit == null) {
            return m12389b(graphQLVisitableModel);
        }
        ImmutableSet<String> g = PropertyHelper.g(feedUnit);
        if (g != null) {
            return g;
        }
        g = m12389b(feedUnit);
        PropertyHelper.a(feedUnit, g);
        return g;
    }

    private static ImmutableSet<String> m12389b(GraphQLVisitableModel graphQLVisitableModel) {
        if (graphQLVisitableModel == null) {
            return RegularImmutableSet.a;
        }
        TagVisitor tagVisitor = new TagVisitor();
        tagVisitor.b(graphQLVisitableModel);
        return ImmutableSet.copyOf(tagVisitor.f8584a);
    }
}
