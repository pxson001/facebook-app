package com.facebook.leadgen;

import android.support.v4.view.ViewPager;
import com.facebook.common.time.MonotonicClock;
import com.facebook.graphql.model.GraphQLLeadGenContextPage;
import com.facebook.graphql.model.GraphQLLeadGenLegalContent;
import com.facebook.graphql.model.GraphQLLeadGenPage;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.inject.Assisted;
import com.facebook.leadgen.cache.LeadGenFormPendingInputEntry;
import com.facebook.leadgen.data.LeadGenDataExtractor;
import com.facebook.leadgen.util.LeadGenInfoFieldUserData;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: place_edit_review_success */
public class LeadGenPagerController {
    public final MonotonicClock f6318a;
    private final LeadGenLogger f6319b;
    public final ViewPager f6320c;
    public final Map<String, String> f6321d = new HashMap();
    public final Map<String, String> f6322e = new HashMap();
    private final Map<String, String> f6323f = new HashMap();
    public LeadGenFormPagesAdapter f6324g;
    public int f6325h;
    public long f6326i;
    public LeadGenDataExtractor f6327j;

    @Inject
    public LeadGenPagerController(LeadGenFormPagesAdapterProvider leadGenFormPagesAdapterProvider, MonotonicClock monotonicClock, LeadGenLogger leadGenLogger, @Assisted ViewPager viewPager, @Assisted LeadGenDataExtractor leadGenDataExtractor, @Assisted LeadGenFormPendingInputEntry leadGenFormPendingInputEntry) {
        this.f6318a = monotonicClock;
        this.f6319b = leadGenLogger;
        this.f6320c = viewPager;
        this.f6327j = leadGenDataExtractor;
        this.f6324g = new LeadGenFormPagesAdapter(this.f6327j, leadGenFormPendingInputEntry, null);
        this.f6320c.setOffscreenPageLimit(3);
        this.f6320c.setAdapter(this.f6324g);
        this.f6325h = 0;
        this.f6326i = this.f6318a.now();
        if (leadGenFormPendingInputEntry != null) {
            this.f6325h = leadGenFormPendingInputEntry.f6363b;
            this.f6321d.putAll(leadGenFormPendingInputEntry.f6364c);
        }
        this.f6320c.setCurrentItem(this.f6325h);
    }

    public final boolean m8153a() {
        if (this.f6325h >= this.f6324g.b() - 1) {
            return false;
        }
        m8155d();
        this.f6325h++;
        this.f6320c.a(this.f6325h, true);
        this.f6324g.m8117a(this.f6327j, this.f6321d, this.f6325h);
        return true;
    }

    public final boolean m8154b() {
        if (this.f6325h <= 0) {
            return false;
        }
        m8155d();
        this.f6325h--;
        this.f6320c.a(this.f6325h, true);
        this.f6324g.m8117a(this.f6327j, this.f6321d, this.f6325h);
        return true;
    }

    public final void m8155d() {
        this.f6319b.m8143b(this.f6318a.now() - this.f6326i, this.f6325h);
        this.f6326i = this.f6318a.now();
    }

    public final boolean m8156e() {
        return this.f6325h == 0;
    }

    public final boolean m8157f() {
        return this.f6325h == this.f6324g.b() + -1;
    }

    public final ImmutableMap<String, String> m8158g() {
        return ImmutableMap.copyOf(this.f6321d);
    }

    public final ImmutableMap<String, String> m8159i() {
        return ImmutableMap.copyOf(this.f6323f);
    }

    public final void m8160k() {
        m8152a(this.f6324g.f6269f.mo347b());
    }

    private void m8152a(@Nullable List<LeadGenInfoFieldUserData> list) {
        if (list != null) {
            for (LeadGenInfoFieldUserData leadGenInfoFieldUserData : list) {
                this.f6321d.put(leadGenInfoFieldUserData.f6563b.j(), leadGenInfoFieldUserData.f6562a);
                this.f6322e.put(leadGenInfoFieldUserData.f6563b.j(), leadGenInfoFieldUserData.f6564c);
            }
        }
    }

    public final LeadGenUtil$ValidationResult m8161l() {
        LeadGenFormPageView leadGenFormPageView = this.f6324g.f6269f;
        if (leadGenFormPageView == null) {
            return LeadGenUtil$ValidationResult.UNKNOWN_ERROR;
        }
        LeadGenUtil$ValidationResult c = leadGenFormPageView.mo348c(this.f6325h);
        if (!c.isValid()) {
            return c;
        }
        m8152a(leadGenFormPageView.mo347b());
        if (!m8162n()) {
            return c;
        }
        this.f6323f.putAll(leadGenFormPageView.mo349c());
        return c;
    }

    public final boolean m8162n() {
        LeadGenFormPagesAdapter leadGenFormPagesAdapter = this.f6324g;
        int i = this.f6325h;
        BaseModel baseModel = (BaseModel) leadGenFormPagesAdapter.f6266c.get(i);
        boolean b = ((baseModel instanceof GraphQLLeadGenPage) || (baseModel instanceof GraphQLLeadGenLegalContent)) ? leadGenFormPagesAdapter.f6268e.m8197L() ? i == leadGenFormPagesAdapter.f6266c.size() + -1 : LeadGenUtil.b((GraphQLLeadGenPage) baseModel) : false;
        return b;
    }

    public final boolean m8163o() {
        LeadGenFormPagesAdapter leadGenFormPagesAdapter = this.f6324g;
        return leadGenFormPagesAdapter.f6266c.get(this.f6325h) instanceof GraphQLLeadGenContextPage;
    }
}
