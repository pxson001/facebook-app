package com.facebook.inject;

import android.annotation.SuppressLint;
import com.facebook.common.build.BuildConstants;
import com.google.common.base.Throwables;
import java.lang.reflect.Constructor;
import javax.annotation.Nullable;

@SuppressLint({"ExplicitComplexProvider", "FbInjectorGet"})
/* compiled from: video_segment_transcode_upload */
public class AssistedProviderProvider<T> extends AbstractProvider<AssistedProvider<T>> {
    @Nullable
    private volatile Constructor<AssistedProvider<T>> f1099a;
    private final Class<AssistedProvider<T>> f1100b;

    public /* synthetic */ Object get() {
        return m2224a();
    }

    public AssistedProviderProvider(Class<AssistedProvider<T>> cls) {
        this.f1100b = cls;
        if (BuildConstants.i) {
            m2223c();
        }
    }

    public final AssistedProvider<T> m2224a() {
        AbstractAssistedProvider b = m2222b();
        if (b instanceof AbstractAssistedProvider) {
            b.f1098a = (FbInjector) getScopeAwareInjector();
        }
        return b;
    }

    private AssistedProvider<T> m2222b() {
        try {
            return (AbstractAssistedProvider) m2223c().newInstance(new Object[0]);
        } catch (Throwable e) {
            throw Throwables.propagate(e);
        } catch (Throwable e2) {
            throw Throwables.propagate(e2);
        } catch (Throwable e22) {
            throw Throwables.propagate(e22);
        }
    }

    private Constructor<AssistedProvider<T>> m2223c() {
        Constructor<AssistedProvider<T>> constructor = this.f1099a;
        if (constructor != null) {
            return constructor;
        }
        try {
            constructor = this.f1100b.getDeclaredConstructor(new Class[0]);
            constructor.setAccessible(true);
            this.f1099a = constructor;
            return constructor;
        } catch (Throwable e) {
            throw new IllegalArgumentException("Assisted provider " + this.f1100b + " doesn't have default constructor.", e);
        }
    }
}
