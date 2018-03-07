package com.facebook.audiofingerprinting;

import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaeTaggableActivity;
import com.facebook.composer.minutiae.graphql.MinutiaeSuggestionDefaultsGraphQLInterfaces.MinutiaeTaggableSuggestions;
import com.facebook.composer.minutiae.graphql.MinutiaeSuggestionDefaultsGraphQLModels.MinutiaeTaggableSuggestionsModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Collection;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: updated_asset_count */
public class AudioFingerprintingSuggestionsCache {
    private static volatile AudioFingerprintingSuggestionsCache f1068c;
    public ImmutableList<? extends MinutiaeTaggableSuggestions> f1069a = null;
    public MinutiaeTaggableActivity f1070b = null;

    public static com.facebook.audiofingerprinting.AudioFingerprintingSuggestionsCache m1021a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f1068c;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.audiofingerprinting.AudioFingerprintingSuggestionsCache.class;
        monitor-enter(r1);
        r0 = f1068c;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m1022c();	 Catch:{ all -> 0x0034 }
        f1068c = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f1068c;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.audiofingerprinting.AudioFingerprintingSuggestionsCache.a(com.facebook.inject.InjectorLike):com.facebook.audiofingerprinting.AudioFingerprintingSuggestionsCache");
    }

    private static AudioFingerprintingSuggestionsCache m1022c() {
        return new AudioFingerprintingSuggestionsCache();
    }

    public final ImmutableList<? extends MinutiaeTaggableSuggestions> m1023a() {
        return m1024b(this.f1069a);
    }

    public final ImmutableList<? extends MinutiaeTaggableSuggestions> m1024b(@Nullable ImmutableList<? extends MinutiaeTaggableSuggestions> immutableList) {
        if (this.f1070b == null || immutableList == null) {
            return immutableList;
        }
        Collection a = Lists.a();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            MinutiaeTaggableSuggestionsModel minutiaeTaggableSuggestionsModel = (MinutiaeTaggableSuggestionsModel) immutableList.get(i);
            if (minutiaeTaggableSuggestionsModel.c().b().l().equals(this.f1070b.l()) && minutiaeTaggableSuggestionsModel.c().b().n().equals(this.f1070b.n())) {
                a.add(minutiaeTaggableSuggestionsModel);
            }
        }
        if (a.isEmpty()) {
            return null;
        }
        return ImmutableList.copyOf(a);
    }
}
