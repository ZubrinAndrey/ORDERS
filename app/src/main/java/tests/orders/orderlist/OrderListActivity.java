package tests.orders.orderlist;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import tests.orders.R;
import tests.orders.authentication.AuthActivity;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;
import static tests.orders.R.id.nav_view;

public class OrderListActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = OrderListActivity.class.getSimpleName();
    private static final String KEY_LOGIN = TAG + "login";

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    public static Intent newInstance(Context context, String login) {
        Intent intent = new Intent(context, OrderListActivity.class);
        intent.putExtra(KEY_LOGIN, login);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_order_list);

        createSideMenu();

        setToolbarIcon();

        addFragment(OrderListFragment.newInstance(getIntent().getStringExtra(KEY_LOGIN)));
    }

    private void setToolbarIcon() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void createSideMenu() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setSideMenuHeader(navigationView.getHeaderView(0));
    }

    private void setSideMenuHeader(View header) {
        TextView userName = (TextView) header.findViewById(R.id.user_name);
        userName.setText(getIntent().getStringExtra(KEY_LOGIN));
    }

    public void addFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container, fragment);
        fragmentTransaction.commit();
    }
//
//    @Override
//    public void onBackPressed() {
//        openQuitConfirmationDialog();
//    }
//
//    private void openQuitConfirmationDialog() {
//        new AlertDialog.Builder(this)
//                .setTitle("Выход: Вы уверены?")
//                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        finish();
//                    }
//                })
//                .setNegativeButton("Нет", null)
//                .show();
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);

        switch (item.getItemId()) {
            case R.id.nav_account:
                Toast.makeText(this, "MY ACCOUNT", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_settings:
                Toast.makeText(this, "SETTINGS", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_logout:
                Intent intent = new Intent(this, AuthActivity.class);
                intent.addFlags(FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                Toast.makeText(this, "LOGOUT", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }
}