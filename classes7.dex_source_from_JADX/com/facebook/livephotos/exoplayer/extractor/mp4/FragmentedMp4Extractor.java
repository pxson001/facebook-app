package com.facebook.livephotos.exoplayer.extractor.mp4;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.facebook.livephotos.exoplayer.ParserException;
import com.facebook.livephotos.exoplayer.drm.DrmInitData;
import com.facebook.livephotos.exoplayer.drm.DrmInitData.Mapped;
import com.facebook.livephotos.exoplayer.drm.DrmInitData.SchemeInitData;
import com.facebook.livephotos.exoplayer.extractor.ChunkIndex;
import com.facebook.livephotos.exoplayer.extractor.DefaultExtractorInput;
import com.facebook.livephotos.exoplayer.extractor.Extractor;
import com.facebook.livephotos.exoplayer.extractor.ExtractorSampleSource;
import com.facebook.livephotos.exoplayer.extractor.PositionHolder;
import com.facebook.livephotos.exoplayer.extractor.SeekMap;
import com.facebook.livephotos.exoplayer.extractor.TrackOutput;
import com.facebook.livephotos.exoplayer.extractor.mp4.Atom.ContainerAtom;
import com.facebook.livephotos.exoplayer.extractor.mp4.Atom.LeafAtom;
import com.facebook.livephotos.exoplayer.util.Assertions;
import com.facebook.livephotos.exoplayer.util.NalUnitUtil;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;
import com.facebook.livephotos.exoplayer.util.Util;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/* compiled from: page_post */
public final class FragmentedMp4Extractor implements Extractor {
    private static final byte[] f7178a = new byte[]{(byte) -94, (byte) 57, (byte) 79, (byte) 82, (byte) 90, (byte) -101, (byte) 79, (byte) 20, (byte) -94, (byte) 68, (byte) 108, (byte) 66, (byte) 124, (byte) 100, (byte) -115, (byte) -12};
    private final int f7179b;
    public final Track f7180c;
    public final SparseArray<TrackBundle> f7181d;
    private final ParsableByteArray f7182e;
    private final ParsableByteArray f7183f;
    private final ParsableByteArray f7184g;
    private final ParsableByteArray f7185h;
    private final byte[] f7186i;
    public final Stack<ContainerAtom> f7187j;
    private int f7188k;
    private int f7189l;
    private long f7190m;
    private int f7191n;
    private ParsableByteArray f7192o;
    private long f7193p;
    private TrackBundle f7194q;
    private int f7195r;
    private int f7196s;
    private int f7197t;
    public ExtractorSampleSource f7198u;
    public boolean f7199v;

    /* compiled from: page_post */
    public final class TrackBundle {
        public final TrackFragment f7173a = new TrackFragment();
        public final TrackOutput f7174b;
        public Track f7175c;
        public DefaultSampleValues f7176d;
        public int f7177e;

        public TrackBundle(TrackOutput trackOutput) {
            this.f7174b = trackOutput;
        }

        public final void m9005a(Track track, DefaultSampleValues defaultSampleValues) {
            this.f7175c = (Track) Assertions.m9293a((Object) track);
            this.f7176d = (DefaultSampleValues) Assertions.m9293a((Object) defaultSampleValues);
            this.f7174b.mo410a(track.f7231k);
            this.f7173a.m9048a();
            this.f7177e = 0;
        }
    }

    public final boolean mo429a(DefaultExtractorInput defaultExtractorInput) {
        return Sniffer.m9047a(defaultExtractorInput, 4096, true);
    }

    public FragmentedMp4Extractor() {
        this(0);
    }

    private FragmentedMp4Extractor(int i) {
        this(i, null);
    }

