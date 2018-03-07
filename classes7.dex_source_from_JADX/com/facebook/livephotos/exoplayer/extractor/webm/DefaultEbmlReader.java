package com.facebook.livephotos.exoplayer.extractor.webm;

import com.facebook.livephotos.exoplayer.ParserException;
import com.facebook.livephotos.exoplayer.extractor.DefaultExtractorInput;
import com.facebook.livephotos.exoplayer.extractor.webm.WebmExtractor.InnerEbmlReaderOutput;
import com.facebook.livephotos.exoplayer.util.Assertions;
import java.util.Stack;

/* compiled from: pageX */
public final class DefaultEbmlReader {
    private final byte[] f7532a = new byte[8];
    public final Stack<MasterElement> f7533b = new Stack();
    public final VarintReader f7534c = new VarintReader();
    public InnerEbmlReaderOutput f7535d;
    public int f7536e;
    private int f7537f;
    private long f7538g;

    /* compiled from: pageX */
    final class MasterElement {
        public final int f7530a;
        public final long f7531b;

        public MasterElement(int i, long j) {
            this.f7530a = i;
            this.f7531b = j;
        }
    }

    DefaultEbmlReader() {
    }

    public final boolean m9215a(DefaultExtractorInput defaultExtractorInput) {
        Assertions.m9297b(this.f7535d != null);
        while (true) {
            if (this.f7533b.isEmpty() || defaultExtractorInput.f6964d < ((MasterElement) this.f7533b.peek()).f7531b) {
                int i;
                if (this.f7536e == 0) {
                    long a = this.f7534c.m9220a(defaultExtractorInput, true, false, 4);
                    if (a == -2) {
                        a = m9214b(defaultExtractorInput);
                    }
                    if (a == -1) {
                        return false;
                    }
                    this.f7537f = (int) a;
                    this.f7536e = 1;
                }
                if (this.f7536e == 1) {
                    this.f7538g = this.f7534c.m9220a(defaultExtractorInput, false, true, 8);
                    this.f7536e = 2;
                }
                InnerEbmlReaderOutput innerEbmlReaderOutput = this.f7535d;
                switch (this.f7537f) {
                    case 131:
                    case 155:
                    case 159:
                    case 176:
                    case 179:
                    case 186:
                    case 215:
                    case 231:
                    case 241:
                    case 251:
                    case 16980:
                    case 17029:
                    case 17143:
                    case 18401:
                    case 18408:
                    case 20529:
                    case 20530:
                    case 21420:
                    case 21680:
                    case 21682:
                    case 21690:
                    case 22186:
                    case 22203:
                    case 25188:
                    case 2352003:
                    case 2807729:
                        i = 2;
                        break;
                    case 134:
                    case 17026:
                    case 2274716:
                        i = 3;
                        break;
                    case 160:
                    case 174:
                    case 183:
                    case 187:
                    case 224:
                    case 225:
                    case 18407:
                    case 19899:
                    case 20532:
                    case 20533:
                    case 25152:
                    case 28032:
                    case 290298740:
                    case 357149030:
                    case 374648427:
                    case 408125543:
                    case 440786851:
                    case 475249515:
                    case 524531317:
                        i = 1;
                        break;
                    case 161:
                    case 163:
                    case 16981:
                    case 18402:
                    case 21419:
                    case 25506:
                        i = 4;
                        break;
                    case 181:
                    case 17545:
                        i = 5;
                        break;
                    default:
                        i = 0;
                        break;
                }
                int i2 = i;
                switch (i2) {
                    case 0:
                        defaultExtractorInput.m8841b((int) this.f7538g);
                        this.f7536e = 0;
                    case 1:
                        long j = defaultExtractorInput.f6964d;
                        this.f7533b.add(new MasterElement(this.f7537f, this.f7538g + j));
                        this.f7535d.m9224a(this.f7537f, j, this.f7538g);
                        this.f7536e = 0;
                        return true;
                    case 2:
                        if (this.f7538g > 8) {
                            throw new ParserException("Invalid integer size: " + this.f7538g);
                        }
                        this.f7535d.f7545a.m9244a(this.f7537f, m9212a(defaultExtractorInput, (int) this.f7538g));
                        this.f7536e = 0;
                        return true;
                    case 3:
                        if (this.f7538g > 2147483647L) {
                            throw new ParserException("String element size: " + this.f7538g);
                        }
                        String str;
                        innerEbmlReaderOutput = this.f7535d;
                        int i3 = this.f7537f;
                        int i4 = (int) this.f7538g;
                        if (i4 == 0) {
                            str = "";
                        } else {
                            byte[] bArr = new byte[i4];
                            defaultExtractorInput.m8842b(bArr, 0, i4);
                            str = new String(bArr);
                        }
                        innerEbmlReaderOutput.f7545a.m9246a(i3, str);
                        this.f7536e = 0;
                        return true;
                    case 4:
                        this.f7535d.f7545a.m9243a(this.f7537f, (int) this.f7538g, defaultExtractorInput);
                        this.f7536e = 0;
                        return true;
                    case 5:
                        if (this.f7538g == 4 || this.f7538g == 8) {
                            this.f7535d.m9223a(this.f7537f, m9213b(defaultExtractorInput, (int) this.f7538g));
                            this.f7536e = 0;
                            return true;
                        }
                        throw new ParserException("Invalid float size: " + this.f7538g);
                    default:
                        throw new ParserException("Invalid element type " + i2);
                }
            }
            this.f7535d.f7545a.m9250c(((MasterElement) this.f7533b.pop()).f7530a);
            return true;
        }
    }

    private long m9214b(DefaultExtractorInput defaultExtractorInput) {
        defaultExtractorInput.m8838a();
        while (true) {
            defaultExtractorInput.m8846c(this.f7532a, 0, 4);
            int a = VarintReader.m9218a(this.f7532a[0]);
            if (a != -1 && a <= 4) {
                Object obj;
                int a2 = (int) VarintReader.m9219a(this.f7532a, a, false);
                InnerEbmlReaderOutput innerEbmlReaderOutput = this.f7535d;
                if (a2 == 357149030 || a2 == 524531317 || a2 == 475249515 || a2 == 374648427) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    defaultExtractorInput.m8841b(a);
                    return (long) a2;
                }
            }
            defaultExtractorInput.m8841b(1);
        }
    }

    private long m9212a(DefaultExtractorInput defaultExtractorInput, int i) {
        int i2 = 0;
        defaultExtractorInput.m8842b(this.f7532a, 0, i);
        long j = 0;
        while (i2 < i) {
            j = (j << 8) | ((long) (this.f7532a[i2] & 255));
            i2++;
        }
        return j;
    }

    private double m9213b(DefaultExtractorInput defaultExtractorInput, int i) {
        long a = m9212a(defaultExtractorInput, i);
        if (i == 4) {
            return (double) Float.intBitsToFloat((int) a);
        }
        return Double.longBitsToDouble(a);
    }
}
