package com.facebook.livephotos.exoplayer.extractor.mp4;

import com.facebook.livephotos.exoplayer.MediaFormat;
import com.facebook.livephotos.exoplayer.extractor.DefaultExtractorInput;
import com.facebook.livephotos.exoplayer.extractor.Extractor;
import com.facebook.livephotos.exoplayer.extractor.ExtractorSampleSource;
import com.facebook.livephotos.exoplayer.extractor.GaplessInfo;
import com.facebook.livephotos.exoplayer.extractor.PositionHolder;
import com.facebook.livephotos.exoplayer.extractor.SeekMap;
import com.facebook.livephotos.exoplayer.extractor.TrackOutput;
import com.facebook.livephotos.exoplayer.extractor.mp4.Atom.ContainerAtom;
import com.facebook.livephotos.exoplayer.extractor.mp4.Atom.LeafAtom;
import com.facebook.livephotos.exoplayer.util.Assertions;
import com.facebook.livephotos.exoplayer.util.NalUnitUtil;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;
import com.facebook.livephotos.exoplayer.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* compiled from: page_nux_shop_start */
public final class Mp4Extractor implements Extractor, SeekMap {
    private static final int f7204a = Util.m9368c("qt  ");
    private final ParsableByteArray f7205b = new ParsableByteArray(NalUnitUtil.f7723a);
    private final ParsableByteArray f7206c = new ParsableByteArray(4);
    private final ParsableByteArray f7207d = new ParsableByteArray(16);
    private final Stack<ContainerAtom> f7208e = new Stack();
    private int f7209g;
    private int f7210h;
    private long f7211i;
    private int f7212j;
    private ParsableByteArray f7213k;
    private int f7214l;
    private int f7215m;
    private int f7216n;
    public ExtractorSampleSource f7217o;
    public Mp4Track[] f7218p;
    public boolean f7219q;

    /* compiled from: page_nux_shop_start */
    public final class Mp4Track {
        public final Track f7200a;
        public final TrackSampleTable f7201b;
        public final TrackOutput f7202c;
        public int f7203d;

        public Mp4Track(Track track, TrackSampleTable trackSampleTable, TrackOutput trackOutput) {
            this.f7200a = track;
            this.f7201b = trackSampleTable;
            this.f7202c = trackOutput;
        }
    }

    public final boolean mo429a(DefaultExtractorInput defaultExtractorInput) {
        return Sniffer.m9047a(defaultExtractorInput, 128, false);
    }

    public Mp4Extractor() {
        m9037c();
    }

    public final void mo428a(ExtractorSampleSource extractorSampleSource) {
        this.f7217o = extractorSampleSource;
    }

    public final void mo430b() {
        this.f7208e.clear();
        this.f7212j = 0;
        this.f7215m = 0;
        this.f7216n = 0;
        this.f7209g = 0;
    }

    public final int mo427a(DefaultExtractorInput defaultExtractorInput, PositionHolder positionHolder) {
        while (true) {
            switch (this.f7209g) {
                case 0:
                    if (defaultExtractorInput.f6964d != 0) {
                        this.f7209g = 3;
                        break;
                    }
                    m9037c();
                    break;
                case 1:
                    if (m9034b(defaultExtractorInput)) {
                        break;
                    }
                    return -1;
                case 2:
                    if (!m9035b(defaultExtractorInput, positionHolder)) {
                        break;
                    }
                    return 1;
                default:
                    return m9036c(defaultExtractorInput, positionHolder);
            }
        }
    }

    public final boolean mo407a() {
        return true;
    }

    public final long mo406a(long j) {
        long j2 = Long.MAX_VALUE;
        for (int i = 0; i < this.f7218p.length; i++) {
            TrackSampleTable trackSampleTable = this.f7218p[i].f7201b;
            int a = Util.m9361a(trackSampleTable.f7256e, j, true, false);
            while (a >= 0) {
                if ((trackSampleTable.f7257f[a] & 1) != 0) {
                    break;
                }
                a--;
            }
            a = -1;
            int i2 = a;
            if (i2 == -1) {
                a = Util.m9366b(trackSampleTable.f7256e, j, true, false);
                while (a < trackSampleTable.f7256e.length) {
                    if ((trackSampleTable.f7257f[a] & 1) != 0) {
                        break;
                    }
                    a++;
                }
                a = -1;
                i2 = a;
            }
            this.f7218p[i].f7203d = i2;
            long j3 = trackSampleTable.f7253b[i2];
            if (j3 < j2) {
                j2 = j3;
            }
        }
        return j2;
    }

