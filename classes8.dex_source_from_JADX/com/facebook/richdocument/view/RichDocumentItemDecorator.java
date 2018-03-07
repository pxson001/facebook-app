package com.facebook.richdocument.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.inject.InjectorLike;
import com.facebook.richdocument.ham.HamContentType;
import com.facebook.richdocument.ham.HamDimensions;
import com.facebook.richdocument.ham.RichDocumentPaddingCalculator;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.view.block.BlockView;
import com.facebook.richdocument.view.block.CustomBackgroundAware;
import com.facebook.richdocument.view.block.impl.CodeBlockViewImpl;
import com.facebook.richdocument.view.util.WebViewUtils;
import com.facebook.richdocument.view.viewholder.BlockViewHolder;
import javax.inject.Inject;

/* compiled from: payment_type */
public class RichDocumentItemDecorator extends ItemDecoration implements InjectableComponentWithoutContext {
    @Inject
    public RichDocumentPaddingCalculator f6524a;
    @Inject
    public HamDimensions f6525b;
    @Inject
    public RichDocumentMarginCalculator f6526c;
    private final int f6527d = this.f6525b.m5276b(2131558651);

    public static void m6885a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        RichDocumentItemDecorator richDocumentItemDecorator = (RichDocumentItemDecorator) obj;
        RichDocumentPaddingCalculator a = RichDocumentPaddingCalculator.m5294a(injectorLike);
        HamDimensions a2 = HamDimensions.m5268a(injectorLike);
        RichDocumentMarginCalculator richDocumentMarginCalculator = new RichDocumentMarginCalculator(HamDimensions.m5268a(injectorLike), WebViewUtils.m7372a(injectorLike));
        richDocumentItemDecorator.f6524a = a;
        richDocumentItemDecorator.f6525b = a2;
        richDocumentItemDecorator.f6526c = richDocumentMarginCalculator;
    }

    public RichDocumentItemDecorator(Context context) {
        Class cls = RichDocumentItemDecorator.class;
        m6885a((Object) this, context);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m6888a(android.graphics.Rect r10, android.view.View r11, android.support.v7.widget.RecyclerView r12, android.support.v7.widget.RecyclerView.State r13) {
        /*
        r9 = this;
        r6 = 0;
        r1 = android.support.v7.widget.RecyclerView.d(r11);
        r7 = r12.o;
        r0 = r7;
        r0 = (com.facebook.richdocument.view.RichDocumentAdapter) r0;
        r2 = m6884a(r0, r1);
        r3 = r9.f6526c;
        r7 = 0;
        r8 = r2.mo272n();
        switch(r8) {
            case 4: goto L_0x0021;
            case 5: goto L_0x0021;
            case 6: goto L_0x0021;
            case 7: goto L_0x0021;
            case 8: goto L_0x0055;
            case 12: goto L_0x0021;
            case 18: goto L_0x0021;
            case 23: goto L_0x0021;
            default: goto L_0x0018;
        };
    L_0x0018:
        r7 = r3.f6528a;
        r8 = 2131558653; // 0x7f0d00fd float:1.8742628E38 double:1.0531299025E-314;
        r7 = r7.m5276b(r8);
    L_0x0021:
        r3 = r7;
        r4 = r9.f6526c;
        r7 = 0;
        r8 = r2.mo272n();
        switch(r8) {
            case 4: goto L_0x0035;
            case 5: goto L_0x0035;
            case 6: goto L_0x0035;
            case 7: goto L_0x0035;
            case 8: goto L_0x005f;
            case 12: goto L_0x0035;
            case 18: goto L_0x0035;
            case 23: goto L_0x0035;
            default: goto L_0x002c;
        };
    L_0x002c:
        r7 = r4.f6528a;
        r8 = 2131558654; // 0x7f0d00fe float:1.874263E38 double:1.053129903E-314;
        r7 = r7.m5276b(r8);
    L_0x0035:
        r4 = r7;
        r7 = r12.o;
        r5 = r7;
        r5 = r5.aZ_();
        r5 = r5 + -1;
        if (r1 != r5) goto L_0x0047;
    L_0x0041:
        r0 = r9.f6527d;
        r10.set(r3, r6, r4, r0);
    L_0x0046:
        return;
    L_0x0047:
        r5 = r1 + 1;
        r0 = m6884a(r0, r5);
        r0 = r9.m6883a(r11, r1, r2, r0);
        r10.set(r3, r6, r4, r0);
        goto L_0x0046;
    L_0x0055:
        r8 = r3.f6529b;
        r8 = r8.m7381a(r2);
        if (r8 == 0) goto L_0x0018;
    L_0x005d:
        goto L_0x0021;
    L_0x005f:
        r8 = r4.f6529b;
        r8 = r8.m7381a(r2);
        if (r8 == 0) goto L_0x002c;
    L_0x0067:
        goto L_0x0035;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.richdocument.view.RichDocumentItemDecorator.a(android.graphics.Rect, android.view.View, android.support.v7.widget.RecyclerView, android.support.v7.widget.RecyclerView$State):void");
    }

    private int m6883a(View view, int i, BlockData blockData, BlockData blockData2) {
        HamContentType from = HamContentType.from(blockData);
        HamContentType from2 = HamContentType.from(blockData2);
        if (i == 0 && (from == HamContentType.MEDIA_WITH_ABOVE_AND_BELOW_CAPTION || from == HamContentType.MEDIA_WITH_ABOVE_CAPTION || from == HamContentType.MEDIA_WITH_BELOW_CAPTION || from == HamContentType.MEDIA_WITHOUT_ABOVE_OR_BELOW_CAPTION)) {
            return 0;
        }
        return this.f6524a.m5296a(from, view, from2, null);
    }

    public final void m6887a(Canvas canvas, RecyclerView recyclerView, State state) {
        int childCount = recyclerView.getChildCount();
        Paint paint = new Paint();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            BlockView blockView = ((BlockViewHolder) recyclerView.a(childAt)).m7383w().f6382d;
            if (blockView instanceof CustomBackgroundAware) {
                int i2;
                BlockView blockView2;
                int height;
                int a = ((CustomBackgroundAware) blockView).mo383a();
                paint.setColor(a);
                paint.setStyle(Style.FILL);
                if (i == 0) {
                    i2 = 0;
                } else {
                    blockView2 = ((BlockViewHolder) recyclerView.a(recyclerView.getChildAt(i - 1))).m7383w().f6382d;
                    if (!(blockView2 instanceof CustomBackgroundAware) && (blockView instanceof CodeBlockViewImpl)) {
                        i2 = childAt.getTop() - ((CodeBlockViewImpl) blockView).f6631e;
                    } else if ((blockView2 instanceof CustomBackgroundAware) && ((CustomBackgroundAware) blockView2).mo383a() == a) {
                        i2 = childAt.getTop();
                        int bottom = i2 - recyclerView.getChildAt(i - 1).getBottom();
                        i2 -= ((m6886a(bottom) ? 1 : 0) + bottom) / 2;
                    } else {
                        i2 = childAt.getTop();
                    }
                }
                if (i + 1 == childCount) {
                    height = recyclerView.getHeight();
                } else {
                    blockView2 = ((BlockViewHolder) recyclerView.a(recyclerView.getChildAt(i + 1))).m7383w().f6382d;
                    if (!(blockView2 instanceof CustomBackgroundAware) && (blockView instanceof CodeBlockViewImpl)) {
                        height = childAt.getBottom() + ((CodeBlockViewImpl) blockView).f6631e;
                    } else if ((blockView2 instanceof CustomBackgroundAware) && ((CustomBackgroundAware) blockView2).mo383a() == a) {
                        height = childAt.getBottom();
                        height += (recyclerView.getChildAt(i + 1).getTop() - height) / 2;
                    } else {
                        height = childAt.getBottom();
                    }
                }
                canvas.drawRect(0.0f, (float) i2, (float) recyclerView.getWidth(), (float) height, paint);
            }
        }
    }

    private static boolean m6886a(int i) {
        return (i & 1) == 1;
    }

    private static BlockData m6884a(RichDocumentAdapter richDocumentAdapter, int i) {
        if (i < 0 || i >= richDocumentAdapter.aZ_()) {
            return null;
        }
        return richDocumentAdapter.m6882e(i);
    }
}
