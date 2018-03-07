package com.facebook.messaging.model.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.messaging.business.commerce.model.retail.CommerceData;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel;
import com.facebook.messaging.model.attachment.Attachment;
import com.facebook.messaging.model.attribution.ContentAppAttribution;
import com.facebook.messaging.model.messagemetadata.MessageMetadataAtTextRange;
import com.facebook.messaging.model.messagemetadata.PlatformMetadata;
import com.facebook.messaging.model.messagemetadata.PlatformMetadataType;
import com.facebook.messaging.model.mms.MmsData;
import com.facebook.messaging.model.payment.PaymentRequestData;
import com.facebook.messaging.model.payment.PaymentTransactionData;
import com.facebook.messaging.model.send.PendingSendQueueKey;
import com.facebook.messaging.model.send.SendError;
import com.facebook.messaging.model.send.SendErrorType;
import com.facebook.messaging.model.share.SentShareAttachment;
import com.facebook.messaging.model.share.Share;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.share.model.ComposerAppAttribution;
import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: uploaded */
public class Message implements Parcelable {
    public static final Creator<Message> CREATOR = new C00951();
    public final PendingSendQueueKey f1993A;
    public final PaymentTransactionData f1994B;
    public final PaymentRequestData f1995C;
    public final boolean f1996D;
    public final ComposerAppAttribution f1997E;
    public final ContentAppAttribution f1998F;
    @Nullable
    public final XMAModel f1999G;
    @Nullable
    public final CommerceData f2000H;
    @Nullable
    public final GenericAdminMessageInfo f2001I;
    @Nullable
    public final Integer f2002J;
    @Nullable
    public final Long f2003K;
    public final MmsData f2004L;
    public final boolean f2005M;
    @Nullable
    public final String f2006N;
    public final boolean f2007O;
    public final ImmutableList<MessageMetadataAtTextRange> f2008P;
    public final ImmutableMap<PlatformMetadataType, PlatformMetadata> f2009Q;
    public final String f2010a;
    public final ThreadKey f2011b;
    public final long f2012c;
    public final long f2013d;
    public final ParticipantInfo f2014e;
    public final String f2015f;
    @Deprecated
    public final long f2016g;
    public final boolean f2017h;
    public final ImmutableList<Attachment> f2018i;
    public final ImmutableList<Share> f2019j;
    public final String f2020k;
    public final MessageType f2021l;
    public final ImmutableList<ParticipantInfo> f2022m;
    public final String f2023n;
    public final boolean f2024o;
    public final String f2025p;
    public final ChannelSource f2026q;
    public final SendChannel f2027r;
    public final Publicity f2028s;
    public final ImmutableList<MediaResource> f2029t;
    public final SentShareAttachment f2030u;
    public final ImmutableMap<String, String> f2031v;
    public final SendError f2032w;
    public final String f2033x;
    public final String f2034y;
    public final ImmutableMap<String, ThreadKey> f2035z;

    /* compiled from: uploaded */
    final class C00951 implements Creator<Message> {
        C00951() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new Message(parcel);
        }

