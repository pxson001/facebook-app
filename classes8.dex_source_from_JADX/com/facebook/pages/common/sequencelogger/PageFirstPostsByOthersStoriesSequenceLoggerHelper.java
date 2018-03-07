package com.facebook.pages.common.sequencelogger;

import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.common.constants.PagesPerfConstants.PageSequences;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: creativecam_video_ */
public class PageFirstPostsByOthersStoriesSequenceLoggerHelper {
    private static volatile PageFirstPostsByOthersStoriesSequenceLoggerHelper f16579d;
    public final SequenceLogger f16580a;
    public final Product f16581b;
    public final ImmutableList<? extends AbstractSequenceDefinition> f16582c;

    public static com.facebook.pages.common.sequencelogger.PageFirstPostsByOthersStoriesSequenceLoggerHelper m19605a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f16579d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.pages.common.sequencelogger.PageFirstPostsByOthersStoriesSequenceLoggerHelper.class;
        monitor-enter(r1);
        r0 = f16579d;	 Catch:{ all -> 0x003a }
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
        r0 = m19606b(r0);	 Catch:{ all -> 0x0035 }
        f16579d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16579d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.sequencelogger.PageFirstPostsByOthersStoriesSequenceLoggerHelper.a(com.facebook.inject.InjectorLike):com.facebook.pages.common.sequencelogger.PageFirstPostsByOthersStoriesSequenceLoggerHelper");
    }

    private static PageFirstPostsByOthersStoriesSequenceLoggerHelper m19606b(InjectorLike injectorLike) {
        return new PageFirstPostsByOthersStoriesSequenceLoggerHelper((SequenceLogger) SequenceLoggerImpl.a(injectorLike), ProductMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public PageFirstPostsByOthersStoriesSequenceLoggerHelper(SequenceLogger sequenceLogger, Product product) {
        this.f16580a = sequenceLogger;
        this.f16581b = product;
        if (this.f16581b == Product.PAA) {
            this.f16582c = ImmutableList.of(PageSequences.f1726l);
        } else {
            this.f16582c = ImmutableList.of(PageSequences.f1728n, PageSequences.f1727m);
        }
    }

    public final PageFirstPostsByOthersStoriesSequenceLoggerHelper m19607b() {
        int size = this.f16582c.size();
        for (int i = 0; i < size; i++) {
            AbstractSequenceDefinition abstractSequenceDefinition = (AbstractSequenceDefinition) this.f16582c.get(i);
            if (this.f16580a.e(abstractSequenceDefinition) != null) {
                this.f16580a.d(abstractSequenceDefinition);
            }
        }
        return this;
    }
}
