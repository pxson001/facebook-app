package com.facebook.feed.fragment;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.graphics.drawable.ColorDrawable;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler;
import com.facebook.api.feedcache.db.FeedDatabaseSupplier;
import com.facebook.api.feedcache.db.FeedDbSchemaPart.HomeStoriesTable.Columns;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.util.SizeUtil;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.api.Holder;
import com.facebook.controllercallbacks.fragment.ResumePauseCallbacks;
import com.facebook.database.sqlite.SqlExpression;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.broadcaster.NewsFeedBroadcaster;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.controllercallbacks.ScrollCallback;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.inject.Inject;

/* compiled from: photo_reminder */
public class NewsFeedFragmentOfflineController extends BaseController implements ResumePauseCallbacks, ScrollCallback {
    private TextView f10041a;
    private final FbNetworkManager f10042b;
    public final NewsFeedBroadcaster f10043c;
    public final DbFeedHomeStoriesHandler f10044d;
    private final ListeningExecutorService f10045e;
    public final QeAccessor f10046f;
    public final BaseFbBroadcastManager f10047g;
    private final UnseenStoryRunnable f10048h = new UnseenStoryRunnable(this);
    public SelfRegistrableReceiverImpl f10049i;
    public Holder<FbFragment> f10050j;

    /* compiled from: photo_reminder */
    class UnseenStoryRunnable implements Runnable {
        final /* synthetic */ NewsFeedFragmentOfflineController f10051a;

        public UnseenStoryRunnable(NewsFeedFragmentOfflineController newsFeedFragmentOfflineController) {
            this.f10051a = newsFeedFragmentOfflineController;
        }

        public void run() {
            int i;
            DbFeedHomeStoriesHandler dbFeedHomeStoriesHandler = this.f10051a.f10044d;
            SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
            sQLiteQueryBuilder.setTables("home_stories");
            Expression a = SqlExpression.m10727a(Columns.f5273i.toString(), "0");
            Cursor query = sQLiteQueryBuilder.query(((FeedDatabaseSupplier) dbFeedHomeStoriesHandler.f5249e.get()).mo2480a(), new String[]{"COUNT(" + Columns.f5273i.toString() + ")"}, a.mo1476a(), a.mo1477b(), null, null, null);
            if (query.moveToFirst()) {
                i = query.getInt(0);
            } else {
                i = 0;
            }
            query.close();
            this.f10051a.f10043c.f4901a.mo406a(new Intent().setAction("com.facebook.feed.util.NEWS_FEED_NEW_STORIES").putExtra("new_story_count", i).putExtra("use_large_count", true));
        }
    }

    public static NewsFeedFragmentOfflineController m15125a(InjectorLike injectorLike) {
        return new NewsFeedFragmentOfflineController(NewsFeedBroadcaster.m8781a(injectorLike), FbNetworkManager.m3811a(injectorLike), C0055x2995691a.m1881a(injectorLike), DbFeedHomeStoriesHandler.m9120a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), LocalFbBroadcastManager.m2946a(injectorLike));
    }

    @Inject
    public NewsFeedFragmentOfflineController(NewsFeedBroadcaster newsFeedBroadcaster, FbNetworkManager fbNetworkManager, ListeningExecutorService listeningExecutorService, DbFeedHomeStoriesHandler dbFeedHomeStoriesHandler, QeAccessor qeAccessor, BaseFbBroadcastManager baseFbBroadcastManager) {
        this.f10042b = fbNetworkManager;
        this.f10043c = newsFeedBroadcaster;
        this.f10044d = dbFeedHomeStoriesHandler;
        this.f10045e = listeningExecutorService;
        this.f10046f = qeAccessor;
        this.f10047g = baseFbBroadcastManager;
    }

    public final void mo1264c() {
        if (this.f10046f.mo596a(ExperimentsForNewsFeedAbTestModule.f5086M, false)) {
            Context ao = ((FbFragment) this.f10050j.f10429a).ao();
            if (this.f10041a == null) {
                this.f10041a = new TextView(ao);
                this.f10041a.setText("Offline Mode");
                this.f10041a.setTextSize(2, 8.0f);
                this.f10041a.setGravity(17);
                int a = SizeUtil.m19191a(ao, 5.0f);
                int a2 = SizeUtil.m19191a(ao, 2.0f);
                this.f10041a.setPadding(a, a2, a, a2);
                this.f10041a.setBackgroundDrawable(new ColorDrawable(-1));
                this.f10041a.setTextColor(-16777216);
                ao.getWindow().addContentView(this.f10041a, new LayoutParams(-2, -2, 1));
            }
            if (this.f10049i == null) {
                this.f10049i = this.f10047g.m2951a().mo506a("com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED", new 1(this)).mo503a();
                this.f10049i.m3296b();
            }
            m15126e(this);
        }
    }

    public final void mo1265d() {
        if (this.f10049i != null) {
            this.f10049i.m3297c();
            this.f10049i = null;
        }
    }

    public final void mo1262a(ScrollingViewProxy scrollingViewProxy, int i) {
        if (i == 0) {
            m15126e(this);
        }
    }

    public final void mo1263a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
    }

    public static void m15126e(NewsFeedFragmentOfflineController newsFeedFragmentOfflineController) {
        if (newsFeedFragmentOfflineController.f10041a != null) {
            newsFeedFragmentOfflineController.f10041a.setVisibility(newsFeedFragmentOfflineController.f10042b.m3828d() ? 8 : 0);
        }
    }
}
