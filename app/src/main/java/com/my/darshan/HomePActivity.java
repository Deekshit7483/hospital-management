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
import android.content.Intent;
import android.net.Uri;
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
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.Activity;
import android.content.SharedPreferences;
import android.animation.ObjectAnimator;
import android.view.animation.LinearInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import java.util.Timer;
import java.util.TimerTask;
import android.view.View;
import com.bumptech.glide.Glide;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class HomePActivity extends AppCompatActivity {
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private DrawerLayout _drawer;
	private HashMap<String, Object> map = new HashMap<>();
	
	private ScrollView vscroll2;
	private LinearLayout linear14;
	private ImageView imageview7;
	private TextView textview9;
	private LinearLayout linear1;
	private LinearLayout linear5;
	private LinearLayout linear15;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private ImageView imageview1;
	private TextView textview1;
	private ImageView imageview2;
	private TextView textview2;
	private LinearLayout linear6;
	private LinearLayout linear7;
	private ImageView imageview4;
	private TextView textview3;
	private ImageView imageview3;
	private TextView textview4;
	private LinearLayout linear16;
	private ImageView imageview5;
	private TextView textview7;
	private ScrollView _drawer_vscroll1;
	private LinearLayout _drawer_linear1;
	private LinearLayout _drawer_linear2;
	private LinearLayout _drawer_linear10;
	private CircleImageView _drawer_circleimageview1;
	private TextView _drawer_textview1;
	private TextView _drawer_textview2;
	private LinearLayout _drawer_linear3;
	private LinearLayout _drawer_linear4;
	private LinearLayout _drawer_linear9;
	private LinearLayout _drawer_linear6;
	private LinearLayout _drawer_linear7;
	private LinearLayout _drawer_linear8;
	private TextView _drawer_textview9;
	private ImageView _drawer_imageview1;
	private TextView _drawer_profile;
	private ImageView _drawer_imageview2;
	private TextView _drawer_My_appointment;
	private ImageView _drawer_imageview6;
	private TextView _drawer_Appointment_history;
	private ImageView _drawer_imageview3;
	private TextView _drawer_precipitation;
	private ImageView _drawer_imageview4;
	private TextView _drawer_textview7;
	private ImageView _drawer_imageview5;
	private TextView _drawer_textview8;
	
	private Intent i = new Intent();
	private FirebaseAuth fauth_p;
	private OnCompleteListener<Void> fauth_p_updateEmailListener;
	private OnCompleteListener<Void> fauth_p_updatePasswordListener;
	private OnCompleteListener<Void> fauth_p_emailVerificationSentListener;
	private OnCompleteListener<Void> fauth_p_deleteUserListener;
	private OnCompleteListener<Void> fauth_p_updateProfileListener;
	private OnCompleteListener<AuthResult> fauth_p_phoneAuthListener;
	private OnCompleteListener<AuthResult> fauth_p_googleSignInListener;
	private OnCompleteListener<AuthResult> _fauth_p_create_user_listener;
	private OnCompleteListener<AuthResult> _fauth_p_sign_in_listener;
	private OnCompleteListener<Void> _fauth_p_reset_password_listener;
	private DatabaseReference user = _firebase.getReference("user");
	private ChildEventListener _user_child_listener;
	private AlertDialog.Builder log;
	private SharedPreferences profile;
	private ObjectAnimator cl = new ObjectAnimator();
	private ObjectAnimator cli = new ObjectAnimator();
	private TimerTask t;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.home_p);
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
		ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(HomePActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		
		LinearLayout _nav_view = (LinearLayout) findViewById(R.id._nav_view);
		
		vscroll2 = (ScrollView) findViewById(R.id.vscroll2);
		linear14 = (LinearLayout) findViewById(R.id.linear14);
		imageview7 = (ImageView) findViewById(R.id.imageview7);
		textview9 = (TextView) findViewById(R.id.textview9);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear15 = (LinearLayout) findViewById(R.id.linear15);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview1 = (TextView) findViewById(R.id.textview1);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		textview2 = (TextView) findViewById(R.id.textview2);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		textview3 = (TextView) findViewById(R.id.textview3);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		textview4 = (TextView) findViewById(R.id.textview4);
		linear16 = (LinearLayout) findViewById(R.id.linear16);
		imageview5 = (ImageView) findViewById(R.id.imageview5);
		textview7 = (TextView) findViewById(R.id.textview7);
		_drawer_vscroll1 = (ScrollView) _nav_view.findViewById(R.id.vscroll1);
		_drawer_linear1 = (LinearLayout) _nav_view.findViewById(R.id.linear1);
		_drawer_linear2 = (LinearLayout) _nav_view.findViewById(R.id.linear2);
		_drawer_linear10 = (LinearLayout) _nav_view.findViewById(R.id.linear10);
		_drawer_circleimageview1 = (CircleImageView) _nav_view.findViewById(R.id.circleimageview1);
		_drawer_textview1 = (TextView) _nav_view.findViewById(R.id.textview1);
		_drawer_textview2 = (TextView) _nav_view.findViewById(R.id.textview2);
		_drawer_linear3 = (LinearLayout) _nav_view.findViewById(R.id.linear3);
		_drawer_linear4 = (LinearLayout) _nav_view.findViewById(R.id.linear4);
		_drawer_linear9 = (LinearLayout) _nav_view.findViewById(R.id.linear9);
		_drawer_linear6 = (LinearLayout) _nav_view.findViewById(R.id.linear6);
		_drawer_linear7 = (LinearLayout) _nav_view.findViewById(R.id.linear7);
		_drawer_linear8 = (LinearLayout) _nav_view.findViewById(R.id.linear8);
		_drawer_textview9 = (TextView) _nav_view.findViewById(R.id.textview9);
		_drawer_imageview1 = (ImageView) _nav_view.findViewById(R.id.imageview1);
		_drawer_profile = (TextView) _nav_view.findViewById(R.id.profile);
		_drawer_imageview2 = (ImageView) _nav_view.findViewById(R.id.imageview2);
		_drawer_My_appointment = (TextView) _nav_view.findViewById(R.id.My_appointment);
		_drawer_imageview6 = (ImageView) _nav_view.findViewById(R.id.imageview6);
		_drawer_Appointment_history = (TextView) _nav_view.findViewById(R.id.Appointment_history);
		_drawer_imageview3 = (ImageView) _nav_view.findViewById(R.id.imageview3);
		_drawer_precipitation = (TextView) _nav_view.findViewById(R.id.precipitation);
		_drawer_imageview4 = (ImageView) _nav_view.findViewById(R.id.imageview4);
		_drawer_textview7 = (TextView) _nav_view.findViewById(R.id.textview7);
		_drawer_imageview5 = (ImageView) _nav_view.findViewById(R.id.imageview5);
		_drawer_textview8 = (TextView) _nav_view.findViewById(R.id.textview8);
		fauth_p = FirebaseAuth.getInstance();
		log = new AlertDialog.Builder(this);
		profile = getSharedPreferences("profile", Activity.MODE_PRIVATE);
		
		linear3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!cl.isRunning()) {
					cl.setTarget(linear3);
					cl.setPropertyName("scaleX");
					cl.setFloatValues((float)(1.0d), (float)(0.7d));
					cl.setDuration((int)(200));
					cl.setRepeatMode(ValueAnimator.REVERSE);
					cl.setRepeatCount((int)(1));
					cl.start();
					cli.setTarget(linear3);
					cli.setPropertyName("scaleY");
					cli.setFloatValues((float)(1.0d), (float)(0.7d));
					cli.setDuration((int)(200));
					cli.setRepeatMode(ValueAnimator.REVERSE);
					cli.setRepeatCount((int)(1));
					cli.start();
					t = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									i.setClass(getApplicationContext(), ProfileActivity.class);
									i.putExtra("profile ", "true");
									startActivity(i);
								}
							});
						}
					};
					_timer.schedule(t, (int)(500));
				}
			}
		});
		
		linear4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!cl.isRunning()) {
					cl.setTarget(linear4);
					cl.setPropertyName("scaleX");
					cl.setFloatValues((float)(1.0d), (float)(0.7d));
					cl.setDuration((int)(200));
					cl.setRepeatMode(ValueAnimator.REVERSE);
					cl.setRepeatCount((int)(1));
					cl.start();
					cli.setTarget(linear4);
					cli.setPropertyName("scaleY");
					cli.setFloatValues((float)(1.0d), (float)(0.7d));
					cli.setDuration((int)(200));
					cli.setRepeatMode(ValueAnimator.REVERSE);
					cli.setRepeatCount((int)(1));
					cli.start();
					t = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									i.setClass(getApplicationContext(), BookAppointmentActivity.class);
									startActivity(i);
								}
							});
						}
					};
					_timer.schedule(t, (int)(500));
				}
			}
		});
		
		linear6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!cl.isRunning()) {
					cl.setTarget(linear6);
					cl.setPropertyName("scaleX");
					cl.setFloatValues((float)(1.0d), (float)(0.7d));
					cl.setDuration((int)(200));
					cl.setRepeatMode(ValueAnimator.REVERSE);
					cl.setRepeatCount((int)(1));
					cl.start();
					cli.setTarget(linear6);
					cli.setPropertyName("scaleY");
					cli.setFloatValues((float)(1.0d), (float)(0.7d));
					cli.setDuration((int)(200));
					cli.setRepeatMode(ValueAnimator.REVERSE);
					cli.setRepeatCount((int)(1));
					cli.start();
					t = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									i.setClass(getApplicationContext(), MyAppointmentActivity.class);
									i.putExtra("button", "true");
									startActivity(i);
								}
							});
						}
					};
					_timer.schedule(t, (int)(500));
				}
			}
		});
		
		linear7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!cl.isRunning()) {
					cl.setTarget(linear7);
					cl.setPropertyName("scaleX");
					cl.setFloatValues((float)(1.0d), (float)(0.7d));
					cl.setDuration((int)(200));
					cl.setRepeatMode(ValueAnimator.REVERSE);
					cl.setRepeatCount((int)(1));
					cl.start();
					cli.setTarget(linear7);
					cli.setPropertyName("scaleY");
					cli.setFloatValues((float)(1.0d), (float)(0.7d));
					cli.setDuration((int)(200));
					cli.setRepeatMode(ValueAnimator.REVERSE);
					cli.setRepeatCount((int)(1));
					cli.start();
					t = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									i.setClass(getApplicationContext(), MyAppointmentActivity.class);
									i.putExtra("button", "false");
									startActivity(i);
								}
							});
						}
					};
					_timer.schedule(t, (int)(500));
				}
			}
		});
		
		linear16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!cl.isRunning()) {
					cl.setTarget(linear16);
					cl.setPropertyName("scaleX");
					cl.setFloatValues((float)(1.0d), (float)(0.7d));
					cl.setDuration((int)(200));
					cl.setRepeatMode(ValueAnimator.REVERSE);
					cl.setRepeatCount((int)(1));
					cl.start();
					cli.setTarget(linear16);
					cli.setPropertyName("scaleY");
					cli.setFloatValues((float)(1.0d), (float)(0.7d));
					cli.setDuration((int)(200));
					cli.setRepeatMode(ValueAnimator.REVERSE);
					cli.setRepeatCount((int)(1));
					cli.start();
					t = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									i.setClass(getApplicationContext(), PrecipitationHistoryActivity.class);
									startActivity(i);
								}
							});
						}
					};
					_timer.schedule(t, (int)(500));
				}
			}
		});
		
		_user_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					_drawer_textview1.setText(_childValue.get("name").toString());
					_drawer_textview2.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());
					profile.edit().putString("name", _childValue.get("name").toString()).commit();
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
		user.addChildEventListener(_user_child_listener);
		
		_drawer_textview9.setOnClickListener(new View.OnClickListener() {
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
				i.setClass(getApplicationContext(), ProfileActivity.class);
				i.putExtra("profile ", "false");
				startActivity(i);
			}
		});
		
		_drawer_My_appointment.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), MyAppointmentActivity.class);
				i.putExtra("button", "true");
				startActivity(i);
			}
		});
		
		_drawer_Appointment_history.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), MyAppointmentActivity.class);
				i.putExtra("button", "false");
				startActivity(i);
			}
		});
		
		_drawer_precipitation.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), PrecipitationHistoryActivity.class);
				startActivity(i);
			}
		});
		
		_drawer_textview7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), AboutUsActivity.class);
				startActivity(i);
			}
		});
		
		_drawer_textview8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), ContactUsActivity.class);
				startActivity(i);
			}
		});
		
		fauth_p_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_p_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_p_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_p_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_p_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task){
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		fauth_p_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_p_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task){
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_fauth_p_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_fauth_p_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_fauth_p_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		_SetCornerRadius(_drawer_linear2, 30, 20, "#80D8FF");
		_SetCornerRadius(_drawer_linear3, 30, 20, "#80D8FF");
		_SetCornerRadius(_drawer_linear4, 30, 20, "#80D8FF");
		_SetCornerRadius(_drawer_linear6, 30, 20, "#80D8FF");
		_SetCornerRadius(_drawer_linear7, 30, 20, "#80D8FF");
		_SetCornerRadius(_drawer_linear8, 30, 20, "#80D8FF");
		_SetCornerRadius(_drawer_textview9, 30, 20, "#80D8FF");
		_SetCornerRadius(_drawer_linear9, 30, 20, "#80D8FF");
		_SetBackground(linear3, 25, 100, "#4DB6AC", true);
		_SetBackground(linear4, 25, 100, "#4DB6AC", true);
		_SetBackground(linear6, 25, 100, "#4DB6AC", true);
		_SetBackground(linear7, 25, 100, "#4DB6AC", true);
		_SetBackground(linear16, 25, 100, "#4DB6AC", true);
		_MarqueTextView(textview9, "Hello ".concat(profile.getString("name", "")).concat("  Welcome to Hospital Management System     Get well soon 😊"));
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
	public void _SetCornerRadius (final View _view, final double _radius, final double _shadow, final String _color) {
		android.graphics.drawable.GradientDrawable ab = new android.graphics.drawable.GradientDrawable();
		
		ab.setColor(Color.parseColor(_color));
		ab.setCornerRadius((float) _radius);
		_view.setElevation((float) _shadow);
		_view.setBackground(ab);
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