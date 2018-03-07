package com.facebook.feedplugins.pymk.views.rows;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.friends.ui.SmartButtonLite;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;
import javax.inject.Inject;

/* compiled from: THREAD */
public class CCUPromoCardView extends PagerItemWrapperLayout implements RecyclableView {
    @Inject
    public GatekeeperStoreImpl f24919a;
    @Inject
    public AllCapsTransformationMethod f24920b;
    public boolean f24921c;
    public Resources f24922d;
    private SmartButtonLite f24923e;

    public static void m26691a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        CCUPromoCardView cCUPromoCardView = (CCUPromoCardView) obj;
        GatekeeperStoreImpl a = GatekeeperStoreImplMethodAutoProvider.a(fbInjector);
        AllCapsTransformationMethod b = AllCapsTransformationMethod.b(fbInjector);
        cCUPromoCardView.f24919a = a;
        cCUPromoCardView.f24920b = b;
    }

    public CCUPromoCardView(Context context) {
        this(context, null);
    }

    private CCUPromoCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Class cls = CCUPromoCardView.class;
        m26691a(this, getContext());
        this.f24922d = getResources();
        if (this.f24919a.a(659, false)) {
            setContentView(2130904322);
        } else {
            setContentView(2130904321);
        }
        this.f24923e = (SmartButtonLite) c(2131561954);
        this.f24923e.setText(this.f24920b.getTransformation(this.f24922d.getString(2131235590), null));
        if (this.f24919a.a(659, false)) {
            this.f24923e.setTextColor(this.f24922d.getColor(2131361920));
            this.f24923e.setBackgroundResource(2130840349);
            return;
        }
        this.f24923e.setStyle(2130772401);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 834391876);
        super.onAttachedToWindow();
        this.f24921c = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 259328324, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1393209447);
        super.onDetachedFromWindow();
        this.f24921c = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1754136800, a);
    }

    public final boolean m26692a() {
        return this.f24921c;
    }
}
