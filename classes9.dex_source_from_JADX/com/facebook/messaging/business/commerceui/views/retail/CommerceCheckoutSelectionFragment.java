package com.facebook.messaging.business.commerceui.views.retail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragments.MessengerCommerceFetchProductGroupQueryString;
import com.facebook.messaging.business.commerceui.loader.CommerceCheckoutSelectionLoader;
import com.facebook.messaging.business.commerceui.loader.CommerceCheckoutSelectionLoader.C09491;
import com.facebook.messaging.business.commerceui.utils.ProductVariantHelper;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment;
import com.facebook.messaging.business.common.activity.BusinessActivityFragment.EventListener;
import com.facebook.messaging.business.common.helper.LogoViewHelper;
import com.facebook.messaging.payment.value.input.checkout.MessengerPayCheckoutIntentHelper;
import com.facebook.resources.ui.FbButton;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.Futures;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: null result. */
public final class CommerceCheckoutSelectionFragment extends FbFragment implements BusinessActivityFragment {
    @Inject
    public CommerceCheckoutSelectionAdapter f8463a;
    public FbButton al;
    @Inject
    public CommerceCheckoutSelectionLoader f8464b;
    @Inject
    public AbstractFbErrorReporter f8465c;
    @Inject
    SecureContextHelper f8466d;
    @Inject
    MessengerPayCheckoutIntentHelper f8467e;
    public String f8468f;
    public LinearLayout f8469g;
    private RecyclerView f8470h;
    public ProgressBar f8471i;

    /* compiled from: null result. */
    class C09611 extends SpanSizeLookup {
        final /* synthetic */ CommerceCheckoutSelectionFragment f8459b;

        C09611(CommerceCheckoutSelectionFragment commerceCheckoutSelectionFragment) {
            this.f8459b = commerceCheckoutSelectionFragment;
        }

        public final int m8722a(int i) {
            int i2;
            switch (this.f8459b.f8463a.getItemViewType(i)) {
                case 0:
                case 1:
                case 2:
                    i2 = 4;
                    break;
                case 4:
                    i2 = 2;
                    break;
                default:
                    i2 = 1;
                    break;
            }
            return i2;
        }
    }

    /* compiled from: null result. */
    public class C09622 {
        public final /* synthetic */ CommerceCheckoutSelectionFragment f8460a;

        public C09622(CommerceCheckoutSelectionFragment commerceCheckoutSelectionFragment) {
            this.f8460a = commerceCheckoutSelectionFragment;
        }
    }

    /* compiled from: null result. */
    public class C09633 {
        public final /* synthetic */ CommerceCheckoutSelectionFragment f8461a;

        public C09633(CommerceCheckoutSelectionFragment commerceCheckoutSelectionFragment) {
            this.f8461a = commerceCheckoutSelectionFragment;
        }
    }

    /* compiled from: null result. */
    public class C09644 implements OnClickListener {
        final /* synthetic */ CommerceCheckoutSelectionFragment f8462a;

        public C09644(CommerceCheckoutSelectionFragment commerceCheckoutSelectionFragment) {
            this.f8462a = commerceCheckoutSelectionFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1242270043);
            String d = this.f8462a.f8463a.m8721d();
            if (!Strings.isNullOrEmpty(d)) {
                this.f8462a.f8466d.a(this.f8462a.f8467e.m15975a(this.f8462a.getContext(), d), 1, this.f8462a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1277269786, a);
        }
    }

    /* compiled from: null result. */
    public class Factory implements com.facebook.messaging.business.common.activity.BusinessActivityFragment.Factory {
        public final String mo307a() {
            return "CommerceCheckoutSelectionFragment";
        }

        public final BusinessActivityFragment mo308b() {
            return new CommerceCheckoutSelectionFragment();
        }
    }

    public static void m8726a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((CommerceCheckoutSelectionFragment) obj).m8725a(new CommerceCheckoutSelectionAdapter(new ProductVariantHelper(), LogoViewHelper.m9022b(fbInjector)), CommerceCheckoutSelectionLoader.m8669b(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), MessengerPayCheckoutIntentHelper.m15974b(fbInjector));
    }

    private void m8725a(CommerceCheckoutSelectionAdapter commerceCheckoutSelectionAdapter, CommerceCheckoutSelectionLoader commerceCheckoutSelectionLoader, AbstractFbErrorReporter abstractFbErrorReporter, SecureContextHelper secureContextHelper, MessengerPayCheckoutIntentHelper messengerPayCheckoutIntentHelper) {
        this.f8463a = commerceCheckoutSelectionAdapter;
        this.f8464b = commerceCheckoutSelectionLoader;
        this.f8465c = abstractFbErrorReporter;
        this.f8466d = secureContextHelper;
        this.f8467e = messengerPayCheckoutIntentHelper;
    }

    public final void mo310a(Parcelable parcelable) {
        this.f8468f = ((Bundle) parcelable).getString("product_item_id");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(this.f8468f));
    }

    public final String mo309a(Context context) {
        return context.getString(2131240692);
    }

    public final void mo311a(EventListener eventListener) {
    }

    public final void m8734c(Bundle bundle) {
        super.c(bundle);
        Class cls = CommerceCheckoutSelectionFragment.class;
        m8726a((Object) this, getContext());
    }

    public final View m8728a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1983255962);
        View inflate = layoutInflater.inflate(2130905627, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 876909890, a);
        return inflate;
    }

    public final void m8732a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f8469g = (LinearLayout) e(2131564663);
        this.f8470h = (RecyclerView) e(2131564664);
        this.f8471i = (ProgressBar) e(2131564666);
        this.al = (FbButton) e(2131559172);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
        gridLayoutManager.h = new C09611(this);
        this.f8470h.setLayoutManager(gridLayoutManager);
        this.f8470h.setAdapter(this.f8463a);
        this.f8464b.f8387g = new C09622(this);
        this.f8463a.f8456c = new C09633(this);
        this.al.setOnClickListener(new C09644(this));
        this.f8471i.setVisibility(0);
        this.f8469g.setVisibility(8);
        CommerceCheckoutSelectionLoader commerceCheckoutSelectionLoader = this.f8464b;
        String str = this.f8468f;
        commerceCheckoutSelectionLoader.m8670a();
        GraphQlQueryString messengerCommerceFetchProductGroupQueryString = new MessengerCommerceFetchProductGroupQueryString();
        messengerCommerceFetchProductGroupQueryString.a("product_item_id", str);
        GraphQLRequest a = GraphQLRequest.a(messengerCommerceFetchProductGroupQueryString).a(GraphQLCachePolicy.a).a(600);
        long now = commerceCheckoutSelectionLoader.f8384d.now();
        commerceCheckoutSelectionLoader.f8386f = commerceCheckoutSelectionLoader.f8381a.a(a);
        Futures.a(commerceCheckoutSelectionLoader.f8386f, new C09491(commerceCheckoutSelectionLoader, str, now), commerceCheckoutSelectionLoader.f8382b);
    }

    public final void m8730a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i == 1 && i2 == -1) {
            o().finish();
        }
    }

    public final void m8727H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 815967946);
        super.H();
        this.f8464b.m8670a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1986055642, a);
    }
}
