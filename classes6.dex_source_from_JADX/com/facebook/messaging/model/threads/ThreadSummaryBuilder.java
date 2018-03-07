package com.facebook.messaging.model.threads;

import android.net.Uri;
import com.facebook.common.util.TriState;
import com.facebook.graphql.enums.GraphQLMessageThreadCannotReplyReason;
import com.facebook.messaging.model.folders.FolderName;
import com.facebook.messaging.model.messages.MessageDraft;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary.GroupType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.collect.RegularImmutableList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: upcoming_saved_count */
public class ThreadSummaryBuilder {
    public FolderName f2345A;
    public MessageDraft f2346B;
    public NotificationSetting f2347C = NotificationSetting.f2238a;
    public ThreadCustomization f2348D;
    public long f2349E = -1;
    public boolean f2350F;
    public int f2351G;
    public Uri f2352H;
    public List<ThreadEventReminder> f2353I = RegularImmutableList.a;
    public boolean f2354J;
    public long f2355K;
    public float f2356L;
    public Map<String, ThreadGameData> f2357M = RegularImmutableBiMap.a;
    public GroupType f2358N;
    public boolean f2359O;
    public List<ThreadJoinRequest> f2360P = RegularImmutableList.a;
    public ThreadRtcCallInfoData f2361Q;
    public String f2362R;
    @Nullable
    public TriState f2363S;
    @Nullable
    public TriState f2364T;
    public int f2365U;
    public ThreadKey f2366a;
    public String f2367b;
    public long f2368c;
    public long f2369d = -1;
    public long f2370e;
    public long f2371f;
    public String f2372g;
    public List<ThreadParticipant> f2373h = RegularImmutableList.a;
    public List<ThreadParticipant> f2374i = RegularImmutableList.a;
    public List<ThreadParticipant> f2375j = RegularImmutableList.a;
    public long f2376k;
    public long f2377l;
    public long f2378m;
    public long f2379n;
    public List<ParticipantInfo> f2380o = RegularImmutableList.a;
    public String f2381p;
    public ParticipantInfo f2382q;
    public String f2383r;
    public String f2384s;
    public Uri f2385t;
    public boolean f2386u;
    public GraphQLMessageThreadCannotReplyReason f2387v;
    public boolean f2388w;
    public boolean f2389x;
    public boolean f2390y;
    public boolean f2391z;

    ThreadSummaryBuilder() {
    }

    public final ThreadSummaryBuilder m3594a(ThreadSummary threadSummary) {
        this.f2366a = threadSummary.f2319a;
        this.f2367b = threadSummary.f2320b;
        this.f2368c = threadSummary.f2321c;
        this.f2369d = threadSummary.f2322d;
        this.f2370e = threadSummary.f2323e;
        this.f2371f = threadSummary.f2324f;
        this.f2372g = threadSummary.f2325g;
        this.f2373h = threadSummary.f2326h;
        this.f2374i = threadSummary.f2327i;
        this.f2375j = threadSummary.f2328j;
        this.f2376k = threadSummary.f2329k;
        this.f2355K = threadSummary.f2308L;
        this.f2377l = threadSummary.f2330l;
        this.f2378m = threadSummary.f2331m;
        this.f2379n = threadSummary.f2332n;
        this.f2380o = threadSummary.f2333o;
        this.f2381p = threadSummary.f2334p;
        this.f2382q = threadSummary.f2336r;
        this.f2383r = threadSummary.f2335q;
        this.f2384s = threadSummary.f2337s;
        this.f2385t = threadSummary.f2338t;
        this.f2386u = threadSummary.f2339u;
        this.f2387v = threadSummary.f2340v;
        this.f2388w = threadSummary.f2341w;
        this.f2389x = threadSummary.f2342x;
        this.f2390y = threadSummary.f2343y;
        this.f2391z = threadSummary.f2344z;
        this.f2345A = threadSummary.f2297A;
        this.f2346B = threadSummary.f2298B;
        this.f2347C = threadSummary.f2299C;
        this.f2348D = threadSummary.f2300D;
        this.f2349E = threadSummary.f2302F;
        this.f2350F = threadSummary.f2303G;
        this.f2351G = threadSummary.f2304H;
        this.f2352H = threadSummary.f2305I;
        this.f2353I = threadSummary.f2306J;
        this.f2354J = threadSummary.f2307K;
        this.f2356L = threadSummary.f2309M;
        this.f2357M = threadSummary.f2310N;
        this.f2358N = threadSummary.f2312P;
        this.f2359O = threadSummary.f2313Q;
        this.f2360P = threadSummary.f2314R;
        this.f2361Q = threadSummary.f2301E;
        this.f2362R = threadSummary.f2311O;
        this.f2363S = threadSummary.f2315S;
        this.f2364T = threadSummary.f2316T;
        this.f2365U = threadSummary.f2317U;
        return this;
    }

    public final ThreadKey m3579a() {
        return this.f2366a;
    }

    public final ThreadSummaryBuilder m3589a(ThreadKey threadKey) {
        this.f2366a = threadKey;
        return this;
    }

    public final ThreadSummaryBuilder m3596a(String str) {
        this.f2367b = str;
        return this;
    }

    public final ThreadSummaryBuilder m3582a(long j) {
        this.f2370e = j;
        return this;
    }

    public final ThreadSummaryBuilder m3599b(long j) {
        this.f2371f = j;
        return this;
    }

