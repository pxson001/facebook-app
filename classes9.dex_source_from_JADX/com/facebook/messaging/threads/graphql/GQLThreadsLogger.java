package com.facebook.messaging.threads.graphql;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.graphql.enums.GraphQLMessageVideoType;
import com.facebook.graphql.enums.GraphQLObjectType.ObjectType;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.MessageInfoModel.BlobAttachmentsModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.facebook.heisman.ProfilePictureOverlayPivotActivity */
public class GQLThreadsLogger {
    public final AbstractFbErrorReporter f17831a;
    private final AnalyticsLogger f17832b;
    private final LoggedInUserSessionManager f17833c;
    private final AppStateManager f17834d;

    public static GQLThreadsLogger m17795b(InjectorLike injectorLike) {
        return new GQLThreadsLogger((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), LoggedInUserSessionManager.a(injectorLike), AppStateManager.a(injectorLike));
    }

    @Inject
    public GQLThreadsLogger(AbstractFbErrorReporter abstractFbErrorReporter, AnalyticsLogger analyticsLogger, LoggedInUserSessionManager loggedInUserSessionManager, AppStateManager appStateManager) {
        this.f17831a = abstractFbErrorReporter;
        this.f17832b = analyticsLogger;
        this.f17833c = loggedInUserSessionManager;
        this.f17834d = appStateManager;
    }

    public final void m17805a(String str, Object... objArr) {
        Preconditions.checkNotNull(str);
        String str2 = "gql_threads_null";
        for (Object obj : objArr) {
            if (obj == null) {
                this.f17831a.a(SoftError.b(str2, str));
                throw new NullPointerException(str2 + ": " + str);
            }
        }
    }

    public static GQLThreadsLogger m17793a(InjectorLike injectorLike) {
        return m17795b(injectorLike);
    }

    public final void m17804a(String str) {
        Preconditions.checkNotNull(str);
        this.f17831a.a(SoftError.b("gql_threads_null", str));
    }

    public final void m17806a(Throwable th) {
        this.f17831a.a("failed_fetch_thread_list", th);
    }

    public final void m17809b(Throwable th) {
        m17794a("failed_fetch_thread_list_communication", th);
    }

    public final void m17810c(Throwable th) {
        this.f17831a.a("failed_fetch_more_threads", th);
    }

    public final void m17811d(Throwable th) {
        m17794a("failed_fetch_more_threads_communication", th);
    }

    public final void m17812e(Throwable th) {
        this.f17831a.a("failed_fetch_user", th);
    }

    public final void m17813f(Throwable th) {
        m17794a("failed_fetch_user_communication", th);
    }

    public final void m17814g(Throwable th) {
        this.f17831a.a("failed_fetch_threads", th);
    }

    public final void m17815h(Throwable th) {
        m17794a("failed_fetch_threads_communication", th);
    }

    public final void m17816i(Throwable th) {
        this.f17831a.a("failed_fetch_more_messages", th);
    }

    public final void m17817j(Throwable th) {
        m17794a("failed_fetch_more_messages_communication", th);
    }

    public final void m17818k(Throwable th) {
        this.f17831a.a("failed_fetch_messages", th);
    }

    public final void m17819l(Throwable th) {
        m17794a("failed_fetch_messages_communication", th);
    }

    public final void m17820m(Throwable th) {
        this.f17831a.a("failed_fetch_pinned_threads", th);
    }

    public final void m17821n(Throwable th) {
        m17794a("failed_fetch_pinned_threads_communication", th);
    }

    public final void m17801a(XMAModel xMAModel, Exception exception) {
        this.f17831a.a("xma_handling_failed", "Failed to handle XMA with id: " + xMAModel.b(), exception);
    }

    public final void m17796a() {
        this.f17831a.a("pinned_threads_fetch", "Graphql pinned_message_threads is null");
    }

    public final void m17803a(@Nullable Long l) {
        this.f17831a.a("threads_fetch_no_folder", "Unexpected no-folder thread. Id: " + l);
    }

    public final void m17807b() {
        this.f17831a.a("null_thread_list_result", "Thread list returned from server was null");
    }

    public final void m17802a(ThreadKey threadKey) {
        this.f17831a.a("fetch_thread_fail", "Failed to fetch thread " + threadKey.toString());
    }

    public final void m17797a(int i) {
        this.f17831a.a("graphql_type_unsupported", "Failed to support graphql message of type " + ObjectType.a(i));
    }

    public final void m17808b(int i) {
        this.f17831a.a("graphql_type_unsupported", "Failed to support graphql attachment of type " + ObjectType.a(i));
    }

    public final void m17799a(GraphQLMessageVideoType graphQLMessageVideoType) {
        this.f17831a.a("graphql_video_type_null", "Graphql type of video attachment is null: " + graphQLMessageVideoType.toString());
    }

    public final void m17800a(BlobAttachmentsModel blobAttachmentsModel) {
        this.f17831a.a("graphql_video_incomplete_model", "Got an incomplete video attachment model. streamingImageThumbnail=" + blobAttachmentsModel.M() + ", attachmentVideoUrl=" + blobAttachmentsModel.u() + ", originalDimensions=" + blobAttachmentsModel.I() + ", playableDurationInMs=" + blobAttachmentsModel.J());
    }

    public final void m17798a(@Nullable CallerContext callerContext) {
        String str;
        AbstractFbErrorReporter abstractFbErrorReporter = this.f17831a;
        String str2 = "null_logged_in_user";
        StringBuilder append = new StringBuilder("Got a null ViewerContextUser, caller context:").append(callerContext).append(", LoggedInUser: ").append(this.f17833c.c()).append(", ViewerContextUserId: ");
        if (this.f17833c.a() == null) {
            str = null;
        } else {
            str = this.f17833c.a().mUserId;
        }
        abstractFbErrorReporter.a(str2, append.append(str).append(", isMaskingCurrentCredentials: ").append(this.f17833c.h()).append(", hasReportedAuthSyncError: ").append(this.f17833c.i()).append(", isLoggedIn: ").append(this.f17833c.b()).append(", isLoggingOut: ").append(this.f17833c.d()).append(", isAppBackgrounded: ").append(this.f17834d.j()).append(", isUserInApp: ").append(this.f17834d.l()).append(", isAppInitialized: ").append(this.f17834d.h()).append(", isApplicationFirstRunOnInstall: ").append(this.f17834d.U).append(", isApplicationFirstRunOnUpgrade: ").append(this.f17834d.V).append(", isAppStartedInBackground: ").append(this.f17834d.k()).toString());
    }

    private void m17794a(String str, Throwable th) {
        String name;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        String str2 = "type";
        if (th.getCause() == null) {
            name = th.getClass().getName();
        } else {
            name = th.getCause().getClass().getName();
        }
        HoneyClientEvent b = honeyClientEvent.b(str2, name).b("reason", th.getMessage());
        b.c = "ThreadsModel";
        this.f17832b.a(b);
    }
}
