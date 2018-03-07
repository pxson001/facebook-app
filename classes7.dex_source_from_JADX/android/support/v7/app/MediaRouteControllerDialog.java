package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouter;
import android.support.v7.media.MediaRouter.Callback;
import android.support.v7.media.MediaRouter.RouteInfo;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: custom_cta_mobile_contact_us_tapped_ban_from_page */
public class MediaRouteControllerDialog extends Dialog {
    private final MediaRouter f16233a;
    private final MediaRouterCallback f16234b;
    public final RouteInfo f16235c;
    private boolean f16236d;
    public Drawable f16237e;
    public Drawable f16238f;
    private Drawable f16239g;
    public boolean f16240h;
    private LinearLayout f16241i;
    public SeekBar f16242j;
    public boolean f16243k;
    private View f16244l;
    private Button f16245m;

    /* compiled from: custom_cta_mobile_contact_us_tapped_ban_from_page */
    class C12831 implements OnSeekBarChangeListener {
        final /* synthetic */ MediaRouteControllerDialog f16229a;
        private final Runnable f16230b = new C12821(this);

        /* compiled from: custom_cta_mobile_contact_us_tapped_ban_from_page */
        class C12821 implements Runnable {
            final /* synthetic */ C12831 f16228a;

            C12821(C12831 c12831) {
                this.f16228a = c12831;
            }

            public void run() {
                if (this.f16228a.f16229a.f16243k) {
                    this.f16228a.f16229a.f16243k = false;
                    this.f16228a.f16229a.m20283d();
                }
            }
        }

        C12831(MediaRouteControllerDialog mediaRouteControllerDialog) {
            this.f16229a = mediaRouteControllerDialog;
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            if (this.f16229a.f16243k) {
                this.f16229a.f16242j.removeCallbacks(this.f16230b);
            } else {
                this.f16229a.f16243k = true;
            }
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            this.f16229a.f16242j.postDelayed(this.f16230b, 250);
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                this.f16229a.f16235c.m20372a(i);
            }
        }
    }

    /* compiled from: custom_cta_mobile_contact_us_tapped_ban_from_page */
    class C12842 implements OnClickListener {
        final /* synthetic */ MediaRouteControllerDialog f16231a;

        C12842(MediaRouteControllerDialog mediaRouteControllerDialog) {
            this.f16231a = mediaRouteControllerDialog;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1110463947);
            if (this.f16231a.f16235c.m20376f()) {
                MediaRouter.m20386b().m20378n();
            }
            this.f16231a.dismiss();
            Logger.a(2, EntryType.UI_INPUT_END, 1425437015, a);
        }
    }

    /* compiled from: custom_cta_mobile_contact_us_tapped_ban_from_page */
    final class MediaRouterCallback extends Callback {
        final /* synthetic */ MediaRouteControllerDialog f16232a;

        public MediaRouterCallback(MediaRouteControllerDialog mediaRouteControllerDialog) {
            this.f16232a = mediaRouteControllerDialog;
        }

        public final void mo1245a() {
            this.f16232a.m20283d();
        }

        public final void mo1250b(MediaRouter mediaRouter) {
            this.f16232a.m20283d();
        }

        public final void mo1253b(MediaRouter mediaRouter, RouteInfo routeInfo) {
            if (routeInfo == this.f16232a.f16235c) {
                this.f16232a.m20283d();
            }
        }
    }

    public MediaRouteControllerDialog(Context context) {
        this(context, 0);
    }

    private MediaRouteControllerDialog(Context context, int i) {
        super(MediaRouterThemeHelper.m20289a(context, true), i);
        this.f16240h = true;
        this.f16233a = MediaRouter.m20380a(getContext());
        this.f16234b = new MediaRouterCallback(this);
        this.f16235c = MediaRouter.m20387c();
    }

    public View m20284a() {
        return null;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().requestFeature(3);
        setContentView(2130905307);
        this.f16241i = (LinearLayout) findViewById(2131563936);
        this.f16242j = (SeekBar) findViewById(2131563937);
        this.f16242j.setOnSeekBarChangeListener(new C12831(this));
        this.f16245m = (Button) findViewById(2131563939);
        this.f16245m.setOnClickListener(new C12842(this));
        this.f16236d = true;
        if (m20283d()) {
            this.f16244l = m20284a();
            FrameLayout frameLayout = (FrameLayout) findViewById(2131563931);
            if (this.f16244l != null) {
                frameLayout.addView(this.f16244l);
                frameLayout.setVisibility(0);
                return;
            }
            frameLayout.setVisibility(8);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f16233a.m20390a(MediaRouteSelector.f16268a, this.f16234b, 2);
        m20283d();
    }

    public void onDetachedFromWindow() {
        this.f16233a.m20391a(this.f16234b);
        super.onDetachedFromWindow();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 25 && i != 24) {
            return super.onKeyDown(i, keyEvent);
        }
        int i2;
        RouteInfo routeInfo = this.f16235c;
        if (i == 25) {
            i2 = -1;
        } else {
            i2 = 1;
        }
        routeInfo.m20375b(i2);
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 25 || i == 24) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public static boolean m20282b(MediaRouteControllerDialog mediaRouteControllerDialog) {
        if (!mediaRouteControllerDialog.f16235c.m20376f() || mediaRouteControllerDialog.f16235c.m20377g()) {
            mediaRouteControllerDialog.dismiss();
            return false;
        }
        Drawable drawable;
        mediaRouteControllerDialog.setTitle(mediaRouteControllerDialog.f16235c.f16307d);
        mediaRouteControllerDialog.m20283d();
        if (mediaRouteControllerDialog.f16235c.f16310g) {
            if (mediaRouteControllerDialog.f16237e == null) {
                mediaRouteControllerDialog.f16237e = MediaRouterThemeHelper.m20290b(mediaRouteControllerDialog.getContext(), 2130773717);
            }
            drawable = mediaRouteControllerDialog.f16237e;
        } else {
            if (mediaRouteControllerDialog.f16238f == null) {
                mediaRouteControllerDialog.f16238f = MediaRouterThemeHelper.m20290b(mediaRouteControllerDialog.getContext(), 2130773718);
            }
            drawable = mediaRouteControllerDialog.f16238f;
        }
        Drawable drawable2 = drawable;
        if (drawable2 == mediaRouteControllerDialog.f16239g) {
            return true;
        }
        mediaRouteControllerDialog.f16239g = drawable2;
        drawable2.setVisible(false, true);
        mediaRouteControllerDialog.getWindow().setFeatureDrawable(3, drawable2);
        return true;
    }

    private void m20283d() {
        if (!this.f16243k) {
            Object obj = 1;
            if (!(this.f16240h && this.f16235c.f16314k == 1)) {
                obj = null;
            }
            if (obj != null) {
                this.f16241i.setVisibility(0);
                this.f16242j.setMax(this.f16235c.f16316m);
                this.f16242j.setProgress(this.f16235c.f16315l);
                return;
            }
            this.f16241i.setVisibility(8);
        }
    }
}
