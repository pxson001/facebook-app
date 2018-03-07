package com.facebook.katana.login;

import android.content.Context;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: task_key_toggle_post_like */
public class Boolean_UseAuthLoginMethodAutoProvider extends AbstractProvider<Boolean> {
    public static Boolean m1514b(InjectorLike injectorLike) {
        injectorLike.getInstance(Context.class);
        return Fb4aLoginModule.b();
    }

    public Object get() {
        getInstance(Context.class);
        return Fb4aLoginModule.b();
    }
}
