package com.facebook.quickpromotion.ui;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.quickpromotion.asset.QuickPromotionImageFetcher;
import com.facebook.quickpromotion.asset.QuickPromotionImageFetcher$ImageType;
import com.facebook.quickpromotion.logger.QuickPromotionLogger$LayoutInfo;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.Action;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.Creative;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ImageParameters;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.text.TextViewUtils;
import com.facebook.widget.touch.TouchDelegateUtils;
import javax.inject.Inject;

/* compiled from: reactionWriteTimeline */
public class QuickPromotionDivebarViewFactory {
    private static final CallerContext f4787a = CallerContext.a(QuickPromotionDivebarViewFactory.class, "quick_promotion_interstitial");
    private final QuickPromotionViewHelperProvider f4788b;
    private final QuickPromotionImageFetcher f4789c;
    private FbDraweeView f4790d;

    @Inject
    public QuickPromotionDivebarViewFactory(QuickPromotionViewHelperProvider quickPromotionViewHelperProvider, QuickPromotionImageFetcher quickPromotionImageFetcher) {
        this.f4788b = quickPromotionViewHelperProvider;
        this.f4789c = quickPromotionImageFetcher;
    }

    public final View m4663a(ViewGroup viewGroup, QuickPromotionDefinition quickPromotionDefinition, String str, OnClickListener onClickListener) {
        Object obj;
        Creative c = quickPromotionDefinition.c();
        final QuickPromotionViewHelper a = this.f4788b.a(quickPromotionDefinition, str, c, null);
        final View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2130906544, null);
        final Button button = (Button) inflate.findViewById(2131558610);
        final Button button2 = (Button) inflate.findViewById(2131559191);
        final Button button3 = (Button) inflate.findViewById(2131566504);
        final TextView textView = (TextView) inflate.findViewById(2131558927);
        final TextView textView2 = (TextView) inflate.findViewById(2131561061);
        textView.setText(quickPromotionDefinition.title);
        if (TextUtils.isEmpty(quickPromotionDefinition.content)) {
            textView2.setVisibility(8);
        } else {
            if (textView.getLineCount() >= 2) {
                textView2.setMaxLines(2);
            }
            textView2.setText(quickPromotionDefinition.content);
            textView2.setVisibility(0);
        }
        button.setText(quickPromotionDefinition.primaryAction.title);
        final OnClickListener onClickListener2 = onClickListener;
        button.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ QuickPromotionDivebarViewFactory f4770c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 255605867);
                a.m4728b();
                if (a.m4730d()) {
                    onClickListener2.onClick(view);
                }
                Logger.a(2, EntryType.UI_INPUT_END, -1629350810, a);
            }
        });
        Action action = quickPromotionDefinition.secondaryAction;
        if (action == null || TextUtils.isEmpty(action.title)) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            button2.setText(action.title);
            onClickListener2 = onClickListener;
            button2.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ QuickPromotionDivebarViewFactory f4773c;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -582020620);
                    a.m4731e();
                    if (a.m4733g()) {
                        onClickListener2.onClick(view);
                    }
                    Logger.a(2, EntryType.UI_INPUT_END, -713340223, a);
                }
            });
            button2.setVisibility(0);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(2131566505);
            if (VERSION.SDK_INT >= 11) {
                m4662a(linearLayout);
            } else {
                LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(1, 2131559119);
                layoutParams.addRule(3, 2131561061);
                linearLayout.setLayoutParams(layoutParams);
            }
        } else {
            button2.setVisibility(8);
        }
        if (quickPromotionDefinition.dismissAction != null || obj == null) {
            onClickListener2 = onClickListener;
            button3.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ QuickPromotionDivebarViewFactory f4776c;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -322847301);
                    a.m4734h();
                    if (a.m4735i()) {
                        onClickListener2.onClick(view);
                    }
                    Logger.a(2, EntryType.UI_INPUT_END, -1227889281, a);
                }
            });
            inflate.post(new Runnable(this) {
                final /* synthetic */ QuickPromotionDivebarViewFactory f4779c;

                public void run() {
                    inflate.setTouchDelegate(TouchDelegateUtils.a(button3, 12));
                }
            });
            button3.setVisibility(0);
        } else {
            button3.setVisibility(8);
        }
        this.f4790d = (FbDraweeView) inflate.findViewById(2131559119);
        if (this.f4789c.a(this.f4790d, c, f4787a, this.f4789c.a())) {
            QuickPromotionImageFetcher.a(c, this.f4790d);
            ImageParameters b = QuickPromotionImageFetcher.b(c, QuickPromotionImageFetcher$ImageType.ANY);
            int a2 = this.f4789c.a(b, c);
            int b2 = this.f4789c.b(b, c);
            LayoutParams layoutParams2 = this.f4790d.getLayoutParams();
            layoutParams2.width = a2;
            layoutParams2.height = b2;
            this.f4790d.setLayoutParams(layoutParams2);
            this.f4790d.setVisibility(0);
        } else {
            this.f4790d.setVisibility(8);
        }
        inflate.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
            final /* synthetic */ QuickPromotionDivebarViewFactory f4786g;

            public void onGlobalLayout() {
                CustomViewUtils.a(inflate, this);
                QuickPromotionViewHelper quickPromotionViewHelper = a;
                QuickPromotionLogger$LayoutInfo quickPromotionLogger$LayoutInfo = new QuickPromotionLogger$LayoutInfo();
                quickPromotionLogger$LayoutInfo.f4746a = TextViewUtils.b(textView);
                quickPromotionLogger$LayoutInfo = quickPromotionLogger$LayoutInfo;
                quickPromotionLogger$LayoutInfo.f4747b = TextViewUtils.b(textView2);
                quickPromotionLogger$LayoutInfo = quickPromotionLogger$LayoutInfo;
                quickPromotionLogger$LayoutInfo.f4748c = TextViewUtils.b(button);
                quickPromotionLogger$LayoutInfo = quickPromotionLogger$LayoutInfo;
                quickPromotionLogger$LayoutInfo.f4749d = TextViewUtils.b(button2);
                quickPromotionViewHelper.m4727a(quickPromotionLogger$LayoutInfo);
                a.m4726a();
            }
        });
        return inflate;
    }

    @TargetApi(11)
    private static void m4662a(LinearLayout linearLayout) {
        linearLayout.setMeasureWithLargestChildEnabled(true);
    }
}
