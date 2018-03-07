package com.facebook.livephotos.exoplayer.extractor.webm;

import android.util.Pair;
import android.util.SparseArray;
import com.facebook.livephotos.exoplayer.ParserException;
import com.facebook.livephotos.exoplayer.drm.DrmInitData.SchemeInitData;
import com.facebook.livephotos.exoplayer.drm.DrmInitData.Universal;
import com.facebook.livephotos.exoplayer.extractor.ChunkIndex;
import com.facebook.livephotos.exoplayer.extractor.DefaultExtractorInput;
import com.facebook.livephotos.exoplayer.extractor.Extractor;
import com.facebook.livephotos.exoplayer.extractor.ExtractorSampleSource;
import com.facebook.livephotos.exoplayer.extractor.PositionHolder;
import com.facebook.livephotos.exoplayer.extractor.SeekMap;
import com.facebook.livephotos.exoplayer.extractor.TrackOutput;
import com.facebook.livephotos.exoplayer.util.LongArray;
import com.facebook.livephotos.exoplayer.util.NalUnitUtil;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;
import com.facebook.livephotos.exoplayer.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* compiled from: pageName */
public final class WebmExtractor implements Extractor {
    private static final byte[] f7567a = new byte[]{(byte) 49, (byte) 10, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 44, (byte) 48, (byte) 48, (byte) 48, (byte) 32, (byte) 45, (byte) 45, (byte) 62, (byte) 32, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 58, (byte) 48, (byte) 48, (byte) 44, (byte) 48, (byte) 48, (byte) 48, (byte) 10};
    public static final byte[] f7568b = new byte[]{(byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32, (byte) 32};
    public static final UUID f7569c = new UUID(72057594037932032L, -9223371306706625679L);
    private long f7570A;
    private LongArray f7571B;
    private LongArray f7572C;
    private boolean f7573D;
    private int f7574E;
    private long f7575F;
    private long f7576G;
    private int f7577H;
    private int f7578I;
    private int[] f7579J;
    private int f7580K;
    private int f7581L;
    private int f7582M;
    private int f7583N;
    private boolean f7584O;
    private int f7585P;
    private int f7586Q;
    private boolean f7587R;
    private boolean f7588S;
    private ExtractorSampleSource f7589T;
    private final DefaultEbmlReader f7590d;
    private final VarintReader f7591e;
    private final SparseArray<Track> f7592f;
    private final ParsableByteArray f7593g;
    private final ParsableByteArray f7594h;
    private final ParsableByteArray f7595i;
    private final ParsableByteArray f7596j;
    private final ParsableByteArray f7597k;
    private final ParsableByteArray f7598l;
    private final ParsableByteArray f7599m;
    private long f7600n;
    private long f7601o;
    private long f7602p;
    public long f7603q;
    private long f7604r;
    public Track f7605s;
    private boolean f7606t;
    private boolean f7607u;
    private int f7608v;
    private long f7609w;
    private boolean f7610x;
    private long f7611y;
    private long f7612z;

    /* compiled from: pageName */
    public final class InnerEbmlReaderOutput {
        public final /* synthetic */ WebmExtractor f7545a;

        public InnerEbmlReaderOutput(WebmExtractor webmExtractor) {
            this.f7545a = webmExtractor;
        }

        public final void m9224a(int i, long j, long j2) {
            this.f7545a.m9245a(i, j, j2);
        }

        public final void m9223a(int i, double d) {
            WebmExtractor webmExtractor = this.f7545a;
            switch (i) {
                case 181:
                    webmExtractor.f7605s.f7561p = (int) d;
                    return;
                case 17545:
                    webmExtractor.f7603q = (long) d;
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: pageName */
    public final class Track {
        public String f7546a;
        public int f7547b;
        public int f7548c;
        public int f7549d;
        public boolean f7550e;
        public byte[] f7551f;
        public byte[] f7552g;
        public byte[] f7553h;
        public int f7554i = -1;
        public int f7555j = -1;
        public int f7556k = -1;
        public int f7557l = -1;
        public int f7558m = 0;
        public int f7559n = 1;
        public int f7560o = -1;
        public int f7561p = 8000;
        public long f7562q = 0;
        public long f7563r = 0;
        public TrackOutput f7564s;
        public int f7565t;
        public String f7566u = "eng";

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void m9230a(com.facebook.livephotos.exoplayer.extractor.ExtractorSampleSource r12, int r13, long r14) {
            /*
            r11 = this;
            r0 = 0;
            r4 = 3;
            r3 = 16;
            r5 = 8;
            r2 = -1;
            r1 = r11.f7546a;
            r6 = r1.hashCode();
            switch(r6) {
                case -2095576542: goto L_0x004e;
                case -2095575984: goto L_0x003a;
                case -1985379776: goto L_0x00f7;
                case -1784763192: goto L_0x00bc;
                case -1730367663: goto L_0x0076;
                case -1482641357: goto L_0x0098;
                case -1373388978: goto L_0x006c;
                case -538363189: goto L_0x0044;
                case -538363109: goto L_0x0058;
                case -425012669: goto L_0x011b;
                case -356037306: goto L_0x00df;
                case 62923557: goto L_0x008c;
                case 62923603: goto L_0x00a4;
                case 62927045: goto L_0x00c8;
                case 82338133: goto L_0x001c;
                case 82338134: goto L_0x0026;
                case 99146302: goto L_0x0127;
                case 542569478: goto L_0x00d3;
                case 725957860: goto L_0x0103;
                case 855502857: goto L_0x0062;
                case 1422270023: goto L_0x010f;
                case 1809237540: goto L_0x0030;
                case 1950749482: goto L_0x00b0;
                case 1950789798: goto L_0x00eb;
                case 1951062397: goto L_0x0081;
                default: goto L_0x0010;
            };
        L_0x0010:
            r1 = r2;
        L_0x0011:
            switch(r1) {
                case 0: goto L_0x0133;
                case 1: goto L_0x015a;
                case 2: goto L_0x015f;
                case 3: goto L_0x0164;
                case 4: goto L_0x0164;
                case 5: goto L_0x0164;
                case 6: goto L_0x0174;
                case 7: goto L_0x0193;
                case 8: goto L_0x01b2;
                case 9: goto L_0x01c3;
                case 10: goto L_0x01d0;
                case 11: goto L_0x020f;
                case 12: goto L_0x021b;
                case 13: goto L_0x0222;
                case 14: goto L_0x0228;
                case 15: goto L_0x022e;
                case 16: goto L_0x0234;
                case 17: goto L_0x0234;
                case 18: goto L_0x023a;
                case 19: goto L_0x0240;
                case 20: goto L_0x024c;
                case 21: goto L_0x027e;
                case 22: goto L_0x029b;
                case 23: goto L_0x02a1;
                case 24: goto L_0x02ad;
                default: goto L_0x0014;
            };
        L_0x0014:
            r0 = new com.facebook.livephotos.exoplayer.ParserException;
            r1 = "Unrecognized codec identifier.";
            r0.<init>(r1);
            throw r0;
        L_0x001c:
            r6 = "V_VP8";
            r1 = r1.equals(r6);
            if (r1 == 0) goto L_0x0010;
        L_0x0024:
            r1 = 0;
            goto L_0x0011;
        L_0x0026:
            r6 = "V_VP9";
            r1 = r1.equals(r6);
            if (r1 == 0) goto L_0x0010;
        L_0x002e:
            r1 = 1;
            goto L_0x0011;
        L_0x0030:
            r6 = "V_MPEG2";
            r1 = r1.equals(r6);
            if (r1 == 0) goto L_0x0010;
        L_0x0038:
            r1 = 2;
            goto L_0x0011;
        L_0x003a:
            r6 = "V_MPEG4/ISO/SP";
            r1 = r1.equals(r6);
            if (r1 == 0) goto L_0x0010;
        L_0x0042:
            r1 = r4;
            goto L_0x0011;
        L_0x0044:
            r6 = "V_MPEG4/ISO/ASP";
            r1 = r1.equals(r6);
            if (r1 == 0) goto L_0x0010;
        L_0x004c:
            r1 = 4;
            goto L_0x0011;
        L_0x004e:
            r6 = "V_MPEG4/ISO/AP";
            r1 = r1.equals(r6);
            if (r1 == 0) goto L_0x0010;
        L_0x0056:
            r1 = 5;
            goto L_0x0011;
        L_0x0058:
            r6 = "V_MPEG4/ISO/AVC";
            r1 = r1.equals(r6);
            if (r1 == 0) goto L_0x0010;
        L_0x0060:
            r1 = 6;
            goto L_0x0011;
        L_0x0062:
            r6 = "V_MPEGH/ISO/HEVC";
            r1 = r1.equals(r6);
            if (r1 == 0) goto L_0x0010;
        L_0x006a:
            r1 = 7;
            goto L_0x0011;
        L_0x006c:
            r6 = "V_MS/VFW/FOURCC";
            r1 = r1.equals(r6);
            if (r1 == 0) goto L_0x0010;
        L_0x0074:
            r1 = r5;
            goto L_0x0011;
        L_0x0076:
            r6 = "A_VORBIS";
            r1 = r1.equals(r6);
            if (r1 == 0) goto L_0x0010;
        L_0x007e:
            r1 = 9;
            goto L_0x0011;
        L_0x0081:
            r6 = "A_OPUS";
            r1 = r1.equals(r6);
            if (r1 == 0) goto L_0x0010;
        L_0x0089:
            r1 = 10;
            goto L_0x0011;
        L_0x008c:
            r6 = "A_AAC";
            r1 = r1.equals(r6);
            if (r1 == 0) goto L_0x0010;
        L_0x0094:
            r1 = 11;
            goto L_0x0011;
        L_0x0098:
            r6 = "A_MPEG/L3";
            r1 = r1.equals(r6);
            if (r1 == 0) goto L_0x0010;
        L_0x00a0:
            r1 = 12;
            goto L_0x0011;
        L_0x00a4:
            r6 = "A_AC3";
            r1 = r1.equals(r6);
            if (r1 == 0) goto L_0x0010;
        L_0x00ac:
            r1 = 13;
            goto L_0x0011;
        L_0x00b0:
            r6 = "A_EAC3";
            r1 = r1.equals(r6);
            if (r1 == 0) goto L_0x0010;
        L_0x00b8:
            r1 = 14;
            goto L_0x0011;
        L_0x00bc:
            r6 = "A_TRUEHD";
            r1 = r1.equals(r6);
            if (r1 == 0) goto L_0x0010;
        L_0x00c4:
            r1 = 15;
            goto L_0x0011;
        L_0x00c8:
            r6 = "A_DTS";
            r1 = r1.equals(r6);
            if (r1 == 0) goto L_0x0010;
        L_0x00d0:
            r1 = r3;
            goto L_0x0011;
        L_0x00d3:
            r6 = "A_DTS/EXPRESS";
            r1 = r1.equals(r6);
            if (r1 == 0) goto L_0x0010;
        L_0x00db:
            r1 = 17;
            goto L_0x0011;
        L_0x00df:
            r6 = "A_DTS/LOSSLESS";
            r1 = r1.equals(r6);
            if (r1 == 0) goto L_0x0010;
        L_0x00e7:
            r1 = 18;
            goto L_0x0011;
        L_0x00eb:
            r6 = "A_FLAC";
            r1 = r1.equals(r6);
            if (r1 == 0) goto L_0x0010;
        L_0x00f3:
            r1 = 19;
            goto L_0x0011;
        L_0x00f7:
            r6 = "A_MS/ACM";
            r1 = r1.equals(r6);
            if (r1 == 0) goto L_0x0010;
        L_0x00ff:
            r1 = 20;
            goto L_0x0011;
        L_0x0103:
            r6 = "A_PCM/INT/LIT";
            r1 = r1.equals(r6);
            if (r1 == 0) goto L_0x0010;
        L_0x010b:
            r1 = 21;
            goto L_0x0011;
        L_0x010f:
            r6 = "S_TEXT/UTF8";
            r1 = r1.equals(r6);
            if (r1 == 0) goto L_0x0010;
        L_0x0117:
            r1 = 22;
            goto L_0x0011;
        L_0x011b:
            r6 = "S_VOBSUB";
            r1 = r1.equals(r6);
            if (r1 == 0) goto L_0x0010;
        L_0x0123:
            r1 = 23;
            goto L_0x0011;
        L_0x0127:
            r6 = "S_HDMV/PGS";
            r1 = r1.equals(r6);
            if (r1 == 0) goto L_0x0010;
        L_0x012f:
            r1 = 24;
            goto L_0x0011;
        L_0x0133:
            r1 = "video/x-vnd.on2.vp8";
            r8 = r0;
            r3 = r2;
        L_0x0137:
            r0 = com.facebook.livephotos.exoplayer.util.MimeTypes.m9304a(r1);
            if (r0 == 0) goto L_0x02b3;
        L_0x013d:
            r0 = java.lang.Integer.toString(r13);
            r6 = r11.f7559n;
            r7 = r11.f7561p;
            r9 = r11.f7566u;
            r4 = r14;
            r0 = com.facebook.livephotos.exoplayer.MediaFormat.m8740a(r0, r1, r2, r3, r4, r6, r7, r8, r9);
        L_0x014c:
            r1 = r11.f7547b;
            r1 = r12.m8892d(r1);
            r11.f7564s = r1;
            r1 = r11.f7564s;
            r1.mo410a(r0);
            return;
        L_0x015a:
            r1 = "video/x-vnd.on2.vp9";
            r8 = r0;
            r3 = r2;
            goto L_0x0137;
        L_0x015f:
            r1 = "video/mpeg2";
            r8 = r0;
            r3 = r2;
            goto L_0x0137;
        L_0x0164:
            r1 = "video/mp4v-es";
            r3 = r11.f7553h;
            if (r3 != 0) goto L_0x016d;
        L_0x016a:
            r8 = r0;
            r3 = r2;
            goto L_0x0137;
        L_0x016d:
            r0 = r11.f7553h;
            r0 = java.util.Collections.singletonList(r0);
            goto L_0x016a;
        L_0x0174:
            r3 = "video/avc";
            r0 = new com.facebook.livephotos.exoplayer.util.ParsableByteArray;
            r1 = r11.f7553h;
            r0.<init>(r1);
            r1 = m9227b(r0);
            r0 = r1.first;
            r0 = (java.util.List) r0;
            r1 = r1.second;
            r1 = (java.lang.Integer) r1;
            r1 = r1.intValue();
            r11.f7565t = r1;
            r1 = r3;
            r8 = r0;
            r3 = r2;
            goto L_0x0137;
        L_0x0193:
            r3 = "video/hevc";
            r0 = new com.facebook.livephotos.exoplayer.util.ParsableByteArray;
            r1 = r11.f7553h;
            r0.<init>(r1);
            r1 = m9228c(r0);
            r0 = r1.first;
            r0 = (java.util.List) r0;
            r1 = r1.second;
            r1 = (java.lang.Integer) r1;
            r1 = r1.intValue();
            r11.f7565t = r1;
            r1 = r3;
            r8 = r0;
            r3 = r2;
            goto L_0x0137;
        L_0x01b2:
            r1 = "video/wvc1";
            r0 = new com.facebook.livephotos.exoplayer.util.ParsableByteArray;
            r3 = r11.f7553h;
            r0.<init>(r3);
            r0 = m9225a(r0);
            r8 = r0;
            r3 = r2;
            goto L_0x0137;
        L_0x01c3:
            r1 = "audio/vorbis";
            r3 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
            r0 = r11.f7553h;
            r0 = m9226a(r0);
            r8 = r0;
            goto L_0x0137;
        L_0x01d0:
            r1 = "audio/opus";
            r3 = 5760; // 0x1680 float:8.071E-42 double:2.846E-320;
            r0 = new java.util.ArrayList;
            r0.<init>(r4);
            r4 = r11.f7553h;
            r0.add(r4);
            r4 = java.nio.ByteBuffer.allocate(r5);
            r6 = java.nio.ByteOrder.LITTLE_ENDIAN;
            r4 = r4.order(r6);
            r6 = r11.f7562q;
            r4 = r4.putLong(r6);
            r4 = r4.array();
            r0.add(r4);
            r4 = java.nio.ByteBuffer.allocate(r5);
            r5 = java.nio.ByteOrder.LITTLE_ENDIAN;
            r4 = r4.order(r5);
            r6 = r11.f7563r;
            r4 = r4.putLong(r6);
            r4 = r4.array();
            r0.add(r4);
            r8 = r0;
            goto L_0x0137;
        L_0x020f:
            r1 = "audio/mp4a-latm";
            r0 = r11.f7553h;
            r0 = java.util.Collections.singletonList(r0);
            r8 = r0;
            r3 = r2;
            goto L_0x0137;
        L_0x021b:
            r1 = "audio/mpeg";
            r3 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
            r8 = r0;
            goto L_0x0137;
        L_0x0222:
            r1 = "audio/ac3";
            r8 = r0;
            r3 = r2;
            goto L_0x0137;
        L_0x0228:
            r1 = "audio/eac3";
            r8 = r0;
            r3 = r2;
            goto L_0x0137;
        L_0x022e:
            r1 = "audio/true-hd";
            r8 = r0;
            r3 = r2;
            goto L_0x0137;
        L_0x0234:
            r1 = "audio/vnd.dts";
            r8 = r0;
            r3 = r2;
            goto L_0x0137;
        L_0x023a:
            r1 = "audio/vnd.dts.hd";
            r8 = r0;
            r3 = r2;
            goto L_0x0137;
        L_0x0240:
            r1 = "audio/x-flac";
            r0 = r11.f7553h;
            r0 = java.util.Collections.singletonList(r0);
            r8 = r0;
            r3 = r2;
            goto L_0x0137;
        L_0x024c:
            r1 = "audio/raw";
            r4 = new com.facebook.livephotos.exoplayer.util.ParsableByteArray;
            r5 = r11.f7553h;
            r4.<init>(r5);
            r4 = m9229d(r4);
            if (r4 != 0) goto L_0x0263;
        L_0x025b:
            r0 = new com.facebook.livephotos.exoplayer.ParserException;
            r1 = "Non-PCM MS/ACM is unsupported";
            r0.<init>(r1);
            throw r0;
        L_0x0263:
            r4 = r11.f7560o;
            if (r4 == r3) goto L_0x0336;
        L_0x0267:
            r0 = new com.facebook.livephotos.exoplayer.ParserException;
            r1 = new java.lang.StringBuilder;
            r2 = "Unsupported PCM bit depth: ";
            r1.<init>(r2);
            r2 = r11.f7560o;
            r1 = r1.append(r2);
            r1 = r1.toString();
            r0.<init>(r1);
            throw r0;
        L_0x027e:
            r1 = "audio/raw";
            r4 = r11.f7560o;
            if (r4 == r3) goto L_0x0336;
        L_0x0284:
            r0 = new com.facebook.livephotos.exoplayer.ParserException;
            r1 = new java.lang.StringBuilder;
            r2 = "Unsupported PCM bit depth: ";
            r1.<init>(r2);
            r2 = r11.f7560o;
            r1 = r1.append(r2);
            r1 = r1.toString();
            r0.<init>(r1);
            throw r0;
        L_0x029b:
            r1 = "application/x-subrip";
            r8 = r0;
            r3 = r2;
            goto L_0x0137;
        L_0x02a1:
            r1 = "application/vobsub";
            r0 = r11.f7553h;
            r0 = java.util.Collections.singletonList(r0);
            r8 = r0;
            r3 = r2;
            goto L_0x0137;
        L_0x02ad:
            r1 = "application/pgs";
            r8 = r0;
            r3 = r2;
            goto L_0x0137;
        L_0x02b3:
            r0 = com.facebook.livephotos.exoplayer.util.MimeTypes.m9305b(r1);
            if (r0 == 0) goto L_0x02fb;
        L_0x02b9:
            r0 = r11.f7558m;
            if (r0 != 0) goto L_0x02cd;
        L_0x02bd:
            r0 = r11.f7556k;
            if (r0 != r2) goto L_0x02f5;
        L_0x02c1:
            r0 = r11.f7554i;
        L_0x02c3:
            r11.f7556k = r0;
            r0 = r11.f7557l;
            if (r0 != r2) goto L_0x02f8;
        L_0x02c9:
            r0 = r11.f7555j;
        L_0x02cb:
            r11.f7557l = r0;
        L_0x02cd:
            r10 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
            r0 = r11.f7556k;
            if (r0 == r2) goto L_0x02e5;
        L_0x02d3:
            r0 = r11.f7557l;
            if (r0 == r2) goto L_0x02e5;
        L_0x02d7:
            r0 = r11.f7555j;
            r4 = r11.f7556k;
            r0 = r0 * r4;
            r0 = (float) r0;
            r4 = r11.f7554i;
            r5 = r11.f7557l;
            r4 = r4 * r5;
            r4 = (float) r4;
            r10 = r0 / r4;
        L_0x02e5:
            r0 = java.lang.Integer.toString(r13);
            r6 = r11.f7554i;
            r7 = r11.f7555j;
            r4 = r14;
            r9 = r2;
            r0 = com.facebook.livephotos.exoplayer.MediaFormat.m8739a(r0, r1, r2, r3, r4, r6, r7, r8, r9, r10);
            goto L_0x014c;
        L_0x02f5:
            r0 = r11.f7556k;
            goto L_0x02c3;
        L_0x02f8:
            r0 = r11.f7557l;
            goto L_0x02cb;
        L_0x02fb:
            r0 = "application/x-subrip";
            r0 = r0.equals(r1);
            if (r0 == 0) goto L_0x0310;
        L_0x0303:
            r0 = java.lang.Integer.toString(r13);
            r5 = r11.f7566u;
            r3 = r14;
            r0 = com.facebook.livephotos.exoplayer.MediaFormat.m8742a(r0, r1, r2, r3, r5);
            goto L_0x014c;
        L_0x0310:
            r0 = "application/vobsub";
            r0 = r0.equals(r1);
            if (r0 != 0) goto L_0x0320;
        L_0x0318:
            r0 = "application/pgs";
            r0 = r0.equals(r1);
            if (r0 == 0) goto L_0x032e;
        L_0x0320:
            r0 = java.lang.Integer.toString(r13);
            r6 = r11.f7566u;
            r3 = r14;
            r5 = r8;
            r0 = com.facebook.livephotos.exoplayer.MediaFormat.m8744a(r0, r1, r2, r3, r5, r6);
            goto L_0x014c;
        L_0x032e:
            r0 = new com.facebook.livephotos.exoplayer.ParserException;
            r1 = "Unexpected MIME type.";
            r0.<init>(r1);
            throw r0;
        L_0x0336:
            r8 = r0;
            r3 = r2;
            goto L_0x0137;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.livephotos.exoplayer.extractor.webm.WebmExtractor.Track.a(com.facebook.livephotos.exoplayer.extractor.ExtractorSampleSource, int, long):void");
        }

        private static List<byte[]> m9225a(ParsableByteArray parsableByteArray) {
            try {
                parsableByteArray.m9339c(16);
                long l = parsableByteArray.m9348l();
                if (l != 826496599) {
                    throw new ParserException("Unsupported FourCC compression type: " + l);
                }
                int d = parsableByteArray.m9340d() + 20;
                byte[] bArr = parsableByteArray.f7731a;
                while (d < bArr.length - 4) {
                    if (bArr[d] == (byte) 0 && bArr[d + 1] == (byte) 0 && bArr[d + 2] == (byte) 1 && bArr[d + 3] == (byte) 15) {
                        return Collections.singletonList(Arrays.copyOfRange(bArr, d, bArr.length));
                    }
                    d++;
                }
                throw new ParserException("Failed to find FourCC VC1 initialization data");
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ParserException("Error parsing FourCC VC1 codec private");
            }
        }

        private static Pair<List<byte[]>, Integer> m9227b(ParsableByteArray parsableByteArray) {
            int i = 0;
            try {
                parsableByteArray.m9337b(4);
                int f = (parsableByteArray.m9343f() & 3) + 1;
                if (f == 3) {
                    throw new ParserException();
                }
                int i2;
                List arrayList = new ArrayList();
                int f2 = parsableByteArray.m9343f() & 31;
                for (i2 = 0; i2 < f2; i2++) {
                    arrayList.add(NalUnitUtil.m9317a(parsableByteArray));
                }
                i2 = parsableByteArray.m9343f();
                while (i < i2) {
                    arrayList.add(NalUnitUtil.m9317a(parsableByteArray));
                    i++;
                }
                return Pair.create(arrayList, Integer.valueOf(f));
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ParserException("Error parsing AVC codec private");
            }
        }

        private static Pair<List<byte[]>, Integer> m9228c(ParsableByteArray parsableByteArray) {
            try {
                int g;
                int i;
                int i2;
                parsableByteArray.m9337b(21);
                int f = parsableByteArray.m9343f() & 3;
                int f2 = parsableByteArray.m9343f();
                int d = parsableByteArray.m9340d();
                int i3 = 0;
                int i4 = 0;
                while (i3 < f2) {
                    parsableByteArray.m9339c(1);
                    g = parsableByteArray.m9344g();
                    i = i4;
                    for (i2 = 0; i2 < g; i2++) {
                        i4 = parsableByteArray.m9344g();
                        i += i4 + 4;
                        parsableByteArray.m9339c(i4);
                    }
                    i3++;
                    i4 = i;
                }
                parsableByteArray.m9337b(d);
                Object obj = new byte[i4];
                i3 = 0;
                i2 = 0;
                while (i3 < f2) {
                    parsableByteArray.m9339c(1);
                    g = parsableByteArray.m9344g();
                    i = i2;
                    for (i2 = 0; i2 < g; i2++) {
                        int g2 = parsableByteArray.m9344g();
                        System.arraycopy(NalUnitUtil.f7723a, 0, obj, i, NalUnitUtil.f7723a.length);
                        i += NalUnitUtil.f7723a.length;
                        System.arraycopy(parsableByteArray.f7731a, parsableByteArray.m9340d(), obj, i, g2);
                        i += g2;
                        parsableByteArray.m9339c(g2);
                    }
                    i3++;
                    i2 = i;
                }
                return Pair.create(i4 == 0 ? null : Collections.singletonList(obj), Integer.valueOf(f + 1));
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ParserException("Error parsing HEVC codec private");
            }
        }

        private static List<byte[]> m9226a(byte[] bArr) {
            int i = 0;
            try {
                if (bArr[0] != (byte) 2) {
                    throw new ParserException("Error parsing vorbis codec private");
                }
                int i2 = 0;
                int i3 = 1;
                while (bArr[i3] == (byte) -1) {
                    i3++;
                    i2 += 255;
                }
                int i4 = i3 + 1;
                i2 += bArr[i3];
                while (bArr[i4] == (byte) -1) {
                    i += 255;
                    i4++;
                }
                i3 = i4 + 1;
                i += bArr[i4];
                if (bArr[i3] != (byte) 1) {
                    throw new ParserException("Error parsing vorbis codec private");
                }
                Object obj = new byte[i2];
                System.arraycopy(bArr, i3, obj, 0, i2);
                i2 += i3;
                if (bArr[i2] != (byte) 3) {
                    throw new ParserException("Error parsing vorbis codec private");
                }
                i += i2;
                if (bArr[i] != (byte) 5) {
                    throw new ParserException("Error parsing vorbis codec private");
                }
                Object obj2 = new byte[(bArr.length - i)];
                System.arraycopy(bArr, i, obj2, 0, bArr.length - i);
                List<byte[]> arrayList = new ArrayList(2);
                arrayList.add(obj);
                arrayList.add(obj2);
                return arrayList;
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ParserException("Error parsing vorbis codec private");
            }
        }

        private static boolean m9229d(ParsableByteArray parsableByteArray) {
            try {
                int h = parsableByteArray.m9345h();
                if (h == 1) {
                    return true;
                }
                if (h != 65534) {
                    return false;
                }
                parsableByteArray.m9337b(24);
                if (parsableByteArray.m9351o() == WebmExtractor.f7569c.getMostSignificantBits() && parsableByteArray.m9351o() == WebmExtractor.f7569c.getLeastSignificantBits()) {
                    return true;
                }
                return false;
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ParserException("Error parsing MS/ACM codec private");
            }
        }
    }

    public WebmExtractor() {
        this(new DefaultEbmlReader());
    }

    private WebmExtractor(DefaultEbmlReader defaultEbmlReader) {
        this.f7600n = -1;
        this.f7601o = -1;
        this.f7602p = -1;
        this.f7603q = -1;
        this.f7604r = -1;
        this.f7611y = -1;
        this.f7612z = -1;
        this.f7570A = -1;
        this.f7590d = defaultEbmlReader;
        this.f7590d.f7535d = new InnerEbmlReaderOutput(this);
        this.f7591e = new VarintReader();
        this.f7592f = new SparseArray();
        this.f7595i = new ParsableByteArray(4);
        this.f7596j = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
        this.f7597k = new ParsableByteArray(4);
        this.f7593g = new ParsableByteArray(NalUnitUtil.f7723a);
        this.f7594h = new ParsableByteArray(4);
        this.f7598l = new ParsableByteArray();
        this.f7599m = new ParsableByteArray();
    }

    public final boolean mo429a(DefaultExtractorInput defaultExtractorInput) {
        return new Sniffer().m9217a(defaultExtractorInput);
    }

    public final void mo428a(ExtractorSampleSource extractorSampleSource) {
        this.f7589T = extractorSampleSource;
    }

    public final void mo430b() {
        this.f7570A = -1;
        this.f7574E = 0;
        DefaultEbmlReader defaultEbmlReader = this.f7590d;
        defaultEbmlReader.f7536e = 0;
        defaultEbmlReader.f7533b.clear();
        defaultEbmlReader.f7534c.m9221a();
        this.f7591e.m9221a();
        m9240c();
    }

    public final int mo427a(DefaultExtractorInput defaultExtractorInput, PositionHolder positionHolder) {
        this.f7587R = false;
        boolean z = true;
        while (z && !this.f7587R) {
            z = this.f7590d.m9215a(defaultExtractorInput);
            if (z && m9238a(positionHolder, defaultExtractorInput.f6964d)) {
                return 1;
            }
        }
        return z ? 0 : -1;
    }

    final void m9245a(int i, long j, long j2) {
        switch (i) {
            case 160:
                this.f7588S = false;
                return;
            case 174:
                this.f7605s = new Track();
                return;
            case 187:
                this.f7573D = false;
                return;
            case 19899:
                this.f7608v = -1;
                this.f7609w = -1;
                return;
            case 20533:
                this.f7605s.f7550e = true;
                return;
            case 408125543:
                if (this.f7600n == -1 || this.f7600n == j) {
                    this.f7600n = j;
                    this.f7601o = j2;
                    return;
                }
                throw new ParserException("Multiple Segment elements not supported");
            case 475249515:
                this.f7571B = new LongArray();
                this.f7572C = new LongArray();
                return;
            case 524531317:
                if (!this.f7607u) {
                    if (this.f7611y != -1) {
                        this.f7610x = true;
                        return;
                    }
                    this.f7589T.f7011m = SeekMap.f6955f;
                    this.f7607u = true;
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void m9250c(int i) {
        switch (i) {
            case 160:
                if (this.f7574E == 2) {
                    if (!this.f7588S) {
                        this.f7582M |= 1;
                    }
                    m9237a((Track) this.f7592f.get(this.f7580K), this.f7575F);
                    this.f7574E = 0;
                    return;
                }
                return;
            case 174:
                if (this.f7592f.get(this.f7605s.f7547b) == null) {
                    Object obj;
                    String str = this.f7605s.f7546a;
                    if ("V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str)) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        this.f7605s.m9230a(this.f7589T, this.f7605s.f7547b, this.f7604r);
                        this.f7592f.put(this.f7605s.f7547b, this.f7605s);
                    }
                }
                this.f7605s = null;
                return;
            case 19899:
                if (this.f7608v == -1 || this.f7609w == -1) {
                    throw new ParserException("Mandatory element SeekID or SeekPosition not found");
                } else if (this.f7608v == 475249515) {
                    this.f7611y = this.f7609w;
                    return;
                } else {
                    return;
                }
            case 25152:
                if (!this.f7605s.f7550e) {
                    return;
                }
                if (this.f7605s.f7552g == null) {
                    throw new ParserException("Encrypted Track found but ContentEncKeyID was not found");
                } else if (!this.f7606t) {
                    this.f7589T.f7012n = new Universal(new SchemeInitData("video/webm", this.f7605s.f7552g));
                    this.f7606t = true;
                    return;
                } else {
                    return;
                }
            case 28032:
                if (this.f7605s.f7550e && this.f7605s.f7551f != null) {
                    throw new ParserException("Combining encryption and compression is not supported");
                }
                return;
            case 357149030:
                if (this.f7602p == -1) {
                    this.f7602p = 1000000;
                }
                if (this.f7603q != -1) {
                    this.f7604r = m9232a(this.f7603q);
                    return;
                }
                return;
            case 374648427:
                if (this.f7592f.size() == 0) {
                    throw new ParserException("No valid tracks were found");
                }
                this.f7589T.m8895g();
                return;
            case 475249515:
                if (!this.f7607u) {
                    this.f7589T.f7011m = m9241d();
                    this.f7607u = true;
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void m9244a(int i, long j) {
        switch (i) {
            case 131:
                this.f7605s.f7548c = (int) j;
                return;
            case 155:
                this.f7576G = m9232a(j);
                return;
            case 159:
                this.f7605s.f7559n = (int) j;
                return;
            case 176:
                this.f7605s.f7554i = (int) j;
                return;
            case 179:
                this.f7571B.m9303a(m9232a(j));
                return;
            case 186:
                this.f7605s.f7555j = (int) j;
                return;
            case 215:
                this.f7605s.f7547b = (int) j;
                return;
            case 231:
                this.f7570A = m9232a(j);
                return;
            case 241:
                if (!this.f7573D) {
                    this.f7572C.m9303a(j);
                    this.f7573D = true;
                    return;
                }
                return;
            case 251:
                this.f7588S = true;
                return;
            case 16980:
                if (j != 3) {
                    throw new ParserException("ContentCompAlgo " + j + " not supported");
                }
                return;
            case 17029:
                if (j < 1 || j > 2) {
                    throw new ParserException("DocTypeReadVersion " + j + " not supported");
                }
                return;
            case 17143:
                if (j != 1) {
                    throw new ParserException("EBMLReadVersion " + j + " not supported");
                }
                return;
            case 18401:
                if (j != 5) {
                    throw new ParserException("ContentEncAlgo " + j + " not supported");
                }
                return;
            case 18408:
                if (j != 1) {
                    throw new ParserException("AESSettingsCipherMode " + j + " not supported");
                }
                return;
            case 20529:
                if (j != 0) {
                    throw new ParserException("ContentEncodingOrder " + j + " not supported");
                }
                return;
            case 20530:
                if (j != 1) {
                    throw new ParserException("ContentEncodingScope " + j + " not supported");
                }
                return;
            case 21420:
                this.f7609w = this.f7600n + j;
                return;
            case 21680:
                this.f7605s.f7556k = (int) j;
                return;
            case 21682:
                this.f7605s.f7558m = (int) j;
                return;
            case 21690:
                this.f7605s.f7557l = (int) j;
                return;
            case 22186:
                this.f7605s.f7562q = j;
                return;
            case 22203:
                this.f7605s.f7563r = j;
                return;
            case 25188:
                this.f7605s.f7560o = (int) j;
                return;
            case 2352003:
                this.f7605s.f7549d = (int) j;
                return;
            case 2807729:
                this.f7602p = j;
                return;
            default:
                return;
        }
    }

    public final void m9246a(int i, String str) {
        switch (i) {
            case 134:
                this.f7605s.f7546a = str;
                return;
            case 17026:
                if (!"webm".equals(str) && !"matroska".equals(str)) {
                    throw new ParserException("DocType " + str + " not supported");
                }
                return;
            case 2274716:
                this.f7605s.f7566u = str;
                return;
            default:
                return;
        }
    }

    public final void m9243a(int i, int i2, DefaultExtractorInput defaultExtractorInput) {
        switch (i) {
            case 161:
            case 163:
                if (this.f7574E == 0) {
                    this.f7580K = (int) this.f7591e.m9220a(defaultExtractorInput, false, true, 8);
                    this.f7581L = this.f7591e.m9222b();
                    this.f7576G = -1;
                    this.f7574E = 1;
                    this.f7595i.m9331a();
                }
                Track track = (Track) this.f7592f.get(this.f7580K);
                if (track == null) {
                    defaultExtractorInput.m8841b(i2 - this.f7581L);
                    this.f7574E = 0;
                    return;
                }
                if (this.f7574E == 1) {
                    int i3;
                    m9233a(defaultExtractorInput, 3);
                    int i4 = (this.f7595i.f7731a[2] & 6) >> 1;
                    if (i4 == 0) {
                        this.f7578I = 1;
                        this.f7579J = m9239a(this.f7579J, 1);
                        this.f7579J[0] = (i2 - this.f7581L) - 3;
                    } else if (i != 163) {
                        throw new ParserException("Lacing only supported in SimpleBlocks.");
                    } else {
                        m9233a(defaultExtractorInput, 4);
                        this.f7578I = (this.f7595i.f7731a[3] & 255) + 1;
                        this.f7579J = m9239a(this.f7579J, this.f7578I);
                        if (i4 == 2) {
                            Arrays.fill(this.f7579J, 0, this.f7578I, ((i2 - this.f7581L) - 4) / this.f7578I);
                        } else if (i4 == 1) {
                            r5 = 0;
                            i3 = 4;
                            for (i4 = 0; i4 < this.f7578I - 1; i4++) {
                                this.f7579J[i4] = 0;
                                do {
                                    i3++;
                                    m9233a(defaultExtractorInput, i3);
                                    r6 = this.f7595i.f7731a[i3 - 1] & 255;
                                    r7 = this.f7579J;
                                    r7[i4] = r7[i4] + r6;
                                } while (r6 == 255);
                                r5 += this.f7579J[i4];
                            }
                            this.f7579J[this.f7578I - 1] = ((i2 - this.f7581L) - i3) - r5;
                        } else if (i4 == 3) {
                            r5 = 0;
                            i3 = 4;
                            i4 = 0;
                            while (i4 < this.f7578I - 1) {
                                this.f7579J[i4] = 0;
                                i3++;
                                m9233a(defaultExtractorInput, i3);
                                if (this.f7595i.f7731a[i3 - 1] == (byte) 0) {
                                    throw new ParserException("No valid varint length mask found");
                                }
                                long j = 0;
                                int i5 = 0;
                                while (i5 < 8) {
                                    int i6 = 1 << (7 - i5);
                                    if ((this.f7595i.f7731a[i3 - 1] & i6) != 0) {
                                        int i7 = i3 - 1;
                                        i3 += i5;
                                        m9233a(defaultExtractorInput, i3);
                                        j = (long) ((this.f7595i.f7731a[i7] & 255) & (i6 ^ -1));
                                        for (i6 = i7 + 1; i6 < i3; i6++) {
                                            j = ((long) (this.f7595i.f7731a[i6] & 255)) | (j << 8);
                                        }
                                        if (i4 > 0) {
                                            j -= (1 << ((i5 * 7) + 6)) - 1;
                                        }
                                        if (j >= -2147483648L || j > 2147483647L) {
                                            throw new ParserException("EBML lacing sample size out of range.");
                                        }
                                        r6 = (int) j;
                                        r7 = this.f7579J;
                                        if (i4 != 0) {
                                            r6 += this.f7579J[i4 - 1];
                                        }
                                        r7[i4] = r6;
                                        r5 += this.f7579J[i4];
                                        i4++;
                                    } else {
                                        i5++;
                                    }
                                }
                                if (j >= -2147483648L) {
                                    break;
                                }
                                throw new ParserException("EBML lacing sample size out of range.");
                            }
                            this.f7579J[this.f7578I - 1] = ((i2 - this.f7581L) - i3) - r5;
                        } else {
                            throw new ParserException("Unexpected lacing value: " + i4);
                        }
                    }
                    this.f7575F = this.f7570A + m9232a((long) ((this.f7595i.f7731a[0] << 8) | (this.f7595i.f7731a[1] & 255)));
                    Object obj = (this.f7595i.f7731a[2] & 8) == 8 ? 1 : null;
                    Object obj2 = (track.f7548c == 2 || (i == 163 && (this.f7595i.f7731a[2] & 128) == 128)) ? 1 : null;
                    i3 = obj2 != null ? 1 : 0;
                    if (obj != null) {
                        i4 = 134217728;
                    } else {
                        i4 = 0;
                    }
                    this.f7582M = i4 | i3;
                    this.f7574E = 2;
                    this.f7577H = 0;
                }
                if (i == 163) {
                    while (this.f7577H < this.f7578I) {
                        m9234a(defaultExtractorInput, track, this.f7579J[this.f7577H]);
                        m9237a(track, this.f7575F + ((long) ((this.f7577H * track.f7549d) / 1000)));
                        this.f7577H++;
                    }
                    this.f7574E = 0;
                    return;
                }
                m9234a(defaultExtractorInput, track, this.f7579J[0]);
                return;
            case 16981:
                this.f7605s.f7551f = new byte[i2];
                defaultExtractorInput.m8842b(this.f7605s.f7551f, 0, i2);
                return;
            case 18402:
                this.f7605s.f7552g = new byte[i2];
                defaultExtractorInput.m8842b(this.f7605s.f7552g, 0, i2);
                return;
            case 21419:
                Arrays.fill(this.f7597k.f7731a, (byte) 0);
                defaultExtractorInput.m8842b(this.f7597k.f7731a, 4 - i2, i2);
                this.f7597k.m9337b(0);
                this.f7608v = (int) this.f7597k.m9347k();
                return;
            case 25506:
                this.f7605s.f7553h = new byte[i2];
                defaultExtractorInput.m8842b(this.f7605s.f7553h, 0, i2);
                return;
            default:
                throw new ParserException("Unexpected id: " + i);
        }
    }

    private void m9237a(Track track, long j) {
        if ("S_TEXT/UTF8".equals(track.f7546a)) {
            m9236a(track);
        }
        track.f7564s.mo409a(j, this.f7582M, this.f7586Q, 0, track.f7552g);
        this.f7587R = true;
        m9240c();
    }

    private void m9240c() {
        this.f7583N = 0;
        this.f7586Q = 0;
        this.f7585P = 0;
        this.f7584O = false;
        this.f7598l.m9331a();
    }

    private void m9233a(DefaultExtractorInput defaultExtractorInput, int i) {
        if (this.f7595i.f7733c < i) {
            if (this.f7595i.m9342e() < i) {
                this.f7595i.m9334a(Arrays.copyOf(this.f7595i.f7731a, Math.max(this.f7595i.f7731a.length * 2, i)), this.f7595i.f7733c);
            }
            defaultExtractorInput.m8842b(this.f7595i.f7731a, this.f7595i.f7733c, i - this.f7595i.f7733c);
            this.f7595i.m9332a(i);
        }
    }

    private void m9234a(DefaultExtractorInput defaultExtractorInput, Track track, int i) {
        if ("S_TEXT/UTF8".equals(track.f7546a)) {
            int length = f7567a.length + i;
            if (this.f7599m.m9342e() < length) {
                this.f7599m.f7731a = Arrays.copyOf(f7567a, length + i);
            }
            defaultExtractorInput.m8842b(this.f7599m.f7731a, f7567a.length, i);
            this.f7599m.m9337b(0);
            this.f7599m.m9332a(length);
            return;
        }
        TrackOutput trackOutput = track.f7564s;
        if (!this.f7584O) {
            if (track.f7550e) {
                this.f7582M &= -3;
                defaultExtractorInput.m8842b(this.f7595i.f7731a, 0, 1);
                this.f7583N++;
                if ((this.f7595i.f7731a[0] & 128) == 128) {
                    throw new ParserException("Extension bit is set in signal byte");
                } else if ((this.f7595i.f7731a[0] & 1) == 1) {
                    this.f7595i.f7731a[0] = (byte) 8;
                    this.f7595i.m9337b(0);
                    trackOutput.mo411a(this.f7595i, 1);
                    this.f7586Q++;
                    this.f7582M |= 2;
                }
            } else if (track.f7551f != null) {
                this.f7598l.m9334a(track.f7551f, track.f7551f.length);
            }
            this.f7584O = true;
        }
        int i2 = this.f7598l.f7733c + i;
        if ("V_MPEG4/ISO/AVC".equals(track.f7546a) || "V_MPEGH/ISO/HEVC".equals(track.f7546a)) {
            byte[] bArr = this.f7594h.f7731a;
            bArr[0] = (byte) 0;
            bArr[1] = (byte) 0;
            bArr[2] = (byte) 0;
            int i3 = track.f7565t;
            int i4 = 4 - track.f7565t;
            while (this.f7583N < i2) {
                if (this.f7585P == 0) {
                    m9235a(defaultExtractorInput, bArr, i4, i3);
                    this.f7594h.m9337b(0);
                    this.f7585P = this.f7594h.m9355s();
                    this.f7593g.m9337b(0);
                    trackOutput.mo411a(this.f7593g, 4);
                    this.f7586Q += 4;
                } else {
                    this.f7585P -= m9231a(defaultExtractorInput, trackOutput, this.f7585P);
                }
            }
        } else {
            while (this.f7583N < i2) {
                m9231a(defaultExtractorInput, trackOutput, i2 - this.f7583N);
            }
        }
        if ("A_VORBIS".equals(track.f7546a)) {
            this.f7596j.m9337b(0);
            trackOutput.mo411a(this.f7596j, 4);
            this.f7586Q += 4;
        }
    }

    private void m9236a(Track track) {
        Object obj;
        Object obj2 = this.f7599m.f7731a;
        long j = this.f7576G;
        if (j == -1) {
            obj = f7568b;
        } else {
            long j2 = j - (((long) ((int) (j / 3600000000L))) * 3600000000L);
            j2 -= (long) (60000000 * ((int) (j2 / 60000000)));
            int i = (int) ((j2 - ((long) (1000000 * ((int) (j2 / 1000000))))) / 1000);
            obj = String.format(Locale.US, "%02d:%02d:%02d,%03d", new Object[]{Integer.valueOf((int) (j / 3600000000L)), Integer.valueOf(r5), Integer.valueOf(r8), Integer.valueOf(i)}).getBytes();
        }
        System.arraycopy(obj, 0, obj2, 19, 12);
        track.f7564s.mo411a(this.f7599m, this.f7599m.f7733c);
        this.f7586Q += this.f7599m.f7733c;
    }

    private void m9235a(DefaultExtractorInput defaultExtractorInput, byte[] bArr, int i, int i2) {
        int min = Math.min(i2, this.f7598l.m9336b());
        defaultExtractorInput.m8842b(bArr, i + min, i2 - min);
        if (min > 0) {
            this.f7598l.m9335a(bArr, i, min);
        }
        this.f7583N += i2;
    }

    private int m9231a(DefaultExtractorInput defaultExtractorInput, TrackOutput trackOutput, int i) {
        int b = this.f7598l.m9336b();
        if (b > 0) {
            b = Math.min(i, b);
            trackOutput.mo411a(this.f7598l, b);
        } else {
            b = trackOutput.mo408a(defaultExtractorInput, i, false);
        }
        this.f7583N += b;
        this.f7586Q += b;
        return b;
    }

    private SeekMap m9241d() {
        int i = 0;
        if (this.f7600n == -1 || this.f7604r == -1 || this.f7571B == null || this.f7571B.f7694a == 0 || this.f7572C == null || this.f7572C.f7694a != this.f7571B.f7694a) {
            this.f7571B = null;
            this.f7572C = null;
            return SeekMap.f6955f;
        }
        int i2 = this.f7571B.f7694a;
        int[] iArr = new int[i2];
        long[] jArr = new long[i2];
        long[] jArr2 = new long[i2];
        long[] jArr3 = new long[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            jArr3[i3] = this.f7571B.m9302a(i3);
            jArr[i3] = this.f7600n + this.f7572C.m9302a(i3);
        }
        while (i < i2 - 1) {
            iArr[i] = (int) (jArr[i + 1] - jArr[i]);
            jArr2[i] = jArr3[i + 1] - jArr3[i];
            i++;
        }
        iArr[i2 - 1] = (int) ((this.f7600n + this.f7601o) - jArr[i2 - 1]);
        jArr2[i2 - 1] = this.f7604r - jArr3[i2 - 1];
        this.f7571B = null;
        this.f7572C = null;
        return new ChunkIndex(iArr, jArr, jArr2, jArr3);
    }

    private boolean m9238a(PositionHolder positionHolder, long j) {
        if (this.f7610x) {
            this.f7612z = j;
            positionHolder.f7028a = this.f7611y;
            this.f7610x = false;
            return true;
        } else if (!this.f7607u || this.f7612z == -1) {
            return false;
        } else {
            positionHolder.f7028a = this.f7612z;
            this.f7612z = -1;
            return true;
        }
    }

    private long m9232a(long j) {
        if (this.f7602p == -1) {
            throw new ParserException("Can't scale timecode prior to timecodeScale being set.");
        }
        return Util.m9362a(j, this.f7602p, 1000);
    }

    private static int[] m9239a(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        return iArr.length < i ? new int[Math.max(iArr.length * 2, i)] : iArr;
    }
}
