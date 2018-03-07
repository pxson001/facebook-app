package com.facebook.messaging.business.ride.utils;

import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.location.Coordinates;
import com.facebook.messages.links.MessengerLinks;
import com.facebook.messaging.business.ride.utils.RideServiceParams.RideServiceParamsBuilder;
import com.facebook.messaging.util.MessengerAppUtils;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: mnc */
public class RideshareUtil {
    private static final String f9317a = RideUtilsModule.class.getName();
    private static volatile RideshareUtil f9318e;
    private final MessengerAppUtils f9319b;
    private final GatekeeperStoreImpl f9320c;
    private final AbstractFbErrorReporter f9321d;

    public static com.facebook.messaging.business.ride.utils.RideshareUtil m9769a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9318e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.business.ride.utils.RideshareUtil.class;
        monitor-enter(r1);
        r0 = f9318e;	 Catch:{ all -> 0x003a }
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
        r0 = m9770b(r0);	 Catch:{ all -> 0x0035 }
        f9318e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9318e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.business.ride.utils.RideshareUtil.a(com.facebook.inject.InjectorLike):com.facebook.messaging.business.ride.utils.RideshareUtil");
    }

    private static RideshareUtil m9770b(InjectorLike injectorLike) {
        return new RideshareUtil(MessengerAppUtils.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public RideshareUtil(MessengerAppUtils messengerAppUtils, GatekeeperStoreImpl gatekeeperStoreImpl, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f9319b = messengerAppUtils;
        this.f9320c = gatekeeperStoreImpl;
        this.f9321d = abstractFbErrorReporter;
    }

    public final boolean m9772a() {
        return this.f9320c.a(304, false) && this.f9319b.b() && this.f9319b.d() && this.f9319b.a("61.0");
    }

    public static Uri m9768a(@Nullable String str, @Nullable Double d, @Nullable Double d2, @Nullable String str2, @Nullable String str3) {
        Builder buildUpon = Uri.parse(MessengerLinks.O).buildUpon();
        if (!Strings.isNullOrEmpty(str)) {
            buildUpon.appendQueryParameter("dest_address", str);
        }
        if (!Strings.isNullOrEmpty(str2)) {
            buildUpon.appendQueryParameter("provider_name", str2);
        }
        if (!Strings.isNullOrEmpty(str3)) {
            buildUpon.appendQueryParameter("logging_tag", str3);
        }
        if (!(d == null || d2 == null)) {
            buildUpon.appendQueryParameter("dest_lat", d.toString()).appendQueryParameter("dest_long", d2.toString());
        }
        return buildUpon.build();
    }

    public final RideServiceParams m9771a(Uri uri) {
        Preconditions.checkNotNull(uri);
        String queryParameter = uri.getQueryParameter("dest_lat");
        String queryParameter2 = uri.getQueryParameter("dest_long");
        String queryParameter3 = uri.getQueryParameter("dest_address");
        String queryParameter4 = uri.getQueryParameter("provider_name");
        String queryParameter5 = uri.getQueryParameter("logging_tag");
        String queryParameter6 = uri.getQueryParameter("promo_data");
        Coordinates coordinates = null;
        if (!(Strings.isNullOrEmpty(queryParameter) || Strings.isNullOrEmpty(queryParameter2))) {
            try {
                Double valueOf = Double.valueOf(Double.parseDouble(queryParameter2));
                coordinates = Coordinates.newBuilder().b(valueOf).a(Double.valueOf(Double.parseDouble(queryParameter))).d();
            } catch (Throwable e) {
                this.f9321d.a(f9317a, e);
            }
        }
        return new RideServiceParamsBuilder().m9762a("order_ride_deep_linking").m9763b(queryParameter3).m9761a(coordinates).m9764c(queryParameter4).m9765e(queryParameter5).m9766f(queryParameter6).m9767j();
    }
}
