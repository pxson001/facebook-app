package com.facebook.fbreactmodules.relay;

import android.util.SparseArray;
import com.facebook.graphql.enums.GraphQLObjectType.ObjectType;
import com.facebook.graphql.executor.GraphQLCacheAggregator;
import com.facebook.graphql.executor.cache.ConsistencyCacheFactoryImpl;
import com.facebook.graphql.executor.cache.ConsistencyConfigImpl;
import com.facebook.graphql.executor.cache.ConsistencyConfigImpl.LazyHolder;
import com.facebook.graphql.executor.iface.ConsistencyMemoryCache;
import com.facebook.inject.Assisted;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import java.util.Arrays;
import java.util.HashSet;
import javax.inject.Inject;

/* compiled from: dtstart */
public final class FbRelayNativeAdapter extends ReactContextBaseJavaModule {
    private ConsistencyCacheFactoryImpl f7512a;
    private GraphQLCacheAggregator f7513b;

    /* compiled from: dtstart */
    /* synthetic */ class C09521 {
        static final /* synthetic */ int[] f7511a = new int[ReadableType.values().length];

        static {
            try {
                f7511a[ReadableType.Null.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f7511a[ReadableType.Boolean.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f7511a[ReadableType.Number.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f7511a[ReadableType.String.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f7511a[ReadableType.Map.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f7511a[ReadableType.Array.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    @Inject
    public FbRelayNativeAdapter(@Assisted ReactApplicationContext reactApplicationContext, ConsistencyCacheFactoryImpl consistencyCacheFactoryImpl, GraphQLCacheAggregator graphQLCacheAggregator) {
        super(reactApplicationContext);
        this.f7512a = consistencyCacheFactoryImpl;
        this.f7513b = graphQLCacheAggregator;
    }

    public final String getName() {
        return "FbRelayNativeAdapter";
    }

    @ReactMethod
    public final void updateCLC(ReadableArray readableArray) {
        ConsistencyMemoryCache a = this.f7512a.a();
        ConsistencyConfigImpl consistencyConfigImpl = LazyHolder.a;
        SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < readableArray.size(); i++) {
            ReadableArray a2 = readableArray.a(i);
            String string = a2.getString(0);
            String string2 = a2.getString(1);
            String string3 = a2.getString(2);
            int a3 = ObjectType.a(string);
            HashSet hashSet = (HashSet) sparseArray.get(a3);
            if (hashSet == null) {
                hashSet = new HashSet(Arrays.asList(consistencyConfigImpl.a(a3)));
                sparseArray.put(a3, hashSet);
            }
            if (hashSet.contains(string3)) {
                a.a(string2, string3, m8728a(a2, a2.getType(3)));
            }
        }
        this.f7513b.a(a);
    }

    private static Object m8728a(ReadableArray readableArray, ReadableType readableType) {
        switch (C09521.f7511a[readableType.ordinal()]) {
            case 1:
                return null;
            case 2:
                return Boolean.valueOf(readableArray.getBoolean(3));
            case 3:
                return Integer.valueOf(readableArray.getInt(3));
            case 4:
                return readableArray.getString(3);
            default:
                throw new JSApplicationCausedNativeException("Unknown type in update " + readableType);
        }
    }
}
