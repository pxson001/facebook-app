package com.facebook.csslayout;

import com.facebook.csslayout.CSSNode.LayoutState;

/* compiled from: friendsnearby_invite?selected=%s&excluded=%s */
public class LayoutEngine {
    private static final int f22974a = CSSFlexDirection.COLUMN.ordinal();
    private static final int f22975b = CSSFlexDirection.COLUMN_REVERSE.ordinal();
    private static final int f22976c = CSSFlexDirection.ROW.ordinal();
    private static final int f22977d = CSSFlexDirection.ROW_REVERSE.ordinal();
    private static final int f22978e = CSSPositionType.RELATIVE.ordinal();
    private static final int f22979f = CSSPositionType.ABSOLUTE.ordinal();
    private static final int[] f22980g = new int[]{1, 3, 0, 2};
    private static final int[] f22981h = new int[]{3, 1, 2, 0};
    private static final int[] f22982i = new int[]{1, 3, 0, 2};
    private static final int[] f22983j = new int[]{1, 1, 0, 0};
    private static final int[] f22984k = new int[]{1, 3, 6, 6};
    private static final int[] f22985l = new int[]{3, 1, 7, 7};

    private static float m31093a(CSSNode cSSNode, int i, float f) {
        float f2;
        float f3 = Float.NaN;
        if (i == f22974a || i == f22975b) {
            f2 = cSSNode.f22780a.f22817p;
            f3 = cSSNode.f22780a.f22819r;
        } else if (i == f22976c || i == f22977d) {
            f2 = cSSNode.f22780a.f22816o;
            f3 = cSSNode.f22780a.f22818q;
        } else {
            f2 = Float.NaN;
        }
        if (!Float.isNaN(f3) && ((double) f3) >= 0.0d && f > f3) {
            f = f3;
        }
        if (Float.isNaN(f2) || ((double) f2) < 0.0d || f >= f2) {
            return f;
        }
        return f2;
    }

    private static void m31099a(CSSNode cSSNode, int i) {
        if (Float.isNaN(cSSNode.f22781b.f22826b[f22983j[i]]) && !Float.isNaN(cSSNode.f22780a.f22815n[f22983j[i]]) && ((double) cSSNode.f22780a.f22815n[f22983j[i]]) > 0.0d) {
            cSSNode.f22781b.f22826b[f22983j[i]] = Math.max(m31093a(cSSNode, i, cSSNode.f22780a.f22815n[f22983j[i]]), ((cSSNode.f22780a.f22812k.m30943a(f22984k[i], f22980g[i]) + cSSNode.f22780a.f22812k.m30943a(f22985l[i], f22981h[i])) + cSSNode.f22780a.f22813l.m30943a(f22984k[i], f22980g[i])) + cSSNode.f22780a.f22813l.m30943a(f22985l[i], f22981h[i]));
        }
    }

    private static float m31100b(CSSNode cSSNode, int i) {
        float f = cSSNode.f22780a.f22814m[f22980g[i]];
        if (!Float.isNaN(f)) {
            return f;
        }
        f = cSSNode.f22780a.f22814m[f22981h[i]];
        return Float.isNaN(f) ? 0.0f : -f;
    }

    private static int m31094a(int i, CSSDirection cSSDirection) {
        if (cSSDirection != CSSDirection.RTL) {
            return i;
        }
        if (i == f22976c) {
            return f22977d;
        }
        if (i == f22977d) {
            return f22976c;
        }
        return i;
    }

    private static CSSDirection m31097a(CSSNode cSSNode, CSSDirection cSSDirection) {
        CSSDirection cSSDirection2 = cSSNode.f22780a.f22802a;
        if (cSSDirection2 != CSSDirection.INHERIT) {
            return cSSDirection2;
        }
        if (cSSDirection == null) {
            return CSSDirection.LTR;
        }
        return cSSDirection;
    }

    private static int m31095a(CSSNode cSSNode) {
        return cSSNode.f22780a.f22803b.ordinal();
    }

    private static int m31101b(int i, CSSDirection cSSDirection) {
        if (i == f22974a || i == f22975b) {
            return m31094a(f22976c, cSSDirection);
        }
        return f22974a;
    }

    private static CSSAlign m31096a(CSSNode cSSNode, CSSNode cSSNode2) {
        if (cSSNode2.f22780a.f22807f != CSSAlign.AUTO) {
            return cSSNode2.f22780a.f22807f;
        }
        return cSSNode.f22780a.f22806e;
    }

    private static boolean m31103b(CSSNode cSSNode) {
        return cSSNode.e_();
    }

    static void m31098a(CSSLayoutContext cSSLayoutContext, CSSNode cSSNode, float f, float f2, CSSDirection cSSDirection) {
        int i = 0;
        int i2 = 0;
        if (!(!cSSNode.f_() && FloatUtil.m30999a(cSSNode.f22782c.f22829e, cSSNode.f22781b.f22826b[1]) && FloatUtil.m30999a(cSSNode.f22782c.f22828d, cSSNode.f22781b.f22826b[0]) && FloatUtil.m30999a(cSSNode.f22782c.f22830f, f) && FloatUtil.m30999a(cSSNode.f22782c.f22831g, f2))) {
            i2 = 1;
        }
        if (i2 != 0) {
            cSSNode.f22782c.f22828d = cSSNode.f22781b.f22826b[0];
            cSSNode.f22782c.f22829e = cSSNode.f22781b.f22826b[1];
            cSSNode.f22782c.f22830f = f;
            cSSNode.f22782c.f22831g = f2;
            int a = cSSNode.m30841a();
            while (i < a) {
                cSSNode.a_(i).f22781b.m30948a();
                i++;
            }
            m31102b(cSSLayoutContext, cSSNode, f, f2, cSSDirection);
            cSSNode.f22782c.m30949a(cSSNode.f22781b);
        } else {
            cSSNode.f22781b.m30949a(cSSNode.f22782c);
        }
        cSSNode.f22789j = LayoutState.HAS_NEW_LAYOUT;
    }

