package com.facebook.timeline.refresher;

import android.os.Bundle;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.calls.ProfileWizardRefresherStepSkipInputData;
import com.facebook.graphql.calls.ProfileWizardRefresherStepSkipInputData.StepType;
import com.facebook.graphql.enums.GraphQLProfileWizardStepType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultBigProfilePictureFieldsModel;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.inject.Assisted;
import com.facebook.qe.api.QeAccessor;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQL;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQL.TimelineProfilePictureUriQueryString;
import com.facebook.timeline.refresher.ProfileRefresherHeaderFragment.HeaderRefreshable;
import com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQL;
import com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQL.TimelineCoverPhotoUriQueryString;
import com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQL.TimelineNuxQueryString;
import com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQL.TimelineRefresherQueryString;
import com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.ProfileWizardNuxFieldsModel;
import com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.ProfileWizardRefresherFieldsModel;
import com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineCoverPhotoUriQueryModel;
import com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineNuxQueryModel;
import com.facebook.timeline.refresher.protocol.FetchProfileRefresherGraphQLModels.TimelineRefresherQueryModel;
import com.facebook.timeline.refresher.protocol.ProfileRefresherSkipMutation.ProfileRefresherStepSkipMutationString;
import com.facebook.timeline.refresher.ui.ProfileRefresherStepProgressBar;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.Futures;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: updatePinnedThreadsParams */
public class ProfileRefresherController implements HeaderRefreshable, EventListener {
    public final ProfileRefresherBinder f967a;
    public final ProfileRefresherModel f968b;
    public final ActivityListener f969c;
    public final ProfileRefresherView f970d;
    private final ProfileRefresherAnalyticsLogger f971e;
    public final GraphQLQueryExecutor f972f;
    public final Executor f973g;
    public final List<FutureAndCallbackHolder<?>> f974h = new ArrayList();
    private ProfileRefresherStepSkipMutationController f975i;

    /* compiled from: updatePinnedThreadsParams */
    public interface ActivityListener {
        void mo46i();

        void mo48k();

        void mo49l();
    }

    /* compiled from: updatePinnedThreadsParams */
    public class C00931 extends AbstractDisposableFutureCallback<GraphQLResult<T>> {
        final /* synthetic */ ProfileRefresherController f964a;

        public C00931(ProfileRefresherController profileRefresherController) {
            this.f964a = profileRefresherController;
        }

        public final void m970a(Object obj) {
            ProfileRefresherController.m982c(this.f964a, (GraphQLResult) obj);
        }

        public final void m971a(Throwable th) {
            this.f964a.f969c.mo48k();
        }
    }

    /* compiled from: updatePinnedThreadsParams */
    public class C00942 extends AbstractDisposableFutureCallback<GraphQLResult<DefaultBigProfilePictureFieldsModel>> {
        final /* synthetic */ ProfileRefresherController f965a;

        public C00942(ProfileRefresherController profileRefresherController) {
            this.f965a = profileRefresherController;
        }

        public final void m972a(Object obj) {
            this.f965a.m987a((GraphQLResult) obj);
        }

        public final void m973a(Throwable th) {
            this.f965a.f969c.mo48k();
        }
    }

    /* compiled from: updatePinnedThreadsParams */
    public class C00953 extends AbstractDisposableFutureCallback<GraphQLResult<TimelineCoverPhotoUriQueryModel>> {
        final /* synthetic */ ProfileRefresherController f966a;

        public C00953(ProfileRefresherController profileRefresherController) {
            this.f966a = profileRefresherController;
        }

        protected final void m974a(Object obj) {
            this.f966a.m988b((GraphQLResult) obj);
        }

        protected final void m975a(Throwable th) {
            this.f966a.f969c.mo48k();
        }
    }

