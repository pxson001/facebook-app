package com.facebook.messaging.tincan.messenger;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.bitmaps.BitmapResizingParam;
import com.facebook.bitmaps.ImageResizer;
import com.facebook.bitmaps.ImageResizer.ImageResizingException;
import com.facebook.bitmaps.ImageResizerMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.CacheInsertThreadsHandler;
import com.facebook.messaging.cache.MessagesBroadcaster;
import com.facebook.messaging.database.serialization.DbMediaResourceSerialization;
import com.facebook.messaging.media.upload.EncryptedPhotoUploadResult;
import com.facebook.messaging.media.upload.EncryptedPhotoUploadResult.Status;
import com.facebook.messaging.model.attachment.Attachment;
import com.facebook.messaging.model.messages.GenericAdminMessageInfo;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageBuilder;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.send.SendError;
import com.facebook.messaging.model.send.SendErrorBuilder;
import com.facebook.messaging.model.send.SendErrorType;
import com.facebook.messaging.model.threadkey.DefaultThreadKeyFactory;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKeyFactory;
import com.facebook.messaging.notify.MessagesNotificationClient;
import com.facebook.messaging.service.model.FetchThreadResult;
import com.facebook.messaging.service.model.NewMessageResult;
import com.facebook.messaging.tincan.TincanDeviceIdHolder;
import com.facebook.messaging.tincan.database.DbFetchTincanCryptoHandler;
import com.facebook.messaging.tincan.database.DbFetchTincanMessagesHandler;
import com.facebook.messaging.tincan.database.DbWriteTincanHandler;
import com.facebook.messaging.tincan.database.TincanDbMessagesFetcher;
import com.facebook.messaging.tincan.database.TincanDbThreadsFetcher;
import com.facebook.messaging.tincan.database.clock.TincanDbClock;
import com.facebook.messaging.tincan.gatekeepers.TincanGatekeepers;
import com.facebook.messaging.tincan.inbound.ConnectionProcessor;
import com.facebook.messaging.tincan.inbound.ConnectionReceiver;
import com.facebook.messaging.tincan.inbound.MessageProcessor;
import com.facebook.messaging.tincan.inbound.MessageReceiver;
import com.facebook.messaging.tincan.omnistore.TincanMessage;
import com.facebook.messaging.tincan.outbound.Sender;
import com.facebook.messaging.tincan.prefs.TincanPrefKeys;
import com.facebook.messaging.tincan.thrift.SalamanderBody;
import com.facebook.messaging.tincan.thrift.StickerInfo;
import com.facebook.messaging.tincan.thrift.ThriftFactory;
import com.facebook.messaging.tincan.thrift.ThriftUtil;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.facebook.zero.DefaultZeroMessageSendHandler;
import com.facebook.zero.ZeroMessageSendHandler;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: click_request_ride_button */
public class TincanServiceHandler implements BlueServiceHandler {
    private static final Object f18042F = new Object();
    private static final Class<?> f18043a = TincanServiceHandler.class;
    public final Provider<MessagesNotificationClient> f18044A;
    private final ZeroMessageSendHandler f18045B;
    private final FbSharedPreferences f18046C;
    private final ImageResizer f18047D;
    private final TincanGatekeepers f18048E;
    private final Clock f18049b;
    public final Provider<Sender> f18050c;
    public final ConnectionProcessor f18051d;
    public final MessageProcessor f18052e;
    public final Provider<MessageReceiver> f18053f;
    private final TincanDbThreadsFetcher f18054g;
    public final TincanDbMessagesFetcher f18055h;
    public final DbFetchTincanCryptoHandler f18056i;
    private final DbFetchTincanMessagesHandler f18057j;
    public final DbWriteTincanHandler f18058k;
    private final TincanSnippetHelper f18059l;
    private final DefaultThreadKeyFactory f18060m;
    public final TincanDeviceIdHolder f18061n;
    public final Provider<String> f18062o;
    private final Provider<User> f18063p;
    private final Provider<CacheInsertThreadsHandler> f18064q;
    private final MessagesBroadcaster f18065r;
    public final Provider<Context> f18066s;
    public final DbMediaResourceSerialization f18067t;
    public final DefaultBlueServiceOperationFactory f18068u;
    private final TincanDbClock f18069v;
    public final TincanDeviceIdHolder f18070w;
    public final MessengerPacketIdFactory f18071x;
    private final AttachmentFileDeleter f18072y;
    public final Provider<ConnectionReceiver> f18073z;

