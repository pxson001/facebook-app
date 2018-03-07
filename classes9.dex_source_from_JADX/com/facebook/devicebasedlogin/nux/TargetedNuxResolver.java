package com.facebook.devicebasedlogin.nux;

import android.content.Context;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: There are no nux steps to show. */
public final class TargetedNuxResolver {
    private final Context f24172a;

    /* compiled from: There are no nux steps to show. */
    public enum NuxType {
        DEFAULT("default"),
        AUTOSAVE("autosave"),
        FREQUENT_LOGIN_LOGOUT("login_logout"),
        TROUBLE_LOGGING_IN("trouble_logging_in"),
        SHARED_DEVICE("shared_device");
        
        private final String mNuxType;

        private NuxType(String str) {
            this.mNuxType = str;
        }

        public final String getTypeString() {
            return this.mNuxType;
        }

        public static NuxType fromString(String str) {
            if (str != null) {
                for (NuxType nuxType : values()) {
                    if (str.equalsIgnoreCase(nuxType.getTypeString())) {
                        return nuxType;
                    }
                }
            }
            return null;
        }
    }

    public static TargetedNuxResolver m26135b(InjectorLike injectorLike) {
        return new TargetedNuxResolver((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public TargetedNuxResolver(Context context) {
        this.f24172a = context;
    }

    public final String m26136a(NuxType nuxType) {
        switch (nuxType) {
            case AUTOSAVE:
                return this.f24172a.getString(2131236229);
            case FREQUENT_LOGIN_LOGOUT:
                return this.f24172a.getString(2131236298);
            case TROUBLE_LOGGING_IN:
                return this.f24172a.getString(2131236296);
            case SHARED_DEVICE:
                return this.f24172a.getString(2131236300);
            default:
                return this.f24172a.getString(2131236227);
        }
    }

    public final String m26137b(NuxType nuxType) {
        switch (nuxType) {
            case AUTOSAVE:
                return this.f24172a.getString(2131236230);
            case FREQUENT_LOGIN_LOGOUT:
                return this.f24172a.getString(2131236299);
            case TROUBLE_LOGGING_IN:
                return this.f24172a.getString(2131236297);
            case SHARED_DEVICE:
                return this.f24172a.getString(2131236299);
            default:
                return this.f24172a.getString(2131236228);
        }
    }
}
