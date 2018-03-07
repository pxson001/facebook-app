package com.facebook.pages.identity.fragments.moreinformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.graphql.enums.GraphQLPageInfoFieldStyle;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.querybuilder.convertible.DefaultGraphQLConversionHelper;
import com.facebook.inject.FbInjector;
import com.facebook.pages.common.ui.widgets.ExpandableTextView;
import com.facebook.pages.identity.fragments.moreinformation.PageInformationGenericAboutLineField.C05541;
import com.facebook.pages.identity.protocol.graphql.PageInformationDataGraphQLModels.PageInfoSectionFieldsModel;
import com.facebook.pages.identity.protocol.graphql.PageInformationDataGraphQLModels.PageInformationDataModel.PageInfoSectionsModel;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.ufiservices.util.LinkifyUtilConverter;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: pages_browser_data */
public class PageInformationGenericAboutCardView extends CustomFrameLayout {
    @Inject
    public LinkifyUtil f4019a;
    private final LayoutInflater f4020b;
    private final LinearLayout f4021c;

    private static <T extends View> void m4951a(Class<T> cls, T t) {
        m4952a((Object) t, t.getContext());
    }

    private static void m4952a(Object obj, Context context) {
        ((PageInformationGenericAboutCardView) obj).f4019a = LinkifyUtil.a(FbInjector.get(context));
    }

    public PageInformationGenericAboutCardView(Context context) {
        this(context, null);
    }

    public PageInformationGenericAboutCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PageInformationGenericAboutCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130906056);
        this.f4020b = LayoutInflater.from(context);
        this.f4021c = (LinearLayout) c(2131565599);
        m4951a(PageInformationGenericAboutCardView.class, (View) this);
    }

    public void setSectionData(PageInfoSectionsModel pageInfoSectionsModel) {
        ImmutableList a = pageInfoSectionsModel.a();
        int size = a.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            PageInfoSectionFieldsModel pageInfoSectionFieldsModel = (PageInfoSectionFieldsModel) a.get(i);
            if (i2 > 0) {
                this.f4021c.addView(m4948a());
            }
            View a2 = m4949a(pageInfoSectionFieldsModel);
            if (a2 != null) {
                this.f4021c.addView(a2);
                i3 = i2 + 1;
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
    }

    private View m4948a() {
        View inflate = this.f4020b.inflate(2130906053, null);
        inflate.setVisibility(0);
        return inflate;
    }

    private View m4949a(PageInfoSectionFieldsModel pageInfoSectionFieldsModel) {
        if (pageInfoSectionFieldsModel.j().contains(GraphQLPageInfoFieldStyle.PARAGRAPH)) {
            return m4953b(pageInfoSectionFieldsModel);
        }
        if (pageInfoSectionFieldsModel.j().contains(GraphQLPageInfoFieldStyle.LINE)) {
            return m4954c(pageInfoSectionFieldsModel);
        }
        return null;
    }

    private View m4953b(PageInfoSectionFieldsModel pageInfoSectionFieldsModel) {
        View inflate = this.f4020b.inflate(2130906055, null);
        ExpandableTextView expandableTextView = (ExpandableTextView) inflate.findViewById(2131565598);
        ((TextView) inflate.findViewById(2131565597)).setText(pageInfoSectionFieldsModel.a());
        expandableTextView.m3660a();
        expandableTextView.setText(this.f4019a.a(LinkifyUtilConverter.c(DefaultGraphQLConversionHelper.a(pageInfoSectionFieldsModel.k())), true, null));
        return inflate;
    }

    private View m4954c(PageInfoSectionFieldsModel pageInfoSectionFieldsModel) {
        PageInformationGenericAboutLineField pageInformationGenericAboutLineField = new PageInformationGenericAboutLineField(getContext());
        CharSequence a = pageInfoSectionFieldsModel.a();
        GraphQLTextWithEntities a2 = DefaultGraphQLConversionHelper.a(pageInfoSectionFieldsModel.k());
        pageInformationGenericAboutLineField.f4031i.clear();
        pageInformationGenericAboutLineField.f4028f = a;
        pageInformationGenericAboutLineField.f4029g = a2;
        pageInformationGenericAboutLineField.f4024b.setText(a);
        pageInformationGenericAboutLineField.f4026d.setVisibility(8);
        pageInformationGenericAboutLineField.f4025c.setVisibility(0);
        pageInformationGenericAboutLineField.f4025c.setText(pageInformationGenericAboutLineField.f4023a.a(LinkifyUtilConverter.c(pageInformationGenericAboutLineField.f4029g), true, null));
        pageInformationGenericAboutLineField.f4027e = pageInformationGenericAboutLineField.f4025c;
        pageInformationGenericAboutLineField.f4030h.getViewTreeObserver().addOnGlobalLayoutListener(new C05541(pageInformationGenericAboutLineField));
        return pageInformationGenericAboutLineField;
    }

    private void m4950a(LinkifyUtil linkifyUtil) {
        this.f4019a = linkifyUtil;
    }
}
