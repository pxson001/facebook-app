package com.facebook.entitycards.contextitems.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryInterfaces.ContextItemsConnectionFragment.Edges;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.ContextItemsConnectionFragmentModel.EdgesModel;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.ContextItemsConnectionWithPageInfoFragmentModel;
import com.facebook.entitycards.contextitems.surface.ContextItemSurfaces;
import com.facebook.graphql.model.GraphQLRating;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.uicontrib.contextitem.PlutoniumContextualItemView;
import com.facebook.widget.listview.FbBaseAdapter;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: in method deletePostAndBlockUser */
public class ContextItemsAdapter extends FbBaseAdapter {
    private static final Object f10912a = new Object();
    private final Context f10913b;
    private final LayoutInflater f10914c;
    private final ContextItemsViewBinder f10915d;
    @Nullable
    public ImmutableList<Edges> f10916e;
    public ContextItemSurfaces f10917f;
    private EntityData f10918g;
    public boolean f10919h;
    public String f10920i;
    private ViewTypes[] f10921j;

    /* compiled from: in method deletePostAndBlockUser */
    class C11691 implements Predicate<Edges> {
        final /* synthetic */ ContextItemsAdapter f10908a;

        C11691(ContextItemsAdapter contextItemsAdapter) {
            this.f10908a = contextItemsAdapter;
        }

        public boolean apply(@Nullable Object obj) {
            EdgesModel edgesModel = (EdgesModel) obj;
            if (edgesModel == null || edgesModel.a() == null || edgesModel.a().d() == null || edgesModel.a().b() == null || edgesModel.a().b().a() == null) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: in method deletePostAndBlockUser */
    public class EntityData {
        public String f10910a;
        public GraphQLRating f10911b;

        public EntityData(String str, @Nullable GraphQLRating graphQLRating) {
            this.f10910a = str;
            this.f10911b = graphQLRating;
        }
    }

    /* compiled from: in method deletePostAndBlockUser */
    public enum ViewTypes {
        CONTEXT_ITEM_VIEW,
        LOAD_MORE_VIEW,
        REACTION_CONTEXT_ITEM_VIEW,
        UNKNOWN
    }

    public static ContextItemsAdapter m12856b(InjectorLike injectorLike) {
        return new ContextItemsAdapter((Context) injectorLike.getInstance(Context.class), LayoutInflaterMethodAutoProvider.b(injectorLike), ContextItemsViewBinder.m12884b(injectorLike));
    }

    @Inject
    public ContextItemsAdapter(Context context, LayoutInflater layoutInflater, ContextItemsViewBinder contextItemsViewBinder) {
        this.f10913b = context;
        this.f10914c = layoutInflater;
        this.f10915d = contextItemsViewBinder;
    }

    public final void m12860a(@Nullable ContextItemsConnectionWithPageInfoFragmentModel contextItemsConnectionWithPageInfoFragmentModel, ContextItemSurfaces contextItemSurfaces, EntityData entityData) {
        if (contextItemsConnectionWithPageInfoFragmentModel != null) {
            this.f10916e = ImmutableList.copyOf(Collections2.a(contextItemsConnectionWithPageInfoFragmentModel.a(), new C11691(this)));
            if (!this.f10916e.isEmpty()) {
                if (contextItemsConnectionWithPageInfoFragmentModel.b() != null) {
                    this.f10919h = contextItemsConnectionWithPageInfoFragmentModel.b().b();
                    this.f10920i = contextItemsConnectionWithPageInfoFragmentModel.b().a();
                }
                this.f10917f = contextItemSurfaces;
                this.f10918g = entityData;
                AdapterDetour.a(this, 267621399);
            }
        }
    }

    public final String m12861c() {
        return this.f10918g.f10910a;
    }

    public final View m12858a(int i, ViewGroup viewGroup) {
        switch (m12857d()[i]) {
            case LOAD_MORE_VIEW:
                return new ContextItemsLoadMoreView(this.f10913b);
            case REACTION_CONTEXT_ITEM_VIEW:
                return this.f10914c.inflate(2130906656, viewGroup, false);
            default:
                return this.f10914c.inflate(2130903796, viewGroup, false);
        }
    }

    public final void m12859a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        if (obj == f10912a && (view instanceof ContextItemsLoadMoreView)) {
            ((ContextItemsLoadMoreView) view).m12876a(false);
            return;
        }
        PlutoniumContextualItemView plutoniumContextualItemView = (PlutoniumContextualItemView) view;
        this.f10915d.m12885a(plutoniumContextualItemView, ((EdgesModel) obj).a(), this.f10918g);
    }

    public int getCount() {
        int i = 0;
        if (this.f10916e == null) {
            return 0;
        }
        int size = this.f10916e.size();
        if (this.f10919h) {
            i = 1;
        }
        return i + size;
    }

    public Object getItem(int i) {
        if (i >= this.f10916e.size()) {
            return f10912a;
        }
        return this.f10916e.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getViewTypeCount() {
        return m12857d().length;
    }

    public int getItemViewType(int i) {
        Object item = getItem(i);
        if (this.f10917f.equals(ContextItemSurfaces.PLACE_TIPS)) {
            return ViewTypes.REACTION_CONTEXT_ITEM_VIEW.ordinal();
        }
        if (item instanceof EdgesModel) {
            return ViewTypes.CONTEXT_ITEM_VIEW.ordinal();
        }
        return ViewTypes.LOAD_MORE_VIEW.ordinal();
    }

    private ViewTypes[] m12857d() {
        if (this.f10921j == null) {
            this.f10921j = ViewTypes.values();
        }
        return this.f10921j;
    }
}
