package com.facebook.heisman;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.inject.Inject;

/* compiled from: video_processed */
public class BirthdayFrameStagingGroundDummyActivity extends FbFragmentActivity {
    @Inject
    public BirthdayFrameStagingGroundDummyActivityControllerProvider f535p;
    private BirthdayFrameStagingGroundDummyActivityController f536q;

    private static <T extends Context> void m592a(Class<T> cls, T t) {
        m593a((Object) t, (Context) t);
    }

    public static void m593a(Object obj, Context context) {
        ((BirthdayFrameStagingGroundDummyActivity) obj).f535p = (BirthdayFrameStagingGroundDummyActivityControllerProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(BirthdayFrameStagingGroundDummyActivityControllerProvider.class);
    }

    public static Intent m590a(Context context, String str, ImageOverlayFieldsModel imageOverlayFieldsModel) {
        Intent intent = new Intent(context, BirthdayFrameStagingGroundDummyActivity.class);
        intent.putExtra("profile_id", str);
        FlatBufferModelHelper.a(intent, "imageoverlay", imageOverlayFieldsModel);
        return intent;
    }

    public final void m594b(Bundle bundle) {
        super.b(bundle);
        Class cls = BirthdayFrameStagingGroundDummyActivity.class;
        m593a((Object) this, (Context) this);
        Bundle extras = getIntent().getExtras();
        this.f536q = this.f535p.m609a(this, extras.getString("profile_id"), (ImageOverlayFieldsModel) FlatBufferModelHelper.a(extras, "imageoverlay"));
        this.f536q.m604a();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            this.f536q.m605a(this, i, i2, intent);
            super.onActivityResult(i, i2, intent);
        }
    }

    public void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1649646016);
        super.onDestroy();
        if (this.f536q != null) {
            this.f536q.m608b();
            this.f536q = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 752796272, a);
    }

    private void m591a(BirthdayFrameStagingGroundDummyActivityControllerProvider birthdayFrameStagingGroundDummyActivityControllerProvider) {
        this.f535p = birthdayFrameStagingGroundDummyActivityControllerProvider;
    }
}
