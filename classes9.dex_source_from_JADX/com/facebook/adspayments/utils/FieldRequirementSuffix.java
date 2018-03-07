package com.facebook.adspayments.utils;

import android.content.Context;

/* compiled from: UPLOAD_SUCCEEDED */
public enum FieldRequirementSuffix {
    OPTIONAL {
        public final String getHint(Context context, String str) {
            return context.getString(2131240162, new Object[]{str});
        }
    },
    REQUIRED {
        public final String getHint(Context context, String str) {
            return context.getString(2131240163, new Object[]{str});
        }
    },
    NO_SUFFIX {
        public final String getHint(Context context, String str) {
            return str;
        }
    };

    public abstract String getHint(Context context, String str);
}
