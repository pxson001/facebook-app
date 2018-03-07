package com.facebook.search.results.livefeed.loader;

import android.os.Handler;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.Clock;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.search.common.errors.GraphSearchException;
import com.facebook.search.results.livefeed.loader.LiveFeedDataLoader.C24963;
import com.facebook.search.results.livefeed.loader.LiveFeedDataLoader.C24974;
import com.facebook.search.results.livefeed.loader.LiveFeedModuleConfigToRefreshConfigAdapter.C24981;
import com.facebook.search.results.model.contract.SearchResultsContext;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: SEARCH_PERFORMED */
public class LiveFeedRefreshController implements StoryRefreshController {
    public static final Class<?> f23219b = LiveFeedRefreshController.class;
    public final Handler f23220c;
    public final FbNetworkManager f23221d;
    public final Clock f23222e;
    public final LiveFeedDataLoaderProvider f23223f;
    public C24981 f23224g;
    public RefreshController f23225h;
    public LiveFeedDataHandler f23226i = a;
    public boolean f23227j = false;
    public LiveFeedDataLoader f23228k;
    public Optional<String> f23229l;

    /* compiled from: SEARCH_PERFORMED */
    public class C25002 implements LiveFeedDataHandler {
        final /* synthetic */ LiveFeedRefreshController f23217a;

        public final void mo1297b(ImmutableList<GraphQLStory> immutableList, Optional<DefaultPageInfoFields> optional, String str, String str2, String str3) {
            Class cls = LiveFeedRefreshController.f23219b;
            Integer.valueOf(immutableList.size());
            this.f23217a.f23226i.mo1297b(immutableList, optional, str, str2, str3);
        }

        public C25002(LiveFeedRefreshController liveFeedRefreshController) {
            this.f23217a = liveFeedRefreshController;
        }

        public final void mo1296a(ImmutableList<GraphQLStory> immutableList, Optional<DefaultPageInfoFields> optional, String str, String str2, String str3) {
            if (optional.isPresent()) {
                this.f23217a.f23229l = Optional.fromNullable(((DefaultPageInfoFields) optional.get()).v_());
            }
            Class cls = LiveFeedRefreshController.f23219b;
            Integer.valueOf(immutableList.size());
            this.f23217a.f23226i.mo1296a(immutableList.reverse(), Absent.INSTANCE, str, str2, str3);
        }

        public final void mo1295a(GraphSearchException graphSearchException) {
            this.f23217a.f23226i.mo1295a(graphSearchException);
        }
    }

    public final void mo1314a(SearchResultsContext searchResultsContext, LiveFeedRefreshConfig liveFeedRefreshConfig, Optional<ImmutableList<GraphQLStory>> optional) {
        Integer.valueOf(15000);
        Integer.valueOf(15000);
        searchResultsContext.mo1212b();
        String str = "[Refresh TypeaheadConfig Values] RenderInterval: " + 15000 + ", TimeDelta: " + 23000 + ", FetchInterval: " + 15000 + ", FetchNumResults: " + 20 + ", ExcludeIdQueueLength: " + (20 * 3);
        this.f23224g = liveFeedRefreshConfig;
        this.f23228k = this.f23223f.m26909a(searchResultsContext, new C25002(this));
        if (this.f23225h != null) {
            this.f23225h.m26914c();
        }
        Clock clock = this.f23222e;
        Handler handler = this.f23220c;
        C24981 c24981 = this.f23224g;
        this.f23225h = new RefreshController(this, clock, handler, 15000, false) {
            final /* synthetic */ LiveFeedRefreshController f23216a;

            protected final void mo1311a() {
                if (this.f23216a.f23221d.d()) {
                    Class cls = LiveFeedRefreshController.f23219b;
                    this.f23216a.f23229l.orNull();
                    this.f23216a.f23228k.m26908a((String) this.f23216a.f23229l.orNull(), null);
                }
            }
        };
        this.f23227j = true;
        this.f23229l = Absent.INSTANCE;
    }

    @Inject
    public LiveFeedRefreshController(Clock clock, LiveFeedDataLoaderProvider liveFeedDataLoaderProvider, Handler handler, FbNetworkManager fbNetworkManager) {
        this.f23222e = clock;
        this.f23220c = handler;
        this.f23223f = liveFeedDataLoaderProvider;
        this.f23221d = fbNetworkManager;
    }

    public final void mo1313a(@Nullable LiveFeedDataHandler liveFeedDataHandler) {
        if (liveFeedDataHandler == null) {
            liveFeedDataHandler = a;
        }
        this.f23226i = liveFeedDataHandler;
    }

    public final void mo1312a() {
        if (this.f23227j) {
            this.f23225h.m26913b();
        }
    }

    public final void mo1316b() {
        if (this.f23227j) {
            this.f23225h.m26914c();
        }
    }

    public final void mo1317c() {
        mo1315a(null);
    }

    public final void mo1318d() {
        if (this.f23227j) {
            this.f23225h.m26914c();
            this.f23225h.f23214g = false;
            this.f23225h.mo1311a();
            this.f23225h.m26913b();
        }
    }

    public final void mo1315a(String str) {
        if (this.f23227j) {
            Integer.valueOf(10);
            LiveFeedDataLoader liveFeedDataLoader = this.f23228k;
            liveFeedDataLoader.f23204b.a("fetch_live_conversations_tailload", new C24963(liveFeedDataLoader, str, 10), new C24974(liveFeedDataLoader));
        }
    }

    public final boolean mo1319e() {
        if (this.f23227j) {
            return this.f23228k.f23204b.a("fetch_live_conversations_tailload");
        }
        return false;
    }
}
