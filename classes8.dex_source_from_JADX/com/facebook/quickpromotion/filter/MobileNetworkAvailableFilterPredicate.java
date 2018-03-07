package com.facebook.quickpromotion.filter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import com.facebook.common.android.ConnectivityManagerMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: reaction_profile_pic_size */
public class MobileNetworkAvailableFilterPredicate extends AbstractContextualFilterPredicate {
    private static volatile MobileNetworkAvailableFilterPredicate f4709c;
    private final ConnectivityManager f4710a;
    public final Context f4711b;

    public static com.facebook.quickpromotion.filter.MobileNetworkAvailableFilterPredicate m4574a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4709c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.quickpromotion.filter.MobileNetworkAvailableFilterPredicate.class;
        monitor-enter(r1);
        r0 = f4709c;	 Catch:{ all -> 0x003a }
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
        r0 = m4575b(r0);	 Catch:{ all -> 0x0035 }
        f4709c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4709c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.quickpromotion.filter.MobileNetworkAvailableFilterPredicate.a(com.facebook.inject.InjectorLike):com.facebook.quickpromotion.filter.MobileNetworkAvailableFilterPredicate");
    }

    private static MobileNetworkAvailableFilterPredicate m4575b(InjectorLike injectorLike) {
        return new MobileNetworkAvailableFilterPredicate(ConnectivityManagerMethodAutoProvider.b(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public MobileNetworkAvailableFilterPredicate(ConnectivityManager connectivityManager, Context context) {
        this.f4710a = connectivityManager;
        this.f4711b = context;
    }

    public final boolean mo217a(@Nonnull QuickPromotionDefinition quickPromotionDefinition, @Nonnull ContextualFilter contextualFilter) {
        boolean z;
        Preconditions.checkNotNull(contextualFilter.value);
        NetworkInfo networkInfo = this.f4710a.getNetworkInfo(0);
        if (networkInfo != null && networkInfo.isAvailable()) {
            int i = 1;
            if (VERSION.SDK_INT < 17) {
                if (System.getInt(this.f4711b.getContentResolver(), "airplane_mode_on", 0) == 0) {
                    i = 0;
                }
            } else if (Global.getInt(this.f4711b.getContentResolver(), "airplane_mode_on", 0) == 0) {
                i = 0;
            }
            if (i == 0) {
                z = true;
                if (z != Boolean.parseBoolean(contextualFilter.value)) {
                    return true;
                }
                return false;
            }
        }
        z = false;
        if (z != Boolean.parseBoolean(contextualFilter.value)) {
            return false;
        }
        return true;
    }
}
