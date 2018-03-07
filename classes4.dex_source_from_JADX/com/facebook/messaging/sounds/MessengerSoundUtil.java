package com.facebook.messaging.sounds;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.support.v4.util.LruCache;
import android.telephony.TelephonyManager;
import com.facebook.common.android.AudioManagerMethodAutoProvider;
import com.facebook.common.android.TelephonyManagerMethodAutoProvider;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.notify.MessagingNotificationPreferencesUtil;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.sounds.FBSoundUtil;
import com.facebook.sounds.SoundPlayer;
import com.facebook.sounds.SoundResourceStore;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: settings changed broadcast did not have parameter */
public class MessengerSoundUtil extends FBSoundUtil {
    private static volatile MessengerSoundUtil f2366h;
    private final Product f2367a;
    public final MessagingNotificationPreferencesUtil f2368b;
    private final AudioManager f2369c;
    public final TelephonyManager f2370d;
    private final AppStateManager f2371e;
    private final boolean f2372f;
    @GuardedBy("ui thread")
    private final DedupForSoundCache f2373g = new DedupForSoundCache();

    @ThreadSafe
    /* compiled from: settings changed broadcast did not have parameter */
    class DedupForSoundCache extends LruCache<String, String> {
        public DedupForSoundCache() {
            super(100);
        }

        @Nullable
        public final String m2631a(@Nullable String str) {
            if (str != null) {
                return (String) a(str, str);
            }
            return null;
        }

        public final boolean m2632b(@Nullable String str) {
            return (str == null || a(str) == null) ? false : true;
        }
    }

