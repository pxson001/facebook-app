package com.facebook.friendsharing.souvenirs.verve;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.greetingcards.verve.model.VMDeck;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.core.JsonParseException;
import com.google.common.base.Throwables;
import com.google.common.io.Closeables;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: PushNotificationsMuteMutation */
public class SouvenirsLocalTemplateHelper {
    private static volatile SouvenirsLocalTemplateHelper f24240d;
    private final Resources f24241a;
    private final FbObjectMapper f24242b;
    @DefaultExecutorService
    public final ListeningExecutorService f24243c;

    /* compiled from: PushNotificationsMuteMutation */
    public class C21101 implements Callable<VMDeck> {
        final /* synthetic */ SouvenirsLocalTemplateHelper f24239a;

        public C21101(SouvenirsLocalTemplateHelper souvenirsLocalTemplateHelper) {
            this.f24239a = souvenirsLocalTemplateHelper;
        }

        public Object call() {
            return SouvenirsLocalTemplateHelper.m26477b(this.f24239a);
        }
    }

    public static com.facebook.friendsharing.souvenirs.verve.SouvenirsLocalTemplateHelper m26475a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f24240d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.friendsharing.souvenirs.verve.SouvenirsLocalTemplateHelper.class;
        monitor-enter(r1);
        r0 = f24240d;	 Catch:{ all -> 0x003a }
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
        r0 = m26476b(r0);	 Catch:{ all -> 0x0035 }
        f24240d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f24240d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.friendsharing.souvenirs.verve.SouvenirsLocalTemplateHelper.a(com.facebook.inject.InjectorLike):com.facebook.friendsharing.souvenirs.verve.SouvenirsLocalTemplateHelper");
    }

    private static SouvenirsLocalTemplateHelper m26476b(InjectorLike injectorLike) {
        return new SouvenirsLocalTemplateHelper(ResourcesMethodAutoProvider.a(injectorLike), FbObjectMapperMethodAutoProvider.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SouvenirsLocalTemplateHelper(Resources resources, FbObjectMapper fbObjectMapper, ListeningExecutorService listeningExecutorService) {
        this.f24241a = resources;
        this.f24242b = fbObjectMapper;
        this.f24243c = listeningExecutorService;
    }

    public static VMDeck m26477b(SouvenirsLocalTemplateHelper souvenirsLocalTemplateHelper) {
        InputStream inputStream = null;
        VMDeck vMDeck;
        try {
            inputStream = souvenirsLocalTemplateHelper.f24241a.getAssets().open("souvenirs.json");
            vMDeck = (VMDeck) souvenirsLocalTemplateHelper.f24242b.b().a(inputStream).a(VMDeck.class);
            return vMDeck;
        } catch (JsonParseException e) {
            vMDeck = e;
            Throwables.propagate(vMDeck);
            throw new RuntimeException("Error deserializing Deck.");
        } catch (IOException e2) {
            vMDeck = e2;
            Throwables.propagate(vMDeck);
            throw new RuntimeException("Error deserializing Deck.");
        } finally {
            Closeables.a(inputStream);
        }
    }
}
