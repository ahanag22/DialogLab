package tcss450.uw.edu.dialoglab_ahana;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DialogActivity extends AppCompatActivity implements FireMissilesDialogFragment.OnFragmentInteractionListener,
        ListDialogFragment.OnFragmentInteractionListener, MultiListDialogFragment.OnFragmentInteractionListener,CustomDialogFragment.OnFragmentInteractionListener,
        TimePickerDialogFragment.OnFragmentInteractionListener,DatePickerDialogFragment.OnFragmentInteractionListener
{

    NotificationCompat.Builder notification;
    public static final int UNIQUEID = 45612;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        notification = new NotificationCompat.Builder(this);
        notification.setWhen(System.currentTimeMillis());
        notification.setAutoCancel(true);
    }
    public void launch(View v) {
        DialogFragment fragment = null;
        if (v.getId() == R.id.fire_missiles_button) {
            fragment = new FireMissilesDialogFragment();
        } else if (v.getId() == R.id.list_button) {
            fragment = new ListDialogFragment();
        } else if (v.getId() == R.id.multi_list_button) {
            fragment = new MultiListDialogFragment();
        } else if (v.getId() == R.id.custom_button) {
            fragment = new CustomDialogFragment();
        } else if (v.getId() == R.id.time_button) {
            fragment = new TimePickerDialogFragment();
        } else if (v.getId() == R.id.date_button) {
            fragment = new DatePickerDialogFragment();
        }
        else if (v.getId() == R.id.notice){
            notification.setSmallIcon(R.mipmap.ic_launcher);
            notification.setContentTitle("Notification Title");
            notification.setContentText("Notification Content");
            Intent intent = new Intent(this, DialogActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            notification.setContentIntent(pendingIntent);
            NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            nm.notify(UNIQUEID,notification.build());
        }
        if (fragment != null)
            fragment.show(getSupportFragmentManager(), "launch");
    }

    





    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
