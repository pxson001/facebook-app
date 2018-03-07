package com.facebook.reviews.adapter;

import android.util.Pair;
import com.facebook.feedback.ui.RootFeedbackEventSubscriber;
import com.facebook.feedback.ui.RootFeedbackEventSubscriberProvider;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.reviews.adapter.UserReviewsListBaseSection.SectionChangedListener;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewWithFeedback;
import com.facebook.reviews.util.ReviewWithFeedbackMutator;
import com.facebook.reviews.util.helper.ReviewsGraphQLHelper;
import com.facebook.reviews.util.protocol.graphql.FetchUserReviewsInterfaces.FetchSingleReviewQuery.RepresentedProfile;
import com.google.common.base.Absent;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: URL_SEGUE */
public class SingleReviewSection extends UserReviewsListBaseSection<Pair<ReviewWithFeedback, RepresentedProfile>> {
    public Optional<ReviewWithFeedback> f21360a = Absent.INSTANCE;
    public Optional<RepresentedProfile> f21361b = Absent.INSTANCE;
    public RootFeedbackEventSubscriber f21362c;
    public SectionChangedListener f21363d;

    /* compiled from: URL_SEGUE */
    public class C22771 implements Function<GraphQLFeedback, Void> {
        final /* synthetic */ SingleReviewSection f21359a;

        public C22771(SingleReviewSection singleReviewSection) {
            this.f21359a = singleReviewSection;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) obj;
            if (graphQLFeedback != null && this.f21359a.f21360a.isPresent()) {
                this.f21359a.m24985a(ReviewWithFeedbackMutator.m4906a((ReviewWithFeedback) this.f21359a.f21360a.get(), graphQLFeedback));
                this.f21359a.f21363d.mo1169f();
            }
            return null;
        }
    }

    @Inject
    public SingleReviewSection(RootFeedbackEventSubscriberProvider rootFeedbackEventSubscriberProvider) {
        this.f21362c = rootFeedbackEventSubscriberProvider.a(new C22771(this), null, null, null, null);
    }

    protected final int mo1166k() {
        return this.f21360a.isPresent() ? 1 : 0;
    }

    protected final Object mo1163b(int i) {
        Preconditions.checkState(i == 0);
        Preconditions.checkState(this.f21360a.isPresent());
        Preconditions.checkState(this.f21361b.isPresent());
        return Pair.create(this.f21360a.get(), this.f21361b.get());
    }

    protected final UserReviewsListViewTypes mo1162a(int i) {
        Preconditions.checkState(i == 0);
        Preconditions.checkState(this.f21360a.isPresent());
        Preconditions.checkState(this.f21361b.isPresent());
        return UserReviewsListViewTypes.REVIEW_WITH_NO_ATTACHMENT;
    }

    @Nullable
    public final String m24984a() {
        return null;
    }

    protected final UserReviewsListViewTypes mo1164i() {
        return UserReviewsListViewTypes.NO_HEADER;
    }

    public final List m24987b() {
        return (this.f21360a.isPresent() && this.f21361b.isPresent()) ? ImmutableList.of(Pair.create(this.f21360a.get(), this.f21361b.get())) : RegularImmutableList.a;
    }

    public final void m24985a(@Nullable ReviewWithFeedback reviewWithFeedback) {
        this.f21362c.a(ReviewsGraphQLHelper.m4919d(reviewWithFeedback));
        if (reviewWithFeedback == null) {
            this.f21360a = Absent.INSTANCE;
            this.f21361b = Absent.INSTANCE;
            return;
        }
        this.f21360a = Optional.of(reviewWithFeedback);
    }
}
