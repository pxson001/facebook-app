package com.facebook.bugreporter;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.bugreporter.RageShakeDetector.ActivityListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.tempfile.TempFileManager;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.runtimelinter.UIRuntimeLinter;
import com.facebook.fbui.viewdescriptionbuilder.ViewDescriptionBuilder;
import com.facebook.fbui.viewdescriptionbuilder.ViewDescriptionShareHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.katana.app.module.ComponentName_InternalSettingsActivityMethodAutoProvider;
import com.facebook.placetips.settings.ui.PlaceTipsSettingsRageShakeItem;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: android.media.metadata.DISPLAY_ICON_URI */
public class RageShakeDialogFragment extends FbDialogFragment {
    private static final Class an = RageShakeDialogFragment.class;
    SecureContextHelper am;
    public ComponentName ao;
    public ActivityListener ap;
    public Provider<BugReporter> aq;
    public UIRuntimeLinter ar;
    public ViewDescriptionShareHelper as;
    private ImmutableList<RageShakeActionItem> at;

    /* compiled from: android.media.metadata.DISPLAY_ICON_URI */
    class C10212 implements OnClickListener {
        final /* synthetic */ RageShakeDialogFragment f10659a;

        C10212(RageShakeDialogFragment rageShakeDialogFragment) {
            this.f10659a = rageShakeDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* compiled from: android.media.metadata.DISPLAY_ICON_URI */
    class C10223 implements OnDismissListener {
        final /* synthetic */ RageShakeDialogFragment f10660a;

        C10223(RageShakeDialogFragment rageShakeDialogFragment) {
            this.f10660a = rageShakeDialogFragment;
        }

        public void onDismiss(DialogInterface dialogInterface) {
            ActivityListener activityListener = this.f10660a.ap;
            if (activityListener.b != null) {
                activityListener.b.f10643a.a();
            }
        }
    }

    private static <T extends InjectableComponentWithContext> void m18680a(Class<T> cls, T t) {
        m18681a((Object) t, t.getContext());
    }

    private static void m18681a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((RageShakeDialogFragment) obj).m18679a(UIRuntimeLinter.a(fbInjector), IdBasedSingletonScopeProvider.a(fbInjector, 5011), new ViewDescriptionShareHelper((SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), ViewDescriptionBuilder.b(fbInjector), TempFileManager.a(fbInjector)), ActivityListenerMethodAutoProvider.b(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), ComponentName_InternalSettingsActivityMethodAutoProvider.b(fbInjector), STATICDI_MULTIBIND_PROVIDER$RageShakeActionItem.m18685a(fbInjector));
    }

    @Inject
    private void m18679a(UIRuntimeLinter uIRuntimeLinter, Provider<BugReporter> provider, ViewDescriptionShareHelper viewDescriptionShareHelper, ActivityListener activityListener, SecureContextHelper secureContextHelper, ComponentName componentName, Set<RageShakeActionItem> set) {
        this.ar = uIRuntimeLinter;
        this.aq = provider;
        this.as = viewDescriptionShareHelper;
        this.ap = activityListener;
        this.am = secureContextHelper;
        this.ao = componentName;
        this.at = ImmutableList.copyOf(set);
    }

    public final Dialog m18682c(Bundle bundle) {
        m18680a(RageShakeDialogFragment.class, (InjectableComponentWithContext) this);
        FbAlertDialogBuilder fbAlertDialogBuilder = new FbAlertDialogBuilder(an());
        CharSequence string = mt_().getString("title");
        try {
            PackageManager packageManager = an().getPackageManager();
            CharSequence applicationLabel = packageManager.getApplicationLabel(packageManager.getApplicationInfo(an().getPackageName(), 0));
            if (applicationLabel != null) {
                string = applicationLabel.toString() + ": " + string;
            }
        } catch (Throwable e) {
            BLog.a(an, "", e);
        }
        fbAlertDialogBuilder.a(string);
        List charSequenceArrayList = mt_().getCharSequenceArrayList("items");
        if (!(this.ao == null || charSequenceArrayList.contains(b(2131235822)))) {
            charSequenceArrayList.add(b(2131235822));
        }
        final int size = charSequenceArrayList.size();
        final List arrayList = new ArrayList(this.at.size());
        int size2 = this.at.size();
        for (int i = 0; i < size2; i++) {
            PlaceTipsSettingsRageShakeItem placeTipsSettingsRageShakeItem = (PlaceTipsSettingsRageShakeItem) this.at.get(i);
            getContext();
            if (placeTipsSettingsRageShakeItem.a()) {
                arrayList.add(placeTipsSettingsRageShakeItem);
                charSequenceArrayList.add(placeTipsSettingsRageShakeItem.a(getContext()));
            }
        }
        fbAlertDialogBuilder.a((CharSequence[]) charSequenceArrayList.toArray(new CharSequence[charSequenceArrayList.size()]), new OnClickListener(this) {
            final /* synthetic */ RageShakeDialogFragment f10658c;

            public void onClick(DialogInterface dialogInterface, int i) {
                Context an = this.f10658c.an();
                FragmentManager fragmentManager = this.f10658c.D;
                FragmentTransaction a = fragmentManager.a();
                a.a(this.f10658c);
                a.c();
                fragmentManager.b();
                switch (i) {
                    case 0:
                        ((BugReporter) this.f10658c.aq.get()).m18644a(BugReportFlowStartParams.newBuilder().m18545a(an).m18546a(BugReportSource.RAGE_SHAKE).m18549a());
                        return;
                    case 1:
                        this.f10658c.ar.a(500);
                        return;
                    case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                        this.f10658c.as.m20236a(an);
                        return;
                    case 3:
                        if (this.f10658c.ao != null) {
                            this.f10658c.am.b(new Intent().setComponent(this.f10658c.ao), an);
                            return;
                        }
                        return;
                    default:
                        int i2 = i - size;
                        if (i2 >= 0 && i2 < arrayList.size()) {
                            PlaceTipsSettingsRageShakeItem placeTipsSettingsRageShakeItem = (PlaceTipsSettingsRageShakeItem) arrayList.get(i2);
                            placeTipsSettingsRageShakeItem.c.a(placeTipsSettingsRageShakeItem.d.a(an, FBLinks.da), an);
                            return;
                        }
                        return;
                }
            }
        });
        fbAlertDialogBuilder.b(b(2131230727), new C10212(this));
        AlertDialog a = fbAlertDialogBuilder.a();
        a.setOnDismissListener(new C10223(this));
        return a;
    }
}
