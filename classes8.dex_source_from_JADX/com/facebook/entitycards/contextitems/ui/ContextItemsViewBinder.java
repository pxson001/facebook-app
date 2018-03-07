package com.facebook.entitycards.contextitems.ui;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.util.SizeUtil;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.ContextItemFieldsModel;
import com.facebook.entitycards.contextitems.ui.ContextItemsAdapter.EntityData;
import com.facebook.graphql.enums.GraphQLEntityCardContextItemType;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.reviews.util.ReviewTextUtils;
import com.facebook.uicontrib.contextitem.PlutoniumContextualItemView;
import javax.inject.Inject;

/* compiled from: imageoverlay */
public class ContextItemsViewBinder {
    private final int f10943a;
    private final int f10944b;
    private final Context f10945c;
    private final LayoutInflater f10946d;
    private final ReviewTextUtils f10947e;
    private final Lazy<FbErrorReporter> f10948f;

    /* compiled from: imageoverlay */
    /* synthetic */ class C11751 {
        static final /* synthetic */ int[] f10942a = new int[GraphQLEntityCardContextItemType.values().length];

        static {
            try {
                f10942a[GraphQLEntityCardContextItemType.ADMIN_MESSAGE_ACTIVE_TROPHY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f10942a[GraphQLEntityCardContextItemType.PAGE_MESSAGE_RESPONSE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f10942a[GraphQLEntityCardContextItemType.ADMIN_MESSAGE_INACTIVE_TROPHY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static ContextItemsViewBinder m12884b(InjectorLike injectorLike) {
        return new ContextItemsViewBinder((Context) injectorLike.getInstance(Context.class), LayoutInflaterMethodAutoProvider.b(injectorLike), ReviewTextUtils.m4903a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494));
    }

    @Inject
    public ContextItemsViewBinder(Context context, LayoutInflater layoutInflater, ReviewTextUtils reviewTextUtils, Lazy<FbErrorReporter> lazy) {
        this.f10945c = context;
        this.f10946d = layoutInflater;
        this.f10947e = reviewTextUtils;
        this.f10948f = lazy;
        this.f10943a = SizeUtil.c(context.getResources(), 2131427402);
        this.f10944b = SizeUtil.c(context.getResources(), 2131427400);
    }

    public final void m12885a(PlutoniumContextualItemView plutoniumContextualItemView, ContextItemFieldsModel contextItemFieldsModel, EntityData entityData) {
        if (contextItemFieldsModel != null) {
            Resources resources = plutoniumContextualItemView.getResources();
            m12882a(plutoniumContextualItemView, contextItemFieldsModel, entityData, resources);
            if (contextItemFieldsModel.bC_() != null) {
                switch (C11751.f10942a[contextItemFieldsModel.d().ordinal()]) {
                    case 1:
                    case 2:
                        plutoniumContextualItemView.a(this.f10945c.getResources().getColor(2131361938), ContextItemsUiUtil.m12878a(contextItemFieldsModel, this.f10945c), 2, this.f10943a);
                        break;
                    default:
                        plutoniumContextualItemView.a(ContextItemsUiUtil.m12878a(contextItemFieldsModel, this.f10945c), 2, this.f10943a);
                        break;
                }
            }
            plutoniumContextualItemView.a(contextItemFieldsModel.g() != null ? contextItemFieldsModel.g().a() : null, 2, this.f10944b);
            plutoniumContextualItemView.b(resources.getDimensionPixelSize(2131427497));
            switch (C11751.f10942a[contextItemFieldsModel.d().ordinal()]) {
                case 1:
                    plutoniumContextualItemView.a(true, true);
                    break;
                case 3:
                    plutoniumContextualItemView.a(true, false);
                    break;
            }
            plutoniumContextualItemView.a(true, null);
        }
    }

    private void m12882a(PlutoniumContextualItemView plutoniumContextualItemView, ContextItemFieldsModel contextItemFieldsModel, EntityData entityData, Resources resources) {
        if (m12883a(contextItemFieldsModel, entityData)) {
            plutoniumContextualItemView.a(m12881a(entityData));
        } else if (contextItemFieldsModel.b() == null) {
        } else {
            if (contextItemFieldsModel.b().a() != null) {
                int dimensionPixelOffset = resources.getDimensionPixelOffset(2131429772);
                int dimensionPixelOffset2 = resources.getDimensionPixelOffset(2131427497);
                plutoniumContextualItemView.setPadding(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset, dimensionPixelOffset2);
                plutoniumContextualItemView.a(resources.getDimensionPixelSize(2131429771), 0, 0, Uri.parse(contextItemFieldsModel.b().a().d()), contextItemFieldsModel.b().b(), "entity_cards");
                return;
            }
            ((AbstractFbErrorReporter) this.f10948f.get()).b(getClass().getName(), "Icon with no IconImage, " + contextItemFieldsModel.d());
        }
    }

    private boolean m12883a(ContextItemFieldsModel contextItemFieldsModel, EntityData entityData) {
        if (contextItemFieldsModel.d() != GraphQLEntityCardContextItemType.RATINGS_AND_REVIEWS) {
            return false;
        }
        if (entityData.f10911b != null) {
            return true;
        }
        ((AbstractFbErrorReporter) this.f10948f.get()).a(getClass().getName(), "Review context without average rating for entity " + entityData.f10910a);
        return false;
    }

    private View m12881a(EntityData entityData) {
        View inflate = this.f10946d.inflate(2130903323, null);
        ((TextView) inflate.findViewById(2131559757)).setText(this.f10947e.m4905a(entityData.f10911b.k()));
        return inflate;
    }
}
