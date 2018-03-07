package com.facebook.livephotos.exoplayer.extractor.mp4;

import android.util.Pair;
import com.facebook.livephotos.exoplayer.MediaFormat;
import com.facebook.livephotos.exoplayer.ParserException;
import com.facebook.livephotos.exoplayer.extractor.GaplessInfo;
import com.facebook.livephotos.exoplayer.extractor.mp4.Atom.ContainerAtom;
import com.facebook.livephotos.exoplayer.extractor.mp4.Atom.LeafAtom;
import com.facebook.livephotos.exoplayer.util.Ac3Util;
import com.facebook.livephotos.exoplayer.util.Assertions;
import com.facebook.livephotos.exoplayer.util.CodecSpecificDataUtil;
import com.facebook.livephotos.exoplayer.util.NalUnitUtil;
import com.facebook.livephotos.exoplayer.util.ParsableBitArray;
import com.facebook.livephotos.exoplayer.util.ParsableByteArray;
import com.facebook.livephotos.exoplayer.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: page_presence_tab_switch */
public final class AtomParsers {

    /* compiled from: page_presence_tab_switch */
    final class AvcCData {
        public final List<byte[]> f7160a;
        public final int f7161b;
        public final float f7162c;

        public AvcCData(List<byte[]> list, int i, float f) {
            this.f7160a = list;
            this.f7161b = i;
            this.f7162c = f;
        }
    }

    /* compiled from: page_presence_tab_switch */
    final class StsdData {
        public final TrackEncryptionBox[] f7163a;
        public MediaFormat f7164b;
        public int f7165c = -1;

        public StsdData(int i) {
            this.f7163a = new TrackEncryptionBox[i];
        }
    }

    /* compiled from: page_presence_tab_switch */
    final class TkhdData {
        private final int f7166a;
        private final long f7167b;
        private final int f7168c;

        public TkhdData(int i, long j, int i2) {
            this.f7166a = i;
            this.f7167b = j;
            this.f7168c = i2;
        }
    }

    public static Track m8991a(ContainerAtom containerAtom, LeafAtom leafAtom, boolean z) {
        ContainerAtom e = containerAtom.m8982e(Atom.f7109B);
        int e2 = m9002e(e.m8981d(Atom.f7122O).aA);
        if (e2 != Track.f7222b && e2 != Track.f7221a && e2 != Track.f7223c && e2 != Track.f7224d && e2 != Track.f7225e) {
            return null;
        }
        long j;
        TkhdData d = m9001d(containerAtom.m8981d(Atom.f7118K).aA);
        long a = d.f7167b;
        long c = m8999c(leafAtom.aA);
        if (a == -1) {
            j = -1;
        } else {
            j = Util.m9362a(a, 1000000, c);
        }
        ContainerAtom e3 = e.m8982e(Atom.f7110C).m8982e(Atom.f7111D);
        Pair f = m9003f(e.m8981d(Atom.f7121N).aA);
        StsdData a2 = m8990a(e3.m8981d(Atom.f7123P).aA, d.f7166a, j, d.f7168c, (String) f.second, z);
        Pair a3 = m8986a(containerAtom.m8982e(Atom.f7119L));
        if (a2.f7164b == null) {
            return null;
        }
        return new Track(d.f7166a, e2, ((Long) f.first).longValue(), c, j, a2.f7164b, a2.f7163a, a2.f7165c, (long[]) a3.first, (long[]) a3.second);
    }