    private static TincanServiceHandler m18047b(InjectorLike injectorLike) {
        return new TincanServiceHandler((Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 2742), ConnectionProcessor.m17953a(injectorLike), MessageProcessor.m17958a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 2730), TincanDbThreadsFetcher.a(injectorLike), TincanDbMessagesFetcher.a(injectorLike), DbFetchTincanCryptoHandler.m17899a(injectorLike), DbFetchTincanMessagesHandler.a(injectorLike), DbWriteTincanHandler.a(injectorLike), TincanSnippetHelper.a(injectorLike), DefaultThreadKeyFactory.a(injectorLike), TincanDeviceIdHolder.a(injectorLike), IdBasedProvider.a(injectorLike, 4442), IdBasedProvider.a(injectorLike, 3595), IdBasedProvider.a(injectorLike, 7695), MessagesBroadcaster.a(injectorLike), injectorLike.getProvider(Context.class), DbMediaResourceSerialization.a(injectorLike), DefaultBlueServiceOperationFactory.a(injectorLike), TincanDbClock.a(injectorLike), TincanDeviceIdHolder.a(injectorLike), MessengerPacketIdFactory.a(injectorLike), AttachmentFileDeleter.m17968a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 2727), IdBasedProvider.a(injectorLike, 8006), (ZeroMessageSendHandler) DefaultZeroMessageSendHandler.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), ImageResizerMethodAutoProvider.a(injectorLike), TincanGatekeepers.a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.tincan.messenger.TincanServiceHandler m18036a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f18042F;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m18047b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f18042F;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.tincan.messenger.TincanServiceHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.tincan.messenger.TincanServiceHandler) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f18042F;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.tincan.messenger.TincanServiceHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.tincan.messenger.TincanServiceHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.tincan.messenger.TincanServiceHandler");
    }

    public final OperationResult m18065a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("TincanAccept".equals(str)) {
            return m18046b(operationParams);
        }
        if ("TincanNewConnection".equals(str)) {
            this.f18051d.m17957a(m18037a(operationParams.c));
            return OperationResult.a;
        } else if ("TincanNewMessage".equals(str)) {
            TincanMessage a = m18037a(operationParams.c);
            this.f18052e.m17964a(a);
            ((MessageReceiver) this.f18053f.get()).a(a.f18074a);
            return OperationResult.a;
        } else if ("TincanFindOrCreateThread".equals(str)) {
            return m18052e(operationParams);
        } else {
            if ("TincanSendMessage".equals(str)) {
                return m18054f(operationParams);
            }
            if ("TincanSendAnyQueuedMessages".equals(str)) {
                return m18056g(operationParams);
            }
            if ("UpdateUploadStatus".equals(str)) {
                return m18064m(operationParams);
            }
            if ("TincanDeleteThread".equals(str)) {
                return m18061j(operationParams);
            }
            if ("TincanSendReadReceipt".equals(str)) {
                return m18063k(operationParams);
            }
            if ("TincanAdminMessage".equals(str)) {
                return m18058h(operationParams);
            }
            if ("TincanAutoAcceptPendingSession".equals(str)) {
                return m18034a();
            }
            if ("TincanSignalingPacketDelete".equals(str)) {
                if (this.f18058k.a(operationParams.c.getString("packet_key")) > 0 && this.f18056i.m17906b() == 0) {
                    ((MessagesNotificationClient) this.f18044A.get()).m13117a();
                }
                return OperationResult.a;
            } else if ("TincanSetSalamanderError".equals(str)) {
                return m18059i(operationParams);
            } else {
                throw new IllegalArgumentException("Unknown operation type: " + str);
            }
        }
    }

    private OperationResult m18046b(OperationParams operationParams) {
        Bundle bundle = operationParams.c;
        long j = bundle.getLong("from_user_id");
        long j2 = bundle.getLong("to_user_id");
        String string = bundle.getString("from_instance_id");
        String string2 = bundle.getString("to_instance_id");
        ((Sender) this.f18050c.get()).a(j, string, j2, string2, ThriftUtil.a(ThriftFactory.m18182a(1, null, null)), this.f18071x.c.a(j2, string2));
        return OperationResult.a;
    }

    private OperationResult m18052e(OperationParams operationParams) {
        User user = (User) operationParams.c.getParcelable("other_user");
        Preconditions.checkNotNull(user);
        long parseLong = Long.parseLong(user.a);
        ImmutableList a = this.f18054g.a(parseLong);
        if (!a.isEmpty()) {
            return OperationResult.a((ThreadKey) a.get(0));
        }
        this.f18058k.a(parseLong, user.h(), user.i(), user.e.f());
        ThreadKey b = this.f18060m.b(parseLong);
        this.f18058k.a(b);
        this.f18058k.a(b, this.f18049b.a());
        m18040a(m18035a(b, ((Context) this.f18066s.get()).getResources().getString(2131232400)).R());
        Sender sender = (Sender) this.f18050c.get();
        ThriftUtil thriftUtil = this.f18071x.d;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.putLong(parseLong);
        sender.a(parseLong, thriftUtil.a(allocate.array()));
        return OperationResult.a(b);
    }

    private OperationResult m18054f(OperationParams operationParams) {
        Message message = (Message) operationParams.c.getParcelable("message");
        Preconditions.checkNotNull(message);
        long a = this.f18069v.a();
        MessageBuilder a2 = Message.newBuilder().a(message);
        a2.c = a;
        a2 = a2;
        a2.d = a;
        message = a2.R();
        if (message.J != null && message.J.intValue() > 0) {
            MessageBuilder a3 = Message.newBuilder().a(message);
            a3.K = Long.valueOf(SystemClock.a.a() + ((long) message.J.intValue()));
            message = a3.R();
        }
        ThreadKey threadKey = message.b;
        byte[] e = m18053e(message);
        String a4 = this.f18067t.a(message.t);
        if (!m18055f(message) && !m18057g(message)) {
            boolean z = m18060i(message) && m18062j(message);
            Preconditions.checkState(z);
        } else if (!ThreadKey.h(message.b)) {
            m18041a(message, e);
            Preconditions.checkState(message.l == MessageType.PENDING_SEND);
            MessageBuilder a5 = Message.newBuilder().a(message);
            a5.l = MessageType.REGULAR;
            message = a5.R();
        }
        m18042a(message, e, a4);
        return OperationResult.a(message);
    }

    private OperationResult m18058h(OperationParams operationParams) {
        Bundle bundle = operationParams.c;
        Message R = m18035a((ThreadKey) bundle.getParcelable("thread_key"), bundle.getString("message")).R();
        m18040a(R);
        return OperationResult.a(R);
    }

    private OperationResult m18059i(OperationParams operationParams) {
        Message a = this.f18057j.a(operationParams.c.getString("message_id"));
        if (a != null) {
            SendErrorBuilder sendErrorBuilder = new SendErrorBuilder();
            sendErrorBuilder.a = SendErrorType.TINCAN_NONRETRYABLE;
            sendErrorBuilder = sendErrorBuilder;
            sendErrorBuilder.c = this.f18049b.a();
            SendErrorBuilder sendErrorBuilder2 = sendErrorBuilder;
            sendErrorBuilder2.b = ((Context) this.f18066s.get()).getResources().getString(2131232406);
            SendError f = sendErrorBuilder2.f();
            MessageBuilder a2 = Message.newBuilder().a(a);
            a2.l = MessageType.FAILED_SEND;
            a2 = a2;
            a2.u = f;
            a = a2.R();
            this.f18058k.a(a.a, f);
            m18050b(a);
        }
        return OperationResult.a;
    }

    private OperationResult m18061j(OperationParams operationParams) {
        ThreadKey threadKey = (ThreadKey) operationParams.c.getParcelable("thread_key");
        Preconditions.checkArgument(ThreadKey.g(threadKey));
        if (!ThreadKey.h(threadKey)) {
            ((Sender) this.f18050c.get()).b(Long.parseLong((String) this.f18062o.get()), this.f18061n.a(), threadKey.d, threadKey.f, ThriftUtil.a(ThriftFactory.m18182a(2, null, null)), this.f18071x.a());
        }
        this.f18072y.m17969a(threadKey);
        this.f18058k.b(threadKey);
        return OperationResult.a(threadKey);
    }

    private OperationResult m18063k(OperationParams operationParams) {
        Bundle bundle = operationParams.c;
        ThreadKey threadKey = (ThreadKey) bundle.getParcelable("thread_key");
        long j = bundle.getLong("timestamp_us");
        Preconditions.checkArgument(ThreadKey.g(threadKey));
        ((Sender) this.f18050c.get()).b(Long.parseLong((String) this.f18062o.get()), this.f18061n.a(), threadKey.d, threadKey.f, j, this.f18071x.a());
        return OperationResult.a(threadKey);
    }

    private OperationResult m18064m(OperationParams operationParams) {
        EncryptedPhotoUploadResult encryptedPhotoUploadResult = (EncryptedPhotoUploadResult) operationParams.c.getParcelable("upload_status");
        if (encryptedPhotoUploadResult.f11827c == Status.Success) {
            m18039a(encryptedPhotoUploadResult);
        } else {
            Preconditions.checkState(encryptedPhotoUploadResult.f11827c == Status.Failure);
            m18049b(encryptedPhotoUploadResult);
        }
        return OperationResult.a;
    }

    @Inject
    public TincanServiceHandler(Clock clock, Provider<Sender> provider, ConnectionProcessor connectionProcessor, MessageProcessor messageProcessor, Provider<MessageReceiver> provider2, TincanDbThreadsFetcher tincanDbThreadsFetcher, TincanDbMessagesFetcher tincanDbMessagesFetcher, DbFetchTincanCryptoHandler dbFetchTincanCryptoHandler, DbFetchTincanMessagesHandler dbFetchTincanMessagesHandler, DbWriteTincanHandler dbWriteTincanHandler, TincanSnippetHelper tincanSnippetHelper, ThreadKeyFactory threadKeyFactory, TincanDeviceIdHolder tincanDeviceIdHolder, Provider<String> provider3, Provider<User> provider4, Provider<CacheInsertThreadsHandler> provider5, MessagesBroadcaster messagesBroadcaster, Provider<Context> provider6, DbMediaResourceSerialization dbMediaResourceSerialization, BlueServiceOperationFactory blueServiceOperationFactory, TincanDbClock tincanDbClock, TincanDeviceIdHolder tincanDeviceIdHolder2, MessengerPacketIdFactory messengerPacketIdFactory, AttachmentFileDeleter attachmentFileDeleter, Provider<ConnectionReceiver> provider7, Provider<MessagesNotificationClient> provider8, ZeroMessageSendHandler zeroMessageSendHandler, FbSharedPreferences fbSharedPreferences, ImageResizer imageResizer, TincanGatekeepers tincanGatekeepers) {
        this.f18049b = clock;
        this.f18050c = provider;
        this.f18051d = connectionProcessor;
        this.f18052e = messageProcessor;
        this.f18053f = provider2;
        this.f18054g = tincanDbThreadsFetcher;
        this.f18055h = tincanDbMessagesFetcher;
        this.f18056i = dbFetchTincanCryptoHandler;
        this.f18057j = dbFetchTincanMessagesHandler;
        this.f18058k = dbWriteTincanHandler;
        this.f18059l = tincanSnippetHelper;
        this.f18060m = threadKeyFactory;
        this.f18061n = tincanDeviceIdHolder;
        this.f18062o = provider3;
        this.f18063p = provider4;
        this.f18064q = provider5;
        this.f18065r = messagesBroadcaster;
        this.f18066s = provider6;
        this.f18067t = dbMediaResourceSerialization;
        this.f18068u = blueServiceOperationFactory;
        this.f18069v = tincanDbClock;
        this.f18070w = tincanDeviceIdHolder2;
        this.f18071x = messengerPacketIdFactory;
        this.f18072y = attachmentFileDeleter;
        this.f18073z = provider7;
        this.f18044A = provider8;
        this.f18045B = zeroMessageSendHandler;
        this.f18046C = fbSharedPreferences;
        this.f18047D = imageResizer;
        this.f18048E = tincanGatekeepers;
    }

    private OperationResult m18056g(OperationParams operationParams) {
        ThreadKey threadKey = (ThreadKey) operationParams.b().getParcelable("thread_key");
        Preconditions.checkState(ThreadKey.g(threadKey));
        ImmutableList b = this.f18055h.a(threadKey, -1, -1).b();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            Message message = (Message) b.get(i);
            if (message.l == MessageType.PENDING_SEND && (m18055f(message) || m18057g(message) || !m18062j(message))) {
                try {
                    m18041a(message, m18053e(message));
                } catch (Throwable e) {
                    BLog.b(f18043a, e, "Failed to send queued message with id %s", new Object[]{message.a});
                }
            }
        }
        return OperationResult.a();
    }

    private MessageBuilder m18035a(ThreadKey threadKey, String str) {
        MessageBuilder newBuilder = Message.newBuilder();
        newBuilder.a(SafeUUIDGenerator.a().toString());
        newBuilder.n = newBuilder.a;
        newBuilder.b = threadKey;
        newBuilder.c = this.f18049b.a();
        newBuilder.d = this.f18049b.a();
        newBuilder.l = MessageType.ADMIN;
        newBuilder.e = new ParticipantInfo(UserKey.b((String) this.f18062o.get()), ((User) this.f18063p.get()).k());
        newBuilder.I = GenericAdminMessageInfo.newBuilder().a();
        newBuilder.f = str;
        return newBuilder;
    }

    private void m18040a(Message message) {
        String str = message.f;
        m18042a(message, ThriftUtil.a(ThriftFactory.m18182a(5, SalamanderBody.m18151b(str), message.J)), null);
    }

    private void m18042a(Message message, @Nullable byte[] bArr, @Nullable String str) {
        this.f18058k.b(message, bArr, str);
        m18050b(message);
    }

    private void m18050b(Message message) {
        this.f18059l.a(message);
        m18051c(message);
        this.f18065r.a(message.b);
    }

    private void m18051c(Message message) {
        ((CacheInsertThreadsHandler) this.f18064q.get()).m9939b(new NewMessageResult(DataFreshnessResult.FROM_DB_NEED_INITIAL_FETCH, message, null, null, message.c));
    }

    private OperationResult m18034a() {
        ImmutableMap a = this.f18056i.m17903a();
        if (a.isEmpty()) {
            return OperationResult.a;
        }
        this.f18058k.a(a);
        Iterator it = a.keySet().iterator();
        while (it.hasNext()) {
            ThreadKey threadKey = (ThreadKey) it.next();
            ((ConnectionReceiver) this.f18073z.get()).a(((Bundle) a.get(threadKey)).getString("packet_key"));
            long parseLong = Long.parseLong((String) this.f18062o.get());
            Bundle bundle = new Bundle();
            bundle.putLong("to_user_id", threadKey.d);
            bundle.putString("to_instance_id", threadKey.f);
            bundle.putLong("from_user_id", parseLong);
            bundle.putString("from_instance_id", this.f18070w.a());
            BlueServiceOperationFactoryDetour.a(this.f18068u, "TincanAccept", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(TincanIncomingDispatcher.class), -478611147).a();
            bundle = new Bundle();
            bundle.putParcelable("thread_key", threadKey);
            bundle.putString("message", ((Context) this.f18066s.get()).getResources().getString(2131232402));
            BlueServiceOperationFactoryDetour.a(this.f18068u, "TincanAdminMessage", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(TincanIncomingDispatcher.class), 252947580).a();
            FetchThreadResult a2 = this.f18054g.a(threadKey, 0);
            if (a2 != FetchThreadResult.f17178a) {
                ((CacheInsertThreadsHandler) this.f18064q.get()).m9938b(a2);
            }
        }
        this.f18065r.a(ImmutableList.copyOf(a.keySet()));
        return OperationResult.a;
    }

    private void m18041a(Message message, byte[] bArr) {
        ((Sender) this.f18050c.get()).b(Long.parseLong((String) this.f18062o.get()), this.f18061n.a(), message.b.d, message.b.f, m18045a(message.J, bArr), message.a.getBytes());
    }

    private byte[] m18045a(@Nullable Integer num, byte[] bArr) {
        if (this.f18046C.a(TincanPrefKeys.f18089n, false)) {
            return ThriftUtil.a(ThriftFactory.m18182a(3, null, num));
        }
        if (this.f18046C.a(TincanPrefKeys.f18090o, false)) {
            return ThriftUtil.a(ThriftFactory.m18182a(3, SalamanderBody.m18151b("BAD"), num));
        }
        return bArr;
    }

    private static byte[] m18053e(Message message) {
        if (m18055f(message)) {
            Long valueOf = Long.valueOf(Long.parseLong(message.k));
            return ThriftUtil.a(ThriftFactory.m18182a(6, SalamanderBody.m18148a(new StickerInfo(valueOf)), message.J));
        } else if (m18057g(message)) {
            String str = message.f;
            return ThriftUtil.a(ThriftFactory.m18182a(3, SalamanderBody.m18149a(str), message.J));
        } else if (m18060i(message)) {
            return SignedContentBinaryCreator.m18021a(message);
        } else {
            throw new UnsupportedOperationException("Tried to send an unsupported message.");
        }
    }

    private static boolean m18055f(Message message) {
        return !StringUtil.c(message.k);
    }

    private static boolean m18057g(Message message) {
        return !m18060i(message);
    }

    public static boolean m18060i(Message message) {
        return (message.t.isEmpty() && message.i.isEmpty()) ? false : true;
    }

    public static boolean m18062j(Message message) {
        ImmutableList immutableList = message.t;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            if (Strings.isNullOrEmpty(((MediaResource) immutableList.get(i)).u)) {
                return true;
            }
        }
        return false;
    }

    private void m18039a(EncryptedPhotoUploadResult encryptedPhotoUploadResult) {
        Message b = this.f18055h.b(encryptedPhotoUploadResult.f11825a);
        if (b != null) {
            ArrayList arrayList;
            String str;
            if (b.t != null) {
                arrayList = new ArrayList(b.i);
            } else {
                arrayList = new ArrayList();
            }
            ArrayList arrayList2 = arrayList;
            List a = m18038a(b.a, arrayList2, this.f18067t.a(this.f18055h.a(encryptedPhotoUploadResult.f11825a)), encryptedPhotoUploadResult.f11826b, encryptedPhotoUploadResult.f11828d);
            MessageBuilder a2 = Message.newBuilder().a(b);
            a2.i = arrayList2;
            Message R = a2.R();
            byte[] a3 = SignedContentBinaryCreator.m18021a(R);
            if (a.isEmpty()) {
                str = null;
            } else {
                str = this.f18067t.a(a);
            }
            boolean isEmpty = a.isEmpty();
            if (isEmpty) {
                boolean z = R.l == MessageType.PENDING_SEND || R.l == MessageType.FAILED_SEND;
                Preconditions.checkState(z);
                MessageBuilder a4 = Message.newBuilder().a(R);
                a4.l = MessageType.REGULAR;
                a4 = a4;
                a4.u = SendError.a;
                R = a4.R();
            }
            this.f18058k.b(R, a3, str);
            if (isEmpty) {
                m18041a(R, a3);
                m18051c(R);
                this.f18065r.a(b.b);
            }
        }
    }

    private void m18049b(EncryptedPhotoUploadResult encryptedPhotoUploadResult) {
        Message b = this.f18055h.b(encryptedPhotoUploadResult.f11825a);
        if (b != null) {
            Preconditions.checkState(b.l != MessageType.REGULAR);
            SendErrorBuilder sendErrorBuilder = new SendErrorBuilder();
            sendErrorBuilder.a = SendErrorType.MEDIA_UPLOAD_FAILED;
            sendErrorBuilder = sendErrorBuilder;
            sendErrorBuilder.c = this.f18049b.a();
            SendErrorBuilder sendErrorBuilder2 = sendErrorBuilder;
            sendErrorBuilder2.b = ((Context) this.f18066s.get()).getResources().getString(2131232407);
            SendError f = sendErrorBuilder2.f();
            MessageBuilder a = Message.newBuilder().a(b);
            a.l = MessageType.FAILED_SEND;
            a = a;
            a.u = f;
            b = a.R();
            this.f18058k.a(b.a, f);
            m18051c(b);
            this.f18065r.a(b.b);
        }
    }

    private List<MediaResource> m18038a(String str, List<Attachment> list, List<MediaResource> list2, Uri uri, String str2) {
        int i = 0;
        for (Attachment attachment : list) {
            int length;
            String str3 = attachment.g.g;
            if (str3 != null) {
                length = str3.length();
            } else {
                length = 0;
            }
            i = length + i;
        }
        int i2 = i;
        Preconditions.checkState(i2 <= 30720);
        List<MediaResource> arrayList = new ArrayList();
        for (MediaResource mediaResource : list2) {
            if (mediaResource.c.equals(uri)) {
                String b = m18048b(mediaResource.c.getPath());
                if (!m18043a(b, i2)) {
                    b = null;
                }
                list.add(AttachmentHelper.m17970a(mediaResource, str2, str, b));
            } else {
                arrayList.add(mediaResource);
            }
        }
        return arrayList;
    }

    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    private static boolean m18043a(@Nullable String str, int i) {
        return str != null && str.length() + i <= 30720;
    }

    @SuppressLint({"DeprecatedClass"})
    @Nullable
    private String m18048b(String str) {
        String str2 = null;
        if (this.f18048E.e()) {
            try {
                str2 = Base64.encodeToString(m18044a(this.f18047D.a(str, new BitmapResizingParam(0, 42))), 0);
            } catch (ImageResizingException e) {
                BLog.b(f18043a, "Error while generating a thumbnail", e);
            }
        }
        return str2;
    }

    private static byte[] m18044a(Bitmap bitmap) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.JPEG, 70, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static TincanMessage m18037a(Bundle bundle) {
        String string = bundle.getString("packet_key");
        bundle.getLong("timestamp_us");
        return new TincanMessage(string, ByteBuffer.wrap(bundle.getByteArray("message_data")));
    }
}
