package com.facebook.orca.notify;

import android.app.KeyguardManager;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.support.v4.app.NotificationCompat$Builder;
import android.support.v4.app.NotificationCompat.BigPictureStyle;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.InboxStyle;
import android.support.v4.app.NotificationCompat.Style;
import android.support.v4.app.NotificationCompat.WearableExtender;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import com.facebook.common.android.KeyguardManagerMethodAutoProvider;
import com.facebook.common.android.PowerManagerMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.android.String_PackageNameMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.random.Random_InsecureRandomMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.SecurePendingIntent;
import com.facebook.datasource.DataSource;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.katana.orca.FbAndroidMessagingNotificationPreferences;
import com.facebook.messages.ipc.MessagingNotificationPreferences;
import com.facebook.messaging.attachments.AttachmentDataFactory;
import com.facebook.messaging.attachments.ImageAttachmentData;
import com.facebook.messaging.attributionview.AttributionHelper;
import com.facebook.messaging.ephemeral.gating.EphemeralGatingUtil;
import com.facebook.messaging.messagerendering.MessageRenderingUtil;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadCustomization;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.notify.MessageSnippetHelper;
import com.facebook.messaging.notify.NewEphemeralMessageNotification;
import com.facebook.messaging.notify.NewMessageNotification;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.messaging.threadview.rows.RowItemGrouping;
import com.facebook.messaging.util.date.MessagingDateUtil;
import com.facebook.messengerwear.shared.Message.Attachment;
import com.facebook.messengerwear.shared.Message.Attachment.Type;
import com.facebook.messengerwear.shared.MessageGrouping;
import com.facebook.messengerwear.shared.MessageType;
import com.facebook.messengerwear.shared.MessengerWearThreadNotification.Builder;
import com.facebook.messengerwear.support.MessageNotificationDeleteHandlerService;
import com.facebook.messengerwear.support.MessengerWearDispatcher;
import com.facebook.messengerwear.support.MessengerWearHelper;
import com.facebook.orca.notify.DefaultMessagingNotificationHandler.10;
import com.facebook.orca.notify.MuteNotificationHelper.MuteOption;
import com.facebook.orca.threadview.RowItemUiUtil;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.UserKey;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: setSurfaceTexture failed for 360 Video */
public class ThreadSystemTrayNotificationManager {
    private static volatile ThreadSystemTrayNotificationManager f2408E;
    private final Random f2409A;
    private final MuteNotificationHelper f2410B;
    private final Provider<Boolean> f2411C;
    private final Map<ThreadKey, ThreadSystemTrayMessageList> f2412D;
    @Inject
    volatile Provider<SecureContextHelper> f2413a = UltralightRuntime.a();
    @Inject
    volatile Provider<AttachmentDataFactory> f2414b = UltralightRuntime.a();
    @Inject
    volatile Provider<AttributionHelper> f2415c = UltralightRuntime.a();
    private final String f2416d;
    private final Context f2417e;
    private final Resources f2418f;
    private final FbAndroidMessagingNotificationPreferences f2419g;
    private final FbSharedPreferences f2420h;
    private final MessagingNotificationUtil f2421i;
    private final MessageRenderingUtil f2422j;
    private final MessageSnippetHelper f2423k;
    private final NotificationTruncator f2424l;
    private final MessagesWearNodeListener f2425m;
    private final Provider<Boolean> f2426n;
    private final Provider<Boolean> f2427o;
    public final KeyguardManager f2428p;
    public final PowerManager f2429q;
    private final MessagesForegroundActivityListener f2430r;
    private final AbstractFbErrorReporter f2431s;
    private final EphemeralMessageNotificationManager f2432t;
    private final EphemeralGatingUtil f2433u;
    public final MessengerWearHelper f2434v;
    private final Provider<UserKey> f2435w;
    private final Lazy<MessengerWearDispatcher> f2436x;
    private final Lazy<RowItemUiUtil> f2437y;
    private final Lazy<MessagingDateUtil> f2438z;

