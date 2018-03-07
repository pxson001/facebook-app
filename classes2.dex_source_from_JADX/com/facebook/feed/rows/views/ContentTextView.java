package com.facebook.feed.rows.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.graphql.model.FeedStorySpannableString;
import com.facebook.graphql.model.FeedStorySpannableString.TextViewCallback;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ufiservices.util.ContinueReadingAccessibilityDelegate;
import com.facebook.widget.accessibility.ClickableSpanAccessibilityDelegator;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: is_connected */
public class ContentTextView extends BetterTextView implements SupportsCopyStoryText, TextViewCallback, ClickableSpanAccessibilityDelegator {
    @Inject
    public AbstractFbErrorReporter f19222a;
    public GraphQLStory f19223b;
    private ExploreByTouchHelper f19224c;
    private boolean f19225d;
    private FeedStorySpannableString f19226e;
    private CopyStoryTextListenerController f19227f;

    private static <T extends View> void m26924a(Class<T> cls, T t) {
        m26925a((Object) t, t.getContext());
    }

    private static void m26925a(Object obj, Context context) {
        ((ContentTextView) obj).f19222a = FbErrorReporterImpl.m2317a(FbInjector.get(context));
    }

    public ContentTextView(Context context) {
        super(context);
        m26923a(context, null);
    }

    public ContentTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m26923a(context, attributeSet);
    }

    private void m26923a(Context context, @Nullable AttributeSet attributeSet) {
        m26924a(ContentTextView.class, (View) this);
        setIncludeFontPadding(false);
        setHighlightColor(context.getResources().getColor(2131362049));
        setTextSize(0, (float) context.getResources().getDimensionPixelSize(2131430351));
        setLineSpacing(context.getResources().getDimension(2131430350), 1.0f);
        setTextColor(getContext().getResources().getColor(m26922a(attributeSet)));
        setMovementMethod(LinkMovementMethod.getInstance());
        this.f19224c = new ContinueReadingAccessibilityDelegate(this);
        this.f19225d = false;
        this.f19227f = new CopyStoryTextListenerController(getContext());
    }

    public final void m26927b() {
        ViewCompat.m10939a((View) this, this.f19224c);
        this.f19225d = true;
    }

    @TargetApi(14)
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (this.f19225d && this.f19224c.m26957a(motionEvent)) {
            return true;
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    public void setSpannable(Spannable spannable) {
        if (spannable == null) {
            this.f19226e = null;
        } else if (spannable instanceof FeedStorySpannableString) {
            this.f19226e = (FeedStorySpannableString) spannable;
            this.f19226e.m31235a(this);
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        m26926c();
    }

    private void m26926c() {
        if (this.f19226e != null) {
            this.f19226e.m31235a(null);
        }
        this.f19226e = null;
    }

    private static int m26922a(@Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            return attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "textColor", 2131362048);
        }
        return 2131362048;
    }

    protected void onMeasure(int i, int i2) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1176713876);
        try {
            super.onMeasure(i, i2);
        } catch (Throwable e) {
            AbstractFbErrorReporter abstractFbErrorReporter = this.f19222a;
            String str = "ContentTextView" + (this.f19223b != null ? "_withZombie" : "");
            String str2 = "JellyBean measure bug with zombie: %s";
            Object[] objArr = new Object[1];
            objArr[0] = this.f19223b != null ? this.f19223b.S_() : null;
            abstractFbErrorReporter.mo336a(SoftError.a(str, StringLocaleUtil.m21640a(str2, objArr)).a(e).g());
            setText(getText().toString());
            super.onMeasure(i, i2);
        }
        LogUtils.g(1048669303, a);
    }

    public void setDebugInfo(@Nullable GraphQLStory graphQLStory) {
        this.f19223b = graphQLStory;
    }

    public void setCopyTextGestureListener(CopyStoryTextListener copyStoryTextListener) {
        this.f19227f.setCopyTextGestureListener(copyStoryTextListener);
    }

    public final void iD_() {
        this.f19227f.iD_();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1794671896);
        boolean z = this.f19227f.m26959a(motionEvent) && super.onTouchEvent(motionEvent);
        LogUtils.a(483709802, a);
        return z;
    }
}
