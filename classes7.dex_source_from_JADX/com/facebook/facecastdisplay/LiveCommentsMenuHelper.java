package com.facebook.facecastdisplay;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.api.ufiservices.common.DeleteCommentParams;
import com.facebook.api.ufiservices.common.DeleteCommentParams.Builder;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.friends.protocol.BlockUserMethod.Params;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: stpp */
public class LiveCommentsMenuHelper {
    public static final String f2895a = LiveCommentsMenuHelper.class.getName();
    public final DefaultBlueServiceOperationFactory f2896b;
    public final String f2897c;
    public final Toaster f2898d;
    public final Executor f2899e;
    @Nullable
    public PopoverMenuWindow f2900f;
    @Nullable
    public LiveEventsListAdapter f2901g;

    /* compiled from: stpp */
    public class C02521 implements OnMenuItemClickListener {
        final /* synthetic */ LiveEventsListAdapter f2887a;
        final /* synthetic */ LiveCommentEventModel f2888b;
        final /* synthetic */ LiveCommentsMenuHelper f2889c;

        public C02521(LiveCommentsMenuHelper liveCommentsMenuHelper, LiveEventsListAdapter liveEventsListAdapter, LiveCommentEventModel liveCommentEventModel) {
            this.f2889c = liveCommentsMenuHelper;
            this.f2887a = liveEventsListAdapter;
            this.f2888b = liveCommentEventModel;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            LiveEventsListAdapter liveEventsListAdapter = this.f2887a;
            int indexOf = liveEventsListAdapter.f2938e.indexOf(this.f2888b);
            if (indexOf >= 0) {
                liveEventsListAdapter.f2938e.remove(indexOf);
                liveEventsListAdapter.l_(indexOf);
            }
            LiveCommentsMenuHelper liveCommentsMenuHelper = this.f2889c;
            String str = this.f2888b.f2852d;
            Builder builder = new Builder();
            builder.a = str;
            builder = builder;
            builder.b = "";
            DeleteCommentParams a = builder.a();
            Bundle bundle = new Bundle();
            bundle.putParcelable("deleteCommentParams", a);
            BlueServiceOperationFactoryDetour.a(liveCommentsMenuHelper.f2896b, "feed_delete_comment", bundle, -831725518).a();
            return false;
        }
    }

    /* compiled from: stpp */
    public class C02532 implements OnMenuItemClickListener {
        final /* synthetic */ LiveEventsListAdapter f2890a;
        final /* synthetic */ LiveCommentEventModel f2891b;
        final /* synthetic */ LiveCommentsMenuHelper f2892c;

        public C02532(LiveCommentsMenuHelper liveCommentsMenuHelper, LiveEventsListAdapter liveEventsListAdapter, LiveCommentEventModel liveCommentEventModel) {
            this.f2892c = liveCommentsMenuHelper;
            this.f2890a = liveEventsListAdapter;
            this.f2891b = liveCommentEventModel;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.f2890a.m3225a(this.f2891b.f2848k.f2903b, true);
            LiveCommentsMenuHelper liveCommentsMenuHelper = this.f2892c;
            String str = this.f2891b.f2848k.f2903b;
            Params params = new Params(Long.parseLong(liveCommentsMenuHelper.f2897c), Long.parseLong(str));
            Bundle bundle = new Bundle();
            bundle.putParcelable("blockUser", params);
            Futures.a(BlueServiceOperationFactoryDetour.a(liveCommentsMenuHelper.f2896b, "friending_block_user", bundle, 1211278992).a(), new C02543(liveCommentsMenuHelper, str), liveCommentsMenuHelper.f2899e);
            return false;
        }
    }

    /* compiled from: stpp */
    public class C02543 extends OperationResultFutureCallback {
        final /* synthetic */ String f2893a;
        final /* synthetic */ LiveCommentsMenuHelper f2894b;

        protected final void m3181a(ServiceException serviceException) {
            String str = LiveCommentsMenuHelper.f2895a;
            if (this.f2894b.f2901g != null) {
                this.f2894b.f2901g.m3225a(this.f2893a, false);
            }
            this.f2894b.f2898d.a(new ToastBuilder(2131230762));
        }

        public C02543(LiveCommentsMenuHelper liveCommentsMenuHelper, String str) {
            this.f2894b = liveCommentsMenuHelper;
            this.f2893a = str;
        }
    }

    @Inject
    public LiveCommentsMenuHelper(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, String str, Toaster toaster, Executor executor) {
        this.f2896b = defaultBlueServiceOperationFactory;
        this.f2897c = str;
        this.f2898d = toaster;
        this.f2899e = executor;
    }
}
