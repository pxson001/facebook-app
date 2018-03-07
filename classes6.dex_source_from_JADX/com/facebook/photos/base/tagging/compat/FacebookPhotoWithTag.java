package com.facebook.photos.base.tagging.compat;

import com.facebook.debug.log.BLog;
import org.json.JSONObject;

/* compiled from: inferences */
public class FacebookPhotoWithTag extends FacebookPhotoTagBase {
    public final long f12798a;

    public FacebookPhotoWithTag(long j) {
        this.f12798a = j;
    }

    public final JSONObject mo1103m() {
        try {
            return new JSONObject().put("tag_uid", Long.toString(this.f12798a));
        } catch (Throwable e) {
            BLog.b("", "inconceivable JSON exception", e);
            return null;
        }
    }
}
