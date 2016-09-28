package bistu.rookie.u_nity.androidproject_23;

import android.database.ContentObserver;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getContentResolver().registerContentObserver(ContactsContract.Contacts.CONTENT_URI,true,new ContactsObserver(new Handler()));
    }

    private final class ContactsObserver extends ContentObserver {
        public ContactsObserver(Handler handler){
            super(handler);
        }

        @Override
        public void onChange(boolean selfChange) {
            Log.i("MonitorLog", "Something Changed!");
        }
    }

}
