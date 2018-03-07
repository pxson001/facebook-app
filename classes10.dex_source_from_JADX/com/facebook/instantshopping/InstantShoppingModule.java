package com.facebook.instantshopping;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.instantshopping.annotations.ForInstantShopping;
import com.facebook.instantshopping.view.transition.InstantShoppingTransitionStrategyFactory;
import com.facebook.richdocument.view.transition.TransitionStrategyFactory;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: StartLoad */
public class InstantShoppingModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    @ForInstantShopping
    static TransitionStrategyFactory m24784a() {
        return new InstantShoppingTransitionStrategyFactory();
    }
}