    @Inject
    public ProfileRefresherController(@Assisted ActivityListener activityListener, @Assisted ProfileRefresherBinder profileRefresherBinder, @Assisted ProfileRefresherModel profileRefresherModel, @Assisted ProfileRefresherView profileRefresherView, GraphQLQueryExecutor graphQLQueryExecutor, Executor executor, ProfileRefresherAnalyticsLogger profileRefresherAnalyticsLogger, ProfileRefresherStepSkipMutationController profileRefresherStepSkipMutationController, QeAccessor qeAccessor) {
        this.f969c = activityListener;
        this.f967a = profileRefresherBinder;
        this.f968b = profileRefresherModel;
        this.f970d = profileRefresherView;
        this.f972f = graphQLQueryExecutor;
        this.f973g = executor;
        this.f971e = profileRefresherAnalyticsLogger;
        this.f975i = profileRefresherStepSkipMutationController;
    }

    public final void m986a(@Nullable Bundle bundle) {
        GraphQLRequest a;
        this.f967a.f959d = this.f970d;
        this.f970d.setListener(this);
        if (bundle != null) {
            Object a2 = FlatBufferModelHelper.a(bundle, "profile_nux_refresher_model");
            if (a2 instanceof BaseModel) {
                m982c(this, new GraphQLResult(a2, DataFreshnessResult.FROM_CACHE_UP_TO_DATE, 0));
                return;
            }
        }
        GraphQlQueryString timelineRefresherQueryString;
        if (this.f968b.f1018f) {
            timelineRefresherQueryString = new TimelineRefresherQueryString();
            timelineRefresherQueryString.a("profile_refresher_step_types", m983k());
            a = GraphQLRequest.a(timelineRefresherQueryString);
        } else {
            timelineRefresherQueryString = new TimelineNuxQueryString();
            timelineRefresherQueryString.a("profile_nux_step_types", m983k());
            a = GraphQLRequest.a(timelineRefresherQueryString);
        }
        GraphQLQueryFuture a3 = this.f972f.a(a);
        C00931 c00931 = new C00931(this);
        Futures.a(a3, c00931, this.f973g);
        this.f974h.add(new FutureAndCallbackHolder(a3, c00931));
    }

    private ImmutableList<GraphQLProfileWizardStepType> m983k() {
        Builder builder = new Builder();
        builder.c(GraphQLProfileWizardStepType.PROFILE_PICTURE).c(GraphQLProfileWizardStepType.COVER_PHOTO);
        if (this.f968b.f1018f) {
            builder.c(GraphQLProfileWizardStepType.CORE_PROFILE_FIELD);
        } else {
            builder.c(GraphQLProfileWizardStepType.COMPOSER).c(GraphQLProfileWizardStepType.CORE_PROFILE_FIELD);
        }
        return builder.b();
    }

    public static void m982c(ProfileRefresherController profileRefresherController, GraphQLResult graphQLResult) {
        if (graphQLResult != null && graphQLResult.e != null) {
            BaseModel baseModel = (BaseModel) graphQLResult.e;
            if (!profileRefresherController.m981a(baseModel)) {
                profileRefresherController.f968b.m1027a(baseModel);
                profileRefresherController.f969c.mo49l();
                ProfileRefresherBinder profileRefresherBinder = profileRefresherController.f967a;
                if (profileRefresherController.f968b.f1021i >= 2) {
                    profileRefresherBinder.f961f = (ProfileRefresherStepProgressBar) profileRefresherBinder.f959d.f1045e.inflate();
                    profileRefresherBinder.f961f.setVisibility(0);
                }
                profileRefresherController.f967a.m968b(profileRefresherController.f968b);
                if (profileRefresherController.f970d.f1052l.m1039c(GraphQLProfileWizardStepType.PROFILE_PICTURE)) {
                    ((ProfileRefresherHeaderFragment) profileRefresherController.f970d.f1052l.m1038b(GraphQLProfileWizardStepType.PROFILE_PICTURE)).as = profileRefresherController;
                }
                profileRefresherController.m985n();
            }
        }
    }

    private boolean m981a(BaseModel baseModel) {
        if (this.f968b.f1018f) {
            ProfileWizardRefresherFieldsModel a = ((TimelineRefresherQueryModel) baseModel).m1148a();
            if (a == null || a.m1092a() == null || a.m1093j() == null || a.m1093j().m1098a() == null) {
                return true;
            }
        }
        ProfileWizardNuxFieldsModel a2 = ((TimelineNuxQueryModel) baseModel).m1143a();
        if (a2 == null || a2.m1081a() == null || a2.m1082j() == null || a2.m1082j().m1098a() == null) {
            return true;
        }
        return false;
    }

