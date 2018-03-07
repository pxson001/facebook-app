package com.facebook.feedplugins.attachments.linkshare.follow;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.feedplugins.attachments.linkshare.follow.BaseFollowShareAttachmentPartDefinition.FollowShareButtonState;
import com.facebook.feedplugins.base.footer.ui.Footer.DividerStyle;
import com.facebook.feedplugins.base.footer.ui.FooterDividerPainter;
import com.facebook.inject.FbInjector;
import com.facebook.multirow.api.ViewType;
import com.facebook.resources.ui.FbButton;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: TItem; */
public class FollowShareAttachmentView extends CustomLinearLayout {
    public static final ViewType f22603b = new C19691();
    @Inject
    public FooterDividerPainter f22604a;
    private final FbButton f22605c;

    /* compiled from: TItem; */
    final class C19691 extends ViewType {
        C19691() {
        }

        public final View m25276a(Context context) {
            return new FollowShareAttachmentView(context);
        }
    }

    public static void m25277a(Object obj, Context context) {
        ((FollowShareAttachmentView) obj).f22604a = FooterDividerPainter.b(FbInjector.get(context));
    }

    public FollowShareAttachmentView(Context context) {
        this(context, null);
    }

    private FollowShareAttachmentView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FollowShareAttachmentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130904397);
        this.f22605c = (FbButton) a(2131562110);
        Class cls = FollowShareAttachmentView.class;
        m25277a(this, getContext());
        setContentView(2130904397);
        this.f22604a.d = DividerStyle.VISIBLE;
    }

    public FbButton getButton() {
        return this.f22605c;
    }

    public void setButtonState(FollowShareButtonState followShareButtonState) {
        followShareButtonState.setState(this.f22605c);
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.f22604a.a(this, canvas);
    }
}
