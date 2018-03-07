package com.facebook.ipc.legacykeyvalue;

import android.net.Uri;
import com.facebook.common.build.BuildConstants;

/* compiled from: get_open_graph_url */
public class UserValuesContract {
    public static final String f11070a = (BuildConstants.n() + ".provider.UserValuesProvider");
    public static final Uri f11071b = Uri.parse("content://" + f11070a + "/user_values");
    public static final Uri f11072c = Uri.parse("content://" + f11070a + "/user_values" + "/name");
}