    public final void mo51d() {
        if (this.f968b.m1031e() != null) {
            String str;
            ProfileRefresherAnalyticsLogger profileRefresherAnalyticsLogger = this.f971e;
            if (this.f968b.f1018f) {
                str = "profile_refresher";
            } else {
                str = "profile_nux";
            }
            profileRefresherAnalyticsLogger.m955c(str, this.f968b.m1032f(), this.f968b.m1031e());
        }
        if (this.f968b.f1020h == this.f968b.f1021i - 1) {
            this.f969c.mo46i();
            return;
        }
        if (this.f968b.f1018f) {
            ProfileRefresherStepSkipMutationController profileRefresherStepSkipMutationController = this.f975i;
            String valueOf = String.valueOf(this.f968b.f1014b);
            StepType valueOf2 = StepType.valueOf(this.f968b.m1031e().toString());
            ProfileWizardRefresherStepSkipInputData profileWizardRefresherStepSkipInputData = new ProfileWizardRefresherStepSkipInputData();
            profileWizardRefresherStepSkipInputData.a("actor_id", valueOf);
            profileWizardRefresherStepSkipInputData.a("step_type", valueOf2);
            GraphQlQueryString profileRefresherStepSkipMutationString = new ProfileRefresherStepSkipMutationString();
            profileRefresherStepSkipMutationString.a("input", profileWizardRefresherStepSkipInputData);
            profileRefresherStepSkipMutationController.f1035a.a(GraphQLRequest.a(profileRefresherStepSkipMutationString));
        }
        m984m();
    }

    public final void mo52e() {
        if (this.f968b.m1034q() && this.f968b.m1031e() != null) {
            String str;
            ProfileRefresherAnalyticsLogger profileRefresherAnalyticsLogger = this.f971e;
            if (this.f968b.f1018f) {
                str = "profile_refresher";
            } else {
                str = "profile_nux";
            }
            profileRefresherAnalyticsLogger.m953b(str, this.f968b.m1032f(), this.f968b.m1031e());
        }
        this.f969c.mo46i();
    }

    public final void m987a(GraphQLResult<DefaultBigProfilePictureFieldsModel> graphQLResult) {
        String b = ((DefaultBigProfilePictureFieldsModel) graphQLResult.e).a() == null ? null : ((DefaultBigProfilePictureFieldsModel) graphQLResult.e).a().b();
        ProfileRefresherModel profileRefresherModel = this.f968b;
        profileRefresherModel.f1015c = b;
        profileRefresherModel.f1017e = true;
        ProfileRefresherAnalyticsLogger profileRefresherAnalyticsLogger = this.f971e;
        if (this.f968b.f1018f) {
            b = "profile_refresher";
        } else {
            b = "profile_nux";
        }
        profileRefresherAnalyticsLogger.m959f(b, this.f968b.m1032f(), this.f968b.m1031e());
        m984m();
    }

    public final void m988b(GraphQLResult<TimelineCoverPhotoUriQueryModel> graphQLResult) {
        String str;
        if (((TimelineCoverPhotoUriQueryModel) graphQLResult.e).m1136a() == null || ((TimelineCoverPhotoUriQueryModel) graphQLResult.e).m1136a().m1131a() == null || ((TimelineCoverPhotoUriQueryModel) graphQLResult.e).m1136a().m1131a().m1127a() == null) {
            str = null;
        } else {
            str = ((TimelineCoverPhotoUriQueryModel) graphQLResult.e).m1136a().m1131a().m1127a().m1123a();
        }
        this.f968b.f1016d = str;
        ProfileRefresherAnalyticsLogger profileRefresherAnalyticsLogger = this.f971e;
        if (this.f968b.f1018f) {
            str = "profile_refresher";
        } else {
            str = "profile_nux";
        }
        profileRefresherAnalyticsLogger.m959f(str, this.f968b.m1032f(), this.f968b.m1031e());
        m984m();
    }

