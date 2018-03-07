package com.facebook.backstage.consumption.importflow;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.facebook.backstage.consumption.GenericDraweeViewHelper;
import com.facebook.backstage.consumption.ScreenUtil;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.inject.FbInjector;
import javax.inject.Inject;

/* compiled from: risk_introduction_fragment_tag */
public class ImportFlowPanelView extends FrameLayout {
    @Inject
    public ScreenUtil f4773a;
    @Inject
    public FbDraweeControllerBuilder f4774b;
    public final ImageView f4775c;
    public final ImageView f4776d;
    public final GenericDraweeView f4777e;
    public final PorterDuffColorFilter f4778f;

    public static void m4649a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ImportFlowPanelView importFlowPanelView = (ImportFlowPanelView) obj;
        ScreenUtil a = ScreenUtil.m4547a(fbInjector);
        FbDraweeControllerBuilder b = FbDraweeControllerBuilder.b(fbInjector);
        importFlowPanelView.f4773a = a;
        importFlowPanelView.f4774b = b;
    }

    public ImportFlowPanelView(Context context) {
        this(context, null);
    }

    private ImportFlowPanelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private ImportFlowPanelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = ImportFlowPanelView.class;
        m4649a(this, getContext());
        View inflate = LayoutInflater.from(getContext()).inflate(2130904849, this);
        this.f4778f = new PorterDuffColorFilter(getResources().getColor(2131363720), Mode.SRC_ATOP);
        this.f4775c = (ImageView) inflate.findViewById(2131563069);
        this.f4776d = (ImageView) inflate.findViewById(2131563070);
        this.f4777e = (GenericDraweeView) inflate.findViewById(2131563068);
        this.f4777e.setLayoutParams(new LayoutParams(this.f4773a.m4553c(), this.f4773a.m4553c()));
        this.f4777e.setHierarchy(GenericDraweeViewHelper.m4530a(getResources()));
    }
}
