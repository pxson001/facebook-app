package com.facebook.checkin.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.i18n.PluralUtil;
import com.facebook.common.locale.Locales;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props.Builder;
import com.facebook.multirow.parts.TextOrHiddenPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import java.text.NumberFormat;
import javax.inject.Inject;

@ContextScoped
/* compiled from: new_notifications_notif_fragment */
public class BaseCheckinStoryPartDefinition<Environment extends HasPrefetcher & HasRowKey> extends BaseSinglePartDefinition<Props, Boolean, Environment, ImageBlockLayout> {
    private static final CallerContext f7122a = CallerContext.a(BaseCheckinStoryPartDefinition.class);
    private static BaseCheckinStoryPartDefinition f7123i;
    private static final Object f7124j = new Object();
    private final TextPartDefinition f7125b;
    private final TextOrHiddenPartDefinition f7126c;
    private final FbDraweePartDefinition f7127d;
    private final RatingBarPartDefinition f7128e;
    private final Locales f7129f;
    private final Context f7130g;
    private final PluralUtil f7131h;

    /* compiled from: new_notifications_notif_fragment */
    public class Props {
        public final GraphQLStory f13687a;
        public final boolean f13688b;
        public final GraphQLPlace f13689c;

        public Props(GraphQLStory graphQLStory, GraphQLPlace graphQLPlace, boolean z) {
            this.f13687a = graphQLStory;
            this.f13689c = graphQLPlace;
            this.f13688b = z;
        }
    }

    private static BaseCheckinStoryPartDefinition m7449b(InjectorLike injectorLike) {
        return new BaseCheckinStoryPartDefinition(TextPartDefinition.a(injectorLike), TextOrHiddenPartDefinition.a(injectorLike), FbDraweePartDefinition.a(injectorLike), RatingBarPartDefinition.m7455a(injectorLike), Locales.a(injectorLike), (Context) injectorLike.getInstance(Context.class), PluralUtil.m7461a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ Object m7451a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return m7446a(subParts, (Props) obj);
    }

    public final /* bridge */ /* synthetic */ void m7452a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int i;
        int a = Logger.a(8, EntryType.MARK_PUSH, -633639342);
        Boolean bool = (Boolean) obj2;
        View view2 = ((ImageBlockLayout) view).f;
        if (bool.booleanValue()) {
            i = 0;
        } else {
            i = 8;
        }
        view2.setVisibility(i);
        Logger.a(8, EntryType.MARK_POP, 2015717511, a);
    }

    public final void m7453b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((ImageBlockLayout) view).f.setVisibility(8);
    }

    public static BaseCheckinStoryPartDefinition m7445a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BaseCheckinStoryPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7124j) {
                BaseCheckinStoryPartDefinition baseCheckinStoryPartDefinition;
                if (a2 != null) {
                    baseCheckinStoryPartDefinition = (BaseCheckinStoryPartDefinition) a2.a(f7124j);
                } else {
                    baseCheckinStoryPartDefinition = f7123i;
                }
                if (baseCheckinStoryPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7449b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7124j, b3);
                        } else {
                            f7123i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = baseCheckinStoryPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public BaseCheckinStoryPartDefinition(TextPartDefinition textPartDefinition, TextOrHiddenPartDefinition textOrHiddenPartDefinition, FbDraweePartDefinition fbDraweePartDefinition, RatingBarPartDefinition ratingBarPartDefinition, Locales locales, Context context, PluralUtil pluralUtil) {
        this.f7125b = textPartDefinition;
        this.f7126c = textOrHiddenPartDefinition;
        this.f7127d = fbDraweePartDefinition;
        this.f7128e = ratingBarPartDefinition;
        this.f7129f = locales;
        this.f7130g = context;
        this.f7131h = pluralUtil;
    }

    private Boolean m7446a(SubParts<Environment> subParts, Props props) {
        Object quantityString;
        Object obj;
        boolean z;
        GraphQLPlace graphQLPlace = props.f13689c;
        subParts.a(2131562017, this.f7125b, graphQLPlace.B());
        if (RatingBarPartDefinition.m7456a(graphQLPlace)) {
            subParts.a(2131562019, this.f7128e, graphQLPlace);
            subParts.a(2131562018, this.f7125b, this.f7131h.m7463a(2131689615, (double) ((float) graphQLPlace.C().k())));
        }
        if (m7447a(graphQLPlace)) {
            NumberFormat instance = NumberFormat.getInstance(this.f7129f.a());
            quantityString = this.f7130g.getResources().getQuantityString(2131689572, graphQLPlace.E().a(), new Object[]{instance.format((long) graphQLPlace.E().a())});
        } else {
            quantityString = null;
        }
        subParts.a(2131562021, this.f7126c, quantityString);
        if (graphQLPlace.o() == null || graphQLPlace.o().isEmpty()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            quantityString = (String) graphQLPlace.o().get(0);
        } else {
            quantityString = null;
        }
        subParts.a(2131562020, this.f7126c, quantityString);
        FbDraweePartDefinition fbDraweePartDefinition;
        Builder a;
        if (m7450d(graphQLPlace)) {
            fbDraweePartDefinition = this.f7127d;
            a = FbDraweePartDefinition.a().a(graphQLPlace.N().b());
            a.c = f7122a;
            subParts.a(2131562016, fbDraweePartDefinition, a.a());
            z = true;
        } else if (props.f13688b && m7448a(graphQLPlace, props.f13687a)) {
            fbDraweePartDefinition = this.f7127d;
            a = FbDraweePartDefinition.a().a("res:///" + 2130837956);
            a.c = f7122a;
            subParts.a(2131562016, fbDraweePartDefinition, a.a());
            z = true;
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    private static boolean m7447a(GraphQLPlace graphQLPlace) {
        Object obj = (graphQLPlace.C() == null || !graphQLPlace.U()) ? null : 1;
        return obj == null && graphQLPlace.E() != null && graphQLPlace.E().a() > 0;
    }

    private static boolean m7450d(GraphQLPlace graphQLPlace) {
        return (graphQLPlace.O() || graphQLPlace.N() == null || StringUtil.a(graphQLPlace.N().b())) ? false : true;
    }

    private static boolean m7448a(GraphQLPlace graphQLPlace, GraphQLStory graphQLStory) {
        return graphQLPlace.O() && !graphQLPlace.y() && graphQLStory.P();
    }
}
