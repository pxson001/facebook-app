package com.facebook.video.server;

import com.facebook.common.disk.DiskTrimmable;
import com.facebook.ui.media.cache.FileMetadata;
import com.facebook.ui.media.cache.PartialFileStorage;
import com.facebook.ui.media.cache.PartialFileStorage.PartialFile;
import com.facebook.ui.media.cache.Range;
import com.google.common.base.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: commerce_product_item_update */
public class ComposedPartialFileStorage implements DiskTrimmable, PartialFileStorage<VideoCacheKey> {
    public final PartialFileStorage<VideoCacheKey> f19464a;
    public final PartialFileStorage<VideoCacheKey> f19465b;

    /* compiled from: commerce_product_item_update */
    public class ComposedPartialFile implements PartialFile<VideoCacheKey> {
        final /* synthetic */ ComposedPartialFileStorage f19459a;
        public final VideoCacheKey f19460b;
        private final FileMetadata f19461c;
        private PartialFile<VideoCacheKey> f19462d;
        public PartialFile<VideoCacheKey> f19463e;

        public ComposedPartialFile(ComposedPartialFileStorage composedPartialFileStorage, VideoCacheKey videoCacheKey, PartialFile<VideoCacheKey> partialFile, PartialFile<VideoCacheKey> partialFile2) {
            this.f19459a = composedPartialFileStorage;
            this.f19460b = (VideoCacheKey) Preconditions.checkNotNull(videoCacheKey);
            this.f19461c = ((PartialFile) Preconditions.checkNotNull(m28214a(partialFile, partialFile2))).a();
            this.f19462d = partialFile;
            this.f19463e = partialFile2;
        }

        private static <T> T m28214a(T t, T t2) {
            return t != null ? t : t2;
        }

        public final OutputStream m28217a(long j) {
            final long j2 = (long) this.f19460b.a;
            if (j2 <= j) {
                if (this.f19463e == null) {
                    this.f19463e = this.f19459a.f19465b.a(this.f19460b, m28216a());
                }
                return this.f19463e.a(j);
            }
            if (this.f19462d == null) {
                this.f19462d = this.f19459a.f19464a.a(this.f19460b, m28216a());
            }
            final OutputStream a = this.f19462d.a(j);
            final long j3 = j;
            return new OutputStream(this) {
                final /* synthetic */ ComposedPartialFile f19455d;
                private long f19456e = j3;
                private boolean f19457f = true;
                private OutputStream f19458g = a;

                public void write(byte[] bArr, int i, int i2) {
                    if (this.f19457f) {
                        if (this.f19456e == j2) {
                            if (this.f19455d.f19463e == null) {
                                this.f19455d.f19463e = this.f19455d.f19459a.f19465b.a(this.f19455d.f19460b, this.f19455d.m28216a());
                            }
                            this.f19458g = this.f19455d.f19463e.a(j2);
                            this.f19457f = false;
                        } else if (this.f19456e >= j2 || this.f19456e + ((long) i2) <= j2) {
                            this.f19458g.write(bArr, i, i2);
                            this.f19456e += (long) i2;
                            return;
                        } else {
                            int i3 = (int) (j2 - this.f19456e);
                            this.f19458g.write(bArr, i, i3);
                            this.f19456e = j2;
                            write(bArr, i + i3, i2 - i3);
                            return;
                        }
                    }
                    this.f19458g.write(bArr, i, i2);
                    this.f19456e += (long) i2;
                }

                public void flush() {
                    this.f19458g.flush();
                }

                public void write(int i) {
                    throw new UnsupportedOperationException("write ONE byte?!");
                }

                public void close() {
                    this.f19458g.close();
                }
            };
        }

        public final /* synthetic */ Object m28222g() {
            return this.f19460b;
        }

        private long m28215e() {
            return this.f19461c.a;
        }

        public final FileMetadata m28216a() {
            return this.f19461c;
        }

        public final List<Range> m28221f() {
            List<Range> arrayList = new ArrayList();
            int i = this.f19460b.a;
            if (this.f19462d != null) {
                arrayList.addAll(new Range(0, (long) i).a(this.f19462d.f()));
            }
            if (this.f19463e != null && m28215e() > ((long) i)) {
                arrayList.addAll(new Range((long) i, m28215e()).a(this.f19463e.f()));
            }
            return arrayList;
        }

        public final long m28218b() {
            long j = 0;
            if (this.f19462d != null) {
                j = 0 + this.f19462d.b();
            }
            if (this.f19463e != null) {
                return j + this.f19463e.b();
            }
            return j;
        }

        public final long m28220c() {
            long j = 0;
            if (this.f19462d != null) {
                j = Math.max(this.f19462d.b(), 0);
            }
            if (this.f19463e != null) {
                return j + Math.max(this.f19463e.b(), j);
            }
            return j;
        }

        public final InputStream m28219b(long j) {
            int i;
            if (j < ((long) this.f19460b.a)) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0 && this.f19462d != null) {
                return this.f19462d.b(j);
            }
            if (i != 0 || this.f19463e == null) {
                return new ByteArrayInputStream(new byte[0]);
            }
            return this.f19463e.b(j);
        }
    }

    public final PartialFile m28224a(Object obj, FileMetadata fileMetadata) {
        VideoCacheKey videoCacheKey = (VideoCacheKey) obj;
        if (videoCacheKey.c()) {
            return new ComposedPartialFile(this, videoCacheKey, this.f19464a.a(videoCacheKey, fileMetadata), this.f19465b.a(videoCacheKey, fileMetadata));
        }
        return this.f19465b.a(videoCacheKey, fileMetadata);
    }

    public final void m28226a(Object obj) {
        VideoCacheKey videoCacheKey = (VideoCacheKey) obj;
        this.f19465b.a(videoCacheKey);
        this.f19464a.a(videoCacheKey);
    }

    public final PartialFile m28227b(Object obj) {
        VideoCacheKey videoCacheKey = (VideoCacheKey) obj;
        if (!videoCacheKey.c()) {
            return this.f19465b.b(videoCacheKey);
        }
        PartialFile b = this.f19464a.b(videoCacheKey);
        PartialFile b2 = this.f19465b.b(videoCacheKey);
        if (b == null && b2 == null) {
            return null;
        }
        return new ComposedPartialFile(this, videoCacheKey, b, b2);
    }

    public ComposedPartialFileStorage(PartialFileStorage<VideoCacheKey> partialFileStorage, PartialFileStorage<VideoCacheKey> partialFileStorage2) {
        this.f19464a = partialFileStorage;
        this.f19465b = partialFileStorage2;
    }

    public final List<VideoCacheKey> m28225a() {
        throw new UnsupportedOperationException("Could be done, but underlying storages don't support it");
    }

    public final void ai_() {
        m28223c();
        ((DiskTrimmable) this.f19464a).ai_();
        ((DiskTrimmable) this.f19465b).ai_();
    }

    public final void m28228b() {
        ((DiskTrimmable) this.f19464a).b();
        ((DiskTrimmable) this.f19465b).b();
    }

    private void m28223c() {
        if (!(this.f19464a instanceof DiskTrimmable) || !(this.f19465b instanceof DiskTrimmable)) {
            throw new UnsupportedOperationException("Composing storages are not trimmable");
        }
    }
}
