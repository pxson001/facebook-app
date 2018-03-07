package com.facebook.greetingcards.verve.model;

import android.graphics.PointF;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = VMViewDeserializer.class)
@Immutable
/* compiled from: viewer_context_util_requested */
public class VMView {
    private static final ImmutableList<Float> f334c = ImmutableList.of(Float.valueOf(0.0f), Float.valueOf(0.0f));
    private static final ImmutableList<Float> f335d = ImmutableList.of(Float.valueOf(0.0f), Float.valueOf(0.0f));
    private static final ImmutableList<Float> f336e = ImmutableList.of(Float.valueOf(0.5f), Float.valueOf(0.5f));
    private static final VMColor f337f = new VMColor("solid", ImmutableList.of(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(0.0f)), null, 0.0f, null);
    private static final ImmutableList<Float> f338g = ImmutableList.of(Float.valueOf(0.0f), Float.valueOf(3.0f));
    private static final AtomicInteger f339h = new AtomicInteger();
    public final int f340a;
    @JsonProperty("actions")
    public final ImmutableMap<String, VMAction> actionsMap;
    @JsonProperty("alignment")
    public final String alignment;
    @JsonProperty("anchor")
    public final ImmutableList<Float> anchor;
    public final PointF f341b;
    @JsonProperty("button-size")
    public final String buttonSize;
    @JsonProperty("button-style")
    public final String buttonStyle;
    @JsonProperty("duration")
    public final Float duration;
    @JsonProperty("fill-color")
    public final VMColor fillColor;
    @JsonProperty("font")
    public final String font;
    @JsonProperty("font-size")
    public final Float fontSize;
    public final float f342i;
    private DisplayRect f343j;
    private VMViewType f344k;
    @JsonProperty("line-break")
    public final String lineBreak;
    @JsonProperty("type")
    public final String mType;
    @JsonProperty("name")
    public final String name;
    @JsonProperty("opacity")
    public final Float opacity;
    @JsonProperty("placeholder-color")
    public final VMColor placeholderColor;
    @JsonProperty("placeholder-src")
    public final String placeholderSrc;
    @JsonProperty("position")
    public final ImmutableList<Float> position;
    @JsonProperty("resize")
    public final String resize;
    @JsonProperty("rotation")
    public final Float rotation;
    @JsonProperty("shadow-color")
    public final VMColor shadowColor;
    @JsonProperty("shadow-offset")
    public final ImmutableList<Float> shadowOffset;
    @JsonProperty("shadow-radius")
    public final Integer shadowRadius;
    @JsonProperty("size")
    public final ImmutableList<Float> size;
    @JsonProperty("src")
    public final String src;
    @JsonProperty("states")
    public final ImmutableMap<String, VMView> statesMap;
    @JsonProperty("style")
    public final String styleName;
    @JsonProperty("subviews")
    public final ImmutableList<VMView> subviews;
    @JsonProperty("text")
    public final String text;
    @JsonProperty("title")
    public final String title;
    @JsonProperty("v-alignment")
    public final String vAlignment;
    @JsonProperty("value-name")
    public final String valueName;

    /* compiled from: viewer_context_util_requested */
    public class Builder {
        private String f302A;
        private ImmutableMap<String, VMAction> f303B;
        public Float f304C;
        public PointF f305D;
        public VMColor f306E;
        private String f307F;
        private float f308a = 1.0f;
        private String f309b;
        private ImmutableList<Float> f310c;
        private ImmutableList<Float> f311d;
        private ImmutableList<Float> f312e;
        public String f313f;
        private Float f314g;
        public Float f315h;
        public String f316i;
        private String f317j;
        private String f318k;
        public VMColor f319l;
        public ImmutableList<VMView> f320m;
        public ImmutableMap<String, VMView> f321n;
        public String f322o;
        public Float f323p;
        private String f324q;
        private VMColor f325r;
        private Integer f326s;
        private ImmutableList<Float> f327t;
        public String f328u;
        public String f329v;
        private String f330w;
        private String f331x;
        public String f332y;
        private String f333z;

