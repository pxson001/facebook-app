package com.facebook.composer.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: is_onboarded/ */
public class AlbumSelectorActivity extends FbFragmentActivity {
    @Inject
    public AlbumSelectorControllerProvider f5947p;
    private AlbumSelectorController f5948q;
    public String f5949r;
    @Nullable
    public GraphQLAlbum f5950s;
    public ComposerTargetData f5951t;
    public boolean f5952u;

    /* compiled from: is_onboarded/ */
    public class C07481 {
        final /* synthetic */ AlbumSelectorActivity f5945a;

        public C07481(AlbumSelectorActivity albumSelectorActivity) {
            this.f5945a = albumSelectorActivity;
        }

        public final String m7347a() {
            return this.f5945a.f5949r;
        }

        @Nullable
        public final GraphQLAlbum m7348b() {
            return this.f5945a.f5950s;
        }

        public final ComposerTargetData m7349c() {
            return this.f5945a.f5951t;
        }

        public final boolean m7350d() {
            return this.f5945a.f5952u;
        }
    }

    /* compiled from: is_onboarded/ */
    public class C07492 {
        final /* synthetic */ AlbumSelectorActivity f5946a;

        public C07492(AlbumSelectorActivity albumSelectorActivity) {
            this.f5946a = albumSelectorActivity;
        }

        public final void m7351a(GraphQLAlbum graphQLAlbum) {
            Intent intent = new Intent();
            FlatBufferModelHelper.a(intent, "extra_selected_album", graphQLAlbum);
            this.f5946a.setResult(-1, intent);
            this.f5946a.finish();
        }
    }

    private static <T extends Context> void m7355a(Class<T> cls, T t) {
        m7356a((Object) t, (Context) t);
    }

    public static void m7356a(Object obj, Context context) {
        ((AlbumSelectorActivity) obj).f5947p = (AlbumSelectorControllerProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(AlbumSelectorControllerProvider.class);
    }

    private void m7354a(AlbumSelectorControllerProvider albumSelectorControllerProvider) {
        this.f5947p = albumSelectorControllerProvider;
    }

    public static Intent m7352a(Context context, String str, ViewerContext viewerContext, ComposerTargetData composerTargetData, GraphQLAlbum graphQLAlbum, boolean z) {
        Intent intent = new Intent(context, AlbumSelectorActivity.class);
        intent.putExtra("extra_composer_session_id", str);
        intent.putExtra("extra_target_data", composerTargetData);
        intent.putExtra("extra_viewer_context", viewerContext);
        FlatBufferModelHelper.a(intent, "extra_initial_album", graphQLAlbum);
        intent.putExtra("should_hide_shared_albums", z);
        return intent;
    }

    public final void m7360b(Bundle bundle) {
        super.b(bundle);
        Class cls = AlbumSelectorActivity.class;
        m7356a((Object) this, (Context) this);
        setContentView(2130903236);
        Intent intent = getIntent();
        this.f5950s = (GraphQLAlbum) FlatBufferModelHelper.a(intent, "extra_initial_album");
        this.f5949r = intent.getStringExtra("extra_composer_session_id");
        this.f5951t = (ComposerTargetData) intent.getParcelableExtra("extra_target_data");
        this.f5952u = intent.getBooleanExtra("should_hide_shared_albums", false);
        this.f5948q = this.f5947p.m7366a(new C07492(this), new C07481(this), null, (ViewerContext) intent.getParcelableExtra("extra_viewer_context"));
        this.f5948q.m7365a(findViewById(2131559552));
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1344984424);
        super.onResume();
        this.f5948q.m7364a();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -30984020, a);
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1141463191);
        AlbumSelectorController albumSelectorController = this.f5948q;
        if (albumSelectorController.f5970m) {
            albumSelectorController.f5958a.b(albumSelectorController.f5966i);
        }
        super.onPause();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1048163328, a);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 2312) {
            AlbumSelectorController albumSelectorController = this.f5948q;
            if (i2 == -1) {
                albumSelectorController.f5965h.m7351a((GraphQLAlbum) FlatBufferModelHelper.a(intent, "extra_album"));
            }
        }
    }
}
