package com.facebook.feedplugins.quickpromotion.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.SizeUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.feed.rows.sections.header.ui.CanShowHeaderOptionsMenu;
import com.facebook.feedplugins.quickpromotion.QuickPromotionFeedUnitUtils;
import com.facebook.feedplugins.quickpromotion.QuickPromotionTemplate;
import com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.BrandingStyle;
import com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.LargeImageMarginOption;
import com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.TitleSize;
import com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.Type;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLQPTemplateParameter;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.user.model.User;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;
import com.google.common.collect.ImmutableList;
import javax.inject.Provider;

/* compiled from: capacity */
public class QuickPromotionLargeImageCreativeContentView extends CustomRelativeLayout implements CanShowHeaderOptionsMenu {
    private static final CallerContext f9012k = CallerContext.a(QuickPromotionLargeImageCreativeContentView.class, "quick_promotion_feed");
    private FbDraweeView f9013a;
    private FbDraweeView f9014b;
    private FbDraweeView f9015c;
    public Provider<User> f9016d;
    private QuickPromotionFbVideoView f9017e;
    public ImageView f9018f = ((ImageView) a(2131566490));
    public TextWithEntitiesView f9019g = ((TextWithEntitiesView) a(2131566487));
    public TextWithEntitiesView f9020h = ((TextWithEntitiesView) a(2131566488));
    public TextWithEntitiesView f9021i = ((TextWithEntitiesView) a(2131566489));
    public int f9022j;

    public QuickPromotionLargeImageCreativeContentView(Context context) {
        super(context);
        setContentView(2130906538);
    }

    public void setTitleText(GraphQLTextWithEntities graphQLTextWithEntities) {
        if (QuickPromotionFeedUnitUtils.m9626a(graphQLTextWithEntities)) {
            this.f9019g.a(graphQLTextWithEntities, this.f9019g.getTextSize(), 1);
            this.f9019g.setVisibility(0);
            return;
        }
        this.f9019g.setVisibility(8);
    }

    public final void m9722a(GraphQLTextWithEntities graphQLTextWithEntities, int i) {
        if (QuickPromotionFeedUnitUtils.m9626a(graphQLTextWithEntities)) {
            this.f9020h.a(graphQLTextWithEntities, this.f9020h.getTextSize(), 1);
            if (i > 0) {
                this.f9020h.setWidth((int) (0.8d * ((double) i)));
            }
            this.f9020h.setVisibility(0);
            return;
        }
        this.f9020h.setVisibility(8);
    }

