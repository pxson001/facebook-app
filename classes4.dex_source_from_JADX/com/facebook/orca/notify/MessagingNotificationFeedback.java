package com.facebook.orca.notify;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat$Builder;
import com.facebook.common.android.AudioManagerMethodAutoProvider;
import com.facebook.common.android.VibratorMethodAutoProvider;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.hardware.ScreenPowerState;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.orca.FbAndroidMessagingNotificationPreferences;
import com.facebook.messaging.customthreads.CustomThreadsEmojiLike;
import com.facebook.messaging.messageclassifier.MessageClassification;
import com.facebook.messaging.messageclassifier.MessageClassifier;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.notify.AlertDisposition;
import com.facebook.messaging.push.ServerMessageAlertFlags;
import com.facebook.messaging.sounds.MessengerSoundUtil;
import com.facebook.stickers.model.StickerUtil;
import com.google.common.annotations.VisibleForTesting;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: settings/photoreminders */
public class MessagingNotificationFeedback {
    @VisibleForTesting
    static final long[] f2349a = new long[]{0, 100};
    @VisibleForTesting
    static final long[] f2350b = new long[]{0, 200, 200, 200};
    private static final Class<?> f2351c = MessagingNotificationFeedback.class;
    private static final long[] f2352d = new long[]{0};
    private static volatile MessagingNotificationFeedback f2353p;
    private final Context f2354e;
    private final Vibrator f2355f;
    public final AudioManager f2356g;
    private final CustomThreadsEmojiLike f2357h;
    private final FbAndroidMessagingNotificationPreferences f2358i;
    private final AppStateManager f2359j;
    private final Product f2360k;
    private final MessengerSoundUtil f2361l;
    private final MessageClassifier f2362m;
    private final MessageUtil f2363n;
    private final ScreenPowerState f2364o;

