package com.facebook.controller.connectioncontroller.diskstore;

import com.facebook.graphql.executor.cache.RecursiveModelTransformer;
import com.facebook.graphql.executor.iface.CacheVisitor;
import java.util.Set;

/* compiled from: options[] */
public class DiskConnectionStore$6 implements CacheVisitor {
    final /* synthetic */ RecursiveModelTransformer f8633a;
    final /* synthetic */ Set f8634b;
    final /* synthetic */ DiskConnectionStore f8635c;

    public DiskConnectionStore$6(DiskConnectionStore diskConnectionStore, RecursiveModelTransformer recursiveModelTransformer, Set set) {
        this.f8635c = diskConnectionStore;
        this.f8633a = recursiveModelTransformer;
        this.f8634b = set;
    }

    public final <T> T m12434a(T t) {
        return this.f8633a.a(t);
    }

    public final Set<String> m12435a() {
        return this.f8634b;
    }
}
