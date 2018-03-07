package com.facebook.composer.publish;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.util.ExceptionUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.abtest.ExperimentsForComposerAbTestModule;
import com.facebook.composer.analytics.ComposerAnalyticsLogger;
import com.facebook.composer.analytics.ComposerAnalyticsLogger.Events;
import com.facebook.composer.lifeevent.protocol.ComposerLifeEventParam;
import com.facebook.composer.protocol.PostReviewParams;
import com.facebook.composer.publish.SentryWarningDialogController.C04801;
import com.facebook.composer.publish.SentryWarningDialogController.C04812;
import com.facebook.composer.publish.SentryWarningDialogController.C04823;
import com.facebook.composer.publish.SentryWarningDialogController.Delegate;
import com.facebook.composer.publish.cache.pendingstory.PendingStoryStore;
import com.facebook.composer.publish.common.EditPostParams;
import com.facebook.composer.publish.common.ErrorDetails;
import com.facebook.composer.publish.common.PostParamsWrapper;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.composer.publish.common.PublishPostParams.Builder;
import com.facebook.composer.publish.compost.store.CompostDraftStoryStore;
import com.facebook.composer.publish.compost.store.RecentlyUploadedStoryStore;
import com.facebook.composer.publish.optimistic.ComposerActivityBroadcaster;
import com.facebook.composer.publish.optimistic.ComposerActivityBroadcaster.Result;
import com.facebook.composer.publish.protocol.SimplePhotoUploadParams;
import com.facebook.compost.abtest.ExperimentsForCompostAbTestModule;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.funnellogger.PayloadBundle;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.http.protocol.ApiException;
import com.facebook.infer.annotation.Assertions;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.intent.notifications.INotificationRenderer;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.ipc.composer.model.ComposerType;
import com.facebook.katana.notification.impl.DefaultNotificationRenderer;
import com.facebook.notifications.logging.NotificationType;
import com.facebook.notifications.logging.NotificationsFunnelLogger;
import com.facebook.notifications.logging.NotificationsFunnelLoggingConstants.NotificationActionType;
import com.facebook.notifications.logging.NotificationsLogger$Component;
import com.facebook.notifications.logging.NotificationsLogger$NotificationLogObject;
import com.facebook.notifications.model.SystemTrayNotificationBuilder;
import com.facebook.notifications.util.SystemTrayNotificationManager;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.errordialog.ErrorMessageGenerator;
import com.facebook.ui.errordialog.ErrorMessageGenerator.SentryWarningDetails;
import com.facebook.ui.toaster.ToastThreadUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.json.JSONObject;

/* compiled from: picture_for_share_link */
public class ComposerPublishServiceHelper {
    PublishLogger f7980a = new C04701(this);
    private final ExecutorService f7981b;
    public final ComposerActivityBroadcaster f7982c;
    private final ObjectMapper f7983d;
    private final DefaultBlueServiceOperationFactory f7984e;
    public final ErrorMessageGenerator f7985f;
    public final ComposerAnalyticsLogger f7986g;
    public final DefaultNotificationRenderer f7987h;
    private final AbstractFbErrorReporter f7988i;
    public final ToastThreadUtil f7989j;
    private final ViewerContextManager f7990k;
    public final PendingStoryStore f7991l;
    public final Lazy<RecentlyUploadedStoryStore> f7992m;
    public final Lazy<CompostDraftStoryStore> f7993n;
    public final PostFailureDialogControllerProvider f7994o;
    public final QeAccessor f7995p;
    public final SentryWarningDialogControllerProvider f7996q;
    public final NotificationsFunnelLogger f7997r;
    public Context f7998s;

    /* compiled from: picture_for_share_link */
    public interface PublishLogger {
        void mo922a(PublishPostParams publishPostParams);

        void mo923a(String str, PublishPostParams publishPostParams);

        void mo924a(String str, PublishPostParams publishPostParams, ServiceException serviceException);