    private FragmentedMp4Extractor(int i, Track track) {
        this.f7180c = track;
        this.f7179b = (track != null ? 4 : 0) | i;
        this.f7185h = new ParsableByteArray(16);
        this.f7182e = new ParsableByteArray(NalUnitUtil.f7723a);
        this.f7183f = new ParsableByteArray(4);
        this.f7184g = new ParsableByteArray(1);
        this.f7186i = new byte[16];
        this.f7187j = new Stack();
        this.f7181d = new SparseArray();
        m9011a();
    }

    public final void mo428a(ExtractorSampleSource extractorSampleSource) {
        this.f7198u = extractorSampleSource;
        if (this.f7180c != null) {
            TrackBundle trackBundle = new TrackBundle(extractorSampleSource.m8892d(0));
            trackBundle.m9005a(this.f7180c, new DefaultSampleValues(0, 0, 0, 0));
            this.f7181d.put(0, trackBundle);
            this.f7198u.m8895g();
        }
    }

    public final void mo430b() {
        this.f7187j.clear();
        m9011a();
    }

    public final int mo427a(DefaultExtractorInput defaultExtractorInput, PositionHolder positionHolder) {
        while (true) {
            switch (this.f7188k) {
                case 0:
                    if (m9023b(defaultExtractorInput)) {
                        break;
                    }
                    return -1;
                case 1:
                    m9024c(defaultExtractorInput);
                    break;
                case 2:
                    m9026d(defaultExtractorInput);
                    break;
                default:
                    if (!m9027e(defaultExtractorInput)) {
                        break;
                    }
                    return 0;
            }
        }
    }

    private void m9011a() {
        this.f7188k = 0;
        this.f7191n = 0;
    }

    private boolean m9023b(DefaultExtractorInput defaultExtractorInput) {
        if (this.f7191n == 0) {
            if (!defaultExtractorInput.m8839a(this.f7185h.f7731a, 0, 8, true)) {
                return false;
            }
            this.f7191n = 8;
            this.f7185h.m9337b(0);
            this.f7190m = this.f7185h.m9347k();
            this.f7189l = this.f7185h.m9349m();
        }
        if (this.f7190m == 1) {
            defaultExtractorInput.m8842b(this.f7185h.f7731a, 8, 8);
            this.f7191n += 8;
            this.f7190m = this.f7185h.m9357u();
        }
        long j = defaultExtractorInput.f6964d - ((long) this.f7191n);
        if (this.f7189l == Atom.f7115H) {
            int size = this.f7181d.size();
            for (int i = 0; i < size; i++) {
                TrackFragment trackFragment = ((TrackBundle) this.f7181d.valueAt(i)).f7173a;
                trackFragment.f7241c = j;
                trackFragment.f7240b = j;
            }
        }
        if (this.f7189l == Atom.f7141h) {
            this.f7194q = null;
            this.f7193p = this.f7190m + j;
            if (!this.f7199v) {
                this.f7198u.f7011m = SeekMap.f6955f;
                this.f7199v = true;
            }
            this.f7188k = 2;
            return true;
        }
        if (m9022b(this.f7189l)) {
            long c = (defaultExtractorInput.m8844c() + this.f7190m) - 8;
            this.f7187j.add(new ContainerAtom(this.f7189l, c));
            if (this.f7190m == ((long) this.f7191n)) {
                m9012a(c);
            } else {
                m9011a();
            }
        } else if (m9019a(this.f7189l)) {
            if (this.f7191n != 8) {
                throw new ParserException("Leaf atom defines extended atom size (unsupported).");
            } else if (this.f7190m > 2147483647L) {
                throw new ParserException("Leaf atom with length > 2147483647 (unsupported).");
            } else {
                this.f7192o = new ParsableByteArray((int) this.f7190m);
                System.arraycopy(this.f7185h.f7731a, 0, this.f7192o.f7731a, 0, 8);
                this.f7188k = 1;
            }
        } else if (this.f7190m > 2147483647L) {
            throw new ParserException("Skipping atom with length > 2147483647 (unsupported).");
        } else {
            this.f7192o = null;
            this.f7188k = 1;
        }
        return true;
    }

