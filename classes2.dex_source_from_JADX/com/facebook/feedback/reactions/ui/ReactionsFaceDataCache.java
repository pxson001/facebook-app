package com.facebook.feedback.reactions.ui;

import android.content.res.Resources;
import android.support.v4.util.SparseArrayCompat;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.C0087xd695ba9d;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.feedback.reactions.ui.deserializers.ReactionsAnimationDeserializer;
import com.facebook.feedback.reactions.ui.deserializers.ReactionsAnimationFrameDeserializer;
import com.facebook.feedback.reactions.ui.deserializers.ReactionsAnimationGroupDeserializer;
import com.facebook.feedback.reactions.ui.deserializers.ReactionsColorFrameDeserializer;
import com.facebook.feedback.reactions.ui.deserializers.ReactionsFaceDeserializer;
import com.facebook.feedback.reactions.ui.deserializers.ReactionsFeatureDeserializer;
import com.facebook.feedback.reactions.ui.deserializers.ReactionsFeatureEffectDeserializer;
import com.facebook.feedback.reactions.ui.deserializers.ReactionsFeatureFrameDeserializer;
import com.facebook.feedback.reactions.ui.deserializers.ReactionsGradientColorDeserializer;
import com.facebook.feedback.reactions.ui.deserializers.ReactionsGradientDeserializer;
import com.facebook.inject.InjectorLike;
import com.facebook.reactionsanimations.data.ReactionsAnimation;
import com.facebook.reactionsanimations.data.ReactionsAnimationFrame;
import com.facebook.reactionsanimations.data.ReactionsAnimationGroup;
import com.facebook.reactionsanimations.data.ReactionsColorFrame;
import com.facebook.reactionsanimations.data.ReactionsFace;
import com.facebook.reactionsanimations.data.ReactionsFeature;
import com.facebook.reactionsanimations.data.ReactionsFeatureEffect;
import com.facebook.reactionsanimations.data.ReactionsFeatureFrame;
import com.facebook.reactionsanimations.data.ReactionsGradient;
import com.facebook.reactionsanimations.data.ReactionsGradientColor;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: harrison_current_tab */
public class ReactionsFaceDataCache {
    public static final Class<?> f21409a = ReactionsFaceDataCache.class;
    private static volatile ReactionsFaceDataCache f21410h;
    public final Resources f21411b;
    public final FbObjectMapper f21412c;
    private final ExecutorService f21413d;
    public final SparseArrayCompat<ReactionsFace> f21414e = new SparseArrayCompat();
    private final Map<String, Future> f21415f = new HashMap();
    private final Set<String> f21416g = new HashSet();

    public static com.facebook.feedback.reactions.ui.ReactionsFaceDataCache m29129a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f21410h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedback.reactions.ui.ReactionsFaceDataCache.class;
        monitor-enter(r1);
        r0 = f21410h;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m29130b(r0);	 Catch:{ all -> 0x0035 }
        f21410h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21410h;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedback.reactions.ui.ReactionsFaceDataCache.a(com.facebook.inject.InjectorLike):com.facebook.feedback.reactions.ui.ReactionsFaceDataCache");
    }

    private static ReactionsFaceDataCache m29130b(InjectorLike injectorLike) {
        return new ReactionsFaceDataCache(ResourcesMethodAutoProvider.m6510a(injectorLike), FbObjectMapperMethodAutoProvider.m6609a(injectorLike), C0087xd695ba9d.m2486a(injectorLike));
    }

    @Inject
    public ReactionsFaceDataCache(Resources resources, FbObjectMapper fbObjectMapper, ExecutorService executorService) {
        this.f21411b = resources;
        this.f21412c = fbObjectMapper;
        this.f21413d = executorService;
        GlobalAutoGenDeserializerCache.m11718a(ReactionsAnimation.class, new ReactionsAnimationDeserializer());
        GlobalAutoGenDeserializerCache.m11718a(ReactionsAnimationFrame.class, new ReactionsAnimationFrameDeserializer());
        GlobalAutoGenDeserializerCache.m11718a(ReactionsAnimationGroup.class, new ReactionsAnimationGroupDeserializer());
        GlobalAutoGenDeserializerCache.m11718a(ReactionsColorFrame.class, new ReactionsColorFrameDeserializer());
        GlobalAutoGenDeserializerCache.m11718a(ReactionsFace.class, new ReactionsFaceDeserializer());
        GlobalAutoGenDeserializerCache.m11718a(ReactionsFeature.class, new ReactionsFeatureDeserializer());
        GlobalAutoGenDeserializerCache.m11718a(ReactionsFeatureEffect.class, new ReactionsFeatureEffectDeserializer());
        GlobalAutoGenDeserializerCache.m11718a(ReactionsFeatureFrame.class, new ReactionsFeatureFrameDeserializer());
        GlobalAutoGenDeserializerCache.m11718a(ReactionsGradientColor.class, new ReactionsGradientColorDeserializer());
        GlobalAutoGenDeserializerCache.m11718a(ReactionsGradient.class, new ReactionsGradientDeserializer());
    }

    public final void m29136a(int i, File file) {
        String b = m29131b("disk_face_", i);
        if (!m29132b(b)) {
            this.f21415f.put(b, ExecutorDetour.a(this.f21413d, new PrepareDiskFaceRunnable(this, b, i, file), 1546475729));
        }
    }

    public final void m29137a(ReactionsClientInfo reactionsClientInfo) {
        String b = m29131b("apk_faces_", reactionsClientInfo.l);
        if (!m29132b(b)) {
            this.f21415f.put(b, ExecutorDetour.a(this.f21413d, new PrepareAPKFaceRunnable(this, reactionsClientInfo), -1994478471));
        }
    }

    @Nullable
    public final ReactionsFace m29135a(int i) {
        return (ReactionsFace) this.f21414e.m6350a(i);
    }

    public static String m29131b(String str, int i) {
        return str + i;
    }

    private boolean m29132b(String str) {
        return this.f21415f.containsKey(str) || this.f21416g.contains(str);
    }

    public static synchronized void m29133c(ReactionsFaceDataCache reactionsFaceDataCache, String str) {
        synchronized (reactionsFaceDataCache) {
            reactionsFaceDataCache.f21415f.remove(str);
            reactionsFaceDataCache.f21416g.add(str);
        }
    }

    public static String m29134d(String str) {
        return str.replace("/", "_");
    }
}
