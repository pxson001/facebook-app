package com.fasterxml.jackson.dataformat.smile;

/* compiled from: can_viewer_edit_attachment */
public class SmileBufferRecycler<T> {
    public T[] f6270a;
    public T[] f6271b;

    public final T[] m11864a() {
        T[] tArr = this.f6270a;
        if (tArr != null) {
            this.f6270a = null;
        }
        return tArr;
    }

    public final T[] m11866b() {
        T[] tArr = this.f6271b;
        if (tArr != null) {
            this.f6271b = null;
        }
        return tArr;
    }

    public final void m11863a(T[] tArr) {
        this.f6270a = tArr;
    }

    public final void m11865b(T[] tArr) {
        this.f6271b = tArr;
    }
}