    private void m9024c(DefaultExtractorInput defaultExtractorInput) {
        int i = ((int) this.f7190m) - this.f7191n;
        if (this.f7192o != null) {
            defaultExtractorInput.m8842b(this.f7192o.f7731a, 8, i);
            LeafAtom leafAtom = new LeafAtom(this.f7189l, this.f7192o);
            long j = defaultExtractorInput.f6964d;
            if (!this.f7187j.isEmpty()) {
                ((ContainerAtom) this.f7187j.peek()).m8980a(leafAtom);
            } else if (leafAtom.az == Atom.f7157x) {
                this.f7198u.f7011m = m9008a(leafAtom.aA, j);
                this.f7199v = true;
            }
        } else {
            defaultExtractorInput.m8841b(i);
        }
        m9012a(defaultExtractorInput.f6964d);
    }

    private void m9012a(long j) {
        while (!this.f7187j.isEmpty() && ((ContainerAtom) this.f7187j.peek()).aA == j) {
            m9013a((ContainerAtom) this.f7187j.pop());
        }
        m9011a();
    }

    private void m9013a(ContainerAtom containerAtom) {
        if (containerAtom.az == Atom.f7158y) {
            LeafAtom leafAtom;
            int i;
            Track a;
            boolean z = true;
            Assertions.m9298b(this.f7180c == null, "Unexpected moov box.");
            List list = containerAtom.aB;
            int size = list.size();
            DrmInitData drmInitData = null;
            for (int i2 = 0; i2 < size; i2++) {
                leafAtom = (LeafAtom) list.get(i2);
                if (leafAtom.az == Atom.f7124Q) {
                    if (drmInitData == null) {
                        drmInitData = new Mapped();
                    }
                    byte[] bArr = leafAtom.aA.f7731a;
                    if (PsshAtomUtil.m9045a(bArr) == null) {
                        Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                    } else {
                        drmInitData.f6951a.put(PsshAtomUtil.m9045a(bArr), new SchemeInitData("video/mp4", bArr));
                    }
                }
            }
            if (drmInitData != null) {
                this.f7198u.f7012n = drmInitData;
            }
            ContainerAtom e = containerAtom.m8982e(Atom.f7117J);
            SparseArray sparseArray = new SparseArray();
            size = e.aB.size();
            for (i = 0; i < size; i++) {
                leafAtom = (LeafAtom) e.aB.get(i);
                if (leafAtom.az == Atom.f7155v) {
                    Pair a2 = m9007a(leafAtom.aA);
                    sparseArray.put(((Integer) a2.first).intValue(), a2.second);
                }
            }
            SparseArray sparseArray2 = new SparseArray();
            size = containerAtom.aC.size();
            for (i = 0; i < size; i++) {
                ContainerAtom containerAtom2 = (ContainerAtom) containerAtom.aC.get(i);
                if (containerAtom2.az == Atom.f7108A) {
                    a = AtomParsers.m8991a(containerAtom2, containerAtom.m8981d(Atom.f7159z), false);
                    if (a != null) {
                        sparseArray2.put(a.f7226f, a);
                    }
                }
            }
            size = sparseArray2.size();
            if (this.f7181d.size() == 0) {
                for (int i3 = 0; i3 < size; i3++) {
                    this.f7181d.put(((Track) sparseArray2.valueAt(i3)).f7226f, new TrackBundle(this.f7198u.m8892d(i3)));
                }
                this.f7198u.m8895g();
            } else {
                if (this.f7181d.size() != size) {
                    z = false;
                }
                Assertions.m9297b(z);
            }
            for (i = 0; i < size; i++) {
                a = (Track) sparseArray2.valueAt(i);
                ((TrackBundle) this.f7181d.get(a.f7226f)).m9005a(a, (DefaultSampleValues) sparseArray.get(a.f7226f));
            }
        } else if (containerAtom.az == Atom.f7115H) {
            m9025c(containerAtom);
        } else if (!this.f7187j.isEmpty()) {
            ((ContainerAtom) this.f7187j.peek()).m8979a(containerAtom);
        }
    }

