package com.facebook.composer.shareintent.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RecentTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.DialogFragment;
import android.util.Patterns;
import com.facebook.api.story.FetchSingleStoryParams;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.android.ActivityManagerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.DisposableFutureCallback;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.uri.FbUriResolver;
import com.facebook.common.util.CollectionUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.abtest.ExperimentsForComposerAbTestModule;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.composer.analytics.ComposerPerformanceLogger;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.composer.shareintent.util.UserDraftComposerPlugin.Factory;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.feed.protocol.FetchGraphQLStoryMethod;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.GraphQLWithTagsConnection;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.intent.thirdparty.NativeThirdPartyUriHelper;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.intent.DefaultPluginConfigSerializer;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerLocationInfo;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.ipc.composer.model.ComposerTaggedUser;
import com.facebook.ipc.composer.model.ComposerType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.media.MediaItemFactory;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.platform.analytics.PlatformAnalyticsLogger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManager;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.dialogs.ProgressDialogFragment;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.regex.Matcher;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: platform_get_app_permissions */
public abstract class AbstractShareIntentHandler extends FbFragmentActivity {
    @Inject
    FetchGraphQLStoryMethod f9686A;
    @Inject
    GraphQLQueryExecutor f9687B;
    @Inject
    QeAccessor f9688C;
    @Inject
    PlatformAnalyticsLogger f9689D;
    @Inject
    MonotonicClock f9690E;
    private boolean f9691F;
    public long f9692G;
    public ActivityRuntimePermissionsManager f9693H;
    private Runnable f9694I;
    @Inject
    ActivityManager f9695p;
    @Inject
    Toaster f9696q;
    @Inject
    public ComposerPerformanceLogger f9697r;
    @DefaultExecutorService
    @Inject
    public ListeningExecutorService f9698s;
    @Inject
    @ForUiThread
    Executor f9699t;
    @Inject
    TasksManager f9700u;
    @Inject
    AbstractFbErrorReporter f9701v;
    @Inject
    public FbUriResolver f9702w;
    @Inject
    MediaItemFactory f9703x;
    @Inject
    ComposerLauncher f9704y;
    @Inject
    public ActivityRuntimePermissionsManagerProvider f9705z;

