package com.facebook.csslayout;

import java.util.Arrays;

/* compiled from: fully_seen */
public class CSSStyle {
    public CSSDirection f22802a;
    public CSSFlexDirection f22803b;
    public CSSJustify f22804c;
    public CSSAlign f22805d;
    public CSSAlign f22806e;
    public CSSAlign f22807f;
    public CSSPositionType f22808g;
    public CSSWrap f22809h;
    public float f22810i;
    public Spacing f22811j = new Spacing();
    public Spacing f22812k = new Spacing();
    public Spacing f22813l = new Spacing();
    public float[] f22814m = new float[4];
    public float[] f22815n = new float[2];
    public float f22816o = Float.NaN;
    public float f22817p = Float.NaN;
    public float f22818q = Float.NaN;
    public float f22819r = Float.NaN;

    CSSStyle() {
        m30940a();
    }

    final void m30940a() {
        this.f22802a = CSSDirection.INHERIT;
        this.f22803b = CSSFlexDirection.COLUMN;
        this.f22804c = CSSJustify.FLEX_START;
        this.f22805d = CSSAlign.FLEX_START;
        this.f22806e = CSSAlign.STRETCH;
        this.f22807f = CSSAlign.AUTO;
        this.f22808g = CSSPositionType.RELATIVE;
        this.f22809h = CSSWrap.NOWRAP;
        this.f22810i = 0.0f;
        this.f22811j.m30944a();
        this.f22812k.m30944a();
        this.f22813l.m30944a();
        Arrays.fill(this.f22814m, Float.NaN);
        Arrays.fill(this.f22815n, Float.NaN);
        this.f22816o = Float.NaN;
        this.f22817p = Float.NaN;
        this.f22818q = Float.NaN;
        this.f22819r = Float.NaN;
    }
}
