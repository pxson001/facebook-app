package com.facebook.feedback.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.api.ufiservices.common.CommentLoadDirection;
import com.facebook.api.ufiservices.common.CommentOrderType;
import com.facebook.feedback.abtest.InlineReplyExpansionExperimentUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.widget.CustomRelativeLayout;
import javax.inject.Inject;

/* compiled from: seal_broadcast_request */
public class LoadMoreCommentsView extends CustomRelativeLayout {
    @Inject
    CommentBackgroundUtil f4607a;
    @Inject
    QeAccessor f4608b;
    @Inject
    InlineReplyExpansionExperimentUtil f4609c;
    private ImageView f4610d;
    private ProgressBar f4611e;
    private TextView f4612f;
    private CommentOrderType f4613g;
    private CommentLoadDirection f4614h;
    public Listener f4615i;
    private final OnClickListener f4616j;

    /* compiled from: seal_broadcast_request */
    public interface Listener {
        void mo202a();
    }

    /* compiled from: seal_broadcast_request */
    class C04431 implements OnClickListener {
        final /* synthetic */ LoadMoreCommentsView f4606a;

        C04431(LoadMoreCommentsView loadMoreCommentsView) {
            this.f4606a = loadMoreCommentsView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1893174972);
            this.f4606a.m5161a();
            this.f4606a.f4615i.mo202a();
            Logger.a(2, EntryType.UI_INPUT_END, 132189562, a);
        }
    }

    private static <T extends View> void m5156a(Class<T> cls, T t) {
        m5157a((Object) t, t.getContext());
    }

    private static void m5157a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((LoadMoreCommentsView) obj).m5155a(CommentBackgroundUtil.m4807a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), InlineReplyExpansionExperimentUtil.a(injectorLike));
    }

    public LoadMoreCommentsView(Context context) {
        this(context, null, 0);
    }

    private void m5155a(CommentBackgroundUtil commentBackgroundUtil, QeAccessor qeAccessor, InlineReplyExpansionExperimentUtil inlineReplyExpansionExperimentUtil) {
        this.f4607a = commentBackgroundUtil;
        this.f4608b = qeAccessor;
        this.f4609c = inlineReplyExpansionExperimentUtil;
    }

    public LoadMoreCommentsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadMoreCommentsView(Context context, AttributeSet attributeSet, int i) {
        int i2;
        super(context, attributeSet, i);
        this.f4616j = new C04431(this);
        m5156a(LoadMoreCommentsView.class, (View) this);
        if (this.f4609c.b()) {
            i2 = 2130904392;
        } else {
            i2 = 2130904391;
        }
        setContentView(i2);
        setBackgroundDrawable(this.f4607a.m4813a(context));
        this.f4610d = (ImageView) b(2131562100).orNull();
        this.f4611e = (ProgressBar) b(2131562101).orNull();
        this.f4612f = (TextView) a(2131562102);
    }

    public void setListener(Listener listener) {
        this.f4615i = listener;
    }

    public final void m5162a(CommentOrderType commentOrderType, CommentLoadDirection commentLoadDirection) {
        this.f4613g = commentOrderType;
        this.f4614h = commentLoadDirection;
        m5159b();
    }

    public final void m5161a() {
        this.f4612f.setText(2131233391);
        m5158a(true);
        setOnClickListener(null);
    }

    private void m5159b() {
        m5160c();
        m5158a(false);
        setOnClickListener(this.f4616j);
    }

    private void m5160c() {
        int i = this.f4613g.equals(CommentOrderType.RANKED_ORDER) ? this.f4614h.equals(CommentLoadDirection.LOAD_AFTER) ? 2131233264 : 2131233262 : this.f4614h.equals(CommentLoadDirection.LOAD_BEFORE) ? 2131233264 : 2131233262;
        this.f4612f.setText(i);
    }

    private void m5158a(boolean z) {
        int i = 0;
        if (this.f4610d != null) {
            this.f4610d.setVisibility(z ? 8 : 0);
        }
        if (this.f4611e != null) {
            if (!z) {
                i = 8;
            }
            this.f4611e.setVisibility(i);
        }
    }
}
