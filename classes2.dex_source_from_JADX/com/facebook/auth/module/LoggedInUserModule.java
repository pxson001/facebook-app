package com.facebook.auth.module;

import android.annotation.SuppressLint;
import android.content.Context;
import com.facebook.auth.annotations.IsMeUserAMessengerOnlyUser;
import com.facebook.auth.annotations.IsMeUserAWorkUser;
import com.facebook.auth.annotations.IsMeUserAnEmployee;
import com.facebook.auth.annotations.IsMeUserDeactivatedOnFbNotOnMessenger;
import com.facebook.auth.annotations.IsPartialAccount;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.annotations.LoggedInUserKey;
import com.facebook.auth.annotations.ViewerContextUser;
import com.facebook.auth.annotations.ViewerContextUserId;
import com.facebook.auth.annotations.ViewerContextUserKey;
import com.facebook.auth.credentials.UserTokenCredentials;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.auth.module.ViewerContextManagerImpl.MyListener;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.auth.viewercontext.ViewerContextManagerForApp;
import com.facebook.auth.viewercontext.ViewerContextManagerForContext;
import com.facebook.common.util.TriState;
import com.facebook.config.application.Product;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.user.gender.Gender;
import com.facebook.user.gender.UserGender;
import com.facebook.user.model.User;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.google.common.base.Objects;
import javax.inject.Provider;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: user attribute referrer */
public class LoggedInUserModule extends AbstractLibraryModule {
    @SuppressLint({"NontrivialConfigureMethod"})
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @LoggedInUserId
    static String m2894a(ViewerContextManager viewerContextManager) {
        ViewerContext a = viewerContextManager.mo212a();
        if (a == null) {
            return null;
        }
        return a.mUserId;
    }

    @ProviderMethod
    @LoggedInUserKey
    static UserKey m2891a(User user) {
        return user != null ? user.f3592T : null;
    }

    @ProviderMethod
    @IsMeUserAnEmployee
    static TriState m2888a(Provider<User> provider, FbSharedPreferences fbSharedPreferences) {
        if (!fbSharedPreferences.mo284a()) {
            return TriState.UNSET;
        }
        User user = (User) provider.get();
        if (user == null) {
            return TriState.UNSET;
        }
        return user.f3612o ? TriState.YES : TriState.NO;
    }

    @ProviderMethod
    @IsMeUserAWorkUser
    public static TriState m2887a(LoggedInUserSessionManager loggedInUserSessionManager) {
        if (loggedInUserSessionManager.m2522b()) {
            return loggedInUserSessionManager.m2523c().f3613p ? TriState.YES : TriState.NO;
        } else {
            return TriState.UNSET;
        }
    }

    @ProviderMethod
    @IsPartialAccount
    static TriState m2897b(LoggedInUserSessionManager loggedInUserSessionManager) {
        return loggedInUserSessionManager.m2522b() ? TriState.valueOf(loggedInUserSessionManager.m2523c().f3577E) : TriState.UNSET;
    }

    @ProviderMethod
    @IsPartialAccount
    public static Boolean m2892a(TriState triState) {
        return Boolean.valueOf(triState.asBoolean(false));
    }

    @ProviderMethod
    @IsMeUserAMessengerOnlyUser
    public static Boolean m2899b(User user) {
        boolean booleanValue = user == null ? Boolean.FALSE.booleanValue() : user.f3577E && !user.f3587O;
        return Boolean.valueOf(booleanValue);
    }

    @IsMeUserDeactivatedOnFbNotOnMessenger
    @ProviderMethod
    static Boolean m2900c(User user) {
        boolean booleanValue = user == null ? Boolean.FALSE.booleanValue() : user.f3577E && user.f3587O;
        return Boolean.valueOf(booleanValue);
    }

    @ProviderMethod
    @Singleton
    static MyListener m2885a() {
        return new MyListener();
    }

    @ProviderMethod
    static ViewerContext m2895b(ViewerContextManager viewerContextManager) {
        return viewerContextManager.mo217d();
    }

    @ProviderMethod
    public static UserTokenCredentials m2884a(LoggedInUserSessionManager loggedInUserSessionManager) {
        ViewerContext a = loggedInUserSessionManager.m2517a();
        return a != null ? new UserTokenCredentials(a.mUserId, a.mAuthToken) : null;
    }

    @ProviderMethod
    @ViewerContextUser
    public static User m2890a(ViewerContext viewerContext, Provider<User> provider, Product product) {
        if (product == Product.PAA) {
            throw new IllegalStateException("cannot use default viewer context user provider for Page Manager");
        }
        User user = (User) provider.get();
        if (user == null) {
            return null;
        }
        if (Objects.equal(user.f3598a, viewerContext.mUserId)) {
            return user;
        }
        throw new IllegalStateException("viewer context id and logged in user id should always be the same in " + product);
    }

    @ProviderMethod
    @ViewerContextUserId
    static String m2893a(ViewerContext viewerContext) {
        return viewerContext != null ? viewerContext.mUserId : null;
    }

    @ProviderMethod
    @ViewerContextUserKey
    static UserKey m2898b(ViewerContext viewerContext) {
        return viewerContext != null ? new UserKey(Type.FACEBOOK, viewerContext.mUserId) : null;
    }

    @ProviderMethod
    @Singleton
    @ViewerContextManagerForApp
    static ViewerContextManager m2886a(LoggedInUserSessionManager loggedInUserSessionManager, Context context) {
        return new ViewerContextManagerImpl(loggedInUserSessionManager, context);
    }

    @ProviderMethod
    @ViewerContextManagerForContext
    @ContextScoped
    static ViewerContextManager m2896b(LoggedInUserSessionManager loggedInUserSessionManager, Context context) {
        return new ViewerContextManagerImpl(loggedInUserSessionManager, context);
    }

    @ProviderMethod
    @UserGender
    public static Gender m2889a(Provider<User> provider) {
        User user = (User) provider.get();
        if (user == null || user.f3605h == null) {
            return Gender.UNKNOWN;
        }
        return user.f3605h;
    }
}
