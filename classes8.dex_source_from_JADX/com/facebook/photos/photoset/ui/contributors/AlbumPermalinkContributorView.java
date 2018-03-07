package com.facebook.photos.photoset.ui.contributors;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: code_copied */
public class AlbumPermalinkContributorView extends CustomLinearLayout {
    public static final CallerContext f17812a = CallerContext.a(AlbumPermalinkContributorView.class);
    public GraphQLActor f17813b;
    public Lazy<SecureContextHelper> f17814c;

    /* compiled from: code_copied */
    public class C19091 implements OnClickListener {
        final /* synthetic */ AlbumPermalinkContributorView f17811a;

        public C19091(AlbumPermalinkContributorView albumPermalinkContributorView) {
            this.f17811a = albumPermalinkContributorView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1569134103);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(FBLinks.cm + "/" + this.f17811a.f17813b.H()).buildUpon().build());
            intent.setFlags(268435456);
            ((SecureContextHelper) this.f17811a.f17814c.get()).a(intent, this.f17811a.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, -1238848454, a);
        }
    }

    public static void m21778a(Object obj, Context context) {
        ((AlbumPermalinkContributorView) obj).f17814c = IdBasedSingletonScopeProvider.b(FbInjector.get(context), 968);
    }

    public AlbumPermalinkContributorView(Context context) {
        super(context);
        Class cls = AlbumPermalinkContributorView.class;
        m21778a(this, getContext());
        setContentView(2130903803);
    }
}
