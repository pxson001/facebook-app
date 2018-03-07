package com.facebook.photos.upload.compost;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.publish.cache.pendingstory.PendingStoryStore;
import com.facebook.composer.publish.common.PendingStory;
import com.facebook.composer.publish.compost.store.CompostStoryStore;
import com.facebook.composer.publish.compost.story.CompostStory;
import com.facebook.composer.publish.compost.story.CompostStory.StoryType;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.ExecutionException;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: graph_search_v2_typeahead_echo */
public class CompostPendingPostStore extends CompostStoryStore<CompostPendingPost> {
    private static final String f13544d = CompostPendingPostStore.class.getSimpleName();
    private static volatile CompostPendingPostStore f13545f;
    private final PendingStoryStore f13546e;

    /* compiled from: graph_search_v2_typeahead_echo */
    class C08691 implements Comparator<CompostPendingPost> {
        final /* synthetic */ CompostPendingPostStore f13543a;

        C08691(CompostPendingPostStore compostPendingPostStore) {
            this.f13543a = compostPendingPostStore;
        }

        public int compare(Object obj, Object obj2) {
            return ((CompostPendingPost) obj).mo931c() > ((CompostPendingPost) obj2).mo931c() ? -1 : 1;
        }
    }

    public static com.facebook.photos.upload.compost.CompostPendingPostStore m21223a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f13545f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.upload.compost.CompostPendingPostStore.class;
        monitor-enter(r1);
        r0 = f13545f;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m21224b(r0);	 Catch:{ all -> 0x0035 }
        f13545f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13545f;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.upload.compost.CompostPendingPostStore.a(com.facebook.inject.InjectorLike):com.facebook.photos.upload.compost.CompostPendingPostStore");
    }

    private static CompostPendingPostStore m21224b(InjectorLike injectorLike) {
        return new CompostPendingPostStore(PendingStoryStore.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Nullable
    public final /* synthetic */ CompostStory mo1127c(String str) {
        return m21228e(str);
    }

    @Inject
    public CompostPendingPostStore(PendingStoryStore pendingStoryStore, QeAccessor qeAccessor, Clock clock) {
        super(clock);
        this.f13546e = pendingStoryStore;
    }

    public final ImmutableList<CompostPendingPost> mo1128d() {
        Throwable e;
        Collection arrayList = new ArrayList();
        ImmutableList a = this.f13546e.a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new CompostPendingPost((PendingStory) a.get(i), StoryType.POST));
        }
        try {
            arrayList.addAll((Collection) FutureDetour.a(mo926a(), -1257982768));
        } catch (InterruptedException e2) {
            e = e2;
            BLog.b(f13544d, "Failed to add extra stories", e);
            Collections.sort(arrayList, new C08691(this));
            return ImmutableList.copyOf(arrayList);
        } catch (ExecutionException e3) {
            e = e3;
            BLog.b(f13544d, "Failed to add extra stories", e);
            Collections.sort(arrayList, new C08691(this));
            return ImmutableList.copyOf(arrayList);
        }
        Collections.sort(arrayList, new C08691(this));
        return ImmutableList.copyOf(arrayList);
    }

    @Nullable
    public final CompostPendingPost m21228e(String str) {
        CompostPendingPost compostPendingPost = (CompostPendingPost) super.mo1127c(str);
        if (compostPendingPost != null) {
            return compostPendingPost;
        }
        Optional d = this.f13546e.d(str);
        if (d.isPresent()) {
            return new CompostPendingPost((PendingStory) d.get(), StoryType.POST);
        }
        return null;
    }

    public final long mo929b() {
        return 1209600;
    }
}
