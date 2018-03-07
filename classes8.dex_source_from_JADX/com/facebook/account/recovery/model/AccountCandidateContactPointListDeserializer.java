package com.facebook.account.recovery.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: loadingItemId */
public class AccountCandidateContactPointListDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f10304a;

    static {
        GlobalAutoGenDeserializerCache.a(AccountCandidateContactPointList.class, new AccountCandidateContactPointListDeserializer());
        m12085e();
    }

    public AccountCandidateContactPointListDeserializer() {
        a(AccountCandidateContactPointList.class);
    }

    private static synchronized Map<String, FbJsonField> m12085e() {
        Map<String, FbJsonField> map;
        synchronized (AccountCandidateContactPointListDeserializer.class) {
            if (f10304a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("data", FbJsonField.jsonField(AccountCandidateContactPointList.class.getDeclaredField("candidateContactPoints"), AccountCandidateContactPoint.class));
                    f10304a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f10304a;
        }
        return map;
    }

    public final FbJsonField m12086a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m12085e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m12085e().keySet());
    }
}
