package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18845")
public class BenchmarkTest18845 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = doSomething(param);
		
		double rand = new java.util.Random().nextDouble();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextDouble() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a98899 = param; //assign
		StringBuilder b98899 = new StringBuilder(a98899);  // stick in stringbuilder
		b98899.append(" SafeStuff"); // append some safe content
		b98899.replace(b98899.length()-"Chars".length(),b98899.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map98899 = new java.util.HashMap<String,Object>();
		map98899.put("key98899", b98899.toString()); // put in a collection
		String c98899 = (String)map98899.get("key98899"); // get it back out
		String d98899 = c98899.substring(0,c98899.length()-1); // extract most of it
		String e98899 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d98899.getBytes() ) )); // B64 encode and decode it
		String f98899 = e98899.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g98899 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g98899); // reflection
	
		return bar;	
	}
}