    public static TrackSampleTable m8993a(Track track, ContainerAtom containerAtom) {
        ParsableByteArray parsableByteArray;
        ParsableByteArray parsableByteArray2 = containerAtom.m8981d(Atom.ak).aA;
        Atom d = containerAtom.m8981d(Atom.al);
        if (d == null) {
            d = containerAtom.m8981d(Atom.am);
        }
        ParsableByteArray parsableByteArray3 = d.aA;
        ParsableByteArray parsableByteArray4 = containerAtom.m8981d(Atom.aj).aA;
        ParsableByteArray parsableByteArray5 = containerAtom.m8981d(Atom.ag).aA;
        LeafAtom d2 = containerAtom.m8981d(Atom.ah);
        ParsableByteArray parsableByteArray6 = d2 != null ? d2.aA : null;
        d2 = containerAtom.m8981d(Atom.ai);
        if (d2 != null) {
            parsableByteArray = d2.aA;
        } else {
            parsableByteArray = null;
        }
        parsableByteArray2.m9337b(12);
        int s = parsableByteArray2.m9355s();
        int s2 = parsableByteArray2.m9355s();
        Object obj = new long[s2];
        Object obj2 = new int[s2];
        long[] jArr = new long[s2];
        Object obj3 = new int[s2];
        if (s2 == 0) {
            return new TrackSampleTable(obj, obj2, 0, jArr, obj3);
        }
        long k;
        int i;
        parsableByteArray3.m9337b(12);
        int s3 = parsableByteArray3.m9355s();
        parsableByteArray4.m9337b(12);
        int s4 = parsableByteArray4.m9355s() - 1;
        Assertions.m9298b(parsableByteArray4.m9349m() == 1, "stsc first chunk must be 1");
        int s5 = parsableByteArray4.m9355s();
        parsableByteArray4.m9339c(4);
        int i2 = -1;
        if (s4 > 0) {
            i2 = parsableByteArray4.m9355s() - 1;
        }
        parsableByteArray5.m9337b(12);
        int s6 = parsableByteArray5.m9355s() - 1;
        int s7 = parsableByteArray5.m9355s();
        int s8 = parsableByteArray5.m9355s();
        int i3 = 0;
        if (parsableByteArray != null) {
            parsableByteArray.m9337b(12);
            i3 = parsableByteArray.m9355s();
        }
        int i4 = -1;
        int i5 = 0;
        if (parsableByteArray6 != null) {
            parsableByteArray6.m9337b(12);
            i5 = parsableByteArray6.m9355s();
            i4 = parsableByteArray6.m9355s() - 1;
        }
        if (d.az == Atom.al) {
            k = parsableByteArray3.m9347k();
        } else {
            k = parsableByteArray3.m9357u();
        }
        long j = 0;
        int i6 = s7;
        int i7 = s5;
        s7 = i5;
        long j2 = k;
        i5 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = s5;
        s5 = s4;
        int i11 = s6;
        s6 = i4;
        i4 = i3;
        i3 = i2;
        i2 = 0;
        int i12 = 0;
        int i13 = s8;
        s8 = i11;
        while (i12 < s2) {
            int i14;
            if (parsableByteArray != null) {
                while (i8 == 0 && i4 > 0) {
                    i8 = parsableByteArray.m9355s();
                    i5 = parsableByteArray.m9349m();
                    i4--;
                }
                i8--;
            }
            obj[i12] = j2;
            obj2[i12] = s == 0 ? parsableByteArray2.m9355s() : s;
            if (obj2[i12] > i2) {
                i2 = obj2[i12];
            }
            jArr[i12] = ((long) i5) + j;
            obj3[i12] = parsableByteArray6 == null ? 1 : null;
            if (i12 == s6) {
                obj3[i12] = 1;
                i14 = s7 - 1;
                if (i14 > 0) {
                    i = i14;
                    s4 = parsableByteArray6.m9355s() - 1;
                } else {
                    i = i14;
                    s4 = s6;
                }
            } else {
                i = s7;
                s4 = s6;
            }
            j += (long) i13;
            i14 = i6 - 1;
            if (i14 != 0 || s8 <= 0) {
                s7 = i14;
                s6 = s8;
                s8 = i13;
            } else {
                s7 = parsableByteArray5.m9355s();
                s6 = s8 - 1;
                s8 = parsableByteArray5.m9355s();
            }
            i13 = i7 - 1;
            if (i13 == 0) {
                i9++;
                if (i9 < s3) {
                    if (d.az == Atom.al) {
                        j2 = parsableByteArray3.m9347k();
                    } else {
                        j2 = parsableByteArray3.m9357u();
                    }
                }
                if (i9 == i3) {
                    i14 = parsableByteArray4.m9355s();
                    parsableByteArray4.m9339c(4);
                    i10 = s5 - 1;
                    if (i10 > 0) {
                        i3 = parsableByteArray4.m9355s() - 1;
                    }
                } else {
                    i14 = i10;
                    i10 = s5;
                }
                if (i9 < s3) {
                    i13 = i9;
                    i9 = i3;
                    i3 = i14;
                } else {
                    i11 = i13;
                    i13 = i9;
                    i9 = i3;
                    i3 = i14;
                    i14 = i11;
                }
            } else {
                j2 += (long) obj2[i12];
                i14 = i13;
                i13 = i9;
                i9 = i3;
                i3 = i10;
                i10 = s5;
            }
            i12++;
            i6 = s7;
            i7 = i14;
            s7 = i;
            s5 = i10;
            i10 = i3;
            i3 = i9;
            i9 = i13;
            i13 = s8;
            s8 = s6;
            s6 = s4;
        }
        Assertions.m9295a(s7 == 0);
        Assertions.m9295a(i6 == 0);
        Assertions.m9295a(i7 == 0);
        Assertions.m9295a(s8 == 0);
        Assertions.m9295a(i4 == 0);
        if (track.f7233m == null) {
            Util.m9364a(jArr, 1000000, track.f7228h);
            return new TrackSampleTable(obj, obj2, i2, jArr, obj3);
        } else if (track.f7233m.length == 1 && track.f7233m[0] == 0) {
            for (r2 = 0; r2 < jArr.length; r2++) {
                jArr[r2] = Util.m9362a(jArr[r2] - track.f7234n[0], 1000000, track.f7228h);
            }
            return new TrackSampleTable(obj, obj2, i2, jArr, obj3);
        } else {
            long j3;
            long a;
            Object obj4;
            Object obj5;
            Object obj6;
            r2 = 0;
            s = 0;
            i13 = 0;
            int i15 = 0;
            while (r2 < track.f7233m.length) {
                int b;
                int i16;
                j3 = track.f7234n[r2];
                if (j3 != -1) {
                    a = Util.m9362a(track.f7233m[r2], track.f7228h, track.f7229i);
                    i4 = Util.m9366b(jArr, j3, true, true);
                    b = Util.m9366b(jArr, a + j3, true, false);
                    i5 = i15 + (b - i4);
                    if (i13 != i4) {
                        i16 = 1;
                    } else {
                        i16 = 0;
                    }
                    i16 |= s;
                } else {
                    i16 = s;
                    b = i13;
                    i5 = i15;
                }
                r2++;
                s = i16;
                i13 = b;
                i15 = i5;
            }
            s7 = s | (i15 != s2 ? 1 : 0);
            if (s7 != 0) {
                obj4 = new long[i15];
            } else {
                obj4 = obj;
            }
            if (s7 != 0) {
                obj5 = new int[i15];
            } else {
                obj5 = obj2;
            }
            if (s7 != 0) {
                i5 = 0;
            } else {
                i5 = i2;
            }
            if (s7 != 0) {
                obj6 = new int[i15];
            } else {
                obj6 = obj3;
            }
            long[] jArr2 = new long[i15];
            r2 = 0;
            s = 0;
            j3 = 0;
            i2 = i5;
            while (r2 < track.f7233m.length) {
                long j4 = track.f7234n[r2];
                a = track.f7233m[r2];
                if (j4 != -1) {
                    k = j4 + Util.m9362a(a, track.f7228h, track.f7229i);
                    i5 = Util.m9366b(jArr, j4, true, true);
                    i = Util.m9366b(jArr, k, true, false);
                    if (s7 != 0) {
                        i4 = i - i5;
                        System.arraycopy(obj, i5, obj4, s, i4);
                        System.arraycopy(obj2, i5, obj5, s, i4);
                        System.arraycopy(obj3, i5, obj6, s, i4);
                    }
                    i15 = s;
                    for (i10 = i5; i10 < i; i10++) {
                        jArr2[i15] = Util.m9362a(jArr[i10] - j4, 1000000, track.f7228h) + Util.m9362a(j3, 1000000, track.f7229i);
                        if (s7 != 0 && obj5[i15] > i2) {
                            i2 = obj2[i10];
                        }
                        i15++;
                    }
                    i5 = i2;
                    i2 = i15;
                } else {
                    i5 = i2;
                    i2 = s;
                }
                r2++;
                s = i2;
                j3 = a + j3;
                i2 = i5;
            }
            int i17 = 0;
            for (r2 = 0; r2 < obj6.length && i17 == 0; r2++) {
                i17 |= (obj6[r2] & 1) != 0 ? 1 : 0;
            }
            if (i17 != 0) {
                return new TrackSampleTable(obj4, obj5, i2, jArr2, obj6);
            }
            throw new ParserException("The edited sample sequence does not contain a sync sample.");
        }
    }

