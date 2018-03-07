package com.facebook.feed.rows.sections.header.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Printer;
import android.util.StringBuilderPrinter;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.fbui.widget.text.TextLayoutView;
import com.facebook.inject.FbInjector;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.WrappedViewException;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: group_id=(\d+).* */
public class BaseHeaderViewWithTextLayout extends ImageBlockLayout implements CanShowDefaultHeaderData {
    public static final ViewType f21712h = new C08651();
    @Inject
    public AbstractFbErrorReporter f21713i;
    private final int f21714j;
    private final FbDraweeView f21715k;
    private final TextLayoutView f21716l;
    private final TextLayoutView f21717m;

    /* compiled from: group_id=(\d+).* */
    final class C08651 extends ViewType {
        C08651() {
        }

        public final View mo1995a(Context context) {
            return new BaseHeaderViewWithTextLayout(context);
        }
    }

    public static void m29422a(Object obj, Context context) {
        ((BaseHeaderViewWithTextLayout) obj).f21713i = FbErrorReporterImpl.m2317a(FbInjector.get(context));
    }

    public BaseHeaderViewWithTextLayout(Context context) {
        this(context, null, 2130904770);
    }

    public BaseHeaderViewWithTextLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 2130904770);
    }

    public BaseHeaderViewWithTextLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        Class cls = BaseHeaderViewWithTextLayout.class;
        m29422a(this, getContext());
        setContentView(i);
        this.f21715k = (FbDraweeView) getView(2131562764);
        if (VERSION.SDK_INT >= 16) {
            this.f21715k.setImportantForAccessibility(2);
        }
        this.f21716l = (TextLayoutView) getView(2131562765);
        this.f21717m = (TextLayoutView) getView(2131562766);
        this.f21714j = context.getResources().getColor(2131362771);
        this.f21716l.setHighlightColor(this.f21714j);
        TrackingNodes.m27141a((View) this, TrackingNode.HEADER);
        TrackingNodes.m27141a(this.f21715k, TrackingNode.ACTOR_PHOTO);
        TrackingNodes.m27141a(this.f21716l, TrackingNode.TITLE);
    }

    @VisibleForTesting
    public FbDraweeView getProfileImageView() {
        return this.f21715k;
    }

    public void setSubtitleWithLayout(Layout layout) {
        this.f21717m.setVisibility(layout == null ? 8 : 0);
        this.f21717m.setTextLayout(layout);
    }

    public void setSubtitleIcon(int i) {
        throw new UnsupportedOperationException("Not a simple text header, use text layout t6009510");
    }

    public void setProfileImageOnClickListener(@Nullable OnClickListener onClickListener) {
        this.f21715k.setOnClickListener(onClickListener);
    }

    protected void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (WrappedViewException e) {
            if (e.getCause() instanceof StringIndexOutOfBoundsException) {
                m29423a((StringIndexOutOfBoundsException) e.getCause());
                return;
            }
            throw e;
        } catch (StringIndexOutOfBoundsException e2) {
            m29423a(e2);
        }
    }

    private void m29423a(StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
        StringBuilder stringBuilder = new StringBuilder();
        Printer stringBuilderPrinter = new StringBuilderPrinter(stringBuilder);
        TextUtils.dumpSpans(this.f21716l.getText(), stringBuilderPrinter, "title: ");
        TextUtils.dumpSpans(this.f21717m.getText(), stringBuilderPrinter, "subtitle: ");
        SoftErrorBuilder a = SoftError.a("HeaderViewWithTextLayout.dispatchDraw caused StringIndexOutOfBoundsException", stringBuilder.toString());
        a.c = stringIndexOutOfBoundsException;
        this.f21713i.mo336a(a.g());
    }
}
