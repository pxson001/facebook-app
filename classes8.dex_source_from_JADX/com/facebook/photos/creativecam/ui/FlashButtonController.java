package com.facebook.photos.creativecam.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.optic.CameraDevice;
import com.facebook.photos.creativecam.activity.CreativeEditingCameraFragment.11;
import com.facebook.photos.creativecam.activity.CreativeEditingCameraFragment.12;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: startTime cannot be negative or NaN. */
public class FlashButtonController {
    public final MultiStateToggleImageButton f2249a;
    public final 11 f2250b;
    public final 12 f2251c;
    public boolean f2252d;

    /* compiled from: startTime cannot be negative or NaN. */
    class C02701 implements OnClickListener {
        final /* synthetic */ FlashButtonController f2248a;

        C02701(FlashButtonController flashButtonController) {
            this.f2248a = flashButtonController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1545856335);
            12 12 = this.f2248a.f2251c;
            String currentStateId = this.f2248a.f2249a.getCurrentStateId();
            if (CameraDevice.b.e()) {
                12.a.az.f2170c.setFlashMode(currentStateId);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 781195942, a);
        }
    }

    @Inject
    public FlashButtonController(@Assisted 11 11, @Assisted 12 12, @Assisted MultiStateToggleImageButton multiStateToggleImageButton, @Assisted Boolean bool) {
        this.f2250b = 11;
        this.f2251c = 12;
        this.f2249a = multiStateToggleImageButton;
        this.f2252d = ((Boolean) Preconditions.checkNotNull(bool)).booleanValue();
        this.f2249a.setOnClickListener(new C02701(this));
    }
}
