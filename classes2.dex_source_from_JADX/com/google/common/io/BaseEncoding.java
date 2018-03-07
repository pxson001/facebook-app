package com.google.common.io;

import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
@Beta
/* compiled from: open_fragment_as_modal */
public abstract class BaseEncoding {
    private static final BaseEncoding f10961a = new Base64Encoding("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", Character.valueOf('='));
    public static final BaseEncoding f10962b = new Base64Encoding("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", Character.valueOf('='));
    private static final BaseEncoding f10963c = new StandardBaseEncoding("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", Character.valueOf('='));
    private static final BaseEncoding f10964d = new StandardBaseEncoding("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", Character.valueOf('='));
    public static final BaseEncoding f10965e = new Base16Encoding("base16()", "0123456789ABCDEF");

    /* compiled from: open_fragment_as_modal */
    final class Base64Encoding extends StandardBaseEncoding {
        Base64Encoding(String str, String str2, @Nullable Character ch) {
            this(new Alphabet(str, str2.toCharArray()), ch);
        }

        private Base64Encoding(Alphabet alphabet, @Nullable Character ch) {
            super(alphabet, ch);
            Preconditions.checkArgument(alphabet.f10974f.length == 64);
        }

        final void mo2089a(Appendable appendable, byte[] bArr, int i, int i2) {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
            int i3 = i;
            for (int i4 = i2; i4 >= 3; i4 -= 3) {
                int i5 = i3 + 1;
                int i6 = i5 + 1;
                i5 = ((bArr[i5] & 255) << 8) | ((bArr[i3] & 255) << 16);
                i3 = i6 + 1;
                i5 |= bArr[i6] & 255;
                appendable.append(this.f10967b.m16289a(i5 >>> 18));
                appendable.append(this.f10967b.m16289a((i5 >>> 12) & 63));
                appendable.append(this.f10967b.m16289a((i5 >>> 6) & 63));
                appendable.append(this.f10967b.m16289a(i5 & 63));
            }
            if (i3 < i + i2) {
                m16287b(appendable, bArr, i3, (i + i2) - i3);
            }
        }

        final int mo2087a(byte[] bArr, CharSequence charSequence) {
            int i = 0;
            Preconditions.checkNotNull(bArr);
            CharSequence trimTrailingFrom = mo2091a().trimTrailingFrom(charSequence);
            if (this.f10967b.m16292b(trimTrailingFrom.length())) {
                int i2 = 0;
                while (i < trimTrailingFrom.length()) {
                    int i3 = i + 1;
                    int a = this.f10967b.m16290a(trimTrailingFrom.charAt(i)) << 18;
                    i = i3 + 1;
                    a |= this.f10967b.m16290a(trimTrailingFrom.charAt(i3)) << 12;
                    i3 = i2 + 1;
                    bArr[i2] = (byte) (a >>> 16);
                    if (i < trimTrailingFrom.length()) {
                        i2 = i + 1;
                        int a2 = a | (this.f10967b.m16290a(trimTrailingFrom.charAt(i)) << 6);
                        a = i3 + 1;
                        bArr[i3] = (byte) ((a2 >>> 8) & 255);
                        if (i2 < trimTrailingFrom.length()) {
                            i = i2 + 1;
                            i3 = a2 | this.f10967b.m16290a(trimTrailingFrom.charAt(i2));
                            i2 = a + 1;
                            bArr[a] = (byte) (i3 & 255);
                        } else {
                            i = i2;
                            i2 = a;
                        }
                    } else {
                        i2 = i3;
                    }
                }
                return i2;
            }
            throw new DecodingException("Invalid input length " + trimTrailingFrom.length());
        }

        final BaseEncoding mo2088a(Alphabet alphabet, @Nullable Character ch) {
            return new Base64Encoding(alphabet, ch);
        }
    }

    /* compiled from: open_fragment_as_modal */
    public class StandardBaseEncoding extends BaseEncoding {
        private transient BaseEncoding f10966a;
        final Alphabet f10967b;
        @Nullable
        final Character f10968c;

        StandardBaseEncoding(String str, String str2, @Nullable Character ch) {
            this(new Alphabet(str, str2.toCharArray()), ch);
        }

        StandardBaseEncoding(Alphabet alphabet, @Nullable Character ch) {
            boolean z;
            this.f10967b = (Alphabet) Preconditions.checkNotNull(alphabet);
            if (ch == null || !alphabet.matches(ch.charValue())) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "Padding character %s was already in alphabet", ch);
            this.f10968c = ch;
        }

        final CharMatcher mo2091a() {
            return this.f10968c == null ? CharMatcher.NONE : CharMatcher.is(this.f10968c.charValue());
        }

        final int mo2090a(int i) {
            return this.f10967b.f10971c * IntMath.m16293a(i, this.f10967b.f10972d, RoundingMode.CEILING);
        }

        void mo2089a(Appendable appendable, byte[] bArr, int i, int i2) {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
            int i3 = 0;
            while (i3 < i2) {
                m16287b(appendable, bArr, i + i3, Math.min(this.f10967b.f10972d, i2 - i3));
                i3 += this.f10967b.f10972d;
            }
        }

