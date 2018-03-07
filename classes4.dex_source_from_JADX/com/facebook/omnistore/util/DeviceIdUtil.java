package com.facebook.omnistore.util;

import android.content.Context;
import android.provider.Settings.Secure;
import android.util.Base64;
import com.facebook.common.util.Hex;
import com.facebook.common.util.StringUtil;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: last_contacts_upload_attempt_timestamp */
public class DeviceIdUtil {
    public static final Long AI_DEMOS_SAMPLE_APP_ID = Long.valueOf(1613547858907322L);
    public static final Map<Long, String> APP_ID_MAP = new C04331();
    public static final Long GRAPHQL_TEST_APP_ID = Long.valueOf(512266575476403L);
    public static final Long INSTANT_ARTICLES_SAMPLE_APP_ID = Long.valueOf(1410841939220564L);

    /* compiled from: last_contacts_upload_attempt_timestamp */
    final class C04331 extends HashMap<Long, String> {
        C04331() {
            put(Long.valueOf(256002347743983L), "am");
            put(Long.valueOf(105910932827969L), "ami");
            put(Long.valueOf(181425161904154L), "amd");
            put(Long.valueOf(350685531728L), "af");
            put(Long.valueOf(1442593136019356L), "aw");
            put(Long.valueOf(312713275593566L), "awm");
            put(Long.valueOf(358698234273213L), "ag");
            put(Long.valueOf(615857748495393L), "ac");
            put(Long.valueOf(794956213882720L), "amo");
            put(DeviceIdUtil.GRAPHQL_TEST_APP_ID, "agraphtest");
            put(DeviceIdUtil.INSTANT_ARTICLES_SAMPLE_APP_ID, "aarticlessample");
            put(DeviceIdUtil.AI_DEMOS_SAMPLE_APP_ID, "aaidemossample");
        }
    }

    @Nullable
    public static String getDeviceId(Context context, Long l) {
        String string = Secure.getString(context.getContentResolver(), "android_id");
        if (StringUtil.c(string)) {
            return null;
        }
        String encodeToString;
        try {
            encodeToString = Base64.encodeToString(Hex.a(string), 17);
        } catch (IllegalArgumentException e) {
            encodeToString = string;
        }
        string = (String) APP_ID_MAP.get(l);
        if (string == null) {
            throw new IllegalArgumentException("Invalid app ID: " + String.valueOf(l));
        }
        Object replaceAll = encodeToString.replaceAll("[^a-zA-Z0-9]", "");
        if (StringUtil.c(replaceAll)) {
            return null;
        }
        return string + replaceAll;
    }
}
