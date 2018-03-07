package com.facebook.greetingcards.render.templatefetch;

import android.net.Uri;
import com.facebook.greetingcards.verve.model.VMDeck;
import com.google.common.collect.ImmutableMap;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: xma_action_leave_conversation */
public class TemplateResult {
    public final VMDeck f243a;
    public final ImmutableMap<String, Uri> f244b;

    public TemplateResult(VMDeck vMDeck, ImmutableMap<String, Uri> immutableMap) {
        this.f243a = vMDeck;
        this.f244b = immutableMap;
    }
}
