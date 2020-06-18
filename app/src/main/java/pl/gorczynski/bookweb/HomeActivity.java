package pl.gorczynski.bookweb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button_next);
        setTitle("Strona Główna");
        drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.Open,R.string.Close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final NavigationView nav_view = (NavigationView)findViewById(R.id.nav_view);

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawer(GravityCompat.START);
                int id = item.getItemId();
                if(id == R.id.item1) {
                    Toast.makeText(HomeActivity.this, "BookWeb", Toast.LENGTH_SHORT).show();
                }
                if(id == R.id.item2) {
                    Toast.makeText(HomeActivity.this, "Matematyka", Toast.LENGTH_SHORT).show();
                }
                if(id == R.id.item3) {
                    Toast.makeText(HomeActivity.this, "Informatyka", Toast.LENGTH_SHORT).show();
                }
                if(id == R.id.item4) {
                    Toast.makeText(HomeActivity.this, "Elektronika", Toast.LENGTH_SHORT).show();
                }
                if(id == R.id.item5){
                    Intent intent = new Intent(HomeActivity.this,BooksListActivity.class);
                    startActivity(intent);
                }


                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


    public void button_goNext(MenuItem item) {
        Intent intent = new Intent(this, AboutProgramActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.share){
            String promotion = "Moja nowa aplikacja już dostępna!";
            Intent shareIntent = new Intent();
            shareIntent.setType("text/plain");
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_TEXT, promotion);
            startActivity(Intent.createChooser(shareIntent,"Udostępnij!"));
        }

        return actionBarDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);

    }



    public void goNext(View view) {
        drawerLayout.openDrawer(GravityCompat.START);
    }



}
