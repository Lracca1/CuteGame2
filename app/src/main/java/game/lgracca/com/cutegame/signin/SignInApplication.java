package game.lgracca.com.cutegame.signin;

import android.app.Application;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/**
 * SignInApplication class extends Application and consists of an override onCreate method.
 */
public class SignInApplication extends Application {

  private GoogleSignInClient signInClient;
  private GoogleSignInAccount signInAccount;

  /**
   *
   * @return returns the signInClient
   */
  public GoogleSignInClient getSignInClient() {
    return signInClient;
  }

  /**
   *
   * @param signInClient a setter for the signInClient.
   */
  public void setSignInClient(GoogleSignInClient signInClient) {
    this.signInClient = signInClient;
  }

  /**
   *
   * @return returns the signInAccount.
   */
  public GoogleSignInAccount getSignInAccount() {
    return signInAccount;
  }

  /**
   *
   * @param signInAccount a setter for the signInAccount.
   */
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
