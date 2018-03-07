package com.facebook.feedback.ui.rows.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.view.ViewCompat;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import com.facebook.attachments.AttachmentStyleUtil;
import com.facebook.attachments.ui.AttachmentsSection;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.ui.util.CombinedDrawable;
import com.facebook.common.ui.util.CombinedDrawable.Align;
import com.facebook.common.ui.util.CombinedDrawable.Combine;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.feed.flyout.renderer.FeedFlyoutRenderer;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.ui.CommentBackgroundUtil;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.enums.GraphQLTranslatabilityType;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLCommentHelper;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
import com.facebook.graphql.querybuilder.convertible.DefaultGraphQLConversionHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.resources.ui.FbTextView;
import com.facebook.resources.utils.TextViewUtils;
import com.facebook.translation.ui.TranslatableTextView;
import com.facebook.translation.ui.TranslatableView;
import com.facebook.ufiservices.flyout.renderer.IFlyoutRenderer;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.ufiservices.util.LinkifyUtilConverter;
import com.facebook.ui.emoji.EmojiUtil;
import com.facebook.work.groups.multicompany.bridge.DefaultMultiCompanyGroupIconProvider;
import com.facebook.work.groups.multicompany.bridge.MultiCompanyGroupIconProvider;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: resumeQueueConnectionIfMqttConnected failed for %s queue. Not connected to sync.  viewerContextUserId = %s */
public abstract class CommentHeaderBaseView extends ImageBlockLayout implements HighlightableView, TranslatableView {
    public static Drawable f5162w;
    public static Drawable f5163x;
    public static Drawable f5164y;
    @Inject
    LinkifyUtil f5165h;
    @Inject
    public Lazy<MultiCompanyGroupIconProvider> f5166i;
    public TranslatableTextView f5167j;
    public String f5168k;
    public GraphQLTranslatabilityType f5169l;
    @Inject
    private IFlyoutRenderer f5170m;
    @Inject
    private CommentBackgroundUtil f5171n;
    @Inject
    private EmojiUtil f5172o;
    private FbDraweeView f5173p;
    public FbTextView f5174q;
    private AttachmentsSection f5175r;
    private OnTouchListener f5176s;
    private boolean f5177t = false;
    private boolean f5178u = false;
    private boolean f5179v = false;

