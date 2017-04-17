package tests.orders;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AuthActivity extends AppCompatActivity {
    @BindView(R.id.login)    EditText login;
    @BindView(R.id.button2)    Button button2;
    @BindView(R.id.password)    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        ButterKnife.bind(this);

        setTitle(R.string.auth_title);
    }

    @OnClick(R.id.button2)
    public void login(View view) {
        String log = login.getText().toString();
        String pas = password.getText().toString();

        if (log.equals("Tester") && pas.equals("12345")) {
            Intent intent = new Intent(this, OrdersListActivity.class);
            intent.putExtra("login", log);
            startActivity(intent);
        } else {
            Snackbar.make(view, "Введите верный логин и пароль", Snackbar.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
     //   finish();
    }
}


