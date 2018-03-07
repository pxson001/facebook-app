package com.facebook.runtimepermissions;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.inject.FbInjector;
import com.facebook.runtimepermissions.RequestPermissionsConfig.RationaleBehavior;
import com.facebook.runtimepermissions.RuntimePermissionsManager.RuntimePermissionsListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

@Deprecated
/* compiled from: animationOffset */
public class RequestPermissionsActivity extends FbFragmentActivity {
    @Inject
    public RuntimePermissionsUtil f20398p;
    @Inject
    public ActivityRuntimePermissionsManagerProvider f20399q;
    public ActivityRuntimePermissionsManager f20400r;
    public String[] f20401s;

    /* compiled from: animationOffset */
    public class C24051 implements RuntimePermissionsListener {
        final /* synthetic */ RequestPermissionsActivity f20397a;

        public C24051(RequestPermissionsActivity requestPermissionsActivity) {
            this.f20397a = requestPermissionsActivity;
        }

        public final void m19958a() {
            HashMap hashMap = new HashMap();
            RequestPermissionsActivity.m19964b(hashMap, this.f20397a.f20401s, Integer.valueOf(0));
            RequestPermissionsActivity.m19962a(this.f20397a, hashMap);
        }

        public final void m19959a(String[] strArr, String[] strArr2) {
            HashMap hashMap = new HashMap();
            RequestPermissionsActivity.m19964b(hashMap, this.f20397a.f20401s, Integer.valueOf(0));
            RequestPermissionsActivity.m19964b(hashMap, strArr, Integer.valueOf(1));
            RequestPermissionsActivity.m19964b(hashMap, strArr2, Integer.valueOf(2));
            RequestPermissionsActivity.m19962a(this.f20397a, hashMap);
        }

        public final void m19960b() {
            this.f20397a.setResult(0);
            this.f20397a.finish();
        }
    }

    public static void m19963a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        RequestPermissionsActivity requestPermissionsActivity = (RequestPermissionsActivity) obj;
        RuntimePermissionsUtil b = RuntimePermissionsUtil.b(fbInjector);
        ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider = (ActivityRuntimePermissionsManagerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class);
        requestPermissionsActivity.f20398p = b;
        requestPermissionsActivity.f20399q = activityRuntimePermissionsManagerProvider;
    }

    protected final void m19965b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = RequestPermissionsActivity.class;
        m19963a((Object) this, (Context) this);
        this.f20400r = this.f20399q.a(this);
        if (bundle != null) {
            this.f20401s = bundle.getStringArray("key_permissions");
        } else {
            this.f20401s = getIntent().getStringArrayExtra("extra_permissions");
        }
        if (this.f20401s == null || this.f20401s.length <= 0) {
            m19962a(this, new HashMap());
            return;
        }
        String[] strArr = this.f20401s;
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (!this.f20398p.a(str)) {
                arrayList.add(str);
            }
        }
        strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        Intent intent = getIntent();
        RequestPermissionsConfig requestPermissionsConfig = (RequestPermissionsConfig) intent.getParcelableExtra("extra_permissions_request_config");
        if (requestPermissionsConfig == null) {
            RationaleBehavior rationaleBehavior;
            boolean booleanExtra = intent.getBooleanExtra("extra_should_show_rationale", true);
            String stringExtra = intent.getStringExtra("extra_custom_title");
            String stringExtra2 = intent.getStringExtra("extra_custom_subtitle");
            RequestPermissionsConfigBuilder requestPermissionsConfigBuilder = new RequestPermissionsConfigBuilder();
            requestPermissionsConfigBuilder.a = stringExtra;
            RequestPermissionsConfigBuilder requestPermissionsConfigBuilder2 = requestPermissionsConfigBuilder;
            requestPermissionsConfigBuilder2.b = stringExtra2;
            RequestPermissionsConfigBuilder requestPermissionsConfigBuilder3 = requestPermissionsConfigBuilder2;
            if (booleanExtra) {
                rationaleBehavior = RationaleBehavior.ALWAYS_SHOW;
            } else {
                rationaleBehavior = RationaleBehavior.NEVER_SHOW;
            }
            requestPermissionsConfigBuilder3.c = rationaleBehavior;
            requestPermissionsConfig = requestPermissionsConfigBuilder3.e();
        }
        this.f20400r.a(strArr, requestPermissionsConfig, new C24051(this));
    }

    public static void m19964b(Map<String, Integer> map, String[] strArr, Integer num) {
        for (Object put : strArr) {
            map.put(put, num);
        }
    }

    public static void m19962a(RequestPermissionsActivity requestPermissionsActivity, HashMap hashMap) {
        Intent intent = new Intent();
        intent.putExtra("extra_permission_results", hashMap);
        requestPermissionsActivity.setResult(-1, intent);
        requestPermissionsActivity.finish();
    }

    @Deprecated
    public static Intent m19961a(Context context, @Nullable String[] strArr, RequestPermissionsConfig requestPermissionsConfig) {
        Intent intent = new Intent(context, RequestPermissionsActivity.class);
        intent.putExtra("extra_permissions", strArr);
        Intent intent2 = intent;
        intent2.putExtra("extra_permissions_request_config", requestPermissionsConfig);
        return intent2;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArray("key_permissions", this.f20401s);
    }
}