        public final Builder m286a(VMView vMView) {
            this.f308a = vMView.f342i;
            this.f309b = vMView.name;
            this.f310c = vMView.size;
            this.f311d = vMView.position;
            this.f312e = vMView.anchor;
            this.f313f = vMView.mType;
            this.f314g = vMView.rotation;
            this.f315h = vMView.opacity;
            this.f316i = vMView.src;
            this.f317j = vMView.placeholderSrc;
            this.f318k = vMView.resize;
            this.f319l = vMView.fillColor;
            this.f320m = vMView.subviews;
            this.f321n = vMView.statesMap;
            this.f322o = vMView.text;
            this.f323p = vMView.fontSize;
            this.f324q = vMView.font;
            this.f325r = vMView.shadowColor;
            this.f326s = vMView.shadowRadius;
            this.f327t = vMView.shadowOffset;
            this.f328u = vMView.alignment;
            this.f329v = vMView.vAlignment;
            this.f330w = vMView.valueName;
            this.f331x = vMView.styleName;
            this.f332y = vMView.title;
            this.f333z = vMView.buttonStyle;
            this.f302A = vMView.buttonSize;
            this.f303B = vMView.actionsMap;
            this.f304C = vMView.duration;
            this.f305D = vMView.f341b;
            this.f306E = vMView.placeholderColor;
            this.f307F = vMView.lineBreak;
            return this;
        }

        public final Builder m285a(float f) {
            this.f308a = f;
            Map c = Maps.c();
            if (this.f321n != null) {
                Iterator it = this.f321n.keySet().iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    c.put(str, VMView.m289p().m286a((VMView) this.f321n.get(str)).m285a(f).m287a());
                }
            }
            this.f321n = ImmutableMap.copyOf(c);
            return this;
        }

        public final Builder m288b(VMView vMView) {
            String str;
            VMColor vMColor;
            Float f;
            if (this.f316i != null) {
                str = this.f316i;
            } else {
                str = vMView.src;
            }
            this.f316i = str;
            if (this.f319l != null) {
                vMColor = this.f319l;
            } else {
                vMColor = vMView.fillColor;
            }
            this.f319l = vMColor;
            if (this.f322o != null) {
                str = this.f322o;
            } else {
                str = vMView.text;
            }
            this.f322o = str;
            if (this.f323p != null) {
                f = this.f323p;
            } else {
                f = vMView.fontSize;
            }
            this.f323p = f;
            if (this.f328u != null) {
                str = this.f328u;
            } else {
                str = vMView.alignment;
            }
            this.f328u = str;
            if (this.f329v != null) {
                str = this.f329v;
            } else {
                str = vMView.vAlignment;
            }
            this.f329v = str;
            if (this.f306E != null) {
                vMColor = this.f306E;
            } else {
                vMColor = vMView.placeholderColor;
            }
            this.f306E = vMColor;
            return this;
        }

