package com.facebook.graphql.executor.cache;

import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.filemap.DefaultFlatBufferCorruptionHandler;
import com.facebook.graphql.executor.filemap.DefaultFlatBufferCorruptionHandlerProvider;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: saved_more_menu_item_clicked */
public abstract class AbstractGraphQLDiskCache implements GraphQLDiskCache {
    private final DefaultFlatBufferCorruptionHandlerProvider f6123a;
    @Nullable
    private DefaultFlatBufferCorruptionHandler f6124b = null;

    /* compiled from: saved_more_menu_item_clicked */
    public class CacheResult<VALUE> {
        public final long f15048a;
        public final VALUE f15049b;
        public final Set<String> f15050c;
        public final Class f15051d;
        public final int f15052e;
        public final byte[] f15053f;
        public final byte[] f15054g;
        public final byte[] f15055h;
        public final DataFreshnessResult f15056i;

        public CacheResult(long j, VALUE value, @Nullable byte[] bArr, @Nullable byte[] bArr2, Set<String> set, Class cls, int i, byte[] bArr3, DataFreshnessResult dataFreshnessResult) {
            this.f15048a = j;
            this.f15049b = value;
            this.f15054g = bArr;
            this.f15055h = bArr2;
            this.f15050c = set;
            this.f15051d = cls;
            this.f15052e = i;
            this.f15053f = bArr3;
            this.f15056i = dataFreshnessResult;
        }
    }

    @Nullable
    protected abstract <T> CacheResult<ByteBuffer> mo1439a(GraphQLRequest<T> graphQLRequest);

    protected abstract <T> void mo1441a(GraphQLRequest<T> graphQLRequest, GraphQLResult<T> graphQLResult);

    protected AbstractGraphQLDiskCache(DefaultFlatBufferCorruptionHandlerProvider defaultFlatBufferCorruptionHandlerProvider) {
        this.f6123a = defaultFlatBufferCorruptionHandlerProvider;
    }

    public final <T> GraphQLResult<T> mo1448b(GraphQLRequest<T> graphQLRequest) {
        CacheResult a = mo1439a((GraphQLRequest) graphQLRequest);
        if (a == null) {
            return null;
        }
        Map a2;
        Object a3 = m10295a(a);
        if (a.f15053f != null) {
            a2 = DiskCacheFlattenableHelper.a(a.f15053f);
        } else {
            a2 = null;
        }
        return new GraphQLResult(a3, a.f15056i, a.f15048a, a.f15050c, null, null, a2);
    }

    public final <T> void mo1449b(GraphQLRequest<T> graphQLRequest, GraphQLResult<T> graphQLResult) {
        mo1441a((GraphQLRequest) graphQLRequest, (GraphQLResult) graphQLResult);
    }

    protected final byte[] m10297a(int i, Object obj) {
        if (!m10292a(i)) {
            return FlatBufferBuilder.m21463b((Flattenable) obj);
        }
        byte[] bArr;
        Map map = (Map) obj;
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(2048);
        int a = flatBufferBuilder.m21485a(map, false);
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21507b(0, a);
        a = flatBufferBuilder.m21511d();
        if (a < 0) {
            bArr = null;
        } else {
            flatBufferBuilder.m21513d(a);
            bArr = flatBufferBuilder.m21515e();
        }
        return bArr;
    }

    private synchronized DefaultFlatBufferCorruptionHandler m10293d() {
        if (this.f6124b == null) {
            this.f6124b = this.f6123a.m8185a(GraphQLCachePreferenceKeys.f15057a);
        }
        return this.f6124b;
    }

    protected final Object m10295a(CacheResult<ByteBuffer> cacheResult) {
        if (cacheResult.f15049b == null) {
            return null;
        }
        ByteBuffer wrap;
        ByteBuffer wrap2;
        if (cacheResult.f15054g != null) {
            wrap = ByteBuffer.wrap(cacheResult.f15054g);
        } else {
            wrap = null;
        }
        if (cacheResult.f15055h != null) {
            wrap2 = ByteBuffer.wrap(cacheResult.f15055h);
        } else {
            wrap2 = null;
        }
        if (m10292a(cacheResult.f15052e)) {
            return DiskCacheFlattenableHelper.b((ByteBuffer) cacheResult.f15049b, cacheResult.f15051d, wrap, wrap2, true, m10293d());
        }
        return MutableFlatBuffer.m21521a((ByteBuffer) cacheResult.f15049b, cacheResult.f15051d, wrap, wrap2, true, m10293d());
    }

    private static boolean m10292a(int i) {
        return (i & 1) != 0;
    }

    protected static int m10291a(GraphQLResult<?> graphQLResult) {
        return graphQLResult.f6203e instanceof Map ? 1 : 0;
    }
}
