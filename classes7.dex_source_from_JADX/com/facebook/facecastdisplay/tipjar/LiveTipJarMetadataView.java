package com.facebook.facecastdisplay.tipjar;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.resources.ui.FbButton;

/* compiled from: asset_count_before_edit */
public class LiveTipJarMetadataView extends ImageBlockLayout {
    private static final CallerContext f19094h = CallerContext.a(LiveTipJarMetadataView.class);
    private final FbDraweeView f19095i;
    private final TextView f19096j;
    private final FbButton f19097k;
    private final FbButton f19098l;

    public LiveTipJarMetadataView(Context context) {
        this(context, null);
    }

    public LiveTipJarMetadataView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveTipJarMetadataView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130905092);
        this.f19095i = (FbDraweeView) getView(2131563507);
        this.f19096j = (TextView) getView(2131563508);
        this.f19097k = (FbButton) getView(2131563509);
        this.f19098l = (FbButton) getView(2131563510);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131428244);
        Drawable drawable = getResources().getDrawable(2130840056);
        Drawable drawable2 = getResources().getDrawable(2130839755);
        drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        drawable.setColorFilter(getResources().getColor(2131361956), Mode.SRC_ATOP);
        drawable2.setColorFilter(getResources().getColor(2131361956), Mode.SRC_ATOP);
        this.f19097k.setCompoundDrawables(drawable, null, null, null);
        this.f19098l.setCompoundDrawables(drawable2, null, null, null);
    }

    public void setTitle(FeedProps<GraphQLStory> feedProps) {
        CharSequence charSequence = null;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        if (!(graphQLStory == null || StoryAttachmentHelper.o(graphQLStory) == null || StoryAttachmentHelper.o(graphQLStory).r() == null)) {
            GraphQLMedia r = StoryAttachmentHelper.o(graphQLStory).r();
            charSequence = r.aF() != null ? r.aF().aa() : null;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(2131361921)), 0, spannableString.length(), 18);
        spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 18);
        SpannableString spannableString2 = new SpannableString(getResources().getString(2131232709));
        spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(2131361956)), 0, spannableString2.length(), 18);
        this.f19096j.setText(TextUtils.concat(new CharSequence[]{spannableString2, " ", spannableString}));
    }

    public void setProfilePicture(String str) {
        if (str != null) {
            this.f19095i.setVisibility(0);
            this.f19095i.a(Uri.parse(str), f19094h);
            return;
        }
        this.f19095i.setVisibility(8);
    }
}
