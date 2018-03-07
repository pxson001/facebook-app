package com.facebook.leadgen.view;

import android.content.Context;
import android.net.Uri;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.graphql.enums.GraphQLLeadGenContextPageContentStyle;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLLeadGenContextPage;
import com.facebook.graphql.model.GraphQLLeadGenPage;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.leadgen.LeadGenFormPageView;
import com.facebook.leadgen.LeadGenUtil;
import com.facebook.leadgen.LeadGenUtil$ValidationResult;
import com.facebook.leadgen.cache.LeadGenFormPendingInputEntry;
import com.facebook.leadgen.data.LeadGenDataExtractor;
import com.facebook.leadgen.input.LeadGenFieldInput.OnDataChangeListener;
import com.facebook.leadgen.util.CustomBulletSpan;
import com.facebook.leadgen.util.LeadGenInfoFieldUserData;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: photo_comment_without_text_posted */
public class LeadGenContextCardView extends LeadGenFormPageView {
    private static final CallerContext f6586a = CallerContext.a(LeadGenContextCardView.class, "native_newsfeed");

    public LeadGenContextCardView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        setContentView(2130905013);
    }

    public final void mo345a(GraphQLLeadGenPage graphQLLeadGenPage, int i, LeadGenDataExtractor leadGenDataExtractor, int i2, OnDataChangeListener onDataChangeListener) {
        if (leadGenDataExtractor.m8200a()) {
            String str;
            GraphQLPhoto n;
            ((FbDraweeView) a(2131563365)).a(leadGenDataExtractor.m8204m(), f6586a);
            TextView textView = (TextView) a(2131563374);
            GraphQLLeadGenContextPage s = LeadGenUtil.s(leadGenDataExtractor.f6368d);
            if (s == null) {
                str = null;
            } else {
                str = s.m();
            }
            textView.setText(str);
            FbDraweeView fbDraweeView = (FbDraweeView) a(2131563375);
            fbDraweeView.setVisibility(0);
            fbDraweeView.setAspectRatio(1.9318181f);
            s = LeadGenUtil.s(leadGenDataExtractor.f6368d);
            if (s != null) {
                n = s.n();
            } else {
                n = null;
            }
            GraphQLPhoto graphQLPhoto = n;
            if (graphQLPhoto == null || graphQLPhoto.b() == null) {
                Object obj;
                if (leadGenDataExtractor.f6368d.r() == null || leadGenDataExtractor.f6368d.r().j() == null || leadGenDataExtractor.f6368d.r().j().g() != 82650203) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    fbDraweeView.setVisibility(8);
                } else {
                    Uri uri = null;
                    GraphQLLeadGenContextPage s2 = LeadGenUtil.s(leadGenDataExtractor.f6368d);
                    if (s2 != null) {
                        GraphQLImage l = s2.l();
                        if (l != null) {
                            uri = ImageUtil.a(l);
                        }
                    }
                    Uri uri2 = uri;
                    if (uri2 == null) {
                        GraphQLStoryAttachment graphQLStoryAttachment = leadGenDataExtractor.f6368d;
                        uri = null;
                        if (!(graphQLStoryAttachment == null || GraphQLStoryAttachmentUtil.l(graphQLStoryAttachment) == null)) {
                            uri = ImageUtil.a(GraphQLStoryAttachmentUtil.n(graphQLStoryAttachment));
                        }
                        uri2 = uri;
                    }
                    fbDraweeView.a(uri2, f6586a);
                }
            } else {
                fbDraweeView.a(UriUtil.a(graphQLPhoto.b().b()), f6586a);
            }
            setUpDescriptionView(leadGenDataExtractor);
        }
    }

    public final void mo344a() {
    }

    public final LeadGenUtil$ValidationResult mo348c(int i) {
        return null;
    }

    public final ImmutableList<LeadGenInfoFieldUserData> mo347b() {
        return null;
    }

    public final void mo346a(LeadGenFormPendingInputEntry leadGenFormPendingInputEntry) {
    }

    private void setUpDescriptionView(LeadGenDataExtractor leadGenDataExtractor) {
        ImmutableList immutableList;
        LinearLayout linearLayout = (LinearLayout) a(2131563376);
        GraphQLLeadGenContextPage s = LeadGenUtil.s(leadGenDataExtractor.f6368d);
        if (s == null) {
            immutableList = null;
        } else {
            immutableList = s.a();
        }
        ImmutableList immutableList2 = immutableList;
        if (immutableList2 != null && !immutableList2.isEmpty()) {
            GraphQLLeadGenContextPageContentStyle graphQLLeadGenContextPageContentStyle;
            s = LeadGenUtil.s(leadGenDataExtractor.f6368d);
            if (s == null) {
                graphQLLeadGenContextPageContentStyle = null;
            } else {
                graphQLLeadGenContextPageContentStyle = s.j();
            }
            GraphQLLeadGenContextPageContentStyle graphQLLeadGenContextPageContentStyle2 = graphQLLeadGenContextPageContentStyle;
            int size = immutableList2.size();
            for (int i = 0; i < size; i++) {
                String str = (String) immutableList2.get(i);
                View textView = new TextView(getContext());
                textView.setTextSize(0, getResources().getDimension(2131429071));
                textView.setTextColor(getResources().getColor(2131363585));
                if (graphQLLeadGenContextPageContentStyle2 == GraphQLLeadGenContextPageContentStyle.LIST_STYLE) {
                    m8508a(textView, str);
                } else {
                    textView.setText(str);
                }
                linearLayout.addView(textView);
            }
        }
    }

    private void m8508a(TextView textView, String str) {
        CharSequence spannableString = new SpannableString(str);
        spannableString.setSpan(new CustomBulletSpan((int) getResources().getDimension(2131432234)), 0, str.length(), 0);
        textView.setText(spannableString);
        int dimension = (int) getResources().getDimension(2131432233);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, dimension);
        textView.setLayoutParams(layoutParams);
    }
}
