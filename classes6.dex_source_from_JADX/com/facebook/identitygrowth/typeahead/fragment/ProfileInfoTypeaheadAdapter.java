package com.facebook.identitygrowth.typeahead.fragment;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.identitygrowth.protocol.ProfileInfoTypeaheadSearchGraphQLInterfaces.TypeaheadResultPage;
import com.facebook.identitygrowth.protocol.ProfileInfoTypeaheadSearchGraphQLModels.TypeaheadResultPageModel;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;

/* compiled from: mContactId */
public class ProfileInfoTypeaheadAdapter extends BaseAdapter {
    private static final CallerContext f11199a = CallerContext.a(ProfileInfoTypeaheadAdapter.class, "growth");
    public List<TypeaheadResultPage> f11200b = Lists.a();
    public boolean f11201c = false;
    private LayoutInflater f11202d;

    public static ProfileInfoTypeaheadAdapter m18094b(InjectorLike injectorLike) {
        return new ProfileInfoTypeaheadAdapter(LayoutInflaterMethodAutoProvider.b(injectorLike));
    }

    public /* synthetic */ Object getItem(int i) {
        return m18095a(i);
    }

    @Inject
    public ProfileInfoTypeaheadAdapter(LayoutInflater layoutInflater) {
        this.f11202d = layoutInflater;
    }

    public int getCount() {
        return this.f11200b.size();
    }

    public final TypeaheadResultPageModel m18095a(int i) {
        return (TypeaheadResultPageModel) this.f11200b.get(i);
    }

    public long getItemId(int i) {
        return Long.parseLong(m18095a(i).m17933d());
    }

    public boolean hasStableIds() {
        return true;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        Preconditions.checkArgument(i <= this.f11200b.size());
        if (view == null) {
            view = this.f11202d.inflate(2130906439, viewGroup, false);
        }
        TypeaheadResultPageModel a = m18095a(i);
        if (a != null) {
            FbDraweeView fbDraweeView = (FbDraweeView) view.findViewById(2131566352);
            Uri parse = (a.m17934g() == null || a.m17934g().m17922a() == null) ? null : Uri.parse(a.m17934g().m17922a());
            fbDraweeView.a(parse, f11199a);
            ((TextView) view.findViewById(2131566353)).setText(a.dj_());
            TextView textView = (TextView) view.findViewById(2131566354);
            List a2 = Lists.a();
            ImmutableList c = a.m17932c();
            if (!(c == null || c.isEmpty() || StringUtil.c((CharSequence) c.get(0)))) {
                a2.add(c.get(0));
            }
            if (!(a.m17931b() == null || StringUtil.c(a.m17931b().m17915a()))) {
                a2.add(a.m17931b().m17915a());
            }
            if (!(!this.f11201c || a.m17931b() == null || StringUtil.c(a.m17931b().m17916b()))) {
                a2.add(a.m17931b().m17916b());
            }
            textView.setText(StringUtil.b(" · ", a2.toArray()));
        }
        return view;
    }

    public final ImmutableList<String> m18096a() {
        Builder builder = ImmutableList.builder();
        for (int i = 0; i < this.f11200b.size(); i++) {
            builder.c(m18095a(i).m17933d());
        }
        return builder.b();
    }
}
