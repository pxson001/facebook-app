package com.facebook.account.recovery.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: local_content_entry_point */
public class AccountCandidateContactPointDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f10303a;

    static {
        GlobalAutoGenDeserializerCache.a(AccountCandidateContactPoint.class, new AccountCandidateContactPointDeserializer());
        m12082e();
    }

    public AccountCandidateContactPointDeserializer() {
        a(AccountCandidateContactPoint.class);
    }

    private static synchronized Map<String, FbJsonField> m12082e() {
        Map<String, FbJsonField> map;
        synchronized (AccountCandidateContactPointDeserializer.class) {
            if (f10303a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("id", FbJsonField.jsonField(AccountCandidateContactPoint.class.getDeclaredField("id")));
                    builder.b("display", FbJsonField.jsonField(AccountCandidateContactPoint.class.getDeclaredField("displayContactInfo")));
                    builder.b("type", FbJsonField.jsonField(AccountCandidateContactPoint.class.getDeclaredField("contactType")));
                    f10303a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f10303a;
        }
        return map;
    }

    public final FbJsonField m12083a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m12082e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m12082e().keySet());
    }
}
