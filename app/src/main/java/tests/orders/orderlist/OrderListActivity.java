package tests.orders.orderlist;

import android.app.AlertDialog;
import android.app.FragmentManager;
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
import static tests.orders.R.id.nav_view2;

public class OrderListActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    public static final String KEY_LOGIN = "login";

    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    public static Intent newInstance(Context context, String login) {
        Intent intent = new Intent(context, OrderListActivity.class);
        intent.putExtra(KEY_LOGIN, login);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_oderslist);

        setTitle(R.string.order_list_title);

        mFragmentManager = getFragmentManager();
        OrderListFragment orderListFragment = new OrderListFragment();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.add(R.id.container2, orderListFragment);
        mFragmentTransaction.commit();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout2);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView) findViewById(nav_view2);
        navigationView.setNavigationItemSelectedListener(this);

        View header = navigationView.getHeaderView(0);
        TextView textUserName = (TextView)header.findViewById(R.id.textUserName);
        textUserName.setText(getIntent().getStringExtra(KEY_LOGIN));
    }

    @Override
    public void onBackPressed() {
        openQuitDialog();
    }

    private void openQuitDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Выход: Вы уверены?")
                .setPositiveButton("Да!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("Нет!", null)
                .show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_account) {
            Toast.makeText(this, "MY ACCOUNT", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_settings) {
            Toast.makeText(this, "SETTINGS", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_logout) {
            Intent intent = new Intent(this, AuthActivity.class);
            intent.addFlags(FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            Toast.makeText(this, "LOGOUT", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout2);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}