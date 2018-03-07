package com.facebook.graphql.executor.cache;

import com.facebook.graphql.executor.iface.TypedModelVisitor;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: sModelClasses */
public class RecursiveModelTransformer<T> {
    public final Class<T> f2989a;
    public final TypedModelVisitor<T> f2990b;

    /* compiled from: sModelClasses */
    class C01391 implements GraphQLModelMutatingVisitor {
        final /* synthetic */ RecursiveModelTransformer f2993a;

        C01391(RecursiveModelTransformer recursiveModelTransformer) {
            this.f2993a = recursiveModelTransformer;
        }

        public final GraphQLVisitableModel m3278b(GraphQLVisitableModel graphQLVisitableModel) {
            GraphQLVisitableModel a = graphQLVisitableModel.a(this);
            if (this.f2993a.f2989a.isInstance(a)) {
                return (GraphQLVisitableModel) this.f2993a.f2990b.mo266a(a);
            }
            return a;
        }
    }

    public RecursiveModelTransformer(Class<T> cls, TypedModelVisitor<T> typedModelVisitor) {
        this.f2989a = cls;
        this.f2990b = typedModelVisitor;
    }

    private <U> List<U> m3271a(List<U> list) {
        if (list == null) {
            return list;
        }
        List<U> arrayList = new ArrayList();
        for (Object next : list) {
            Object next2;
            if (next2 instanceof GraphQLVisitableModel) {
                next2 = m3272c((GraphQLVisitableModel) next2);
                if (next2 != null) {
                    arrayList.add(next2);
                }
            } else {
                arrayList.add(next2);
            }
        }
        return arrayList;
    }

    private <U> ImmutableList<U> m3270a(ImmutableList<U> immutableList) {
        if (immutableList == null) {
            return immutableList;
        }
        Collection a = Lists.a(immutableList.size());
        int size = immutableList.size();
        int i = 0;
        Object obj = null;
        while (i < size) {
            Object c;
            Object obj2 = immutableList.get(i);
            if (obj2 instanceof GraphQLVisitableModel) {
                c = m3272c((GraphQLVisitableModel) obj2);
                if (c != null) {
                    a.add(c);
                }
                if (c != obj2) {
                    c = 1;
                }
                c = obj;
            } else {
                a.add(obj2);
                c = obj;
            }
            i++;
            obj = c;
        }
        if (obj != null) {
            return ImmutableList.copyOf(a);
        }
        return immutableList;
    }

    private <U> U m3272c(U u) {
        if (!(u instanceof GraphQLVisitableModel)) {
            return u;
        }
        Object a;
        C01391 c01391 = new C01391(this);
        if (this.f2989a.isInstance(u)) {
            a = this.f2990b.mo266a(u);
        } else {
            U u2 = u;
        }
        return a == null ? null : ((GraphQLVisitableModel) a).a(c01391);
    }

    public final <U> U m3273a(U u) {
        if (u instanceof ImmutableList) {
            return m3270a((ImmutableList) u);
        }
        if (u instanceof List) {
            return m3271a((List) u);
        }
        if (!(u instanceof Map)) {
            return m3272c(u);
        }
        U hashMap = new HashMap();
        for (Entry entry : ((Map) u).entrySet()) {
            Object a = m3273a(entry.getValue());
            if (a != null) {
                hashMap.put(entry.getKey(), a);
            }
        }
        return hashMap;
    }
}
