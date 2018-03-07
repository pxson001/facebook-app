package gifdrawable.pl.droidsonroids.gif;

/* compiled from: qr_code_image_url */
class GifDrawable$5 implements Runnable {
    final /* synthetic */ int f6852a;
    final /* synthetic */ GifDrawable f6853b;

    GifDrawable$5(GifDrawable gifDrawable, int i) {
        this.f6853b = gifDrawable;
        this.f6852a = i;
    }

    public void run() {
        GifDrawable.seekToTime(this.f6853b.c, this.f6852a, this.f6853b.j);
        this.f6853b.invalidateSelf();
    }
}
