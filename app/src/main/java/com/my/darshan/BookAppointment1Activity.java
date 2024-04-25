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
import android.widget.ScrollView;
import android.widget.LinearLayout;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
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
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class BookAppointment1Activity extends AppCompatActivity {
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private HashMap<String, Object> map = new HashMap<>();
	private String key = "";
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private LinearLayout linear7;
	private LinearLayout linear10;
	private LinearLayout linear8;
	private LinearLayout linear9;
	private Button button1;
	private TextView textview1;
	private TextView textview2;
	private TextView textview3;
	private TextView textview4;
	private TextView textview5;
	private TextView textview6;
	private EditText edittext3;
	private TextView textview7;
	private Button button2;
	private TextView textview8;
	private Button button3;
	
	private DatabaseReference user = _firebase.getReference("user");
	private ChildEventListener _user_child_listener;
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
	private DatabaseReference appointment = _firebase.getReference("appointment");
	private ChildEventListener _appointment_child_listener;
	private AlertDialog.Builder dia;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.book_appointment1);
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
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		button1 = (Button) findViewById(R.id.button1);
		textview1 = (TextView) findViewById(R.id.textview1);
		textview2 = (TextView) findViewById(R.id.textview2);
		textview3 = (TextView) findViewById(R.id.textview3);
		textview4 = (TextView) findViewById(R.id.textview4);
		textview5 = (TextView) findViewById(R.id.textview5);
		textview6 = (TextView) findViewById(R.id.textview6);
		edittext3 = (EditText) findViewById(R.id.edittext3);
		textview7 = (TextView) findViewById(R.id.textview7);
		button2 = (Button) findViewById(R.id.button2);
		textview8 = (TextView) findViewById(R.id.textview8);
		button3 = (Button) findViewById(R.id.button3);
		fauth_p = FirebaseAuth.getInstance();
		dia = new AlertDialog.Builder(this);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				key = appointment.push().getKey();
				map = new HashMap<>();
				map.put("doctor name", getIntent().getStringExtra("username"));
				map.put("fees", getIntent().getStringExtra("fees"));
				map.put("specification", getIntent().getStringExtra("specification"));
				map.put("doctor address", getIntent().getStringExtra("address"));
				map.put("user name", textview5.getText().toString());
				map.put("user number", textview6.getText().toString());
				map.put("time ", textview8.getText().toString());
				map.put("date", textview7.getText().toString());
				map.put("doctor id", getIntent().getStringExtra("uid"));
				map.put("user id", FirebaseAuth.getInstance().getCurrentUser().getUid());
				map.put("key", key);
				map.put("problem", edittext3.getText().toString());
				map.put("status", "Pending... ");
				map.put("payment", "false");
				appointment.child(key).updateChildren(map);
				map.clear();
				dia.setTitle("Hospital Management");
				dia.setMessage("Appointed Booked Successfully. ");
				dia.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						finish();
					}
				});
				dia.create().show();
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_DateDialog(textview7);
			}
		});
		
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_TimeDialog(textview8);
			}
		});
		
		_user_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					textview5.setText(_childValue.get("name").toString());
					textview6.setText(_childValue.get("phone").toString());
				}
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
		
		_appointment_child_listener = new ChildEventListener() {
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
		appointment.addChildEventListener(_appointment_child_listener);
		
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
		textview1.setText("Doctor Name:- ".concat(getIntent().getStringExtra("username")));
		textview2.setText("Doctor fees:- ".concat(getIntent().getStringExtra("fees")));
		textview3.setText("Doctor Specification:- ".concat(getIntent().getStringExtra("specification")));
		textview4.setText("Doctor Address:- ".concat(getIntent().getStringExtra("address")));
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	public void _DateDialog (final TextView _textview) {
		DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
			@Override
			public void onDateSet(DatePicker view, int year, int month, int day) {
				month++;
				_textview.setText(day + "/" + month + "/" + year);
			}
		};
		showDatePicker(datePickerListener);
	}
	public void showDatePicker(DatePickerDialog.OnDateSetListener listener) {
		DatePickerDialog datePicker = new DatePickerDialog(this);
		// datePicker.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(0));
		datePicker.setOnDateSetListener(listener);
		datePicker.show();
	}
	{
	}
	
	
	public void _TimeDialog (final TextView _textview) {
		TimePickerFragment.text = _textview;
		new TimePickerFragment().show(getSupportFragmentManager(), "timePicker");
	}
	public static class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			final Calendar c = Calendar.getInstance();
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int minute = c.get(Calendar.MINUTE);
			return new TimePickerDialog(getActivity(), this, hour, minute, android.text.format.DateFormat.is24HourFormat(getActivity()));
		}
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			text.setText(new DecimalFormat("00").format(hourOfDay) + ":" + new DecimalFormat("00").format(minute));
		}
		private static TextView text;
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