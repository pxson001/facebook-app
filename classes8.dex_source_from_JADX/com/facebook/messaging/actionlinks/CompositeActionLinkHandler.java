package com.facebook.messaging.actionlinks;

import android.net.Uri;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;

/* compiled from: trackingcode_unit */
public class CompositeActionLinkHandler implements ActionLinkHandler {
    private final ImmutableList<ActionLinkHandler> f1430a;

    public CompositeActionLinkHandler(ActionLinkHandler... actionLinkHandlerArr) {
        this(ImmutableList.copyOf(Arrays.asList(actionLinkHandlerArr)));
    }

    private CompositeActionLinkHandler(ImmutableList<ActionLinkHandler> immutableList) {
        this.f1430a = (ImmutableList) Preconditions.checkNotNull(immutableList);
    }

    public final boolean mo64a(Uri uri) {
        int size = this.f1430a.size();
        for (int i = 0; i < size; i++) {
            if (((ActionLinkHandler) this.f1430a.get(i)).mo64a(uri)) {
                return true;
            }
        }
        return false;
    }
}