    public static com.facebook.messaging.sounds.MessengerSoundUtil m2586a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2366h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.sounds.MessengerSoundUtil.class;
        monitor-enter(r1);
        r0 = f2366h;	 Catch:{ all -> 0x003a }
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
        r0 = m2588b(r0);	 Catch:{ all -> 0x0035 }
        f2366h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2366h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sounds.MessengerSoundUtil.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sounds.MessengerSoundUtil");
    }

    private static MessengerSoundUtil m2588b(InjectorLike injectorLike) {
        return new MessengerSoundUtil(ProductMethodAutoProvider.b(injectorLike), new MessagingNotificationPreferencesUtil((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 4171)), AudioManagerMethodAutoProvider.b(injectorLike), IdBasedProvider.a(injectorLike, 10990), IdBasedSingletonScopeProvider.a(injectorLike, 10991), TelephonyManagerMethodAutoProvider.b(injectorLike), AppStateManager.a(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MessengerSoundUtil(Product product, MessagingNotificationPreferencesUtil messagingNotificationPreferencesUtil, AudioManager audioManager, Provider<SoundPlayer> provider, Provider<SoundResourceStore> provider2, TelephonyManager telephonyManager, AppStateManager appStateManager, Boolean bool) {
        super(provider, provider2);
        this.f2367a = product;
        this.f2368b = messagingNotificationPreferencesUtil;
        this.f2369c = audioManager;
        this.f2370d = telephonyManager;
        this.f2371e = appStateManager;
        this.f2372f = bool.booleanValue();
    }

    private boolean m2589q() {
        return this.f2367a == Product.MESSENGER && this.f2368b.f2377a.a(MessagingPrefKeys.H, true) && this.f2371e.l() && !this.f2369c.isMusicActive() && this.f2369c.getStreamVolume(2) > 0;
    }

    @GuardedBy("ui thread")
    public final void m2597c(String str) {
        if (m2589q() && !this.f2373g.m2632b(str)) {
            this.f2373g.m2631a(str);
            m2626a("sent");
        }
    }

    public final void mo191a() {
        if (m2589q()) {
            m2626a("send");
        }
    }

    @GuardedBy("ui thread")
    public final void m2600d(String str) {
        if (m2589q() && !this.f2373g.m2632b(str)) {
            this.f2373g.m2631a(str);
            m2626a("seen");
        }
    }

    @GuardedBy("ui thread")
    public final void m2603e(String str) {
        if (m2589q() && !this.f2373g.m2632b(str)) {
            this.f2373g.m2631a(str);
            m2627a("seen_in_group", 0.4f);
        }
    }

    public final void m2593b() {
        if (m2589q()) {
            m2626a("typing");
        }
    }

    @GuardedBy("ui thread")
    public final void m2595c() {
        if (m2589q()) {
            m2626a("outgoing_like_message");
        }
    }

    @GuardedBy("ui thread")
    public final void m2598d() {
        if (m2589q()) {
            m2626a("quickcam_image_take_and_send");
        }
    }

    @GuardedBy("ui thread")
    public final void m2601e() {
        if (m2589q()) {
            m2626a("outgoing_sticker_message");
        }
    }

    @GuardedBy("ui thread")
    public final void m2606f(String str) {
        if (m2589q() && !this.f2373g.m2632b(str)) {
            this.f2373g.m2631a(str);
            m2627a("outgoing_payment_message", 0.2f);
        }
    }

    public final void m2608g(String str) {
        if (m2589q()) {
            m2627a(str, 0.25f);
        }
    }

    public final void m2610h(String str) {
        if (m2589q()) {
            m2626a(str);
        }
    }

    public final void m2604f() {
        if (m2589q()) {
            m2627a("incoming_hot_like_small_message", 0.3f);
        }
    }

    public final void m2607g() {
        if (m2589q()) {
            m2627a("incoming_hot_like_medium_message", 1.0f);
        }
    }

    public final void m2609h() {
        if (m2589q()) {
            m2627a("incoming_hot_like_large_message", 1.0f);
        }
    }

    public final void m2592a(@Nullable Uri uri, @Nullable ThreadKey threadKey, Context context) {
        Object obj;
        if (this.f2368b.f2377a.a(MessagingPrefKeys.G, true)) {
            Object obj2 = 1;
            int callState = this.f2370d.getCallState();
            if (!(callState == 1 || callState == 2)) {
                obj2 = null;
            }
            if (obj2 == null) {
                obj = 1;
                if (obj != null && uri != null) {
                    m2587a(uri, context);
                    return;
                }
            }
        }
        obj = null;
        if (obj != null) {
        }
    }

    @Nullable
    private SoundPlayer m2587a(Uri uri, Context context) {
        float f = 0.2f;
        for (NotificationSoundFiles notificationSoundFiles : NotificationSoundFiles.values()) {
            if (uri.toString().equals(notificationSoundFiles.getUri(context))) {
                break;
            }
        }
        NotificationSoundFiles notificationSoundFiles2 = null;
        NotificationSoundFiles notificationSoundFiles3 = notificationSoundFiles2;
        if (notificationSoundFiles3 != null) {
            switch (1.a[notificationSoundFiles3.ordinal()]) {
                case 1:
                    f = 0.015f;
                    break;
                case 2:
                    f = 0.075f;
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    f = 0.1f;
                    break;
                case 8:
                case 9:
                case 10:
                    f = 0.15f;
                    break;
                case 11:
                    f = 0.175f;
                    break;
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    break;
                case 20:
                case 21:
                    f = 0.25f;
                    break;
                case 22:
                case 23:
                case 24:
                    f = 0.3f;
                    break;
                case 25:
                    f = 0.35f;
                    break;
                case 26:
                case 27:
                    f = 0.4f;
                    break;
                default:
                    break;
            }
        }
        f = 1.0f;
        float f2 = f;
        if (this.f2369c.isMusicActive()) {
            if (this.f2369c.getStreamVolume(1) > 0) {
                return m2625a(uri, 1, f2);
            }
            return null;
        } else if (this.f2369c.getStreamVolume(2) > 0) {
            return m2624a(uri, f2);
        } else {
            return null;
        }
    }

    public final void m2611i() {
        if (m2589q()) {
            SoundPlayer a = m2622a(2131165322, 2, 1.0f);
        }
    }

    @Nullable
    public final SoundPlayer m2590a(float f) {
        if (m2589q()) {
            return m2627a("hot_like_growing", f);
        }
        return null;
    }

    public final void m2594b(float f) {
        if (m2589q()) {
            m2627a("hot_like_small", f);
        }
    }

    public final void m2596c(float f) {
        if (m2589q()) {
            m2627a("hot_like_medium", f);
        }
    }

    public final void m2599d(float f) {
        if (m2589q()) {
            m2627a("hot_like_large", f);
        }
    }

    public final void m2602e(float f) {
        if (m2589q()) {
            m2627a("hot_like_timeout", f);
        }
    }

    public final void m2605f(float f) {
        if (m2589q()) {
            m2627a("hot_like_cancel", f);
        }
    }

    public final void m2612j() {
        if (m2589q()) {
            m2626a("composer_tab_selected");
        }
    }

    public final void m2613k() {
        if (m2589q()) {
            m2627a("composer_p2p_selected", 0.06f);
        }
    }

    public final void m2614l() {
        if (m2589q()) {
            m2626a("audio_clip_send");
        }
    }

    public final void m2615m() {
        if (m2589q()) {
            m2627a("audio_clip_cancel", 0.4f);
        }
    }

    public final void m2616n() {
        if (m2589q()) {
            m2627a("voice_clip_timeout", 0.02f);
        }
    }

    public final void m2617o() {
        if (m2589q()) {
            m2627a("ephemeral_mode_turn_on", 0.2f);
        }
    }

    public final void m2618p() {
        if (m2589q()) {
            m2627a("ephemeral_mode_turn_off", 0.2f);
        }
    }
}
