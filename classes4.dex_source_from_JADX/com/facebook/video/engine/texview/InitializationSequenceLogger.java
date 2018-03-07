package com.facebook.video.engine.texview;

import com.facebook.common.eventbus.TypedEventBus;
import com.facebook.common.eventbus.TypedHandler;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.facebook.video.analytics.InitializationSequence;
import com.facebook.video.api.AsyncVideo$PlayCancelledEvent;
import com.facebook.video.api.AsyncVideo$PlayRequestedEvent;
import com.facebook.video.api.AsyncVideo$PlayStartedEvent;
import com.facebook.video.api.VideoEvents$StartingEvent;
import com.facebook.video.server.VideoServer$VideoIdEvent;
import com.facebook.video.server.VideoServer$VideoServerWorker.RequestLiveInfoImpl;
import com.facebook.video.server.VideoServer.RequestLiveInfo;
import com.facebook.video.server.VideoServerEvents$NetworkAccessEndedEvent;
import com.facebook.video.server.VideoServerEvents$NetworkAccessRequestedEvent;
import com.facebook.video.server.VideoServerEvents$NetworkAccessRetrievedEvent;
import com.facebook.video.server.VideoServerEvents$RequestBeginEvent;
import com.facebook.video.server.VideoServerEvents$RequestGrantedEvent;
import com.facebook.video.server.prefetcher.VideoPrefetcher;
import com.facebook.video.view.ImplementationEvents.AllocationBeginEvent;
import com.facebook.video.view.ImplementationEvents.AllocationEndEvent;
import com.facebook.video.view.ImplementationEvents.PreparationBeginEvent;
import com.facebook.video.view.ImplementationEvents.PreparationEndEvent;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: percentile_90 */
public class InitializationSequenceLogger {
    public final SequenceLogger f5153a;
    private final Handler f5154b = new Handler(this);
    private final TypedEventBus f5155c;
    private final VideoPrefetcher f5156d;
    public TypedEventBus f5157e;
    public final String f5158f;
    public String f5159g = "unset";
    public String f5160h;
    public int f5161i = -1;
    public int f5162j = -1;
    public String f5163k;

    /* compiled from: percentile_90 */
    public class Handler implements TypedHandler, com.facebook.video.api.AsyncVideo$PlayCancelledEvent.Handler, com.facebook.video.api.AsyncVideo$PlayRequestedEvent.Handler, com.facebook.video.api.AsyncVideo$PlayStartedEvent.Handler, com.facebook.video.api.VideoEvents$StartingEvent.Handler, com.facebook.video.view.ImplementationEvents.AllocationBeginEvent.Handler, com.facebook.video.view.ImplementationEvents.AllocationEndEvent.Handler, com.facebook.video.view.ImplementationEvents.PreparationBeginEvent.Handler, com.facebook.video.view.ImplementationEvents.PreparationEndEvent.Handler {
        public final /* synthetic */ InitializationSequenceLogger f5164a;
        private Sequence<InitializationSequence> f5165b;
        public boolean f5166c = true;
        private boolean f5167d = false;
        private int f5168e;
        @GuardedBy("this")
        private final Set<String> f5169f = new HashSet();
        @GuardedBy("this")
        private final List<RequestLiveInfo> f5170g = new ArrayList(2);
        @GuardedBy("this")
        private final List<Long> f5171h = new ArrayList(2);
        private long f5172i;

        public Handler(InitializationSequenceLogger initializationSequenceLogger) {
            this.f5164a = initializationSequenceLogger;
        }

        public final void m5619i() {
            m5604c("VideoPSR");
            m5600a(true);
            this.f5166c = false;
        }

        public final void mo467a(AsyncVideo$PlayRequestedEvent asyncVideo$PlayRequestedEvent) {
            m5605j();
            m5598a("VideoPSR");
            m5598a("VideoStallTime");
        }

        public final void mo466a() {
            m5619i();
        }

