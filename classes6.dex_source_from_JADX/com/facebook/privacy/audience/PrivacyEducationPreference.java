package com.facebook.privacy.audience;

import android.content.Context;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.privacy.PrivacyOperationsClient;
import com.facebook.privacy.PrivacyPrefKeys;
import com.facebook.privacy.protocol.FetchAudienceInfoModels.FetchAudienceInfoModel;
import com.facebook.widget.prefs.OrcaListPreference;
import com.google.common.base.Objects;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: fetchPhotosMetadataParams */
public class PrivacyEducationPreference extends OrcaListPreference implements InjectableComponentWithoutContext {
    public Lazy<StickyGuardrailManager> f14998a;
    public FbSharedPreferences f14999b;
    public PrivacyOperationsClient f15000c;
    public AudienceEducatorManager f15001d;
    public ExecutorService f15002e;
    public FbUriIntentHandler f15003f;

    /* compiled from: fetchPhotosMetadataParams */
    public class C10051 implements OnPreferenceChangeListener {
        final /* synthetic */ PrivacyEducationPreference f14996a;

        public C10051(PrivacyEducationPreference privacyEducationPreference) {
            this.f14996a = privacyEducationPreference;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            if (obj.equals(EducationType.FETCH_STICKY_GUARDRAIL.desc)) {
                ((StickyGuardrailManager) this.f14996a.f14998a.get()).c();
            } else if (obj.equals(EducationType.ENABLE_NEWCOMER_AUDIENCE.desc)) {
                this.f14996a.f14999b.edit().putBoolean(PrivacyPrefKeys.j, true).a(PrivacyPrefKeys.k).commit();
            } else if (obj.equals(EducationType.FORCE_AAA_TUX.desc)) {
                this.f14996a.f14999b.edit().putBoolean(PrivacyPrefKeys.h, true).commit();
            } else if (obj.equals(EducationType.FORCE_AAA_ONLY_ME.desc)) {
                this.f14996a.f14999b.edit().putBoolean(PrivacyPrefKeys.i, true).commit();
            } else if (obj.equals(EducationType.FETCH_AUDIENCE_EDUCATION.desc)) {
                r0 = this.f14996a;
                Futures.a(r0.f15000c.m22565b(), new C10062(r0), r0.f15002e);
            } else if (obj.equals(EducationType.REMOVE_DEFAULT_OVERRIDE.desc)) {
                this.f14996a.f15001d.b.edit().a(PrivacyPrefKeys.m).commit();
            } else if (obj.equals(EducationType.LAUNCH_PROFILE_PHOTO_CHECKUP.desc)) {
                r0 = this.f14996a;
                r0.f15003f.a(r0.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.cN, "fb4a_intern_settings", "PROFILE_PHOTO_CHECKUP"));
            }
            return true;
        }
    }

    /* compiled from: fetchPhotosMetadataParams */
    public class C10062 implements FutureCallback<OperationResult> {
        final /* synthetic */ PrivacyEducationPreference f14997a;

        public C10062(PrivacyEducationPreference privacyEducationPreference) {
            this.f14997a = privacyEducationPreference;
        }

        public void onSuccess(@Nullable Object obj) {
            FetchAudienceInfoModel fetchAudienceInfoModel = (FetchAudienceInfoModel) ((OperationResult) obj).k();
            if (fetchAudienceInfoModel != null) {
                this.f14997a.f15001d.b(fetchAudienceInfoModel.a());
            }
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: fetchPhotosMetadataParams */
    public enum EducationType {
        FETCH_STICKY_GUARDRAIL("Refetch Sticky Guardrail Info"),
        ENABLE_NEWCOMER_AUDIENCE("Set NAS to enabled"),
        FORCE_AAA_TUX("Enable AAA TUX"),
        FORCE_AAA_ONLY_ME("Enable AAA Only Me"),
        FETCH_AUDIENCE_EDUCATION("Refetch Audience Education Info"),
        REMOVE_DEFAULT_OVERRIDE("Remove Default Privacy Override"),
        LAUNCH_PROFILE_PHOTO_CHECKUP("Launch profile photo checkup");
        
        public final String desc;

        private EducationType(String str) {
            this.desc = str;
        }

        public final String toString() {
            return this.desc;
        }

        public static EducationType fromString(String str) {
            for (EducationType educationType : values()) {
                if (Objects.equal(educationType.toString(), str)) {
                    return educationType;
                }
            }
            return FETCH_STICKY_GUARDRAIL;
        }
    }

    public static void m22587a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PrivacyEducationPreference) obj).m22586a(IdBasedSingletonScopeProvider.b(injectorLike, 3104), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), PrivacyOperationsClient.m22544a(injectorLike), AudienceEducatorManager.a(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), FbUriIntentHandler.a(injectorLike));
    }

    public PrivacyEducationPreference(Context context) {
        super(context);
        Class cls = PrivacyEducationPreference.class;
        m22587a(this, context);
        setTitle("Privacy Education Settings");
        setSummary("List of device-specific privacy education settings.");
        setDialogTitle("Ignore the radio buttons.");
        CharSequence[] charSequenceArr = new String[EducationType.values().length];
        for (int i = 0; i < EducationType.values().length; i++) {
            charSequenceArr[i] = EducationType.values()[i].toString();
        }
        setEntries(charSequenceArr);
        setEntryValues(charSequenceArr);
        setKey("privacy_education_preference");
        setOnPreferenceChangeListener(new C10051(this));
    }

    @Inject
    private void m22586a(Lazy<StickyGuardrailManager> lazy, FbSharedPreferences fbSharedPreferences, PrivacyOperationsClient privacyOperationsClient, AudienceEducatorManager audienceEducatorManager, ExecutorService executorService, FbUriIntentHandler fbUriIntentHandler) {
        this.f14998a = lazy;
        this.f14999b = fbSharedPreferences;
        this.f15000c = privacyOperationsClient;
        this.f15001d = audienceEducatorManager;
        this.f15002e = executorService;
        this.f15003f = fbUriIntentHandler;
    }
}