    private static int m8998c(ParsableByteArray parsableByteArray, int i, int i2) {
        int i3 = parsableByteArray.f7732b;
        while (i3 - i < i2) {
            parsableByteArray.m9337b(i3);
            int m = parsableByteArray.m9349m();
            Assertions.m9296a(m > 0, "childAtomSize should be positive");
            if (parsableByteArray.m9349m() == Atom.f7114G) {
                return i3;
            }
            i3 += m;
        }
        return -1;
    }

    public static GaplessInfo m8987a(LeafAtom leafAtom, boolean z) {
        if (z) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtom.aA;
        parsableByteArray.m9337b(8);
        while (parsableByteArray.m9336b() >= 8) {
            int m = parsableByteArray.m9349m();
            if (parsableByteArray.m9349m() == Atom.at) {
                parsableByteArray.m9337b(parsableByteArray.f7732b - 8);
                parsableByteArray.m9332a(parsableByteArray.f7732b + m);
                return m8988a(parsableByteArray);
            }
            parsableByteArray.m9339c(m - 8);
        }
        return null;
    }

    private static GaplessInfo m8988a(ParsableByteArray parsableByteArray) {
        parsableByteArray.m9339c(12);
        ParsableByteArray parsableByteArray2 = new ParsableByteArray();
        while (parsableByteArray.m9336b() >= 8) {
            int m = parsableByteArray.m9349m() - 8;
            if (parsableByteArray.m9349m() == Atom.au) {
                parsableByteArray2.m9334a(parsableByteArray.f7731a, parsableByteArray.f7732b + m);
                parsableByteArray2.m9337b(parsableByteArray.f7732b);
                GaplessInfo gaplessInfo = null;
                while (parsableByteArray2.m9336b() > 0) {
                    int m2 = parsableByteArray2.f7732b + parsableByteArray2.m9349m();
                    if (parsableByteArray2.m9349m() == Atom.ay) {
                        String str = null;
                        String str2 = null;
                        Object obj = null;
                        while (parsableByteArray2.f7732b < m2) {
                            int m3 = parsableByteArray2.m9349m() - 12;
                            int m4 = parsableByteArray2.m9349m();
                            parsableByteArray2.m9339c(4);
                            if (m4 == Atom.av) {
                                obj = parsableByteArray2.m9341d(m3);
                            } else if (m4 == Atom.aw) {
                                str2 = parsableByteArray2.m9341d(m3);
                            } else if (m4 == Atom.ax) {
                                parsableByteArray2.m9339c(4);
                                str = parsableByteArray2.m9341d(m3 - 4);
                            } else {
                                parsableByteArray2.m9339c(m3);
                            }
                        }
                        if (!(str2 == null || str == null || !"com.apple.iTunes".equals(r7))) {
                            gaplessInfo = GaplessInfo.m8898a(str2, str);
                            break;
                        }
                    }
                    parsableByteArray2.m9337b(m2);
                }
                GaplessInfo gaplessInfo2 = gaplessInfo;
                if (gaplessInfo2 != null) {
                    return gaplessInfo2;
                }
            }
            parsableByteArray.m9339c(m);
        }
        return null;
    }

