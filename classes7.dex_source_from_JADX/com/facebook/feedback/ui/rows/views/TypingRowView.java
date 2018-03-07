package com.facebook.feedback.ui.rows.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.inject.FbInjector;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: reshare_ */
public class TypingRowView extends ImageBlockLayout {
    @Inject
    public CommentRowViewControllerProvider f5226h;
    @Inject
    public QeAccessor f5227i;
    private final CommentRowViewController f5228j;
    public final TextView f5229k;

    public static void m5665a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        TypingRowView typingRowView = (TypingRowView) obj;
        CommentRowViewControllerProvider commentRowViewControllerProvider = (CommentRowViewControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(CommentRowViewControllerProvider.class);
        QeAccessor qeAccessor = (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector);
        typingRowView.f5226h = commentRowViewControllerProvider;
        typingRowView.f5227i = qeAccessor;
    }

    public TypingRowView(Context context) {
        this(context, null);
    }

    private TypingRowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private TypingRowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = TypingRowView.class;
        m5665a(this, getContext());
        this.f5228j = this.f5226h.m5645a(this);
        this.f5228j.m5642a();
        setContentView(2130907584);
        setThumbnailPadding(getResources().getDimensionPixelSize(2131428721));
        this.f5229k = (TextView) getView(2131560435);
        if (this.f5227i.a(ExperimentsForFeedbackTestModule.Y, false)) {
            this.f5229k.setText(2131233343);
        } else if (this.f5227i.a(ExperimentsForFeedbackTestModule.X, false)) {
            this.f5229k.setText(2131233344);
        }
    }
}
