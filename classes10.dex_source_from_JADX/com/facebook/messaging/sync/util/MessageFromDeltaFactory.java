package com.facebook.messaging.sync.util;

import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.CrossFbAppBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.enums.GraphQLExtensibleMessageAdminTextType;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.cache.ThreadParticipantUtils;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel;
import com.facebook.messaging.model.attachment.Attachment;
import com.facebook.messaging.model.attachment.AttachmentBuilder;
import com.facebook.messaging.model.attachment.AttachmentBuilder.UrlBuilder;
import com.facebook.messaging.model.attachment.AttachmentImageMap;
import com.facebook.messaging.model.attachment.AttachmentImageMapBuilder;
import com.facebook.messaging.model.attachment.AttachmentImageType;
import com.facebook.messaging.model.attachment.AudioData;
import com.facebook.messaging.model.attachment.ImageData;
import com.facebook.messaging.model.attachment.ImageData.Source;
import com.facebook.messaging.model.attachment.ImageDataUtil;
import com.facebook.messaging.model.attachment.VideoData;
import com.facebook.messaging.model.attribution.AttributionVisibility;
import com.facebook.messaging.model.attribution.AttributionVisibilityBuilder;
import com.facebook.messaging.model.attribution.ContentAppAttribution;
import com.facebook.messaging.model.attribution.ContentAppAttributionBuilder;
import com.facebook.messaging.model.messagemetadata.MessageMetadataAtTextRange;
import com.facebook.messaging.model.messagemetadata.PlatformMetadataType;
import com.facebook.messaging.model.messagemetadata.PlatformMetadataUtil;
import com.facebook.messaging.model.messagemetadata.QuickRepliesPlatformMetadata;
import com.facebook.messaging.model.messagemetadata.QuickReplyItem;
import com.facebook.messaging.model.messages.GenericAdminMessageInfo;
import com.facebook.messaging.model.messages.GenericAdminMessageInfoBuilder;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.Message.ChannelSource;
import com.facebook.messaging.model.messages.MessageBuilder;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.messaging.model.messages.MessageTypeHelper;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.messages.Publicity;
import com.facebook.messaging.model.messages.RecentMessageSource;
import com.facebook.messaging.model.payment.PaymentTransactionData;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ActionIdHelper;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.notify.MessagesNotificationIntents;
import com.facebook.messaging.rtc.adminmsg.model.RTCAdminMsgXMAConverter;
import com.facebook.messaging.rtc.adminmsg.model.RTCAdminMsgXMAConverter.CallLogSnippet;
import com.facebook.messaging.service.methods.RecentMessagesTracker;
import com.facebook.messaging.service.methods.SourceDeserializer;
import com.facebook.messaging.sync.model.thrift.AttachmentAppAttribution;
import com.facebook.messaging.sync.model.thrift.DeltaAdminTextMessage;
import com.facebook.messaging.sync.model.thrift.DeltaBroadcastMessage;
import com.facebook.messaging.sync.model.thrift.DeltaNewMessage;
import com.facebook.messaging.sync.model.thrift.DeltaP2PPaymentMessage;
import com.facebook.messaging.sync.model.thrift.DeltaParticipantLeftGroupThread;
import com.facebook.messaging.sync.model.thrift.DeltaParticipantsAddedToGroupThread;
import com.facebook.messaging.sync.model.thrift.DeltaRTCEventLog;
import com.facebook.messaging.sync.model.thrift.DeltaSentMessage;
import com.facebook.messaging.sync.model.thrift.DeltaThreadImage;
import com.facebook.messaging.sync.model.thrift.DeltaThreadName;
import com.facebook.messaging.sync.model.thrift.MessageMetadata;
import com.facebook.messaging.threads.graphql.GQLXMAHandler;
import com.facebook.messaging.threads.util.MessageClientTagsDeserializer;
import com.facebook.messaging.threads.util.MessagingIdUtil;
import com.facebook.messaging.xma.XMASerialization;
import com.facebook.rtc.models.RecentCallsDb;
import com.facebook.sync.analytics.SyncErrorReporter;
import com.facebook.sync.connection.SyncParamsUtil;
import com.facebook.ui.media.attachments.MediaMimeTypeMap;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableBiMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