    private void m9025c(ContainerAtom containerAtom) {
        SparseArray sparseArray = this.f7181d;
        int i = this.f7179b;
        byte[] bArr = this.f7186i;
        int size = containerAtom.aC.size();
        for (int i2 = 0; i2 < size; i2++) {
            ContainerAtom containerAtom2 = (ContainerAtom) containerAtom.aC.get(i2);
            if (containerAtom2.az == Atom.f7116I) {
                m9021b(containerAtom2, sparseArray, i, bArr);
            }
        }
    }

    public static Pair<Integer, DefaultSampleValues> m9007a(ParsableByteArray parsableByteArray) {
        parsableByteArray.m9337b(12);
        return Pair.create(Integer.valueOf(parsableByteArray.m9349m()), new DefaultSampleValues(parsableByteArray.m9355s() - 1, parsableByteArray.m9355s(), parsableByteArray.m9355s(), parsableByteArray.m9349m()));
    }

    public static void m9021b(ContainerAtom containerAtom, SparseArray<TrackBundle> sparseArray, int i, byte[] bArr) {
        int i2 = Atom.f7156w;
        int i3 = 0;
        int size = containerAtom.aB.size();
        int i4 = 0;
        int i5 = 0;
        while (i4 < size) {
            int i6;
            if (((LeafAtom) containerAtom.aB.get(i4)).az == i2) {
                i6 = i5 + 1;
            } else {
                i6 = i5;
            }
            i4++;
            i5 = i6;
        }
        i4 = containerAtom.aC.size();
        while (i3 < i4) {
            if (((ContainerAtom) containerAtom.aC.get(i3)).az == i2) {
                i6 = i5 + 1;
            } else {
                i6 = i5;
            }
            i3++;
            i5 = i6;
        }
        if (i5 != 1) {
            throw new ParserException("Trun count in traf != 1 (unsupported).");
        }
        TrackBundle a = m9010a(containerAtom.m8981d(Atom.f7154u).aA, (SparseArray) sparseArray, i);
        if (a != null) {
            long j;
            TrackFragment trackFragment = a.f7173a;
            a.f7177e = 0;
            trackFragment.m9048a();
            if (containerAtom.m8981d(Atom.f7153t) == null || (i & 2) != 0) {
                j = 0;
            } else {
                j = m9020b(containerAtom.m8981d(Atom.f7153t).aA);
            }
            m9014a(a, j, i, containerAtom.m8981d(Atom.f7156w).aA);
            LeafAtom d = containerAtom.m8981d(Atom.f7132Y);
            if (d != null) {
                m9015a(a.f7175c.f7232l[trackFragment.f7239a.f7169a], d.aA, trackFragment);
            }
            d = containerAtom.m8981d(Atom.f7133Z);
            if (d != null) {
                m9017a(d.aA, trackFragment);
            }
            d = containerAtom.m8981d(Atom.ab);
            if (d != null) {
                m9016a(d.aA, 0, trackFragment);
            }
            int size2 = containerAtom.aB.size();
            for (int i7 = 0; i7 < size2; i7++) {
                d = (LeafAtom) containerAtom.aB.get(i7);
                if (d.az == Atom.aa) {
                    m9018a(d.aA, trackFragment, bArr);
                }
            }
        }
    }

