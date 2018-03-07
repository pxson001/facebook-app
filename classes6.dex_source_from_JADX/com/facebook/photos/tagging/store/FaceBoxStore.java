package com.facebook.photos.tagging.store;

import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.media.MediaIdKey;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.base.photos.LocalPhoto;
import com.facebook.photos.base.tagging.FaceBox;
import com.facebook.photos.base.tagging.TaggablePhoto;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: group_rank_coefficient */
public class FaceBoxStore implements IHaveUserData {
    private static volatile FaceBoxStore f13418d;
    public final Map<MediaIdKey, List<FaceBox>> f13419a = Collections.synchronizedMap(new HashMap());
    private final Set<String> f13420b = new HashSet();
    private FaceboxOrientationHelper f13421c;

    public static com.facebook.photos.tagging.store.FaceBoxStore m21127a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f13418d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.tagging.store.FaceBoxStore.class;
        monitor-enter(r1);
        r0 = f13418d;	 Catch:{ all -> 0x003a }
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
        r0 = m21128b(r0);	 Catch:{ all -> 0x0035 }
        f13418d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13418d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.tagging.store.FaceBoxStore.a(com.facebook.inject.InjectorLike):com.facebook.photos.tagging.store.FaceBoxStore");
    }

    private static FaceBoxStore m21128b(InjectorLike injectorLike) {
        return new FaceBoxStore(new FaceboxOrientationHelper());
    }

    @Inject
    public FaceBoxStore(FaceboxOrientationHelper faceboxOrientationHelper) {
        this.f13421c = faceboxOrientationHelper;
    }

    public final void m21130a(PhotoItem photoItem) {
        m21131a(photoItem.f12739f, null);
    }

    @Deprecated
    @Nullable
    public final List<FaceBox> m21129a(TaggablePhoto taggablePhoto) {
        return (List) this.f13419a.get(taggablePhoto.mo1094a());
    }

    public final boolean m21134b(TaggablePhoto taggablePhoto) {
        return (m21129a(taggablePhoto) == null || m21129a(taggablePhoto).isEmpty()) ? false : true;
    }

    public final boolean m21135c(TaggablePhoto taggablePhoto) {
        return m21129a(taggablePhoto) != null;
    }

    public final void m21131a(TaggablePhoto taggablePhoto, @Nullable List<FaceBox> list) {
        if ((taggablePhoto instanceof LocalPhoto) && list != null) {
            list = FaceboxOrientationHelper.m21140a(list, ((LocalPhoto) taggablePhoto).f12749e);
        }
        this.f13419a.put(taggablePhoto.mo1094a(), list);
    }

    public final boolean m21136d(TaggablePhoto taggablePhoto) {
        if (!m21134b(taggablePhoto)) {
            return false;
        }
        for (FaceBox o : m21129a(taggablePhoto)) {
            if (!o.m20169o()) {
                return false;
            }
        }
        return true;
    }

    public final void m21132a(String str) {
        this.f13420b.add(str);
    }

    public final void m21133b(String str) {
        this.f13420b.remove(str);
        if (this.f13420b.isEmpty()) {
            clearUserData();
        }
    }

    public void clearUserData() {
        this.f13419a.clear();
    }
}
