package com.facebook.gametime.ui.components.partdefinition.match;

import com.facebook.components.annotations.LayoutSpec;
import com.facebook.gametime.util.GametimeUtil;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@LayoutSpec
/* compiled from: SuggestionsFragment.onLoadNullState */
public class GametimeMatchComponentSpec {
    private static volatile GametimeMatchComponentSpec f25215d;
    public final GametimeMatchTeamComponent f25216a;
    public final GametimeMatchStatusComponent f25217b;
    public final GametimeUtil f25218c;

    public static com.facebook.gametime.ui.components.partdefinition.match.GametimeMatchComponentSpec m27162a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f25215d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.gametime.ui.components.partdefinition.match.GametimeMatchComponentSpec.class;
        monitor-enter(r1);
        r0 = f25215d;	 Catch:{ all -> 0x003a }
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
        r0 = m27163b(r0);	 Catch:{ all -> 0x0035 }
        f25215d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f25215d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.gametime.ui.components.partdefinition.match.GametimeMatchComponentSpec.a(com.facebook.inject.InjectorLike):com.facebook.gametime.ui.components.partdefinition.match.GametimeMatchComponentSpec");
    }

    private static GametimeMatchComponentSpec m27163b(InjectorLike injectorLike) {
        return new GametimeMatchComponentSpec(GametimeMatchTeamComponent.m27177a(injectorLike), GametimeMatchStatusComponent.m27167a(injectorLike), GametimeUtil.a(injectorLike));
    }

    @Inject
    public GametimeMatchComponentSpec(GametimeMatchTeamComponent gametimeMatchTeamComponent, GametimeMatchStatusComponent gametimeMatchStatusComponent, GametimeUtil gametimeUtil) {
        this.f25216a = gametimeMatchTeamComponent;
        this.f25217b = gametimeMatchStatusComponent;
        this.f25218c = gametimeUtil;
    }
}
