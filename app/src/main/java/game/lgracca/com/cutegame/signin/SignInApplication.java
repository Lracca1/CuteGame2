package game.lgracca.com.cutegame.signin;

import android.app.Application;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class SignInApplication extends Application {

  private GoogleSignInClient signInClient;
  private GoogleSignInAccount signInAccount;

  public GoogleSignInClient getSignInClient() {
    return signInClient;
  }

  public void setSignInClient(GoogleSignInClient signInClient) {
    this.signInClient = signInClient;
  }

  public GoogleSignInAccount getSignInAccount() {
    return signInAccount;
  }

  public void setSignInAccount(GoogleSignInAccount signInAccount) {
    this.signInAccount = signInAccount;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    GoogleSignInOptions options = new GoogleSignInOptions.Builder()
        .requestEmail()

        .requestId()
        .requestIdToken("905201496362-tsalaekjqu9rceq5entkdag6iteum3t6.apps.googleusercontent.com")
        .build();
    signInClient = GoogleSignIn.getClient(this,options);

  }
}
