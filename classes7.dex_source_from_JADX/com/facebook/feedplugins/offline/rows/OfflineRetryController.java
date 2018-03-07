package com.facebook.feedplugins.offline.rows;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.network.NetworkMonitor;
import com.facebook.composer.analytics.ComposerAnalyticsLogger;
import com.facebook.composer.cache.OfflinePostConfigCache;
import com.facebook.composer.publish.cache.pendingstory.PendingStoryStore;
import com.facebook.composer.publish.common.ErrorDetails;
import com.facebook.composer.publish.common.PendingStory;
import com.facebook.feed.util.composer.OfflinePostHeaderController;
import com.facebook.feedplugins.offline.rows.ui.OfflineRetryView;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.OfflinePostConfig;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.ipc.composer.model.RetrySource;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomRelativeLayout;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Optional;
import javax.inject.Inject;

/* compiled from: STARS_STARCHOSEN */
public class OfflineRetryController {
    private final OptimisticStoryStateCache f23665a;
    private final PendingStoryStore f23666b;
    private final QeAccessor f23667c;
    public final OfflinePostHeaderController f23668d;
    public final FbNetworkManager f23669e;
    public final ComposerAnalyticsLogger f23670f;
    public final OfflinePostConfigCache f23671g;
    public final NetworkMonitor f23672h;

    /* compiled from: STARS_STARCHOSEN */
    public class C20421 implements OnClickListener {
        final /* synthetic */ GraphQLStory f23663a;
        final /* synthetic */ OfflineRetryController f23664b;

        public C20421(OfflineRetryController offlineRetryController, GraphQLStory graphQLStory) {
            this.f23664b = offlineRetryController;
            this.f23663a = graphQLStory;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1409442520);
            CustomRelativeLayout customRelativeLayout = (CustomRelativeLayout) view.getParent().getParent();
            if (this.f23664b.f23669e.d()) {
                this.f23664b.f23668d.m4438a(this.f23663a, RetrySource.OFFLINE_POSTING_HEADER);
            } else {
                this.f23664b.f23670f.a(this.f23663a.T(), RetrySource.OFFLINE_POSTING_HEADER);
                if (customRelativeLayout instanceof OfflineRetryView) {
                    OfflineRetryView offlineRetryView = (OfflineRetryView) customRelativeLayout;
                    offlineRetryView.f23721a.a(view.getResources().getString(2131230763), 3000);
                }
            }
            LogUtils.a(1760770325, a);
        }
    }

    @Inject
    public OfflineRetryController(QeAccessor qeAccessor, OptimisticStoryStateCache optimisticStoryStateCache, PendingStoryStore pendingStoryStore, OfflinePostHeaderController offlinePostHeaderController, FbNetworkManager fbNetworkManager, ComposerAnalyticsLogger composerAnalyticsLogger, OfflinePostConfigCache offlinePostConfigCache, NetworkMonitor networkMonitor) {
        this.f23667c = qeAccessor;
        this.f23665a = optimisticStoryStateCache;
        this.f23666b = pendingStoryStore;
        this.f23668d = offlinePostHeaderController;
        this.f23669e = fbNetworkManager;
        this.f23670f = composerAnalyticsLogger;
        this.f23671g = offlinePostConfigCache;
        this.f23672h = networkMonitor;
    }

    public final boolean m25872a(GraphQLStory graphQLStory) {
        return m25871d(graphQLStory);
    }

    @VisibleForTesting
    private boolean m25871d(GraphQLStory graphQLStory) {
        if (graphQLStory == null || StoryAttachmentHelper.j(graphQLStory)) {
            return false;
        }
        Optional d = this.f23666b.d(graphQLStory.T());
        if (!d.isPresent()) {
            return false;
        }
        ErrorDetails b = ((PendingStory) d.get()).b().b();
        return this.f23665a.a(graphQLStory) == GraphQLFeedOptimisticPublishState.FAILED && ((b == null || b.isRetriable) && !((PendingStory) d.get()).f());
    }

    final void m25873c(GraphQLStory graphQLStory) {
        if (this.f23666b != null) {
            Optional d = this.f23666b.d(graphQLStory.T());
            if (d.isPresent() && ((PendingStory) d.get()).b().b() != null) {
                OfflinePostConfig a = this.f23671g.a(graphQLStory);
                if (this.f23672h.a()) {
                    long j;
                    if (a.a) {
                        j = 300000;
                    } else {
                        j = 0;
                    }
                    OfflinePostHeaderController offlinePostHeaderController = this.f23668d;
                    Message obtainMessage = offlinePostHeaderController.obtainMessage(2, graphQLStory.T());
                    Bundle bundle = new Bundle(1);
                    FlatBufferModelHelper.a(bundle, "story_key", graphQLStory);
                    obtainMessage.setData(bundle);
                    offlinePostHeaderController.sendMessageDelayed(obtainMessage, j);
                    a.a = true;
                }
            }
        }
    }
}
