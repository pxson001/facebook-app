package com.facebook.timeline.favmediapicker.rows.parts;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
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
import com.facebook.timeline.favmediapicker.protocol.FetchFavoriteMediaPickerSuggestionsModels.SuggestedMediaModel;
import com.facebook.timeline.favmediapicker.protocol.FetchFavoriteMediaPickerSuggestionsModels.SuggestedMediasetModel;
import com.facebook.timeline.favmediapicker.rows.environments.FavoriteMediaPickerEnvironment;
import com.facebook.timeline.favmediapicker.ui.FavoriteMediaPickerActivity;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friends_nearby_search_section_onetap_undo */
public class SuggestedMediasetRollPartDefinition extends MultiRowSinglePartDefinition<SuggestedMediasetModel, Void, FavoriteMediaPickerEnvironment, HScrollRecyclerView> {
    public static final CacheableEntity f11098a = new C16041();
    public static final CallerContext f11099b = CallerContext.a(SuggestedMediasetRollPartDefinition.class, "favorite_media_picker");
    private static SuggestedMediasetRollPartDefinition f11100h;
    private static final Object f11101i = new Object();
    public final ClickablePhotoPartDefinition f11102c;
    private final PersistentRecyclerPartDefinition<Object, FavoriteMediaPickerEnvironment> f11103d;
    private final ViewPaddingPartDefinition f11104e;
    public final PageStyleFactory f11105f;
    public final Resources f11106g;

    /* compiled from: friends_nearby_search_section_onetap_undo */
    final class C16041 implements CacheableEntity {
        C16041() {
        }

        public final String m11259g() {
            return "suggested_roll_key";
        }
    }

    /* compiled from: friends_nearby_search_section_onetap_undo */
    public class C16063 implements OnClickListener {
        final /* synthetic */ String f11095a;
        final /* synthetic */ String f11096b;
        final /* synthetic */ SuggestedMediasetRollPartDefinition f11097c;

        public C16063(SuggestedMediasetRollPartDefinition suggestedMediasetRollPartDefinition, String str, String str2) {
            this.f11097c = suggestedMediasetRollPartDefinition;
            this.f11095a = str;
            this.f11096b = str2;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1490738778);
            FavoriteMediaPickerActivity favoriteMediaPickerActivity = (FavoriteMediaPickerActivity) ContextUtils.a(view.getContext(), FavoriteMediaPickerActivity.class);
            if (favoriteMediaPickerActivity != null) {
                SuggestedMediasetRollPartDefinition suggestedMediasetRollPartDefinition = this.f11097c;
                String str = this.f11095a;
                String str2 = this.f11096b;
                Intent intent = new Intent();
                intent.putExtra("suggested_media_fb_id", str);
                intent.putExtra("suggested_media_uri", str2);
                favoriteMediaPickerActivity.setResult(-1, intent);
                favoriteMediaPickerActivity.finish();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 813556574, a);
        }
    }

    private static SuggestedMediasetRollPartDefinition m11263b(InjectorLike injectorLike) {
        return new SuggestedMediasetRollPartDefinition(ClickablePhotoPartDefinition.m11235a(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), ViewPaddingPartDefinition.a(injectorLike), PageStyleFactory.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final Object m11266a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        SuggestedMediasetModel suggestedMediasetModel = (SuggestedMediasetModel) obj;
        if (suggestedMediasetModel.m11190k() != null) {
            PersistentRecyclerPartDefinition persistentRecyclerPartDefinition = this.f11103d;
            final ImmutableList a = suggestedMediasetModel.m11190k().m11178a();
            subParts.a(persistentRecyclerPartDefinition, new Props(this.f11105f.a((this.f11106g.getDimension(2131433945) / this.f11106g.getDisplayMetrics().density) + 8.0f, Builder.c().i(), true), 0, new SimpleCallbacks<FavoriteMediaPickerEnvironment>(this) {
                final /* synthetic */ SuggestedMediasetRollPartDefinition f11094b;

                public final void m11260a(PageSubParts<FavoriteMediaPickerEnvironment> pageSubParts) {
                    int size = a.size();
                    for (int i = 0; i < size; i++) {
                        SuggestedMediaModel suggestedMediaModel = (SuggestedMediaModel) a.get(i);
                        SuggestedMediasetRollPartDefinition suggestedMediasetRollPartDefinition = this.f11094b;
                        String b = suggestedMediaModel.m11172k() != null ? suggestedMediaModel.m11172k().b() : null;
                        FbDraweePartDefinition.Props.Builder builder = new FbDraweePartDefinition.Props.Builder();
                        builder.c = SuggestedMediasetRollPartDefinition.f11099b;
                        pageSubParts.a(this.f11094b.f11102c, new ClickablePhotoPartDefinition.Props(builder.a(b).a(), new C16063(suggestedMediasetRollPartDefinition, suggestedMediaModel.m11171j(), b)));
                    }
                }

                public final void m11261c(int i) {
                }
            }, f11098a.g(), f11098a));
        }
        subParts.a(this.f11104e, m11264c());
        return null;
    }

    public final /* bridge */ /* synthetic */ void m11267a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1436255485);
        HScrollRecyclerView hScrollRecyclerView = (HScrollRecyclerView) view;
        CustomViewUtils.b(hScrollRecyclerView, new ColorDrawable(ContextCompat.b(hScrollRecyclerView.getContext(), 2131361920)));
        Logger.a(8, EntryType.MARK_POP, -1743420260, a);
    }

    public static SuggestedMediasetRollPartDefinition m11262a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SuggestedMediasetRollPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11101i) {
                SuggestedMediasetRollPartDefinition suggestedMediasetRollPartDefinition;
                if (a2 != null) {
                    suggestedMediasetRollPartDefinition = (SuggestedMediasetRollPartDefinition) a2.a(f11101i);
                } else {
                    suggestedMediasetRollPartDefinition = f11100h;
                }
                if (suggestedMediasetRollPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11263b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11101i, b3);
                        } else {
                            f11100h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = suggestedMediasetRollPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SuggestedMediasetRollPartDefinition(ClickablePhotoPartDefinition clickablePhotoPartDefinition, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, ViewPaddingPartDefinition viewPaddingPartDefinition, PageStyleFactory pageStyleFactory, Resources resources) {
        this.f11102c = clickablePhotoPartDefinition;
        this.f11103d = persistentRecyclerPartDefinition;
        this.f11104e = viewPaddingPartDefinition;
        this.f11105f = pageStyleFactory;
        this.f11106g = resources;
    }

    public final ViewType<HScrollRecyclerView> m11265a() {
        return HScrollRecyclerViewRowType.b;
    }

    public final boolean m11268a(Object obj) {
        return true;
    }

    private PaddingData m11264c() {
        int dimensionPixelSize = this.f11106g.getDimensionPixelSize(2131433946);
        return new PaddingData(dimensionPixelSize, 0, dimensionPixelSize, this.f11106g.getDimensionPixelSize(2131433947));
    }
}
