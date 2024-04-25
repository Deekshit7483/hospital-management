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
import java.util.ArrayList;
import android.widget.ScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import de.hdodenhof.circleimageview.*;
import android.widget.Button;
import android.widget.ImageView;
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
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.firebase.storage.OnProgressListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Continuation;
import java.io.File;
import android.content.ClipData;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;


public class RegisterActivity extends AppCompatActivity {
	public final int REQ_CD_IMAGE = 101;
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private HashMap<String, Object> map = new HashMap<>();
	private String photo = "";
	private boolean upload_image = false;
	
	private ArrayList<String> gender = new ArrayList<>();
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private TextView textview4;
	private CircleImageView circleimageview1;
	private TextView textview1;
	private LinearLayout linear5;
	private LinearLayout linear14;
	private LinearLayout linear15;
	private LinearLayout linear16;
	private LinearLayout linear6;
	private LinearLayout linear8;
	private Button button1;
	private TextView textview3;
	private ImageView imageview3;
	private EditText username;
	private ImageView imageview6;
	private EditText name;
	private ImageView imageview7;
	private EditText number;
	private Spinner spinner1;
	private ImageView imageview4;
	private EditText email;
	private ImageView imageview5;
	private EditText password;
	
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
	private Intent i = new Intent();
	private DatabaseReference user = _firebase.getReference("user");
	private ChildEventListener _user_child_listener;
	private StorageReference profile = _firebase_storage.getReference("profile");
	private OnCompleteListener<Uri> _profile_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _profile_download_success_listener;
	private OnSuccessListener _profile_delete_success_listener;
	private OnProgressListener _profile_upload_progress_listener;
	private OnProgressListener _profile_download_progress_listener;
	private OnFailureListener _profile_failure_listener;
	private Intent image = new Intent(Intent.ACTION_GET_CONTENT);
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.register);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
		}
		else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		textview4 = (TextView) findViewById(R.id.textview4);
		circleimageview1 = (CircleImageView) findViewById(R.id.circleimageview1);
		textview1 = (TextView) findViewById(R.id.textview1);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear14 = (LinearLayout) findViewById(R.id.linear14);
		linear15 = (LinearLayout) findViewById(R.id.linear15);
		linear16 = (LinearLayout) findViewById(R.id.linear16);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		button1 = (Button) findViewById(R.id.button1);
		textview3 = (TextView) findViewById(R.id.textview3);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		username = (EditText) findViewById(R.id.username);
		imageview6 = (ImageView) findViewById(R.id.imageview6);
		name = (EditText) findViewById(R.id.name);
		imageview7 = (ImageView) findViewById(R.id.imageview7);
		number = (EditText) findViewById(R.id.number);
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		email = (EditText) findViewById(R.id.email);
		imageview5 = (ImageView) findViewById(R.id.imageview5);
		password = (EditText) findViewById(R.id.password);
		fauth_p = FirebaseAuth.getInstance();
		image.setType("image/*");
		image.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		
		circleimageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(image, REQ_CD_IMAGE);
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				fauth_p.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(RegisterActivity.this, _fauth_p_create_user_listener);
			}
		});
		
		textview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), LoginPaActivity.class);
				startActivity(i);
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
		
		_profile_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_profile_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_profile_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				map = new HashMap<>();
				map.put("name", name.getText().toString());
				map.put("username", username.getText().toString());
				map.put("phone", number.getText().toString());
				map.put("email", email.getText().toString());
				map.put("pic", _downloadUrl);
				map.put("password", password.getText().toString());
				map.put("gender", gender.get((int)(spinner1.getSelectedItemPosition())));
				user.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(map);
				map.clear();
				photo = "";
				i.setClass(getApplicationContext(), HomePActivity.class);
				startActivity(i);
			}
		};
		
		_profile_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_profile_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_profile_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
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
				if (upload_image) {
					if (_success) {
						profile.child(Uri.parse(photo).getLastPathSegment()).putFile(Uri.fromFile(new File(photo))).addOnFailureListener(_profile_failure_listener).addOnProgressListener(_profile_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
							@Override
							public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
								return profile.child(Uri.parse(photo).getLastPathSegment()).getDownloadUrl();
							}}).addOnCompleteListener(_profile_upload_success_listener);
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), _errorMessage);
					}
				}
				else {
					map = new HashMap<>();
					map.put("name", name.getText().toString());
					map.put("username", username.getText().toString());
					map.put("phone", number.getText().toString());
					map.put("email", email.getText().toString());
					map.put("gender", gender.get((int)(spinner1.getSelectedItemPosition())));
					map.put("password", password.getText().toString());
					map.put("verification", "false");
					map.put("pic", "");
					map.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
					user.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(map);
					map.clear();
					i.setClass(getApplicationContext(), HomePActivity.class);
					startActivity(i);
				}
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
		gender.add("Select Gender");
		gender.add("Male");
		gender.add("Female");
		spinner1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, gender));
		((ArrayAdapter)spinner1.getAdapter()).notifyDataSetChanged();
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			case REQ_CD_IMAGE:
			if (_resultCode == Activity.RESULT_OK) {
				ArrayList<String> _filePath = new ArrayList<>();
				if (_data != null) {
					if (_data.getClipData() != null) {
						for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
							ClipData.Item _item = _data.getClipData().getItemAt(_index);
							_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
						}
					}
					else {
						_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
					}
				}
				circleimageview1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(_filePath.get((int)(0)), 1024, 1024));
				photo = _filePath.get((int)(0));
				upload_image = true;
			}
			else {
				upload_image = false;
			}
			break;
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
	
	
	public void _extra () {
	} private ProgressDialog prog; {
	}
	
	
	public void _ProgresbarDimiss () {
		if(prog != null)
		{
			prog.dismiss();
		}
	}
	
	
	public void _ProgresbarShow (final String _title) {
		prog = new ProgressDialog(RegisterActivity.this);
		prog.setMax(100);
		prog.setMessage(_title);
		prog.setIndeterminate(true);
		prog.setCancelable(false);
		prog.show();
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