package com.facebook.livephotos.exoplayer.extractor.mp4;

import com.facebook.livephotos.exoplayer.util.ParsableByteArray;
import com.facebook.livephotos.exoplayer.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: page_profile_type */
public abstract class Atom {
    public static final int f7108A = Util.m9368c("trak");
    public static final int f7109B = Util.m9368c("mdia");
    public static final int f7110C = Util.m9368c("minf");
    public static final int f7111D = Util.m9368c("stbl");
    public static final int f7112E = Util.m9368c("avcC");
    public static final int f7113F = Util.m9368c("hvcC");
    public static final int f7114G = Util.m9368c("esds");
    public static final int f7115H = Util.m9368c("moof");
    public static final int f7116I = Util.m9368c("traf");
    public static final int f7117J = Util.m9368c("mvex");
    public static final int f7118K = Util.m9368c("tkhd");
    public static final int f7119L = Util.m9368c("edts");
    public static final int f7120M = Util.m9368c("elst");
    public static final int f7121N = Util.m9368c("mdhd");
    public static final int f7122O = Util.m9368c("hdlr");
    public static final int f7123P = Util.m9368c("stsd");
    public static final int f7124Q = Util.m9368c("pssh");
    public static final int f7125R = Util.m9368c("sinf");
    public static final int f7126S = Util.m9368c("schm");
    public static final int f7127T = Util.m9368c("schi");
    public static final int f7128U = Util.m9368c("tenc");
    public static final int f7129V = Util.m9368c("encv");
    public static final int f7130W = Util.m9368c("enca");
    public static final int f7131X = Util.m9368c("frma");
    public static final int f7132Y = Util.m9368c("saiz");
    public static final int f7133Z = Util.m9368c("saio");
    public static final int f7134a = Util.m9368c("ftyp");
    public static final int aa = Util.m9368c("uuid");
    public static final int ab = Util.m9368c("senc");
    public static final int ac = Util.m9368c("pasp");
    public static final int ad = Util.m9368c("TTML");
    public static final int ae = Util.m9368c("vmhd");
    public static final int af = Util.m9368c("mp4v");
    public static final int ag = Util.m9368c("stts");
    public static final int ah = Util.m9368c("stss");
    public static final int ai = Util.m9368c("ctts");
    public static final int aj = Util.m9368c("stsc");
    public static final int ak = Util.m9368c("stsz");
    public static final int al = Util.m9368c("stco");
    public static final int am = Util.m9368c("co64");
    public static final int an = Util.m9368c("tx3g");
    public static final int ao = Util.m9368c("wvtt");
    public static final int ap = Util.m9368c("stpp");
    public static final int aq = Util.m9368c("samr");
    public static final int ar = Util.m9368c("sawb");
    public static final int as = Util.m9368c("udta");
    public static final int at = Util.m9368c("meta");
    public static final int au = Util.m9368c("ilst");
    public static final int av = Util.m9368c("mean");
    public static final int aw = Util.m9368c("name");
    public static final int ax = Util.m9368c("data");
    public static final int ay = Util.m9368c("----");
    public static final int f7135b = Util.m9368c("avc1");
    public static final int f7136c = Util.m9368c("avc3");
    public static final int f7137d = Util.m9368c("hvc1");
    public static final int f7138e = Util.m9368c("hev1");
    public static final int f7139f = Util.m9368c("s263");
    public static final int f7140g = Util.m9368c("d263");
    public static final int f7141h = Util.m9368c("mdat");
    public static final int f7142i = Util.m9368c("mp4a");
    public static final int f7143j = Util.m9368c("wave");
    public static final int f7144k = Util.m9368c("ac-3");
    public static final int f7145l = Util.m9368c("dac3");
    public static final int f7146m = Util.m9368c("ec-3");
    public static final int f7147n = Util.m9368c("dec3");
    public static final int f7148o = Util.m9368c("dtsc");
    public static final int f7149p = Util.m9368c("dtsh");
    public static final int f7150q = Util.m9368c("dtsl");
    public static final int f7151r = Util.m9368c("dtse");
    public static final int f7152s = Util.m9368c("ddts");
    public static final int f7153t = Util.m9368c("tfdt");
    public static final int f7154u = Util.m9368c("tfhd");
    public static final int f7155v = Util.m9368c("trex");
    public static final int f7156w = Util.m9368c("trun");
    public static final int f7157x = Util.m9368c("sidx");
    public static final int f7158y = Util.m9368c("moov");
    public static final int f7159z = Util.m9368c("mvhd");
    public final int az;

    /* compiled from: page_profile_type */
    public final class ContainerAtom extends Atom {
        public final long aA;
        public final List<LeafAtom> aB = new ArrayList();
        public final List<ContainerAtom> aC = new ArrayList();

        public ContainerAtom(int i, long j) {
            super(i);
            this.aA = j;
        }

        public final void m8980a(LeafAtom leafAtom) {
            this.aB.add(leafAtom);
        }

        public final void m8979a(ContainerAtom containerAtom) {
            this.aC.add(containerAtom);
        }

        public final LeafAtom m8981d(int i) {
            int size = this.aB.size();
            for (int i2 = 0; i2 < size; i2++) {
                LeafAtom leafAtom = (LeafAtom) this.aB.get(i2);
                if (leafAtom.az == i) {
                    return leafAtom;
                }
            }
            return null;
        }

        public final ContainerAtom m8982e(int i) {
            int size = this.aC.size();
            for (int i2 = 0; i2 < size; i2++) {
                ContainerAtom containerAtom = (ContainerAtom) this.aC.get(i2);
                if (containerAtom.az == i) {
                    return containerAtom;
                }
            }
            return null;
        }

        public final String toString() {
            return Atom.m8978c(this.az) + " leaves: " + Arrays.toString(this.aB.toArray(new LeafAtom[0])) + " containers: " + Arrays.toString(this.aC.toArray(new ContainerAtom[0]));
        }
    }

    /* compiled from: page_profile_type */
    public final class LeafAtom extends Atom {
        public final ParsableByteArray aA;

        public LeafAtom(int i, ParsableByteArray parsableByteArray) {
            super(i);
            this.aA = parsableByteArray;
        }
    }

    public Atom(int i) {
        this.az = i;
    }

    public String toString() {
        return m8978c(this.az);
    }

    public static int m8976a(int i) {
        return (i >> 24) & 255;
    }

    public static int m8977b(int i) {
        return 16777215 & i;
    }

    public static String m8978c(int i) {
        return ((char) (i >> 24)) + ((char) ((i >> 16) & 255)) + ((char) ((i >> 8) & 255)) + ((char) (i & 255));
    }
}