        void mo925b(PublishPostParams publishPostParams);
    }

    /* compiled from: picture_for_share_link */
    class C04701 implements PublishLogger {
        final /* synthetic */ ComposerPublishServiceHelper f7958a;

        C04701(ComposerPublishServiceHelper composerPublishServiceHelper) {
            this.f7958a = composerPublishServiceHelper;
        }

        public final void mo922a(PublishPostParams publishPostParams) {
            this.f7958a.f7986g.m11143a(Events.COMPOSER_PUBLISH_START, publishPostParams.composerSessionId);
        }

        public final void mo925b(PublishPostParams publishPostParams) {
            this.f7958a.f7986g.m11154a(publishPostParams.composerSessionId, publishPostParams.d());
        }

        public final void mo923a(String str, PublishPostParams publishPostParams) {
            this.f7958a.f7986g.m11152a(publishPostParams.composerSessionId, publishPostParams.composerType, this.f7958a.m11544a((Object) publishPostParams), str, publishPostParams.c());
        }

        public final void mo924a(String str, PublishPostParams publishPostParams, ServiceException serviceException) {
            String str2 = str;
            this.f7958a.f7986g.m11153a(publishPostParams.composerSessionId, publishPostParams.composerType, this.f7958a.m11544a((Object) publishPostParams), str2, this.f7958a.f7985f.a(serviceException, true, true), serviceException, publishPostParams.c());
        }
    }

