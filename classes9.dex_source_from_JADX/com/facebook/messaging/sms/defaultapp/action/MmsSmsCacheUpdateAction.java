package com.facebook.messaging.sms.defaultapp.action;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat.Builder;
import com.facebook.common.android.NotificationManagerMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.content.SecurePendingIntent;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messages.links.MessengerLinks;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.cache.MessagesBroadcaster;
import com.facebook.messaging.model.folders.ThreadsCacheType;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageBuilder;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.service.model.DeleteMessagesParams;
import com.facebook.messaging.service.model.DeleteMessagesParams.ServerParam;
import com.facebook.messaging.service.model.ModifyThreadParamsBuilder;
import com.facebook.messaging.sms.MmsSmsErrorCache;
import com.facebook.messaging.sms.abtest.ReadonlyModeNotificationType;
import com.facebook.messaging.sms.abtest.SmsTakeoverMultiverseExperimentHelper;
import com.facebook.messaging.sms.analytics.SmsTakeoverAnalyticsLogger;
import com.facebook.messaging.sms.common.Constants.MmsSmsErrorType;
import com.facebook.messaging.sms.common.MmsSmsIdUtils;
import com.facebook.messaging.sms.defaultapp.MmsSmsErrorHelper;
import com.facebook.messaging.sms.defaultapp.OfflineThreadingIdCache;
import com.facebook.messaging.sms.readonly.AnonymousSmsThreadHelper;
import com.facebook.messaging.sms.readonly.GentleNotificationChecker;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: com.facebook.orca.media.upload.MEDIA_UPLOAD_PROGRESS */
public class MmsSmsCacheUpdateAction {
    private final Provider<User> f17622a;
    public final Context f17623b;
    public final NotificationManager f17624c;
    public final DefaultBlueServiceOperationFactory f17625d;
    private final OfflineThreadingIdCache f17626e;
    private final MmsSmsErrorHelper f17627f;
    public final Lazy<SmsTakeoverMultiverseExperimentHelper> f17628g;
    public final Lazy<GentleNotificationChecker> f17629h;
    public final Lazy<SmsTakeoverAnalyticsLogger> f17630i;
    private final Lazy<MmsSmsErrorCache> f17631j;
    private final Provider<DataCache> f17632k;
    private final Lazy<MessagesBroadcaster> f17633l;

