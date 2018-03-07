package com.facebook.photos.base.analytics.efficiency;

import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.time.Clock;
import com.facebook.imagepipeline.internal.FbImageFetchListener;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.Assisted;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@ThreadSafe
/* compiled from: onUnbind called for intent. action */
public class ImageFetchEfficiencyTracker extends BaseRequestListener implements FbImageFetchListener {
    private final ImageFetchEfficiencySampler f11073a;
    private final UriRecordManager f11074b;
    private final Clock f11075c;
    @GuardedBy("this")
    private Optional<UriRecord> f11076d = Absent.INSTANCE;
    @GuardedBy("this")
    private boolean f11077e = false;

    @Inject
    public ImageFetchEfficiencyTracker(@Assisted ImageFetchEfficiencySampler imageFetchEfficiencySampler, @Assisted UriRecordManager uriRecordManager, Clock clock) {
        this.f11073a = imageFetchEfficiencySampler;
        this.f11074b = uriRecordManager;
        this.f11075c = clock;
    }

    public final synchronized void mo2114a(ImageRequest imageRequest, CallerContext callerContext, int i, boolean z, boolean z2) {
        if (m16418b() && !this.f11076d.isPresent() && this.f11073a.mo2113a(imageRequest, callerContext)) {
            this.f11076d = Optional.of(this.f11074b.m16412a(imageRequest.m18798b(), i, this.f11075c.mo211a(), z, z2, callerContext.m9066a(), callerContext.m9068c(), callerContext.m9067b()));
        }
    }

    public final synchronized void mo2105a(ImageRequest imageRequest, String str, boolean z) {
        if (!z) {
            if (m16418b() && this.f11076d.isPresent() && !((UriRecord) this.f11076d.get()).f17697d.isPresent() && ((UriRecord) this.f11076d.get()).f17694a.equals(imageRequest.m18798b())) {
                this.f11076d = Optional.fromNullable(this.f11074b.m16413a((UriRecord) this.f11076d.get(), this.f11075c.mo211a()));
            }
        }
    }

    private synchronized Optional<UriRecord> m16417a() {
        Optional<UriRecord> of;
        if (m16418b() && this.f11076d.isPresent() && this.f11075c.mo211a() - ((UriRecord) this.f11076d.get()).f17696c >= 86400000) {
            UriRecord uriRecord = (UriRecord) this.f11076d.get();
            this.f11074b.m16416c();
            this.f11076d = Absent.withType();
            of = Optional.of(uriRecord);
        } else {
            of = Absent.withType();
        }
        return of;
    }

    public final Optional<HoneyClientEvent> m16421c(String str) {
        Optional a = m16417a();
        if (!a.isPresent()) {
            return Absent.INSTANCE;
        }
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.f3099c = "photo";
        honeyClientEvent.m5090b("calling_class", ((UriRecord) a.get()).f17700g);
        honeyClientEvent.m5090b("analytics_tag", ((UriRecord) a.get()).f17701h);
        honeyClientEvent.m5090b("feature_tag", ((UriRecord) a.get()).f17702i);
        honeyClientEvent.m5083a("content_length", ((UriRecord) a.get()).f17695b);
        honeyClientEvent.m5087a("is_prefetch", ((UriRecord) a.get()).f17698e);
        honeyClientEvent.m5087a("is_cancellation_requested", ((UriRecord) a.get()).f17699f);
        honeyClientEvent.m5087a("ui_requested", ((UriRecord) a.get()).f17697d.isPresent());
        if (((UriRecord) a.get()).f17697d.isPresent()) {
            honeyClientEvent.m5084a("prefetch_to_ui_time", ((Long) ((UriRecord) a.get()).f17697d.get()).longValue() - ((UriRecord) a.get()).f17696c);
        }
        return Optional.of(honeyClientEvent);
    }

    private synchronized boolean m16418b() {
        boolean z;
        if (this.f11077e) {
            z = true;
        } else if (this.f11074b.m16414a()) {
            this.f11076d = (Optional) Preconditions.checkNotNull(this.f11074b.m16415b());
            this.f11077e = true;
            z = true;
        } else {
            z = false;
        }
        return z;
    }
}
