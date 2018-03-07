package com.facebook.timeline.editfeaturedcontainers.rows;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.photoreminder.model.MediaModel;
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
import com.facebook.timeline.editfeaturedcontainers.models.CameraRollData;
import com.facebook.timeline.editfeaturedcontainers.rows.environments.NullStateEnvironment;
import com.facebook.timeline.editfeaturedcontainers.utils.StagingGroundIntentCreator;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: getUserAgentString */
public class NullStateCameraRollPartDefinition extends MultiRowSinglePartDefinition<CameraRollData, Void, NullStateEnvironment, HScrollRecyclerView> {
    public static final CacheableEntity f10801a = new C15661();
    public static final CallerContext f10802b = CallerContext.a(NullStateCameraRollPartDefinition.class, "afc_null_state");
    private static NullStateCameraRollPartDefinition f10803i;
    private static final Object f10804j = new Object();
    public final NullStateClickablePhotoPartDefinition f10805c;
    private final PersistentRecyclerPartDefinition<Object, NullStateEnvironment> f10806d;
    private final ViewPaddingPartDefinition f10807e;
    public final Provider<SecureContextHelper> f10808f;
    public final PageStyleFactory f10809g;
    public final Resources f10810h;

    /* compiled from: getUserAgentString */
    final class C15661 implements CacheableEntity {
        C15661() {
        }

        public final String m10931g() {
            return "camera_roll_key";
        }
    }

    /* compiled from: getUserAgentString */
    public class C15683 implements OnClickListener {
        final /* synthetic */ Uri f10799a;
        final /* synthetic */ NullStateCameraRollPartDefinition f10800b;

        public C15683(NullStateCameraRollPartDefinition nullStateCameraRollPartDefinition, Uri uri) {
            this.f10800b = nullStateCameraRollPartDefinition;
            this.f10799a = uri;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1949889549);
            ((SecureContextHelper) this.f10800b.f10808f.get()).a(StagingGroundIntentCreator.m11093a(view.getContext(), true, this.f10799a, null), 4, (Activity) ContextUtils.a(view.getContext(), Activity.class));
            Logger.a(2, EntryType.UI_INPUT_END, 1532175017, a);
        }
    }

    private static NullStateCameraRollPartDefinition m10935b(InjectorLike injectorLike) {
        return new NullStateCameraRollPartDefinition(NullStateClickablePhotoPartDefinition.m10945a(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), ViewPaddingPartDefinition.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 968), PageStyleFactory.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final Object m10938a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        CameraRollData cameraRollData = (CameraRollData) obj;
        PersistentRecyclerPartDefinition persistentRecyclerPartDefinition = this.f10806d;
        final List list = cameraRollData.f10765a;
        subParts.a(persistentRecyclerPartDefinition, new Props(this.f10809g.a((this.f10810h.getDimension(2131433938) / this.f10810h.getDisplayMetrics().density) + 8.0f, Builder.c().i(), true), 0, new SimpleCallbacks<NullStateEnvironment>(this) {
            final /* synthetic */ NullStateCameraRollPartDefinition f10798b;

            public final void m10932a(PageSubParts<NullStateEnvironment> pageSubParts) {
                for (MediaModel mediaModel : list) {
                    NullStateCameraRollPartDefinition nullStateCameraRollPartDefinition = this.f10798b;
                    Uri uri = mediaModel.d;
                    FbDraweePartDefinition.Props.Builder builder = new FbDraweePartDefinition.Props.Builder();
                    builder.c = NullStateCameraRollPartDefinition.f10802b;
                    pageSubParts.a(this.f10798b.f10805c, new NullStateClickablePhotoPartDefinition.Props(builder.a(uri).a(), new C15683(nullStateCameraRollPartDefinition, uri)));
                }
            }

            public final void m10933c(int i) {
            }
        }, f10801a.g(), f10801a));
        subParts.a(this.f10807e, m10936c());
        return null;
    }

    public final /* bridge */ /* synthetic */ void m10939a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1546510867);
        HScrollRecyclerView hScrollRecyclerView = (HScrollRecyclerView) view;
        CustomViewUtils.b(hScrollRecyclerView, new ColorDrawable(ContextCompat.b(hScrollRecyclerView.getContext(), 2131361920)));
        Logger.a(8, EntryType.MARK_POP, 1781926442, a);
    }

    public static NullStateCameraRollPartDefinition m10934a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NullStateCameraRollPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10804j) {
                NullStateCameraRollPartDefinition nullStateCameraRollPartDefinition;
                if (a2 != null) {
                    nullStateCameraRollPartDefinition = (NullStateCameraRollPartDefinition) a2.a(f10804j);
                } else {
                    nullStateCameraRollPartDefinition = f10803i;
                }
                if (nullStateCameraRollPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10935b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10804j, b3);
                        } else {
                            f10803i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = nullStateCameraRollPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public NullStateCameraRollPartDefinition(NullStateClickablePhotoPartDefinition nullStateClickablePhotoPartDefinition, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, ViewPaddingPartDefinition viewPaddingPartDefinition, Provider<SecureContextHelper> provider, PageStyleFactory pageStyleFactory, Resources resources) {
        this.f10805c = nullStateClickablePhotoPartDefinition;
        this.f10806d = persistentRecyclerPartDefinition;
        this.f10807e = viewPaddingPartDefinition;
        this.f10808f = provider;
        this.f10809g = pageStyleFactory;
        this.f10810h = resources;
    }

    public final ViewType<HScrollRecyclerView> m10937a() {
        return HScrollRecyclerViewRowType.b;
    }

    public final boolean m10940a(Object obj) {
        return true;
    }

    private PaddingData m10936c() {
        int dimensionPixelSize = this.f10810h.getDimensionPixelSize(2131433939);
        return new PaddingData(dimensionPixelSize, 0, dimensionPixelSize, this.f10810h.getDimensionPixelSize(2131433940));
    }
}
