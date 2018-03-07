package com.facebook.debug.connection;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.facebook.http.observer.ConnectionQuality;

/* compiled from: inline_action_join_group_click */
public class ConnectionView extends View {
    private final ConnectionViewController f10824a;
    private Paint f10825b;
    private final int f10826c = 10;
    private final int f10827d = 5;
    private final int f10828e = 20;
    private final int f10829f = 16;
    private final int f10830g = 19;
    private final int f10831h = 14;
    private final int f10832i = 30;

    public ConnectionView(Context context, ConnectionViewController connectionViewController) {
        super(context);
        this.f10824a = connectionViewController;
        setBackgroundDrawable(new ColorDrawable(getResources().getColor(17170445)));
        this.f10825b = new Paint();
    }

    protected void onDraw(Canvas canvas) {
        int a;
        super.onDraw(canvas);
        Paint paint = this.f10825b;
        ConnectionViewController connectionViewController = this.f10824a;
        if (connectionViewController.f != ConnectionQuality.UNKNOWN) {
            a = ConnectionViewController.a(connectionViewController.f);
        } else if (connectionViewController.g == ConnectionQuality.UNKNOWN) {
            a = ConnectionViewController.a(connectionViewController.g);
        } else {
            a = (ConnectionViewController.a(connectionViewController.g) & 16777215) | 1996488704;
        }
        paint.setColor(a);
        canvas.drawRect(10.0f, 5.0f, 30.0f, 25.0f, this.f10825b);
        this.f10825b.setColor(ConnectionViewController.a(this.f10824a.h));
        canvas.drawRect(40.0f, 5.0f, 60.0f, 25.0f, this.f10825b);
        paint = this.f10825b;
        if (this.f10824a.i) {
            a = -16711936;
        } else {
            a = -65536;
        }
        paint.setColor(a);
        canvas.drawRect(70.0f, 5.0f, 90.0f, 25.0f, this.f10825b);
        this.f10825b.setColor(-16777216);
        this.f10825b.setTextSize(14.0f);
        canvas.drawText("B", 16.0f, 19.0f, this.f10825b);
        canvas.drawText("L", 46.0f, 19.0f, this.f10825b);
        canvas.drawText("C", 76.0f, 19.0f, this.f10825b);
    }
}
