package com.facebook.appdiscovery.lite.ui.rows.sections;

import com.facebook.appdiscovery.lite.ui.rows.sections.actor.ActorHeaderPartDefinition;
import com.facebook.appdiscovery.lite.ui.rows.sections.actor.MessagePartDefinition;
import com.facebook.appdiscovery.lite.ui.rows.sections.appdetails.AppInfoPartDefinition;
import com.facebook.appdiscovery.lite.ui.rows.sections.appdetails.CallToActionPartDefinition;
import com.facebook.appdiscovery.lite.ui.rows.sections.appdetails.CoverImagePartDefinition;
import com.facebook.appdiscovery.lite.ui.rows.sections.appdetails.SocialContextPartDefinition;
import com.facebook.appdiscovery.lite.ui.rows.sections.appdetails.UserFacepilePartDefinition;
import com.facebook.appdiscovery.lite.ui.rows.sections.relatedapps.RelatedAppPageItemPartDefinition;
import com.facebook.appdiscovery.lite.ui.rows.sections.seemore.HeaderSeeMorePartDefinition;
import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.multirow.api.ViewType;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.facebook.ui.recyclableviewpool.RecyclableViewsDeclaration;
import com.google.common.collect.ImmutableList;
import javax.inject.Singleton;

@Singleton
/* compiled from: nux_ids */
public class AppDiscoveryDeclarations implements FeedRowSupportDeclaration, RecyclableViewsDeclaration {
    private static final ImmutableList<ViewType> f6487a = ImmutableList.of(HeaderSeeMorePartDefinition.f6489a, ActorHeaderPartDefinition.f6493a, CoverImagePartDefinition.f6502a, AppInfoPartDefinition.f6509a, UserFacepilePartDefinition.f6517a, SocialContextPartDefinition.f6520a, CallToActionPartDefinition.f6524a, MessagePartDefinition.f6529a);
    private static volatile AppDiscoveryDeclarations f6488b;

    public static com.facebook.appdiscovery.lite.ui.rows.sections.AppDiscoveryDeclarations m6905a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6488b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.appdiscovery.lite.ui.rows.sections.AppDiscoveryDeclarations.class;
        monitor-enter(r1);
        r0 = f6488b;	 Catch:{ all -> 0x0039 }
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
        r0 = m6904a();	 Catch:{ all -> 0x0034 }
        f6488b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f6488b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appdiscovery.lite.ui.rows.sections.AppDiscoveryDeclarations.a(com.facebook.inject.InjectorLike):com.facebook.appdiscovery.lite.ui.rows.sections.AppDiscoveryDeclarations");
    }

    private static AppDiscoveryDeclarations m6904a() {
        return new AppDiscoveryDeclarations();
    }

    public final void m6906a(ListItemRowController listItemRowController) {
        int size = f6487a.size();
        for (int i = 0; i < size; i++) {
            listItemRowController.a((ViewType) f6487a.get(i));
        }
    }

    public final void m6907a(RecyclableViewPoolManager recyclableViewPoolManager) {
        recyclableViewPoolManager.m6901a(RelatedAppPageItemPartDefinition.f6533a.getClass(), RecyclableViewPoolManager.f6446a, RecyclableViewPoolManager.f6450e);
    }
}
