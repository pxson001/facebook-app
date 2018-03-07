package com.facebook.katana.activity.codegenerator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.widget.TextView;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.ClipboardUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.crudolib.urimap.UriMatchPatterns;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.Lazy;
import com.facebook.katana.prefs.FbandroidPrefKeys;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.search.titlebar.GraphSearchTitleBarController;
import com.facebook.tablet.Boolean_IsTabletMethodAutoProvider;
import com.facebook.tablet.IsTablet;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.FacebookProgressCircleView;
import com.google.common.base.Strings;
import java.lang.reflect.UndeclaredThrowableException;
import java.nio.ByteBuffer;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.inject.Inject;
import javax.inject.Provider;

@UriMatchPatterns
/* compiled from: trim_to_nothing_time */
public class CodeGeneratorActivity extends FbFragmentActivity {
    public static long f663A = 15;
    public static final Long f664B = Long.valueOf(16);
    private static long f665C = 0;
    private static final int[] f666D = new int[]{1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
    public Handler f667E = new Handler();
    public String f668F;
    public Long f669G;
    public FacebookProgressCircleView f670H;
    private TextView f671I;
    public TextView f672J;
    public TextView f673K;
    private Fb4aTitleBar f674L;
    @Inject
    @LoggedInUserId
    Provider<String> f675p;
    @Inject
    DefaultAndroidThreadUtil f676q;
    @Inject
    DefaultBlueServiceOperationFactory f677r;
    @Inject
    FbSharedPreferences f678s;
    @Inject
    SecureContextHelper f679t;
    @Inject
    Lazy<GraphSearchTitleBarController> f680u;
    @Inject
    Clock f681v;
    @Inject
    @IsTablet
    Boolean f682w;
    @Inject
    Toaster f683x;
    @Inject
    GatedCodeGeneratorExperimentHelper f684y;
    protected Runnable f685z = new 5(this);

    /* compiled from: trim_to_nothing_time */
    final class C01068 extends OperationResultFutureCallback {
        final /* synthetic */ String f2072a;
        final /* synthetic */ FbSharedPreferences f2073b;

        C01068(String str, FbSharedPreferences fbSharedPreferences) {
            this.f2072a = str;
            this.f2073b = fbSharedPreferences;
        }

        public final void m2159a(Object obj) {
            FetchCodeResult fetchCodeResult = (FetchCodeResult) ((OperationResult) obj).h();
            String str = fetchCodeResult.f2212a;
            long parseLong = Long.parseLong(fetchCodeResult.f2213b);
            this.f2073b.edit().a((PrefKey) FbandroidPrefKeys.e.a(this.f2072a), parseLong).commit();
            if (!Strings.isNullOrEmpty(str)) {
                this.f2073b.edit().a((PrefKey) FbandroidPrefKeys.f.a(this.f2072a), str).commit();
            }
        }

        protected final void mo148a(ServiceException serviceException) {
        }
    }

    private static <T extends Context> void m1036a(Class<T> cls, T t) {
        m1037a((Object) t, (Context) t);
    }

    public static void m1037a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((CodeGeneratorActivity) obj).m1038a(IdBasedProvider.a(fbInjector, 4442), DefaultAndroidThreadUtil.b(fbInjector), DefaultBlueServiceOperationFactory.b(fbInjector), (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), IdBasedLazy.a(fbInjector, 10889), (Clock) SystemClockMethodAutoProvider.a(fbInjector), Boolean_IsTabletMethodAutoProvider.a(fbInjector), Toaster.b(fbInjector), GatedCodeGeneratorExperimentHelper.m1025b(fbInjector));
    }

    private void m1038a(Provider<String> provider, AndroidThreadUtil androidThreadUtil, BlueServiceOperationFactory blueServiceOperationFactory, FbSharedPreferences fbSharedPreferences, SecureContextHelper secureContextHelper, Lazy<GraphSearchTitleBarController> lazy, Clock clock, Boolean bool, Toaster toaster, GatedCodeGeneratorExperimentHelper gatedCodeGeneratorExperimentHelper) {
        this.f675p = provider;
        this.f676q = androidThreadUtil;
        this.f677r = blueServiceOperationFactory;
        this.f678s = fbSharedPreferences;
        this.f679t = secureContextHelper;
        this.f680u = lazy;
        this.f681v = clock;
        this.f682w = bool;
        this.f683x = toaster;
        this.f684y = gatedCodeGeneratorExperimentHelper;
    }

    public final void m1053b(Bundle bundle) {
        super.b(bundle);
        Class cls = CodeGeneratorActivity.class;
        m1037a((Object) this, (Context) this);
        if (!this.f682w.booleanValue()) {
            setRequestedOrientation(1);
        }
        this.f668F = m1051m();
        this.f669G = Long.valueOf(m1050l());
        if (StringUtil.c(this.f668F)) {
            this.f679t.a(new Intent(this, CodeGeneratorAutoProvisionSecretActivity.class), this);
            finish();
            return;
        }
        setContentView(2130903582);
        this.f672J = (TextView) findViewById(2131560331);
        this.f672J.setOnClickListener(new 1(this));
        this.f673K = (TextView) findViewById(2131560333);
        m1049k();
        findViewById(2131560334).setOnClickListener(new 2(this));
        this.f670H = (FacebookProgressCircleView) findViewById(2131560332);
    }

