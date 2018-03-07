package com.facebook.messaging.composer.triggers;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: messenger_inbox_item */
public class MentionsSearchResultsView extends CustomFrameLayout {
    @Inject
    public MentionsSearchResultsAdapter f9915a;
    private RecyclerView f9916b;
    private LinearLayoutManager f9917c;

    private static <T extends View> void m10470a(Class<T> cls, T t) {
        m10471a((Object) t, t.getContext());
    }

    private static void m10471a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((MentionsSearchResultsView) obj).f9915a = new MentionsSearchResultsAdapter(ResourcesMethodAutoProvider.a(fbInjector), LayoutInflaterMethodAutoProvider.b(fbInjector));
    }

    public MentionsSearchResultsView(Context context) {
        super(context);
        m10468a(context);
    }

    public MentionsSearchResultsView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m10468a(context);
    }

    public MentionsSearchResultsView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10468a(context);
    }

    private void m10468a(Context context) {
        m10470a(MentionsSearchResultsView.class, (View) this);
        setContentView(2130905217);
        this.f9916b = (RecyclerView) c(2131560745);
        this.f9917c = new LinearLayoutManager(context);
        this.f9917c.b(1);
        this.f9916b.setLayoutManager(this.f9917c);
        this.f9916b.setAdapter(this.f9915a);
    }

    public MentionsSearchResultsAdapter getAdapter() {
        return this.f9915a;
    }

    public final void m10472a() {
        this.f9916b.a(0);
    }

    private void m10469a(MentionsSearchResultsAdapter mentionsSearchResultsAdapter) {
        this.f9915a = mentionsSearchResultsAdapter;
    }
}
