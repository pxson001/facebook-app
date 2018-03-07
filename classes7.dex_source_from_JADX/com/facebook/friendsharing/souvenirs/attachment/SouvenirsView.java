package com.facebook.friendsharing.souvenirs.attachment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.drawable.FadeDrawable;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.friendsharing.souvenirs.models.SouvenirMetadata;
import com.facebook.friendsharing.souvenirs.models.SouvenirModel;
import com.facebook.friendsharing.souvenirs.util.SouvenirModelHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Report Spam from Feed */
public class SouvenirsView extends CustomFrameLayout {
    @Inject
    public Lazy<FbNetworkManager> f24006a;
    @Inject
    public SouvenirPlaceholderTitleGenerator f24007b;
    @Inject
    public SouvenirTitleUtil f24008c;
    private final ImageView f24009d;
    private final TextView f24010e;
    private final TextView f24011f;
    public final Handler f24012g;
    private final float f24013h;
    public Float f24014i;
    public Float f24015j;
    public Float f24016k;
    @Nullable
    public SouvenirsViewState f24017l;
    @Nullable
    public Timer f24018m;
    @Nullable
    public TimerTask f24019n;
    public int f24020o;
    public int f24021p;
    public int f24022q;
    public int f24023r;
    public final Runnable f24024s;

    /* compiled from: Report Spam from Feed */
    class C20791 implements Runnable {
        final /* synthetic */ SouvenirsView f24004a;

        C20791(SouvenirsView souvenirsView) {
            this.f24004a = souvenirsView;
        }

        public void run() {
            SouvenirsView souvenirsView = this.f24004a;
            FadeDrawable fadeDrawable = (FadeDrawable) Preconditions.checkNotNull(souvenirsView.f24017l.f24032h);
            fadeDrawable.b();
            int i;
            if (souvenirsView.f24022q < souvenirsView.f24017l.m26123b()) {
                fadeDrawable.a = 0;
                Arrays.fill(fadeDrawable.g, false);
                fadeDrawable.invalidateSelf();
                fadeDrawable.d(Math.max(0, souvenirsView.f24022q - 1));
                i = souvenirsView.f24022q;
                souvenirsView.f24022q = i + 1;
                fadeDrawable.d(i);
            } else {
                fadeDrawable.e(Math.max(0, souvenirsView.f24022q - 2));
                fadeDrawable.g();
                souvenirsView.f24022q = 0;
                i = souvenirsView.f24022q;
                souvenirsView.f24022q = i + 1;
                fadeDrawable.f(i);
            }
            fadeDrawable.c();
            if (souvenirsView.f24017l != null && !((FbNetworkManager) souvenirsView.f24006a.get()).g() && !((FbNetworkManager) souvenirsView.f24006a.get()).h() && souvenirsView.f24021p > souvenirsView.f24017l.m26123b()) {
                int i2 = souvenirsView.f24020o + 1;
                souvenirsView.f24020o = i2;
                if (i2 >= souvenirsView.f24021p) {
                    souvenirsView.f24020o = 0;
                }
                i2 = souvenirsView.f24023r + 1;
                souvenirsView.f24023r = i2;
                if (i2 >= souvenirsView.f24017l.m26123b()) {
                    souvenirsView.f24023r = 0;
                } else if (souvenirsView.f24023r < 0) {
                    return;
                }
                souvenirsView.f24017l.m26121a(souvenirsView.f24020o, souvenirsView.f24023r);
                DraweeHolder b = souvenirsView.f24017l.f24028d.b(souvenirsView.f24023r);
                DraweeController[] draweeControllerArr = souvenirsView.f24017l.f24027c;
                ((AbstractDraweeController) b.f).b();
                b.a(draweeControllerArr[souvenirsView.f24023r]);
            }
        }
    }

    /* compiled from: Report Spam from Feed */
    public class C20802 extends TimerTask {
        final /* synthetic */ SouvenirsView f24005a;

        public C20802(SouvenirsView souvenirsView) {
            this.f24005a = souvenirsView;
        }

        public void run() {
            HandlerDetour.a(this.f24005a.f24012g, this.f24005a.f24024s, 2064531148);
        }
    }

