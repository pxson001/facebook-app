package com.facebook.search.util;

import android.content.Context;
import android.content.res.Resources;
import android.location.Location;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.graphql.enums.GraphQLPageOpenHoursDisplayDecisionEnum;
import com.facebook.graphql.model.GraphQLLocation;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLRating;
import com.facebook.graphql.model.GraphQLStreetAddress;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.location.FbLocationCache;
import com.facebook.location.ImmutableLocation;
import com.facebook.maps.MapsLocationUtils;
import java.text.NumberFormat;
import javax.inject.Inject;

@ContextScoped
/* compiled from: menu_item_add_bookmark */
public class LocalSearchUtil {
    private static LocalSearchUtil f8907c;
    private static final Object f8908d = new Object();
    private final FbLocationCache f8909a;
    private final MapsLocationUtils f8910b;

    private static LocalSearchUtil m10653b(InjectorLike injectorLike) {
        return new LocalSearchUtil(FbLocationCache.b(injectorLike), MapsLocationUtils.b(injectorLike));
    }

    @Inject
    public LocalSearchUtil(FbLocationCache fbLocationCache, MapsLocationUtils mapsLocationUtils) {
        this.f8909a = fbLocationCache;
        this.f8910b = mapsLocationUtils;
    }

    private static SpannableStringBuilder m10649a(SpannableStringBuilder spannableStringBuilder, CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) != '\n') {
                spannableStringBuilder.append(" • ");
            }
            spannableStringBuilder.append(charSequence);
        }
        return spannableStringBuilder;
    }

    private CharSequence m10651a(Context context, GraphQLRating graphQLRating) {
        SpannableStringBuilder spannableStringBuilder;
        if (graphQLRating == null) {
            spannableStringBuilder = null;
        } else {
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(context.getResources().getColor(2131361917));
            double k = graphQLRating.k();
            int a = graphQLRating.a();
            spannableStringBuilder = new SpannableStringBuilder();
            if (a > 0 || k > 0.0d) {
                spannableStringBuilder.append(StringFormatUtil.formatStrLocaleSafe("%.1f", Double.valueOf(k)));
                spannableStringBuilder.append("★");
                if (null != null) {
                    spannableStringBuilder.append(" (").append(NumberFormat.getNumberInstance().format((long) a)).append(")");
                }
                spannableStringBuilder.setSpan(foregroundColorSpan, 0, spannableStringBuilder.length(), 33);
            }
        }
        return spannableStringBuilder;
    }

    public static LocalSearchUtil m10650a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LocalSearchUtil b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8908d) {
                LocalSearchUtil localSearchUtil;
                if (a2 != null) {
                    localSearchUtil = (LocalSearchUtil) a2.a(f8908d);
                } else {
                    localSearchUtil = f8907c;
                }
                if (localSearchUtil == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10653b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8908d, b3);
                        } else {
                            f8907c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = localSearchUtil;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final CharSequence m10654a(Context context, GraphQLNode graphQLNode) {
        Resources resources = context.getResources();
        GraphQLRating eZ = graphQLNode.eZ();
        GraphQLTextWithEntities fw = graphQLNode.fw();
        GraphQLPageOpenHoursDisplayDecisionEnum fx = graphQLNode.fx();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        m10649a(spannableStringBuilder, m10651a(context, eZ));
        m10649a(spannableStringBuilder, (CharSequence) graphQLNode.aZ().get(0));
        m10649a(spannableStringBuilder, graphQLNode.jY());
        m10649a(spannableStringBuilder, m10652a(resources, fw, fx));
        return spannableStringBuilder;
    }

    private static CharSequence m10652a(Resources resources, GraphQLTextWithEntities graphQLTextWithEntities, GraphQLPageOpenHoursDisplayDecisionEnum graphQLPageOpenHoursDisplayDecisionEnum) {
        try {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (graphQLTextWithEntities == null || graphQLPageOpenHoursDisplayDecisionEnum == GraphQLPageOpenHoursDisplayDecisionEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
                return spannableStringBuilder;
            }
            m10649a(spannableStringBuilder, graphQLTextWithEntities.a());
            int length = spannableStringBuilder.length();
            int length2 = length - graphQLTextWithEntities.a().length();
            if (graphQLPageOpenHoursDisplayDecisionEnum == null) {
                return spannableStringBuilder;
            }
            Object obj = null;
            if (graphQLPageOpenHoursDisplayDecisionEnum == GraphQLPageOpenHoursDisplayDecisionEnum.SHOW_AVAILABLE) {
                obj = new ForegroundColorSpan(resources.getColor(2131361919));
            } else if (graphQLPageOpenHoursDisplayDecisionEnum == GraphQLPageOpenHoursDisplayDecisionEnum.SHOW_UNDETERMINED) {
                obj = new ForegroundColorSpan(resources.getColor(2131362034));
            } else if (graphQLPageOpenHoursDisplayDecisionEnum == GraphQLPageOpenHoursDisplayDecisionEnum.SHOW_UNAVAILABLE) {
                obj = new ForegroundColorSpan(resources.getColor(2131361918));
            }
            if (obj == null) {
                return spannableStringBuilder;
            }
            spannableStringBuilder.setSpan(obj, length2, length, 33);
            return spannableStringBuilder;
        } catch (NullPointerException e) {
            return "";
        }
    }

    public final CharSequence m10655a(GraphQLNode graphQLNode) {
        GraphQLStreetAddress s = graphQLNode.s();
        if (s == null || s.o() == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ImmutableLocation a = this.f8909a.a();
        GraphQLLocation er = graphQLNode.er();
        if (!(a == null || er == null)) {
            Location location = new Location("places_search");
            location.setLatitude(er.a());
            location.setLongitude(er.b());
            m10649a(spannableStringBuilder, this.f8910b.a(a, ImmutableLocation.a(location), 80467.203125d, null));
        }
        m10649a(spannableStringBuilder, s.o());
        return spannableStringBuilder;
    }
}
