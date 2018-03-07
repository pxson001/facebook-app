package com.facebook.messaging.model.threads;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.graphql.enums.GraphQLMessageThreadCannotReplyReason;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.messages.MessageDraft;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.user.model.UserKey;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.AbstractList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: update-photo-info */
public class ThreadSummary implements Parcelable {
    public static final Creator<ThreadSummary> CREATOR = new C01261();
    public final FolderName f2297A;
    public final MessageDraft f2298B;
    public final NotificationSetting f2299C;
    public final ThreadCustomization f2300D;
    public final ThreadRtcCallInfoData f2301E;
    public final long f2302F;
    public final boolean f2303G;
    public final int f2304H;
    public final Uri f2305I;
    public final ImmutableList<ThreadEventReminder> f2306J;
    public final boolean f2307K;
    public final long f2308L;
    public final float f2309M;
    public ImmutableMap<String, ThreadGameData> f2310N;
    @Nullable
    public String f2311O;
    public final GroupType f2312P;
    public final boolean f2313Q;
    public final ImmutableList<ThreadJoinRequest> f2314R;
    @Nullable
    public final TriState f2315S;
    public final TriState f2316T;
    public final int f2317U;
    @Nullable
    private ImmutableMap<UserKey, ThreadParticipant> f2318V;
    public final ThreadKey f2319a;
    @Deprecated
    public final String f2320b;
    @Deprecated
    public final long f2321c;
    public final long f2322d;
    public final long f2323e;
    @Deprecated
    public final long f2324f;
    public final String f2325g;
    public final ImmutableList<ThreadParticipant> f2326h;
    public final ImmutableList<ThreadParticipant> f2327i;
    public final ImmutableList<ThreadParticipant> f2328j;
    public final long f2329k;
    public final long f2330l;
    public final long f2331m;
    public final long f2332n;
    public final ImmutableList<ParticipantInfo> f2333o;
    public final String f2334p;
    public final String f2335q;
    public final ParticipantInfo f2336r;
    public final String f2337s;
    public final Uri f2338t;
    public final boolean f2339u;
    public final GraphQLMessageThreadCannotReplyReason f2340v;
    public final boolean f2341w;
    public final boolean f2342x;
    public final boolean f2343y;
    public final boolean f2344z;

    /* compiled from: update-photo-info */
    final class C01261 implements Creator<ThreadSummary> {
        C01261() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ThreadSummary(parcel);
        }

