package study_test;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class interceptor_test extends AbstractInterceptor {
	private String test1;

@Override
public String intercept(ActionInvocation arg0) throws Exception {
	// TODO Auto-generated method stub
	System.out.println("study_test.interceptor_test:test global interceptor");
	  String result="";
	  if(test1!=""){
		  result="login";
	  }
	  return arg0.invoke();
}
}
