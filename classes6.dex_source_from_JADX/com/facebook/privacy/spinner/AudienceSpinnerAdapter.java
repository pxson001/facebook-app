package com.facebook.privacy.spinner;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.graphql.enums.GraphQLPrivacyOptionType;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.inject.Assisted;
import com.facebook.privacy.model.PrivacyOptionHelper;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFieldsWithExplanation;
import com.facebook.privacy.spinner.AudienceSpinner.AudienceExplanationDisplayMode;
import com.facebook.privacy.ui.PrivacyIcons;
import com.facebook.privacy.ui.PrivacyIcons.Size;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.listview.FbBaseAdapter;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: fax_home */
public class AudienceSpinnerAdapter extends FbBaseAdapter {
    private final LayoutInflater f15291a;
    private final PrivacyIcons f15292b;
    private final Resources f15293c;
    private final GlyphColorizer f15294d;
    private final AudienceSpinnerData f15295e;
    public PrivacyOptionFieldsWithExplanation f15296f;
    public final String f15297g;
    private final AudienceExplanationDisplayMode f15298h;

    public /* synthetic */ Object getItem(int i) {
        return m22939a(i);
    }

    @Inject
    public AudienceSpinnerAdapter(LayoutInflater layoutInflater, PrivacyIcons privacyIcons, Resources resources, GlyphColorizer glyphColorizer, @Assisted AudienceSpinnerData audienceSpinnerData, @Assisted AudienceExplanationDisplayMode audienceExplanationDisplayMode, @Nullable @Assisted String str) {
        this.f15291a = layoutInflater;
        this.f15292b = privacyIcons;
        this.f15293c = resources;
        this.f15294d = glyphColorizer;
        this.f15295e = audienceSpinnerData;
        this.f15298h = audienceExplanationDisplayMode;
        this.f15297g = str;
        this.f15296f = audienceSpinnerData.m22948b();
    }

    public final void m22940a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        GraphQLPrivacyOption graphQLPrivacyOption = (GraphQLPrivacyOption) obj;
        boolean equals = graphQLPrivacyOption.equals(this.f15296f);
        int c = m22936c(equals);
        LinearLayout linearLayout = (LinearLayout) view;
        GlyphView glyphView = (GlyphView) linearLayout.findViewById(2131559747);
        GlyphView glyphView2 = (GlyphView) linearLayout.findViewById(2131559744);
        FbTextView fbTextView = (FbTextView) linearLayout.findViewById(2131559745);
        FbTextView fbTextView2 = (FbTextView) linearLayout.findViewById(2131559746);
        fbTextView.setText(graphQLPrivacyOption.d());
        fbTextView.setTextColor(m22932a(equals));
        if (m22934a(graphQLPrivacyOption)) {
            fbTextView2.setVisibility(0);
            fbTextView2.setText(graphQLPrivacyOption.j());
            fbTextView2.setTextColor(m22935b(equals));
        } else {
            fbTextView2.setVisibility(8);
        }
        glyphView2.setImageDrawable(m22933a(this.f15292b.m22957a(PrivacyOptionHelper.a(graphQLPrivacyOption), Size.TOKEN), c, 2131429373));
        if (equals) {
            glyphView.setImageDrawable(m22933a(2130839774, c, 2131429375));
        } else {
            glyphView.setImageDrawable(null);
        }
    }

    private int m22932a(boolean z) {
        if (z) {
            return this.f15293c.getColor(2131361917);
        }
        return this.f15293c.getColor(2131361972);
    }

    private int m22935b(boolean z) {
        if (z) {
            return this.f15293c.getColor(2131361917);
        }
        return this.f15293c.getColor(2131361974);
    }

    private static int m22936c(boolean z) {
        if (z) {
            return 2131361917;
        }
        return 2131361973;
    }

    private boolean m22934a(GraphQLPrivacyOption graphQLPrivacyOption) {
        if (StringUtil.a(graphQLPrivacyOption.j()) || this.f15298h == AudienceExplanationDisplayMode.AUDIENCE_SHOW_NONE) {
            return false;
        }
        if (this.f15298h == AudienceExplanationDisplayMode.AUDIENCE_SHOW_ALL) {
            return true;
        }
        GraphQLPrivacyOptionType a = PrivacyOptionHelper.a(graphQLPrivacyOption);
        if (this.f15298h == AudienceExplanationDisplayMode.AUDIENCE_SHOW_PUBLIC_FRIENDS_AND_CUSTOM && (a.equals(GraphQLPrivacyOptionType.EVERYONE) || a.equals(GraphQLPrivacyOptionType.FRIENDS) || a.equals(GraphQLPrivacyOptionType.CUSTOM) || a.equals(GraphQLPrivacyOptionType.FRIENDS_EXCEPT))) {
            return true;
        }
        return false;
    }

    private Drawable m22933a(int i, int i2, int i3) {
        Drawable a = this.f15294d.a(i, this.f15293c.getColor(i2));
        int dimensionPixelSize = this.f15293c.getDimensionPixelSize(i3);
        a.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        return a;
    }

    public final void m22941a(PrivacyOptionFieldsWithExplanation privacyOptionFieldsWithExplanation) {
        this.f15296f = privacyOptionFieldsWithExplanation;
    }

    public final PrivacyOptionFieldsWithExplanation m22938a() {
        return this.f15296f;
    }

    public final int m22942b() {
        return this.f15295e.m22946a(this.f15296f);
    }

    public final View m22937a(int i, ViewGroup viewGroup) {
        return this.f15291a.inflate(2130903316, viewGroup, false);
    }

    public int getCount() {
        return this.f15295e.f15299a.size();
    }

    public final PrivacyOptionFieldsWithExplanation m22939a(int i) {
        return (PrivacyOptionFieldsWithExplanation) this.f15295e.f15299a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public final String m22943c() {
        return this.f15297g;
    }
}
