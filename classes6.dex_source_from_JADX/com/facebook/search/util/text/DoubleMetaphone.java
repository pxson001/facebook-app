package com.facebook.search.util.text;

import java.util.Locale;

/* compiled from: event_soft_cancel */
public class DoubleMetaphone {
    private static final String[] f15941a = new String[]{"GN", "KN", "PN", "WR", "PS"};
    private static final String[] f15942b = new String[]{"L", "R", "N", "M", "B", "H", "F", "V", "W", " "};
    private static final String[] f15943c = new String[]{"ES", "EP", "EB", "EL", "EY", "IB", "IL", "IN", "IE", "EI", "ER"};
    private static final String[] f15944d = new String[]{"L", "T", "K", "S", "N", "M", "B", "Z"};
    public int f15945e = 20;

    /* compiled from: event_soft_cancel */
    public class DoubleMetaphoneResult {
        final /* synthetic */ DoubleMetaphone f15937a;
        public final StringBuffer f15938b = new StringBuffer(this.f15937a.f15945e);
        public final StringBuffer f15939c = new StringBuffer(this.f15937a.f15945e);
        private int f15940d;

        public DoubleMetaphoneResult(DoubleMetaphone doubleMetaphone, int i) {
            this.f15937a = doubleMetaphone;
            this.f15940d = i;
        }

        public final void m23550a(char c) {
            m23554b(c);
            m23555c(c);
        }

        public final void m23551a(char c, char c2) {
            m23554b(c);
            m23555c(c2);
        }

        public final void m23554b(char c) {
            if (this.f15938b.length() < this.f15940d) {
                this.f15938b.append(c);
            }
        }

        public final void m23555c(char c) {
            if (this.f15939c.length() < this.f15940d) {
                this.f15939c.append(c);
            }
        }

        public final void m23552a(String str) {
            m23548b(str);
            m23549c(str);
        }

        public final void m23553a(String str, String str2) {
            m23548b(str);
            m23549c(str2);
        }

        private void m23548b(String str) {
            int length = this.f15940d - this.f15938b.length();
            if (str.length() <= length) {
                this.f15938b.append(str);
            } else {
                this.f15938b.append(str.substring(0, length));
            }
        }

        private void m23549c(String str) {
            int length = this.f15940d - this.f15939c.length();
            if (str.length() <= length) {
                this.f15939c.append(str);
            } else {
                this.f15939c.append(str.substring(0, length));
            }
        }

        public final boolean m23556c() {
            return this.f15938b.length() >= this.f15940d && this.f15939c.length() >= this.f15940d;
        }
    }

    public final String m23588a(String str) {
        return m23559a(str, false);
    }

