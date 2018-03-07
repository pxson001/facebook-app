package com.facebook.crudo.uri.urigenerated;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.crudolib.urimap.runtime.UriMapHelper;
import com.facebook.katana.urimap.Fb4aComponentHelperFactory;

/* compiled from: fb4a_auto_updates_enabled */
public final class CrudoUriMap {
    private static Intent m8434a(Context context, char[] cArr, int i, int i2, Bundle bundle, Fb4aComponentHelperFactory fb4aComponentHelperFactory) {
        Bundle bundle2;
        if (bundle == null) {
            bundle2 = new Bundle(2);
        } else {
            bundle2 = bundle;
        }
        int[] a = UriMapHelper.a(cArr, i2, null, null, "com.facebook.katana.profile.id", bundle2);
        if (a == null) {
            return null;
        }
        int i3 = a[0];
        int i4 = a[1];
        if (i4 <= 0 || i4 > 3) {
            throw new IllegalStateException("Unexpected templateType: " + i4);
        }
        UriMapHelper.a(cArr, i2, i3, "com.facebook.katana.profile.id", bundle2);
        if (i <= i3) {
            return null;
        }
        i4 = i3 + 1;
        if (cArr[i3] != '?') {
            return null;
        }
        int i5 = i - i4;
        String str = new String(cArr, i4, i5);
        Bundle bundle3 = null;
        i3 = 0;
        Bundle bundle4 = bundle2;
        int i6 = 0;
        while (i3 < i5) {
            i4 = str.indexOf(61, i3);
            if (i4 >= 0) {
                String substring;
                String substring2 = str.substring(i3, i4);
                i3 = str.indexOf(38, i4);
                if (i3 > 0) {
                    substring = str.substring(i4 + 1, i3);
                    i3++;
                } else {
                    substring = str.substring(i4 + 1);
                    i3 = str.length();
                }
                Object obj = -1;
                switch (substring2.hashCode()) {
                    case 1223909392:
                        if (substring2.equals("profile_type")) {
                            obj = null;
                            break;
                        }
                        break;
                }
                switch (obj) {
                    case null:
                        int i7 = i6 | 1;
                        if (bundle4 == null) {
                            bundle4 = new Bundle(2);
                        }
                        bundle4.putString("com.facebook.katana.profile.type", substring);
                        i6 = i7;
                        break;
                    default:
                        bundle3 = UriMapHelper.a(bundle3, substring2, substring);
                        if (bundle3 != null) {
                            break;
                        }
                        return null;
                }
            }
            return null;
        }
        switch (i6) {
            case 1:
                return UriMapHelper.a(context, "com.facebook.platform.PlatformCanonicalProfileIdActivity", null, bundle4, bundle3, fb4aComponentHelperFactory);
            default:
                return null;
        }
    }

    private static Intent m8436b(Context context, char[] cArr, int i, int i2, Bundle bundle, Fb4aComponentHelperFactory fb4aComponentHelperFactory) {
        if (i2 <= i) {
            return UriMapHelper.a(context, 1, 8, null, bundle, null, fb4aComponentHelperFactory);
        }
        if (i2 <= i) {
            return null;
        }
        int i3 = i + 1;
        if (cArr[i] != '?') {
            return null;
        }
        int i4 = i2 - i3;
        String str = new String(cArr, i3, i4);
        Bundle bundle2 = null;
        int i5 = 0;
        int i6 = 0;
        Bundle bundle3 = bundle;
        while (i5 < i4) {
            i3 = str.indexOf(61, i5);
            if (i3 >= 0) {
                String substring;
                String substring2 = str.substring(i5, i3);
                i5 = str.indexOf(38, i3);
                if (i5 > 0) {
                    substring = str.substring(i3 + 1, i5);
                    i5++;
                } else {
                    substring = str.substring(i3 + 1);
                    i5 = str.length();
                }
                Object obj = -1;
                switch (substring2.hashCode()) {
                    case 3151469:
                        if (substring2.equals("fref")) {
                            obj = null;
                            break;
                        }
                        break;
                }
                switch (obj) {
                    case null:
                        int i7 = i6 | 1;
                        if (bundle3 == null) {
                            bundle3 = new Bundle(2);
                        }
                        bundle3.putString("timeline_friend_request_ref", substring);
                        i6 = i7;
                        break;
                    default:
                        bundle2 = UriMapHelper.a(bundle2, substring2, substring);
                        if (bundle2 != null) {
                            break;
                        }
                        return null;
                }
            }
            return null;
        }
        switch (i6) {
            case 1:
                return UriMapHelper.a(context, 1, 8, null, bundle3, bundle2, fb4aComponentHelperFactory);
            default:
                return null;
        }
    }

