package com.facebook.livephotos.exoplayer.extractor.ts;

import android.util.SparseArray;
import com.facebook.livephotos.exoplayer.MediaFormat;
import com.facebook.livephotos.exoplayer.extractor.TrackOutput;
import com.facebook.livephotos.exoplayer.util.NalUnitUtil;
import com.facebook.livephotos.exoplayer.util.NalUnitUtil.PpsData;
import com.facebook.livephotos.exoplayer.util.NalUnitUtil.SpsData;
import com.facebook.livephotos.exoplayer.util.ParsableBitArray;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: page_event_status_update_success */
final class H264Reader extends ElementaryStreamReader {
    private boolean f7415b;
    private final SeiReader f7416c;
    private final boolean[] f7417d = new boolean[3];
    private final SampleReader f7418e;
    private final NalUnitTargetBuffer f7419f;
    private final NalUnitTargetBuffer f7420g;
    private final NalUnitTargetBuffer f7421h;
    private long f7422i;
    private long f7423j;
    private final ParsableByteArray f7424k;

    /* compiled from: page_event_status_update_success */
    public final class SampleReader {
        private final TrackOutput f7397a;
        private final boolean f7398b;
        public final boolean f7399c;
        private final ParsableBitArray f7400d = new ParsableBitArray();
        private final SparseArray<SpsData> f7401e = new SparseArray();
        private final SparseArray<PpsData> f7402f = new SparseArray();
        private byte[] f7403g = new byte[128];
        private int f7404h;
        private int f7405i;
        private long f7406j;
        private boolean f7407k;
        private long f7408l;
        private SliceHeaderData f7409m = new SliceHeaderData();
        private SliceHeaderData f7410n = new SliceHeaderData();
        private boolean f7411o;
        private long f7412p;
        private long f7413q;
        private boolean f7414r;

        /* compiled from: page_event_status_update_success */
        public final class SliceHeaderData {
            public boolean f7381a;
            public boolean f7382b;
            public SpsData f7383c;
            public int f7384d;
            public int f7385e;
            public int f7386f;
            public int f7387g;
            public boolean f7388h;
            public boolean f7389i;
            public boolean f7390j;
            public boolean f7391k;
            public int f7392l;
            public int f7393m;
            public int f7394n;
            public int f7395o;
            public int f7396p;

            public final void m9122a() {
                this.f7382b = false;
                this.f7381a = false;
            }

            public final void m9123a(int i) {
                this.f7385e = i;
                this.f7382b = true;
            }

            public final void m9124a(SpsData spsData, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, int i7, int i8, int i9) {
                this.f7383c = spsData;
                this.f7384d = i;
                this.f7385e = i2;
                this.f7386f = i3;
                this.f7387g = i4;
                this.f7388h = z;
                this.f7389i = z2;
                this.f7390j = z3;
                this.f7391k = z4;
                this.f7392l = i5;
                this.f7393m = i6;
                this.f7394n = i7;
                this.f7395o = i8;
                this.f7396p = i9;
                this.f7381a = true;
                this.f7382b = true;
            }
        }

        public SampleReader(TrackOutput trackOutput, boolean z, boolean z2) {
            this.f7397a = trackOutput;
            this.f7398b = z;
            this.f7399c = z2;
            m9132b();
        }

        public final boolean m9131a() {
            return this.f7399c;
        }

        public final void m9129a(SpsData spsData) {
            this.f7401e.append(spsData.f7713a, spsData);
        }

        public final void m9128a(PpsData ppsData) {
            this.f7402f.append(ppsData.f7710a, ppsData);
        }

        public final void m9132b() {
            this.f7407k = false;
            this.f7411o = false;
            this.f7410n.m9122a();
        }

        public final void m9127a(long j, int i, long j2) {
            this.f7405i = i;
            this.f7408l = j2;
            this.f7406j = j;
            if (!(this.f7398b && this.f7405i == 1)) {
                if (!this.f7399c) {
                    return;
                }
                if (!(this.f7405i == 5 || this.f7405i == 1 || this.f7405i == 2)) {
                    return;
                }
            }
            SliceHeaderData sliceHeaderData = this.f7409m;
            this.f7409m = this.f7410n;
            this.f7410n = sliceHeaderData;
            this.f7410n.m9122a();
            this.f7404h = 0;
            this.f7407k = true;
        }

