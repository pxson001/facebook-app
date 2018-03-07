package com.facebook.crudolib.urimap.runtime;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.debug.log.BLog;
import com.facebook.katana.urimap.Fb4aComponentHelperFactory;
import com.facebook.katana.urimap.PaymentSettingsPickerScreenActivityComponentHelper;
import javax.annotation.Nullable;

/* compiled from: pinned_threads_fetch */
public final class UriMapHelper {
    @SuppressLint({"BadMethodUse"})
    public static boolean m6890a(char[] cArr, int i, String str) {
        int length = cArr.length;
        int length2 = str.length();
        if (length <= i) {
            return false;
        }
        int i2 = 0;
        while (i < length && i2 < length2) {
            if (cArr[i] != str.charAt(i2)) {
                return false;
            }
            i++;
            i2++;
        }
        if (length2 <= i2) {
            return true;
        }
        return false;
    }

    public static int[] m6891a(char[] cArr, int i, String str, String str2, String str3, Bundle bundle) {
        int length = cArr.length;
        long j = 0;
        Object obj = str2 != null ? 1 : null;
        int i2 = i;
        while (length > i2) {
            char c = cArr[i2];
            if (c == '/' || c == '?') {
                length = i2;
                break;
            }
            if (obj != null) {
                int digit = Character.digit(c, 10);
                if (digit != -1) {
                    j = (j * 10) + ((long) digit);
                } else {
                    obj = null;
                }
            }
            i2++;
        }
        length = i2;
        if (length == -1) {
            return null;
        }
        int i3;
        String str4 = new String(cArr, i, length - i);
        i2 = -1;
        if (str != null) {
            Boolean bool = null;
            if (str4 != null) {
                if (str4.equalsIgnoreCase("true") || str4.equals("1")) {
                    bool = Boolean.valueOf(true);
                } else if (str4.equalsIgnoreCase("false") || str4.equals("0")) {
                    bool = Boolean.valueOf(false);
                }
            }
            Boolean bool2 = bool;
            if (bool2 != null) {
                bundle.putBoolean(str, bool2.booleanValue());
                i2 = 1;
            }
        }
        if (i2 != -1 || obj == null) {
            i3 = i2;
        } else {
            bundle.putLong(str2, j);
            i3 = 2;
        }
        if (i3 != -1 || str3 == null) {
            i2 = i3;
        } else {
            bundle.putString(str3, str4);
            i2 = 3;
        }
        if (i2 == -1) {
            return null;
        }
        return new int[]{length, i2};
    }

    public static void m6889a(char[] cArr, int i, int i2, String str, Bundle bundle) {
        bundle.putString(str, new String(cArr, i, i2 - i));
    }

