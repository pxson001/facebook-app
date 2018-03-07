package com.facebook.katana.urimap;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.fragmentconstants.FragmentConstants;
import com.facebook.common.fragmentconstants.FragmentConstants$ContentFragmentType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.crudolib.urimap.runtime.ComponentHelper;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.timeline.TimelineUriMapHelper;
import com.facebook.video.livemap.LiveMapUriMapHelper;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: shutdown */
public class Fb4aComponentHelperFactory {
    private static volatile Fb4aComponentHelperFactory f4849e;
    private final LiveMapUriMapHelper f4850a;
    private final AbstractFbErrorReporter f4851b;
    public final PaymentSettingsPickerScreenActivityComponentHelper f4852c;
    public final TimelineUriMapHelper f4853d;

    public static com.facebook.katana.urimap.Fb4aComponentHelperFactory m8684a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4849e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.katana.urimap.Fb4aComponentHelperFactory.class;
        monitor-enter(r1);
        r0 = f4849e;	 Catch:{ all -> 0x003a }
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
        r0 = m8685b(r0);	 Catch:{ all -> 0x0035 }
        f4849e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4849e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.katana.urimap.Fb4aComponentHelperFactory.a(com.facebook.inject.InjectorLike):com.facebook.katana.urimap.Fb4aComponentHelperFactory");
    }

    private static Fb4aComponentHelperFactory m8685b(InjectorLike injectorLike) {
        return new Fb4aComponentHelperFactory(FbErrorReporterImpl.m2317a(injectorLike), new LiveMapUriMapHelper(), PaymentSettingsPickerScreenActivityComponentHelper.m8690a(injectorLike), new TimelineUriMapHelper(IdBasedProvider.m1811a(injectorLike, 4245), IdBasedProvider.m1811a(injectorLike, 4442)));
    }

    @Inject
    public Fb4aComponentHelperFactory(AbstractFbErrorReporter abstractFbErrorReporter, LiveMapUriMapHelper liveMapUriMapHelper, PaymentSettingsPickerScreenActivityComponentHelper paymentSettingsPickerScreenActivityComponentHelper, TimelineUriMapHelper timelineUriMapHelper) {
        this.f4851b = abstractFbErrorReporter;
        this.f4850a = liveMapUriMapHelper;
        this.f4852c = paymentSettingsPickerScreenActivityComponentHelper;
        this.f4853d = timelineUriMapHelper;
    }

    @Nullable
    public final ComponentHelper m8686a(int i) {
        FragmentConstants$ContentFragmentType a = FragmentConstants.a(i);
        if (a == null) {
            this.f4851b.m2350b("Fb4aComponentHelperFactory", StringFormatUtil.formatStrLocaleSafe("No fragment type for fragmentId = %d", Integer.valueOf(i)));
            return null;
        }
        switch (1.a[a.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
            case 3:
                return this.f4853d;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return this.f4850a;
            default:
                return null;
        }
    }
}
