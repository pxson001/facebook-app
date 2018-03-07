package android.support.v4.text;

import com.facebook.proxygen.HTTPTransportCallback;
import java.util.Locale;

/* compiled from: report_privacy_checkup_action */
public class TextDirectionHeuristicsCompat {
    public static final TextDirectionHeuristicCompat f7476a = new TextDirectionHeuristicInternal(null, false);
    public static final TextDirectionHeuristicCompat f7477b = new TextDirectionHeuristicInternal(null, true);
    public static final TextDirectionHeuristicCompat f7478c = new TextDirectionHeuristicInternal(FirstStrong.f7484a, false);
    public static final TextDirectionHeuristicCompat f7479d = new TextDirectionHeuristicInternal(FirstStrong.f7484a, true);
    public static final TextDirectionHeuristicCompat f7480e = new TextDirectionHeuristicInternal(AnyStrong.f7485a, false);
    public static final TextDirectionHeuristicCompat f7481f = TextDirectionHeuristicLocale.f7488a;

    /* compiled from: report_privacy_checkup_action */
    class TextDirectionHeuristicInternal extends TextDirectionHeuristicImpl {
        private final boolean f7482a;

        public TextDirectionHeuristicInternal(TextDirectionAlgorithm textDirectionAlgorithm, boolean z) {
            super(textDirectionAlgorithm);
            this.f7482a = z;
        }

        protected final boolean mo1669a() {
            return this.f7482a;
        }
    }

    /* compiled from: report_privacy_checkup_action */
    public abstract class TextDirectionHeuristicImpl implements TextDirectionHeuristicCompat {
        public final TextDirectionAlgorithm f7483a;

        public abstract boolean mo1669a();

        public TextDirectionHeuristicImpl(TextDirectionAlgorithm textDirectionAlgorithm) {
            this.f7483a = textDirectionAlgorithm;
        }

        public final boolean mo1670a(CharSequence charSequence, int i, int i2) {
            if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new IllegalArgumentException();
            } else if (this.f7483a == null) {
                return mo1669a();
            } else {
                boolean z;
                switch (this.f7483a.mo1671a(charSequence, i, i2)) {
                    case 0:
                        z = true;
                        break;
                    case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                        z = false;
                        break;
                    default:
                        z = mo1669a();
                        break;
                }
                return z;
            }
        }
    }

    /* compiled from: report_privacy_checkup_action */
    class FirstStrong implements TextDirectionAlgorithm {
        public static final FirstStrong f7484a = new FirstStrong();

        public final int mo1671a(CharSequence charSequence, int i, int i2) {
            int i3 = i + i2;
            int i4 = 2;
            while (i < i3 && i4 == 2) {
                int i5;
                switch (Character.getDirectionality(charSequence.charAt(i))) {
                    case (byte) 0:
                    case (byte) 14:
                    case (byte) 15:
                        i5 = 1;
                        break;
                    case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    case HTTPTransportCallback.HEADER_BYTES_GENERATED /*16*/:
                    case (byte) 17:
                        i5 = 0;
                        break;
                    default:
                        i5 = 2;
                        break;
                }
                i4 = i5;
                i++;
            }
            return i4;
        }

        private FirstStrong() {
        }
    }

    /* compiled from: report_privacy_checkup_action */
    public interface TextDirectionAlgorithm {
        int mo1671a(CharSequence charSequence, int i, int i2);
    }

    /* compiled from: report_privacy_checkup_action */
    class AnyStrong implements TextDirectionAlgorithm {
        public static final AnyStrong f7485a = new AnyStrong(true);
        public static final AnyStrong f7486b = new AnyStrong(false);
        private final boolean f7487c;

        public final int mo1671a(CharSequence charSequence, int i, int i2) {
            int i3 = i + i2;
            int i4 = 0;
            while (i < i3) {
                Object obj;
                switch (Character.getDirectionality(charSequence.charAt(i))) {
                    case (byte) 0:
                        obj = 1;
                        break;
                    case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                        obj = null;
                        break;
                    default:
                        obj = 2;
                        break;
                }
                switch (obj) {
                    case null:
                        if (!this.f7487c) {
                            i4 = 1;
                            break;
                        }
                        return 0;
                    case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                        if (this.f7487c) {
                            i4 = 1;
                            break;
                        }
                        return 1;
                    default:
                        break;
                }
                i++;
            }
            if (i4 == 0) {
                return 2;
            }
            if (this.f7487c) {
                return 1;
            }
            return 0;
        }

        private AnyStrong(boolean z) {
            this.f7487c = z;
        }
    }

    /* compiled from: report_privacy_checkup_action */
    class TextDirectionHeuristicLocale extends TextDirectionHeuristicImpl {
        public static final TextDirectionHeuristicLocale f7488a = new TextDirectionHeuristicLocale();

        public TextDirectionHeuristicLocale() {
            super(null);
        }

        protected final boolean mo1669a() {
            if (TextUtilsCompat.a(Locale.getDefault()) == 1) {
                return true;
            }
            return false;
        }
    }
}
