package com.facebook.appdiscovery.lite.model.factory;

import com.facebook.appdiscovery.lite.model.unit.LiteRelatedAppsFeedUnit;
import com.facebook.appdiscovery.lite.protocol.FetchLiteResultsGraphQLInterfaces.AppStoryQueryFragment;
import com.facebook.appdiscovery.lite.protocol.FetchLiteResultsGraphQLModels.AppSectionQueryFragmentModel;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.inject.InjectorLike;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: is_font_family */
public class LiteRelatedAppsFeedUnitFactory extends LiteFeedUnitFactory<LiteRelatedAppsFeedUnit, AppStoryQueryFragment> {
    private static volatile LiteRelatedAppsFeedUnitFactory f10578b;

    public static com.facebook.appdiscovery.lite.model.factory.LiteRelatedAppsFeedUnitFactory m12482a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10578b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.appdiscovery.lite.model.factory.LiteRelatedAppsFeedUnitFactory.class;
        monitor-enter(r1);
        r0 = f10578b;	 Catch:{ all -> 0x003a }
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
        r0 = m12483b(r0);	 Catch:{ all -> 0x0035 }
        f10578b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10578b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appdiscovery.lite.model.factory.LiteRelatedAppsFeedUnitFactory.a(com.facebook.inject.InjectorLike):com.facebook.appdiscovery.lite.model.factory.LiteRelatedAppsFeedUnitFactory");
    }

    private static LiteRelatedAppsFeedUnitFactory m12483b(InjectorLike injectorLike) {
        return new LiteRelatedAppsFeedUnitFactory((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Nullable
    public final /* synthetic */ FeedUnit mo745a(AppSectionQueryFragmentModel appSectionQueryFragmentModel) {
        return m12484d(appSectionQueryFragmentModel);
    }

    @Nullable
    public final /* synthetic */ FeedUnit mo744a(Object obj) {
        return m12484d((AppSectionQueryFragmentModel) obj);
    }

    @Inject
    public LiteRelatedAppsFeedUnitFactory(AbstractFbErrorReporter abstractFbErrorReporter) {
        super(abstractFbErrorReporter);
    }

    @Nullable
    private LiteRelatedAppsFeedUnit m12484d(AppSectionQueryFragmentModel appSectionQueryFragmentModel) {
        return new LiteRelatedAppsFeedUnit(appSectionQueryFragmentModel.m(), appSectionQueryFragmentModel.j(), appSectionQueryFragmentModel.k(), m12471b(appSectionQueryFragmentModel));
    }
}
