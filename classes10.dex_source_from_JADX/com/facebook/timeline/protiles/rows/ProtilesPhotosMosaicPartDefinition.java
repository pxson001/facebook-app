package com.facebook.timeline.protiles.rows;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.enums.GraphQLProfileTileSectionType;
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
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.timeline.protiles.model.ProtileModel;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLModels.ProtileItemFieldsModel;
import com.facebook.timeline.protiles.rows.ProtilesMosaicSinglePhotoPartDefinition.MosaicSinglePhotoData;
import com.facebook.timeline.protiles.util.TimelineCollapsedProtilesExperimentHelper;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.mosaic.MosaicGridLayout;
import com.facebook.widget.mosaic.MosaicGridLayout.LayoutParams;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: fb_photos_picker */
public class ProtilesPhotosMosaicPartDefinition<E extends HasImageLoadListener> extends MultiRowSinglePartDefinition<ProtileModel, Integer, E, MosaicGridLayout> {
    public static final ViewType f12318a = new C17471();
    private static ProtilesPhotosMosaicPartDefinition f12319e;
    private static final Object f12320f = new Object();
    private final ProtilesMosaicSinglePhotoPartDefinition f12321b;
    public final Provider<Boolean> f12322c;
    private final TimelineCollapsedProtilesExperimentHelper f12323d;

    /* compiled from: fb_photos_picker */
    final class C17471 extends ViewType {
        C17471() {
        }

        public final View m12362a(Context context) {
            MosaicGridLayout mosaicGridLayout = new MosaicGridLayout(context);
            CustomViewUtils.b(mosaicGridLayout, new ColorDrawable(-1));
            Resources resources = context.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(2131433949);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(2131433968);
            mosaicGridLayout.m11834a(dimensionPixelSize, 0, dimensionPixelSize, 0);
            mosaicGridLayout.m11835b(dimensionPixelSize2, dimensionPixelSize2);
            mosaicGridLayout.f11738c = true;
            return mosaicGridLayout;
        }
    }

    private static ProtilesPhotosMosaicPartDefinition m12365b(InjectorLike injectorLike) {
        return new ProtilesPhotosMosaicPartDefinition(ProtilesMosaicSinglePhotoPartDefinition.m12355a(injectorLike), IdBasedProvider.a(injectorLike, 3959), TimelineCollapsedProtilesExperimentHelper.m12438a(injectorLike));
    }

    public final Object m12367a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ProtileModel protileModel = (ProtileModel) obj;
        int i = 0;
        for (int i2 = 0; i2 < protileModel.f12107c.size(); i2++) {
            ProtileItemFieldsModel protileItemFieldsModel = (ProtileItemFieldsModel) protileModel.f12107c.get(i2);
            if (protileItemFieldsModel.m12183j() != null) {
                int i3 = i + 1;
                subParts.a(this.f12321b, new MosaicSinglePhotoData(protileItemFieldsModel, protileModel, i));
                i = i3;
            }
        }
        return Integer.valueOf(i);
    }

    public final /* bridge */ /* synthetic */ void m12368a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1070184772);
        Integer num = (Integer) obj2;
        MosaicGridLayout mosaicGridLayout = (MosaicGridLayout) view;
        if (!((Boolean) this.f12322c.get()).booleanValue()) {
            for (int childCount = mosaicGridLayout.getChildCount(); childCount < num.intValue(); childCount++) {
                mosaicGridLayout.addView(m12363a(mosaicGridLayout.getContext()));
            }
        } else if (mosaicGridLayout.getChildCount() <= 0) {
            FbDraweeView a2 = m12363a(mosaicGridLayout.getContext());
            a2.setImageURI(null);
            mosaicGridLayout.addView(a2, new LayoutParams(0, 0, 6, 3));
        }
        Logger.a(8, EntryType.MARK_POP, -1838856352, a);
    }

    public final boolean m12369a(Object obj) {
        ProtileModel protileModel = (ProtileModel) obj;
        return protileModel.m12109b() == GraphQLProfileTileSectionType.PHOTOS && !this.f12323d.m12445c(protileModel);
    }

    public static ProtilesPhotosMosaicPartDefinition m12364a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProtilesPhotosMosaicPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12320f) {
                ProtilesPhotosMosaicPartDefinition protilesPhotosMosaicPartDefinition;
                if (a2 != null) {
                    protilesPhotosMosaicPartDefinition = (ProtilesPhotosMosaicPartDefinition) a2.a(f12320f);
                } else {
                    protilesPhotosMosaicPartDefinition = f12319e;
                }
                if (protilesPhotosMosaicPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12365b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12320f, b3);
                        } else {
                            f12319e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = protilesPhotosMosaicPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ProtilesPhotosMosaicPartDefinition(ProtilesMosaicSinglePhotoPartDefinition protilesMosaicSinglePhotoPartDefinition, Provider<Boolean> provider, TimelineCollapsedProtilesExperimentHelper timelineCollapsedProtilesExperimentHelper) {
        this.f12321b = protilesMosaicSinglePhotoPartDefinition;
        this.f12322c = provider;
        this.f12323d = timelineCollapsedProtilesExperimentHelper;
    }

    public final ViewType m12366a() {
        return f12318a;
    }

    public static FbDraweeView m12363a(Context context) {
        FbDraweeView fbDraweeView = new FbDraweeView(context);
        Resources resources = context.getResources();
        GenericDraweeHierarchyBuilder g = new GenericDraweeHierarchyBuilder(context.getResources()).g(resources.getDrawable(2131362998));
        g.f = resources.getDrawable(2131363867);
        fbDraweeView.setHierarchy(g.e(ScaleType.h).u());
        return fbDraweeView;
    }
}
