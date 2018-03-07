package com.facebook.rebound;

import android.os.Build.VERSION;
import android.os.Handler;
import android.view.Choreographer;
import com.facebook.rebound.AndroidSpringLooperFactory.ChoreographerAndroidSpringLooper;
import com.facebook.rebound.AndroidSpringLooperFactory.LegacyAndroidSpringLooper;

/* compiled from: f6cccb71f74a7b8d8e5126126bf30c5f */
public class SpringSystem extends BaseSpringSystem {
    public static SpringSystem m23059b() {
        SpringLooper choreographerAndroidSpringLooper;
        if (VERSION.SDK_INT >= 16) {
            choreographerAndroidSpringLooper = new ChoreographerAndroidSpringLooper(Choreographer.getInstance());
        } else {
            choreographerAndroidSpringLooper = new LegacyAndroidSpringLooper(new Handler());
        }
        return new SpringSystem(choreographerAndroidSpringLooper);
    }

    private SpringSystem(SpringLooper springLooper) {
        super(springLooper);
    }
}
