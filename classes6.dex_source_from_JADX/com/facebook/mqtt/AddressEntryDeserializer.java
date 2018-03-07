package com.facebook.mqtt;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: topics_version */
public class AddressEntryDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f2841a;

    static {
        GlobalAutoGenDeserializerCache.a(AddressEntry.class, new AddressEntryDeserializer());
        m3951e();
    }

    public AddressEntryDeserializer() {
        a(AddressEntry.class);
    }

    private static synchronized Map<String, FbJsonField> m3951e() {
        Map<String, FbJsonField> map;
        synchronized (AddressEntryDeserializer.class) {
            if (f2841a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("host_name", FbJsonField.jsonField(AddressEntry.class.getDeclaredField("mHostName")));
                    builder.b("priority", FbJsonField.jsonField(AddressEntry.class.getDeclaredField("mPriority")));
                    builder.b("fail_count", FbJsonField.jsonField(AddressEntry.class.getDeclaredField("mFailCount")));
                    builder.b("address_list_data", FbJsonField.jsonField(AddressEntry.class.getDeclaredField("mAddressListData"), String.class));
                    f2841a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f2841a;
        }
        return map;
    }

    public final FbJsonField m3952a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m3951e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m3951e().keySet());
    }
}
