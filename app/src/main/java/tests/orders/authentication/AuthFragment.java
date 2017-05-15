package tests.orders.authentication;

import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tests.orders.R;
import tests.orders.orderlist.OrderListActivity;

public class AuthFragment extends Fragment {

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
        View view = inflater.inflate(R.layout.fragment_auth, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.button2)
    public void login(View view) {
        String login = this.login.getText().toString();
        String password = this.password.getText().toString();

        if (checkWithRegExp(login))
            startActivity(OrderListActivity.newInstance(getActivity(), login));
        else
            Snackbar.make(view, R.string.exception_wrong_login_and_password, Snackbar.LENGTH_LONG).show();
    }

    public static boolean checkWithRegExp(String userNameString){
        Pattern p = Pattern.compile(".+@.+\\.(com|ru)");
        Matcher m = p.matcher(userNameString);
        return m.matches();
    }
}
