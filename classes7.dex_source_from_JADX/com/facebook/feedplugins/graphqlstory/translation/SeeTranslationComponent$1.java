package com.facebook.feedplugins.graphqlstory.translation;

import com.facebook.components.EventHandler;

/* compiled from: Save Button is binded without a target object. */
class SeeTranslationComponent$1 implements Runnable {
    final /* synthetic */ EventHandler f23448a;
    final /* synthetic */ Object f23449b;
    final /* synthetic */ SeeTranslationComponent f23450c;

    SeeTranslationComponent$1(SeeTranslationComponent seeTranslationComponent, EventHandler eventHandler, Object obj) {
        this.f23450c = seeTranslationComponent;
        this.f23448a = eventHandler;
        this.f23449b = obj;
    }

    public void run() {
        this.f23450c.a(this.f23448a, this.f23449b);
    }
}
