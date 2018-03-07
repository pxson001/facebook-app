package com.facebook.user.names;

import android.content.res.Resources;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import java.util.Locale;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: eligible_for_guardrail */
public class UserNameModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    static NameSplitter m14095a(Resources resources, Locale locale) {
        return new NameSplitter(resources.getString(2131235967), resources.getString(2131235969), resources.getString(2131235968), resources.getString(2131235970), locale);
    }
}
