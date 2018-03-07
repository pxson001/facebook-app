package com.facebook.messaging.model.messages;

import com.facebook.debug.log.BLog;
import com.facebook.messaging.business.commerce.model.retail.CommerceData;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel;
import com.facebook.messaging.model.attachment.Attachment;
import com.facebook.messaging.model.attribution.ContentAppAttribution;
import com.facebook.messaging.model.messagemetadata.MessageMetadataAtTextRange;
import com.facebook.messaging.model.messagemetadata.PlatformMetadata;
import com.facebook.messaging.model.messagemetadata.PlatformMetadataType;
import com.facebook.messaging.model.messages.Message.ChannelSource;
import com.facebook.messaging.model.messages.Message.SendChannel;
import com.facebook.messaging.model.mms.MmsData;
import com.facebook.messaging.model.payment.PaymentRequestData;
import com.facebook.messaging.model.payment.PaymentTransactionData;
import com.facebook.messaging.model.send.PendingSendQueueKey;
import com.facebook.messaging.model.send.SendError;
import com.facebook.messaging.model.share.SentShareAttachment;
import com.facebook.messaging.model.share.Share;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.share.model.ComposerAppAttribution;
import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: upload_speed */
public class MessageBuilder {
    public PendingSendQueueKey f2059A;
    public PaymentTransactionData f2060B;
    public PaymentRequestData f2061C;
    public boolean f2062D;
    public ComposerAppAttribution f2063E;
    public ContentAppAttribution f2064F;
    @Nullable
    public XMAModel f2065G;
    @Nullable
    public CommerceData f2066H;
    @Nullable
    public GenericAdminMessageInfo f2067I;
    @Nullable
    public Integer f2068J;
    @Nullable
    public Long f2069K;
    public MmsData f2070L = MmsData.f2129a;
    public boolean f2071M;
    @Nullable
    public String f2072N;
    public boolean f2073O;
    public List<MessageMetadataAtTextRange> f2074P = RegularImmutableList.a;
    public Map<PlatformMetadataType, PlatformMetadata> f2075Q = new HashMap();
    public String f2076a;
    public ThreadKey f2077b;
    public long f2078c;
    public long f2079d;
    public ParticipantInfo f2080e;
    public String f2081f;
    public long f2082g;
    public boolean f2083h;
    public List<Attachment> f2084i = RegularImmutableList.a;
    public List<Share> f2085j = RegularImmutableList.a;
    public String f2086k;
    public MessageType f2087l = MessageType.REGULAR;
    public List<ParticipantInfo> f2088m = RegularImmutableList.a;
    public String f2089n;
    public boolean f2090o;
    public String f2091p;
    public ChannelSource f2092q = ChannelSource.API;
    public List<MediaResource> f2093r = RegularImmutableList.a;
    public SentShareAttachment f2094s;
    public Map<String, String> f2095t = Maps.c();
    public SendError f2096u = SendError.f2168a;
    public Publicity f2097v = Publicity.f2124a;
    public SendChannel f2098w = SendChannel.UNKNOWN;
    public String f2099x;
    public String f2100y;
    public Map<String, ThreadKey> f2101z;

    MessageBuilder() {
    }

    public final MessageBuilder m3381a(Message message) {
        this.f2076a = message.f2010a;
        this.f2077b = message.f2011b;
        this.f2078c = message.f2012c;
        this.f2079d = message.f2013d;
        this.f2080e = message.f2014e;
        this.f2081f = message.f2015f;
        this.f2082g = message.f2016g;
        this.f2083h = message.f2017h;
        this.f2084i = message.f2018i;
        this.f2085j = message.f2019j;
        this.f2086k = message.f2020k;
        this.f2087l = message.f2021l;
        this.f2088m = message.f2022m;
        this.f2089n = message.f2023n;
        this.f2090o = message.f2024o;
        this.f2091p = message.f2025p;
        this.f2092q = message.f2026q;
        this.f2098w = message.f2027r;
        this.f2093r = message.f2029t;
        this.f2094s = message.f2030u;
        this.f2095t = Maps.a(message.f2031v);
        this.f2096u = message.f2032w;
        this.f2097v = message.f2028s;
        this.f2099x = message.f2033x;
        this.f2100y = message.f2034y;
        this.f2101z = message.f2035z;
        this.f2059A = message.f1993A;
        this.f2060B = message.f1994B;
        this.f2061C = message.f1995C;
        this.f2062D = message.f1996D;
        this.f2063E = message.f1997E;
        this.f2064F = message.f1998F;
        this.f2065G = message.f1999G;
        this.f2066H = message.f2000H;
        this.f2067I = message.f2001I;
        this.f2068J = message.f2002J;
        this.f2069K = message.f2003K;
        this.f2070L = message.f2004L;
        this.f2071M = message.f2005M;
        this.f2072N = message.f2006N;
        this.f2073O = message.f2007O;
        this.f2074P = message.f2008P;
        this.f2075Q = message.f2009Q;
        return this;
    }

    public final MessageBuilder m3395a(String str) {
        if (str != null && str.startsWith("m_mid")) {
            BLog.c("MessageBuilder", "Encountered a legacy message id.");
        }
        this.f2076a = str;
        return this;
    }

    public final MessageBuilder m3391a(ThreadKey threadKey) {
        this.f2077b = threadKey;
        return this;
    }

    public final MessageBuilder m3374a(long j) {
        this.f2078c = j;
        return this;
    }

    public final MessageBuilder m3400b(long j) {
        this.f2079d = j;
        return this;
    }

    public final ParticipantInfo m3416e() {
        return this.f2080e;
    }

