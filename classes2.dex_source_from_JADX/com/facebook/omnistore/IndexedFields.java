package com.facebook.omnistore;

import com.facebook.proguard.annotations.DoNotStrip;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

@DoNotStrip
/* compiled from: mContext= */
public class IndexedFields {
    @DoNotStrip
    private Map<String, String[]> mFields = new HashMap();

    public void setFieldValue(String str, String str2) {
        this.mFields.put(str, new String[]{str2});
    }

    public void setFieldValues(String str, String[] strArr) {
        this.mFields.put(str, strArr);
    }

    @Nullable
    public String[] getFieldValues(String str) {
        return (String[]) this.mFields.get(str);
    }
}
