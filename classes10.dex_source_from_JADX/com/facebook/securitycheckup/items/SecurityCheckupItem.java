package com.facebook.securitycheckup.items;

import com.facebook.securitycheckup.api.SecurityCheckupQueryModels.SecurityCheckupQueryModel.SecurityCheckupModel;
import javax.annotation.Nullable;

/* compiled from: https443 */
public class SecurityCheckupItem {
    public final String f9842a;
    public String f9843b;
    public String f9844c;
    public final ItemType f9845d;
    public boolean f9846e;
    public boolean f9847f = false;
    public boolean f9848g = false;
    public final SecurityCheckupModel f9849h;

    /* compiled from: https443 */
    public enum ItemType {
        INTRO,
        UNUSED_SESSIONS,
        LOGIN_ALERTS,
        PASSWORD,
        CONCLUSION
    }

    public SecurityCheckupItem(String str, String str2, @Nullable String str3, ItemType itemType, SecurityCheckupModel securityCheckupModel) {
        this.f9842a = str;
        this.f9843b = str2;
        this.f9844c = str3;
        this.f9845d = itemType;
        this.f9849h = securityCheckupModel;
    }
}
