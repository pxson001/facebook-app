package com.facebook.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookSdk;
import com.facebook.login.DefaultAudience;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: SEND_SKIPPED_BROADCAST */
public final class NativeProtocol {
    public static final NativeAppInfo f24013a = new KatanaAppInfo();
    public static List<NativeAppInfo> f24014b;
    private static Map<String, List<NativeAppInfo>> f24015c;
    public static AtomicBoolean f24016d = new AtomicBoolean(false);
    private static final List<Integer> f24017e = Arrays.asList(new Integer[]{Integer.valueOf(20141218), Integer.valueOf(20141107), Integer.valueOf(20141028), Integer.valueOf(20141001), Integer.valueOf(20140701), Integer.valueOf(20140324), Integer.valueOf(20140204), Integer.valueOf(20131107), Integer.valueOf(20130618), Integer.valueOf(20130502), Integer.valueOf(20121101)});

    /* compiled from: SEND_SKIPPED_BROADCAST */
    final class C34501 implements Runnable {
        C34501() {
        }

        public final void run() {
            try {
                for (NativeAppInfo a : NativeProtocol.f24014b) {
                    NativeAppInfo.m25285a(a, true);
                }
            } finally {
                NativeProtocol.f24016d.set(false);
            }
        }
    }

    /* compiled from: SEND_SKIPPED_BROADCAST */
    public abstract class NativeAppInfo {
        private static final HashSet<String> f24011a;
        public TreeSet<Integer> f24012b;

        public abstract String mo1041a();

        static {
            HashSet hashSet = new HashSet();
            hashSet.add("8a3c4b262d721acd49a4bf97d5213199c86fa2b9");
            hashSet.add("a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc");
            hashSet.add("5e8f16062ea3cd2c4a0d547876baa6f38cabf625");
            f24011a = hashSet;
        }

