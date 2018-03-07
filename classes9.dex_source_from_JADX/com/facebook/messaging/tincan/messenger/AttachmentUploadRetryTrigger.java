package com.facebook.messaging.tincan.messenger;

import android.net.Uri;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.common.network.NetworkMonitor;
import com.facebook.common.network.NetworkMonitor.State;
import com.facebook.common.time.MonotonicClock;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;

@ThreadSafe
/* compiled from: client_apt */
public class AttachmentUploadRetryTrigger {
    private final NetworkMonitor f17991a;
    public final EncryptedAttachmentUploadRetryHandler f17992b;
    private final ScheduledExecutorService f17993c;
    private final MonotonicClock f17994d;
    @Nullable
    private SelfRegistrableReceiverImpl f17995e = null;
    @Nullable
    private Future f17996f = null;
    private final Map<OfflineThreadIdAndResourceUri, UploadMetadata> f17997g = new HashMap();

    /* compiled from: client_apt */
    class C21071 implements Runnable {
        final /* synthetic */ AttachmentUploadRetryTrigger f17983a;

        C21071(AttachmentUploadRetryTrigger attachmentUploadRetryTrigger) {
            this.f17983a = attachmentUploadRetryTrigger;
        }

        public void run() {
            AttachmentUploadRetryTrigger.m17987g(this.f17983a);
        }
    }

    /* compiled from: client_apt */
    class C21093 implements Runnable {
        final /* synthetic */ AttachmentUploadRetryTrigger f17986a;

        C21093(AttachmentUploadRetryTrigger attachmentUploadRetryTrigger) {
            this.f17986a = attachmentUploadRetryTrigger;
        }

        public void run() {
            AttachmentUploadRetryTrigger.m17989i(this.f17986a);
        }
    }

    @Immutable
    /* compiled from: client_apt */
    class OfflineThreadIdAndResourceUri {
        public final String f17987a;
        public final Uri f17988b;

        public OfflineThreadIdAndResourceUri(String str, Uri uri) {
            this.f17987a = str;
            this.f17988b = uri;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            OfflineThreadIdAndResourceUri offlineThreadIdAndResourceUri = (OfflineThreadIdAndResourceUri) obj;
            if (Objects.equal(this.f17987a, offlineThreadIdAndResourceUri.f17987a) && Objects.equal(this.f17988b, offlineThreadIdAndResourceUri.f17988b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.f17987a, this.f17988b});
        }
    }

    @Immutable
    /* compiled from: client_apt */
    class UploadMetadata {
        public final int f17989a;
        public final long f17990b;

        public UploadMetadata(int i, long j) {
            this.f17989a = i;
            this.f17990b = j;
        }
    }

    @Inject
    public AttachmentUploadRetryTrigger(NetworkMonitor networkMonitor, EncryptedAttachmentUploadRetryHandler encryptedAttachmentUploadRetryHandler, ScheduledExecutorService scheduledExecutorService, MonotonicClock monotonicClock) {
        this.f17991a = networkMonitor;
        this.f17992b = encryptedAttachmentUploadRetryHandler;
        this.f17993c = scheduledExecutorService;
        this.f17994d = monotonicClock;
    }

    public final synchronized void m17991a(String str, Uri uri) {
        m17982c(str, uri);
    }

    public final synchronized boolean m17992b(String str, Uri uri) {
        boolean d;
        d = m17984d(str, uri);
        if (m17978a()) {
            m17985e();
        } else {
            m17980b();
        }
        return d;
    }

    private synchronized void m17982c(String str, Uri uri) {
        this.f17997g.remove(new OfflineThreadIdAndResourceUri(str, uri));
    }

    private synchronized boolean m17984d(String str, Uri uri) {
        boolean z;
        int i;
        OfflineThreadIdAndResourceUri offlineThreadIdAndResourceUri = new OfflineThreadIdAndResourceUri(str, uri);
        UploadMetadata uploadMetadata = (UploadMetadata) this.f17997g.remove(offlineThreadIdAndResourceUri);
        if (uploadMetadata != null) {
            i = uploadMetadata.f17989a + 1;
        } else {
            i = 1;
        }
        if (i == 10) {
            z = false;
        } else {
            this.f17997g.put(offlineThreadIdAndResourceUri, new UploadMetadata(i, this.f17994d.now()));
            z = true;
        }
        return z;
    }

    private synchronized boolean m17978a() {
        return !this.f17997g.isEmpty();
    }

    private synchronized void m17980b() {
        m17981c();
        m17983d();
    }

    private synchronized void m17981c() {
        if (this.f17995e != null) {
            this.f17995e.c();
            this.f17995e = null;
        }
    }

    private synchronized void m17983d() {
        if (this.f17996f != null) {
            this.f17996f.cancel(false);
            this.f17996f = null;
        }
    }

    private synchronized void m17985e() {
        if (!m17986f()) {
            this.f17996f = this.f17993c.schedule(new C21071(this), 60000, TimeUnit.MILLISECONDS);
        }
    }

    private synchronized boolean m17986f() {
        return this.f17996f != null;
    }

    public static synchronized void m17987g(AttachmentUploadRetryTrigger attachmentUploadRetryTrigger) {
        synchronized (attachmentUploadRetryTrigger) {
            attachmentUploadRetryTrigger.f17996f = null;
            attachmentUploadRetryTrigger.m17988h();
        }
    }

    private synchronized void m17988h() {
        if (this.f17991a.a()) {
            m17989i(this);
        } else if (this.f17995e == null) {
            m17990j();
        }
    }

    public static synchronized void m17989i(AttachmentUploadRetryTrigger attachmentUploadRetryTrigger) {
        synchronized (attachmentUploadRetryTrigger) {
            Object obj = null;
            for (Entry entry : attachmentUploadRetryTrigger.f17997g.entrySet()) {
                if (attachmentUploadRetryTrigger.m17979a(((UploadMetadata) entry.getValue()).f17990b)) {
                    attachmentUploadRetryTrigger.m17977a((OfflineThreadIdAndResourceUri) entry.getKey());
                } else {
                    obj = 1;
                }
            }
            if (obj != null) {
                attachmentUploadRetryTrigger.m17985e();
            }
        }
    }

    private synchronized boolean m17979a(long j) {
        return this.f17994d.now() - j >= 30000;
    }

    private synchronized void m17977a(final OfflineThreadIdAndResourceUri offlineThreadIdAndResourceUri) {
        ExecutorDetour.a(this.f17993c, new Runnable(this) {
            final /* synthetic */ AttachmentUploadRetryTrigger f17985b;

            public void run() {
                this.f17985b.f17992b.a(offlineThreadIdAndResourceUri.f17987a, offlineThreadIdAndResourceUri.f17988b);
            }
        }, 528344991);
    }

    private synchronized void m17990j() {
        Preconditions.checkState(this.f17995e == null);
        this.f17995e = this.f17991a.a(State.CONNECTED, new C21093(this));
    }
}
