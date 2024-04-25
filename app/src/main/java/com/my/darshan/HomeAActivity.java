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
import java.util.HashMap;
import android.widget.ScrollView;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class HomeAActivity extends AppCompatActivity {
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> map = new HashMap<>();
	
	private ScrollView vscroll2;
	private LinearLayout linear14;
	private ImageView imageview7;
	private TextView textview11;
	private LinearLayout linear1;
	private LinearLayout linear5;
	private LinearLayout linear15;
	private TextView textview9;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private ImageView imageview1;
	private TextView textview1;
	private ImageView imageview2;
	private TextView textview2;
	private LinearLayout linear6;
	private LinearLayout linear18;
	private ImageView imageview3;
	private TextView textview3;
	private ImageView imageview8;
	private TextView textview10;
	private LinearLayout linear17;
	private ImageView imageview6;
	private TextView textview8;
	
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
	private DatabaseReference user = _firebase.getReference("user");
	private ChildEventListener _user_child_listener;
	private Intent i = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.home_a);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		vscroll2 = (ScrollView) findViewById(R.id.vscroll2);
		linear14 = (LinearLayout) findViewById(R.id.linear14);
		imageview7 = (ImageView) findViewById(R.id.imageview7);
		textview11 = (TextView) findViewById(R.id.textview11);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear15 = (LinearLayout) findViewById(R.id.linear15);
		textview9 = (TextView) findViewById(R.id.textview9);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview1 = (TextView) findViewById(R.id.textview1);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		textview2 = (TextView) findViewById(R.id.textview2);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		linear18 = (LinearLayout) findViewById(R.id.linear18);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		textview3 = (TextView) findViewById(R.id.textview3);
		imageview8 = (ImageView) findViewById(R.id.imageview8);
		textview10 = (TextView) findViewById(R.id.textview10);
		linear17 = (LinearLayout) findViewById(R.id.linear17);
		imageview6 = (ImageView) findViewById(R.id.imageview6);
		textview8 = (TextView) findViewById(R.id.textview8);
		fauth = FirebaseAuth.getInstance();
		
		textview9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FirebaseAuth.getInstance().signOut();
				i.setClass(getApplicationContext(), LoginActivity.class);
				startActivity(i);
			}
		});
		
		linear3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), ManageUserActivity.class);
				startActivity(i);
			}
		});
		
		linear4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), ManageDoctorActivity.class);
				startActivity(i);
			}
		});
		
		linear6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), AllAppointmentActivity.class);
				startActivity(i);
			}
		});
		
		linear18.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), AllPercificationActivity.class);
				startActivity(i);
			}
		});
		
		linear17.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), "please wait");
				shareApplication();
			}
		});
		
		_user_child_listener = new ChildEventListener() {
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
		user.addChildEventListener(_user_child_listener);
		
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
		_SetBackground(linear3, 25, 100, "#4DB6AC", true);
		_SetBackground(linear4, 25, 100, "#4DB6AC", true);
		_SetBackground(linear6, 25, 100, "#4DB6AC", true);
		_SetBackground(linear17, 25, 100, "#4DB6AC", true);
		_SetBackground(linear18, 25, 100, "#4DB6AC", true);
		StrictMode.VmPolicy.Builder builder = 
		    new StrictMode.VmPolicy.Builder(); 
		    StrictMode.setVmPolicy(builder.build());
		    if(Build.VERSION.SDK_INT>=24){ 
			         try{
				        java.lang.reflect.Method m = 
				              StrictMode.class.getMethod(
				        "disableDeathOnFileUriExposure"); 
				              m.invoke(null); 
				       }
			      catch(Exception e){ 
				        showMessage(e.toString()); 
				       } 
			    }
		_MarqueTextView(textview11, "Hello ".concat("  Welcome to Hospital Management System😊"));
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		finishAffinity();
	}
	public void _SetBackground (final View _view, final double _radius, final double _shadow, final String _color, final boolean _ripple) {
		if (_ripple) {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			_view.setElevation((int)_shadow);
			android.content.res.ColorStateList clrb = new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{Color.parseColor("#9e9e9e")});
			android.graphics.drawable.RippleDrawable ripdrb = new android.graphics.drawable.RippleDrawable(clrb , gd, null);
			_view.setClickable(true);
			_view.setBackground(ripdrb);
		}
		else {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			_view.setBackground(gd);
			_view.setElevation((int)_shadow);
		}
	}
	
	
	public void _share () {
	}
	private void shareApplication() { 
		      android.content.pm.ApplicationInfo app = 
		      getApplicationContext().getApplicationInfo(); 
		      String filePath = app.sourceDir;
		      Intent intent = new Intent(Intent.ACTION_SEND); 
		      intent.setType("*/*"); 
		      java.io.File originalApk = new java.io.File(filePath); 
		      try {  
			        java.io.File tempFile = new java.io.File(getExternalCacheDir() + "/ExtractedApk"); 
			         if (!tempFile.isDirectory()) 
			         if (!tempFile.mkdirs()) 
			         return; 
			         tempFile = new java.io.File(tempFile.getPath() + "/" + 
			         "export.apk");
			         if (!tempFile.exists()) 
			          {
				           try{
					             if (!tempFile.createNewFile()) { 
						               return; }
					            }
				           catch (java.io.IOException e){} 
				          } 
			         java.io.InputStream in = new java.io.FileInputStream (originalApk);
			         java.io.OutputStream out = new java.io.FileOutputStream(tempFile);
			         byte[] buf = new byte[1024];
			         int len; 
			         while ((len = in.read(buf)) > 0) { 
				            out.write(buf, 0, len); 
				         } 
			         in.close(); 
			         out.close(); 
			         intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(tempFile));
			         startActivity(Intent.createChooser(intent, "Share app via"));
			      } 
		      catch (java.io.IOException e) 
		      { showMessage(e.toString()); 
			      } 
		   }
	{
	}
	
	
	public void _MarqueTextView (final TextView _view, final String _text) {
		_view.setText(_text);
		_view.setSingleLine(true);
		_view.setEllipsize(TextUtils.TruncateAt.MARQUEE);
		_view.setSelected(true);
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