    private static void m9015a(TrackEncryptionBox trackEncryptionBox, ParsableByteArray parsableByteArray, TrackFragment trackFragment) {
        boolean z = true;
        int i = trackEncryptionBox.f7237b;
        parsableByteArray.m9337b(8);
        if ((Atom.m8977b(parsableByteArray.m9349m()) & 1) == 1) {
            parsableByteArray.m9339c(8);
        }
        int f = parsableByteArray.m9343f();
        int s = parsableByteArray.m9355s();
        if (s != trackFragment.f7242d) {
            throw new ParserException("Length mismatch: " + s + ", " + trackFragment.f7242d);
        }
        if (f == 0) {
            boolean[] zArr = trackFragment.f7248j;
            int i2 = 0;
            f = 0;
            while (i2 < s) {
                boolean z2;
                int f2 = parsableByteArray.m9343f();
                int i3 = f + f2;
                if (f2 > i) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zArr[i2] = z2;
                i2++;
                f = i3;
            }
        } else {
            if (f <= i) {
                z = false;
            }
            f = (f * s) + 0;
            Arrays.fill(trackFragment.f7248j, 0, s, z);
        }
        trackFragment.m9051b(f);
    }

    private static void m9017a(ParsableByteArray parsableByteArray, TrackFragment trackFragment) {
        parsableByteArray.m9337b(8);
        int m = parsableByteArray.m9349m();
        if ((Atom.m8977b(m) & 1) == 1) {
            parsableByteArray.m9339c(8);
        }
        int s = parsableByteArray.m9355s();
        if (s != 1) {
            throw new ParserException("Unexpected saio entry count: " + s);
        }
        m = Atom.m8976a(m);
        trackFragment.f7241c = (m == 0 ? parsableByteArray.m9347k() : parsableByteArray.m9357u()) + trackFragment.f7241c;
    }

    private static TrackBundle m9010a(ParsableByteArray parsableByteArray, SparseArray<TrackBundle> sparseArray, int i) {
        parsableByteArray.m9337b(8);
        int b = Atom.m8977b(parsableByteArray.m9349m());
        int m = parsableByteArray.m9349m();
        if ((i & 4) != 0) {
            m = 0;
        }
        TrackBundle trackBundle = (TrackBundle) sparseArray.get(m);
        if (trackBundle == null) {
            return null;
        }
        if ((b & 1) != 0) {
            long u = parsableByteArray.m9357u();
            trackBundle.f7173a.f7240b = u;
            trackBundle.f7173a.f7241c = u;
        }
        DefaultSampleValues defaultSampleValues = trackBundle.f7176d;
        trackBundle.f7173a.f7239a = new DefaultSampleValues((b & 2) != 0 ? parsableByteArray.m9355s() - 1 : defaultSampleValues.f7169a, (b & 8) != 0 ? parsableByteArray.m9355s() : defaultSampleValues.f7170b, (b & 16) != 0 ? parsableByteArray.m9355s() : defaultSampleValues.f7171c, (b & 32) != 0 ? parsableByteArray.m9355s() : defaultSampleValues.f7172d);
        return trackBundle;
    }

    private static long m9020b(ParsableByteArray parsableByteArray) {
        parsableByteArray.m9337b(8);
        return Atom.m8976a(parsableByteArray.m9349m()) == 1 ? parsableByteArray.m9357u() : parsableByteArray.m9347k();
    }

