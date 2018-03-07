package com.facebook.backstage.consumption.nux;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.facebook.backstage.StacksConstants;
import com.facebook.backstage.analytics.BackstageAnalyticsLogger;
import com.facebook.backstage.analytics.BackstageAnalyticsLogger.Event;
import com.facebook.backstage.consumption.BackstageNavigatorApi.NavigationState;
import com.facebook.backstage.consumption.HolderListener;
import com.facebook.backstage.consumption.ScreenUtil;
import com.facebook.backstage.consumption.nux.BackstageOnboardNuxHelper.C05001;
import com.facebook.backstage.entry.BackstageOnboardInterstitialController;
import com.facebook.backstage.ui.ViewAnimator;
import com.facebook.backstage.ui.ViewAnimator.OnFinishListener;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: ride_service */
public class BackstageNuxView extends FrameLayout {
    @Inject
    public ScreenUtil f4838a;
    @Inject
    public BackstageAnalyticsLogger f4839b;
    public final View f4840c;
    public final View f4841d;
    private final View f4842e;
    private final List<View> f4843f;
    public HolderListener f4844g;
    public NuxState f4845h;
    public C05001 f4846i;

    /* compiled from: ride_service */
    class C04971 implements OnClickListener {
        final /* synthetic */ BackstageNuxView f4836a;

        C04971(BackstageNuxView backstageNuxView) {
            this.f4836a = backstageNuxView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 599346695);
            if (this.f4836a.f4845h == NuxState.FIRST_PANEL) {
                BackstageNuxView backstageNuxView = this.f4836a;
                backstageNuxView.f4845h = NuxState.SECOND_PANEL;
                backstageNuxView.f4839b.m4264a(Event.NUX_STEP_TWO_SHOWN);
                ViewAnimator e = ViewAnimator.m5752a(backstageNuxView.f4840c).m5761e();
                e.f5549z = 0;
                e = e.m5756b(0.0f, (float) (-backstageNuxView.f4840c.getWidth()));
                e.f5524A = 8;
                e.m5759d();
                e = ViewAnimator.m5752a(backstageNuxView.f4841d).m5761e();
                e.f5549z = 0;
                e = e.m5756b((float) backstageNuxView.f4838a.m4551a(), 0.0f);
                e.f5524A = 0;
                e.m5759d();
            } else if (this.f4836a.f4845h == NuxState.SECOND_PANEL) {
                View view2 = this.f4836a;
                if (view2.f4846i != null) {
                    C05001 c05001 = view2.f4846i;
                    BackstageOnboardInterstitialController backstageOnboardInterstitialController = c05001.f4852b.f4855c;
                    InterstitialManager interstitialManager = c05001.f4852b.f4854b;
                    interstitialManager.a(backstageOnboardInterstitialController);
                    interstitialManager.a().a(backstageOnboardInterstitialController.m4953b());
                    backstageOnboardInterstitialController.f5174b.edit().putBoolean(StacksConstants.f4262l, false).commit();
                    backstageOnboardInterstitialController.f5174b.edit().putBoolean(StacksConstants.f4263m, false).commit();
                    c05001.f4851a.m4492a(NavigationState.COLD_START, NavigationState.AUDIENCE_CONTROL);
                }
                OnFinishListener c04982 = new C04982(view2);
                view2.f4845h = NuxState.COMPLETE;
                ViewAnimator e2 = ViewAnimator.m5752a(view2).m5761e();
                e2.f5549z = 0;
                e2 = e2.m5756b(0.0f, (float) (-view2.getWidth()));
                e2.f5528e = c04982;
                e2.m5759d();
            }
            LogUtils.a(573493352, a);
        }
    }

    /* compiled from: ride_service */
    public class C04982 implements OnFinishListener {
        final /* synthetic */ BackstageNuxView f4837a;

        public C04982(BackstageNuxView backstageNuxView) {
            this.f4837a = backstageNuxView;
        }

        public final void mo142a() {
            BackstageNuxView.m4729e(this.f4837a);
            this.f4837a.setVisibility(8);
            this.f4837a.f4839b.m4264a(Event.NUX_COMPLETE);
            if (this.f4837a.f4844g != null) {
                this.f4837a.f4844g.mo143a();
            }
        }
    }

    /* compiled from: ride_service */
    public enum NuxState {
        FIRST_PANEL,
        SECOND_PANEL,
        COMPLETE
    }

    public static void m4728a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        BackstageNuxView backstageNuxView = (BackstageNuxView) obj;
        ScreenUtil a = ScreenUtil.m4547a(injectorLike);
        BackstageAnalyticsLogger a2 = BackstageAnalyticsLogger.m4259a(injectorLike);
        backstageNuxView.f4838a = a;
        backstageNuxView.f4839b = a2;
    }

    public BackstageNuxView(Context context) {
        this(context, null);
    }

    private BackstageNuxView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private BackstageNuxView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4843f = new ArrayList();
        Class cls = BackstageNuxView.class;
        m4728a(this, getContext());
        View.inflate(context, 2130903361, this);
        setBackgroundResource(2131363722);
        this.f4843f.add(findViewById(2131559867));
        this.f4843f.add(findViewById(2131559866));
        this.f4843f.add(findViewById(2131559869));
        this.f4843f.add(findViewById(2131559870));
        this.f4843f.add(findViewById(2131559871));
        this.f4840c = findViewById(2131559865);
        this.f4841d = findViewById(2131559868);
        this.f4842e = findViewById(2131559872);
        this.f4842e.setOnClickListener(new C04971(this));
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 711711967);
        m4729e(this);
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1757224950, a);
    }

    public static void m4729e(BackstageNuxView backstageNuxView) {
        for (View visibility : backstageNuxView.f4843f) {
            visibility.setVisibility(8);
        }
    }
}