    private static Intent m8437c(Context context, char[] cArr, int i, int i2, Bundle bundle, Fb4aComponentHelperFactory fb4aComponentHelperFactory) {
        Bundle bundle2;
        if (bundle == null) {
            bundle2 = new Bundle(2);
        } else {
            bundle2 = bundle;
        }
        int[] a = UriMapHelper.a(cArr, i2, null, "com.facebook.katana.profile.id", "com.facebook.katana.profile.id", bundle2);
        if (a == null) {
            return null;
        }
        int i3 = a[0];
        int i4 = a[1];
        if (i4 <= 0 || i4 > 3) {
            throw new IllegalStateException("Unexpected templateType: " + i4);
        }
        if (i4 == 2) {
            Intent b = m8436b(context, cArr, i3, i, bundle2, fb4aComponentHelperFactory);
            if (b != null) {
                return b;
            }
        }
        UriMapHelper.a(cArr, i2, i3, "com.facebook.katana.profile.id", bundle2);
        if (i <= i3) {
            return null;
        }
        i4 = i3 + 1;
        if (cArr[i3] != '?') {
            return null;
        }
        int i5 = i - i4;
        String str = new String(cArr, i4, i5);
        Bundle bundle3 = null;
        int i6 = 0;
        Bundle bundle4 = bundle2;
        int i7 = 0;
        while (i6 < i5) {
            i4 = str.indexOf(61, i6);
            if (i4 >= 0) {
                String substring;
                String substring2 = str.substring(i6, i4);
                i6 = str.indexOf(38, i4);
                if (i6 > 0) {
                    substring = str.substring(i4 + 1, i6);
                    i6++;
                } else {
                    substring = str.substring(i4 + 1);
                    i6 = str.length();
                }
                Object obj = -1;
                switch (substring2.hashCode()) {
                    case 1223909392:
                        if (substring2.equals("profile_type")) {
                            obj = null;
                            break;
                        }
                        break;
                }
                switch (obj) {
                    case null:
                        int i8 = i7 | 1;
                        if (bundle4 == null) {
                            bundle4 = new Bundle(2);
                        }
                        bundle4.putString("com.facebook.katana.profile.type", substring);
                        i7 = i8;
                        break;
                    default:
                        bundle3 = UriMapHelper.a(bundle3, substring2, substring);
                        if (bundle3 != null) {
                            break;
                        }
                        return null;
                }
            }
            return null;
        }
        switch (i7) {
            case 1:
                return UriMapHelper.a(context, "com.facebook.platform.PlatformCanonicalProfileIdActivity", null, bundle4, bundle3, fb4aComponentHelperFactory);
            default:
                return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.Intent m8438d(android.content.Context r10, char[] r11, int r12, int r13, android.os.Bundle r14, com.facebook.katana.urimap.Fb4aComponentHelperFactory r15) {
        /*
        r6 = r13 - r12;
        r7 = new java.lang.String;
        r7.<init>(r11, r12, r6);
        r5 = 0;
        r0 = 0;
        r1 = 0;
        r3 = r0;
        r4 = r14;
    L_0x000c:
        if (r1 >= r6) goto L_0x0143;
    L_0x000e:
        r0 = 61;
        r0 = r7.indexOf(r0, r1);
        if (r0 >= 0) goto L_0x0018;
    L_0x0016:
        r0 = 0;
    L_0x0017:
        return r0;
    L_0x0018:
        r8 = r7.substring(r1, r0);
        r1 = 38;
        r1 = r7.indexOf(r1, r0);
        if (r1 <= 0) goto L_0x003f;
    L_0x0024:
        r0 = r0 + 1;
        r0 = r7.substring(r0, r1);
        r1 = r1 + 1;
    L_0x002c:
        r2 = -1;
        r9 = r8.hashCode();
        switch(r9) {
            case -1644972755: goto L_0x0086;
            case -799136893: goto L_0x007c;
            case 3355: goto L_0x0068;
            case 2928014: goto L_0x004a;
            case 1223909392: goto L_0x0054;
            case 1256780035: goto L_0x0072;
            case 1537780732: goto L_0x005e;
            default: goto L_0x0034;
        };
    L_0x0034:
        switch(r2) {
            case 0: goto L_0x0090;
            case 1: goto L_0x00a2;
            case 2: goto L_0x00c0;
            case 3: goto L_0x00d2;
            case 4: goto L_0x00e4;
            case 5: goto L_0x011f;
            case 6: goto L_0x0131;
            default: goto L_0x0037;
        };
    L_0x0037:
        r5 = com.facebook.crudolib.urimap.runtime.UriMapHelper.a(r5, r8, r0);
        if (r5 != 0) goto L_0x000c;
    L_0x003d:
        r0 = 0;
        goto L_0x0017;
    L_0x003f:
        r0 = r0 + 1;
        r0 = r7.substring(r0);
        r1 = r7.length();
        goto L_0x002c;
    L_0x004a:
        r9 = "_bt_";
        r9 = r8.equals(r9);
        if (r9 == 0) goto L_0x0034;
    L_0x0052:
        r2 = 0;
        goto L_0x0034;
    L_0x0054:
        r9 = "profile_type";
        r9 = r8.equals(r9);
        if (r9 == 0) goto L_0x0034;
    L_0x005c:
        r2 = 1;
        goto L_0x0034;
    L_0x005e:
        r9 = "category_id";
        r9 = r8.equals(r9);
        if (r9 == 0) goto L_0x0034;
    L_0x0066:
        r2 = 2;
        goto L_0x0034;
    L_0x0068:
        r9 = "id";
        r9 = r8.equals(r9);
        if (r9 == 0) goto L_0x0034;
    L_0x0070:
        r2 = 3;
        goto L_0x0034;
    L_0x0072:
        r9 = "intro_card";
        r9 = r8.equals(r9);
        if (r9 == 0) goto L_0x0034;
    L_0x007a:
        r2 = 4;
        goto L_0x0034;
    L_0x007c:
        r9 = "entry_point";
        r9 = r8.equals(r9);
        if (r9 == 0) goto L_0x0034;
    L_0x0084:
        r2 = 5;
        goto L_0x0034;
    L_0x0086:
        r9 = "frame_id";
        r9 = r8.equals(r9);
        if (r9 == 0) goto L_0x0034;
    L_0x008e:
        r2 = 6;
        goto L_0x0034;
    L_0x0090:
        r2 = r3 | 256;
        if (r4 != 0) goto L_0x009a;
    L_0x0094:
        r4 = new android.os.Bundle;
        r3 = 2;
        r4.<init>(r3);
    L_0x009a:
        r3 = "_bt_";
        r4.putString(r3, r0);
        r3 = r2;
        goto L_0x000c;
    L_0x00a2:
        r2 = -1;
        r8 = r0.hashCode();
        switch(r8) {
            case -991716523: goto L_0x00b1;
            default: goto L_0x00aa;
        };
    L_0x00aa:
        r0 = r2;
    L_0x00ab:
        switch(r0) {
            case 0: goto L_0x00bb;
            default: goto L_0x00ae;
        };
    L_0x00ae:
        r0 = 0;
        goto L_0x0017;
    L_0x00b1:
        r8 = "person";
        r0 = r0.equals(r8);
        if (r0 == 0) goto L_0x00aa;
    L_0x00b9:
        r0 = 0;
        goto L_0x00ab;
    L_0x00bb:
        r0 = r3 | 4;
        r3 = r0;
        goto L_0x000c;
    L_0x00c0:
        r2 = r3 | 128;
        if (r4 != 0) goto L_0x00ca;
    L_0x00c4:
        r4 = new android.os.Bundle;
        r3 = 2;
        r4.<init>(r3);
    L_0x00ca:
        r3 = "heisman_category_id";
        r4.putString(r3, r0);
        r3 = r2;
        goto L_0x000c;
    L_0x00d2:
        r2 = r3 | 1;
        if (r4 != 0) goto L_0x00dc;
    L_0x00d6:
        r4 = new android.os.Bundle;
        r3 = 2;
        r4.<init>(r3);
    L_0x00dc:
        r3 = "profileId";
        r4.putString(r3, r0);
        r3 = r2;
        goto L_0x000c;
    L_0x00e4:
        r2 = -1;
        r8 = r0.hashCode();
        switch(r8) {
            case -1340825219: goto L_0x010b;
            case 1602356563: goto L_0x0101;
            default: goto L_0x00ec;
        };
    L_0x00ec:
        switch(r2) {
            case 0: goto L_0x0115;
            case 1: goto L_0x011a;
            default: goto L_0x00ef;
        };
    L_0x00ef:
        r2 = r3 | 16;
        if (r4 != 0) goto L_0x00f9;
    L_0x00f3:
        r4 = new android.os.Bundle;
        r3 = 2;
        r4.<init>(r3);
    L_0x00f9:
        r3 = "intro_card";
        r4.putString(r3, r0);
        r3 = r2;
        goto L_0x000c;
    L_0x0101:
        r8 = "edit_bio";
        r8 = r0.equals(r8);
        if (r8 == 0) goto L_0x00ec;
    L_0x0109:
        r2 = 0;
        goto L_0x00ec;
    L_0x010b:
        r8 = "edit_featured_photos";
        r8 = r0.equals(r8);
        if (r8 == 0) goto L_0x00ec;
    L_0x0113:
        r2 = 1;
        goto L_0x00ec;
    L_0x0115:
        r0 = r3 | 8;
        r3 = r0;
        goto L_0x000c;
    L_0x011a:
        r0 = r3 | 2;
        r3 = r0;
        goto L_0x000c;
    L_0x011f:
        r2 = r3 | 32;
        if (r4 != 0) goto L_0x0129;
    L_0x0123:
        r4 = new android.os.Bundle;
        r3 = 2;
        r4.<init>(r3);
    L_0x0129:
        r3 = "entry_point";
        r4.putString(r3, r0);
        r3 = r2;
        goto L_0x000c;
    L_0x0131:
        r2 = r3 | 64;
        if (r4 != 0) goto L_0x013b;
    L_0x0135:
        r4 = new android.os.Bundle;
        r3 = 2;
        r4.<init>(r3);
    L_0x013b:
        r3 = "frame_id";
        r4.putString(r3, r0);
        r3 = r2;
        goto L_0x000c;
    L_0x0143:
        switch(r3) {
            case 7: goto L_0x0160;
            case 13: goto L_0x0176;
            case 21: goto L_0x0181;
            case 96: goto L_0x0155;
            case 160: goto L_0x016b;
            case 256: goto L_0x0149;
            default: goto L_0x0146;
        };
    L_0x0146:
        r0 = 0;
        goto L_0x0017;
    L_0x0149:
        r1 = 1;
        r2 = 8;
        r3 = 0;
        r0 = r10;
        r6 = r15;
        r0 = com.facebook.crudolib.urimap.runtime.UriMapHelper.a(r0, r1, r2, r3, r4, r5, r6);
        goto L_0x0017;
    L_0x0155:
        r2 = "com.facebook.heisman.ProfilePictureOverlayCameraActivity";
        r3 = 0;
        r1 = r10;
        r6 = r15;
        r0 = com.facebook.crudolib.urimap.runtime.UriMapHelper.a(r1, r2, r3, r4, r5, r6);
        goto L_0x0017;
    L_0x0160:
        r2 = "com.facebook.timeline.header.favphotos.edit.TimelineEditFavPhotosActivity";
        r3 = 0;
        r1 = r10;
        r6 = r15;
        r0 = com.facebook.crudolib.urimap.runtime.UriMapHelper.a(r1, r2, r3, r4, r5, r6);
        goto L_0x0017;
    L_0x016b:
        r2 = "com.facebook.heisman.ProfilePictureOverlayPivotActivity";
        r3 = 0;
        r1 = r10;
        r6 = r15;
        r0 = com.facebook.crudolib.urimap.runtime.UriMapHelper.a(r1, r2, r3, r4, r5, r6);
        goto L_0x0017;
    L_0x0176:
        r2 = "com.facebook.timeline.header.bio.edit.TimelineBioEditActivity";
        r3 = 0;
        r1 = r10;
        r6 = r15;
        r0 = com.facebook.crudolib.urimap.runtime.UriMapHelper.a(r1, r2, r3, r4, r5, r6);
        goto L_0x0017;
    L_0x0181:
        r1 = 1;
        r2 = 8;
        r3 = 0;
        r0 = r10;
        r6 = r15;
        r0 = com.facebook.crudolib.urimap.runtime.UriMapHelper.a(r0, r1, r2, r3, r4, r5, r6);
        goto L_0x0017;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.crudo.uri.urigenerated.CrudoUriMap.d(android.content.Context, char[], int, int, android.os.Bundle, com.facebook.katana.urimap.Fb4aComponentHelperFactory):android.content.Intent");
    }

    private static Intent m8439e(Context context, char[] cArr, int i, int i2, Bundle bundle, Fb4aComponentHelperFactory fb4aComponentHelperFactory) {
        int i3 = i2 - i;
        String str = new String(cArr, i, i3);
        Bundle bundle2 = null;
        int i4 = 0;
        int i5 = 0;
        Bundle bundle3 = bundle;
        while (i4 < i3) {
            int indexOf = str.indexOf(61, i4);
            if (indexOf >= 0) {
                String substring;
                String substring2 = str.substring(i4, indexOf);
                i4 = str.indexOf(38, indexOf);
                if (i4 > 0) {
                    substring = str.substring(indexOf + 1, i4);
                    i4++;
                } else {
                    substring = str.substring(indexOf + 1);
                    i4 = str.length();
                }
                Object obj = -1;
                switch (substring2.hashCode()) {
                    case 95018246:
                        if (substring2.equals("cuids")) {
                            obj = null;
                            break;
                        }
                        break;
                }
                switch (obj) {
                    case null:
                        int i6 = i5 | 1;
                        if (bundle3 == null) {
                            bundle3 = new Bundle(2);
                        }
                        bundle3.putString("cuids", substring);
                        i5 = i6;
                        break;
                    default:
                        bundle2 = UriMapHelper.a(bundle2, substring2, substring);
                        if (bundle2 != null) {
                            break;
                        }
                        return null;
                }
            }
            return null;
        }
        switch (i5) {
            case 1:
                return UriMapHelper.a(context, "com.facebook.account.recovery.AccountRecoveryActivity", null, bundle3, bundle2, fb4aComponentHelperFactory);
            default:
                return null;
        }
    }

    private static Intent m8440f(Context context, char[] cArr, int i, int i2, Bundle bundle, Fb4aComponentHelperFactory fb4aComponentHelperFactory) {
        Bundle bundle2;
        if (bundle == null) {
            bundle2 = new Bundle(2);
        } else {
            bundle2 = bundle;
        }
        int[] a = UriMapHelper.a(cArr, i2, null, null, "page_id", bundle2);
        if (a == null) {
            return null;
        }
        int i3 = a[0];
        int i4 = a[1];
        if (i4 <= 0 || i4 > 3) {
            throw new IllegalStateException("Unexpected templateType: " + i4);
        }
        UriMapHelper.a(cArr, i2, i3, "page_id", bundle2);
        if (i > i3) {
            return null;
        }
        return UriMapHelper.a(context, "com.facebook.gametime.ui.GametimeActivity", null, bundle2, null, fb4aComponentHelperFactory);
    }

    private static Intent m8441g(Context context, char[] cArr, int i, int i2, Bundle bundle, Fb4aComponentHelperFactory fb4aComponentHelperFactory) {
        int i3 = i2 - i;
        String str = new String(cArr, i, i3);
        Bundle bundle2 = null;
        int i4 = 0;
        int i5 = 0;
        Bundle bundle3 = bundle;
        while (i4 < i3) {
            int indexOf = str.indexOf(61, i4);
            if (indexOf >= 0) {
                String substring;
                String substring2 = str.substring(i4, indexOf);
                i4 = str.indexOf(38, indexOf);
                if (i4 > 0) {
                    substring = str.substring(indexOf + 1, i4);
                    i4++;
                } else {
                    substring = str.substring(indexOf + 1);
                    i4 = str.length();
                }
                Object obj = -1;
                switch (substring2.hashCode()) {
                    case 2928014:
                        if (substring2.equals("_bt_")) {
                            obj = null;
                            break;
                        }
                        break;
                }
                switch (obj) {
                    case null:
                        int i6 = i5 | 1;
                        if (bundle3 == null) {
                            bundle3 = new Bundle(2);
                        }
                        bundle3.putString("unused", substring);
                        i5 = i6;
                        break;
                    default:
                        bundle2 = UriMapHelper.a(bundle2, substring2, substring);
                        if (bundle2 != null) {
                            break;
                        }
                        return null;
                }
            }
            return null;
        }
        switch (i5) {
            case 1:
                return UriMapHelper.a(context, "com.facebook.work.invitecoworker.InviteCoworkerActivity", null, bundle3, bundle2, fb4aComponentHelperFactory);
            default:
                return null;
        }
    }

    private static Intent m8442h(Context context, char[] cArr, int i, int i2, Bundle bundle, Fb4aComponentHelperFactory fb4aComponentHelperFactory) {
        int i3 = i2 - i;
        String str = new String(cArr, i, i3);
        Bundle bundle2 = null;
        int i4 = 0;
        int i5 = 0;
        Bundle bundle3 = bundle;
        while (i4 < i3) {
            int indexOf = str.indexOf(61, i4);
            if (indexOf >= 0) {
                String substring;
                String substring2 = str.substring(i4, indexOf);
                i4 = str.indexOf(38, indexOf);
                if (i4 > 0) {
                    substring = str.substring(indexOf + 1, i4);
                    i4++;
                } else {
                    substring = str.substring(indexOf + 1);
                    i4 = str.length();
                }
                Object obj = -1;
                switch (substring2.hashCode()) {
                    case -896505829:
                        if (substring2.equals("source")) {
                            obj = 1;
                            break;
                        }
                        break;
                    case 2928014:
                        if (substring2.equals("_bt_")) {
                            obj = null;
                            break;
                        }
                        break;
                }
                int i6;
                switch (obj) {
                    case null:
                        i6 = i5 | 1;
                        if (bundle3 == null) {
                            bundle3 = new Bundle(2);
                        }
                        bundle3.putString("unused2", substring);
                        i5 = i6;
                        break;
                    case 1:
                        i6 = i5 | 2;
                        if (bundle3 == null) {
                            bundle3 = new Bundle(2);
                        }
                        bundle3.putString("unused", substring);
                        i5 = i6;
                        break;
                    default:
                        bundle2 = UriMapHelper.a(bundle2, substring2, substring);
                        if (bundle2 != null) {
                            break;
                        }
                        return null;
                }
            }
            return null;
        }
        switch (i5) {
            case 3:
                return UriMapHelper.a(context, 1, 253, null, bundle3, bundle2, fb4aComponentHelperFactory);
            default:
                return null;
        }
    }

    private static Intent m8443i(Context context, char[] cArr, int i, int i2, Bundle bundle, Fb4aComponentHelperFactory fb4aComponentHelperFactory) {
        int i3 = i2 - i;
        String str = new String(cArr, i, i3);
        Bundle bundle2 = null;
        int i4 = 0;
        int i5 = 0;
        Bundle bundle3 = bundle;
        while (i4 < i3) {
            int indexOf = str.indexOf(61, i4);
            if (indexOf >= 0) {
                String substring;
                String substring2 = str.substring(i4, indexOf);
                i4 = str.indexOf(38, indexOf);
                if (i4 > 0) {
                    substring = str.substring(indexOf + 1, i4);
                    i4++;
                } else {
                    substring = str.substring(indexOf + 1);
                    i4 = str.length();
                }
                Object obj = -1;
                switch (substring2.hashCode()) {
                    case 92655287:
                        if (substring2.equals("ad_id")) {
                            obj = null;
                            break;
                        }
                        break;
                    case 423175038:
                        if (substring2.equals("lead_gen_data_id")) {
                            obj = 1;
                            break;
                        }
                        break;
                }
                int i6;
                switch (obj) {
                    case null:
                        i6 = i5 | 2;
                        if (bundle3 == null) {
                            bundle3 = new Bundle(2);
                        }
                        bundle3.putString("ad_id", substring);
                        i5 = i6;
                        break;
                    case 1:
                        i6 = i5 | 1;
                        if (bundle3 == null) {
                            bundle3 = new Bundle(2);
                        }
                        bundle3.putString("lead_gen_data_id", substring);
                        i5 = i6;
                        break;
                    default:
                        bundle2 = UriMapHelper.a(bundle2, substring2, substring);
                        if (bundle2 != null) {
                            break;
                        }
                        return null;
                }
            }
            return null;
        }
        switch (i5) {
            case 1:
                return UriMapHelper.a(context, "com.facebook.leadgen.deeplink.LeadGenActivity", null, bundle3, bundle2, fb4aComponentHelperFactory);
            case 3:
                return UriMapHelper.a(context, "com.facebook.leadgen.deeplink.LeadGenActivity", null, bundle3, bundle2, fb4aComponentHelperFactory);
            default:
                return null;
        }
    }

    public static Intent m8435a(Context context, char[] cArr, Fb4aComponentHelperFactory fb4aComponentHelperFactory) {
        int i = 9;
        int length = cArr.length;
        if (length <= 0) {
            return null;
        }
        switch (cArr[0]) {
            case 'a':
                if (1 >= length) {
                    return null;
                }
                switch (cArr[1]) {
                    case 'b':
                        if (!UriMapHelper.a(cArr, 2, "out") || 5 < length) {
                            return null;
                        }
                        return UriMapHelper.a(context, "com.facebook.about.AboutActivity", null, null, null, fb4aComponentHelperFactory);
                    case 'c':
                        if (!UriMapHelper.a(cArr, 2, "count/recovery")) {
                            return null;
                        }
                        if (16 < length) {
                            i = 17;
                            switch (cArr[16]) {
                                case '/':
                                    if (17 < length && cArr[17] == '?') {
                                        i = 18;
                                        break;
                                    }
                                    return null;
                                    break;
                                case '?':
                                    break;
                                default:
                                    return null;
                            }
                            return m8439e(context, cArr, i, length, null, fb4aComponentHelperFactory);
                        }
                        return UriMapHelper.a(context, "com.facebook.account.recovery.AccountRecoveryActivity", null, null, null, fb4aComponentHelperFactory);
                    default:
                        return null;
                }
            case 'b':
                if (1 >= length) {
                    return null;
                }
                switch (cArr[1]) {
                    case 'a':
                        if (!UriMapHelper.a(cArr, 2, "ckground_location/settings") || 28 < length) {
                            return null;
                        }
                        return UriMapHelper.a(context, "com.facebook.backgroundlocation.settings.BackgroundLocationSettingsActivity", null, null, null, fb4aComponentHelperFactory);
                    case 'i':
                        if (!UriMapHelper.a(cArr, 2, "rthday_card") || 13 < length) {
                            return null;
                        }
                        return UriMapHelper.a(context, 1, 135, null, null, null, fb4aComponentHelperFactory);
                    default:
                        return null;
                }
            case 'c':
                if (1 >= length) {
                    return null;
                }
                switch (cArr[1]) {
                    case 'o':
                        if (2 >= length) {
                            return null;
                        }
                        switch (cArr[2]) {
                            case 'd':
                                if (!UriMapHelper.a(cArr, 3, "egenerator") || 13 < length) {
                                    return null;
                                }
                                return UriMapHelper.a(context, "com.facebook.katana.activity.codegenerator.CodeGeneratorActivity", null, null, null, fb4aComponentHelperFactory);
                            case 'v':
                                if (!UriMapHelper.a(cArr, 3, "erphoto") || 10 < length) {
                                    return null;
                                }
                                return UriMapHelper.a(context, 1, 119, null, null, null, fb4aComponentHelperFactory);
                            default:
                                return null;
                        }
                    default:
                        return null;
                }
            case 'g':
                if (1 >= length) {
                    return null;
                }
                switch (cArr[1]) {
                    case 'o':
                        if (!UriMapHelper.a(cArr, 2, "odfriends/select_audience") || 27 < length) {
                            return null;
                        }
                        return UriMapHelper.a(context, 1, 246, null, null, null, fb4aComponentHelperFactory);
                    case 'r':
                        if (!UriMapHelper.a(cArr, 2, "oups/gridtab") || 14 < length) {
                            return null;
                        }
                        return UriMapHelper.a(context, 1, 66, null, null, null, fb4aComponentHelperFactory);
                    default:
                        return null;
                }
            case 'i':
                if (!UriMapHelper.a(cArr, 1, "nvite_coworker")) {
                    return null;
                }
                if (15 < length) {
                    i = 16;
                    switch (cArr[15]) {
                        case '/':
                            if (16 < length && cArr[16] == '?') {
                                i = 17;
                                break;
                            }
                            return null;
                            break;
                        case '?':
                            break;
                        default:
                            return null;
                    }
                    return m8441g(context, cArr, i, length, null, fb4aComponentHelperFactory);
                }
                return UriMapHelper.a(context, "com.facebook.work.invitecoworker.InviteCoworkerActivity", null, null, null, fb4aComponentHelperFactory);
            case 'l':
                if (1 >= length) {
                    return null;
                }
                switch (cArr[1]) {
                    case 'a':
                        if (!UriMapHelper.a(cArr, 2, "nguage_switch") || 15 < length) {
                            return null;
                        }
                        return UriMapHelper.a(context, "com.facebook.languages.switcher.activity.LanguageSwitcherBookmarksActivity", null, null, null, fb4aComponentHelperFactory);
                    case 'e':
                        if (!UriMapHelper.a(cArr, 2, "ad_gen") || 8 >= length) {
                            return null;
                        }
                        switch (cArr[8]) {
                            case '/':
                                if (9 < length && cArr[9] == '?') {
                                    i = 10;
                                    break;
                                }
                                return null;
                                break;
                            case '?':
                                break;
                            default:
                                return null;
                        }
                        return m8443i(context, cArr, i, length, null, fb4aComponentHelperFactory);
                    case 'i':
                        if (!UriMapHelper.a(cArr, 2, "ve_map")) {
                            return null;
                        }
                        if (8 >= length) {
                            return UriMapHelper.a(context, 1, 253, null, null, null, fb4aComponentHelperFactory);
                        }
                        switch (cArr[8]) {
                            case '/':
                                if (9 < length && cArr[9] == '?') {
                                    i = 10;
                                    break;
                                }
                                return null;
                            case '?':
                                break;
                            default:
                                return null;
                        }
                        return m8442h(context, cArr, i, length, null, fb4aComponentHelperFactory);
                    case 'o':
                        if (!UriMapHelper.a(cArr, 2, "cation_settings") || 17 < length) {
                            return null;
                        }
                        return UriMapHelper.a(context, 1, 30, null, null, null, fb4aComponentHelperFactory);
                    default:
                        return null;
                }
            case 'n':
                if (!UriMapHelper.a(cArr, 1, "ewContactPointFaceweb") || 22 < length) {
                    return null;
                }
                return UriMapHelper.a(context, "com.facebook.katana.activity.contactpoints.AddContactpointFacewebActivity", null, null, null, fb4aComponentHelperFactory);
            case 'p':
                if (1 >= length) {
                    return null;
                }
                switch (cArr[1]) {
                    case 'a':
                        if (!UriMapHelper.a(cArr, 2, "yment_settings") || 16 < length) {
                            return null;
                        }
                        return UriMapHelper.a(context, "com.facebook.payments.paymentmethods.picker.PickerScreenActivity", null, null, null, fb4aComponentHelperFactory);
                    case 'l':
                        if (!UriMapHelper.a(cArr, 2, "ace/creation") || 14 < length) {
                            return null;
                        }
                        return UriMapHelper.a(context, "com.facebook.places.create.NewPlaceCreationActivity", null, null, null, fb4aComponentHelperFactory);
                    case 'r':
                        if (!UriMapHelper.a(cArr, 2, "ofile")) {
                            return null;
                        }
                        if (7 >= length) {
                            return UriMapHelper.a(context, 1, 8, null, null, null, fb4aComponentHelperFactory);
                        }
                        switch (cArr[7]) {
                            case '/':
                                if (8 >= length || cArr[8] != '?') {
                                    if (8 < length) {
                                        switch (cArr[8]) {
                                            case 'a':
                                                if (9 < length) {
                                                    switch (cArr[9]) {
                                                        case 'b':
                                                            if (10 < length) {
                                                                switch (cArr[10]) {
                                                                    case 'o':
                                                                        if (11 < length) {
                                                                            switch (cArr[11]) {
                                                                                case 'u':
                                                                                    if (12 < length) {
                                                                                        switch (cArr[12]) {
                                                                                            case 't':
                                                                                                if (13 >= length) {
                                                                                                    return UriMapHelper.a(context, 1, 42, null, null, null, fb4aComponentHelperFactory);
                                                                                                }
                                                                                                return m8434a(context, cArr, length, 8, null, fb4aComponentHelperFactory);
                                                                                        }
                                                                                    }
                                                                                    return m8434a(context, cArr, length, 8, null, fb4aComponentHelperFactory);
                                                                            }
                                                                        }
                                                                        return m8434a(context, cArr, length, 8, null, fb4aComponentHelperFactory);
                                                                }
                                                            }
                                                            return m8434a(context, cArr, length, 8, null, fb4aComponentHelperFactory);
                                                    }
                                                }
                                                return m8434a(context, cArr, length, 8, null, fb4aComponentHelperFactory);
                                            case 'l':
                                                if (9 < length) {
                                                    switch (cArr[9]) {
                                                        case 'i':
                                                            if (10 < length) {
                                                                switch (cArr[10]) {
                                                                    case 'f':
                                                                        if (11 < length) {
                                                                            switch (cArr[11]) {
                                                                                case 'e':
                                                                                    if (12 < length) {
                                                                                        switch (cArr[12]) {
                                                                                            case '_':
                                                                                                if (13 < length) {
                                                                                                    switch (cArr[13]) {
                                                                                                        case 'e':
                                                                                                            if (14 < length) {
                                                                                                                switch (cArr[14]) {
                                                                                                                    case 'v':
                                                                                                                        if (15 < length) {
                                                                                                                            switch (cArr[15]) {
                                                                                                                                case 'e':
                                                                                                                                    if (16 < length) {
                                                                                                                                        switch (cArr[16]) {
                                                                                                                                            case 'n':
                                                                                                                                                if (17 < length) {
                                                                                                                                                    switch (cArr[17]) {
                                                                                                                                                        case 't':
                                                                                                                                                            if (18 < length) {
                                                                                                                                                                return m8434a(context, cArr, length, 8, null, fb4aComponentHelperFactory);
                                                                                                                                                            }
                                                                                                                                                            return UriMapHelper.a(context, "com.facebook.composer.lifeevent.type.ComposerLifeEventTypeActivity", null, null, null, fb4aComponentHelperFactory);
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                                return m8434a(context, cArr, length, 8, null, fb4aComponentHelperFactory);
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                    return m8434a(context, cArr, length, 8, null, fb4aComponentHelperFactory);
                                                                                                                            }
                                                                                                                        }
                                                                                                                        return m8434a(context, cArr, length, 8, null, fb4aComponentHelperFactory);
                                                                                                                }
                                                                                                            }
                                                                                                            return m8434a(context, cArr, length, 8, null, fb4aComponentHelperFactory);
                                                                                                    }
                                                                                                }
                                                                                                return m8434a(context, cArr, length, 8, null, fb4aComponentHelperFactory);
                                                                                        }
                                                                                    }
                                                                                    return m8434a(context, cArr, length, 8, null, fb4aComponentHelperFactory);
                                                                            }
                                                                        }
                                                                        return m8434a(context, cArr, length, 8, null, fb4aComponentHelperFactory);
                                                                }
                                                            }
                                                            return m8434a(context, cArr, length, 8, null, fb4aComponentHelperFactory);
                                                    }
                                                }
                                                return m8434a(context, cArr, length, 8, null, fb4aComponentHelperFactory);
                                            case 'r':
                                                if (9 < length) {
                                                    switch (cArr[9]) {
                                                        case 'e':
                                                            if (10 < length) {
                                                                switch (cArr[10]) {
                                                                    case 'f':
                                                                        if (11 < length) {
                                                                            switch (cArr[11]) {
                                                                                case 'r':
                                                                                    if (12 < length) {
                                                                                        switch (cArr[12]) {
                                                                                            case 'e':
                                                                                                if (13 < length) {
                                                                                                    switch (cArr[13]) {
                                                                                                        case 's':
                                                                                                            if (14 < length) {
                                                                                                                switch (cArr[14]) {
                                                                                                                    case 'h':
                                                                                                                        if (15 < length) {
                                                                                                                            switch (cArr[15]) {
                                                                                                                                case 'e':
                                                                                                                                    if (16 < length) {
                                                                                                                                        switch (cArr[16]) {
                                                                                                                                            case 'r':
                                                                                                                                                if (17 < length) {
                                                                                                                                                    return m8434a(context, cArr, length, 8, null, fb4aComponentHelperFactory);
                                                                                                                                                }
                                                                                                                                                return UriMapHelper.a(context, "com.facebook.timeline.refresher.ProfileRefresherProfileStepActivity", null, null, null, fb4aComponentHelperFactory);
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                    return m8434a(context, cArr, length, 8, null, fb4aComponentHelperFactory);
                                                                                                                            }
                                                                                                                        }
                                                                                                                        return m8434a(context, cArr, length, 8, null, fb4aComponentHelperFactory);
                                                                                                                }
                                                                                                            }
                                                                                                            return m8434a(context, cArr, length, 8, null, fb4aComponentHelperFactory);
                                                                                                    }
                                                                                                }
                                                                                                return m8434a(context, cArr, length, 8, null, fb4aComponentHelperFactory);
                                                                                        }
                                                                                    }
                                                                                    return m8434a(context, cArr, length, 8, null, fb4aComponentHelperFactory);
                                                                            }
                                                                        }
                                                                        return m8434a(context, cArr, length, 8, null, fb4aComponentHelperFactory);
                                                                }
                                                            }
                                                            return m8434a(context, cArr, length, 8, null, fb4aComponentHelperFactory);
                                                    }
                                                }
                                                return m8434a(context, cArr, length, 8, null, fb4aComponentHelperFactory);
                                        }
                                    }
                                    return m8437c(context, cArr, length, 8, null, fb4aComponentHelperFactory);
                                }
                            case '?':
                                i = 8;
                                break;
                            case '_':
                                if (!UriMapHelper.a(cArr, 8, "picture_nux") || 19 < length) {
                                    return null;
                                }
                                return UriMapHelper.a(context, "com.facebook.work.profilepictureinterstitial.ProfilePictureInterstitialActivity", null, null, null, fb4aComponentHelperFactory);
                            default:
                                return null;
                        }
                        return m8438d(context, cArr, i, length, null, fb4aComponentHelperFactory);
                    default:
                        return null;
                }
            case 'r':
                if (!UriMapHelper.a(cArr, 1, "edspace")) {
                    return null;
                }
                if (8 >= length) {
                    return UriMapHelper.a(context, 1, 161, null, null, null, fb4aComponentHelperFactory);
                }
                switch (cArr[8]) {
                    case '/':
                        if ((9 >= length || cArr[9] != '?') && UriMapHelper.a(cArr, 9, "friends/overflow") && 25 >= length) {
                            return UriMapHelper.a(context, 1, 160, null, null, null, fb4aComponentHelperFactory);
                        }
                        return null;
                    default:
                        return null;
                }
            case 's':
                if (1 >= length) {
                    return null;
                }
                switch (cArr[1]) {
                    case 'e':
                        if (!UriMapHelper.a(cArr, 2, "ttings") || 8 < length) {
                            return null;
                        }
                        return UriMapHelper.a(context, "com.facebook.katana.settings.activity.SettingsActivity", null, null, null, fb4aComponentHelperFactory);
                    case 'p':
                        if (!UriMapHelper.a(cArr, 2, "orts") || 6 >= length) {
                            return null;
                        }
                        switch (cArr[6]) {
                            case '/':
                                if (7 >= length || cArr[7] != '?') {
                                    return m8440f(context, cArr, length, 7, null, fb4aComponentHelperFactory);
                                }
                                return null;
                            case '_':
                                if (!UriMapHelper.a(cArr, 7, "dashboard") || 16 < length) {
                                    return null;
                                }
                                return UriMapHelper.a(context, 1, 251, null, null, null, fb4aComponentHelperFactory);
                            default:
                                return null;
                        }
                    case 't':
                        if (!UriMapHelper.a(cArr, 2, "orygallerysurvey") || 18 < length) {
                            return null;
                        }
                        return UriMapHelper.a(context, "com.facebook.storygallerysurvey.activity.StoryGallerySurveyWithStoryActivity", null, null, null, fb4aComponentHelperFactory);
                    default:
                        return null;
                }
            default:
                return null;
        }
    }
}
