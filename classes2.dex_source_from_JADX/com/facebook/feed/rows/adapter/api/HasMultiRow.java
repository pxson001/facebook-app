package com.facebook.feed.rows.adapter.api;

import android.content.res.Configuration;
import com.facebook.common.dispose.Disposable;
import com.facebook.debug.dumpsys.DumpsysDumpable;
import com.facebook.feed.rows.core.RowIdentifier;

/* compiled from: nearby_friends_selfview_action_button */
public interface HasMultiRow extends Disposable, DumpsysDumpable, HasMarkers {
    void mo2508a(Configuration configuration);

    int mo2510c(int i);

    int mo2511d(int i);

    int mo2512e();

    RowIdentifier mo2513f();

    int mo2514g(int i);

    int mo2515h(int i);

    int s_(int i);

    int t_(int i);
}
