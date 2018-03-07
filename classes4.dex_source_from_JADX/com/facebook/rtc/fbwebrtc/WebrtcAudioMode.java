package com.facebook.rtc.fbwebrtc;

import android.content.Context;
import android.media.AudioManager;
import com.facebook.common.android.AudioManagerMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.webrtc.IWebrtcUiInterface.AudioOutputRoute;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: sensors */
public class WebrtcAudioMode {
    private static final Class<?> f2718a = WebrtcAudioMode.class;
    private static volatile WebrtcAudioMode f2719h;
    public final Context f2720b;
    private final AudioManager f2721c;
    private final WebrtcBluetoothManager f2722d;
    public final FbSharedPreferences f2723e;
    public final Provider<Boolean> f2724f;
    public final Provider<Boolean> f2725g;

    public static com.facebook.rtc.fbwebrtc.WebrtcAudioMode m2914a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2719h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.rtc.fbwebrtc.WebrtcAudioMode.class;
        monitor-enter(r1);
        r0 = f2719h;	 Catch:{ all -> 0x003a }
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
        r0 = m2915b(r0);	 Catch:{ all -> 0x0035 }
        f2719h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2719h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.rtc.fbwebrtc.WebrtcAudioMode.a(com.facebook.inject.InjectorLike):com.facebook.rtc.fbwebrtc.WebrtcAudioMode");
    }

    private static WebrtcAudioMode m2915b(InjectorLike injectorLike) {
        return new WebrtcAudioMode((Context) injectorLike.getInstance(Context.class), AudioManagerMethodAutoProvider.b(injectorLike), WebrtcBluetoothManager.m2918a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 4304), IdBasedProvider.a(injectorLike, 4303));
    }

    @Inject
    public WebrtcAudioMode(Context context, AudioManager audioManager, WebrtcBluetoothManager webrtcBluetoothManager, FbSharedPreferences fbSharedPreferences, Provider<Boolean> provider, Provider<Boolean> provider2) {
        this.f2720b = context;
        this.f2721c = audioManager;
        this.f2722d = webrtcBluetoothManager;
        this.f2723e = fbSharedPreferences;
        this.f2724f = provider;
        this.f2725g = provider2;
    }

    public final boolean m2916a() {
        return this.f2720b.checkCallingOrSelfPermission("android.permission.MODIFY_AUDIO_SETTINGS") != -1;
    }

    public final AudioOutputRoute m2917c() {
        if (this.f2722d.m2922b() && this.f2722d.f2734h) {
            return AudioOutputRoute.AudioOutputRouteBluetooth;
        }
        if (this.f2721c.isSpeakerphoneOn()) {
            return AudioOutputRoute.AudioOutputRouteSpeakerphone;
        }
        if (this.f2721c.isWiredHeadsetOn()) {
            return AudioOutputRoute.AudioOutputRouteHeadset;
        }
        return AudioOutputRoute.AudioOutputRouteEarpiece;
    }
}
