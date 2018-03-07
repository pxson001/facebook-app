package com.facebook.richdocument.view.block.impl;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.inject.FbInjector;
import com.facebook.richdocument.ham.HamViewUtils;
import com.facebook.richdocument.presenter.AuthorsBlockPresenter;
import com.facebook.richdocument.view.block.AuthorsBlockView;
import com.facebook.richdocument.view.block.BlockViewUtil;
import com.facebook.richdocument.view.block.CustomBackgroundAware;
import com.facebook.richdocument.view.widget.PressStateButton;
import com.facebook.richdocument.view.widget.RichTextView;
import javax.inject.Inject;

/* compiled from: page_wait_time */
public class AuthorsBlockViewImpl extends AbstractBlockView<AuthorsBlockPresenter> implements AuthorsBlockView, CustomBackgroundAware {
    public static final CallerContext f6606b = CallerContext.a(AuthorsBlockViewImpl.class, "unknown");
    @Inject
    public HamViewUtils f6607a;
    private final float f6608c = 0.7f;
    public final TextView f6609d;
    public final RichTextView f6610e;
    public final FbDraweeView f6611f;
    private final int f6612g;
    public final PressStateButton f6613h;
    public final PressStateButton f6614i;

    /* compiled from: page_wait_time */
    /* synthetic */ class C07501 {
        static final /* synthetic */ int[] f6605a = new int[GraphQLSubscribeStatus.values().length];

        static {
            try {
                f6605a[GraphQLSubscribeStatus.CAN_SUBSCRIBE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6605a[GraphQLSubscribeStatus.IS_SUBSCRIBED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static void m6944a(Object obj, Context context) {
        ((AuthorsBlockViewImpl) obj).f6607a = HamViewUtils.m5278a(FbInjector.get(context));
    }

    public AuthorsBlockViewImpl(View view) {
        super(view);
        Class cls = AuthorsBlockViewImpl.class;
        m6944a((Object) this, getContext());
        this.f6612g = getContext().getResources().getColor(2131363478);
        this.f6609d = (TextView) view.findViewById(2131562977);
        this.f6610e = (RichTextView) view.findViewById(2131562978);
        this.f6611f = (FbDraweeView) view.findViewById(2131562975);
        this.f6607a.m5280a(this.f6611f, 2131558727, 2131558727);
        this.f6613h = (PressStateButton) view.findViewById(2131562979);
        this.f6613h.setDrawableBaseScale(0.7f);
        this.f6614i = (PressStateButton) view.findViewById(2131562980);
        this.f6614i.setDrawableBaseScale(0.7f);
        this.f6614i.f7246f = false;
        this.f6607a.m5283c(view.findViewById(2131562974), 0, 0, 0, 2131558648);
        this.f6607a.m5283c(view.findViewById(2131562976), 2131558648, 0, 2131558648, 0);
    }

    public final int mo383a() {
        return this.f6612g;
    }

    public final void m6948a(boolean z, boolean z2) {
        if (z) {
            Context context = getContext();
            PressStateButton pressStateButton = this.f6613h;
            int color = context.getResources().getColor(2131363466);
            if (null != null) {
                color = -1;
            }
            int color2 = context.getResources().getColor(2131363477);
            int color3 = null != null ? color2 : context.getResources().getColor(2131363472);
            if (null == null) {
                color2 = context.getResources().getColor(2131363473);
            }
            if (z2) {
                color2 = color;
            }
            if (!z2) {
                color = color3;
            }
            BlockViewUtil.m6920a(pressStateButton, color2, color);
            pressStateButton.setVisibility(0);
        }
    }

    public final void m6947a(GraphQLSubscribeStatus graphQLSubscribeStatus) {
        switch (C07501.f6605a[graphQLSubscribeStatus.ordinal()]) {
            case 1:
                BlockViewUtil.m6921a(this.f6614i, 2131237716, 2130843049, getContext().getResources().getColor(2131363473), getContext().getResources().getColor(2131363472));
                this.f6614i.setVisibility(0);
                return;
            case 2:
                int color = getContext().getResources().getColor(2131363466);
                BlockViewUtil.m6921a(this.f6614i, 2131237716, 2130843050, color, color);
                this.f6614i.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public final void mo374a(Bundle bundle) {
        super.mo374a(null);
        this.f6613h.setVisibility(8);
        this.f6614i.setVisibility(8);
    }
}
