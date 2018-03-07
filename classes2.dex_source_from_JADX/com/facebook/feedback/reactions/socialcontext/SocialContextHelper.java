package com.facebook.feedback.reactions.socialcontext;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

/* compiled from: send_payment */
public class SocialContextHelper {
    private Resources f5610a;
    private final NumberTruncationUtil f5611b;
    private final AbstractFbErrorReporter f5612c;

    public static SocialContextHelper m9606b(InjectorLike injectorLike) {
        return new SocialContextHelper(ResourcesMethodAutoProvider.m6510a(injectorLike), NumberTruncationUtil.m9609a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike));
    }

    @Inject
    public SocialContextHelper(Resources resources, NumberTruncationUtil numberTruncationUtil, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f5610a = resources;
        this.f5611b = numberTruncationUtil;
        this.f5612c = abstractFbErrorReporter;
    }

    public final String m9607b(GraphQLFeedback graphQLFeedback) {
        ImmutableList immutableList;
        int i;
        int i2 = (graphQLFeedback.m23225S() != 0 || graphQLFeedback.y_()) ? 1 : 0;
        if (graphQLFeedback.m23229W() == null) {
            immutableList = RegularImmutableList.f535a;
        } else {
            immutableList = graphQLFeedback.m23229W().m24386a();
        }
        int a = graphQLFeedback.m23211E() != null ? graphQLFeedback.m23211E().m22671a() : graphQLFeedback.m23209C() != null ? graphQLFeedback.m23209C().mo2914a() : 0;
        int size = a - immutableList.size();
        if (i2 != 0) {
            i = 1;
        } else {
            i = 0;
        }
        i = size - i;
        if (i < 0) {
            String str;
            AbstractFbErrorReporter abstractFbErrorReporter = this.f5612c;
            String str2 = "feedback_socialcontext_negative_count";
            StringBuilder append = new StringBuilder("feedback.id = ").append(graphQLFeedback.z_()).append(", feedback.reactors = ");
            if (graphQLFeedback.m23211E() == null) {
                str = "null";
            } else {
                str = String.valueOf(graphQLFeedback.m23211E().m22671a());
            }
            append = append.append(str).append(", feedback.likers = ");
            if (graphQLFeedback.m23209C() == null) {
                str = "null";
            } else {
                str = String.valueOf(graphQLFeedback.m23209C().mo2914a());
            }
            append = append.append(str).append(", feedback.important_reactors = ");
            if (graphQLFeedback.m23229W() == null || graphQLFeedback.m23229W().m24386a() == null) {
                str = "null";
            } else {
                str = String.valueOf(graphQLFeedback.m23229W().m24386a().size());
            }
            abstractFbErrorReporter.m2340a(str2, append.append(str).toString());
            i = 0;
        }
        if (i2 != 0) {
            if (immutableList.isEmpty()) {
                if (i != 0) {
                    return this.f5610a.getQuantityString(2131689639, i, new Object[]{this.f5611b.m9623a(i)});
                } else if (graphQLFeedback.m23221O() != null) {
                    return graphQLFeedback.m23221O().aG();
                } else {
                    if (graphQLFeedback.m23230X() != null) {
                        return graphQLFeedback.m23230X().ar();
                    }
                    return this.f5610a.getString(2131235963);
                }
            } else if (immutableList.size() == 1) {
                if (i == 0) {
                    return this.f5610a.getString(2131235964, new Object[]{((GraphQLActor) immutableList.get(0)).aa()});
                }
                return this.f5610a.getQuantityString(2131689640, i, new Object[]{((GraphQLActor) immutableList.get(0)).aa(), this.f5611b.m9623a(i)});
            } else if (i == 0) {
                return this.f5610a.getString(2131235965, new Object[]{((GraphQLActor) immutableList.get(0)).aa(), ((GraphQLActor) immutableList.get(1)).aa()});
            } else {
                return this.f5610a.getQuantityString(2131689640, i + 1, new Object[]{((GraphQLActor) immutableList.get(0)).aa(), this.f5611b.m9623a(i + 1)});
            }
        } else if (immutableList.isEmpty()) {
            if (i == 0) {
                return this.f5610a.getString(2131235962);
            }
            return this.f5611b.m9623a(i);
        } else if (immutableList.size() == 1) {
            if (i == 0) {
                return ((GraphQLActor) immutableList.get(0)).aa();
            }
            return this.f5610a.getQuantityString(2131689641, i, new Object[]{((GraphQLActor) immutableList.get(0)).aa(), this.f5611b.m9623a(i)});
        } else if (i == 0) {
            return this.f5610a.getString(2131235966, new Object[]{((GraphQLActor) immutableList.get(0)).aa(), ((GraphQLActor) immutableList.get(1)).aa()});
        } else {
            return this.f5610a.getQuantityString(2131689641, i + 1, new Object[]{((GraphQLActor) immutableList.get(0)).aa(), Integer.valueOf(i + 1)});
        }
    }
}
