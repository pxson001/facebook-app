package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.PrettyPrinter;
import java.io.Serializable;

/* compiled from: close_label */
public class MinimalPrettyPrinter implements PrettyPrinter, Serializable {
    private static final long serialVersionUID = -562765100295218442L;
    protected String _rootValueSeparator;

    public MinimalPrettyPrinter() {
        this(" ");
    }

    private MinimalPrettyPrinter(String str) {
        this._rootValueSeparator = " ";
        this._rootValueSeparator = str;
    }

    public final void m10767a(JsonGenerator jsonGenerator) {
        if (this._rootValueSeparator != null) {
            jsonGenerator.c(this._rootValueSeparator);
        }
    }

    public final void m10769b(JsonGenerator jsonGenerator) {
        jsonGenerator.a('{');
    }

    public final void m10776h(JsonGenerator jsonGenerator) {
    }

    public final void m10772d(JsonGenerator jsonGenerator) {
        jsonGenerator.a(':');
    }

    public final void m10771c(JsonGenerator jsonGenerator) {
        jsonGenerator.a(',');
    }

    public final void m10768a(JsonGenerator jsonGenerator, int i) {
        jsonGenerator.a('}');
    }

    public final void m10773e(JsonGenerator jsonGenerator) {
        jsonGenerator.a('[');
    }

    public final void m10775g(JsonGenerator jsonGenerator) {
    }

    public final void m10774f(JsonGenerator jsonGenerator) {
        jsonGenerator.a(',');
    }

    public final void m10770b(JsonGenerator jsonGenerator, int i) {
        jsonGenerator.a(']');
    }
}
