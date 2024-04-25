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
import android.widget.LinearLayout;
import de.hdodenhof.circleimageview.*;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
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
import java.util.Calendar;
import java.text.SimpleDateFormat;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.ClipData;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.firebase.storage.OnProgressListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Continuation;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import android.speech.SpeechRecognizer;
import android.speech.RecognizerIntent;
import android.speech.RecognitionListener;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.os.Build;
import androidx.core.content.FileProvider;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.text.Editable;
import android.text.TextWatcher;
import com.google.gson.Gson;
import com.bumptech.glide.Glide;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;


public class ChatActivity extends AppCompatActivity {
	public final int REQ_CD_FO = 101;
	public final int REQ_CD_FO2 = 102;
	public final int REQ_CD_CAM = 103;
	public final int REQ_CD_FO3 = 104;
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private String STATUS = "";
	private HashMap<String, Object> sts = new HashMap<>();
	private String chat_str = "";
	private String uid2 = "";
	private boolean replyMode = false;
	private double ReplyPosition = 0;
	private String reply_uid = "";
	private String outputFile = "";
	private double time_passed = 0;
	private String voice_duration = "";
	private String ddd = "";
	private String extension = "";
	private boolean recordMode = false;
	private boolean click = false;
	private String list_chat_str = "";
	private String chat_str_2 = "";
	private String listchat_u1 = "";
	private String listchat_u2 = "";
	private boolean get_messages = false;
	private String chat_str_ = "";
	private HashMap<String, Object> map_pesan = new HashMap<>();
	private String push_key = "";
	private HashMap<String, Object> map_key_u2 = new HashMap<>();
	
	private ArrayList<HashMap<String, Object>> lm_pesan = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> lm_list_chat = new ArrayList<>();
	private ArrayList<String> uids = new ArrayList<>();
	private ArrayList<String> names = new ArrayList<>();
	