    public final void m992g() {
        m984m();
    }

    private void m984m() {
        this.f968b.m1033h();
        this.f967a.m968b(this.f968b);
        m985n();
    }

    public final void m993h() {
        if (this.f968b.m1031e() == GraphQLProfileWizardStepType.CORE_PROFILE_FIELD) {
            this.f968b.m1033h();
            m985n();
        }
        this.f967a.m968b(this.f968b);
    }

    private void m985n() {
        if (this.f968b.m1031e() != null) {
            String str;
            ProfileRefresherAnalyticsLogger profileRefresherAnalyticsLogger = this.f971e;
            if (this.f968b.f1018f) {
                str = "profile_refresher";
            } else {
                str = "profile_nux";
            }
            profileRefresherAnalyticsLogger.m951a(str, this.f968b.m1032f(), this.f968b.m1031e());
        }
    }

    public final void mo53f() {
        int c = GraphQlQueryDefaults.c();
        GraphQLQueryFuture a;
        if (this.f968b.m1031e() == GraphQLProfileWizardStepType.PROFILE_PICTURE) {
            a = this.f972f.a(GraphQLRequest.a((TimelineProfilePictureUriQueryString) FetchTimelineHeaderGraphQL.b().a("profile_id", this.f968b.f1014b)));
            C00942 c00942 = new C00942(this);
            Futures.a(a, c00942, this.f973g);
            this.f974h.add(new FutureAndCallbackHolder(a, c00942));
        } else if (this.f968b.m1031e() == GraphQLProfileWizardStepType.COVER_PHOTO) {
            a = this.f972f.a(GraphQLRequest.a((TimelineCoverPhotoUriQueryString) FetchProfileRefresherGraphQL.m1071c().a("profile_id", this.f968b.f1014b).a("cover_photo_size", Integer.valueOf(c))));
            C00953 c00953 = new C00953(this);
            Futures.a(a, c00953, this.f973g);
            this.f974h.add(new FutureAndCallbackHolder(a, c00953));
        }
    }

    public final void mo54i() {
        String str;
        Preconditions.checkArgument(this.f968b != null);
        ProfileRefresherAnalyticsLogger profileRefresherAnalyticsLogger = this.f971e;
        if (this.f968b.f1018f) {
            str = "profile_refresher";
        } else {
            str = "profile_nux";
        }
        profileRefresherAnalyticsLogger.m958e(str, this.f968b.m1032f(), this.f968b.m1031e());
        if (this.f968b.m1031e().equals(GraphQLProfileWizardStepType.PROFILE_PICTURE)) {
            ((ProfileRefresherHeaderFragment) this.f970d.f1052l.m1038b(GraphQLProfileWizardStepType.PROFILE_PICTURE)).au();
        } else if (this.f968b.m1031e().equals(GraphQLProfileWizardStepType.COVER_PHOTO)) {
            ((ProfileRefresherHeaderFragment) this.f970d.f1052l.m1038b(GraphQLProfileWizardStepType.COVER_PHOTO)).av();
        }
    }

    public final void mo55j() {
        String str;
        Preconditions.checkArgument(this.f968b != null);
        ProfileRefresherAnalyticsLogger profileRefresherAnalyticsLogger = this.f971e;
        if (this.f968b.f1018f) {
            str = "profile_refresher";
        } else {
            str = "profile_nux";
        }
        profileRefresherAnalyticsLogger.m957d(str, this.f968b.m1032f(), this.f968b.m1031e());
        if (this.f968b.m1031e().equals(GraphQLProfileWizardStepType.PROFILE_PICTURE)) {
            ((ProfileRefresherHeaderFragment) this.f970d.f1052l.m1038b(GraphQLProfileWizardStepType.PROFILE_PICTURE)).aw();
        } else if (this.f968b.m1031e().equals(GraphQLProfileWizardStepType.COVER_PHOTO)) {
            ((ProfileRefresherHeaderFragment) this.f970d.f1052l.m1038b(GraphQLProfileWizardStepType.COVER_PHOTO)).ax();
        }
    }
}