    public static ComposerPublishServiceHelper m11547b(InjectorLike injectorLike) {
        return new ComposerPublishServiceHelper((Context) injectorLike.getInstance(Context.class), ComposerActivityBroadcaster.m11633a(injectorLike), DefaultBlueServiceOperationFactory.a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), ErrorMessageGenerator.a(injectorLike), ComposerAnalyticsLogger.m11140a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), DefaultNotificationRenderer.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), ToastThreadUtil.a(injectorLike), ViewerContextManagerProvider.a(injectorLike), PendingStoryStore.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 5274), IdBasedSingletonScopeProvider.b(injectorLike, 5273), (PostFailureDialogControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PostFailureDialogControllerProvider.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (SentryWarningDialogControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SentryWarningDialogControllerProvider.class), NotificationsFunnelLogger.a(injectorLike));
    }

    public static ComposerPublishServiceHelper m11534a(InjectorLike injectorLike) {
        return m11547b(injectorLike);
    }

    @Inject
    public ComposerPublishServiceHelper(Context context, ComposerActivityBroadcaster composerActivityBroadcaster, BlueServiceOperationFactory blueServiceOperationFactory, ExecutorService executorService, ErrorMessageGenerator errorMessageGenerator, ComposerAnalyticsLogger composerAnalyticsLogger, ObjectMapper objectMapper, INotificationRenderer iNotificationRenderer, FbErrorReporter fbErrorReporter, ToastThreadUtil toastThreadUtil, ViewerContextManager viewerContextManager, PendingStoryStore pendingStoryStore, Lazy<RecentlyUploadedStoryStore> lazy, Lazy<CompostDraftStoryStore> lazy2, PostFailureDialogControllerProvider postFailureDialogControllerProvider, QeAccessor qeAccessor, SentryWarningDialogControllerProvider sentryWarningDialogControllerProvider, NotificationsFunnelLogger notificationsFunnelLogger) {
        this.f7998s = context;
        this.f7982c = composerActivityBroadcaster;
        this.f7984e = blueServiceOperationFactory;
        this.f7981b = executorService;
        this.f7985f = errorMessageGenerator;
        this.f7986g = composerAnalyticsLogger;
        this.f7983d = objectMapper;
        this.f7987h = iNotificationRenderer;
        this.f7988i = fbErrorReporter;
        this.f7989j = toastThreadUtil;
        this.f7990k = viewerContextManager;
        this.f7991l = pendingStoryStore;
        this.f7992m = lazy;
        this.f7993n = lazy2;
        this.f7994o = postFailureDialogControllerProvider;
        this.f7995p = qeAccessor;
        this.f7996q = sentryWarningDialogControllerProvider;
        this.f7997r = notificationsFunnelLogger;
    }

    public final void m11570a(Context context) {
        this.f7998s = context;
    }

    public final ListenableFuture<OperationResult> m11566a(Intent intent) {
        PostParamsWrapper postParamsWrapper;
        PublishPostParams publishPostParams = (PublishPostParams) intent.getParcelableExtra("publishPostParams");
        EditPostParams editPostParams = (EditPostParams) intent.getParcelableExtra("publishEditPostParamsKey");
        if (publishPostParams != null) {
            Preconditions.checkArgument(editPostParams == null);
            postParamsWrapper = new PostParamsWrapper(publishPostParams);
        } else {
            postParamsWrapper = new PostParamsWrapper((EditPostParams) Preconditions.checkNotNull(editPostParams));
        }
        intent.putExtra("suppress_failure_notification", true);
        ListenableFuture c = m11572c(intent);
        m11545a(c, postParamsWrapper);
        return c;
    }

    public final void m11571b(Intent intent) {
        GraphQLStory graphQLStory = (GraphQLStory) intent.getParcelableExtra("extra_optimistic_feed_story");
        PublishPostParams publishPostParams = (PublishPostParams) intent.getParcelableExtra("publishPostParams");
        if (graphQLStory != null) {
            this.f7991l.a(publishPostParams, graphQLStory);
            this.f7991l.c(publishPostParams.composerSessionId);
            this.f7982c.m11635a(new PostParamsWrapper(publishPostParams), graphQLStory);
        }
    }

    public final ListenableFuture<OperationResult> m11572c(Intent intent) {
        return m11567a(intent, this.f7980a);
    }

    public final ListenableFuture<OperationResult> m11567a(final Intent intent, final PublishLogger publishLogger) {
        if ((!intent.hasExtra("publishEditPostParamsKey") && !intent.hasExtra("publishPostParams")) || (intent.hasExtra("publishEditPostParamsKey") && intent.hasExtra("publishPostParams"))) {
            throw new RuntimeException("publish func must contains publish post/edit post params key.");
        } else if (intent.getBooleanExtra("is_uploading_media", false)) {
            m11555e(intent);
            return Futures.a(null);
        } else if (intent.hasExtra("publishEditPostParamsKey")) {
            return m11541a((EditPostParams) intent.getParcelableExtra("publishEditPostParamsKey"), (GraphQLStory) intent.getParcelableExtra("extra_optimistic_feed_story"));
        } else {
            final PublishPostParams publishPostParams = (PublishPostParams) intent.getParcelableExtra("publishPostParams");
            Preconditions.checkNotNull(publishPostParams);
            publishLogger.mo922a(publishPostParams);
            if (publishPostParams.a() > 0) {
                publishLogger.mo925b(publishPostParams);
            }
            C04712 c04712 = new Object(this) {
                final /* synthetic */ ComposerPublishServiceHelper f7962d;

                public final void m11521a() {
                    Builder builder = new Builder(publishPostParams);
                    builder.aj = true;
                    intent.putExtra("publishPostParams", builder.a());
                    this.f7962d.m11567a(intent, publishLogger);
                }

                public final void m11522b() {
                    if (intent.hasExtra("extra_optimistic_feed_story")) {
                        ComposerActivityBroadcaster composerActivityBroadcaster = this.f7962d.f7982c;
                        Result result = Result.CANCELLED;
                        String str = publishPostParams.composerSessionId;
                        long j = publishPostParams.targetId;
                        ErrorDetails.Builder builder = new ErrorDetails.Builder();
                        builder.a = false;
                        composerActivityBroadcaster.m11636a(result, null, null, str, j, builder.a());
                        this.f7962d.f7991l.a(publishPostParams.composerSessionId);
                    }
                }
            };
            if (publishPostParams.shareable != null) {
                return m11538a(intent, publishPostParams, publishLogger, c04712);
            }
            if (intent.hasExtra("simplePhotoUploadParams")) {
                return m11550b(intent, publishPostParams, publishLogger);
            }
            return m11551b(intent, publishPostParams, publishLogger, c04712);
        }
    }

    private void m11555e(Intent intent) {
        GraphQLStory graphQLStory = (GraphQLStory) intent.getParcelableExtra("extra_optimistic_feed_story");
        if (graphQLStory != null) {
            PostParamsWrapper postParamsWrapper;
            if (intent.hasExtra("publishEditPostParamsKey")) {
                postParamsWrapper = new PostParamsWrapper((EditPostParams) intent.getParcelableExtra("publishEditPostParamsKey"));
            } else {
                postParamsWrapper = new PostParamsWrapper((PublishPostParams) intent.getParcelableExtra("publishPostParams"));
            }
            this.f7991l.a(postParamsWrapper, graphQLStory);
            this.f7991l.c(postParamsWrapper.a());
            this.f7982c.m11635a(postParamsWrapper, graphQLStory);
        }
    }

    public final ListenableFuture<OperationResult> m11573d(Intent intent) {
        final Object obj = (ComposerLifeEventParam) intent.getParcelableExtra("publishLifeEventParams");
        Preconditions.checkNotNull(obj);
        this.f7986g.m11143a(Events.COMPOSER_PUBLISH_START, obj.composerSessionId);
        Bundle bundle = new Bundle();
        bundle.putParcelable("publishLifeEventParams", obj);
        OperationFuture c = BlueServiceOperationFactoryDetour.a(this.f7984e, "publish_life_event", bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(ComposerPublishServiceHelper.class), -2017661666).c();
        final String a = m11544a(obj);
        Futures.a(c, new OperationResultFutureCallback(this) {
            final /* synthetic */ ComposerPublishServiceHelper f7965c;

            protected final void m11523a(ServiceException serviceException) {
                String a = this.f7965c.f7985f.a(serviceException, true, true);
                this.f7965c.f7989j.a(a);
                this.f7965c.f7986g.m11153a(obj.composerSessionId, ComposerType.LIFE_EVENT, a, "publish_life_event", a, serviceException, 0);
            }

            public final void m11524a(Object obj) {
                this.f7965c.f7986g.m11152a(obj.composerSessionId, ComposerType.LIFE_EVENT, a, "publish_life_event", 0);
            }
        }, this.f7981b);
        return c;
    }

    private ListenableFuture<OperationResult> m11538a(Intent intent, PublishPostParams publishPostParams, PublishLogger publishLogger, Delegate delegate) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("publishPostParams", publishPostParams);
        bundle.putParcelable("overridden_viewer_context", this.f7990k.a());
        if (((GraphQLStory) intent.getParcelableExtra("extra_optimistic_feed_story")) != null) {
            bundle.putBoolean("suppress_failure_notification", true);
        } else {
            bundle.putBoolean("suppress_failure_notification", intent.getBooleanExtra("suppress_failure_notification", false));
        }
        return m11542a((GraphQLStory) intent.getParcelableExtra("extra_optimistic_feed_story"), new PostParamsWrapper(publishPostParams), m11540a(bundle, "publish_share", m11556f(intent), publishLogger, delegate));
    }

    private ListenableFuture<OperationResult> m11551b(Intent intent, PublishPostParams publishPostParams, PublishLogger publishLogger, Delegate delegate) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("publishPostParams", publishPostParams);
        if (intent.hasExtra("extra_actor_viewer_context")) {
            bundle.putParcelable("overridden_viewer_context", intent.getParcelableExtra("extra_actor_viewer_context"));
        }
        GraphQLStory graphQLStory = (GraphQLStory) intent.getParcelableExtra("extra_optimistic_feed_story");
        if (graphQLStory != null || publishPostParams.isBackoutDraft) {
            bundle.putBoolean("suppress_failure_notification", true);
        } else {
            bundle.putBoolean("suppress_failure_notification", intent.getBooleanExtra("suppress_failure_notification", false));
        }
        return m11542a(graphQLStory, new PostParamsWrapper(publishPostParams), m11540a(bundle, "publish_post", m11556f(intent), publishLogger, delegate));
    }

    private ListenableFuture<OperationResult> m11550b(Intent intent, PublishPostParams publishPostParams, PublishLogger publishLogger) {
        SimplePhotoUploadParams simplePhotoUploadParams = (SimplePhotoUploadParams) intent.getParcelableExtra("simplePhotoUploadParams");
        Preconditions.checkNotNull(simplePhotoUploadParams);
        Bundle bundle = new Bundle();
        bundle.putParcelable("publishPostParams", publishPostParams);
        bundle.putParcelable("simplePhotoUploadParams", simplePhotoUploadParams);
        return m11539a(bundle, "publish_photo", m11556f(intent), publishLogger);
    }

    @VisibleForTesting
    private ListenableFuture<OperationResult> m11542a(GraphQLStory graphQLStory, PostParamsWrapper postParamsWrapper, ListenableFuture<OperationResult> listenableFuture) {
        if (graphQLStory != null) {
            this.f7991l.a(postParamsWrapper, graphQLStory);
            this.f7991l.c(postParamsWrapper.a());
            this.f7982c.m11635a(postParamsWrapper, graphQLStory);
        }
        m11545a((ListenableFuture) listenableFuture, postParamsWrapper);
        return listenableFuture;
    }

    private void m11545a(ListenableFuture<OperationResult> listenableFuture, final PostParamsWrapper postParamsWrapper) {
        Futures.a(listenableFuture, new OperationResultFutureCallback(this) {
            final /* synthetic */ ComposerPublishServiceHelper f7967b;

            public final void m11526a(Object obj) {
                OperationResult operationResult = (OperationResult) obj;
                this.f7967b.f7991l.b(postParamsWrapper.a());
                GraphQLStory graphQLStory = (GraphQLStory) operationResult.h();
                if (this.f7967b.f7986g) {
                    ((CompostDraftStoryStore) this.f7967b.f7993n.get()).mo928a(postParamsWrapper.a());
                    if (graphQLStory != null) {
                        ((RecentlyUploadedStoryStore) this.f7967b.f7992m.get()).m11610a(graphQLStory);
                    }
                }
                ComposerActivityBroadcaster composerActivityBroadcaster = this.f7967b.f7982c;
                Result result = Result.SUCCESS;
                String nullToEmpty = Strings.nullToEmpty(graphQLStory.ai());
                String a = postParamsWrapper.a();
                long d = postParamsWrapper.d();
                ErrorDetails.Builder builder = new ErrorDetails.Builder();
                builder.a = false;
                composerActivityBroadcaster.m11636a(result, nullToEmpty, graphQLStory, a, d, builder.a());
            }

            protected final void m11525a(ServiceException serviceException) {
                this.f7967b.f7982c.m11636a(Result.EXCEPTION, null, null, postParamsWrapper.a(), postParamsWrapper.d(), this.f7967b.m11537a(serviceException, postParamsWrapper.a()));
            }
        }, this.f7981b);
    }

    public static boolean m11546a(ComposerPublishServiceHelper composerPublishServiceHelper) {
        return composerPublishServiceHelper.f7995p.a(ExperimentsForCompostAbTestModule.f8107z, false);
    }

    private ErrorDetails m11537a(ServiceException serviceException, String str) {
        try {
            return m11548b(serviceException, str);
        } catch (Exception e) {
            return new ErrorDetails.Builder().a(true).a();
        }
    }

    private ErrorDetails m11536a(ServiceException serviceException) {
        Optional of;
        Optional optional;
        ErrorDetails.Builder builder;
        ErrorDetails.Builder a;
        if (serviceException.getCause() instanceof ApiException) {
            ApiException apiException = (ApiException) serviceException.getCause();
            if (!(apiException.b() == null || apiException.b().mJsonResponse == null)) {
                JSONObject jSONObject = new JSONObject(apiException.b().mJsonResponse);
                if (jSONObject.has("error")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("error");
                    if (jSONObject2.has("allow_user_retry") && jSONObject2.getBoolean("allow_user_retry")) {
                        of = Optional.of(new SentryWarningDetails(jSONObject2.getString("error_user_title"), jSONObject2.getString("error_user_msg")));
                        optional = of;
                        if (optional.isPresent()) {
                            String a2 = this.f7985f.a(serviceException, true, true);
                            ApiErrorResult c = ErrorMessageGenerator.c(serviceException);
                            builder = new ErrorDetails.Builder();
                            builder.a = false;
                            a = builder.a(a2);
                            a.c = "SentryBlock";
                            a = a;
                            a.d = c.a();
                            return a.a();
                        }
                        a = new ErrorDetails.Builder();
                        a.f = true;
                        builder = a;
                        builder.g = ((SentryWarningDetails) optional.get()).a;
                        return builder.a(((SentryWarningDetails) optional.get()).b).a();
                    }
                }
            }
        }
        of = Absent.INSTANCE;
        optional = of;
        if (optional.isPresent()) {
            String a22 = this.f7985f.a(serviceException, true, true);
            ApiErrorResult c2 = ErrorMessageGenerator.c(serviceException);
            builder = new ErrorDetails.Builder();
            builder.a = false;
            a = builder.a(a22);
            a.c = "SentryBlock";
            a = a;
            a.d = c2.a();
            return a.a();
        }
        a = new ErrorDetails.Builder();
        a.f = true;
        builder = a;
        builder.g = ((SentryWarningDetails) optional.get()).a;
        return builder.a(((SentryWarningDetails) optional.get()).b).a();
    }

    private ErrorDetails m11548b(ServiceException serviceException, String str) {
        if (this.f7985f.b(serviceException)) {
            return m11536a(serviceException);
        }
        ApiException apiException = (ApiException) ExceptionUtil.b(serviceException, ApiException.class);
        ApiErrorResult b = apiException.b();
        Object d = apiException.d();
        Object c = b.c();
        int a = b.a();
        int i = b.mErrorSubCode;
        boolean z = b.mIsTransient;
        if (!z && !StringUtil.c(d) && StringUtil.c(c) && a == 0 && i == 0) {
            this.f7988i.a("composer_publish_partial_error_result", "session_id: " + str + ", exception_msg: " + serviceException.result.d.getString("originalExceptionMessage"));
        }
        ErrorDetails.Builder builder = new ErrorDetails.Builder();
        builder.a = z;
        ErrorDetails.Builder a2 = builder.a(d);
        a2.c = c;
        a2 = a2;
        a2.d = a;
        a2 = a2;
        a2.e = i;
        return a2.a();
    }

    private ListenableFuture<OperationResult> m11539a(Bundle bundle, String str, Intent intent, PublishLogger publishLogger) {
        return m11540a(bundle, str, intent, publishLogger, null);
    }

    private ListenableFuture<OperationResult> m11540a(Bundle bundle, String str, Intent intent, PublishLogger publishLogger, @Nullable Delegate delegate) {
        OperationFuture c = BlueServiceOperationFactoryDetour.a(this.f7984e, str, bundle, 353865227).c();
        final PublishPostParams publishPostParams = (PublishPostParams) bundle.getParcelable("publishPostParams");
        publishPostParams.a(publishPostParams.a() + 1);
        final boolean z = publishPostParams.composerType == ComposerType.SHARE;
        final C04712 c04712 = delegate;
        final Bundle bundle2 = bundle;
        final Intent intent2 = intent;
        final PublishLogger publishLogger2 = publishLogger;
        final String str2 = str;
        Futures.a(c, new OperationResultFutureCallback(this) {
            final /* synthetic */ ComposerPublishServiceHelper f7975h;

            protected final void m11527a(ServiceException serviceException) {
                ErrorDetails a = this.f7975h.m11537a(serviceException, publishPostParams.composerSessionId);
                if (a.isSentryWarningWithUserConfirmationRequired) {
                    Assertions.a(publishPostParams.canHandleSentryWarning);
                    Assertions.b(c04712);
                    InjectorLike injectorLike = this.f7975h.f7996q;
                    SentryWarningDialogController sentryWarningDialogController = new SentryWarningDialogController(this.f7975h.f7998s, Handler_ForUiThreadMethodAutoProvider.b(injectorLike), ComposerAnalyticsLogger.m11140a(injectorLike));
                    CharSequence charSequence = a.userTitle;
                    CharSequence charSequence2 = a.userMessage;
                    C04712 c04712 = c04712;
                    sentryWarningDialogController.f8022c.m11142a(Events.MEME_BUSTING_SENTRY_WARNING_RECEIVED);
                    HandlerDetour.a(sentryWarningDialogController.f8021b, new C04823(sentryWarningDialogController, new AlertDialog.Builder(sentryWarningDialogController.f8020a).a(charSequence).b(charSequence2).a(sentryWarningDialogController.f8020a.getString(2131230730), new C04812(sentryWarningDialogController, c04712)).b(sentryWarningDialogController.f8020a.getString(2131230727), new C04801(sentryWarningDialogController, c04712))), -123765377);
                    return;
                }
                boolean z = bundle2.getBoolean("suppress_failure_notification", false);
                String a2 = this.f7975h.f7985f.a(serviceException, true, true);
                publishPostParams.a(a);
                if (!a.isRetriable) {
                    this.f7975h.f7994o.m11575a(publishPostParams.composerSessionId).m11574a();
                } else if (!z || z || serviceException.errorCode != ErrorCode.CONNECTION_FAILURE) {
                    if (z && serviceException.errorCode == ErrorCode.CONNECTION_FAILURE) {
                        this.f7975h.f7989j.a(this.f7975h.f7998s.getString(2131234586));
                    } else {
                        this.f7975h.f7989j.a(a2);
                    }
                    if (!(intent2 == null || this.f7975h.f7987h == null || z)) {
                        DefaultNotificationRenderer defaultNotificationRenderer = this.f7975h.f7987h;
                        Intent intent = intent2;
                        SystemTrayNotificationBuilder a3 = ((SystemTrayNotificationBuilder) defaultNotificationRenderer.c.get()).a(defaultNotificationRenderer.a.getResources().getString(2131242543)).c(defaultNotificationRenderer.a.getResources().getString(2131242545)).d(defaultNotificationRenderer.a.getResources().getString(2131242544)).a(2130843529).a(System.currentTimeMillis());
                        NotificationsLogger$NotificationLogObject notificationsLogger$NotificationLogObject = new NotificationsLogger$NotificationLogObject();
                        notificationsLogger$NotificationLogObject.f12170b = NotificationType.ERROR_CLIENT_NOTIFICATION;
                        Intent intent2 = intent;
                        ((SystemTrayNotificationManager) defaultNotificationRenderer.b.get()).a(NotificationType.POST_FAILED, a3, intent2, NotificationsLogger$Component.SERVICE, notificationsLogger$NotificationLogObject);
                    }
                    publishLogger2.mo924a(str2, publishPostParams, serviceException);
                }
            }

            public final void m11528a(Object obj) {
                if (z && !ComposerSourceType.PAGE.toString().equals(publishPostParams.sourceType)) {
                    int i = 2131234522;
                    if (publishPostParams.isBackoutDraft) {
                        i = 2131234775;
                    }
                    this.f7975h.f7989j.a(this.f7975h.f7998s.getString(i));
                    NotificationsFunnelLogger notificationsFunnelLogger = this.f7975h.f7997r;
                    notificationsFunnelLogger.a.a(FunnelRegistry.Q, NotificationActionType.SHARE.name(), null, PayloadBundle.a().a("composer_session_id", publishPostParams.composerSessionId));
                } else if (publishPostParams.isBackoutDraft) {
                    this.f7975h.f7989j.a(this.f7975h.f7995p.a(ExperimentsForComposerAbTestModule.j, 2131234775, this.f7975h.f7998s.getResources()));
                } else {
                    this.f7975h.f7997r.b(publishPostParams.composerSessionId);
                }
                publishLogger2.mo923a(str2, publishPostParams);
            }
        }, this.f7981b);
        return c;
    }

    private String m11544a(Object obj) {
        try {
            return this.f7983d.a(obj);
        } catch (JsonProcessingException e) {
            this.f7988i.a("composer_publish_params_json_failed", e);
            return "";
        }
    }

    private Intent m11556f(Intent intent) {
        return new Intent(this.f7998s, ComposerPublishService.class).putExtra("publishPostParams", (PublishPostParams) intent.getParcelableExtra("publishPostParams"));
    }

    public final ListenableFuture<OperationResult> m11568a(Bundle bundle, String str) {
        return m11539a(bundle, str, null, this.f7980a);
    }

    @VisibleForTesting
    private ListenableFuture<OperationResult> m11541a(final EditPostParams editPostParams, GraphQLStory graphQLStory) {
        Preconditions.checkNotNull(editPostParams);
        Bundle bundle = new Bundle();
        bundle.putParcelable("publishEditPostParamsKey", editPostParams);
        ListenableFuture a = BlueServiceOperationFactoryDetour.a(this.f7984e, "publish_edit_post", bundle, 977157032).a();
        Futures.a(a, new OperationResultFutureCallback(this) {
            final /* synthetic */ ComposerPublishServiceHelper f7977b;

            protected final void m11529a(ServiceException serviceException) {
                String a = this.f7977b.f7985f.a(serviceException, true, true);
                this.f7977b.f7989j.a(a);
                this.f7977b.f7986g.m11153a(editPostParams.composerSessionId, ComposerType.STATUS, "{}", "publish_edit_post", a, serviceException, 0);
            }

            public final void m11530a(Object obj) {
                this.f7977b.f7986g.m11152a(editPostParams.composerSessionId, ComposerType.STATUS, "{}", "publish_edit_post", 0);
            }
        }, this.f7981b);
        return m11542a(graphQLStory, new PostParamsWrapper(editPostParams), a);
    }

    public final ListenableFuture<OperationResult> m11569a(final PostReviewParams postReviewParams, @Nullable ViewerContext viewerContext) {
        Preconditions.checkNotNull(postReviewParams);
        Bundle bundle = new Bundle();
        bundle.putParcelable("publishReviewParams", postReviewParams);
        if (viewerContext != null) {
            bundle.putParcelable("overridden_viewer_context", viewerContext);
        }
        OperationFuture a = BlueServiceOperationFactoryDetour.a(this.f7984e, "publish_review", bundle, 675846124).a();
        if (!Strings.isNullOrEmpty(postReviewParams.f7933a)) {
            Futures.a(a, new OperationResultFutureCallback(this) {
                final /* synthetic */ ComposerPublishServiceHelper f7979b;

                protected final void m11531a(ServiceException serviceException) {
                    this.f7979b.f7986g.m11153a(postReviewParams.f7933a, ComposerType.RECOMMENDATION, "{}", "publish_review", this.f7979b.f7985f.a(serviceException, true, true), serviceException, 0);
                }

                public final void m11532a(Object obj) {
                    this.f7979b.f7986g.m11152a(postReviewParams.f7933a, ComposerType.RECOMMENDATION, "{}", "publish_review", 0);
                }
            }, this.f7981b);
        }
        return a;
    }
}
