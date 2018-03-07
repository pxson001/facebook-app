package com.facebook.livephotos.exoplayer.extractor;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.util.SparseArray;
import com.facebook.livephotos.exoplayer.MediaFormat;
import com.facebook.livephotos.exoplayer.MediaFormatHolder;
import com.facebook.livephotos.exoplayer.ParserException;
import com.facebook.livephotos.exoplayer.SampleHolder;
import com.facebook.livephotos.exoplayer.SampleSource;
import com.facebook.livephotos.exoplayer.SampleSource.SampleSourceReader;
import com.facebook.livephotos.exoplayer.drm.DrmInitData;
import com.facebook.livephotos.exoplayer.upstream.DataSource;
import com.facebook.livephotos.exoplayer.upstream.DataSpec;
import com.facebook.livephotos.exoplayer.upstream.DefaultAllocator;
import com.facebook.livephotos.exoplayer.upstream.Loader;
import com.facebook.livephotos.exoplayer.util.Assertions;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: page_service_card_start_now */
public final class ExtractorSampleSource implements SampleSourceReader, SampleSource {
    private static final List<Class<? extends Extractor>> f6989a = new ArrayList();
    private long f6990A;
    private long f6991B;
    private Loader f6992C;
    private ExtractingLoadable f6993D;
    private IOException f6994E;
    private int f6995F;
    private long f6996G;
    public boolean f6997H;
    public int f6998I;
    private int f6999J;
    private final ExtractorHolder f7000b;
    private final DefaultAllocator f7001c;
    private final int f7002d;
    public final SparseArray<InternalTrackOutput> f7003e;
    private final int f7004f;
    private final Uri f7005g;
    private final DataSource f7006h;
    public final Handler f7007i;
    public final EventListener f7008j;
    public final int f7009k;
    private volatile boolean f7010l;
    public volatile SeekMap f7011m;
    public volatile DrmInitData f7012n;
    private boolean f7013o;
    private int f7014p;
    private MediaFormat[] f7015q;
    private long f7016r;
    private boolean[] f7017s;
    private boolean[] f7018t;
    public boolean[] f7019u;
    private int f7020v;
    private long f7021w;
    private long f7022x;
    private long f7023y;
    private boolean f7024z;

    /* compiled from: page_service_card_start_now */
    public interface EventListener {
    }

    /* compiled from: page_service_card_start_now */
    public class ExtractingLoadable {
        private final Uri f6977a;
        private final DataSource f6978b;
        private final ExtractorHolder f6979c;
        private final DefaultAllocator f6980d;
        private final int f6981e;
        private final PositionHolder f6982f = new PositionHolder();
        public volatile boolean f6983g;
        private boolean f6984h;

        public ExtractingLoadable(Uri uri, DataSource dataSource, ExtractorHolder extractorHolder, DefaultAllocator defaultAllocator, int i, long j) {
            this.f6977a = (Uri) Assertions.m9293a((Object) uri);
            this.f6978b = (DataSource) Assertions.m9293a((Object) dataSource);
            this.f6979c = (ExtractorHolder) Assertions.m9293a((Object) extractorHolder);
            this.f6980d = (DefaultAllocator) Assertions.m9293a((Object) defaultAllocator);
            this.f6981e = i;
            this.f6982f.f7028a = j;
            this.f6984h = true;
        }

        public final boolean m8868b() {
            return this.f6983g;
        }

