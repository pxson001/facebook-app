package com.google.common.base;

import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;
import javax.annotation.CheckReturnValue;

@GwtCompatible
@Beta
/* compiled from: open_flyout */
public abstract class CharMatcher implements Predicate<Character> {
    public static final CharMatcher ANY = Any.INSTANCE;
    public static final CharMatcher ASCII = Ascii.INSTANCE;
    public static final CharMatcher BREAKING_WHITESPACE = BreakingWhitespace.INSTANCE;
    public static final CharMatcher DIGIT = Digit.INSTANCE;
    public static final CharMatcher INVISIBLE = Invisible.INSTANCE;
    public static final CharMatcher JAVA_DIGIT = JavaDigit.INSTANCE;
    public static final CharMatcher JAVA_ISO_CONTROL = JavaIsoControl.INSTANCE;
    public static final CharMatcher JAVA_LETTER = JavaLetter.INSTANCE;
    public static final CharMatcher JAVA_LETTER_OR_DIGIT = JavaLetterOrDigit.INSTANCE;
    public static final CharMatcher JAVA_LOWER_CASE = JavaLowerCase.INSTANCE;
    public static final CharMatcher JAVA_UPPER_CASE = JavaUpperCase.INSTANCE;
    public static final CharMatcher NONE = None.INSTANCE;
    public static final CharMatcher SINGLE_WIDTH = SingleWidth.INSTANCE;
    public static final CharMatcher WHITESPACE = Whitespace.INSTANCE;

    @VisibleForTesting
    /* compiled from: open_flyout */
    public final class Whitespace extends NamedFastMatcher {
        public static final Whitespace INSTANCE = new Whitespace();
        static final int SHIFT = Integer.numberOfLeadingZeros(31);

        Whitespace() {
            super("CharMatcher.whitespace()");
        }

        public final boolean matches(char c) {
            return " 　\r   　 \u000b　   　 \t     \f 　 　　 \n 　".charAt((1682554634 * c) >>> SHIFT) == c;
        }
    }

    /* compiled from: open_flyout */
    abstract class NamedFastMatcher extends FastMatcher {
        private final String description;

        NamedFastMatcher(String str) {
            this.description = (String) Preconditions.checkNotNull(str);
        }

        public final String toString() {
            return this.description;
        }
    }

