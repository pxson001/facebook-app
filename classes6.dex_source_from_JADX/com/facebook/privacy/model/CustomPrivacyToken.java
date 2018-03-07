package com.facebook.privacy.model;

import com.facebook.widget.tokenizedtypeahead.model.BaseToken.Type;
import com.google.common.base.Objects;

/* compiled from: feed_curation_flow_step */
public class CustomPrivacyToken extends PrivacyToken {
    public CustomPrivacyToken(String str, int i, int i2, int i3, int i4) {
        super(Type.FULL_CUSTOM, i, i2, i3, i4, str, null);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CustomPrivacyToken)) {
            return false;
        }
        CustomPrivacyToken customPrivacyToken = (CustomPrivacyToken) obj;
        if (Objects.equal(this.f15085i, customPrivacyToken.mo1185b()) && this.f15081e == customPrivacyToken.mo1187e() && this.f15082f == customPrivacyToken.mo1190h()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f15085i, Integer.valueOf(this.f15081e), Integer.valueOf(this.f15082f)});
    }
}
