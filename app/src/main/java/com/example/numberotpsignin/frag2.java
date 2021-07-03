package com.example.numberotpsignin;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import org.jetbrains.annotations.NotNull;

import java.sql.Array;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

public class frag2 extends Fragment {

    private String no;
    private Button bt, resend_btn;
    private EditText ed1,ed2,ed3,ed4,ed5,ed6;
    private PhoneAuthProvider.ForceResendingToken mResendToken;
    private String[] mVerificationId = {""};


    frag2(String no1) {
        no = no1;
        Log.d("phone no", no);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bt = (Button) view.findViewById(R.id.btn1);
        resend_btn = (Button) view.findViewById(R.id.btn2);
        ed1 = (EditText) view.findViewById(R.id.et1);
        ed2 = (EditText) view.findViewById(R.id.et2);
        ed3 = (EditText) view.findViewById(R.id.et3);
        ed4 = (EditText) view.findViewById(R.id.et4);
        ed5 = (EditText) view.findViewById(R.id.et5);
        ed6 = (EditText) view.findViewById(R.id.et6);
        EditText[] str={ed1,ed2,ed3,ed4,ed5,ed6};
        // for automatic field moving
        ed1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(ed1.getText().toString().length()==1)     //size as per your requirement
                {
                    ed2.requestFocus();
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        ed2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(ed2.getText().toString().length()==1)     //size as per your requirement
                {
                    ed3.requestFocus();
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        ed3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(ed3.getText().toString().length()==1)     //size as per your requirement
                {
                    ed4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        ed4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(ed4.getText().toString().length()==1)     //size as per your requirement
                {
                    ed5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        ed5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(ed5.getText().toString().length()==1)     //size as per your requirement
                {
                    ed6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });



        final PhoneAuthProvider.ForceResendingToken mResendToken = null;
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(FirebaseAuth.getInstance())
                        .setPhoneNumber("+91" + no)       // Phone number to verify
                        .setTimeout(20L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(requireActivity())                 // Activity (for callback binding)
                        .setCallbacks(getCallbacks()).build();
        PhoneAuthProvider.verifyPhoneNumber(options);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st="";
                for(int i=0;i<str.length;i++){
                    st += str[i].getText().toString();
                    System.out.println(st);
                }
               // st=ed1.getText().toString()+ed2.getText().toString()+ed3.getText().toString()+ed4.getText().toString()+ed5.getText().toString()+ed6.getText().toString();
                System.out.println(ed1.getText());
                PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(mVerificationId[0], st);
                signInWithPhoneAuthCredential(phoneAuthCredential);
            }
        });

        resend_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PhoneAuthOptions options =
                        PhoneAuthOptions.newBuilder(FirebaseAuth.getInstance())
                                .setPhoneNumber("+91" + no)       // Phone number to verify
                                .setTimeout(20L, TimeUnit.SECONDS) // Timeout and unit
                                .setActivity(requireActivity())                 // Activity (for callback binding)
                                .setCallbacks(getCallbacks()).setForceResendingToken(mResendToken).
                                build();
                PhoneAuthProvider.verifyPhoneNumber(options);
                view.setEnabled(false);
            }
        });


    }


    private void signInWithPhoneAuthCredential(PhoneAuthCredential phoneAuthCredential) {
        Task<AuthResult> authResultTask = FirebaseAuth.getInstance().signInWithCredential((AuthCredential) phoneAuthCredential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");

                            FirebaseUser user = task.getResult().getUser();

                            Intent intent = new Intent(requireContext(), Student.class);
                            startActivity(intent);
                            requireActivity().finish();

                            // Update UI
                        } else {
                            // Sign in failed, display a message and update the UI
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                                Toast.makeText(requireContext(), "Code Entered is not Correct", Toast.LENGTH_SHORT).show();

                            }
                        }
                    }
                });

    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks getCallbacks() {

        PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onCodeAutoRetrievalTimeOut(@NonNull @NotNull String s) {
                super.onCodeAutoRetrievalTimeOut(s);
                resend_btn.setEnabled(true);

            }

            @Override
            public void onCodeSent(@NonNull @NotNull String s, @NonNull @NotNull PhoneAuthProvider.ForceResendingToken

                    forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                Log.d(TAG, "onCodeSent:" + s);

                // Save verification ID and resending token so we can use them later
                mVerificationId[0] = s;
                mResendToken = forceResendingToken;
            }

            @Override
            public void onVerificationCompleted(@NonNull @NotNull PhoneAuthCredential phoneAuthCredential) {
                Log.d(TAG, "onVerificationCompleted:" + phoneAuthCredential);

                signInWithPhoneAuthCredential(phoneAuthCredential);

            }

            @Override
            public void onVerificationFailed(@NonNull @NotNull FirebaseException e) {
                Log.w(TAG, "onVerificationFailed", e);

                if (e instanceof FirebaseAuthInvalidCredentialsException) {
                    Toast.makeText(getContext(), "INVALID REQUEST", Toast.LENGTH_SHORT).show();
                } else if (e instanceof FirebaseTooManyRequestsException) {
                    // The SMS quota for the project has been exceeded
                }

            }
        };

        return onVerificationStateChangedCallbacks;
    }

}