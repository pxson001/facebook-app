package com.facebook.auth.datastore.impl;

import android.text.TextUtils;
import com.facebook.common.util.TriState;
import com.facebook.crudolib.prefs.LightSharedPreferences$Editor;
import com.facebook.crudolib.prefs.LightSharedPreferencesImpl;
import com.facebook.user.gender.Gender;
import com.facebook.user.model.Name;
import com.facebook.user.model.User;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserBuilder;
import com.facebook.user.model.UserEmailAddress;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: t_inbox */
public class UserDataStore {
    UserDataStore() {
    }

    static void m5752a(User user, LightSharedPreferences$Editor lightSharedPreferences$Editor) {
        String str = user.f3598a;
        Preconditions.checkArgument(!TextUtils.isEmpty(str), "No ID in logged-in user");
        lightSharedPreferences$Editor.mo3283a("uid", str);
        Name name = user.f3602e;
        if (name != null) {
            m5753a("first_name", name.m5808a(), lightSharedPreferences$Editor);
            m5753a("last_name", name.m5810c(), lightSharedPreferences$Editor);
            m5753a("name", name.m5814g(), lightSharedPreferences$Editor);
        }
        lightSharedPreferences$Editor.mo3281a("birth_date_year", user.f3574B);
        lightSharedPreferences$Editor.mo3281a("birth_date_month", user.f3575C);
        lightSharedPreferences$Editor.mo3281a("birth_date_day", user.f3576D);
        Gender gender = user.f3605h;
        if (gender != null) {
            lightSharedPreferences$Editor.mo3283a("gender", gender.name());
        }
        ImmutableList immutableList = user.f3600c;
        if (immutableList != null) {
            int size = immutableList.size();
            if (size > 0) {
                Set hashSet = new HashSet(size);
                for (int i = 0; i < size; i++) {
                    UserEmailAddress userEmailAddress = (UserEmailAddress) immutableList.get(i);
                    if (userEmailAddress != null) {
                        String str2 = userEmailAddress.f3571a;
                        if (!TextUtils.isEmpty(str2)) {
                            hashSet.add(str2);
                        }
                    }
                }
                lightSharedPreferences$Editor.mo3284a("emails", hashSet);
            }
        }
        m5753a("phones", user.m5852s(), lightSharedPreferences$Editor);
        m5753a("pic_square", user.m5856x(), lightSharedPreferences$Editor);
        m5753a("profile_pic_square", user.m5819A(), lightSharedPreferences$Editor);
        m5753a("pic_cover", user.f3607j, lightSharedPreferences$Editor);
        lightSharedPreferences$Editor.mo3280a("rank", user.f3610m);
        TriState triState = user.f3611n;
        if (triState != TriState.UNSET) {
            lightSharedPreferences$Editor.mo3285a("is_pushable", triState.asBoolean(false));
        }
        if (user.f3612o) {
            lightSharedPreferences$Editor.mo3285a("is_employee", true);
        }
        if (user.f3613p) {
            lightSharedPreferences$Editor.mo3285a("is_work_user", true);
        }
        m5753a("type", user.f3616s, lightSharedPreferences$Editor);
        if (user.f3577E) {
            lightSharedPreferences$Editor.mo3285a("is_partial", true);
        }
        if (user.f3578F) {
            lightSharedPreferences$Editor.mo3285a("is_minor", true);
        }
        triState = user.f3579G;
        if (triState != TriState.UNSET) {
            lightSharedPreferences$Editor.mo3285a("profile_picture_is_silhouette", triState.asBoolean(false));
        }
        lightSharedPreferences$Editor.mo3282a("montage_thread_fbid", user.f3585M);
        if (user.f3586N) {
            lightSharedPreferences$Editor.mo3285a("can_see_viewer_montage_thread", true);
        }
        if (user.f3587O) {
            lightSharedPreferences$Editor.mo3285a("is_deactivated_allowed_on_messenger", true);
        }
    }