        public final VMView m287a() {
            return new VMView(this.f308a, this.f309b, this.f310c, this.f311d, this.f312e, this.f313f, this.f314g, this.f315h, this.f316i, this.f317j, this.f318k, this.f319l, this.f320m, this.f321n, this.f322o, this.f323p, this.f324q, this.f325r, this.f326s, this.f327t, this.f328u, this.f329v, this.f330w, this.f331x, this.f332y, this.f333z, this.f302A, this.f303B, this.f304C, this.f305D, this.f306E, this.f307F);
        }
    }

    public VMView() {
        this.f340a = f339h.incrementAndGet();
        this.f342i = 1.0f;
        this.name = null;
        this.size = null;
        this.position = null;
        this.anchor = null;
        this.mType = null;
        this.rotation = null;
        this.opacity = null;
        this.src = null;
        this.placeholderSrc = null;
        this.resize = null;
        this.fillColor = null;
        this.subviews = null;
        this.statesMap = null;
        this.text = null;
        this.fontSize = null;
        this.font = null;
        this.shadowColor = null;
        this.shadowRadius = null;
        this.shadowOffset = null;
        this.alignment = null;
        this.vAlignment = null;
        this.valueName = null;
        this.styleName = null;
        this.title = null;
        this.buttonStyle = null;
        this.buttonSize = null;
        this.actionsMap = null;
        this.duration = null;
        this.f341b = null;
        this.placeholderColor = null;
        this.lineBreak = null;
    }

    private VMView(float f, String str, ImmutableList<Float> immutableList, ImmutableList<Float> immutableList2, ImmutableList<Float> immutableList3, String str2, Float f2, Float f3, String str3, String str4, String str5, VMColor vMColor, ImmutableList<VMView> immutableList4, ImmutableMap<String, VMView> immutableMap, String str6, Float f4, String str7, VMColor vMColor2, Integer num, ImmutableList<Float> immutableList5, String str8, String str9, String str10, String str11, String str12, String str13, String str14, ImmutableMap<String, VMAction> immutableMap2, Float f5, PointF pointF, VMColor vMColor3, String str15) {
        this.f342i = f;
        this.f340a = f339h.incrementAndGet();
        this.name = str;
        this.size = immutableList;
        this.position = immutableList2;
        this.anchor = immutableList3;
        this.mType = str2;
        this.rotation = f2;
        this.opacity = f3;
        this.src = str3;
        this.placeholderSrc = str4;
        this.resize = str5;
        this.fillColor = vMColor;
        this.subviews = immutableList4;
        this.statesMap = immutableMap;
        this.text = str6;
        this.fontSize = f4;
        this.font = str7;
        this.shadowColor = vMColor2;
        this.shadowRadius = num;
        this.shadowOffset = immutableList5;
        this.alignment = str8;
        this.vAlignment = str9;
        this.valueName = str10;
        this.styleName = str11;
        this.title = str12;
        this.buttonStyle = str13;
        this.buttonSize = str14;
        this.actionsMap = immutableMap2;
        this.duration = f5;
        this.f341b = pointF;
        this.placeholderColor = vMColor3;
        this.lineBreak = str15;
    }

    private DisplayRect m290q() {
        if (this.f343j == null) {
            this.f343j = new DisplayRect(((Float) m292s().get(0)).floatValue() - (((Float) m291r().get(0)).floatValue() * ((Float) m293t().get(0)).floatValue()), ((Float) m292s().get(1)).floatValue() - (((Float) m291r().get(1)).floatValue() * ((Float) m293t().get(1)).floatValue()), ((Float) m291r().get(0)).floatValue(), ((Float) m291r().get(1)).floatValue());
            this.f343j = DisplayRect.m263a(this.f343j, this.f342i);
        }
        return this.f343j;
    }

    private ImmutableList<Float> m291r() {
        return this.size == null ? f334c : this.size;
    }

    private ImmutableList<Float> m292s() {
        return this.position == null ? f335d : this.position;
    }

    private ImmutableList<Float> m293t() {
        return this.anchor == null ? f336e : this.anchor;
    }

    public final float m294a() {
        return this.rotation == null ? 0.0f : this.rotation.floatValue();
    }

    public final float m295b() {
        return this.opacity == null ? 1.0f : this.opacity.floatValue();
    }

    public final float m296c() {
        return (this.fontSize == null ? 18.0f : this.fontSize.floatValue()) * this.f342i;
    }

    public final VMColor m297d() {
        return this.fillColor == null ? f337f : this.fillColor;
    }

    public final int m298e() {
        return this.shadowRadius == null ? 3 : this.shadowRadius.intValue();
    }

    public final ImmutableList<Float> m299f() {
        return this.shadowOffset == null ? f338g : this.shadowOffset;
    }

    public final float m300g() {
        return this.duration == null ? 1.0f : this.duration.floatValue();
    }

    public final float m301h() {
        return m290q().f276c;
    }

    public final float m302i() {
        return m290q().f277d;
    }

    public final float m303j() {
        return m290q().f274a;
    }

    public final float m304k() {
        return m290q().f275b;
    }

    public final float m305l() {
        return ((Float) m293t().get(0)).floatValue() * m301h();
    }

    public final float m306m() {
        return ((Float) m293t().get(1)).floatValue() * m302i();
    }

    public final String m307n() {
        return this.lineBreak == null ? "wrap" : this.lineBreak;
    }

    public final VMViewType m308o() {
        if (this.f344k == null) {
            this.f344k = VMViewType.fromString(this.mType);
        }
        return this.f344k;
    }

    public static Builder m289p() {
        return new Builder();
    }
}
