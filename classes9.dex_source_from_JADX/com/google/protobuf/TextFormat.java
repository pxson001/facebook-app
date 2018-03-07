package com.google.protobuf;

import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor.JavaType;
import com.google.protobuf.Descriptors.FieldDescriptor.Type;
import com.google.protobuf.UnknownFieldSet.Field;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.Map.Entry;

/* compiled from: all_transactions_creation_time_index */
public final class TextFormat {
    private static final Printer f21018a = new Printer();
    private static final Printer f21019b;
    private static final Printer f21020c;

    /* compiled from: all_transactions_creation_time_index */
    class InvalidEscapeSequenceException extends IOException {
        InvalidEscapeSequenceException(String str) {
            super(str);
        }
    }

    /* compiled from: all_transactions_creation_time_index */
    public final class Printer {
        public boolean f21013a = false;
        public boolean f21014b = true;

        public static void m21461a(Printer printer, UnknownFieldSet unknownFieldSet, TextGenerator textGenerator) {
            for (Entry entry : unknownFieldSet.f21033b.entrySet()) {
                int intValue = ((Integer) entry.getKey()).intValue();
                Field field = (Field) entry.getValue();
                printer.m21458a(intValue, 0, field.f21026b, textGenerator);
                printer.m21458a(intValue, 5, field.f21027c, textGenerator);
                printer.m21458a(intValue, 1, field.f21028d, textGenerator);
                printer.m21458a(intValue, 2, field.f21029e, textGenerator);
                for (UnknownFieldSet unknownFieldSet2 : field.f21030f) {
                    textGenerator.m21466a(((Integer) entry.getKey()).toString());
                    if (printer.f21013a) {
                        textGenerator.m21466a(" { ");
                    } else {
                        textGenerator.m21466a(" {\n");
                        textGenerator.m21465a();
                    }
                    m21461a(printer, unknownFieldSet2, textGenerator);
                    if (printer.f21013a) {
                        textGenerator.m21466a("} ");
                    } else {
                        textGenerator.m21467b();
                        textGenerator.m21466a("}\n");
                    }
                }
            }
        }

        public static void m21460a(Printer printer, MessageOrBuilder messageOrBuilder, TextGenerator textGenerator) {
            for (Entry entry : messageOrBuilder.lR_().entrySet()) {
                printer.m21459a((FieldDescriptor) entry.getKey(), entry.getValue(), textGenerator);
            }
            m21461a(printer, messageOrBuilder.mo868g(), textGenerator);
        }

        private void m21459a(FieldDescriptor fieldDescriptor, Object obj, TextGenerator textGenerator) {
            if (fieldDescriptor.m21239m()) {
                for (Object b : (List) obj) {
                    m21462b(fieldDescriptor, b, textGenerator);
                }
                return;
            }
            m21462b(fieldDescriptor, obj, textGenerator);
        }

        private void m21462b(FieldDescriptor fieldDescriptor, Object obj, TextGenerator textGenerator) {
            if (fieldDescriptor.m21243q()) {
                textGenerator.m21466a("[");
                if (fieldDescriptor.f20868h.m21195d().messageSetWireFormat_ && fieldDescriptor.f20867g == Type.MESSAGE && fieldDescriptor.m21238l() && fieldDescriptor.m21245s() == fieldDescriptor.m21246t()) {
                    textGenerator.m21466a(fieldDescriptor.m21246t().mo894b());
                } else {
                    textGenerator.m21466a(fieldDescriptor.mo894b());
                }
                textGenerator.m21466a("]");
            } else if (fieldDescriptor.f20867g == Type.GROUP) {
                textGenerator.m21466a(fieldDescriptor.m21246t().mo893a());
            } else {
                textGenerator.m21466a(fieldDescriptor.mo893a());
            }
            if (fieldDescriptor.m21232f() != JavaType.MESSAGE) {
                textGenerator.m21466a(": ");
            } else if (this.f21013a) {
                textGenerator.m21466a(" { ");
            } else {
                textGenerator.m21466a(" {\n");
                textGenerator.m21465a();
            }
            m21463c(fieldDescriptor, obj, textGenerator);
            if (fieldDescriptor.m21232f() == JavaType.MESSAGE) {
                if (this.f21013a) {
                    textGenerator.m21466a("} ");
                    return;
                }
                textGenerator.m21467b();
                textGenerator.m21466a("}\n");
            } else if (this.f21013a) {
                textGenerator.m21466a(" ");
            } else {
                textGenerator.m21466a("\n");
            }
        }

