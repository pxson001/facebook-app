package com.facebook.katana.app.module;

import android.content.Context;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.service.AppSession;

/* compiled from: VideoCard */
public class AppSessionMethodAutoProvider extends AbstractProvider<AppSession> {
    private static AppSession m10793b(InjectorLike injectorLike) {
        return MainProcessModule.a((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return MainProcessModule.a((Context) getInstance(Context.class));
    }
}