    /* compiled from: open_flyout */
    abstract class FastMatcher extends CharMatcher {
        FastMatcher() {
        }

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.apply((Character) obj);
        }
    }

    /* compiled from: open_flyout */
    public final class BreakingWhitespace extends CharMatcher {
        public static final CharMatcher INSTANCE = new BreakingWhitespace();

        private BreakingWhitespace() {
        }

        @Deprecated
        public final /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.apply((Character) obj);
        }

        public final boolean matches(char c) {
            switch (c) {
                case '\t':
                case '\n':
                case '\u000b':
                case '\f':
                case '\r':
                case HTTPTransportCallback.HEADER_BYTES_RECEIVED /*32*/:
                case '':
                case ' ':
                case ' ':
                case ' ':
                case ' ':
                case '　':
                    return true;
                case ' ':
                    return false;
                default:
                    if (c < ' ' || c > ' ') {
                        return false;
                    }
                    return true;
            }
        }

        public final String toString() {
            return "CharMatcher.breakingWhitespace()";
        }
    }

    /* compiled from: open_flyout */
    public final class Ascii extends NamedFastMatcher {
        public static final Ascii INSTANCE = new Ascii();

        Ascii() {
            super("CharMatcher.ascii()");
        }

        public final boolean matches(char c) {
            return c <= '';
        }
    }

    /* compiled from: open_flyout */
    public final class Digit extends RangesMatcher {
        public static final Digit INSTANCE = new Digit();

        private Digit() {
            String str = "CharMatcher.digit()";
            char[] toCharArray = "0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray();
            char[] cArr = new char[31];
            for (int i = 0; i < 31; i++) {
                cArr[i] = (char) ("0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".charAt(i) + 9);
            }
            super(str, toCharArray, cArr);
        }
    }

    /* compiled from: open_flyout */
    class RangesMatcher extends CharMatcher {
        private final String description;
        private final char[] rangeEnds;
        private final char[] rangeStarts;

        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.apply((Character) obj);
        }

        RangesMatcher(String str, char[] cArr, char[] cArr2) {
            boolean z;
            this.description = str;
            this.rangeStarts = cArr;
            this.rangeEnds = cArr2;
            if (cArr.length == cArr2.length) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z);
            for (int i = 0; i < cArr.length; i++) {
                boolean z2;
                if (cArr[i] <= cArr2[i]) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Preconditions.checkArgument(z2);
                if (i + 1 < cArr.length) {
                    if (cArr2[i] < cArr[i + 1]) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    Preconditions.checkArgument(z2);
                }
            }
        }

        public boolean matches(char c) {
            int binarySearch = Arrays.binarySearch(this.rangeStarts, c);
            if (binarySearch >= 0) {
                return true;
            }
            binarySearch = (binarySearch ^ -1) - 1;
            if (binarySearch < 0 || c > this.rangeEnds[binarySearch]) {
                return false;
            }
            return true;
        }

        public String toString() {
            return this.description;
        }
    }

    /* compiled from: open_flyout */
    public final class JavaDigit extends CharMatcher {
        public static final JavaDigit INSTANCE = new JavaDigit();

        private JavaDigit() {
        }

        @Deprecated
        public final /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.apply((Character) obj);
        }

        public final boolean matches(char c) {
            return Character.isDigit(c);
        }

        public final String toString() {
            return "CharMatcher.javaDigit()";
        }
    }

    /* compiled from: open_flyout */
    public final class JavaLetter extends CharMatcher {
        public static final JavaLetter INSTANCE = new JavaLetter();

        private JavaLetter() {
        }

        @Deprecated
        public final /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.apply((Character) obj);
        }

        public final boolean matches(char c) {
            return Character.isLetter(c);
        }

        public final String toString() {
            return "CharMatcher.javaLetter()";
        }
    }

    /* compiled from: open_flyout */
    public final class JavaLetterOrDigit extends CharMatcher {
        public static final JavaLetterOrDigit INSTANCE = new JavaLetterOrDigit();

        private JavaLetterOrDigit() {
        }

        @Deprecated
        public final /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.apply((Character) obj);
        }

        public final boolean matches(char c) {
            return Character.isLetterOrDigit(c);
        }

        public final String toString() {
            return "CharMatcher.javaLetterOrDigit()";
        }
    }

    /* compiled from: open_flyout */
    public final class JavaUpperCase extends CharMatcher {
        public static final JavaUpperCase INSTANCE = new JavaUpperCase();

        private JavaUpperCase() {
        }

        @Deprecated
        public final /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.apply((Character) obj);
        }

        public final boolean matches(char c) {
            return Character.isUpperCase(c);
        }

        public final String toString() {
            return "CharMatcher.javaUpperCase()";
        }
    }

    /* compiled from: open_flyout */
    public final class JavaLowerCase extends CharMatcher {
        public static final JavaLowerCase INSTANCE = new JavaLowerCase();

        private JavaLowerCase() {
        }

        @Deprecated
        public final /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.apply((Character) obj);
        }

        public final boolean matches(char c) {
            return Character.isLowerCase(c);
        }

        public final String toString() {
            return "CharMatcher.javaLowerCase()";
        }
    }

    /* compiled from: open_flyout */
    public final class JavaIsoControl extends NamedFastMatcher {
        public static final JavaIsoControl INSTANCE = new JavaIsoControl();

        private JavaIsoControl() {
            super("CharMatcher.javaIsoControl()");
        }

        public final boolean matches(char c) {
            return c <= '\u001f' || (c >= '' && c <= '');
        }
    }

    /* compiled from: open_flyout */
    public final class Invisible extends RangesMatcher {
        public static final Invisible INSTANCE = new Invisible();

        private Invisible() {
            super("CharMatcher.invisible()", "\u0000­؀؜۝܏ ᠎   ⁦⁧⁨⁩⁪　?﻿￹￺".toCharArray(), "  ­؄؜۝܏ ᠎‏ ⁤⁦⁧⁨⁩⁯　﻿￹￻".toCharArray());
        }
    }

    /* compiled from: open_flyout */
    public final class SingleWidth extends RangesMatcher {
        public static final SingleWidth INSTANCE = new SingleWidth();

        private SingleWidth() {
            super("CharMatcher.singleWidth()", "\u0000־א׳؀ݐ฀Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ๿₯℺﷿﻿ￜ".toCharArray());
        }
    }

    /* compiled from: open_flyout */
    public final class Any extends NamedFastMatcher {
        public static final Any INSTANCE = new Any();

        private Any() {
            super("CharMatcher.any()");
        }

        public final boolean matches(char c) {
            return true;
        }

        public final int indexIn(CharSequence charSequence) {
            return charSequence.length() == 0 ? -1 : 0;
        }

        public final int indexIn(CharSequence charSequence, int i) {
            int length = charSequence.length();
            Preconditions.checkPositionIndex(i, length);
            return i == length ? -1 : i;
        }

        public final String removeFrom(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return "";
        }

        public final String trimFrom(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return "";
        }

        public final CharMatcher or(CharMatcher charMatcher) {
            Preconditions.checkNotNull(charMatcher);
            return this;
        }
    }

    /* compiled from: open_flyout */
    public final class None extends NamedFastMatcher {
        public static final None INSTANCE = new None();

        private None() {
            super("CharMatcher.none()");
        }

        public final boolean matches(char c) {
            return false;
        }

        public final int indexIn(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return -1;
        }

        public final int indexIn(CharSequence charSequence, int i) {
            Preconditions.checkPositionIndex(i, charSequence.length());
            return -1;
        }

        public final String removeFrom(CharSequence charSequence) {
            return charSequence.toString();
        }

        public final String trimFrom(CharSequence charSequence) {
            return charSequence.toString();
        }

        public final String trimLeadingFrom(CharSequence charSequence) {
            return charSequence.toString();
        }

        public final String trimTrailingFrom(CharSequence charSequence) {
            return charSequence.toString();
        }

        public final CharMatcher or(CharMatcher charMatcher) {
            return (CharMatcher) Preconditions.checkNotNull(charMatcher);
        }
    }

    public abstract boolean matches(char c);

    public static CharMatcher is(char c) {
        return new Is(c);
    }

    public static CharMatcher anyOf(CharSequence charSequence) {
        switch (charSequence.length()) {
            case 0:
                return None.INSTANCE;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return is(charSequence.charAt(0));
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return new IsEither(charSequence.charAt(0), charSequence.charAt(1));
            default:
                return new AnyOf(charSequence);
        }
    }

    protected CharMatcher() {
    }

    public CharMatcher or(CharMatcher charMatcher) {
        return new Or(this, charMatcher);
    }

    public int indexIn(CharSequence charSequence) {
        return indexIn(charSequence, 0);
    }

    public int indexIn(CharSequence charSequence, int i) {
        int length = charSequence.length();
        Preconditions.checkPositionIndex(i, length);
        for (int i2 = i; i2 < length; i2++) {
            if (matches(charSequence.charAt(i2))) {
                return i2;
            }
        }
        return -1;
    }

    @CheckReturnValue
    public String removeFrom(CharSequence charSequence) {
        String charSequence2 = charSequence.toString();
        int indexIn = indexIn(charSequence2);
        if (indexIn == -1) {
            return charSequence2;
        }
        char[] toCharArray = charSequence2.toCharArray();
        int i = 1;
        while (true) {
            indexIn++;
            if (indexIn == toCharArray.length) {
                return new String(toCharArray, 0, indexIn - i);
            }
            if (matches(toCharArray[indexIn])) {
                i++;
            } else {
                toCharArray[indexIn - i] = toCharArray[indexIn];
            }
        }
    }

    @CheckReturnValue
    public String trimFrom(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && matches(charSequence.charAt(i))) {
            i++;
        }
        int i2 = length - 1;
        while (i2 > i && matches(charSequence.charAt(i2))) {
            i2--;
        }
        return charSequence.subSequence(i, i2 + 1).toString();
    }

    @CheckReturnValue
    public String trimLeadingFrom(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!matches(charSequence.charAt(i))) {
                return charSequence.subSequence(i, length).toString();
            }
        }
        return "";
    }

    @CheckReturnValue
    public String trimTrailingFrom(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!matches(charSequence.charAt(length))) {
                return charSequence.subSequence(0, length + 1).toString();
            }
        }
        return "";
    }

    @Deprecated
    public boolean apply(Character ch) {
        return matches(ch.charValue());
    }

    public static String showCharacter(char c) {
        String str = "0123456789ABCDEF";
        char[] cArr = new char[]{'\\', 'u', '\u0000', '\u0000', '\u0000', '\u0000'};
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = str.charAt(c & 15);
            c = (char) (c >> 4);
        }
        return String.copyValueOf(cArr);
    }
}