        public final void m8869c() {
            int i;
            DefaultExtractorInput defaultExtractorInput;
            Throwable th;
            int i2 = 0;
            while (i2 == 0 && !this.f6983g) {
                try {
                    long j = this.f6982f.f7028a;
                    long a = this.f6978b.mo441a(new DataSpec(this.f6977a, j, -1, null));
                    if (a != -1) {
                        a += j;
                    }
                    DefaultExtractorInput defaultExtractorInput2 = new DefaultExtractorInput(this.f6978b, j, a);
                    try {
                        int i3;
                        Extractor a2 = this.f6979c.m8870a(defaultExtractorInput2);
                        if (this.f6984h) {
                            a2.mo430b();
                            this.f6984h = false;
                        }
                        int i4 = i2;
                        while (i4 == 0) {
                            try {
                                if (this.f6983g) {
                                    break;
                                }
                                this.f6980d.m9266b(this.f6981e);
                                i4 = a2.mo427a(defaultExtractorInput2, this.f6982f);
                            } catch (Throwable th2) {
                                Throwable th3 = th2;
                                i = i4;
                                defaultExtractorInput = defaultExtractorInput2;
                                th = th3;
                            }
                        }
                        if (i4 == 1) {
                            i3 = 0;
                        } else {
                            this.f6982f.f7028a = defaultExtractorInput2.m8844c();
                            i3 = i4;
                        }
                        this.f6978b.mo442a();
                        i2 = i3;
                    } catch (Throwable th4) {
                        i = i2;
                        DefaultExtractorInput defaultExtractorInput3 = defaultExtractorInput2;
                        th = th4;
                        defaultExtractorInput = defaultExtractorInput3;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    defaultExtractorInput = null;
                    i = i2;
                }
            }
            return;
            if (!(i == 1 || defaultExtractorInput == null)) {
                this.f6982f.f7028a = defaultExtractorInput.m8844c();
            }
            this.f6978b.mo442a();
            throw th;
        }
    }

    /* compiled from: page_service_card_start_now */
    public final class ExtractorHolder {
        private final Extractor[] f6985a;
        private final ExtractorSampleSource f6986b;
        public Extractor f6987c;

        public ExtractorHolder(Extractor[] extractorArr, ExtractorSampleSource extractorSampleSource) {
            this.f6985a = extractorArr;
            this.f6986b = extractorSampleSource;
        }

        public final Extractor m8870a(DefaultExtractorInput defaultExtractorInput) {
            if (this.f6987c != null) {
                return this.f6987c;
            }
            Extractor[] extractorArr = this.f6985a;
            int length = extractorArr.length;
            int i = 0;
            loop0:
            while (i < length) {
                Extractor extractor = extractorArr[i];
                try {
                    if (extractor.mo429a(defaultExtractorInput)) {
                        this.f6987c = extractor;
                        defaultExtractorInput.m8838a();
                        break loop0;
                    }
                    i++;
                } catch (EOFException e) {
                    i++;
                } finally {
                    defaultExtractorInput.m8838a();
                }
            }
            if (this.f6987c == null) {
                throw new UnrecognizedInputFormatException(this.f6985a);
            }
            this.f6987c.mo428a(this.f6986b);
            return this.f6987c;
        }
    }

    /* compiled from: page_service_card_start_now */
    public class InternalTrackOutput extends DefaultTrackOutput {
        final /* synthetic */ ExtractorSampleSource f6988a;

        public InternalTrackOutput(ExtractorSampleSource extractorSampleSource, DefaultAllocator defaultAllocator) {
            this.f6988a = extractorSampleSource;
            super(defaultAllocator);
        }

        public final void mo409a(long j, int i, int i2, int i3, byte[] bArr) {
            super.mo409a(j, i, i2, i3, bArr);
            ExtractorSampleSource extractorSampleSource = this.f6988a;
            extractorSampleSource.f6998I++;
        }
    }

    /* compiled from: page_service_card_start_now */
    public final class UnrecognizedInputFormatException extends ParserException {
        public UnrecognizedInputFormatException(Extractor[] extractorArr) {
            StringBuilder stringBuilder = new StringBuilder("None of the available extractors (");
            StringBuilder stringBuilder2 = new StringBuilder();
            for (int i = 0; i < extractorArr.length; i++) {
                stringBuilder2.append(extractorArr[i].getClass().getSimpleName());
                if (i < extractorArr.length - 1) {
                    stringBuilder2.append(", ");
                }
            }
            super(stringBuilder.append(stringBuilder2.toString()).append(") could read the stream.").toString());
        }
    }

