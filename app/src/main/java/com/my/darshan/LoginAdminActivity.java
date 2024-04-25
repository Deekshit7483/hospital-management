package com.my.darshan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class LoginAdminActivity extends AppCompatActivity {
	
	private String code = "";
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private ImageView imageview2;
	private TextView textview1;
	private LinearLayout linear7;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private Button button1;
	private ImageView imageview5;
	private EditText codes;
	private ImageView imageview3;
	private EditText email;
	private ImageView imageview4;
	private EditText password;
	
	private FirebaseAuth fauth;
	private OnCompleteListener<Void> fauth_updateEmailListener;
	private OnCompleteListener<Void> fauth_updatePasswordListener;
	private OnCompleteListener<Void> fauth_emailVerificationSentListener;
	private OnCompleteListener<Void> fauth_deleteUserListener;
	private OnCompleteListener<Void> fauth_updateProfileListener;
	private OnCompleteListener<AuthResult> fauth_phoneAuthListener;
	private OnCompleteListener<AuthResult> fauth_googleSignInListener;
	private OnCompleteListener<AuthResult> _fauth_create_user_listener;
	private OnCompleteListener<AuthResult> _fauth_sign_in_listener;
	private OnCompleteListener<Void> _fauth_reset_password_listener;
	private Intent i = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.login_admin);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		textview1 = (TextView) findViewById(R.id.textview1);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		button1 = (Button) findViewById(R.id.button1);
		imageview5 = (ImageView) findViewById(R.id.imageview5);
		codes = (EditText) findViewById(R.id.codes);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		email = (EditText) findViewById(R.id.email);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		password = (EditText) findViewById(R.id.password);
		fauth = FirebaseAuth.getInstance();
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (email.getText().toString().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "enter email");
				}
				else {
					if (password.getText().toString().equals("")) {
						SketchwareUtil.showMessage(getApplicationContext(), "enter password");
					}
					else {
						if (!codes.getText().toString().equals("")) {
							if (code.equals("")) {
								SketchwareUtil.showMessage(getApplicationContext(), "invalid code");
							}
							else {
								if (codes.getText().toString().equals(code)) {
									fauth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(LoginAdminActivity.this, _fauth_sign_in_listener);
								}
								else {
									SketchwareUtil.showMessage(getApplicationContext(), "invalid code");
								}
							}
						}
						else {
							SketchwareUtil.showMessage(getApplicationContext(), "enter code");
						}
					}
				}
			}
		});
		
		fauth_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task){
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		fauth_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task){
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_fauth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_fauth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				if (_success) {
					i.setClass(getApplicationContext(), HomeAActivity.class);
					startActivity(i);
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), _errorMessage);
				}
			}
		};
		
		_fauth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		code = "9844";
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _ARGMaterialEditText (final View _linear, final TextView _edittext, final String _hint, final String _name) {
		((LinearLayout)_linear).removeView(_edittext); 
		final com.google.android.material.textfield.TextInputLayout _nme = new com.google.android.material.textfield.TextInputLayout (this);
		 _nme.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)); 
		
		 _nme.setPadding((int)getDip(2), (int)getDip(2) , (int)getDip(2) , (int)getDip(2) );
		_nme.setGravity(Gravity.CENTER);
		_nme.setHintEnabled(true);
		_nme.setHint(_hint);
		_nme.setBoxBackgroundMode(_nme.BOX_BACKGROUND_OUTLINE); 
		_nme.setBoxStrokeColor(0xFF212121);
		_nme.setBoxCornerRadii(5, 5, 5, 5);
		_nme.setErrorEnabled(true);
		_nme.setHintAnimationEnabled(true);
		
		_nme.addView(_edittext);
		 ((LinearLayout)_linear).addView(_nme);
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}