    private String m23559a(String str, boolean z) {
        String str2 = null;
        if (str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                str2 = trim.toUpperCase(Locale.ENGLISH);
            }
        }
        String str3 = str2;
        if (str3 == null) {
            return null;
        }
        boolean z2;
        if (str3.indexOf(87) >= 0 || str3.indexOf(75) >= 0 || str3.indexOf("CZ") >= 0 || str3.indexOf("WITZ") >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        boolean z3 = z2;
        int i = m23574c(str3) ? 1 : 0;
        DoubleMetaphoneResult doubleMetaphoneResult = new DoubleMetaphoneResult(this, this.f15945e);
        while (!doubleMetaphoneResult.m23556c() && i <= str3.length() - 1) {
            switch (str3.charAt(i)) {
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                case 'Y':
                    if (i == 0) {
                        doubleMetaphoneResult.m23550a('A');
                    }
                    i++;
                    break;
                case 'B':
                    doubleMetaphoneResult.m23550a('P');
                    if (m23581f(str3, i + 1) != 'B') {
                        i++;
                        break;
                    }
                    i += 2;
                    break;
                case 'C':
                    i = m23557a(str3, doubleMetaphoneResult, i);
                    break;
                case 'D':
                    i = m23576d(str3, doubleMetaphoneResult, i);
                    break;
                case 'F':
                    doubleMetaphoneResult.m23550a('F');
                    if (m23581f(str3, i + 1) != 'F') {
                        i++;
                        break;
                    }
                    i += 2;
                    break;
                case 'G':
                    i = m23558a(str3, doubleMetaphoneResult, i, z3);
                    break;
                case 'H':
                    int i2;
                    if ((i == 0 || m23560a(m23581f(str3, i - 1))) && m23560a(m23581f(str3, i + 1))) {
                        doubleMetaphoneResult.m23550a('H');
                        i2 = i + 2;
                    } else {
                        i2 = i + 1;
                    }
                    i = i2;
                    break;
                case 'J':
                    i = m23570b(str3, doubleMetaphoneResult, i, z3);
                    break;
                case 'K':
                    doubleMetaphoneResult.m23550a('K');
                    if (m23581f(str3, i + 1) != 'K') {
                        i++;
                        break;
                    }
                    i += 2;
                    break;
                case 'L':
                    i = m23582g(str3, doubleMetaphoneResult, i);
                    break;
                case 'M':
                    doubleMetaphoneResult.m23550a('M');
                    if (!m23580e(str3, i)) {
                        i++;
                        break;
                    }
                    i += 2;
                    break;
                case 'N':
                    doubleMetaphoneResult.m23550a('N');
                    if (m23581f(str3, i + 1) != 'N') {
                        i++;
                        break;
                    }
                    i += 2;
                    break;
                case 'P':
                    i = m23583h(str3, doubleMetaphoneResult, i);
                    break;
                case 'Q':
                    doubleMetaphoneResult.m23550a('K');
                    if (m23581f(str3, i + 1) != 'Q') {
                        i++;
                        break;
                    }
                    i += 2;
                    break;
                case 'R':
                    i = m23573c(str3, doubleMetaphoneResult, i, z3);
                    break;
                case 'S':
                    i = m23577d(str3, doubleMetaphoneResult, i, z3);
                    break;
                case 'T':
                    i = m23585j(str3, doubleMetaphoneResult, i);
                    break;
                case 'V':
                    doubleMetaphoneResult.m23550a('F');
                    if (m23581f(str3, i + 1) != 'V') {
                        i++;
                        break;
                    }
                    i += 2;
                    break;
                case 'W':
                    i = m23586k(str3, doubleMetaphoneResult, i);
                    break;
                case 'X':
                    i = m23587l(str3, doubleMetaphoneResult, i);
                    break;
                case 'Z':
                    i = m23579e(str3, doubleMetaphoneResult, i, z3);
                    break;
                default:
                    i++;
                    break;
            }
        }
        if (z) {
            return doubleMetaphoneResult.f15939c.toString();
        }
        return doubleMetaphoneResult.f15938b.toString();
    }

    private int m23557a(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (m23561a(str, i)) {
            doubleMetaphoneResult.m23550a('K');
            return i + 2;
        } else if (i == 0 && m23562a(str, i, 6, "CAESAR")) {
            doubleMetaphoneResult.m23550a('S');
            return i + 2;
        } else if (m23562a(str, i, 2, "CH")) {
            return m23572c(str, doubleMetaphoneResult, i);
        } else {
            if (m23562a(str, i, 2, "CZ") && !m23562a(str, i - 2, 4, "WICZ")) {
                doubleMetaphoneResult.m23551a('S', 'X');
                return i + 2;
            } else if (m23562a(str, i + 1, 3, "CIA")) {
                doubleMetaphoneResult.m23550a('X');
                return i + 3;
            } else if (m23562a(str, i, 2, "CC") && (i != 1 || m23581f(str, 0) != 'M')) {
                return m23569b(str, doubleMetaphoneResult, i);
            } else {
                if (m23564a(str, i, 2, "CK", "CG", "CQ")) {
                    doubleMetaphoneResult.m23550a('K');
                    return i + 2;
                }
                if (m23564a(str, i, 2, "CI", "CE", "CY")) {
                    if (m23564a(str, i, 3, "CIO", "CIE", "CIA")) {
                        doubleMetaphoneResult.m23551a('S', 'X');
                    } else {
                        doubleMetaphoneResult.m23550a('S');
                    }
                    return i + 2;
                }
                doubleMetaphoneResult.m23550a('K');
                if (m23564a(str, i + 1, 2, " C", " Q", " G")) {
                    return i + 3;
                }
                if (!m23564a(str, i + 1, 1, "C", "K", "Q") || m23563a(str, i + 1, 2, "CE", "CI")) {
                    return i + 1;
                }
                return i + 2;
            }
        }
    }

