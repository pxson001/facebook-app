package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Map.Entry;

/* compiled from: camera */
public final class Maps$11 implements Function<Entry<K, V1>, Entry<K, V2>> {
    final /* synthetic */ Maps$EntryTransformer f7468a;

    public Maps$11(Maps$EntryTransformer maps$EntryTransformer) {
        this.f7468a = maps$EntryTransformer;
    }

    public final Object apply(Object obj) {
        return Maps.a(this.f7468a, (Entry) obj);
    }
}
