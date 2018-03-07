package com.facebook.zero.onboarding.experiments;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.bottomsheet.BottomSheetAdapter;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: custom_icons */
public class ShareExternalUtils {
    public final SecureContextHelper f16201a;
    public final ShareExternalExperimentUtils f16202b;

    public static ShareExternalUtils m20248a(InjectorLike injectorLike) {
        return new ShareExternalUtils((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), ShareExternalExperimentUtils.m20245b(injectorLike));
    }

    @Inject
    public ShareExternalUtils(SecureContextHelper secureContextHelper, ShareExternalExperimentUtils shareExternalExperimentUtils) {
        this.f16201a = secureContextHelper;
        this.f16202b = shareExternalExperimentUtils;
    }

    public final void m20250a(Context context, String str) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
        Adapter bottomSheetAdapter = new BottomSheetAdapter(context);
        m20249a(context, str, bottomSheetAdapter);
        bottomSheetAdapter.f15838c = true;
        bottomSheetAdapter.f15840e = true;
        bottomSheetDialog.m19815a(bottomSheetAdapter);
        bottomSheetDialog.show();
    }

    private void m20249a(final Context context, final String str, BottomSheetAdapter bottomSheetAdapter) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        List queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        String a = this.f16202b.f16195a.a(ExperimentsForAssistedOnboardingAbTestModule.f16194d, "");
        Set hashSet = new HashSet();
        for (Object add : a.split(",")) {
            hashSet.add(add);
        }
        Set set = hashSet;
        for (int i = 0; i < queryIntentActivities.size(); i++) {
            final ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivities.get(i);
            if (resolveInfo.activityInfo == null || set.contains(resolveInfo.activityInfo.packageName)) {
                MenuItemImpl a2 = bottomSheetAdapter.a(resolveInfo.loadLabel(packageManager).toString());
                a2.setIcon(resolveInfo.loadIcon(packageManager));
                a2.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ ShareExternalUtils f16200d;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.SEND");
                        intent.setType("text/plain");
                        PackageItemInfo packageItemInfo = resolveInfo.activityInfo;
                        intent.putExtra("android.intent.extra.TEXT", this.f16200d.f16202b.m20246a(str, packageItemInfo.applicationInfo.packageName));
                        ComponentName componentName = new ComponentName(packageItemInfo.applicationInfo.packageName, packageItemInfo.name);
                        intent.addCategory("android.intent.category.LAUNCHER");
                        intent.setFlags(270532608);
                        intent.setComponent(componentName);
                        ShareExternalExperimentUtils shareExternalExperimentUtils = this.f16200d.f16202b;
                        String str = packageItemInfo.applicationInfo.packageName;
                        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("fb_share_external_package_selected");
                        honeyClientEvent.b("package_name", str);
                        honeyClientEvent.c = "assisted_onboarding";
                        ((AnalyticsLogger) shareExternalExperimentUtils.f16196b.get()).a(honeyClientEvent);
                        this.f16200d.f16201a.b(intent, context);
                        return true;
                    }
                });
            }
        }
    }
}