        public final void m9130a(byte[] bArr, int i, int i2) {
            if (this.f7407k) {
                int i3 = i2 - i;
                if (this.f7403g.length < this.f7404h + i3) {
                    this.f7403g = Arrays.copyOf(this.f7403g, (this.f7404h + i3) * 2);
                }
                System.arraycopy(bArr, i, this.f7403g, this.f7404h, i3);
                this.f7404h = i3 + this.f7404h;
                this.f7400d.m9323a(this.f7403g, this.f7404h);
                if (this.f7400d.m9321a() >= 8) {
                    this.f7400d.m9324b(1);
                    int c = this.f7400d.m9326c(2);
                    this.f7400d.m9324b(5);
                    if (this.f7400d.m9327c()) {
                        this.f7400d.m9328d();
                        if (this.f7400d.m9327c()) {
                            int d = this.f7400d.m9328d();
                            if (!this.f7399c) {
                                this.f7407k = false;
                                this.f7410n.m9123a(d);
                            } else if (this.f7400d.m9327c()) {
                                int d2 = this.f7400d.m9328d();
                                if (this.f7402f.indexOfKey(d2) < 0) {
                                    this.f7407k = false;
                                    return;
                                }
                                PpsData ppsData = (PpsData) this.f7402f.get(d2);
                                SpsData spsData = (SpsData) this.f7401e.get(ppsData.f7711b);
                                if (spsData.f7717e) {
                                    if (this.f7400d.m9321a() >= 2) {
                                        this.f7400d.m9324b(2);
                                    } else {
                                        return;
                                    }
                                }
                                if (this.f7400d.m9321a() >= spsData.f7719g) {
                                    boolean z = false;
                                    boolean z2 = false;
                                    boolean z3 = false;
                                    int c2 = this.f7400d.m9326c(spsData.f7719g);
                                    if (!spsData.f7718f) {
                                        if (this.f7400d.m9321a() > 0) {
                                            z = this.f7400d.m9325b();
                                            if (z) {
                                                if (this.f7400d.m9321a() > 0) {
                                                    z3 = this.f7400d.m9325b();
                                                    z2 = true;
                                                } else {
                                                    return;
                                                }
                                            }
                                        }
                                        return;
                                    }
                                    boolean z4 = this.f7405i == 5;
                                    int i4 = 0;
                                    if (z4) {
                                        if (this.f7400d.m9327c()) {
                                            i4 = this.f7400d.m9328d();
                                        } else {
                                            return;
                                        }
                                    }
                                    int i5 = 0;
                                    int i6 = 0;
                                    int i7 = 0;
                                    int i8 = 0;
                                    if (spsData.f7720h == 0) {
                                        if (this.f7400d.m9321a() >= spsData.f7721i) {
                                            i5 = this.f7400d.m9326c(spsData.f7721i);
                                            if (ppsData.f7712c && !z) {
                                                if (this.f7400d.m9327c()) {
                                                    i6 = this.f7400d.m9329e();
                                                } else {
                                                    return;
                                                }
                                            }
                                        }
                                        return;
                                    } else if (spsData.f7720h == 1 && !spsData.f7722j) {
                                        if (this.f7400d.m9327c()) {
                                            i7 = this.f7400d.m9329e();
                                            if (ppsData.f7712c && !z) {
                                                if (this.f7400d.m9327c()) {
                                                    i8 = this.f7400d.m9329e();
                                                } else {
                                                    return;
                                                }
                                            }
                                        }
                                        return;
                                    }
                                    this.f7410n.m9124a(spsData, c, d, c2, d2, z, z2, z3, z4, i4, i5, i6, i7, i8);
                                    this.f7407k = false;
                                }
                            }
                        }
                    }
                }
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void m9126a(long r9, int r11) {
            /*
            r8 = this;
            r0 = 0;
            r1 = 1;
            r2 = r8.f7405i;
            r3 = 9;
            if (r2 == r3) goto L_0x008e;
        L_0x0008:
            r2 = r8.f7399c;
            if (r2 == 0) goto L_0x00a7;
        L_0x000c:
            r2 = r8.f7410n;
            r3 = r8.f7409m;
            r5 = 1;
            r6 = r2.f7381a;
            if (r6 == 0) goto L_0x00cf;
        L_0x0015:
            r6 = r3.f7381a;
            if (r6 == 0) goto L_0x008b;
        L_0x0019:
            r6 = r2.f7386f;
            r7 = r3.f7386f;
            if (r6 != r7) goto L_0x008b;
        L_0x001f:
            r6 = r2.f7387g;
            r7 = r3.f7387g;
            if (r6 != r7) goto L_0x008b;
        L_0x0025:
            r6 = r2.f7388h;
            r7 = r3.f7388h;
            if (r6 != r7) goto L_0x008b;
        L_0x002b:
            r6 = r2.f7389i;
            if (r6 == 0) goto L_0x0039;
        L_0x002f:
            r6 = r3.f7389i;
            if (r6 == 0) goto L_0x0039;
        L_0x0033:
            r6 = r2.f7390j;
            r7 = r3.f7390j;
            if (r6 != r7) goto L_0x008b;
        L_0x0039:
            r6 = r2.f7384d;
            r7 = r3.f7384d;
            if (r6 == r7) goto L_0x0047;
        L_0x003f:
            r6 = r2.f7384d;
            if (r6 == 0) goto L_0x008b;
        L_0x0043:
            r6 = r3.f7384d;
            if (r6 == 0) goto L_0x008b;
        L_0x0047:
            r6 = r2.f7383c;
            r6 = r6.f7720h;
            if (r6 != 0) goto L_0x005f;
        L_0x004d:
            r6 = r3.f7383c;
            r6 = r6.f7720h;
            if (r6 != 0) goto L_0x005f;
        L_0x0053:
            r6 = r2.f7393m;
            r7 = r3.f7393m;
            if (r6 != r7) goto L_0x008b;
        L_0x0059:
            r6 = r2.f7394n;
            r7 = r3.f7394n;
            if (r6 != r7) goto L_0x008b;
        L_0x005f:
            r6 = r2.f7383c;
            r6 = r6.f7720h;
            if (r6 != r5) goto L_0x0077;
        L_0x0065:
            r6 = r3.f7383c;
            r6 = r6.f7720h;
            if (r6 != r5) goto L_0x0077;
        L_0x006b:
            r6 = r2.f7395o;
            r7 = r3.f7395o;
            if (r6 != r7) goto L_0x008b;
        L_0x0071:
            r6 = r2.f7396p;
            r7 = r3.f7396p;
            if (r6 != r7) goto L_0x008b;
        L_0x0077:
            r6 = r2.f7391k;
            r7 = r3.f7391k;
            if (r6 != r7) goto L_0x008b;
        L_0x007d:
            r6 = r2.f7391k;
            if (r6 == 0) goto L_0x00cf;
        L_0x0081:
            r6 = r3.f7391k;
            if (r6 == 0) goto L_0x00cf;
        L_0x0085:
            r6 = r2.f7392l;
            r7 = r3.f7392l;
            if (r6 == r7) goto L_0x00cf;
        L_0x008b:
            r2 = r5;
            if (r2 == 0) goto L_0x00a7;
        L_0x008e:
            r2 = r8.f7411o;
            if (r2 == 0) goto L_0x009b;
        L_0x0092:
            r2 = r8.f7406j;
            r2 = r9 - r2;
            r2 = (int) r2;
            r2 = r2 + r11;
            r8.m9125a(r2);
        L_0x009b:
            r2 = r8.f7406j;
            r8.f7412p = r2;
            r2 = r8.f7408l;
            r8.f7413q = r2;
            r8.f7414r = r0;
            r8.f7411o = r1;
        L_0x00a7:
            r2 = r8.f7414r;
            r3 = r8.f7405i;
            r4 = 5;
            if (r3 == r4) goto L_0x00ca;
        L_0x00ae:
            r3 = r8.f7398b;
            if (r3 == 0) goto L_0x00cb;
        L_0x00b2:
            r3 = r8.f7405i;
            if (r3 != r1) goto L_0x00cb;
        L_0x00b6:
            r3 = r8.f7410n;
            r5 = r3.f7382b;
            if (r5 == 0) goto L_0x00d1;
        L_0x00bc:
            r5 = r3.f7385e;
            r6 = 7;
            if (r5 == r6) goto L_0x00c6;
        L_0x00c1:
            r5 = r3.f7385e;
            r6 = 2;
            if (r5 != r6) goto L_0x00d1;
        L_0x00c6:
            r5 = 1;
        L_0x00c7:
            r3 = r5;
            if (r3 == 0) goto L_0x00cb;
        L_0x00ca:
            r0 = r1;
        L_0x00cb:
            r0 = r0 | r2;
            r8.f7414r = r0;
            return;
        L_0x00cf:
            r5 = 0;
            goto L_0x008b;
        L_0x00d1:
            r5 = 0;
            goto L_0x00c7;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.livephotos.exoplayer.extractor.ts.H264Reader.SampleReader.a(long, int):void");
        }

        private void m9125a(int i) {
            this.f7397a.mo409a(this.f7413q, this.f7414r ? 1 : 0, (int) (this.f7406j - this.f7412p), i, null);
        }
    }

    public H264Reader(TrackOutput trackOutput, SeiReader seiReader, boolean z, boolean z2) {
        super(trackOutput);
        this.f7416c = seiReader;
        this.f7418e = new SampleReader(trackOutput, z, z2);
        this.f7419f = new NalUnitTargetBuffer(7, 128);
        this.f7420g = new NalUnitTargetBuffer(8, 128);
        this.f7421h = new NalUnitTargetBuffer(6, 128);
        this.f7424k = new ParsableByteArray();
    }

    public final void mo434a() {
        NalUnitUtil.m9316a(this.f7417d);
        this.f7419f.m9164a();
        this.f7420g.m9164a();
        this.f7421h.m9164a();
        this.f7418e.m9132b();
        this.f7422i = 0;
    }

    public final void mo435a(long j, boolean z) {
        this.f7423j = j;
    }

    public final void mo436a(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.m9336b() > 0) {
            int i = parsableByteArray.f7732b;
            int i2 = parsableByteArray.f7733c;
            byte[] bArr = parsableByteArray.f7731a;
            this.f7422i += (long) parsableByteArray.m9336b();
            this.f7327a.mo411a(parsableByteArray, parsableByteArray.m9336b());
            while (true) {
                int a = NalUnitUtil.m9312a(bArr, i, i2, this.f7417d);
                if (a == i2) {
                    m9136a(bArr, i, i2);
                    return;
                }
                int i3 = bArr[a + 3] & 31;
                int i4 = a - i;
                if (i4 > 0) {
                    m9136a(bArr, i, a);
                }
                int i5 = i2 - a;
                long j = this.f7422i - ((long) i5);
                m9134a(j, i5, i4 < 0 ? -i4 : 0, this.f7423j);
                m9135a(j, i3, this.f7423j);
                i = a + 3;
            }
        }
    }

    public final void mo437b() {
    }

    private void m9135a(long j, int i, long j2) {
        if (!this.f7415b || this.f7418e.f7399c) {
            this.f7419f.m9165a(i);
            this.f7420g.m9165a(i);
        }
        this.f7421h.m9165a(i);
        this.f7418e.m9127a(j, i, j2);
    }

    private void m9136a(byte[] bArr, int i, int i2) {
        if (!this.f7415b || this.f7418e.f7399c) {
            this.f7419f.m9166a(bArr, i, i2);
            this.f7420g.m9166a(bArr, i, i2);
        }
        this.f7421h.m9166a(bArr, i, i2);
        this.f7418e.m9130a(bArr, i, i2);
    }

    private void m9134a(long j, int i, int i2, long j2) {
        if (!this.f7415b || this.f7418e.m9131a()) {
            this.f7419f.m9168b(i2);
            this.f7420g.m9168b(i2);
            if (this.f7415b) {
                if (this.f7419f.m9167b()) {
                    this.f7418e.m9129a(NalUnitUtil.m9313a(m9133a(this.f7419f)));
                    this.f7419f.m9164a();
                } else if (this.f7420g.m9167b()) {
                    this.f7418e.m9128a(NalUnitUtil.m9318b(m9133a(this.f7420g)));
                    this.f7420g.m9164a();
                }
            } else if (this.f7419f.m9167b() && this.f7420g.m9167b()) {
                List arrayList = new ArrayList();
                arrayList.add(Arrays.copyOf(this.f7419f.f7462a, this.f7419f.f7463b));
                arrayList.add(Arrays.copyOf(this.f7420g.f7462a, this.f7420g.f7463b));
                SpsData a = NalUnitUtil.m9313a(m9133a(this.f7419f));
                PpsData b = NalUnitUtil.m9318b(m9133a(this.f7420g));
                this.f7327a.mo410a(MediaFormat.m8739a(null, "video/avc", -1, -1, -1, a.f7714b, a.f7715c, arrayList, -1, a.f7716d));
                this.f7415b = true;
                this.f7418e.m9129a(a);
                this.f7418e.m9128a(b);
                this.f7419f.m9164a();
                this.f7420g.m9164a();
            }
        }
        if (this.f7421h.m9168b(i2)) {
            this.f7424k.m9334a(this.f7421h.f7462a, NalUnitUtil.m9310a(this.f7421h.f7462a, this.f7421h.f7463b));
            this.f7424k.m9337b(4);
            this.f7416c.m9178a(j2, this.f7424k);
        }
        this.f7418e.m9126a(j, i);
    }

    private static ParsableBitArray m9133a(NalUnitTargetBuffer nalUnitTargetBuffer) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(nalUnitTargetBuffer.f7462a, NalUnitUtil.m9310a(nalUnitTargetBuffer.f7462a, nalUnitTargetBuffer.f7463b));
        parsableBitArray.m9324b(32);
        return parsableBitArray;
    }
}
