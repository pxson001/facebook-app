package com.facebook.photos.photoset.ui.permalink;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.albums.events.AlbumsEventBus;
import com.facebook.photos.albums.events.AlbumsEvents.ToggleContributorsEvent;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: closing_image */
public class AlbumPermalinkContributorsSectionView extends CustomLinearLayout {
    private static final CallerContext f17819a = CallerContext.a(AlbumPermalinkContributorsSectionView.class);
    public Lazy<AlbumsEventBus> f17820b;

    private static <T extends View> void m21785a(Class<T> cls, T t) {
        m21786a((Object) t, t.getContext());
    }

    private static void m21786a(Object obj, Context context) {
        ((AlbumPermalinkContributorsSectionView) obj).f17820b = IdBasedSingletonScopeProvider.b(FbInjector.get(context), 9247);
    }

    public AlbumPermalinkContributorsSectionView(Context context) {
        super(context);
        m21781a();
    }

    public AlbumPermalinkContributorsSectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m21781a();
    }

    protected AlbumPermalinkContributorsSectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m21781a();
    }

    @Inject
    private void m21783a(Lazy<AlbumsEventBus> lazy) {
        this.f17820b = lazy;
    }

    private void m21781a() {
        m21785a(AlbumPermalinkContributorsSectionView.class, (View) this);
    }

    public final void m21787a(final GraphQLAlbum graphQLAlbum) {
        setVisibility(8);
        setOnClickListener(null);
        if (graphQLAlbum.q() != null && graphQLAlbum.q().size() > 1) {
            setVisibility(0);
            setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ AlbumPermalinkContributorsSectionView f17818b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1393370758);
                    ((AlbumsEventBus) this.f17818b.f17820b.get()).a(new ToggleContributorsEvent(graphQLAlbum));
                    Logger.a(2, EntryType.UI_INPUT_END, -556503066, a);
                }
            });
            m21784a(graphQLAlbum.q());
        }
    }

    private static void m21782a(FbDraweeView fbDraweeView, ImmutableList<GraphQLActor> immutableList, int i) {
        if (i >= immutableList.size()) {
            fbDraweeView.setVisibility(8);
        } else if (((GraphQLActor) immutableList.get(i)).ai() != null && ((GraphQLActor) immutableList.get(i)).ai().b() != null) {
            fbDraweeView.a(ImageUtil.a(((GraphQLActor) immutableList.get(i)).ai()), f17819a);
            fbDraweeView.setVisibility(0);
        }
    }

    private void m21784a(ImmutableList<GraphQLActor> immutableList) {
        boolean z = (immutableList == null || immutableList.isEmpty()) ? false : true;
        Preconditions.checkState(z);
        int[] iArr = new int[]{2131565762, 2131565763, 2131565764};
        for (int i = 0; i < 3; i++) {
            m21782a((FbDraweeView) findViewById(iArr[i]), immutableList, i);
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(2131565765);
        FbTextView fbTextView = (FbTextView) findViewById(2131565766);
        ImageView imageView = (ImageView) findViewById(2131565767);
        FbDraweeView fbDraweeView = (FbDraweeView) findViewById(2131565768);
        if (3 >= immutableList.size()) {
            frameLayout.setVisibility(8);
            return;
        }
        m21782a(fbDraweeView, immutableList, 3);
        if (immutableList.size() > 4) {
            fbTextView.setText("+" + String.valueOf(immutableList.size() - 4));
            fbTextView.setVisibility(0);
            imageView.setVisibility(0);
        } else {
            fbTextView.setVisibility(8);
            imageView.setVisibility(8);
        }
        frameLayout.setVisibility(0);
        fbDraweeView.setVisibility(0);
        imageView.bringToFront();
        fbTextView.bringToFront();
    }
}