    @Nullable
    public static Intent m6887a(Context context, String str, @Nullable String str2, @Nullable Bundle bundle, @Nullable Bundle bundle2, @Nullable Fb4aComponentHelperFactory fb4aComponentHelperFactory) {
        ComponentHelper componentHelper;
        if (fb4aComponentHelperFactory != null) {
            PaymentSettingsPickerScreenActivityComponentHelper paymentSettingsPickerScreenActivityComponentHelper;
            Object obj = -1;
            switch (str.hashCode()) {
                case -1712246474:
                    if (str.equals("com.facebook.composer.lifeevent.type.ComposerLifeEventTypeActivity")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 511037741:
                    if (str.equals("com.facebook.timeline.refresher.ProfileRefresherProfileStepActivity")) {
                        obj = 5;
                        break;
                    }
                    break;
                case 941833561:
                    if (str.equals("com.facebook.heisman.ProfilePictureOverlayCameraActivity")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 1149513933:
                    if (str.equals("com.facebook.payments.paymentmethods.picker.PickerScreenActivity")) {
                        obj = null;
                        break;
                    }
                    break;
                case 2056459468:
                    if (str.equals("com.facebook.heisman.ProfilePictureOverlayPivotActivity")) {
                        obj = 3;
                        break;
                    }
                    break;
                case 2121142962:
                    if (str.equals("com.facebook.platform.PlatformCanonicalProfileIdActivity")) {
                        obj = 4;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    paymentSettingsPickerScreenActivityComponentHelper = fb4aComponentHelperFactory.c;
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    paymentSettingsPickerScreenActivityComponentHelper = fb4aComponentHelperFactory.d;
                    break;
                default:
                    paymentSettingsPickerScreenActivityComponentHelper = null;
                    break;
            }
            componentHelper = paymentSettingsPickerScreenActivityComponentHelper;
        } else {
            componentHelper = null;
        }
        return m6886a(context, str, str2, bundle, bundle2, componentHelper);
    }

    @Nullable
    private static Intent m6886a(Context context, String str, @Nullable String str2, @Nullable Bundle bundle, @Nullable Bundle bundle2, @Nullable ComponentHelper componentHelper) {
        if (componentHelper != null && !componentHelper.a()) {
            return null;
        }
        Intent intent = new Intent();
        intent.setClassName(context, str);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (str2 != null) {
            String stringBuilder;
            if (bundle != null) {
                for (String stringBuilder2 : bundle.keySet()) {
                    str2 = str2.replace("<" + stringBuilder2 + ">", bundle.get(stringBuilder2).toString());
                }
            }
            String str3 = str2;
            if (bundle2 != null) {
                Object obj = !str3.contains("?") ? 1 : null;
                StringBuilder stringBuilder3 = new StringBuilder(str3);
                Object obj2 = obj;
                for (String stringBuilder22 : bundle2.keySet()) {
                    Object obj3 = bundle2.get(stringBuilder22);
                    if (obj2 != null) {
                        stringBuilder3.append('?');
                        obj2 = null;
                    } else {
                        stringBuilder3.append('&');
                    }
                    stringBuilder3.append(stringBuilder22).append('=').append(obj3);
                }
                stringBuilder22 = stringBuilder3.toString();
            } else {
                stringBuilder22 = str3;
            }
            intent.putExtra("key_templated_str", stringBuilder22);
        }
        return componentHelper != null ? componentHelper.a(intent) : intent;
    }

    @Nullable
    public static Intent m6885a(Context context, int i, int i2, @Nullable String str, @Nullable Bundle bundle, @Nullable Bundle bundle2, @Nullable Fb4aComponentHelperFactory fb4aComponentHelperFactory) {
        String str2;
        switch (i) {
            case 1:
                str2 = "com.facebook.katana.activity.ImmersiveActivity";
                break;
            case 2:
                str2 = "com.facebook.katana.activity.react.ImmersiveReactActivity";
                break;
            default:
                str2 = null;
                break;
        }
        String str3 = str2;
        if (str3 == null) {
            BLog.c("UriMapHelper", "ComponentMap.getNameForType(%d) returned null", new Object[]{Integer.valueOf(i)});
            return null;
        }
        Bundle bundle3;
        ComponentHelper a = fb4aComponentHelperFactory != null ? fb4aComponentHelperFactory.a(i2) : null;
        if (bundle == null) {
            bundle3 = new Bundle();
        } else {
            bundle3 = bundle;
        }
        bundle3.putInt("target_fragment", i2);
        return m6886a(context, str3, str, bundle3, bundle2, a);
    }

    public static Bundle m6888a(@Nullable Bundle bundle, String str, String str2) {
        int i = -1;
        switch (str.hashCode()) {
            case -1483898950:
                if (str.equals("__tn__")) {
                    i = 2;
                    break;
                }
                break;
            case -983972142:
                if (str.equals("pn_ref")) {
                    i = 1;
                    break;
                }
                break;
            case 2931858:
                if (str.equals("_ft_")) {
                    i = 3;
                    break;
                }
                break;
            case 3151469:
                if (str.equals("fref")) {
                    i = 0;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
                if (bundle == null) {
                    bundle = new Bundle(2);
                }
                bundle.putString(str, str2);
                return bundle;
            default:
                return null;
        }
    }
}
