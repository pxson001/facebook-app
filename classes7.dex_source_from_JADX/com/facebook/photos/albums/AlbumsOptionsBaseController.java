package com.facebook.photos.albums;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.StringUtil;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.albums.events.AlbumsEventBus;
import com.facebook.photos.albums.events.AlbumsEvents.AlbumDeletedEvent;
import com.facebook.photos.albums.events.AlbumsEvents.AlbumTitleRenamedEvent;
import com.facebook.photos.data.method.DeletePhotoAlbumParams;
import com.facebook.photos.futures.PhotosFuturesGenerator;
import com.facebook.resources.ui.FbEditText;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.keyboard.KeyboardUtils;
import javax.inject.Provider;

/* compiled from: marginBottom */
public class AlbumsOptionsBaseController {
    public final Provider<Context> f9333a;
    public final GraphQLAlbum f9334b;
    protected ProgressDialog f9335c;
    protected ProgressDialog f9336d;
    protected final AlbumsEventBus f9337e;
    protected final PhotosFuturesGenerator f9338f;
    protected final TasksManager f9339g;

    public AlbumsOptionsBaseController(Provider<Context> provider, GraphQLAlbum graphQLAlbum, AlbumsEventBus albumsEventBus, PhotosFuturesGenerator photosFuturesGenerator, TasksManager tasksManager) {
        this.f9333a = provider;
        this.f9334b = graphQLAlbum;
        this.f9337e = albumsEventBus;
        this.f9338f = photosFuturesGenerator;
        this.f9339g = tasksManager;
    }

    public final void m11337a() {
        View inflate = LayoutInflater.from(m11339b()).inflate(2130903235, null);
        final FbEditText fbEditText = (FbEditText) inflate.findViewById(2131559551);
        fbEditText.setText(this.f9334b.E().a());
        fbEditText.setSelection(this.f9334b.E().a().length());
        fbEditText.setTextColor(m11339b().getResources().getColor(2131361848));
        final AlertDialog a = new Builder(m11339b()).a(2131234359).b(inflate).a(2131234358, null).b(2131234361, null).a();
        a.setOnShowListener(new OnShowListener(this) {
            final /* synthetic */ AlbumsOptionsBaseController f9323b;

            public void onShow(DialogInterface dialogInterface) {
                KeyboardUtils.b(this.f9323b.m11339b(), fbEditText);
            }
        });
        a.show();
        a.a(-1).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AlbumsOptionsBaseController f9328c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -100162172);
                final String obj = fbEditText.getText().toString();
                if (StringUtil.c(obj)) {
                    Toast.makeText(this.f9328c.m11339b(), 2131234363, 1).show();
                    Logger.a(2, EntryType.UI_INPUT_END, 1650333086, a);
                } else if (obj.equals(this.f9328c.f9334b.E().a())) {
                    a.dismiss();
                    LogUtils.a(-1742169109, a);
                } else {
                    this.f9328c.f9335c = new ProgressDialog(this.f9328c.m11339b());
                    this.f9328c.f9335c.d = 0;
                    this.f9328c.f9335c.a(this.f9328c.m11339b().getResources().getText(2131234362));
                    this.f9328c.f9335c.a(true);
                    this.f9328c.f9335c.setCancelable(false);
                    this.f9328c.f9335c.show();
                    this.f9328c.f9339g.a("tasks-renamePhotoAlbum:" + this.f9328c.f9334b.u(), this.f9328c.f9338f.m12393a(this.f9328c.f9334b.u(), obj), new AbstractDisposableFutureCallback<OperationResult>(this) {
                        final /* synthetic */ C07572 f9325b;

                        protected final void m11333a(Object obj) {
                            AlbumsEventBus albumsEventBus = this.f9325b.f9328c.f9337e;
                            GraphQLTextWithEntities.Builder builder = new GraphQLTextWithEntities.Builder();
                            builder.i = obj;
                            albumsEventBus.a(new AlbumTitleRenamedEvent(builder.a()));
                            this.f9325b.f9328c.f9335c.dismiss();
                            this.f9325b.f9328c.f9335c = null;
                        }

                        protected final void m11334a(Throwable th) {
                            this.f9325b.f9328c.f9335c.dismiss();
                            this.f9325b.f9328c.f9335c = null;
                        }
                    });
                    a.dismiss();
                    LogUtils.a(-50111000, a);
                }
            }
        });
    }

    public final void m11338a(final Activity activity) {
        new Builder((Context) this.f9333a.get()).a(m11339b().getResources().getString(2131234384)).b(m11339b().getResources().getString(2131234385, new Object[]{this.f9334b.E().a()})).a(2131234383, new DialogInterface.OnClickListener(this, false) {
            final /* synthetic */ AlbumsOptionsBaseController f9332c;

            /* compiled from: marginBottom */
            class C07581 extends AbstractDisposableFutureCallback<OperationResult> {
                final /* synthetic */ C07593 f9329a;

                C07581(C07593 c07593) {
                    this.f9329a = c07593;
                }

                protected final void m11335a(Object obj) {
                    this.f9329a.f9332c.f9336d.dismiss();
                    this.f9329a.f9332c.f9336d = null;
                    if (activity != null) {
                        Toast.makeText(this.f9329a.f9332c.m11339b(), 2131234388, 0).show();
                        if (false) {
                            activity.onBackPressed();
                            return;
                        }
                        this.f9329a.f9332c.f9337e.a(new AlbumDeletedEvent(this.f9329a.f9332c.f9334b.u()));
                        activity.finish();
                    }
                }

                protected final void m11336a(Throwable th) {
                    this.f9329a.f9332c.f9336d.dismiss();
                    this.f9329a.f9332c.f9336d = null;
                }
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f9332c.f9336d = new ProgressDialog(this.f9332c.m11339b());
                this.f9332c.f9336d.d = 0;
                this.f9332c.f9336d.a(this.f9332c.m11339b().getResources().getText(2131234387));
                this.f9332c.f9336d.a(true);
                this.f9332c.f9336d.setCancelable(false);
                this.f9332c.f9336d.show();
                C07581 c07581 = new C07581(this);
                TasksManager tasksManager = this.f9332c.f9339g;
                String str = "tasks-deletePhotoAlbum:" + this.f9332c.f9334b.u();
                PhotosFuturesGenerator photosFuturesGenerator = this.f9332c.f9338f;
                String u = this.f9332c.f9334b.u();
                Bundle bundle = new Bundle();
                bundle.putParcelable("deletePhotoAlbumParams", new DeletePhotoAlbumParams(u));
                tasksManager.a(str, BlueServiceOperationFactoryDetour.a(photosFuturesGenerator.f10532a, "delete_photo_album", bundle, -683050567).a(), c07581);
            }
        }).b(2131234386, null).b();
    }

    public final Context m11339b() {
        return (Context) this.f9333a.get();
    }
}
