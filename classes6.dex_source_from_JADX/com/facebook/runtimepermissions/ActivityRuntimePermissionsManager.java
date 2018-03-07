package com.facebook.runtimepermissions;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.activitylistener.AbstractFbActivityListener;
import com.facebook.common.i18n.StringLengthHelper;
import com.facebook.content.AppInfo;
import com.facebook.content.AppInfoCore;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.inject.Assisted;
import com.facebook.resources.ui.FbTextView;
import com.facebook.runtimepermissions.RequestPermissionsConfig.RationaleBehavior;
import com.facebook.runtimepermissions.RuntimePermissionsManager.RuntimePermissionsListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import javax.inject.Inject;

/* compiled from: setInitialRedSpaceValue */
public class ActivityRuntimePermissionsManager implements RuntimePermissionsManager {
    private final int f4773b = 0;
    private final int f4774c = 111;
    public RequestPermissionsConfig f4775d;
    public boolean f4776e = true;
    public Activity f4777f;
    public RuntimePermissionsListener f4778g;
    private FbFragmentActivityPermissionsListener f4779h;
    public RuntimePermissionsUtil f4780i;
    private String f4781j;

    /* compiled from: setInitialRedSpaceValue */
    public class C02867 extends AbstractFbActivityListener {
        final /* synthetic */ String[] f4768a;
        final /* synthetic */ String[] f4769b;
        final /* synthetic */ String[] f4770c;
        final /* synthetic */ ActivityRuntimePermissionsManager f4771d;

        public C02867(ActivityRuntimePermissionsManager activityRuntimePermissionsManager, String[] strArr, String[] strArr2, String[] strArr3) {
            this.f4771d = activityRuntimePermissionsManager;
            this.f4768a = strArr;
            this.f4769b = strArr2;
            this.f4770c = strArr3;
        }

        public final void m7542a(Activity activity, int i, int i2, Intent intent) {
            if (i == 111) {
                ((FbFragmentActivity) this.f4771d.f4777f).b(this);
                ActivityRuntimePermissionsManager.m7549c(this.f4771d, this.f4768a, this.f4769b, this.f4770c);
            }
        }
    }

