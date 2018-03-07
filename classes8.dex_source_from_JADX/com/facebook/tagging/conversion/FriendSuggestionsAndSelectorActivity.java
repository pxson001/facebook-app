package com.facebook.tagging.conversion;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.media.MediaItem;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.analytics.DefaultPhotoFlowLogger;
import com.facebook.photos.base.analytics.PhotoFlowLogger;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.ui.titlebar.Fb4aTitleBar.OnActionButtonClickListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.primitives.Longs;
import java.util.ArrayList;
import java.util.Set;

/* compiled from: max_scroll_distance */
public final class FriendSuggestionsAndSelectorActivity extends FbFragmentActivity implements AnalyticsActivity {
    public FriendSuggestionsAndSelectorFragment f9050p;
    private DefaultPhotoFlowLogger f9051q;
    private final OnActionButtonClickListener f9052r = new C09351(this);

    /* compiled from: max_scroll_distance */
    class C09351 implements OnActionButtonClickListener {
        final /* synthetic */ FriendSuggestionsAndSelectorActivity f9048a;

        C09351(FriendSuggestionsAndSelectorActivity friendSuggestionsAndSelectorActivity) {
            this.f9048a = friendSuggestionsAndSelectorActivity;
        }

        public final void m10810a(View view) {
            this.f9048a.f9050p.m10867b();
        }
    }

    /* compiled from: max_scroll_distance */
    class C09362 implements OnClickListener {
        final /* synthetic */ FriendSuggestionsAndSelectorActivity f9049a;

        C09362(FriendSuggestionsAndSelectorActivity friendSuggestionsAndSelectorActivity) {
            this.f9049a = friendSuggestionsAndSelectorActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 488332847);
            this.f9049a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 1304551720, a);
        }
    }

    public static Intent m10811a(Context context, Set<Long> set) {
        return m10813a(context, (Set) set, null, null);
    }

    public static Intent m10814a(Context context, long[] jArr) {
        return m10815a(context, jArr, null, null);
    }

    public static Intent m10812a(Context context, Set<Long> set, int i) {
        Intent a = m10811a(context, (Set) set);
        a.putExtra("custom_title_res_id", i);
        return a;
    }

    public static Intent m10813a(Context context, Set<Long> set, ImmutableList<MediaItem> immutableList, PhotoFlowLogger photoFlowLogger) {
        return m10815a(context, Longs.a(set), (ImmutableList) immutableList, (DefaultPhotoFlowLogger) photoFlowLogger);
    }

    private static Intent m10815a(Context context, long[] jArr, ImmutableList<MediaItem> immutableList, PhotoFlowLogger photoFlowLogger) {
        Intent intent = new Intent(context, FriendSuggestionsAndSelectorActivity.class);
        intent.putExtra("profiles", jArr);
        ArrayList a = m10817a((ImmutableList) immutableList);
        boolean z = (a == null || a.isEmpty()) ? false : true;
        if (z) {
            intent.putParcelableArrayListExtra("extra_media_items", new ArrayList(immutableList));
            intent.putExtra("extras_has_faces_detected", true);
        }
        if (photoFlowLogger != null) {
            intent.putExtra("photo_upload_waterfall_id", photoFlowLogger.j);
        }
        return intent;
    }

    private static ArrayList<MediaItem> m10817a(ImmutableList<MediaItem> immutableList) {
        if (immutableList == null) {
            return Lists.a();
        }
        ArrayList<MediaItem> a = Lists.a();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            MediaItem mediaItem = (MediaItem) immutableList.get(i);
            if (mediaItem instanceof PhotoItem) {
                a.add(mediaItem);
            }
        }
        return a;
    }

    public final void m10818b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130904537);
        Fb4aTitleBar fb4aTitleBar = (Fb4aTitleBar) a(2131558563);
        fb4aTitleBar.a(new C09362(this));
        Builder a = TitleBarButtonSpec.a();
        a.a = 1;
        a = a;
        a.g = getString(2131234445);
        a = a;
        a.q = true;
        a = a;
        a.h = -2;
        fb4aTitleBar.setPrimaryButton(a.a());
        fb4aTitleBar.setTitle(2131234443);
        fb4aTitleBar.setActionButtonOnClickListener(this.f9052r);
        if (bundle == null) {
            this.f9050p = new FriendSuggestionsAndSelectorFragment();
            if (getIntent().hasExtra("extra_include_viewer")) {
                this.f9050p.ba = true;
            }
            this.f9050p.g(getIntent().getExtras());
            kO_().a().b(2131558429, this.f9050p).b();
        } else {
            this.f9050p = (FriendSuggestionsAndSelectorFragment) kO_().a(2131558429);
        }
        FriendSuggestionsAndSelectorFragment friendSuggestionsAndSelectorFragment = this.f9050p;
        Intent intent = getIntent();
        Set a2 = Sets.a();
        long[] longArrayExtra = intent.getLongArrayExtra("profiles");
        if (longArrayExtra != null) {
            a2 = Sets.b(Longs.a(longArrayExtra));
        }
        if (intent.hasExtra("people_tagging_metadata")) {
            friendSuggestionsAndSelectorFragment.bi = intent.getStringArrayListExtra("people_tagging_metadata").contains("only_tag_good_friends");
        }
        friendSuggestionsAndSelectorFragment.bf = a2;
        friendSuggestionsAndSelectorFragment.ax = fb4aTitleBar;
        if (getIntent().hasExtra("photo_upload_waterfall_id")) {
            String stringExtra = getIntent().getStringExtra("photo_upload_waterfall_id");
            this.f9051q = DefaultPhotoFlowLogger.b(FbInjector.get(getApplicationContext()));
            this.f9051q.a(stringExtra);
        }
    }

    public final String am_() {
        return "friend_suggestions_and_selector";
    }

    public final void onBackPressed() {
        if (this.f9051q != null) {
            this.f9051q.b();
        }
        if (getIntent().hasExtra("extra_place")) {
            Intent intent = new Intent();
            FlatBufferModelHelper.a(intent, "extra_place", FlatBufferModelHelper.a(getIntent(), "extra_place"));
            setResult(0, intent);
            finish();
        } else if (this.f9050p == null || this.f9050p.m10870e()) {
            super.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }
}
