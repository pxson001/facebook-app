package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Supplier;
import com.google.common.collect.Multimaps.CustomListMultimap;
import com.google.common.collect.Multimaps.CustomSetMultimap;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckReturnValue;

@GwtCompatible
@CheckReturnValue
@Beta
/* compiled from: sms_takeover_inbox_filter_opt_out */
public abstract class MultimapBuilder<K0, V0> {

    /* compiled from: sms_takeover_inbox_filter_opt_out */
    public abstract class ListMultimapBuilder<K0, V0> extends MultimapBuilder<K0, V0> {
        public abstract <K extends K0, V extends V0> ListMultimap<K, V> mo142b();

        ListMultimapBuilder() {
        }
    }

    /* compiled from: sms_takeover_inbox_filter_opt_out */
    final class ArrayListSupplier<V> implements Supplier<List<V>>, Serializable {
        private final int expectedValuesPerKey;

        ArrayListSupplier(int i) {
            this.expectedValuesPerKey = CollectPreconditions.a(i, "expectedValuesPerKey");
        }

        public final Object get() {
            return new ArrayList(this.expectedValuesPerKey);
        }
    }

    /* compiled from: sms_takeover_inbox_filter_opt_out */
    public final class C04232 extends MultimapBuilderWithKeys<Object> {
        final /* synthetic */ int f9011a;

        public C04232(int i) {
            this.f9011a = i;
        }

        final <K, V> Map<K, Collection<V>> mo699a() {
            return Maps.c(this.f9011a);
        }
    }

    /* compiled from: sms_takeover_inbox_filter_opt_out */
    public abstract class MultimapBuilderWithKeys<K0> {
        abstract <K extends K0, V> Map<K, Collection<V>> mo699a();

        MultimapBuilderWithKeys() {
        }

        public final ListMultimapBuilder<K0, Object> m9361b() {
            CollectPreconditions.a(2, "expectedValuesPerKey");
            return new ListMultimapBuilder<K0, Object>(this, 2) {
                final /* synthetic */ MultimapBuilderWithKeys f2021b;

                public final <K extends K0, V> ListMultimap<K, V> mo142b() {
                    return new CustomListMultimap(this.f2021b.mo699a(), new ArrayListSupplier(2));
                }
            };
        }

        public final SetMultimapBuilder<K0, Object> m9362c() {
            CollectPreconditions.a(2, "expectedValuesPerKey");
            return new SetMultimapBuilder<K0, Object>(this, 2) {
                final /* synthetic */ MultimapBuilderWithKeys f9013b;

                public final <K extends K0, V> SetMultimap<K, V> mo700b() {
                    return new CustomSetMultimap(this.f9013b.mo699a(), new LinkedHashSetSupplier(2));
                }
            };
        }
    }

    /* compiled from: sms_takeover_inbox_filter_opt_out */
    public abstract class SetMultimapBuilder<K0, V0> extends MultimapBuilder<K0, V0> {
        public abstract <K extends K0, V extends V0> SetMultimap<K, V> mo700b();

        SetMultimapBuilder() {
        }
    }

    /* compiled from: sms_takeover_inbox_filter_opt_out */
    final class LinkedHashSetSupplier<V> implements Supplier<Set<V>>, Serializable {
        private final int expectedValuesPerKey;

        LinkedHashSetSupplier(int i) {
            this.expectedValuesPerKey = CollectPreconditions.a(i, "expectedValuesPerKey");
        }

        public final Object get() {
            return new LinkedHashSet(Maps.b(this.expectedValuesPerKey));
        }
    }

    public static MultimapBuilderWithKeys<Object> m9358a() {
        CollectPreconditions.a(8, "expectedKeys");
        return new C04232(8);
    }
}
