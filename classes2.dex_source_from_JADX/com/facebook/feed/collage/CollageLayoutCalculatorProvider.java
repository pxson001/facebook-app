package com.facebook.feed.collage;

import android.content.Context;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: groups_new_privacy_policy */
public class CollageLayoutCalculatorProvider extends AbstractAssistedProvider<CollageLayoutCalculator> {
    public final <T extends CollageItem> CollageLayoutCalculator<T> m29258a(CollageLayoutProperties<T> collageLayoutProperties) {
        return new CollageLayoutCalculator((Context) getInstance(Context.class), collageLayoutProperties, DialtoneControllerImpl.m8272a((InjectorLike) this));
    }
}
