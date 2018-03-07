package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.CollectionUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedplugins.base.footer.ui.TwoButtonFooterView;
import com.facebook.feedplugins.base.footer.ui.TwoButtonFooterView.Button;
import com.facebook.goodwill.composer.GoodwillVideoComposerLauncher;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GoodwillFeedUnitHelper;
import com.facebook.graphql.model.GraphQLGoodwillCampaign;
import com.facebook.graphql.model.GraphQLGoodwillFriendversaryCampaign;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackFriendversaryPromotionStory;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackPromotionFeedUnit;
import com.facebook.graphql.model.GraphQLGoodwillVideoCampaign;
import com.facebook.graphql.model.GraphQLUser;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.composer.model.ComposerTaggedUser;
import com.facebook.ipc.composer.model.ComposerTaggedUser.Builder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.collect.ImmutableList;
import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: global_share_id */
public class ThrowbackVideoSharePartDefinition extends MultiRowSinglePartDefinition<FeedProps<? extends FeedUnit>, State, HasPositionInformation, TwoButtonFooterView> {
    private static final PaddingStyle f12631a;
    private static ThrowbackVideoSharePartDefinition f12632i;
    private static final Object f12633j = new Object();
    private final BackgroundPartDefinition f12634b;
    private final TextPartDefinition f12635c;
    private final ClickListenerPartDefinition f12636d;
    public final FbUriIntentHandler f12637e;
    public final SecureContextHelper f12638f;
    public final Context f12639g;
    private final Resources f12640h;

    /* compiled from: global_share_id */
    public class State {
        public final Drawable f12627a;
        public final Drawable f12628b;
        public final int f12629c;
        public final int f12630d;

        public State(Drawable drawable, Drawable drawable2, int i, int i2) {
            this.f12627a = drawable;
            this.f12628b = drawable2;
            this.f12629c = i;
            this.f12630d = i2;
        }
    }

