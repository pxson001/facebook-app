package com.facebook.socialgood.ipc;

import android.text.TextUtils;

/* compiled from: user_currency */
public class SocialGoodConstants {

    /* compiled from: user_currency */
    public enum FundraiserActionType {
        INVITE,
        NONE;

        public static FundraiserActionType fromString(String str) {
            if (TextUtils.isEmpty(str)) {
                return NONE;
            }
            if ("invite".equalsIgnoreCase(str)) {
                return INVITE;
            }
            return NONE;
        }
    }
}
