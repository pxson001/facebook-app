package com.facebook.fbreact.i18n;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import com.facebook.common.internal.ByteStreams;
import com.facebook.common.locale.FBLocaleMapper;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.JsonWriter;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: extra_privacy_checkup_step */
public class FbReactI18nModule extends ReactContextBaseJavaModule {
    private final int f7335a;
    private final FbLocaleProvider f7336b;

    public FbReactI18nModule(ReactApplicationContext reactApplicationContext, int i, FbLocaleProvider fbLocaleProvider) {
        super(reactApplicationContext);
        this.f7336b = fbLocaleProvider;
        this.f7335a = i;
    }

    public String getName() {
        return "RKI18n";
    }

    public final Map<String, Object> m8528a() {
        Map hashMap = new HashMap();
        Context baseContext = this.a.getBaseContext();
        Locale locale = baseContext.getResources().getConfiguration().locale;
        m8526a(hashMap);
        hashMap.put("NumberFormatConfig", m8527r());
        hashMap.put("localeIdentifier", locale.toString());
        hashMap.put("translationsDictionary", m8525a(baseContext, this.f7335a));
        return hashMap;
    }

    private String m8527r() {
        ReactApplicationContext p = p();
        if (p.getResources().getIdentifier("number_format_config", "raw", p.getPackageName()) != 0) {
            return m8525a(p, 2131165257);
        }
        Writer stringWriter = new StringWriter();
        DecimalFormat decimalFormat = new DecimalFormat();
        DecimalFormatSymbols instance = DecimalFormatSymbols.getInstance();
        try {
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            jsonWriter.c();
            jsonWriter.a("decimalSeparator").b(String.valueOf(instance.getDecimalSeparator()));
            jsonWriter.a("numberDelimiter").b(String.valueOf(instance.getGroupingSeparator()));
            jsonWriter.a("minDigitsForThousandsSeparator").a((long) decimalFormat.getGroupingSize());
            jsonWriter.d();
            jsonWriter.close();
            return stringWriter.getBuffer().toString();
        } catch (Throwable e) {
            FLog.a("React", "Unable to serialize NumberFormatConfig from system values", e);
            return null;
        }
    }

    private static String m8525a(Context context, int i) {
        Throwable e;
        InputStream inputStream = null;
        try {
            inputStream = context.getResources().openRawResource(i);
            String str = new String(ByteStreams.a(inputStream));
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                }
            }
            return str;
        } catch (NotFoundException e3) {
            e = e3;
            try {
                throw new IllegalStateException("Could not read localized JSON file from resources", e);
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                    }
                }
            }
        } catch (IOException e5) {
            e = e5;
            throw new IllegalStateException("Could not read localized JSON file from resources", e);
        }
    }

    private void m8526a(HashMap<String, Object> hashMap) {
        Locale locale;
        String str = "fbLocaleIdentifier";
        Locale locale2 = this.a.getResources().getConfiguration().locale;
        if ("fil".equals(locale2.getLanguage())) {
            locale = new Locale("tl", locale2.getCountry());
        } else {
            locale = locale2;
        }
        hashMap.put(str, FBLocaleMapper.a(locale));
        hashMap.put("CurrencyFormatConfig", m8525a(this.a, 2131165203));
        hashMap.put("DateFormatConfig", m8525a(this.a, 2131165204));
    }
}
