package com.facebook.react.bridge;

import java.io.Closeable;
import java.io.Writer;
import java.util.ArrayDeque;
import java.util.Deque;

/* compiled from: group_members_section */
public class JsonWriter implements Closeable {
    private final Writer f11518a;
    private final Deque<Scope> f11519b = new ArrayDeque();

    /* compiled from: group_members_section */
    enum Scope {
        EMPTY_OBJECT,
        OBJECT,
        EMPTY_ARRAY,
        ARRAY
    }

    public JsonWriter(Writer writer) {
        this.f11518a = writer;
    }

    public final JsonWriter m13475a() {
        m13471a(Scope.EMPTY_ARRAY, '[');
        return this;
    }

    public final JsonWriter m13480b() {
        m13469a(']');
        return this;
    }

    public final JsonWriter m13482c() {
        m13471a(Scope.EMPTY_OBJECT, '{');
        return this;
    }

    public final JsonWriter m13484d() {
        m13469a('}');
        return this;
    }

    public final JsonWriter m13478a(String str) {
        if (str == null) {
            throw new NullPointerException("name can not be null");
        }
        m13474g();
        m13472d(str);
        this.f11518a.write(58);
        return this;
    }

    public final JsonWriter m13481b(String str) {
        if (str == null) {
            return m13485e();
        }
        m13473f();
        m13472d(str);
        return this;
    }

    public final JsonWriter m13485e() {
        m13473f();
        this.f11518a.write("null");
        return this;
    }

    public final JsonWriter m13483c(String str) {
        m13473f();
        this.f11518a.write(str);
        return this;
    }

    public final JsonWriter m13479a(boolean z) {
        m13473f();
        this.f11518a.write(z ? "true" : "false");
        return this;
    }

    public final JsonWriter m13476a(long j) {
        m13473f();
        this.f11518a.write(Long.toString(j));
        return this;
    }

    public final JsonWriter m13477a(Number number) {
        if (number == null) {
            return m13485e();
        }
        m13473f();
        this.f11518a.append(number.toString());
        return this;
    }

    public void close() {
        this.f11518a.close();
    }

    private void m13473f() {
        Scope scope = (Scope) this.f11519b.peek();
        switch (scope) {
            case EMPTY_ARRAY:
                m13470a(Scope.ARRAY);
                return;
            case EMPTY_OBJECT:
                throw new IllegalArgumentException(Scope.EMPTY_OBJECT.name());
            case ARRAY:
                this.f11518a.write(44);
                return;
            case OBJECT:
                return;
            default:
                throw new IllegalStateException("Unknown scope: " + scope);
        }
    }

    private void m13474g() {
        Scope scope = (Scope) this.f11519b.peek();
        switch (scope) {
            case EMPTY_ARRAY:
            case ARRAY:
                throw new IllegalStateException("name not allowed in array");
            case EMPTY_OBJECT:
                m13470a(Scope.OBJECT);
                return;
            case OBJECT:
                this.f11518a.write(44);
                return;
            default:
                throw new IllegalStateException("Unknown scope: " + scope);
        }
    }

    private void m13471a(Scope scope, char c) {
        this.f11519b.push(scope);
        this.f11518a.write(c);
    }

    private void m13469a(char c) {
        this.f11519b.pop();
        this.f11518a.write(c);
    }

    private void m13472d(String str) {
        this.f11518a.write(34);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case '\b':
                    this.f11518a.write("\\b");
                    continue;
                case '\t':
                    this.f11518a.write("\\t");
                    continue;
                case '\n':
                    this.f11518a.write("\\n");
                    continue;
                case '\f':
                    this.f11518a.write("\\f");
                    continue;
                case '\r':
                    this.f11518a.write("\\r");
                    continue;
                case '\"':
                case '\\':
                    this.f11518a.write(92);
                    break;
                case ' ':
                case ' ':
                    this.f11518a.write(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
                    continue;
                default:
                    if (charAt <= '\u001f') {
                        this.f11518a.write(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
                        continue;
                    }
                    break;
            }
            this.f11518a.write(charAt);
        }
        this.f11518a.write(34);
    }

    private void m13470a(Scope scope) {
        this.f11519b.pop();
        this.f11519b.push(scope);
    }
}
