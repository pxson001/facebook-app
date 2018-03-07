package com.facebook.auth.protocol;

import com.facebook.auth.component.AuthenticationResult;
import com.facebook.auth.credentials.FacebookCredentials;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.TriState;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import javax.inject.Inject;

/* compiled from: target_dialect_name */
public class AuthenticationResultExtractor {
    private final ObjectMapper f1303a;
    private final AbstractFbErrorReporter f1304b;

    public static AuthenticationResultExtractor m1535b(InjectorLike injectorLike) {
        return new AuthenticationResultExtractor((ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public AuthenticationResultExtractor(ObjectMapper objectMapper, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f1303a = objectMapper;
        this.f1304b = abstractFbErrorReporter;
    }

    public final AuthenticationResult m1536a(JsonNode jsonNode, String str, boolean z, String str2) {
        String b = JSONUtil.b(jsonNode.b("uid"));
        String b2 = JSONUtil.b(jsonNode.b("access_token"));
        String a = JSONUtil.a(jsonNode.b("user_storage_key"), "");
        String a2 = JSONUtil.a(jsonNode.b("user_storage_key_prev"), "");
        String b3 = JSONUtil.b(jsonNode.b("machine_id"));
        String b4 = JSONUtil.b(jsonNode.b("secret"));
        ArrayNode arrayNode = (ArrayNode) jsonNode.b("session_cookies");
        String b5 = JSONUtil.b(jsonNode.b("session_key"));
        TriState valueOf = TriState.valueOf(JSONUtil.g(jsonNode.b("confirmed")));
        String str3 = null;
        if (z) {
            if (arrayNode != null) {
                try {
                    str3 = this.f1303a.a(arrayNode);
                } catch (Throwable e) {
                    this.f1304b.a(str2 + ":IOException", "Unable to serialize session cookie.", e);
                }
            } else {
                this.f1304b.a(str2 + ":cookiesArrayMissing", "server did not return session cookie when asked.");
            }
        }
        return new AuthenticationResultImpl(b, new FacebookCredentials(b, b2, str3, b4, b5, str), b3, valueOf, a, a2);
    }
}
