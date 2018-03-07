package com.facebook.backstage.camera;

import android.app.Activity;
import android.view.ViewGroup;
import com.facebook.backstage.consumption.BackstageLifeCycleHelper;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: search_null_state */
public class CameraHolderProvider extends AbstractAssistedProvider<CameraHolder> {
    public static CameraHolder m4323a(Activity activity, ViewGroup viewGroup, BackstageLifeCycleHelper backstageLifeCycleHelper) {
        return new CameraHolder(activity, viewGroup, backstageLifeCycleHelper);
    }
}
