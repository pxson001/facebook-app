package com.facebook.katana.model;

import com.facebook.auth.credentials.SessionCookie;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.ipc.model.FacebookUser;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = FacebookSessionInfoDeserializer.class)
@Deprecated
/* compiled from: update-last-read */
public class FacebookSessionInfo {
    private List<SessionCookie> f937a;
    private AbstractFbErrorReporter f938b;
    @JsonProperty("error_data")
    public final String errorData;
    @JsonProperty("filter")
    String mFilterKey;
    @JsonProperty("profile")
    FacebookUser mMyself;
    @JsonProperty("machine_id")
    public final String machineID;
    @JsonProperty("access_token")
    public final String oAuthToken;
    @JsonProperty("session_key")
    public final String sessionKey;
    @JsonProperty("secret")
    public final String sessionSecret;
    @JsonProperty("uid")
    public final long userId;
    @JsonProperty("username")
    public String username;

    /* compiled from: update-last-read */
    class C01491 extends TypeReference<List<SessionCookie>> {
        final /* synthetic */ FacebookSessionInfo f936b;

        C01491(FacebookSessionInfo facebookSessionInfo) {
            this.f936b = facebookSessionInfo;
        }
    }

    public static boolean m986a(FacebookSessionInfo facebookSessionInfo) {
        return (facebookSessionInfo == null || facebookSessionInfo.userId == -1 || facebookSessionInfo.sessionKey == null || facebookSessionInfo.sessionSecret == null || facebookSessionInfo.oAuthToken == null || facebookSessionInfo.mMyself == null) ? false : true;
    }

    protected FacebookSessionInfo() {
        this.username = null;
        this.sessionKey = null;
        this.sessionSecret = null;
        this.oAuthToken = null;
        this.machineID = null;
        this.errorData = null;
        this.userId = -1;
        this.f937a = null;
    }

    public FacebookSessionInfo(String str, String str2, String str3, String str4, long j, @Nullable String str5, FacebookUser facebookUser, @Nullable List<SessionCookie> list, FbErrorReporter fbErrorReporter) {
        this.username = str;
        this.sessionKey = str2;
        this.sessionSecret = str3;
        this.oAuthToken = str4;
        this.userId = j;
        this.machineID = str5;
        this.errorData = null;
        this.mFilterKey = null;
        this.mMyself = facebookUser;
        this.f937a = list;
        this.f938b = fbErrorReporter;
    }

    public final FacebookUser m987a() {
        return this.mMyself;
    }

    @JsonProperty("session_cookies")
    public List<SessionCookie> getSessionCookies() {
        if (this.f937a != null) {
            return Collections.unmodifiableList(this.f937a);
        }
        return null;
    }

    @JsonProperty("session_cookies")
    public void setSessionCookies(TokenBuffer tokenBuffer) {
        if (tokenBuffer == null) {
            this.f937a = null;
            return;
        }
        try {
            JsonParser i = tokenBuffer.i();
            if (i != null) {
                this.f937a = (List) i.a(new C01491(this));
            }
        } catch (IOException e) {
            this.f937a = null;
        }
    }

    public final void m988b() {
        this.f937a = null;
    }
}
