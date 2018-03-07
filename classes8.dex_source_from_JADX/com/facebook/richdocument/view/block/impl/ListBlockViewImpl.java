package com.facebook.richdocument.view.block.impl;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.TextView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.richdocument.ham.HamDimensions;
import com.facebook.richdocument.view.block.TextBlockView;
import com.facebook.richdocument.view.widget.RichTextUtils;
import com.facebook.richdocument.view.widget.RichTextView;
import javax.inject.Inject;

/* compiled from: page_manager_tap */
public class ListBlockViewImpl extends TextBlockViewImpl implements TextBlockView {
    @Inject
    public HamDimensions f6659a;
    @Inject
    public RichTextUtils f6660b;
    public final int f6661e = ((int) getContext().getResources().getDimension(2131431881));
    public final RichTextView f6662f;
    public final TextView f6663g;

    public static void m7009a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ListBlockViewImpl listBlockViewImpl = (ListBlockViewImpl) obj;
        HamDimensions a = HamDimensions.m5268a(injectorLike);
        RichTextUtils a2 = RichTextUtils.m1355a(injectorLike);
        listBlockViewImpl.f6659a = a;
        listBlockViewImpl.f6660b = a2;
    }

    public ListBlockViewImpl(View view) {
        super(view);
        Class cls = ListBlockViewImpl.class;
        m7009a(this, getContext());
        this.f6662f = (RichTextView) view.findViewById(2131567036);
        this.f6662f.f7393d.setMinimumWidth(this.f6659a.m5276b(2131558651));
        this.f6662f.f7393d.setGravity(3);
        this.f6663g = (TextView) view.findViewById(2131567037);
        if (VERSION.SDK_INT > 17) {
            this.f6663g.setPaddingRelative(0, 0, this.f6659a.m5276b(2131558650), 0);
        } else {
            this.f6663g.setPadding(0, 0, this.f6659a.m5276b(2131558650), 0);
        }
    }
}
