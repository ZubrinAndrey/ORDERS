package tests.orders.orderdetails;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import tests.orders.R;
import tests.orders.authentication.AuthActivity;
import tests.orders.orderlist.OrderListActivity;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class OrderDetailsActivity extends AppCompatActivity {

//    private FragmentManager mFragmentManager;
//    private FragmentTransaction mFragmentTransaction;
//    private DrawerLayout mDrawerLayout;
//    private ActionBarDrawerToggle mToggle;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_order);
//        ButterKnife.bind(this);
//
//        int position = getIntent().getIntExtra("position", 1);
//        setTitle("Заказ номер " + position + 1);
//
//        mFragmentManager = getFragmentManager();
//        OrderDetailsFragment orderDetailsFragment = new OrderDetailsFragment();
//        mFragmentTransaction = mFragmentManager.beginTransaction();
//        mFragmentTransaction.add(R.id.container3, orderDetailsFragment);
//        mFragmentTransaction.commit();
//
//        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout3);
//        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
//        mDrawerLayout.addDrawerListener(mToggle);
//        mToggle.syncState();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view3);
//        navigationView.setNavigationItemSelectedListener(this);
//
//        View header = navigationView.getHeaderView(0);
//        TextView textUserName = (TextView) header.findViewById(R.id.user_name);
//      //  textUserName.setText(getIntent().getStringExtra(OrderListActivity.KEY_LOGIN));
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (mToggle.onOptionsItemSelected(item)) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//        int id = item.getItemId();
//
//        if (id == R.id.nav_account) {
//
//            Toast.makeText(this, "MY ACCOUNT", Toast.LENGTH_SHORT).show();
//        } else if (id == R.id.nav_settings) {
//            Toast.makeText(this, "SETTINGS", Toast.LENGTH_SHORT).show();
//
//        } else if (id == R.id.nav_logout) {
//            Intent intent = new Intent(this, AuthActivity.class);
//            intent.addFlags(FLAG_ACTIVITY_CLEAR_TASK);
//            intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
//            startActivity(intent);
//            Toast.makeText(this, "LOGOUT", Toast.LENGTH_SHORT).show();
//        }
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout3);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }
}

