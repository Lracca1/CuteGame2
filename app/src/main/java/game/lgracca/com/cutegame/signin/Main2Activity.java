package game.lgracca.com.cutegame.signin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import game.lgracca.com.cutegame.R;

public class Main2Activity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main2);
    TextView displayName = findViewById(R.id.display_name);
    displayName.setText(getSignInApplication().getSignInAccount().getDisplayName());
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.options, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.action_logout:
        signOut();
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }

  private void signOut() {
    getSignInApplication().getSignInClient().signOut()
        .addOnCompleteListener(this, new OnCompleteListener<Void>() {
          @Override
          public void onComplete(@NonNull Task<Void> task) {
            getSignInApplication().setSignInAccount(null);
            Intent intent = new Intent(Main2Activity.this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
          }
        });
  }
  private SignInApplication getSignInApplication() {
    return (SignInApplication) getApplication();
  }

}
