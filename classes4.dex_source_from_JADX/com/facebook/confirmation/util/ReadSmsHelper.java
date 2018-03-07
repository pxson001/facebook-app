package com.facebook.confirmation.util;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android_src.provider.Telephony$Sms$Inbox;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.confirmation.task.SimpleSmsMessage;
import com.facebook.confirmation.task.SmsCode;
import com.facebook.confirmation.task.SmsCodeType;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;

/* compiled from: fb_api_req_friendly_name */
public class ReadSmsHelper {
    private final Clock f12045a;
    private final Lazy<ContentResolver> f12046b;
    private final RuntimePermissionsUtil f12047c;

    public static ReadSmsHelper m12724b(InjectorLike injectorLike) {
        return new ReadSmsHelper(IdBasedLazy.a(injectorLike, 22), RuntimePermissionsUtil.b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ReadSmsHelper(Lazy<ContentResolver> lazy, RuntimePermissionsUtil runtimePermissionsUtil, Clock clock) {
        this.f12046b = lazy;
        this.f12047c = runtimePermissionsUtil;
        this.f12045a = clock;
    }

    public final List<SimpleSmsMessage> m12725a(long j, long j2) {
        if (!this.f12047c.a("android.permission.READ_SMS")) {
            return ImmutableList.of();
        }
        Builder builder = new Builder();
        Cursor query = ((ContentResolver) this.f12046b.get()).query(m12721a(), new String[]{"date", "body", "address"}, null, null, "date DESC");
        if ((query == null ? 0 : query.getCount()) > 0) {
            long j3 = j - 10000;
            int i = 0;
            while (query.moveToNext() && i < 1000) {
                try {
                    i++;
                    long j4 = query.getLong(query.getColumnIndexOrThrow("date"));
                    if (j4 < j3 || this.f12045a.a() - j4 > j2) {
                        break;
                    }
                    Object string = query.getString(query.getColumnIndexOrThrow("body"));
                    if (!StringUtil.a(string)) {
                        builder.c(new SimpleSmsMessage(j4, query.getString(query.getColumnIndexOrThrow("address")), string));
                    }
                } catch (Throwable th) {
                    if (query != null) {
                        query.close();
                    }
                }
            }
        }
        if (query != null) {
            query.close();
        }
        return builder.b();
    }

    public final List<SmsCode> m12726a(List<SimpleSmsMessage> list, Set<String> set, Pattern pattern, int i) {
        List<SmsCode> a = Lists.a();
        Map c = Maps.c();
        Set a2 = m12723a(list);
        int i2 = 0;
        for (SimpleSmsMessage simpleSmsMessage : list) {
            int intValue = c.containsKey(simpleSmsMessage.c) ? ((Integer) c.get(simpleSmsMessage.c)).intValue() : 0;
            if (intValue < 5) {
                String a3 = m12722a(simpleSmsMessage.d, pattern, i);
                if (a3 != null) {
                    int i3 = i2 + 1;
                    SmsCodeType smsCodeType = SmsCodeType.NORMAL;
                    if (simpleSmsMessage.e || a2.contains(simpleSmsMessage.c)) {
                        smsCodeType = simpleSmsMessage.e ? SmsCodeType.PRIORITY_FB_TOKEN_1 : SmsCodeType.PRIORITY_FB_TOKEN_2;
                    } else if (set.contains(simpleSmsMessage.c)) {
                        smsCodeType = SmsCodeType.PRIORITY_SENDER;
                    }
                    a.add(new SmsCode(a3, smsCodeType));
                    c.put(simpleSmsMessage.c, Integer.valueOf(intValue + 1));
                    if (i3 > 100) {
                        break;
                    }
                    i2 = i3;
                } else {
                    continue;
                }
            }
        }
        Collections.sort(a);
        Builder builder = new Builder();
        Set a4 = Sets.a();
        for (SmsCode smsCode : a) {
            if (!a4.contains(smsCode.a)) {
                a4.add(smsCode.a);
                builder.c(smsCode);
            }
        }
        return builder.b();
    }

    private static Uri m12721a() {
        return Telephony$Sms$Inbox.f12077a;
    }

    @VisibleForTesting
    private static Set<String> m12723a(List<SimpleSmsMessage> list) {
        ImmutableSet.Builder builder = new ImmutableSet.Builder();
        for (SimpleSmsMessage simpleSmsMessage : list) {
            if (simpleSmsMessage.e) {
                builder.c(simpleSmsMessage.c);
            }
        }
        return builder.b();
    }

    @VisibleForTesting
    private static String m12722a(String str, Pattern pattern, int i) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(i);
        }
        return null;
    }
}
