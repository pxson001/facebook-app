package com.facebook.reaction.externalshare;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalBroadcast;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.fragmentfactory.FragmentFactoryMap;
import com.facebook.common.fragmentfactory.FragmentFactoryMapImpl;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: billing_zip_digits */
public class ReactionExternalShareActivity extends FbFragmentActivity {
    @Inject
    @LocalBroadcast
    public BaseFbBroadcastManager f18935p;
    @Inject
    public FragmentFactoryMap f18936q;

    private static <T extends Context> void m22952a(Class<T> cls, T t) {
        m22953a((Object) t, (Context) t);
    }

    public static void m22953a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ReactionExternalShareActivity reactionExternalShareActivity = (ReactionExternalShareActivity) obj;
        BaseFbBroadcastManager baseFbBroadcastManager = (BaseFbBroadcastManager) LocalFbBroadcastManager.a(fbInjector);
        FragmentFactoryMap fragmentFactoryMap = (FragmentFactoryMap) FragmentFactoryMapImpl.a(fbInjector);
        reactionExternalShareActivity.f18935p = baseFbBroadcastManager;
        reactionExternalShareActivity.f18936q = fragmentFactoryMap;
    }

    @Nullable
    public static Intent m22951a(Context context, Intent intent) {
        Object obj;
        if (intent == null || !intent.hasExtra("reaction_session_id")) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            return null;
        }
        Intent intent2 = new Intent(context, ReactionExternalShareActivity.class);
        intent2.putExtras(intent);
        intent2.putExtra("close_activity_after_finish", true);
        intent2.setFlags(411041792);
        return intent2;
    }

    protected final void m22954b(Bundle bundle) {
        super.b(bundle);
        Class cls = ReactionExternalShareActivity.class;
        m22953a((Object) this, (Context) this);
        setContentView(2130906660);
        kO_().a().a(2131559609, this.f18936q.a(ContentFragmentType.REACTION_DIALOG_FRAGMENT.ordinal()).a(getIntent()), "chromeless:content:fragment:tag").b();
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1530093969);
        super.onDestroy();
        if (this.f18935p != null) {
            this.f18935p.a("com.facebook.intent.action.REACTION_CLOSE_EXTERNAL_SHARE_SERVICE");
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1386617907, a);
    }
}
