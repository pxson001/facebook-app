package com.facebook.messaging.service.base;

import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: decline_request_dialog */
public class OperationResultMerger {

    /* compiled from: decline_request_dialog */
    public interface SubOperationMerger<T> {
        OperationResult mo696a(Map<T, OperationResult> map, ImmutableSet<Exception> immutableSet);
    }

    /* compiled from: decline_request_dialog */
    public class StrictSuccessMerger<T> implements SubOperationMerger<T> {
        public final OperationResult mo696a(Map<T, OperationResult> map, ImmutableSet<Exception> immutableSet) {
            if (immutableSet.isEmpty()) {
                return OperationResult.a;
            }
            throw new OperationMultipleFailureException(immutableSet);
        }
    }

    /* compiled from: decline_request_dialog */
    class SubOperation<T> {
        final T f16857a;
        final BlueServiceHandler f16858b;
        final OperationParams f16859c;

        SubOperation(T t, BlueServiceHandler blueServiceHandler, OperationParams operationParams) {
            this.f16857a = t;
            this.f16858b = blueServiceHandler;
            this.f16859c = operationParams;
        }
    }

    /* compiled from: decline_request_dialog */
    public class SubOperationBatch<T> {
        public final ArrayList<SubOperation<T>> f16860a = new ArrayList();

        public final SubOperationBatch<T> m16844a(T t, BlueServiceHandler blueServiceHandler, OperationParams operationParams) {
            this.f16860a.add(new SubOperation(t, blueServiceHandler, operationParams));
            return this;
        }
    }

    public static <T> OperationResult m16845a(SubOperationBatch<T> subOperationBatch, SubOperationMerger<T> subOperationMerger) {
        Map hashMap = new HashMap(subOperationBatch.f16860a.size());
        Builder builder = ImmutableSet.builder();
        ArrayList arrayList = subOperationBatch.f16860a;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            SubOperation subOperation = (SubOperation) arrayList.get(i);
            try {
                hashMap.put(subOperation.f16857a, subOperation.f16858b.a(subOperation.f16859c));
            } catch (Exception e) {
                builder.c(e);
            }
        }
        ImmutableSet b = builder.b();
        OperationResult a = subOperationMerger.mo696a(hashMap, b);
        if (b.isEmpty()) {
            return a;
        }
        throw new OperationPartialResultException(a, b);
    }
}
