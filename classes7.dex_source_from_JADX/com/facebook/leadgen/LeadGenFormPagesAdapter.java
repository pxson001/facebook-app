package com.facebook.leadgen;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.graphql.model.GraphQLLeadGenContextPage;
import com.facebook.graphql.model.GraphQLLeadGenPage;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.inject.Assisted;
import com.facebook.leadgen.cache.LeadGenFormPendingInputEntry;
import com.facebook.leadgen.data.LeadGenDataExtractor;
import com.facebook.leadgen.input.LeadGenFieldInput.OnDataChangeListener;
import com.facebook.leadgen.view.LeadGenContextCardView;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: place_question_answers */
public class LeadGenFormPagesAdapter extends PagerAdapter {
    private final LeadGenFormPendingInputEntry f6264a;
    private final List<GraphQLLeadGenPage> f6265b;
    public final List<BaseModel> f6266c;
    private final OnDataChangeListener f6267d;
    public final LeadGenDataExtractor f6268e;
    public LeadGenFormPageView f6269f;

    @Inject
    public LeadGenFormPagesAdapter(@Assisted LeadGenDataExtractor leadGenDataExtractor, @Assisted LeadGenFormPendingInputEntry leadGenFormPendingInputEntry, @Assisted OnDataChangeListener onDataChangeListener) {
        ImmutableList arrayList;
        this.f6268e = leadGenDataExtractor;
        this.f6264a = leadGenFormPendingInputEntry;
        this.f6267d = onDataChangeListener;
        LeadGenDataExtractor leadGenDataExtractor2 = this.f6268e;
        if (leadGenDataExtractor2.f6370f == null || leadGenDataExtractor2.f6370f.M() == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = leadGenDataExtractor2.f6370f.M().n();
        }
        this.f6265b = arrayList;
        this.f6266c = new ArrayList();
        if (this.f6268e.m8203e()) {
            this.f6266c.add(LeadGenUtil.s(this.f6268e.f6368d));
        }
        this.f6266c.addAll(this.f6265b);
        if (this.f6268e.m8197L()) {
            this.f6266c.add(LeadGenUtil.h(this.f6268e.f6368d));
        }
    }

    public final int m8119b() {
        return this.f6266c.size();
    }

    public final void m8116a(ViewGroup viewGroup, int i, Object obj) {
        LeadGenFormPageView leadGenFormPageView = (LeadGenFormPageView) obj;
        leadGenFormPageView.mo344a();
        viewGroup.removeView(leadGenFormPageView);
    }

    public final boolean m8118a(View view, Object obj) {
        return view == obj;
    }

    public final void m8120b(ViewGroup viewGroup, int i, Object obj) {
        this.f6269f = (LeadGenFormPageView) obj;
        super.b(viewGroup, i, obj);
    }

    public final Object m8115a(ViewGroup viewGroup, int i) {
        BaseModel baseModel = (BaseModel) this.f6266c.get(i);
        GraphQLLeadGenPage graphQLLeadGenPage = baseModel instanceof GraphQLLeadGenPage ? (GraphQLLeadGenPage) baseModel : null;
        LeadGenFormPageView a = m8114a(viewGroup.getContext(), baseModel, i);
        a.mo345a(graphQLLeadGenPage, i, this.f6268e, i, this.f6267d);
        if (this.f6264a != null) {
            a.mo346a(this.f6264a);
        }
        viewGroup.addView(a);
        return a;
    }

    public final void m8117a(LeadGenDataExtractor leadGenDataExtractor, Map<String, String> map, int i) {
        if ((this.f6264a == null || this.f6264a.f6364c.size() < map.size()) && this.f6269f != null && leadGenDataExtractor != null) {
            this.f6269f.mo346a(new LeadGenFormPendingInputEntry(leadGenDataExtractor.m8201b(), i, map));
        } else if (this.f6264a != null && this.f6269f != null) {
            this.f6269f.mo346a(this.f6264a);
        }
    }

    private LeadGenFormPageView m8114a(Context context, BaseModel baseModel, int i) {
        if (baseModel instanceof GraphQLLeadGenContextPage) {
            return new LeadGenContextCardView(context, null);
        }
        if (LeadGenUtil.a((GraphQLStoryAttachment) this.f6268e.f6367c.a, i, b()) || LeadGenUtil.b((GraphQLLeadGenPage) baseModel)) {
            return new LeadGenNewCustomDisclaimerView(context, null);
        }
        return new LeadGenUserInfoFormView(context, null, b());
    }
}
