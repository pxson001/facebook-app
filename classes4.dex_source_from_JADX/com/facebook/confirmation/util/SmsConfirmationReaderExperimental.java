package com.facebook.confirmation.util;

import android.content.ContentResolver;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.confirmation.logging.ConfirmationAnalyticsLogger;
import com.facebook.confirmation.task.SimpleSmsMessage;
import com.facebook.confirmation.task.SmsCode;
import com.facebook.confirmation.task.SmsCodeType;
import com.facebook.confirmation.util.SmsReaderExperimental.SmsReaderPointer;
import com.facebook.inject.InjectorLike;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;

/* compiled from: fb_access_token */
public class SmsConfirmationReaderExperimental extends SmsReaderExperimental {
    @VisibleForTesting
    static final Set<String> f12061a = ImmutableSet.of("32665", "FACEBOOK", "919232232665", "1006", "3404", "42665", new String[]{"2123", "631", "3265", "85264503266", "325", "51555", "717", "3223", "604", "5100", "600", "488", "13999", "15666"});
    private static final Pattern f12062b = Pattern.compile("(?:^|\\D)(\\d{4,10})(?:$|\\D)");
    private final ConfirmationAnalyticsLogger f12063c;

    public static SmsConfirmationReaderExperimental m12744c(InjectorLike injectorLike) {
        return new SmsConfirmationReaderExperimental(ContentResolverMethodAutoProvider.b(injectorLike), RuntimePermissionsUtil.b(injectorLike), ConfirmationAnalyticsLogger.m12704b(injectorLike));
    }

    @Inject
    public SmsConfirmationReaderExperimental(ContentResolver contentResolver, RuntimePermissionsUtil runtimePermissionsUtil, ConfirmationAnalyticsLogger confirmationAnalyticsLogger) {
        super(contentResolver, runtimePermissionsUtil);
        this.f12063c = confirmationAnalyticsLogger;
    }

    public final List<SmsCode> mo902a(SmsReaderPointer smsReaderPointer) {
        List<SimpleSmsMessage> b = m12756b(smsReaderPointer);
        m12743a(b.size());
        List<SmsCode> arrayList = new ArrayList();
        Set hashSet = new HashSet();
        Map hashMap = new HashMap();
        Set a = m12742a((List) b);
        for (SimpleSmsMessage simpleSmsMessage : b) {
            int intValue;
            if (hashMap.containsKey(simpleSmsMessage.c)) {
                intValue = ((Integer) hashMap.get(simpleSmsMessage.c)).intValue();
            } else {
                intValue = 0;
            }
            if (intValue < 5) {
                String a2 = m12741a(simpleSmsMessage.d);
                if (!(a2 == null || hashSet.contains(a2))) {
                    hashSet.add(a2);
                    SmsCodeType smsCodeType = SmsCodeType.NORMAL;
                    if (simpleSmsMessage.e || a.contains(simpleSmsMessage.c)) {
                        smsCodeType = simpleSmsMessage.e ? SmsCodeType.PRIORITY_FB_TOKEN_1 : SmsCodeType.PRIORITY_FB_TOKEN_2;
                    } else if (f12061a.contains(simpleSmsMessage.c)) {
                        smsCodeType = SmsCodeType.PRIORITY_SENDER;
                    }
                    arrayList.add(new SmsCode(a2, smsCodeType));
                    hashMap.put(simpleSmsMessage.c, Integer.valueOf(intValue + 1));
                    if (arrayList.size() > 100) {
                        break;
                    }
                }
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    @VisibleForTesting
    private void m12743a(int i) {
        this.f12063c.m12706a(i);
    }

    @VisibleForTesting
    private static Set<String> m12742a(List<SimpleSmsMessage> list) {
        Set<String> hashSet = new HashSet();
        for (SimpleSmsMessage simpleSmsMessage : list) {
            if (simpleSmsMessage.e) {
                hashSet.add(simpleSmsMessage.c);
            }
        }
        return hashSet;
    }

    @VisibleForTesting
    private static String m12741a(String str) {
        Matcher matcher = f12062b.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
