package tests.orders.authentication;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tests.orders.orderlist.OrderListActivity;
import tests.orders.R;

public class AuthActivity extends AppCompatActivity {

    private static final String TEST_LOGIN = "Tester";
    private static final String TEST_PASSWORD = "12345";

    @BindView(R.id.login)
    EditText login;

    @BindView(R.id.password)
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_auth);

        ButterKnife.bind(this);

        setTitle(R.string.auth_title);
    }

    @OnClick(R.id.button2)
    public void login(View view) {
        String login = this.login.getText().toString();
        String password = this.password.getText().toString();

        if (login.equals(TEST_LOGIN) && password.equals(TEST_PASSWORD))
            startActivity(OrderListActivity.newInstance(this, login));
        else
            Snackbar.make(view, R.string.exception_wrong_login_and_password, Snackbar.LENGTH_LONG).show();
    }
}


