package com.facebook.katana;

import android.app.Activity;
import android.content.res.Resources;
import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.common.activitylistener.annotations.IAuthNotRequired;
import com.facebook.common.android.ActivityMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.http.protocol.ApiException;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.common.ForegroundStatusProvider;
import com.facebook.katana.prefs.FbandroidPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.resources.IFbResourcesNotRequired;
import java.io.IOException;
import javax.inject.Inject;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ui_notify */
public class LoginErrorHandlingHelper implements IAuthNotRequired, IFbResourcesNotRequired {
    private static final Class<?> f618u = LoginErrorHandlingHelper.class;
    private FbSharedPreferences f619a;
    public Activity f620b;
    public SecureContextHelper f621c;
    private AbstractFbErrorReporter f622d;
    private Resources f623e;
    private final String f624f = "actual_identifier";
    private final String f625g = "error_title";
    private final String f626h = "error_message";
    private final String f627i = "url";
    private final String f628j = "uid";
    private final String f629k = "auth_token";
    private final String f630l = "machine_id";
    private final String f631m = "conditional_uri";
    private final String f632n = "finish_after_loading_url";
    private final String f633o = "start_internal_webview_from_url";
    private final String f634p = "positive_button_string";
    private final String f635q = "negative_button_string";
    private final String f636r = "error_subcode";
    private final String f637s = "login_first_factor";
    public ForegroundStatusProvider f638t;

    /* compiled from: ui_notify */
    public class ErrorData {
        long f717a;
        int f718b;
        String f719c;
        String f720d;
        String f721e;
        String f722f;
        String f723g;
        String f724h;
        String f725i;
        String f726j;
        TriState f727k = TriState.UNSET;
        TriState f728l = TriState.UNSET;
        String f729m;
        String f730n;
    }

