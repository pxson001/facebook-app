package com.facebook.heisman;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageButton;
import android.widget.TextView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.connection.SingletonConnectionFetcherProvider;
import com.facebook.heisman.CategoryBrowserActivity.FragmentDelegate;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbEditText;
import com.facebook.ultralight.Inject;
import com.facebook.widget.LazyView;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: video_count_48_h_since_last_log */
public class CategoryBrowserFragment extends FbFragment {
    @Inject
    public CategoryBrowserAdapterProvider f586a;
    @Inject
    public CategoryBrowserFragmentControllerProvider f587b;
    @Inject
    public CategoryBrowserFetchControllerProvider f588c;
    public CategoryBrowserFetchController f589d;
    public CategoryBrowserAdapter f590e;
    public FragmentDelegate f591f;
    public LoadingIndicatorView f592g;
    public LazyView<TextView> f593h;

    public static void m633a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        CategoryBrowserFragment categoryBrowserFragment = (CategoryBrowserFragment) obj;
        CategoryBrowserAdapterProvider categoryBrowserAdapterProvider = (CategoryBrowserAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(CategoryBrowserAdapterProvider.class);
        CategoryBrowserFragmentControllerProvider categoryBrowserFragmentControllerProvider = (CategoryBrowserFragmentControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(CategoryBrowserFragmentControllerProvider.class);
        CategoryBrowserFetchControllerProvider categoryBrowserFetchControllerProvider = (CategoryBrowserFetchControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(CategoryBrowserFetchControllerProvider.class);
        categoryBrowserFragment.f586a = categoryBrowserAdapterProvider;
        categoryBrowserFragment.f587b = categoryBrowserFragmentControllerProvider;
        categoryBrowserFragment.f588c = categoryBrowserFetchControllerProvider;
    }

    public final void m636c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = CategoryBrowserFragment.class;
        m633a((Object) this, getContext());
    }

    public final View m634a(LayoutInflater layoutInflater, ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1518660020);
        View inflate = layoutInflater.inflate(2130903526, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 585753354, a);
        return inflate;
    }

    public final void m635a(View view, @Nullable Bundle bundle) {
        ViewGroup viewGroup = (ViewGroup) view;
        CategoryBrowserFragmentControllerProvider categoryBrowserFragmentControllerProvider = this.f587b;
        CategoryBrowserFragmentController categoryBrowserFragmentController = new CategoryBrowserFragmentController(this.f591f);
        categoryBrowserFragmentController.f594a = IdBasedSingletonScopeProvider.a(categoryBrowserFragmentControllerProvider, 494);
        CategoryBrowserFragmentController categoryBrowserFragmentController2 = categoryBrowserFragmentController;
        CategoryBrowserAdapterProvider categoryBrowserAdapterProvider = this.f586a;
        CategoryBrowserAdapter categoryBrowserAdapter = new CategoryBrowserAdapter(categoryBrowserFragmentController2);
        categoryBrowserAdapter.f565a = LayoutInflaterMethodAutoProvider.b(categoryBrowserAdapterProvider);
        this.f590e = categoryBrowserAdapter;
        CategoryBrowserFetchControllerProvider categoryBrowserFetchControllerProvider = this.f588c;
        CategoryBrowserFetchController categoryBrowserFetchController = new CategoryBrowserFetchController(this, (SingletonConnectionFetcherProvider) categoryBrowserFetchControllerProvider.getOnDemandAssistedProviderForStaticDi(SingletonConnectionFetcherProvider.class));
        Lazy a = IdBasedLazy.a(categoryBrowserFetchControllerProvider, 43);
        CategoryBrowserConnectionConfiguration categoryBrowserConnectionConfiguration = new CategoryBrowserConnectionConfiguration();
        Provider a2 = IdBasedSingletonScopeProvider.a(categoryBrowserFetchControllerProvider, 3478);
        Lazy b = IdBasedSingletonScopeProvider.b(categoryBrowserFetchControllerProvider, 494);
        categoryBrowserConnectionConfiguration.f568a = a2;
        categoryBrowserConnectionConfiguration.f569c = b;
        CategoryBrowserConnectionConfiguration categoryBrowserConnectionConfiguration2 = categoryBrowserConnectionConfiguration;
        CategoryBrowserSearchConnectionConfigurationProvider categoryBrowserSearchConnectionConfigurationProvider = (CategoryBrowserSearchConnectionConfigurationProvider) categoryBrowserFetchControllerProvider.getOnDemandAssistedProviderForStaticDi(CategoryBrowserSearchConnectionConfigurationProvider.class);
        categoryBrowserFetchController.f578e = a;
        categoryBrowserFetchController.f579f = categoryBrowserConnectionConfiguration2;
        categoryBrowserFetchController.f580g = categoryBrowserSearchConnectionConfigurationProvider;
        this.f589d = categoryBrowserFetchController;
        this.f589d.m630a();
        this.f591f.mo17b(ao().getString(2131238438));
        View findViewById = viewGroup.findViewById(2131567301);
        findViewById.setVisibility(0);
        final FbEditText fbEditText = (FbEditText) findViewById.findViewById(2131560492);
        final ImageButton imageButton = (ImageButton) findViewById.findViewById(2131560324);
        fbEditText.setHint(2131238442);
        fbEditText.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ CategoryBrowserFragment f583b;

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.f583b.f589d.m631a(charSequence);
                this.f583b.f592g.a();
                if (StringUtil.a(charSequence)) {
                    imageButton.setVisibility(8);
                } else {
                    imageButton.setVisibility(0);
                }
            }

            public void afterTextChanged(Editable editable) {
            }
        });
        imageButton.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CategoryBrowserFragment f585b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -67060017);
                fbEditText.setText("");
                Logger.a(2, EntryType.UI_INPUT_END, -515501536, a);
            }
        });
        this.f592g = (LoadingIndicatorView) viewGroup.findViewById(2131560266);
        this.f593h = new LazyView((ViewStub) viewGroup.findViewById(2131560267));
        ProfileOverlayPageRecyclerViewInitializer.m646a((BetterRecyclerView) this.f592g.findViewById(2131566381), this.f590e, ao());
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1418421096);
        this.f589d.m632b();
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -399124126, a);
    }
}
