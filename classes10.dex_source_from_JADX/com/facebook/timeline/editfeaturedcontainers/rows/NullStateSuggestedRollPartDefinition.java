package com.facebook.timeline.editfeaturedcontainers.rows;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewRowType;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyleFactory;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSubParts;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Props;
import com.facebook.feed.rows.sections.hscrollrecyclerview.SimpleCallbacks;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.ViewPaddingPartDefinition;
import com.facebook.multirow.parts.ViewPaddingPartDefinition.PaddingData;
import com.facebook.timeline.editfeaturedcontainers.models.SuggestedPhotosData;
import com.facebook.timeline.editfeaturedcontainers.protocol.FetchNullStateGraphQLModels.FeaturedPhotoSuggestionModel;
import com.facebook.timeline.editfeaturedcontainers.rows.environments.NullStateEnvironment;
import com.facebook.timeline.editfeaturedcontainers.utils.StagingGroundIntentCreator;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: getEmailAddresses */
public class NullStateSuggestedRollPartDefinition extends MultiRowSinglePartDefinition<SuggestedPhotosData, Void, NullStateEnvironment, HScrollRecyclerView> {
    public static final CacheableEntity f10879a = new C15741();
    public static final CallerContext f10880b = CallerContext.a(NullStateSuggestedRollPartDefinition.class, "afc_null_state");
    private static NullStateSuggestedRollPartDefinition f10881i;
    private static final Object f10882j = new Object();
    public final NullStateClickablePhotoPartDefinition f10883c;
    private final PersistentRecyclerPartDefinition<Object, NullStateEnvironment> f10884d;
    private final ViewPaddingPartDefinition f10885e;
    public final Provider<SecureContextHelper> f10886f;
    public final PageStyleFactory f10887g;
    public final Resources f10888h;

    /* compiled from: getEmailAddresses */
    final class C15741 implements CacheableEntity {
        C15741() {
        }

        public final String m10987g() {
            return "suggested_roll_key";
        }
    }

    /* compiled from: getEmailAddresses */
    public class C15763 implements OnClickListener {
        final /* synthetic */ String f10877a;
        final /* synthetic */ NullStateSuggestedRollPartDefinition f10878b;

        public C15763(NullStateSuggestedRollPartDefinition nullStateSuggestedRollPartDefinition, String str) {
            this.f10878b = nullStateSuggestedRollPartDefinition;
            this.f10877a = str;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1174416112);
            ((SecureContextHelper) this.f10878b.f10886f.get()).a(StagingGroundIntentCreator.m11093a(view.getContext(), true, null, this.f10877a), 4, (Activity) ContextUtils.a(view.getContext(), Activity.class));
            Logger.a(2, EntryType.UI_INPUT_END, 989910621, a);
        }
    }

    private static NullStateSuggestedRollPartDefinition m10991b(InjectorLike injectorLike) {
        return new NullStateSuggestedRollPartDefinition(NullStateClickablePhotoPartDefinition.m10945a(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), ViewPaddingPartDefinition.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 968), PageStyleFactory.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final Object m10994a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        SuggestedPhotosData suggestedPhotosData = (SuggestedPhotosData) obj;
        PersistentRecyclerPartDefinition persistentRecyclerPartDefinition = this.f10884d;
        final ImmutableList immutableList = suggestedPhotosData.f10771a;
        subParts.a(persistentRecyclerPartDefinition, new Props(this.f10887g.a((this.f10888h.getDimension(2131433938) / this.f10888h.getDisplayMetrics().density) + 8.0f, Builder.c().i(), true), 0, new SimpleCallbacks<NullStateEnvironment>(this) {
            final /* synthetic */ NullStateSuggestedRollPartDefinition f10876b;

            public final void m10988a(PageSubParts<NullStateEnvironment> pageSubParts) {
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    FeaturedPhotoSuggestionModel featuredPhotoSuggestionModel = (FeaturedPhotoSuggestionModel) immutableList.get(i);
                    NullStateSuggestedRollPartDefinition nullStateSuggestedRollPartDefinition = this.f10876b;
                    String str = null;
                    if (!(featuredPhotoSuggestionModel.m10862a() == null || featuredPhotoSuggestionModel.m10862a().m10893k() == null || featuredPhotoSuggestionModel.m10862a().m10893k().b() == null)) {
                        str = featuredPhotoSuggestionModel.m10862a().m10893k().b();
                    }
                    FbDraweePartDefinition.Props.Builder builder = new FbDraweePartDefinition.Props.Builder();
                    builder.c = NullStateSuggestedRollPartDefinition.f10880b;
                    pageSubParts.a(this.f10876b.f10883c, new NullStateClickablePhotoPartDefinition.Props(builder.a(str).a(), new C15763(nullStateSuggestedRollPartDefinition, featuredPhotoSuggestionModel.m10862a().m10892j())));
                }
            }

            public final void m10989c(int i) {
            }
        }, f10879a.g(), f10879a));
        subParts.a(this.f10885e, m10992c());
        return null;
    }

    public final /* bridge */ /* synthetic */ void m10995a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1047065575);
        HScrollRecyclerView hScrollRecyclerView = (HScrollRecyclerView) view;
        CustomViewUtils.b(hScrollRecyclerView, new ColorDrawable(ContextCompat.b(hScrollRecyclerView.getContext(), 2131361920)));
        Logger.a(8, EntryType.MARK_POP, 487942798, a);
    }

    public static NullStateSuggestedRollPartDefinition m10990a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NullStateSuggestedRollPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10882j) {
                NullStateSuggestedRollPartDefinition nullStateSuggestedRollPartDefinition;
                if (a2 != null) {
                    nullStateSuggestedRollPartDefinition = (NullStateSuggestedRollPartDefinition) a2.a(f10882j);
                } else {
                    nullStateSuggestedRollPartDefinition = f10881i;
                }
                if (nullStateSuggestedRollPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10991b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10882j, b3);
                        } else {
                            f10881i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = nullStateSuggestedRollPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public NullStateSuggestedRollPartDefinition(NullStateClickablePhotoPartDefinition nullStateClickablePhotoPartDefinition, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, ViewPaddingPartDefinition viewPaddingPartDefinition, Provider<SecureContextHelper> provider, PageStyleFactory pageStyleFactory, Resources resources) {
        this.f10883c = nullStateClickablePhotoPartDefinition;
        this.f10884d = persistentRecyclerPartDefinition;
        this.f10885e = viewPaddingPartDefinition;
        this.f10886f = provider;
        this.f10887g = pageStyleFactory;
        this.f10888h = resources;
    }

    public final ViewType<HScrollRecyclerView> m10993a() {
        return HScrollRecyclerViewRowType.b;
    }

    public final boolean m10996a(Object obj) {
        return true;
    }

    private PaddingData m10992c() {
        int dimensionPixelSize = this.f10888h.getDimensionPixelSize(2131433939);
        return new PaddingData(dimensionPixelSize, 0, dimensionPixelSize, this.f10888h.getDimensionPixelSize(2131433940));
    }
}