	private LinearLayout tools;
	private LinearLayout linear_main;
	private LinearLayout tool;
	private LinearLayout linear21;
	private LinearLayout linear_nm;
	private CircleImageView circleimageview1;
	private LinearLayout linear_n;
	private TextView status;
	private TextView username;
	private ImageView im_verified;
	private LinearLayout linear22;
	private ListView listview1;
	private LinearLayout linear_msg_main;
	private TextView textview21;
	private ImageView imageview12;
	private LinearLayout linear_message;
	private ImageView im_send;
	private LinearLayout linear_attach;
	private LinearLayout linear_reply;
	private LinearLayout linear1;
	private LinearLayout lin_camera;
	private LinearLayout lin_gallery;
	private ImageView imageview8;
	private TextView textview15;
	private ImageView imageview11;
	private TextView textview20;
	private LinearLayout linear20;
	private ImageView ig_reply_close;
	private TextView name_reply_out;
	private TextView text_reply_out;
	private ImageView im_send_img;
	private EditText tx_message;
	private ImageView im_attach_file;
	
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
	private DatabaseReference doctor = _firebase.getReference("doctor");
	private ChildEventListener _doctor_child_listener;
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
	private DatabaseReference userstatus = _firebase.getReference("userstatus");
	private ChildEventListener _userstatus_child_listener;
	private Intent in = new Intent();
	private Calendar cal2 = Calendar.getInstance();
	private DatabaseReference list_chat = _firebase.getReference("+list_chat_str+");
	private ChildEventListener _list_chat_child_listener;
	private SharedPreferences share;
	private DatabaseReference chat = _firebase.getReference("+chat_str+");
	private ChildEventListener _chat_child_listener;
	private DatabaseReference listChatU2 = _firebase.getReference("+listchat_u2+");
	private ChildEventListener _listChatU2_child_listener;
	private SharedPreferences listchat;
	private SharedPreferences pesan;
	private Intent fo = new Intent(Intent.ACTION_GET_CONTENT);
	private StorageReference image = _firebase_storage.getReference("image");
	private OnCompleteListener<Uri> _image_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _image_download_success_listener;
	private OnSuccessListener _image_delete_success_listener;
	private OnProgressListener _image_upload_progress_listener;
	private OnProgressListener _image_download_progress_listener;
	private OnFailureListener _image_failure_listener;
	private TimerTask timer;
	private StorageReference voice = _firebase_storage.getReference("voice");
	private OnCompleteListener<Uri> _voice_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _voice_download_success_listener;
	private OnSuccessListener _voice_delete_success_listener;
	private OnProgressListener _voice_upload_progress_listener;
	private OnProgressListener _voice_download_progress_listener;
	private OnFailureListener _voice_failure_listener;
	private SpeechRecognizer so;
	private TimerTask tm4;
	private TimerTask tatta;
	private MediaPlayer mediaPlayer;
	private Intent fo2 = new Intent(Intent.ACTION_GET_CONTENT);
	private StorageReference video = _firebase_storage.getReference("video");
	private OnCompleteListener<Uri> _video_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _video_download_success_listener;
	private OnSuccessListener _video_delete_success_listener;
	private OnProgressListener _video_upload_progress_listener;
	private OnProgressListener _video_download_progress_listener;
	private OnFailureListener _video_failure_listener;
	private Intent cam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	private File _file_cam;
	private Intent fo3 = new Intent(Intent.ACTION_GET_CONTENT);
	private StorageReference file = _firebase_storage.getReference("file");
	private OnCompleteListener<Uri> _file_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _file_download_success_listener;
	private OnSuccessListener _file_delete_success_listener;
	private OnProgressListener _file_upload_progress_listener;
	private OnProgressListener _file_download_progress_listener;
	private OnFailureListener _file_failure_listener;
	private Calendar cl = Calendar.getInstance();
	private AlertDialog.Builder alert;
	private DatabaseReference chatU1 = _firebase.getReference("+chat_str+");
	private ChildEventListener _chatU1_child_listener;
	private Calendar cals = Calendar.getInstance();
	private DatabaseReference listChatU1 = _firebase.getReference("+listchat_u1+");
	private ChildEventListener _listChatU1_child_listener;
	private Calendar cal = Calendar.getInstance();
	private DatabaseReference chat_2 = _firebase.getReference("+chat_str_2+");
	private ChildEventListener _chat_2_child_listener;
	private DatabaseReference user = _firebase.getReference("user");
	private ChildEventListener _user_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.chat);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO}, 1000);
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
		tools = (LinearLayout) findViewById(R.id.tools);
		linear_main = (LinearLayout) findViewById(R.id.linear_main);
		tool = (LinearLayout) findViewById(R.id.tool);
		linear21 = (LinearLayout) findViewById(R.id.linear21);
		linear_nm = (LinearLayout) findViewById(R.id.linear_nm);
		circleimageview1 = (CircleImageView) findViewById(R.id.circleimageview1);
		linear_n = (LinearLayout) findViewById(R.id.linear_n);
		status = (TextView) findViewById(R.id.status);
		username = (TextView) findViewById(R.id.username);
		im_verified = (ImageView) findViewById(R.id.im_verified);
		linear22 = (LinearLayout) findViewById(R.id.linear22);
		listview1 = (ListView) findViewById(R.id.listview1);
		linear_msg_main = (LinearLayout) findViewById(R.id.linear_msg_main);
		textview21 = (TextView) findViewById(R.id.textview21);
		imageview12 = (ImageView) findViewById(R.id.imageview12);
		linear_message = (LinearLayout) findViewById(R.id.linear_message);
		im_send = (ImageView) findViewById(R.id.im_send);
		linear_attach = (LinearLayout) findViewById(R.id.linear_attach);
		linear_reply = (LinearLayout) findViewById(R.id.linear_reply);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		lin_camera = (LinearLayout) findViewById(R.id.lin_camera);
		lin_gallery = (LinearLayout) findViewById(R.id.lin_gallery);
		imageview8 = (ImageView) findViewById(R.id.imageview8);
		textview15 = (TextView) findViewById(R.id.textview15);
		imageview11 = (ImageView) findViewById(R.id.imageview11);
		textview20 = (TextView) findViewById(R.id.textview20);
		linear20 = (LinearLayout) findViewById(R.id.linear20);
		ig_reply_close = (ImageView) findViewById(R.id.ig_reply_close);
		name_reply_out = (TextView) findViewById(R.id.name_reply_out);
		text_reply_out = (TextView) findViewById(R.id.text_reply_out);
		im_send_img = (ImageView) findViewById(R.id.im_send_img);
		tx_message = (EditText) findViewById(R.id.tx_message);
		im_attach_file = (ImageView) findViewById(R.id.im_attach_file);
		fauth_p = FirebaseAuth.getInstance();
		fauth_d = FirebaseAuth.getInstance();
		share = getSharedPreferences("share", Activity.MODE_PRIVATE);
		listchat = getSharedPreferences("listchat", Activity.MODE_PRIVATE);
		pesan = getSharedPreferences("pesan", Activity.MODE_PRIVATE);
		fo.setType("image/*");
		fo.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		so = SpeechRecognizer.createSpeechRecognizer(this);
		fo2.setType("video/*");
		fo2.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		_file_cam = FileUtil.createNewPictureFile(getApplicationContext());
		Uri _uri_cam = null;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
			_uri_cam= FileProvider.getUriForFile(getApplicationContext(), getApplicationContext().getPackageName() + ".provider", _file_cam);
		}
		else {
			_uri_cam = Uri.fromFile(_file_cam);
		}
		cam.putExtra(MediaStore.EXTRA_OUTPUT, _uri_cam);
		cam.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
		fo3.setType("*/*");
		fo3.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		alert = new AlertDialog.Builder(this);
		
		im_send.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				try {
					if (tx_message.getText().toString().replace(" ", "").equals("")) {
						_recordVoice();
						if (replyMode) {
							replyMode = false;
							linear_reply.setVisibility(View.GONE);
						}
						_Shadow(2, 60, "#FFFFFF", linear_message);
					}
					else {
						if (replyMode) {
							push_key = chat.push().getKey();
							map_pesan = new HashMap<>();
							map_pesan.put("pesan", tx_message.getText().toString());
							map_pesan.put("lasted", tx_message.getText().toString());
							map_pesan.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
							map_pesan.put("push key", push_key);
							map_pesan.put("reply", "true");
							map_pesan.put("reply_position", String.valueOf((long)(ReplyPosition)));
							map_pesan.put("reply_uid", reply_uid);
							map_pesan.put("reply_message", text_reply_out.getText().toString());
							chat.child(push_key).updateChildren(map_pesan);
							chat_2.child(push_key).updateChildren(map_pesan);
							map_pesan.put("uid2", uid2);
							listChatU1.child(uid2).updateChildren(map_pesan);
							listChatU2.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(map_pesan);
							tx_message.setText("");
						}
						else {
							push_key = chat.push().getKey();
							map_pesan = new HashMap<>();
							map_pesan.put("pesan", tx_message.getText().toString());
							map_pesan.put("lasted", tx_message.getText().toString());
							map_pesan.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
							map_pesan.put("push key", push_key);
							cals = Calendar.getInstance();
							map_pesan.put("timestamp", String.valueOf((long)(cals.getTimeInMillis())));
							chat.child(push_key).updateChildren(map_pesan);
							chat_2.child(push_key).updateChildren(map_pesan);
							map_pesan.put("uid2", uid2);
							listChatU1.child(uid2).updateChildren(map_pesan);
							listChatU2.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(map_pesan);
							tx_message.setText("");
						}
					}
					if (replyMode) {
						replyMode = false;
						linear_reply.setVisibility(View.GONE);
					}
					if (click) {
						click = false;
						linear_attach.setVisibility(View.GONE);
					}
				}catch(Exception e){
					SketchwareUtil.showMessage(getApplicationContext(), e.toString());
				}
			}
		});
		
		ig_reply_close.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				replyMode = false;
				linear_reply.setVisibility(View.GONE);
				_Shadow(2, 60, "#FFFFFF", linear_message);
			}
		});
		
		tx_message.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (_charSeq.replace(" ", "").equals("")) {
					im_send.setImageResource(R.drawable.ic_mic_none_white);
					_setUserStatus("online");
				}
				else {
					im_send.setImageResource(R.drawable.outline_send);
					_setUserStatus("typing...");
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		im_attach_file.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (click) {
					linear_attach.setVisibility(View.GONE);
					click = false;
					_Shadow(2, 60, "#FFFFFF", linear_message);
					_TransitionManager(linear_main, 200);
				}
				else {
					linear_attach.setVisibility(View.VISIBLE);
					click = true;
					_Shadow(2, 40, "#FFFFFF", linear_message);
					_TransitionManager(linear_main, 200);
				}
				if (replyMode) {
					replyMode = false;
					linear_reply.setVisibility(View.GONE);
					_Shadow(2, 60, "#FFFFFF", linear_message);
					_TransitionManager(linear_main, 200);
				}
			}
		});
		
		_doctor_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				uids.add(_childKey);
				names.add(_childValue.get("username").toString());
				if (_childKey.equals(getIntent().getStringExtra("uid"))) {
					if (_childValue.containsKey("username")) {
						username.setText(_childValue.get("username").toString());
					}
					if (_childValue.containsKey("pic")) {
						if (_childValue.get("pic").toString().equals("")) {
							circleimageview1.setImageResource(R.drawable.profile);
						}
						else {
							Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("pic").toString())).into(circleimageview1);
						}
					}
					if (_childValue.get("verification").toString().equals("true")) {
						im_verified.setVisibility(View.VISIBLE);
					}
					else {
						im_verified.setVisibility(View.GONE);
					}
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
		doctor.addChildEventListener(_doctor_child_listener);
		
		_userstatus_child_listener = new ChildEventListener() {
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
		userstatus.addChildEventListener(_userstatus_child_listener);
		
		_list_chat_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				_get_list_chat();
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				_get_list_chat();
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				_get_list_chat();
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		list_chat.addChildEventListener(_list_chat_child_listener);
		
		_chat_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				try {
					lm_pesan.add(_childValue);
					listview1.setAdapter(new Listview1Adapter(lm_pesan));
					((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					listview1.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL); listview1.setStackFromBottom(true);
					pesan.edit().putString(uid2, new Gson().toJson(lm_pesan)).commit();
					share.edit().putString(uid2, lm_pesan.get((int)lm_pesan.size() - 1).get("push key").toString()).commit();
				}catch(Exception e){
					SketchwareUtil.showMessage(getApplicationContext(), e.toString());
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				try {
					lm_pesan.add(_childValue);
					listview1.setAdapter(new Listview1Adapter(lm_pesan));
					((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					listview1.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL); listview1.setStackFromBottom(true);
					pesan.edit().putString(uid2, new Gson().toJson(lm_pesan)).commit();
					share.edit().putString(uid2, lm_pesan.get((int)lm_pesan.size() - 1).get("push key").toString()).commit();
				}catch(Exception e){
					SketchwareUtil.showMessage(getApplicationContext(), e.toString());
				}
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				try {
					lm_pesan.add(_childValue);
					listview1.setAdapter(new Listview1Adapter(lm_pesan));
					((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					listview1.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL); listview1.setStackFromBottom(true);
					pesan.edit().putString(uid2, new Gson().toJson(lm_pesan)).commit();
					share.edit().putString(uid2, lm_pesan.get((int)lm_pesan.size() - 1).get("push key").toString()).commit();
				}catch(Exception e){
					SketchwareUtil.showMessage(getApplicationContext(), e.toString());
				}
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		chat.addChildEventListener(_chat_child_listener);
		
		_listChatU2_child_listener = new ChildEventListener() {
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
		listChatU2.addChildEventListener(_listChatU2_child_listener);
		
		_image_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_image_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_image_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				
			}
		};
		
		_image_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_image_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_image_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_voice_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				try {
					im_send.setEnabled(false);
					Notification.Builder builder = new Notification.Builder(ChatActivity.this);
					builder.setContentTitle("Sending voice...")
					.setContentText(outputFile)
					.setSmallIcon(R.drawable.ic_upload);
					
					builder.setProgress(0,0,true);
					
					NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
					
					manager.notify(1,builder.build());
				}catch(Exception e){
					SketchwareUtil.showMessage(getApplicationContext(), e.toString());
				}
			}
		};
		
		_voice_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				Notification.Builder builder = new Notification.Builder(ChatActivity.this);
				builder.setContentTitle("Downloading media...")
				.setContentText("Voice")
				.setSmallIcon(R.drawable.ic_upload);
				
				builder.setProgress(0,0,true);
				
				NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
				
				manager.notify(1,builder.build());
			}
		};
		
		_voice_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				try {
					push_key = chat.push().getKey();
					map_pesan = new HashMap<>();
					map_pesan.put("lasted", "Voice");
					map_pesan.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
					map_pesan.put("push key", push_key);
					map_pesan.put("voice", _downloadUrl);
					map_pesan.put("voice_during", voice_duration);
					map_pesan.put("path", outputFile);
					chat.child(push_key).updateChildren(map_pesan);
					chat_2.child(push_key).updateChildren(map_pesan);
					map_pesan.put("uid2", uid2);
					listChatU1.child(uid2).updateChildren(map_pesan);
					listChatU2.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(map_pesan);
					tx_message.setText("");
					im_send.setEnabled(true);
					_Shadow(2, 60, "#FFFFFF", linear_message);
					if (replyMode) {
						replyMode = false;
						linear_reply.setVisibility(View.GONE);
					}
					if (click) {
						click = false;
						linear_attach.setVisibility(View.GONE);
					}
					_setUserStatus("online");
					NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); notificationManager.cancel(1);
				}catch(Exception e){
					SketchwareUtil.showMessage(getApplicationContext(), e.toString());
				}
			}
		};
		
		_voice_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); notificationManager.cancel(1);
				SketchwareUtil.showMessage(getApplicationContext(), "Downloaded.");
			}
		};
		
		_voice_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_voice_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_video_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_video_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_video_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				
			}
		};
		
		_video_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_video_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_video_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_file_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_file_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_file_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				
			}
		};
		
		_file_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_file_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_file_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_chatU1_child_listener = new ChildEventListener() {
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
		chatU1.addChildEventListener(_chatU1_child_listener);
		
		_listChatU1_child_listener = new ChildEventListener() {
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
		listChatU1.addChildEventListener(_listChatU1_child_listener);
		
		_chat_2_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				map_key_u2.clear();
				map_key_u2.put(_childKey, "uid2");
				share.edit().putString("key".concat(uid2), new Gson().toJson(map_key_u2)).commit();
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				map_key_u2.clear();
				map_key_u2.put(_childKey, "uid2");
				share.edit().putString("key".concat(uid2), new Gson().toJson(map_key_u2)).commit();
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				map_key_u2.clear();
				share.edit().putString("key".concat(uid2), new Gson().toJson(map_key_u2)).commit();
				_SortMap(lm_pesan, "push key", false, true);
				listview1.setAdapter(new Listview1Adapter(lm_pesan));
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
				listview1.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL); listview1.setStackFromBottom(true);
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		chat_2.addChildEventListener(_chat_2_child_listener);
		
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
		uid2 = getIntent().getStringExtra("uid");
		recordMode = false;
		_setUserStatus("Online");
		getSupportActionBar().setTitle(null);
		
		getSupportActionBar().setDisplayShowTitleEnabled(false);
		
		_toolbar.setContentInsetStartWithNavigation(0);
		
		_toolbar.setContentInsetsAbsolute(0, 0);
		
		
		
		tools.removeView(tool);
		_toolbar.addView(tool);
		com.google.android.material.appbar.AppBarLayout appBar =
		    (com.google.android.material.appbar.AppBarLayout) _toolbar.getParent();
		appBar.setElevation(3f);
		appBar.setStateListAnimator(null);
		_rippleRoundStroke(im_send, "#009688", "#FFFFFF", 500, 0, "#FFFFFF");
		_Shadow(2, 60, "#FFFFFF", linear_message);
		tx_message.setMaxHeight(230);
		linear_attach.setVisibility(View.GONE);
		linear_reply.setVisibility(View.GONE);
		_Shadow(0, 18, "#EEEEEE", linear_reply);
		_circleRipple("#E0E0E0", lin_camera);
		_circleRipple("#E0E0E0", lin_gallery);
		_circleRipple("#E0E0E0", im_attach_file);
		_circleRipple("#E0E0E0", im_send_img);
		_circleRipple("#E0E0E0", imageview12);
		_rippleEffect(linear22);
		replyMode = false;
		click = false;
		list_chat.removeEventListener(_list_chat_child_listener);
		list_chat_str = "chat list/".concat(FirebaseAuth.getInstance().getCurrentUser().getUid());
		list_chat = _firebase.getReference(list_chat_str);
		list_chat.addChildEventListener(_list_chat_child_listener);
		share.edit().putString("list_chat_", "ya").commit();
		chat.removeEventListener(_chat_child_listener);
		chat_str = "chat/".concat(FirebaseAuth.getInstance().getCurrentUser().getUid().concat("/".concat(getIntent().getStringExtra("uid"))));
		chat = _firebase.getReference(chat_str);
		chat.addChildEventListener(_chat_child_listener);
		chat_2.removeEventListener(_chat_2_child_listener);
		chat_str_2 = "chat/".concat(getIntent().getStringExtra("uid").concat("/".concat(FirebaseAuth.getInstance().getCurrentUser().getUid())));
		chat_2 = _firebase.getReference(chat_str_2);
		chat_2.addChildEventListener(_chat_2_child_listener);
		listChatU1.removeEventListener(_listChatU1_child_listener);
		listchat_u1 = "chat list/".concat(FirebaseAuth.getInstance().getCurrentUser().getUid());
		listChatU1 = _firebase.getReference(listchat_u1);
		listChatU1.addChildEventListener(_listChatU1_child_listener);
		listChatU2.removeEventListener(_listChatU2_child_listener);
		listchat_u2 = "chat list/".concat(uid2);
		listChatU2 = _firebase.getReference(listchat_u2);
		listChatU2.addChildEventListener(_listChatU2_child_listener);
		get_messages = true;
		chatU1.removeEventListener(_chatU1_child_listener);
		chat_str_ = "chat";
		chatU1 = _firebase.getReference(chat_str_);
		chatU1.addChildEventListener(_chatU1_child_listener);
	}
	
	private MediaRecorder myAudioRecorder;
	
	private void fo4o() {
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
	public void onStart() {
		super.onStart();
		overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
		_setUserStatus("online");
	}
	
	@Override
	public void onBackPressed() {
		if (replyMode) {
			replyMode = false;
			linear_reply.setVisibility(View.GONE);
			_Shadow(2, 60, "#FFFFFF", linear_message);
			_TransitionManager(linear_main, 200);
		}
		else {
			if (click) {
				click = false;
				linear_attach.setVisibility(View.GONE);
				_Shadow(2, 60, "#FFFFFF", linear_message);
			}
			else {
				_hideKeyboard();
				finish();
			}
		}
	}
	
	@Override
	public void onStop() {
		super.onStop();
		get_messages = false;
		share.edit().putString("list_chat_", "").commit();
	}
	
	@Override
	public void onResume() {
		super.onResume();
		get_messages = true;
		share.edit().putString("list_chat_", "ya").commit();
	}
	public void _Shadow (final double _sadw, final double _cru, final String _wc, final View _widgets) {
		android.graphics.drawable.GradientDrawable wd = new android.graphics.drawable.GradientDrawable();
		wd.setColor(Color.parseColor(_wc));
		wd.setCornerRadius((int)_cru);
		_widgets.setElevation((int)_sadw);
		_widgets.setBackground(wd);
	}
	
	
	public void _circleRipple (final String _color, final View _v) {
		android.content.res.ColorStateList clrb = new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{Color.parseColor(_color)});
		android.graphics.drawable.RippleDrawable ripdrb = new android.graphics.drawable.RippleDrawable(clrb , null, null);
		_v.setBackground(ripdrb);
	}
	
	
	public void _setUserStatus (final String _str) {
		if (!_str.equals(STATUS)) {
			sts = new HashMap<>();
			sts.put("chat", chat_str);
			sts.put("status", _str);
			userstatus.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(sts);
			STATUS = _str;
		}
	}
	
	
	public void _deleteChat () {
		alert.setTitle("Delete Chat?");
		alert.setMessage("Are you sure want to delete this conversation? After this action it cannot be recovered! ");
		alert.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				chatU1.child(FirebaseAuth.getInstance().getCurrentUser().getUid().concat("/".concat(uid2))).removeValue();
				list_chat.child(uid2).removeValue();
				pesan.edit().putString(uid2, "").commit();
				finish();
			}
		});
		alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				
			}
		});
		alert.create().show();
	}
	
	
	public void _deleteMessage (final double _position) {
		if (lm_pesan.get((int)_position).containsKey("push key")) {
			chat.child(lm_pesan.get((int)_position).get("push key").toString()).removeValue();
			lm_pesan.remove((int)(_position));
			listview1.setAdapter(new Listview1Adapter(lm_pesan));
			((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
			if (lm_pesan.get((int)_position).containsKey("image")) {
				_firebase_storage.getReferenceFromUrl(lm_pesan.get((int)_position).get("image").toString()).delete().addOnSuccessListener(_image_delete_success_listener).addOnFailureListener(_image_failure_listener);
			}
			else {
				if (lm_pesan.get((int)_position).containsKey("voice")) {
					_firebase_storage.getReferenceFromUrl(lm_pesan.get((int)_position).get("voice").toString()).delete().addOnSuccessListener(_voice_delete_success_listener).addOnFailureListener(_voice_failure_listener);
				}
				else {
					if (lm_pesan.get((int)_position).containsKey("video")) {
						_firebase_storage.getReferenceFromUrl(lm_pesan.get((int)_position).get("video").toString()).delete().addOnSuccessListener(_video_delete_success_listener).addOnFailureListener(_video_failure_listener);
					}
					else {
						if (lm_pesan.get((int)_position).containsKey("file")) {
							_firebase_storage.getReferenceFromUrl(lm_pesan.get((int)_position).get("file").toString()).delete().addOnSuccessListener(_file_delete_success_listener).addOnFailureListener(_file_failure_listener);
						}
					}
				}
			}
		}
	}
	
	
	public void _rippleRoundStroke (final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
		android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
		GG.setColor(Color.parseColor(_focus));
		GG.setCornerRadius((float)_round);
		GG.setStroke((int) _stroke,
		Color.parseColor("#" + _strokeclr.replace("#", "")));
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor(_pressed)}), GG, null);
		_view.setBackground(RE);
		_view.setElevation((float)3);
	}
	
	
	public void _TransitionManager (final View _view, final double _duration) {
		LinearLayout viewgroup =(LinearLayout) _view;
		
		android.transition.AutoTransition autoTransition = new android.transition.AutoTransition(); autoTransition.setDuration((long)_duration); android.transition.TransitionManager.beginDelayedTransition(viewgroup, autoTransition);
	}
	
	
	public void _get_list_chat () {
		list_chat.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot _dataSnapshot) {
				lm_list_chat = new ArrayList<>();
				try {
					GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
					for (DataSnapshot _data : _dataSnapshot.getChildren()) {
						HashMap<String, Object> _map = _data.getValue(_ind);
						lm_list_chat.add(_map);
					}
				}
				catch (Exception _e) {
					_e.printStackTrace();
				}
				listchat.edit().putString("ls", new Gson().toJson(lm_list_chat)).commit();
			}
			@Override
			public void onCancelled(DatabaseError _databaseError) {
			}
		});
	}
	
	
	public void _SortMap (final ArrayList<HashMap<String, Object>> _listMap, final String _key, final boolean _isNumber, final boolean _Ascending) {
		final Object _keyObject = _key;
		Collections.sort(_listMap, new Comparator<HashMap<String,Object>>(){
			public int compare(HashMap<String,Object> _compareMap1, HashMap<String,Object> _compareMap2){
				if (_isNumber) {
					int _count1 = Integer.valueOf(_compareMap1.get(_key).toString());
					int _count2 = Integer.valueOf(_compareMap2.get(_key).toString());
					if (_Ascending) {
						return _count1 < _count2 ? -1 : _count1 < _count2 ? 1 : 0;
					}
					else {
						return _count1 > _count2 ? -1 : _count1 > _count2 ? 1 : 0;
					}
				}
				else {
					if (_Ascending) {
						return (_compareMap1.get(_key).toString()).compareTo(_compareMap2.get(_key).toString());
					}
					else {
						return (_compareMap2.get(_key).toString()).compareTo(_compareMap1.get(_key).toString());
					}
				}
			}});
		///Use true or false blocks if sorting number of listmap
	}
	
	
	public void _SX_CornerRadius_4 (final View _view, final String _color1, final String _color2, final double _str, final double _n1, final double _n2, final double _n3, final double _n4) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		
		gd.setColor(Color.parseColor(_color1));
		
		gd.setStroke((int)_str, Color.parseColor(_color2));
		
		gd.setCornerRadii(new float[]{(int)_n1,(int)_n1,(int)_n2,(int)_n2,(int)_n3,(int)_n3,(int)_n4,(int)_n4});
		
		_view.setBackground(gd);
		
		_view.setElevation(2);
	}
	
	
	public void _setRadius (final double _position, final boolean _my_user_id, final ArrayList<HashMap<String, Object>> _listmap, final View _linear_layout) {
		if (_my_user_id) {
			if (_position == 0) {
				_SX_CornerRadius_4(_linear_layout, "#009688", "#009688", 0, 50, 50, 3, 50);
				if (_listmap.size() == 1) {
					_SX_CornerRadius_4(_linear_layout, "#009688", "#009688", 0, 50, 50, 50, 50);
				}
				else {
					if (!_listmap.get((int)_position).get("uid").toString().equals(_listmap.get((int)_position + 1).get("uid").toString())) {
						_SX_CornerRadius_4(_linear_layout, "#009688", "#009688", 0, 50, 50, 50, 50);
					}
				}
			}
			else {
				if (!_listmap.get((int)_position).get("uid").toString().equals(_listmap.get((int)_position - 1).get("uid").toString())) {
					_SX_CornerRadius_4(_linear_layout, "#009688", "#009688", 0, 50, 50, 3, 50);
					if (_position == (_listmap.size() - 1)) {
						_SX_CornerRadius_4(_linear_layout, "#009688", "#009688", 0, 50, 50, 50, 50);
					}
					else {
						if (!_listmap.get((int)_position).get("uid").toString().equals(_listmap.get((int)_position + 1).get("uid").toString())) {
							_SX_CornerRadius_4(_linear_layout, "#009688", "#009688", 0, 50, 50, 50, 50);
						}
					}
				}
				else {
					if (_position == (_listmap.size() - 1)) {
						if (_listmap.get((int)_position).get("uid").toString().equals(_listmap.get((int)_position - 1).get("uid").toString())) {
							_SX_CornerRadius_4(_linear_layout, "#009688", "#009688", 0, 50, 3, 50, 50);
						}
						else {
							_SX_CornerRadius_4(_linear_layout, "#009688", "#009688", 0, 50, 50, 50, 50);
						}
					}
					else {
						if (_listmap.get((int)_position).get("uid").toString().equals(_listmap.get((int)_position - 1).get("uid").toString()) && _listmap.get((int)_position).get("uid").toString().equals(_listmap.get((int)_position + 1).get("uid").toString())) {
							_SX_CornerRadius_4(_linear_layout, "#009688", "#009688", 0, 50, 3, 3, 50);
						}
						else {
							if (_listmap.get((int)_position).get("uid").toString().equals(_listmap.get((int)_position + 1).get("uid").toString())) {
								_SX_CornerRadius_4(_linear_layout, "#009688", "#009688", 0, 50, 50, 3, 50);
							}
							else {
								_SX_CornerRadius_4(_linear_layout, "#009688", "#009688", 0, 50, 3, 50, 50);
							}
						}
					}
				}
			}
		}
		else {
			if (_position == 0) {
				_SX_CornerRadius_4(_linear_layout, "#F5F5F5", "#F5F5F5", 0, 50, 50, 50, 3);
				if (_listmap.size() == 1) {
					_SX_CornerRadius_4(_linear_layout, "#F5F5F5", "#F5F5F5", 0, 50, 50, 50, 50);
				}
				else {
					if (!_listmap.get((int)_position).get("uid").toString().equals(_listmap.get((int)_position + 1).get("uid").toString())) {
						_SX_CornerRadius_4(_linear_layout, "#F5F5F5", "#F5F5F5", 0, 50, 50, 50, 50);
					}
				}
			}
			else {
				if (!_listmap.get((int)_position).get("uid").toString().equals(_listmap.get((int)_position - 1).get("uid").toString())) {
					_SX_CornerRadius_4(_linear_layout, "#F5F5F5", "#F5F5F5", 0, 50, 50, 50, 3);
				}
				else {
					if (_position == (_listmap.size() - 1)) {
						if (_listmap.get((int)_position).get("uid").toString().equals(_listmap.get((int)_position - 1).get("uid").toString())) {
							_SX_CornerRadius_4(_linear_layout, "#F5F5F5", "#F5F5F5", 0, 3, 50, 50, 50);
						}
						else {
							_SX_CornerRadius_4(_linear_layout, "#F5F5F5", "#F5F5F5", 0, 50, 50, 50, 50);
						}
					}
					else {
						if (_listmap.get((int)_position).get("uid").toString().equals(_listmap.get((int)_position - 1).get("uid").toString()) && _listmap.get((int)_position).get("uid").toString().equals(_listmap.get((int)_position + 1).get("uid").toString())) {
							_SX_CornerRadius_4(_linear_layout, "#F5F5F5", "#F5F5F5", 0, 3, 50, 50, 3);
						}
						else {
							if (_listmap.get((int)_position).get("uid").toString().equals(_listmap.get((int)_position + 1).get("uid").toString())) {
								_SX_CornerRadius_4(_linear_layout, "#F5F5F5", "#F5F5F5", 0, 50, 50, 50, 3);
							}
							else {
								_SX_CornerRadius_4(_linear_layout, "#F5F5F5", "#F5F5F5", 0, 3, 50, 50, 50);
							}
						}
					}
				}
			}
		}
	}
	
	
	public void _replyAt (final double _position) {
		_Shadow(2, 40, "#FFFFFF", linear_message);
		linear_reply.setVisibility(View.VISIBLE);
		replyMode = true;
		ReplyPosition = _position;
		if (lm_pesan.get((int)_position).get("uid").toString().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
			name_reply_out.setText("You");
			reply_uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
		}
		else {
			name_reply_out.setText(username.getText().toString());
			reply_uid = lm_pesan.get((int)_position).get("uid").toString();
		}
		if (lm_pesan.get((int)_position).containsKey("pesan")) {
			text_reply_out.setText(lm_pesan.get((int)_position).get("pesan").toString());
		}
		else {
			if (lm_pesan.get((int)_position).containsKey("image")) {
				text_reply_out.setText("Image📷");
			}
			else {
				if (lm_pesan.get((int)_position).containsKey("voice")) {
					text_reply_out.setText("voice message 🔊");
				}
				else {
					if (lm_pesan.get((int)_position).containsKey("video")) {
						text_reply_out.setText("Video 📽");
					}
					else {
						if (lm_pesan.get((int)_position).containsKey("file")) {
							text_reply_out.setText("File 📃");
						}
					}
				}
			}
		}
	}
	
	
	public void _smoothScroll (final double _position) {
		listview1.smoothScrollToPosition((int)(_position));
	}
	
	
	public void _hideKeyboard () {
		new Thread(new Runnable() {
			@Override public void run() {
				try {
					
					android.view.View view = ChatActivity.this.getCurrentFocus();   android.view.inputmethod.InputMethodManager imm = (android.view.inputmethod.InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE); imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
					
				} catch(Exception _e){}
			}
		}).start(); // Start thread
	}
	
	
	public void _removeScollBar (final View _view) {
		_view.setVerticalScrollBarEnabled(false); _view.setHorizontalScrollBarEnabled(false);
	}
	
	
	public void _recordVoice () {
		cal = Calendar.getInstance();
		outputFile = FileUtil.getExternalStorageDir().concat("/zen/audios/".concat(String.valueOf((long)(cal.getTimeInMillis()))));
		myAudioRecorder = new MediaRecorder();
		
		myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		
		myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
		
		myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
		
		myAudioRecorder.setOutputFile(outputFile);
		final com.google.android.material.bottomsheet.BottomSheetDialog
		 pro_dialog = new com.google.android.material.bottomsheet.BottomSheetDialog
		(ChatActivity.this);
		
		LayoutInflater inflater = getLayoutInflater();
		
		View convertView = (View) inflater.inflate(R.layout.recording, null);
		
		pro_dialog.setContentView(convertView);
		
		pro_dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { 		@Override 		public void onDismiss(DialogInterface dialogInterface) { 			
				
				try {
					myAudioRecorder.stop();
					myAudioRecorder.release();
					myAudioRecorder = null;
				} catch(Exception e) {}
				
				 	} });
		
		/*

View touchOutsideView = pro_dialog.getWindow().getDecorView().findViewById(com.google.android.material.R
.id.touch_outside);

touchOutsideView.setOnClickListener(null);

View bottomSheetView = pro_dialog.getWindow().getDecorView().findViewById(com.google.android.material.R
.id.design_bottom_sheet);

com.google.android.material.bottomsheet.BottomSheetBehavior
.from(bottomSheetView).setHideable(false);

*/
		final ImageView l_send = (ImageView)convertView.findViewById(R.id.l_send);
		final ImageView l_stop = (ImageView)convertView.findViewById(R.id.l_stop);
		final TextView tx_duration = (TextView)convertView.findViewById(R.id.tx_duration);
		l_send.setColorFilter(0xFF000000, PorterDuff.Mode.MULTIPLY);
		_Shadow(0, 100, "#ECEFF1", l_send);
		_Shadow(0, 100, "#ECEFF1", l_stop);
		try {
			
			myAudioRecorder.prepare();
			myAudioRecorder.start();
			
		} catch (Exception e) {
		}
		time_passed = 0;
		try {
			timer.cancel();
		} catch(Exception e) {}
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						time_passed++;
						tx_duration.setText(String.valueOf((long)(time_passed / 60)).concat(":".concat(String.valueOf((long)(time_passed % 60)))));
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(timer, (int)(0), (int)(1000));
		l_send.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View _view) {
				try {
					myAudioRecorder.stop();
					myAudioRecorder.release();
					myAudioRecorder = null;
				} catch(Exception e) {}
				SketchwareUtil.showMessage(getApplicationContext(), "sending...");
				voice_duration = tx_duration.getText().toString();
				voice.child(Uri.parse(outputFile).getLastPathSegment()).putFile(Uri.fromFile(new File(outputFile))).addOnFailureListener(_voice_failure_listener).addOnProgressListener(_voice_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
					@Override
					public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
						return voice.child(Uri.parse(outputFile).getLastPathSegment()).getDownloadUrl();
					}}).addOnCompleteListener(_voice_upload_success_listener);
				pro_dialog.dismiss();
			}
				});
		l_stop.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View _view) {
				try {
					myAudioRecorder.stop();
					myAudioRecorder.release();
					myAudioRecorder = null;
				} catch(Exception e) {}
				pro_dialog.dismiss();
			}
				});
		pro_dialog.show();
	}
	
	
	public void _playVoice (final double _position, final ImageView _img, final SeekBar _seekbar, final ArrayList<HashMap<String, Object>> _listmap) {
		ddd = _listmap.get((int)_position).get("path").toString();
		mediaPlayer = new MediaPlayer();
		try {
			mediaPlayer.setDataSource(ddd);
			mediaPlayer.prepare();
			mediaPlayer.start();
			_seekbar.setMax((int)mediaPlayer.getDuration());
			_img.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {
					if (mediaPlayer.isPlaying()) {
						mediaPlayer.pause();
					}
					else {
						mediaPlayer.start();
					}
				}});
			try {
				tm4.cancel();
			} catch(Exception e) {}
			try {
				tatta.cancel();
			} catch(Exception e) {}
			tatta = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							_seekbar.setProgress((int)mediaPlayer.getCurrentPosition());
							if (mediaPlayer.isPlaying()) {
								_img.setImageResource(R.drawable.ic_pause_white);
							}
							else {
								_img.setImageResource(R.drawable.ic_play_arrow_white);
							}
						}
					});
				}
			};
			_timer.scheduleAtFixedRate(tatta, (int)(0), (int)(750));
		} catch(Exception e) {}
		_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
						@Override
						public void onProgressChanged (SeekBar _param1, int _param2, boolean _param3) {
								final int _progressValue = _param2;
								
						}
						
						@Override
						public void onStartTrackingTouch(SeekBar _param1) {
								
						}
						
						@Override
						public void onStopTrackingTouch(SeekBar _param2) {
								
				try {
					if (!mediaPlayer.isPlaying()) {
						mediaPlayer.start();
					}
					mediaPlayer.seekTo((int)(_seekbar.getProgress()));
				} catch(Exception e) {}
			}
				});
		_img.setImageResource(R.drawable.ic_pause_white);
		mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
			    public void onCompletion(MediaPlayer mp) {
				_img.setImageResource(R.drawable.ic_play_arrow_white);
			}
		});
	}
	
	
	public void _RippleEffects (final String _color, final View _view) {
		android.content.res.ColorStateList clr = new android.content.res.ColorStateList(new int[][]{new int[]{}},new int[]{Color.parseColor(_color)});
		android.graphics.drawable.RippleDrawable ripdr = new android.graphics.drawable.RippleDrawable(clr, null, null);
		_view.setBackground(ripdr);
	}
	
	
	public void _rippleEffect (final View _view) {
		_view.setBackground(CircleDrawables.getSelectableDrawableFor(Color.parseColor("#b0b0b0")));
		
		_view.setClickable(true);
		
		
	}
	
	public static class Drawables {
		    public static android.graphics.drawable.Drawable getSelectableDrawableFor(int color) {
			        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
				            android.graphics.drawable.StateListDrawable stateListDrawable = new android.graphics.drawable.StateListDrawable();
				            stateListDrawable.addState(
				                new int[]{android.R.attr.state_pressed},
				                new android.graphics.drawable.ColorDrawable(Color.parseColor("#ffffff"))
				            );
				            stateListDrawable.addState(
				                new int[]{android.R.attr.state_focused},
				                new android.graphics.drawable.ColorDrawable(Color.parseColor("#00ffffff"))
				            );
				            stateListDrawable.addState(
				                new int[]{},
				                new android.graphics.drawable.ColorDrawable(Color.parseColor("#00ffffff"))
				            );
				            return stateListDrawable;
				        } else {
				            android.content.res.ColorStateList pressedColor = android.content.res.ColorStateList.valueOf(color);
				            android.graphics.drawable.ColorDrawable defaultColor = new android.graphics.drawable.ColorDrawable(Color.parseColor("#00ffffff"));
				            
				android.graphics.drawable.Drawable rippleColor = getRippleColor(color);
				            return new android.graphics.drawable.RippleDrawable(
				                pressedColor,
				                defaultColor,
				                rippleColor
				            );
				        }
			    }
		
		    private static android.graphics.drawable.Drawable getRippleColor(int color) {
			        float[] outerRadii = new float[8];
			        Arrays.fill(outerRadii, 0);
			        android.graphics.drawable.shapes.RoundRectShape r = new android.graphics.drawable.shapes.RoundRectShape(outerRadii, null, null);
			        
			android.graphics.drawable.ShapeDrawable shapeDrawable = new 
			android.graphics.drawable.ShapeDrawable(r);
			        shapeDrawable.getPaint().setColor(color);
			        return shapeDrawable;
			    }
		 
		    private static int lightenOrDarken(int color, double fraction) {
			        if (canLighten(color, fraction)) {
				            return lighten(color, fraction);
				        } else {
				            return darken(color, fraction);
				        }
			    }
		 
		    private static int lighten(int color, double fraction) {
			        int red = Color.red(color);
			        int green = Color.green(color);
			        int blue = Color.blue(color);
			        red = lightenColor(red, fraction);
			        green = lightenColor(green, fraction);
			        blue = lightenColor(blue, fraction);
			        int alpha = Color.alpha(color);
			        return Color.argb(alpha, red, green, blue);
			    }
		 
		    private static int darken(int color, double fraction) {
			        int red = Color.red(color);
			        int green = Color.green(color);
			        int blue = Color.blue(color);
			        red = darkenColor(red, fraction);
			        green = darkenColor(green, fraction);
			        blue = darkenColor(blue, fraction);
			        int alpha = Color.alpha(color);
			 
			        return Color.argb(alpha, red, green, blue);
			    }
		 
		    private static boolean canLighten(int color, double fraction) {
			        int red = Color.red(color);
			        int green = Color.green(color);
			        int blue = Color.blue(color);
			        return canLightenComponent(red, fraction)
			            && canLightenComponent(green, fraction)
			            && canLightenComponent(blue, fraction);
			    }
		 
		    private static boolean canLightenComponent(int colorComponent, double fraction) {
			        int red = Color.red(colorComponent);
			        int green = Color.green(colorComponent);
			        int blue = Color.blue(colorComponent);
			        return red + (red * fraction) < 255
			            && green + (green * fraction) < 255
			            && blue + (blue * fraction) < 255;
			    }
		 
		    private static int darkenColor(int color, double fraction) {
			        return (int) Math.max(color - (color * fraction), 0);
			    }
		 
		    private static int lightenColor(int color, double fraction) {
			        return (int) Math.min(color + (color * fraction), 255);
			    }
	}
	public static class CircleDrawables {
		    public static android.graphics.drawable.Drawable getSelectableDrawableFor(int color) {
			        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
				            android.graphics.drawable.StateListDrawable stateListDrawable = new android.graphics.drawable.StateListDrawable();
				            stateListDrawable.addState(
				                new int[]{android.R.attr.state_pressed},
				                new android.graphics.drawable.ColorDrawable(Color.parseColor("#ffffff"))
				            );
				            stateListDrawable.addState(
				                new int[]{android.R.attr.state_focused},
				                new android.graphics.drawable.ColorDrawable(Color.parseColor("#00ffffff"))
				            );
				            stateListDrawable.addState(
				                new int[]{},
				                new android.graphics.drawable.ColorDrawable(Color.parseColor("#00ffffff"))
				            );
				            return stateListDrawable;
				        } else {
				            android.content.res.ColorStateList pressedColor = android.content.res.ColorStateList.valueOf(color);
				            android.graphics.drawable.ColorDrawable defaultColor = new android.graphics.drawable.ColorDrawable(Color.parseColor("#00ffffff"));
				            
				android.graphics.drawable.Drawable rippleColor = getRippleColor(color);
				            return new android.graphics.drawable.RippleDrawable(
				                pressedColor,
				                defaultColor,
				                rippleColor
				            );
				        }
			    }
		
		    private static android.graphics.drawable.Drawable getRippleColor(int color) {
			        float[] outerRadii = new float[180];
			/*YOU CAN CHANGE OUTERRADII TO CHANGE THE ROUNDNESS OF EFFECT*/
			        Arrays.fill(outerRadii, 20);
			        android.graphics.drawable.shapes.RoundRectShape r = new android.graphics.drawable.shapes.RoundRectShape(outerRadii, null, null);
			        
			android.graphics.drawable.ShapeDrawable shapeDrawable = new 
			android.graphics.drawable.ShapeDrawable(r);
			        shapeDrawable.getPaint().setColor(color);
			        return shapeDrawable;
			    }
		 
		    private static int lightenOrDarken(int color, double fraction) {
			        if (canLighten(color, fraction)) {
				            return lighten(color, fraction);
				        } else {
				            return darken(color, fraction);
				        }
			    }
		 
		    private static int lighten(int color, double fraction) {
			        int red = Color.red(color);
			        int green = Color.green(color);
			        int blue = Color.blue(color);
			        red = lightenColor(red, fraction);
			        green = lightenColor(green, fraction);
			        blue = lightenColor(blue, fraction);
			        int alpha = Color.alpha(color);
			        return Color.argb(alpha, red, green, blue);
			    }
		 
		    private static int darken(int color, double fraction) {
			        int red = Color.red(color);
			        int green = Color.green(color);
			        int blue = Color.blue(color);
			        red = darkenColor(red, fraction);
			        green = darkenColor(green, fraction);
			        blue = darkenColor(blue, fraction);
			        int alpha = Color.alpha(color);
			 
			        return Color.argb(alpha, red, green, blue);
			    }
		 
		    private static boolean canLighten(int color, double fraction) {
			        int red = Color.red(color);
			        int green = Color.green(color);
			        int blue = Color.blue(color);
			        return canLightenComponent(red, fraction)
			            && canLightenComponent(green, fraction)
			            && canLightenComponent(blue, fraction);
			    }
		 
		    private static boolean canLightenComponent(int colorComponent, double fraction) {
			        int red = Color.red(colorComponent);
			        int green = Color.green(colorComponent);
			        int blue = Color.blue(colorComponent);
			        return red + (red * fraction) < 255
			            && green + (green * fraction) < 255
			            && blue + (blue * fraction) < 255;
			    }
		 
		    private static int darkenColor(int color, double fraction) {
			        return (int) Math.max(color - (color * fraction), 0);
			    }
		 
		    private static int lightenColor(int color, double fraction) {
			        return (int) Math.min(color + (color * fraction), 255);
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
				_view = _inflater.inflate(R.layout.chat_list, null);
			}
			
			final LinearLayout linear_main = (LinearLayout) _view.findViewById(R.id.linear_main);
			final LinearLayout linear_item = (LinearLayout) _view.findViewById(R.id.linear_item);
			final LinearLayout linear_message = (LinearLayout) _view.findViewById(R.id.linear_message);
			final LinearLayout l_voice = (LinearLayout) _view.findViewById(R.id.l_voice);
			final LinearLayout linear_file = (LinearLayout) _view.findViewById(R.id.linear_file);
			final ImageView thumbs = (ImageView) _view.findViewById(R.id.thumbs);
			final ImageView imageview1 = (ImageView) _view.findViewById(R.id.imageview1);
			final LinearLayout lin_reply = (LinearLayout) _view.findViewById(R.id.lin_reply);
			final TextView tx_message = (TextView) _view.findViewById(R.id.tx_message);
			final TextView tx_replyer = (TextView) _view.findViewById(R.id.tx_replyer);
			final TextView tx_reply_msg = (TextView) _view.findViewById(R.id.tx_reply_msg);
			final ImageView im_play = (ImageView) _view.findViewById(R.id.im_play);
			final SeekBar seekbar1 = (SeekBar) _view.findViewById(R.id.seekbar1);
			final TextView tx_voice_name = (TextView) _view.findViewById(R.id.tx_voice_name);
			final ImageView im_file = (ImageView) _view.findViewById(R.id.im_file);
			final TextView tx_file_name = (TextView) _view.findViewById(R.id.tx_file_name);
			
			try {
				_Shadow(5, 10, "#FFFFFF", imageview1);
				_Shadow(5, 10, "#FFFFFF", thumbs);
				_Shadow(2, 10, "#FFFFFF", linear_file);
				if (_data.get((int)_position).get("uid").toString().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					linear_main.setGravity(Gravity.CENTER_VERTICAL|Gravity.RIGHT);
					linear_item.setGravity(Gravity.CENTER_VERTICAL|Gravity.RIGHT);
					tx_message.setTextColor(0xFFFFFFFF);
					_setRadius(_position, true, _data, linear_message);
					_Shadow(0, 15, "#26A69A", lin_reply);
					tx_replyer.setTextColor(0xFFFFFFFF);
					tx_reply_msg.setTextColor(0xFFFFFFFF);
					_setRadius(_position, true, _data, l_voice);
					tx_voice_name.setTextColor(0xFFFFFFFF);
					im_play.setColorFilter(0xFFFFFFFF, PorterDuff.Mode.MULTIPLY);
					seekbar1.getProgressDrawable().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
					seekbar1.getThumb().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
					tx_message.setAutoLinkMask(android.text.util.Linkify.ALL);
					    tx_message.setLinkTextColor(Color.parseColor("#FFFFFF"));
					
					tx_message.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
				}
				else {
					linear_main.setGravity(Gravity.CENTER_VERTICAL|Gravity.LEFT);
					linear_item.setGravity(Gravity.CENTER_VERTICAL|Gravity.LEFT);
					tx_message.setTextColor(0xFF000000);
					_setRadius(_position, false, _data, linear_message);
					_Shadow(0, 15, "#EEEEEE", lin_reply);
					tx_replyer.setTextColor(0xFF000000);
					tx_reply_msg.setTextColor(0xFF000000);
					_setRadius(_position, false, _data, l_voice);
					tx_voice_name.setTextColor(0xFF000000);
					im_play.setColorFilter(0xFF607D8B, PorterDuff.Mode.MULTIPLY);
					seekbar1.getProgressDrawable().setColorFilter(Color.parseColor("#008DCD"), PorterDuff.Mode.SRC_IN);
					seekbar1.getThumb().setColorFilter(Color.parseColor("#008DCD"), PorterDuff.Mode.SRC_IN);
					tx_message.setAutoLinkMask(android.text.util.Linkify.ALL);
					    tx_message.setLinkTextColor(Color.parseColor("#008DCD"));
					
					tx_message.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
				}
				if (_data.get((int)_position).containsKey("pesan")) {
					linear_message.setVisibility(View.VISIBLE);
					tx_message.setText(_data.get((int)_position).get("pesan").toString());
				}
				else {
					linear_message.setVisibility(View.GONE);
				}
				if (_data.get((int)_position).containsKey("image")) {
					imageview1.setVisibility(View.VISIBLE);
					Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("image").toString())).into(imageview1);
					imageview1.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View _view) {
							
						}
					});
				}
				else {
					imageview1.setVisibility(View.GONE);
				}
				if (_data.get((int)_position).containsKey("reply")) {
					tx_reply_msg.setText(_data.get((int)_position).get("reply_message").toString());
					lin_reply.setVisibility(View.VISIBLE);
					lin_reply.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View _view) {
							_smoothScroll(Double.parseDouble(_data.get((int)_position).get("reply_position").toString()));
						}
					});
					if (_data.get((int)_position).get("reply_uid").toString().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
						tx_replyer.setText("You");
					}
					else {
						tx_replyer.setText(username.getText().toString());
					}
				}
				else {
					lin_reply.setVisibility(View.GONE);
				}
				if (_data.get((int)_position).containsKey("voice")) {
					l_voice.setVisibility(View.VISIBLE);
					tx_voice_name.setText(_data.get((int)_position).get("voice_during").toString());
					im_play.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View _view) {
							if (_data.get((int)_position).containsKey("path")) {
								if (FileUtil.isExistFile(_data.get((int)_position).get("path").toString())) {
									_playVoice(_position, im_play, seekbar1, _data);
								}
								else {
									_firebase_storage.getReferenceFromUrl(_data.get((int)_position).get("voice").toString()).getFile(new File(_data.get((int)_position).get("path").toString())).addOnSuccessListener(_voice_download_success_listener).addOnFailureListener(_voice_failure_listener).addOnProgressListener(_voice_download_progress_listener);
								}
							}
						}
					});
				}
				else {
					l_voice.setVisibility(View.GONE);
				}
				if (_data.get((int)_position).containsKey("video")) {
					if (_data.get((int)_position).containsKey("thumbnail")) {
						byte[] imageBytes = android.util.Base64.decode(
						lm_pesan.get(_position).get("thumbnail").toString(), android.util.Base64.DEFAULT);
						
						Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
						
						thumbs.setImageBitmap(decodedImage);
						thumbs.setVisibility(View.VISIBLE);
						thumbs.setOnClickListener(new View.OnClickListener() {
							@Override
							public void onClick(View _view) {
								
							}
						});
					}
					else {
						thumbs.setVisibility(View.GONE);
					}
				}
				else {
					thumbs.setVisibility(View.GONE);
				}
				if (_data.get((int)_position).containsKey("file")) {
					linear_file.setVisibility(View.VISIBLE);
					tx_file_name.setText(_data.get((int)_position).get("filename").toString());
				}
				else {
					linear_file.setVisibility(View.GONE);
				}
			}catch(Exception e){
				SketchwareUtil.showMessage(getApplicationContext(), e.toString());
			}
			
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