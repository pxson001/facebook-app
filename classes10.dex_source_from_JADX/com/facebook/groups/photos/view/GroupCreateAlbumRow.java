package com.facebook.groups.photos.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.groups.photos.fragment.GroupAlbumsFragment;
import com.facebook.groups.photos.fragment.GroupAlbumsFragment.C33181;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.composer.intent.ComposerTargetData.Builder;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.albumcreator.AlbumCreatorIntentBuilder;
import com.facebook.photos.albumcreator.AlbumCreatorSourceType;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

/* compiled from: TITLE_BUTTON */
public class GroupCreateAlbumRow extends CustomLinearLayout {
    @Inject
    public Resources f23102a;
    @Inject
    public GroupPhotosDefaultViewFactory f23103b;
    public ImageView f23104c;
    public final Paint f23105d = new Paint(1);
    public float f23106e;
    public float f23107f;

    /* compiled from: TITLE_BUTTON */
    public class C33301 implements OnClickListener {
        final /* synthetic */ C33181 f23100a;
        final /* synthetic */ GroupCreateAlbumRow f23101b;

        public C33301(GroupCreateAlbumRow groupCreateAlbumRow, C33181 c33181) {
            this.f23101b = groupCreateAlbumRow;
            this.f23100a = c33181;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 921020574);
            GroupAlbumsFragment groupAlbumsFragment = this.f23100a.f23003a;
            AlbumCreatorIntentBuilder albumCreatorIntentBuilder = (AlbumCreatorIntentBuilder) groupAlbumsFragment.f23012f.get();
            AlbumCreatorSourceType albumCreatorSourceType = AlbumCreatorSourceType.ALBUMSTAB;
            Builder builder = new Builder();
            builder.a = Long.parseLong(groupAlbumsFragment.f23013g);
            builder = builder;
            builder.b = TargetType.GROUP;
            groupAlbumsFragment.f23009c.a(albumCreatorIntentBuilder.a(albumCreatorSourceType, null, builder.a()), 1991, groupAlbumsFragment);
            Logger.a(2, EntryType.UI_INPUT_END, 110072285, a);
        }
    }

    public static void m24418a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        GroupCreateAlbumRow groupCreateAlbumRow = (GroupCreateAlbumRow) obj;
        Resources a = ResourcesMethodAutoProvider.a(fbInjector);
        GroupPhotosDefaultViewFactory b = GroupPhotosDefaultViewFactory.m24419b(fbInjector);
        groupCreateAlbumRow.f23102a = a;
        groupCreateAlbumRow.f23103b = b;
    }

    public GroupCreateAlbumRow(Context context) {
        super(context);
        Class cls = GroupCreateAlbumRow.class;
        m24418a(this, getContext());
        setOrientation(0);
        setContentView(2130904648);
        setVisibility(8);
        setBackgroundDrawable(this.f23102a.getDrawable(2130840707));
        this.f23104c = (ImageView) a(2131562650);
        ImageView imageView = this.f23104c;
        Drawable mutate = this.f23103b.m24422e().mutate();
        mutate.setColorFilter(new PorterDuffColorFilter(this.f23102a.getColor(2131363508), Mode.SRC_ATOP));
        imageView.setImageDrawable(mutate);
        this.f23105d.setColor(this.f23102a.getColor(2131363505));
        this.f23105d.setStyle(Style.FILL);
        this.f23106e = this.f23102a.getDimension(2131431925);
        this.f23107f = this.f23102a.getDimension(2131431927);
        setWillNotDraw(false);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Canvas canvas2 = canvas;
        canvas2.drawRect(this.f23106e, ((float) getHeight()) - this.f23107f, ((float) getWidth()) - this.f23106e, (float) getHeight(), this.f23105d);
    }
}
