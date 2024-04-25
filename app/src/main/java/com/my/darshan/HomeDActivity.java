package com.my.darshan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.widget.LinearLayout;
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
import android.widget.ImageView;
import android.widget.TextView;
import de.hdodenhof.circleimageview.*;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import android.view.View;
import com.bumptech.glide.Glide;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class HomeDActivity extends AppCompatActivity {
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private DrawerLayout _drawer;
	private HashMap<String, Object> map = new HashMap<>();
	
	private ScrollView vscroll2;
	private LinearLayout linear14;
	private ImageView imageview5;
	private TextView textview9;
	private LinearLayout linear1;
	private LinearLayout linear5;
	private LinearLayout linear19;
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
	private ImageView imageview6;
	private TextView textview10;
	private LinearLayout linear17;
	private ImageView imageview7;
	private TextView textview8;
	private LinearLayout _drawer_linear1;
	private LinearLayout _drawer_linear2;
	private LinearLayout _drawer_linear10;
	private CircleImageView _drawer_circleimageview1;
	private TextView _drawer_textview1;
	private TextView _drawer_textview2;
	private LinearLayout _drawer_linear3;
	private LinearLayout _drawer_linear4;
	private LinearLayout _drawer_linear6;
	private LinearLayout _drawer_linear7;
	private LinearLayout _drawer_linear8;
	private TextView _drawer_logout;
	private ImageView _drawer_imageview1;
	private TextView _drawer_profile;
	private ImageView _drawer_imageview2;
	private TextView _drawer_manage_appointment;
	private ImageView _drawer_imageview3;
	private TextView _drawer_add_precipitation;
	private ImageView _drawer_imageview4;
	private TextView _drawer_about_us;
	private ImageView _drawer_imageview5;
	private TextView _drawer_contact_us;
	
	private FirebaseAuth fath_d;
	private OnCompleteListener<Void> fath_d_updateEmailListener;
	private OnCompleteListener<Void> fath_d_updatePasswordListener;
	private OnCompleteListener<Void> fath_d_emailVerificationSentListener;
	private OnCompleteListener<Void> fath_d_deleteUserListener;
	private OnCompleteListener<Void> fath_d_updateProfileListener;
	private OnCompleteListener<AuthResult> fath_d_phoneAuthListener;
	private OnCompleteListener<AuthResult> fath_d_googleSignInListener;
	private OnCompleteListener<AuthResult> _fath_d_create_user_listener;
	private OnCompleteListener<AuthResult> _fath_d_sign_in_listener;
	private OnCompleteListener<Void> _fath_d_reset_password_listener;
	private Intent i = new Intent();
	private SharedPreferences profile;
	private AlertDialog.Builder log;
	private DatabaseReference doctor = _firebase.getReference("doctor");
	private ChildEventListener _doctor_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.home_d);
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
		_drawer = (DrawerLayout) findViewById(R.id._drawer);
		ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(HomeDActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		
		LinearLayout _nav_view = (LinearLayout) findViewById(R.id._nav_view);
		
		vscroll2 = (ScrollView) findViewById(R.id.vscroll2);
		linear14 = (LinearLayout) findViewById(R.id.linear14);
		imageview5 = (ImageView) findViewById(R.id.imageview5);
		textview9 = (TextView) findViewById(R.id.textview9);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear19 = (LinearLayout) findViewById(R.id.linear19);
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
		imageview6 = (ImageView) findViewById(R.id.imageview6);
		textview10 = (TextView) findViewById(R.id.textview10);
		linear17 = (LinearLayout) findViewById(R.id.linear17);
		imageview7 = (ImageView) findViewById(R.id.imageview7);
		textview8 = (TextView) findViewById(R.id.textview8);
		_drawer_linear1 = (LinearLayout) _nav_view.findViewById(R.id.linear1);
		_drawer_linear2 = (LinearLayout) _nav_view.findViewById(R.id.linear2);
		_drawer_linear10 = (LinearLayout) _nav_view.findViewById(R.id.linear10);
		_drawer_circleimageview1 = (CircleImageView) _nav_view.findViewById(R.id.circleimageview1);
		_drawer_textview1 = (TextView) _nav_view.findViewById(R.id.textview1);
		_drawer_textview2 = (TextView) _nav_view.findViewById(R.id.textview2);
		_drawer_linear3 = (LinearLayout) _nav_view.findViewById(R.id.linear3);
		_drawer_linear4 = (LinearLayout) _nav_view.findViewById(R.id.linear4);
		_drawer_linear6 = (LinearLayout) _nav_view.findViewById(R.id.linear6);
		_drawer_linear7 = (LinearLayout) _nav_view.findViewById(R.id.linear7);
		_drawer_linear8 = (LinearLayout) _nav_view.findViewById(R.id.linear8);
		_drawer_logout = (TextView) _nav_view.findViewById(R.id.logout);
		_drawer_imageview1 = (ImageView) _nav_view.findViewById(R.id.imageview1);
		_drawer_profile = (TextView) _nav_view.findViewById(R.id.profile);
		_drawer_imageview2 = (ImageView) _nav_view.findViewById(R.id.imageview2);
		_drawer_manage_appointment = (TextView) _nav_view.findViewById(R.id.manage_appointment);
		_drawer_imageview3 = (ImageView) _nav_view.findViewById(R.id.imageview3);
		_drawer_add_precipitation = (TextView) _nav_view.findViewById(R.id.add_precipitation);
		_drawer_imageview4 = (ImageView) _nav_view.findViewById(R.id.imageview4);
		_drawer_about_us = (TextView) _nav_view.findViewById(R.id.about_us);
		_drawer_imageview5 = (ImageView) _nav_view.findViewById(R.id.imageview5);
		_drawer_contact_us = (TextView) _nav_view.findViewById(R.id.contact_us);
		fath_d = FirebaseAuth.getInstance();
		profile = getSharedPreferences("Profile", Activity.MODE_PRIVATE);
		log = new AlertDialog.Builder(this);
		
		linear3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), ProfileDActivity.class);
				startActivity(i);
			}
		});
		
		linear4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), ManageAppointmentActivity.class);
				i.putExtra("button", "true");
				startActivity(i);
			}
		});
		
		linear6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), PrecipitationActivity.class);
				i.putExtra("button", "false");
				startActivity(i);
			}
		});
		
		linear18.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), PercificationActivity.class);
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
		
		_doctor_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					_drawer_textview1.setText(_childValue.get("username").toString());
					_drawer_textview2.setText(_childValue.get("email").toString());
					profile.edit().putString("name", _childValue.get("username").toString()).commit();
					if (_childValue.get("pic").toString().equals("")) {
						_drawer_circleimageview1.setImageResource(R.drawable.profile);
					}
					else {
						Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("pic").toString())).into(_drawer_circleimageview1);
					}
				}
				_drawer_circleimageview1.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						i.setClass(getApplicationContext(), FullimageActivity.class);
						i.putExtra("image", _childValue.get("pic").toString());
						startActivity(i);
					}
				});
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
		
		_drawer_logout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				log.setTitle("Hospital Management");
				log.setIcon(R.drawable.doctors);
				log.setMessage("Do you want to log out now?");
				log.setPositiveButton("Log out now !", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						FirebaseAuth.getInstance().signOut();
						i.setClass(getApplicationContext(), LoginActivity.class);
						startActivity(i);
					}
				});
				log.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				log.create().show();
			}
		});
		
		_drawer_profile.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), ProfileDActivity.class);
				startActivity(i);
			}
		});
		
		_drawer_manage_appointment.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), ManageAppointmentActivity.class);
				i.putExtra("button", "true");
				startActivity(i);
			}
		});
		
		_drawer_add_precipitation.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), PrecipitationActivity.class);
				i.putExtra("button", "false");
				startActivity(i);
			}
		});
		
		_drawer_about_us.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), AboutUsActivity.class);
				startActivity(i);
			}
		});
		
		_drawer_contact_us.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), ContactUsActivity.class);
				startActivity(i);
			}
		});
		
		fath_d_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fath_d_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fath_d_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fath_d_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fath_d_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task){
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		fath_d_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fath_d_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task){
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_fath_d_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_fath_d_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_fath_d_reset_password_listener = new OnCompleteListener<Void>() {
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
		_SetBackground(linear18, 25, 100, "#4DB6AC", true);
		_SetBackground(linear17, 25, 100, "#4DB6AC", true);
		_SetCornerRadius(_drawer_linear2, 30, 20, "#80D8FF");
		_SetCornerRadius(_drawer_linear3, 30, 20, "#80D8FF");
		_SetCornerRadius(_drawer_linear4, 30, 20, "#80D8FF");
		_SetCornerRadius(_drawer_linear6, 30, 20, "#80D8FF");
		_SetCornerRadius(_drawer_linear7, 30, 20, "#80D8FF");
		_SetCornerRadius(_drawer_linear8, 30, 20, "#80D8FF");
		_SetCornerRadius(_drawer_logout, 30, 20, "#80D8FF");
		_MarqueTextView(textview9, "Hello ".concat(profile.getString("name", "")).concat("  Welcome to Hospital Management System😊"));
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
	
	
	public void _MarqueTextView (final TextView _view, final String _text) {
		_view.setText(_text);
		_view.setSingleLine(true);
		_view.setEllipsize(TextUtils.TruncateAt.MARQUEE);
		_view.setSelected(true);
	}
	
	
	public void _SetCornerRadius (final View _view, final double _radius, final double _shadow, final String _color) {
		android.graphics.drawable.GradientDrawable ab = new android.graphics.drawable.GradientDrawable();
		
		ab.setColor(Color.parseColor(_color));
		ab.setCornerRadius((float) _radius);
		_view.setElevation((float) _shadow);
		_view.setBackground(ab);
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