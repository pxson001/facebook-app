package com.facebook.pages.identity.fragments.moreinformation;

import android.content.Context;
import android.content.res.Configuration;
import android.text.method.LinkMovementMethod;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.FbInjector;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.ufiservices.util.LinkifyUtilConverter;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;
import javax.inject.Inject;

/* compiled from: pages_browser_category_page_load_successful */
public class PageInformationGenericAboutLineField extends CustomFrameLayout {
    @Inject
    public LinkifyUtil f4023a;
    public TextView f4024b = ((TextView) c(2131565594));
    public TextWithEntitiesView f4025c = ((TextWithEntitiesView) c(2131565595));
    public TextWithEntitiesView f4026d = ((TextWithEntitiesView) c(2131565596));
    public TextView f4027e;
    public String f4028f;
    public GraphQLTextWithEntities f4029g;
    public View f4030h = c(2131565593);
    public SparseArray<TextView> f4031i = new SparseArray(2);
    public int f4032j = getResources().getConfiguration().orientation;

    /* compiled from: pages_browser_category_page_load_successful */
    public class C05541 implements OnGlobalLayoutListener {
        final /* synthetic */ PageInformationGenericAboutLineField f4022a;

        public C05541(PageInformationGenericAboutLineField pageInformationGenericAboutLineField) {
            this.f4022a = pageInformationGenericAboutLineField;
        }

        public void onGlobalLayout() {
            if (this.f4022a.f4029g != null) {
                TextView textView = (TextView) this.f4022a.f4031i.get(this.f4022a.f4032j);
                if (textView == null) {
                    if (((int) (((((this.f4022a.f4024b.getPaint().measureText(this.f4022a.f4028f) + ((float) this.f4022a.f4024b.getCompoundPaddingLeft())) + ((float) this.f4022a.f4024b.getCompoundPaddingRight())) + this.f4022a.f4025c.getPaint().measureText(this.f4022a.f4029g.a())) + ((float) this.f4022a.f4025c.getCompoundPaddingRight())) + ((float) this.f4022a.f4025c.getCompoundPaddingLeft()))) > this.f4022a.f4030h.getMeasuredWidth()) {
                        this.f4022a.f4031i.put(this.f4022a.f4032j, this.f4022a.f4026d);
                        textView = this.f4022a.f4026d;
                    } else {
                        this.f4022a.f4031i.put(this.f4022a.f4032j, this.f4022a.f4025c);
                        textView = this.f4022a.f4025c;
                    }
                }
                PageInformationGenericAboutLineField pageInformationGenericAboutLineField = this.f4022a;
                if (pageInformationGenericAboutLineField.f4027e != textView) {
                    pageInformationGenericAboutLineField.f4027e.setText("");
                    pageInformationGenericAboutLineField.f4027e.setVisibility(8);
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                    textView.setText(pageInformationGenericAboutLineField.f4023a.a(LinkifyUtilConverter.c(pageInformationGenericAboutLineField.f4029g), true, null));
                    textView.setVisibility(0);
                    pageInformationGenericAboutLineField.f4027e = textView;
                }
            }
        }
    }

    public static void m4955a(Object obj, Context context) {
        ((PageInformationGenericAboutLineField) obj).f4023a = LinkifyUtil.a(FbInjector.get(context));
    }

    public PageInformationGenericAboutLineField(Context context) {
        super(context);
        Class cls = PageInformationGenericAboutLineField.class;
        m4955a(this, getContext());
        setContentView(2130906054);
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (this.f4032j != configuration.orientation) {
            this.f4032j = configuration.orientation;
        }
    }
}
