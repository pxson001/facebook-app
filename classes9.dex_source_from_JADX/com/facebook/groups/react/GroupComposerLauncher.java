package com.facebook.groups.react;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.common.locale.Locales;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.composer.publish.optimistic.ComposerActivityBroadcaster.Result;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.launch.ComposerIntentLauncher;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.simplepicker.SimplePickerIntent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: payment_pin_protections_params_extra */
public class GroupComposerLauncher {
    @Nullable
    private final ReactContext f7004a;
    public final Activity f7005b;
    public final ComposerLauncher f7006c;
    private final Lazy<ComposerIntentLauncher> f7007d;
    private final Lazy<ComposerPublishServiceHelper> f7008e;
    private final Lazy<ExecutorService> f7009f;
    public final Lazy<FbBroadcastManager> f7010g;
    private final Lazy<Locales> f7011h;
    public SelfRegistrableReceiverImpl f7012i;

    /* compiled from: payment_pin_protections_params_extra */
    class C07321 implements LifecycleEventListener {
        final /* synthetic */ GroupComposerLauncher f7000a;

        C07321(GroupComposerLauncher groupComposerLauncher) {
            this.f7000a = groupComposerLauncher;
        }

        public final void hf_() {
            GroupComposerLauncher groupComposerLauncher = this.f7000a;
            groupComposerLauncher.f7012i = ((BaseFbBroadcastManager) groupComposerLauncher.f7010g.get()).a().a("com.facebook.STREAM_PUBLISH_COMPLETE", new C07332(groupComposerLauncher)).a();
            groupComposerLauncher.f7012i.b();
        }

        public final void hg_() {
            GroupComposerLauncher groupComposerLauncher = this.f7000a;
            if (groupComposerLauncher.f7012i != null) {
                groupComposerLauncher.f7012i.c();
                groupComposerLauncher.f7012i = null;
            }
        }

        public final void hh_() {
        }
    }

    /* compiled from: payment_pin_protections_params_extra */
    public class C07332 implements ActionReceiver {
        final /* synthetic */ GroupComposerLauncher f7001a;

        public C07332(GroupComposerLauncher groupComposerLauncher) {
            this.f7001a = groupComposerLauncher;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 750655053);
            if (intent.getExtras().getString("extra_result").equals(Result.SUCCESS.toString())) {
                GroupComposerLauncher.m7310a(this.f7001a, PostStatus.CONFIRMED, -1);
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 605490948, a);
        }
    }

    /* compiled from: payment_pin_protections_params_extra */
    enum PostStatus {
        CREATED,
        CONFIRMED,
        ERROR
    }

    @Inject
    public GroupComposerLauncher(@Nullable @Assisted ReactContext reactContext, @Assisted Activity activity, ComposerLauncher composerLauncher, Lazy<ComposerIntentLauncher> lazy, Lazy<ComposerPublishServiceHelper> lazy2, Lazy<ExecutorService> lazy3, Lazy<FbBroadcastManager> lazy4, Lazy<Locales> lazy5) {
        this.f7004a = reactContext;
        this.f7005b = activity;
        this.f7006c = composerLauncher;
        this.f7007d = lazy;
        this.f7008e = lazy2;
        this.f7009f = lazy3;
        this.f7010g = lazy4;
        this.f7011h = lazy5;
        if (this.f7004a != null) {
            this.f7004a.a(new C07321(this));
        }
    }

    public static ComposerConfiguration m7308a(String str, String str2, boolean z) {
        Builder useOptimisticPosting = ComposerConfigurationFactory.a(ComposerSourceSurface.GROUP_FEED, "reactGroups").setUseOptimisticPosting(z);
        ComposerTargetData.Builder builder = new ComposerTargetData.Builder(Long.parseLong(str), TargetType.GROUP);
        builder.c = str2;
        return useOptimisticPosting.setInitialTargetData(builder.a()).setNectarModule("group_composer").a();
    }

    public final void m7312c(String str, String str2) {
        ComposerIntentLauncher composerIntentLauncher = (ComposerIntentLauncher) this.f7007d.get();
        Context context = this.f7005b;
        SimplePickerLauncherConfiguration.Builder builder = new SimplePickerLauncherConfiguration.Builder(SimplePickerSource.GROUP);
        Builder isFireAndForget = ComposerConfigurationFactory.a(ComposerSourceSurface.GROUP_FEED, "groupPhotoReact").setIsFireAndForget(true);
        ComposerTargetData.Builder builder2 = new ComposerTargetData.Builder(Long.parseLong(str), TargetType.GROUP);
        builder2.c = str2;
        builder.a = isFireAndForget.setInitialTargetData(builder2.a()).a();
        composerIntentLauncher.a(SimplePickerIntent.a(context, builder), 1756, this.f7005b);
    }

    public final void m7311a(int i, Intent intent) {
        if (i == -1) {
            final PublishPostParams publishPostParams = (PublishPostParams) intent.getParcelableExtra("publishPostParams");
            ListenableFuture c = ((ComposerPublishServiceHelper) this.f7008e.get()).c(intent);
            if (!intent.getBooleanExtra("is_uploading_media", false)) {
                Futures.a(c, new FutureCallback<OperationResult>(this) {
                    final /* synthetic */ GroupComposerLauncher f7003b;

                    public void onSuccess(Object obj) {
                        GroupComposerLauncher.m7310a(this.f7003b, PostStatus.CONFIRMED, publishPostParams.targetId);
                    }

                    public void onFailure(Throwable th) {
                        GroupComposerLauncher.m7310a(this.f7003b, PostStatus.ERROR, publishPostParams.targetId);
                    }
                }, (Executor) this.f7009f.get());
            }
            if (intent.hasExtra("extra_optimistic_feed_story")) {
                m7309a(PostStatus.CREATED, publishPostParams.targetId, GroupsReactCacheUtil.m7314a((GraphQLStory) intent.getParcelableExtra("extra_optimistic_feed_story")));
                return;
            }
            m7310a(this, PostStatus.CREATED, publishPostParams.targetId);
        }
    }

    public static void m7310a(GroupComposerLauncher groupComposerLauncher, PostStatus postStatus, long j) {
        groupComposerLauncher.m7309a(postStatus, j, null);
    }

    private void m7309a(PostStatus postStatus, long j, @Nullable Bundle bundle) {
        if (j != 0 && this.f7004a != null && this.f7004a.b()) {
            WritableMap b = Arguments.b();
            b.putString("groupID", String.valueOf(j));
            b.putString("status", postStatus.toString());
            if (bundle != null) {
                b.a("optimisticStory", Arguments.a(bundle));
            }
            ((RCTNativeAppEventEmitter) this.f7004a.a(RCTNativeAppEventEmitter.class)).emit("postComposerEvent", b);
        }
    }
}
