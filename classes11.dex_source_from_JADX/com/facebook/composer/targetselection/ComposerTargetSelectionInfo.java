package com.facebook.composer.targetselection;

import android.app.Activity;
import com.facebook.ipc.composer.model.TargetType;

/* compiled from: fetchPagesAlbumsList */
public class ComposerTargetSelectionInfo {
    public final TargetType f6946a;
    public final int f6947b;
    public final int f6948c;
    public final int f6949d;
    public final Class<? extends Activity> f6950e;

    public ComposerTargetSelectionInfo(TargetType targetType, int i, int i2, int i3, Class<? extends Activity> cls) {
        this.f6946a = targetType;
        this.f6947b = i;
        this.f6948c = i2;
        this.f6949d = i3;
        this.f6950e = cls;
    }
}
