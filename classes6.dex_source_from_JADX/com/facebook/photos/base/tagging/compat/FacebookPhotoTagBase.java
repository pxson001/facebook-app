package com.facebook.photos.base.tagging.compat;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: info_review_items */
public abstract class FacebookPhotoTagBase {
    public abstract JSONObject mo1103m();

    public static String m20177a(List<? extends FacebookPhotoTagBase> list) {
        JSONArray jSONArray = new JSONArray();
        for (FacebookPhotoTagBase facebookPhotoTagBase : list) {
            if (facebookPhotoTagBase.mo1103m() != null) {
                jSONArray.put(facebookPhotoTagBase.mo1103m());
            }
        }
        return jSONArray.toString();
    }
}
