package com.facebook.reviews.handler;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.controller.mutation.FeedbackMutationHelper;
import com.facebook.controller.mutation.MutationCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultFeedbackFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultFeedbackFieldsModel.LikersModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultFeedbackFieldsModel.LikersModel.Builder;
import com.facebook.inject.Assisted;
import com.facebook.reviews.binder.ReviewFeedRowViewBinder;
import com.facebook.reviews.binder.ReviewFeedRowViewBinder.C22813;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewWithFeedback;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsModels.ReviewWithFeedbackModel;
import javax.inject.Inject;

/* compiled from: Tried to return a view that was not lent out by this StyleRenderer */
public class LikeReviewClickHandler {
    public final C22813 f21627a;
    public final AbstractFbErrorReporter f21628b;
    public final FeedbackMutationHelper f21629c;

    /* compiled from: Tried to return a view that was not lent out by this StyleRenderer */
    public class C23211 implements MutationCallback<GraphQLFeedback> {
        final /* synthetic */ ReviewWithFeedback f21624a;
        final /* synthetic */ boolean f21625b;
        final /* synthetic */ LikeReviewClickHandler f21626c;

        public C23211(LikeReviewClickHandler likeReviewClickHandler, ReviewWithFeedback reviewWithFeedback, boolean z) {
            this.f21626c = likeReviewClickHandler;
            this.f21624a = reviewWithFeedback;
            this.f21625b = z;
        }

        public final /* bridge */ /* synthetic */ void m25167b(Object obj) {
        }

        public final /* bridge */ /* synthetic */ void m25168c(Object obj) {
        }

        public final void m25165a(Object obj) {
            LikeReviewClickHandler likeReviewClickHandler = this.f21626c;
            ReviewWithFeedbackModel a = ReviewWithFeedbackModel.a(this.f21624a);
            boolean z = this.f21625b;
            DefaultFeedbackFieldsModel m = a.m();
            int a2 = (z ? 1 : -1) + m.m().a();
            Builder builder = new Builder();
            LikersModel m2 = m.m();
            Builder builder2 = new Builder();
            builder2.a = m2.a();
            builder = builder2;
            builder.a = a2;
            LikersModel a3 = builder.a();
            DefaultFeedbackFieldsModel.Builder builder3 = new DefaultFeedbackFieldsModel.Builder();
            DefaultFeedbackFieldsModel.Builder builder4 = new DefaultFeedbackFieldsModel.Builder();
            builder4.a = m.b();
            builder4.b = m.c();
            builder4.c = m.d();
            builder4.d = m.x_();
            builder4.e = m.g();
            builder4.f = m.y_();
            builder4.g = m.z_();
            builder4.h = m.j();
            builder4.i = m.m();
            builder4.j = m.n();
            builder3 = builder4;
            builder3.f = z;
            builder3 = builder3;
            builder3.i = a3;
            m = builder3.a();
            ReviewWithFeedbackModel.Builder builder5 = new ReviewWithFeedbackModel.Builder();
            builder5 = ReviewWithFeedbackModel.Builder.a(a);
            builder5.c = m;
            ReviewFeedRowViewBinder.m25042d(this.f21626c.f21627a.f21391a, builder5.a());
        }

        public final void m25166a(Object obj, ServiceException serviceException) {
            C22813 c22813 = this.f21626c.f21627a;
            ReviewFeedRowViewBinder.m25042d(c22813.f21391a, this.f21624a);
        }
    }

    @Inject
    public LikeReviewClickHandler(@Assisted C22813 c22813, AbstractFbErrorReporter abstractFbErrorReporter, FeedbackMutationHelper feedbackMutationHelper) {
        this.f21627a = c22813;
        this.f21628b = abstractFbErrorReporter;
        this.f21629c = feedbackMutationHelper;
    }
}
