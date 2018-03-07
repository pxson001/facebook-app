package com.facebook.catalyst.modules.analytics;

import com.facebook.analytics2.logger.EventBuilder;
import com.facebook.crudolib.params.ParamsCollectionArray;
import com.facebook.crudolib.params.ParamsCollectionMap;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;

/* compiled from: mask */
public class AnalyticsDataParser {

    /* compiled from: mask */
    /* synthetic */ class C07171 {
        static final /* synthetic */ int[] f5564a = new int[ReadableType.values().length];

        static {
            try {
                f5564a[ReadableType.Null.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5564a[ReadableType.Boolean.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5564a[ReadableType.Number.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f5564a[ReadableType.String.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f5564a[ReadableType.Map.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f5564a[ReadableType.Array.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public static void m6878a(EventBuilder eventBuilder, ReadableMap readableMap) {
        ReadableMapKeySetIterator a = readableMap.a();
        while (a.hasNextKey()) {
            String nextKey = a.nextKey();
            switch (C07171.f5564a[readableMap.getType(nextKey).ordinal()]) {
                case 1:
                    eventBuilder.d(nextKey, "null");
                    break;
                case 2:
                    eventBuilder.a(nextKey, Boolean.valueOf(readableMap.getBoolean(nextKey)));
                    break;
                case 3:
                    eventBuilder.a(nextKey, Double.valueOf(readableMap.getDouble(nextKey)));
                    break;
                case 4:
                    eventBuilder.d(nextKey, readableMap.getString(nextKey));
                    break;
                case 5:
                    m6880a(eventBuilder.c().b(nextKey), readableMap.b(nextKey));
                    break;
                case 6:
                    m6879a(eventBuilder.c().c(nextKey), readableMap.a(nextKey));
                    break;
                default:
                    throw new JSApplicationCausedNativeException("Unknown data type");
            }
        }
    }

    private static void m6880a(ParamsCollectionMap paramsCollectionMap, ReadableMap readableMap) {
        ReadableMapKeySetIterator a = readableMap.a();
        while (a.hasNextKey()) {
            String nextKey = a.nextKey();
            switch (C07171.f5564a[readableMap.getType(nextKey).ordinal()]) {
                case 1:
                    paramsCollectionMap.a(nextKey, "null");
                    break;
                case 2:
                    paramsCollectionMap.a(nextKey, Boolean.valueOf(readableMap.getBoolean(nextKey)));
                    break;
                case 3:
                    paramsCollectionMap.a(nextKey, Double.valueOf(readableMap.getDouble(nextKey)));
                    break;
                case 4:
                    paramsCollectionMap.a(nextKey, readableMap.getString(nextKey));
                    break;
                case 5:
                    m6880a(paramsCollectionMap.b(nextKey), readableMap.b(nextKey));
                    break;
                case 6:
                    m6879a(paramsCollectionMap.c(nextKey), readableMap.a(nextKey));
                    break;
                default:
                    throw new JSApplicationCausedNativeException("Unknown data type");
            }
        }
    }

    private static void m6879a(ParamsCollectionArray paramsCollectionArray, ReadableArray readableArray) {
        for (int i = 0; i < readableArray.size(); i++) {
            switch (C07171.f5564a[readableArray.getType(i).ordinal()]) {
                case 1:
                    paramsCollectionArray.a("null");
                    break;
                case 2:
                    paramsCollectionArray.a(Boolean.valueOf(readableArray.getBoolean(i)));
                    break;
                case 3:
                    paramsCollectionArray.a(Double.valueOf(readableArray.getDouble(i)));
                    break;
                case 4:
                    paramsCollectionArray.a(readableArray.getString(i));
                    break;
                case 5:
                    m6880a(paramsCollectionArray.k(), readableArray.b(i));
                    break;
                case 6:
                    m6879a(paramsCollectionArray.l(), readableArray.a(i));
                    break;
                default:
                    throw new JSApplicationCausedNativeException("Unknown data type");
            }
        }
    }
}
