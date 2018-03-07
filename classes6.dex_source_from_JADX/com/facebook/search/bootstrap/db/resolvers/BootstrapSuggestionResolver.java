package com.facebook.search.bootstrap.db.resolvers;

import com.facebook.common.cursors.CursorIterator;
import com.facebook.common.executors.ListeningExecutorService_SearchRequestExecutorMethodAutoProvider;
import com.facebook.common.i18n.BreakIteratorHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.search.bootstrap.common.normalizer.NormalizedTokenHelper;
import com.facebook.search.bootstrap.db.data.BootstrapDbFetchHelper;
import com.facebook.search.bootstrap.db.iterator.EntityIterator;
import com.facebook.search.bootstrap.db.iterator.EntityIteratorFactory;
import com.facebook.search.bootstrap.db.iterator.KeywordIterator;
import com.facebook.search.bootstrap.db.iterator.PhoneticEntityIterator;
import com.facebook.search.bootstrap.db.model.BootstrapDbModel;
import com.facebook.search.bootstrap.db.model.EntityDbModel;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: existing_profile_inputs */
public class BootstrapSuggestionResolver {
    public final ListeningExecutorService f15745a;
    public final EntityIteratorFactory f15746b;
    private final NormalizedTokenHelper f15747c;
    private final BreakIteratorHelper f15748d;

    /* compiled from: existing_profile_inputs */
    public class C11122 implements Callable<ImmutableList<BootstrapDbModel>> {
        final /* synthetic */ String f15740a;
        final /* synthetic */ int f15741b;
        final /* synthetic */ int f15742c;
        final /* synthetic */ BootstrapSuggestionResolver f15743d;

        public C11122(BootstrapSuggestionResolver bootstrapSuggestionResolver, String str, int i, int i2) {
            this.f15743d = bootstrapSuggestionResolver;
            this.f15740a = str;
            this.f15741b = i;
            this.f15742c = i2;
        }

        public Object call() {
            Iterable b;
            Builder builder = ImmutableList.builder();
            EntityIteratorFactory entityIteratorFactory = this.f15743d.f15746b;
            Iterable a = BootstrapSuggestionResolver.m23428a(this.f15743d, new KeywordIterator(entityIteratorFactory.f15705a.m23389c(this.f15740a, this.f15741b)));
            if (this.f15742c > a.size()) {
                b = BootstrapSuggestionResolver.m23431b(this.f15743d, this.f15740a, this.f15742c - a.size(), RegularImmutableList.a);
            } else {
                b = RegularImmutableList.a;
            }
            return builder.b(a).b(b).b();
        }
    }

    /* compiled from: existing_profile_inputs */
    class C11133 implements Function<I, List<M>> {
        final /* synthetic */ BootstrapSuggestionResolver f15744a;

        C11133(BootstrapSuggestionResolver bootstrapSuggestionResolver) {
            this.f15744a = bootstrapSuggestionResolver;
        }

        public /* synthetic */ Object apply(Object obj) {
            return C11133.m23426a((CursorIterator) obj);
        }

        public static List<M> m23426a(I i) {
            List<M> arrayList = new ArrayList();
            while (i.hasNext()) {
                arrayList.add((BootstrapDbModel) i.next());
            }
            return arrayList;
        }
    }

    public static BootstrapSuggestionResolver m23430b(InjectorLike injectorLike) {
        return new BootstrapSuggestionResolver(ListeningExecutorService_SearchRequestExecutorMethodAutoProvider.a(injectorLike), new EntityIteratorFactory(BootstrapDbFetchHelper.m23383b(injectorLike)), NormalizedTokenHelper.m23188b(injectorLike), BreakIteratorHelper.a(injectorLike));
    }

    @Inject
    public BootstrapSuggestionResolver(ListeningExecutorService listeningExecutorService, EntityIteratorFactory entityIteratorFactory, NormalizedTokenHelper normalizedTokenHelper, BreakIteratorHelper breakIteratorHelper) {
        this.f15745a = listeningExecutorService;
        this.f15746b = entityIteratorFactory;
        this.f15747c = normalizedTokenHelper;
        this.f15748d = breakIteratorHelper;
    }

    public final ListenableFuture<List<EntityDbModel>> m23432a(final String str, final int i, final List list) {
        return this.f15745a.a(new Callable<List<EntityDbModel>>(this) {
            final /* synthetic */ BootstrapSuggestionResolver f15739d;

            public Object call() {
                return BootstrapSuggestionResolver.m23431b(this.f15739d, str, i, list);
            }
        });
    }

    public static List m23431b(BootstrapSuggestionResolver bootstrapSuggestionResolver, String str, int i, List list) {
        List a = m23428a(bootstrapSuggestionResolver, (CursorIterator) new EntityIterator(bootstrapSuggestionResolver.f15746b.f15705a.m23385a(str, i)));
        if (a.size() + list.size() < 5) {
            for (EntityDbModel entityDbModel : bootstrapSuggestionResolver.m23427a(new PhoneticEntityIterator(bootstrapSuggestionResolver.f15746b.f15705a.m23387b(str, i)), str)) {
                if (!a.contains(entityDbModel)) {
                    a.add(entityDbModel);
                }
            }
        }
        return a;
    }

    public static <M extends BootstrapDbModel, I extends CursorIterator<M>> List m23428a(BootstrapSuggestionResolver bootstrapSuggestionResolver, CursorIterator cursorIterator) {
        try {
            C11133 c11133 = new C11133(bootstrapSuggestionResolver);
            List a = C11133.m23426a(cursorIterator);
            return a;
        } finally {
            cursorIterator.close();
        }
    }

    private List<EntityDbModel> m23427a(PhoneticEntityIterator phoneticEntityIterator, String str) {
        List<EntityDbModel> arrayList = new ArrayList();
        while (phoneticEntityIterator.hasNext()) {
            try {
                EntityDbModel entityDbModel = (EntityDbModel) phoneticEntityIterator.next();
                ImmutableList b = this.f15748d.b(str);
                ImmutableList a = this.f15748d.a(entityDbModel.m23423b());
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    Object obj;
                    String str2 = (String) a.get(i);
                    int size2 = b.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        if (m23429a((String) b.get(i2), str2, 0, 0.4f)) {
                            arrayList.add(entityDbModel);
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj != null) {
                        break;
                    }
                }
            } finally {
                phoneticEntityIterator.close();
            }
        }
        return arrayList;
    }

    private static boolean m23429a(String str, String str2, int i, float f) {
        int a = LevenshteinDistance.m23433a(str, str2.toLowerCase(Locale.getDefault()), f <= 0.0f ? i : 2147483646);
        if (f > 0.0f) {
            int max = Math.max(str.length(), str2.length());
            return max > 0 && ((float) a) / ((float) max) <= f;
        } else if (a <= i) {
            return true;
        } else {
            return false;
        }
    }
}
