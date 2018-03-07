package com.facebook.timeline.protiles.rows;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.fbpipeline.FbPipelineDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.events.EventsStream;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.protiles.events.ProtilesActionEvent;
import com.facebook.timeline.protiles.model.ProtileModel;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLInterfaces.ProtileItemFields;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLModels.ProtileItemFieldsModel;
import com.facebook.timeline.protiles.util.ProtilesClickHandler;
import com.facebook.timeline.protiles.util.ProtilesImageUtil;
import com.facebook.widget.mosaic.MosaicGridLayout;
import com.facebook.widget.mosaic.MosaicGridLayout.LayoutParams;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: fbad_command */
public class ProtilesMosaicSinglePhotoPartDefinition<E extends HasImageLoadListener & HasPrefetcher> extends BaseSinglePartDefinition<MosaicSinglePhotoData, State, E, MosaicGridLayout> {
    private static final CallerContext f12309a = CallerContext.a(ProtilesMosaicSinglePhotoPartDefinition.class, "timeline");
    private static ProtilesMosaicSinglePhotoPartDefinition f12310h;
    private static final Object f12311i = new Object();
    public final ProtilesClickHandler f12312b;
    public final EventsStream f12313c;
    private final FbDraweeControllerBuilder f12314d;
    public final Provider<Boolean> f12315e;
    private final QeAccessor f12316f;
    private final ProtilesImageUtil f12317g;

    /* compiled from: fbad_command */
    public class MosaicSinglePhotoData {
        public final ProtileItemFieldsModel f12300a;
        public final ProtileModel f12301b;
        public final int f12302c;

        public MosaicSinglePhotoData(ProtileItemFieldsModel protileItemFieldsModel, ProtileModel protileModel, int i) {
            this.f12300a = protileItemFieldsModel;
            this.f12301b = protileModel;
            this.f12302c = i;
        }
    }

    /* compiled from: fbad_command */
    public class State {
        public LayoutParams f12303a;
        public DraweeController f12304b;
        public Drawable f12305c;
        public PointF f12306d;
        public OnClickListener f12307e;
        public String f12308f;

        public State(LayoutParams layoutParams, DraweeController draweeController, Drawable drawable, PointF pointF, OnClickListener onClickListener, String str) {
            this.f12303a = layoutParams;
            this.f12304b = draweeController;
            this.f12305c = drawable;
            this.f12306d = pointF;
            this.f12307e = onClickListener;
            this.f12308f = str;
        }
    }