    @Nullable
    static User m5751a(Type type, LightSharedPreferencesImpl lightSharedPreferencesImpl) {
        String a = lightSharedPreferencesImpl.m2643a("uid", null);
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        UserBuilder userBuilder = new UserBuilder();
        userBuilder.m5767a(type, a);
        userBuilder.f3550g = new Name(lightSharedPreferencesImpl.m2643a("first_name", null), lightSharedPreferencesImpl.m2643a("last_name", null), lightSharedPreferencesImpl.m2643a("name", null));
        userBuilder.m5762a(lightSharedPreferencesImpl.m2641a("birth_date_year", 0), lightSharedPreferencesImpl.m2641a("birth_date_month", 0), lightSharedPreferencesImpl.m2641a("birth_date_day", 0));
        userBuilder.f3556m = m5754b(lightSharedPreferencesImpl);
        Set set = null;
        Builder builder = ImmutableList.builder();
        Set<String> a2 = lightSharedPreferencesImpl.m2645a("emails", null);
        if (a2 != null) {
            for (String userEmailAddress : a2) {
                builder.m1069c(new UserEmailAddress(userEmailAddress, 0));
            }
            set = builder.m1068b();
        }
        userBuilder.f3546c = set;
        userBuilder.f3549f = lightSharedPreferencesImpl.m2643a("phones", null);
        userBuilder.f3557n = lightSharedPreferencesImpl.m2643a("pic_square", null);
        userBuilder.f3560q = lightSharedPreferencesImpl.m2643a("profile_pic_square", null);
        userBuilder.f3558o = lightSharedPreferencesImpl.m2643a("pic_cover", null);
        userBuilder.f3563t = lightSharedPreferencesImpl.m2640a("rank", 0.0f);
        userBuilder.f3564u = m5750a("is_pushable", lightSharedPreferencesImpl);
        userBuilder.f3565v = lightSharedPreferencesImpl.m2647a("is_employee", false);
        userBuilder.f3566w = lightSharedPreferencesImpl.m2647a("is_work_user", false);
        userBuilder.f3569z = lightSharedPreferencesImpl.m2643a("type", null);
        userBuilder.f3529L = lightSharedPreferencesImpl.m2647a("is_partial", false);
        userBuilder.f3530M = lightSharedPreferencesImpl.m2647a("is_minor", false);
        userBuilder.f3531N = m5750a("profile_picture_is_silhouette", lightSharedPreferencesImpl);
        userBuilder.f3542Y = lightSharedPreferencesImpl.m2642a("montage_thread_fbid", 0);
        userBuilder.f3543Z = lightSharedPreferencesImpl.m2647a("can_see_viewer_montage_thread", false);
        userBuilder.f3535R = lightSharedPreferencesImpl.m2647a("is_deactivated_allowed_on_messenger", false);
        return userBuilder.aa();
    }

    private static Gender m5754b(LightSharedPreferencesImpl lightSharedPreferencesImpl) {
        Object a = lightSharedPreferencesImpl.m2643a("gender", null);
        if (TextUtils.isEmpty(a)) {
            return Gender.UNKNOWN;
        }
        try {
            return Gender.valueOf(a);
        } catch (IllegalArgumentException e) {
            return Gender.UNKNOWN;
        }
    }

    public static void m5753a(String str, @Nullable String str2, LightSharedPreferences$Editor lightSharedPreferences$Editor) {
        if (!TextUtils.isEmpty(str2)) {
            lightSharedPreferences$Editor.mo3283a(str, str2);
        }
    }

    private static TriState m5750a(String str, LightSharedPreferencesImpl lightSharedPreferencesImpl) {
        if (lightSharedPreferencesImpl.m2646a(str)) {
            return lightSharedPreferencesImpl.m2647a(str, false) ? TriState.YES : TriState.NO;
        } else {
            return TriState.UNSET;
        }
    }
}
