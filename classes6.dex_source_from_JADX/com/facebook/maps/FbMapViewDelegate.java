package com.facebook.maps;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.android.maps.FacebookMap;
import com.facebook.android.maps.FacebookMapOptions;
import com.facebook.android.maps.ReportButtonDrawable;
import com.facebook.fbui.draggable.HorizontalScrollInterceptingView;
import com.facebook.inject.FbInjector;
import com.facebook.iorg.common.upsell.ui.FbZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController.Listener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.delegate.MapViewDelegate;
import com.facebook.maps.delegate.OnMapReadyDelegateCallback;
import com.facebook.maps.report.FbMapReporterLauncher;
import com.facebook.resources.ui.FbTextView;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import java.util.LinkedList;
import javax.inject.Inject;

/* compiled from: zero_extra_charges_dialog_cancel */
public class FbMapViewDelegate extends MapViewDelegate implements HorizontalScrollInterceptingView {
    @Inject
    FbMapInitializer f158c;
    @Inject
    FbMapReporterLauncher f159d;
    @Inject
    ZeroDialogController f160e;
    private LinkedList<OnMapReadyDelegateCallback> f161f;
    private Bundle f162g;
    public ZeroFeatureKey f163h;
    public FragmentManager f164i;
    private FbTextView f165j;

    /* compiled from: zero_extra_charges_dialog_cancel */
    class C00231 implements OnClickListener {
        final /* synthetic */ FbMapViewDelegate f149a;

        /* compiled from: zero_extra_charges_dialog_cancel */
        class C00221 implements Listener {
            final /* synthetic */ C00231 f148a;

            C00221(C00231 c00231) {
                this.f148a = c00231;
            }

            public final void m112a(Object obj) {
                FbMapViewDelegate.setZeroRatingEnabled(this.f148a.f149a, false);
            }

            public final void m111a() {
            }
        }

        C00231(FbMapViewDelegate fbMapViewDelegate) {
            this.f149a = fbMapViewDelegate;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1411329181);
            this.f149a.f160e.a(this.f149a.f163h, this.f149a.getResources().getString(2131232927), new C00221(this));
            this.f149a.f160e.a(this.f149a.f163h, this.f149a.f164i);
            Logger.a(2, EntryType.UI_INPUT_END, -1277349847, a);
        }
    }

    private static <T extends View> void m124a(Class<T> cls, T t) {
        m125a((Object) t, t.getContext());
    }

    private static void m125a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FbMapViewDelegate) obj).m122a(FbMapInitializer.m109b(fbInjector), FbMapReporterLauncher.a(fbInjector), (ZeroDialogController) FbZeroDialogController.b(fbInjector));
    }

    public FbMapViewDelegate(Context context) {
        super(context);
        m127e();
    }

    public FbMapViewDelegate(Context context, FacebookMapOptions facebookMapOptions) {
        super(context, facebookMapOptions);
        m127e();
    }

    public FbMapViewDelegate(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m127e();
    }

    private void m127e() {
        m124a(FbMapViewDelegate.class, (View) this);
        if (this.f150a == 2) {
            this.a = 0;
        }
        this.f158c.m110a();
    }

    public final void mo4a(OnMapReadyDelegateCallback onMapReadyDelegateCallback) {
        if (this.f163h == null || isEnabled()) {
            super.mo4a(onMapReadyDelegateCallback);
            return;
        }
        if (this.f161f == null) {
            this.f161f = new LinkedList();
        }
        this.f161f.add(onMapReadyDelegateCallback);
    }

    private void m122a(FbMapInitializer fbMapInitializer, FbMapReporterLauncher fbMapReporterLauncher, ZeroDialogController zeroDialogController) {
        this.f158c = fbMapInitializer;
        this.f159d = fbMapReporterLauncher;
        this.f160e = zeroDialogController;
    }

    public static void setZeroRatingEnabled(FbMapViewDelegate fbMapViewDelegate, boolean z) {
        if (!z || fbMapViewDelegate.f163h == null) {
            fbMapViewDelegate.m115a(fbMapViewDelegate.f162g);
            fbMapViewDelegate.setEnabled(true);
            if (fbMapViewDelegate.f165j != null) {
                fbMapViewDelegate.f165j.setVisibility(8);
            }
            if (fbMapViewDelegate.f161f != null) {
                while (true) {
                    OnMapReadyDelegateCallback onMapReadyDelegateCallback = (OnMapReadyDelegateCallback) fbMapViewDelegate.f161f.poll();
                    if (onMapReadyDelegateCallback == null) {
                        break;
                    }
                    fbMapViewDelegate.mo4a(onMapReadyDelegateCallback);
                }
            }
            fbMapViewDelegate.f161f = null;
            return;
        }
        fbMapViewDelegate.setEnabled(false);
        if (fbMapViewDelegate.f165j == null) {
            fbMapViewDelegate.f165j = fbMapViewDelegate.m128f();
            fbMapViewDelegate.f165j.setOnClickListener(new C00231(fbMapViewDelegate));
            fbMapViewDelegate.addView(fbMapViewDelegate.f165j, -1, -1);
        }
        fbMapViewDelegate.f165j.setVisibility(0);
    }

    protected final ReportButtonDrawable mo3a(FacebookMap facebookMap) {
        return new ReportButtonDrawable(facebookMap, this.f151b, this.f159d, getResources().getString(2131230962));
    }

    public void setMapSource(int i) {
        this.f150a = i;
    }

    private FbTextView m128f() {
        FbTextView fbTextView = new FbTextView(getContext());
        Resources resources = getResources();
        fbTextView.setText(resources.getText(2131230960));
        fbTextView.setTextColor(-9801344);
        fbTextView.setTextSize(0, resources.getDimension(2131427408));
        fbTextView.setTypeface(fbTextView.getTypeface(), 1);
        fbTextView.setBackgroundResource(2130843367);
        fbTextView.setGravity(17);
        return fbTextView;
    }
}