        public static boolean m25286a(Context context, String str) {
            String str2 = Build.BRAND;
            int i = context.getApplicationInfo().flags;
            if (str2.startsWith("generic") && (i & 2) != 0) {
                return true;
            }
            try {
                for (Signature toByteArray : context.getPackageManager().getPackageInfo(str, 64).signatures) {
                    if (f24011a.contains(Utility.m25327a(toByteArray.toByteArray()))) {
                        return true;
                    }
                }
                return false;
            } catch (NameNotFoundException e) {
                return false;
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static synchronized void m25285a(com.facebook.internal.NativeProtocol.NativeAppInfo r1, boolean r2) {
            /*
            monitor-enter(r1);
            if (r2 != 0) goto L_0x0007;
        L_0x0003:
            r0 = r1.f24012b;	 Catch:{ all -> 0x000f }
            if (r0 != 0) goto L_0x000d;
        L_0x0007:
            r0 = com.facebook.internal.NativeProtocol.m25299b(r1);	 Catch:{ all -> 0x000f }
            r1.f24012b = r0;	 Catch:{ all -> 0x000f }
        L_0x000d:
            monitor-exit(r1);
            return;
        L_0x000f:
            r0 = move-exception;
            monitor-exit(r1);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.NativeProtocol.NativeAppInfo.a(com.facebook.internal.NativeProtocol$NativeAppInfo, boolean):void");
        }
    }

    /* compiled from: SEND_SKIPPED_BROADCAST */
    class KatanaAppInfo extends NativeAppInfo {
        protected final String mo1041a() {
            return "com.facebook.katana";
        }
    }

    /* compiled from: SEND_SKIPPED_BROADCAST */
    public class MessengerAppInfo extends NativeAppInfo {
        protected final String mo1041a() {
            return "com.facebook.orca";
        }
    }

    /* compiled from: SEND_SKIPPED_BROADCAST */
    public class WakizashiAppInfo extends NativeAppInfo {
        protected final String mo1041a() {
            return "com.facebook.wakizashi";
        }
    }

    static {
        List arrayList = new ArrayList();
        arrayList.add(f24013a);
        arrayList.add(new WakizashiAppInfo());
        f24014b = arrayList;
        Map hashMap = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new MessengerAppInfo());
        hashMap.put("com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG", f24014b);
        hashMap.put("com.facebook.platform.action.request.FEED_DIALOG", f24014b);
        hashMap.put("com.facebook.platform.action.request.LIKE_DIALOG", f24014b);
        hashMap.put("com.facebook.platform.action.request.APPINVITES_DIALOG", f24014b);
        hashMap.put("com.facebook.platform.action.request.MESSAGE_DIALOG", arrayList2);
        hashMap.put("com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG", arrayList2);
        f24015c = hashMap;
    }

    private static Intent m25293a(Context context, Intent intent, NativeAppInfo nativeAppInfo) {
        if (intent == null) {
            return null;
        }
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        if (resolveActivity == null) {
            return null;
        }
        if (NativeAppInfo.m25286a(context, resolveActivity.activityInfo.packageName)) {
            return intent;
        }
        return null;
    }

    public static Intent m25298b(Context context, Intent intent, NativeAppInfo nativeAppInfo) {
        if (intent == null) {
            return null;
        }
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
        if (resolveService == null) {
            return null;
        }
        if (NativeAppInfo.m25286a(context, resolveService.serviceInfo.packageName)) {
            return intent;
        }
        return null;
    }

    public static Intent m25294a(Context context, String str, Collection<String> collection, String str2, boolean z, boolean z2, DefaultAudience defaultAudience) {
        for (NativeAppInfo nativeAppInfo : f24014b) {
            Intent putExtra = new Intent().setClassName(nativeAppInfo.mo1041a(), "com.facebook.katana.ProxyAuth").putExtra("client_id", str);
            if (!Utility.m25346a((Collection) collection)) {
                putExtra.putExtra("scope", TextUtils.join(",", collection));
            }
            if (!Utility.m25345a(str2)) {
                putExtra.putExtra("e2e", str2);
            }
            putExtra.putExtra("response_type", "token,signed_request");
            putExtra.putExtra("return_scopes", "true");
            if (z2) {
                putExtra.putExtra("default_audience", defaultAudience.getNativeProtocolAudience());
            }
            putExtra.putExtra("legacy_override", "v2.5");
            if (z) {
                putExtra.putExtra("auth_type", "rerequest");
            }
            Intent a = m25293a(context, putExtra, nativeAppInfo);
            if (a != null) {
                return a;
            }
        }
        return null;
    }

    public static final int m25291a() {
        return ((Integer) f24017e.get(0)).intValue();
    }

    private static boolean m25301b(int i) {
        return f24017e.contains(Integer.valueOf(i)) && i >= 20140701;
    }

    public static Intent m25295a(Intent intent, Bundle bundle, FacebookException facebookException) {
        UUID c = m25303c(intent);
        if (c == null) {
            return null;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", m25297b(intent));
        Bundle bundle2 = new Bundle();
        bundle2.putString("action_id", c.toString());
        if (facebookException != null) {
            Bundle bundle3;
            String str = "error";
            if (facebookException == null) {
                bundle3 = null;
            } else {
                bundle3 = new Bundle();
                bundle3.putString("error_description", facebookException.toString());
                if (facebookException instanceof FacebookOperationCanceledException) {
                    bundle3.putString("error_type", "UserCanceled");
                }
            }
            bundle2.putBundle(str, bundle3);
        }
        intent2.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", bundle2);
        if (bundle == null) {
            return intent2;
        }
        intent2.putExtra("com.facebook.platform.protocol.RESULT_ARGS", bundle);
        return intent2;
    }

    private static int m25297b(Intent intent) {
        return intent.getIntExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 0);
    }

    private static UUID m25303c(Intent intent) {
        UUID uuid = null;
        if (intent != null) {
            String string;
            if (m25301b(m25297b(intent))) {
                Bundle bundleExtra = intent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
                if (bundleExtra != null) {
                    string = bundleExtra.getString("action_id");
                } else {
                    Object obj = uuid;
                }
            } else {
                string = intent.getStringExtra("com.facebook.platform.protocol.CALL_ID");
            }
            if (string != null) {
                try {
                    uuid = UUID.fromString(string);
                } catch (IllegalArgumentException e) {
                }
            }
        }
        return uuid;
    }

    public static Bundle m25296a(Intent intent) {
        if (m25301b(m25297b(intent))) {
            return intent.getBundleExtra("com.facebook.platform.protocol.METHOD_ARGS");
        }
        return intent.getExtras();
    }

    public static int m25292a(int i) {
        int i2;
        List<NativeAppInfo> list = f24014b;
        int[] iArr = new int[]{i};
        m25300b();
        if (list == null) {
            i2 = -1;
        } else {
            for (NativeAppInfo nativeAppInfo : list) {
                if (nativeAppInfo.f24012b == null) {
                    NativeAppInfo.m25285a(nativeAppInfo, false);
                }
                TreeSet treeSet = nativeAppInfo.f24012b;
                int a = m25291a();
                int i3 = -1;
                int length = iArr.length - 1;
                Iterator descendingIterator = treeSet.descendingIterator();
                int i4 = -1;
                int i5 = length;
                while (descendingIterator.hasNext()) {
                    int intValue = ((Integer) descendingIterator.next()).intValue();
                    length = Math.max(i4, intValue);
                    i4 = i5;
                    while (i4 >= 0 && iArr[i4] > intValue) {
                        i4--;
                    }
                    if (i4 < 0) {
                        break;
                    } else if (iArr[i4] != intValue) {
                        i5 = i4;
                        i4 = length;
                    } else if (i4 % 2 == 0) {
                        i3 = Math.min(length, a);
                    }
                }
                i2 = i3;
                if (i2 != -1) {
                    break;
                }
            }
            i2 = -1;
        }
        return i2;
    }

    public static void m25300b() {
        if (f24016d.compareAndSet(false, true)) {
            ExecutorDetour.a(FacebookSdk.m14050d(), new C34501(), 638860795);
        }
    }

    public static TreeSet<Integer> m25299b(NativeAppInfo nativeAppInfo) {
        Throwable th;
        Cursor cursor = null;
        TreeSet<Integer> treeSet = new TreeSet();
        ContentResolver contentResolver = FacebookSdk.m14051f().getContentResolver();
        String[] strArr = new String[]{"version"};
        Uri c = m25302c(nativeAppInfo);
        try {
            Cursor query;
            if (FacebookSdk.m14051f().getPackageManager().resolveContentProvider(nativeAppInfo.mo1041a() + ".provider.PlatformProvider", 0) != null) {
                query = contentResolver.query(c, strArr, null, null, null);
                if (query != null) {
                    while (query.moveToNext()) {
                        try {
                            treeSet.add(Integer.valueOf(query.getInt(query.getColumnIndex("version"))));
                        } catch (Throwable th2) {
                            cursor = query;
                            th = th2;
                        }
                    }
                }
            } else {
                query = null;
            }
            if (query != null) {
                query.close();
            }
            return treeSet;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private static Uri m25302c(NativeAppInfo nativeAppInfo) {
        return Uri.parse("content://" + nativeAppInfo.mo1041a() + ".provider.PlatformProvider/versions");
    }
}
