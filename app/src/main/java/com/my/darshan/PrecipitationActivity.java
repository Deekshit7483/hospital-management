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
import java.util.ArrayList;
import java.util.HashMap;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class PrecipitationActivity extends AppCompatActivity {
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	
	private ArrayList<HashMap<String, Object>> appointment_list = new ArrayList<>();
	
	private ListView listview1;
	
	private DatabaseReference appointment = _firebase.getReference("appointment");
	private ChildEventListener _appointment_child_listener;
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
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.precipitation);
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
		listview1 = (ListView) findViewById(R.id.listview1);
		fauth_d = FirebaseAuth.getInstance();
		
		_appointment_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				appointment.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						appointment_list = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								appointment_list.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						listview1.setAdapter(new Listview1Adapter(appointment_list));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				appointment.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						appointment_list = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								appointment_list.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						listview1.setAdapter(new Listview1Adapter(appointment_list));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
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
		appointment.addChildEventListener(_appointment_child_listener);
		
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
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			
			default:
			break;
		}
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
	
	
	public class Listview1Adapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.man_appointment, null);
			}
			
			final LinearLayout linear1 = (LinearLayout) _view.findViewById(R.id.linear1);
			final TextView textview1 = (TextView) _view.findViewById(R.id.textview1);
			final TextView textview2 = (TextView) _view.findViewById(R.id.textview2);
			final TextView textview3 = (TextView) _view.findViewById(R.id.textview3);
			final TextView textview4 = (TextView) _view.findViewById(R.id.textview4);
			final TextView textview5 = (TextView) _view.findViewById(R.id.textview5);
			final TextView textview9 = (TextView) _view.findViewById(R.id.textview9);
			final TextView textview6 = (TextView) _view.findViewById(R.id.textview6);
			final TextView textview7 = (TextView) _view.findViewById(R.id.textview7);
			final TextView textview8 = (TextView) _view.findViewById(R.id.textview8);
			final LinearLayout linear2 = (LinearLayout) _view.findViewById(R.id.linear2);
			final Button button2 = (Button) _view.findViewById(R.id.button2);
			final Button button1 = (Button) _view.findViewById(R.id.button1);
			final TextView textview10 = (TextView) _view.findViewById(R.id.textview10);
			
			_SetBackground(linear1, 25, 10, "#4DB6AC", true);
			if (appointment_list.get((int)_position).get("doctor id").toString().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
				if (appointment_list.get((int)_position).containsKey("doctor name")) {
					textview1.setText(appointment_list.get((int)_position).get("doctor name").toString());
				}
				if (appointment_list.get((int)_position).containsKey("fees")) {
					textview2.setText(appointment_list.get((int)_position).get("fees").toString());
				}
				if (appointment_list.get((int)_position).containsKey("specification")) {
					textview3.setText(appointment_list.get((int)_position).get("specification").toString());
				}
				if (appointment_list.get((int)_position).containsKey("doctor address")) {
					textview4.setText(appointment_list.get((int)_position).get("doctor address").toString());
				}
				if (appointment_list.get((int)_position).containsKey("user name")) {
					textview5.setText(appointment_list.get((int)_position).get("user name").toString());
				}
				if (appointment_list.get((int)_position).containsKey("problem")) {
					textview9.setText(appointment_list.get((int)_position).get("problem").toString());
				}
				if (appointment_list.get((int)_position).containsKey("user number")) {
					textview6.setText(appointment_list.get((int)_position).get("user number").toString());
				}
				if (appointment_list.get((int)_position).containsKey("time ")) {
					textview7.setText(appointment_list.get((int)_position).get("time ").toString());
				}
				if (appointment_list.get((int)_position).containsKey("date")) {
					textview8.setText(appointment_list.get((int)_position).get("date").toString());
				}
				if (appointment_list.get((int)_position).containsKey("status")) {
					textview10.setText(appointment_list.get((int)_position).get("status").toString());
				}
				linear1.setVisibility(View.VISIBLE);
			}
			else {
				linear1.setVisibility(View.GONE);
			}
			button2.setVisibility(View.GONE);
			button1.setVisibility(View.GONE);
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					i.setClass(getApplicationContext(), AddPrecipitationActivity.class);
					i.putExtra("doctor name", appointment_list.get((int)_position).get("doctor name").toString());
					i.putExtra("username name", appointment_list.get((int)_position).get("user name").toString());
					i.putExtra("doctor id", appointment_list.get((int)_position).get("doctor id").toString());
					i.putExtra("user id", appointment_list.get((int)_position).get("user id").toString());
					i.putExtra("problem", appointment_list.get((int)_position).get("problem").toString());
					startActivity(i);
				}
			});
			
			return _view;
		}
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