        private synchronized void m5600a(boolean z) {
            if (this.f5165b != null) {
                ImmutableList copyOf = ImmutableList.copyOf(this.f5169f);
                int size = copyOf.size();
                for (int i = 0; i < size; i++) {
                    m5602b((String) copyOf.get(i));
                }
                this.f5164a.f5153a.b(InitializationSequence.a, m5601b(z));
                this.f5165b = null;
                this.f5167d = false;
                this.f5170g.clear();
                this.f5171h.clear();
            }
        }

        public final void m5615d() {
            m5598a("Allocation");
        }

        public final void m5616e() {
            m5602b("Allocation");
        }

        private synchronized void m5605j() {
            if (this.f5166c && this.f5165b == null) {
                this.f5170g.clear();
                this.f5171h.clear();
                this.f5165b = this.f5164a.f5153a.a(InitializationSequence.a);
                this.f5168e = 0;
                this.f5167d = false;
            }
        }

        public final void m5617f() {
            m5605j();
            m5598a("Preparation");
            m5598a("PrepareToDataRequest");
        }

        public final void m5618g() {
            m5602b("Preparation");
        }

        public final void mo469a(VideoEvents$StartingEvent videoEvents$StartingEvent) {
            m5598a("Buffering");
        }

        public final void mo468a(AsyncVideo$PlayStartedEvent asyncVideo$PlayStartedEvent) {
            this.f5167d = true;
            m5600a(false);
        }

        @GuardedBy("this")
        private ImmutableMap<String, String> m5601b(boolean z) {
            long j = 0;
            long j2 = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            long j3 = 0;
            long j4 = 0;
            int i4 = 0;
            for (RequestLiveInfoImpl requestLiveInfoImpl : this.f5170g) {
                j += requestLiveInfoImpl.m5913a();
                j2 += requestLiveInfoImpl.m5914b();
                j4 += requestLiveInfoImpl.m5920g();
                j3 = requestLiveInfoImpl.m5921h() + j3;
                i4 = requestLiveInfoImpl.m5919f() + i4;
                i3 = requestLiveInfoImpl.m5918e() + i3;
                i2 = requestLiveInfoImpl.m5917d() + i2;
                i = requestLiveInfoImpl.m5916c() + i;
            }
            long j5 = -1;
            if (!(this.f5171h == null || this.f5171h.isEmpty())) {
                j5 = ((Long) this.f5171h.get(0)).longValue();
            }
            return ImmutableMap.builder().b("started", this.f5167d ? "1" : "0").b("request_count", String.valueOf(this.f5170g.size())).b("bytes_served", String.valueOf(j2)).b("bytes_downloaded", String.valueOf(j)).b("first_missing_cache_byte", String.valueOf(j5)).b("network_count", String.valueOf(this.f5168e)).b("player_version", this.f5164a.f5158f).b("player_type", this.f5164a.f5159g).b("video_atom_size", String.valueOf(this.f5164a.f5161i)).b("video_bitrate", String.valueOf(this.f5164a.f5162j)).b("fetch_bitrate_est", String.valueOf(this.f5172i)).b("intercepted", String.valueOf(i)).b("reused", String.valueOf(i2)).b("reused_later", String.valueOf(i3)).b("reused_past", String.valueOf(i4)).b("reused_distance", String.valueOf(j4)).b("reused_later_distance", String.valueOf(j3)).b("psr_cancelled", String.valueOf(z)).b("streaming_format", this.f5164a.f5163k == null ? "" : this.f5164a.f5163k).b("video_id", this.f5164a.f5160h == null ? "" : this.f5164a.f5160h).b();
        }

        public final synchronized void m5612a(VideoServerEvents$RequestBeginEvent videoServerEvents$RequestBeginEvent) {
            if (this.f5165b != null) {
                m5602b("PrepareToDataRequest");
                m5598a("RequestLock");
                this.f5170g.add(videoServerEvents$RequestBeginEvent.f5285a);
                this.f5171h.add(Long.valueOf(videoServerEvents$RequestBeginEvent.f5286b));
                this.f5172i = VideoPrefetcher.a();
            }
        }

        public final void m5614c() {
            m5602b("RequestLock");
        }

