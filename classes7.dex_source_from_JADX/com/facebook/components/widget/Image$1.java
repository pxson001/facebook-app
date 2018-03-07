package com.facebook.components.widget;

import com.facebook.components.EventHandler;

/* compiled from: transliterator_dictionary_load_failed */
class Image$1 implements Runnable {
    final /* synthetic */ EventHandler f1240a;
    final /* synthetic */ Object f1241b;
    final /* synthetic */ Image f1242c;

    Image$1(Image image, EventHandler eventHandler, Object obj) {
        this.f1242c = image;
        this.f1240a = eventHandler;
        this.f1241b = obj;
    }

    public void run() {
        this.f1242c.a(this.f1240a, this.f1241b);
    }
}
