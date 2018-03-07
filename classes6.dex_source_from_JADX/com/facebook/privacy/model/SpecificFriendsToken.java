package com.facebook.privacy.model;

import com.facebook.widget.tokenizedtypeahead.model.BaseToken.Type;
import com.google.common.base.Objects;

/* compiled from: fbuploader_video_file_chunk */
public class SpecificFriendsToken extends PrivacyToken {
    public SpecificFriendsToken(String str, int i, int i2, int i3, int i4) {
        super(Type.SPECIFIC_FRIENDS, i, i2, i3, i4, str, null);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SpecificFriendsToken)) {
            return false;
        }
        SpecificFriendsToken specificFriendsToken = (SpecificFriendsToken) obj;
        if (Objects.equal(this.f15085i, specificFriendsToken.mo1185b()) && this.f15081e == specificFriendsToken.mo1187e() && this.f15082f == specificFriendsToken.mo1190h()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f15085i, Integer.valueOf(this.f15081e), Integer.valueOf(this.f15082f)});
    }
}
