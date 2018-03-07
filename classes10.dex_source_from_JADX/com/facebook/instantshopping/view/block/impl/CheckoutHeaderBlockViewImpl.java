package com.facebook.instantshopping.view.block.impl;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.inject.FbInjector;
import com.facebook.instantshopping.InstantShoppingPrefKeys;
import com.facebook.instantshopping.abtest.ExperimentsForInstantShoppingAbtestModule;
import com.facebook.instantshopping.action.InstantShoppingActionUtils;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingActionFragmentModel;
import com.facebook.instantshopping.presenter.HeaderBlockPresenter;
import com.facebook.instantshopping.utils.InstantShoppingDocumentContext;
import com.facebook.instantshopping.view.block.HeaderBlockView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.richdocument.view.block.impl.AbstractBlockView;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

/* compiled from: STATUS_UNKNOW */
public class CheckoutHeaderBlockViewImpl extends AbstractBlockView<HeaderBlockPresenter> implements HeaderBlockView {
    @Inject
    public InstantShoppingActionUtils f23709a;
    @Inject
    public FbSharedPreferences f23710b;
    @Inject
    public QeAccessor f23711c;
    @Inject
    public InstantShoppingDocumentContext f23712d;
    private final BetterTextView f23713e;
    public final ImageView f23714f;
    private final FrameLayout f23715g;
    public String f23716h;

    public static void m25040a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        CheckoutHeaderBlockViewImpl checkoutHeaderBlockViewImpl = (CheckoutHeaderBlockViewImpl) obj;
        InstantShoppingActionUtils a = InstantShoppingActionUtils.m24796a(fbInjector);
        FbSharedPreferences fbSharedPreferences = (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector);
        QeAccessor qeAccessor = (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector);
        InstantShoppingDocumentContext a2 = InstantShoppingDocumentContext.a(fbInjector);
        checkoutHeaderBlockViewImpl.f23709a = a;
        checkoutHeaderBlockViewImpl.f23710b = fbSharedPreferences;
        checkoutHeaderBlockViewImpl.f23711c = qeAccessor;
        checkoutHeaderBlockViewImpl.f23712d = a2;
    }

    public CheckoutHeaderBlockViewImpl(View view) {
        super(view);
        Class cls = CheckoutHeaderBlockViewImpl.class;
        m25040a(this, getContext());
        this.f23715g = (FrameLayout) view.findViewById(2131563315);
        this.f23713e = (BetterTextView) view.findViewById(2131563317);
        this.f23714f = (ImageView) view.findViewById(2131563316);
    }

    public final void m25041a(int i) {
        if (i <= 0) {
            this.f23713e.setVisibility(8);
            return;
        }
        CharSequence text = this.f23713e.getText();
        this.f23713e.setVisibility(0);
        this.f23713e.setText(Integer.toString(i));
        if (StringUtil.c(text) && i == 1) {
            if (this.f23711c.a(ExperimentsForInstantShoppingAbtestModule.a, false) && !this.f23710b.a((PrefKey) ((PrefKey) InstantShoppingPrefKeys.f23460b.a("/")).a(this.f23712d.a), false) && StringUtil.c(this.f23716h)) {
                Tooltip tooltip = new Tooltip(getContext(), 2);
                tooltip.a(this.f23716h);
                tooltip.z = SizeUtil.a(getContext(), 3.0f);
                tooltip.y = SizeUtil.a(getContext(), 3.0f);
                tooltip.a(Position.BELOW);
                tooltip.a(this.f23714f);
                tooltip.d();
                this.f23710b.edit().putBoolean((PrefKey) ((PrefKey) InstantShoppingPrefKeys.f23460b.a("/")).a(this.f23712d.a), true).commit();
            }
        }
    }

    public final void mo1028c() {
        this.f23715g.setVisibility(0);
        this.f23713e.setVisibility(0);
        this.f23714f.setVisibility(0);
    }

    public final void mo1027a(final InstantShoppingActionFragmentModel instantShoppingActionFragmentModel) {
        OnClickListener c34001 = new OnClickListener(this) {
            final /* synthetic */ CheckoutHeaderBlockViewImpl f23708b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -2038294282);
                this.f23708b.f23709a.m24802a(this.f23708b.getContext(), instantShoppingActionFragmentModel, null, null);
                Logger.a(2, EntryType.UI_INPUT_END, -718153930, a);
            }
        };
        this.f23714f.setOnClickListener(c34001);
        this.f23713e.setOnClickListener(c34001);
    }
}