    /* compiled from: com.facebook.orca.media.upload.MEDIA_UPLOAD_PROGRESS */
    public /* synthetic */ class C20871 {
        public static final /* synthetic */ int[] f17621a = new int[ReadonlyModeNotificationType.values().length];

        static {
            try {
                f17621a[ReadonlyModeNotificationType.CHATHEAD_SYSTEM_NOTIFICATIONS_ON.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f17621a[ReadonlyModeNotificationType.CHATHEAD_SYSTEM_NOTIFICATIONS_OFF.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f17621a[ReadonlyModeNotificationType.CHATHEAD_NOTIFICATIONS_ON.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f17621a[ReadonlyModeNotificationType.GENTLE_CHATHEAD_SYSTEM_NOTIFICATIONS_ON.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f17621a[ReadonlyModeNotificationType.GENTLE_CHATHEAD_NOTIFICATIONS_ON.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public static MmsSmsCacheUpdateAction m17596b(InjectorLike injectorLike) {
        return new MmsSmsCacheUpdateAction(IdBasedProvider.a(injectorLike, 3595), (Context) injectorLike.getInstance(Context.class), NotificationManagerMethodAutoProvider.b(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), OfflineThreadingIdCache.m17547a(injectorLike), MmsSmsErrorHelper.m17537b(injectorLike), IdBasedLazy.a(injectorLike, 2705), IdBasedSingletonScopeProvider.b(injectorLike, 8483), IdBasedLazy.a(injectorLike, 2706), IdBasedSingletonScopeProvider.b(injectorLike, 8439), IdBasedProvider.a(injectorLike, 2567), IdBasedSingletonScopeProvider.b(injectorLike, 2568));
    }

    @Inject
    public MmsSmsCacheUpdateAction(Provider<User> provider, Context context, NotificationManager notificationManager, BlueServiceOperationFactory blueServiceOperationFactory, OfflineThreadingIdCache offlineThreadingIdCache, MmsSmsErrorHelper mmsSmsErrorHelper, Lazy<SmsTakeoverMultiverseExperimentHelper> lazy, Lazy<GentleNotificationChecker> lazy2, Lazy<SmsTakeoverAnalyticsLogger> lazy3, Lazy<MmsSmsErrorCache> lazy4, Provider<DataCache> provider2, Lazy<MessagesBroadcaster> lazy5) {
        this.f17622a = provider;
        this.f17623b = context;
        this.f17624c = notificationManager;
        this.f17625d = blueServiceOperationFactory;
        this.f17626e = offlineThreadingIdCache;
        this.f17627f = mmsSmsErrorHelper;
        this.f17628g = lazy;
        this.f17629h = lazy2;
        this.f17630i = lazy3;
        this.f17631j = lazy4;
        this.f17632k = provider2;
        this.f17633l = lazy5;
    }

    public final void m17600a(CallerContext callerContext, Message message, @Nullable Uri uri) {
        Preconditions.checkState(!message.o);
        if (this.f17622a.get() != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("message", message);
            if (uri != null) {
                bundle.putString("delete_msg_id", MmsSmsIdUtils.m17499a(uri));
            }
            BlueServiceOperationFactoryDetour.a(this.f17625d, "received_sms", bundle, ErrorPropagation.BY_EXCEPTION, callerContext, -902693376).a();
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(MessengerLinks.g));
        PendingIntent a = SecurePendingIntent.a(this.f17623b, 0, intent, 134217728);
        CharSequence charSequence = message.f;
        if (Strings.isNullOrEmpty(charSequence) && MmsSmsIdUtils.m17503d(message.a)) {
            charSequence = this.f17623b.getString(2131232331);
        }
        Builder a2 = new Builder(this.f17623b).a(message.e.c).b(charSequence).c(true).a(2130842225);
        a2.d = a;
        this.f17624c.notify(10029, a2.c());
    }

    public final void m17601a(CallerContext callerContext, Message message, MmsSmsErrorType mmsSmsErrorType) {
        Preconditions.checkState(!message.o);
        String a = this.f17626e.m17548a(message.a);
        if (!(a == null && mmsSmsErrorType == null)) {
            MessageBuilder a2 = Message.newBuilder().a(message);
            if (a != null) {
                this.f17626e.m17551c(message.a);
                a2.n = a;
            }
            if (!(mmsSmsErrorType == null || mmsSmsErrorType == MmsSmsErrorType.NO_ERROR)) {
                if (MmsSmsIdUtils.m17502c(message.a)) {
                    a2.u = this.f17627f.m17539a(mmsSmsErrorType);
                } else {
                    a2.u = this.f17627f.m17540b(mmsSmsErrorType);
                }
                ((MmsSmsErrorCache) this.f17631j.get()).m17418a(message.a, mmsSmsErrorType);
            }
            message = a2.R();
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("message", message);
        BlueServiceOperationFactoryDetour.a(this.f17625d, "sms_mms_sent", bundle, ErrorPropagation.BY_EXCEPTION, callerContext, 497057765).a();
    }

    public final void m17599a(CallerContext callerContext, Uri uri, ThreadKey threadKey) {
        String a = MmsSmsIdUtils.m17499a(uri);
        Bundle bundle = new Bundle();
        bundle.putParcelable("deleteMessagesParams", new DeleteMessagesParams(ImmutableSet.of(a), ServerParam.CLIENT_ONLY, threadKey));
        BlueServiceOperationFactoryDetour.a(this.f17625d, "delete_messages", bundle, ErrorPropagation.BY_EXCEPTION, callerContext, 2019086329).a();
    }

    public final void m17597a() {
        ((DataCache) this.f17632k.get()).a(ThreadsCacheType.SMS);
        ((MessagesBroadcaster) this.f17633l.get()).a();
    }

    public final void m17598a(CallerContext callerContext) {
        Bundle bundle = new Bundle();
        ModifyThreadParamsBuilder modifyThreadParamsBuilder = new ModifyThreadParamsBuilder();
        modifyThreadParamsBuilder.f17237a = AnonymousSmsThreadHelper.f17730b;
        bundle.putParcelable("modifyThreadParams", modifyThreadParamsBuilder.m17161q());
        BlueServiceOperationFactoryDetour.a(this.f17625d, "modify_thread", bundle, ErrorPropagation.BY_EXCEPTION, callerContext, 1545320863).a();
    }
}
