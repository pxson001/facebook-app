package com.facebook.privacy.audience;

import com.facebook.config.background.AbstractConfigurationComponent;
import com.facebook.graphql.model.GraphQLViewer;
import com.facebook.http.protocol.BatchComponent;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.BatchOperation.Builder;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.privacy.protocol.FetchComposerPrivacyGuardrailInfoMethod;
import com.google.common.collect.ImmutableList;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: row_was_updated */
public class ComposerPrivacyGuardrailFetchComponent extends AbstractConfigurationComponent {
    private static volatile ComposerPrivacyGuardrailFetchComponent f3326c;
    public final FetchComposerPrivacyGuardrailInfoMethod f3327a;
    public final Lazy<StickyGuardrailManager> f3328b;

    /* compiled from: row_was_updated */
    class MyBatchComponent implements BatchComponent {
        final /* synthetic */ ComposerPrivacyGuardrailFetchComponent f3329a;

        public MyBatchComponent(ComposerPrivacyGuardrailFetchComponent composerPrivacyGuardrailFetchComponent) {
            this.f3329a = composerPrivacyGuardrailFetchComponent;
        }

        public final Iterable<BatchOperation> mo99a() {
            Builder a = BatchOperation.m12541a(this.f3329a.f3327a, null);
            a.f11927c = "fetchStickyGuardrailInfo";
            return ImmutableList.of(a.m12549a());
        }

        public final void mo100a(Map<String, Object> map) {
            ((StickyGuardrailManager) this.f3329a.f3328b.get()).m4165a((GraphQLViewer) map.get("fetchStickyGuardrailInfo"));
        }
    }

    public static com.facebook.privacy.audience.ComposerPrivacyGuardrailFetchComponent m3543a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3326c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.privacy.audience.ComposerPrivacyGuardrailFetchComponent.class;
        monitor-enter(r1);
        r0 = f3326c;	 Catch:{ all -> 0x003a }
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
        r0 = m3544b(r0);	 Catch:{ all -> 0x0035 }
        f3326c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3326c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.privacy.audience.ComposerPrivacyGuardrailFetchComponent.a(com.facebook.inject.InjectorLike):com.facebook.privacy.audience.ComposerPrivacyGuardrailFetchComponent");
    }

    private static ComposerPrivacyGuardrailFetchComponent m3544b(InjectorLike injectorLike) {
        return new ComposerPrivacyGuardrailFetchComponent(FetchComposerPrivacyGuardrailInfoMethod.m3546b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3104));
    }

    @Inject
    public ComposerPrivacyGuardrailFetchComponent(FetchComposerPrivacyGuardrailInfoMethod fetchComposerPrivacyGuardrailInfoMethod, Lazy<StickyGuardrailManager> lazy) {
        this.f3327a = fetchComposerPrivacyGuardrailInfoMethod;
        this.f3328b = lazy;
    }

    public final long co_() {
        return 14400000;
    }

    public final BatchComponent mo101b() {
        return new MyBatchComponent(this);
    }
}
