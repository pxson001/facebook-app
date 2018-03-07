package com.facebook.feedplugins.graphqlstory.inlinecomments;

import android.content.Context;
import android.os.Handler;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewStub;
import android.widget.TextView;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.SizeUtil;
import com.facebook.device.ScreenUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.fbui.widget.text.BadgeTextView;
import com.facebook.fbui.widget.text.TextLayoutView;
import com.facebook.fbui.widget.text.layoutbuilder.TextLayoutBuilder;
import com.facebook.feed.rows.abtest.ExperimentsForMultipleRowsStoriesAbtestModule;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.widget.RecyclableView;
import com.google.common.annotations.VisibleForTesting;
import javax.inject.Inject;

/* compiled from: domain */
public class InlineCommentView extends ImageBlockLayout implements RecyclableView {
    @VisibleForTesting
    public FbDraweeView f13717h;
    @Inject
    public ScreenUtil f13718i;
    @Inject
    public QeAccessor f13719j;
    @VisibleForTesting
    public FbDraweeView f13720k;
    public BadgeTextView f13721l;
    public TextView f13722m;
    public TextLayoutView f13723n;
    public TextLayoutBuilder f13724o;
    private Boolean f13725p;
    private boolean f13726q;
    public CustomLinkMovementMethod f13727r;

    /* compiled from: domain */
    public class CustomLinkMovementMethod extends LinkMovementMethod {
        final /* synthetic */ InlineCommentView f13740a;
        private final Handler f13741b = new Handler();

        public CustomLinkMovementMethod(InlineCommentView inlineCommentView) {
            this.f13740a = inlineCommentView;
        }

        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 1 && action != 0) {
                return super.onTouchEvent(textView, spannable, motionEvent);
            }
            int x = (((int) motionEvent.getX()) - textView.getTotalPaddingLeft()) + textView.getScrollX();
            int y = (((int) motionEvent.getY()) - textView.getTotalPaddingTop()) + textView.getScrollY();
            Layout layout = textView.getLayout();
            x = layout.getOffsetForHorizontal(layout.getLineForVertical(y), (float) x);
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(x, x, ClickableSpan.class);
            if (clickableSpanArr.length == 0) {
                Selection.removeSelection(spannable);
                if (action == 0) {
                    if (InlineCommentView.m14468g(this.f13740a)) {
                        this.f13740a.f13723n.setClickable(false);
                    } else {
                        this.f13740a.f13722m.setMovementMethod(null);
                        this.f13740a.f13722m.setClickable(false);
                    }
                    HandlerDetour.a(this.f13741b, new 1(this, motionEvent), -351060376);
                }
                return true;
            }
            if (action == 1) {
                clickableSpanArr[0].onClick(textView);
            } else {
                Selection.setSelection(spannable, spannable.getSpanStart(clickableSpanArr[0]), spannable.getSpanEnd(clickableSpanArr[0]));
            }
            return true;
        }
    }

    public static void m14467a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        InlineCommentView inlineCommentView = (InlineCommentView) obj;
        ScreenUtil a = ScreenUtil.a(fbInjector);
        QeAccessor qeAccessor = (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector);
        inlineCommentView.f13718i = a;
        inlineCommentView.f13719j = qeAccessor;
    }

    public InlineCommentView(Context context) {
        this(context, null);
    }

    private InlineCommentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Class cls = InlineCommentView.class;
        m14467a((Object) this, getContext());
        this.b = 16;
        setContentView(2130904304);
        this.f13717h = (FbDraweeView) getView(2131561919);
        this.f13721l = (BadgeTextView) getView(2131561920);
        this.f13720k = (FbDraweeView) getView(2131561923);
        this.f13727r = new CustomLinkMovementMethod(this);
        this.f13721l.setMovementMethod(null);
        this.f13721l.setClickable(false);
        this.f13721l.setLinksClickable(false);
        this.f13717h.setClickable(false);
        if (m14468g(this)) {
            this.f13724o = new TextLayoutBuilder().a(TruncateAt.END).b(getResources().getDimensionPixelSize(2131427402)).c(getResources().getColor(2131362762));
            this.f13723n = (TextLayoutView) ((ViewStub) getView(2131561922)).inflate();
            this.f13723n.setFocusable(false);
            this.f13723n.setClickable(true);
            this.f13723n.setOnClickListener(new TextLayoutClickListener(this));
            TrackingNodes.a(this.f13723n, TrackingNode.COMMENT);
        } else {
            this.f13722m = (TextView) ((ViewStub) getView(2131561921)).inflate();
            this.f13722m.setMovementMethod(this.f13727r);
            this.f13722m.setFocusable(false);
            this.f13722m.setLinksClickable(false);
            this.f13722m.setClickable(false);
            TrackingNodes.a(this.f13722m, TrackingNode.COMMENT);
        }
        TrackingNodes.a(this, TrackingNode.PERMALINK_COMMENT);
        TrackingNodes.a(this.f13721l, TrackingNode.USER_NAME);
    }

    public void setBodyText(CharSequence charSequence) {
        if (m14468g(this)) {
            this.f13723n.setTextLayout(this.f13724o.a(charSequence).d());
        } else {
            this.f13722m.setText(charSequence);
        }
    }

    private void setBodyWidth(boolean z) {
        if (m14468g(this)) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(2131427592);
            int c = ((this.f13718i.c() - (SizeUtil.a(getContext(), 12.0f) * 2)) - getResources().getDimensionPixelSize(2131428825)) - dimensionPixelSize;
            if (z) {
                c -= dimensionPixelSize + getResources().getDimensionPixelSize(2131429108);
            }
            this.f13723n.setTextLayout(this.f13724o.a(c).d());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1120565902);
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 1 || action == 3) {
            if (m14468g(this)) {
                this.f13723n.setFocusable(false);
            } else {
                this.f13722m.setFocusable(false);
            }
        }
        LogUtils.a(197832378, a);
        return onTouchEvent;
    }

    public void setHasBeenAttached(boolean z) {
        this.f13726q = z;
    }

    public final boolean mo569a() {
        return this.f13726q;
    }

    public final void m14469a(AttachmentDisplayInfo attachmentDisplayInfo, CallerContext callerContext) {
        int i = 0;
        if (attachmentDisplayInfo == null) {
            this.f13720k.setVisibility(8);
            setBodyWidth(false);
            return;
        }
        this.f13720k.setVisibility(0);
        FbDraweeView fbDraweeView = this.f13720k;
        if (attachmentDisplayInfo.c) {
            i = 2130840255;
        }
        fbDraweeView.setBackgroundResource(i);
        this.f13720k.setScaleType(attachmentDisplayInfo.b);
        this.f13720k.a(attachmentDisplayInfo.a, callerContext);
        setBodyWidth(true);
    }

    public static boolean m14468g(InlineCommentView inlineCommentView) {
        if (inlineCommentView.f13725p == null) {
            inlineCommentView.f13725p = Boolean.valueOf(inlineCommentView.f13719j.a(ExperimentsForMultipleRowsStoriesAbtestModule.i, false));
        }
        return inlineCommentView.f13725p.booleanValue();
    }
}