    public final MessageBuilder m3383a(@Nullable ParticipantInfo participantInfo) {
        this.f2080e = participantInfo;
        return this;
    }

    public final String m3417f() {
        return this.f2081f;
    }

    public final MessageBuilder m3401b(@Nullable String str) {
        this.f2081f = str;
        return this;
    }

    public final MessageBuilder m3405c(long j) {
        this.f2082g = j;
        return this;
    }

    public final MessageBuilder m3399a(boolean z) {
        this.f2083h = z;
        return this;
    }

    public final MessageBuilder m3397a(List<Attachment> list) {
        this.f2084i = list;
        return this;
    }

    public final List<Share> m3419j() {
        return this.f2085j;
    }

    public final MessageBuilder m3402b(List<Share> list) {
        this.f2085j = list;
        return this;
    }

    public final String m3420k() {
        return this.f2086k;
    }

    public final MessageBuilder m3406c(@Nullable String str) {
        this.f2086k = str;
        return this;
    }

    public final MessageType m3421l() {
        return this.f2087l;
    }

    public final MessageBuilder m3382a(MessageType messageType) {
        this.f2087l = messageType;
        return this;
    }

    public final MessageBuilder m3378a(GenericAdminMessageInfo genericAdminMessageInfo) {
        this.f2067I = genericAdminMessageInfo;
        return this;
    }

    public final MessageBuilder m3407c(List<ParticipantInfo> list) {
        this.f2088m = list;
        return this;
    }

    public final MessageBuilder m3410d(@Nullable String str) {
        this.f2089n = str;
        return this;
    }

    public final MessageBuilder m3404b(boolean z) {
        this.f2090o = z;
        return this;
    }

    public final MessageBuilder m3413e(@Nullable String str) {
        this.f2091p = str;
        return this;
    }

    public final MessageBuilder m3379a(ChannelSource channelSource) {
        this.f2092q = channelSource;
        return this;
    }

    public final MessageBuilder m3380a(SendChannel sendChannel) {
        this.f2098w = (SendChannel) Preconditions.checkNotNull(sendChannel);
        return this;
    }

    public final MessageBuilder m3411d(List<MediaResource> list) {
        this.f2093r = list;
        return this;
    }

    public final MessageBuilder m3390a(@Nullable SentShareAttachment sentShareAttachment) {
        this.f2094s = sentShareAttachment;
        return this;
    }

    public final MessageBuilder m3398a(Map<String, String> map) {
        Preconditions.checkNotNull(map);
        this.f2095t = Maps.a(map);
        return this;
    }

    public final MessageBuilder m3396a(String str, String str2) {
        this.f2095t.put(str, str2);
        return this;
    }

    public final MessageBuilder m3403b(Map<String, String> map) {
        this.f2095t.putAll(map);
        return this;
    }

    public final MessageBuilder m3389a(SendError sendError) {
        this.f2096u = sendError;
        return this;
    }

    public final MessageBuilder m3384a(Publicity publicity) {
        this.f2097v = publicity;
        return this;
    }

    public final MessageBuilder m3388a(@Nullable PendingSendQueueKey pendingSendQueueKey) {
        this.f2059A = pendingSendQueueKey;
        return this;
    }

    public final MessageBuilder m3387a(@Nullable PaymentTransactionData paymentTransactionData) {
        this.f2060B = paymentTransactionData;
        return this;
    }

    public final MessageBuilder m3386a(@Nullable PaymentRequestData paymentRequestData) {
        this.f2061C = paymentRequestData;
        return this;
    }

    public final MessageBuilder m3409c(boolean z) {
        this.f2062D = z;
        return this;
    }

    public final MessageBuilder m3392a(ComposerAppAttribution composerAppAttribution) {
        this.f2063E = composerAppAttribution;
        return this;
    }

    public final MessageBuilder m3377a(ContentAppAttribution contentAppAttribution) {
        this.f2064F = contentAppAttribution;
        return this;
    }

    public final MessageBuilder m3376a(@Nullable XMAModel xMAModel) {
        this.f2065G = xMAModel;
        return this;
    }

    public final MessageBuilder m3375a(CommerceData commerceData) {
        this.f2066H = commerceData;
        return this;
    }

    public final MessageBuilder m3393a(Integer num) {
        this.f2068J = num;
        return this;
    }

    @Nullable
    public final Long m3370K() {
        return this.f2069K;
    }

    public final MessageBuilder m3394a(@Nullable Long l) {
        this.f2069K = l;
        return this;
    }

    public final MmsData m3371L() {
        return this.f2070L;
    }

    public final MessageBuilder m3385a(MmsData mmsData) {
        Preconditions.checkArgument(mmsData != null);
        this.f2070L = mmsData;
        return this;
    }

    public final MessageBuilder m3412d(boolean z) {
        this.f2071M = z;
        return this;
    }

    public final MessageBuilder m3418h(String str) {
        this.f2072N = str;
        return this;
    }

    public final MessageBuilder m3415e(boolean z) {
        this.f2073O = z;
        return this;
    }

    public final MessageBuilder m3414e(@Nullable List<MessageMetadataAtTextRange> list) {
        if (list == null) {
            list = RegularImmutableList.a;
        }
        this.f2074P = list;
        return this;
    }

    public final Map<PlatformMetadataType, PlatformMetadata> m3372Q() {
        return this.f2075Q;
    }

    public final MessageBuilder m3408c(@Nullable Map<PlatformMetadataType, PlatformMetadata> map) {
        this.f2075Q = map;
        if (this.f2075Q == null) {
            this.f2075Q = new HashMap();
        }
        return this;
    }

    public final Message m3373R() {
        return new Message(this);
    }
}
