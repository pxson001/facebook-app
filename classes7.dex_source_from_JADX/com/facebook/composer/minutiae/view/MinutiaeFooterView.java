package com.facebook.composer.minutiae.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.composer.minutiae.MinutiaeTaggableVerbFragment;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: textSize */
public class MinutiaeFooterView extends CustomLinearLayout {
    public static final CallerContext f1877a = CallerContext.a(MinutiaeFooterView.class);
    public final ImageView f1878b = ((ImageView) a(2131560565));
    public final View f1879c = a(2131560563);
    public final FbDraweeView f1880d = ((FbDraweeView) a(2131560562));
    public final TextView f1881e = ((TextView) a(2131560564));
    public MinutiaeTaggableVerbFragment f1882f = null;

    /* compiled from: textSize */
    public class C01891 implements OnClickListener {
        final /* synthetic */ MinutiaeFooterView f1873a;

        public C01891(MinutiaeFooterView minutiaeFooterView) {
            this.f1873a = minutiaeFooterView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1401042845);
            this.f1873a.f1882f.m1533g(0);
            Logger.a(2, EntryType.UI_INPUT_END, 1812582760, a);
        }
    }

    /* compiled from: textSize */
    public class C01902 implements OnClickListener {
        final /* synthetic */ MinutiaeObject f1874a;
        final /* synthetic */ MinutiaeFooterView f1875b;

        public C01902(MinutiaeFooterView minutiaeFooterView, MinutiaeObject minutiaeObject) {
            this.f1875b = minutiaeFooterView;
            this.f1874a = minutiaeObject;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2107518025);
            MinutiaeTaggableVerbFragment minutiaeTaggableVerbFragment = this.f1875b.f1882f;
            MinutiaeObject minutiaeObject = this.f1874a;
            if (minutiaeTaggableVerbFragment.aB != null) {
                minutiaeTaggableVerbFragment.aB.mo64a(minutiaeObject, 1010);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -455554224, a);
        }
    }

    /* compiled from: textSize */
    public class C01913 implements OnClickListener {
        final /* synthetic */ MinutiaeFooterView f1876a;

        public C01913(MinutiaeFooterView minutiaeFooterView) {
            this.f1876a = minutiaeFooterView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2107368697);
            this.f1876a.f1882f.m1533g(-1);
            Logger.a(2, EntryType.UI_INPUT_END, 1340376524, a);
        }
    }

    public MinutiaeFooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130903698);
    }
}