        public final Object[] newArray(int i) {
            return new Message[i];
        }
    }

    /* compiled from: uploaded */
    public enum ChannelSource {
        API,
        CALL_LOG,
        C2DM,
        MQTT,
        SEND
    }

    /* compiled from: uploaded */
    public enum SendChannel {
        UNKNOWN,
        MQTT,
        GRAPH,
        SMS
    }

    Message(MessageBuilder messageBuilder) {
        ArrayList a;
        int i;
        boolean z;
        boolean z2 = false;
        this.f2010a = messageBuilder.f2076a;
        this.f2011b = messageBuilder.f2077b;
        this.f2012c = messageBuilder.f2078c;
        this.f2013d = messageBuilder.f2079d;
        this.f2014e = messageBuilder.f2080e;
        this.f2015f = messageBuilder.f2081f;
        this.f2016g = messageBuilder.f2082g;
        this.f2017h = messageBuilder.f2083h;
        this.f2018i = ImmutableList.copyOf(messageBuilder.f2084i);
        this.f2019j = ImmutableList.copyOf(messageBuilder.f2085j);
        this.f2020k = messageBuilder.f2086k;
        this.f2021l = messageBuilder.f2087l;
        this.f2022m = ImmutableList.copyOf(messageBuilder.f2088m);
        this.f2023n = messageBuilder.f2089n;
        this.f2024o = messageBuilder.f2090o;
        this.f2025p = messageBuilder.f2091p;
        this.f2026q = messageBuilder.f2092q;
        this.f2027r = messageBuilder.f2098w;
        if (messageBuilder.f2093r == null) {
            a = Lists.a();
        } else {
            a = messageBuilder.f2093r;
        }
        this.f2029t = ImmutableList.copyOf(a);
        this.f2030u = messageBuilder.f2094s;
        this.f2031v = ImmutableMap.copyOf(messageBuilder.f2095t);
        this.f2032w = messageBuilder.f2096u;
        this.f2028s = messageBuilder.f2097v;
        this.f2033x = messageBuilder.f2099x;
        this.f2034y = messageBuilder.f2100y;
        Map map = messageBuilder.f2101z;
        this.f2035z = map == null ? null : ImmutableMap.copyOf(map);
        this.f1993A = messageBuilder.f2059A;
        this.f1996D = messageBuilder.f2062D;
        if (this.f2021l == MessageType.FAILED_SEND) {
            i = 1;
        } else {
            i = 0;
        }
        Preconditions.checkArgument(i ^ (this.f2032w.f2169b == SendErrorType.NONE ? 1 : 0));
        if (this.f1993A == null || Objects.equal(this.f1993A.f2166a, this.f2011b)) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.f1994B = messageBuilder.f2060B;
        this.f1995C = messageBuilder.f2061C;
        this.f2000H = messageBuilder.f2066H;
        this.f1997E = messageBuilder.f2063E;
        this.f1998F = messageBuilder.f2064F;
        if (this.f1997E == null || this.f1998F == null) {
            z2 = true;
        }
        Preconditions.checkArgument(z2);
        this.f1999G = messageBuilder.f2065G;
        this.f2001I = messageBuilder.f2067I;
        this.f2002J = messageBuilder.f2068J;
        this.f2003K = messageBuilder.f2069K;
        this.f2004L = messageBuilder.f2070L;
        this.f2005M = messageBuilder.f2071M;
        this.f2006N = messageBuilder.f2072N;
        this.f2007O = messageBuilder.f2073O;
        this.f2008P = ImmutableList.copyOf(messageBuilder.f2074P);
        this.f2009Q = ImmutableMap.copyOf(messageBuilder.f2075Q);
    }

    public Message(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f2010a = parcel.readString();
        this.f2011b = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
        this.f2012c = parcel.readLong();
        this.f2013d = parcel.readLong();
        this.f2014e = (ParticipantInfo) parcel.readParcelable(ParticipantInfo.class.getClassLoader());
        this.f2015f = parcel.readString();
        this.f2016g = parcel.readLong();
        this.f2017h = parcel.readInt() != 0;
        this.f2018i = ImmutableList.copyOf(parcel.readArrayList(Attachment.class.getClassLoader()));
        this.f2019j = ImmutableList.copyOf(parcel.readArrayList(Share.class.getClassLoader()));
        this.f2020k = parcel.readString();
        this.f2021l = (MessageType) parcel.readSerializable();
        this.f2022m = ImmutableList.copyOf(parcel.readArrayList(ParticipantInfo.class.getClassLoader()));
        this.f2023n = parcel.readString();
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f2024o = z;
        this.f2025p = parcel.readString();
        this.f2026q = ChannelSource.valueOf(parcel.readString());
        this.f2029t = ImmutableList.copyOf(parcel.readArrayList(MediaResource.class.getClassLoader()));
        this.f2030u = (SentShareAttachment) parcel.readParcelable(SentShareAttachment.class.getClassLoader());
        this.f2031v = ImmutableMap.copyOf(parcel.readHashMap(Message.class.getClassLoader()));
        this.f2032w = (SendError) parcel.readParcelable(SendError.class.getClassLoader());
        this.f2028s = (Publicity) parcel.readParcelable(Publicity.class.getClassLoader());
        this.f2033x = parcel.readString();
        this.f2034y = parcel.readString();
        Map c = Maps.c();
        ParcelUtil.a(parcel, c, ThreadKey.class);
        this.f2035z = ImmutableMap.copyOf(c);
        this.f1993A = (PendingSendQueueKey) parcel.readParcelable(PendingSendQueueKey.class.getClassLoader());
        this.f1994B = (PaymentTransactionData) parcel.readParcelable(PaymentTransactionData.class.getClassLoader());
        this.f1995C = (PaymentRequestData) parcel.readParcelable(PaymentRequestData.class.getClassLoader());
        this.f1996D = parcel.readInt() != 0;
        this.f1997E = (ComposerAppAttribution) parcel.readParcelable(ComposerAppAttribution.class.getClassLoader());
        this.f1998F = (ContentAppAttribution) parcel.readParcelable(ContentAppAttribution.class.getClassLoader());
        this.f1999G = (XMAModel) FlatBufferModelHelper.a(parcel);
        this.f2000H = (CommerceData) parcel.readParcelable(CommerceData.class.getClassLoader());
        this.f2001I = (GenericAdminMessageInfo) parcel.readParcelable(GenericAdminMessageInfo.class.getClassLoader());
        this.f2002J = (Integer) parcel.readValue(Integer.class.getClassLoader());
        Object readString = parcel.readString();
        this.f2027r = StringUtil.a(readString) ? SendChannel.UNKNOWN : SendChannel.valueOf(readString);
        this.f2004L = (MmsData) parcel.readParcelable(MmsData.class.getClassLoader());
        if (parcel.readInt() == 0) {
            z2 = false;
        }
        this.f2005M = z2;
        this.f2006N = parcel.readString();
        this.f2007O = ParcelUtil.a(parcel);
        this.f2003K = (Long) parcel.readValue(Long.class.getClassLoader());
        this.f2008P = ImmutableList.copyOf(parcel.readArrayList(MessageMetadataAtTextRange.class.getClassLoader()));
        List arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        ArrayList readArrayList = parcel.readArrayList(PlatformMetadata.class.getClassLoader());
        Builder builder = ImmutableMap.builder();
        for (int i = 0; i < arrayList.size(); i++) {
            builder.b(PlatformMetadataType.fromRawValue((String) arrayList.get(i)), readArrayList.get(i));
        }
        this.f2009Q = builder.b();
    }

    public static MessageBuilder newBuilder() {
        return new MessageBuilder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.f2010a);
        parcel.writeParcelable(this.f2011b, i);
        parcel.writeLong(this.f2012c);
        parcel.writeLong(this.f2013d);
        parcel.writeParcelable(this.f2014e, i);
        parcel.writeString(this.f2015f);
        parcel.writeLong(this.f2016g);
        parcel.writeInt(this.f2017h ? 1 : 0);
        parcel.writeList(this.f2018i);
        parcel.writeList(this.f2019j);
        parcel.writeString(this.f2020k);
        parcel.writeSerializable(this.f2021l);
        parcel.writeList(this.f2022m);
        parcel.writeString(this.f2023n);
        if (this.f2024o) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(this.f2025p);
        parcel.writeString(this.f2026q.name());
        parcel.writeList(this.f2029t);
        parcel.writeParcelable(this.f2030u, i);
        parcel.writeMap(this.f2031v);
        parcel.writeParcelable(this.f2032w, i);
        parcel.writeParcelable(this.f2028s, i);
        parcel.writeString(this.f2033x);
        parcel.writeString(this.f2034y);
        ParcelUtil.c(parcel, this.f2035z);
        parcel.writeParcelable(this.f1993A, i);
        parcel.writeParcelable(this.f1994B, i);
        parcel.writeParcelable(this.f1995C, i);
        parcel.writeInt(this.f1996D ? 1 : 0);
        parcel.writeParcelable(this.f1997E, i);
        parcel.writeParcelable(this.f1998F, i);
        FlatBufferModelHelper.a(parcel, this.f1999G);
        parcel.writeParcelable(this.f2000H, i);
        parcel.writeParcelable(this.f2001I, i);
        parcel.writeValue(this.f2002J);
        parcel.writeString(this.f2027r.name());
        parcel.writeParcelable(this.f2004L, i);
        if (!this.f2005M) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeString(this.f2006N);
        ParcelUtil.a(parcel, this.f2007O);
        parcel.writeValue(this.f2003K);
        parcel.writeList(this.f2008P);
        ImmutableMap immutableMap = this.f2009Q;
        List arrayList = new ArrayList();
        ImmutableList asList = immutableMap.keySet().asList();
        int size = asList.size();
        for (int i4 = 0; i4 < size; i4++) {
            arrayList.add(((PlatformMetadataType) asList.get(i4)).value);
        }
        parcel.writeStringList(arrayList);
        parcel.writeList(immutableMap.values().asList());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f2010a);
        if (ThreadKey.m3502g(this.f2011b)) {
            return stringBuilder.toString();
        }
        if (!StringUtil.a(this.f2023n)) {
            stringBuilder.append(" (").append(this.f2023n).append(")");
        }
        stringBuilder.append(" ").append(this.f2026q);
        stringBuilder.append(" t: ").append(this.f2012c);
        stringBuilder.append(" st: ").append(this.f2013d);
        stringBuilder.append(" na: ").append(this.f2024o);
        stringBuilder.append(" ua: ").append(this.f1996D);
        stringBuilder.append(": ");
        String str = this.f2015f;
        if (StringUtil.a(str)) {
            stringBuilder.append("[empty]");
        } else if (str.length() > 10) {
            stringBuilder.append(str.substring(0, 10));
        } else {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public final ImmutableList<MediaResource> m3361a() {
        return !ThreadKey.m3499d(this.f2011b) ? this.f2029t : this.f2004L.f2133d;
    }
}
