package com.facebook.qe.store;

import com.facebook.qe.api.manager.Authority;
import com.facebook.qe.store.Index.Visitor;
import java.util.Map;

/* compiled from: show_suggestion */
public class ExperimentParametersCollectingIndexVisitor implements Visitor {
    private final Authority f4350a;
    private final View f4351b;
    private final String f4352c;
    private final Map<String, String> f4353d;
    private boolean f4354e;

    public ExperimentParametersCollectingIndexVisitor(Authority authority, View view, String str, Map<String, String> map) {
        this.f4350a = authority;
        this.f4351b = view;
        this.f4352c = str;
        this.f4353d = map;
    }

    public final void m6446a(String str, int i) {
        this.f4354e = str.equals(this.f4352c);
    }

    public final void m6447a(String str, int i, int i2, boolean z) {
        if (!z && this.f4354e && this.f4351b.f(this.f4350a, i)) {
            switch (i2) {
                case 100:
                    this.f4353d.put(str, this.f4351b.a(this.f4350a, i));
                    return;
                case 101:
                    this.f4353d.put(str, Boolean.toString(this.f4351b.e(this.f4350a, i)));
                    return;
                case 102:
                    this.f4353d.put(str, Integer.toString(this.f4351b.b(this.f4350a, i)));
                    return;
                case 103:
                    this.f4353d.put(str, Long.toString(this.f4351b.c(this.f4350a, i)));
                    return;
                case 104:
                    this.f4353d.put(str, Float.toString(this.f4351b.d(this.f4350a, i)));
                    return;
                case 105:
                    this.f4353d.put(str, this.f4351b.a(this.f4350a, i));
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }
}
