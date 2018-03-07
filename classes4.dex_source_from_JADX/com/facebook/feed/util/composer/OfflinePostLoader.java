package com.facebook.feed.util.composer;

import com.facebook.api.feedcache.memory.pendingstory.PendingStoryCache;
import com.facebook.composer.cache.OfflinePostConfigCache;
import com.facebook.composer.publish.cache.pendingstory.PendingStoryStore;
import com.facebook.composer.publish.common.PendingStory;
import com.facebook.composer.publish.common.PostParamsWrapper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.upload.manager.UploadManager;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: non-static member class */
public class OfflinePostLoader {
    private static final String f7022a = OfflinePostLoader.class.getSimpleName();
    private final PendingStoryStore f7023b;
    private final UploadManager f7024c;
    private final OfflinePostConfigCache f7025d;

    /* compiled from: non-static member class */
    public interface Listener {
        void mo589a();

        boolean mo590a(long j, GraphQLStory graphQLStory);

        void mo591b();
    }

    public static OfflinePostLoader m7301b(InjectorLike injectorLike) {
        return new OfflinePostLoader(PendingStoryStore.a(injectorLike), UploadManager.m7304a(injectorLike), OfflinePostConfigCache.a(injectorLike));
    }

    @Inject
    public OfflinePostLoader(PendingStoryStore pendingStoryStore, UploadManager uploadManager, OfflinePostConfigCache offlinePostConfigCache) {
        this.f7023b = pendingStoryStore;
        this.f7024c = uploadManager;
        this.f7025d = offlinePostConfigCache;
    }

    public final void m7302a(Listener listener, PendingStoryCache pendingStoryCache) {
        ImmutableList a = this.f7023b.a();
        if (a != null && !a.isEmpty()) {
            listener.mo589a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                PendingStory pendingStory = (PendingStory) a.get(i);
                PostParamsWrapper b = pendingStory.b();
                if (b.e() && b.b() != null && b.b().isRetriable && !this.f7024c.m7337e(b.a())) {
                    this.f7023b.a(b.a());
                } else if (listener.mo590a(b.d(), pendingStory.a())) {
                    String a2 = b.a();
                    String i2 = b.i();
                    GraphQLStory a3 = pendingStory.a();
                    if (pendingStoryCache.e(i2) == null || !pendingStoryCache.a(a3)) {
                        pendingStoryCache.a(a2, a3);
                    }
                    this.f7025d.a(pendingStory.a()).a = false;
                }
            }
            listener.mo591b();
        }
    }

    public static OfflinePostLoader m7300a(InjectorLike injectorLike) {
        return m7301b(injectorLike);
    }
}
