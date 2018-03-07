package com.facebook.katana.app.module;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.languages.switchercommonex.PersistentLocale;
import java.util.Locale;

/* compiled from: timeline_delete_info_request */
public class LocaleMethodAutoProvider extends AbstractProvider<Locale> {
    public static Locale m4768b(InjectorLike injectorLike) {
        return MainProcessModule.m4787a(PersistentLocale.m4769a(injectorLike));
    }

    public Object get() {
        return MainProcessModule.m4787a(PersistentLocale.m4769a((InjectorLike) this));
    }
}