        public final Object[] newArray(int i) {
            return new ThreadSummary[i];
        }
    }

    @Immutable
    /* compiled from: update-photo-info */
    public enum GroupType {
        PRIVATE("private"),
        HIDDEN("hidden"),
        PUBLIC("public");
        
        public final String dbValue;

        private GroupType(String str) {
            Preconditions.checkArgument(!Strings.isNullOrEmpty(str));
            this.dbValue = str;
        }

        @Nullable
        public static GroupType fromDbValue(String str) {
            for (GroupType groupType : values()) {
                if (Objects.equal(groupType.dbValue, str)) {
                    return groupType;
                }
            }
            return null;
        }

        public static GroupType fromIntegerValue(int i) {
            switch (i) {
                case 1:
                    return HIDDEN;
                default:
                    return PRIVATE;
            }
        }
    }

    /* compiled from: update-photo-info */
    public class MergedList extends AbstractList<ThreadParticipant> {
        private final ImmutableList<ThreadParticipant> f2294a;
        private final ImmutableList<ThreadParticipant> f2295b;
        private final ImmutableList<ThreadParticipant> f2296c;

        public MergedList(ImmutableList<ThreadParticipant> immutableList, ImmutableList<ThreadParticipant> immutableList2, ImmutableList<ThreadParticipant> immutableList3) {
            this.f2294a = immutableList;
            this.f2295b = immutableList2;
            this.f2296c = immutableList3;
        }

        public Object get(int i) {
            if (i < this.f2294a.size()) {
                return (ThreadParticipant) this.f2294a.get(i);
            }
            if (i < this.f2294a.size() + this.f2295b.size()) {
                return (ThreadParticipant) this.f2295b.get(i - this.f2294a.size());
            }
            return (ThreadParticipant) this.f2296c.get((i - this.f2294a.size()) - this.f2295b.size());
        }

        public int size() {
            return (this.f2294a.size() + this.f2295b.size()) + this.f2296c.size();
        }
    }

    ThreadSummary(ThreadSummaryBuilder threadSummaryBuilder) {
        GraphQLMessageThreadCannotReplyReason graphQLMessageThreadCannotReplyReason;
        Preconditions.checkNotNull(threadSummaryBuilder.f2345A);
        Preconditions.checkNotNull(threadSummaryBuilder.f2366a);
        this.f2319a = threadSummaryBuilder.f2366a;
        this.f2320b = threadSummaryBuilder.f2367b;
        this.f2321c = threadSummaryBuilder.f2368c;
        this.f2322d = threadSummaryBuilder.f2369d;
        this.f2323e = threadSummaryBuilder.f2370e;
        this.f2324f = threadSummaryBuilder.f2371f;
        this.f2325g = threadSummaryBuilder.f2372g;
        this.f2326h = ImmutableList.copyOf(threadSummaryBuilder.f2373h);
        this.f2327i = ImmutableList.copyOf(threadSummaryBuilder.f2374i);
        this.f2328j = ImmutableList.copyOf(threadSummaryBuilder.f2375j);
        this.f2329k = threadSummaryBuilder.f2376k;
        this.f2330l = threadSummaryBuilder.f2377l;
        this.f2331m = threadSummaryBuilder.f2378m;
        this.f2332n = threadSummaryBuilder.f2379n;
        this.f2333o = ImmutableList.copyOf(threadSummaryBuilder.f2380o);
        this.f2334p = threadSummaryBuilder.f2381p;
        this.f2335q = threadSummaryBuilder.f2383r;
        this.f2336r = threadSummaryBuilder.f2382q;
        this.f2337s = threadSummaryBuilder.f2384s;
        this.f2338t = threadSummaryBuilder.f2385t;
        this.f2339u = threadSummaryBuilder.f2386u;
        if (threadSummaryBuilder.f2387v != null) {
            graphQLMessageThreadCannotReplyReason = threadSummaryBuilder.f2387v;
        } else {
            graphQLMessageThreadCannotReplyReason = GraphQLMessageThreadCannotReplyReason.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        this.f2340v = graphQLMessageThreadCannotReplyReason;
        this.f2341w = threadSummaryBuilder.f2388w;
        this.f2342x = threadSummaryBuilder.f2389x;
        this.f2343y = threadSummaryBuilder.f2390y;
        this.f2344z = threadSummaryBuilder.f2391z;
        this.f2297A = threadSummaryBuilder.f2345A;
        this.f2298B = threadSummaryBuilder.f2346B;
        this.f2299C = threadSummaryBuilder.f2347C;
        this.f2300D = threadSummaryBuilder.f2348D;
        this.f2302F = threadSummaryBuilder.f2349E;
        this.f2303G = threadSummaryBuilder.f2350F;
        this.f2304H = threadSummaryBuilder.f2351G;
        this.f2305I = threadSummaryBuilder.f2352H;
        this.f2306J = ImmutableList.copyOf(threadSummaryBuilder.f2353I);
        this.f2307K = threadSummaryBuilder.f2354J;
        this.f2308L = threadSummaryBuilder.f2355K;
        this.f2309M = threadSummaryBuilder.f2356L;
        this.f2310N = ImmutableMap.copyOf(threadSummaryBuilder.f2357M);
        this.f2312P = m3567a(threadSummaryBuilder.f2358N);
        this.f2313Q = m3569a(threadSummaryBuilder.f2359O);
        this.f2314R = ImmutableList.copyOf(threadSummaryBuilder.f2360P);
        this.f2301E = threadSummaryBuilder.f2361Q;
        this.f2311O = threadSummaryBuilder.f2362R;
        this.f2315S = threadSummaryBuilder.f2363S;
        this.f2316T = m3566a(threadSummaryBuilder.f2364T);
        this.f2317U = threadSummaryBuilder.f2365U;
    }

    public ThreadSummary(Parcel parcel) {
        this.f2319a = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
        this.f2320b = parcel.readString();
        this.f2321c = parcel.readLong();
        this.f2322d = parcel.readLong();
        this.f2323e = parcel.readLong();
        this.f2324f = parcel.readLong();
        this.f2325g = parcel.readString();
        this.f2326h = ImmutableList.copyOf(parcel.createTypedArrayList(ThreadParticipant.CREATOR));
        this.f2327i = ImmutableList.copyOf(parcel.createTypedArrayList(ThreadParticipant.CREATOR));
        this.f2328j = ImmutableList.copyOf(parcel.createTypedArrayList(ThreadParticipant.CREATOR));
        this.f2329k = parcel.readLong();
        this.f2330l = parcel.readLong();
        this.f2331m = parcel.readLong();
        this.f2332n = parcel.readLong();
        this.f2333o = ImmutableList.copyOf(parcel.createTypedArrayList(ParticipantInfo.CREATOR));
        this.f2334p = parcel.readString();
        this.f2335q = parcel.readString();
        this.f2336r = (ParticipantInfo) parcel.readParcelable(ParticipantInfo.class.getClassLoader());
        this.f2337s = parcel.readString();
        this.f2338t = (Uri) parcel.readParcelable(null);
        this.f2339u = ParcelUtil.a(parcel);
        GraphQLMessageThreadCannotReplyReason graphQLMessageThreadCannotReplyReason = (GraphQLMessageThreadCannotReplyReason) ParcelUtil.c(parcel, GraphQLMessageThreadCannotReplyReason.class);
        if (graphQLMessageThreadCannotReplyReason == null) {
            graphQLMessageThreadCannotReplyReason = GraphQLMessageThreadCannotReplyReason.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        this.f2340v = graphQLMessageThreadCannotReplyReason;
        this.f2341w = ParcelUtil.a(parcel);
        this.f2342x = ParcelUtil.a(parcel);
        this.f2343y = ParcelUtil.a(parcel);
        this.f2344z = ParcelUtil.a(parcel);
        this.f2297A = FolderName.fromDbName(parcel.readString());
        this.f2298B = (MessageDraft) parcel.readParcelable(MessageDraft.class.getClassLoader());
        this.f2299C = (NotificationSetting) parcel.readParcelable(NotificationSetting.class.getClassLoader());
        this.f2300D = (ThreadCustomization) parcel.readParcelable(ThreadCustomization.class.getClassLoader());
        this.f2302F = parcel.readLong();
        this.f2303G = ParcelUtil.a(parcel);
        this.f2304H = parcel.readInt();
        this.f2305I = (Uri) parcel.readParcelable(null);
        this.f2306J = ImmutableList.copyOf(parcel.createTypedArrayList(ThreadEventReminder.CREATOR));
        this.f2307K = ParcelUtil.a(parcel);
        this.f2308L = parcel.readLong();
        this.f2309M = parcel.readFloat();
        Map hashMap = new HashMap();
        ParcelUtil.a(parcel, hashMap, ThreadGameData.class);
        this.f2310N = ImmutableMap.copyOf(hashMap);
        this.f2312P = m3567a(GroupType.fromDbValue(parcel.readString()));
        this.f2313Q = m3569a(ParcelUtil.a(parcel));
        this.f2314R = ImmutableList.copyOf(parcel.createTypedArrayList(ThreadJoinRequest.CREATOR));
        this.f2301E = (ThreadRtcCallInfoData) parcel.readParcelable(ThreadRtcCallInfoData.class.getClassLoader());
        this.f2311O = parcel.readString();
        this.f2315S = ParcelUtil.g(parcel);
        this.f2316T = m3566a(ParcelUtil.g(parcel));
        this.f2317U = parcel.readInt();
    }

    public static ThreadSummaryBuilder newBuilder() {
        return new ThreadSummaryBuilder();
    }

    public final boolean m3571a() {
        return !StringUtil.a(this.f2325g);
    }

    public final boolean m3572b() {
        return this.f2337s != null;
    }

    public final boolean m3573c() {
        return this.f2338t != null;
    }

    public final boolean m3574d() {
        return this.f2312P == GroupType.HIDDEN && this.f2305I != null;
    }

    @Nullable
    public final ThreadParticipant m3570a(UserKey userKey) {
        if (this.f2318V == null) {
            int i;
            ThreadParticipant threadParticipant;
            ImmutableList immutableList = this.f2326h;
            ImmutableList immutableList2 = this.f2327i;
            ImmutableList immutableList3 = this.f2328j;
            int i2 = 0;
            Map c = Maps.c();
            int size = immutableList.size();
            for (i = 0; i < size; i++) {
                threadParticipant = (ThreadParticipant) immutableList.get(i);
                c.put(threadParticipant.m3549b(), threadParticipant);
            }
            size = immutableList2.size();
            for (i = 0; i < size; i++) {
                threadParticipant = (ThreadParticipant) immutableList2.get(i);
                c.put(threadParticipant.m3549b(), threadParticipant);
            }
            i = immutableList3.size();
            while (i2 < i) {
                threadParticipant = (ThreadParticipant) immutableList3.get(i2);
                c.put(threadParticipant.m3549b(), threadParticipant);
                i2++;
            }
            this.f2318V = ImmutableMap.copyOf(c);
        }
        return (ThreadParticipant) this.f2318V.get(userKey);
    }

    public final boolean m3575f() {
        return this.f2330l < this.f2329k;
    }

    public final boolean m3576g() {
        return ThreadKey.m3499d(this.f2319a) && this.f2326h != null && this.f2326h.size() > 2;
    }

    public final boolean m3577h() {
        return this.f2304H != 0;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f2319a, i);
        parcel.writeString(this.f2320b);
        parcel.writeLong(this.f2321c);
        parcel.writeLong(this.f2322d);
        parcel.writeLong(this.f2323e);
        parcel.writeLong(this.f2324f);
        parcel.writeString(this.f2325g);
        parcel.writeTypedList(this.f2326h);
        parcel.writeTypedList(this.f2327i);
        parcel.writeTypedList(this.f2328j);
        parcel.writeLong(this.f2329k);
        parcel.writeLong(this.f2330l);
        parcel.writeLong(this.f2331m);
        parcel.writeLong(this.f2332n);
        parcel.writeTypedList(this.f2333o);
        parcel.writeString(this.f2334p);
        parcel.writeString(this.f2335q);
        parcel.writeParcelable(this.f2336r, i);
        parcel.writeString(this.f2337s);
        parcel.writeParcelable(this.f2338t, i);
        ParcelUtil.a(parcel, this.f2339u);
        ParcelUtil.a(parcel, this.f2340v);
        ParcelUtil.a(parcel, this.f2341w);
        ParcelUtil.a(parcel, this.f2342x);
        ParcelUtil.a(parcel, this.f2343y);
        ParcelUtil.a(parcel, this.f2344z);
        parcel.writeString(this.f2297A.dbName);
        parcel.writeParcelable(this.f2298B, i);
        parcel.writeParcelable(this.f2299C, i);
        parcel.writeParcelable(this.f2300D, i);
        parcel.writeLong(this.f2302F);
        ParcelUtil.a(parcel, this.f2303G);
        parcel.writeInt(this.f2304H);
        parcel.writeParcelable(this.f2305I, i);
        parcel.writeTypedList(this.f2306J);
        ParcelUtil.a(parcel, this.f2307K);
        parcel.writeLong(this.f2308L);
        parcel.writeFloat(this.f2309M);
        ParcelUtil.c(parcel, this.f2310N);
        parcel.writeString(this.f2312P.dbValue);
        ParcelUtil.a(parcel, this.f2313Q);
        parcel.writeTypedList(this.f2314R);
        parcel.writeParcelable(this.f2301E, i);
        parcel.writeString(this.f2311O);
        ParcelUtil.a(parcel, this.f2315S);
        ParcelUtil.a(parcel, this.f2316T);
        parcel.writeInt(this.f2317U);
    }

    public String toString() {
        return Objects.toStringHelper(ThreadSummary.class).add("threadKey", this.f2319a).add("folder", this.f2297A.toString()).add("name", this.f2325g).add("unread", m3575f()).add("timestampMs", this.f2329k).add("lastReadTimestampMs", this.f2330l).add("participants", this.f2326h).add("senders", this.f2333o).add("snippet", m3568a(this.f2334p)).add("adminSnippet", m3568a(this.f2335q)).add("threadCustomization", this.f2300D).add("outgoingMessageLifetime", this.f2304H).add("subscribed", this.f2341w).add("canReplyTo", this.f2339u).toString();
    }

    private static String m3568a(String str) {
        if (str == null) {
            return null;
        }
        return str.replace("\n", " ");
    }

    private GroupType m3567a(@Nullable GroupType groupType) {
        Preconditions.checkNotNull(groupType);
        if (!this.f2319a.m3505b()) {
            Preconditions.checkArgument(groupType.equals(GroupType.PRIVATE));
        }
        return groupType;
    }

    private boolean m3569a(boolean z) {
        if (!this.f2319a.m3505b()) {
            Preconditions.checkArgument(!z);
        }
        return z;
    }

    private TriState m3566a(TriState triState) {
        Preconditions.checkNotNull(triState);
        if (!(this.f2319a.m3505b() || this.f2319a.m3507d())) {
            Preconditions.checkArgument(triState != TriState.YES);
        }
        return triState;
    }
}
