package dlmbg.pckg.notif.read;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NotifReadActivity extends Activity {
	
	@Override
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	public void tampilNotifikasi(View view) {
		NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		Notification notification = new Notification(R.drawable.suse,"Halo mas brow, ente dapat notifikasi dari ane..!!!", System.currentTimeMillis());
		notification.flags |= Notification.FLAG_AUTO_CANCEL;

		Intent intent = new Intent(this, NotificationReceiver.class);
		Bundle b = new Bundle();
		b.putString("pesan", "Halo mas brow, ini notifikasi dari ane. Makasi udah berkunjung ke http://gedelumbung.com.");
		intent.putExtras(b);
		
		PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 0);
		notification.setLatestEventInfo(this, "Notifikasi Dari Gede Lumbung","Klik mas brow, untuk lihat isi pesannya", activity);
		notification.number += 1;
		notificationManager.notify(0, notification);
	}
}
