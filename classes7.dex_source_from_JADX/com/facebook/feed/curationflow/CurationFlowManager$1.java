package com.facebook.feed.curationflow;

import com.facebook.fbservice.service.OperationResult;
import com.google.common.util.concurrent.FutureCallback;
import java.util.Stack;
import javax.annotation.Nullable;

/* compiled from: application/x-subrip */
class CurationFlowManager$1 implements FutureCallback<OperationResult> {
    final /* synthetic */ String f19133a;
    final /* synthetic */ FutureCallback f19134b;
    final /* synthetic */ CurationFlowManager f19135c;

    CurationFlowManager$1(CurationFlowManager curationFlowManager, String str, FutureCallback futureCallback) {
        this.f19135c = curationFlowManager;
        this.f19133a = str;
        this.f19134b = futureCallback;
    }

    public void onSuccess(@Nullable Object obj) {
        this.f19135c.a(this.f19133a, ((OperationResult) obj).c);
        CurationFlowManager.d(this.f19135c, this.f19133a);
        Stack stack = (Stack) this.f19135c.f.get(this.f19133a);
        if (!stack.empty()) {
            stack.pop();
        }
        if (this.f19134b != null) {
            this.f19134b.onSuccess(this.f19135c.b(this.f19133a));
        }
    }

    public void onFailure(Throwable th) {
        CurationFlowManager.d(this.f19135c, this.f19133a);
        this.f19135c.b.a(CurationFlowManager.a, "Undo curation flow failed", th);
        this.f19134b.onFailure(th);
    }
}