    public final void m9723a(GraphQLTextWithEntities graphQLTextWithEntities, ImmutableList<GraphQLQPTemplateParameter> immutableList) {
        if (QuickPromotionFeedUnitUtils.m9626a(graphQLTextWithEntities)) {
            BrandingStyle fromString;
            this.f9021i.a(graphQLTextWithEntities, this.f9021i.getTextSize(), 1);
            BrandingStyle brandingStyle = BrandingStyle.BRANDING_BOTTOM_DIVIDER;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                GraphQLQPTemplateParameter graphQLQPTemplateParameter = (GraphQLQPTemplateParameter) immutableList.get(i);
                if (Type.NEWSFEED_BRANDING_STYLE == Type.fromString(graphQLQPTemplateParameter.j())) {
                    fromString = BrandingStyle.fromString(graphQLQPTemplateParameter.l());
                    break;
                }
            }
            fromString = BrandingStyle.UNKNOWN;
            if (brandingStyle == fromString) {
                Drawable drawable = getResources().getDrawable(2130839828);
                drawable.setBounds(0, 0, getResources().getDimensionPixelSize(2131434634), drawable.getIntrinsicHeight());
                this.f9021i.setCompoundDrawables(null, drawable, null, null);
                this.f9021i.setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131427420));
            } else {
                this.f9021i.setCompoundDrawables(null, null, null, null);
            }
            this.f9021i.setVisibility(0);
            return;
        }
        this.f9021i.setVisibility(8);
    }

    public final void m9719a(OnClickListener onClickListener, GraphQLImage graphQLImage) {
        if (this.f9014b == null) {
            ((ViewStub) findViewById(2131566485)).inflate();
        }
        this.f9014b = (FbDraweeView) findViewById(2131566486);
        int a = (int) (((double) m9716a(graphQLImage)) * 0.4d);
        LayoutParams layoutParams = (LayoutParams) this.f9014b.getLayoutParams();
        layoutParams.height = a;
        layoutParams.width = a;
        String str = ((User) this.f9016d.get()).z().a(a).url;
        this.f9014b.setVisibility(0);
        this.f9014b.a(Uri.parse(str), f9012k);
        this.f9014b.setOnClickListener(onClickListener);
    }

    public final void m9721a(GraphQLImage graphQLImage, OnClickListener onClickListener, int i) {
        this.f9022j = i;
        if (this.f9013a == null) {
            ((ViewStub) findViewById(2131566483)).inflate();
        }
        this.f9013a = (FbDraweeView) findViewById(2131566484);
        m9717a(this.f9013a, graphQLImage, onClickListener, (FrameLayout) findViewById(2131566480));
    }

    public void setBrandingImage(GraphQLImage graphQLImage) {
        if (graphQLImage != null) {
            if (this.f9015c == null) {
                ((ViewStub) findViewById(2131566491)).inflate();
            }
            this.f9015c = (FbDraweeView) findViewById(2131566492);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f9015c.getLayoutParams();
            layoutParams.width = graphQLImage.c();
            layoutParams.height = graphQLImage.a();
            this.f9015c.setVisibility(0);
            this.f9015c.a(ImageUtil.a(graphQLImage), f9012k);
        } else if (this.f9015c != null) {
            this.f9015c.setVisibility(8);
        }
    }

    public final void m9726a(ImmutableList<GraphQLQPTemplateParameter> immutableList, String str) {
        if (immutableList != null) {
            TitleSize fromString;
            TitleSize titleSize = TitleSize.SMALL;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                GraphQLQPTemplateParameter graphQLQPTemplateParameter = (GraphQLQPTemplateParameter) immutableList.get(i);
                if (Type.TITLE_SIZE == Type.fromString(graphQLQPTemplateParameter.j())) {
                    fromString = TitleSize.fromString(graphQLQPTemplateParameter.l());
                    break;
                }
            }
            fromString = TitleSize.UNKNOWN;
            if (titleSize == fromString) {
                this.f9019g.setTextSize((float) SizeUtil.c(getResources(), 2131427402));
                return;
            }
        }
        if (QuickPromotionTemplate.NEWSFEED_BRANDED_VIDEO == QuickPromotionTemplate.fromString(str)) {
            this.f9019g.setTextSize((float) SizeUtil.c(getResources(), 2131427404));
        }
    }

    public final void m9725a(ImmutableList<GraphQLQPTemplateParameter> immutableList) {
        if (immutableList != null) {
            LargeImageMarginOption fromString;
            LargeImageMarginOption largeImageMarginOption = LargeImageMarginOption.BOTTOM;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                GraphQLQPTemplateParameter graphQLQPTemplateParameter = (GraphQLQPTemplateParameter) immutableList.get(i);
                if (Type.NEWSFEED_LARGE_IMAGE_MARGIN_OPTION == Type.fromString(graphQLQPTemplateParameter.j())) {
                    fromString = LargeImageMarginOption.fromString(graphQLQPTemplateParameter.l());
                    break;
                }
            }
            fromString = LargeImageMarginOption.UNKNOWN;
            if (largeImageMarginOption == fromString) {
                this.f9019g.setPadding(this.f9019g.getPaddingLeft(), getResources().getDimensionPixelSize(2131430055), this.f9019g.getPaddingRight(), this.f9019g.getPaddingBottom());
            }
        }
    }

    private void m9717a(FbDraweeView fbDraweeView, GraphQLImage graphQLImage, OnClickListener onClickListener, FrameLayout frameLayout) {
        if (graphQLImage != null) {
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            layoutParams.width = this.f9022j;
            layoutParams.height = m9716a(graphQLImage);
            fbDraweeView.setVisibility(0);
            fbDraweeView.a(ImageUtil.a(graphQLImage), f9012k);
            fbDraweeView.setOnClickListener(onClickListener);
        }
    }

    private int m9716a(GraphQLImage graphQLImage) {
        return (int) ((((double) graphQLImage.a()) / ((double) graphQLImage.c())) * ((double) this.f9022j));
    }

    public final void m9718a() {
        if (this.f9014b != null) {
            this.f9014b.setVisibility(8);
            this.f9014b.setOnClickListener(null);
        }
        if (this.f9013a != null) {
            this.f9013a.setVisibility(8);
            this.f9013a.setOnClickListener(null);
        }
        if (this.f9015c != null) {
            this.f9015c.setVisibility(8);
        }
        if (this.f9017e != null) {
            this.f9017e.setVisibility(8);
        }
        this.f9018f.setVisibility(8);
        setOnClickListener(null);
        this.f9018f.setOnClickListener(null);
    }

    public void setMenuButtonActive(boolean z) {
        this.f9018f.setVisibility(z ? 0 : 8);
    }

    public final boolean hk_() {
        return this.f9018f.getVisibility() == 0;
    }

    public final void m9720a(Tooltip tooltip) {
        tooltip.f(this.f9018f);
    }

    public final void m9724a(GraphQLVideo graphQLVideo, GraphQLImage graphQLImage, int i) {
        this.f9022j = i;
        if (this.f9017e == null) {
            ((ViewStub) findViewById(2131566481)).inflate();
        }
        this.f9017e = (QuickPromotionFbVideoView) findViewById(2131566482);
        QuickPromotionFbVideoView quickPromotionFbVideoView = this.f9017e;
        double bw = ((double) graphQLVideo.bw()) / ((double) graphQLVideo.I());
        String b = graphQLImage.b();
        ViewGroup.LayoutParams layoutParams = quickPromotionFbVideoView.getLayoutParams();
        layoutParams.width = this.f9022j;
        layoutParams.height = (int) Math.ceil(((double) this.f9022j) / bw);
        quickPromotionFbVideoView.setVisibility(0);
        quickPromotionFbVideoView.m9714a(graphQLVideo.aE(), graphQLVideo.J(), b, bw);
        quickPromotionFbVideoView.iE_();
    }
}
