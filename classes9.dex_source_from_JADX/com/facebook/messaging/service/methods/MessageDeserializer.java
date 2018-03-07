package com.facebook.messaging.service.methods;

import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.commerce.model.retail.CommerceDataSerialization;
import com.facebook.messaging.model.attachment.AttachmentBuilder.UrlBuilder;
import com.facebook.messaging.model.attachment.AttachmentImageType;
import com.facebook.messaging.model.attribution.ContentAppAttribution;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageBuilder;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.messaging.model.messages.MessageTypeHelper;
import com.facebook.messaging.model.messages.Publicity;
import com.facebook.messaging.model.messages.RecentMessageSource;
import com.facebook.messaging.model.share.Share;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ActionIdHelper;
import com.facebook.messaging.momentsinvite.model.MomentsInviteDataSerialization;
import com.facebook.messaging.photos.size.MediaSizeUtil;
import com.facebook.messaging.rtc.adminmsg.model.RTCAdminMsgXMAConverter;
import com.facebook.messaging.threads.util.MessagingIdUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Iterators;
import com.google.common.collect.PeekingIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: custom_targeting */
public class MessageDeserializer {
    private final ParticipantInfoDeserializer f16939a;
    private final ShareDeserializer f16940b;
    private final AttachmentDeserializer f16941c;
    private final SourceDeserializer f16942d;
    private final PaymentTransactionDataDeserializer f16943e;
    private final PaymentTransactionLogDataDeserializer f16944f;
    public final MediaSizeUtil f16945g;
    private final Provider<Boolean> f16946h;
    private final RecentMessagesTracker f16947i;
    private final AppAttributionDeserializer f16948j;

    public static MessageDeserializer m16978b(InjectorLike injectorLike) {
        return new MessageDeserializer(ParticipantInfoDeserializer.m16987a(injectorLike), new ShareDeserializer((ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), CommerceDataSerialization.a(injectorLike), MomentsInviteDataSerialization.b(injectorLike)), AttachmentDeserializer.m16860a(injectorLike), SourceDeserializer.m17062a(injectorLike), PaymentTransactionDataDeserializer.m16992a(injectorLike), PaymentTransactionLogDataDeserializer.m16994a(injectorLike), MediaSizeUtil.a(injectorLike), IdBasedProvider.a(injectorLike, 4060), RecentMessagesTracker.m17010a(injectorLike), AppAttributionDeserializer.m16858a(injectorLike));
    }

    @Inject
    public MessageDeserializer(ParticipantInfoDeserializer participantInfoDeserializer, ShareDeserializer shareDeserializer, AttachmentDeserializer attachmentDeserializer, SourceDeserializer sourceDeserializer, PaymentTransactionDataDeserializer paymentTransactionDataDeserializer, PaymentTransactionLogDataDeserializer paymentTransactionLogDataDeserializer, MediaSizeUtil mediaSizeUtil, Provider<Boolean> provider, RecentMessagesTracker recentMessagesTracker, AppAttributionDeserializer appAttributionDeserializer) {
        this.f16939a = participantInfoDeserializer;
        this.f16940b = shareDeserializer;
        this.f16941c = attachmentDeserializer;
        this.f16942d = sourceDeserializer;
        this.f16943e = paymentTransactionDataDeserializer;
        this.f16944f = paymentTransactionLogDataDeserializer;
        this.f16945g = mediaSizeUtil;
        this.f16946h = provider;
        this.f16947i = recentMessagesTracker;
        this.f16948j = appAttributionDeserializer;
    }