    public static void m5618a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((CommentHeaderBaseView) obj).m5617a((IFlyoutRenderer) FeedFlyoutRenderer.m22719b(injectorLike), CommentBackgroundUtil.m4807a(injectorLike), EmojiUtil.a(injectorLike), LinkifyUtil.a(injectorLike), IdBasedLazy.a(injectorLike, 11777));
    }

    public abstract void setBody(CharSequence charSequence);

    private void m5617a(IFlyoutRenderer iFlyoutRenderer, CommentBackgroundUtil commentBackgroundUtil, EmojiUtil emojiUtil, LinkifyUtil linkifyUtil, Lazy<MultiCompanyGroupIconProvider> lazy) {
        this.f5170m = iFlyoutRenderer;
        this.f5171n = commentBackgroundUtil;
        this.f5172o = emojiUtil;
        this.f5165h = linkifyUtil;
        this.f5166i = lazy;
    }

    public CommentHeaderBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = CommentHeaderBaseView.class;
        m5618a((Object) this, getContext());
    }

    public final void m5624a(@Nullable GraphQLProfile graphQLProfile, @Nullable Uri uri, CallerContext callerContext) {
        this.f5173p.a(uri, callerContext);
        this.f5170m.a(this.f5173p, graphQLProfile, null);
        if (graphQLProfile != null) {
            this.f5173p.setContentDescription(getContext().getString(2131233315, new Object[]{graphQLProfile.U()}));
            return;
        }
        this.f5173p.setContentDescription("");
    }

    public final void m5623a(FeedProps<GraphQLComment> feedProps, AttachmentStyleUtil attachmentStyleUtil) {
        if (GraphQLCommentHelper.b((GraphQLComment) feedProps.a)) {
            Object obj;
            if (attachmentStyleUtil.a(feedProps.a(GraphQLCommentHelper.c((GraphQLComment) feedProps.a))) != GraphQLStoryAttachmentStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                if (this.f5175r == null) {
                    this.f5175r = (AttachmentsSection) ((ViewStub) getView(2131560436)).inflate();
                }
                this.f5175r.setVisibility(0);
                this.f5175r.m996a((FeedProps) feedProps, attachmentStyleUtil);
                return;
            }
        }
        if (this.f5175r != null) {
            this.f5175r.setVisibility(8);
        }
    }

    public void setVerifiedBadgeVisibility(boolean z) {
        this.f5177t = z;
        if (z) {
            if (f5162w == null) {
                f5162w = getResources().getDrawable(2130843879);
            }
            Drawable drawable = f5162w;
        }
        mo280h();
    }

    public void setPinnedIconVisibility(boolean z) {
        this.f5178u = z;
        if (z) {
            if (f5163x == null) {
                f5163x = getResources().getDrawable(2130840063);
            }
            Drawable drawable = f5163x;
        }
        mo280h();
    }

    public void setWorkMultiCompanyIconVisibiity(boolean z) {
        this.f5179v = z;
        if (z) {
            if (f5164y == null) {
                DefaultMultiCompanyGroupIconProvider defaultMultiCompanyGroupIconProvider = (DefaultMultiCompanyGroupIconProvider) this.f5166i.get();
                f5164y = null;
            }
            Drawable drawable = f5164y;
        }
        mo280h();
    }

    public final void mo279a(ValueAnimator valueAnimator) {
        CommentBackgroundUtil.m4809a(getBackground(), valueAnimator);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        if (this.f5176s != null) {
            this.f5176s.onTouch(this, motionEvent);
        }
        return false;
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
        this.f5176s = onTouchListener;
    }

    public final void m5621a() {
        this.f5167j.a();
    }

    public final boolean m5626g() {
        return this.f5167j.d();
    }

    protected void setThumbnailPaddingAndBackgroundDrawable(Context context) {
        setThumbnailPadding(getResources().getDimensionPixelSize(2131428721));
        setBackgroundDrawable(this.f5171n.m4813a(context));
    }

    protected void getViews() {
        this.f5173p = (FbDraweeView) getView(2131560433);
        ViewCompat.d(this.f5173p, 2);
        this.f5174q = (FbTextView) getView(2131560434);
        this.f5174q.setMovementMethod(LinkMovementMethod.getInstance());
        this.f5167j = (TranslatableTextView) getView(2131560435);
    }

    @Nullable
    protected final CharSequence m5625b(DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel) {
        if (defaultTextWithEntitiesLongFieldsModel == null) {
            return null;
        }
        return m5620a(LinkifyUtil.a(this.f5165h.a(LinkifyUtilConverter.c(DefaultGraphQLConversionHelper.m5800a((DefaultTextWithEntitiesLongFields) defaultTextWithEntitiesLongFieldsModel)), true, null)));
    }

    protected final CharSequence m5620a(CharSequence charSequence) {
        CharSequence spannableStringBuilder = new SpannableStringBuilder(charSequence);
        this.f5172o.a(spannableStringBuilder, (int) this.f5167j.getTextSize());
        return spannableStringBuilder;
    }

    private void mo280h() {
        Drawable combinedDrawable;
        if (this.f5177t || this.f5178u || this.f5179v) {
            combinedDrawable = new CombinedDrawable(Combine.HORIZONTAL, Align.CENTER, 1, new Drawable[]{f5162w, f5163x, f5164y});
        } else {
            combinedDrawable = null;
        }
        TextViewUtils.a(this.f5174q, null, null, combinedDrawable, null);
    }
}
