package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.SerializerCache$TypeKey;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: video_resize_bitrate_kbps */
public class JsonSerializerMap {
    private final Bucket[] f250a;
    private final int f251b;

    /* compiled from: video_resize_bitrate_kbps */
    final class Bucket {
        public final SerializerCache$TypeKey f252a;
        public final JsonSerializer<Object> f253b;
        public final Bucket f254c;

        public Bucket(Bucket bucket, SerializerCache$TypeKey serializerCache$TypeKey, JsonSerializer<Object> jsonSerializer) {
            this.f254c = bucket;
            this.f252a = serializerCache$TypeKey;
            this.f253b = jsonSerializer;
        }
    }

    public JsonSerializerMap(Map<SerializerCache$TypeKey, JsonSerializer<Object>> map) {
        int a = m291a(map.size());
        this.f251b = a;
        int i = a - 1;
        Bucket[] bucketArr = new Bucket[a];
        for (Entry entry : map.entrySet()) {
            SerializerCache$TypeKey serializerCache$TypeKey = (SerializerCache$TypeKey) entry.getKey();
            int hashCode = serializerCache$TypeKey.hashCode() & i;
            bucketArr[hashCode] = new Bucket(bucketArr[hashCode], serializerCache$TypeKey, (JsonSerializer) entry.getValue());
        }
        this.f250a = bucketArr;
    }

    private static final int m291a(int i) {
        int i2 = 8;
        while (i2 < (i <= 64 ? i + i : (i >> 2) + i)) {
            i2 += i2;
        }
        return i2;
    }

    public final JsonSerializer<Object> m292a(SerializerCache$TypeKey serializerCache$TypeKey) {
        Bucket bucket = this.f250a[serializerCache$TypeKey.hashCode() & (this.f250a.length - 1)];
        if (bucket == null) {
            return null;
        }
        if (serializerCache$TypeKey.equals(bucket.f252a)) {
            return bucket.f253b;
        }
        do {
            bucket = bucket.f254c;
            if (bucket == null) {
                return null;
            }
        } while (!serializerCache$TypeKey.equals(bucket.f252a));
        return bucket.f253b;
    }
}
