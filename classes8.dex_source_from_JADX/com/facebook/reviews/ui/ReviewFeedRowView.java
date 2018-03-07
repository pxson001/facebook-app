package com.facebook.reviews.ui;

import android.content.Context;
import android.net.Uri;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.analytics.CurationSurface;
import com.facebook.android.maps.StaticMapView.StaticMapOptions;
import com.facebook.attachments.angora.actionbutton.SaveButton;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.ui.util.CompoundTouchDelegate;
import com.facebook.common.util.SeparatedSpannableStringBuilder;
import com.facebook.common.util.SizeUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.widget.FeedbackCustomPressStateButton;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStreetAddress;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.FbStaticMapView;
import com.facebook.resources.ui.ExpandingEllipsizingTextView;
import com.facebook.resources.ui.ExpandingEllipsizingTextView.ExpandState;
import com.facebook.resources.ui.ExpandingEllipsizingTextView.OnExpandStateChangeListener;
import com.facebook.reviews.analytics.ReviewsClickEventTargets;
import com.facebook.reviews.analytics.ReviewsLogger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.springbutton.TouchSpring;
import com.facebook.widget.touch.TouchDelegateUtils;
import com.google.common.base.Strings;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: TimeToSurfaceOnViewCreated */
public class ReviewFeedRowView extends CustomLinearLayout {
    private static final CallerContext f21770e = CallerContext.a(ReviewFeedRowView.class);
    @Inject
    public AbstractFbErrorReporter f21771a;
    @Inject
    public GlyphColorizer f21772b;
    @Inject
    public Provider<TouchSpring> f21773c;
    @Inject
    public ReviewsLogger f21774d;
    private ContentViewWithButton f21775f;
    private FbDraweeView f21776g;
    private FbDraweeView f21777h;
    private FbStaticMapView f21778i;
    private LinearLayout f21779j;
    private SaveButton f21780k;
    private TextView f21781l;
    private TextView f21782m;
    private ImageView f21783n;
    private TextView f21784o;
    private ExpandingEllipsizingTextView f21785p;
    private TextView f21786q;
    private View f21787r;
    private FeedbackCustomPressStateButton f21788s;
    private FeedbackCustomPressStateButton f21789t;

    private static <T extends View> void m25269a(Class<T> cls, T t) {
        m25270a((Object) t, t.getContext());
    }