    private static long m8999c(ParsableByteArray parsableByteArray) {
        int i = 8;
        parsableByteArray.m9337b(8);
        if (Atom.m8976a(parsableByteArray.m9349m()) != 0) {
            i = 16;
        }
        parsableByteArray.m9339c(i);
        return parsableByteArray.m9347k();
    }

    private static TkhdData m9001d(ParsableByteArray parsableByteArray) {
        int i;
        long j;
        int i2 = 8;
        parsableByteArray.m9337b(8);
        int a = Atom.m8976a(parsableByteArray.m9349m());
        parsableByteArray.m9339c(a == 0 ? 8 : 16);
        int m = parsableByteArray.m9349m();
        parsableByteArray.m9339c(4);
        Object obj = 1;
        int i3 = parsableByteArray.f7732b;
        if (a == 0) {
            i2 = 4;
        }
        for (i = 0; i < i2; i++) {
            if (parsableByteArray.f7731a[i3 + i] != (byte) -1) {
                obj = null;
                break;
            }
        }
        if (obj != null) {
            parsableByteArray.m9339c(i2);
            j = -1;
        } else {
            j = a == 0 ? parsableByteArray.m9347k() : parsableByteArray.m9357u();
        }
        parsableByteArray.m9339c(16);
        int m2 = parsableByteArray.m9349m();
        i = parsableByteArray.m9349m();
        parsableByteArray.m9339c(4);
        int m3 = parsableByteArray.m9349m();
        a = parsableByteArray.m9349m();
        m2 = (m2 == 0 && i == 65536 && m3 == -65536 && a == 0) ? 90 : (m2 == 0 && i == -65536 && m3 == 65536 && a == 0) ? 270 : (m2 == -65536 && i == 0 && m3 == 0 && a == -65536) ? 180 : 0;
        return new TkhdData(m, j, m2);
    }

