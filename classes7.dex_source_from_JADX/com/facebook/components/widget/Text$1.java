package com.facebook.components.widget;

import com.facebook.components.EventHandler;

/* compiled from: transliteration_dictionary_ */
class Text$1 implements Runnable {
    final /* synthetic */ EventHandler f1274a;
    final /* synthetic */ Object f1275b;
    final /* synthetic */ Text f1276c;

    Text$1(Text text, EventHandler eventHandler, Object obj) {
        this.f1276c = text;
        this.f1274a = eventHandler;
        this.f1275b = obj;
    }

    public void run() {
        this.f1276c.a(this.f1274a, this.f1275b);
    }
}