    static {
        try {
            f6989a.add(Class.forName("com.facebook.livephotos.exoplayer.extractor.webm.WebmExtractor").asSubclass(Extractor.class));
        } catch (ClassNotFoundException e) {
        }
        try {
            f6989a.add(Class.forName("com.facebook.livephotos.exoplayer.extractor.mp4.FragmentedMp4Extractor").asSubclass(Extractor.class));
        } catch (ClassNotFoundException e2) {
        }
        try {
            f6989a.add(Class.forName("com.facebook.livephotos.exoplayer.extractor.mp4.Mp4Extractor").asSubclass(Extractor.class));
        } catch (ClassNotFoundException e3) {
        }
        try {
            f6989a.add(Class.forName("com.facebook.livephotos.exoplayer.extractor.mp3.Mp3Extractor").asSubclass(Extractor.class));
        } catch (ClassNotFoundException e4) {
        }
        try {
            f6989a.add(Class.forName("com.facebook.livephotos.exoplayer.extractor.ts.AdtsExtractor").asSubclass(Extractor.class));
        } catch (ClassNotFoundException e5) {
        }
        try {
            f6989a.add(Class.forName("com.facebook.livephotos.exoplayer.extractor.ts.TsExtractor").asSubclass(Extractor.class));
        } catch (ClassNotFoundException e6) {
        }
        try {
            f6989a.add(Class.forName("com.facebook.livephotos.exoplayer.extractor.flv.FlvExtractor").asSubclass(Extractor.class));
        } catch (ClassNotFoundException e7) {
        }
        try {
            f6989a.add(Class.forName("com.facebook.livephotos.exoplayer.extractor.ogg.OggVorbisExtractor").asSubclass(Extractor.class));
        } catch (ClassNotFoundException e8) {
        }
        try {
            f6989a.add(Class.forName("com.facebook.livephotos.exoplayer.extractor.ts.PsExtractor").asSubclass(Extractor.class));
        } catch (ClassNotFoundException e9) {
        }
        try {
            f6989a.add(Class.forName("com.facebook.livephotos.exoplayer.extractor.wav.WavExtractor").asSubclass(Extractor.class));
        } catch (ClassNotFoundException e10) {
        }
        try {
            f6989a.add(Class.forName("com.facebook.livephotos.exoplayer.ext.flac.FlacExtractor").asSubclass(Extractor.class));
        } catch (ClassNotFoundException e11) {
        }
    }

    public ExtractorSampleSource(Uri uri, DataSource dataSource, DefaultAllocator defaultAllocator, int i, Extractor... extractorArr) {
        this(uri, dataSource, defaultAllocator, i, -1, extractorArr);
    }

    private ExtractorSampleSource(Uri uri, DataSource dataSource, DefaultAllocator defaultAllocator, int i, int i2, Extractor... extractorArr) {
        this(uri, dataSource, defaultAllocator, i, i2, null, null, 0, extractorArr);
    }

    private ExtractorSampleSource(Uri uri, DataSource dataSource, DefaultAllocator defaultAllocator, int i, int i2, Handler handler, EventListener eventListener, int i3, Extractor... extractorArr) {
        this.f7005g = uri;
        this.f7006h = dataSource;
        this.f7008j = eventListener;
        this.f7007i = handler;
        this.f7009k = i3;
        this.f7001c = defaultAllocator;
        this.f7002d = i;
        this.f7004f = i2;
        if (extractorArr == null || extractorArr.length == 0) {
            extractorArr = new Extractor[f6989a.size()];
            int i4 = 0;
            while (i4 < extractorArr.length) {
                try {
                    extractorArr[i4] = (Extractor) ((Class) f6989a.get(i4)).newInstance();
                    i4++;
                } catch (Throwable e) {
                    throw new IllegalStateException("Unexpected error creating default extractor", e);
                } catch (Throwable e2) {
                    throw new IllegalStateException("Unexpected error creating default extractor", e2);
                }
            }
        }
        this.f7000b = new ExtractorHolder(extractorArr, this);
        this.f7003e = new SparseArray();
        this.f7023y = Long.MIN_VALUE;
    }