        public final void m5610a(VideoServerEvents$NetworkAccessRequestedEvent videoServerEvents$NetworkAccessRequestedEvent) {
            if (this.f5165b != null) {
                this.f5168e++;
                ImmutableMap a = m5597a(videoServerEvents$NetworkAccessRequestedEvent.f5287a, videoServerEvents$NetworkAccessRequestedEvent.f5288b);
                m5599a("NetworkAccess", a);
                m5599a("NetworkAccessHeader", a);
            }
        }

        public final void m5611a(VideoServerEvents$NetworkAccessRetrievedEvent videoServerEvents$NetworkAccessRetrievedEvent) {
            m5602b("NetworkAccessHeader");
            m5599a("NetworkAccessContent", m5597a(videoServerEvents$NetworkAccessRetrievedEvent.f5289a, videoServerEvents$NetworkAccessRetrievedEvent.f5290b));
        }

        public final void m5613b() {
            m5602b("NetworkAccessContent");
            m5602b("NetworkAccess");
        }

        private static ImmutableMap<String, String> m5597a(long j, long j2) {
            return ImmutableMap.of("from", String.valueOf(j), "to", String.valueOf(j2));
        }

        private void m5598a(String str) {
            m5599a(str, null);
        }

        private void m5602b(String str) {
            m5603b(str, null);
        }

        private synchronized void m5599a(String str, @Nullable ImmutableMap<String, String> immutableMap) {
            if (this.f5165b != null) {
                SequenceLoggerDetour.a(this.f5165b, str, null, immutableMap, -1340971060);
                this.f5169f.add(str);
            }
        }

        private synchronized void m5603b(String str, @Nullable ImmutableMap<String, String> immutableMap) {
            if (this.f5165b != null) {
                SequenceLoggerDetour.b(this.f5165b, str, null, immutableMap, -93980290);
                this.f5169f.remove(str);
            }
        }

        private synchronized void m5604c(String str) {
            if (this.f5165b != null) {
                SequenceLoggerDetour.a(this.f5165b, str, null, -435529341);
                this.f5169f.remove(str);
            }
        }
    }

    public InitializationSequenceLogger(SequenceLogger sequenceLogger, TypedEventBus typedEventBus, String str, VideoPrefetcher videoPrefetcher) {
        this.f5153a = sequenceLogger;
        this.f5155c = typedEventBus;
        this.f5158f = str;
        this.f5156d = videoPrefetcher;
    }

    public final void m5595a(TypedEventBus typedEventBus) {
        Preconditions.checkArgument(this.f5157e == null, "Cannot register twice");
        this.f5157e = (TypedEventBus) Preconditions.checkNotNull(typedEventBus);
        typedEventBus.a(AsyncVideo$PlayRequestedEvent.class, this.f5154b);
        typedEventBus.a(AsyncVideo$PlayStartedEvent.class, this.f5154b);
        typedEventBus.a(AsyncVideo$PlayCancelledEvent.class, this.f5154b);
        typedEventBus.a(AllocationBeginEvent.class, this.f5154b);
        typedEventBus.a(AllocationEndEvent.class, this.f5154b);
        typedEventBus.a(PreparationBeginEvent.class, this.f5154b);
        typedEventBus.a(PreparationEndEvent.class, this.f5154b);
        typedEventBus.a(VideoEvents$StartingEvent.class, this.f5154b);
        typedEventBus.a(VideoServerEvents$RequestBeginEvent.class, this.f5154b);
        typedEventBus.a(VideoServerEvents$RequestGrantedEvent.class, this.f5154b);
        typedEventBus.a(VideoServerEvents$NetworkAccessRequestedEvent.class, this.f5154b);
        typedEventBus.a(VideoServerEvents$NetworkAccessRetrievedEvent.class, this.f5154b);
        typedEventBus.a(VideoServerEvents$NetworkAccessEndedEvent.class, this.f5154b);
    }

    public final void m5596b(String str) {
        this.f5160h = str;
        Handler handler = this.f5154b;
        boolean z = !handler.f5166c;
        handler.f5166c = true;
        if (z) {
            this.f5155c.a(VideoServer$VideoIdEvent.class, this.f5154b);
        }
    }

    public final void m5594a() {
        this.f5154b.m5619i();
        this.f5155c.b(VideoServer$VideoIdEvent.class, this.f5154b);
    }
}
