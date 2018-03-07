package com.facebook.account.recovery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import com.facebook.account.recovery.constants.AccountRecoveryPrefKeys;
import com.facebook.account.recovery.fragment.AccountConfirmFragment;
import com.facebook.account.recovery.fragment.AccountConfirmFragment$OnConfirmationCodeValidatedListener;
import com.facebook.account.recovery.fragment.AccountSearchFragment;
import com.facebook.account.recovery.fragment.AccountSearchFragment$AccountSearchListener;
import com.facebook.account.recovery.fragment.FriendSearchFragment;
import com.facebook.account.recovery.fragment.FriendSearchFragment$FriendSearchListener;
import com.facebook.account.recovery.fragment.LogoutFragment;
import com.facebook.account.recovery.fragment.LogoutFragment$LogoutListener;
import com.facebook.account.recovery.fragment.ResetPasswordFragment;
import com.facebook.account.recovery.fragment.ResetPasswordFragment$OnPasswordResetListener;
import com.facebook.account.recovery.logging.AccountRecoveryAnalyticsLogger;
import com.facebook.account.recovery.model.AccountCandidateModel;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.captcha.fragment.CaptchaFragment;
import com.facebook.captcha.fragment.CaptchaFragment$OnCaptchaSolvedListener;
import com.facebook.common.activitylistener.annotations.IAuthNotRequired;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.crudolib.urimap.UriMatchPatterns;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.HasTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import org.json.JSONArray;

@UriMatchPatterns
/* compiled from: trimCacheParamIdsToKeep */
public class AccountRecoveryActivity extends FbFragmentActivity implements AccountConfirmFragment$OnConfirmationCodeValidatedListener, AccountSearchFragment$AccountSearchListener, FriendSearchFragment$FriendSearchListener, LogoutFragment$LogoutListener, ResetPasswordFragment$OnPasswordResetListener, CaptchaFragment$OnCaptchaSolvedListener, IAuthNotRequired, HasTitleBar {
    private static final Class<?> f694s = AccountRecoveryActivity.class;
    private static final PrefKey f695t = ((PrefKey) SharedPrefKeys.d.a("ar_logout"));
    @Inject
    AccountRecoveryAnalyticsLogger f696p;
    @Inject
    FbSharedPreferences f697q;
    @Inject
    FbObjectMapper f698r;
    private FbTitleBar f699u;
    private String f700v;
    private String f701w;
    private String f702x = "";
    private View f703y;

    private static <T extends Context> void m1068a(Class<T> cls, T t) {
        m1069a((Object) t, (Context) t);
    }

