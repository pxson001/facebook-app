package com.facebook.android.maps;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import com.facebook.android.maps.MapReporterLauncher.DialogBuilder;

/* compiled from: b0 */
public class MapReporterLauncher$5 implements DialogBuilder {
    final /* synthetic */ MapReporterLauncher f8178a;
    private final Builder f8179b = new Builder(this.f8178a.b);

    public MapReporterLauncher$5(MapReporterLauncher mapReporterLauncher) {
        this.f8178a = mapReporterLauncher;
    }

    public final DialogBuilder m14315a(CharSequence charSequence) {
        this.f8179b.setMessage(charSequence);
        return this;
    }

    public final DialogBuilder m14316a(CharSequence charSequence, OnClickListener onClickListener) {
        this.f8179b.setPositiveButton(charSequence, onClickListener);
        return this;
    }

    public final DialogBuilder m14317b(CharSequence charSequence, OnClickListener onClickListener) {
        this.f8179b.setNegativeButton(charSequence, onClickListener);
        return this;
    }

    public final Dialog m14314a() {
        return this.f8179b.create();
    }
}
