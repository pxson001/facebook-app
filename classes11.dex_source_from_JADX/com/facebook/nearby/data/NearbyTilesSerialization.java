package com.facebook.nearby.data;

import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.nearby.model.MapTile;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: user_code */
public class NearbyTilesSerialization {
    private static volatile NearbyTilesSerialization f315b;
    public final ObjectMapper f316a;

    public static com.facebook.nearby.data.NearbyTilesSerialization m399a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f315b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.nearby.data.NearbyTilesSerialization.class;
        monitor-enter(r1);
        r0 = f315b;	 Catch:{ all -> 0x003a }
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
        r0 = m400b(r0);	 Catch:{ all -> 0x0035 }
        f315b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f315b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.nearby.data.NearbyTilesSerialization.a(com.facebook.inject.InjectorLike):com.facebook.nearby.data.NearbyTilesSerialization");
    }

    private static NearbyTilesSerialization m400b(InjectorLike injectorLike) {
        return new NearbyTilesSerialization((ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public NearbyTilesSerialization(ObjectMapper objectMapper) {
        this.f316a = objectMapper;
    }

    public final MapTile m402a(String str) {
        return (MapTile) this.f316a.a(str, MapTile.class);
    }

    public static <T extends Comparable<? super T>> String m401c(Set<T> set) {
        Joiner on = Joiner.on(",");
        Iterable a = Lists.a(set);
        Collections.sort(a);
        return on.join(a);
    }

    public final Set<String> m403b(String str) {
        Set<String> a = Sets.a();
        ArrayList a2 = Lists.a(Splitter.on(",").split(str));
        int size = a2.size();
        for (int i = 0; i < size; i++) {
            String str2 = (String) a2.get(i);
            if (!Strings.isNullOrEmpty(str2)) {
                a.add(str2);
            }
        }
        return a;
    }

    public final Set<Long> m404c(String str) {
        Set<Long> a = Sets.a();
        for (String str2 : str.split(",")) {
            if (!Strings.isNullOrEmpty(str2)) {
                a.add(Long.valueOf(Long.parseLong(str2)));
            }
        }
        return a;
    }
}