    public final ThreadSummaryBuilder m3604c(long j) {
        this.f2368c = j;
        return this;
    }

    public final ThreadSummaryBuilder m3608d(long j) {
        this.f2369d = j;
        return this;
    }

    public final ThreadSummaryBuilder m3601b(String str) {
        this.f2372g = str;
        return this;
    }

    public final ThreadSummaryBuilder m3597a(List<ThreadParticipant> list) {
        this.f2373h = list;
        return this;
    }

    public final ThreadSummaryBuilder m3602b(List<ThreadParticipant> list) {
        this.f2374i = list;
        return this;
    }

    public final ThreadSummaryBuilder m3606c(List<ThreadParticipant> list) {
        this.f2375j = list;
        return this;
    }

    public final long m3623k() {
        return this.f2376k;
    }

    public final ThreadSummaryBuilder m3611e(long j) {
        this.f2376k = j;
        return this;
    }

    public final ThreadSummaryBuilder m3614f(long j) {
        this.f2377l = j;
        return this;
    }

    public final ThreadSummaryBuilder m3617g(long j) {
        this.f2378m = j;
        return this;
    }

    public final ThreadSummaryBuilder m3619h(long j) {
        this.f2379n = j;
        return this;
    }

    public final ThreadSummaryBuilder m3605c(@Nullable String str) {
        this.f2381p = str;
        return this;
    }

    public final ThreadSummaryBuilder m3588a(ParticipantInfo participantInfo) {
        this.f2382q = participantInfo;
        return this;
    }

    public final ThreadSummaryBuilder m3609d(@Nullable String str) {
        this.f2383r = str;
        return this;
    }

    public final ThreadSummaryBuilder m3583a(Uri uri) {
        this.f2385t = uri;
        return this;
    }

    public final ThreadSummaryBuilder m3598a(boolean z) {
        this.f2386u = z;
        return this;
    }

    public final ThreadSummaryBuilder m3585a(GraphQLMessageThreadCannotReplyReason graphQLMessageThreadCannotReplyReason) {
        this.f2387v = graphQLMessageThreadCannotReplyReason;
        return this;
    }

    public final ThreadSummaryBuilder m3603b(boolean z) {
        this.f2388w = z;
        return this;
    }

    public final ThreadSummaryBuilder m3607c(boolean z) {
        this.f2389x = z;
        return this;
    }

    public final ThreadSummaryBuilder m3610d(boolean z) {
        this.f2390y = z;
        return this;
    }

    public final ThreadSummaryBuilder m3613e(boolean z) {
        this.f2391z = z;
        return this;
    }

    public final ThreadSummaryBuilder m3586a(FolderName folderName) {
        this.f2345A = folderName;
        return this;
    }

    public final ThreadSummaryBuilder m3587a(@Nullable MessageDraft messageDraft) {
        this.f2346B = messageDraft;
        return this;
    }

    public final ThreadSummaryBuilder m3590a(NotificationSetting notificationSetting) {
        this.f2347C = notificationSetting;
        return this;
    }

    public final ThreadSummaryBuilder m3591a(ThreadCustomization threadCustomization) {
        this.f2348D = threadCustomization;
        return this;
    }

    public final ThreadSummaryBuilder m3621i(long j) {
        this.f2349E = j;
        return this;
    }

    public final ThreadSummaryBuilder m3616f(boolean z) {
        this.f2350F = z;
        return this;
    }

    public final ThreadSummaryBuilder m3581a(int i) {
        this.f2351G = i;
        return this;
    }

    public final ThreadSummaryBuilder m3600b(Uri uri) {
        this.f2352H = uri;
        return this;
    }

    public final ThreadSummaryBuilder m3612e(List<ThreadEventReminder> list) {
        this.f2353I = list;
        return this;
    }

    public final ThreadSummaryBuilder m3618g(boolean z) {
        this.f2354J = z;
        return this;
    }

    public final ThreadSummaryBuilder m3622j(long j) {
        this.f2355K = j;
        return this;
    }

    public final ThreadSummaryBuilder m3580a(float f) {
        this.f2356L = f;
        return this;
    }

    public final ThreadSummaryBuilder m3593a(GroupType groupType) {
        this.f2358N = groupType;
        return this;
    }

    public final ThreadSummaryBuilder m3620h(boolean z) {
        this.f2359O = z;
        return this;
    }

    public final ThreadSummaryBuilder m3595a(ImmutableList<ThreadJoinRequest> immutableList) {
        this.f2360P = immutableList;
        return this;
    }

    public final ThreadSummaryBuilder m3592a(ThreadRtcCallInfoData threadRtcCallInfoData) {
        this.f2361Q = threadRtcCallInfoData;
        return this;
    }

    public final ThreadSummaryBuilder m3615f(String str) {
        this.f2362R = str;
        return this;
    }

    public final ThreadSummaryBuilder m3584a(TriState triState) {
        this.f2364T = triState;
        return this;
    }

    public final ThreadSummary m3578V() {
        if (this.f2348D == null) {
            this.f2348D = ThreadCustomization.f2252a;
        }
        if (this.f2358N == null) {
            this.f2358N = GroupType.PRIVATE;
        }
        if (this.f2361Q == null) {
            this.f2361Q = ThreadRtcCallInfoData.f2290a;
        }
        if (this.f2364T == null) {
            this.f2364T = TriState.UNSET;
        }
        return new ThreadSummary(this);
    }
}
