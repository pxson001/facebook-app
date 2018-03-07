package com.facebook.reviews.adapter;

import com.facebook.feedback.ui.RootFeedbackEventSubscriber;
import com.facebook.feedback.ui.RootFeedbackEventSubscriberProvider;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.querybuilder.convertible.DefaultGraphQLConversionHelper;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewWithFeedback;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsInterfaces.UserReviews.AuthoredReviews.Edges;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsModels.UserReviewsModel.AuthoredReviewsModel;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsModels.UserReviewsModel.AuthoredReviewsModel.EdgesModel;
import com.facebook.reviews.util.ReviewWithFeedbackMutator;
import com.facebook.reviews.util.helper.AuthoredReviewsMutator;
import com.facebook.reviews.util.helper.ReviewsGraphQLHelper;
import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: UPDATE_PHONE */
public class UserReviewsSection extends UserReviewsListBaseSection<Edges> {
    private final RootFeedbackEventSubscriberProvider f21377a;
    public final UserReviewsInfiniteScrollFooter f21378b;
    public final List<Edges> f21379c = new ArrayList();
    private final List<RootFeedbackEventSubscriber> f21380d = new ArrayList();
    public final Map<String, Edges> f21381e = new HashMap();
    public final Map<String, Edges> f21382f = new HashMap();
    private final Map<String, Edges> f21383g = new HashMap();
    public String f21384h;
    public String f21385i;
    public boolean f21386j = true;
    public boolean f21387k;

    @Inject
    public UserReviewsSection(RootFeedbackEventSubscriberProvider rootFeedbackEventSubscriberProvider, UserReviewsInfiniteScrollFooter userReviewsInfiniteScrollFooter) {
        this.f21378b = userReviewsInfiniteScrollFooter;
        this.f21377a = rootFeedbackEventSubscriberProvider;
    }

    public final void m25023a(@Nullable AuthoredReviewsModel authoredReviewsModel) {
        if (authoredReviewsModel != null) {
            ImmutableList a = authoredReviewsModel.a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                EdgesModel edgesModel = (EdgesModel) a.get(i);
                String b = ReviewsGraphQLHelper.m4916b(edgesModel);
                if (!(edgesModel == null || b == null || this.f21382f.containsKey(b))) {
                    m25016a(this, edgesModel);
                    this.f21379c.add(edgesModel);
                    m25017d(this.f21379c.size() - 1);
                }
            }
            this.f21385i = authoredReviewsModel.b().a();
            this.f21386j = authoredReviewsModel.b().b();
        }
    }

    public final /* synthetic */ UserReviewsListBaseFooter mo1167l() {
        return this.f21378b;
    }

    public final void m25024a(String str) {
        if (this.f21382f.containsKey(str)) {
            EdgesModel edgesModel = (EdgesModel) this.f21382f.remove(str);
            ReviewWithFeedback b = edgesModel.b();
            int indexOf = this.f21379c.indexOf(edgesModel);
            this.f21379c.remove(edgesModel);
            this.f21383g.remove(ReviewsGraphQLHelper.m4915b(b));
            this.f21381e.remove(ReviewsGraphQLHelper.m4918c(b));
            m25019f(indexOf);
        }
    }

    public final int m25020a(String str, EdgesModel edgesModel) {
        int indexOf = this.f21382f.containsKey(str) ? this.f21379c.indexOf(this.f21382f.get(str)) : 0;
        if (this.f21382f.containsKey(str)) {
            this.f21379c.set(indexOf, edgesModel);
            m25015a(this, indexOf, DefaultGraphQLConversionHelper.a(edgesModel.b().bO_()));
        } else {
            this.f21379c.add(indexOf, edgesModel);
            this.f21380d.add(m25018e(indexOf));
            m25019f(indexOf);
        }
        m25016a(this, edgesModel);
        return indexOf;
    }

    protected final boolean mo1165j() {
        return this.f21386j && this.f21387k;
    }

    protected final int mo1166k() {
        return this.f21379c.size();
    }

    protected final Object mo1163b(int i) {
        return (EdgesModel) this.f21379c.get(i);
    }

    protected final UserReviewsListViewTypes mo1162a(int i) {
        return UserReviewsListViewTypes.USER_REVIEW;
    }

    public final String m25022a() {
        return this.f21384h;
    }

    public final List m25026b() {
        return ImmutableList.copyOf(this.f21379c);
    }

    protected final UserReviewsListViewTypes mo1164i() {
        return (this.f21384h == null || this.f21379c.isEmpty()) ? UserReviewsListViewTypes.NO_HEADER : UserReviewsListViewTypes.DEFAULT_HEADER;
    }

    public static void m25016a(UserReviewsSection userReviewsSection, EdgesModel edgesModel) {
        userReviewsSection.f21382f.put(ReviewsGraphQLHelper.m4916b(edgesModel), edgesModel);
        ReviewWithFeedback b = edgesModel.b();
        String b2 = ReviewsGraphQLHelper.m4915b(b);
        if (!Strings.isNullOrEmpty(b2)) {
            userReviewsSection.f21383g.put(b2, edgesModel);
        }
        String c = ReviewsGraphQLHelper.m4918c(b);
        if (!Strings.isNullOrEmpty(c)) {
            userReviewsSection.f21381e.put(c, edgesModel);
        }
    }

    private void m25017d(int i) {
        RootFeedbackEventSubscriber e = m25018e(i);
        this.f21380d.add(e);
        if (((EdgesModel) this.f21379c.get(i)).b().bO_() != null) {
            e.a(DefaultGraphQLConversionHelper.a(((EdgesModel) this.f21379c.get(i)).b().bO_()));
        }
    }

    private RootFeedbackEventSubscriber m25018e(final int i) {
        return this.f21377a.a(new Function<GraphQLFeedback, Void>(this) {
            final /* synthetic */ UserReviewsSection f21376b;

            public Object apply(Object obj) {
                GraphQLFeedback graphQLFeedback = (GraphQLFeedback) obj;
                if (graphQLFeedback != null) {
                    EdgesModel a = AuthoredReviewsMutator.m4907a((EdgesModel) this.f21376b.f21379c.get(i), ReviewWithFeedbackMutator.m4906a(((EdgesModel) this.f21376b.f21379c.get(i)).b(), graphQLFeedback));
                    this.f21376b.f21379c.set(i, a);
                    UserReviewsSection.m25016a(this.f21376b, a);
                    UserReviewsSection.m25015a(this.f21376b, i, graphQLFeedback);
                    this.f21376b.f21378b.m24993c();
                }
                return null;
            }
        }, null, null, null, null);
    }

    private void m25019f(int i) {
        while (i < this.f21379c.size()) {
            ((RootFeedbackEventSubscriber) this.f21380d.get(i)).a();
            m25015a(this, i, DefaultGraphQLConversionHelper.a(((EdgesModel) this.f21379c.get(i)).b().bO_()));
            i++;
        }
    }

    public static void m25015a(UserReviewsSection userReviewsSection, int i, GraphQLFeedback graphQLFeedback) {
        ((RootFeedbackEventSubscriber) userReviewsSection.f21380d.get(i)).a(graphQLFeedback);
    }
}
