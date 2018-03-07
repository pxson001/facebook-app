package com.facebook.timeline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.analytics.tagging.CurrentModuleHolder;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.timeline.intent.ModelBundleGraphQLInterfaces.ModelBundleProfileGraphQL;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: groups_seeds_composer_create_file */
public class TimelineFragmentFactory implements IFragmentFactory {
    private static volatile TimelineFragmentFactory f10240b;
    private final CurrentModuleHolder f10241a;

    public static com.facebook.timeline.TimelineFragmentFactory m10328a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10240b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.TimelineFragmentFactory.class;
        monitor-enter(r1);
        r0 = f10240b;	 Catch:{ all -> 0x003a }
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
        r0 = m10329b(r0);	 Catch:{ all -> 0x0035 }
        f10240b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10240b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.TimelineFragmentFactory.a(com.facebook.inject.InjectorLike):com.facebook.timeline.TimelineFragmentFactory");
    }

    private static TimelineFragmentFactory m10329b(InjectorLike injectorLike) {
        return new TimelineFragmentFactory(CurrentModuleHolder.a(injectorLike));
    }

    @Inject
    public TimelineFragmentFactory(CurrentModuleHolder currentModuleHolder) {
        this.f10241a = currentModuleHolder;
    }

    public final Fragment m10330a(Intent intent) {
        return m10327a((ModelBundleProfileGraphQL) FlatBufferModelHelper.a(intent, "graphql_profile"), this.f10241a.a("unknown"), intent.getExtras());
    }

    private static Fragment m10327a(ModelBundleProfileGraphQL modelBundleProfileGraphQL, String str, Bundle bundle) {
        TimelineFragment timelineFragment = new TimelineFragment();
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("session_id", SafeUUIDGenerator.a().toString());
        FlatBufferModelHelper.a(bundle, "graphql_profile", modelBundleProfileGraphQL);
        bundle.putString("navigation_source", str);
        if (!bundle.containsKey("com.facebook.katana.profile.id")) {
            bundle.putLong("com.facebook.katana.profile.id", -1);
        }
        timelineFragment.g(bundle);
        return timelineFragment;
    }
}