    private static void m31102b(CSSLayoutContext cSSLayoutContext, CSSNode cSSNode, float f, float f2, CSSDirection cSSDirection) {
        Object obj;
        float f3;
        Object obj2;
        Object obj3;
        int i;
        float f4;
        int i2;
        CSSNode a_;
        CSSNode cSSNode2;
        int i3;
        float f5;
        CSSDirection a = m31097a(cSSNode, cSSDirection);
        int a2 = m31094a(m31095a(cSSNode), a);
        int b = m31101b(a2, a);
        int a3 = m31094a(f22976c, a);
        m31099a(cSSNode, a2);
        m31099a(cSSNode, b);
        cSSNode.f22781b.f22827c = a;
        float[] fArr = cSSNode.f22781b.f22825a;
        int i4 = f22980g[a2];
        fArr[i4] = fArr[i4] + (cSSNode.f22780a.f22811j.m30943a(f22984k[a2], f22980g[a2]) + m31100b(cSSNode, a2));
        fArr = cSSNode.f22781b.f22825a;
        i4 = f22981h[a2];
        fArr[i4] = fArr[i4] + (cSSNode.f22780a.f22811j.m30943a(f22985l[a2], f22981h[a2]) + m31100b(cSSNode, a2));
        fArr = cSSNode.f22781b.f22825a;
        i4 = f22980g[b];
        fArr[i4] = fArr[i4] + (cSSNode.f22780a.f22811j.m30943a(f22984k[b], f22980g[b]) + m31100b(cSSNode, b));
        fArr = cSSNode.f22781b.f22825a;
        i4 = f22981h[b];
        fArr[i4] = fArr[i4] + (cSSNode.f22780a.f22811j.m30943a(f22985l[b], f22981h[b]) + m31100b(cSSNode, b));
        int a4 = cSSNode.m30841a();
        float a5 = (cSSNode.f22780a.f22812k.m30943a(f22984k[a3], f22980g[a3]) + cSSNode.f22780a.f22813l.m30943a(f22984k[a3], f22980g[a3])) + (cSSNode.f22780a.f22812k.m30943a(f22985l[a3], f22981h[a3]) + cSSNode.f22780a.f22813l.m30943a(f22985l[a3], f22981h[a3]));
        float a6 = (cSSNode.f22780a.f22812k.m30943a(f22984k[f22974a], f22980g[f22974a]) + cSSNode.f22780a.f22813l.m30943a(f22984k[f22974a], f22980g[f22974a])) + (cSSNode.f22780a.f22812k.m30943a(f22985l[f22974a], f22981h[f22974a]) + cSSNode.f22780a.f22813l.m30943a(f22985l[f22974a], f22981h[f22974a]));
        if (m31103b(cSSNode)) {
            float f6;
            CSSMeasureMode cSSMeasureMode;
            CSSMeasureMode cSSMeasureMode2;
            obj = (Float.isNaN(cSSNode.f22781b.f22826b[f22983j[a3]]) || ((double) cSSNode.f22781b.f22826b[f22983j[a3]]) < 0.0d) ? null : 1;
            CSSMeasureMode cSSMeasureMode3 = CSSMeasureMode.UNDEFINED;
            if (!Float.isNaN(cSSNode.f22780a.f22815n[f22983j[a3]]) && ((double) cSSNode.f22780a.f22815n[f22983j[a3]]) >= 0.0d) {
                f6 = cSSNode.f22780a.f22815n[0];
                cSSMeasureMode3 = CSSMeasureMode.EXACTLY;
            } else if (obj != null) {
                f6 = cSSNode.f22781b.f22826b[f22983j[a3]];
                cSSMeasureMode3 = CSSMeasureMode.EXACTLY;
            } else {
                f6 = f - (cSSNode.f22780a.f22811j.m30943a(f22984k[a3], f22980g[a3]) + cSSNode.f22780a.f22811j.m30943a(f22985l[a3], f22981h[a3]));
                cSSMeasureMode3 = CSSMeasureMode.AT_MOST;
            }
            f6 -= a5;
            if (Float.isNaN(f6)) {
                cSSMeasureMode = CSSMeasureMode.UNDEFINED;
            } else {
                cSSMeasureMode = cSSMeasureMode3;
            }
            cSSMeasureMode3 = CSSMeasureMode.UNDEFINED;
            if (!Float.isNaN(cSSNode.f22780a.f22815n[f22983j[f22974a]]) && ((double) cSSNode.f22780a.f22815n[f22983j[f22974a]]) >= 0.0d) {
                f3 = cSSNode.f22780a.f22815n[1];
                cSSMeasureMode3 = CSSMeasureMode.EXACTLY;
            } else if (Float.isNaN(cSSNode.f22781b.f22826b[f22983j[f22974a]]) || ((double) cSSNode.f22781b.f22826b[f22983j[f22974a]]) < 0.0d) {
                f3 = f2 - (cSSNode.f22780a.f22811j.m30943a(f22984k[a3], f22980g[a3]) + cSSNode.f22780a.f22811j.m30943a(f22985l[a3], f22981h[a3]));
                cSSMeasureMode3 = CSSMeasureMode.AT_MOST;
            } else {
                f3 = cSSNode.f22781b.f22826b[f22983j[f22974a]];
                cSSMeasureMode3 = CSSMeasureMode.EXACTLY;
            }
            f3 -= (cSSNode.f22780a.f22812k.m30943a(f22984k[f22974a], f22980g[f22974a]) + cSSNode.f22780a.f22813l.m30943a(f22984k[f22974a], f22980g[f22974a])) + (cSSNode.f22780a.f22812k.m30943a(f22985l[f22974a], f22981h[f22974a]) + cSSNode.f22780a.f22813l.m30943a(f22985l[f22974a], f22981h[f22974a]));
            if (Float.isNaN(f3)) {
                cSSMeasureMode2 = CSSMeasureMode.UNDEFINED;
            } else {
                cSSMeasureMode2 = cSSMeasureMode3;
            }
            Object obj4 = ((Float.isNaN(cSSNode.f22780a.f22815n[f22983j[a3]]) || ((double) cSSNode.f22780a.f22815n[f22983j[a3]]) < 0.0d) && obj == null) ? 1 : null;
            if ((Float.isNaN(cSSNode.f22780a.f22815n[f22983j[f22974a]]) || ((double) cSSNode.f22780a.f22815n[f22983j[f22974a]]) < 0.0d) && Float.isNaN(cSSNode.f22781b.f22826b[f22983j[f22974a]])) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (!(obj4 == null && obj2 == null)) {
                MeasureOutput a7 = cSSNode.m30843a(cSSLayoutContext.f22744a, f6, cSSMeasureMode, f3, cSSMeasureMode2);
                if (obj4 != null) {
                    cSSNode.f22781b.f22826b[0] = a7.f22745a + a5;
                }
                if (obj2 != null) {
                    cSSNode.f22781b.f22826b[1] = a7.f22746b + a6;
                }
            }
            if (a4 == 0) {
                return;
            }
        }
        obj = cSSNode.f22780a.f22809h == CSSWrap.WRAP ? 1 : null;
        CSSJustify cSSJustify = cSSNode.f22780a.f22804c;
        float a8 = cSSNode.f22780a.f22812k.m30943a(f22984k[a2], f22980g[a2]) + cSSNode.f22780a.f22813l.m30943a(f22984k[a2], f22980g[a2]);
        float a9 = cSSNode.f22780a.f22812k.m30943a(f22984k[b], f22980g[b]) + cSSNode.f22780a.f22813l.m30943a(f22984k[b], f22980g[b]);
        float a10 = (cSSNode.f22780a.f22812k.m30943a(f22984k[a2], f22980g[a2]) + cSSNode.f22780a.f22813l.m30943a(f22984k[a2], f22980g[a2])) + (cSSNode.f22780a.f22812k.m30943a(f22985l[a2], f22981h[a2]) + cSSNode.f22780a.f22813l.m30943a(f22985l[a2], f22981h[a2]));
        float a11 = (cSSNode.f22780a.f22812k.m30943a(f22984k[b], f22980g[b]) + cSSNode.f22780a.f22813l.m30943a(f22984k[b], f22980g[b])) + (cSSNode.f22780a.f22812k.m30943a(f22985l[b], f22981h[b]) + cSSNode.f22780a.f22813l.m30943a(f22985l[b], f22981h[b]));
        Object obj5 = (Float.isNaN(cSSNode.f22781b.f22826b[f22983j[a2]]) || ((double) cSSNode.f22781b.f22826b[f22983j[a2]]) < 0.0d) ? null : 1;
        Object obj6 = (Float.isNaN(cSSNode.f22781b.f22826b[f22983j[b]]) || ((double) cSSNode.f22781b.f22826b[f22983j[b]]) < 0.0d) ? null : 1;
        if (a2 == f22976c || a2 == f22977d) {
            obj3 = 1;
        } else {
            obj3 = null;
        }
        float f7 = Float.NaN;
        if (obj5 != null) {
            f7 = cSSNode.f22781b.f22826b[f22983j[a2]] - a10;
        }
        float f8 = 0.0f;
        float f9 = 0.0f;
        CSSNode cSSNode3 = null;
        int i5 = 0;
        int i6 = 0;
        CSSNode cSSNode4 = null;
        int i7 = 0;
        Object obj7 = null;
        while (i5 < a4) {
            int i8;
            float f10;
            CSSNode cSSNode5;
            Object obj8;
            float f11;
            CSSNode cSSNode6;
            int i9;
            obj2 = ((obj5 == null || cSSJustify != CSSJustify.FLEX_START) && (obj5 != null || cSSJustify == CSSJustify.CENTER)) ? null : 1;
            if (obj2 != null) {
                i = a4;
            } else {
                i = i6;
            }
            CSSNode cSSNode7 = null;
            float f12 = 0.0f;
            int i10 = i6;
            float f13 = a8;
            CSSNode cSSNode8 = null;
            Object obj9 = 1;
            Object obj10 = obj2;
            float f14 = 0.0f;
            float f15 = Float.NaN;
            int i11 = a4;
            Object obj11 = obj7;
            int i12 = 0;
            int i13 = i5;
            int i14 = i;
            float f16 = Float.NaN;
            int i15 = 0;
            CSSNode cSSNode9 = cSSNode3;
            float f17 = 0.0f;
            while (i10 < a4) {
                CSSNode cSSNode10;
                CSSNode cSSNode11;
                int i16;
                int i17;
                CSSNode a_2 = cSSNode.a_(i10);
                a_2.f22783d = i7;
                a_2.f22784e = null;
                a_2.f22785f = null;
                CSSAlign a12 = m31096a(cSSNode, a_2);
                if (a12 != CSSAlign.STRETCH || a_2.f22780a.f22808g != CSSPositionType.RELATIVE || obj6 == null || (!Float.isNaN(a_2.f22780a.f22815n[f22983j[b]]) && ((double) a_2.f22780a.f22815n[f22983j[b]]) >= 0.0d)) {
                    if (a_2.f22780a.f22808g == CSSPositionType.ABSOLUTE) {
                        if (cSSNode4 == null) {
                            cSSNode10 = a_2;
                        } else {
                            cSSNode10 = cSSNode4;
                        }
                        if (cSSNode9 != null) {
                            cSSNode9.f22784e = a_2;
                        }
                        i8 = 0;
                        while (i8 < 2) {
                            i = i8 != 0 ? f22976c : f22974a;
                            if (!(Float.isNaN(cSSNode.f22781b.f22826b[f22983j[i]]) || ((double) cSSNode.f22781b.f22826b[f22983j[i]]) < 0.0d || ((!Float.isNaN(a_2.f22780a.f22815n[f22983j[i]]) && ((double) a_2.f22780a.f22815n[f22983j[i]]) >= 0.0d) || Float.isNaN(a_2.f22780a.f22814m[f22980g[i]]) || Float.isNaN(a_2.f22780a.f22814m[f22981h[i]])))) {
                                float[] fArr2 = a_2.f22781b.f22826b;
                                int i18 = f22983j[i];
                                float a13 = (cSSNode.f22781b.f22826b[f22983j[i]] - ((cSSNode.f22780a.f22812k.m30943a(f22984k[i], f22980g[i]) + cSSNode.f22780a.f22813l.m30943a(f22984k[i], f22980g[i])) + (cSSNode.f22780a.f22812k.m30943a(f22985l[i], f22981h[i]) + cSSNode.f22780a.f22813l.m30943a(f22985l[i], f22981h[i])))) - (a_2.f22780a.f22811j.m30943a(f22984k[i], f22980g[i]) + a_2.f22780a.f22811j.m30943a(f22985l[i], f22981h[i]));
                                if (Float.isNaN(a_2.f22780a.f22814m[f22980g[i]])) {
                                    f10 = 0.0f;
                                } else {
                                    f10 = a_2.f22780a.f22814m[f22980g[i]];
                                }
                                a13 -= f10;
                                if (Float.isNaN(a_2.f22780a.f22814m[f22981h[i]])) {
                                    f10 = 0.0f;
                                } else {
                                    f10 = a_2.f22780a.f22814m[f22981h[i]];
                                }
                                fArr2[i18] = Math.max(m31093a(a_2, i, a13 - f10), (a_2.f22780a.f22813l.m30943a(f22985l[i], f22981h[i]) + a_2.f22780a.f22812k.m30943a(f22985l[i], f22981h[i])) + (a_2.f22780a.f22812k.m30943a(f22984k[i], f22980g[i]) + a_2.f22780a.f22813l.m30943a(f22984k[i], f22980g[i])));
                            }
                            i8++;
                        }
                        cSSNode11 = a_2;
                    } else {
                        cSSNode11 = cSSNode9;
                        cSSNode10 = cSSNode4;
                    }
                } else {
                    a_2.f22781b.f22826b[f22983j[b]] = Math.max(m31093a(a_2, b, (cSSNode.f22781b.f22826b[f22983j[b]] - a11) - (a_2.f22780a.f22811j.m30943a(f22984k[b], f22980g[b]) + a_2.f22780a.f22811j.m30943a(f22985l[b], f22981h[b]))), (a_2.f22780a.f22812k.m30943a(f22984k[b], f22980g[b]) + a_2.f22780a.f22813l.m30943a(f22984k[b], f22980g[b])) + (a_2.f22780a.f22812k.m30943a(f22985l[b], f22981h[b]) + a_2.f22780a.f22813l.m30943a(f22985l[b], f22981h[b])));
                    cSSNode11 = cSSNode9;
                    cSSNode10 = cSSNode4;
                }
                if (obj5 == null || a_2.f22780a.f22808g != CSSPositionType.RELATIVE || a_2.f22780a.f22810i <= 0.0f) {
                    f10 = Float.NaN;
                    f3 = Float.NaN;
                    if (obj3 == null) {
                        f10 = (Float.isNaN(cSSNode.f22781b.f22826b[f22983j[a3]]) || ((double) cSSNode.f22781b.f22826b[f22983j[a3]]) < 0.0d) ? (f - (cSSNode.f22780a.f22811j.m30943a(f22984k[a3], f22980g[a3]) + cSSNode.f22780a.f22811j.m30943a(f22985l[a3], f22981h[a3]))) - a5 : cSSNode.f22781b.f22826b[f22983j[a3]] - a5;
                    } else {
                        f3 = (Float.isNaN(cSSNode.f22781b.f22826b[f22983j[f22974a]]) || ((double) cSSNode.f22781b.f22826b[f22983j[f22974a]]) < 0.0d) ? (f2 - (cSSNode.f22780a.f22811j.m30943a(f22984k[f22974a], f22980g[f22974a]) + cSSNode.f22780a.f22811j.m30943a(f22985l[f22974a], f22981h[f22974a]))) - a6 : cSSNode.f22781b.f22826b[f22983j[f22974a]] - a6;
                    }
                    if (obj11 == null) {
                        m31098a(cSSLayoutContext, a_2, f10, f3, a);
                    }
                    if (a_2.f22780a.f22808g == CSSPositionType.RELATIVE) {
                        f16 = f10;
                        f10 = (a_2.f22781b.f22826b[f22983j[a2]] + a_2.f22780a.f22811j.m30943a(f22984k[a2], f22980g[a2])) + a_2.f22780a.f22811j.m30943a(f22985l[a2], f22981h[a2]);
                        f15 = f17;
                        i16 = i12 + 1;
                        i12 = i15;
                        cSSNode5 = cSSNode8;
                        i17 = i16;
                    } else {
                        f16 = f10;
                        f15 = f17;
                        f10 = 0.0f;
                        i16 = i12;
                        i12 = i15;
                        cSSNode5 = cSSNode8;
                        i17 = i16;
                    }
                } else {
                    i15++;
                    f17 += a_2.f22780a.f22810i;
                    if (cSSNode7 == null) {
                        cSSNode7 = a_2;
                    }
                    if (cSSNode8 != null) {
                        cSSNode8.f22785f = a_2;
                    }
                    f10 = ((a_2.f22780a.f22812k.m30943a(f22984k[a2], f22980g[a2]) + a_2.f22780a.f22813l.m30943a(f22984k[a2], f22980g[a2])) + (a_2.f22780a.f22812k.m30943a(f22985l[a2], f22981h[a2]) + a_2.f22780a.f22813l.m30943a(f22985l[a2], f22981h[a2]))) + (a_2.f22780a.f22811j.m30943a(f22984k[a2], f22980g[a2]) + a_2.f22780a.f22811j.m30943a(f22985l[a2], f22981h[a2]));
                    i17 = i12;
                    f3 = f15;
                    i12 = i15;
                    f15 = f17;
                    cSSNode5 = a_2;
                }
                if (obj != null && obj5 != null && f14 + f10 > f7 && i10 != i6) {
                    obj8 = 1;
                    f11 = f3;
                    cSSNode5 = cSSNode11;
                    cSSNode6 = cSSNode10;
                    i9 = i12;
                    i8 = i17 - 1;
                    f10 = f15;
                    break;
                }
                Object obj12;
                int i19;
                if (obj10 == null || (a_2.f22780a.f22808g == CSSPositionType.RELATIVE && (a_2.f22780a.f22808g != CSSPositionType.RELATIVE || a_2.f22780a.f22810i <= 0.0f))) {
                    obj11 = obj10;
                } else {
                    i14 = i10;
                    obj11 = null;
                }
                if (obj9 == null || (a_2.f22780a.f22808g == CSSPositionType.RELATIVE && ((a12 == CSSAlign.STRETCH || a12 == CSSAlign.FLEX_START) && !(a12 == CSSAlign.STRETCH && obj6 == null)))) {
                    obj12 = obj9;
                } else {
                    i11 = i10;
                    obj12 = null;
                }
                if (obj11 != null) {
                    float[] fArr3 = a_2.f22781b.f22825a;
                    i19 = f22982i[a2];
                    fArr3[i19] = fArr3[i19] + f13;
                    if (obj5 != null) {
                        a_2.f22781b.f22825a[f22981h[a2]] = (cSSNode.f22781b.f22826b[f22983j[a2]] - a_2.f22781b.f22826b[f22983j[a2]]) - a_2.f22781b.f22825a[f22982i[a2]];
                    }
                    f17 = ((a_2.f22781b.f22826b[f22983j[a2]] + a_2.f22780a.f22811j.m30943a(f22984k[a2], f22980g[a2])) + a_2.f22780a.f22811j.m30943a(f22985l[a2], f22981h[a2])) + f13;
                    f12 = Math.max(f12, m31093a(a_2, b, (a_2.f22781b.f22826b[f22983j[b]] + a_2.f22780a.f22811j.m30943a(f22984k[b], f22980g[b])) + a_2.f22780a.f22811j.m30943a(f22985l[b], f22981h[b])));
                } else {
                    f17 = f13;
                }
                if (obj12 != null) {
                    float[] fArr4 = a_2.f22781b.f22825a;
                    i19 = f22982i[b];
                    fArr4[i19] = fArr4[i19] + (f9 + a9);
                    if (obj6 != null) {
                        a_2.f22781b.f22825a[f22981h[b]] = (cSSNode.f22781b.f22826b[f22983j[b]] - a_2.f22781b.f22826b[f22983j[b]]) - a_2.f22781b.f22825a[f22982i[b]];
                    }
                }
                i19 = i10 + 1;
                i10++;
                obj10 = obj11;
                f14 += f10;
                obj11 = null;
                cSSNode4 = cSSNode10;
                f13 = f17;
                f17 = f15;
                f15 = f3;
                cSSNode9 = cSSNode11;
                i16 = i17;
                cSSNode8 = cSSNode5;
                i15 = i12;
                i12 = i16;
                int i20 = i19;
                obj9 = obj12;
                i13 = i20;
            }
            f11 = f15;
            i8 = i12;
            i9 = i15;
            cSSNode5 = cSSNode9;
            Object obj13 = obj11;
            cSSNode6 = cSSNode4;
            f10 = f17;
            obj8 = obj13;
            if (obj5 != null) {
                f3 = f7 - f14;
            } else {
                f3 = Math.max(f14, 0.0f) - f14;
            }
            if (i9 != 0) {
                float f18 = f3 / f10;
                for (cSSNode11 = cSSNode7; cSSNode11 != null; cSSNode11 = cSSNode11.f22785f) {
                    float a14 = (cSSNode11.f22780a.f22810i * f18) + ((cSSNode11.f22780a.f22812k.m30943a(f22984k[a2], f22980g[a2]) + cSSNode11.f22780a.f22813l.m30943a(f22984k[a2], f22980g[a2])) + (cSSNode11.f22780a.f22812k.m30943a(f22985l[a2], f22981h[a2]) + cSSNode11.f22780a.f22813l.m30943a(f22985l[a2], f22981h[a2])));
                    float a15 = m31093a(cSSNode11, a2, a14);
                    if (a14 != a15) {
                        f3 -= a15;
                        f10 -= cSSNode11.f22780a.f22810i;
                    }
                }
                f3 /= f10;
                if (f3 < 0.0f) {
                    f3 = 0.0f;
                }
                f10 = f11;
                f11 = f16;
                CSSNode cSSNode12 = cSSNode7;
                while (cSSNode12 != null) {
                    cSSNode12.f22781b.f22826b[f22983j[a2]] = m31093a(cSSNode12, a2, (cSSNode12.f22780a.f22810i * f3) + ((cSSNode12.f22780a.f22812k.m30943a(f22984k[a2], f22980g[a2]) + cSSNode12.f22780a.f22813l.m30943a(f22984k[a2], f22980g[a2])) + (cSSNode12.f22780a.f22812k.m30943a(f22985l[a2], f22981h[a2]) + cSSNode12.f22780a.f22813l.m30943a(f22985l[a2], f22981h[a2]))));
                    f10 = Float.NaN;
                    if (!Float.isNaN(cSSNode.f22781b.f22826b[f22983j[a3]]) && ((double) cSSNode.f22781b.f22826b[f22983j[a3]]) >= 0.0d) {
                        f10 = cSSNode.f22781b.f22826b[f22983j[a3]] - a5;
                    } else if (obj3 == null) {
                        f10 = (f - (cSSNode.f22780a.f22811j.m30943a(f22984k[a3], f22980g[a3]) + cSSNode.f22780a.f22811j.m30943a(f22985l[a3], f22981h[a3]))) - a5;
                    }
                    f11 = Float.NaN;
                    if (!Float.isNaN(cSSNode.f22781b.f22826b[f22983j[f22974a]]) && ((double) cSSNode.f22781b.f22826b[f22983j[f22974a]]) >= 0.0d) {
                        f11 = cSSNode.f22781b.f22826b[f22983j[f22974a]] - a6;
                    } else if (obj3 != null) {
                        f11 = (f2 - (cSSNode.f22780a.f22811j.m30943a(f22984k[f22974a], f22980g[f22974a]) + cSSNode.f22780a.f22811j.m30943a(f22985l[f22974a], f22981h[f22974a]))) - a6;
                    }
                    m31098a(cSSLayoutContext, cSSNode12, f10, f11, a);
                    cSSNode7 = cSSNode12.f22785f;
                    cSSNode12.f22785f = null;
                    cSSNode12 = cSSNode7;
                    float f19 = f10;
                    f10 = f11;
                    f11 = f19;
                }
                f3 = 0.0f;
                f15 = f11;
                f11 = f10;
                f10 = 0.0f;
            } else {
                if (cSSJustify != CSSJustify.FLEX_START) {
                    if (cSSJustify == CSSJustify.CENTER) {
                        f10 = f3 / 2.0f;
                        f3 = 0.0f;
                        f15 = f16;
                    } else if (cSSJustify == CSSJustify.FLEX_END) {
                        f10 = f3;
                        f3 = 0.0f;
                        f15 = f16;
                    } else if (cSSJustify == CSSJustify.SPACE_BETWEEN) {
                        f3 = Math.max(f3, 0.0f);
                        if ((i9 + i8) - 1 != 0) {
                            f3 /= (float) ((i9 + i8) - 1);
                            f10 = 0.0f;
                            f15 = f16;
                        } else {
                            f3 = 0.0f;
                            f10 = 0.0f;
                            f15 = f16;
                        }
                    } else if (cSSJustify == CSSJustify.SPACE_AROUND) {
                        f3 /= (float) (i9 + i8);
                        f10 = f3 / 2.0f;
                        f15 = f16;
                    }
                }
                f3 = 0.0f;
                f10 = 0.0f;
                f15 = f16;
            }
            f16 = f13 + f10;
            float f20 = f12;
            while (i14 < i13) {
                CSSNode a_3 = cSSNode.a_(i14);
                if (a_3.f22780a.f22808g != CSSPositionType.ABSOLUTE || Float.isNaN(a_3.f22780a.f22814m[f22980g[a2]])) {
                    float[] fArr5 = a_3.f22781b.f22825a;
                    int i21 = f22982i[a2];
                    fArr5[i21] = fArr5[i21] + f16;
                    if (obj5 != null) {
                        a_3.f22781b.f22825a[f22981h[a2]] = (cSSNode.f22781b.f22826b[f22983j[a2]] - a_3.f22781b.f22826b[f22983j[a2]]) - a_3.f22781b.f22825a[f22982i[a2]];
                    }
                    if (a_3.f22780a.f22808g == CSSPositionType.RELATIVE) {
                        f16 += ((a_3.f22781b.f22826b[f22983j[a2]] + a_3.f22780a.f22811j.m30943a(f22984k[a2], f22980g[a2])) + a_3.f22780a.f22811j.m30943a(f22985l[a2], f22981h[a2])) + f3;
                        f10 = Math.max(f20, m31093a(a_3, b, (a_3.f22781b.f22826b[f22983j[b]] + a_3.f22780a.f22811j.m30943a(f22984k[b], f22980g[b])) + a_3.f22780a.f22811j.m30943a(f22985l[b], f22981h[b])));
                        f20 = f16;
                    } else {
                        f10 = f20;
                        f20 = f16;
                    }
                } else {
                    float[] fArr6 = a_3.f22781b.f22825a;
                    i8 = f22982i[a2];
                    if (Float.isNaN(a_3.f22780a.f22814m[f22980g[a2]])) {
                        f10 = 0.0f;
                    } else {
                        f10 = a_3.f22780a.f22814m[f22980g[a2]];
                    }
                    fArr6[i8] = (f10 + cSSNode.f22780a.f22813l.m30943a(f22984k[a2], f22980g[a2])) + a_3.f22780a.f22811j.m30943a(f22984k[a2], f22980g[a2]);
                    f10 = f20;
                    f20 = f16;
                }
                i14++;
                f16 = f20;
                f20 = f10;
            }
            f3 = cSSNode.f22781b.f22826b[f22983j[b]];
            if (obj6 == null) {
                f3 = Math.max(m31093a(cSSNode, b, f20 + a11), a11);
            }
            while (i11 < i13) {
                CSSNode a_4 = cSSNode.a_(i11);
                float[] fArr7;
                if (a_4.f22780a.f22808g != CSSPositionType.ABSOLUTE || Float.isNaN(a_4.f22780a.f22814m[f22980g[b]])) {
                    if (a_4.f22780a.f22808g == CSSPositionType.RELATIVE) {
                        CSSAlign a16 = m31096a(cSSNode, a_4);
                        if (a16 == CSSAlign.STRETCH) {
                            if (Float.isNaN(a_4.f22780a.f22815n[f22983j[b]]) || ((double) a_4.f22780a.f22815n[f22983j[b]]) < 0.0d) {
                                f10 = a_4.f22781b.f22826b[f22983j[b]];
                                a_4.f22781b.f22826b[f22983j[b]] = Math.max(m31093a(a_4, b, (f3 - a11) - (a_4.f22780a.f22811j.m30943a(f22984k[b], f22980g[b]) + a_4.f22780a.f22811j.m30943a(f22985l[b], f22981h[b]))), (a_4.f22780a.f22812k.m30943a(f22984k[b], f22980g[b]) + a_4.f22780a.f22813l.m30943a(f22984k[b], f22980g[b])) + (a_4.f22780a.f22812k.m30943a(f22985l[b], f22981h[b]) + a_4.f22780a.f22813l.m30943a(f22985l[b], f22981h[b])));
                                if (f10 != a_4.f22781b.f22826b[f22983j[b]] && a_4.m30841a() > 0) {
                                    fArr5 = a_4.f22781b.f22825a;
                                    int i22 = f22980g[a2];
                                    fArr5[i22] = fArr5[i22] - (a_4.f22780a.f22811j.m30943a(f22984k[a2], f22980g[a2]) + m31100b(a_4, a2));
                                    fArr5 = a_4.f22781b.f22825a;
                                    i22 = f22981h[a2];
                                    fArr5[i22] = fArr5[i22] - (a_4.f22780a.f22811j.m30943a(f22985l[a2], f22981h[a2]) + m31100b(a_4, a2));
                                    fArr5 = a_4.f22781b.f22825a;
                                    i22 = f22980g[b];
                                    fArr5[i22] = fArr5[i22] - (a_4.f22780a.f22811j.m30943a(f22984k[b], f22980g[b]) + m31100b(a_4, b));
                                    fArr5 = a_4.f22781b.f22825a;
                                    i22 = f22981h[b];
                                    fArr5[i22] = fArr5[i22] - (a_4.f22780a.f22811j.m30943a(f22985l[b], f22981h[b]) + m31100b(a_4, b));
                                    m31098a(cSSLayoutContext, a_4, f15, f11, a);
                                }
                                f10 = a9;
                                fArr7 = a_4.f22781b.f22825a;
                                i21 = f22982i[b];
                                fArr7[i21] = (f10 + f9) + fArr7[i21];
                                if (obj6 == null) {
                                    a_4.f22781b.f22825a[f22981h[b]] = (cSSNode.f22781b.f22826b[f22983j[b]] - a_4.f22781b.f22826b[f22983j[b]]) - a_4.f22781b.f22825a[f22982i[b]];
                                }
                            }
                        } else if (a16 != CSSAlign.FLEX_START) {
                            f12 = (f3 - a11) - ((a_4.f22781b.f22826b[f22983j[b]] + a_4.f22780a.f22811j.m30943a(f22984k[b], f22980g[b])) + a_4.f22780a.f22811j.m30943a(f22985l[b], f22981h[b]));
                            if (a16 == CSSAlign.CENTER) {
                                f10 = (f12 / 2.0f) + a9;
                            } else {
                                f10 = a9 + f12;
                            }
                            fArr7 = a_4.f22781b.f22825a;
                            i21 = f22982i[b];
                            fArr7[i21] = (f10 + f9) + fArr7[i21];
                            if (obj6 == null) {
                                a_4.f22781b.f22825a[f22981h[b]] = (cSSNode.f22781b.f22826b[f22983j[b]] - a_4.f22781b.f22826b[f22983j[b]]) - a_4.f22781b.f22825a[f22982i[b]];
                            }
                        }
                    }
                    f10 = a9;
                    fArr7 = a_4.f22781b.f22825a;
                    i21 = f22982i[b];
                    fArr7[i21] = (f10 + f9) + fArr7[i21];
                    if (obj6 == null) {
                        a_4.f22781b.f22825a[f22981h[b]] = (cSSNode.f22781b.f22826b[f22983j[b]] - a_4.f22781b.f22826b[f22983j[b]]) - a_4.f22781b.f22825a[f22982i[b]];
                    }
                } else {
                    fArr7 = a_4.f22781b.f22825a;
                    i21 = f22982i[b];
                    if (Float.isNaN(a_4.f22780a.f22814m[f22980g[b]])) {
                        f10 = 0.0f;
                    } else {
                        f10 = a_4.f22780a.f22814m[f22980g[b]];
                    }
                    fArr7[i21] = (f10 + cSSNode.f22780a.f22813l.m30943a(f22984k[b], f22980g[b])) + a_4.f22780a.f22811j.m30943a(f22984k[b], f22980g[b]);
                }
                i11++;
            }
            f11 = f9 + f20;
            i7++;
            f8 = Math.max(f8, f16);
            f9 = f11;
            obj7 = obj8;
            i5 = i13;
            i6 = i13;
            cSSNode3 = cSSNode5;
            cSSNode4 = cSSNode6;
        }
        if (i7 > 1 && obj6 != null) {
            f7 = cSSNode.f22781b.f22826b[f22983j[b]] - a11;
            f3 = f7 - f9;
            f4 = 0.0f;
            CSSAlign cSSAlign = cSSNode.f22780a.f22805d;
            if (cSSAlign == CSSAlign.FLEX_END) {
                a9 += f3;
            } else if (cSSAlign == CSSAlign.CENTER) {
                a9 += f3 / 2.0f;
            } else if (cSSAlign == CSSAlign.STRETCH && f7 > f9) {
                f4 = f3 / ((float) i7);
            }
            i = 0;
            int i23 = 0;
            while (i23 < i7) {
                f7 = 0.0f;
                i6 = i;
                while (i6 < a4) {
                    CSSNode a_5 = cSSNode.a_(i6);
                    if (a_5.f22780a.f22808g == CSSPositionType.RELATIVE) {
                        if (a_5.f22783d != i23) {
                            break;
                        } else if (!Float.isNaN(a_5.f22781b.f22826b[f22983j[b]]) && ((double) a_5.f22781b.f22826b[f22983j[b]]) >= 0.0d) {
                            f7 = Math.max(f7, (a_5.f22780a.f22811j.m30943a(f22985l[b], f22981h[b]) + a_5.f22780a.f22811j.m30943a(f22984k[b], f22980g[b])) + a_5.f22781b.f22826b[f22983j[b]]);
                        }
                    }
                    i6++;
                }
                f20 = f7 + f4;
                for (int i24 = i; i24 < i6; i24++) {
                    cSSNode9 = cSSNode.a_(i24);
                    if (cSSNode9.f22780a.f22808g == CSSPositionType.RELATIVE) {
                        CSSAlign a17 = m31096a(cSSNode, cSSNode9);
                        if (a17 == CSSAlign.FLEX_START) {
                            cSSNode9.f22781b.f22825a[f22982i[b]] = cSSNode9.f22780a.f22811j.m30943a(f22984k[b], f22980g[b]) + a9;
                        } else if (a17 == CSSAlign.FLEX_END) {
                            cSSNode9.f22781b.f22825a[f22982i[b]] = ((a9 + f20) - cSSNode9.f22780a.f22811j.m30943a(f22985l[b], f22981h[b])) - cSSNode9.f22781b.f22826b[f22983j[b]];
                        } else if (a17 == CSSAlign.CENTER) {
                            cSSNode9.f22781b.f22825a[f22982i[b]] = ((f20 - cSSNode9.f22781b.f22826b[f22983j[b]]) / 2.0f) + a9;
                        } else if (a17 == CSSAlign.STRETCH) {
                            cSSNode9.f22781b.f22825a[f22982i[b]] = cSSNode9.f22780a.f22811j.m30943a(f22984k[b], f22980g[b]) + a9;
                        }
                    }
                }
                a9 += f20;
                i23++;
                i = i6;
            }
        }
        Object obj14 = null;
        if (obj5 == null) {
            cSSNode.f22781b.f22826b[f22983j[a2]] = Math.max(m31093a(cSSNode, a2, (cSSNode.f22780a.f22812k.m30943a(f22985l[a2], f22981h[a2]) + cSSNode.f22780a.f22813l.m30943a(f22985l[a2], f22981h[a2])) + f8), a10);
            if (a2 == f22977d || a2 == f22975b) {
                obj14 = 1;
            }
        }
        if (obj6 == null) {
            cSSNode.f22781b.f22826b[f22983j[b]] = Math.max(m31093a(cSSNode, b, f9 + a11), a11);
            if (b == f22977d || b == f22975b) {
                obj5 = 1;
                if (!(obj14 == null && obj5 == null)) {
                    for (i2 = 0; i2 < a4; i2++) {
                        a_ = cSSNode.a_(i2);
                        if (obj14 != null) {
                            a_.f22781b.f22825a[f22981h[a2]] = (cSSNode.f22781b.f22826b[f22983j[a2]] - a_.f22781b.f22826b[f22983j[a2]]) - a_.f22781b.f22825a[f22982i[a2]];
                        }
                        if (obj5 != null) {
                            a_.f22781b.f22825a[f22981h[b]] = (cSSNode.f22781b.f22826b[f22983j[b]] - a_.f22781b.f22826b[f22983j[b]]) - a_.f22781b.f22825a[f22982i[b]];
                        }
                    }
                }
                cSSNode2 = cSSNode4;
                while (cSSNode2 != null) {
                    i3 = 0;
                    while (i3 < 2) {
                        i2 = i3 == 0 ? f22976c : f22974a;
                        if (!(Float.isNaN(cSSNode.f22781b.f22826b[f22983j[i2]]) || ((double) cSSNode.f22781b.f22826b[f22983j[i2]]) < 0.0d || ((!Float.isNaN(cSSNode2.f22780a.f22815n[f22983j[i2]]) && ((double) cSSNode2.f22780a.f22815n[f22983j[i2]]) >= 0.0d) || Float.isNaN(cSSNode2.f22780a.f22814m[f22980g[i2]]) || Float.isNaN(cSSNode2.f22780a.f22814m[f22981h[i2]])))) {
                            float[] fArr8 = cSSNode2.f22781b.f22826b;
                            int i25 = f22983j[i2];
                            f11 = (cSSNode.f22781b.f22826b[f22983j[i2]] - (cSSNode.f22780a.f22813l.m30943a(f22984k[i2], f22980g[i2]) + cSSNode.f22780a.f22813l.m30943a(f22985l[i2], f22981h[i2]))) - (cSSNode2.f22780a.f22811j.m30943a(f22984k[i2], f22980g[i2]) + cSSNode2.f22780a.f22811j.m30943a(f22985l[i2], f22981h[i2]));
                            if (Float.isNaN(cSSNode2.f22780a.f22814m[f22980g[i2]])) {
                                f5 = cSSNode2.f22780a.f22814m[f22980g[i2]];
                            } else {
                                f5 = 0.0f;
                            }
                            f11 -= f5;
                            if (Float.isNaN(cSSNode2.f22780a.f22814m[f22981h[i2]])) {
                                f5 = cSSNode2.f22780a.f22814m[f22981h[i2]];
                            } else {
                                f5 = 0.0f;
                            }
                            fArr8[i25] = Math.max(m31093a(cSSNode2, i2, f11 - f5), (cSSNode2.f22780a.f22812k.m30943a(f22984k[i2], f22980g[i2]) + cSSNode2.f22780a.f22813l.m30943a(f22984k[i2], f22980g[i2])) + (cSSNode2.f22780a.f22812k.m30943a(f22985l[i2], f22981h[i2]) + cSSNode2.f22780a.f22813l.m30943a(f22985l[i2], f22981h[i2])));
                        }
                        if (!Float.isNaN(cSSNode2.f22780a.f22814m[f22981h[i2]]) && Float.isNaN(cSSNode2.f22780a.f22814m[f22980g[i2]])) {
                            float[] fArr9 = cSSNode2.f22781b.f22825a;
                            i = f22980g[i2];
                            f10 = cSSNode.f22781b.f22826b[f22983j[i2]] - cSSNode2.f22781b.f22826b[f22983j[i2]];
                            if (Float.isNaN(cSSNode2.f22780a.f22814m[f22981h[i2]])) {
                                f4 = cSSNode2.f22780a.f22814m[f22981h[i2]];
                            } else {
                                f4 = 0.0f;
                            }
                            fArr9[i] = f10 - f4;
                        }
                        i3++;
                    }
                    CSSNode cSSNode13 = cSSNode2.f22784e;
                    cSSNode2.f22784e = null;
                    cSSNode2 = cSSNode13;
                }
            }
        }
        obj5 = null;
        for (i2 = 0; i2 < a4; i2++) {
            a_ = cSSNode.a_(i2);
            if (obj14 != null) {
                a_.f22781b.f22825a[f22981h[a2]] = (cSSNode.f22781b.f22826b[f22983j[a2]] - a_.f22781b.f22826b[f22983j[a2]]) - a_.f22781b.f22825a[f22982i[a2]];
            }
            if (obj5 != null) {
                a_.f22781b.f22825a[f22981h[b]] = (cSSNode.f22781b.f22826b[f22983j[b]] - a_.f22781b.f22826b[f22983j[b]]) - a_.f22781b.f22825a[f22982i[b]];
            }
        }
        cSSNode2 = cSSNode4;
        while (cSSNode2 != null) {
            i3 = 0;
            while (i3 < 2) {
                if (i3 == 0) {
                }
                float[] fArr82 = cSSNode2.f22781b.f22826b;
                int i252 = f22983j[i2];
                f11 = (cSSNode.f22781b.f22826b[f22983j[i2]] - (cSSNode.f22780a.f22813l.m30943a(f22984k[i2], f22980g[i2]) + cSSNode.f22780a.f22813l.m30943a(f22985l[i2], f22981h[i2]))) - (cSSNode2.f22780a.f22811j.m30943a(f22984k[i2], f22980g[i2]) + cSSNode2.f22780a.f22811j.m30943a(f22985l[i2], f22981h[i2]));
                if (Float.isNaN(cSSNode2.f22780a.f22814m[f22980g[i2]])) {
                    f5 = cSSNode2.f22780a.f22814m[f22980g[i2]];
                } else {
                    f5 = 0.0f;
                }
                f11 -= f5;
                if (Float.isNaN(cSSNode2.f22780a.f22814m[f22981h[i2]])) {
                    f5 = cSSNode2.f22780a.f22814m[f22981h[i2]];
                } else {
                    f5 = 0.0f;
                }
                fArr82[i252] = Math.max(m31093a(cSSNode2, i2, f11 - f5), (cSSNode2.f22780a.f22812k.m30943a(f22984k[i2], f22980g[i2]) + cSSNode2.f22780a.f22813l.m30943a(f22984k[i2], f22980g[i2])) + (cSSNode2.f22780a.f22812k.m30943a(f22985l[i2], f22981h[i2]) + cSSNode2.f22780a.f22813l.m30943a(f22985l[i2], f22981h[i2])));
                float[] fArr92 = cSSNode2.f22781b.f22825a;
                i = f22980g[i2];
                f10 = cSSNode.f22781b.f22826b[f22983j[i2]] - cSSNode2.f22781b.f22826b[f22983j[i2]];
                if (Float.isNaN(cSSNode2.f22780a.f22814m[f22981h[i2]])) {
                    f4 = cSSNode2.f22780a.f22814m[f22981h[i2]];
                } else {
                    f4 = 0.0f;
                }
                fArr92[i] = f10 - f4;
                i3++;
            }
            CSSNode cSSNode132 = cSSNode2.f22784e;
            cSSNode2.f22784e = null;
            cSSNode2 = cSSNode132;
        }
    }
}
