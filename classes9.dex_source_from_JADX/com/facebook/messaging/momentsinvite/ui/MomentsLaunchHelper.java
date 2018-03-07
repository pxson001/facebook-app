package com.facebook.messaging.momentsinvite.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.appsinstallhelper.AppsInstallHelper;
import com.facebook.appsinstallhelper.AppsInstallHelperProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.calls.MomentsBotInvitePostbackInputData;
import com.facebook.graphql.enums.GraphQLMomentsAppMessengerInviteActionType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.common.NetworkException;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.MomentsAppInvitationActionLinkFragmentModel;
import com.facebook.messaging.momentsinvite.analytics.MomentsInviteLogger;
import com.facebook.messaging.momentsinvite.graphql.MomentsInviteActionPostbackMutation.MomentsInviteActionPostbackMutationString;
import com.facebook.messaging.momentsinvite.graphql.MomentsInviteActionPostbackMutationModels.MomentsInviteActionPostbackMutationModel;
import com.facebook.messaging.momentsinvite.model.MomentsInviteXMAModel;
import com.facebook.messaging.momentsinvite.webview.MomentsInviteWebViewActivity;
import com.facebook.moments.install.MomentsInstallInfo;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: iso-8859-9 */
public class MomentsLaunchHelper {
    public static final String f12373a = MomentsLaunchHelper.class.getSimpleName();
    private final AppsInstallHelper f12374b;
    private final SecureContextHelper f12375c;
    private final MomentsInviteLogger f12376d;
    private final TasksManager<String> f12377e;
    public final GraphQLQueryExecutor f12378f;
    public final Lazy<FbErrorReporter> f12379g;

    /* compiled from: iso-8859-9 */
    public interface PostbackCallback {
        void mo464a();

        void mo465b();
    }

    public static MomentsLaunchHelper m12842b(InjectorLike injectorLike) {
        return new MomentsLaunchHelper((AppsInstallHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AppsInstallHelperProvider.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), MomentsInviteLogger.m12752a(injectorLike), TasksManager.b(injectorLike), GraphQLQueryExecutor.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494));
    }

    @Inject
    public MomentsLaunchHelper(AppsInstallHelperProvider appsInstallHelperProvider, SecureContextHelper secureContextHelper, MomentsInviteLogger momentsInviteLogger, TasksManager tasksManager, GraphQLQueryExecutor graphQLQueryExecutor, Lazy<FbErrorReporter> lazy) {
        this.f12374b = appsInstallHelperProvider.a(new MomentsInstallInfo());
        this.f12375c = secureContextHelper;
        this.f12376d = momentsInviteLogger;
        this.f12377e = tasksManager;
        this.f12378f = graphQLQueryExecutor;
        this.f12379g = lazy;
    }

    public final boolean m12844a(Context context) {
        return this.f12374b.a();
    }

    public final void m12843a(final Context context, MomentsInviteXMAModel momentsInviteXMAModel, MomentsAppInvitationActionLinkFragmentModel momentsAppInvitationActionLinkFragmentModel, boolean z, @Nullable final PostbackCallback postbackCallback) {
        boolean a = m12844a(context);
        MomentsInviteLogger momentsInviteLogger = this.f12376d;
        String b = momentsAppInvitationActionLinkFragmentModel.b();
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("moments_invite_clicked");
        MomentsInviteLogger.m12753a(momentsInviteXMAModel, honeyClientEvent);
        honeyClientEvent.b("share_id", momentsInviteXMAModel.f);
        honeyClientEvent.a("invite_app_installed", a);
        honeyClientEvent.b("invite_click_target", z ? "photo" : "button");
        honeyClientEvent.b("invite_click_action", b);
        momentsInviteLogger.f12293a.a(honeyClientEvent);
        String g = a ? momentsAppInvitationActionLinkFragmentModel.g() : momentsAppInvitationActionLinkFragmentModel.aJ_();
        if (g != null) {
            momentsAppInvitationActionLinkFragmentModel.b();
            if (momentsAppInvitationActionLinkFragmentModel.a() == GraphQLMomentsAppMessengerInviteActionType.INSTALL) {
                this.f12374b.a(g, context.getApplicationContext());
                return;
            }
            Uri parse = Uri.parse(g);
            if (MomentsInviteWebViewActivity.m12848a(parse)) {
                Intent intent = new Intent(context, MomentsInviteWebViewActivity.class);
                intent.setData(parse);
                this.f12375c.a(intent, context);
            } else {
                this.f12374b.b(g, context.getApplicationContext());
            }
        }
        g = a ? momentsAppInvitationActionLinkFragmentModel.c() : momentsAppInvitationActionLinkFragmentModel.d();
        if (g != null) {
            momentsAppInvitationActionLinkFragmentModel.b();
            MomentsBotInvitePostbackInputData momentsBotInvitePostbackInputData = new MomentsBotInvitePostbackInputData();
            momentsBotInvitePostbackInputData.a("payload_json", g);
            final GraphQlQueryString momentsInviteActionPostbackMutationString = new MomentsInviteActionPostbackMutationString();
            momentsInviteActionPostbackMutationString.a("input", momentsBotInvitePostbackInputData);
            if (postbackCallback != null) {
                postbackCallback.mo464a();
            }
            this.f12377e.a(momentsAppInvitationActionLinkFragmentModel.b(), new Callable<ListenableFuture<GraphQLResult<MomentsInviteActionPostbackMutationModel>>>(this) {
                final /* synthetic */ MomentsLaunchHelper f12369b;

                public Object call() {
                    return this.f12369b.f12378f.a(GraphQLRequest.a(momentsInviteActionPostbackMutationString));
                }
            }, new AbstractDisposableFutureCallback<GraphQLResult<MomentsInviteActionPostbackMutationModel>>(this) {
                final /* synthetic */ MomentsLaunchHelper f12372c;

                protected final void m12840a(Object obj) {
                    String str = MomentsLaunchHelper.f12373a;
                    if (postbackCallback != null) {
                        postbackCallback.mo465b();
                    }
                }

                protected final void m12841a(Throwable th) {
                    if (NetworkException.class.isInstance(th)) {
                        String str = MomentsLaunchHelper.f12373a;
                        Toast.makeText(context, 2131241124, 0).show();
                    } else {
                        ((AbstractFbErrorReporter) this.f12372c.f12379g.get()).a(MomentsLaunchHelper.f12373a, "Postback unknown failure", th);
                        Toast.makeText(context, 2131241123, 0).show();
                    }
                    if (postbackCallback != null) {
                        postbackCallback.mo465b();
                    }
                }
            });
        }
    }
}