    public final SampleSourceReader mo414a() {
        this.f7020v++;
        return this;
    }

    public final boolean mo421c() {
        if (this.f7013o) {
            return true;
        }
        if (this.f6992C == null) {
            this.f6992C = new Loader("Loader:ExtractorSampleSource");
        }
        m8874j();
        if (this.f7011m == null || !this.f7010l) {
            return false;
        }
        Object obj = null;
        for (int i = 0; i < this.f7003e.size(); i++) {
            if ((((InternalTrackOutput) this.f7003e.valueAt(i)).f6974g != null ? 1 : null) == null) {
                break;
            }
        }
        obj = 1;
        if (obj == null) {
            return false;
        }
        int size = this.f7003e.size();
        this.f7019u = new boolean[size];
        this.f7018t = new boolean[size];
        this.f7017s = new boolean[size];
        this.f7015q = new MediaFormat[size];
        this.f7016r = -1;
        for (int i2 = 0; i2 < size; i2++) {
            MediaFormat mediaFormat = ((InternalTrackOutput) this.f7003e.valueAt(i2)).f6974g;
            this.f7015q[i2] = mediaFormat;
            if (mediaFormat.f6850e != -1 && mediaFormat.f6850e > this.f7016r) {
                this.f7016r = mediaFormat.f6850e;
            }
        }
        this.f7013o = true;
        return true;
    }

    public final int mo422d() {
        return this.f7003e.size();
    }

    public final MediaFormat mo413a(int i) {
        Assertions.m9297b(this.f7013o);
        return this.f7015q[i];
    }

    public final void mo415a(int i, long j) {
        Assertions.m9297b(this.f7013o);
        Assertions.m9297b(!this.f7019u[i]);
        this.f7014p++;
        this.f7019u[i] = true;
        this.f7017s[i] = true;
        this.f7018t[i] = false;
        if (this.f7014p == 1) {
            if (!this.f7011m.mo407a()) {
                j = 0;
            }
            this.f7021w = j;
            this.f7022x = j;
            m8872b(j);
        }
    }

    public final void mo420c(int i) {
        Assertions.m9297b(this.f7013o);
        Assertions.m9297b(this.f7019u[i]);
        this.f7014p--;
        this.f7019u[i] = false;
        if (this.f7014p == 0) {
            this.f7021w = Long.MIN_VALUE;
            if (this.f6992C.f7680c) {
                this.f6992C.m9286b();
                return;
            }
            m8876m();
            this.f7001c.m9264a(0);
        }
    }

    public final boolean mo419b(int i, long j) {
        Assertions.m9297b(this.f7013o);
        Assertions.m9297b(this.f7019u[i]);
        this.f7021w = j;
        long j2 = this.f7021w;
        for (int i2 = 0; i2 < this.f7019u.length; i2++) {
            if (!this.f7019u[i2]) {
                InternalTrackOutput internalTrackOutput = (InternalTrackOutput) this.f7003e.valueAt(i2);
                while (internalTrackOutput.f6968a.m8913a(internalTrackOutput.f6969b) && internalTrackOutput.f6969b.f6873e < j2) {
                    internalTrackOutput.f6968a.m8914b();
                    internalTrackOutput.f6970c = true;
                }
                internalTrackOutput.f6971d = Long.MIN_VALUE;
            }
        }
        if (this.f6997H) {
            return true;
        }
        m8874j();
        if (m8877n()) {
            return false;
        }
        return !((InternalTrackOutput) this.f7003e.valueAt(i)).m8859e();
    }

