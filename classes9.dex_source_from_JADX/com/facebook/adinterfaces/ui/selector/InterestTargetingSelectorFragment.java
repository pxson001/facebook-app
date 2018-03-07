package com.facebook.adinterfaces.ui.selector;

import android.content.Context;
import android.os.Bundle;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.InterestModel;
import com.facebook.adinterfaces.protocol.FetchPageTargetingTypeaheadGraphQL.FetchPageTargetingTypeaheadInterestQueryString;
import com.facebook.adinterfaces.protocol.FetchPageTargetingTypeaheadMethod;
import com.facebook.adinterfaces.protocol.FetchPageTargetingTypeaheadMethod.C25482;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.widget.listview.ImmutableSectionedListSection;
import com.facebook.widget.listview.SectionedListSection;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken.Type;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.ImmutableSortedSet.Builder;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Comparator;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Unknown intent name that is not registered. */
public class InterestTargetingSelectorFragment extends BaseTargetingSelectorFragment<InterestModel> {
    @Inject
    public FetchPageTargetingTypeaheadMethod f23218a;

    /* compiled from: Unknown intent name that is not registered. */
    public class InterestToken extends BaseToken<InterestModel> {
        public static final Comparator<InterestToken> f23216e = new C27391();
        public final InterestModel f23217f;

        /* compiled from: Unknown intent name that is not registered. */
        final class C27391 implements Comparator<InterestToken> {
            C27391() {
            }

            public final int compare(Object obj, Object obj2) {
                InterestToken interestToken = (InterestToken) obj;
                InterestToken interestToken2 = (InterestToken) obj2;
                Preconditions.checkNotNull(interestToken);
                Preconditions.checkNotNull(interestToken2);
                return interestToken.b().compareTo(interestToken2.b());
            }
        }

        public InterestToken(InterestModel interestModel) {
            super(Type.SUGGESTION);
            Preconditions.checkNotNull(interestModel);
            this.f23217f = interestModel;
        }

        public final Object m25187d() {
            return this.f23217f;
        }

        public final String m25186b() {
            return this.f23217f.m23464k();
        }

        public final int m25188e() {
            return -1;
        }

        public final int m25189f() {
            return -1;
        }

        public final int m25190g() {
            return -1;
        }

        public final int m25191h() {
            return -1;
        }

        public final String m25192i() {
            return null;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof InterestToken)) {
                return false;
            }
            InterestModel interestModel = ((InterestToken) obj).f23217f;
            return obj == this || (Objects.equal(this.f23217f.m23463j(), interestModel.m23463j()) && Objects.equal(this.f23217f.m23464k(), interestModel.m23464k()));
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.f23217f.m23463j(), this.f23217f.m23464k()});
        }
    }

    public static void m25193a(Object obj, Context context) {
        ((InterestTargetingSelectorFragment) obj).f23218a = FetchPageTargetingTypeaheadMethod.m24218b(FbInjector.get(context));
    }

    protected final BaseToken mo1038a(Object obj) {
        InterestModel interestModel = (InterestModel) obj;
        Preconditions.checkNotNull(interestModel);
        return new InterestToken(interestModel);
    }

    public final void mo1042c(Bundle bundle) {
        super.mo1042c(bundle);
        Class cls = InterestTargetingSelectorFragment.class;
        m25193a(this, getContext());
    }

    protected final List<? extends SectionedListSection<? extends BaseToken<InterestModel>>> mo1040a(List<InterestModel> list) {
        Builder b = ImmutableSortedSet.b(InterestToken.f23216e);
        for (InterestModel interestToken : list) {
            b.d(new InterestToken(interestToken));
        }
        return ImmutableList.of(new ImmutableSectionedListSection(b(2131234083), ImmutableList.copyOf(b.c())));
    }

    protected final String mo1041b() {
        return b(2131234088);
    }

    protected final String mo1043e() {
        return b(2131234087);
    }

    @Nullable
    protected final ListenableFuture<List<InterestModel>> mo1039a(String str) {
        FetchPageTargetingTypeaheadMethod fetchPageTargetingTypeaheadMethod = this.f23218a;
        Preconditions.checkNotNull(str);
        GraphQlQueryString fetchPageTargetingTypeaheadInterestQueryString = new FetchPageTargetingTypeaheadInterestQueryString();
        fetchPageTargetingTypeaheadInterestQueryString.a("query", str);
        return Futures.a(fetchPageTargetingTypeaheadMethod.f22380a.a(GraphQLRequest.a(fetchPageTargetingTypeaheadInterestQueryString)), new C25482(fetchPageTargetingTypeaheadMethod), MoreExecutors.a());
    }
}
