package com.facebook.base.activity;

import android.content.Context;
import android.view.LayoutInflater.Factory;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: survey_ready */
public class FactoryMethodAutoProvider extends AbstractProvider<Factory> {
    public static Factory m6192b(InjectorLike injectorLike) {
        injectorLike.getInstance(Context.class);
        return null;
    }

    public Object get() {
        getInstance(Context.class);
        return null;
    }
}
