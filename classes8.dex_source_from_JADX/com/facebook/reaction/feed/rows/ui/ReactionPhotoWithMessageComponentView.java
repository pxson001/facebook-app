package com.facebook.reaction.feed.rows.ui;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: android_native_article_block_interaction */
public class ReactionPhotoWithMessageComponentView extends CustomLinearLayout {
    public static final ViewType f19483a = new C21121();
    private FbDraweeView f19484b = ((FbDraweeView) a(2131566683));
    public TextView f19485c = ((TextView) a(2131566684));

    /* compiled from: android_native_article_block_interaction */
    final class C21121 extends ViewType {
        C21121() {
        }

        public final View m23439a(Context context) {
            return new ReactionPhotoWithMessageComponentView(context);
        }
    }

    public ReactionPhotoWithMessageComponentView(Context context) {
        super(context);
        setContentView(2130906645);
    }

    public final void m23440a(float f, @Nullable DraweeController draweeController, @Nullable PointF pointF, @Nullable OnClickListener onClickListener) {
        this.f19484b.setController(draweeController);
        this.f19484b.setOnClickListener(onClickListener);
        this.f19484b.setAspectRatio(f);
        if (pointF != null) {
            ((GenericDraweeHierarchy) this.f19484b.getHierarchy()).a(pointF);
        }
    }

    @VisibleForTesting
    public FbDraweeView getDraweeView() {
        return this.f19484b;
    }
}