    @Inject
    public ActivityRuntimePermissionsManager(@Assisted Activity activity, AppInfo appInfo, RuntimePermissionsUtil runtimePermissionsUtil) {
        ApplicationInfo b;
        this.f4777f = activity;
        this.f4780i = runtimePermissionsUtil;
        this.f4779h = new FbFragmentActivityPermissionsListener(this);
        PackageManager packageManager = this.f4777f.getApplicationContext().getPackageManager();
        String packageName = this.f4777f.getPackageName();
        if (AppInfoCore.f(packageName)) {
            b = appInfo.b(packageName, 0);
        } else {
            b = appInfo.e(packageName, 0);
        }
        ApplicationInfo applicationInfo = b;
        this.f4781j = (String) (applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo) : "(unknown)");
    }

    public final void mo335a(String[] strArr, RuntimePermissionsListener runtimePermissionsListener) {
        mo334a(strArr, a, runtimePermissionsListener);
    }

    public final void mo334a(String[] strArr, RequestPermissionsConfig requestPermissionsConfig, RuntimePermissionsListener runtimePermissionsListener) {
        this.f4775d = requestPermissionsConfig;
        if (VERSION.SDK_INT < 23) {
            runtimePermissionsListener.mo6a();
            return;
        }
        this.f4778g = runtimePermissionsListener;
        if (this.f4777f instanceof FbFragmentActivity) {
            ((FbFragmentActivity) this.f4777f).B = this.f4779h;
        }
        if (mo336a(strArr)) {
            this.f4778g.mo6a();
            return;
        }
        Object obj = null;
        for (String shouldShowRequestPermissionRationale : strArr) {
            if (this.f4777f.shouldShowRequestPermissionRationale(shouldShowRequestPermissionRationale)) {
                obj = 1;
                break;
            }
        }
        if (obj == null || !this.f4775d.f4784c.shouldShowForDialogStep) {
            m7548b(this, strArr);
        } else {
            m7550c(strArr);
        }
    }

    @Deprecated
    public final void m7560a(String[] strArr, String str, String str2, RuntimePermissionsListener runtimePermissionsListener) {
        RequestPermissionsConfigBuilder requestPermissionsConfigBuilder = new RequestPermissionsConfigBuilder();
        requestPermissionsConfigBuilder.f4786a = str;
        requestPermissionsConfigBuilder = requestPermissionsConfigBuilder;
        requestPermissionsConfigBuilder.f4787b = str2;
        requestPermissionsConfigBuilder = requestPermissionsConfigBuilder;
        requestPermissionsConfigBuilder.f4788c = RationaleBehavior.ALWAYS_SHOW;
        requestPermissionsConfigBuilder = requestPermissionsConfigBuilder;
        requestPermissionsConfigBuilder.f4789d = false;
        mo334a(strArr, requestPermissionsConfigBuilder.m7562e(), runtimePermissionsListener);
    }

    public final boolean mo336a(String[] strArr) {
        return this.f4780i.a(strArr);
    }

    public static void m7548b(ActivityRuntimePermissionsManager activityRuntimePermissionsManager, String[] strArr) {
        activityRuntimePermissionsManager.f4777f.requestPermissions(activityRuntimePermissionsManager.m7555i(strArr), 0);
    }

    private void m7550c(final String[] strArr) {
        LinearLayout linearLayout = (LinearLayout) this.f4777f.getLayoutInflater().inflate(2130906928, (ViewGroup) this.f4777f.getWindow().getDecorView(), false);
        AlertDialog a = new Builder(this.f4777f).b(linearLayout).a(2131235938, new OnClickListener(this) {
            final /* synthetic */ ActivityRuntimePermissionsManager f4754b;

            public void onClick(DialogInterface dialogInterface, int i) {
                boolean z;
                ActivityRuntimePermissionsManager activityRuntimePermissionsManager = this.f4754b;
                if (ActivityRuntimePermissionsManager.m7557k(this.f4754b, strArr).length > 0) {
                    z = true;
                } else {
                    z = false;
                }
                activityRuntimePermissionsManager.f4776e = z;
                ActivityRuntimePermissionsManager.m7548b(this.f4754b, strArr);
            }
        }).b(2131235939, new OnClickListener(this) {
            final /* synthetic */ ActivityRuntimePermissionsManager f4752b;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f4752b.f4778g.mo7a(ActivityRuntimePermissionsManager.m7556j(this.f4752b, strArr), ActivityRuntimePermissionsManager.m7557k(this.f4752b, strArr));
            }
        }).a();
        FbTextView fbTextView = (FbTextView) linearLayout.findViewById(2131567194);
        FbTextView fbTextView2 = (FbTextView) linearLayout.findViewById(2131567195);
        final String[] j = m7556j(this, strArr);
        if (this.f4775d.f4782a != null) {
            fbTextView.setText(this.f4775d.f4782a);
        } else if (m7551d(j) > 1) {
            fbTextView.setText(this.f4777f.getString(2131235909, new Object[]{this.f4781j}));
        } else {
            fbTextView.setText(this.f4777f.getString(RuntimePermissionsMappings.m7565d(j[0]), new Object[]{this.f4781j}));
        }
        if (this.f4775d.f4783b != null) {
            fbTextView2.setText(this.f4775d.f4783b);
        } else if (m7551d(j) > 1) {
            fbTextView2.setText(m7553f(strArr));
        } else {
            fbTextView2.setText(this.f4777f.getString(RuntimePermissionsMappings.m7566e(j[0]), new Object[]{this.f4781j}));
        }
        a.setOnCancelListener(new OnCancelListener(this) {
            final /* synthetic */ ActivityRuntimePermissionsManager f4757c;

            public void onCancel(DialogInterface dialogInterface) {
                this.f4757c.f4778g.mo7a(j, ActivityRuntimePermissionsManager.m7557k(this.f4757c, strArr));
            }
        });
        a.show();
    }

    private void m7547a(final String[] strArr, final String[] strArr2, final String[] strArr3) {
        LinearLayout linearLayout = (LinearLayout) this.f4777f.getLayoutInflater().inflate(2130906929, (ViewGroup) this.f4777f.getWindow().getDecorView(), false);
        AlertDialog a = new Builder(this.f4777f).b(linearLayout).a(2131235941, new OnClickListener(this) {
            final /* synthetic */ ActivityRuntimePermissionsManager f4764d;

            public void onClick(DialogInterface dialogInterface, int i) {
                ActivityRuntimePermissionsManager activityRuntimePermissionsManager = this.f4764d;
                String[] strArr = strArr;
                String[] strArr2 = strArr2;
                String[] strArr3 = strArr3;
                if (activityRuntimePermissionsManager.f4775d.f4785d && (activityRuntimePermissionsManager.f4777f instanceof FbFragmentActivity)) {
                    activityRuntimePermissionsManager.f4780i.a(111, activityRuntimePermissionsManager.f4777f);
                    ((FbFragmentActivity) activityRuntimePermissionsManager.f4777f).a(new C02867(activityRuntimePermissionsManager, strArr, strArr2, strArr3));
                    return;
                }
                activityRuntimePermissionsManager.f4780i.b();
                activityRuntimePermissionsManager.f4778g.mo8b();
            }
        }).b(2131235940, new OnClickListener(this) {
            final /* synthetic */ ActivityRuntimePermissionsManager f4760c;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f4760c.f4778g.mo7a(strArr2, strArr3);
            }
        }).a();
        a.setOnCancelListener(new OnCancelListener(this) {
            final /* synthetic */ ActivityRuntimePermissionsManager f4767c;

            public void onCancel(DialogInterface dialogInterface) {
                this.f4767c.f4778g.mo7a(strArr2, strArr3);
            }
        });
        FbTextView fbTextView = (FbTextView) linearLayout.findViewById(2131567194);
        FbTextView fbTextView2 = (FbTextView) linearLayout.findViewById(2131567195);
        if (this.f4775d.f4782a != null) {
            fbTextView.setText(this.f4775d.f4782a);
        } else if (m7551d(strArr3) > 1) {
            fbTextView.setText(this.f4777f.getString(2131235909, new Object[]{this.f4781j}));
        } else {
            fbTextView.setText(this.f4777f.getString(RuntimePermissionsMappings.m7565d(strArr3[0]), new Object[]{this.f4781j}));
        }
        if (this.f4775d.f4783b != null) {
            fbTextView2.setText(this.f4775d.f4783b);
        } else if (m7551d(strArr3) > 1) {
            fbTextView2.setText(m7553f(strArr3));
        } else {
            fbTextView2.setText(this.f4777f.getString(RuntimePermissionsMappings.m7566e(strArr3[0]), new Object[]{this.f4781j}));
        }
        ((FbTextView) linearLayout.findViewById(2131567196)).setText(this.f4777f.getResources().getString(2131235937, new Object[]{m7552e(strArr3)}));
        a.show();
    }

    private static int m7551d(String[] strArr) {
        HashSet hashSet = new HashSet();
        for (String a : strArr) {
            hashSet.add(RuntimePermissionsMappings.m7563a(a));
        }
        return hashSet.size();
    }

    private String m7552e(String[] strArr) {
        HashSet hashSet = new HashSet();
        for (String a : strArr) {
            hashSet.add(RuntimePermissionsMappings.m7563a(a));
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            stringBuilder.append(this.f4777f.getString(RuntimePermissionsMappings.m7564c((String) it.next())));
            stringBuilder.append(",");
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    private SpannableStringBuilder m7553f(String[] strArr) {
        HashSet hashSet = new HashSet();
        for (String a : strArr) {
            hashSet.add(RuntimePermissionsMappings.m7563a(a));
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Object string = this.f4777f.getString(RuntimePermissionsMappings.m7564c(str), new Object[]{this.f4781j});
            spannableStringBuilder.append(string);
            spannableStringBuilder.setSpan(new StyleSpan(1), spannableStringBuilder.length() - StringLengthHelper.a(string), spannableStringBuilder.length(), 33);
            spannableStringBuilder.append("\n");
            Activity activity = this.f4777f;
            int i = 0;
            Object obj = -1;
            switch (str.hashCode()) {
                case -1639857183:
                    if (str.equals("android.permission-group.CONTACTS")) {
                        obj = 2;
                        break;
                    }
                    break;
                case -1410061184:
                    if (str.equals("android.permission-group.PHONE")) {
                        obj = 5;
                        break;
                    }
                    break;
                case -1250730292:
                    if (str.equals("android.permission-group.CALENDAR")) {
                        obj = null;
                        break;
                    }
                    break;
                case -1140935117:
                    if (str.equals("android.permission-group.CAMERA")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 421761675:
                    if (str.equals("android.permission-group.SENSORS")) {
                        obj = 6;
                        break;
                    }
                    break;
                case 828638019:
                    if (str.equals("android.permission-group.LOCATION")) {
                        obj = 3;
                        break;
                    }
                    break;
                case 852078861:
                    if (str.equals("android.permission-group.STORAGE")) {
                        obj = 8;
                        break;
                    }
                    break;
                case 1581272376:
                    if (str.equals("android.permission-group.MICROPHONE")) {
                        obj = 4;
                        break;
                    }
                    break;
                case 1795181803:
                    if (str.equals("android.permission-group.SMS")) {
                        obj = 7;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    i = 2131235911;
                    break;
                case 1:
                    i = 2131235913;
                    break;
                case 2:
                    i = 2131235915;
                    break;
                case 3:
                    i = 2131235917;
                    break;
                case 4:
                    i = 2131235919;
                    break;
                case 5:
                    i = 2131235921;
                    break;
                case 6:
                    i = 2131235923;
                    break;
                case 7:
                    i = 2131235925;
                    break;
                case 8:
                    i = 2131235927;
                    break;
                default:
                    break;
            }
            spannableStringBuilder.append(activity.getString(i, new Object[]{this.f4781j}));
            spannableStringBuilder.append("\n");
        }
        return spannableStringBuilder;
    }

    public static void m7546a(ActivityRuntimePermissionsManager activityRuntimePermissionsManager, int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            Object obj = null;
            if (iArr.length > 0) {
                for (int i2 : iArr) {
                    if (i2 != 0) {
                        break;
                    }
                }
                obj = 1;
            }
            if (obj != null) {
                activityRuntimePermissionsManager.f4778g.mo6a();
            } else {
                String[] h = activityRuntimePermissionsManager.m7554h(strArr);
                String[] j = m7556j(activityRuntimePermissionsManager, strArr);
                String[] k = m7557k(activityRuntimePermissionsManager, strArr);
                if (activityRuntimePermissionsManager.f4775d.f4784c.shouldShowForSettingsStep && k.length > 0 && activityRuntimePermissionsManager.f4776e) {
                    activityRuntimePermissionsManager.m7547a(h, j, k);
                } else {
                    activityRuntimePermissionsManager.f4776e = true;
                    activityRuntimePermissionsManager.f4778g.mo7a(j, k);
                }
            }
        }
        if (activityRuntimePermissionsManager.f4777f instanceof FbFragmentActivity) {
            ((FbFragmentActivity) activityRuntimePermissionsManager.f4777f).B = null;
        }
    }

    public static void m7549c(ActivityRuntimePermissionsManager activityRuntimePermissionsManager, String[] strArr, String[] strArr2, String[] strArr3) {
        int i = 0;
        String[] i2 = activityRuntimePermissionsManager.m7555i(strArr);
        String[] i3 = activityRuntimePermissionsManager.m7555i(strArr2);
        String[] i4 = activityRuntimePermissionsManager.m7555i(strArr3);
        if ((i2.length + i3.length) + i4.length == 0) {
            activityRuntimePermissionsManager.f4778g.mo6a();
            return;
        }
        String[] strArr4 = new String[(i2.length + i3.length)];
        for (int i5 = 0; i5 < i2.length; i5++) {
            strArr4[i5] = i2[i5];
        }
        while (i < i3.length) {
            strArr4[i2.length + i] = i3[i];
            i++;
        }
        activityRuntimePermissionsManager.f4778g.mo7a(strArr4, i4);
    }

    private String[] m7554h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (this.f4777f.checkCallingOrSelfPermission(str) == 0) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private String[] m7555i(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (this.f4777f.checkCallingOrSelfPermission(str) != 0) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] m7556j(ActivityRuntimePermissionsManager activityRuntimePermissionsManager, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (activityRuntimePermissionsManager.f4777f.checkCallingOrSelfPermission(str) == -1 && activityRuntimePermissionsManager.f4777f.shouldShowRequestPermissionRationale(str)) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] m7557k(ActivityRuntimePermissionsManager activityRuntimePermissionsManager, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (activityRuntimePermissionsManager.f4777f.checkSelfPermission(str) == -1 && !activityRuntimePermissionsManager.f4777f.shouldShowRequestPermissionRationale(str)) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