    public final ImmutableList<Message> m16980a(JsonNode jsonNode, JsonNode jsonNode2, JsonNode jsonNode3, int i, ThreadKey threadKey) {
        int i2;
        MessagesAttachmentIndex a = m16976a(jsonNode2);
        List arrayList = new ArrayList();
        for (i2 = 0; i2 < jsonNode.e(); i2++) {
            arrayList.add(m16975a(jsonNode.a(i2), a, threadKey));
        }
        List arrayList2 = new ArrayList();
        for (i2 = 0; i2 < jsonNode3.e(); i2++) {
            arrayList2.add(m16974a(jsonNode3.a(i2), threadKey));
        }
        PeekingIterator i3 = Iterators.i(arrayList.iterator());
        PeekingIterator i4 = Iterators.i(arrayList2.iterator());
        Builder builder = ImmutableList.builder();
        int i5 = 0;
        while (true) {
            if ((i3.hasNext() || i4.hasNext()) && i5 < i) {
                Message message = i3.hasNext() ? (Message) i3.a() : null;
                Message message2 = i4.hasNext() ? (Message) i4.a() : null;
                if (message == null || message2 == null) {
                    if (message != null) {
                        builder.c(message);
                        i3.next();
                        i5++;
                    } else {
                        if (message2 != null) {
                            builder.c(message2);
                            i4.next();
                            i2 = i5 + 1;
                        } else {
                            i2 = i5;
                        }
                        i5 = i2;
                    }
                } else if (message.c > message2.c) {
                    builder.c(message);
                    i3.next();
                    i5++;
                } else {
                    builder.c(message2);
                    i4.next();
                    i5++;
                }
            }
        }
        ImmutableList<Message> b = builder.b();
        if (!b.isEmpty()) {
            this.f16947i.m17015a(RecentMessageSource.FETCH_FQL, (Message) b.get(0));
        }
        return b;
    }

    private MessagesAttachmentIndex m16976a(JsonNode jsonNode) {
        MessagesAttachmentIndex messagesAttachmentIndex = new MessagesAttachmentIndex();
        for (int i = 0; i < jsonNode.e(); i++) {
            JsonNode a = jsonNode.a(i);
            if (a.d("message_id") && a.d("attachment_id")) {
                String c = MessagingIdUtil.m17838c(JSONUtil.b(a.b("message_id")));
                String b = JSONUtil.b(a.b("attachment_id"));
                int a2 = JSONUtil.a(a.b("width"), 0);
                int a3 = JSONUtil.a(a.b("height"), 0);
                String a4 = JSONUtil.a(a.b("src"), null);
                String a5 = JSONUtil.a(a.b("animated_gif_src"), null);
                String a6 = JSONUtil.a(a.b("animated_webp_src"), null);
                if (a2 == 0 || a3 == 0 || a4 == null) {
                    StringBuilder stringBuilder = new StringBuilder(100);
                    stringBuilder.append(c).append('\n');
                    stringBuilder.append(b).append('\n');
                    if (a2 == 0) {
                        stringBuilder.append("Width is missing.\n");
                    }
                    if (a3 == 0) {
                        stringBuilder.append("Height is missing.\n");
                    }
                    if (a4 == null) {
                        stringBuilder.append("Src is missing.\n");
                    }
                    BLog.c("MessageDeserializer", stringBuilder.toString());
                } else {
                    AttachmentImageType b2 = this.f16945g.b(a2, a3);
                    if (b2 != null) {
                        UrlBuilder urlBuilder = new UrlBuilder();
                        urlBuilder.a = a2;
                        urlBuilder = urlBuilder;
                        urlBuilder.b = a3;
                        urlBuilder = urlBuilder;
                        urlBuilder.c = a4;
                        messagesAttachmentIndex.m16982a(c, b, b2, urlBuilder.d());
                        if (a6 == null) {
                            if (a5 != null) {
                                a6 = a5;
                            } else {
                                a6 = null;
                            }
                        }
                        if (a6 != null) {
                            UrlBuilder urlBuilder2 = new UrlBuilder();
                            urlBuilder2.a = a2;
                            urlBuilder2 = urlBuilder2;
                            urlBuilder2.b = a3;
                            urlBuilder2 = urlBuilder2;
                            urlBuilder2.c = a6;
                            messagesAttachmentIndex.m16983b(c, b, b2, urlBuilder2.d());
                        }
                    }
                }
            }
        }
        return messagesAttachmentIndex;
    }

