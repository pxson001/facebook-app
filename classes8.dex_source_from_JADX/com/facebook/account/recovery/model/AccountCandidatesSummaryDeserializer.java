package com.facebook.account.recovery.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: load_members_to_add */
public class AccountCandidatesSummaryDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f10310a;

    static {
        GlobalAutoGenDeserializerCache.a(AccountCandidatesSummary.class, new AccountCandidatesSummaryDeserializer());
        m12103e();
    }

    public AccountCandidatesSummaryDeserializer() {
        a(AccountCandidatesSummary.class);
    }

    private static synchronized Map<String, FbJsonField> m12103e() {
        Map<String, FbJsonField> map;
        synchronized (AccountCandidatesSummaryDeserializer.class) {
            if (f10310a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("total_count", FbJsonField.jsonField(AccountCandidatesSummary.class.getDeclaredField("totalCount")));
                    f10310a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f10310a;
        }
        return map;
    }

    public final FbJsonField m12104a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m12103e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m12103e().keySet());
    }
}