    public static void m14696a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((AbstractShareIntentHandler) obj).m14695a(ActivityManagerMethodAutoProvider.m2390a(injectorLike), Toaster.m6449a(injectorLike), ComposerPerformanceLogger.m14909a(injectorLike), C0055x2995691a.m1881a(injectorLike), ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.m1951a(injectorLike), TasksManager.m14546a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), FbUriResolver.a(injectorLike), MediaItemFactory.m19663a(injectorLike), ComposerLauncherImpl.m14892a(injectorLike), (ActivityRuntimePermissionsManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class), FetchGraphQLStoryMethod.a(injectorLike), GraphQLQueryExecutor.m10435a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), PlatformAnalyticsLogger.a(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike));
    }

    public abstract String mo1943i();

    protected abstract void mo797j();

    private void m14695a(ActivityManager activityManager, Toaster toaster, ComposerPerformanceLogger composerPerformanceLogger, ListeningExecutorService listeningExecutorService, Executor executor, TasksManager tasksManager, AbstractFbErrorReporter abstractFbErrorReporter, FbUriResolver fbUriResolver, MediaItemFactory mediaItemFactory, ComposerLauncher composerLauncher, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider, FetchGraphQLStoryMethod fetchGraphQLStoryMethod, GraphQLQueryExecutor graphQLQueryExecutor, QeAccessor qeAccessor, PlatformAnalyticsLogger platformAnalyticsLogger, MonotonicClock monotonicClock) {
        this.f9695p = activityManager;
        this.f9696q = toaster;
        this.f9697r = composerPerformanceLogger;
        this.f9698s = listeningExecutorService;
        this.f9699t = executor;
        this.f9700u = tasksManager;
        this.f9701v = abstractFbErrorReporter;
        this.f9702w = fbUriResolver;
        this.f9703x = mediaItemFactory;
        this.f9704y = composerLauncher;
        this.f9705z = activityRuntimePermissionsManagerProvider;
        this.f9686A = fetchGraphQLStoryMethod;
        this.f9687B = graphQLQueryExecutor;
        this.f9688C = qeAccessor;
        this.f9689D = platformAnalyticsLogger;
        this.f9690E = monotonicClock;
    }

    protected final void hy_() {
        mo1944k();
        this.f9692G = this.f9690E.now();
    }

    protected void mo790b(Bundle bundle) {
        ListenableFuture listenableFuture;
        super.mo790b(bundle);
        1 1 = new 1(this);
        Intent intent = getIntent();
        if (m14712j(intent)) {
            this.f9693H = this.f9705z.a(this);
            String[] strArr = new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
            SettableFuture f = SettableFuture.m1547f();
            this.f9693H.a(strArr, new 3(this, f));
            listenableFuture = f;
        } else if (m14709g(intent) || m14699f(intent)) {
            listenableFuture = Futures.m2452a(null);
        } else {
            m14714k(intent);
            listenableFuture = Futures.m2453a(new UnsupportedOperationException());
        }
        Futures.m2458a(listenableFuture, new 2(this, 1), this.f9699t);
    }

    protected void onPostResume() {
        super.onPostResume();
        this.f9691F = false;
        Runnable runnable = this.f9694I;
        this.f9694I = null;
        m14704a(runnable);
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1661117895);
        this.f9691F = true;
        super.onPause();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1959380622, a);
    }

    protected void onStop() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -2005463461);
        super.onStop();
        if (this.f9700u != null) {
            this.f9700u.m14560c();
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1971185320, a);
    }

    protected void mo1944k() {
        Class cls = AbstractShareIntentHandler.class;
        m14696a((Object) this, (Context) this);
    }

    protected final void m14704a(Runnable runnable) {
        if (runnable != null && !isFinishing()) {
            if (this.f9691F) {
                this.f9694I = runnable;
            } else {
                runnable.run();
            }
        }
    }

    public static String m14697b(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = Patterns.WEB_URL.matcher(str);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    private static ComposerTargetData m14702q() {
        return ComposerTargetData.a;
    }

    protected final void m14705b(Intent intent) {
        boolean z;
        String type = intent.getType();
        String action = intent.getAction();
        Parcelable parcelableExtra;
        if (type != null && type.startsWith("image/") && "android.intent.action.SEND".equals(action)) {
            parcelableExtra = intent.getParcelableExtra("android.intent.extra.STREAM");
            if ((parcelableExtra instanceof Uri) && FbUriResolver.a((Uri) parcelableExtra)) {
                z = true;
            }
            z = false;
        } else if ("android.intent.action.SEND_MULTIPLE".equals(action)) {
            if (intent.getParcelableArrayListExtra("android.intent.extra.STREAM") != null) {
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("android.intent.extra.STREAM");
                int size = parcelableArrayListExtra.size();
                for (int i = 0; i < size; i++) {
                    parcelableExtra = (Parcelable) parcelableArrayListExtra.get(i);
                    if ((parcelableExtra instanceof Uri) && FbUriResolver.a((Uri) parcelableExtra)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
        } else {
            if (intent.getBooleanExtra("is_draft", false)) {
                z = true;
            }
            z = false;
        }
        if (z) {
            DialogFragment a = ProgressDialogFragment.a(2131234609, true, false, true);
            a.m213a(kO_(), null);
            this.f9700u.m14553a((Object) "any", this.f9698s.mo271a(new 5(this, intent, 1756)), (DisposableFutureCallback) new 6(this, a));
            return;
        }
        Runnable a2 = mo1942a(intent, 1756);
        if (a2 != null) {
            m14704a(a2);
        }
    }

    @Nullable
    protected Runnable mo1942a(Intent intent, int i) {
        this.f9697r.f9873c.mo395e(917509, "ComposerLaunchTTIExternalShare");
        String type = intent.getType();
        if ((type == null || "*/*".equals(type)) && !m14715n()) {
            this.f9696q.m6456b(new ToastBuilder(2131234540));
            finish();
            return null;
        }
        ComposerConfiguration d;
        if (intent.getBooleanExtra("is_draft", false)) {
            d = m14698d(intent.getStringExtra("story_id"));
        } else {
            d = m14707d(intent);
        }
        if (d != null) {
            return new 4(this, d, i);
        }
        return null;
    }

    @Nullable
    protected final ComposerConfiguration m14707d(Intent intent) {
        Builder builder;
        Builder allowTargetSelection = ComposerConfigurationFactory.m26256a(ComposerSourceSurface.THIRD_PARTY_APP_VIA_INTENT, "textPostFromThirdParty").setInitialTargetData(ComposerTargetData.a).setAllowTargetSelection(true);
        if (m14709g(intent)) {
            CharSequence b = m14697b(intent.getStringExtra("android.intent.extra.TEXT"));
            if (!StringUtil.m3599c(b)) {
                allowTargetSelection = ComposerConfigurationFactory.m26261a(ComposerSourceType.EXTERNAL, ComposerShareParams.Builder.a(b).b()).setInitialTargetData(ComposerTargetData.a).setAllowTargetSelection(true);
            }
        } else if (m14712j(intent)) {
            ImmutableList e = m14708e(intent);
            int i = 0;
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("extra_composer_moments_object_uuids");
            if (CollectionUtil.m29343b(stringArrayListExtra)) {
                boolean z;
                if (e.size() == stringArrayListExtra.size()) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkArgument(z);
                while (i < stringArrayListExtra.size()) {
                    if (((ComposerAttachment) e.get(i)).b() != null) {
                        ((ComposerAttachment) e.get(i)).b().f = (String) stringArrayListExtra.get(i);
                    }
                    i++;
                }
            }
            allowTargetSelection = ComposerConfigurationFactory.m26256a(ComposerSourceSurface.THIRD_PARTY_APP_VIA_INTENT, "mediaPostFromThirdParty").setInitialTargetData(ComposerTargetData.a).setInitialAttachments(e).setAllowTargetSelection(true);
        } else {
            m14714k(intent);
            allowTargetSelection = null;
            builder = allowTargetSelection;
            return builder == null ? builder.a() : null;
        }
        allowTargetSelection.setExternalRefName(m14716o()).setAllowsRedSpaceToggle(true).setReactionSurface(Surface.ANDROID_EXTERNAL_COMPOSER);
        builder = allowTargetSelection;
        if (builder == null) {
        }
    }

    @Nullable
    private ComposerConfiguration m14698d(String str) {
        int i = 0;
        this.f9689D.e(str);
        try {
            GraphQLResult graphQLResult = (GraphQLResult) FutureDetour.a(this.f9687B.m10446a(this.f9686A.a(new FetchSingleStoryParams(str, DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE))), -1487096757);
            if (graphQLResult == null) {
                return null;
            }
            GraphQLStory graphQLStory = (GraphQLStory) graphQLResult.m10400d();
            if (graphQLStory == null) {
                return null;
            }
            GraphQLTextWithEntities b = StoryHierarchyHelper.m27435b(graphQLStory);
            ImmutableList of = ImmutableList.of();
            Builder pluginConfig = ComposerConfiguration.newBuilder().setComposerType(ComposerType.SHARE).setSourceType(ComposerSourceType.NOTIFICATION).setLegacyApiStoryId(Strings.nullToEmpty(graphQLStory.ai())).setStoryId(graphQLStory.m22350c()).setCacheId(graphQLStory.mo2507g()).setInitialText(b).setAllowsRedSpaceToggle(true).setPluginConfig(new DefaultPluginConfigSerializer().a(Factory.a));
            ImmutableList M = graphQLStory.m22327M();
            int size = M.size();
            for (int i2 = 0; i2 < size; i2++) {
                GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) M.get(i2);
                if (GraphQLStoryAttachmentUtil.m28059j(graphQLStoryAttachment)) {
                    String nullToEmpty = Strings.nullToEmpty(graphQLStoryAttachment.m23966C());
                    if (NativeThirdPartyUriHelper.m29571a(nullToEmpty)) {
                        nullToEmpty = NativeThirdPartyUriHelper.m29579d(Uri.parse(nullToEmpty)).toString();
                    }
                    pluginConfig.setInitialShareParams(ComposerShareParams.Builder.a(nullToEmpty).b());
                }
            }
            if (!of.isEmpty()) {
                pluginConfig = ComposerConfigurationFactory.m26256a(ComposerSourceSurface.NOTIFICATIONS, "draftFromNotification").setInitialTargetData(m14702q()).setInitialAttachments(of).setInitialText(b).setAllowsRedSpaceToggle(true);
            }
            pluginConfig.setMinutiaeObjectTag(MinutiaeObject.a(graphQLStory));
            GraphQLWithTagsConnection aR = graphQLStory.aR();
            if (aR != null) {
                ImmutableList.Builder builder = ImmutableList.builder();
                ImmutableList a = aR.m24957a();
                int size2 = a.size();
                while (i < size2) {
                    GraphQLActor graphQLActor = (GraphQLActor) a.get(i);
                    builder.m1069c(ComposerTaggedUser.a(Long.parseLong(graphQLActor.m23765H())).a(graphQLActor.aa()).a());
                    i++;
                }
                pluginConfig.setInitialTaggedUsers(builder.m1068b());
            }
            GraphQLPlace Y = graphQLStory.m22339Y();
            if (Y != null) {
                pluginConfig.setInitialLocationInfo(ComposerLocationInfo.newBuilder().b(new CheckinPlaceModel.Builder().a(Y.m24171x()).b(Y.m24126B()).a()).b());
            }
            return pluginConfig.a();
        } catch (InterruptedException e) {
            return null;
        } catch (ExecutionException e2) {
            return null;
        }
    }

    public final ImmutableList<ComposerAttachment> m14708e(Intent intent) {
        boolean p = m14701p(intent);
        List list = RegularImmutableList.f535a;
        if (p && intent.getParcelableExtra("android.intent.extra.STREAM") != null) {
            list = ImmutableList.of(intent.getParcelableExtra("android.intent.extra.STREAM"));
        } else if (intent.getParcelableArrayListExtra("android.intent.extra.STREAM") != null) {
            list = intent.getParcelableArrayListExtra("android.intent.extra.STREAM");
        }
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (Parcelable parcelable : r2) {
            if (parcelable instanceof Uri) {
                builder.m1069c(this.f9702w.a((Uri) parcelable, mo1943i()));
            }
        }
        ImmutableList b = builder.m1068b();
        if (b.isEmpty()) {
            return RegularImmutableList.f535a;
        }
        return ComposerAttachment.a(b, this.f9703x);
    }

    public static boolean m14699f(Intent intent) {
        return intent.getBooleanExtra("is_draft", false);
    }

    public final boolean m14709g(Intent intent) {
        return "text/plain".equals(intent.getType()) && m14701p(intent);
    }

    public static boolean m14700o(Intent intent) {
        return "android.intent.action.SEND_MULTIPLE".equals(intent.getAction());
    }

    public final boolean m14712j(Intent intent) {
        boolean z = intent.getType().startsWith("image/") && m14701p(intent);
        if (!(z || m14700o(intent))) {
            Object obj = (intent.getType().startsWith("video/") && m14701p(intent)) ? 1 : null;
            if (obj == null && !"*/*".equals(intent.getType())) {
                return false;
            }
        }
        return true;
    }

    public static boolean m14701p(Intent intent) {
        return "android.intent.action.SEND".equals(intent.getAction());
    }

    public final void m14714k(Intent intent) {
        AbstractFbErrorReporter abstractFbErrorReporter = this.f9701v;
        SoftErrorBuilder a = SoftError.a(mo1943i(), "Unexpected action: " + intent.getAction() + " type: " + intent.getType() + " app: " + m14716o());
        a.d = true;
        a = a;
        a.e = 1;
        abstractFbErrorReporter.mo336a(a.g());
        this.f9696q.m6456b(new ToastBuilder(2131234540));
        finish();
    }

    protected final boolean m14715n() {
        return this.f9688C.mo596a(ExperimentsForComposerAbTestModule.Q, false);
    }

    public final String m14716o() {
        ComponentName callingActivity = getCallingActivity();
        if (callingActivity != null) {
            return callingActivity.getPackageName();
        }
        if (checkCallingOrSelfPermission("android.permission.GET_TASKS") != 0) {
            return "external_ref_missing_permission";
        }
        for (RecentTaskInfo recentTaskInfo : this.f9695p.getRecentTasks(1, 1)) {
            if (recentTaskInfo.baseIntent != null && recentTaskInfo.baseIntent.getComponent() != null) {
                return recentTaskInfo.baseIntent.getComponent().getPackageName();
            }
        }
        return "external_ref_unavailable";
    }
}
