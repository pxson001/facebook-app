package com.facebook.friendsharing.souvenirs.models;

import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.core.JsonParseException;
import com.google.common.base.Strings;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: RESUMED */
public class SouvenirsFormattedStringHelper {
    private static volatile SouvenirsFormattedStringHelper f24078b;
    private final FbObjectMapper f24079a;

    public static com.facebook.friendsharing.souvenirs.models.SouvenirsFormattedStringHelper m26207a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f24078b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.friendsharing.souvenirs.models.SouvenirsFormattedStringHelper.class;
        monitor-enter(r1);
        r0 = f24078b;	 Catch:{ all -> 0x003a }
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
        r0 = m26208b(r0);	 Catch:{ all -> 0x0035 }
        f24078b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f24078b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.friendsharing.souvenirs.models.SouvenirsFormattedStringHelper.a(com.facebook.inject.InjectorLike):com.facebook.friendsharing.souvenirs.models.SouvenirsFormattedStringHelper");
    }

    private static SouvenirsFormattedStringHelper m26208b(InjectorLike injectorLike) {
        return new SouvenirsFormattedStringHelper(FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SouvenirsFormattedStringHelper(FbObjectMapper fbObjectMapper) {
        this.f24079a = fbObjectMapper;
    }

    public final ImmutableList<SouvenirFormattingStringModel> m26209a(String str) {
        if (Strings.isNullOrEmpty(str)) {
            return ImmutableList.of();
        }
        Builder builder = new Builder();
        try {
            Iterator b = this.f24079a.b().a(str).b(SouvenirFormattingStringModel.class);
            while (b.hasNext()) {
                builder.c((SouvenirFormattingStringModel) b.next());
            }
        } catch (JsonParseException e) {
            Throwables.propagate(e);
        } catch (Throwable e2) {
            Throwables.propagate(e2);
        }
        return builder.b();
    }
}