    public static com.facebook.orca.notify.ThreadSystemTrayNotificationManager m2688a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2408E;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.orca.notify.ThreadSystemTrayNotificationManager.class;
        monitor-enter(r1);
        r0 = f2408E;	 Catch:{ all -> 0x003a }
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
        r0 = m2702b(r0);	 Catch:{ all -> 0x0035 }
        f2408E = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2408E;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.notify.ThreadSystemTrayNotificationManager.a(com.facebook.inject.InjectorLike):com.facebook.orca.notify.ThreadSystemTrayNotificationManager");
    }

    private static ThreadSystemTrayNotificationManager m2702b(InjectorLike injectorLike) {
        ThreadSystemTrayNotificationManager threadSystemTrayNotificationManager = new ThreadSystemTrayNotificationManager(String_PackageNameMethodAutoProvider.a(injectorLike), FbAndroidMessagingNotificationPreferences.m10901a(injectorLike), (Context) injectorLike.getInstance(Context.class), ResourcesMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), MessagingNotificationUtil.m2639a(injectorLike), MessageRenderingUtil.m2715a(injectorLike), MessageSnippetHelper.a(injectorLike), NotificationTruncator.m2721a(injectorLike), MessagesWearNodeListener.m2725a(injectorLike), IdBasedProvider.a(injectorLike, 4128), IdBasedProvider.a(injectorLike, 4132), KeyguardManagerMethodAutoProvider.a(injectorLike), PowerManagerMethodAutoProvider.a(injectorLike), MessagesForegroundActivityListener.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), EphemeralMessageNotificationManager.m2728a(injectorLike), EphemeralGatingUtil.a(injectorLike), MessengerWearHelper.m2741a(injectorLike), IdBasedProvider.a(injectorLike, 3598), IdBasedSingletonScopeProvider.b(injectorLike, 8610), IdBasedSingletonScopeProvider.b(injectorLike, 8853), IdBasedLazy.a(injectorLike, 2748), Random_InsecureRandomMethodAutoProvider.a(injectorLike), MuteNotificationHelper.m2746a(injectorLike), IdBasedProvider.a(injectorLike, 4073));
        threadSystemTrayNotificationManager.m2697a(IdBasedSingletonScopeProvider.a(injectorLike, 968), IdBasedProvider.a(injectorLike, 2552), IdBasedProvider.a(injectorLike, 7534));
        return threadSystemTrayNotificationManager;
    }

    private void m2697a(Provider<SecureContextHelper> provider, Provider<AttachmentDataFactory> provider2, Provider<AttributionHelper> provider3) {
        this.f2413a = provider;
        this.f2414b = provider2;
        this.f2415c = provider3;
    }

    @javax.inject.Inject
    public ThreadSystemTrayNotificationManager(String str, MessagingNotificationPreferences messagingNotificationPreferences, Context context, Resources resources, FbSharedPreferences fbSharedPreferences, MessagingNotificationUtil messagingNotificationUtil, MessageRenderingUtil messageRenderingUtil, MessageSnippetHelper messageSnippetHelper, NotificationTruncator notificationTruncator, MessagesWearNodeListener messagesWearNodeListener, Provider<Boolean> provider, Provider<Boolean> provider2, KeyguardManager keyguardManager, PowerManager powerManager, MessagesForegroundActivityListener messagesForegroundActivityListener, FbErrorReporter fbErrorReporter, EphemeralMessageNotificationManager ephemeralMessageNotificationManager, EphemeralGatingUtil ephemeralGatingUtil, MessengerWearHelper messengerWearHelper, Provider<UserKey> provider3, Lazy<MessengerWearDispatcher> lazy, Lazy<RowItemUiUtil> lazy2, Lazy<MessagingDateUtil> lazy3, Random random, MuteNotificationHelper muteNotificationHelper, Provider<Boolean> provider4) {
        this.f2416d = str;
        this.f2421i = messagingNotificationUtil;
        this.f2422j = messageRenderingUtil;
        this.f2417e = context;
        this.f2418f = resources;
        this.f2419g = messagingNotificationPreferences;
        this.f2420h = fbSharedPreferences;
        this.f2423k = messageSnippetHelper;
        this.f2424l = notificationTruncator;
        this.f2425m = messagesWearNodeListener;
        this.f2426n = provider;
        this.f2427o = provider2;
        this.f2428p = keyguardManager;
        this.f2429q = powerManager;
        this.f2430r = messagesForegroundActivityListener;
        this.f2431s = fbErrorReporter;
        this.f2432t = ephemeralMessageNotificationManager;
        this.f2433u = ephemeralGatingUtil;
        this.f2434v = messengerWearHelper;
        this.f2435w = provider3;
        this.f2436x = lazy;
        this.f2437y = lazy2;
        this.f2438z = lazy3;
        this.f2409A = random;
        this.f2410B = muteNotificationHelper;
        this.f2411C = provider4;
        this.f2412D = Maps.c();
    }

    public final void m2710a(NewMessageNotification newMessageNotification, Bitmap bitmap) {
        Message message = newMessageNotification.c;
        if (message.b != null) {
            byte[] bArr;
            ThreadSummary a = this.f2421i.m2654a(message.b);
            String a2 = this.f2421i.m2655a(message, a);
            int b = m2700b(message.b);
            Builder builder = new Builder();
            Collection arrayList = new ArrayList();
            synchronized (this) {
                com.facebook.messengerwear.shared.Message.Builder builder2 = new com.facebook.messengerwear.shared.Message.Builder(MessageType.REGULAR);
                if (!m2705c(message.b)) {
                    builder2.a(this.f2418f.getQuantityString(2131689496, b, new Object[]{Integer.valueOf(b)}));
                } else if (this.f2419g.m10904c()) {
                    builder2.a(message.f).b(m2703b(message)).c(message.k);
                } else {
                    builder2.a(this.f2423k.c(message, a != null ? a.D : ThreadCustomization.a));
                }
                m2695a(builder2, m2689a(message));
                builder2.a(message.c).a(m2699a(message.e.b));
                builder.a(message.b.toString()).a(newMessageNotification.a()).b(a2).a(builder2.a());
                if (m2713a(message.b)) {
                    List<MuteOption> a3 = this.f2410B.m2747a(message.b);
                    List arrayList2 = new ArrayList();
                    for (MuteOption muteOption : a3) {
                        arrayList2.add(muteOption.b);
                    }
                    builder.a(arrayList2);
                }
                ImmutableList a4 = m2690a(message, b, m2706d(message.b));
                int i = 0;
                boolean z = true;
                while (i < a4.size()) {
                    Message message2;
                    boolean z2;
                    MessageType messageType;
                    Message message3 = z ? null : (Message) a4.get(i - 1);
                    Message message4 = (Message) a4.get(i);
                    if (i + 1 < a4.size()) {
                        message2 = (Message) a4.get(i + 1);
                    } else {
                        message2 = null;
                    }
                    if (((RowItemUiUtil) this.f2437y.get()).a(message4, z, message3)) {
                        builder.b(new com.facebook.messengerwear.shared.Message.Builder(MessageType.TIME_DIVIDER).a(message4.c).a(((MessagingDateUtil) this.f2438z.get()).m10721b(MessageUtil.d(message4))).a());
                    }
                    RowItemGrouping a5 = ((RowItemUiUtil) this.f2437y.get()).a(message4, z, message3, message2);
                    MessageType a6 = m2687a(message4.l);
                    String b2 = m2703b(message4);
                    if (a6 != MessageType.REGULAR || Strings.isNullOrEmpty(b2) || a5.groupWithOlderRow) {
                        z2 = false;
                    } else {
                        builder.b(new com.facebook.messengerwear.shared.Message.Builder(MessageType.SENDER_NAME).a(message4.c).a(b2).a());
                        z2 = true;
                    }
                    MessageGrouping forGrouping = MessageGrouping.forGrouping(a5.groupWithNewerRow, a5.groupWithOlderRow, z2);
                    ImmutableList a7 = m2689a(message4);
                    arrayList.addAll(a7);
                    String str = message4.f;
                    if (a6 == MessageType.REGULAR && message4.k == null && a7.isEmpty() && StringUtil.c(str)) {
                        str = this.f2423k.b(message4, null);
                        messageType = MessageType.SNIPPET;
                    } else {
                        messageType = a6;
                    }
                    if (messageType != MessageType.REGULAR || a7.isEmpty()) {
                        builder.b(new com.facebook.messengerwear.shared.Message.Builder(messageType).a(message4.c).a(str).b(message4.e.c).a(m2699a(message4.e.b)).c(message4.k).a(forGrouping).a());
                    } else {
                        Object obj = null;
                        if (!StringUtil.c(str)) {
                            builder.b(new com.facebook.messengerwear.shared.Message.Builder(messageType).a(message4.c).a(str).b(message4.e.c).a(m2699a(message4.e.b)).a(MessageGrouping.forGrouping(true, a5.groupWithOlderRow, z2)).a());
                            obj = 1;
                        }
                        AttributionHelper attributionHelper = (AttributionHelper) this.f2415c.get();
                        Iterator it = a7.iterator();
                        Object obj2 = obj;
                        while (it.hasNext()) {
                            MessageGrouping messageGrouping;
                            ImageAttachmentData imageAttachmentData = (ImageAttachmentData) it.next();
                            if (!it.hasNext() && obj2 == null) {
                                messageGrouping = forGrouping;
                            } else if (obj2 == null && it.hasNext()) {
                                messageGrouping = MessageGrouping.forGrouping(true, forGrouping.groupWithOlderRow, z2);
                            } else if (it.hasNext()) {
                                messageGrouping = MessageGrouping.forMiddleImageAttachment();
                            } else {
                                messageGrouping = MessageGrouping.forBottomImageAttachment(forGrouping.groupWithNewerRow);
                            }
                            com.facebook.messengerwear.shared.Message.Builder a8 = new com.facebook.messengerwear.shared.Message.Builder(messageType).a(message4.c).b(message4.e.c).a(m2699a(message4.e.b)).c(message4.k).a(messageGrouping).a(new Attachment(imageAttachmentData.e, Type.PHOTO));
                            if (attributionHelper.b(message4)) {
                                a8.d(message4.F.c);
                            }
                            builder.b(a8.a());
                            b = 1;
                        }
                    }
                    i++;
                    z = false;
                }
            }
            if (bitmap != null && bitmap.isRecycled()) {
                Throwable illegalStateException = new IllegalStateException("Attempt to set a recycled bitmap as a notification icon");
                this.f2431s.a("MessagingNotificationWithRecycledBitmap", illegalStateException.getMessage(), illegalStateException);
                bArr = null;
            } else if (bitmap != null) {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                bArr = byteArrayOutputStream.toByteArray();
            } else {
                bArr = null;
            }
            ((MessengerWearDispatcher) this.f2436x.get()).a(builder.a(), bArr, ImmutableList.copyOf(arrayList));
        }
    }

    private static MessageType m2687a(com.facebook.messaging.model.messages.MessageType messageType) {
        switch (3.a[messageType.ordinal()]) {
            case 1:
                return MessageType.ADD_MEMBERS;
            case 2:
                return MessageType.REMOVE_MEMBERS;
            case 3:
                return MessageType.SET_NAME;
            case 4:
            case 5:
                return MessageType.SET_IMAGE;
            case 6:
                return MessageType.ADMIN;
            default:
                return MessageType.REGULAR;
        }
    }

    private static void m2695a(com.facebook.messengerwear.shared.Message.Builder builder, List<ImageAttachmentData> list) {
        for (ImageAttachmentData imageAttachmentData : list) {
            builder.h = new Attachment(imageAttachmentData.e, Type.PHOTO);
        }
    }

    private ImmutableList<ImageAttachmentData> m2689a(Message message) {
        ImmutableList f = ((AttachmentDataFactory) this.f2414b.get()).f(message);
        Collection arrayList = new ArrayList();
        int size = f.size();
        for (int i = 0; i < size; i++) {
            ImageAttachmentData imageAttachmentData = (ImageAttachmentData) f.get(i);
            if (imageAttachmentData.a()) {
                arrayList.add(imageAttachmentData);
            }
        }
        return ImmutableList.copyOf(arrayList);
    }

    public final void m2712a(String str) {
        if (this.f2434v.m2744a()) {
            ((SecureContextHelper) this.f2413a.get()).c(m2701b(str), this.f2417e);
        }
    }

    private Intent m2701b(String str) {
        Intent intent = new Intent(this.f2417e, MessageNotificationDeleteHandlerService.class);
        intent.putExtra("thread_key", str);
        return intent;
    }

    @Nullable
    private String m2703b(Message message) {
        if (!message.b.b() || m2699a(message.e.b)) {
            return null;
        }
        return this.f2422j.m2718a(message.e, message.b);
    }

    private boolean m2699a(UserKey userKey) {
        UserKey userKey2 = (UserKey) this.f2435w.get();
        return userKey2 != null && userKey2.equals(userKey);
    }

    public final void m2711a(NewMessageNotification newMessageNotification, NotificationCompat$Builder notificationCompat$Builder, 10 10) {
        WearableExtender wearableExtender = new WearableExtender();
        FbAndroidMessagingNotificationPreferences fbAndroidMessagingNotificationPreferences = this.f2419g;
        notificationCompat$Builder.m2a(2130843533);
        if (((Boolean) this.f2411C.get()).booleanValue()) {
            notificationCompat$Builder.f27y = ContextCompat.b(this.f2417e, 2131362241);
        }
        if (this.f2433u.a(newMessageNotification.c)) {
            this.f2432t.m2732a(notificationCompat$Builder, (NewEphemeralMessageNotification) newMessageNotification);
            10.a(wearableExtender);
            return;
        }
        boolean z = newMessageNotification.c.b.a == ThreadKey.Type.SMS;
        if (!z && this.f2434v.m2744a()) {
            notificationCompat$Builder.f24v = true;
            if (newMessageNotification.d != null) {
                notificationCompat$Builder.m18b(SecurePendingIntent.m10164c(this.f2417e, this.f2409A.nextInt(), m2701b(newMessageNotification.d.g()), 1073741824));
            }
        }
        this.f2421i.m2658a(newMessageNotification, new 1(this, z, newMessageNotification, notificationCompat$Builder, wearableExtender, 10));
    }

    @VisibleForTesting
    final void m2709a(NotificationCompat$Builder notificationCompat$Builder, NewMessageNotification newMessageNotification, WearableExtender wearableExtender, Bitmap bitmap) {
        CharSequence a;
        int i;
        boolean z = false;
        Message message = newMessageNotification.c;
        ThreadSummary a2 = this.f2421i.m2654a(message.b);
        String a3 = this.f2421i.m2655a(message, a2);
        int b = m2700b(newMessageNotification.d);
        synchronized (this) {
            ThreadSystemTrayMessageList d = m2706d(newMessageNotification.d);
            d.a(message);
            while (d.b() > b) {
                d.c();
            }
            if (m2705c(message.b)) {
                if (!this.f2419g.m10904c()) {
                    z = true;
                }
                ThreadCustomization threadCustomization = a2 != null ? a2.D : ThreadCustomization.a;
                a = m2692a(message, threadCustomization, false, z);
                if (z || m2704c()) {
                    m2694a(message, d, threadCustomization, b, a, notificationCompat$Builder, wearableExtender);
                } else if (b > 1) {
                    notificationCompat$Builder.m12a(m2686a(a3, b, d, threadCustomization));
                } else {
                    notificationCompat$Builder.m12a(new BigTextStyle().b(a));
                }
            } else {
                a = this.f2418f.getQuantityString(2131689496, d.b(), new Object[]{Integer.valueOf(d.b())});
            }
        }
        if (b > 1) {
            notificationCompat$Builder.m17b(b);
        }
        if (bitmap != null) {
            if (bitmap.isRecycled()) {
                Throwable illegalStateException = new IllegalStateException("Attempt to set a recycled bitmap as a notification icon");
                this.f2431s.a("MessagingNotificationWithRecycledBitmap", illegalStateException.getMessage(), illegalStateException);
            } else {
                notificationCompat$Builder.m9a(bitmap);
            }
        }
        notificationCompat$Builder.m13a((CharSequence) a3);
        notificationCompat$Builder.m19b(a);
        notificationCompat$Builder.m6a(message.c);
        notificationCompat$Builder.m14a("msg");
        if (m2698a()) {
            i = -1;
        } else {
            i = 1;
        }
        notificationCompat$Builder.m24d(i);
    }

    private boolean m2698a() {
        if (VERSION.SDK_INT >= 21 && ((Boolean) this.f2427o.get()).booleanValue() && ((Boolean) this.f2426n.get()).booleanValue() && this.f2430r.b == null) {
            Object obj = (this.f2428p.inKeyguardRestrictedInputMode() || !this.f2429q.isScreenOn()) ? 1 : null;
            if (obj == null) {
                return true;
            }
        }
        return false;
    }

    public final String m2708a(NewMessageNotification newMessageNotification) {
        String str;
        if (m2705c(newMessageNotification.c.b) && this.f2419g.m10904c()) {
            str = newMessageNotification.b;
        } else {
            str = this.f2418f.getString(2131231664, new Object[]{r0.e.c});
        }
        return this.f2424l.m2724a(str);
    }

    private int m2700b(ThreadKey threadKey) {
        return this.f2420h.a(MessagingPrefKeys.b(threadKey), 0);
    }

    private boolean m2705c(ThreadKey threadKey) {
        if (ThreadKey.g(threadKey)) {
            return false;
        }
        return this.f2419g.m10903b();
    }

    public final boolean m2713a(ThreadKey threadKey) {
        return m2700b(threadKey) >= 3;
    }

    private void m2694a(Message message, ThreadSystemTrayMessageList threadSystemTrayMessageList, ThreadCustomization threadCustomization, int i, CharSequence charSequence, NotificationCompat$Builder notificationCompat$Builder, WearableExtender wearableExtender) {
        2 2 = new 2(this, notificationCompat$Builder, charSequence, wearableExtender, message, threadCustomization, i, threadSystemTrayMessageList);
        DataSource a = this.f2421i.m2651a(message);
        if (a != null) {
            a.a(2, MoreExecutors.a());
            return;
        }
        notificationCompat$Builder.m12a(new BigTextStyle().b(charSequence));
        m2693a(message, threadCustomization, i, threadSystemTrayMessageList, wearableExtender);
    }

    private void m2693a(Message message, ThreadCustomization threadCustomization, int i, ThreadSystemTrayMessageList threadSystemTrayMessageList, WearableExtender wearableExtender) {
        ImmutableList copyOf;
        MessagesCollection a = this.f2421i.m2653a(message.b, i + 1);
        if (a == null) {
            copyOf = ImmutableList.copyOf(threadSystemTrayMessageList.a);
        } else {
            copyOf = m2691a(a, threadSystemTrayMessageList);
        }
        if (!copyOf.isEmpty()) {
            boolean z;
            if (a == null || a.c) {
                z = true;
            } else {
                z = false;
            }
            wearableExtender.a(m2685a(z, copyOf, threadCustomization));
        }
    }

    private ImmutableList<Message> m2690a(Message message, int i, ThreadSystemTrayMessageList threadSystemTrayMessageList) {
        MessagesCollection a = this.f2421i.m2653a(message.b, i + 1);
        return (a == null ? ImmutableList.copyOf(threadSystemTrayMessageList.a) : m2691a(a, threadSystemTrayMessageList)).reverse();
    }

    public static Notification m2684a(ThreadSystemTrayNotificationManager threadSystemTrayNotificationManager, Bitmap bitmap) {
        NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(threadSystemTrayNotificationManager.f2417e);
        BigPictureStyle bigPictureStyle = new BigPictureStyle();
        bigPictureStyle.a = bitmap;
        notificationCompat$Builder = notificationCompat$Builder.m12a((Style) bigPictureStyle);
        new WearableExtender().c(true).a(notificationCompat$Builder);
        return notificationCompat$Builder.m21c();
    }

    private static ImmutableList<Message> m2691a(MessagesCollection messagesCollection, ThreadSystemTrayMessageList threadSystemTrayMessageList) {
        ImmutableList.Builder builder = ImmutableList.builder();
        Set a = Sets.a();
        ImmutableList immutableList = messagesCollection.b;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            a.add(((Message) immutableList.get(i)).a);
        }
        for (Message message : threadSystemTrayMessageList.a) {
            if (!a.contains(message.a)) {
                builder.c(message);
                a.add(message.a);
            }
        }
        builder.b(messagesCollection.b);
        return builder.b();
    }

    private Notification m2685a(boolean z, ImmutableList<Message> immutableList, ThreadCustomization threadCustomization) {
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        if (!z) {
            spannableStringBuilder.append("...");
        }
        ImmutableList reverse = immutableList.reverse();
        int size = reverse.size();
        for (int i = 0; i < size; i++) {
            Message message = (Message) reverse.get(i);
            if (spannableStringBuilder.length() > 0) {
                spannableStringBuilder.append("\n\n");
            }
            spannableStringBuilder.append(m2692a(message, threadCustomization, true, false));
        }
        NotificationCompat$Builder a = new NotificationCompat$Builder(this.f2417e).m12a(new BigTextStyle().b(spannableStringBuilder));
        new WearableExtender().a(true).a(a);
        return a.m21c();
    }

    private InboxStyle m2686a(String str, int i, ThreadSystemTrayMessageList threadSystemTrayMessageList, ThreadCustomization threadCustomization) {
        InboxStyle inboxStyle = new InboxStyle();
        inboxStyle.e = NotificationCompat$Builder.m1f(str);
        for (Message a : threadSystemTrayMessageList.a) {
            inboxStyle.a.add(NotificationCompat$Builder.m1f(m2692a(a, threadCustomization, false, false)));
        }
        if (i > 7) {
            inboxStyle.f = NotificationCompat$Builder.m1f(this.f2418f.getQuantityString(2131689497, i - 7, new Object[]{Integer.valueOf(i - 7)}));
            inboxStyle.g = true;
        }
        return inboxStyle;
    }

    private CharSequence m2692a(@Nonnull Message message, ThreadCustomization threadCustomization, boolean z, boolean z2) {
        if (this.f2423k.a(message)) {
            return this.f2423k.a(message, threadCustomization);
        }
        CharSequence c = z2 ? this.f2423k.c(message, threadCustomization) : (z2 || TextUtils.isEmpty(message.f)) ? this.f2423k.b(message, threadCustomization) : message.f;
        if (!z && message.b.a == ThreadKey.Type.ONE_TO_ONE) {
            return c;
        }
        ParticipantInfo b = this.f2421i.m2659b(message);
        if (b == null) {
            return c;
        }
        String a = this.f2422j.m2718a(b, message.b);
        if (a == null || c.startsWith(a)) {
            return c;
        }
        Spannable spannableString = new SpannableString(this.f2418f.getString(2131231030, new Object[]{a, c}));
        spannableString.setSpan(new StyleSpan(1), 0, a.length(), 33);
        return spannableString;
    }

    private boolean m2704c() {
        return ((!TextUtils.isEmpty(this.f2425m.f2453b.a(MessagingPrefKeys.at, "")) ? 1 : null) == null || this.f2434v.m2744a()) ? false : true;
    }

    @GuardedBy("this")
    private ThreadSystemTrayMessageList m2706d(ThreadKey threadKey) {
        ThreadSystemTrayMessageList threadSystemTrayMessageList = (ThreadSystemTrayMessageList) this.f2412D.get(threadKey);
        if (threadSystemTrayMessageList != null) {
            return threadSystemTrayMessageList;
        }
        m2707d();
        threadSystemTrayMessageList = new ThreadSystemTrayMessageList();
        this.f2412D.put(threadKey, threadSystemTrayMessageList);
        return threadSystemTrayMessageList;
    }

    @GuardedBy("this")
    @VisibleForTesting
    private void m2707d() {
        Iterator it = this.f2412D.keySet().iterator();
        while (it.hasNext()) {
            if (m2700b((ThreadKey) it.next()) == 0) {
                it.remove();
            }
        }
        while (this.f2412D.size() >= 5) {
            ThreadKey threadKey = null;
            ThreadSystemTrayMessageList threadSystemTrayMessageList = null;
            for (ThreadKey threadKey2 : this.f2412D.keySet()) {
                ThreadKey threadKey22;
                ThreadSystemTrayMessageList threadSystemTrayMessageList2 = (ThreadSystemTrayMessageList) this.f2412D.get(threadKey22);
                if (threadSystemTrayMessageList != null && threadSystemTrayMessageList.b <= threadSystemTrayMessageList2.b) {
                    threadKey22 = threadKey;
                    threadSystemTrayMessageList2 = threadSystemTrayMessageList;
                }
                threadKey = threadKey22;
                threadSystemTrayMessageList = threadSystemTrayMessageList2;
            }
            this.f2412D.remove(threadKey);
        }
    }
}
