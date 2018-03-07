package com.facebook.feedplugins.pymk.views.rows;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.util.SizeUtil;
import com.facebook.feedplugins.pymk.PymkGatekeepers;
import com.facebook.feedplugins.pymk.rows.PeopleYouMayKnowHScrollPartDefinition;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Inject;

/* compiled from: THIRD_PARTY_PROCESSOR */
public class PersonYouMayKnowView extends PagerItemWrapperLayout implements RecyclableView {
    private static int f24926c = 0;
    @Inject
    public GatekeeperStoreImpl f24927a;
    @Inject
    public PymkGatekeepers f24928b;
    public boolean f24929d;
    private View f24930e;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: THIRD_PARTY_PROCESSOR */
    public @interface Surface {
    }

    public static void m26695a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PersonYouMayKnowView personYouMayKnowView = (PersonYouMayKnowView) obj;
        GatekeeperStoreImpl a = GatekeeperStoreImplMethodAutoProvider.a(fbInjector);
        PymkGatekeepers a2 = PymkGatekeepers.m26572a(fbInjector);
        personYouMayKnowView.f24927a = a;
        personYouMayKnowView.f24928b = a2;
    }

    public PersonYouMayKnowView(Context context) {
        this(context, null);
    }

    private PersonYouMayKnowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PersonYouMayKnowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        Class cls = PersonYouMayKnowView.class;
        m26695a(this, getContext());
        if (i == 1 || this.f24928b.f24692a || this.f24928b.f24694c || this.f24928b.f24695d) {
            setContentView(2130904325);
        } else if (this.f24928b.f24693b) {
            setContentView(2130904323);
        } else {
            setContentView(2130904324);
        }
        this.f24930e = c(2131561958);
        if (this.f24927a.a(656, false)) {
            if (f24926c == 0) {
                float f;
                Resources resources = getResources();
                Resources resources2 = getResources();
                if (this.f24928b.f24692a || this.f24928b.f24693b) {
                    f = 304.0f;
                } else {
                    f = 204.0f;
                }
                f24926c = SizeUtil.a(resources, PeopleYouMayKnowHScrollPartDefinition.m26625a(resources2, f) - 4.0f);
            }
            this.f24930e.getLayoutParams().width = f24926c;
        }
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1750230561);
        super.onAttachedToWindow();
        this.f24929d = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -794037202, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 383050225);
        super.onDetachedFromWindow();
        this.f24929d = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -859066369, a);
    }

    public final boolean m26696a() {
        return this.f24929d;
    }
}
