package com.facebook.katana.binding.sessioninfo;

import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import com.facebook.auth.component.AuthenticationResult;
import com.facebook.auth.credentials.FacebookCredentials;
import com.facebook.auth.credentials.SessionCookie;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.auth.protocol.AuthenticationResultImpl;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.init.INeedInit;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.model.FacebookUser;
import com.facebook.ipc.model.FacebookUserCoverPhoto;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.prefs.FbandroidPrefKeys;
import com.facebook.legacykeyvalue.db.LegacyKeyValueDatabaseSupplier;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.user.model.User;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: shoerack_notifications */
public class SessionInfoHelper implements INeedInit {
    private final ObjectMapper f4966a;
    private final LoggedInUserSessionManager f4967b;
    private final AbstractFbErrorReporter f4968c;
    private final FbSharedPreferences f4969d;
    private final Lazy<LegacyKeyValueDatabaseSupplier> f4970e;

    public static SessionInfoHelper m8877b(InjectorLike injectorLike) {
        return new SessionInfoHelper(FbObjectMapperMethodAutoProvider.m6609a(injectorLike), LoggedInUserSessionManager.m2511a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2471));
    }

    @Inject
    public SessionInfoHelper(ObjectMapper objectMapper, LoggedInUserSessionManager loggedInUserSessionManager, FbErrorReporter fbErrorReporter, FbSharedPreferences fbSharedPreferences, Lazy<LegacyKeyValueDatabaseSupplier> lazy) {
        this.f4966a = objectMapper;
        this.f4967b = loggedInUserSessionManager;
        this.f4968c = fbErrorReporter;
        this.f4969d = fbSharedPreferences;
        this.f4970e = lazy;
    }

    public void init() {
        if (this.f4967b.m2522b()) {
            m8881e();
        } else {
            m8878b();
        }
    }

    @Deprecated
    @Nullable
    public final FacebookSessionInfo m8882a() {
        if (!this.f4967b.m2522b()) {
            return null;
        }
        ViewerContext a = this.f4967b.m2517a();
        List a2 = SessionCookie.a(this.f4966a, a.mSessionCookiesString);
        User c = this.f4967b.m2523c();
        return new FacebookSessionInfo(a.m1531g(), a.m1530f(), a.m1529e(), a.m1526b(), Long.parseLong(a.m1525a()), this.f4969d.mo278a(AuthPrefKeys.f2951f, null), new FacebookUser(Long.parseLong(a.m1525a()), c.m5843h(), c.m5844i(), c.m5845j(), c.m5856x(), new FacebookUserCoverPhoto(c.m5857y())), a2, this.f4968c);
    }

    @Nullable
    private void m8878b() {
        String d;
        FacebookSessionInfo facebookSessionInfo;
        String c = m8879c();
        if (c == null) {
            d = m8880d();
        } else {
            d = c;
        }
        m8881e();
        if (d != null) {
            try {
                facebookSessionInfo = (FacebookSessionInfo) this.f4966a.m6657a(d, FacebookSessionInfo.class);
            } catch (Exception e) {
                this.f4968c.m2340a("CorruptedSessionOnDisk", "Couldn't resume session from disk because it was corrupt." + d);
            }
            if (facebookSessionInfo == null) {
            }
            if (FacebookSessionInfo.a(facebookSessionInfo)) {
                this.f4968c.m2340a("InvalidSessionOnDisk", "Couldn't resume session from disk because it was invalid." + d);
            } else {
                m8875a(facebookSessionInfo);
            }
        }
        facebookSessionInfo = null;
        if (facebookSessionInfo == null) {
            if (FacebookSessionInfo.a(facebookSessionInfo)) {
                this.f4968c.m2340a("InvalidSessionOnDisk", "Couldn't resume session from disk because it was invalid." + d);
            } else {
                m8875a(facebookSessionInfo);
            }
        }
    }

    private String m8879c() {
        return this.f4969d.mo278a((PrefKey) FbandroidPrefKeys.f19411c.m2011a("active_session_info"), null);
    }

    private String m8880d() {
        String str = null;
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("user_values");
        Cursor query = sQLiteQueryBuilder.query(((LegacyKeyValueDatabaseSupplier) this.f4970e.get()).mo2480a(), new String[]{"value"}, "name='active_session_info'", null, null, null, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    str = query.getString(0);
                }
                query.close();
            } catch (Throwable th) {
                query.close();
            }
        }
        return str;
    }

    private void m8881e() {
        this.f4969d.edit().mo1271a((PrefKey) FbandroidPrefKeys.f19411c.m2011a("active_session_info")).commit();
        ((LegacyKeyValueDatabaseSupplier) this.f4970e.get()).mo2480a().delete("user_values", "name='active_session_info'", null);
    }

    private void m8875a(FacebookSessionInfo facebookSessionInfo) {
        AuthenticationResult b = m8876b(facebookSessionInfo);
        FacebookCredentials b2 = b.b();
        this.f4967b.m2518a(b2);
        if (!this.f4969d.mo285a(AuthPrefKeys.f2951f)) {
            this.f4969d.edit().mo1276a(AuthPrefKeys.f2951f, b.c()).commit();
        }
        UserBuilder userBuilder = new UserBuilder();
        userBuilder.m5767a(Type.FACEBOOK, b2.a);
        FacebookUser a = facebookSessionInfo.a();
        if (a != null) {
            userBuilder.f3551h = a.a();
            userBuilder.f3552i = a.mFirstName;
            userBuilder.f3553j = a.mLastName;
            if (a.mImageUrl != null) {
                userBuilder.f3557n = a.mImageUrl;
            }
            if (a.mCoverPhoto != null) {
                userBuilder.f3558o = a.mCoverPhoto.source;
            }
        }
        this.f4967b.m2524c(userBuilder.aa());
    }

    private AuthenticationResult m8876b(FacebookSessionInfo facebookSessionInfo) {
        String str;
        Object sessionCookies = facebookSessionInfo.getSessionCookies();
        String str2 = null;
        if (sessionCookies != null) {
            try {
                str2 = this.f4966a.m6659a(sessionCookies);
            } catch (Throwable e) {
                this.f4968c.m2343a("AppSession_SerializeSessionInfo", "Unable to serialize session info into string.", e);
                str = str2;
            }
        }
        str = str2;
        String valueOf = String.valueOf(facebookSessionInfo.userId);
        return new AuthenticationResultImpl(valueOf, new FacebookCredentials(String.valueOf(facebookSessionInfo.userId), facebookSessionInfo.oAuthToken, str, facebookSessionInfo.sessionSecret, facebookSessionInfo.sessionKey, facebookSessionInfo.username), facebookSessionInfo.machineID, TriState.UNSET, "", "");
    }
}
