package com.facebook.feedplugins.pyml.rows.components;

import com.facebook.components.Component;
import com.facebook.components.Component.Builder;
import com.facebook.components.ComponentContext;
import com.facebook.feed.rows.sections.hscrollrecyclerview.FeedUnitAndChangePageListener;
import com.facebook.graphql.model.GraphQLPYMLWithLargeImageFeedUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* compiled from: android.settings.INTERNAL_STORAGE_SETTINGS */
public class PagesYouMayLikeComponent$Builder extends Builder<PagesYouMayLikeComponent> {
    PagesYouMayLikeComponent$State f19800a;
    final /* synthetic */ PagesYouMayLikeComponent f19801b;
    private String[] f19802c = new String[]{"environment", "pages", "shouldShowHeader"};
    private int f19803d = 3;
    private BitSet f19804e = new BitSet(this.f19803d);

    public PagesYouMayLikeComponent$Builder(PagesYouMayLikeComponent pagesYouMayLikeComponent) {
        this.f19801b = pagesYouMayLikeComponent;
    }

    public static void m20046a(PagesYouMayLikeComponent$Builder pagesYouMayLikeComponent$Builder, ComponentContext componentContext, int i, PagesYouMayLikeComponent$State pagesYouMayLikeComponent$State) {
        super.a(componentContext, i, pagesYouMayLikeComponent$State);
        pagesYouMayLikeComponent$Builder.f19800a = pagesYouMayLikeComponent$State;
        pagesYouMayLikeComponent$Builder.f19804e.clear();
    }

    public final PagesYouMayLikeComponent$Builder m20047a(E e) {
        this.f19800a.f19805a = e;
        this.f19804e.set(0);
        return this;
    }

    public final PagesYouMayLikeComponent$Builder m20048a(FeedUnitAndChangePageListener<GraphQLPYMLWithLargeImageFeedUnit> feedUnitAndChangePageListener) {
        this.f19800a.f19806b = feedUnitAndChangePageListener;
        this.f19804e.set(1);
        return this;
    }

    public final PagesYouMayLikeComponent$Builder m20049a(boolean z) {
        this.f19800a.f19807c = z;
        this.f19804e.set(2);
        return this;
    }

    public final Component<PagesYouMayLikeComponent> m20051d() {
        int i = 0;
        if (this.f19804e == null || this.f19804e.nextClearBit(0) >= this.f19803d) {
            PagesYouMayLikeComponent$State pagesYouMayLikeComponent$State = this.f19800a;
            m20050a();
            return pagesYouMayLikeComponent$State;
        }
        List arrayList = new ArrayList();
        while (i < this.f19803d) {
            if (!this.f19804e.get(i)) {
                arrayList.add(this.f19802c[i]);
            }
            i++;
        }
        throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
    }

    protected final void m20050a() {
        super.a();
        this.f19800a = null;
        this.f19801b.c.a(this);
    }
}
