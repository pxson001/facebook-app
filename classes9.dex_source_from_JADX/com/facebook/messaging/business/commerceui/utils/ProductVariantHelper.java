package com.facebook.messaging.business.commerceui.utils;

import com.facebook.common.util.FinanceUtils;
import com.facebook.debug.log.BLog;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsInterfaces.MessengerCommerceFetchProductGroupQuery.Group.ProductItemsEdge.Nodes;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.MessengerCommerceFetchProductGroupQueryModel;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.MessengerCommerceFetchProductGroupQueryModel.GroupModel.ProductItemsEdgeModel.NodesModel;
import com.facebook.messaging.business.commerce.graphql.CommerceQueryFragmentsModels.MessengerCommerceProductPriceFieldsModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: num_fetching_offset */
public class ProductVariantHelper {
    public int f8409a;
    public ImmutableList<String> f8410b;
    public VariantValuesCollection[] f8411c;
    public ImmutableList<Nodes> f8412d;

    /* compiled from: num_fetching_offset */
    class C09521 implements Comparator<Nodes> {
        final /* synthetic */ ProductVariantHelper f8405a;

        C09521(ProductVariantHelper productVariantHelper) {
            this.f8405a = productVariantHelper;
        }

        public int compare(Object obj, Object obj2) {
            NodesModel nodesModel = (NodesModel) obj2;
            long parseLong = Long.parseLong(((NodesModel) obj).c().b());
            long parseLong2 = Long.parseLong(nodesModel.c().b());
            if (parseLong == parseLong2) {
                return 0;
            }
            return parseLong > parseLong2 ? 1 : -1;
        }
    }

    /* compiled from: num_fetching_offset */
    public enum VariantValueState {
        AVAILABLE,
        NOT_AVAILABLE,
        SOLD_OUT
    }

    /* compiled from: num_fetching_offset */
    public class VariantValuesCollection {
        public final String[] f8406a;
        public final VariantValueState[] f8407b;
        public int f8408c = -1;

        public VariantValuesCollection(ImmutableList<String> immutableList) {
            this.f8406a = new String[immutableList.size()];
            immutableList.toArray(this.f8406a);
            this.f8407b = new VariantValueState[immutableList.size()];
            for (int i = 0; i < this.f8406a.length; i++) {
                this.f8407b[i] = VariantValueState.AVAILABLE;
            }
        }
    }

    public final void m8680a(MessengerCommerceFetchProductGroupQueryModel messengerCommerceFetchProductGroupQueryModel) {
        this.f8412d = ImmutableList.copyOf(messengerCommerceFetchProductGroupQueryModel.c().a().a());
        m8677b(messengerCommerceFetchProductGroupQueryModel);
    }

    private void m8678d() {
        for (int i = 0; i < this.f8409a; i++) {
            int[] a = m8681a();
            for (int i2 = 0; i2 < this.f8411c[i].f8406a.length; i2++) {
                a[i] = i2;
                ImmutableList a2 = m8679a(a);
                if (a2.isEmpty()) {
                    this.f8411c[i].f8407b[i2] = VariantValueState.NOT_AVAILABLE;
                } else {
                    int i3 = 0;
                    for (int i4 = 0; i4 < a2.size(); i4++) {
                        i3 += ((NodesModel) a2.get(i4)).b();
                    }
                    if (i3 == 0) {
                        this.f8411c[i].f8407b[i2] = VariantValueState.SOLD_OUT;
                    } else {
                        this.f8411c[i].f8407b[i2] = VariantValueState.AVAILABLE;
                    }
                }
            }
        }
    }

    public final ImmutableList<Nodes> m8679a(int[] iArr) {
        Builder builder = new Builder();
        int size = this.f8412d.size();
        for (int i = 0; i < size; i++) {
            NodesModel nodesModel = (NodesModel) this.f8412d.get(i);
            if (nodesModel.b() != 0) {
                Object obj;
                int i2 = 0;
                while (i2 < this.f8409a) {
                    if (iArr[i2] != -1 && !((String) nodesModel.cc_().get(i2)).equals(this.f8411c[i2].f8406a[iArr[i2]])) {
                        obj = null;
                        break;
                    }
                    i2++;
                }
                int i3 = 1;
                if (obj != null) {
                    builder.c(nodesModel);
                }
            }
        }
        return builder.b();
    }

    public final int[] m8681a() {
        int[] iArr = new int[this.f8409a];
        for (int i = 0; i < this.f8409a; i++) {
            iArr[i] = this.f8411c[i].f8408c;
        }
        return iArr;
    }

    @Nullable
    public final String m8682c() {
        ImmutableList a = m8679a(m8681a());
        if (a == null || a.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(a);
        Collections.sort(arrayList, new C09521(this));
        if (arrayList.size() == 1) {
            return m8676a(((NodesModel) arrayList.get(0)).g());
        }
        if (Long.parseLong(((NodesModel) arrayList.get(0)).c().b()) == Long.parseLong(((NodesModel) arrayList.get(arrayList.size() - 1)).c().b())) {
            return m8676a(((NodesModel) arrayList.get(0)).c());
        }
        return m8676a(((NodesModel) arrayList.get(0)).c()) + " - " + m8676a(((NodesModel) arrayList.get(arrayList.size() - 1)).c());
    }

    private static String m8676a(MessengerCommerceProductPriceFieldsModel messengerCommerceProductPriceFieldsModel) {
        try {
            return FinanceUtils.a(messengerCommerceProductPriceFieldsModel.a(), (long) Integer.parseInt(messengerCommerceProductPriceFieldsModel.b()), 2);
        } catch (Throwable e) {
            BLog.b(ProductVariantHelper.class, "Couldn't parse amountInHundredths.", e);
            return null;
        }
    }

    private void m8677b(MessengerCommerceFetchProductGroupQueryModel messengerCommerceFetchProductGroupQueryModel) {
        this.f8410b = ImmutableList.copyOf(messengerCommerceFetchProductGroupQueryModel.c().b());
        this.f8409a = this.f8410b.size();
        if (this.f8409a != 0) {
            this.f8411c = new VariantValuesCollection[this.f8409a];
            for (int i = 0; i < this.f8409a; i++) {
                VariantValuesCollection[] variantValuesCollectionArr = this.f8411c;
                ImmutableList immutableList = this.f8412d;
                Builder builder = new Builder();
                Set hashSet = new HashSet();
                int size = immutableList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    NodesModel nodesModel = (NodesModel) immutableList.get(i2);
                    if (nodesModel.cc_().size() > i) {
                        String str = (String) nodesModel.cc_().get(i);
                        if (!hashSet.contains(str)) {
                            hashSet.add(str);
                            builder.c(str);
                        }
                    }
                }
                variantValuesCollectionArr[i] = new VariantValuesCollection(builder.b());
            }
            m8678d();
        }
    }
}
