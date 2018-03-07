package com.facebook.account.recovery.protocol;

import com.facebook.account.recovery.model.AccountCandidateModel;
import com.facebook.account.recovery.protocol.AccountRecoverySearchAccountMethod.Result;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: list_shown */
public class AccountRecoverySearchAccountMethod_ResultDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f10316a;

    static {
        GlobalAutoGenDeserializerCache.a(Result.class, new AccountRecoverySearchAccountMethod_ResultDeserializer());
        m12114e();
    }

    public AccountRecoverySearchAccountMethod_ResultDeserializer() {
        a(Result.class);
    }

    private static synchronized Map<String, FbJsonField> m12114e() {
        Map<String, FbJsonField> map;
        synchronized (AccountRecoverySearchAccountMethod_ResultDeserializer.class) {
            if (f10316a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("data", FbJsonField.jsonField(Result.class.getDeclaredField("mAccountCandidates"), AccountCandidateModel.class));
                    builder.b("summary", FbJsonField.jsonField(Result.class.getDeclaredField("mSummary")));
                    f10316a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f10316a;
        }
        return map;
    }

    public final FbJsonField m12115a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m12114e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m12114e().keySet());
    }
}