    private static ProtilesMosaicSinglePhotoPartDefinition m12358b(InjectorLike injectorLike) {
        return new ProtilesMosaicSinglePhotoPartDefinition(EventsStream.a(injectorLike), ProtilesClickHandler.m12399a(injectorLike), FbDraweeControllerBuilder.b(injectorLike), IdBasedProvider.a(injectorLike, 3959), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), ProtilesImageUtil.m12423a(injectorLike));
    }

    public final Object m12359a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Drawable colorDrawable;
        C17461 c17461;
        MosaicSinglePhotoData mosaicSinglePhotoData = (MosaicSinglePhotoData) obj;
        HasImageLoadListener hasImageLoadListener = (HasImageLoadListener) anyEnvironment;
        String str = null;
        final DefaultImageFields b = this.f12317g.m12430b(mosaicSinglePhotoData.f12300a);
        List a = m12356a(b, mosaicSinglePhotoData.f12300a);
        Object[] objArr = new ImageRequest[a.size()];
        a.toArray(objArr);
        ImageRequest b2 = m12357b(b, mosaicSinglePhotoData.f12300a);
        FbDraweeControllerBuilder a2 = this.f12314d.a(f12309a);
        if (a.isEmpty()) {
            objArr = null;
        }
        FbPipelineDraweeController s = ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) a2.a(objArr)).d(b2)).s();
        if (!a.isEmpty()) {
            hasImageLoadListener.a(s, mosaicSinglePhotoData.f12301b.f12105a, (ImageRequest) a.get(0));
        }
        if (mosaicSinglePhotoData.f12300a.m12180b().m12155l() != null) {
            colorDrawable = new ColorDrawable(Color.parseColor("#" + mosaicSinglePhotoData.f12300a.m12180b().m12155l()));
        } else {
            colorDrawable = null;
        }
        if (this.f12316f.a(ExperimentsForTimelineAbTestModule.aw, false)) {
            if (!a.isEmpty()) {
                ((HasPrefetcher) hasImageLoadListener).a((ImageRequest) a.get(0), f12309a);
            }
            if (b2 != null) {
                ((HasPrefetcher) hasImageLoadListener).a(b2, f12309a);
            }
        }
        PointF a3 = ProtilesImageUtil.m12420a(mosaicSinglePhotoData.f12300a);
        final ProtileItemFieldsModel protileItemFieldsModel = mosaicSinglePhotoData.f12300a;
        final ProtileModel protileModel = mosaicSinglePhotoData.f12301b;
        if (protileItemFieldsModel.m12180b() == null) {
            c17461 = null;
        } else {
            c17461 = new OnClickListener(this) {
                final /* synthetic */ ProtilesMosaicSinglePhotoPartDefinition f12299d;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -543006768);
                    Preconditions.checkArgument(view instanceof FbDraweeView);
                    this.f12299d.f12312b.m12403a((FbDraweeView) view, protileItemFieldsModel.m12180b().m12151d(), b, protileModel.m12114g(), protileModel);
                    this.f12299d.f12313c.a(ProtilesActionEvent.m12101a(protileModel, protileItemFieldsModel));
                    Logger.a(2, EntryType.UI_INPUT_END, 1291721028, a);
                }
            };
        }
        C17461 c174612 = c17461;
        if (!(mosaicSinglePhotoData.f12300a.m12180b() == null || mosaicSinglePhotoData.f12300a.m12180b().m12153j() == null)) {
            str = mosaicSinglePhotoData.f12300a.m12180b().m12153j();
        }
        return new State(ProtilesImageUtil.m12425c(mosaicSinglePhotoData.f12300a), s, colorDrawable, a3, c174612, str);
    }

    public final /* bridge */ /* synthetic */ void m12360a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 419573180);
        MosaicSinglePhotoData mosaicSinglePhotoData = (MosaicSinglePhotoData) obj;
        State state = (State) obj2;
        MosaicGridLayout mosaicGridLayout = (MosaicGridLayout) view;
        if (!((Boolean) this.f12315e.get()).booleanValue() && mosaicSinglePhotoData.f12302c < mosaicGridLayout.getChildCount()) {
            CharSequence string;
            FbDraweeView fbDraweeView = (FbDraweeView) mosaicGridLayout.getChildAt(mosaicSinglePhotoData.f12302c);
            fbDraweeView.setLayoutParams(state.f12303a);
            fbDraweeView.setController(state.f12304b);
            ((GenericDraweeHierarchy) fbDraweeView.getHierarchy()).a(state.f12306d);
            if (state.f12305c != null) {
                ((GenericDraweeHierarchy) fbDraweeView.getHierarchy()).b(state.f12305c);
            }
            fbDraweeView.setOnClickListener(state.f12307e);
            if (state.f12308f != null) {
                string = fbDraweeView.getResources().getString(2131241409, new Object[]{Integer.valueOf(mosaicSinglePhotoData.f12302c + 1), Integer.valueOf(mosaicGridLayout.getChildCount()), state.f12308f});
            } else {
                string = fbDraweeView.getResources().getString(2131241408, new Object[]{Integer.valueOf(mosaicSinglePhotoData.f12302c + 1)});
            }
            fbDraweeView.setContentDescription(string);
        }
        Logger.a(8, EntryType.MARK_POP, 1724541483, a);
    }

    public final void m12361b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        MosaicSinglePhotoData mosaicSinglePhotoData = (MosaicSinglePhotoData) obj;
        MosaicGridLayout mosaicGridLayout = (MosaicGridLayout) view;
        if (mosaicSinglePhotoData.f12302c < mosaicGridLayout.getChildCount()) {
            mosaicGridLayout.getChildAt(mosaicSinglePhotoData.f12302c).setOnClickListener(null);
        }
    }

    public static ProtilesMosaicSinglePhotoPartDefinition m12355a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProtilesMosaicSinglePhotoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12311i) {
                ProtilesMosaicSinglePhotoPartDefinition protilesMosaicSinglePhotoPartDefinition;
                if (a2 != null) {
                    protilesMosaicSinglePhotoPartDefinition = (ProtilesMosaicSinglePhotoPartDefinition) a2.a(f12311i);
                } else {
                    protilesMosaicSinglePhotoPartDefinition = f12310h;
                }
                if (protilesMosaicSinglePhotoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12358b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12311i, b3);
                        } else {
                            f12310h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = protilesMosaicSinglePhotoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ProtilesMosaicSinglePhotoPartDefinition(EventsStream eventsStream, ProtilesClickHandler protilesClickHandler, FbDraweeControllerBuilder fbDraweeControllerBuilder, Provider<Boolean> provider, QeAccessor qeAccessor, ProtilesImageUtil protilesImageUtil) {
        this.f12313c = eventsStream;
        this.f12312b = protilesClickHandler;
        this.f12314d = fbDraweeControllerBuilder;
        this.f12315e = provider;
        this.f12316f = qeAccessor;
        this.f12317g = protilesImageUtil;
    }

    private List<ImageRequest> m12356a(@Nullable DefaultImageFields defaultImageFields, ProtileItemFields protileItemFields) {
        List arrayList = new ArrayList(3);
        if (defaultImageFields != null) {
            arrayList.add(ImageRequest.a(defaultImageFields.b()));
            if (this.f12316f.a(ExperimentsForTimelineAbTestModule.aU, false)) {
                DefaultImageFields bc_ = protileItemFields.m12180b().bc_();
                DefaultImageFields g = protileItemFields.m12180b().m12152g();
                if (!(defaultImageFields == g || defaultImageFields == bc_)) {
                    arrayList.add(m12354a(bc_));
                }
                if (defaultImageFields != g) {
                    arrayList.add(m12354a(g));
                }
            }
        }
        return arrayList;
    }

    @Nullable
    private ImageRequest m12357b(@Nullable DefaultImageFields defaultImageFields, ProtileItemFieldsModel protileItemFieldsModel) {
        if (defaultImageFields == null || !this.f12316f.a(ExperimentsForTimelineAbTestModule.aU, false)) {
            return null;
        }
        DefaultImageFields bd_ = protileItemFieldsModel.m12180b().bd_();
        DefaultImageFields bc_ = protileItemFieldsModel.m12180b().bc_();
        if (defaultImageFields == protileItemFieldsModel.m12180b().m12152g()) {
            return m12354a(bc_);
        }
        if (defaultImageFields == bc_) {
            return m12354a(bd_);
        }
        return null;
    }

    @Nullable
    private static ImageRequest m12354a(@Nullable DefaultImageFields defaultImageFields) {
        if (defaultImageFields == null) {
            return null;
        }
        ImageRequestBuilder a = ImageRequestBuilder.a(Uri.parse(defaultImageFields.b()));
        a.b = RequestLevel.DISK_CACHE;
        return a.m();
    }
}
