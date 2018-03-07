package com.facebook.account.recovery.model;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: load_start_low_memory */
public class AccountCandidateModelDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f10309a;

    static {
        GlobalAutoGenDeserializerCache.a(AccountCandidateModel.class, new AccountCandidateModelDeserializer());
        m12100e();
    }

    public AccountCandidateModelDeserializer() {
        a(AccountCandidateModel.class);
    }

    private static synchronized Map<String, FbJsonField> m12100e() {
        Map<String, FbJsonField> map;
        synchronized (AccountCandidateModelDeserializer.class) {
            if (f10309a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("id", FbJsonField.jsonField(AccountCandidateModel.class.getDeclaredField("id")));
                    builder.b("name", FbJsonField.jsonField(AccountCandidateModel.class.getDeclaredField("name")));
                    builder.b("network_info", FbJsonField.jsonField(AccountCandidateModel.class.getDeclaredField("networkName")));
                    builder.b("profile_pic_uri", FbJsonField.jsonField(AccountCandidateModel.class.getDeclaredField("profilePictureUri")));
                    builder.b("contactpoints", FbJsonField.jsonField(AccountCandidateModel.class.getDeclaredField("contactPoints")));
                    f10309a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f10309a;
        }
        return map;
    }

    public final FbJsonField m12101a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m12100e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m12100e().keySet());
    }
}
