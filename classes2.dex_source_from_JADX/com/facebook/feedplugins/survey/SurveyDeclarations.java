package com.facebook.feedplugins.survey;

import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.feed.rows.core.RootPartRegistrationController;
import com.facebook.feed.rows.core.RootPartsDeclaration;
import com.facebook.graphql.model.GraphQLSurveyFeedUnit;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: jpeg */
public class SurveyDeclarations implements FeedRowSupportDeclaration, RootPartsDeclaration {
    private static volatile SurveyDeclarations f18580b;
    private Lazy<SurveyGroupPartDefinition> f18581a;

    public static com.facebook.feedplugins.survey.SurveyDeclarations m26054a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f18580b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedplugins.survey.SurveyDeclarations.class;
        monitor-enter(r1);
        r0 = f18580b;	 Catch:{ all -> 0x003a }
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
        r0 = m26055b(r0);	 Catch:{ all -> 0x0035 }
        f18580b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f18580b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedplugins.survey.SurveyDeclarations.a(com.facebook.inject.InjectorLike):com.facebook.feedplugins.survey.SurveyDeclarations");
    }

    private static SurveyDeclarations m26055b(InjectorLike injectorLike) {
        return new SurveyDeclarations(IdBasedLazy.m1808a(injectorLike, 6610));
    }

    @Inject
    SurveyDeclarations(Lazy<SurveyGroupPartDefinition> lazy) {
        this.f18581a = lazy;
    }

    public final void mo2998a(ListItemRowController listItemRowController) {
        listItemRowController.m16558a(SurveyPagePartDefinition.a);
    }

    public final void mo2995a(RootPartRegistrationController rootPartRegistrationController) {
        rootPartRegistrationController.m25196a(GraphQLSurveyFeedUnit.class, this.f18581a);
    }
}
