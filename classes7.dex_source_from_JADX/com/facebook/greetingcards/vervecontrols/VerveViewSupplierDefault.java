package com.facebook.greetingcards.vervecontrols;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.greetingcards.verve.VerveViewSupplier;
import com.facebook.greetingcards.verve.VerveViewSupplier.RecyclerType;
import com.facebook.greetingcards.verve.model.VMView;
import com.facebook.greetingcards.verve.render.VerveVideoContainer;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;
import javax.annotation.Nullable;

/* compiled from: PushDataHandlerService */
public abstract class VerveViewSupplierDefault implements VerveViewSupplier {
    public <V extends View & VerveVideoContainer> V mo1607b(Context context, VMView vMView) {
        return new VerveVideoView(context);
    }

    public void mo1606a(VMView vMView, ImmutableMap<String, String> immutableMap, VerveVideoContainer verveVideoContainer) {
        VerveVideoView verveVideoView = (VerveVideoView) verveVideoContainer;
        verveVideoView.g.setSource(Uri.parse((String) immutableMap.get(vMView.src)));
        if (Strings.isNullOrEmpty(vMView.placeholderSrc)) {
            verveVideoView.setCoverUri(null);
        } else {
            verveVideoView.setCoverUri(Uri.parse((String) immutableMap.get(vMView.placeholderSrc)));
        }
    }

    public <T extends Enum & RecyclerType> ImmutableSet<T> mo1604a() {
        return RegularImmutableSet.a;
    }

    @Nullable
    public <T extends Enum & RecyclerType> T mo1605a(VMView vMView) {
        return null;
    }
}
