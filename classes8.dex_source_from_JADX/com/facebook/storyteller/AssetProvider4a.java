package com.facebook.storyteller;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.friendsharing.souvenirs.abtest.ExperimentsForSouvenirAbtestModule;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.media.MediaItem;
import com.facebook.photos.local.LocalMediaCursor;
import com.facebook.photos.local.LocalMediaCursorImp;
import com.facebook.photos.local.LocalMediaCursorMethodAutoProvider;
import com.facebook.proguard.annotations.DoNotStrip;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.flatbuffers.FlatBufferBuilder;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

@DoNotStrip
/* compiled from: mediaPickerLauncher */
public class AssetProvider4a implements Closeable {
    private static final String f9009a = AssetProvider4a.class.getSimpleName();
    private final LocalMediaCursorImp f9010b;
    private final StoryTellerConfig f9011c;
    private final Lazy<FbErrorReporter> f9012d;
    private final Clock f9013e;
    private final Object f9014f = new Object();
    @GuardedBy("mIteratorLock")
    private Iterator<MediaItem> f9015g;
    private CloseableReference f9016h;
    @Nullable
    private MediaItem f9017i;

    /* compiled from: mediaPickerLauncher */
    class C09311 implements Predicate<MediaItem> {
        final /* synthetic */ AssetProvider4a f9008a;

        C09311(AssetProvider4a assetProvider4a) {
            this.f9008a = assetProvider4a;
        }

        public boolean apply(Object obj) {
            return ((MediaItem) obj) != null;
        }
    }

    public static AssetProvider4a m10738b(InjectorLike injectorLike) {
        return new AssetProvider4a(LocalMediaCursorMethodAutoProvider.b(injectorLike), StoryTellerConfig.m10752a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    public static AssetProvider4a m10737a(InjectorLike injectorLike) {
        return m10738b(injectorLike);
    }

    @Inject
    public AssetProvider4a(LocalMediaCursor localMediaCursor, StoryTellerConfig storyTellerConfig, Lazy<FbErrorReporter> lazy, Clock clock) {
        this.f9010b = localMediaCursor;
        this.f9016h = localMediaCursor.a();
        this.f9011c = storyTellerConfig;
        this.f9012d = lazy;
        this.f9013e = clock;
    }

    private void m10739b() {
        synchronized (this.f9014f) {
            if (this.f9015g != null) {
                return;
            }
            this.f9016h = this.f9010b.a();
            List a = m10740a();
            this.f9015g = a == null ? new ArrayList().iterator() : Iterators.b(a.iterator(), new C09311(this));
            this.f9017i = this.f9015g.hasNext() ? (MediaItem) this.f9015g.next() : null;
        }
    }

    @DoNotStrip
    public boolean hasNext() {
        m10739b();
        return this.f9017i != null;
    }

    @DoNotStrip
    public void advance() {
        m10739b();
        synchronized (this.f9014f) {
            this.f9017i = this.f9015g.hasNext() ? (MediaItem) this.f9015g.next() : null;
        }
    }

    @DoNotStrip
    public byte[] obtain() {
        m10739b();
        if (this.f9017i == null) {
            ((AbstractFbErrorReporter) this.f9012d.get()).b(f9009a, "obtain() called with null nextItem");
            return null;
        }
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        MediaItem mediaItem = this.f9017i;
        FlatBufferBuilder flatBufferBuilder2 = new FlatBufferBuilder(128);
        flatBufferBuilder2.c(AssetProviderUtil.m10742a(flatBufferBuilder2, mediaItem));
        return flatBufferBuilder2.e();
    }

    @DoNotStrip
    @GuardedBy("mIteratorLock")
    public void close() {
        synchronized (this.f9014f) {
            if (this.f9016h != null) {
                this.f9016h.close();
                this.f9016h = null;
            }
        }
    }

    @Nullable
    public final List<MediaItem> m10740a() {
        return AssetProviderUtil.m10743a(this.f9010b, this.f9013e.a() - this.f9011c.m10757b(), this.f9011c.f9034c.a(ExperimentsForSouvenirAbtestModule.D, 64));
    }
}
