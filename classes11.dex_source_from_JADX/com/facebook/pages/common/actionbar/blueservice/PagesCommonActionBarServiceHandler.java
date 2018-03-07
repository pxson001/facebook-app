package com.facebook.pages.common.actionbar.blueservice;

import com.facebook.api.feedcache.memory.ToggleSaveParams;
import com.facebook.controller.mutation.util.FeedbackGraphQLGenerator;
import com.facebook.fbservice.service.ApiMethodNotFoundException;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.feed.protocol.PlaceSaveMethod;
import com.facebook.feed.protocol.PlaceUnsaveMethod;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: store_locator_args */
public class PagesCommonActionBarServiceHandler implements BlueServiceHandler {
    private static volatile PagesCommonActionBarServiceHandler f1348f;
    public final Provider<SingleMethodRunner> f1349a;
    public final Lazy<ReportPlaceMethod> f1350b;
    public final Lazy<PlaceUnsaveMethod> f1351c;
    public final Lazy<PlaceSaveMethod> f1352d;
    public final Lazy<FeedbackGraphQLGenerator> f1353e;

    public static com.facebook.pages.common.actionbar.blueservice.PagesCommonActionBarServiceHandler m1998a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1348f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.pages.common.actionbar.blueservice.PagesCommonActionBarServiceHandler.class;
        monitor-enter(r1);
        r0 = f1348f;	 Catch:{ all -> 0x003a }
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
        r0 = m1999b(r0);	 Catch:{ all -> 0x0035 }
        f1348f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1348f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.actionbar.blueservice.PagesCommonActionBarServiceHandler.a(com.facebook.inject.InjectorLike):com.facebook.pages.common.actionbar.blueservice.PagesCommonActionBarServiceHandler");
    }

    private static PagesCommonActionBarServiceHandler m1999b(InjectorLike injectorLike) {
        return new PagesCommonActionBarServiceHandler(IdBasedSingletonScopeProvider.a(injectorLike, 2289), IdBasedLazy.a(injectorLike, 8906), IdBasedLazy.a(injectorLike, 5894), IdBasedLazy.a(injectorLike, 5893), IdBasedLazy.a(injectorLike, 995));
    }

    @Inject
    public PagesCommonActionBarServiceHandler(Provider<SingleMethodRunner> provider, Lazy<ReportPlaceMethod> lazy, Lazy<PlaceUnsaveMethod> lazy2, Lazy<PlaceSaveMethod> lazy3, Lazy<FeedbackGraphQLGenerator> lazy4) {
        this.f1349a = provider;
        this.f1350b = lazy;
        this.f1351c = lazy2;
        this.f1352d = lazy3;
        this.f1353e = lazy4;
    }

    public final OperationResult m2000a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("report_place".equals(str)) {
            ((AbstractSingleMethodRunner) this.f1349a.get()).a((ApiMethod) this.f1350b.get(), (ReportPlaceParams) operationParams.c.getParcelable("reportPlaceParams"));
            return OperationResult.a;
        } else if ("toggle_place_save_from_page".equals(str)) {
            Boolean bool;
            OperationResult operationResult;
            ToggleSaveParams toggleSaveParams = (ToggleSaveParams) operationParams.c.getParcelable("togglePlaceSaveParams");
            AbstractSingleMethodRunner abstractSingleMethodRunner = (AbstractSingleMethodRunner) this.f1349a.get();
            if (toggleSaveParams.e) {
                bool = (Boolean) abstractSingleMethodRunner.a((ApiMethod) this.f1352d.get(), toggleSaveParams);
            } else {
                bool = (Boolean) abstractSingleMethodRunner.a((ApiMethod) this.f1351c.get(), toggleSaveParams);
            }
            if (bool.booleanValue()) {
                ((FeedbackGraphQLGenerator) this.f1353e.get()).a(toggleSaveParams.b, toggleSaveParams.e ? GraphQLSavedState.SAVED : GraphQLSavedState.NOT_SAVED);
                operationResult = OperationResult.a;
            } else {
                operationResult = OperationResult.a(ErrorCode.OTHER);
            }
            return operationResult;
        } else {
            throw new ApiMethodNotFoundException(str);
        }
    }
}
