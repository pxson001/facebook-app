package com.facebook.crudolib.urimap;

import com.facebook.common.build.BuildConstants;
import javax.annotation.Nullable;

/* compiled from: open_permalink */
public enum UriScheme {
    FB("FB_URL_SCHEME"),
    MESSENGER("MESSENGER_URL_SCHEME"),
    MESSENGER_SAMETASK("MESSENGER_SAMETASK_URL_SCHEME"),
    MESSENGER_SECURE("MESSENGER_SECURE_URL_SCHEME"),
    NONE(null);
    
    @Nullable
    public final String buildConstantName;

    private UriScheme(String str) {
        this.buildConstantName = str;
    }

    public final boolean hasBuildConstant() {
        return this.buildConstantName != null;
    }

    public final String encode() {
        return "$" + super.toString();
    }

    public static UriScheme decode(String str) {
        return str.startsWith("$") ? valueOf(str.substring(1)) : NONE;
    }

    public final String getBuildConstant() {
        if (this.buildConstantName == null) {
            throw new IllegalStateException(String.format("Scheme %s does not have a buildConstantName", new Object[]{this}));
        }
        try {
            return (String) BuildConstants.class.getField(this.buildConstantName).get(this);
        } catch (Throwable e) {
            throw new RuntimeException(String.format("Could not access %s.%s", new Object[]{BuildConstants.class.getSimpleName(), this.buildConstantName}), e);
        }
    }
}
