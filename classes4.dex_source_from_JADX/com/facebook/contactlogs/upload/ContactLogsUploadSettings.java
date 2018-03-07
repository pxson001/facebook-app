package com.facebook.contactlogs.upload;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.contactlogs.logging.ContactLogsAnalyticsLogger;
import com.facebook.contactlogs.logging.ContactLogsLoggingConstants.EventType;
import com.facebook.contactlogs.prefs.ContactLogsPrefKeys;
import com.facebook.contactlogs.protocol.SetContactLogsUploadSettingMethod.Setting;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: fb4a_profile_share */
public class ContactLogsUploadSettings {
    private static final CallerContext f12095a = CallerContext.a(ContactLogsUploadSettings.class);
    private final FbSharedPreferences f12096b;
    private final DefaultBlueServiceOperationFactory f12097c;
    private final Provider<String> f12098d;
    private final ContactLogsAnalyticsLogger f12099e;
    private final Provider<TriState> f12100f;

    public static ContactLogsUploadSettings m12772b(InjectorLike injectorLike) {
        return new ContactLogsUploadSettings((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), IdBasedProvider.a(injectorLike, 4442), ContactLogsAnalyticsLogger.m12776a(injectorLike), IdBasedProvider.a(injectorLike, 654));
    }

    @Inject
    public ContactLogsUploadSettings(FbSharedPreferences fbSharedPreferences, BlueServiceOperationFactory blueServiceOperationFactory, Provider<String> provider, ContactLogsAnalyticsLogger contactLogsAnalyticsLogger, Provider<TriState> provider2) {
        this.f12096b = fbSharedPreferences;
        this.f12097c = blueServiceOperationFactory;
        this.f12098d = provider;
        this.f12099e = contactLogsAnalyticsLogger;
        this.f12100f = provider2;
    }

    public final ListenableFuture<OperationResult> m12774a(boolean z) {
        if (!((TriState) this.f12100f.get()).asBoolean(false)) {
            return Futures.a(OperationResult.a(ErrorCode.OTHER));
        }
        if (m12775a() == z) {
            return Futures.a(OperationResult.a);
        }
        PrefKey b = m12773b();
        if (b != null) {
            this.f12096b.edit().putBoolean(b, z).commit();
        }
        this.f12099e.f12103a.a(ContactLogsAnalyticsLogger.m12777b(EventType.UPLOAD_SETTING_SET).b("enabled", Boolean.valueOf(z).toString()));
        Bundle bundle = new Bundle();
        bundle.putSerializable("set_contact_logs_upload_setting_param_key", z ? Setting.ON : Setting.OFF);
        return BlueServiceOperationFactoryDetour.a(this.f12097c, "set_contact_logs_upload_setting", bundle, ErrorPropagation.BY_EXCEPTION, f12095a, 100099072).a();
    }

    public final boolean m12775a() {
        PrefKey b = m12773b();
        if (b == null || !this.f12096b.a(b, false)) {
            return false;
        }
        return true;
    }

    @Nullable
    private PrefKey m12773b() {
        PrefKey prefKey;
        String str = (String) this.f12098d.get();
        if (StringUtil.a(str)) {
            prefKey = null;
        } else {
            prefKey = (PrefKey) ContactLogsPrefKeys.c.a(str);
        }
        return prefKey;
    }
}
