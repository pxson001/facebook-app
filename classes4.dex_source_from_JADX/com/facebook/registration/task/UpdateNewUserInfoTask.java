package com.facebook.registration.task;

import com.facebook.backgroundtasks.AbstractBackgroundTask;
import com.facebook.backgroundtasks.BackgroundResult;
import com.facebook.backgroundtasks.BackgroundTask.Prerequisite;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.calls.UserUpdateGenderInputData;
import com.facebook.graphql.calls.UserUpdateGenderInputData.NewGender;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.registration.logging.SimpleRegLogger;
import com.facebook.registration.prefs.RegistrationPrefKeys;
import com.facebook.registration.protocol.UserInfoMutations;
import com.facebook.registration.protocol.UserInfoMutations.UserUpdateGenderCoreMutationString;
import com.facebook.registration.util.RegistrationUtil;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: extra_topic_name */
public class UpdateNewUserInfoTask extends AbstractBackgroundTask {
    private final FbSharedPreferences f12430a;
    private final Provider<String> f12431b;
    private final GraphQLQueryExecutor f12432c;
    private final SimpleRegLogger f12433d;
    private final RegistrationUtil f12434e;
    private int f12435f = 0;

    @Inject
    public UpdateNewUserInfoTask(FbSharedPreferences fbSharedPreferences, Provider<String> provider, GraphQLQueryExecutor graphQLQueryExecutor, SimpleRegLogger simpleRegLogger, RegistrationUtil registrationUtil) {
        super("UPDATE_NEW_USER_INFO");
        this.f12430a = fbSharedPreferences;
        this.f12431b = provider;
        this.f12432c = graphQLQueryExecutor;
        this.f12433d = simpleRegLogger;
        this.f12434e = registrationUtil;
    }

    public final Set<Prerequisite> mo594h() {
        return ImmutableSet.of(Prerequisite.NETWORK_CONNECTIVITY, Prerequisite.USER_LOGGED_IN);
    }

    public final boolean mo595i() {
        String str = (String) this.f12431b.get();
        if (this.f12430a.a(RegistrationPrefKeys.m13187a(str)) || this.f12430a.a(RegistrationPrefKeys.m13188b(str))) {
            return true;
        }
        return false;
    }

    public final long mo593f() {
        return -1;
    }

    public final ListenableFuture<BackgroundResult> mo596j() {
        boolean z;
        boolean z2 = true;
        String str = (String) this.f12431b.get();
        this.f12435f++;
        Object a = this.f12430a.a(RegistrationPrefKeys.m13187a(str), null);
        if (StringUtil.a(a)) {
            z = false;
        } else {
            UserUpdateGenderInputData a2 = new UserUpdateGenderInputData().a(NewGender.valueOf(a));
            UserUpdateGenderCoreMutationString a3 = UserInfoMutations.a();
            a3.a("input", a2);
            try {
                FutureDetour.a(this.f12432c.a(GraphQLRequest.a(a3)), -596996488);
                this.f12433d.m13173f();
                m13140a(str);
                z = false;
            } catch (Exception e) {
                if (this.f12435f >= 3) {
                    m13140a(str);
                    z = false;
                } else {
                    z = true;
                }
            }
        }
        String a4 = this.f12430a.a(RegistrationPrefKeys.m13188b(str), null);
        if (!StringUtil.a(a4)) {
            File file = new File(a4);
            if (file.exists()) {
                try {
                    FutureDetour.a(this.f12434e.m13195a(str, a4), -1873551470);
                    this.f12433d.m13181k();
                    m13141b(str);
                    file.delete();
                } catch (Exception e2) {
                    this.f12433d.m13174f("Upload error - " + e2.getMessage());
                    if (this.f12435f >= 3) {
                        m13141b(str);
                        file.delete();
                    } else {
                        z = true;
                    }
                }
            } else {
                this.f12433d.m13174f("File doesn't exist");
                m13141b(str);
            }
        }
        if (z) {
            z2 = false;
        }
        return Futures.a(new BackgroundResult(z2));
    }

    private void m13140a(String str) {
        this.f12430a.edit().a(RegistrationPrefKeys.m13187a(str)).commit();
    }

    private void m13141b(String str) {
        this.f12430a.edit().a(RegistrationPrefKeys.m13188b(str)).commit();
    }
}
