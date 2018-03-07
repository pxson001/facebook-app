package com.facebook.quickpromotion.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.facebook.base.fragment.FbFragment;
import com.facebook.inject.FbInjector;
import com.facebook.interstitial.manager.InterstitialTriggerContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.quickpromotion.logger.QuickPromotionLogger$LayoutInfo;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.Creative;
import com.facebook.widget.CustomViewUtils;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: react */
public abstract class QuickPromotionFragment extends FbFragment {
    public QuickPromotionDefinition f4794a;
    public Creative f4795b;
    @Inject
    public QuickPromotionViewHelperProvider f4796c;
    private QuickPromotionFragmentHost f4797d;
    public QuickPromotionViewHelper f4798e;
    private InterstitialTriggerContext f4799f;
    public OnGlobalLayoutListener f4800g;
    private String f4801h;
    private boolean f4802i;

    /* compiled from: react */
    class C06401 implements OnGlobalLayoutListener {
        final /* synthetic */ QuickPromotionFragment f4811a;

        C06401(QuickPromotionFragment quickPromotionFragment) {
            this.f4811a = quickPromotionFragment;
        }

        public void onGlobalLayout() {
            CustomViewUtils.a(this.f4811a.T, this.f4811a.f4800g);
            this.f4811a.f4800g = null;
            this.f4811a.aA();
        }
    }

    /* compiled from: react */
    public interface QuickPromotionFragmentHost {
        void c_(boolean z);
    }

    public static void m4664a(Object obj, Context context) {
        ((QuickPromotionFragment) obj).f4796c = (QuickPromotionViewHelperProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(QuickPromotionViewHelperProvider.class);
    }

    public void mo226c(Bundle bundle) {
        super.c(bundle);
        Class cls = QuickPromotionFragment.class;
        m4664a(this, getContext());
        Bundle bundle2 = this.s;
        this.f4794a = (QuickPromotionDefinition) bundle2.getParcelable("qp_definition");
        this.f4795b = (Creative) bundle2.getParcelable("qp_creative");
        if (this.f4795b == null) {
            this.f4795b = this.f4794a.c();
        }
        this.f4799f = (InterstitialTriggerContext) bundle2.getParcelable("qp_trigger_context");
        Preconditions.checkNotNull(this.f4794a, "A QuickPromotionDefinition object must be passed via arguments using the key 'qp_definition'");
    }

    public final void a_(Context context) {
        super.a_(context);
        this.f4797d = (QuickPromotionFragmentHost) a(QuickPromotionFragmentHost.class);
    }

    public final void dE_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -861256466);
        super.dE_();
        this.f4797d = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1607018642, a);
    }

    public void mo227d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 103337684);
        super.d(bundle);
        this.f4801h = this.s.getString("qp_controller_id");
        Preconditions.checkNotNull(this.f4801h, "The controller id must be passed in for logging");
        this.f4798e = this.f4796c.a(this.f4794a, this.f4801h, this.f4795b, this.f4799f);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1988198333, a);
    }

    public final void m4666G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2113902618);
        super.G();
        if (!this.f4802i && D() && mo229e()) {
            az();
            this.f4802i = true;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1236990750, a);
    }

    @Nullable
    protected QuickPromotionLogger$LayoutInfo mo225b() {
        return null;
    }

    public void mo230g(boolean z) {
        boolean D = D();
        super.g(z);
        if (this.y && z && D != z && !this.f4802i && mo229e()) {
            this.f4802i = true;
            az();
        }
    }

    protected boolean mo229e() {
        return true;
    }

    public final void as() {
        this.f4798e.m4728b();
        m4667a(this.f4798e.m4730d());
    }

    public final void au() {
        this.f4798e.m4731e();
        m4667a(this.f4798e.m4733g());
    }

    protected final void aw() {
        this.f4798e.m4734h();
        m4667a(this.f4798e.m4735i());
    }

    public void m4667a(boolean z) {
        if (this.f4797d != null) {
            this.f4797d.c_(z);
        }
    }

    public final void ay() {
        aA();
        this.f4802i = true;
    }

    public void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2062287482);
        if (this.f4800g != null) {
            CustomViewUtils.a(this.T, this.f4800g);
            this.f4800g = null;
        }
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1610517320, a);
    }

    private void aA() {
        this.f4798e.m4726a();
        this.f4798e.m4727a(mo225b());
    }

    public final boolean m4669b(Intent intent) {
        QuickPromotionDefinition quickPromotionDefinition = (QuickPromotionDefinition) this.s.getParcelable("qp_definition");
        QuickPromotionDefinition quickPromotionDefinition2 = (QuickPromotionDefinition) intent.getParcelableExtra("qp_definition");
        return (quickPromotionDefinition == null || quickPromotionDefinition2 == null || !Objects.equal(quickPromotionDefinition.promotionId, quickPromotionDefinition2.promotionId)) ? false : true;
    }

    private void az() {
        View view = this.T;
        if (view != null) {
            if (view.getWidth() > 0) {
                aA();
            } else if (this.f4800g == null) {
                this.f4800g = new C06401(this);
                view.getViewTreeObserver().addOnGlobalLayoutListener(this.f4800g);
            }
        }
    }
}
