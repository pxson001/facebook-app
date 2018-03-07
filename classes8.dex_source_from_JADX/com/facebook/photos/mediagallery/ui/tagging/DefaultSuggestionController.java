package com.facebook.photos.mediagallery.ui.tagging;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.photos.data.method.FetchDefaultTagSuggestions;
import com.facebook.photos.data.method.FetchDefaultTagSuggestions.DefaultTagSuggestionsCallback;
import com.facebook.tagging.data.TagTypeaheadDataSource.SourceResultsListener;
import com.facebook.tagging.graphql.data.GoodFriendsTaggingTypeaheadDataSource;
import com.facebook.tagging.model.TaggingProfile;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;

@UserScoped
/* compiled from: sms_auto_confirm_start */
public class DefaultSuggestionController {
    private static final Object f2442f = new Object();
    private final Lazy<FetchDefaultTagSuggestions> f2443a;
    private final Lazy<GoodFriendsTaggingTypeaheadDataSource> f2444b;
    public final List<DefaultTagSuggestionsListener> f2445c = Lists.a();
    public ImmutableList<TaggingProfile> f2446d = null;
    public String f2447e;

    /* compiled from: sms_auto_confirm_start */
    class C02931 implements SourceResultsListener {
        final /* synthetic */ DefaultSuggestionController f2440a;

        C02931(DefaultSuggestionController defaultSuggestionController) {
            this.f2440a = defaultSuggestionController;
        }

        public final void m2565a(CharSequence charSequence, List<TaggingProfile> list) {
            this.f2440a.f2446d = ImmutableList.copyOf(list);
            for (DefaultTagSuggestionsListener a : this.f2440a.f2445c) {
                a.mo129a(this.f2440a.f2446d);
            }
            this.f2440a.f2445c.clear();
        }
    }

    /* compiled from: sms_auto_confirm_start */
    class C02942 implements DefaultTagSuggestionsCallback {
        final /* synthetic */ DefaultSuggestionController f2441a;

        C02942(DefaultSuggestionController defaultSuggestionController) {
            this.f2441a = defaultSuggestionController;
        }

        public final void m2566a(List<TaggingProfile> list) {
            if (list != null && !list.isEmpty()) {
                Builder builder = ImmutableList.builder();
                for (TaggingProfile taggingProfile : list) {
                    if (taggingProfile != null) {
                        builder.c(taggingProfile);
                    }
                }
                this.f2441a.f2446d = builder.b();
                for (DefaultTagSuggestionsListener a : this.f2441a.f2445c) {
                    a.mo129a(this.f2441a.f2446d);
                }
                this.f2441a.f2445c.clear();
            }
        }
    }

    /* compiled from: sms_auto_confirm_start */
    public interface DefaultTagSuggestionsListener {
        void mo129a(ImmutableList<TaggingProfile> immutableList);
    }

    private static DefaultSuggestionController m2569b(InjectorLike injectorLike) {
        return new DefaultSuggestionController(IdBasedSingletonScopeProvider.b(injectorLike, 9318), IdBasedLazy.a(injectorLike, 11100));
    }

    @Inject
    public DefaultSuggestionController(Lazy<FetchDefaultTagSuggestions> lazy, Lazy<GoodFriendsTaggingTypeaheadDataSource> lazy2) {
        this.f2443a = lazy;
        this.f2444b = lazy2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.photos.mediagallery.ui.tagging.DefaultSuggestionController m2568a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f2442f;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m2569b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f2442f;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.photos.mediagallery.ui.tagging.DefaultSuggestionController) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.photos.mediagallery.ui.tagging.DefaultSuggestionController) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f2442f;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.photos.mediagallery.ui.tagging.DefaultSuggestionController) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.mediagallery.ui.tagging.DefaultSuggestionController.a(com.facebook.inject.InjectorLike):com.facebook.photos.mediagallery.ui.tagging.DefaultSuggestionController");
    }

    public final void m2570a(DefaultTagSuggestionsListener defaultTagSuggestionsListener) {
        Preconditions.checkNotNull(defaultTagSuggestionsListener);
        if (this.f2446d == null) {
            this.f2445c.add(defaultTagSuggestionsListener);
            m2571b();
            return;
        }
        defaultTagSuggestionsListener.mo129a(this.f2446d);
    }

    public final void m2571b() {
        if (this.f2447e == null || !this.f2447e.equals("good_friends")) {
            ((FetchDefaultTagSuggestions) this.f2443a.get()).a(new C02942(this));
            return;
        }
        ((GoodFriendsTaggingTypeaheadDataSource) this.f2444b.get()).a("", "", false, false, false, false, false, new C02931(this));
    }
}
