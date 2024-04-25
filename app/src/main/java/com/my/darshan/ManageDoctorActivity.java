package com.my.darshan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
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
import android.content.Intent;
import android.net.Uri;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class ManageDoctorActivity extends AppCompatActivity {
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private FloatingActionButton _fab;
	private String user_id = "";
	
	private ArrayList<HashMap<String, Object>> doctor_list = new ArrayList<>();
	
	private ListView listview1;
	
	private DatabaseReference doctor = _firebase.getReference("doctor");
	private ChildEventListener _doctor_child_listener;
	private Intent i = new Intent();
	private AlertDialog.Builder d;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.manage_doctor);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_fab = (FloatingActionButton) findViewById(R.id._fab);
		
		listview1 = (ListView) findViewById(R.id.listview1);
		d = new AlertDialog.Builder(this);
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), RegisterDocActivity.class);
				startActivity(i);
			}
		});
		
		_doctor_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				doctor.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						doctor_list = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								doctor_list.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						listview1.setAdapter(new Listview1Adapter(doctor_list));
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
				doctor.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						doctor_list = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								doctor_list.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						listview1.setAdapter(new Listview1Adapter(doctor_list));
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
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		doctor.addChildEventListener(_doctor_child_listener);
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
				_view = _inflater.inflate(R.layout.doctor_list, null);
			}
			
			final LinearLayout linear1 = (LinearLayout) _view.findViewById(R.id.linear1);
			final TextView username = (TextView) _view.findViewById(R.id.username);
			final TextView fees = (TextView) _view.findViewById(R.id.fees);
			final TextView phone = (TextView) _view.findViewById(R.id.phone);
			final TextView specification = (TextView) _view.findViewById(R.id.specification);
			final TextView address = (TextView) _view.findViewById(R.id.address);
			final TextView email = (TextView) _view.findViewById(R.id.email);
			final Button button1 = (Button) _view.findViewById(R.id.button1);
			
			_SetBackground(linear1, 35, 15, "#4DB6AC", true);
			if (doctor_list.get((int)_position).containsKey("username")) {
				username.setText(doctor_list.get((int)_position).get("username").toString());
			}
			if (doctor_list.get((int)_position).containsKey("phone")) {
				phone.setText(doctor_list.get((int)_position).get("phone").toString());
			}
			if (doctor_list.get((int)_position).containsKey("fees")) {
				fees.setText(doctor_list.get((int)_position).get("fees").toString());
			}
			if (doctor_list.get((int)_position).containsKey("specification")) {
				specification.setText(doctor_list.get((int)_position).get("specification").toString());
			}
			if (doctor_list.get((int)_position).containsKey("email")) {
				email.setText(doctor_list.get((int)_position).get("email").toString());
			}
			if (doctor_list.get((int)_position).containsKey("address")) {
				address.setText(doctor_list.get((int)_position).get("address").toString());
			}
			button1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					d.setTitle("Hospital Management");
					d.setMessage("Do you want to delete this Doctor? ");
					d.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							doctor.child(doctor_list.get((int)_position).get("uid").toString()).removeValue();
						}
					});
					d.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					d.create().show();
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