    private static ThrowbackVideoSharePartDefinition m14466b(InjectorLike injectorLike) {
        return new ThrowbackVideoSharePartDefinition(BackgroundPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), FbUriIntentHandler.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (Context) injectorLike.getInstance(Context.class), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final Object m14468a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Position position;
        String str;
        FeedProps feedProps = (FeedProps) obj;
        PaddingStyle paddingStyle = f12631a;
        if (((FeedUnit) feedProps.a) instanceof GraphQLGoodwillThrowbackFriendversaryPromotionStory) {
            position = Position.BOTTOM;
        } else {
            position = null;
        }
        subParts.a(this.f12634b, new StylingData(feedProps, paddingStyle, position));
        final GraphQLGoodwillVideoCampaign a = m14465a((FeedUnit) feedProps.a);
        subParts.a(2131568143, this.f12635c, this.f12640h.getString(2131239207));
        subParts.a(2131568144, this.f12635c, this.f12640h.getString(2131239206));
        if (((FeedUnit) feedProps.a) instanceof GraphQLGoodwillThrowbackFriendversaryPromotionStory) {
            str = "otd_permalink";
        } else {
            str = "promotion";
        }
        final String str2 = str;
        subParts.a(2131568143, this.f12636d, new OnClickListener(this) {
            final /* synthetic */ ThrowbackVideoSharePartDefinition f12624c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1712118900);
                Intent intent = new Intent(this.f12624c.f12639g, GoodwillVideoComposerLauncher.class);
                intent.putExtra("campaign_id", a.j());
                intent.putExtra("campaign_type", a.m().toString());
                intent.putExtra("source", str2);
                intent.putExtra("direct_source", str2);
                intent.putExtra("share_preview", a.n().b());
                Object p = a.p();
                if (!TextUtils.isEmpty(p)) {
                    intent.putExtra("default_share_message", p);
                }
                p = a.q();
                if (!TextUtils.isEmpty(p)) {
                    intent.putExtra("placeholder_text", p);
                }
                p = a.r();
                if (!TextUtils.isEmpty(p)) {
                    intent.putExtra("share_preview_title", p);
                }
                ImmutableList o = a.o();
                if (CollectionUtil.b(o)) {
                    Serializable arrayList = new ArrayList();
                    int size = o.size();
                    for (int i = 0; i < size; i++) {
                        GraphQLUser graphQLUser = (GraphQLUser) o.get(i);
                        Builder a2 = ComposerTaggedUser.a(Long.parseLong(graphQLUser.P()));
                        a2.b = graphQLUser.ar();
                        a2 = a2;
                        if (!(graphQLUser.aI() == null || TextUtils.isEmpty(graphQLUser.aI().b()))) {
                            a2.c = graphQLUser.aI().b();
                        }
                        arrayList.add(a2.a());
                    }
                    intent.putExtra("tagged_users", arrayList);
                }
                this.f12624c.f12638f.a(intent, this.f12624c.f12639g);
                LogUtils.a(-1651876421, a);
            }
        });
        subParts.a(2131568144, this.f12636d, new OnClickListener(this) {
            final /* synthetic */ ThrowbackVideoSharePartDefinition f12626b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1967284936);
                this.f12626b.f12637e.a(this.f12626b.f12639g, StringFormatUtil.formatStrLocaleSafe(FBLinks.er, a.j(), a.m().toString(), "promotion"));
                Logger.a(2, EntryType.UI_INPUT_END, -1065900589, a);
            }
        });
        return new State(this.f12640h.getDrawable(2130843792), this.f12640h.getDrawable(2130840013), this.f12640h.getColor(2131361937), this.f12640h.getColor(2131361937));
    }

    public final /* bridge */ /* synthetic */ void m14469a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 627595394);
        State state = (State) obj2;
        TwoButtonFooterView twoButtonFooterView = (TwoButtonFooterView) view;
        twoButtonFooterView.a(Button.LEFT, state.f12627a);
        twoButtonFooterView.a(Button.LEFT, state.f12629c);
        twoButtonFooterView.a(Button.RIGHT, state.f12628b);
        twoButtonFooterView.a(Button.RIGHT, state.f12630d);
        Logger.a(8, EntryType.MARK_POP, 468333261, a);
    }

    public final boolean m14470a(Object obj) {
        GraphQLGoodwillVideoCampaign a = m14465a((FeedUnit) ((FeedProps) obj).a);
        if (a == null) {
            return false;
        }
        return (a.n() == null || TextUtils.isEmpty(a.n().b()) || a.m() == null || TextUtils.isEmpty(a.j())) ? false : true;
    }

    public final void m14471b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        TwoButtonFooterView twoButtonFooterView = (TwoButtonFooterView) view;
        twoButtonFooterView.a(Button.LEFT, null);
        twoButtonFooterView.a(Button.RIGHT, null);
    }

    public static ThrowbackVideoSharePartDefinition m14464a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackVideoSharePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12633j) {
                ThrowbackVideoSharePartDefinition throwbackVideoSharePartDefinition;
                if (a2 != null) {
                    throwbackVideoSharePartDefinition = (ThrowbackVideoSharePartDefinition) a2.a(f12633j);
                } else {
                    throwbackVideoSharePartDefinition = f12632i;
                }
                if (throwbackVideoSharePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14466b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12633j, b3);
                        } else {
                            f12632i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackVideoSharePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    static {
        PaddingStyle.Builder d = PaddingStyle.Builder.d();
        d.b = -2.0f;
        d = d;
        d.c = -2.0f;
        f12631a = d.i();
    }

    @Inject
    public ThrowbackVideoSharePartDefinition(BackgroundPartDefinition backgroundPartDefinition, TextPartDefinition textPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, FbUriIntentHandler fbUriIntentHandler, SecureContextHelper secureContextHelper, Context context, Resources resources) {
        this.f12634b = backgroundPartDefinition;
        this.f12635c = textPartDefinition;
        this.f12636d = clickListenerPartDefinition;
        this.f12637e = fbUriIntentHandler;
        this.f12638f = secureContextHelper;
        this.f12639g = context;
        this.f12640h = resources;
    }

    public final ViewType m14467a() {
        return TwoButtonFooterView.a;
    }

    private static GraphQLGoodwillVideoCampaign m14465a(FeedUnit feedUnit) {
        if (feedUnit instanceof GraphQLGoodwillThrowbackFriendversaryPromotionStory) {
            GraphQLGoodwillFriendversaryCampaign l = ((GraphQLGoodwillThrowbackFriendversaryPromotionStory) feedUnit).l();
            if (l != null) {
                return l.x();
            }
        } else if (feedUnit instanceof GraphQLGoodwillThrowbackPromotionFeedUnit) {
            GraphQLGoodwillCampaign g = GoodwillFeedUnitHelper.g((GraphQLGoodwillThrowbackPromotionFeedUnit) feedUnit);
            if (g != null) {
                return g.F();
            }
        }
        return null;
    }
}
