package com.facebook.photos.upload.compost;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.composer.publish.compost.store.CompostDraftStoryStore;
import com.facebook.composer.publish.compost.store.CompostStoryStore.OnUpdateListener;
import com.facebook.composer.publish.compost.store.RecentlyUploadedStoryStore;
import com.facebook.composer.publish.compost.story.CompostDraftStory;
import com.facebook.composer.publish.compost.story.CompostStory;
import com.facebook.composer.publish.compost.story.RecentlyUploadedStory;
import com.facebook.content.event.FbEvent;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.photos.upload.event.MediaUploadEventBus;
import com.facebook.photos.upload.event.MediaUploadEventSubscriber;
import com.facebook.photos.upload.event.MediaUploadSuccessEvent;
import com.facebook.photos.upload.progresspage.CompostFragment.C08901;
import com.facebook.photos.upload.progresspage.CompostFragment.C08901.C08891;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: graph_search_v2_trending_story */
public class CompostStoryFetcher {
    private static final String f13552a = CompostStoryFetcher.class.getSimpleName();
    public final MediaUploadEventBus f13553b;
    public final CompostPendingPostStore f13554c;
    public final RecentlyUploadedStoryStore f13555d;
    public final CompostDraftStoryStore f13556e;
    public final Lazy<TasksManager> f13557f;
    public final OnUpdateListener<RecentlyUploadedStory> f13558g = new C08701(this);
    public final MediaUploadEventSubscriber f13559h = new ManageStoryRemovePostedSubscriber(this);
    public final List<CompostPendingPost> f13560i = new ArrayList();
    private final List<RecentlyUploadedStory> f13561j = new ArrayList();
    private final List<CompostDraftStory> f13562k = new ArrayList();
    public Optional<CompostDataListener> f13563l;
    private int f13564m;
    public boolean f13565n;

    /* compiled from: graph_search_v2_trending_story */
    public class C08701 {
        final /* synthetic */ CompostStoryFetcher f13547a;

        C08701(CompostStoryFetcher compostStoryFetcher) {
            this.f13547a = compostStoryFetcher;
        }

        public final void m21229a(Object obj) {
            RecentlyUploadedStory recentlyUploadedStory = (RecentlyUploadedStory) obj;
            if (this.f13547a.f13563l.isPresent() && StoryAttachmentHelper.b(recentlyUploadedStory.f8057a)) {
                C08901 c08901 = (C08901) this.f13547a.f13563l.get();
                c08901.f13836a.o().runOnUiThread(new C08891(c08901, recentlyUploadedStory));
            }
        }
    }

    /* compiled from: graph_search_v2_trending_story */
    class C08723 extends AbstractDisposableFutureCallback<ImmutableList<T>> {
        final /* synthetic */ CompostStoryFetcher f13550a;

        C08723(CompostStoryFetcher compostStoryFetcher) {
            this.f13550a = compostStoryFetcher;
        }

        protected final void m21230a(Object obj) {
            this.f13550a.f13564m = this.f13550a.f13564m + 1;
            if (CompostStoryFetcher.m21238h(this.f13550a) && this.f13550a.f13563l.isPresent()) {
                CompostStoryFetcher.m21239i(this.f13550a);
            }
        }

        protected final void m21231a(Throwable th) {
            this.f13550a.f13564m = this.f13550a.f13564m + 1;
            this.f13550a.f13565n = true;
            if (CompostStoryFetcher.m21238h(this.f13550a)) {
                CompostStoryFetcher.m21239i(this.f13550a);
            }
        }
    }

    /* compiled from: graph_search_v2_trending_story */
    enum CompostTaskId {
        FETCH_PENDING,
        FETCH_UPLOADED,
        FETCH_DRAFTS
    }

    /* compiled from: graph_search_v2_trending_story */
    class ManageStoryRemovePostedSubscriber extends MediaUploadEventSubscriber<MediaUploadSuccessEvent> {
        final /* synthetic */ CompostStoryFetcher f13551a;

        public ManageStoryRemovePostedSubscriber(CompostStoryFetcher compostStoryFetcher) {
            this.f13551a = compostStoryFetcher;
        }

        public final void m21233b(FbEvent fbEvent) {
            for (CompostPendingPost compostPendingPost : this.f13551a.f13560i) {
                Object obj;
                ImmutableList d = this.f13551a.f13554c.mo1128d();
                int size = d.size();
                for (int i = 0; i < size; i++) {
                    if (((CompostPendingPost) d.get(i)).mo934f().equals(compostPendingPost.mo934f())) {
                        obj = 1;
                        continue;
                        break;
                    }
                }
                obj = null;
                continue;
                if (obj == null) {
                    if (this.f13551a.f13563l.isPresent()) {
                        ((C08901) this.f13551a.f13563l.get()).m21608a(compostPendingPost);
                    }
                    this.f13551a.f13560i.remove(compostPendingPost);
                    return;
                }
            }
        }

