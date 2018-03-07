package com.facebook.common.locale;

import android.annotation.SuppressLint;
import com.facebook.common.locale.SupportedLanguages.Type;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableSet;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: validateCaptcha */
public abstract class MemoizedSupportedLanguages extends SupportedLanguages {
    @SuppressLint({"ConstructorMayLeakThis"})
    private final Supplier<ImmutableSet<String>> f1374a = Suppliers.memoize(new C00961(this));
    @SuppressLint({"ConstructorMayLeakThis"})
    private final Supplier<ImmutableSet<String>> f1375b = Suppliers.memoize(new C00972(this));
    @SuppressLint({"ConstructorMayLeakThis"})
    private final Supplier<ImmutableSet<String>> f1376c = Suppliers.memoize(new C00983(this));

    /* compiled from: validateCaptcha */
    class C00961 implements Supplier<ImmutableSet<String>> {
        final /* synthetic */ MemoizedSupportedLanguages f1427a;

        C00961(MemoizedSupportedLanguages memoizedSupportedLanguages) {
            this.f1427a = memoizedSupportedLanguages;
        }

        public Object get() {
            return this.f1427a.mo361b();
        }
    }

    /* compiled from: validateCaptcha */
    class C00972 implements Supplier<ImmutableSet<String>> {
        final /* synthetic */ MemoizedSupportedLanguages f1428a;

        C00972(MemoizedSupportedLanguages memoizedSupportedLanguages) {
            this.f1428a = memoizedSupportedLanguages;
        }

        public Object get() {
            return this.f1428a.mo362c();
        }
    }

    /* compiled from: validateCaptcha */
    class C00983 implements Supplier<ImmutableSet<String>> {
        final /* synthetic */ MemoizedSupportedLanguages f1429a;

        C00983(MemoizedSupportedLanguages memoizedSupportedLanguages) {
            this.f1429a = memoizedSupportedLanguages;
        }

        public Object get() {
            return this.f1429a.mo363d();
        }
    }

    /* compiled from: validateCaptcha */
    /* synthetic */ class C01874 {
        static final /* synthetic */ int[] f3008a = new int[Type.values().length];

        static {
            try {
                f3008a[Type.ASSET.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3008a[Type.DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    protected abstract ImmutableSet<String> mo361b();

    protected abstract ImmutableSet<String> mo362c();

    protected abstract ImmutableSet<String> mo363d();

    public final ImmutableSet<String> mo364a() {
        return (ImmutableSet) this.f1374a.get();
    }

    public final ImmutableSet<String> mo365a(Type type) {
        switch (C01874.f3008a[type.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return (ImmutableSet) this.f1375b.get();
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return (ImmutableSet) this.f1376c.get();
            default:
                throw new IllegalArgumentException("Unhandled language set type");
        }
    }
}
