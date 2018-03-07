package com.facebook.reaction.feed.unitcomponents.partdefinition.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View.OnClickListener;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbButton;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

/* compiled from: accent_images */
public class ReactionCrisisActionView extends CustomLinearLayout {
    @Inject
    public AllCapsTransformationMethod f20157a;
    public FbButton f20158b = ((FbButton) a(2131566704));
    public FbButton f20159c = ((FbButton) a(2131566705));

    public static void m24038a(Object obj, Context context) {
        ((ReactionCrisisActionView) obj).f20157a = AllCapsTransformationMethod.b(FbInjector.get(context));
    }

    public ReactionCrisisActionView(Context context) {
        super(context);
        Class cls = ReactionCrisisActionView.class;
        m24038a((Object) this, getContext());
        setContentView(2130906659);
        setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131361920)));
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(2131427425);
        setPadding(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
        setOrientation(1);
    }

    public final void m24039a(OnClickListener onClickListener, OnClickListener onClickListener2) {
        this.f20158b.setOnClickListener(onClickListener);
        this.f20159c.setOnClickListener(onClickListener2);
    }
}