        public final Class m21232a() {
            return MediaUploadSuccessEvent.class;
        }
    }

    public static CompostStoryFetcher m21236b(InjectorLike injectorLike) {
        return new CompostStoryFetcher(MediaUploadEventBus.a(injectorLike), CompostPendingPostStore.m21223a(injectorLike), RecentlyUploadedStoryStore.m11608a(injectorLike), CompostDraftStoryStore.m11595a(injectorLike), IdBasedLazy.a(injectorLike, 3561));
    }

    @Inject
    public CompostStoryFetcher(MediaUploadEventBus mediaUploadEventBus, CompostPendingPostStore compostPendingPostStore, RecentlyUploadedStoryStore recentlyUploadedStoryStore, CompostDraftStoryStore compostDraftStoryStore, Lazy<TasksManager> lazy) {
        this.f13553b = mediaUploadEventBus;
        this.f13554c = compostPendingPostStore;
        this.f13555d = recentlyUploadedStoryStore;
        this.f13556e = compostDraftStoryStore;
        this.f13557f = lazy;
        this.f13563l = Absent.INSTANCE;
    }

    public final void m21240c() {
        this.f13564m = 0;
        this.f13565n = false;
        m21234a(CompostTaskId.FETCH_PENDING, Futures.a(this.f13554c.mo1128d()));
        m21234a(CompostTaskId.FETCH_UPLOADED, this.f13555d.mo926a());
        m21234a(CompostTaskId.FETCH_DRAFTS, this.f13556e.mo926a());
    }

    private <T extends CompostStory> void m21234a(CompostTaskId compostTaskId, final ListenableFuture<ImmutableList<T>> listenableFuture) {
        ((TasksManager) this.f13557f.get()).a(compostTaskId, new Callable<ListenableFuture<ImmutableList<T>>>(this) {
            final /* synthetic */ CompostStoryFetcher f13549b;

            public Object call() {
                return listenableFuture;
            }
        }, new C08723(this));
    }

    public static boolean m21238h(CompostStoryFetcher compostStoryFetcher) {
        return compostStoryFetcher.f13564m >= 3;
    }

    public static void m21239i(CompostStoryFetcher compostStoryFetcher) {
        int i = 0;
        compostStoryFetcher.f13560i.clear();
        compostStoryFetcher.f13561j.clear();
        compostStoryFetcher.f13562k.clear();
        try {
            int i2;
            ImmutableList d = compostStoryFetcher.f13554c.mo1128d();
            int size = d.size();
            for (int i3 = 0; i3 < size; i3++) {
                CompostPendingPost compostPendingPost = (CompostPendingPost) d.get(i3);
                if (StoryAttachmentHelper.b(compostPendingPost.m21217a())) {
                    compostStoryFetcher.f13560i.add(compostPendingPost);
                }
            }
            ImmutableList immutableList = (ImmutableList) FutureDetour.a(compostStoryFetcher.f13555d.mo926a(), -1993518165);
            size = immutableList.size();
            for (i2 = 0; i2 < size; i2++) {
                RecentlyUploadedStory recentlyUploadedStory = (RecentlyUploadedStory) immutableList.get(i2);
                if (StoryAttachmentHelper.b(recentlyUploadedStory.m11626a())) {
                    compostStoryFetcher.f13561j.add(recentlyUploadedStory);
                }
            }
            immutableList = (ImmutableList) FutureDetour.a(compostStoryFetcher.f13556e.mo926a(), 2143900031);
            i2 = immutableList.size();
            while (i < i2) {
                CompostDraftStory compostDraftStory = (CompostDraftStory) immutableList.get(i);
                if (!compostStoryFetcher.m21237b(compostDraftStory)) {
                    compostStoryFetcher.f13562k.add(compostDraftStory);
                }
                i++;
            }
        } catch (Throwable e) {
            BLog.b(f13552a, "Interrupted while fetching stories", e);
            compostStoryFetcher.f13565n = true;
        } catch (Throwable e2) {
            BLog.b(f13552a, "Failed to fetch stories", e2);
            compostStoryFetcher.f13565n = true;
        }
        if (m21238h(compostStoryFetcher) && compostStoryFetcher.f13563l.isPresent()) {
            ((C08901) compostStoryFetcher.f13563l.get()).m21607a();
        }
    }

    private boolean m21237b(CompostDraftStory compostDraftStory) {
        return this.f13554c.m21228e(compostDraftStory.mo934f()) != null;
    }

    public final ImmutableList<CompostPendingPost> m21241d() {
        return ImmutableList.copyOf(this.f13560i);
    }

    public final ImmutableList<RecentlyUploadedStory> m21242e() {
        return ImmutableList.copyOf(this.f13561j);
    }

    public final ImmutableList<CompostDraftStory> m21243f() {
        return ImmutableList.copyOf(this.f13562k);
    }
}