    private void m1049k() {
        this.f674L = (Fb4aTitleBar) findViewById(2131558563);
        this.f674L.a(new 3(this));
        this.f674L.j = new 4(this);
        this.f674L.setSearchButtonVisible(true);
        this.f671I = (TextView) findViewById(2131558927);
        this.f671I.setText(2131236469);
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1711658498);
        HandlerDetour.a(this.f667E, this.f685z);
        this.f670H.setVisibility(4);
        this.f673K.setVisibility(4);
        super.onPause();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1617456633, a);
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 443576743);
        super.onResume();
        this.f668F = m1051m();
        if (StringUtil.c(this.f668F)) {
            this.f679t.a(new Intent(this, CodeGeneratorAutoProvisionSecretActivity.class), this);
            finish();
            Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1103744915, a);
            return;
        }
        if (!this.f684y.m1027b()) {
            m1052n();
        }
        HandlerDetour.a(this.f667E, this.f685z);
        HandlerDetour.a(this.f667E, this.f685z, 1082523955);
        this.f670H.setVisibility(0);
        this.f673K.setVisibility(0);
        LogUtils.c(-1082399508, a);
    }

    protected final void m1054b(String str) {
        this.f672J.setText(str);
    }

    private void m1035a(CharSequence charSequence) {
        ClipboardUtil.a(this, charSequence.toString());
        this.f683x.b(new ToastBuilder(2131236466));
    }

    private long m1050l() {
        Object c = this.f678s.c((PrefKey) FbandroidPrefKeys.e.a((String) this.f675p.get()));
        if (c == null) {
            return 0;
        }
        return c instanceof String ? Long.parseLong((String) c) : ((Long) c).longValue();
    }

    private String m1051m() {
        return this.f678s.a((PrefKey) FbandroidPrefKeys.f.a((String) this.f675p.get()), "");
    }

    public static String m1031a(String str, Long l) {
        byte[] a = m1039a(m1043c(str), ByteBuffer.allocate(8).putLong(l.longValue()).array());
        int i = a[a.length - 1] & 15;
        return StringFormatUtil.formatStrLocaleSafe("%06d", Integer.valueOf(((a[i + 3] & 255) | ((((a[i] & 127) << 24) | ((a[i + 1] & 255) << 16)) | ((a[i + 2] & 255) << 8))) % f666D[6]));
    }

    private static byte[] m1039a(byte[] bArr, byte[] bArr2) {
        try {
            Mac instance = Mac.getInstance("HmacSHA1");
            instance.init(new SecretKeySpec(bArr, "RAW"));
            return instance.doFinal(bArr2);
        } catch (Throwable e) {
            BLog.b("hmac function failed", e.getMessage(), e);
            throw new UndeclaredThrowableException(e);
        }
    }

    private static byte[] m1043c(String str) {
        int i = 0;
        if (CodeGeneratorValidator.m2398a(str)) {
            byte[] bArr = new byte[((str.length() * 5) / 8)];
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (i < str.length()) {
                int i5;
                char charAt = str.charAt(i);
                if ('A' > charAt || charAt > 'Z') {
                    i5 = (charAt - 50) + 26;
                } else {
                    i5 = charAt - 65;
                }
                int i6 = i3 + 5;
                i4 = (i5 & 31) | (i4 << 5);
                if (i6 >= 8) {
                    i3 = i2 + 1;
                    bArr[i2] = (byte) (i4 >> (i6 - 8));
                    int i7 = i3;
                    i3 = i6 - 8;
                    i2 = i7;
                } else {
                    i3 = i6;
                }
                i++;
            }
            return bArr;
        }
        throw new IllegalStateException();
    }

    private void m1052n() {
        Long valueOf = Long.valueOf(this.f681v.a() / 1000);
        String a = m1031a(this.f668F, Long.valueOf(Long.valueOf(valueOf.longValue() + this.f669G.longValue()).longValue() / 30));
        if (f665C == 0 || valueOf.longValue() - 600 > f665C) {
            f665C = valueOf.longValue();
            CheckCodeParams checkCodeParams = new CheckCodeParams((String) this.f675p.get(), a, valueOf.toString());
            Bundle bundle = new Bundle();
            bundle.putParcelable("checkCodeParams", checkCodeParams);
            this.f676q.a(BlueServiceOperationFactoryDetour.a(this.f677r, "legacy_check_code", bundle, -375851917).a(), new 6(this));
        }
    }

    public static void m1034a(FbSharedPreferences fbSharedPreferences, DefaultAndroidThreadUtil defaultAndroidThreadUtil, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, String str, boolean z) {
        if (!StringUtil.c(fbSharedPreferences.a((PrefKey) FbandroidPrefKeys.f.a(str), ""))) {
            return;
        }
        if (z) {
            FetchCodeParams fetchCodeParams = new FetchCodeParams(str, Long.valueOf(System.currentTimeMillis() / 1000).toString(), false);
            Bundle bundle = new Bundle();
            bundle.putParcelable("checkCodeParams", fetchCodeParams);
            defaultAndroidThreadUtil.a(BlueServiceOperationFactoryDetour.a(defaultBlueServiceOperationFactory, "fetch_code", bundle, 1558231546).a(), new 7(str, fbSharedPreferences));
            return;
        }
        m1042c(fbSharedPreferences, defaultAndroidThreadUtil, defaultBlueServiceOperationFactory, str);
    }

    public static void m1042c(FbSharedPreferences fbSharedPreferences, DefaultAndroidThreadUtil defaultAndroidThreadUtil, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, String str) {
        Parcelable legacyFetchCodeParams = new LegacyFetchCodeParams(str, fbSharedPreferences.a(AuthPrefKeys.f, ""), Long.valueOf(System.currentTimeMillis() / 1000).toString());
        Bundle bundle = new Bundle();
        bundle.putParcelable("checkCodeParams", legacyFetchCodeParams);
        defaultAndroidThreadUtil.a(BlueServiceOperationFactoryDetour.a(defaultBlueServiceOperationFactory, "legacy_fetch_code", bundle, -1002839908).a(), new C01068(str, fbSharedPreferences));
    }
}
