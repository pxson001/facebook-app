package com.facebook.messaging.payment.thread;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.graphql.enums.GraphQLMessengerPayThemeAssetTypeEnum;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.ThemeAssetModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.ThemeModel;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.ImmutableList;

/* compiled from: failure_ignored */
public class PaymentBubbleThemeView extends CustomLinearLayout {
    private static final CallerContext f14988a = CallerContext.a(PaymentBubbleThemeView.class);
    private FbDraweeView f14989b;

    private static <T extends View> void m15376a(Class<T> cls, T t) {
        FbInjector.get(t.getContext());
    }

    private static void m15377a(Object obj, Context context) {
        FbInjector.get(context);
    }

    public PaymentBubbleThemeView(Context context) {
        super(context);
        m15375a();
    }

    public PaymentBubbleThemeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m15375a();
    }

    public PaymentBubbleThemeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15375a();
    }

    private void m15375a() {
        m15376a(PaymentBubbleThemeView.class, (View) this);
        setContentView(2130905815);
        this.f14989b = (FbDraweeView) findViewById(2131565040);
    }

    public final void m15378a(ThemeModel themeModel) {
        if (themeModel.m13940b() == null) {
            this.f14989b.setVisibility(8);
            return;
        }
        ImmutableList a = themeModel.m13940b().m13932a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            ThemeAssetModel themeAssetModel = (ThemeAssetModel) a.get(i);
            if (themeAssetModel.m13923a().equals(GraphQLMessengerPayThemeAssetTypeEnum.CHAT_BUBBLE_VIEW)) {
                this.f14989b.a(Uri.parse(themeAssetModel.m13926c().m13918a()), f14988a);
                return;
            }
        }
        this.f14989b.setVisibility(8);
    }
}