        final void m16287b(Appendable appendable, byte[] bArr, int i, int i2) {
            boolean z;
            int i3;
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
            if (i2 <= this.f10967b.f10972d) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z);
            long j = 0;
            for (i3 = 0; i3 < i2; i3++) {
                j = (j | ((long) (bArr[i + i3] & 255))) << 8;
            }
            int i4 = ((i2 + 1) * 8) - this.f10967b.f10970b;
            i3 = 0;
            while (i3 < i2 * 8) {
                appendable.append(this.f10967b.m16289a(((int) (j >>> (i4 - i3))) & this.f10967b.f10969a));
                i3 += this.f10967b.f10970b;
            }
            if (this.f10968c != null) {
                while (i3 < this.f10967b.f10972d * 8) {
                    appendable.append(this.f10968c.charValue());
                    i3 += this.f10967b.f10970b;
                }
            }
        }

        final int mo2092b(int i) {
            return (int) (((((long) this.f10967b.f10970b) * ((long) i)) + 7) / 8);
        }

        int mo2087a(byte[] bArr, CharSequence charSequence) {
            Preconditions.checkNotNull(bArr);
            CharSequence trimTrailingFrom = mo2091a().trimTrailingFrom(charSequence);
            if (this.f10967b.m16292b(trimTrailingFrom.length())) {
                int i = 0;
                int i2 = 0;
                while (i2 < trimTrailingFrom.length()) {
                    int i3;
                    long j = 0;
                    int i4 = 0;
                    for (i3 = 0; i3 < this.f10967b.f10971c; i3++) {
                        long j2 = j << this.f10967b.f10970b;
                        if (i2 + i3 < trimTrailingFrom.length()) {
                            i4++;
                            j = j2 | ((long) this.f10967b.m16290a(trimTrailingFrom.charAt(i4 + i2)));
                        } else {
                            j = j2;
                        }
                    }
                    int i5 = (this.f10967b.f10972d * 8) - (i4 * this.f10967b.f10970b);
                    i3 = (this.f10967b.f10972d - 1) * 8;
                    while (i3 >= i5) {
                        i4 = i + 1;
                        bArr[i] = (byte) ((int) ((j >>> i3) & 255));
                        i3 -= 8;
                        i = i4;
                    }
                    i2 += this.f10967b.f10971c;
                }
                return i;
            }
            throw new DecodingException("Invalid input length " + trimTrailingFrom.length());
        }

        public final BaseEncoding mo2093b() {
            return this.f10968c == null ? this : mo2088a(this.f10967b, null);
        }

        public final BaseEncoding mo2094c() {
            BaseEncoding baseEncoding = this.f10966a;
            if (baseEncoding == null) {
                Alphabet a = this.f10967b.m16291a();
                if (a == this.f10967b) {
                    baseEncoding = this;
                } else {
                    baseEncoding = mo2088a(a, this.f10968c);
                }
                this.f10966a = baseEncoding;
            }
            return baseEncoding;
        }

        BaseEncoding mo2088a(Alphabet alphabet, @Nullable Character ch) {
            return new StandardBaseEncoding(alphabet, ch);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("BaseEncoding.");
            stringBuilder.append(this.f10967b.toString());
            if (8 % this.f10967b.f10970b != 0) {
                if (this.f10968c == null) {
                    stringBuilder.append(".omitPadding()");
                } else {
                    stringBuilder.append(".withPadChar(").append(this.f10968c).append(')');
                }
            }
            return stringBuilder.toString();
        }
    }

    /* compiled from: open_fragment_as_modal */
    public final class Alphabet extends CharMatcher {
        final int f10969a;
        final int f10970b;
        final int f10971c;
        final int f10972d;
        private final String f10973e;
        public final char[] f10974f;
        private final byte[] f10975g;
        private final boolean[] f10976h;

        Alphabet(String str, char[] cArr) {
            int i = 0;
            this.f10973e = (String) Preconditions.checkNotNull(str);
            this.f10974f = (char[]) Preconditions.checkNotNull(cArr);
            try {
                this.f10970b = IntMath.m16294a(cArr.length, RoundingMode.UNNECESSARY);
                int min = Math.min(8, Integer.lowestOneBit(this.f10970b));
                this.f10971c = 8 / min;
                this.f10972d = this.f10970b / min;
                this.f10969a = cArr.length - 1;
                byte[] bArr = new byte[HTTPTransportCallback.BODY_BYTES_RECEIVED];
                Arrays.fill(bArr, (byte) -1);
                for (min = 0; min < cArr.length; min++) {
                    char c = cArr[min];
                    Preconditions.checkArgument(CharMatcher.ASCII.matches(c), "Non-ASCII character: %s", Character.valueOf(c));
                    Preconditions.checkArgument(bArr[c] == (byte) -1, "Duplicate character: %s", Character.valueOf(c));
                    bArr[c] = (byte) min;
                }
                this.f10975g = bArr;
                boolean[] zArr = new boolean[this.f10971c];
                while (i < this.f10972d) {
                    zArr[IntMath.m16293a(i * 8, this.f10970b, RoundingMode.CEILING)] = true;
                    i++;
                }
                this.f10976h = zArr;
            } catch (Throwable e) {
                throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e);
            }
        }

        final char m16289a(int i) {
            return this.f10974f[i];
        }

        final boolean m16292b(int i) {
            return this.f10976h[i % this.f10971c];
        }

        final int m16290a(char c) {
            if (c <= '' && this.f10975g[c] != (byte) -1) {
                return this.f10975g[c];
            }
            throw new DecodingException("Unrecognized character: " + (CharMatcher.INVISIBLE.matches(c) ? "0x" + Integer.toHexString(c) : Character.valueOf(c)));
        }

        final Alphabet m16291a() {
            int i = 0;
            Object obj = null;
            for (char isUpperCase : this.f10974f) {
                if (Ascii.isUpperCase(isUpperCase)) {
                    obj = 1;
                    break;
                }
            }
            if (obj == null) {
                return this;
            }
            boolean z;
            obj = null;
            for (char isUpperCase2 : this.f10974f) {
                Object obj2;
                if (isUpperCase2 < 'a' || isUpperCase2 > 'z') {
                    obj2 = null;
                } else {
                    obj2 = 1;
                }
                if (obj2 != null) {
                    obj = 1;
                    break;
                }
            }
            if (obj == null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "Cannot call lowerCase() on a mixed-case alphabet");
            char[] cArr = new char[this.f10974f.length];
            while (i < this.f10974f.length) {
                cArr[i] = Ascii.toLowerCase(this.f10974f[i]);
                i++;
            }
            return new Alphabet(this.f10973e + ".lowerCase()", cArr);
        }

        public final boolean matches(char c) {
            return CharMatcher.ASCII.matches(c) && this.f10975g[c] != (byte) -1;
        }

        public final String toString() {
            return this.f10973e;
        }
    }

    /* compiled from: open_fragment_as_modal */
    final class Base16Encoding extends StandardBaseEncoding {
        final char[] f10983a;

        Base16Encoding(String str, String str2) {
            this(new Alphabet(str, str2.toCharArray()));
        }

        private Base16Encoding(Alphabet alphabet) {
            boolean z;
            int i = 0;
            super(alphabet, null);
            this.f10983a = new char[512];
            if (alphabet.f10974f.length == 16) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z);
            while (i < 256) {
                this.f10983a[i] = alphabet.m16289a(i >>> 4);
                this.f10983a[i | 256] = alphabet.m16289a(i & 15);
                i++;
            }
        }

        final void mo2089a(Appendable appendable, byte[] bArr, int i, int i2) {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = bArr[i + i3] & 255;
                appendable.append(this.f10983a[i4]);
                appendable.append(this.f10983a[i4 | 256]);
            }
        }

        final int mo2087a(byte[] bArr, CharSequence charSequence) {
            int i = 0;
            Preconditions.checkNotNull(bArr);
            if (charSequence.length() % 2 == 1) {
                throw new DecodingException("Invalid input length " + charSequence.length());
            }
            int i2 = 0;
            while (i < charSequence.length()) {
                int a = this.f10967b.m16290a(charSequence.charAt(i + 1)) | (this.f10967b.m16290a(charSequence.charAt(i)) << 4);
                int i3 = i2 + 1;
                bArr[i2] = (byte) a;
                i += 2;
                i2 = i3;
            }
            return i2;
        }

        final BaseEncoding mo2088a(Alphabet alphabet, @Nullable Character ch) {
            return new Base16Encoding(alphabet);
        }
    }

    abstract int mo2090a(int i);

    abstract int mo2087a(byte[] bArr, CharSequence charSequence);

    abstract CharMatcher mo2091a();

    abstract void mo2089a(Appendable appendable, byte[] bArr, int i, int i2);

    abstract int mo2092b(int i);

    @CheckReturnValue
    public abstract BaseEncoding mo2093b();

    @CheckReturnValue
    public abstract BaseEncoding mo2094c();

    BaseEncoding() {
    }

    public final String m16271a(byte[] bArr) {
        return m16264a(bArr, 0, bArr.length);
    }

    private String m16264a(byte[] bArr, int i, int i2) {
        Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        Appendable stringBuilder = new StringBuilder(mo2090a(i2));
        try {
            mo2089a(stringBuilder, bArr, i, i2);
            return stringBuilder.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    private static byte[] m16265a(byte[] bArr, int i) {
        if (i == bArr.length) {
            return bArr;
        }
        Object obj = new byte[i];
        System.arraycopy(bArr, 0, obj, 0, i);
        return obj;
    }

    public final byte[] m16273a(CharSequence charSequence) {
        try {
            return m16266b(charSequence);
        } catch (DecodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private byte[] m16266b(CharSequence charSequence) {
        CharSequence trimTrailingFrom = mo2091a().trimTrailingFrom(charSequence);
        byte[] bArr = new byte[mo2092b(trimTrailingFrom.length())];
        return m16265a(bArr, mo2087a(bArr, trimTrailingFrom));
    }

    public static BaseEncoding m16267e() {
        return f10963c;
    }
}
