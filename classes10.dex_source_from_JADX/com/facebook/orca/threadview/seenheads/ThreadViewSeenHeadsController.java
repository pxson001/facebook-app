package com.facebook.orca.threadview.seenheads;

import android.support.v4.util.LongSparseArray;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.Assisted;
import com.facebook.messaging.deliveryreceipt.RowReceiptParticipant;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.seenheads.SeenHeadCircleOverflowRendererProvider;
import com.facebook.messaging.threadview.rows.RowItem;
import com.facebook.messaging.threadview.rows.RowItemDeliveryState;
import com.facebook.messaging.threadview.rows.RowMessageItem;
import com.facebook.messaging.threadview.rows.RowReceiptItem;
import com.facebook.orca.threadview.messagelist.MessageListHelper;
import com.facebook.springs.SpringSystem;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: m_quick_reply */
public class ThreadViewSeenHeadsController {
    public final SeenHeadsDecoration f8337a;
    public ThreadSummary f8338b;

    @Inject
    public ThreadViewSeenHeadsController(SeenHeadsDecorationProvider seenHeadsDecorationProvider, @Assisted MessageListHelper messageListHelper) {
        this.f8337a = new SeenHeadsDecoration(ResourcesMethodAutoProvider.a(seenHeadsDecorationProvider), (SeenHeadProvider) seenHeadsDecorationProvider.getOnDemandAssistedProviderForStaticDi(SeenHeadProvider.class), SeenHeadCircleOverflowRendererProvider.b(seenHeadsDecorationProvider), SpringSystem.b(seenHeadsDecorationProvider), messageListHelper);
    }

    public final void m8301b() {
        SeenHeadsDecoration seenHeadsDecoration = this.f8337a;
        for (SeenHead seenHead : seenHeadsDecoration.f8326e) {
            seenHead.m8271e();
            seenHead.m8272f();
        }
        seenHeadsDecoration.f8326e.clear();
        seenHeadsDecoration.f8327f.b();
        seenHeadsDecoration.f8328g.clear();
        seenHeadsDecoration.f8329h.b();
        seenHeadsDecoration.f8330i.clear();
    }

    private boolean m8298c() {
        if (this.f8338b == null) {
            return false;
        }
        if (ThreadKey.b(this.f8338b.a) || ThreadKey.g(this.f8338b.a)) {
            return true;
        }
        return false;
    }

    private UserKey m8299d() {
        if (m8298c()) {
            return UserKey.b(Long.toString(this.f8338b.a.d));
        }
        return null;
    }

    public final void m8300a(ImmutableList<RowItem> immutableList) {
        LongSparseArray longSparseArray = new LongSparseArray();
        LongSparseArray longSparseArray2 = new LongSparseArray();
        Set a = Sets.a();
        int size = immutableList.size() - 1;
        int i = -1;
        RowReceiptItem rowReceiptItem = null;
        while (size >= 0) {
            int i2;
            RowReceiptItem rowReceiptItem2;
            RowItem rowItem = (RowItem) immutableList.get(size);
            if (rowItem instanceof RowMessageItem) {
                Collection asList;
                RowMessageItem rowMessageItem = (RowMessageItem) rowItem;
                long a2 = rowMessageItem.m4299a();
                if (i != -1) {
                    longSparseArray.b(a2, Integer.valueOf(i));
                } else {
                    longSparseArray.b(a2, Integer.valueOf(size));
                }
                if (m8298c() && rowMessageItem.f4740i != null && rowMessageItem.f4740i == RowItemDeliveryState.READ && a.isEmpty()) {
                    asList = Arrays.asList(new UserKey[]{m8299d()});
                } else if (rowReceiptItem == null || rowReceiptItem.f4759b == null || rowReceiptItem.f4759b.isEmpty()) {
                    asList = null;
                } else {
                    List arrayList = new ArrayList();
                    for (RowReceiptParticipant rowReceiptParticipant : rowReceiptItem.f4759b) {
                        UserKey userKey = rowReceiptParticipant.b.b;
                        if (!a.contains(userKey)) {
                            arrayList.add(userKey);
                        }
                    }
                    Object obj = arrayList;
                }
                if (!(asList == null || asList.isEmpty())) {
                    longSparseArray2.b(a2, asList);
                    a.addAll(asList);
                }
                i2 = -1;
                rowReceiptItem2 = null;
            } else if (rowItem instanceof RowReceiptItem) {
                rowReceiptItem2 = (RowReceiptItem) rowItem;
                i2 = size;
            } else {
                i2 = i;
                rowReceiptItem2 = rowReceiptItem;
            }
            size--;
            rowReceiptItem = rowReceiptItem2;
            i = i2;
        }
        this.f8337a.m8290a(longSparseArray2, longSparseArray);
    }
}
