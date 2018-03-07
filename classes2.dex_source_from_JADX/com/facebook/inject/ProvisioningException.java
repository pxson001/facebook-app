package com.facebook.inject;

import com.facebook.inject.ProvisioningDebugStack.StackEntry;
import com.facebook.inject.ProvisioningDebugStack.StackType;
import com.google.inject.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: sponsored_impressions_log_non_viewability_enabled */
public class ProvisioningException extends RuntimeException {
    public ProvisioningException() {
        super(m7810a(null));
    }

    public ProvisioningException(String str) {
        super(m7810a(str));
    }

    private static String m7810a(@Nullable String str) {
        StringBuilder stringBuilder = new StringBuilder();
        if (str != null) {
            stringBuilder.append(str);
        } else {
            stringBuilder.append("Failure to provision.");
        }
        stringBuilder.append("\n");
        List list = (List) ProvisioningDebugStack.a.get();
        List arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i += 2) {
            arrayList.add(new StackEntry((StackType) list.get(i), (Key) list.get(i + 1)));
        }
        List<StackEntry> list2 = arrayList;
        Collections.reverse(list2);
        for (StackEntry stackEntry : list2) {
            if (stackEntry.a == StackType.INSTANCE_GET) {
                stringBuilder.append(" while trying to get instance of ");
            } else if (stackEntry.a == StackType.INJECT_COMPONENT) {
                stringBuilder.append(" while trying to inject component of ");
            } else {
                stringBuilder.append(" while trying to get provider of ");
            }
            stringBuilder.append(stackEntry.b).append("\n");
        }
        return stringBuilder.toString();
    }
}
