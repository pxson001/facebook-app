package com.facebook.feedplugins.momentsupsell;

import android.content.Context;
import com.facebook.feedplugins.momentsupsell.abtest.ExperimentsForMomentsUpsellFeedPluginModule;
import com.facebook.inject.FbInjector;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomViewGroup;
import javax.inject.Inject;

/* compiled from: STICKER_PICKER_OPENED */
public class MomentsUpsellFooterView extends CustomViewGroup {
    @Inject
    public QeAccessor f23549a;
    public FbTextView f23550b = ((FbTextView) getView(2131563916));
    public FbTextView f23551c = ((FbTextView) getView(2131563917));

    public static void m25795a(Object obj, Context context) {
        ((MomentsUpsellFooterView) obj).f23549a = (QeAccessor) QeInternalImplMethodAutoProvider.a(FbInjector.get(context));
    }

    public MomentsUpsellFooterView(Context context) {
        super(context);
        Class cls = MomentsUpsellFooterView.class;
        m25795a(this, getContext());
        setContentView(2130905298);
        this.f23550b.setText(this.f23549a.a(ExperimentsForMomentsUpsellFeedPluginModule.d, getContext().getResources().getString(2131239069)));
        this.f23551c.setText(this.f23549a.a(ExperimentsForMomentsUpsellFeedPluginModule.c, getContext().getResources().getString(2131239070)));
    }
}
