package com.facebook.api.feed.data;

import com.facebook.api.feed.data.AppendOnlyGraphQLObjectCollectionGraphQLInterfaces.AppendOnlyPageInfoGraphQL;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Set;

/* compiled from: atom_size */
public class AppendOnlyGraphQLObjectCollection<T> {
    public final Function<T, String> f8763a;
    public final Set<String> f8764b = Sets.a();
    public final List<T> f8765c = Lists.a();
    private String f8766d;
    public String f8767e;
    private boolean f8768f = true;
    public boolean f8769g = true;

    public AppendOnlyGraphQLObjectCollection(Function<T, String> function) {
        this.f8763a = function;
    }

    public final String m14659a() {
        return this.f8767e;
    }

    public final void m14660a(Iterable<? extends T> iterable, AppendOnlyPageInfoGraphQL appendOnlyPageInfoGraphQL) {
        if (iterable.iterator().hasNext()) {
            for (Object next : iterable) {
                String str = (String) this.f8763a.apply(next);
                if (this.f8764b.contains(str)) {
                    for (int size = this.f8765c.size() - 1; size >= 0; size--) {
                        if (str.equals(this.f8763a.apply(this.f8765c.get(size)))) {
                            this.f8765c.set(size, next);
                            break;
                        }
                    }
                } else {
                    this.f8765c.add(next);
                    this.f8764b.add(str);
                }
            }
            this.f8767e = appendOnlyPageInfoGraphQL.m14667a();
            this.f8769g = appendOnlyPageInfoGraphQL.m14669b();
            if (this.f8766d == null) {
                this.f8766d = appendOnlyPageInfoGraphQL.m14671d();
                this.f8768f = appendOnlyPageInfoGraphQL.m14670c();
            }
        }
    }

    public final T m14658a(int i) {
        return this.f8765c.get(i);
    }

    public final int m14661c() {
        return this.f8765c.size();
    }
}