    private int m23569b(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (!m23564a(str, i + 2, 1, "I", "E", "H") || m23562a(str, i + 2, 2, "HU")) {
            doubleMetaphoneResult.m23550a('K');
            return i + 2;
        }
        if ((i == 1 && m23581f(str, i - 1) == 'A') || m23563a(str, i - 1, 5, "UCCEE", "UCCES")) {
            doubleMetaphoneResult.m23552a("KS");
        } else {
            doubleMetaphoneResult.m23550a('X');
        }
        return i + 3;
    }

    private int m23572c(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (i > 0 && m23562a(str, i, 4, "CHAE")) {
            doubleMetaphoneResult.m23551a('K', 'X');
            return i + 2;
        } else if (m23571b(str, i)) {
            doubleMetaphoneResult.m23550a('K');
            return i + 2;
        } else if (m23575c(str, i)) {
            doubleMetaphoneResult.m23550a('K');
            return i + 2;
        } else {
            if (i <= 0) {
                doubleMetaphoneResult.m23550a('X');
            } else if (m23562a(str, 0, 2, "MC")) {
                doubleMetaphoneResult.m23550a('K');
            } else {
                doubleMetaphoneResult.m23551a('X', 'K');
            }
            return i + 2;
        }
    }

    private static int m23576d(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (m23562a(str, i, 2, "DG")) {
            if (m23564a(str, i + 2, 1, "I", "E", "Y")) {
                doubleMetaphoneResult.m23550a('J');
                return i + 3;
            }
            doubleMetaphoneResult.m23552a("TK");
            return i + 2;
        } else if (m23563a(str, i, 2, "DT", "DD")) {
            doubleMetaphoneResult.m23550a('T');
            return i + 2;
        } else {
            doubleMetaphoneResult.m23550a('T');
            return i + 1;
        }
    }

