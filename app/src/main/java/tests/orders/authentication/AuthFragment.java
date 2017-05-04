package tests.orders.authentication;

import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tests.orders.R;
import tests.orders.orderlist.OrderListActivity;

public class AuthFragment extends Fragment {

    private static final String TEST_LOGIN = "Tester";
    private static final String TEST_PASSWORD = "12345";

    @BindView(R.id.login)
    EditText login;

    @BindView(R.id.password)
    EditText password;

    public static AuthFragment newInstance() {
        return new AuthFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_auth, container, false);

        ButterKnife.bind(this, v);

        return v;
    }

    @OnClick(R.id.button2)
    public void login(View view) {
        String login = this.login.getText().toString();
        String password = this.password.getText().toString();

        if (login.equals(TEST_LOGIN) && password.equals(TEST_PASSWORD))
            startActivity(OrderListActivity.newInstance(getActivity(), login));
        else
            Snackbar.make(view, R.string.exception_wrong_login_and_password, Snackbar.LENGTH_LONG).show();
    }
}
