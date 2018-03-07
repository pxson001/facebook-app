package com.facebook.timeline.favmediapicker.rows.parts;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.photos.pandora.ui.PandoraMediaSetActivity;
import com.facebook.timeline.favmediapicker.protocol.FetchFavoriteMediaPickerSuggestionsModels.SuggestedMediasetModel;
import com.facebook.timeline.favmediapicker.rows.environments.FavoriteMediaPickerEnvironment;
import com.facebook.timeline.favmediapicker.rows.parts.SectionTitlePartDefinition.Props;
import com.facebook.timeline.favmediapicker.ui.FavoriteMediaPickerActivity;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: friends_nearby_search_section_onetap_invite */
public class SuggestedMediasetSectionPartDefinition extends BaseMultiRowGroupPartDefinition<SuggestedMediasetModel, Void, FavoriteMediaPickerEnvironment> {
    public static final CallerContext f11109a = CallerContext.a(SuggestedMediasetSectionPartDefinition.class, "favorite_media_picker");
    private static SuggestedMediasetSectionPartDefinition f11110f;
    private static final Object f11111g = new Object();
    public final Provider<SecureContextHelper> f11112b;
    private final SectionTitlePartDefinition f11113c;
    private final SuggestedMediasetRollPartDefinition f11114d;
    public final String f11115e;

    private static SuggestedMediasetSectionPartDefinition m11270b(InjectorLike injectorLike) {
        return new SuggestedMediasetSectionPartDefinition(IdBasedSingletonScopeProvider.a(injectorLike, 968), SectionTitlePartDefinition.m11248a(injectorLike), SuggestedMediasetRollPartDefinition.m11262a(injectorLike), IdBasedProvider.a(injectorLike, 4442));
    }

    public final Object m11271a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        C16071 c16071;
        final SuggestedMediasetModel suggestedMediasetModel = (SuggestedMediasetModel) obj;
        String a = suggestedMediasetModel.m11191l() == null ? null : suggestedMediasetModel.m11191l().m11184a();
        SectionTitlePartDefinition sectionTitlePartDefinition = this.f11113c;
        if (suggestedMediasetModel.m11190k() == null || suggestedMediasetModel.m11190k().m11178a().size() < 6) {
            c16071 = null;
        } else {
            c16071 = new OnClickListener(this) {
                final /* synthetic */ SuggestedMediasetSectionPartDefinition f11108b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1288485073);
                    ((SecureContextHelper) this.f11108b.f11112b.get()).a(PandoraMediaSetActivity.a(view.getContext(), this.f11108b.f11115e, suggestedMediasetModel.m11189j(), view.getResources().getString(2131241396), SuggestedMediasetSectionPartDefinition.f11109a), 3, (Activity) ContextUtils.a(view.getContext(), FavoriteMediaPickerActivity.class));
                    Logger.a(2, EntryType.UI_INPUT_END, -1436567479, a);
                }
            };
        }
        baseMultiRowSubParts.a(sectionTitlePartDefinition, new Props(a, c16071));
        baseMultiRowSubParts.a(this.f11114d, suggestedMediasetModel);
        return null;
    }

    public final boolean m11272a(Object obj) {
        SuggestedMediasetModel suggestedMediasetModel = (SuggestedMediasetModel) obj;
        return (suggestedMediasetModel.m11190k() == null || suggestedMediasetModel.m11190k().m11178a().isEmpty()) ? false : true;
    }

    @Inject
    public SuggestedMediasetSectionPartDefinition(Provider<SecureContextHelper> provider, SectionTitlePartDefinition sectionTitlePartDefinition, SuggestedMediasetRollPartDefinition suggestedMediasetRollPartDefinition, Provider<String> provider2) {
        this.f11112b = provider;
        this.f11113c = sectionTitlePartDefinition;
        this.f11114d = suggestedMediasetRollPartDefinition;
        this.f11115e = (String) provider2.get();
    }

    public static SuggestedMediasetSectionPartDefinition m11269a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SuggestedMediasetSectionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11111g) {
                SuggestedMediasetSectionPartDefinition suggestedMediasetSectionPartDefinition;
                if (a2 != null) {
                    suggestedMediasetSectionPartDefinition = (SuggestedMediasetSectionPartDefinition) a2.a(f11111g);
                } else {
                    suggestedMediasetSectionPartDefinition = f11110f;
                }
                if (suggestedMediasetSectionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11270b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11111g, b3);
                        } else {
                            f11110f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = suggestedMediasetSectionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
