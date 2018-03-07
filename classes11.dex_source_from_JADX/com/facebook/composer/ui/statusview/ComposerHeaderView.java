package com.facebook.composer.ui.statusview;

import android.content.Context;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.ViewStub;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.composer.ui.text.ComposerMovementMethod;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.LazyView;

/* compiled from: fbLocaleIdentifier */
public class ComposerHeaderView extends ImageBlockLayout {
    private FbDraweeView f7131h;
    private FbTextView f7132i;
    public ViewStub f7133j;
    public LazyView<FbTextView> f7134k;
    public LazyView<FbTextView> f7135l;
    public LazyView<FixedPrivacyPillView> f7136m;
    public LazyView<FbTextView> f7137n;
    public LazyView<FbTextView> f7138o;
    public ViewStub f7139p;
    private DraweeHolder<GenericDraweeHierarchy> f7140q;
    public ViewStub f7141r;

    public ComposerHeaderView(Context context) {
        this(context, null);
    }

    public ComposerHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8354a();
    }

    private void m8354a() {
        setContentView(2130903681);
        this.f7131h = (FbDraweeView) getView(2131560531);
        this.f7132i = (FbTextView) getView(2131560532);
        this.f7132i.setMovementMethod(new ComposerMovementMethod());
        ((ViewStub) getView(2131560533)).inflate();
        this.f7133j = (ViewStub) getView(2131560595);
        this.f7134k = new LazyView((ViewStub) getView(2131560596));
        this.f7135l = new LazyView((ViewStub) getView(2131560597));
        this.f7136m = new LazyView((ViewStub) getView(2131560598));
        this.f7137n = new LazyView((ViewStub) getView(2131560599));
        this.f7138o = new LazyView((ViewStub) getView(2131560601));
        this.f7141r = (ViewStub) getView(2131560603);
        this.f7139p = (ViewStub) getView(2131560600);
    }

    public LazyView<FbTextView> getImplicitLocationPillView() {
        return this.f7137n;
    }

    public LazyView<FbTextView> getPagePublishOptionPillView() {
        return this.f7138o;
    }

    public LazyView<FbTextView> getTagExpansionPillView() {
        return this.f7135l;
    }

    public LazyView<FixedPrivacyPillView> getFixedPrivacyPillView() {
        return this.f7136m;
    }

    public LazyView<FbTextView> getSelectablePrivacyPillView() {
        return this.f7134k;
    }

    public ViewStub getLoadingPrivacyPillViewStub() {
        return this.f7133j;
    }

    public ViewStub getTopicPillsViewStub() {
        return this.f7141r;
    }

    public ViewStub getAlbumPillViewStub() {
        return this.f7139p;
    }

    public void setText(SpannableStringBuilder spannableStringBuilder) {
        this.f7132i.setText(spannableStringBuilder);
    }

    public final void m8355a(Uri uri, CallerContext callerContext) {
        this.f7131h.a(uri, callerContext);
    }

    public void setMinutiaeIconHolder(DraweeHolder<GenericDraweeHierarchy> draweeHolder) {
        this.f7140q = draweeHolder;
        ((GenericDraweeHierarchy) this.f7140q.f()).a().setCallback(this.f7132i);
    }

    public CharSequence getText() {
        return this.f7132i.getText();
    }

    public float getAscentForText() {
        return this.f7132i.getPaint().getFontMetrics().ascent;
    }

    public void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1075941807);
        super.onAttachedToWindow();
        if (this.f7140q != null) {
            this.f7140q.b();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1135864409, a);
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -786557512);
        super.onDetachedFromWindow();
        if (this.f7140q != null) {
            this.f7140q.d();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 425324168, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.f7140q != null) {
            this.f7140q.d();
        }
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.f7140q != null) {
            this.f7140q.b();
        }
    }
}