    private int m23558a(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i, boolean z) {
        if (m23581f(str, i + 1) == 'H') {
            return m23578e(str, doubleMetaphoneResult, i);
        }
        if (m23581f(str, i + 1) == 'N') {
            if (i == 1 && m23560a(m23581f(str, 0)) && !z) {
                doubleMetaphoneResult.m23553a("KN", "N");
            } else if (m23562a(str, i + 2, 2, "EY") || m23581f(str, i + 1) == 'Y' || z) {
                doubleMetaphoneResult.m23552a("KN");
            } else {
                doubleMetaphoneResult.m23553a("N", "KN");
            }
            return i + 2;
        }
        if (m23562a(str, i + 1, 2, "LI") && !z) {
            doubleMetaphoneResult.m23553a("KL", "L");
        } else if (i == 0 && (m23581f(str, i + 1) == 'Y' || m23568a(str, i + 1, 2, f15943c))) {
            doubleMetaphoneResult.m23551a('K', 'J');
        } else {
            if (m23562a(str, i + 1, 2, "ER") || m23581f(str, i + 1) == 'Y') {
                if (!(m23564a(str, 0, 6, "DANGER", "RANGER", "MANGER") || m23563a(str, i - 1, 1, "E", "I") || m23563a(str, i - 1, 3, "RGY", "OGY"))) {
                    doubleMetaphoneResult.m23551a('K', 'J');
                }
            }
            if (m23564a(str, i + 1, 1, "E", "I", "Y") || m23563a(str, i - 1, 4, "AGGI", "OGGI")) {
                if (m23563a(str, 0, 4, "VAN ", "VON ") || m23562a(str, 0, 3, "SCH") || m23562a(str, i + 1, 2, "ET")) {
                    doubleMetaphoneResult.m23550a('K');
                } else if (m23562a(str, i + 1, 3, "IER")) {
                    doubleMetaphoneResult.m23550a('J');
                } else {
                    doubleMetaphoneResult.m23551a('J', 'K');
                }
            } else if (m23581f(str, i + 1) == 'G') {
                r0 = i + 2;
                doubleMetaphoneResult.m23550a('K');
                return r0;
            } else {
                r0 = i + 1;
                doubleMetaphoneResult.m23550a('K');
                return r0;
            }
        }
        return i + 2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m23578e(java.lang.String r11, com.facebook.search.util.text.DoubleMetaphone.DoubleMetaphoneResult r12, int r13) {
        /*
        r10 = this;
        r9 = 73;
        r6 = 2;
        r8 = 75;
        r2 = 1;
        if (r13 <= 0) goto L_0x001a;
    L_0x0008:
        r0 = r13 + -1;
        r0 = m23581f(r11, r0);
        r0 = m23560a(r0);
        if (r0 != 0) goto L_0x001a;
    L_0x0014:
        r12.m23550a(r8);
    L_0x0017:
        r0 = r13 + 2;
    L_0x0019:
        return r0;
    L_0x001a:
        if (r13 != 0) goto L_0x0030;
    L_0x001c:
        r0 = r13 + 2;
        r0 = m23581f(r11, r0);
        if (r0 != r9) goto L_0x002c;
    L_0x0024:
        r0 = 74;
        r12.m23550a(r0);
    L_0x0029:
        r0 = r13 + 2;
        goto L_0x0019;
    L_0x002c:
        r12.m23550a(r8);
        goto L_0x0029;
    L_0x0030:
        if (r13 <= r2) goto L_0x0041;
    L_0x0032:
        r1 = r13 + -2;
        r3 = "B";
        r4 = "H";
        r5 = "D";
        r0 = r11;
        r0 = m23564a(r0, r1, r2, r3, r4, r5);
        if (r0 != 0) goto L_0x0017;
    L_0x0041:
        if (r13 <= r6) goto L_0x0052;
    L_0x0043:
        r1 = r13 + -3;
        r3 = "B";
        r4 = "H";
        r5 = "D";
        r0 = r11;
        r0 = m23564a(r0, r1, r2, r3, r4, r5);
        if (r0 != 0) goto L_0x0017;
    L_0x0052:
        r0 = 3;
        if (r13 <= r0) goto L_0x0061;
    L_0x0055:
        r0 = r13 + -4;
        r1 = "B";
        r3 = "H";
        r0 = m23563a(r11, r0, r2, r1, r3);
        if (r0 != 0) goto L_0x0017;
    L_0x0061:
        if (r13 <= r6) goto L_0x0088;
    L_0x0063:
        r0 = r13 + -1;
        r0 = m23581f(r11, r0);
        r1 = 85;
        if (r0 != r1) goto L_0x0088;
    L_0x006d:
        r1 = r13 + -3;
        r3 = "C";
        r4 = "G";
        r5 = "L";
        r6 = "R";
        r7 = "T";
        r0 = r11;
        r0 = m23566a(r0, r1, r2, r3, r4, r5, r6, r7);
        if (r0 == 0) goto L_0x0088;
    L_0x0080:
        r0 = 70;
        r12.m23550a(r0);
    L_0x0085:
        r0 = r13 + 2;
        goto L_0x0019;
    L_0x0088:
        if (r13 <= 0) goto L_0x0085;
    L_0x008a:
        r0 = r13 + -1;
        r0 = m23581f(r11, r0);
        if (r0 == r9) goto L_0x0085;
    L_0x0092:
        r12.m23550a(r8);
        goto L_0x0085;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.util.text.DoubleMetaphone.e(java.lang.String, com.facebook.search.util.text.DoubleMetaphone$DoubleMetaphoneResult, int):int");
    }

    private int m23570b(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i, boolean z) {
        if (m23562a(str, i, 4, "JOSE") || m23562a(str, 0, 4, "SAN ")) {
            if ((i == 0 && m23581f(str, i + 4) == ' ') || str.length() == 4 || m23562a(str, 0, 4, "SAN ")) {
                doubleMetaphoneResult.m23550a('H');
            } else {
                doubleMetaphoneResult.m23551a('J', 'H');
            }
            return i + 1;
        }
        if (i == 0 && !m23562a(str, i, 4, "JOSE")) {
            doubleMetaphoneResult.m23551a('J', 'A');
        } else if (m23560a(m23581f(str, i - 1)) && !z && (m23581f(str, i + 1) == 'A' || m23581f(str, i + 1) == 'O')) {
            doubleMetaphoneResult.m23551a('J', 'H');
        } else if (i == str.length() - 1) {
            doubleMetaphoneResult.m23551a('J', ' ');
        } else if (!m23568a(str, i + 1, 1, f15944d)) {
            if (!m23564a(str, i - 1, 1, "S", "K", "L")) {
                doubleMetaphoneResult.m23550a('J');
            }
        }
        if (m23581f(str, i + 1) == 'J') {
            return i + 2;
        }
        return i + 1;
    }

    private int m23582g(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (m23581f(str, i + 1) == 'L') {
            int i2;
            if (i == str.length() - 3) {
                if (m23564a(str, i - 1, 4, "ILLO", "ILLA", "ALLE")) {
                    i2 = 1;
                    if (i2 == 0) {
                        doubleMetaphoneResult.m23554b('L');
                    } else {
                        doubleMetaphoneResult.m23550a('L');
                    }
                    return i + 2;
                }
            }
            i2 = ((m23563a(str, str.length() + -2, 2, "AS", "OS") || m23563a(str, str.length() - 1, 1, "A", "O")) && m23562a(str, i - 1, 4, "ALLE")) ? 1 : 0;
            if (i2 == 0) {
                doubleMetaphoneResult.m23550a('L');
            } else {
                doubleMetaphoneResult.m23554b('L');
            }
            return i + 2;
        }
        int i3 = i + 1;
        doubleMetaphoneResult.m23550a('L');
        return i3;
    }

    private int m23583h(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (m23581f(str, i + 1) == 'H') {
            doubleMetaphoneResult.m23550a('F');
            return i + 2;
        }
        doubleMetaphoneResult.m23550a('P');
        return m23563a(str, i + 1, 1, "P", "B") ? i + 2 : i + 1;
    }

    private int m23573c(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i, boolean z) {
        if (i != str.length() - 1 || z || !m23562a(str, i - 2, 2, "IE") || m23563a(str, i - 4, 2, "ME", "MA")) {
            doubleMetaphoneResult.m23550a('R');
        } else {
            doubleMetaphoneResult.m23555c('R');
        }
        return m23581f(str, i + 1) == 'R' ? i + 2 : i + 1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m23577d(java.lang.String r11, com.facebook.search.util.text.DoubleMetaphone.DoubleMetaphoneResult r12, int r13, boolean r14) {
        /*
        r10 = this;
        r4 = 3;
        r9 = 2;
        r8 = 88;
        r2 = 1;
        r7 = 83;
        r0 = r13 + -1;
        r1 = "ISL";
        r3 = "YSL";
        r0 = m23563a(r11, r0, r4, r1, r3);
        if (r0 == 0) goto L_0x0016;
    L_0x0013:
        r0 = r13 + 1;
    L_0x0015:
        return r0;
    L_0x0016:
        if (r13 != 0) goto L_0x0027;
    L_0x0018:
        r0 = 5;
        r1 = "SUGAR";
        r0 = m23562a(r11, r13, r0, r1);
        if (r0 == 0) goto L_0x0027;
    L_0x0021:
        r12.m23551a(r8, r7);
        r0 = r13 + 1;
        goto L_0x0015;
    L_0x0027:
        r0 = "SH";
        r0 = m23562a(r11, r13, r9, r0);
        if (r0 == 0) goto L_0x004b;
    L_0x002f:
        r1 = r13 + 1;
        r2 = 4;
        r3 = "HEIM";
        r4 = "HOEK";
        r5 = "HOLM";
        r6 = "HOLZ";
        r0 = r11;
        r0 = m23565a(r0, r1, r2, r3, r4, r5, r6);
        if (r0 == 0) goto L_0x0047;
    L_0x0041:
        r12.m23550a(r7);
    L_0x0044:
        r0 = r13 + 2;
        goto L_0x0015;
    L_0x0047:
        r12.m23550a(r8);
        goto L_0x0044;
    L_0x004b:
        r0 = "SIO";
        r1 = "SIA";
        r0 = m23563a(r11, r13, r4, r0, r1);
        if (r0 != 0) goto L_0x00cc;
    L_0x0055:
        r0 = 4;
        r1 = "SIAN";
        r0 = m23562a(r11, r13, r0, r1);
        if (r0 != 0) goto L_0x00cc;
    L_0x005e:
        if (r13 != 0) goto L_0x0071;
    L_0x0060:
        r1 = r13 + 1;
        r3 = "M";
        r4 = "N";
        r5 = "L";
        r6 = "W";
        r0 = r11;
        r0 = m23565a(r0, r1, r2, r3, r4, r5, r6);
        if (r0 != 0) goto L_0x00b7;
    L_0x0071:
        r0 = r13 + 1;
        r1 = "Z";
        r0 = m23562a(r11, r0, r2, r1);
        if (r0 != 0) goto L_0x00b7;
    L_0x007b:
        r0 = "SC";
        r0 = m23562a(r11, r13, r9, r0);
        if (r0 == 0) goto L_0x0088;
    L_0x0083:
        r0 = r10.m23584i(r11, r12, r13);
        goto L_0x0015;
    L_0x0088:
        r0 = r11.length();
        r0 = r0 + -1;
        if (r13 != r0) goto L_0x00af;
    L_0x0090:
        r0 = r13 + -2;
        r1 = "AI";
        r3 = "OI";
        r0 = m23563a(r11, r0, r9, r1, r3);
        if (r0 == 0) goto L_0x00af;
    L_0x009c:
        r12.m23555c(r7);
    L_0x009f:
        r0 = r13 + 1;
        r1 = "S";
        r3 = "Z";
        r0 = m23563a(r11, r0, r2, r1, r3);
        if (r0 == 0) goto L_0x00b3;
    L_0x00ab:
        r0 = r13 + 2;
        goto L_0x0015;
    L_0x00af:
        r12.m23550a(r7);
        goto L_0x009f;
    L_0x00b3:
        r0 = r13 + 1;
        goto L_0x0015;
    L_0x00b7:
        r12.m23551a(r7, r8);
        r0 = r13 + 1;
        r1 = "Z";
        r0 = m23562a(r11, r0, r2, r1);
        if (r0 == 0) goto L_0x00c8;
    L_0x00c4:
        r0 = r13 + 2;
        goto L_0x0015;
    L_0x00c8:
        r0 = r13 + 1;
        goto L_0x0015;
    L_0x00cc:
        if (r14 == 0) goto L_0x00d5;
    L_0x00ce:
        r12.m23550a(r7);
    L_0x00d1:
        r0 = r13 + 3;
        goto L_0x0015;
    L_0x00d5:
        r12.m23551a(r7, r8);
        goto L_0x00d1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.util.text.DoubleMetaphone.d(java.lang.String, com.facebook.search.util.text.DoubleMetaphone$DoubleMetaphoneResult, int, boolean):int");
    }

    private int m23584i(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (m23581f(str, i + 2) == 'H') {
            if (m23567a(str, i + 3, 2, "OO", "ER", "EN", "UY", "ED", "EM")) {
                if (m23563a(str, i + 3, 2, "ER", "EN")) {
                    doubleMetaphoneResult.m23553a("X", "SK");
                } else {
                    doubleMetaphoneResult.m23552a("SK");
                }
            } else if (i != 0 || m23560a(m23581f(str, 3)) || m23581f(str, 3) == 'W') {
                doubleMetaphoneResult.m23550a('X');
            } else {
                doubleMetaphoneResult.m23551a('X', 'S');
            }
        } else {
            if (m23564a(str, i + 2, 1, "I", "E", "Y")) {
                doubleMetaphoneResult.m23550a('S');
            } else {
                doubleMetaphoneResult.m23552a("SK");
            }
        }
        return i + 3;
    }

    private static int m23585j(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (m23562a(str, i, 4, "TION")) {
            doubleMetaphoneResult.m23550a('X');
            return i + 3;
        } else if (m23563a(str, i, 3, "TIA", "TCH")) {
            doubleMetaphoneResult.m23550a('X');
            return i + 3;
        } else if (m23562a(str, i, 2, "TH") || m23562a(str, i, 3, "TTH")) {
            if (m23563a(str, i + 2, 2, "OM", "AM") || m23563a(str, 0, 4, "VAN ", "VON ") || m23562a(str, 0, 3, "SCH")) {
                doubleMetaphoneResult.m23550a('T');
            } else {
                doubleMetaphoneResult.m23551a('0', 'T');
            }
            return i + 2;
        } else {
            doubleMetaphoneResult.m23550a('T');
            return m23563a(str, i + 1, 1, "T", "D") ? i + 2 : i + 1;
        }
    }

    private int m23586k(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (m23562a(str, i, 2, "WR")) {
            doubleMetaphoneResult.m23550a('R');
            return i + 2;
        } else if (i == 0 && (m23560a(m23581f(str, i + 1)) || m23562a(str, i, 2, "WH"))) {
            if (m23560a(m23581f(str, i + 1))) {
                doubleMetaphoneResult.m23551a('A', 'F');
            } else {
                doubleMetaphoneResult.m23550a('A');
            }
            return i + 1;
        } else {
            if (!(i == str.length() - 1 && m23560a(m23581f(str, i - 1)))) {
                if (!(m23565a(str, i - 1, 5, "EWSKI", "EWSKY", "OWSKI", "OWSKY") || m23562a(str, 0, 3, "SCH"))) {
                    if (!m23563a(str, i, 4, "WICZ", "WITZ")) {
                        return i + 1;
                    }
                    doubleMetaphoneResult.m23553a("TS", "FX");
                    return i + 4;
                }
            }
            doubleMetaphoneResult.m23555c('F');
            return i + 1;
        }
    }

    private static int m23587l(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (i == 0) {
            doubleMetaphoneResult.m23550a('S');
            return i + 1;
        }
        if (!(i == str.length() - 1 && (m23563a(str, i - 3, 3, "IAU", "EAU") || m23563a(str, i - 2, 2, "AU", "OU")))) {
            doubleMetaphoneResult.m23552a("KS");
        }
        return m23563a(str, i + 1, 1, "C", "X") ? i + 2 : i + 1;
    }

    private int m23579e(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i, boolean z) {
        if (m23581f(str, i + 1) == 'H') {
            doubleMetaphoneResult.m23550a('J');
            return i + 2;
        }
        if (m23564a(str, i + 1, 2, "ZO", "ZI", "ZA") || (z && i > 0 && m23581f(str, i - 1) != 'T')) {
            doubleMetaphoneResult.m23553a("S", "TS");
        } else {
            doubleMetaphoneResult.m23550a('S');
        }
        return m23581f(str, i + 1) == 'Z' ? i + 2 : i + 1;
    }

    private boolean m23561a(String str, int i) {
        if (m23562a(str, i, 4, "CHIA")) {
            return true;
        }
        if (i <= 1) {
            return false;
        }
        if (m23560a(m23581f(str, i - 2))) {
            return false;
        }
        if (!m23562a(str, i - 1, 3, "ACH")) {
            return false;
        }
        char f = m23581f(str, i + 2);
        if ((f == 'I' || f == 'E') && !m23563a(str, i - 2, 6, "BACHER", "MACHER")) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m23571b(java.lang.String r9, int r10) {
        /*
        r8 = 5;
        r7 = 0;
        if (r10 != 0) goto L_0x002c;
    L_0x0004:
        r0 = r10 + 1;
        r1 = "HARAC";
        r2 = "HARIS";
        r0 = m23563a(r9, r0, r8, r1, r2);
        if (r0 != 0) goto L_0x0022;
    L_0x0010:
        r1 = r10 + 1;
        r2 = 3;
        r3 = "HOR";
        r4 = "HYM";
        r5 = "HIA";
        r6 = "HEM";
        r0 = r9;
        r0 = m23565a(r0, r1, r2, r3, r4, r5, r6);
        if (r0 == 0) goto L_0x002c;
    L_0x0022:
        r0 = "CHORE";
        r0 = m23562a(r9, r7, r8, r0);
        if (r0 != 0) goto L_0x002c;
    L_0x002a:
        r0 = 1;
    L_0x002b:
        return r0;
    L_0x002c:
        r0 = r7;
        goto L_0x002b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.util.text.DoubleMetaphone.b(java.lang.String, int):boolean");
    }

    private static boolean m23575c(String str, int i) {
        if (!(m23563a(str, 0, 4, "VAN ", "VON ") || m23562a(str, 0, 3, "SCH"))) {
            if (!(m23564a(str, i - 2, 6, "ORCHES", "ARCHIT", "ORCHID") || m23563a(str, i + 2, 1, "T", "S"))) {
                if (!((m23565a(str, i - 1, 1, "A", "O", "U", "E") || i == 0) && (m23568a(str, i + 2, 1, f15942b) || i + 1 == str.length() - 1))) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean m23580e(String str, int i) {
        if (m23581f(str, i + 1) == 'M') {
            return true;
        }
        return m23562a(str, i + -1, 3, "UMB") && (i + 1 == str.length() - 1 || m23562a(str, i + 2, 2, "ER"));
    }

    public static boolean m23560a(char c) {
        return "AEIOUY".indexOf(c) != -1;
    }

    private static boolean m23574c(String str) {
        for (String startsWith : f15941a) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    public static char m23581f(String str, int i) {
        return (i < 0 || i >= str.length()) ? '\u0000' : str.charAt(i);
    }

    public static boolean m23562a(String str, int i, int i2, String str2) {
        return m23568a(str, i, i2, new String[]{str2});
    }

    public static boolean m23563a(String str, int i, int i2, String str2, String str3) {
        return m23568a(str, i, i2, new String[]{str2, str3});
    }

    public static boolean m23564a(String str, int i, int i2, String str2, String str3, String str4) {
        return m23568a(str, i, i2, new String[]{str2, str3, str4});
    }

    private static boolean m23565a(String str, int i, int i2, String str2, String str3, String str4, String str5) {
        return m23568a(str, i, i2, new String[]{str2, str3, str4, str5});
    }

    private static boolean m23566a(String str, int i, int i2, String str2, String str3, String str4, String str5, String str6) {
        return m23568a(str, i, i2, new String[]{str2, str3, str4, str5, str6});
    }

    private static boolean m23567a(String str, int i, int i2, String str2, String str3, String str4, String str5, String str6, String str7) {
        return m23568a(str, i, i2, new String[]{str2, str3, str4, str5, str6, str7});
    }

    private static boolean m23568a(String str, int i, int i2, String[] strArr) {
        if (i < 0 || i + i2 > str.length()) {
            return false;
        }
        String substring = str.substring(i, i + i2);
        for (Object equals : strArr) {
            if (substring.equals(equals)) {
                return true;
            }
        }
        return false;
    }
}