    public static void m1069a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((AccountRecoveryActivity) obj).m1067a(AccountRecoveryAnalyticsLogger.m1058a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    private void m1067a(AccountRecoveryAnalyticsLogger accountRecoveryAnalyticsLogger, FbSharedPreferences fbSharedPreferences, FbObjectMapper fbObjectMapper) {
        this.f696p = accountRecoveryAnalyticsLogger;
        this.f697q = fbSharedPreferences;
        this.f698r = fbObjectMapper;
    }

    protected final void m1077b(Bundle bundle) {
        super.b(bundle);
        Class cls = AccountRecoveryActivity.class;
        m1069a((Object) this, (Context) this);
        setContentView(2130903069);
        FragmentManager kO_ = kO_();
        FbTitleBarUtil.b(this);
        this.f699u = (FbTitleBar) findViewById(2131558563);
        this.f699u.a(new 1(this, kO_));
        AccountSearchFragment accountSearchFragment = new AccountSearchFragment();
        Object i = m1071i();
        if (!StringUtil.a(i)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("parallel_search", i);
            accountSearchFragment.g(bundle2);
        }
        kO_.a().a(2131559174, accountSearchFragment, "account_search").b();
    }

    public final void a_(String str) {
        this.f699u.setTitle(str);
    }

    public final void y_(int i) {
        this.f699u.setTitle(i);
    }

    public void setCustomTitle(View view) {
        this.f699u.setCustomTitleView(view);
        this.f703y = view;
    }

    public final View lh_() {
        return this.f703y;
    }

    public final void m1075a(TitleBarButtonSpec titleBarButtonSpec) {
    }

    public final void m1078b(TitleBarButtonSpec titleBarButtonSpec) {
    }

    public final void m1074a(OnToolbarButtonListener onToolbarButtonListener) {
    }

    public final void kg_() {
    }

    public final void m1084c(boolean z) {
    }

    public final void mo69b(String str) {
        FriendSearchFragment friendSearchFragment = (FriendSearchFragment) kO_().a("friend_search");
        if (friendSearchFragment != null) {
            friendSearchFragment.f = str;
            friendSearchFragment.b.a();
            friendSearchFragment.b.b();
            friendSearchFragment.c.setVisibility(8);
            friendSearchFragment.d.setVisibility(8);
            return;
        }
        friendSearchFragment = new FriendSearchFragment();
        Bundle bundle = new Bundle();
        bundle.putString("query", str);
        friendSearchFragment.g(bundle);
        kO_().a().b(2131559174, friendSearchFragment, "friend_search").a(null).b();
    }

    public final void mo67a(AccountCandidateModel accountCandidateModel, boolean z) {
        AccountConfirmFragment accountConfirmFragment = (AccountConfirmFragment) kO_().a(2131559162);
        if (accountConfirmFragment != null) {
            accountConfirmFragment.a(accountCandidateModel, z);
            return;
        }
        accountConfirmFragment = new AccountConfirmFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("account_profile", accountCandidateModel);
        bundle.putBoolean("auto_identify", z);
        accountConfirmFragment.g(bundle);
        kO_().a().b(2131559174, accountConfirmFragment).a(null).b();
    }

    public final void mo68a(String str, String str2) {
        m1070a(str, str2, Boolean.valueOf(false));
    }

    public final void mo70b(String str, String str2) {
        this.f700v = str;
        this.f701w = str2;
        LogoutFragment logoutFragment = (LogoutFragment) kO_().a("logout");
        if (logoutFragment != null) {
            logoutFragment.f = this.f700v;
            return;
        }
        logoutFragment = new LogoutFragment();
        Bundle bundle = new Bundle();
        bundle.putString("account_secret_id", this.f700v);
        logoutFragment.g(bundle);
        kO_().a().b(2131559174, logoutFragment, "logout").a(null).b();
    }

    public final void mo71b(boolean z) {
        ResetPasswordFragment resetPasswordFragment = (ResetPasswordFragment) kO_().a(2131566977);
        if (resetPasswordFragment != null) {
            String str = this.f700v;
            String str2 = this.f701w;
            resetPasswordFragment.h = str;
            resetPasswordFragment.i = str2;
            return;
        }
        resetPasswordFragment = new ResetPasswordFragment();
        Bundle bundle = new Bundle();
        bundle.putString("account_secret_id", this.f700v);
        bundle.putString("account_confirmation_code", this.f701w);
        bundle.putBoolean("account_logout", z);
        resetPasswordFragment.g(bundle);
        kO_().a().b(2131559174, resetPasswordFragment).a(null).b();
    }

    public final void mo73c(String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("account_user_id", str);
        intent.putExtra("account_password", str2);
        setResult(-1, intent);
        finish();
    }

    public void onBackPressed() {
        Fragment a = kO_().a(2131559174);
        if (a != null && (a instanceof AccountSearchFragment)) {
            Object obj;
            AccountSearchFragment accountSearchFragment = (AccountSearchFragment) a;
            if (accountSearchFragment.b.isEmpty()) {
                obj = null;
            } else {
                AccountSearchFragment.e(accountSearchFragment);
                accountSearchFragment.c.m1062b(accountSearchFragment.az.name());
                obj = 1;
            }
            if (obj != null) {
                return;
            }
        }
        super.onBackPressed();
    }

    public final void mo66a() {
        m1070a(this.f702x, "", Boolean.valueOf(true));
    }

    public final void mo72c(String str) {
        this.f702x = str;
        kO_().a().b(2131559174, new CaptchaFragment(), "captcha").a(null).b();
    }

    private void m1070a(String str, String str2, Boolean bool) {
        FragmentManager kO_ = kO_();
        if (kO_.f() > 0) {
            kO_.e();
        }
        AccountSearchFragment accountSearchFragment = (AccountSearchFragment) kO_.a("account_search");
        if (accountSearchFragment != null) {
            accountSearchFragment.av = str;
            accountSearchFragment.aw = str2;
            if (StringUtil.a(accountSearchFragment.av)) {
                AccountSearchFragment.e(accountSearchFragment);
                return;
            }
            accountSearchFragment.an.setText(accountSearchFragment.av);
            accountSearchFragment.an.onEditorAction(accountSearchFragment.an, 3, null);
            return;
        }
        accountSearchFragment = new AccountSearchFragment();
        Bundle bundle = new Bundle();
        bundle.putString("query", str);
        bundle.putString("friend_name", str2);
        bundle.putBoolean("account_search_use_query_now", bool.booleanValue());
        accountSearchFragment.g(bundle);
        kO_().a().b(2131559174, accountSearchFragment, "account_search").a(null).b();
    }

    private String m1071i() {
        HashMap hashMap;
        Throwable e;
        Object stringExtra;
        JSONArray jSONArray;
        List arrayList;
        int i;
        String a;
        HashMap hashMap2 = new HashMap();
        if (this.f697q.a(AccountRecoveryPrefKeys.a)) {
            Object a2 = this.f697q.a(AccountRecoveryPrefKeys.a, null);
            if (StringUtil.a(a2)) {
                hashMap = hashMap2;
            } else {
                try {
                    hashMap = (HashMap) this.f698r.a(a2, new 2(this));
                    try {
                        this.f696p.m1064k();
                    } catch (IOException e2) {
                        e = e2;
                        BLog.b(f694s, "Fetching DeviceData from SharedPreferences failed", e);
                        this.f697q.edit().a(AccountRecoveryPrefKeys.a).commit();
                        stringExtra = getIntent().getStringExtra("cuids");
                        if (!StringUtil.a(stringExtra)) {
                            try {
                                jSONArray = new JSONArray(stringExtra);
                                arrayList = new ArrayList();
                                for (i = 0; i < jSONArray.length(); i++) {
                                    arrayList.add(jSONArray.get(i).toString());
                                }
                                hashMap.put("cuid", arrayList);
                                this.f696p.m1065l();
                            } catch (Throwable e3) {
                                BLog.b(f694s, "Parsing encrypted user IDs failed", e3);
                            }
                        }
                        if (!hashMap.isEmpty()) {
                            return null;
                        }
                        a = this.f698r.a(hashMap);
                        return a;
                    }
                } catch (Throwable e4) {
                    Throwable th = e4;
                    hashMap = hashMap2;
                    e3 = th;
                    BLog.b(f694s, "Fetching DeviceData from SharedPreferences failed", e3);
                    this.f697q.edit().a(AccountRecoveryPrefKeys.a).commit();
                    stringExtra = getIntent().getStringExtra("cuids");
                    if (StringUtil.a(stringExtra)) {
                        jSONArray = new JSONArray(stringExtra);
                        arrayList = new ArrayList();
                        for (i = 0; i < jSONArray.length(); i++) {
                            arrayList.add(jSONArray.get(i).toString());
                        }
                        hashMap.put("cuid", arrayList);
                        this.f696p.m1065l();
                    }
                    if (!hashMap.isEmpty()) {
                        return null;
                    }
                    a = this.f698r.a(hashMap);
                    return a;
                }
            }
            this.f697q.edit().a(AccountRecoveryPrefKeys.a).commit();
        } else {
            hashMap = hashMap2;
        }
        stringExtra = getIntent().getStringExtra("cuids");
        if (StringUtil.a(stringExtra)) {
            jSONArray = new JSONArray(stringExtra);
            arrayList = new ArrayList();
            for (i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.get(i).toString());
            }
            hashMap.put("cuid", arrayList);
            this.f696p.m1065l();
        }
        try {
            if (!hashMap.isEmpty()) {
                return null;
            }
            a = this.f698r.a(hashMap);
            return a;
        } catch (Throwable e42) {
            BLog.b(f694s, "JsonCode Account Search Assisted Data failed", e42);
            a = null;
        }
    }
}
