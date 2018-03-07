package com.facebook.feedplugins.base.footer;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feedplugins.base.BaseFeedPluginModule;
import com.facebook.inject.InjectorLike;
import java.util.EnumMap;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: is_photo_reminder_nux_shown */
public class DefaultFooterBackgroundStyleResolver {
    private static volatile DefaultFooterBackgroundStyleResolver f18961b;
    private final EnumMap<FooterLevel, FooterBackgroundStyleDefinition> f18962a;

    public static com.facebook.feedplugins.base.footer.DefaultFooterBackgroundStyleResolver m26661a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f18961b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedplugins.base.footer.DefaultFooterBackgroundStyleResolver.class;
        monitor-enter(r1);
        r0 = f18961b;	 Catch:{ all -> 0x003a }
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
        r0 = m26662b(r0);	 Catch:{ all -> 0x0035 }
        f18961b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f18961b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedplugins.base.footer.DefaultFooterBackgroundStyleResolver.a(com.facebook.inject.InjectorLike):com.facebook.feedplugins.base.footer.DefaultFooterBackgroundStyleResolver");
    }

    private static DefaultFooterBackgroundStyleResolver m26662b(InjectorLike injectorLike) {
        return new DefaultFooterBackgroundStyleResolver(BaseFeedPluginModule.m26664a(ResourcesMethodAutoProvider.m6510a(injectorLike), DefaultPaddingStyleResolver.m19157a(injectorLike)));
    }

    @Inject
    public DefaultFooterBackgroundStyleResolver(EdgeToEdgeFooterBackgroundStyleConfig edgeToEdgeFooterBackgroundStyleConfig) {
        this.f18962a = edgeToEdgeFooterBackgroundStyleConfig.m26677d();
    }

    public final FooterBackgroundStyleDefinition m26663a(FooterLevel footerLevel) {
        return (FooterBackgroundStyleDefinition) this.f18962a.get(footerLevel);
    }
}