    private static int m9002e(ParsableByteArray parsableByteArray) {
        parsableByteArray.m9337b(16);
        return parsableByteArray.m9349m();
    }

    private static Pair<Long, String> m9003f(ParsableByteArray parsableByteArray) {
        int i = 8;
        parsableByteArray.m9337b(8);
        int a = Atom.m8976a(parsableByteArray.m9349m());
        parsableByteArray.m9339c(a == 0 ? 8 : 16);
        long k = parsableByteArray.m9347k();
        if (a == 0) {
            i = 4;
        }
        parsableByteArray.m9339c(i);
        int g = parsableByteArray.m9344g();
        return Pair.create(Long.valueOf(k), ((char) (((g >> 10) & 31) + 96)) + ((char) (((g >> 5) & 31) + 96)) + ((char) ((g & 31) + 96)));
    }

    private static StsdData m8990a(ParsableByteArray parsableByteArray, int i, long j, int i2, String str, boolean z) {
        parsableByteArray.m9337b(12);
        int m = parsableByteArray.m9349m();
        StsdData stsdData = new StsdData(m);
        for (int i3 = 0; i3 < m; i3++) {
            int d = parsableByteArray.m9340d();
            int m2 = parsableByteArray.m9349m();
            Assertions.m9296a(m2 > 0, "childAtomSize should be positive");
            int m3 = parsableByteArray.m9349m();
            if (m3 == Atom.f7135b || m3 == Atom.f7136c || m3 == Atom.f7129V || m3 == Atom.af || m3 == Atom.f7137d || m3 == Atom.f7138e || m3 == Atom.f7139f) {
                m8995a(parsableByteArray, d, m2, i, j, i2, stsdData, i3);
            } else if (m3 == Atom.f7142i || m3 == Atom.f7130W || m3 == Atom.f7144k || m3 == Atom.f7146m || m3 == Atom.f7148o || m3 == Atom.f7151r || m3 == Atom.f7149p || m3 == Atom.f7150q || m3 == Atom.aq || m3 == Atom.ar) {
                m8994a(parsableByteArray, m3, d, m2, i, j, str, z, stsdData, i3);
            } else if (m3 == Atom.ad) {
                stsdData.f7164b = MediaFormat.m8742a(Integer.toString(i), "application/ttml+xml", -1, j, str);
            } else if (m3 == Atom.an) {
                stsdData.f7164b = MediaFormat.m8742a(Integer.toString(i), "application/x-quicktime-tx3g", -1, j, str);
            } else if (m3 == Atom.ao) {
                stsdData.f7164b = MediaFormat.m8742a(Integer.toString(i), "application/x-mp4vtt", -1, j, str);
            } else if (m3 == Atom.ap) {
                stsdData.f7164b = MediaFormat.m8743a(Integer.toString(i), "application/ttml+xml", -1, j, str, 0);
            }
            parsableByteArray.m9337b(d + m2);
        }
        return stsdData;
    }