@Singleton
/* compiled from: possible_purposes */
public class MessageFromDeltaFactory {
    private static volatile MessageFromDeltaFactory f4687q;
    private final ThriftModelUtil f4688a;
    private final SourceDeserializer f4689b;
    private final Provider<UserKey> f4690c;
    private final SyncParamsUtil f4691d;
    private final SyncErrorReporter f4692e;
    private final RecentMessagesTracker f4693f;
    private final MediaMimeTypeMap f4694g;
    private final XMASerialization f4695h;
    private final GQLXMAHandler f4696i;
    private final RecentCallsDb f4697j;
    private final MessageUtil f4698k;
    private final Clock f4699l;
    private final BaseFbBroadcastManager f4700m;
    private final Lazy<ObjectMapper> f4701n;
    private final Lazy<FbErrorReporter> f4702o;
    private final Provider<Boolean> f4703p;

    public static com.facebook.messaging.sync.util.MessageFromDeltaFactory m4243a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4687q;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.sync.util.MessageFromDeltaFactory.class;
        monitor-enter(r1);
        r0 = f4687q;	 Catch:{ all -> 0x003a }
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
        r0 = m4247b(r0);	 Catch:{ all -> 0x0035 }
        f4687q = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4687q;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.sync.util.MessageFromDeltaFactory.a(com.facebook.inject.InjectorLike):com.facebook.messaging.sync.util.MessageFromDeltaFactory");
    }

    private static MessageFromDeltaFactory m4247b(InjectorLike injectorLike) {
        return new MessageFromDeltaFactory(ThriftModelUtil.m4260a(injectorLike), SourceDeserializer.a(injectorLike), IdBasedProvider.a(injectorLike, 3598), SyncParamsUtil.a(injectorLike), SyncErrorReporter.a(injectorLike), RecentMessagesTracker.a(injectorLike), MediaMimeTypeMap.a(injectorLike), XMASerialization.a(injectorLike), GQLXMAHandler.a(injectorLike), RecentCallsDb.a(injectorLike), MessageUtil.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (BaseFbBroadcastManager) CrossFbAppBroadcastManager.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 572), IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedProvider.a(injectorLike, 4213));
    }

    @Inject
    public MessageFromDeltaFactory(ThriftModelUtil thriftModelUtil, SourceDeserializer sourceDeserializer, Provider<UserKey> provider, SyncParamsUtil syncParamsUtil, SyncErrorReporter syncErrorReporter, RecentMessagesTracker recentMessagesTracker, MediaMimeTypeMap mediaMimeTypeMap, XMASerialization xMASerialization, GQLXMAHandler gQLXMAHandler, RecentCallsDb recentCallsDb, MessageUtil messageUtil, Clock clock, FbBroadcastManager fbBroadcastManager, Lazy<ObjectMapper> lazy, Lazy<FbErrorReporter> lazy2, Provider<Boolean> provider2) {
        this.f4688a = thriftModelUtil;
        this.f4689b = sourceDeserializer;
        this.f4690c = provider;
        this.f4691d = syncParamsUtil;
        this.f4692e = syncErrorReporter;
        this.f4693f = recentMessagesTracker;
        this.f4694g = mediaMimeTypeMap;
        this.f4695h = xMASerialization;
        this.f4696i = gQLXMAHandler;
        this.f4697j = recentCallsDb;
        this.f4698k = messageUtil;
        this.f4699l = clock;
        this.f4700m = fbBroadcastManager;
        this.f4701n = lazy;
        this.f4702o = lazy2;
        this.f4703p = provider2;
    }

    public final Message m4250a(DeltaNewMessage deltaNewMessage, ThreadSummary threadSummary) {
        boolean z = deltaNewMessage.data != null && Boolean.parseBoolean((String) deltaNewMessage.data.get("is_sponsored"));
        Message a = m4239a(threadSummary, deltaNewMessage.messageMetadata, deltaNewMessage.body, deltaNewMessage.stickerId, deltaNewMessage.attachments, deltaNewMessage.ttl, z, deltaNewMessage.data != null ? (String) deltaNewMessage.data.get("commerce_message_type") : null, deltaNewMessage.data);
        this.f4693f.a(RecentMessageSource.SYNC_PROTOCOL_NEW_MESSAGE_DELTA, a);
        return a;
    }

    public final Message m4255a(DeltaSentMessage deltaSentMessage, ThreadSummary threadSummary) {
        MessageBuilder a = m4240a(deltaSentMessage.messageMetadata, threadSummary.a, m4242a(threadSummary, Long.parseLong(((UserKey) this.f4690c.get()).b())));
        if (!(deltaSentMessage.attachments == null || deltaSentMessage.attachments.isEmpty())) {
            m4246a(deltaSentMessage.attachments, a);
            a.i = m4244a(deltaSentMessage.attachments, deltaSentMessage.messageMetadata.messageId);
        }
        Message R = a.R();
        this.f4693f.a(RecentMessageSource.SYNC_PROTOCOL_SENT_MESSAGE_DELTA, R);
        return R;
    }

    private ImmutableList<Attachment> m4244a(List<com.facebook.messaging.sync.model.thrift.Attachment> list, String str) {
        Builder builder = ImmutableList.builder();
        for (com.facebook.messaging.sync.model.thrift.Attachment attachment : list) {
            if (StringUtil.a(attachment.xmaGraphQL)) {
                int intValue;
                int intValue2;
                AttachmentBuilder attachmentBuilder = new AttachmentBuilder(attachment.id, str);
                attachmentBuilder.d = attachment.mimeType;
                attachmentBuilder = attachmentBuilder;
                attachmentBuilder.e = attachment.filename;
                AttachmentBuilder attachmentBuilder2 = attachmentBuilder;
                if (attachment.fbid != null) {
                    attachmentBuilder2.c = Long.toString(attachment.fbid.longValue());
                }
                if (attachment.fileSize != null) {
                    attachmentBuilder2.f = attachment.fileSize.intValue();
                }
                if (attachment.imageMetadata != null) {
                    boolean booleanValue;
                    String encodeToString;
                    AttachmentImageMap a = m4237a(str, attachment.imageMetadata.imageURIMap);
                    AttachmentImageMap a2 = m4237a(str, attachment.imageMetadata.animatedImageURIMap);
                    Source fromIntVal = attachment.imageMetadata.imageSource == null ? Source.NONQUICKCAM : Source.fromIntVal(attachment.imageMetadata.imageSource.intValue());
                    intValue = attachment.imageMetadata.width.intValue();
                    intValue2 = attachment.imageMetadata.height.intValue();
                    if (attachment.imageMetadata.renderAsSticker != null) {
                        booleanValue = attachment.imageMetadata.renderAsSticker.booleanValue();
                    } else {
                        booleanValue = false;
                    }
                    if (attachment.imageMetadata.miniPreview != null) {
                        encodeToString = Base64.encodeToString(attachment.imageMetadata.miniPreview, 0);
                    } else {
                        encodeToString = null;
                    }
                    attachmentBuilder2.g = new ImageData(intValue, intValue2, a, a2, fromIntVal, booleanValue, encodeToString);
                }
                if (attachment.audioMetadata != null) {
                    attachmentBuilder2.i = new AudioData(attachment.audioMetadata.isVoicemail.booleanValue());
                }
                if (attachment.videoMetadata != null) {
                    int i;
                    intValue = attachment.videoMetadata.width.intValue();
                    intValue2 = attachment.videoMetadata.height.intValue();
                    if (attachment.videoMetadata.rotation == null) {
                        i = 0;
                    } else {
                        i = attachment.videoMetadata.rotation.intValue();
                    }
                    attachmentBuilder2.h = new VideoData(intValue, intValue2, i, (int) (((long) attachment.videoMetadata.durationMs.intValue()) / 1000), ThriftModelUtil.m4258a(attachment.videoMetadata.source), Uri.parse(attachment.videoMetadata.videoUri), Uri.parse(attachment.videoMetadata.thumbnailUri));
                }
                builder.c(attachmentBuilder2.k());
            }
        }
        return builder.b();
    }

    private AttachmentImageMap m4237a(String str, Map<Integer, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        AttachmentImageMapBuilder newBuilder = AttachmentImageMap.newBuilder();
        for (Integer num : map.keySet()) {
            int a = this.f4691d.a(num.intValue());
            int b = this.f4691d.b(num.intValue());
            if (!(a == -1 || b == -1)) {
                UrlBuilder urlBuilder = new UrlBuilder();
                urlBuilder.a = a;
                UrlBuilder urlBuilder2 = urlBuilder;
                urlBuilder2.b = b;
                UrlBuilder urlBuilder3 = urlBuilder2;
                urlBuilder3.c = (String) map.get(num);
                newBuilder.a(AttachmentImageType.fromPersistentIndex(num.intValue()), urlBuilder3.d());
            }
        }
        AttachmentImageMap b2 = newBuilder.b();
        if (ImageDataUtil.a(b2)) {
            return b2;
        }
        this.f4692e.a.a("sync_bad_cdn_attachment_info", ImageDataUtil.a(str, b2));
        return null;
    }

    public final Message m4257a(DeltaThreadName deltaThreadName, ThreadSummary threadSummary) {
        MessageBuilder a = m4241a(deltaThreadName.messageMetadata, threadSummary);
        a.l = MessageType.SET_NAME;
        Message R = a.R();
        this.f4693f.a(RecentMessageSource.SYNC_PROTOCOL_THREAD_NAME_DELTA, R);
        return R;
    }

    public final Message m4256a(DeltaThreadImage deltaThreadImage, ThreadSummary threadSummary) {
        MessageType messageType;
        if (deltaThreadImage.image == null) {
            messageType = MessageType.REMOVED_IMAGE;
        } else {
            messageType = MessageType.SET_IMAGE;
        }
        MessageBuilder a = m4241a(deltaThreadImage.messageMetadata, threadSummary);
        a.l = messageType;
        Message R = a.R();
        this.f4693f.a(RecentMessageSource.SYNC_PROTOCOL_THREAD_IMAGE_DELTA, R);
        return R;
    }

    public final Message m4253a(DeltaParticipantsAddedToGroupThread deltaParticipantsAddedToGroupThread, ThreadSummary threadSummary, List<ParticipantInfo> list) {
        MessageBuilder a = m4241a(deltaParticipantsAddedToGroupThread.messageMetadata, threadSummary);
        a.l = MessageType.ADD_MEMBERS;
        a = a;
        a.m = list;
        Message R = a.R();
        this.f4693f.a(RecentMessageSource.SYNC_PROTOCOL_PARTICIPANTS_ADDED_DELTA, R);
        return R;
    }

    public final Message m4252a(DeltaParticipantLeftGroupThread deltaParticipantLeftGroupThread, ThreadSummary threadSummary, ParticipantInfo participantInfo) {
        MessageBuilder a = m4241a(deltaParticipantLeftGroupThread.messageMetadata, threadSummary);
        a.l = MessageType.REMOVE_MEMBERS;
        a = a;
        a.m = ImmutableList.of(participantInfo);
        Message R = a.R();
        this.f4693f.a(RecentMessageSource.SYNC_PROTOCOL_PARTICIPANT_LEFT_GROUP_DELTA, R);
        return R;
    }

    public final Message m4254a(DeltaRTCEventLog deltaRTCEventLog, ThreadSummary threadSummary) {
        MessageBuilder a = m4241a(deltaRTCEventLog.messageMetadata, threadSummary);
        XMAModel b = RTCAdminMsgXMAConverter.b(deltaRTCEventLog);
        CallLogSnippet a2 = RTCAdminMsgXMAConverter.a(deltaRTCEventLog);
        CallLogSnippet callLogSnippet = new CallLogSnippet();
        a.a(MessageType.CALL_LOG).a(b);
        Message R = a.R();
        this.f4693f.a(RecentMessageSource.SYNC_PROTOCOL_RTC_EVENT_LOG_DELTA, R);
        boolean P = this.f4698k.P(R);
        if (a2.a != null) {
            this.f4697j.a(a2.a, null, a2.b, a2.c, a2.d.asBoolean(false), P, a2.f.asBoolean(false), false, a2.g.asBoolean(false), false, false);
        }
        return R;
    }

    public final Message m4248a(DeltaAdminTextMessage deltaAdminTextMessage, ThreadSummary threadSummary) {
        MessageBuilder a = m4241a(deltaAdminTextMessage.messageMetadata, threadSummary);
        a.l = MessageType.ADMIN;
        a = a;
        GraphQLExtensibleMessageAdminTextType fromString = GraphQLExtensibleMessageAdminTextType.fromString(deltaAdminTextMessage.type);
        GenericAdminMessageInfoBuilder newBuilder = GenericAdminMessageInfo.newBuilder();
        newBuilder.a = fromString;
        GenericAdminMessageInfoBuilder genericAdminMessageInfoBuilder = newBuilder;
        if (deltaAdminTextMessage.untypedData != null) {
            genericAdminMessageInfoBuilder.a(deltaAdminTextMessage.untypedData);
        }
        a.I = genericAdminMessageInfoBuilder.a();
        Message R = a.R();
        this.f4693f.a(RecentMessageSource.SYNC_PROTOCOL_ADMIN_TEXT_MESSAGE_DELTA, R);
        if (!(R.I == null || !R.I.o() || StringUtil.a(R.I.m) || ((Boolean) this.f4703p.get()).booleanValue())) {
            String str = R.I.m;
            String l = Long.toString(R.b.i());
            if (str.contentEquals("call_started")) {
                this.f4697j.a(l, this.f4699l.a(), R.I.o, this.f4698k.P(R), true);
            } else if (str.contentEquals("call_ended")) {
                this.f4697j.a(l, false);
                Intent intent = new Intent();
                intent.setAction(MessagesNotificationIntents.l);
                intent.putExtra("thread_key_string", R.b.toString());
                this.f4700m.a(intent);
            }
        }
        return R;
    }

    public final Message m4251a(DeltaP2PPaymentMessage deltaP2PPaymentMessage, ThreadSummary threadSummary) {
        MessageBuilder a = m4241a(deltaP2PPaymentMessage.messageMetadata, threadSummary);
        a.l = MessageTypeHelper.a(deltaP2PPaymentMessage.messageType);
        MessageBuilder messageBuilder = a;
        messageBuilder.B = new PaymentTransactionData(String.valueOf(deltaP2PPaymentMessage.transferId), 0, 0, 0, null);
        return messageBuilder.R();
    }

    private MessageBuilder m4241a(MessageMetadata messageMetadata, ThreadSummary threadSummary) {
        return m4240a(messageMetadata, threadSummary.a, m4242a(threadSummary, messageMetadata.actorFbId.longValue()));
    }

    private MessageBuilder m4240a(MessageMetadata messageMetadata, ThreadKey threadKey, ParticipantInfo participantInfo) {
        String str;
        MessageBuilder newBuilder = Message.newBuilder();
        newBuilder.b = threadKey;
        newBuilder = newBuilder.a(messageMetadata.messageId);
        newBuilder.c = messageMetadata.timestamp.longValue();
        newBuilder = newBuilder;
        newBuilder.n = Long.toString(messageMetadata.offlineThreadingId.longValue());
        newBuilder = newBuilder;
        newBuilder.f = messageMetadata.adminText;
        newBuilder = newBuilder;
        newBuilder.e = participantInfo;
        newBuilder = newBuilder;
        newBuilder.q = ChannelSource.MQTT;
        newBuilder = newBuilder;
        SourceDeserializer sourceDeserializer = this.f4689b;
        List<String> list = messageMetadata.tags;
        if (list == null) {
            str = null;
        } else {
            for (String str2 : list) {
                str2 = SourceDeserializer.a(str2);
                if (str2 != null) {
                    break;
                }
            }
            str2 = null;
        }
        newBuilder.p = str2;
        newBuilder = newBuilder.a(MessageClientTagsDeserializer.a(messageMetadata.tags));
        newBuilder.v = Publicity.c;
        newBuilder = newBuilder;
        long a = ActionIdHelper.a(messageMetadata.timestamp.longValue());
        newBuilder.g = a;
        if (messageMetadata.messageId != null) {
            newBuilder.a(messageMetadata.messageId);
        } else {
            newBuilder.a(MessagingIdUtil.d(a));
        }
        return newBuilder;
    }

    private static ParticipantInfo m4242a(ThreadSummary threadSummary, long j) {
        UserKey userKey = new UserKey(Type.FACEBOOK, Long.toString(j));
        ParticipantInfo a = ThreadParticipantUtils.a(threadSummary.h, userKey);
        if (a == null) {
            a = ThreadParticipantUtils.a(threadSummary.j, userKey);
            if (a == null) {
                throw new IllegalArgumentException("Thread " + threadSummary.a + " does not contain participant with id " + j);
            }
        }
        return a;
    }

    public final Message m4249a(DeltaBroadcastMessage deltaBroadcastMessage, MessageMetadata messageMetadata, ThreadSummary threadSummary) {
        Message a = m4239a(threadSummary, messageMetadata, deltaBroadcastMessage.body, deltaBroadcastMessage.stickerId, deltaBroadcastMessage.attachments, null, false, null, null);
        this.f4693f.a(RecentMessageSource.SYNC_PROTOCOL_BROADACST_DELTA, a);
        return a;
    }

    private Message m4239a(ThreadSummary threadSummary, MessageMetadata messageMetadata, @Nullable String str, @Nullable Long l, @Nullable List<com.facebook.messaging.sync.model.thrift.Attachment> list, @Nullable Integer num, boolean z, @Nullable String str2, @Nullable Map<String, String> map) {
        MessageBuilder b = m4241a(messageMetadata, threadSummary).b(Strings.nullToEmpty(str));
        if (l != null) {
            b.c(Long.toString(l.longValue()));
        }
        if (!(list == null || list.isEmpty())) {
            m4246a((List) list, b);
            b.a(m4244a((List) list, messageMetadata.messageId));
        }
        b.a(m4238a((List) list));
        if (num != null) {
            b.a(num);
        }
        b.d(z);
        b.h(str2);
        if (map != null) {
            String str3 = (String) map.get("customization");
            if (str3 != null) {
                try {
                    b.e(new JSONObject(str3).getString("border").equals("flowers"));
                } catch (JSONException e) {
                }
            }
            str3 = (String) map.get("meta_ranges");
            if (!Strings.isNullOrEmpty(str3)) {
                b.e(MessageMetadataAtTextRange.a((ObjectMapper) this.f4701n.get(), (AbstractFbErrorReporter) this.f4702o.get(), str3));
            }
            str3 = (String) map.get("platform_xmd");
            if (!Strings.isNullOrEmpty(str3)) {
                b.c(PlatformMetadataUtil.a((AbstractFbErrorReporter) this.f4702o.get(), (ObjectMapper) this.f4701n.get(), str3));
            }
            ImmutableList a = QuickReplyItem.a((String) map.get("agent_quick_replies"));
            if (!(a == null || a.isEmpty())) {
                QuickRepliesPlatformMetadata quickRepliesPlatformMetadata = new QuickRepliesPlatformMetadata(a);
                Map Q = b.Q();
                if (Q == null) {
                    Q = new HashMap();
                }
                Q.put(PlatformMetadataType.QUICK_REPLIES, quickRepliesPlatformMetadata);
                b.c(Q);
            }
        }
        Message R = b.R();
        m4245a(R);
        return R;
    }

    private void m4246a(List<com.facebook.messaging.sync.model.thrift.Attachment> list, MessageBuilder messageBuilder) {
        for (com.facebook.messaging.sync.model.thrift.Attachment attachment : list) {
            if (!StringUtil.a(attachment.xmaGraphQL)) {
                this.f4696i.a(this.f4695h.b(attachment.xmaGraphQL), messageBuilder);
                return;
            }
        }
    }

    private static void m4245a(Message message) {
        if (message.F != null && Objects.equal(message.F.b, "1541184119468976")) {
            ImmutableList immutableList = message.i;
            if (!immutableList.isEmpty()) {
                Attachment attachment = (Attachment) immutableList.get(0);
                if (attachment.g != null && attachment.g.d == null) {
                    BLog.c("MessageFromDeltaFactory", "Message %s from app '%s' is missing animated images", new Object[]{message.a, message.F.c});
                }
            }
        }
    }

    @Nullable
    private ContentAppAttribution m4238a(@Nullable List<com.facebook.messaging.sync.model.thrift.Attachment> list) {
        if (list != null) {
            for (com.facebook.messaging.sync.model.thrift.Attachment attachment : list) {
                if (attachment.attributionInfo != null) {
                    ImmutableMap immutableMap;
                    Long l = attachment.fbid;
                    AttachmentAppAttribution attachmentAppAttribution = attachment.attributionInfo;
                    AttributionVisibilityBuilder newBuilder = AttributionVisibility.newBuilder();
                    newBuilder.a = attachmentAppAttribution.visibility.hideAttribution.booleanValue();
                    newBuilder = newBuilder;
                    newBuilder.c = attachmentAppAttribution.visibility.hideInstallButton.booleanValue();
                    newBuilder = newBuilder;
                    newBuilder.d = attachmentAppAttribution.visibility.hideReplyButton.booleanValue();
                    newBuilder = newBuilder;
                    newBuilder.e = attachmentAppAttribution.visibility.hideInstallButton.booleanValue();
                    AttributionVisibility h = newBuilder.h();
                    ContentAppAttributionBuilder newBuilder2 = ContentAppAttribution.newBuilder();
                    newBuilder2.a = String.valueOf(l);
                    newBuilder2 = newBuilder2;
                    newBuilder2.b = String.valueOf(attachmentAppAttribution.attributionAppId);
                    newBuilder2 = newBuilder2;
                    newBuilder2.c = attachmentAppAttribution.attributionAppName;
                    newBuilder2 = newBuilder2;
                    newBuilder2.e = attachmentAppAttribution.androidPackageName;
                    newBuilder2 = newBuilder2;
                    newBuilder2.f = attachmentAppAttribution.attributionMetadata;
                    newBuilder2 = newBuilder2;
                    if (attachmentAppAttribution.otherUserAppScopedFbIds == null) {
                        immutableMap = RegularImmutableBiMap.a;
                    } else {
                        ImmutableMap.Builder builder = ImmutableMap.builder();
                        for (Entry entry : attachmentAppAttribution.otherUserAppScopedFbIds.entrySet()) {
                            builder.b(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
                        }
                        immutableMap = builder.b();
                    }
                    newBuilder2 = newBuilder2.a(immutableMap);
                    newBuilder2.h = h;
                    return newBuilder2.i();
                }
            }
        }
        return null;
    }
}
