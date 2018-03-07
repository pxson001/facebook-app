package com.facebook.ipc.userstatus;

import android.net.Uri;
import com.facebook.common.build.BuildConstants;

/* compiled from: zero_version */
public class UserStatusContract {
    public static final String f283a = (BuildConstants.n() + ".provider.UserStatusesProvider");
    public static final Uri f284b = Uri.parse("content://" + f283a + "/clear_all_data");
}