    private static void m8995a(ParsableByteArray parsableByteArray, int i, int i2, int i3, long j, int i4, StsdData stsdData, int i5) {
        parsableByteArray.m9337b(i + 8);
        parsableByteArray.m9339c(24);
        int g = parsableByteArray.m9344g();
        int g2 = parsableByteArray.m9344g();
        Object obj = null;
        float f = 1.0f;
        parsableByteArray.m9339c(50);
        List list = null;
        String str = null;
        int d = parsableByteArray.m9340d();
        while (d - i < i2) {
            parsableByteArray.m9337b(d);
            int d2 = parsableByteArray.m9340d();
            int m = parsableByteArray.m9349m();
            if (m == 0 && parsableByteArray.m9340d() - i == i2) {
                break;
            }
            Object obj2;
            Assertions.m9296a(m > 0, "childAtomSize should be positive");
            int m2 = parsableByteArray.m9349m();
            if (m2 == Atom.f7112E) {
                Assertions.m9297b(str == null);
                str = "video/avc";
                AvcCData a = m8989a(parsableByteArray, d2);
                list = a.f7160a;
                stsdData.f7165c = a.f7161b;
                if (obj == null) {
                    f = a.f7162c;
                }
                obj2 = obj;
            } else if (m2 == Atom.f7113F) {
                Assertions.m9297b(str == null);
                Pair b = m8996b(parsableByteArray, d2);
                List list2 = (List) b.first;
                stsdData.f7165c = ((Integer) b.second).intValue();
                list = list2;
                obj2 = obj;
                str = "video/hevc";
            } else if (m2 == Atom.f7140g) {
                Assertions.m9297b(str == null);
                str = "video/3gpp";
                obj2 = obj;
            } else if (m2 == Atom.f7114G) {
                Assertions.m9297b(str == null);
                Pair d3 = m9000d(parsableByteArray, d2);
                String str2 = (String) d3.first;
                list = Collections.singletonList(d3.second);
                str = str2;
                obj2 = obj;
            } else if (m2 == Atom.f7125R) {
                stsdData.f7163a[i5] = m8992a(parsableByteArray, d2, m);
                obj2 = obj;
            } else if (m2 == Atom.ac) {
                f = m8997c(parsableByteArray, d2);
                obj2 = 1;
            } else {
                obj2 = obj;
            }
            d += m;
            obj = obj2;
        }
        if (str != null) {
            stsdData.f7164b = MediaFormat.m8739a(Integer.toString(i3), str, -1, -1, j, g, g2, list, i4, f);
        }
    }

    private static AvcCData m8989a(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.m9337b((i + 8) + 4);
        int f = (parsableByteArray.m9343f() & 3) + 1;
        if (f == 3) {
            throw new IllegalStateException();
        }
        int i2;
        List arrayList = new ArrayList();
        float f2 = 1.0f;
        int f3 = parsableByteArray.m9343f() & 31;
        for (i2 = 0; i2 < f3; i2++) {
            arrayList.add(NalUnitUtil.m9317a(parsableByteArray));
        }
        int f4 = parsableByteArray.m9343f();
        for (i2 = 0; i2 < f4; i2++) {
            arrayList.add(NalUnitUtil.m9317a(parsableByteArray));
        }
        if (f3 > 0) {
            ParsableBitArray parsableBitArray = new ParsableBitArray((byte[]) arrayList.get(0));
            parsableBitArray.m9322a((f + 1) * 8);
            f2 = NalUnitUtil.m9313a(parsableBitArray).f7716d;
        }
        return new AvcCData(arrayList, f, f2);
    }

    private static Pair<List<byte[]>, Integer> m8996b(ParsableByteArray parsableByteArray, int i) {
        int i2;
        parsableByteArray.m9337b((i + 8) + 21);
        int f = parsableByteArray.m9343f() & 3;
        int f2 = parsableByteArray.m9343f();
        int i3 = parsableByteArray.f7732b;
        int i4 = 0;
        int i5 = 0;
        while (i4 < f2) {
            parsableByteArray.m9339c(1);
            int g = parsableByteArray.m9344g();
            int i6 = i5;
            for (i2 = 0; i2 < g; i2++) {
                i5 = parsableByteArray.m9344g();
                i6 += i5 + 4;
                parsableByteArray.m9339c(i5);
            }
            i4++;
            i5 = i6;
        }
        parsableByteArray.m9337b(i3);
        Object obj = new byte[i5];
        i4 = 0;
        i2 = 0;
        while (i4 < f2) {
            parsableByteArray.m9339c(1);
            g = parsableByteArray.m9344g();
            i6 = i2;
            for (i2 = 0; i2 < g; i2++) {
                int g2 = parsableByteArray.m9344g();
                System.arraycopy(NalUnitUtil.f7723a, 0, obj, i6, NalUnitUtil.f7723a.length);
                i6 += NalUnitUtil.f7723a.length;
                System.arraycopy(parsableByteArray.f7731a, parsableByteArray.m9340d(), obj, i6, g2);
                i6 += g2;
                parsableByteArray.m9339c(g2);
            }
            i4++;
            i2 = i6;
        }
        return Pair.create(i5 == 0 ? null : Collections.singletonList(obj), Integer.valueOf(f + 1));
    }

