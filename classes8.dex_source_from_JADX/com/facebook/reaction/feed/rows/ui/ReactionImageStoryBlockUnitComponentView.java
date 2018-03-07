package com.facebook.reaction.feed.rows.ui;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: android_native_article_native_ad_perf */
public class ReactionImageStoryBlockUnitComponentView extends CustomLinearLayout {
    public static final ViewType f19460a = new C21091();
    public static final CallerContext f19461b = CallerContext.a(ReactionImageStoryBlockUnitComponentView.class, "reaction_dialog", "component_icon");
    public ImageBlockLayout f19462c;
    public TextView f19463d;
    public TextView f19464e;
    public FbDraweeView f19465f;

    /* compiled from: android_native_article_native_ad_perf */
    final class C21091 extends ViewType {
        C21091() {
        }

        public final View m23430a(Context context) {
            return new ReactionImageStoryBlockUnitComponentView(context);
        }
    }

    public ReactionImageStoryBlockUnitComponentView(Context context) {
        super(context);
        setContentView(2130906610);
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(2130773596, typedValue, true)) {
            setBackgroundResource(typedValue.resourceId);
        }
        this.f19462c = (ImageBlockLayout) a(2131566617);
        this.f19463d = (TextView) a(2131566618);
        this.f19464e = (TextView) a(2131566619);
    }
}