    public static void m26118a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        SouvenirsView souvenirsView = (SouvenirsView) obj;
        Lazy b = IdBasedSingletonScopeProvider.b(fbInjector, 585);
        SouvenirPlaceholderTitleGenerator b2 = SouvenirPlaceholderTitleGenerator.b(fbInjector);
        SouvenirTitleUtil souvenirTitleUtil = new SouvenirTitleUtil(ResourcesMethodAutoProvider.a(fbInjector));
        souvenirsView.f24006a = b;
        souvenirsView.f24007b = b2;
        souvenirsView.f24008c = souvenirTitleUtil;
    }

    public SouvenirsView(Context context) {
        this(context, null, 0);
    }

    private SouvenirsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f24024s = new C20791(this);
        Class cls = SouvenirsView.class;
        m26118a(this, getContext());
        this.f24012g = new Handler(Looper.getMainLooper());
        this.f24013h = getResources().getDisplayMetrics().density;
        setContentView(2130907167);
        this.f24009d = (ImageView) c(2131567529);
        this.f24010e = (TextView) c(2131567531);
        this.f24011f = (TextView) c(2131567532);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        Preconditions.checkNotNull(this.f24014i);
        int round = Math.round(((float) measuredWidth) * this.f24014i.floatValue());
        if (round > measuredHeight) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), MeasureSpec.makeMeasureSpec(round, 1073741824));
        }
    }

    private void setTitle(@Nullable SouvenirModel souvenirModel) {
        if (souvenirModel == null) {
            this.f24010e.setText(null);
            return;
        }
        SouvenirMetadata a = souvenirModel.a();
        CharSequence b = a.m26170b();
        if (b == null) {
            b = this.f24007b.a(a.m26171c(), a.m26172d());
        }
        this.f24010e.setText(b);
        Preconditions.checkNotNull(this.f24015j);
        this.f24010e.setTextSize(this.f24015j.floatValue() / this.f24013h);
    }

    private void setSubTitle(@Nullable SouvenirModel souvenirModel) {
        if (souvenirModel == null) {
            this.f24011f.setText(null);
            return;
        }
        String str;
        TextView textView = this.f24011f;
        SouvenirTitleUtil souvenirTitleUtil = this.f24008c;
        int size = souvenirModel.b().size();
        if (size <= 0) {
            str = null;
        } else {
            int b = Iterators.b(SouvenirModelHelper.m26457b(souvenirModel));
            int i = size - b;
            if (b <= 0 || i <= 0) {
                if (b > 0) {
                    b = 2131689709;
                } else {
                    b = 2131689710;
                }
                str = souvenirTitleUtil.f24003a.getQuantityString(b, size, new Object[]{Integer.valueOf(size)});
            } else {
                str = souvenirTitleUtil.f24003a.getString(2131238444, new Object[]{Integer.valueOf(size)});
            }
        }
        textView.setText(str);
        Preconditions.checkNotNull(this.f24016k);
        this.f24011f.setTextSize(this.f24016k.floatValue() / this.f24013h);
    }

    public final void m26120a(SouvenirsViewState souvenirsViewState) {
        this.f24017l = souvenirsViewState;
        this.f24021p = this.f24017l.f24029e.size();
        setOnClickListener(this.f24017l.f24026b);
        setVisibility(0);
        SouvenirModel souvenirModel = this.f24017l.f24025a;
        setTitle(souvenirModel);
        setSubTitle(souvenirModel);
        this.f24022q = 0;
        if (this.f24017l.f24027c.length > 0) {
            this.f24009d.setImageDrawable((Drawable) Preconditions.checkNotNull(this.f24017l.f24033i));
            this.f24020o = souvenirsViewState.m26123b() - 1;
            this.f24023r = -3;
            if (souvenirsViewState.m26123b() > 1 && this.f24019n == null) {
                this.f24019n = new C20802(this);
                this.f24018m = new Timer();
                this.f24018m.schedule(this.f24019n, 0, 2000);
            }
        }
    }

    public final void m26119a() {
        if (this.f24018m != null) {
            this.f24018m.cancel();
            this.f24018m.purge();
            this.f24018m = null;
        }
        this.f24012g.removeCallbacksAndMessages(null);
        this.f24019n = null;
        setVisibility(8);
        setTitle(null);
        setSubTitle(null);
        setOnClickListener(null);
        ((SouvenirsViewState) Preconditions.checkNotNull(this.f24017l)).f24028d.b();
        this.f24017l = null;
        this.f24021p = 0;
        this.f24022q = 0;
        this.f24023r = 0;
        this.f24020o = 0;
    }

    public void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -494997209);
        super.onAttachedToWindow();
        if (this.f24017l != null) {
            this.f24017l.f24028d.a();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1253015931, a);
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.f24017l != null) {
            this.f24017l.f24028d.a();
        }
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.f24017l != null) {
            this.f24017l.f24028d.b();
        }
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -797452863);
        super.onDetachedFromWindow();
        if (this.f24017l != null) {
            this.f24017l.f24028d.b();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 2140150748, a);
    }
}
