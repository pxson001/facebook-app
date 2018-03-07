package com.facebook.identitygrowth.profilequestion.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.privacy.model.ContentPrivacyOptionsResult;
import com.facebook.privacy.model.PrivacyOptionsResultFactory;
import com.facebook.privacy.ui.PrivacyIcons;
import com.facebook.privacy.ui.PrivacyIcons.Size;
import com.facebook.privacy.ui.PrivacyOptionsAdapter;
import com.facebook.widget.listview.ImmutableSectionedListSection;
import com.facebook.widget.listview.SectionedListSection;
import java.util.List;
import java.util.ListIterator;

/* compiled from: mImageOverlayUrl */
public class ProfileQuestionPrivacySpinnerAdapter extends PrivacyOptionsAdapter implements SpinnerAdapter {
    private final Resources f11083e;
    private final AbstractFbErrorReporter f11084f;
    private final PrivacyIcons f11085g;
    private ContentPrivacyOptionsResult f11086h;
    private PrivacyOptionsResultFactory f11087i;

    public ProfileQuestionPrivacySpinnerAdapter(Context context, Resources resources, LayoutInflater layoutInflater, AbstractFbErrorReporter abstractFbErrorReporter, PrivacyIcons privacyIcons, PrivacyOptionsResultFactory privacyOptionsResultFactory) {
        super(context, layoutInflater);
        this.f11083e = resources;
        this.f11084f = abstractFbErrorReporter;
        this.f11085g = privacyIcons;
        this.f11087i = privacyOptionsResultFactory;
    }

    private int m17831b(GraphQLPrivacyOption graphQLPrivacyOption) {
        int i = 0;
        ListIterator listIterator = this.f11078d.listIterator();
        while (listIterator.hasNext()) {
            int i2 = i + 1;
            List b = ((SectionedListSection) listIterator.next()).mo434b();
            int indexOf = b.indexOf(graphQLPrivacyOption);
            if (indexOf != -1) {
                return i2 + indexOf;
            }
            i = b.size() + i2;
        }
        return -1;
    }

    public final int m17832a(GraphQLPrivacyOption graphQLPrivacyOption) {
        int b = m17831b(graphQLPrivacyOption);
        if (b == -1) {
            mo1066a(ContentPrivacyOptionsResult.m22634a(this.f11086h).m22631a(graphQLPrivacyOption).m22633b());
            b = m17831b(graphQLPrivacyOption);
            if (b == -1) {
                this.f11084f.a("identitygrowth", "Still cannot find this privacy option even after inserting it. Please update inserting method accordingly.");
            }
        }
        return b;
    }

    public final View mo1058a(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            return this.f11077c.inflate(2130904830, null);
        }
        return view;
    }

    public final View mo1057a(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f11077c.inflate(2130904830, null);
        }
        GraphQLPrivacyOption graphQLPrivacyOption = (GraphQLPrivacyOption) mo1059a(i, i2);
        ImageView imageView = (ImageView) view.findViewById(2131563035);
        imageView.setImageResource(this.f11085g.m22958a(graphQLPrivacyOption.l(), Size.LIST));
        imageView.setContentDescription(graphQLPrivacyOption.d());
        return view;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        if (view == null) {
            inflate = this.f11077c.inflate(2130904829, null);
        } else {
            inflate = view;
        }
        int[] d = m8650d(i);
        if (getItemViewType(i) == 0) {
            ((TextView) inflate).setText(((ImmutableSectionedListSection) mo1060b(d[0])).mo432a());
            ((TextView) inflate).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        } else {
            GraphQLPrivacyOption graphQLPrivacyOption = (GraphQLPrivacyOption) mo1059a(d[0], d[1]);
            ((TextView) inflate).setText(graphQLPrivacyOption.d());
            ((TextView) inflate).setCompoundDrawablesWithIntrinsicBounds(this.f11083e.getDrawable(this.f11085g.m22958a(graphQLPrivacyOption.l(), Size.COMPOSER_FOOTER)), null, null, null);
        }
        return inflate;
    }

    public final void mo1066a(ContentPrivacyOptionsResult contentPrivacyOptionsResult) {
        this.f11086h = contentPrivacyOptionsResult;
        super.mo1066a(contentPrivacyOptionsResult);
    }

    public int getViewTypeCount() {
        return 1;
    }
}
