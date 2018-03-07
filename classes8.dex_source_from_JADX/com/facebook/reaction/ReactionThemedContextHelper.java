package com.facebook.reaction;

import android.content.Context;
import android.view.ContextThemeWrapper;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.util.ReactionSurfaceUtil;

/* compiled from: browser_open_url_logger */
public class ReactionThemedContextHelper {
    public static ReactionThemedContextHelper m22628a(InjectorLike injectorLike) {
        return new ReactionThemedContextHelper();
    }

    public static Context m22627a(Context context, Surface surface) {
        int i;
        if (ReactionSurfaceUtil.m4782i(surface)) {
            i = 2131625859;
        } else if (ReactionSurfaceUtil.m4785l(surface)) {
            i = 2131626237;
        } else {
            Object obj;
            if (surface == Surface.ANDROID_EVENT_DISCOVER_EVENT_LIST || surface == Surface.ANDROID_EVENT_DISCOVER_DASHBOARD) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                i = 2131625860;
            } else {
                if (surface == Surface.ANDROID_EVENT_PERMALINK || surface == Surface.ANDROID_EVENT_PERMALINK_PRIVATE) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    i = 2131625861;
                } else if (ReactionSurfaceUtil.m4788q(surface)) {
                    i = 2131625889;
                } else {
                    if (surface == Surface.A_PLACE_FOR) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        i = 2131626233;
                    } else if (ReactionSurfaceUtil.m4787n(surface)) {
                        i = 2131626238;
                    } else {
                        i = 2131625858;
                    }
                }
            }
        }
        return new ContextThemeWrapper(context, i);
    }
}
