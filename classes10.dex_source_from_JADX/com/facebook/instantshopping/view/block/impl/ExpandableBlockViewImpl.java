package com.facebook.instantshopping.view.block.impl;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.instantshopping.logging.InstantShoppingAnalyticsLogger;
import com.facebook.instantshopping.logging.LoggingParams;
import com.facebook.instantshopping.presenter.ExpandableBlockPresenter;
import com.facebook.instantshopping.utils.AnimationUtility;
import com.facebook.instantshopping.utils.InstantShoppingTextUtils;
import com.facebook.instantshopping.view.block.ExpandableBlockView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.richdocument.view.block.impl.AbstractBlockView;
import com.facebook.richdocument.view.widget.RichTextView;
import java.util.HashMap;
import javax.inject.Inject;

/* compiled from: STATE_LOGGING_INFO */
public class ExpandableBlockViewImpl extends AbstractBlockView<ExpandableBlockPresenter> implements ExpandableBlockView {
    @Inject
    public InstantShoppingAnalyticsLogger f23738a;
    @Inject
    public InstantShoppingTextUtils f23739b;
    public final RichTextView f23740c;
    public final ImageView f23741d;
    public final RichTextView f23742e;
    public final RelativeLayout f23743f;
    public boolean f23744g = false;

    /* compiled from: STATE_LOGGING_INFO */
    public class C34031 implements OnClickListener {
        final /* synthetic */ LoggingParams f23731a;
        final /* synthetic */ ExpandableBlockViewImpl f23732b;

        public C34031(ExpandableBlockViewImpl expandableBlockViewImpl, LoggingParams loggingParams) {
            this.f23732b = expandableBlockViewImpl;
            this.f23731a = loggingParams;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 52093973);
            ExpandableBlockViewImpl.m25053c(this.f23732b, this.f23731a);
            Logger.a(2, EntryType.UI_INPUT_END, 1417059597, a);
        }
    }

    /* compiled from: STATE_LOGGING_INFO */
    public class C34042 implements OnClickListener {
        final /* synthetic */ LoggingParams f23733a;
        final /* synthetic */ ExpandableBlockViewImpl f23734b;

        public C34042(ExpandableBlockViewImpl expandableBlockViewImpl, LoggingParams loggingParams) {
            this.f23734b = expandableBlockViewImpl;
            this.f23733a = loggingParams;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1955937600);
            ExpandableBlockViewImpl.m25053c(this.f23734b, this.f23733a);
            Logger.a(2, EntryType.UI_INPUT_END, -929141149, a);
        }
    }

    /* compiled from: STATE_LOGGING_INFO */
    public class C34053 implements OnClickListener {
        final /* synthetic */ LoggingParams f23735a;
        final /* synthetic */ ExpandableBlockViewImpl f23736b;

        public C34053(ExpandableBlockViewImpl expandableBlockViewImpl, LoggingParams loggingParams) {
            this.f23736b = expandableBlockViewImpl;
            this.f23735a = loggingParams;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 520735551);
            ExpandableBlockViewImpl.m25053c(this.f23736b, this.f23735a);
            Logger.a(2, EntryType.UI_INPUT_END, -988818460, a);
        }
    }

    /* compiled from: STATE_LOGGING_INFO */
    class C34064 extends AnimatorListenerAdapter {
        final /* synthetic */ ExpandableBlockViewImpl f23737a;

        C34064(ExpandableBlockViewImpl expandableBlockViewImpl) {
            this.f23737a = expandableBlockViewImpl;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.f23737a.f23742e.setVisibility(8);
        }
    }

    public static void m25052a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ExpandableBlockViewImpl expandableBlockViewImpl = (ExpandableBlockViewImpl) obj;
        InstantShoppingAnalyticsLogger a = InstantShoppingAnalyticsLogger.m24853a(injectorLike);
        InstantShoppingTextUtils b = InstantShoppingTextUtils.b(injectorLike);
        expandableBlockViewImpl.f23738a = a;
        expandableBlockViewImpl.f23739b = b;
    }

    public ExpandableBlockViewImpl(View view) {
        super(view);
        this.f23740c = (RichTextView) view.findViewById(2131563243);
        this.f23741d = (ImageView) view.findViewById(2131563244);
        this.f23742e = (RichTextView) view.findViewById(2131563245);
        this.f23743f = (RelativeLayout) view.findViewById(2131563242);
        Class cls = ExpandableBlockViewImpl.class;
        m25052a(this, getContext());
    }

    public final void m25054a(Bundle bundle) {
        super.a(bundle);
        iY_().setVisibility(8);
    }

    public static void m25053c(ExpandableBlockViewImpl expandableBlockViewImpl, final LoggingParams loggingParams) {
        if (expandableBlockViewImpl.f23742e.getVisibility() == 8) {
            expandableBlockViewImpl.f23744g = true;
            expandableBlockViewImpl.f23742e.setAlpha(0.0f);
            expandableBlockViewImpl.f23742e.setVisibility(0);
            expandableBlockViewImpl.f23742e.animate().alpha(1.0f).setDuration(100).setListener(null);
            AnimationUtility.a(expandableBlockViewImpl.getContext(), expandableBlockViewImpl.f23741d, 2130968728);
        } else if (expandableBlockViewImpl.f23742e.getVisibility() == 0) {
            expandableBlockViewImpl.f23744g = false;
            expandableBlockViewImpl.f23742e.animate().alpha(0.0f).setDuration(100).setListener(new C34064(expandableBlockViewImpl));
            AnimationUtility.a(expandableBlockViewImpl.getContext(), expandableBlockViewImpl.f23741d, 2130968723);
        }
        expandableBlockViewImpl.f23738a.m24859a("instant_shopping_element_click", new HashMap<String, Object>() {
        });
    }
}