    public final long mo417b(int i) {
        if (!this.f7018t[i]) {
            return Long.MIN_VALUE;
        }
        this.f7018t[i] = false;
        return this.f7022x;
    }

    public final int mo412a(int i, long j, MediaFormatHolder mediaFormatHolder, SampleHolder sampleHolder) {
        this.f7021w = j;
        if (this.f7018t[i] || m8877n()) {
            return -2;
        }
        InternalTrackOutput internalTrackOutput = (InternalTrackOutput) this.f7003e.valueAt(i);
        if (this.f7017s[i]) {
            mediaFormatHolder.f6867a = internalTrackOutput.f6974g;
            mediaFormatHolder.f6868b = this.f7012n;
            this.f7017s[i] = false;
            return -4;
        } else if (!internalTrackOutput.m8858a(sampleHolder)) {
            return this.f6997H ? -1 : -2;
        } else {
            int i2;
            boolean z = sampleHolder.f6873e < this.f7022x;
            int i3 = sampleHolder.f6872d;
            if (z) {
                i2 = 134217728;
            } else {
                i2 = 0;
            }
            sampleHolder.f6872d = i2 | i3;
            if (this.f7024z) {
                this.f6991B = this.f6990A - sampleHolder.f6873e;
                this.f7024z = false;
            }
            sampleHolder.f6873e += this.f6991B;
            return -3;
        }
    }

    public final void mo418b() {
        if (this.f6994E != null) {
            if (m8878o()) {
                throw this.f6994E;
            }
            int i = this.f7004f != -1 ? this.f7004f : (this.f7011m == null || this.f7011m.mo407a()) ? 3 : 6;
            if (this.f6995F > i) {
                throw this.f6994E;
            }
        }
    }

    public final void mo416a(long j) {
        int i = 0;
        Assertions.m9297b(this.f7013o);
        Assertions.m9297b(this.f7014p > 0);
        if (!this.f7011m.mo407a()) {
            j = 0;
        }
        long j2 = m8877n() ? this.f7023y : this.f7021w;
        this.f7021w = j;
        this.f7022x = j;
        if (j2 != j) {
            boolean z;
            if (m8877n()) {
                z = false;
            } else {
                z = true;
            }
            int i2 = 0;
            int i3 = z;
            while (i3 != 0 && i2 < this.f7003e.size()) {
                i3 &= ((InternalTrackOutput) this.f7003e.valueAt(i2)).f6968a.m8912a(j);
                i2++;
            }
            if (i3 == 0) {
                m8872b(j);
            }
            while (i < this.f7018t.length) {
                this.f7018t[i] = true;
                i++;
            }
        }
    }

    public final long mo423e() {
        if (this.f6997H) {
            return -3;
        }
        if (m8877n()) {
            return this.f7023y;
        }
        long j = Long.MIN_VALUE;
        for (int i = 0; i < this.f7003e.size(); i++) {
            j = Math.max(j, ((InternalTrackOutput) this.f7003e.valueAt(i)).f6973f);
        }
        return j == Long.MIN_VALUE ? this.f7021w : j;
    }

    public final void mo424f() {
        Assertions.m9297b(this.f7020v > 0);
        int i = this.f7020v - 1;
        this.f7020v = i;
        if (i == 0) {
            if (this.f6992C != null) {
                Loader loader = this.f6992C;
                if (loader.f7680c) {
                    loader.m9286b();
                }
                loader.f7678a.shutdown();
                this.f6992C = null;
            }
            if (this.f7000b.f6987c != null) {
                this.f7000b.f6987c = null;
            }
        }
    }

    public final void m8896i() {
        if (this.f7014p > 0) {
            m8872b(this.f7023y);
            return;
        }
        m8876m();
        this.f7001c.m9264a(0);
    }

