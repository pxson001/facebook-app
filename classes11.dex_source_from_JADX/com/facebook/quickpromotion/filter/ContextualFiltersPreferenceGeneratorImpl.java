package com.facebook.quickpromotion.filter;

import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceScreen;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.quickpromotion.debug.QuickPromotionFiltersActivity;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter.Type;
import com.facebook.quickpromotion.prefs.QuickPromotionPrefKeys;
import com.facebook.quickpromotion.prefs.QuickPromotionPrefKeys.FilterState;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: SQUARE_TO_CIRCLE */
public class ContextualFiltersPreferenceGeneratorImpl implements ContextualFiltersPreferenceGenerator {
    private static volatile ContextualFiltersPreferenceGeneratorImpl f11349c;
    private final FbSharedPreferences f11350a;
    private final FilterState[] f11351b = FilterState.values();

    /* compiled from: SQUARE_TO_CIRCLE */
    class OnClickListener implements OnPreferenceClickListener {
        final /* synthetic */ ContextualFiltersPreferenceGeneratorImpl f11346a;
        private QuickPromotionFiltersActivity f11347b;
        private Type f11348c;

        public OnClickListener(ContextualFiltersPreferenceGeneratorImpl contextualFiltersPreferenceGeneratorImpl, QuickPromotionFiltersActivity quickPromotionFiltersActivity, Type type) {
            this.f11346a = contextualFiltersPreferenceGeneratorImpl;
            this.f11347b = quickPromotionFiltersActivity;
            this.f11348c = type;
        }

        public boolean onPreferenceClick(Preference preference) {
            this.f11347b.a(this.f11348c);
            return true;
        }
    }

    public static com.facebook.quickpromotion.filter.ContextualFiltersPreferenceGeneratorImpl m11673a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f11349c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.quickpromotion.filter.ContextualFiltersPreferenceGeneratorImpl.class;
        monitor-enter(r1);
        r0 = f11349c;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m11674b(r0);	 Catch:{ all -> 0x0035 }
        f11349c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11349c;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.quickpromotion.filter.ContextualFiltersPreferenceGeneratorImpl.a(com.facebook.inject.InjectorLike):com.facebook.quickpromotion.filter.ContextualFiltersPreferenceGeneratorImpl");
    }

    private static ContextualFiltersPreferenceGeneratorImpl m11674b(InjectorLike injectorLike) {
        return new ContextualFiltersPreferenceGeneratorImpl((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public ContextualFiltersPreferenceGeneratorImpl(FbSharedPreferences fbSharedPreferences) {
        this.f11350a = fbSharedPreferences;
    }

    public final void m11675a(QuickPromotionFiltersActivity quickPromotionFiltersActivity, PreferenceScreen preferenceScreen) {
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.CI_CONT_SYNC_CONSENT));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.CI_CONSENT));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.DIALTONE_ACTIVE));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.DIALTONE_AVAILABLE));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.UNREAD_MESSAGES));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.OMNISTORE_KEY_JUST_WRITTEN));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.CLOCK_SKEW));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.CONTACT_LOGS_UPLOAD_ENABLED));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.CONTACTS_UPLOAD_ENABLED));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.HAS_MADE_RTC_CALL));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.IS_MISSING_PROFILE_PICTURE));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.MESSENGER_PHOTO_MAGIC_EVER_ENABLED));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.MESSENGER_PHOTO_MAGIC_NUX_ELIGIBLE));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.SMS_TAKEOVER_DELAYED_READ_ONLY_THREAD_VIEW_BANNER_ELIGIBLE));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.SMS_TAKEOVER_FULL_READ_ONLY_THREAD_VIEW_BANNER_ELIGIBLE));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.SMS_TAKEOVER_RECENT_READ_ONLY_THREAD_VIEW_BANNER_ELIGIBLE));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.AGGREGATE_CAP));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.ANDROID_PERMISSIONS_ANY_DISABLED));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.APP_INSTALLED));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.APP_NOT_INSTALLED));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.AVAILABLE_APP_STORAGE_KB));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.MAX_AVAILABLE_APP_STORAGE_KB));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.APP_MAX_VERSION));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.APP_MIN_VERSION));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.PREFETCH_ALL_ASSETS));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.REMAINING_BATTERY_LEVEL));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.DIRECT_INSTALL_ENABLED));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.GOOGLE_ACCOUNT_AVAILABLE));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.GOOGLE_PLAY_AVAILABLE));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.METERED_CONNECTION));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.OTHER_PROFILE_IS_BIRTHDAY));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.LOCALE));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.MIN_MANUAL_NEWSFEED_REFRESHES));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.MESSAGES_SENT_ONE_AFTER_THE_OTHER));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.FACEBOOK_MESSENGER_INSTALLED));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.MOBILE_NETWORK_AVAILABLE));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.NETWORK_CONNECTIVITY));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.OTHER_PROMOTION_EVENT));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.PREINSTALLED_APP));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.OTHER_PROFILE_RTC_PRESENCE));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.SECONDS_SINCE_MESSAGE_RECEIVED));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.SECONDS_SINCE_MESSAGE_SENT));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.SECONDS_SINCE_METERED_CONNECTION_CHANGED_LT));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.TIME_OF_DAY_AFTER));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.TIME_OF_DAY_BEFORE));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.SECONDS_SINCE_LAST_DISMISSAL));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.SECONDS_SINCE_FOREGROUND));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.SECONDS_SINCE_LAST_IMPRESSION));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.UNKNOWN));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.OTHER_PROFILE_COMMUNICATION_COEFFICIENT));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.WIFI_CONNECTED));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.CANNOT_CREATE_PROFILE_VIDEO));
        preferenceScreen.addPreference(m11672a(quickPromotionFiltersActivity, Type.CANNOT_VIEW_CONTEXT_PROFILE_VIDEO));
    }

    private Preference m11672a(QuickPromotionFiltersActivity quickPromotionFiltersActivity, Type type) {
        Preference preference = new Preference(quickPromotionFiltersActivity);
        preference.setTitle(type.name());
        preference.setSummary(this.f11351b[this.f11350a.a(QuickPromotionPrefKeys.a(type), FilterState.DEFAULT.ordinal())].getFilterStateCaption());
        preference.setOnPreferenceClickListener(new OnClickListener(this, quickPromotionFiltersActivity, type));
        return preference;
    }
}