    private static void m25270a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ReviewFeedRowView reviewFeedRowView = (ReviewFeedRowView) obj;
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        GlyphColorizer a = GlyphColorizer.a(fbInjector);
        Provider a2 = IdBasedProvider.a(fbInjector, 3736);
        ReviewsLogger a3 = ReviewsLogger.a(fbInjector);
        reviewFeedRowView.f21771a = abstractFbErrorReporter;
        reviewFeedRowView.f21772b = a;
        reviewFeedRowView.f21773c = a2;
        reviewFeedRowView.f21774d = a3;
    }

    public ReviewFeedRowView(Context context) {
        super(context);
        m25267a();
    }

    public ReviewFeedRowView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m25267a();
    }

    protected ReviewFeedRowView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m25267a();
    }

    private void m25267a() {
        m25269a(ReviewFeedRowView.class, (View) this);
        setContentView(2130906851);
        setOrientation(1);
        this.f21776g = (FbDraweeView) a(2131567003);
        this.f21781l = (TextView) a(2131567004);
        this.f21781l.setMovementMethod(LinkMovementMethod.getInstance());
        this.f21782m = (TextView) a(2131567005);
        this.f21783n = (ImageView) a(2131567006);
        this.f21784o = (TextView) a(2131567007);
        this.f21785p = (ExpandingEllipsizingTextView) a(2131567008);
        this.f21786q = (TextView) a(2131567010);
        this.f21787r = a(2131567011);
        m25273b();
    }

    private void m25273b() {
        this.f21788s = m25266a(2131567012, 2131233267, 2130843790);
        this.f21789t = m25266a(2131567013, 2131233269, 2130843788);
    }

    private FeedbackCustomPressStateButton m25266a(int i, int i2, int i3) {
        FeedbackCustomPressStateButton feedbackCustomPressStateButton = (FeedbackCustomPressStateButton) a(i);
        feedbackCustomPressStateButton.setText(getResources().getString(i2));
        feedbackCustomPressStateButton.setImageDrawable(this.f21772b.a(i3, -7235677));
        feedbackCustomPressStateButton.setSpring((TouchSpring) this.f21773c.get());
        return feedbackCustomPressStateButton;
    }

    public void setProfilePicture(@Nullable Uri uri) {
        this.f21776g.a(uri, CallerContext.a(ReviewFeedRowView.class));
    }

    public void setProfilePicOnClickListener(OnClickListener onClickListener) {
        this.f21776g.setOnClickListener(onClickListener);
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.f21781l.setText(charSequence);
    }

    public void setTitleOnClickListener(OnClickListener onClickListener) {
        this.f21781l.setOnClickListener(onClickListener);
    }

    public void setTitleTextAppearance(int i) {
        this.f21781l.setTextAppearance(getContext(), i);
    }

    public void setSubtitle(SpannableString spannableString) {
        this.f21782m.setMovementMethod(LinkMovementMethod.getInstance());
        this.f21782m.setText(spannableString);
    }

    public void setSecondaryActionVisibility(int i) {
        this.f21783n.setVisibility(i);
    }

    public void setSecondaryActionClickListener(@Nullable OnClickListener onClickListener) {
        this.f21783n.setOnClickListener(onClickListener);
    }

    public final void m25277a(@Nullable SpannableStringBuilder spannableStringBuilder, @Nullable SpannableStringBuilder spannableStringBuilder2) {
        if ((spannableStringBuilder == null || spannableStringBuilder.length() == 0) && (spannableStringBuilder2 == null || spannableStringBuilder2.length() == 0)) {
            this.f21771a.a(ReviewFeedRowView.class.getName(), "Tried to set a review without a rating");
            this.f21784o.setVisibility(8);
            this.f21785p.setVisibility(8);
        } else if (spannableStringBuilder == null || spannableStringBuilder.length() == 0) {
            setMargin(false);
            this.f21784o.setVisibility(8);
            this.f21785p.setVisibility(0);
            this.f21785p.setText(spannableStringBuilder2);
        } else if (spannableStringBuilder2 == null || spannableStringBuilder2.length() == 0) {
            setMargin(false);
            this.f21784o.setVisibility(0);
            this.f21785p.setVisibility(8);
            this.f21784o.setText(spannableStringBuilder);
        } else {
            setMargin(true);
            this.f21784o.setVisibility(0);
            this.f21785p.setVisibility(0);
            this.f21784o.setText(spannableStringBuilder);
            this.f21785p.setText(spannableStringBuilder2);
        }
    }

    private void setMargin(boolean z) {
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(2131430067);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(2131430057);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f21784o.getLayoutParams();
        marginLayoutParams.setMargins(dimensionPixelOffset2, dimensionPixelOffset, dimensionPixelOffset2, z ? dimensionPixelOffset : dimensionPixelOffset2);
        this.f21784o.setLayoutParams(marginLayoutParams);
        marginLayoutParams = (MarginLayoutParams) this.f21785p.getLayoutParams();
        marginLayoutParams.setMargins(dimensionPixelOffset2, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset2);
        this.f21785p.setLayoutParams(marginLayoutParams);
    }

    public void setReviewTextOnExpandStateChangeListener(OnExpandStateChangeListener onExpandStateChangeListener) {
        this.f21785p.setOnExpandedStateChangeListener(onExpandStateChangeListener);
    }

    public void setReviewTextExpandedState(ExpandState expandState) {
        this.f21785p.setExpandState(expandState);
    }

    public void setFeedbackSummary(SpannableStringBuilder spannableStringBuilder) {
        if (spannableStringBuilder.length() == 0) {
            this.f21786q.setVisibility(8);
            return;
        }
        this.f21786q.setVisibility(0);
        this.f21786q.setText(spannableStringBuilder);
        this.f21786q.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void setFeedbackDividerVisibility(int i) {
        this.f21787r.setVisibility(i);
    }

    public void setLikeButtonVisibility(int i) {
        this.f21788s.setVisibility(i);
    }

    public void setLikeButtonClickListener(OnClickListener onClickListener) {
        this.f21788s.setOnClickListener(onClickListener);
    }

    public void setLikeButtonLikeState(boolean z) {
        if (z) {
            this.f21788s.setTextColor(getResources().getColor(2131361917));
            this.f21788s.setImageDrawable(getResources().getDrawable(2130843791));
            return;
        }
        this.f21788s.setTextColor(getResources().getColor(2131361937));
        this.f21788s.setImageDrawable(this.f21772b.a(2130843790, -7235677));
    }

    public void setCommentButtonClickListener(OnClickListener onClickListener) {
        this.f21789t.setOnClickListener(onClickListener);
    }

    public void setCommentButtonVisibility(int i) {
        this.f21789t.setVisibility(i);
    }

    public void setPageAttachmentView(@Nullable FeedProps<GraphQLStory> feedProps) {
        if (feedProps == null) {
            this.f21779j.setVisibility(8);
            return;
        }
        if (this.f21779j == null) {
            m25268a(((ViewStub) findViewById(2131567009)).inflate());
        }
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        if (StoryAttachmentHelper.o(graphQLStory) == null || StoryAttachmentHelper.o(graphQLStory).z() == null) {
            this.f21779j.setVisibility(8);
            return;
        }
        final GraphQLNode z = StoryAttachmentHelper.o(graphQLStory).z();
        this.f21780k.a(z, CurationSurface.PAGE_SEE_ALL_REVIEWS, feedProps, new OnClickListener(this) {
            final /* synthetic */ ReviewFeedRowView f21769b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 847219144);
                this.f21769b.f21774d.a("user_reviews_list", z.dp(), z.bx() != null ? z.bx().H() : null, ReviewsClickEventTargets.USER_REVIEWS_ATTACHMENT_SAVE);
                LogUtils.a(-172657455, a);
            }
        });
        this.f21779j.setVisibility(0);
        setCoverPhotoOrMapView(z);
        setProfilePhotoLayout(z);
        CharSequence a = m25265a(z);
        this.f21775f.setTitleText(a);
        this.f21775f.setContentDescription(a);
        this.f21775f.setSubtitleText(m25272b(z));
    }

    private void m25268a(View view) {
        this.f21779j = (LinearLayout) view.findViewById(2131566986);
        this.f21778i = (FbStaticMapView) view.findViewById(2131566987);
        this.f21777h = (FbDraweeView) this.f21779j.findViewById(2131566988);
        this.f21775f = (ContentViewWithButton) this.f21779j.findViewById(2131566989);
        this.f21780k = (SaveButton) this.f21779j.findViewById(2131566990);
    }

    private void setCoverPhotoOrMapView(GraphQLNode graphQLNode) {
        if (graphQLNode.br() == null || graphQLNode.br().j() == null || graphQLNode.br().j().L() == null) {
            this.f21777h.setVisibility(8);
            if (graphQLNode.er() == null) {
                this.f21778i.setVisibility(8);
                return;
            }
            this.f21778i.setVisibility(0);
            this.f21778i.setMapOptions(new StaticMapOptions("place_review_ego_unit").a(graphQLNode.er().a(), graphQLNode.er().b()).a(graphQLNode.ev()));
            return;
        }
        this.f21778i.setVisibility(8);
        this.f21777h.setVisibility(0);
        this.f21777h.a(ImageUtil.a(graphQLNode.br().j().L()), f21770e);
    }

    private void setProfilePhotoLayout(GraphQLNode graphQLNode) {
        GraphQLPhoto gh = graphQLNode.gh();
        if (gh == null || gh.L() == null || gh.L().b() == null) {
            this.f21775f.setThumbnailDrawable(getResources().getDrawable(2130842668));
        } else {
            this.f21775f.setThumbnailUri(ImageUtil.a(gh.L()));
        }
    }

    public void setAttachmentClickListener(OnClickListener onClickListener) {
        this.f21779j.setOnClickListener(onClickListener);
        if (this.f21778i != null && this.f21778i.getVisibility() == 0) {
            this.f21778i.setOnClickListener(onClickListener);
        }
    }

    private static Spannable m25265a(GraphQLNode graphQLNode) {
        Spannable spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(graphQLNode.eP());
        spannableStringBuilder.setSpan(new StyleSpan(1), 0, spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    private static Spannable m25272b(GraphQLNode graphQLNode) {
        Spannable c = m25274c(graphQLNode);
        if (c.length() > 0) {
            c.append("\n");
        }
        CharSequence d = m25276d(graphQLNode);
        if (!Strings.isNullOrEmpty(d)) {
            c.append(d);
        }
        return c;
    }

    private static SpannableStringBuilder m25274c(GraphQLNode graphQLNode) {
        SeparatedSpannableStringBuilder separatedSpannableStringBuilder = new SeparatedSpannableStringBuilder();
        if (graphQLNode.aZ() != null) {
            List aZ = graphQLNode.aZ();
            if (aZ.size() > 2) {
                aZ = aZ.subList(0, 2);
            }
            for (String a : r0) {
                separatedSpannableStringBuilder.a(a);
            }
        }
        return separatedSpannableStringBuilder;
    }

    @Nullable
    private static String m25276d(GraphQLNode graphQLNode) {
        GraphQLStreetAddress s = graphQLNode.s();
        if (s == null) {
            return null;
        }
        return s.p() != null ? s.p() : s.k();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m25275c();
    }

    private void m25275c() {
        List arrayList = new ArrayList();
        int c = SizeUtil.c(getContext(), getResources().getDimension(2131430058));
        m25271a(arrayList, this.f21783n, c);
        m25271a(arrayList, this.f21786q, c);
        if (arrayList.isEmpty()) {
            setTouchDelegate(null);
        } else {
            setTouchDelegate(new CompoundTouchDelegate(this, (TouchDelegate[]) arrayList.toArray(new TouchDelegate[arrayList.size()])));
        }
    }

    private void m25271a(List<TouchDelegate> list, View view, int i) {
        if (view.getVisibility() == 0) {
            list.add(TouchDelegateUtils.a(view, this, i));
        }
    }
}
