package com.facebook.ui.media.cache;

import com.facebook.common.iolite.ProgressOutputStream;
import com.facebook.common.iolite.ProgressOutputStream.Listener;
import com.facebook.ui.media.cache.PartialFileStorage.PartialFile;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/* compiled from: pack_types INNER JOIN sticker_packs ON pack_types. */
class PartialFileCache$CachedFile implements PartialFile<Key> {
    final /* synthetic */ PartialFileCache f5547a;
    private final Key f5548b;
    private final PartialFile<String> f5549c;
    private final Listener f5550d;

    public PartialFileCache$CachedFile(final PartialFileCache partialFileCache, Key key, PartialFile partialFile) {
        this.f5547a = partialFileCache;
        this.f5548b = key;
        this.f5549c = partialFile;
        this.f5550d = new Listener(this) {
            final /* synthetic */ PartialFileCache$CachedFile f5552b;

            public final void m5980a(long j, long j2) {
                PartialFileCache.a(this.f5552b.f5547a, j);
            }
        };
    }

    public final Object m5979g() {
        return this.f5548b;
    }

    public final List<Range> m5978f() {
        return this.f5549c.f();
    }

    public final long m5975b() {
        return this.f5549c.b();
    }

    public final long m5977c() {
        return this.f5549c.c();
    }

    public final FileMetadata m5973a() {
        return this.f5549c.a();
    }

    public final OutputStream m5974a(long j) {
        PartialFileCache.c(this.f5547a);
        return new ProgressOutputStream(this.f5549c.a(j), this.f5550d);
    }

    public final InputStream m5976b(long j) {
        return this.f5549c.b(j);
    }
}