    private Message m16975a(JsonNode jsonNode, MessagesAttachmentIndex messagesAttachmentIndex, ThreadKey threadKey) {
        long b;
        MessageType b2;
        JsonNode b3;
        ContentAppAttribution contentAppAttribution;
        JsonNode b4;
        boolean z;
        List list;
        Object b5;
        SourceDeserializer sourceDeserializer;
        int i;
        String a;
        String str;
        AppAttributionDeserializer appAttributionDeserializer;
        MessageBuilder newBuilder = Message.newBuilder();
        String c = MessagingIdUtil.m17838c(JSONUtil.b(jsonNode.b("message_id")));
        newBuilder.a(c);
        newBuilder.b = threadKey;
        newBuilder.f = JSONUtil.b(jsonNode.b("body"));
        long c2 = JSONUtil.c(jsonNode.b("timestamp"));
        newBuilder.c = c2;
        if (((Boolean) this.f16946h.get()).booleanValue()) {
            b = ActionIdHelper.b(c2);
        } else {
            b = JSONUtil.c(jsonNode.b("action_id"));
        }
        newBuilder.g = b;
        MessageType messageType = MessageType.REGULAR;
        if (jsonNode.d("log_message") && jsonNode.b("log_message").i()) {
            JsonNode b6 = jsonNode.b("log_message");
            if (!b6.d("threadPic")) {
                b2 = m16977b(b6);
                if (b2 == null) {
                    if (b6.d("threadName")) {
                        b2 = MessageType.SET_NAME;
                    } else if (b6.d("callLog")) {
                        newBuilder.G = RTCAdminMsgXMAConverter.a(jsonNode);
                        b2 = MessageType.CALL_LOG;
                    } else if (b6.d("p2p_payment")) {
                        b3 = b6.b("p2p_payment");
                        newBuilder.B = PaymentTransactionLogDataDeserializer.m16993a(b3);
                        b2 = MessageTypeHelper.a(Integer.valueOf(JSONUtil.d(b3.b("message_type"))));
                    }
                }
            } else if (b6.b("threadPic").c("deleted").a(false)) {
                b2 = MessageType.REMOVED_IMAGE;
            } else {
                b2 = MessageType.SET_IMAGE;
            }
            newBuilder.l = b2;
            newBuilder.e = this.f16939a.m16990b(jsonNode.b("sender"));
            if (jsonNode.d("attachment_map") || !jsonNode.b("attachment_map").i()) {
                contentAppAttribution = null;
            } else {
                b3 = jsonNode.b("attachment_map");
                String str2 = newBuilder.a;
                MessageAttachmentIndex messageAttachmentIndex = (MessageAttachmentIndex) messagesAttachmentIndex.f16949a.get(c);
                if (messageAttachmentIndex == null) {
                    messageAttachmentIndex = MessageAttachmentIndex.f16937a;
                }
                newBuilder.i = AttachmentDeserializer.m16861a(b3, str2, messageAttachmentIndex);
                contentAppAttribution = m16979c(b3);
            }
            if (jsonNode.d("share_map") && jsonNode.b("share_map").i()) {
                b4 = jsonNode.b("share_map");
                b3 = (JsonNode) b4.iterator().next();
                z = b3 == null && b3.i();
                if (z || !b3.d("sticker_id")) {
                    newBuilder.j = this.f16940b.m17061a(b4);
                    list = newBuilder.j;
                    if (!(list.isEmpty() || ((Share) list.get(0)).l == null)) {
                        newBuilder.H = ((Share) list.get(0)).l;
                    }
                } else {
                    newBuilder.k = JSONUtil.b(b3.b("sticker_id"));
                }
                if (z && b3.d("fb_object_type") && b3.b("fb_object_type").B().equals("p2p_payment_info_map") && b3.d("fb_object_contents")) {
                    b3 = b3.b("fb_object_contents");
                    if (b3.e() != 0) {
                        newBuilder.B = PaymentTransactionDataDeserializer.m16991a((JsonNode) b3.iterator().next());
                    }
                }
            }
            b5 = JSONUtil.b(jsonNode.b("offline_threading_id"));
            if (!StringUtil.a(b5)) {
                newBuilder.n = b5;
            }
            b3 = jsonNode.b("tags");
            sourceDeserializer = this.f16942d;
            for (i = 0; i < b3.e(); i++) {
                a = SourceDeserializer.m17063a(JSONUtil.b(b3.a(i)));
                if (a != null) {
                    str = a;
                    break;
                }
            }
            str = null;
            newBuilder.p = str;
            newBuilder.v = Publicity.c;
            newBuilder.D = UnavailableAttachmentDeserializer.m17070a(b3);
            if (contentAppAttribution == null && jsonNode.e("app_attribution") && jsonNode.b("app_attribution").i()) {
                appAttributionDeserializer = this.f16948j;
                contentAppAttribution = AppAttributionDeserializer.m16859b(null, jsonNode.b("app_attribution"));
            }
            newBuilder.F = contentAppAttribution;
            return newBuilder.R();
        }
        b2 = messageType;
        newBuilder.l = b2;
        newBuilder.e = this.f16939a.m16990b(jsonNode.b("sender"));
        if (jsonNode.d("attachment_map")) {
        }
        contentAppAttribution = null;
        b4 = jsonNode.b("share_map");
        b3 = (JsonNode) b4.iterator().next();
        if (b3 == null) {
        }
        if (z) {
        }
        newBuilder.j = this.f16940b.m17061a(b4);
        list = newBuilder.j;
        newBuilder.H = ((Share) list.get(0)).l;
        b3 = b3.b("fb_object_contents");
        if (b3.e() != 0) {
            newBuilder.B = PaymentTransactionDataDeserializer.m16991a((JsonNode) b3.iterator().next());
        }
        b5 = JSONUtil.b(jsonNode.b("offline_threading_id"));
        if (StringUtil.a(b5)) {
            newBuilder.n = b5;
        }
        b3 = jsonNode.b("tags");
        sourceDeserializer = this.f16942d;
        for (i = 0; i < b3.e(); i++) {
            a = SourceDeserializer.m17063a(JSONUtil.b(b3.a(i)));
            if (a != null) {
                str = a;
                break;
            }
        }
        str = null;
        newBuilder.p = str;
        newBuilder.v = Publicity.c;
        newBuilder.D = UnavailableAttachmentDeserializer.m17070a(b3);
        appAttributionDeserializer = this.f16948j;
        contentAppAttribution = AppAttributionDeserializer.m16859b(null, jsonNode.b("app_attribution"));
        newBuilder.F = contentAppAttribution;
        return newBuilder.R();
    }

