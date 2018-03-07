package com.facebook.messaging.inbox2.sharing;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.loader.AbstractFbLoaderCallback;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.messaging.contacts.loader.ContactListsCache;
import com.facebook.messaging.contacts.loader.ContactsLoader;
import com.facebook.messaging.contacts.loader.ContactsLoader.FriendLists;
import com.facebook.messaging.contacts.loader.ContactsLoader.InitParams;
import com.facebook.messaging.contacts.loader.ContactsLoader.Result;
import com.facebook.messaging.inbox2.sharing.SuggestedUser.ShareState;
import com.facebook.user.model.User;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.EnumSet;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mPreviousAttemptFailed */
public class QuickShareSuggestionsView extends CustomLinearLayout {
    @Inject
    ContactListsCache f11337a;
    @Inject
    Lazy<ContactsLoader> f11338b;
    @Inject
    Lazy<FbErrorReporter> f11339c;
    @Inject
    QuickShareSuggestionsAdapter f11340d;
    private RecyclerView f11341e;
    private ImmutableList<SuggestedUser> f11342f;

    /* compiled from: mPreviousAttemptFailed */
    class C12502 extends AbstractFbLoaderCallback<Void, Result, Throwable> {
        final /* synthetic */ QuickShareSuggestionsView f11336a;

        C12502(QuickShareSuggestionsView quickShareSuggestionsView) {
            this.f11336a = quickShareSuggestionsView;
        }

        public final void m11931b(Object obj, Object obj2) {
            this.f11336a.m11935a(((Result) obj2).g);
        }

        public final void m11932c(Object obj, Object obj2) {
            Throwable th = (Throwable) obj2;
            this.f11336a.m11935a(RegularImmutableList.a);
            ((AbstractFbErrorReporter) this.f11336a.f11339c.get()).a("quick_share_loader", th);
        }
    }

    private static <T extends View> void m11936a(Class<T> cls, T t) {
        m11937a((Object) t, t.getContext());
    }

    private static void m11937a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((QuickShareSuggestionsView) obj).m11933a(ContactListsCache.a(fbInjector), IdBasedLazy.a(fbInjector, 2592), IdBasedSingletonScopeProvider.b(fbInjector, 494), new QuickShareSuggestionsAdapter((Context) fbInjector.getInstance(Context.class)));
    }

    public QuickShareSuggestionsView(Context context) {
        super(context);
        m11938b();
    }

    public QuickShareSuggestionsView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m11938b();
    }

    public QuickShareSuggestionsView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11938b();
    }

    private void m11933a(ContactListsCache contactListsCache, Lazy<ContactsLoader> lazy, Lazy<FbErrorReporter> lazy2, QuickShareSuggestionsAdapter quickShareSuggestionsAdapter) {
        this.f11337a = contactListsCache;
        this.f11338b = lazy;
        this.f11339c = lazy2;
        this.f11340d = quickShareSuggestionsAdapter;
    }

    private void m11938b() {
        m11936a(QuickShareSuggestionsView.class, (View) this);
        setOrientation(1);
        setContentView(2130904873);
        this.f11341e = (RecyclerView) a(2131563098);
        this.f11341e.setAdapter(this.f11340d);
        RecyclerView recyclerView = this.f11341e;
        getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(0, false));
        m11939c();
        m11940d();
    }

    private void m11939c() {
        Resources resources = getResources();
        final int dimensionPixelSize = resources.getDimensionPixelSize(2131433613);
        final int dimensionPixelSize2 = resources.getDimensionPixelSize(2131433614);
        this.f11341e.a(new ItemDecoration(this) {
            final /* synthetic */ QuickShareSuggestionsView f11335c;

            public final void m11930a(Rect rect, View view, RecyclerView recyclerView, State state) {
                int d = RecyclerView.d(view);
                rect.set(d == 0 ? dimensionPixelSize2 : dimensionPixelSize, 0, d == state.e() + -1 ? dimensionPixelSize2 : dimensionPixelSize, 0);
            }
        });
    }

    private void m11940d() {
        if (this.f11337a.c() != null) {
            m11935a(this.f11337a.c());
            return;
        }
        ((ContactsLoader) this.f11338b.get()).v = new InitParams(EnumSet.of(FriendLists.TOP_FRIENDS_ON_MESSENGER));
        ((ContactsLoader) this.f11338b.get()).a(new C12502(this));
        ((ContactsLoader) this.f11338b.get()).a();
    }

    private void m11935a(ImmutableList<User> immutableList) {
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            builder.c(new SuggestedUser((User) immutableList.get(i)));
        }
        this.f11342f = builder.b();
        QuickShareSuggestionsAdapter quickShareSuggestionsAdapter = this.f11340d;
        quickShareSuggestionsAdapter.f11331c = this.f11342f;
        quickShareSuggestionsAdapter.notifyDataSetChanged();
    }

    public final void m11941a() {
        int size = this.f11342f.size();
        for (int i = 0; i < size; i++) {
            ((SuggestedUser) this.f11342f.get(i)).f11354b = ShareState.PROFILE_PIC;
        }
        this.f11341e.setAdapter(this.f11340d);
    }

    public void setListener(UserSelectionListener userSelectionListener) {
        this.f11340d.f11332d = userSelectionListener;
    }
}
