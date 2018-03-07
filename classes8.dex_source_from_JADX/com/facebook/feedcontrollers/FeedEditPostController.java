package com.facebook.feedcontrollers;

import android.content.Context;
import android.content.Intent;
import com.facebook.api.feed.data.LegacyFeedUnitUpdater;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.composer.publish.common.EditPostParams;
import com.facebook.composer.publish.optimistic.ComposerActivityBroadcaster.Result;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.feed.loader.FeedOnDataChangeListener;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Objects;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: group_creation */
public class FeedEditPostController {
    public final ComposerPublishServiceHelper f11942a;
    public final FeedStoryMutator f11943b;
    public final BaseFbBroadcastManager f11944c;
    public LegacyFeedUnitUpdater f11945d;
    @Nullable
    private FeedOnDataChangeListener f11946e;
    public FutureAndCallbackHolder<OperationResult> f11947f;
    public SelfRegistrableReceiverImpl f11948g;

    /* compiled from: group_creation */
    public class C12821 implements ActionReceiver {
        final /* synthetic */ GraphQLStory f11939a;
        final /* synthetic */ EditPostParams f11940b;
        final /* synthetic */ FeedEditPostController f11941c;

        public C12821(FeedEditPostController feedEditPostController, GraphQLStory graphQLStory, EditPostParams editPostParams) {
            this.f11941c = feedEditPostController;
            this.f11939a = graphQLStory;
            this.f11940b = editPostParams;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -2942783);
            if (intent.getAction() != "com.facebook.STREAM_PUBLISH_COMPLETE") {
                Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1301149306, a);
            } else if (Result.valueOf(intent.getStringExtra("extra_result")) != Result.SUCCESS) {
                FeedEditPostController feedEditPostController = this.f11941c;
                feedEditPostController.f11945d.a(this.f11939a);
                FeedEditPostController.m14031b(feedEditPostController);
                LogUtils.e(1558837356, a);
            } else {
                String stringExtra = intent.getStringExtra("extra_legacy_api_post_id");
                if (Objects.equal(this.f11940b.legacyStoryApiId, stringExtra)) {
                    if (this.f11941c.f11945d.e(this.f11939a.c()) == null) {
                        LogUtils.e(-813421909, a);
                        return;
                    } else {
                        this.f11941c.f11945d.a(stringExtra);
                        FeedEditPostController.m14031b(this.f11941c);
                    }
                }
                LogUtils.e(-1682391748, a);
            }
        }
    }

    public static FeedEditPostController m14030b(InjectorLike injectorLike) {
        return new FeedEditPostController(ComposerPublishServiceHelper.b(injectorLike), FeedStoryMutator.b(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike));
    }

    public static FeedEditPostController m14029a(InjectorLike injectorLike) {
        return m14030b(injectorLike);
    }

    @Inject
    public FeedEditPostController(ComposerPublishServiceHelper composerPublishServiceHelper, FeedStoryMutator feedStoryMutator, BaseFbBroadcastManager baseFbBroadcastManager) {
        this.f11942a = composerPublishServiceHelper;
        this.f11943b = feedStoryMutator;
        this.f11944c = baseFbBroadcastManager;
    }

    public final void m14032a(LegacyFeedUnitUpdater legacyFeedUnitUpdater, @Nullable FeedOnDataChangeListener feedOnDataChangeListener) {
        this.f11945d = legacyFeedUnitUpdater;
        this.f11946e = feedOnDataChangeListener;
    }

    public static void m14031b(FeedEditPostController feedEditPostController) {
        if (feedEditPostController.f11946e != null) {
            feedEditPostController.f11946e.c();
        }
    }
}