    public final void m8885a(final IOException iOException) {
        this.f6994E = iOException;
        this.f6995F = this.f6998I > this.f6999J ? 1 : this.f6995F + 1;
        this.f6996G = SystemClock.elapsedRealtime();
        if (!(this.f7007i == null || this.f7008j == null)) {
            HandlerDetour.a(this.f7007i, new Runnable(this) {
                final /* synthetic */ ExtractorSampleSource f6976b;

                public void run() {
                    EventListener eventListener = this.f6976b.f7008j;
                    int i = this.f6976b.f7009k;
                }
            }, -468711507);
        }
        m8874j();
    }

    public final TrackOutput m8892d(int i) {
        InternalTrackOutput internalTrackOutput = (InternalTrackOutput) this.f7003e.get(i);
        if (internalTrackOutput != null) {
            return internalTrackOutput;
        }
        TrackOutput internalTrackOutput2 = new InternalTrackOutput(this, this.f7001c);
        this.f7003e.put(i, internalTrackOutput2);
        return internalTrackOutput2;
    }

    public final void m8895g() {
        this.f7010l = true;
    }

    public final void m8884a(SeekMap seekMap) {
        this.f7011m = seekMap;
    }

    private void m8872b(long j) {
        this.f7023y = j;
        this.f6997H = false;
        if (this.f6992C.f7680c) {
            this.f6992C.m9286b();
            return;
        }
        m8876m();
        m8874j();
    }

    private void m8874j() {
        int i = 0;
        if (!this.f6997H && !this.f6992C.f7680c) {
            if (this.f6994E == null) {
                this.f6991B = 0;
                this.f7024z = false;
                if (this.f7013o) {
                    Assertions.m9297b(m8877n());
                    if (this.f7016r == -1 || this.f7023y < this.f7016r) {
                        this.f6993D = m8873c(this.f7023y);
                        this.f7023y = Long.MIN_VALUE;
                    } else {
                        this.f6997H = true;
                        this.f7023y = Long.MIN_VALUE;
                        return;
                    }
                }
                this.f6993D = m8875k();
                this.f6999J = this.f6998I;
                this.f6992C.m9285a(this.f6993D, this);
            } else if (!m8878o()) {
                Assertions.m9297b(this.f6993D != null);
                if (SystemClock.elapsedRealtime() - this.f6996G >= Math.min((((long) this.f6995F) - 1) * 1000, 5000)) {
                    this.f6994E = null;
                    if (!this.f7013o) {
                        while (i < this.f7003e.size()) {
                            ((InternalTrackOutput) this.f7003e.valueAt(i)).m8854a();
                            i++;
                        }
                        this.f6993D = m8875k();
                    } else if (!this.f7011m.mo407a() && this.f7016r == -1) {
                        while (i < this.f7003e.size()) {
                            ((InternalTrackOutput) this.f7003e.valueAt(i)).m8854a();
                            i++;
                        }
                        this.f6993D = m8875k();
                        this.f6990A = this.f7021w;
                        this.f7024z = true;
                    }
                    this.f6999J = this.f6998I;
                    this.f6992C.m9285a(this.f6993D, this);
                }
            }
        }
    }

    private ExtractingLoadable m8875k() {
        return new ExtractingLoadable(this.f7005g, this.f7006h, this.f7000b, this.f7001c, this.f7002d, 0);
    }

    private ExtractingLoadable m8873c(long j) {
        return new ExtractingLoadable(this.f7005g, this.f7006h, this.f7000b, this.f7001c, this.f7002d, this.f7011m.mo406a(j));
    }

    private void m8876m() {
        for (int i = 0; i < this.f7003e.size(); i++) {
            ((InternalTrackOutput) this.f7003e.valueAt(i)).m8854a();
        }
        this.f6993D = null;
        this.f6994E = null;
        this.f6995F = 0;
    }

    private boolean m8877n() {
        return this.f7023y != Long.MIN_VALUE;
    }

    private boolean m8878o() {
        return this.f6994E instanceof UnrecognizedInputFormatException;
    }
}