    @Nullable
    private static MessageType m16977b(JsonNode jsonNode) {
        if (!jsonNode.d("pageAdminReply") || !jsonNode.b("pageAdminReply").i()) {
            return null;
        }
        JsonNode b = jsonNode.b("pageAdminReply");
        if (!b.d("reply_type")) {
            return null;
        }
        String B = b.b("reply_type").B();
        if ("2".equals(B)) {
            return MessageType.COMMERCE_LINK;
        }
        if ("3".equals(B)) {
            return MessageType.COMMERCE_UNLINK;
        }
        return null;
    }

    private Message m16974a(JsonNode jsonNode, ThreadKey threadKey) {
        MessageBuilder newBuilder = Message.newBuilder();
        long c = JSONUtil.c(jsonNode.b("timestamp"));
        long b = ((Boolean) this.f16946h.get()).booleanValue() ? ActionIdHelper.b(c) : JSONUtil.c(jsonNode.b("action_id"));
        newBuilder.a(MessagingIdUtil.m17839d(b));
        newBuilder.b = threadKey;
        newBuilder.g = b;
        int d = JSONUtil.d(jsonNode.b("type"));
        if (d == 1) {
            newBuilder.l = MessageType.ADD_MEMBERS;
        } else if (d == 2) {
            newBuilder.l = MessageType.REMOVE_MEMBERS;
        } else {
            newBuilder.l = MessageType.UNKNOWN;
        }
        JsonNode b2 = jsonNode.b("actor");
        newBuilder.c = c;
        newBuilder.e = this.f16939a.m16990b(b2);
        newBuilder.m = this.f16939a.m16989a(jsonNode.b("users"));
        newBuilder.f = JSONUtil.b(jsonNode.b("body"));
        newBuilder.v = Publicity.c;
        return newBuilder.R();
    }

    private ContentAppAttribution m16979c(JsonNode jsonNode) {
        Iterator j = jsonNode.j();
        while (j.hasNext()) {
            JsonNode b = jsonNode.b((String) j.next());
            if (b.e("attribution") && b.b("attribution").i()) {
                AppAttributionDeserializer appAttributionDeserializer = this.f16948j;
                return AppAttributionDeserializer.m16859b(JSONUtil.b(b.b("fbid")), b.b("attribution"));
            }
        }
        return null;
    }
}
