package com.facebook.greetingcards.render;

import android.os.Build.VERSION;
import android.view.Window;

/* compiled from: xma_query_id */
public class StatusBarVisibilityController {
    private final Window f221a;

    public StatusBarVisibilityController(Window window) {
        this.f221a = window;
    }

    public final void m266a() {
        if (VERSION.SDK_INT >= 19) {
            this.f221a.getDecorView().setSystemUiVisibility(5894);
            return;
        }
        this.f221a.clearFlags(2048);
        this.f221a.setFlags(1024, 1024);
    }

    public final void m267b() {
        if (VERSION.SDK_INT >= 19) {
            this.f221a.getDecorView().setSystemUiVisibility(0);
            return;
        }
        this.f221a.clearFlags(1024);
        this.f221a.setFlags(2048, 2048);
    }
}