    private void m9037c() {
        this.f7209g = 1;
        this.f7212j = 0;
    }

    private boolean m9034b(DefaultExtractorInput defaultExtractorInput) {
        Object obj;
        if (this.f7212j == 0) {
            if (!defaultExtractorInput.m8839a(this.f7207d.f7731a, 0, 8, true)) {
                return false;
            }
            this.f7212j = 8;
            this.f7207d.m9337b(0);
            this.f7211i = this.f7207d.m9347k();
            this.f7210h = this.f7207d.m9349m();
        }
        if (this.f7211i == 1) {
            defaultExtractorInput.m8842b(this.f7207d.f7731a, 8, 8);
            this.f7212j += 8;
            this.f7211i = this.f7207d.m9357u();
        }
        int i = this.f7210h;
        if (i == Atom.f7158y || i == Atom.f7108A || i == Atom.f7109B || i == Atom.f7110C || i == Atom.f7111D || i == Atom.f7119L) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            long j = (defaultExtractorInput.f6964d + this.f7211i) - ((long) this.f7212j);
            this.f7208e.add(new ContainerAtom(this.f7210h, j));
            if (this.f7211i == ((long) this.f7212j)) {
                m9033b(j);
            } else {
                m9037c();
            }
        } else {
            i = this.f7210h;
            if (i == Atom.f7121N || i == Atom.f7159z || i == Atom.f7122O || i == Atom.f7123P || i == Atom.ag || i == Atom.ah || i == Atom.ai || i == Atom.f7120M || i == Atom.aj || i == Atom.ak || i == Atom.al || i == Atom.am || i == Atom.f7118K || i == Atom.f7134a || i == Atom.as) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                boolean z;
                if (this.f7212j == 8) {
                    z = true;
                } else {
                    z = false;
                }
                Assertions.m9297b(z);
                if (this.f7211i <= 2147483647L) {
                    z = true;
                } else {
                    z = false;
                }
                Assertions.m9297b(z);
                this.f7213k = new ParsableByteArray((int) this.f7211i);
                System.arraycopy(this.f7207d.f7731a, 0, this.f7213k.f7731a, 0, 8);
                this.f7209g = 2;
            } else {
                this.f7213k = null;
                this.f7209g = 2;
            }
        }
        return true;
    }

    private boolean m9035b(DefaultExtractorInput defaultExtractorInput, PositionHolder positionHolder) {
        boolean z;
        long j = this.f7211i - ((long) this.f7212j);
        long j2 = defaultExtractorInput.f6964d + j;
        if (this.f7213k != null) {
            defaultExtractorInput.m8842b(this.f7213k.f7731a, this.f7212j, (int) j);
            if (this.f7210h == Atom.f7134a) {
                this.f7219q = m9032a(this.f7213k);
                z = false;
            } else if (this.f7208e.isEmpty()) {
                z = false;
            } else {
                ((ContainerAtom) this.f7208e.peek()).m8980a(new LeafAtom(this.f7210h, this.f7213k));
                z = false;
            }
        } else if (j < 262144) {
            defaultExtractorInput.m8841b((int) j);
            z = false;
        } else {
            positionHolder.f7028a = j + defaultExtractorInput.m8844c();
            z = true;
        }
        m9033b(j2);
        if (!z || this.f7209g == 3) {
            return false;
        }
        return true;
    }

    private void m9033b(long j) {
        while (!this.f7208e.isEmpty() && ((ContainerAtom) this.f7208e.peek()).aA == j) {
            ContainerAtom containerAtom = (ContainerAtom) this.f7208e.pop();
            if (containerAtom.az == Atom.f7158y) {
                GaplessInfo a;
                List arrayList = new ArrayList();
                LeafAtom d = containerAtom.m8981d(Atom.as);
                if (d != null) {
                    a = AtomParsers.m8987a(d, this.f7219q);
                } else {
                    a = null;
                }
                for (int i = 0; i < containerAtom.aC.size(); i++) {
                    ContainerAtom containerAtom2 = (ContainerAtom) containerAtom.aC.get(i);
                    if (containerAtom2.az == Atom.f7108A) {
                        Track a2 = AtomParsers.m8991a(containerAtom2, containerAtom.m8981d(Atom.f7159z), this.f7219q);
                        if (a2 != null) {
                            TrackSampleTable a3 = AtomParsers.m8993a(a2, containerAtom2.m8982e(Atom.f7109B).m8982e(Atom.f7110C).m8982e(Atom.f7111D));
                            if (a3.f7252a != 0) {
                                Mp4Track mp4Track = new Mp4Track(a2, a3, this.f7217o.m8892d(i));
                                MediaFormat a4 = a2.f7231k.m8746a(a3.f7255d + 30);
                                if (a != null) {
                                    a4 = a4.m8747a(a.f7026a, a.f7027b);
                                }
                                mp4Track.f7202c.mo410a(a4);
                                arrayList.add(mp4Track);
                            }
                        }
                    }
                }
                this.f7218p = (Mp4Track[]) arrayList.toArray(new Mp4Track[0]);
                this.f7217o.m8895g();
                this.f7217o.f7011m = this;
                this.f7208e.clear();
                this.f7209g = 3;
            } else if (!this.f7208e.isEmpty()) {
                ((ContainerAtom) this.f7208e.peek()).m8979a(containerAtom);
            }
        }
        if (this.f7209g != 3) {
            m9037c();
        }
    }

    private static boolean m9032a(ParsableByteArray parsableByteArray) {
        parsableByteArray.m9337b(8);
        if (parsableByteArray.m9349m() == f7204a) {
            return true;
        }
        parsableByteArray.m9339c(4);
        while (parsableByteArray.m9336b() > 0) {
            if (parsableByteArray.m9349m() == f7204a) {
                return true;
            }
        }
        return false;
    }

    private int m9036c(DefaultExtractorInput defaultExtractorInput, PositionHolder positionHolder) {
        int d = m9038d();
        if (d == -1) {
            return -1;
        }
        Mp4Track mp4Track = this.f7218p[d];
        TrackOutput trackOutput = mp4Track.f7202c;
        int i = mp4Track.f7203d;
        long j = mp4Track.f7201b.f7253b[i];
        long j2 = (j - defaultExtractorInput.f6964d) + ((long) this.f7215m);
        if (j2 < 0 || j2 >= 262144) {
            positionHolder.f7028a = j;
            return 1;
        }
        defaultExtractorInput.m8841b((int) j2);
        this.f7214l = mp4Track.f7201b.f7254c[i];
        int i2;
        if (mp4Track.f7200a.f7235o != -1) {
            byte[] bArr = this.f7206c.f7731a;
            bArr[0] = (byte) 0;
            bArr[1] = (byte) 0;
            bArr[2] = (byte) 0;
            i2 = mp4Track.f7200a.f7235o;
            int i3 = 4 - mp4Track.f7200a.f7235o;
            while (this.f7215m < this.f7214l) {
                if (this.f7216n == 0) {
                    defaultExtractorInput.m8842b(this.f7206c.f7731a, i3, i2);
                    this.f7206c.m9337b(0);
                    this.f7216n = this.f7206c.m9355s();
                    this.f7205b.m9337b(0);
                    trackOutput.mo411a(this.f7205b, 4);
                    this.f7215m += 4;
                    this.f7214l += i3;
                } else {
                    int a = trackOutput.mo408a(defaultExtractorInput, this.f7216n, false);
                    this.f7215m += a;
                    this.f7216n -= a;
                }
            }
        } else {
            while (this.f7215m < this.f7214l) {
                i2 = trackOutput.mo408a(defaultExtractorInput, this.f7214l - this.f7215m, false);
                this.f7215m += i2;
                this.f7216n -= i2;
            }
        }
        trackOutput.mo409a(mp4Track.f7201b.f7256e[i], mp4Track.f7201b.f7257f[i], this.f7214l, 0, null);
        mp4Track.f7203d++;
        this.f7215m = 0;
        this.f7216n = 0;
        return 0;
    }

    private int m9038d() {
        int i = -1;
        long j = Long.MAX_VALUE;
        for (int i2 = 0; i2 < this.f7218p.length; i2++) {
            Mp4Track mp4Track = this.f7218p[i2];
            int i3 = mp4Track.f7203d;
            if (i3 != mp4Track.f7201b.f7252a) {
                long j2 = mp4Track.f7201b.f7253b[i3];
                if (j2 < j) {
                    j = j2;
                    i = i2;
                }
            }
        }
        return i;
    }
}
