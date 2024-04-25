package com.my.darshan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
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
import java.util.HashMap;
import java.util.ArrayList;
import android.widget.ScrollView;
import android.widget.LinearLayout;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import android.content.Intent;
import android.net.Uri;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class RegisterDocActivity extends AppCompatActivity {
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private HashMap<String, Object> map = new HashMap<>();
	private String cod = "";
	private String specification = "";
	
	private ArrayList<String> specifications = new ArrayList<>();
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private LinearLayout linear3;
	private LinearLayout linear7;
	private LinearLayout linear8;
	private LinearLayout linear2;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private Button button1;
	private EditText username;
	private EditText phone;
	private Spinner spinner1;
	private EditText address;
	private EditText email;
	private EditText password;
	
	private FirebaseAuth fauth_d;
	private OnCompleteListener<Void> fauth_d_updateEmailListener;
	private OnCompleteListener<Void> fauth_d_updatePasswordListener;
	private OnCompleteListener<Void> fauth_d_emailVerificationSentListener;
	private OnCompleteListener<Void> fauth_d_deleteUserListener;
	private OnCompleteListener<Void> fauth_d_updateProfileListener;
	private OnCompleteListener<AuthResult> fauth_d_phoneAuthListener;
	private OnCompleteListener<AuthResult> fauth_d_googleSignInListener;
	private OnCompleteListener<AuthResult> _fauth_d_create_user_listener;
	private OnCompleteListener<AuthResult> _fauth_d_sign_in_listener;
	private OnCompleteListener<Void> _fauth_d_reset_password_listener;
	private Intent i = new Intent();
	private DatabaseReference doctor = _firebase.getReference("doctor");
	private ChildEventListener _doctor_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.register_doc);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_app_bar = (AppBarLayout) findViewById(R.id._app_bar);
		_coordinator = (CoordinatorLayout) findViewById(R.id._coordinator);
		_toolbar = (Toolbar) findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		button1 = (Button) findViewById(R.id.button1);
		username = (EditText) findViewById(R.id.username);
		phone = (EditText) findViewById(R.id.phone);
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		address = (EditText) findViewById(R.id.address);
		email = (EditText) findViewById(R.id.email);
		password = (EditText) findViewById(R.id.password);
		fauth_d = FirebaseAuth.getInstance();
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (address.getText().toString().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Enter address");
				}
				else {
					if (username.getText().toString().equals("")) {
						SketchwareUtil.showMessage(getApplicationContext(), "Enter username");
					}
					else {
						if (phone.getText().toString().equals("")) {
							SketchwareUtil.showMessage(getApplicationContext(), "Enter phone");
						}
						else {
							if (email.getText().toString().equals("")) {
								SketchwareUtil.showMessage(getApplicationContext(), "Enter email");
							}
							else {
								if (password.getText().toString().equals("")) {
									SketchwareUtil.showMessage(getApplicationContext(), "Enter password");
								}
								else {
									if (specifications.get((int)(spinner1.getSelectedItemPosition())).equals("")) {
										SketchwareUtil.showMessage(getApplicationContext(), "Select Specification");
									}
									else {
										fauth_d.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(RegisterDocActivity.this, _fauth_d_create_user_listener);
									}
								}
							}
						}
					}
				}
			}
		});
		
		_doctor_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		doctor.addChildEventListener(_doctor_child_listener);
		
		fauth_d_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_d_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_d_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_d_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_d_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task){
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		fauth_d_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_d_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task){
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_fauth_d_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				if (_success) {
					map = new HashMap<>();
					map.put("username", "Dr. ".concat(username.getText().toString()));
					map.put("phone", phone.getText().toString());
					map.put("email", email.getText().toString());
					map.put("password", password.getText().toString());
					map.put("address", address.getText().toString());
					map.put("fees", "500 Rs");
					map.put("pic", "");
					map.put("verification", "false");
					map.put("specification", specifications.get((int)(spinner1.getSelectedItemPosition())));
					map.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
					doctor.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(map);
					map.clear();
					finish();
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), _errorMessage);
				}
			}
		};
		
		_fauth_d_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_fauth_d_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		cod = "1234";
		_ARGMaterialEditText(linear2, address, "Enter Address", "Address");
		_ARGMaterialEditText(linear3, username, "Enter Username", "Username");
		_ARGMaterialEditText(linear7, phone, "Enter Phone", "Phone");
		_ARGMaterialEditText(linear4, email, "Enter Email", "Email");
		_ARGMaterialEditText(linear5, password, "Enter Password", "Password");
		specifications.add("specification");
		specifications.add("Cardiologist");
		specifications.add("Dermatologist");
		specifications.add("Neurologist");
		specifications.add("Oncologist");
		specifications.add("Ophthalmologist");
		specifications.add("Otolaryngologist");
		specifications.add("Radiologist");
		specifications.add("Nephrologist");
		spinner1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, specifications));
		((ArrayAdapter)spinner1.getAdapter()).notifyDataSetChanged();
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