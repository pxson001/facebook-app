package com.facebook.inject;

import com.google.inject.Key;
import com.google.inject.Key.NullAnnotationStrategy;
import com.google.inject.internal.MoreTypes$ParameterizedTypeImpl;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: deleteFromServer */
public class MultiBinder<T> {
    public static final Comparator<Key> f5142a = new C04871();
    private final FbInjector f5143b;
    public final Key<T> f5144c;
    public final List<Key<? extends T>> f5145d = new ArrayList();

    /* compiled from: deleteFromServer */
    final class C04871 implements Comparator<Key> {
        C04871() {
        }

        public final int compare(Object obj, Object obj2) {
            return ((Key) obj).b.a.getName().compareTo(((Key) obj2).b.a.getName());
        }
    }

    MultiBinder(FbInjector fbInjector, Key<T> key) {
        this.f5143b = fbInjector;
        this.f5144c = key;
    }

    final Provider<Set<T>> m10027b() {
        return new MultiBinderProvider(this.f5143b, this.f5145d, this.f5144c);
    }

    final Key<? extends Set<T>> m10028c() {
        Type moreTypes$ParameterizedTypeImpl = new MoreTypes$ParameterizedTypeImpl(null, Set.class, this.f5144c.b.b);
        if (this.f5144c.c() != null) {
            return new Key(moreTypes$ParameterizedTypeImpl, Key.a(this.f5144c.c()));
        }
        if (this.f5144c.b() != null) {
            return new Key(moreTypes$ParameterizedTypeImpl, Key.b(this.f5144c.b()));
        }
        return new Key(moreTypes$ParameterizedTypeImpl, NullAnnotationStrategy.INSTANCE);
    }
}