    private static Pair<long[], long[]> m8986a(ContainerAtom containerAtom) {
        if (containerAtom != null) {
            LeafAtom d = containerAtom.m8981d(Atom.f7120M);
            if (d != null) {
                ParsableByteArray parsableByteArray = d.aA;
                parsableByteArray.m9337b(8);
                int a = Atom.m8976a(parsableByteArray.m9349m());
                int s = parsableByteArray.m9355s();
                Object obj = new long[s];
                Object obj2 = new long[s];
                for (int i = 0; i < s; i++) {
                    obj[i] = a == 1 ? parsableByteArray.m9357u() : parsableByteArray.m9347k();
                    obj2[i] = a == 1 ? parsableByteArray.m9351o() : (long) parsableByteArray.m9349m();
                    byte[] bArr = parsableByteArray.f7731a;
                    int i2 = parsableByteArray.f7732b;
                    parsableByteArray.f7732b = i2 + 1;
                    int i3 = (bArr[i2] & 255) << 8;
                    byte[] bArr2 = parsableByteArray.f7731a;
                    int i4 = parsableByteArray.f7732b;
                    parsableByteArray.f7732b = i4 + 1;
                    if (((short) (i3 | (bArr2[i4] & 255))) != (short) 1) {
                        throw new IllegalArgumentException("Unsupported media rate.");
                    }
                    parsableByteArray.m9339c(2);
                }
                return Pair.create(obj, obj2);
            }
        }
        return Pair.create(null, null);
    }

    private static TrackEncryptionBox m8992a(ParsableByteArray parsableByteArray, int i, int i2) {
        int i3 = i + 8;
        TrackEncryptionBox trackEncryptionBox = null;
        while (i3 - i < i2) {
            parsableByteArray.m9337b(i3);
            int m = parsableByteArray.m9349m();
            int m2 = parsableByteArray.m9349m();
            if (m2 == Atom.f7131X) {
                parsableByteArray.m9349m();
            } else if (m2 == Atom.f7126S) {
                parsableByteArray.m9339c(4);
                parsableByteArray.m9349m();
                parsableByteArray.m9349m();
            } else if (m2 == Atom.f7127T) {
                TrackEncryptionBox trackEncryptionBox2;
                boolean z = true;
                int i4 = i3 + 8;
                while (i4 - i3 < m) {
                    parsableByteArray.m9337b(i4);
                    int m3 = parsableByteArray.m9349m();
                    if (parsableByteArray.m9349m() == Atom.f7128U) {
                        parsableByteArray.m9339c(4);
                        i4 = parsableByteArray.m9349m();
                        if ((i4 >> 8) != 1) {
                            z = false;
                        }
                        i4 &= 255;
                        byte[] bArr = new byte[16];
                        parsableByteArray.m9335a(bArr, 0, 16);
                        trackEncryptionBox2 = new TrackEncryptionBox(z, i4, bArr);
                        trackEncryptionBox = trackEncryptionBox2;
                    } else {
                        i4 += m3;
                    }
                }
                trackEncryptionBox2 = null;
                trackEncryptionBox = trackEncryptionBox2;
            }
            i3 += m;
        }
        return trackEncryptionBox;
    }

    private static float m8997c(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.m9337b(i + 8);
        return ((float) parsableByteArray.m9355s()) / ((float) parsableByteArray.m9355s());
    }