    private static void m9014a(TrackBundle trackBundle, long j, int i, ParsableByteArray parsableByteArray) {
        Object obj;
        long a;
        parsableByteArray.m9337b(8);
        int b = Atom.m8977b(parsableByteArray.m9349m());
        Track track = trackBundle.f7175c;
        TrackFragment trackFragment = trackBundle.f7173a;
        DefaultSampleValues defaultSampleValues = trackFragment.f7239a;
        int s = parsableByteArray.m9355s();
        if ((b & 1) != 0) {
            trackFragment.f7240b += (long) parsableByteArray.m9349m();
        }
        Object obj2 = (b & 4) != 0 ? 1 : null;
        int i2 = defaultSampleValues.f7172d;
        if (obj2 != null) {
            i2 = parsableByteArray.m9355s();
        }
        Object obj3 = (b & 256) != 0 ? 1 : null;
        Object obj4 = (b & 512) != 0 ? 1 : null;
        Object obj5 = (b & 1024) != 0 ? 1 : null;
        if ((b & 2048) != 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (track.f7233m != null && track.f7233m.length == 1 && track.f7233m[0] == 0) {
            a = Util.m9362a(track.f7234n[0], 1000, track.f7228h);
        } else {
            a = 0;
        }
        trackFragment.m9049a(s);
        int[] iArr = trackFragment.f7243e;
        int[] iArr2 = trackFragment.f7244f;
        long[] jArr = trackFragment.f7245g;
        boolean[] zArr = trackFragment.f7246h;
        long j2 = track.f7228h;
        Object obj6 = (track.f7227g != Track.f7221a || (i & 1) == 0) ? null : 1;
        int i3 = 0;
        long j3 = j;
        while (i3 < s) {
            int s2 = obj3 != null ? parsableByteArray.m9355s() : defaultSampleValues.f7170b;
            int s3 = obj4 != null ? parsableByteArray.m9355s() : defaultSampleValues.f7171c;
            int m = (i3 != 0 || obj2 == null) ? obj5 != null ? parsableByteArray.m9349m() : defaultSampleValues.f7172d : i2;
            if (obj != null) {
                iArr2[i3] = (int) (((long) (parsableByteArray.m9349m() * 1000)) / j2);
            } else {
                iArr2[i3] = 0;
            }
            jArr[i3] = Util.m9362a(j3, 1000, j2) - a;
            iArr[i3] = s3;
            boolean z = ((m >> 16) & 1) == 0 && (obj6 == null || i3 == 0);
            zArr[i3] = z;
            i3++;
            j3 += (long) s2;
        }
    }

    private static void m9018a(ParsableByteArray parsableByteArray, TrackFragment trackFragment, byte[] bArr) {
        parsableByteArray.m9337b(8);
        parsableByteArray.m9335a(bArr, 0, 16);
        if (Arrays.equals(bArr, f7178a)) {
            m9016a(parsableByteArray, 16, trackFragment);
        }
    }

    public static void m9016a(ParsableByteArray parsableByteArray, int i, TrackFragment trackFragment) {
        parsableByteArray.m9337b(i + 8);
        int b = Atom.m8977b(parsableByteArray.m9349m());
        if ((b & 1) != 0) {
            throw new ParserException("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z;
        if ((b & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        int s = parsableByteArray.m9355s();
        if (s != trackFragment.f7242d) {
            throw new ParserException("Length mismatch: " + s + ", " + trackFragment.f7242d);
        }
        Arrays.fill(trackFragment.f7248j, 0, s, z);
        trackFragment.m9051b(parsableByteArray.m9336b());
        parsableByteArray.m9335a(trackFragment.f7250l.f7731a, 0, trackFragment.f7249k);
        trackFragment.f7250l.m9337b(0);
        trackFragment.f7251m = false;
    }

    public static ChunkIndex m9008a(ParsableByteArray parsableByteArray, long j) {
        long k;
        long k2;
        parsableByteArray.m9337b(8);
        int a = Atom.m8976a(parsableByteArray.m9349m());
        parsableByteArray.m9339c(4);
        long k3 = parsableByteArray.m9347k();
        if (a == 0) {
            k = parsableByteArray.m9347k();
            k2 = parsableByteArray.m9347k() + j;
        } else {
            k = parsableByteArray.m9357u();
            k2 = parsableByteArray.m9357u() + j;
        }
        parsableByteArray.m9339c(2);
        int g = parsableByteArray.m9344g();
        int[] iArr = new int[g];
        long[] jArr = new long[g];
        long[] jArr2 = new long[g];
        long[] jArr3 = new long[g];
        long j2 = k2;
        int i = 0;
        long j3 = k;
        k = Util.m9362a(k, 1000000, k3);
        while (i < g) {
            int m = parsableByteArray.m9349m();
            if ((Integer.MIN_VALUE & m) != 0) {
                throw new ParserException("Unhandled indirect reference");
            }
            long k4 = parsableByteArray.m9347k();
            iArr[i] = m & Integer.MAX_VALUE;
            jArr[i] = j2;
            jArr3[i] = k;
            k = j3 + k4;
            k4 = Util.m9362a(k, 1000000, k3);
            jArr2[i] = k4 - jArr3[i];
            parsableByteArray.m9339c(4);
            j2 += (long) iArr[i];
            i++;
            j3 = k;
            k = k4;
        }
        return new ChunkIndex(iArr, jArr, jArr2, jArr3);
    }

    private void m9026d(DefaultExtractorInput defaultExtractorInput) {
        TrackBundle trackBundle = null;
        long j = Long.MAX_VALUE;
        int size = this.f7181d.size();
        int i = 0;
        while (i < size) {
            TrackBundle trackBundle2;
            long j2;
            TrackFragment trackFragment = ((TrackBundle) this.f7181d.valueAt(i)).f7173a;
            long j3;
            if (!trackFragment.f7251m || trackFragment.f7241c >= j) {
                j3 = j;
                trackBundle2 = trackBundle;
                j2 = j3;
            } else {
                j3 = trackFragment.f7241c;
                trackBundle2 = (TrackBundle) this.f7181d.valueAt(i);
                j2 = j3;
            }
            i++;
            trackBundle = trackBundle2;
            j = j2;
        }
        if (trackBundle == null) {
            this.f7188k = 3;
            return;
        }
        int i2 = (int) (j - defaultExtractorInput.f6964d);
        if (i2 < 0) {
            throw new ParserException("Offset to encryption data was negative.");
        }
        defaultExtractorInput.m8841b(i2);
        trackBundle.f7173a.m9050a(defaultExtractorInput);
    }

    private boolean m9027e(DefaultExtractorInput defaultExtractorInput) {
        int i = 2;
        if (this.f7188k == 3) {
            if (this.f7194q == null) {
                this.f7194q = m9009a(this.f7181d);
                if (this.f7194q == null) {
                    i = (int) (this.f7193p - defaultExtractorInput.m8844c());
                    if (i < 0) {
                        throw new ParserException("Offset to end of mdat was negative.");
                    }
                    defaultExtractorInput.m8841b(i);
                    m9011a();
                    return false;
                }
                int c = (int) (this.f7194q.f7173a.f7240b - defaultExtractorInput.m8844c());
                if (c < 0) {
                    throw new ParserException("Offset to sample data was negative.");
                }
                defaultExtractorInput.m8841b(c);
            }
            this.f7195r = this.f7194q.f7173a.f7243e[this.f7194q.f7177e];
            if (this.f7194q.f7173a.f7247i) {
                this.f7196s = m9006a(this.f7194q);
                this.f7195r += this.f7196s;
            } else {
                this.f7196s = 0;
            }
            this.f7188k = 4;
            this.f7197t = 0;
        }
        TrackFragment trackFragment = this.f7194q.f7173a;
        Track track = this.f7194q.f7175c;
        TrackOutput trackOutput = this.f7194q.f7174b;
        int i2 = this.f7194q.f7177e;
        if (track.f7235o != -1) {
            byte[] bArr = this.f7183f.f7731a;
            bArr[0] = (byte) 0;
            bArr[1] = (byte) 0;
            bArr[2] = (byte) 0;
            int i3 = track.f7235o;
            int i4 = 4 - track.f7235o;
            while (this.f7196s < this.f7195r) {
                if (this.f7197t == 0) {
                    defaultExtractorInput.m8842b(this.f7183f.f7731a, i4, i3);
                    this.f7183f.m9337b(0);
                    this.f7197t = this.f7183f.m9355s();
                    this.f7182e.m9337b(0);
                    trackOutput.mo411a(this.f7182e, 4);
                    this.f7196s += 4;
                    this.f7195r += i4;
                } else {
                    int a = trackOutput.mo408a(defaultExtractorInput, this.f7197t, false);
                    this.f7196s += a;
                    this.f7197t -= a;
                }
            }
        } else {
            while (this.f7196s < this.f7195r) {
                this.f7196s = trackOutput.mo408a(defaultExtractorInput, this.f7195r - this.f7196s, false) + this.f7196s;
            }
        }
        long c2 = trackFragment.m9052c(i2) * 1000;
        if (!trackFragment.f7247i) {
            i = 0;
        }
        trackOutput.mo409a(c2, (trackFragment.f7246h[i2] ? 1 : 0) | i, this.f7195r, 0, trackFragment.f7247i ? track.f7232l[trackFragment.f7239a.f7169a].f7238c : null);
        TrackBundle trackBundle = this.f7194q;
        trackBundle.f7177e++;
        if (this.f7194q.f7177e == trackFragment.f7242d) {
            this.f7194q = null;
        }
        this.f7188k = 3;
        return true;
    }

    private static TrackBundle m9009a(SparseArray<TrackBundle> sparseArray) {
        TrackBundle trackBundle = null;
        long j = Long.MAX_VALUE;
        int size = sparseArray.size();
        int i = 0;
        while (i < size) {
            TrackBundle trackBundle2;
            long j2;
            TrackBundle trackBundle3 = (TrackBundle) sparseArray.valueAt(i);
            if (trackBundle3.f7177e != trackBundle3.f7173a.f7242d) {
                long j3 = trackBundle3.f7173a.f7240b;
                if (j3 < j) {
                    long j4 = j3;
                    trackBundle2 = trackBundle3;
                    j2 = j4;
                    i++;
                    j = j2;
                    trackBundle = trackBundle2;
                }
            }
            trackBundle2 = trackBundle;
            j2 = j;
            i++;
            j = j2;
            trackBundle = trackBundle2;
        }
        return trackBundle;
    }

    private int m9006a(TrackBundle trackBundle) {
        TrackFragment trackFragment = trackBundle.f7173a;
        ParsableByteArray parsableByteArray = trackFragment.f7250l;
        int i = trackBundle.f7175c.f7232l[trackFragment.f7239a.f7169a].f7237b;
        boolean z = trackFragment.f7248j[trackBundle.f7177e];
        this.f7184g.f7731a[0] = (byte) ((z ? 128 : 0) | i);
        this.f7184g.m9337b(0);
        TrackOutput trackOutput = trackBundle.f7174b;
        trackOutput.mo411a(this.f7184g, 1);
        trackOutput.mo411a(parsableByteArray, i);
        if (!z) {
            return i + 1;
        }
        int g = parsableByteArray.m9344g();
        parsableByteArray.m9339c(-2);
        g = (g * 6) + 2;
        trackOutput.mo411a(parsableByteArray, g);
        return (i + 1) + g;
    }

    private static boolean m9019a(int i) {
        return i == Atom.f7122O || i == Atom.f7121N || i == Atom.f7159z || i == Atom.f7157x || i == Atom.f7123P || i == Atom.f7153t || i == Atom.f7154u || i == Atom.f7118K || i == Atom.f7155v || i == Atom.f7156w || i == Atom.f7124Q || i == Atom.f7132Y || i == Atom.f7133Z || i == Atom.ab || i == Atom.aa || i == Atom.f7120M;
    }

    private static boolean m9022b(int i) {
        return i == Atom.f7158y || i == Atom.f7108A || i == Atom.f7109B || i == Atom.f7110C || i == Atom.f7111D || i == Atom.f7115H || i == Atom.f7116I || i == Atom.f7117J || i == Atom.f7119L;
    }
}
