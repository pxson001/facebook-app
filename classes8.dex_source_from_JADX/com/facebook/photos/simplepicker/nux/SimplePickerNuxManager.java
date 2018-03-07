package com.facebook.photos.simplepicker.nux;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import com.facebook.inject.Assisted;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.photos.simplepicker.controller.SimplePickerSlideshowEntrypointController;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: set_friend_requests_audience */
public class SimplePickerNuxManager {
    private static final InterstitialTrigger f3200a = new InterstitialTrigger(Action.PHOTO_PICKER);
    private static final InterstitialTrigger f3201b = new InterstitialTrigger(Action.PHOTO_PICKER_DETECTED_RECENT_VIDEO);
    public final Context f3202c;
    public final InterstitialManager f3203d;
    public final View f3204e;
    public final boolean f3205f;
    public final boolean f3206g;
    public final int f3207h;
    public final boolean f3208i;
    public final int f3209j;
    public final SimplePickerSlideshowEntrypointController f3210k;
    public final String f3211l;
    private SimplePickerNux f3212m;
    public SimplePickerSouvenirInterstitialController f3213n;
    public SimplePickerMultimediaInterstitialController f3214o;
    public SimplePickerSlideshowInterstitialController f3215p;
    public SimplePickerHDUploadInterstitialController f3216q;

    @Inject
    public SimplePickerNuxManager(Context context, InterstitialManager interstitialManager, @Assisted View view, @Assisted boolean z, @Assisted boolean z2, @Assisted int i, @Assisted boolean z3, @Assisted int i2, @Nullable @Assisted SimplePickerSlideshowEntrypointController simplePickerSlideshowEntrypointController, @Assisted String str) {
        this.f3202c = context;
        this.f3203d = interstitialManager;
        this.f3205f = z;
        this.f3204e = view;
        this.f3206g = z2;
        this.f3207h = i;
        this.f3208i = z3;
        this.f3209j = i2;
        this.f3210k = simplePickerSlideshowEntrypointController;
        this.f3211l = str;
    }

    public final void m3184c() {
        if (this.f3212m == null) {
            this.f3212m = (SimplePickerNux) this.f3203d.a(f3201b, SimplePickerNux.class);
            if (this.f3212m != null) {
                this.f3203d.a().a(this.f3212m.b());
                this.f3212m.e();
            }
        }
    }

    public final void m3183a() {
        this.f3213n = (SimplePickerSouvenirInterstitialController) this.f3203d.a("3993", SimplePickerSouvenirInterstitialController.class);
        SimplePickerSouvenirInterstitialController simplePickerSouvenirInterstitialController = this.f3213n;
        View view = this.f3204e;
        boolean z = this.f3206g;
        int i = this.f3207h;
        String str = this.f3211l;
        simplePickerSouvenirInterstitialController.b.a(SimplePickerInterstitialControllers.forControllerClass(simplePickerSouvenirInterstitialController.getClass()).prefKey);
        simplePickerSouvenirInterstitialController.g = z;
        if (simplePickerSouvenirInterstitialController.g) {
            simplePickerSouvenirInterstitialController.d = view;
            View findViewById = simplePickerSouvenirInterstitialController.d.findViewById(2131567470);
            if (findViewById == null) {
                findViewById = ((ViewStub) simplePickerSouvenirInterstitialController.d.findViewById(2131567469)).inflate();
            }
            simplePickerSouvenirInterstitialController.f = findViewById.findViewById(2131567549);
            simplePickerSouvenirInterstitialController.e = findViewById.findViewById(2131567548);
            Display defaultDisplay = ((WindowManager) simplePickerSouvenirInterstitialController.a.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            int i2 = i + ((int) (((float) point.x) * 0.55f));
            int dimensionPixelSize = i2 - simplePickerSouvenirInterstitialController.a.getResources().getDimensionPixelSize(2131429469);
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) simplePickerSouvenirInterstitialController.f.getLayoutParams();
            ((MarginLayoutParams) simplePickerSouvenirInterstitialController.e.getLayoutParams()).setMargins(0, i2, 0, 0);
            marginLayoutParams.setMargins(0, dimensionPixelSize, 0, 0);
            simplePickerSouvenirInterstitialController.h.c = str;
        }
        this.f3214o = (SimplePickerMultimediaInterstitialController) this.f3203d.a("3883", SimplePickerMultimediaInterstitialController.class);
        SimplePickerMultimediaInterstitialController simplePickerMultimediaInterstitialController = this.f3214o;
        view = this.f3204e;
        simplePickerMultimediaInterstitialController.e = this.f3205f;
        simplePickerMultimediaInterstitialController.b.a(SimplePickerInterstitialControllers.forControllerClass(simplePickerMultimediaInterstitialController.getClass()).prefKey);
        simplePickerMultimediaInterstitialController.d = view.findViewById(2131558756);
        this.f3215p = (SimplePickerSlideshowInterstitialController) this.f3203d.a("4194", SimplePickerSlideshowInterstitialController.class);
        SimplePickerSlideshowInterstitialController simplePickerSlideshowInterstitialController = this.f3215p;
        boolean z2 = this.f3208i;
        int i3 = this.f3209j;
        SimplePickerSlideshowEntrypointController simplePickerSlideshowEntrypointController = this.f3210k;
        str = this.f3211l;
        simplePickerSlideshowInterstitialController.f3220b.a(SimplePickerInterstitialControllers.forControllerClass(simplePickerSlideshowInterstitialController.getClass()).prefKey);
        simplePickerSlideshowInterstitialController.f3223e = z2;
        simplePickerSlideshowInterstitialController.f3225g = simplePickerSlideshowEntrypointController;
        simplePickerSlideshowInterstitialController.f3224f = i3;
        simplePickerSlideshowInterstitialController.f3221c.f9007b = str;
        this.f3216q = (SimplePickerHDUploadInterstitialController) this.f3203d.a("4169", SimplePickerHDUploadInterstitialController.class);
        SimplePickerHDUploadInterstitialController simplePickerHDUploadInterstitialController = this.f3216q;
        Context context = this.f3202c;
        View view2 = this.f3204e;
        simplePickerHDUploadInterstitialController.f3195e = context;
        simplePickerHDUploadInterstitialController.f3196f = view2;
        simplePickerHDUploadInterstitialController.f3193c.a(SimplePickerInterstitialControllers.forControllerClass(simplePickerHDUploadInterstitialController.getClass()).prefKey);
        this.f3212m = (SimplePickerNux) this.f3203d.a(f3200a, SimplePickerNux.class);
        if (this.f3212m != null) {
            this.f3203d.a().a(this.f3212m.b());
            this.f3212m.e();
        }
    }
}