    private static void m8994a(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, long j, String str, boolean z, StsdData stsdData, int i5) {
        parsableByteArray.m9337b(i2 + 8);
        int i6 = 0;
        if (z) {
            parsableByteArray.m9339c(8);
            i6 = parsableByteArray.m9344g();
            parsableByteArray.m9339c(6);
        } else {
            parsableByteArray.m9339c(16);
        }
        int g = parsableByteArray.m9344g();
        int g2 = parsableByteArray.m9344g();
        parsableByteArray.m9339c(4);
        int q = parsableByteArray.m9353q();
        if (i6 > 0) {
            parsableByteArray.m9339c(16);
            if (i6 == 2) {
                parsableByteArray.m9339c(20);
            }
        }
        String str2 = null;
        if (i == Atom.f7144k) {
            str2 = "audio/ac3";
        } else if (i == Atom.f7146m) {
            str2 = "audio/eac3";
        } else if (i == Atom.f7148o) {
            str2 = "audio/vnd.dts";
        } else if (i == Atom.f7149p || i == Atom.f7150q) {
            str2 = "audio/vnd.dts.hd";
        } else if (i == Atom.f7151r) {
            str2 = "audio/vnd.dts.hd;profile=lbr";
        } else if (i == Atom.aq) {
            str2 = "audio/3gpp";
        } else if (i == Atom.ar) {
            str2 = "audio/amr-wb";
        }
        Object obj = null;
        int d = parsableByteArray.m9340d();
        String str3 = str2;
        while (d - i2 < i3) {
            Object obj2;
            parsableByteArray.m9337b(d);
            int m = parsableByteArray.m9349m();
            Assertions.m9296a(m > 0, "childAtomSize should be positive");
            int m2 = parsableByteArray.m9349m();
            if (i == Atom.f7142i || i == Atom.f7130W) {
                i6 = -1;
                if (m2 == Atom.f7114G) {
                    i6 = d;
                } else if (z && m2 == Atom.f7143j) {
                    i6 = m8998c(parsableByteArray, d, m);
                }
                if (i6 != -1) {
                    Pair d2 = m9000d(parsableByteArray, i6);
                    str3 = (String) d2.first;
                    obj2 = (byte[]) d2.second;
                    if ("audio/mp4a-latm".equals(str3)) {
                        Pair a = CodecSpecificDataUtil.m9299a(obj2);
                        q = ((Integer) a.first).intValue();
                        g = ((Integer) a.second).intValue();
                    }
                } else {
                    if (m2 == Atom.f7125R) {
                        stsdData.f7163a[i5] = m8992a(parsableByteArray, d, m);
                    }
                    obj2 = obj;
                }
            } else if (i == Atom.f7144k && m2 == Atom.f7145l) {
                parsableByteArray.m9337b(d + 8);
                stsdData.f7164b = Ac3Util.m9289a(parsableByteArray, Integer.toString(i4), j, str);
                return;
            } else if (i == Atom.f7146m && m2 == Atom.f7147n) {
                parsableByteArray.m9337b(d + 8);
                stsdData.f7164b = Ac3Util.m9291b(parsableByteArray, Integer.toString(i4), j, str);
                return;
            } else if ((i == Atom.f7148o || i == Atom.f7151r || i == Atom.f7149p || i == Atom.f7150q) && m2 == Atom.f7152s) {
                stsdData.f7164b = MediaFormat.m8740a(Integer.toString(i4), str3, -1, -1, j, g, q, null, str);
                return;
            } else {
                obj2 = obj;
            }
            d += m;
            obj = obj2;
        }
        if (str3 != null) {
            List list;
            str2 = Integer.toString(i4);
            if (obj == null) {
                list = null;
            } else {
                list = Collections.singletonList(obj);
            }
            stsdData.f7164b = MediaFormat.m8740a(str2, str3, -1, g2, j, g, q, list, str);
        }
    }

    private static Pair<String, byte[]> m9000d(ParsableByteArray parsableByteArray, int i) {
        Object obj = null;
        parsableByteArray.m9337b((i + 8) + 4);
        parsableByteArray.m9339c(1);
        m9004g(parsableByteArray);
        parsableByteArray.m9339c(2);
        int f = parsableByteArray.m9343f();
        if ((f & 128) != 0) {
            parsableByteArray.m9339c(2);
        }
        if ((f & 64) != 0) {
            parsableByteArray.m9339c(parsableByteArray.m9344g());
        }
        if ((f & 32) != 0) {
            parsableByteArray.m9339c(2);
        }
        parsableByteArray.m9339c(1);
        m9004g(parsableByteArray);
        switch (parsableByteArray.m9343f()) {
            case 32:
                obj = "video/mp4v-es";
                break;
            case 33:
                obj = "video/avc";
                break;
            case 35:
                obj = "video/hevc";
                break;
            case 64:
            case 102:
            case 103:
            case 104:
                obj = "audio/mp4a-latm";
                break;
            case 107:
                return Pair.create("audio/mpeg", null);
            case 165:
                obj = "audio/ac3";
                break;
            case 166:
                obj = "audio/eac3";
                break;
            case 169:
            case 172:
                return Pair.create("audio/vnd.dts", null);
            case 170:
            case 171:
                return Pair.create("audio/vnd.dts.hd", null);
        }
        parsableByteArray.m9339c(12);
        parsableByteArray.m9339c(1);
        f = m9004g(parsableByteArray);
        Object obj2 = new byte[f];
        parsableByteArray.m9335a(obj2, 0, f);
        return Pair.create(obj, obj2);
    }

    private static int m9004g(ParsableByteArray parsableByteArray) {
        int f = parsableByteArray.m9343f();
        int i = f & 127;
        while ((f & 128) == 128) {
            f = parsableByteArray.m9343f();
            i = (i << 7) | (f & 127);
        }
        return i;
    }

    private AtomParsers() {
    }
}