        private void m21463c(FieldDescriptor fieldDescriptor, Object obj, TextGenerator textGenerator) {
            switch (fieldDescriptor.f20867g) {
                case INT32:
                case SINT32:
                case SFIXED32:
                    textGenerator.m21466a(((Integer) obj).toString());
                    return;
                case INT64:
                case SINT64:
                case SFIXED64:
                    textGenerator.m21466a(((Long) obj).toString());
                    return;
                case BOOL:
                    textGenerator.m21466a(((Boolean) obj).toString());
                    return;
                case FLOAT:
                    textGenerator.m21466a(((Float) obj).toString());
                    return;
                case DOUBLE:
                    textGenerator.m21466a(((Double) obj).toString());
                    return;
                case UINT32:
                case FIXED32:
                    String num;
                    int intValue = ((Integer) obj).intValue();
                    if (intValue >= 0) {
                        num = Integer.toString(intValue);
                    } else {
                        num = Long.toString(((long) intValue) & 4294967295L);
                    }
                    textGenerator.m21466a(num);
                    return;
                case UINT64:
                case FIXED64:
                    textGenerator.m21466a(TextFormat.m21477b(((Long) obj).longValue()));
                    return;
                case STRING:
                    textGenerator.m21466a("\"");
                    if (this.f21014b) {
                        obj = TextFormat.m21470a(ByteString.m20173a((String) obj));
                    } else {
                        String str = (String) obj;
                    }
                    textGenerator.m21466a(obj);
                    textGenerator.m21466a("\"");
                    return;
                case BYTES:
                    textGenerator.m21466a("\"");
                    textGenerator.m21466a(TextFormat.m21470a((ByteString) obj));
                    textGenerator.m21466a("\"");
                    return;
                case ENUM:
                    textGenerator.m21466a(((EnumValueDescriptor) obj).mo893a());
                    return;
                case MESSAGE:
                case GROUP:
                    m21460a(this, (AbstractMessage) obj, textGenerator);
                    return;
                default:
                    return;
            }
        }

        private void m21458a(int i, int i2, List<?> list, TextGenerator textGenerator) {
            for (Object next : list) {
                textGenerator.m21466a(String.valueOf(i));
                textGenerator.m21466a(": ");
                TextFormat.m21478b(i2, next, textGenerator);
                textGenerator.m21466a(this.f21013a ? " " : "\n");
            }
        }
    }

    /* compiled from: all_transactions_creation_time_index */
    final class TextGenerator {
        private final Appendable f21015a;
        private final StringBuilder f21016b = new StringBuilder();
        private boolean f21017c = true;

        public TextGenerator(Appendable appendable) {
            this.f21015a = appendable;
        }

        public final void m21465a() {
            this.f21016b.append("  ");
        }

        public final void m21467b() {
            int length = this.f21016b.length();
            if (length == 0) {
                throw new IllegalArgumentException(" Outdent() without matching Indent().");
            }
            this.f21016b.delete(length - 2, length);
        }

        public final void m21466a(CharSequence charSequence) {
            int i = 0;
            int length = charSequence.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (charSequence.charAt(i2) == '\n') {
                    m21464a(charSequence.subSequence(i, length), (i2 - i) + 1);
                    i = i2 + 1;
                    this.f21017c = true;
                }
            }
            m21464a(charSequence.subSequence(i, length), length - i);
        }

