package com.facebook.photos.upload.manager;

import android.content.Context;
import com.facebook.common.build.BuildConstants;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.photos.upload.operation.UploadOperation.Type;

/* compiled from: graph_search_results_page_group */
public class DefaultUploadNotificationConfiguration {
    public int m21347a() {
        return 2130843532;
    }

    public int m21353b() {
        return 17301624;
    }

    public String mo1131a(Context context, UploadOperation uploadOperation) {
        return mo1132a(context, uploadOperation, Boolean.valueOf(false));
    }

    public String mo1132a(Context context, UploadOperation uploadOperation, Boolean bool) {
        int i = uploadOperation.m21521Z() ? 2131236054 : uploadOperation.m21520Y() ? bool.booleanValue() ? 2131236058 : 2131236057 : uploadOperation.f13795r == Type.PHOTO_REVIEW ? 2131236053 : uploadOperation.m21532c() == 1 ? 2131236055 : 2131236056;
        return context.getString(i);
    }

    public String mo1134b(Context context) {
        return context.getString(2131236063);
    }

    public String mo1136c(Context context) {
        return context.getString(2131236042);
    }

    public String mo1137d(Context context) {
        return context.getString(2131236061);
    }

    public int m21356c() {
        return 2130843528;
    }

    public String mo1138e(Context context) {
        return context.getString(2131236051, new Object[]{m21346a(context)});
    }

    public String mo1139f(Context context) {
        return context.getString(2131236059, new Object[]{m21346a(context)});
    }

    public String mo1140g(Context context) {
        return context.getString(2131236060);
    }

    public String mo1130a(Context context, int i, int i2) {
        if (i == 0) {
            return context.getString(2131236042);
        }
        return context.getString(2131236043, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public void mo1133a(boolean z) {
    }

    public static String m21346a(Context context) {
        return context.getString(BuildConstants.j ? 2131236041 : 2131236040);
    }

    public int mo1129a(UploadOperation uploadOperation) {
        String str;
        if (uploadOperation.f13763L == null) {
            str = uploadOperation.f13793p;
        } else {
            str = uploadOperation.f13763L;
        }
        return str.hashCode();
    }

    public String mo1135b(Context context, UploadOperation uploadOperation) {
        if (uploadOperation.f13795r == Type.VIDEO || uploadOperation.f13795r == Type.PROFILE_PIC || uploadOperation.f13795r == Type.COVER_PHOTO || uploadOperation.f13795r == Type.PLACE_PHOTO || uploadOperation.f13795r == Type.MENU_PHOTO || uploadOperation.f13795r == Type.PROFILE_VIDEO || uploadOperation.f13795r == Type.PRODUCT_IMAGE || uploadOperation.f13795r == Type.LIVE_VIDEO || uploadOperation.m21521Z() || uploadOperation.f13790m) {
            return context.getString(2131236046);
        }
        if (uploadOperation.aa()) {
            return context.getString(2131236047);
        }
        if (uploadOperation.f13795r == Type.PHOTO_REVIEW) {
            return context.getString(2131236050);
        }
        return context.getString(BuildConstants.j ? 2131236049 : 2131236048);
    }
}
