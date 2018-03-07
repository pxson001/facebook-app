package com.facebook.drawee.controller;

import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;

/* compiled from: [TT; */
class AbstractDraweeControllerBuilder$2 implements Supplier<DataSource<IMAGE>> {
    final /* synthetic */ Object f11893a;
    final /* synthetic */ Object f11894b;
    final /* synthetic */ boolean f11895c;
    final /* synthetic */ AbstractDraweeControllerBuilder f11896d;

    AbstractDraweeControllerBuilder$2(AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, Object obj, Object obj2, boolean z) {
        this.f11896d = abstractDraweeControllerBuilder;
        this.f11893a = obj;
        this.f11894b = obj2;
        this.f11895c = z;
    }

    public final Object m19945a() {
        return this.f11896d.a(this.f11893a, this.f11894b, this.f11895c);
    }

    public String toString() {
        return Objects.a(this).a("request", this.f11893a.toString()).toString();
    }
}
