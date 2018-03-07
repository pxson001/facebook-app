package com.facebook.feedplugins.pymi.views;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.feedplugins.pymi.abtest.ExperimentsForPymiModule;
import com.facebook.inject.FbInjector;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.widget.CustomFrameLayout;
import javax.inject.Inject;

/* compiled from: checkup_source */
public class FutureFriendingHeaderView extends CustomFrameLayout {
    @Inject
    public QeAccessor f8812a;

    public static void m9572a(Object obj, Context context) {
        ((FutureFriendingHeaderView) obj).f8812a = (QeAccessor) QeInternalImplMethodAutoProvider.a(FbInjector.get(context));
    }

    public FutureFriendingHeaderView(Context context) {
        this(context, null);
    }

    private FutureFriendingHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Class cls = FutureFriendingHeaderView.class;
        m9572a(this, getContext());
        setContentView(this.f8812a.a(ExperimentsForPymiModule.f8674d, false) ? 2130904568 : 2130904569);
    }
}
