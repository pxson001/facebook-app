package com.facebook.friending.jewel;

import android.content.Context;
import android.content.Intent;
import com.facebook.base.service.FbIntentService;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.friending.jewel.protocol.SetFriendRequestsAudienceMutation.SetFriendRequestsAudienceMutationString;
import com.facebook.friending.jewel.protocol.SetFriendRequestsAudienceMutationModels.SetFriendRequestsAudienceMutationModel;
import com.facebook.graphql.calls.SetFriendRequestsAudienceInputData;
import com.facebook.graphql.calls.SetFriendRequestsAudienceInputData.Audience;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: first_frame_render_time */
public class FriendRequestsPrivacySettingService extends FbIntentService {
    private static final Class<?> f13208d = FriendRequestsPrivacySettingService.class;
    @Inject
    public GraphQLQueryExecutor f13209a;
    @DefaultExecutorService
    @Inject
    public ExecutorService f13210b;
    @Inject
    public AbstractFbErrorReporter f13211c;

    /* compiled from: first_frame_render_time */
    class C13821 implements FutureCallback<GraphQLResult<SetFriendRequestsAudienceMutationModel>> {
        final /* synthetic */ FriendRequestsPrivacySettingService f13207a;

        C13821(FriendRequestsPrivacySettingService friendRequestsPrivacySettingService) {
            this.f13207a = friendRequestsPrivacySettingService;
        }

        public /* bridge */ /* synthetic */ void onSuccess(@Nullable Object obj) {
        }

        public void onFailure(Throwable th) {
            AbstractFbErrorReporter abstractFbErrorReporter = this.f13207a.f13211c;
            SoftErrorBuilder a = SoftError.a("friend_requests_restrict_audience", "Mutation call for new privacy setting returned an error " + th.getMessage());
            a.e = 1;
            abstractFbErrorReporter.a(a.g());
        }
    }

    private static <T extends Context> void m14869a(Class<T> cls, T t) {
        m14870a((Object) t, (Context) t);
    }

    public static void m14870a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        FriendRequestsPrivacySettingService friendRequestsPrivacySettingService = (FriendRequestsPrivacySettingService) obj;
        GraphQLQueryExecutor a = GraphQLQueryExecutor.a(fbInjector);
        ExecutorService executorService = (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(fbInjector);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        friendRequestsPrivacySettingService.f13209a = a;
        friendRequestsPrivacySettingService.f13210b = executorService;
        friendRequestsPrivacySettingService.f13211c = abstractFbErrorReporter;
    }

    public FriendRequestsPrivacySettingService() {
        super(f13208d.getName());
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, -1061617614);
        super.onCreate();
        Class cls = FriendRequestsPrivacySettingService.class;
        m14870a((Object) this, (Context) this);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 783478936, a);
    }

    protected final void m14871a(Intent intent) {
        SetFriendRequestsAudienceInputData setFriendRequestsAudienceInputData = new SetFriendRequestsAudienceInputData();
        setFriendRequestsAudienceInputData.a("audience", Audience.FRIENDS_OF_FRIENDS);
        GraphQlQueryString setFriendRequestsAudienceMutationString = new SetFriendRequestsAudienceMutationString();
        setFriendRequestsAudienceMutationString.a("input", setFriendRequestsAudienceInputData);
        Futures.a(this.f13209a.a(GraphQLRequest.a(setFriendRequestsAudienceMutationString)), new C13821(this), this.f13210b);
    }
}
