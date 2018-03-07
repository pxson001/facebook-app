package android_src.mmsv2;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.debug.log.BLog;
import com.facebook.phonenumbers.NumberParseException;
import com.facebook.phonenumbers.PhoneNumberUtil;
import com.facebook.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.facebook.phonenumbers.Phonenumber.PhoneNumber;

/* compiled from: setPrimaryCardParams */
public class PhoneNumberHelper {
    static String m3575a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            PhoneNumberUtil instance = PhoneNumberUtil.getInstance(context);
            try {
                PhoneNumber parse = instance.parse(str, str2);
                if (parse != null && instance.isValidNumber(parse)) {
                    str = instance.format(parse, PhoneNumberFormat.NATIONAL).replaceAll("\\D", "");
                }
            } catch (NumberParseException e) {
                BLog.a("MmsLib", "getNumberNoCountryCode: invalid number " + e);
            }
        }
        return str;
    }
}
