package com.facebook.feed.fragment.controllercallbacks;

import android.content.Context;
import android.content.Intent;
import com.facebook.api.feed.data.LegacyFeedUnitUpdater;
import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.C0115xfdf5bd2;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.api.Holder;
import com.facebook.controllercallbacks.fragment.ActivityResultCallback;
import com.facebook.feed.fragment.NewsFeedFragment;
import com.facebook.feed.goodfriends.customization.GoodFriendsCustomizationHeaderAdapter;
import com.facebook.feed.goodfriends.customization.GoodFriendsCustomizationHeaderAdapterProvider;
import com.facebook.goodfriends.data.FriendStateFetcher;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: parent_story_id */
public class GoodFriendsCustomizationHeaderController extends BaseController implements ActivityResultCallback {
    private final GoodFriendsCustomizationHeaderAdapterProvider f10377a;
    public final DbFeedHomeStoriesHandler f10378b;
    public final Executor f10379c;
    public final Executor f10380d;
    public GoodFriendsCustomizationHeaderAdapter f10381e;
    public Context f10382f;
    public NewsFeedFragment f10383g;
    public Holder<LegacyFeedUnitUpdater> f10384h;

    public static GoodFriendsCustomizationHeaderController m15473a(InjectorLike injectorLike) {
        return new GoodFriendsCustomizationHeaderController((GoodFriendsCustomizationHeaderAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GoodFriendsCustomizationHeaderAdapterProvider.class), DbFeedHomeStoriesHandler.m9120a(injectorLike), ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.m1951a(injectorLike), C0115xfdf5bd2.m3569a(injectorLike));
    }

    @Inject
    public GoodFriendsCustomizationHeaderController(GoodFriendsCustomizationHeaderAdapterProvider goodFriendsCustomizationHeaderAdapterProvider, DbFeedHomeStoriesHandler dbFeedHomeStoriesHandler, Executor executor, Executor executor2) {
        this.f10377a = goodFriendsCustomizationHeaderAdapterProvider;
        this.f10378b = dbFeedHomeStoriesHandler;
        this.f10379c = executor;
        this.f10380d = executor2;
    }

    public final GoodFriendsCustomizationHeaderAdapter m15475b() {
        InjectorLike injectorLike = this.f10377a;
        this.f10381e = new GoodFriendsCustomizationHeaderAdapter(DefaultSecureContextHelper.m4636a(injectorLike), FriendStateFetcher.b(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), Fb4aUriIntentMapper.m8640a(injectorLike), this.f10382f);
        return this.f10381e;
    }

    public final void mo1941a(int i, int i2, Intent intent) {
        if (i == 101 && i2 == -1 && intent != null && intent.getBooleanExtra("audience_changed", false)) {
            if (this.f10381e != null) {
                this.f10381e.a();
            }
            ExecutorDetour.a(this.f10380d, new 1(this, getClass(), "clean-goodfriends-feed"), -1404920105);
        }
    }
}