        private void m21464a(CharSequence charSequence, int i) {
            if (i != 0) {
                if (this.f21017c) {
                    this.f21017c = false;
                    this.f21015a.append(this.f21016b);
                }
                this.f21015a.append(charSequence);
            }
        }
    }

    private TextFormat() {
    }

    static {
        Printer printer = new Printer();
        printer.f21013a = true;
        f21019b = printer;
        printer = new Printer();
        printer.f21014b = false;
        f21020c = printer;
    }

    private static void m21473a(MessageOrBuilder messageOrBuilder, Appendable appendable) {
        Printer.m21460a(f21018a, messageOrBuilder, new TextGenerator(appendable));
    }

    private static void m21474a(UnknownFieldSet unknownFieldSet, Appendable appendable) {
        Printer.m21461a(f21018a, unknownFieldSet, new TextGenerator(appendable));
    }

    public static String m21471a(MessageOrBuilder messageOrBuilder) {
        try {
            Appendable stringBuilder = new StringBuilder();
            m21473a(messageOrBuilder, stringBuilder);
            return stringBuilder.toString();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public static String m21472a(UnknownFieldSet unknownFieldSet) {
        try {
            Appendable stringBuilder = new StringBuilder();
            m21474a(unknownFieldSet, stringBuilder);
            return stringBuilder.toString();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public static void m21478b(int i, Object obj, TextGenerator textGenerator) {
        switch (i & 7) {
            case 0:
                textGenerator.m21466a(m21477b(((Long) obj).longValue()));
                return;
            case 1:
                textGenerator.m21466a(String.format(null, "0x%016x", new Object[]{(Long) obj}));
                return;
            case 2:
                textGenerator.m21466a("\"");
                textGenerator.m21466a(m21470a((ByteString) obj));
                textGenerator.m21466a("\"");
                return;
            case 3:
                Printer.m21461a(f21018a, (UnknownFieldSet) obj, textGenerator);
                return;
            case 5:
                textGenerator.m21466a(String.format(null, "0x%08x", new Object[]{(Integer) obj}));
                return;
            default:
                throw new IllegalArgumentException("Bad tag: " + i);
        }
    }

    public static String m21477b(long j) {
        if (j >= 0) {
            return Long.toString(j);
        }
        return BigInteger.valueOf(Long.MAX_VALUE & j).setBit(63).toString();
    }

    public static String m21470a(ByteString byteString) {
        StringBuilder stringBuilder = new StringBuilder(byteString.mo912b());
        for (int i = 0; i < byteString.mo912b(); i++) {
            byte a = byteString.mo909a(i);
            switch (a) {
                case (byte) 7:
                    stringBuilder.append("\\a");
                    break;
                case (byte) 8:
                    stringBuilder.append("\\b");
                    break;
                case (byte) 9:
                    stringBuilder.append("\\t");
                    break;
                case (byte) 10:
                    stringBuilder.append("\\n");
                    break;
                case (byte) 11:
                    stringBuilder.append("\\v");
                    break;
                case (byte) 12:
                    stringBuilder.append("\\f");
                    break;
                case (byte) 13:
                    stringBuilder.append("\\r");
                    break;
                case (byte) 34:
                    stringBuilder.append("\\\"");
                    break;
                case (byte) 39:
                    stringBuilder.append("\\'");
                    break;
                case (byte) 92:
                    stringBuilder.append("\\\\");
                    break;
                default:
                    if (a < (byte) 32) {
                        stringBuilder.append('\\');
                        stringBuilder.append((char) (((a >>> 6) & 3) + 48));
                        stringBuilder.append((char) (((a >>> 3) & 7) + 48));
                        stringBuilder.append((char) ((a & 7) + 48));
                        break;
                    }
                    stringBuilder.append((char) a);
                    break;
            }
        }
        return stringBuilder.toString();
    }

    static ByteString m21469a(CharSequence charSequence) {
        ByteString a = ByteString.m20173a(charSequence.toString());
        byte[] bArr = new byte[a.mo912b()];
        int i = 0;
        int i2;
        for (int i3 = 0; i3 < a.mo912b(); i3 = i2 + 1) {
            byte a2 = a.mo909a(i3);
            if (a2 != (byte) 92) {
                i2 = i + 1;
                bArr[i] = a2;
                i = i2;
                i2 = i3;
            } else if (i3 + 1 < a.mo912b()) {
                i2 = i3 + 1;
                byte a3 = a.mo909a(i2);
                int i4;
                if (m21475a(a3)) {
                    i3 = m21480c(a3);
                    if (i2 + 1 < a.mo912b() && m21475a(a.mo909a(i2 + 1))) {
                        i2++;
                        i3 = (i3 * 8) + m21480c(a.mo909a(i2));
                    }
                    if (i2 + 1 < a.mo912b() && m21475a(a.mo909a(i2 + 1))) {
                        i2++;
                        i3 = (i3 * 8) + m21480c(a.mo909a(i2));
                    }
                    i4 = i + 1;
                    bArr[i] = (byte) i3;
                    i = i4;
                } else {
                    switch (a3) {
                        case (byte) 34:
                            i3 = i + 1;
                            bArr[i] = (byte) 34;
                            i = i3;
                            break;
                        case (byte) 39:
                            i3 = i + 1;
                            bArr[i] = (byte) 39;
                            i = i3;
                            break;
                        case (byte) 92:
                            i3 = i + 1;
                            bArr[i] = (byte) 92;
                            i = i3;
                            break;
                        case (byte) 97:
                            i3 = i + 1;
                            bArr[i] = (byte) 7;
                            i = i3;
                            break;
                        case (byte) 98:
                            i3 = i + 1;
                            bArr[i] = (byte) 8;
                            i = i3;
                            break;
                        case (byte) 102:
                            i3 = i + 1;
                            bArr[i] = (byte) 12;
                            i = i3;
                            break;
                        case (byte) 110:
                            i3 = i + 1;
                            bArr[i] = (byte) 10;
                            i = i3;
                            break;
                        case (byte) 114:
                            i3 = i + 1;
                            bArr[i] = (byte) 13;
                            i = i3;
                            break;
                        case (byte) 116:
                            i3 = i + 1;
                            bArr[i] = (byte) 9;
                            i = i3;
                            break;
                        case (byte) 118:
                            i3 = i + 1;
                            bArr[i] = (byte) 11;
                            i = i3;
                            break;
                        case (byte) 120:
                            if (i2 + 1 < a.mo912b() && m21479b(a.mo909a(i2 + 1))) {
                                i2++;
                                i3 = m21480c(a.mo909a(i2));
                                if (i2 + 1 < a.mo912b() && m21479b(a.mo909a(i2 + 1))) {
                                    i2++;
                                    i3 = (i3 * 16) + m21480c(a.mo909a(i2));
                                }
                                i4 = i + 1;
                                bArr[i] = (byte) i3;
                                i = i4;
                                break;
                            }
                            throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\x' with no digits");
                        default:
                            throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\" + ((char) a3) + '\'');
                    }
                }
            } else {
                throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\' at end of string.");
            }
        }
        return ByteString.m20175a(bArr, 0, i);
    }

    private static boolean m21475a(byte b) {
        return (byte) 48 <= b && b <= (byte) 55;
    }

    private static boolean m21479b(byte b) {
        return ((byte) 48 <= b && b <= (byte) 57) || (((byte) 97 <= b && b <= (byte) 102) || ((byte) 65 <= b && b <= (byte) 70));
    }

    private static int m21480c(byte b) {
        if ((byte) 48 <= b && b <= (byte) 57) {
            return b - 48;
        }
        if ((byte) 97 > b || b > (byte) 122) {
            return (b - 65) + 10;
        }
        return (b - 97) + 10;
    }

    static int m21476b(String str) {
        return (int) m21468a(str, true, false);
    }

    static int m21481c(String str) {
        return (int) m21468a(str, false, false);
    }

    static long m21482d(String str) {
        return m21468a(str, true, true);
    }

    static long m21483e(String str) {
        return m21468a(str, false, true);
    }

    private static long m21468a(String str, boolean z, boolean z2) {
        int i;
        int i2 = 1;
        int i3 = 0;
        if (!str.startsWith("-", 0)) {
            i2 = 0;
        } else if (z) {
            i3 = 1;
        } else {
            throw new NumberFormatException("Number must be positive: " + str);
        }
        if (str.startsWith("0x", i3)) {
            i = i3 + 2;
            i3 = 16;
        } else if (str.startsWith("0", i3)) {
            i = i3;
            i3 = 8;
        } else {
            i = i3;
            i3 = 10;
        }
        String substring = str.substring(i);
        if (substring.length() < 16) {
            long j;
            long parseLong = Long.parseLong(substring, i3);
            if (i2 != 0) {
                j = -parseLong;
            } else {
                j = parseLong;
            }
            if (z2) {
                return j;
            }
            if (z) {
                if (j <= 2147483647L && j >= -2147483648L) {
                    return j;
                }
                throw new NumberFormatException("Number out of range for 32-bit signed integer: " + str);
            } else if (j < 4294967296L && j >= 0) {
                return j;
            } else {
                throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + str);
            }
        }
        BigInteger negate;
        BigInteger bigInteger = new BigInteger(substring, i3);
        if (i2 != 0) {
            negate = bigInteger.negate();
        } else {
            negate = bigInteger;
        }
        if (z2) {
            if (z) {
                if (negate.bitLength() > 63) {
                    throw new NumberFormatException("Number out of range for 64-bit signed integer: " + str);
                }
            } else if (negate.bitLength() > 64) {
                throw new NumberFormatException("Number out of range for 64-bit unsigned integer: " + str);
            }
        } else if (z) {
            if (negate.bitLength() > 31) {
                throw new NumberFormatException("Number out of range for 32-bit signed integer: " + str);
            }
        } else if (negate.bitLength() > 32) {
            throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + str);
        }
        return negate.longValue();
    }
}