    public static com.facebook.orca.notify.MessagingNotificationFeedback m2571a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2353p;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.orca.notify.MessagingNotificationFeedback.class;
        monitor-enter(r1);
        r0 = f2353p;	 Catch:{ all -> 0x003a }
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
        r0 = m2572b(r0);	 Catch:{ all -> 0x0035 }
        f2353p = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2353p;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.notify.MessagingNotificationFeedback.a(com.facebook.inject.InjectorLike):com.facebook.orca.notify.MessagingNotificationFeedback");
    }

    private static MessagingNotificationFeedback m2572b(InjectorLike injectorLike) {
        return new MessagingNotificationFeedback((Context) injectorLike.getInstance(Context.class), VibratorMethodAutoProvider.m2581b(injectorLike), AudioManagerMethodAutoProvider.b(injectorLike), CustomThreadsEmojiLike.m2583b(injectorLike), FbAndroidMessagingNotificationPreferences.m10901a(injectorLike), AppStateManager.a(injectorLike), ProductMethodAutoProvider.b(injectorLike), MessengerSoundUtil.m2586a(injectorLike), MessageUtil.a(injectorLike), MessageClassifier.a(injectorLike), ScreenPowerState.a(injectorLike));
    }

    @Inject
    public MessagingNotificationFeedback(Context context, Vibrator vibrator, AudioManager audioManager, CustomThreadsEmojiLike customThreadsEmojiLike, FbAndroidMessagingNotificationPreferences fbAndroidMessagingNotificationPreferences, AppStateManager appStateManager, Product product, MessengerSoundUtil messengerSoundUtil, MessageUtil messageUtil, MessageClassifier messageClassifier, ScreenPowerState screenPowerState) {
        this.f2354e = context;
        this.f2355f = vibrator;
        this.f2356g = audioManager;
        this.f2357h = customThreadsEmojiLike;
        this.f2358i = fbAndroidMessagingNotificationPreferences;
        this.f2359j = appStateManager;
        this.f2360k = product;
        this.f2361l = messengerSoundUtil;
        this.f2363n = messageUtil;
        this.f2362m = messageClassifier;
        this.f2364o = screenPowerState;
    }

    public final void m2575a(NotificationCompat$Builder notificationCompat$Builder, AlertDisposition alertDisposition, @Nullable ServerMessageAlertFlags serverMessageAlertFlags, @Nullable ThreadKey threadKey) {
        m2576a(notificationCompat$Builder, alertDisposition, serverMessageAlertFlags, threadKey, null);
    }

    public final void m2576a(NotificationCompat$Builder notificationCompat$Builder, AlertDisposition alertDisposition, @Nullable ServerMessageAlertFlags serverMessageAlertFlags, @Nullable ThreadKey threadKey, @Nullable Uri uri) {
        int i = 0;
        boolean d = this.f2358i.m10905d();
        int i2 = (!this.f2358i.m10906e() || this.f2356g.isMusicActive()) ? 0 : 1;
        boolean f = this.f2358i.m10907f();
        int i3;
        if (serverMessageAlertFlags == null || !serverMessageAlertFlags.a) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        int i4;
        if (serverMessageAlertFlags == null || !serverMessageAlertFlags.b) {
            i4 = 0;
        } else {
            i4 = 1;
        }
        if (!(i2 == 0 || alertDisposition.d || r4 != 0)) {
            Uri a = uri == null ? threadKey != null ? m2570a(threadKey) : m2574d() : uri;
            if (a != null) {
                notificationCompat$Builder.m10a(a);
            } else {
                i = 1;
            }
            alertDisposition.c();
        }
        if (d && !alertDisposition.e && r3 == 0) {
            if (this.f2364o.a()) {
                notificationCompat$Builder.m16a(f2349a);
            } else {
                notificationCompat$Builder.m16a(f2350b);
                if (BLog.b(2)) {
                    Arrays.toString(f2350b);
                }
            }
            alertDisposition.e();
        } else {
            notificationCompat$Builder.m16a(f2352d);
        }
        if (i != 0) {
            notificationCompat$Builder.m22c(i);
        }
        if (f && !alertDisposition.f) {
            notificationCompat$Builder.m3a(-16711936, 300, 1000);
            alertDisposition.f = true;
        }
    }

    public final boolean m2579a(Message message) {
        if (this.f2360k != Product.MESSENGER) {
            boolean z = this.f2358i.m10906e() && !this.f2356g.isMusicActive();
            Uri d = m2574d();
            if (z) {
                Object obj;
                if (this.f2356g.getStreamVolume(2) > 0) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    if (BLog.b(3)) {
                        new StringBuilder("Played new message sound, ").append(d);
                    }
                    this.f2361l.m2623a(d);
                    return true;
                }
            }
            return false;
        } else if (!this.f2359j.l()) {
            this.f2361l.m2592a(m2570a(message.b), message.b, this.f2354e);
            return true;
        } else if (MessageUtil.R(message) || this.f2357h.m2584a(message)) {
            if ("369239263222822".equals(message.k)) {
                this.f2361l.m2604f();
                return true;
            } else if ("369239343222814".equals(message.k)) {
                this.f2361l.m2607g();
                return true;
            } else {
                this.f2361l.m2609h();
                return true;
            }
        } else if (MessageUtil.Q(message)) {
            if (StickerUtil.a(message.k)) {
                this.f2361l.m2610h("incoming_like_message");
                return true;
            }
            this.f2361l.m2610h("incoming_sticker_message");
            return true;
        } else if (this.f2362m.a(message) == MessageClassification.PAYMENT) {
            this.f2361l.m2608g("incoming_payment_message");
            return true;
        } else {
            this.f2361l.m2610h("in_app_message");
            return true;
        }
    }

    public final boolean m2577a() {
        if (!m2573c()) {
            return false;
        }
        this.f2355f.vibrate(f2349a, -1);
        return true;
    }

    public final boolean m2578a(NotificationCompat$Builder notificationCompat$Builder) {
        if (!m2573c()) {
            return false;
        }
        notificationCompat$Builder.m16a(f2350b);
        return true;
    }

    private boolean m2573c() {
        return this.f2356g.getRingerMode() != 0 && this.f2358i.m10905d();
    }

    @Nullable
    private Uri m2574d() {
        return m2569a(this.f2358i.m10908g());
    }

    @Nullable
    private Uri m2570a(ThreadKey threadKey) {
        if (this.f2358i instanceof RingtoneNotificationPreferences) {
            return m2569a(((RingtoneNotificationPreferences) this.f2358i).a());
        }
        return m2574d();
    }

    @Nullable
    private Uri m2569a(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        String scheme = uri.getScheme();
        if (scheme != null && !scheme.equals("file")) {
            AssetFileDescriptor assetFileDescriptor = null;
            try {
                AssetFileDescriptor openAssetFileDescriptor = this.f2354e.getContentResolver().openAssetFileDescriptor(uri, "r");
                if (openAssetFileDescriptor == null) {
                    if (openAssetFileDescriptor != null) {
                        try {
                            openAssetFileDescriptor.close();
                        } catch (IOException e) {
                        }
                    }
                    return null;
                } else if (openAssetFileDescriptor == null) {
                    return uri;
                } else {
                    try {
                        openAssetFileDescriptor.close();
                        return uri;
                    } catch (IOException e2) {
                        return uri;
                    }
                }
            } catch (SecurityException e3) {
                if (null != null) {
                    try {
                        assetFileDescriptor.close();
                    } catch (IOException e4) {
                    }
                }
                return null;
            } catch (FileNotFoundException e5) {
                if (null != null) {
                    try {
                        assetFileDescriptor.close();
                    } catch (IOException e6) {
                    }
                }
                return null;
            } catch (Throwable th) {
                if (null != null) {
                    try {
                        assetFileDescriptor.close();
                    } catch (IOException e7) {
                    }
                }
            }
        } else if (new File(uri.getPath()).exists()) {
            return uri;
        } else {
            return null;
        }
    }
}
