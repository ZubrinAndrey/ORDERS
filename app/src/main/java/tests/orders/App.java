package tests.orders;

import android.app.Application;
import android.widget.Toast;


public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "NEW APP CREATED", Toast.LENGTH_SHORT).show();
    }


}
