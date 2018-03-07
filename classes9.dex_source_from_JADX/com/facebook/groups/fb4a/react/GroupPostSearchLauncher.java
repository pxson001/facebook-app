package com.facebook.groups.fb4a.react;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.dracula.api.DraculaReturnValue;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.groups.feed.data.GroupsGraphSearchHelper;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.DraculaImplementation;
import com.facebook.groups.feed.protocol.FetchGroupInformationGraphQLModels.FetchGroupInformationModel.Builder;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.logging.perf.SearchPerfLogger;
import com.facebook.search.suggestions.nullstate.NullStateSupplier.RefreshPolicy;
import com.facebook.search.suggestions.nullstate.SearchNullStateListSupplier;
import com.facebook.search.titlebar.GraphSearchIntentLauncher;
import com.facebook.search.util.GraphSearchConfig;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: payments_android_reliability_ */
public class GroupPostSearchLauncher {
    private static final CallerContext f6912a = CallerContext.a(GraphSearchIntentLauncher.class, "search");
    private final GraphSearchConfig f6913b;
    private final SecureContextHelper f6914c;
    private final Provider<ComponentName> f6915d;
    private final Provider<SearchNullStateListSupplier> f6916e;
    private final Provider<SearchPerfLogger> f6917f;

    public static GroupPostSearchLauncher m7197b(InjectorLike injectorLike) {
        return new GroupPostSearchLauncher(GraphSearchConfig.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), IdBasedProvider.a(injectorLike, 12), IdBasedSingletonScopeProvider.a(injectorLike, 3399), IdBasedProvider.a(injectorLike, 10496));
    }

    @Inject
    public GroupPostSearchLauncher(GraphSearchConfig graphSearchConfig, SecureContextHelper secureContextHelper, @FragmentChromeActivity Provider<ComponentName> provider, Provider<SearchNullStateListSupplier> provider2, Provider<SearchPerfLogger> provider3) {
        this.f6913b = graphSearchConfig;
        this.f6914c = secureContextHelper;
        this.f6915d = provider;
        this.f6916e = provider2;
        this.f6917f = provider3;
    }

    public final void m7198a(String str, Context context) {
        Builder builder = new Builder();
        builder.a(str);
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(1024);
        int a = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        int a2 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        int b = flatBufferBuilder.b(null);
        int a3 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        int a4 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        int a5 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        int a6 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        int a7 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        int a8 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        int b2 = flatBufferBuilder.b(str);
        int b3 = flatBufferBuilder.b("");
        int a9 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        int b4 = flatBufferBuilder.b(null);
        int e = flatBufferBuilder.e(null);
        int a10 = flatBufferBuilder.a(null);
        int a11 = DraculaImplementation.a(null, 0, 0, flatBufferBuilder);
        flatBufferBuilder.c(19);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, b);
        flatBufferBuilder.b(3, a3);
        flatBufferBuilder.b(4, a4);
        flatBufferBuilder.a(5, 0, 0);
        flatBufferBuilder.b(6, a5);
        flatBufferBuilder.b(7, a6);
        flatBufferBuilder.b(8, a7);
        flatBufferBuilder.b(9, a8);
        flatBufferBuilder.a(10, false);
        flatBufferBuilder.b(11, b2);
        flatBufferBuilder.a(12, false);
        flatBufferBuilder.b(13, b3);
        flatBufferBuilder.b(14, a9);
        flatBufferBuilder.b(15, b4);
        flatBufferBuilder.b(16, e);
        flatBufferBuilder.b(17, a10);
        flatBufferBuilder.b(18, a11);
        DraculaReturnValue a12 = DraculaReturnValue.a(flatBufferBuilder, 291056794);
        builder.a(a12.a, a12.b, a12.c);
        GraphSearchQuery b5 = GroupsGraphSearchHelper.b(builder.a(), str, false, this.f6913b);
        Intent putExtra = new Intent().setComponent((ComponentName) this.f6915d.get()).putExtra("target_fragment", ContentFragmentType.SEARCH_FRAGMENT.ordinal());
        if (b5 != null) {
            putExtra.putExtra("initial_typeahead_query", b5);
        }
        ((SearchPerfLogger) this.f6917f.get()).b();
        ((SearchNullStateListSupplier) this.f6916e.get()).a(f6912a, RefreshPolicy.MEMORY);
        this.f6914c.a(putExtra, context);
    }
}
