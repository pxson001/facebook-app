package com.facebook.pages.identity.cards.actionbar;

import com.facebook.debug.log.BLog;
import com.facebook.pages.data.graphql.pageheader.PageNuxStateMutationModels.NotifyPageNuxShownMutationModel;
import com.google.common.util.concurrent.FutureCallback;
import java.util.Collections;
import javax.annotation.Nullable;

/* compiled from: privacy_checkup_write_request_success */
public class PageMessageButtonNuxStateMutator$1 implements FutureCallback<NotifyPageNuxShownMutationModel> {
    final /* synthetic */ PageMessageButtonNuxStateMutator f3170a;

    public PageMessageButtonNuxStateMutator$1(PageMessageButtonNuxStateMutator pageMessageButtonNuxStateMutator) {
        this.f3170a = pageMessageButtonNuxStateMutator;
    }

    public void onSuccess(@Nullable Object obj) {
        this.f3170a.d.a("message_button_nux_mutation_success", Collections.singletonMap("user_Id", this.f3170a.b));
    }

    public void onFailure(Throwable th) {
        BLog.b(PageMessageButtonNuxStateMutator.a, th, "failed to mutate message button nux state", new Object[0]);
        this.f3170a.d.a("message_button_nux_mutation_failure", Collections.singletonMap("user_Id", this.f3170a.b));
    }
}
