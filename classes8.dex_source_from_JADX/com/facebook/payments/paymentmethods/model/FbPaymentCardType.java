package com.facebook.payments.paymentmethods.model;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.infer.annotation.PrivacySource;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@JsonDeserialize(using = FbPaymentCardTypeDeserializer.class)
@Immutable
/* compiled from: suggestifier_response_id */
public enum FbPaymentCardType {
    UNKNOWN("UNKNOWN", Pattern.compile(""), "Unknown card type", 0, 16),
    AMEX("AMERICAN_EXPRESS", Pattern.compile("^3[47]"), "American Express", 2130842968, 15),
    DISCOVER("DISCOVER", Pattern.compile("^(6011|65|64[4-9]|622([2-8]|1[3-9]|12[6-9]|9[0-1]|92[0-5]))"), "Discover", 2130842969, 16),
    JCB("JCB", Pattern.compile("^35(2[8-9]|[3-8])"), "JCB", 2130842970, 16),
    MASTER_CARD("MASTERCARD", Pattern.compile("^5[0-5]"), "MasterCard", 2130842971, 16),
    VISA("VISA", Pattern.compile("^4"), "Visa", 2130842974, 16);
    
    @PrivacySource
    private final String mAssociation;
    private final int mCardLength;
    @PrivacySource
    private final String mHumanReadableName;
    private final Pattern mPrefixMatchRegexPattern;
    @DrawableRes
    private final int mRectangularDrawableResourceId;

    private FbPaymentCardType(String str, Pattern pattern, String str2, int i, int i2) {
        this.mAssociation = str;
        this.mPrefixMatchRegexPattern = pattern;
        this.mHumanReadableName = str2;
        this.mRectangularDrawableResourceId = i;
        this.mCardLength = i2;
    }

    @JsonCreator
    public static FbPaymentCardType forValue(String str) {
        for (FbPaymentCardType fbPaymentCardType : values()) {
            boolean z;
            String str2 = fbPaymentCardType.mAssociation;
            if (str2 == null && str == null) {
                z = true;
            } else if (str2 == null || str == null) {
                z = false;
            } else {
                z = str2.replaceAll("[^a-zA-Z]", "").equalsIgnoreCase(str.replaceAll("[^a-zA-Z]", ""));
            }
            if (z) {
                return fbPaymentCardType;
            }
        }
        return UNKNOWN;
    }

    @Nullable
    public final Drawable getRectangularDrawable(Resources resources) {
        if (this.mRectangularDrawableResourceId != 0) {
            return resources.getDrawable(this.mRectangularDrawableResourceId);
        }
        return null;
    }

    public final Pattern getPrefixMatchRegexPattern() {
        return this.mPrefixMatchRegexPattern;
    }

    public final String getHumanReadableName() {
        return this.mHumanReadableName;
    }

    public final int getCardLength() {
        return this.mCardLength;
    }

    public final String toString() {
        return getHumanReadableName();
    }
}
