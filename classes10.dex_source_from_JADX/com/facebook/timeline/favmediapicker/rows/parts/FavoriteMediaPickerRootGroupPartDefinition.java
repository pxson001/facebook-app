package com.facebook.timeline.favmediapicker.rows.parts;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.RootPartSelector;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.timeline.favmediapicker.models.CameraRollData;
import com.facebook.timeline.favmediapicker.models.SuggestedForYouLabel;
import com.facebook.timeline.favmediapicker.protocol.FetchFavoriteMediaPickerSuggestionsModels.SuggestedMediasetModel;
import com.facebook.timeline.favmediapicker.rows.environments.FavoriteMediaPickerEnvironment;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friends_nearby_settings_learn_more */
public class FavoriteMediaPickerRootGroupPartDefinition extends BaseMultiRowGroupPartDefinition<Object, Void, FavoriteMediaPickerEnvironment> {
    private static FavoriteMediaPickerRootGroupPartDefinition f11071b;
    private static final Object f11072c = new Object();
    private final RootPartSelector<FavoriteMediaPickerEnvironment> f11073a;

    private static FavoriteMediaPickerRootGroupPartDefinition m11240b(InjectorLike injectorLike) {
        return new FavoriteMediaPickerRootGroupPartDefinition(IdBasedLazy.a(injectorLike, 11224), IdBasedLazy.a(injectorLike, 11229), IdBasedLazy.a(injectorLike, 11231));
    }

    @Inject
    public FavoriteMediaPickerRootGroupPartDefinition(Lazy<CameraSectionPartDefinition> lazy, Lazy<SuggestedForYouLabelPartDefinition> lazy2, Lazy<SuggestedMediasetSectionPartDefinition> lazy3) {
        this.f11073a = RootPartSelector.a().a(CameraRollData.class, lazy).a(SuggestedForYouLabel.class, lazy2).a(SuggestedMediasetModel.class, lazy3);
    }

    public final boolean m11242a(Object obj) {
        return true;
    }

    public final Object m11241a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        this.f11073a.a(baseMultiRowSubParts, obj);
        return null;
    }

    public static FavoriteMediaPickerRootGroupPartDefinition m11239a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FavoriteMediaPickerRootGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11072c) {
                FavoriteMediaPickerRootGroupPartDefinition favoriteMediaPickerRootGroupPartDefinition;
                if (a2 != null) {
                    favoriteMediaPickerRootGroupPartDefinition = (FavoriteMediaPickerRootGroupPartDefinition) a2.a(f11072c);
                } else {
                    favoriteMediaPickerRootGroupPartDefinition = f11071b;
                }
                if (favoriteMediaPickerRootGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11240b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11072c, b3);
                        } else {
                            f11071b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = favoriteMediaPickerRootGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