    public static LoginErrorHandlingHelper m997b(InjectorLike injectorLike) {
        return new LoginErrorHandlingHelper((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), ActivityMethodAutoProvider.b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public static LoginErrorHandlingHelper m994a(InjectorLike injectorLike) {
        return m997b(injectorLike);
    }

    @Inject
    public LoginErrorHandlingHelper(FbSharedPreferences fbSharedPreferences, Activity activity, SecureContextHelper secureContextHelper, AbstractFbErrorReporter abstractFbErrorReporter, Resources resources) {
        this.f619a = fbSharedPreferences;
        this.f620b = activity;
        this.f621c = secureContextHelper;
        this.f622d = abstractFbErrorReporter;
        this.f623e = resources;
    }

    public final boolean m1004a(int i, ErrorData errorData) {
        if (errorData.f721e == null || errorData.f722f == null) {
            int i2;
            int i3;
            switch (i) {
                case 2:
                    i2 = 2131232472;
                    i3 = 2131232473;
                    break;
                case 400:
                    i2 = 2131232461;
                    i3 = 2131232462;
                    break;
                case 401:
                    i2 = 2131232463;
                    i3 = 2131232464;
                    break;
                case 405:
                    i2 = 2131232468;
                    i3 = 2131232469;
                    break;
                case 406:
                    i2 = 2131232495;
                    i3 = 2131232497;
                    break;
                case 407:
                    i2 = 2131232470;
                    i3 = 2131232471;
                    break;
                default:
                    return false;
            }
            m1002a(this.f623e.getString(i2), this.f623e.getString(i3));
        } else if (errorData.f723g != null) {
            String str = errorData.f729m;
            String str2 = errorData.f730n;
            if (StringUtil.a(str) && StringUtil.a(str2)) {
                str = this.f623e.getString(2131230756);
                str2 = this.f623e.getString(2131237528);
            }
            m995a(errorData.f721e, errorData.f722f, errorData.f723g, str, str2, errorData.f728l.asBoolean(false), errorData.f727k.asBoolean(true));
        } else {
            m1002a(errorData.f721e, errorData.f722f);
        }
        return true;
    }

    public final void m999a(ApiException apiException) {
        if (apiException != null && apiException.m10826b() != null) {
            m996a(this.f623e.getString(2131232474), StringFormatUtil.formatStrLocaleSafe("[%d] %s", Integer.valueOf(apiException.m10826b().m10832a()), apiException.m10826b().m10834c()), apiException);
        }
    }

    public final void m1001a(IOException iOException) {
        if (iOException != null) {
            m996a(this.f623e.getString(2131232474), StringFormatUtil.formatStrLocaleSafe("%s (%s: %s)", this.f623e.getString(2131232476), iOException.getClass().getSimpleName(), iOException.getMessage()), iOException);
        }
    }

    public final void m1003a(Throwable th) {
        if (th != null) {
            m996a(this.f623e.getString(2131232474), StringFormatUtil.formatStrLocaleSafe("%s (%s: %s)", this.f623e.getString(2131232475), th.getClass().getSimpleName(), th.getMessage()), th);
        }
    }

    public final void m1000a(ErrorData errorData) {
        if (!StringUtil.c(errorData.f724h) && StringUtil.c(this.f619a.a(AuthPrefKeys.f, ""))) {
            this.f619a.edit().a(AuthPrefKeys.f, errorData.f724h).commit();
        }
        m1004a(406, errorData);
    }

    public final void m998a() {
        this.f619a.edit().a(FbandroidPrefKeys.l, System.currentTimeMillis()).commit();
    }

    private void m996a(String str, String str2, Throwable th) {
        if (!(str == null || str2 == null)) {
            m1002a(str, str2);
        }
        this.f622d.a("LOGIN_ERROR", str2, th);
    }

    public final void m1002a(String str, String str2) {
        if (this.f638t != null && this.f638t.mo64c()) {
            new Builder(this.f620b).m14337a((CharSequence) str).m14350c(17301543).m14346b((CharSequence) str2).mo962a(2131230756, null).m14339a(true).m14349b();
        }
    }

    private void m995a(String str, String str2, String str3, String str4, String str5, boolean z, boolean z2) {
        if (this.f638t != null && this.f638t.mo64c()) {
            Builder b = new Builder(this.f620b).m14337a((CharSequence) str).m14350c(17301543).m14346b((CharSequence) str2);
            if (!StringUtil.a(str4)) {
                b.mo963a((CharSequence) str4, new 1(this, str3, z, z2));
            }
            if (!StringUtil.a(str5)) {
                b.mo966b((CharSequence) str5, new 2(this));
            }
            b.m14339a(false).m14349b();
        }
    }

    public static ErrorData m993a(String str) {
        ErrorData errorData = new ErrorData();
        if (!StringUtil.c(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                try {
                    errorData.f721e = jSONObject.getString("error_title");
                    errorData.f722f = jSONObject.getString("error_message");
                } catch (Throwable e) {
                    BLog.b(f618u, "JSON Exception", e);
                }
                try {
                    errorData.f723g = jSONObject.getString("url");
                } catch (Throwable e2) {
                    BLog.b(f618u, "JSON Exception", e2);
                }
                try {
                    errorData.f724h = jSONObject.getString("machine_id");
                } catch (Throwable e22) {
                    BLog.b(f618u, "JSON Exception", e22);
                }
                try {
                    errorData.f717a = jSONObject.getLong("uid");
                } catch (Throwable e222) {
                    BLog.b(f618u, "JSON Exception", e222);
                }
                try {
                    errorData.f719c = jSONObject.getString("auth_token");
                } catch (Throwable e2222) {
                    BLog.b(f618u, "JSON Exception", e2222);
                }
                try {
                    errorData.f725i = jSONObject.getString("conditional_uri");
                } catch (Throwable e22222) {
                    BLog.b(f618u, "JSON Exception", e22222);
                }
                try {
                    errorData.f726j = jSONObject.getString("actual_identifier");
                } catch (Throwable e222222) {
                    BLog.b(f618u, "JSON Exception", e222222);
                }
                try {
                    errorData.f727k = TriState.valueOf(jSONObject.getBoolean("finish_after_loading_url"));
                } catch (Throwable e2222222) {
                    BLog.b(f618u, "JSON Exception", e2222222);
                }
                try {
                    errorData.f728l = TriState.valueOf(jSONObject.getBoolean("start_internal_webview_from_url"));
                } catch (Throwable e22222222) {
                    BLog.b(f618u, "JSON Exception", e22222222);
                }
                try {
                    errorData.f729m = jSONObject.getString("positive_button_string");
                } catch (Throwable e222222222) {
                    BLog.b(f618u, "JSON Exception", e222222222);
                }
                try {
                    errorData.f730n = jSONObject.getString("negative_button_string");
                } catch (Throwable e2222222222) {
                    BLog.b(f618u, "JSON Exception", e2222222222);
                }
                try {
                    errorData.f718b = jSONObject.getInt("error_subcode");
                } catch (Throwable e22222222222) {
                    BLog.b(f618u, "JSON Exception", e22222222222);
                }
                try {
                    errorData.f720d = jSONObject.getString("login_first_factor");
                } catch (Throwable e222222222222) {
                    BLog.b(f618u, "JSON Exception", e222222222222);
                }
            } catch (JSONException e3) {
            }
        }
        return errorData;
    }
}
