package com.facebook.timeline.survey;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLStructuredSurveyQuestionTokenParamType;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.rapidfeedback.RapidFeedbackController;
import com.facebook.structuredsurvey.StructuredSurveyController;
import com.facebook.timeline.delegate.ProfileControllerDelegate;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: extra_is_composer_intercept_status */
public class TimelineStructuredSurveyController {
    private static TimelineStructuredSurveyController f12739g;
    private static final Object f12740h = new Object();
    private final Context f12741a;
    private final Provider<RapidFeedbackController> f12742b;
    private final Provider<StructuredSurveyController> f12743c;
    private final ProfileControllerDelegate f12744d;
    public boolean f12745e;
    public boolean f12746f;

    /* compiled from: extra_is_composer_intercept_status */
    public class C17861 implements OnClickListener {
        final /* synthetic */ TimelineHeaderUserData f12736a;
        final /* synthetic */ TimelineContext f12737b;
        final /* synthetic */ TimelineStructuredSurveyController f12738c;

        public C17861(TimelineStructuredSurveyController timelineStructuredSurveyController, TimelineHeaderUserData timelineHeaderUserData, TimelineContext timelineContext) {
            this.f12738c = timelineStructuredSurveyController;
            this.f12736a = timelineHeaderUserData;
            this.f12737b = timelineContext;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2003305958);
            if (this.f12738c.f12745e) {
                TimelineStructuredSurveyController.m12688a(this.f12738c, "806719932784684", "profile_first_name", this.f12736a.y(), this.f12736a.E());
                this.f12738c.f12745e = false;
            } else if (this.f12738c.f12746f) {
                this.f12738c.m12686a(this.f12737b, this.f12736a, "1075751319133793", "241841249505807", "1169519076433548");
            } else {
                this.f12738c.m12686a(this.f12737b, this.f12736a, "416127421878254", "1578439722370397", "610802272355300");
            }
            LogUtils.a(-526766415, a);
        }
    }

    private static TimelineStructuredSurveyController m12690b(InjectorLike injectorLike) {
        return new TimelineStructuredSurveyController((Context) injectorLike.getInstance(Context.class), IdBasedProvider.a(injectorLike, 3253), IdBasedSingletonScopeProvider.a(injectorLike, 3480), ProfileControllerDelegate.m10751a(injectorLike));
    }

    @Inject
    public TimelineStructuredSurveyController(Context context, Provider<RapidFeedbackController> provider, Provider<StructuredSurveyController> provider2, ProfileControllerDelegate profileControllerDelegate) {
        this.f12741a = context;
        this.f12742b = provider;
        this.f12743c = provider2;
        this.f12744d = profileControllerDelegate;
    }

    public final void m12692a(boolean z) {
        this.f12745e = z;
    }

    public final void m12694b(boolean z) {
        this.f12746f = z;
    }

    public static TimelineStructuredSurveyController m12685a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelineStructuredSurveyController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12740h) {
                TimelineStructuredSurveyController timelineStructuredSurveyController;
                if (a2 != null) {
                    timelineStructuredSurveyController = (TimelineStructuredSurveyController) a2.a(f12740h);
                } else {
                    timelineStructuredSurveyController = f12739g;
                }
                if (timelineStructuredSurveyController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12690b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12740h, b3);
                        } else {
                            f12739g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = timelineStructuredSurveyController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private void m12686a(TimelineContext timelineContext, TimelineHeaderUserData timelineHeaderUserData, String str, String str2, String str3) {
        String N = timelineHeaderUserData.N();
        String E = timelineHeaderUserData.E();
        if (timelineContext.i()) {
            m12688a(this, str, "loaded_profile_name", N, E);
        } else if (timelineHeaderUserData.B() == GraphQLFriendshipStatus.ARE_FRIENDS) {
            m12688a(this, str2, "loaded_profile_name", N, E);
        } else {
            m12688a(this, str3, "loaded_profile_name", N, E);
        }
    }

    public static void m12688a(TimelineStructuredSurveyController timelineStructuredSurveyController, String str, String str2, String str3, String str4) {
        if (((StructuredSurveyController) timelineStructuredSurveyController.f12743c.get()).b(str)) {
            RapidFeedbackController rapidFeedbackController = (RapidFeedbackController) timelineStructuredSurveyController.f12742b.get();
            rapidFeedbackController.a("profile_id", str4);
            ((StructuredSurveyController) rapidFeedbackController.d.get()).t.a(GraphQLStructuredSurveyQuestionTokenParamType.SESSION).a.put(str2, str3);
            rapidFeedbackController.c(str, timelineStructuredSurveyController.f12741a);
            return;
        }
        timelineStructuredSurveyController.f12744d.mp_();
    }

    public final void m12693b(TimelineContext timelineContext, TimelineHeaderUserData timelineHeaderUserData) {
        if (this.f12745e) {
            m12689a("806719932784684");
        } else if (this.f12746f) {
            m12691b(timelineContext, timelineHeaderUserData, "1075751319133793", "241841249505807", "1169519076433548");
        } else {
            m12691b(timelineContext, timelineHeaderUserData, "416127421878254", "1578439722370397", "610802272355300");
        }
    }

    private void m12691b(TimelineContext timelineContext, TimelineHeaderUserData timelineHeaderUserData, String str, String str2, String str3) {
        if (timelineContext.i()) {
            m12689a(str);
        } else if (timelineHeaderUserData.B() == GraphQLFriendshipStatus.ARE_FRIENDS) {
            m12689a(str2);
        } else {
            m12689a(str3);
        }
    }

    private void m12689a(String str) {
        ((StructuredSurveyController) this.f12743c.get()).a(str);
    }
}
