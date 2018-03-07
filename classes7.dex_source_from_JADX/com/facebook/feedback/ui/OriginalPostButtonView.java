package com.facebook.feedback.ui;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.feedback.abtest.ExperimentsForFeedbackTestModule;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLActorUtil;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.inject.FbInjector;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.linkify.LinkifyTargetBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ufiservices.util.LinkifyUtil;
import javax.inject.Inject;

/* compiled from: rotation-degrees */
public class OriginalPostButtonView extends ImageBlockLayout {
    @Inject
    public QeAccessor f4646h;
    @Inject
    public LinkifyUtil f4647i;
    @Inject
    public IFeedIntentBuilder f4648j;
    @Inject
    public SecureContextHelper f4649k;
    private FbTextView f4650l;

    private static <T extends View> void m5184a(Class<T> cls, T t) {
        m5185a((Object) t, t.getContext());
    }

    private static void m5185a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((OriginalPostButtonView) obj).m5183a((QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), LinkifyUtil.a(fbInjector), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector));
    }

    private void m5183a(QeAccessor qeAccessor, LinkifyUtil linkifyUtil, IFeedIntentBuilder iFeedIntentBuilder, SecureContextHelper secureContextHelper) {
        this.f4646h = qeAccessor;
        this.f4647i = linkifyUtil;
        this.f4648j = iFeedIntentBuilder;
        this.f4649k = secureContextHelper;
    }

    public OriginalPostButtonView(Context context) {
        this(context, null);
    }

    public OriginalPostButtonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OriginalPostButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5182a();
    }

    private void m5182a() {
        m5184a(OriginalPostButtonView.class, (View) this);
        setContentView(2130905924);
        if (this.f4646h.a(ExperimentsForFeedbackTestModule.P, true)) {
            m5186f();
        }
    }

    private void m5186f() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int applyDimension = (int) TypedValue.applyDimension(1, 52.0f, displayMetrics);
        int applyDimension2 = (int) TypedValue.applyDimension(1, 12.0f, displayMetrics);
        LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null && this.f4646h.a(ExperimentsForFeedbackTestModule.n, false)) {
            layoutParams = new MarginLayoutParams(-1, applyDimension);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
            marginLayoutParams.width = -1;
            marginLayoutParams.height = applyDimension;
            applyDimension = (int) TypedValue.applyDimension(1, 8.0f, displayMetrics);
            marginLayoutParams.setMargins(applyDimension, 0, applyDimension, applyDimension2);
            setLayoutParams(marginLayoutParams);
        }
        if (this.f4646h.a(ExperimentsForFeedbackTestModule.M, false)) {
            setBackgroundResource(2130843027);
        } else {
            setBackgroundResource(2130843026);
        }
        setPaddingRelative(applyDimension2, 0, applyDimension2, 0);
        setGravity(17);
        setThumbnailSize((int) TypedValue.applyDimension(1, 28.0f, displayMetrics));
        setThumbnailPadding(0);
        setThumbnailGravity(17);
        setThumbnailResource(2130841701);
    }

    public final void m5187a(final GraphQLStory graphQLStory) {
        Uri uri;
        GraphQLActor b = graphQLStory != null ? StoryActorHelper.b(graphQLStory) : null;
        if (b == null || TextUtils.isEmpty(GraphQLActorUtil.c(b))) {
            uri = null;
        } else {
            uri = Uri.parse(GraphQLActorUtil.c(b));
        }
        if (uri != null) {
            setThumbnailUri(uri);
            setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ OriginalPostButtonView f4645b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1474054741);
                    this.f4645b.f4649k.a(this.f4645b.f4648j.a(graphQLStory), this.f4645b.getContext());
                    Logger.a(2, EntryType.UI_INPUT_END, 722896198, a);
                }
            });
            if (this.f4650l == null) {
                this.f4650l = (FbTextView) getView(2131565274);
            }
            this.f4650l.setText(TextUtils.concat(new CharSequence[]{"See original post from ", this.f4647i.a(LinkifyTargetBuilder.a(b), null, LinkifyUtil.a, true)}));
        }
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 2077722292);
        super.onAttachedToWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 996809660, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -583304492);
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1276341429, a);
    }
}
