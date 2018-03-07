package com.facebook.messengerwear.support;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.common.executors.BackgroundExecutorService;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.InjectorLike;
import com.facebook.messengerwear.support.MessengerWearMediaManager.C06951;
import com.facebook.messengerwear.support.graphql.MessengerWearStickersGraphQL.FetchRecentlyUsedStickersQueryString;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.ultralight.Inject;
import com.google.common.util.concurrent.Futures;
import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import javax.inject.Singleton;

@Singleton
/* compiled from: photo_height */
public class MessengerWearSoftAlarm {
    private static final Class f5067f = MessengerWearSoftAlarm.class;
    private static volatile MessengerWearSoftAlarm f5068g;
    @Inject
    public Clock f5069a;
    @Inject
    public FbSharedPreferences f5070b;
    @Inject
    public MessengerWearMediaManager f5071c;
    @BackgroundExecutorService
    @Inject
    public ExecutorService f5072d;
    AlarmHandler f5073e;

    /* compiled from: photo_height */
    class AlarmHandler extends Handler {
        final /* synthetic */ MessengerWearSoftAlarm f5066a;

        /* compiled from: photo_height */
        class C06991 implements Runnable {
            final /* synthetic */ AlarmHandler f5065a;

            C06991(AlarmHandler alarmHandler) {
                this.f5065a = alarmHandler;
            }

            public void run() {
                MessengerWearMediaManager messengerWearMediaManager = this.f5065a.f5066a.f5071c;
                Futures.a(messengerWearMediaManager.f5063e.a(GraphQLRequest.a((FetchRecentlyUsedStickersQueryString) new FetchRecentlyUsedStickersQueryString().a("sticker_count", Integer.valueOf(8)))), new C06951(messengerWearMediaManager), messengerWearMediaManager.f5062d);
            }
        }

        AlarmHandler(MessengerWearSoftAlarm messengerWearSoftAlarm, Looper looper) {
            this.f5066a = messengerWearSoftAlarm;
            super(looper);
        }

        public void handleMessage(Message message) {
            MessengerWearSoftAlarm.m4557a(this.f5066a, this.f5066a.f5069a.a() + 86400000);
            this.f5066a.f5073e.sendEmptyMessageDelayed(1, 86400000);
            ExecutorDetour.a(this.f5066a.f5072d, new C06991(this), -1704506400);
        }
    }

    public static com.facebook.messengerwear.support.MessengerWearSoftAlarm m4558a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5068g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messengerwear.support.MessengerWearSoftAlarm.class;
        monitor-enter(r1);
        r0 = f5068g;	 Catch:{ all -> 0x003a }
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
        r0 = m4559b(r0);	 Catch:{ all -> 0x0035 }
        f5068g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5068g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messengerwear.support.MessengerWearSoftAlarm.a(com.facebook.inject.InjectorLike):com.facebook.messengerwear.support.MessengerWearSoftAlarm");
    }

    private static MessengerWearSoftAlarm m4559b(InjectorLike injectorLike) {
        MessengerWearSoftAlarm messengerWearSoftAlarm = new MessengerWearSoftAlarm();
        FbSharedPreferences fbSharedPreferences = (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike);
        MessengerWearMediaManager a = MessengerWearMediaManager.m4552a(injectorLike);
        ExecutorService executorService = (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike);
        messengerWearSoftAlarm.f5069a = (Clock) SystemClockMethodAutoProvider.a(injectorLike);
        messengerWearSoftAlarm.f5070b = fbSharedPreferences;
        messengerWearSoftAlarm.f5071c = a;
        messengerWearSoftAlarm.f5072d = executorService;
        return messengerWearSoftAlarm;
    }

    public final void m4560a() {
        long a = this.f5069a.a();
        long a2 = this.f5070b.a(MessengerWearPrefKeys.d, 0);
        DateFormat.getDateTimeInstance().format(new Date(a2));
        if (a2 == 0 || a2 < a) {
            a2 = m4557a(this, 10000 + a);
        }
        this.f5073e = new AlarmHandler(this, Looper.getMainLooper());
        this.f5073e.sendEmptyMessageDelayed(1, a2 - a);
    }

    public static long m4557a(MessengerWearSoftAlarm messengerWearSoftAlarm, long j) {
        DateFormat.getDateTimeInstance().format(new Date(j));
        messengerWearSoftAlarm.f5070b.edit().a(MessengerWearPrefKeys.d, j).commit();
        return j;
    }
}
