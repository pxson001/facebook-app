package com.facebook.backstage.consumption.importflow;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.facebook.backstage.consumption.ScreenUtil;
import com.facebook.backstage.consumption.swipe.BackstageSwipeController;
import com.facebook.backstage.util.BetterGestureListener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.debug.log.BLog;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.inject.InjectorLike;
import com.facebook.pager.PagerViewItemFactory;
import com.facebook.pager.renderers.standard.StandardPagerViewRenderer;
import com.facebook.resources.ui.FbTextView;
import com.facebook.springs.SpringSystem;
import com.google.common.collect.ImmutableList;
import java.text.DateFormat;
import javax.inject.Inject;

/* compiled from: risk_card_first_six_fragment_tag */
public class ImportFlowStackViewController {
    public static final String f4801a = ImportFlowStackViewController.class.getSimpleName();
    public final C04941 f4802b = new C04941(this);
    private final ImportStackViewEditTextHandler f4803c = new ImportStackViewEditTextHandler();
    public final BackstageSwipeController<ImportMedia, ImportFlowStackPagerViewItem> f4804d;
    public final FbDraweeControllerBuilder f4805e;
    private final ScreenUtil f4806f;
    private StandardPagerViewRenderer<ImportMedia, ImportFlowStackPagerViewItem> f4807g;
    public ViewGroup f4808h;
    public FbTextView f4809i;
    public boolean f4810j;

    /* compiled from: risk_card_first_six_fragment_tag */
    public class C04941 {
        final /* synthetic */ ImportFlowStackViewController f4799a;

        C04941(ImportFlowStackViewController importFlowStackViewController) {
            this.f4799a = importFlowStackViewController;
        }

        public final void m4678a() {
            if (this.f4799a.f4804d.f5097f == null) {
                BLog.b(ImportFlowStackViewController.f4801a, "Controller not yet initialized.");
            } else {
                this.f4799a.f4809i.setText(DateFormat.getTimeInstance(3).format(((ImportMedia) this.f4799a.f4804d.f5097f.f18378C).f4821e));
            }
        }
    }

    /* compiled from: risk_card_first_six_fragment_tag */
    class C04952 implements PagerViewItemFactory<ImportFlowStackPagerViewItem> {
        final /* synthetic */ ImportFlowStackViewController f4800a;

        C04952(ImportFlowStackViewController importFlowStackViewController) {
            this.f4800a = importFlowStackViewController;
        }

        public final Object mo170a() {
            ImportFlowStackPagerViewItem importFlowStackPagerViewItem = new ImportFlowStackPagerViewItem(this.f4800a.f4808h.getContext(), this.f4800a.f4805e);
            importFlowStackPagerViewItem.setLayoutParams(ImportFlowStackViewController.m4690g());
            importFlowStackPagerViewItem.f4781b = this.f4800a.f4802b;
            return importFlowStackPagerViewItem;
        }
    }

    public static ImportFlowStackViewController m4683b(InjectorLike injectorLike) {
        return new ImportFlowStackViewController(SpringSystem.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), ScreenUtil.m4547a(injectorLike), FbDraweeControllerBuilder.b(injectorLike));
    }

    public static ImportFlowStackViewController m4681a(InjectorLike injectorLike) {
        return m4683b(injectorLike);
    }

    @Inject
    public ImportFlowStackViewController(SpringSystem springSystem, AbstractFbErrorReporter abstractFbErrorReporter, ScreenUtil screenUtil, FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f4804d = new BackstageSwipeController(screenUtil, springSystem, abstractFbErrorReporter);
        this.f4806f = screenUtil;
        this.f4805e = fbDraweeControllerBuilder;
    }

    public final void m4691a(ImmutableList<ImportMedia> immutableList, ViewGroup viewGroup, ViewGroup viewGroup2, ImportFlowTitleView importFlowTitleView, FbTextView fbTextView) {
        this.f4808h = viewGroup2;
        this.f4809i = fbTextView;
        if (this.f4807g == null) {
            this.f4807g = new StandardPagerViewRenderer(this.f4808h, new C04952(this), 2);
        }
        this.f4804d.f5099h = this.f4803c;
        this.f4804d.m4889a(this.f4807g, (float) this.f4806f.m4551a(), (float) this.f4806f.m4552b(), immutableList);
        ImportStackViewEditTextHandler importStackViewEditTextHandler = this.f4803c;
        BackstageSwipeController backstageSwipeController = this.f4804d;
        importStackViewEditTextHandler.f4824a = importFlowTitleView;
        importStackViewEditTextHandler.f4825b = viewGroup;
        importStackViewEditTextHandler.f4827d = backstageSwipeController;
        this.f4804d.f5097f.m18386a(0, 10.0f);
        this.f4810j = true;
    }

    public final boolean m4692a() {
        return this.f4810j;
    }

    public final BetterGestureListener m4693b() {
        return this.f4804d.f5092a;
    }

    public final boolean m4694c() {
        if (this.f4804d.m4890c() != null) {
            this.f4804d.m4890c();
            if (null != null) {
                return true;
            }
        }
        return false;
    }

    public final void m4695d() {
        this.f4810j = false;
        this.f4807g = null;
        this.f4804d.m4891d();
        this.f4804d.f5099h = null;
        this.f4808h.removeAllViews();
        ImportStackViewEditTextHandler importStackViewEditTextHandler = this.f4803c;
        if (importStackViewEditTextHandler.f4826c != null) {
            importStackViewEditTextHandler.f4826c.f5505d = null;
        }
        importStackViewEditTextHandler.f4826c = null;
        importStackViewEditTextHandler.f4824a = null;
        importStackViewEditTextHandler.f4825b = null;
        importStackViewEditTextHandler.f4827d = null;
    }

    public static LayoutParams m4690g() {
        return new LayoutParams(-1, -1);
    }
}
